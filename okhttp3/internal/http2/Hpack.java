package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
/* loaded from: classes.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    /* loaded from: classes.dex */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(Source source, int i6) {
            this(source, i6, 0, 4, null);
            l.d(source, "source");
        }

        private final void adjustDynamicTableByteCount() {
            int i6 = this.maxDynamicTableByteCount;
            int i7 = this.dynamicTableByteCount;
            if (i6 < i7) {
                if (i6 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i7 - i6);
                }
            }
        }

        private final void clearDynamicTable() {
            i.m(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i6) {
            return this.nextHeaderIndex + 1 + i6;
        }

        private final int evictToRecoverBytes(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i7 = this.nextHeaderIndex;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    l.b(header);
                    int i9 = header.hpackSize;
                    i6 -= i9;
                    this.dynamicTableByteCount -= i9;
                    this.headerCount--;
                    i8++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i7 + 1, headerArr, i7 + 1 + i8, this.headerCount);
                this.nextHeaderIndex += i8;
            }
            return i8;
        }

        private final ByteString getName(int i6) {
            Header header;
            if (!isStaticHeader(i6)) {
                int dynamicTableIndex = dynamicTableIndex(i6 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
                if (dynamicTableIndex >= 0) {
                    Header[] headerArr = this.dynamicTable;
                    if (dynamicTableIndex < headerArr.length) {
                        header = headerArr[dynamicTableIndex];
                        l.b(header);
                    }
                }
                throw new IOException(l.i("Header index too large ", Integer.valueOf(i6 + 1)));
            }
            header = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i6];
            return header.name;
        }

        private final void insertIntoDynamicTable(int i6, Header header) {
            this.headerList.add(header);
            int i7 = header.hpackSize;
            if (i6 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i6)];
                l.b(header2);
                i7 -= header2.hpackSize;
            }
            int i8 = this.maxDynamicTableByteCount;
            if (i7 > i8) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i7) - i8);
            if (i6 == -1) {
                int i9 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i9 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i10 = this.nextHeaderIndex;
                this.nextHeaderIndex = i10 - 1;
                this.dynamicTable[i10] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i6 + dynamicTableIndex(i6) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i7;
        }

        private final boolean isStaticHeader(int i6) {
            return i6 >= 0 && i6 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i6) {
            if (isStaticHeader(i6)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i6]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i6 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    l.b(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException(l.i("Header index too large ", Integer.valueOf(i6 + 1)));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i6) {
            insertIntoDynamicTable(-1, new Header(getName(i6), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i6) {
            this.headerList.add(new Header(getName(i6), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> O;
            O = v.O(this.headerList);
            this.headerList.clear();
            return O;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() {
            int readByte = readByte();
            boolean z5 = (readByte & 128) == 128;
            long readInt = readInt(readByte, 127);
            if (z5) {
                Buffer buffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, readInt, buffer);
                return buffer.readByteString();
            }
            return this.source.readByteString(readInt);
        }

        public final void readHeaders() {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException(l.i("Invalid dynamic table size update ", Integer.valueOf(this.maxDynamicTableByteCount)));
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i6, int i7) {
            int i8 = i6 & i7;
            if (i8 < i7) {
                return i8;
            }
            int i9 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i7 + (readByte << i9);
                }
                i7 += (readByte & 127) << i9;
                i9 += 7;
            }
        }

        public Reader(Source source, int i6, int i7) {
            l.d(source, "source");
            this.headerTableSizeSetting = i6;
            this.maxDynamicTableByteCount = i7;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        public /* synthetic */ Reader(Source source, int i6, int i7, int i8, g gVar) {
            this(source, i6, (i8 & 4) != 0 ? i6 : i7);
        }
    }

    /* loaded from: classes.dex */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(int i6, Buffer buffer) {
            this(i6, false, buffer, 2, null);
            l.d(buffer, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i6 = this.maxDynamicTableByteCount;
            int i7 = this.dynamicTableByteCount;
            if (i6 < i7) {
                if (i6 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i7 - i6);
                }
            }
        }

        private final void clearDynamicTable() {
            i.m(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i7 = this.nextHeaderIndex;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    l.b(header);
                    i6 -= header.hpackSize;
                    int i9 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    l.b(header2);
                    this.dynamicTableByteCount = i9 - header2.hpackSize;
                    this.headerCount--;
                    i8++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i7 + 1, headerArr, i7 + 1 + i8, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i10 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i10 + 1, i10 + 1 + i8, (Object) null);
                this.nextHeaderIndex += i8;
            }
            return i8;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i6 = header.hpackSize;
            int i7 = this.maxDynamicTableByteCount;
            if (i6 > i7) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i6) - i7);
            int i8 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i8 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i9 = this.nextHeaderIndex;
            this.nextHeaderIndex = i9 - 1;
            this.dynamicTable[i9] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i6;
        }

        public final void resizeHeaderTable(int i6) {
            this.headerTableSizeSetting = i6;
            int min = Math.min(i6, 16384);
            int i7 = this.maxDynamicTableByteCount;
            if (i7 == min) {
                return;
            }
            if (min < i7) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString byteString) {
            int size;
            int i6;
            l.d(byteString, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(byteString, buffer);
                    byteString = buffer.readByteString();
                    size = byteString.size();
                    i6 = 128;
                    writeInt(size, 127, i6);
                    this.out.write(byteString);
                }
            }
            size = byteString.size();
            i6 = 0;
            writeInt(size, 127, i6);
            this.out.write(byteString);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void writeHeaders(List<Header> list) {
            int i6;
            int i7;
            l.d(list, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i8 = this.smallestHeaderTableSizeSetting;
                if (i8 < this.maxDynamicTableByteCount) {
                    writeInt(i8, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            int i9 = 0;
            while (i9 < size) {
                int i10 = i9 + 1;
                Header header = list.get(i9);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    i7 = num.intValue() + 1;
                    if (2 <= i7 && i7 < 8) {
                        if (l.a(hpack.getSTATIC_HEADER_TABLE()[i7 - 1].value, byteString)) {
                            i6 = i7;
                        } else if (l.a(hpack.getSTATIC_HEADER_TABLE()[i7].value, byteString)) {
                            i7++;
                            i6 = i7;
                        }
                        if (i7 == -1) {
                            int i11 = this.nextHeaderIndex + 1;
                            int length = this.dynamicTable.length;
                            while (true) {
                                if (i11 >= length) {
                                    break;
                                }
                                int i12 = i11 + 1;
                                Header header2 = this.dynamicTable[i11];
                                l.b(header2);
                                if (l.a(header2.name, asciiLowercase)) {
                                    Header header3 = this.dynamicTable[i11];
                                    l.b(header3);
                                    if (l.a(header3.value, byteString)) {
                                        i7 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i11 - this.nextHeaderIndex);
                                        break;
                                    } else if (i6 == -1) {
                                        i6 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i11 - this.nextHeaderIndex);
                                    }
                                }
                                i11 = i12;
                            }
                        }
                        if (i7 == -1) {
                            writeInt(i7, 127, 128);
                        } else {
                            if (i6 == -1) {
                                this.out.writeByte(64);
                                writeByteString(asciiLowercase);
                            } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || l.a(Header.TARGET_AUTHORITY, asciiLowercase)) {
                                writeInt(i6, 63, 64);
                            } else {
                                writeInt(i6, 15, 0);
                                writeByteString(byteString);
                            }
                            writeByteString(byteString);
                            insertIntoDynamicTable(header);
                        }
                        i9 = i10;
                    }
                    i6 = i7;
                } else {
                    i6 = -1;
                }
                i7 = -1;
                if (i7 == -1) {
                }
                if (i7 == -1) {
                }
                i9 = i10;
            }
        }

        public final void writeInt(int i6, int i7, int i8) {
            int i9;
            Buffer buffer;
            if (i6 < i7) {
                buffer = this.out;
                i9 = i6 | i8;
            } else {
                this.out.writeByte(i8 | i7);
                i9 = i6 - i7;
                while (i9 >= 128) {
                    this.out.writeByte(128 | (i9 & 127));
                    i9 >>>= 7;
                }
                buffer = this.out;
            }
            buffer.writeByte(i9);
        }

        public Writer(int i6, boolean z5, Buffer buffer) {
            l.d(buffer, "out");
            this.headerTableSizeSetting = i6;
            this.useCompression = z5;
            this.out = buffer;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i6;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        public /* synthetic */ Writer(int i6, boolean z5, Buffer buffer, int i7, g gVar) {
            this((i7 & 1) != 0 ? 4096 : i6, (i7 & 2) != 0 ? true : z5, buffer);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(Buffer buffer) {
            this(0, false, buffer, 3, null);
            l.d(buffer, "out");
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, HttpUrl.FRAGMENT_ENCODE_SET), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", HttpUrl.FRAGMENT_ENCODE_SET), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", HttpUrl.FRAGMENT_ENCODE_SET), new Header("accept-ranges", HttpUrl.FRAGMENT_ENCODE_SET), new Header("accept", HttpUrl.FRAGMENT_ENCODE_SET), new Header("access-control-allow-origin", HttpUrl.FRAGMENT_ENCODE_SET), new Header("age", HttpUrl.FRAGMENT_ENCODE_SET), new Header("allow", HttpUrl.FRAGMENT_ENCODE_SET), new Header("authorization", HttpUrl.FRAGMENT_ENCODE_SET), new Header("cache-control", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-disposition", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-encoding", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-language", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-length", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-location", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-range", HttpUrl.FRAGMENT_ENCODE_SET), new Header("content-type", HttpUrl.FRAGMENT_ENCODE_SET), new Header("cookie", HttpUrl.FRAGMENT_ENCODE_SET), new Header("date", HttpUrl.FRAGMENT_ENCODE_SET), new Header("etag", HttpUrl.FRAGMENT_ENCODE_SET), new Header("expect", HttpUrl.FRAGMENT_ENCODE_SET), new Header("expires", HttpUrl.FRAGMENT_ENCODE_SET), new Header("from", HttpUrl.FRAGMENT_ENCODE_SET), new Header("host", HttpUrl.FRAGMENT_ENCODE_SET), new Header("if-match", HttpUrl.FRAGMENT_ENCODE_SET), new Header("if-modified-since", HttpUrl.FRAGMENT_ENCODE_SET), new Header("if-none-match", HttpUrl.FRAGMENT_ENCODE_SET), new Header("if-range", HttpUrl.FRAGMENT_ENCODE_SET), new Header("if-unmodified-since", HttpUrl.FRAGMENT_ENCODE_SET), new Header("last-modified", HttpUrl.FRAGMENT_ENCODE_SET), new Header("link", HttpUrl.FRAGMENT_ENCODE_SET), new Header("location", HttpUrl.FRAGMENT_ENCODE_SET), new Header("max-forwards", HttpUrl.FRAGMENT_ENCODE_SET), new Header("proxy-authenticate", HttpUrl.FRAGMENT_ENCODE_SET), new Header("proxy-authorization", HttpUrl.FRAGMENT_ENCODE_SET), new Header("range", HttpUrl.FRAGMENT_ENCODE_SET), new Header("referer", HttpUrl.FRAGMENT_ENCODE_SET), new Header("refresh", HttpUrl.FRAGMENT_ENCODE_SET), new Header("retry-after", HttpUrl.FRAGMENT_ENCODE_SET), new Header("server", HttpUrl.FRAGMENT_ENCODE_SET), new Header("set-cookie", HttpUrl.FRAGMENT_ENCODE_SET), new Header("strict-transport-security", HttpUrl.FRAGMENT_ENCODE_SET), new Header("transfer-encoding", HttpUrl.FRAGMENT_ENCODE_SET), new Header("user-agent", HttpUrl.FRAGMENT_ENCODE_SET), new Header("vary", HttpUrl.FRAGMENT_ENCODE_SET), new Header("via", HttpUrl.FRAGMENT_ENCODE_SET), new Header("www-authenticate", HttpUrl.FRAGMENT_ENCODE_SET)};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i6].name)) {
                linkedHashMap.put(headerArr2[i6].name, Integer.valueOf(i6));
            }
            i6 = i7;
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        l.c(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString byteString) {
        l.d(byteString, "name");
        int size = byteString.size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            byte b6 = byteString.getByte(i6);
            if (65 <= b6 && b6 <= 90) {
                throw new IOException(l.i("PROTOCOL_ERROR response malformed: mixed case name: ", byteString.utf8()));
            }
            i6 = i7;
        }
        return byteString;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
