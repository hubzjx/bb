package okio.internal;

import h4.n;
import h4.q;
import i4.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.collections.v;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import kotlin.text.w;
import kotlin.text.x;
import n4.a;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
import p4.p;
/* loaded from: classes.dex */
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Map<Path, ZipEntry> e6;
        List<ZipEntry> L;
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        e6 = e0.e(n.a(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        L = v.L(list, new Comparator() { // from class: okio.internal.ZipKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                int a6;
                a6 = b.a(((ZipEntry) t5).getCanonicalPath(), ((ZipEntry) t6).getCanonicalPath());
                return a6;
            }
        });
        for (ZipEntry zipEntry : L) {
            if (e6.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = e6.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        e6.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return e6;
    }

    private static final Long dosDateTimeToEpochMillis(int i6, int i7) {
        if (i7 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i6 >> 9) & 127) + 1980, ((i6 >> 5) & 15) - 1, i6 & 31, (i7 >> 11) & 31, (i7 >> 5) & 63, (i7 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i6) {
        int a6;
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        a6 = kotlin.text.b.a(16);
        String num = Integer.toString(i6, a6);
        l.c(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    public static final ZipFileSystem openZip(Path path, FileSystem fileSystem, p4.l lVar) {
        int readIntLe;
        l.d(path, "zipPath");
        l.d(fileSystem, "fileSystem");
        l.d(lVar, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(path);
        try {
            long size = openReadOnly.size() - 22;
            if (size < 0) {
                throw new IOException("not a zip: size=" + openReadOnly.size());
            }
            long max = Math.max(size - 65536, 0L);
            while (true) {
                BufferedSource buffer = Okio.buffer(openReadOnly.source(size));
                if (buffer.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                    EocdRecord readEocdRecord = readEocdRecord(buffer);
                    String readUtf8 = buffer.readUtf8(readEocdRecord.getCommentByteCount());
                    buffer.close();
                    long j6 = size - 20;
                    if (j6 > 0) {
                        BufferedSource buffer2 = Okio.buffer(openReadOnly.source(j6));
                        if (buffer2.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                            int readIntLe2 = buffer2.readIntLe();
                            long readLongLe = buffer2.readLongLe();
                            if (buffer2.readIntLe() != 1 || readIntLe2 != 0) {
                                throw new IOException("unsupported zip: spanned");
                            }
                            BufferedSource buffer3 = Okio.buffer(openReadOnly.source(readLongLe));
                            try {
                                if (buffer3.readIntLe() != ZIP64_EOCD_RECORD_SIGNATURE) {
                                    throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(readIntLe));
                                }
                                readEocdRecord = readZip64EocdRecord(buffer3, readEocdRecord);
                                q qVar = q.f10774a;
                                a.a(buffer3, null);
                            } finally {
                            }
                        }
                        q qVar2 = q.f10774a;
                        a.a(buffer2, null);
                    }
                    ArrayList arrayList = new ArrayList();
                    BufferedSource buffer4 = Okio.buffer(openReadOnly.source(readEocdRecord.getCentralDirectoryOffset()));
                    long entryCount = readEocdRecord.getEntryCount();
                    for (long j7 = 0; j7 < entryCount; j7++) {
                        ZipEntry readEntry = readEntry(buffer4);
                        if (readEntry.getOffset() >= readEocdRecord.getCentralDirectoryOffset()) {
                            throw new IOException("bad zip: local file header offset >= central directory offset");
                        }
                        if (((Boolean) lVar.invoke(readEntry)).booleanValue()) {
                            arrayList.add(readEntry);
                        }
                    }
                    q qVar3 = q.f10774a;
                    a.a(buffer4, null);
                    ZipFileSystem zipFileSystem = new ZipFileSystem(path, fileSystem, buildIndex(arrayList), readUtf8);
                    a.a(openReadOnly, null);
                    return zipFileSystem;
                }
                buffer.close();
                size--;
                if (size < max) {
                    throw new IOException("not a zip: end of central directory signature not found");
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a.a(openReadOnly, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, p4.l lVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            lVar = ZipKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, lVar);
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) {
        int readIntLe;
        int readShortLe;
        boolean C;
        int i6;
        Long l6;
        long j6;
        boolean k6;
        l.d(bufferedSource, "<this>");
        if (bufferedSource.readIntLe() != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(4L);
        if ((bufferedSource.readShortLe() & 65535 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        int readShortLe2 = bufferedSource.readShortLe() & 65535;
        Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 65535, bufferedSource.readShortLe() & 65535);
        long readIntLe2 = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        kotlin.jvm.internal.q qVar = new kotlin.jvm.internal.q();
        qVar.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        kotlin.jvm.internal.q qVar2 = new kotlin.jvm.internal.q();
        qVar2.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int readShortLe3 = bufferedSource.readShortLe() & 65535;
        int readShortLe4 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(8L);
        kotlin.jvm.internal.q qVar3 = new kotlin.jvm.internal.q();
        qVar3.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String readUtf8 = bufferedSource.readUtf8(bufferedSource.readShortLe() & 65535);
        C = x.C(readUtf8, (char) 0, false, 2, null);
        if (C) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        if (qVar2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j6 = 8 + 0;
            i6 = readShortLe2;
            l6 = dosDateTimeToEpochMillis;
        } else {
            i6 = readShortLe2;
            l6 = dosDateTimeToEpochMillis;
            j6 = 0;
        }
        if (qVar.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j6 += 8;
        }
        if (qVar3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j6 += 8;
        }
        long j7 = j6;
        o oVar = new o();
        readExtra(bufferedSource, readShortLe3, new ZipKt$readEntry$1(oVar, j7, qVar2, bufferedSource, qVar, qVar3));
        if (j7 <= 0 || oVar.element) {
            String readUtf82 = bufferedSource.readUtf8(readShortLe4);
            Path resolve = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(readUtf8);
            k6 = w.k(readUtf8, "/", false, 2, null);
            return new ZipEntry(resolve, k6, readUtf82, readIntLe2, qVar.element, qVar2.element, i6, l6, qVar3.element);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) {
        int readShortLe = bufferedSource.readShortLe() & 65535;
        int readShortLe2 = bufferedSource.readShortLe() & 65535;
        long readShortLe3 = bufferedSource.readShortLe() & 65535;
        if (readShortLe3 == (bufferedSource.readShortLe() & 65535) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4L);
            return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & bufferedSource.readIntLe(), bufferedSource.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i6, p pVar) {
        long j6 = i6;
        while (j6 != 0) {
            if (j6 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int readShortLe = bufferedSource.readShortLe() & 65535;
            long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j7 = j6 - 4;
            if (j7 < readShortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(readShortLe2);
            long size = bufferedSource.getBuffer().size();
            pVar.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
            long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
            int i7 = (size2 > 0L ? 1 : (size2 == 0L ? 0 : -1));
            if (i7 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
            }
            if (i7 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j6 = j7 - readShortLe2;
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        l.d(bufferedSource, "<this>");
        l.d(fileMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        l.b(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        r rVar = new r();
        rVar.element = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        r rVar2 = new r();
        r rVar3 = new r();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(2L);
        int readShortLe = bufferedSource.readShortLe() & 65535;
        if ((readShortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        bufferedSource.skip(18L);
        long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int readShortLe3 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(readShortLe2);
        if (fileMetadata == null) {
            bufferedSource.skip(readShortLe3);
            return null;
        }
        readExtra(bufferedSource, readShortLe3, new ZipKt$readOrSkipLocalHeader$1(bufferedSource, rVar, rVar2, rVar3));
        return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), null, fileMetadata.getSize(), (Long) rVar3.element, (Long) rVar.element, (Long) rVar2.element, null, 128, null);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8L);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        l.d(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
