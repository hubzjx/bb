package okhttp3.dnsoverhttps;

import io.jsonwebtoken.JwtParser;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.internal.l;
import kotlin.text.x;
import okio.Buffer;
import okio.ByteString;
import okio.Utf8;
/* loaded from: classes.dex */
public final class DnsRecordCodec {
    private static final int NXDOMAIN = 3;
    private static final int SERVFAIL = 2;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;
    private static final int TYPE_PTR = 12;
    public static final DnsRecordCodec INSTANCE = new DnsRecordCodec();
    private static final Charset ASCII = StandardCharsets.US_ASCII;

    private DnsRecordCodec() {
    }

    private final void skipName(Buffer buffer) {
        byte readByte = buffer.readByte();
        if (readByte < 0) {
            buffer.skip(1L);
            return;
        }
        while (readByte > 0) {
            buffer.skip(readByte);
            readByte = buffer.readByte();
        }
    }

    public final List<InetAddress> decodeAnswers(String str, ByteString byteString) {
        l.d(str, "hostname");
        l.d(byteString, "byteString");
        ArrayList arrayList = new ArrayList();
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.readShort();
        int readShort = buffer.readShort() & 65535;
        int i6 = 0;
        if ((readShort >> 15) != 0) {
            int i7 = readShort & 15;
            if (i7 != 2) {
                if (i7 != 3) {
                    int readShort2 = buffer.readShort() & 65535;
                    int readShort3 = buffer.readShort() & 65535;
                    buffer.readShort();
                    buffer.readShort();
                    int i8 = 0;
                    while (i8 < readShort2) {
                        i8++;
                        skipName(buffer);
                        buffer.readShort();
                        buffer.readShort();
                    }
                    while (i6 < readShort3) {
                        i6++;
                        skipName(buffer);
                        int readShort4 = buffer.readShort() & 65535;
                        buffer.readShort();
                        buffer.readInt();
                        int readShort5 = buffer.readShort() & 65535;
                        if (readShort4 == 1 || readShort4 == 28) {
                            byte[] bArr = new byte[readShort5];
                            buffer.read(bArr);
                            InetAddress byAddress = InetAddress.getByAddress(bArr);
                            l.c(byAddress, "getByAddress(bytes)");
                            arrayList.add(byAddress);
                        } else {
                            buffer.skip(readShort5);
                        }
                    }
                    return arrayList;
                }
                throw new UnknownHostException(l.i(str, ": NXDOMAIN"));
            }
            throw new UnknownHostException(l.i(str, ": SERVFAIL"));
        }
        throw new IllegalArgumentException("not a response".toString());
    }

    public final ByteString encodeQuery(String str, int i6) {
        List j02;
        List<String> f6;
        boolean z5;
        l.d(str, "host");
        Buffer buffer = new Buffer();
        buffer.writeShort(0);
        buffer.writeShort(256);
        buffer.writeShort(1);
        buffer.writeShort(0);
        buffer.writeShort(0);
        buffer.writeShort(0);
        Buffer buffer2 = new Buffer();
        j02 = x.j0(str, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null);
        if (!j02.isEmpty()) {
            ListIterator listIterator = j02.listIterator(j02.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() == 0) {
                    z5 = true;
                    continue;
                } else {
                    z5 = false;
                    continue;
                }
                if (!z5) {
                    f6 = v.M(j02, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        f6 = n.f();
        for (String str2 : f6) {
            long size$default = Utf8.size$default(str2, 0, 0, 3, null);
            if (!(size$default == ((long) str2.length()))) {
                throw new IllegalArgumentException(l.i("non-ascii hostname: ", str).toString());
            }
            buffer2.writeByte((int) size$default);
            buffer2.writeUtf8(str2);
        }
        buffer2.writeByte(0);
        buffer2.copyTo(buffer, 0L, buffer2.size());
        buffer.writeShort(i6);
        buffer.writeShort(1);
        return buffer.readByteString();
    }
}
