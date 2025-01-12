package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal._ByteStringKt;
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                charset = kotlin.text.d.f11327b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i6 = 0;
            }
            if ((i8 & 2) != 0) {
                i7 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i6, i7);
        }

        /* renamed from: -deprecated_decodeBase64  reason: not valid java name */
        public final ByteString m166deprecated_decodeBase64(String str) {
            kotlin.jvm.internal.l.d(str, "string");
            return decodeBase64(str);
        }

        /* renamed from: -deprecated_decodeHex  reason: not valid java name */
        public final ByteString m167deprecated_decodeHex(String str) {
            kotlin.jvm.internal.l.d(str, "string");
            return decodeHex(str);
        }

        /* renamed from: -deprecated_encodeString  reason: not valid java name */
        public final ByteString m168deprecated_encodeString(String str, Charset charset) {
            kotlin.jvm.internal.l.d(str, "string");
            kotlin.jvm.internal.l.d(charset, "charset");
            return encodeString(str, charset);
        }

        /* renamed from: -deprecated_encodeUtf8  reason: not valid java name */
        public final ByteString m169deprecated_encodeUtf8(String str) {
            kotlin.jvm.internal.l.d(str, "string");
            return encodeUtf8(str);
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m170deprecated_of(ByteBuffer byteBuffer) {
            kotlin.jvm.internal.l.d(byteBuffer, "buffer");
            return of(byteBuffer);
        }

        /* renamed from: -deprecated_read  reason: not valid java name */
        public final ByteString m172deprecated_read(InputStream inputStream, int i6) {
            kotlin.jvm.internal.l.d(inputStream, "inputstream");
            return read(inputStream, i6);
        }

        public final ByteString decodeBase64(String str) {
            kotlin.jvm.internal.l.d(str, "<this>");
            byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            kotlin.jvm.internal.l.d(str, "<this>");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = i6 * 2;
                bArr[i6] = (byte) ((_ByteStringKt.access$decodeHexDigit(str.charAt(i7)) << 4) + _ByteStringKt.access$decodeHexDigit(str.charAt(i7 + 1)));
            }
            return new ByteString(bArr);
        }

        public final ByteString encodeString(String str, Charset charset) {
            kotlin.jvm.internal.l.d(str, "<this>");
            kotlin.jvm.internal.l.d(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.l.c(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            kotlin.jvm.internal.l.d(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(ByteBuffer byteBuffer) {
            kotlin.jvm.internal.l.d(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString read(InputStream inputStream, int i6) {
            kotlin.jvm.internal.l.d(inputStream, "<this>");
            int i7 = 0;
            if (!(i6 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i6).toString());
            }
            byte[] bArr = new byte[i6];
            while (i7 < i6) {
                int read = inputStream.read(bArr, i7, i6 - i7);
                if (read == -1) {
                    throw new EOFException();
                }
                i7 += read;
            }
            return new ByteString(bArr);
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m171deprecated_of(byte[] bArr, int i6, int i7) {
            kotlin.jvm.internal.l.d(bArr, "array");
            return of(bArr, i6, i7);
        }

        public final ByteString of(byte... bArr) {
            kotlin.jvm.internal.l.d(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            kotlin.jvm.internal.l.c(copyOf, "copyOf(this, size)");
            return new ByteString(copyOf);
        }

        public final ByteString of(byte[] bArr, int i6, int i7) {
            byte[] h6;
            kotlin.jvm.internal.l.d(bArr, "<this>");
            int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(bArr, i7);
            _UtilKt.checkOffsetAndCount(bArr.length, i6, resolveDefaultParameter);
            h6 = kotlin.collections.i.h(bArr, i6, resolveDefaultParameter + i6);
            return new ByteString(h6);
        }
    }

    public ByteString(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "data");
        this.data = bArr;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i6, byte[] bArr, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i9 & 1) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        byteString.copyInto(i6, bArr, i7, i8);
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i6, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 2) != 0) {
                i6 = 0;
            }
            return byteString.indexOf(byteString2, i6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i6, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 2) != 0) {
                i6 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(byteString2, i6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    public static final ByteString read(InputStream inputStream, int i6) {
        return Companion.read(inputStream, i6);
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i6, int i7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                i6 = 0;
            }
            if ((i8 & 2) != 0) {
                i7 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.substring(i6, i7);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m164deprecated_getByte(int i6) {
        return getByte(i6);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m165deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        kotlin.jvm.internal.l.c(asReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return _Base64Kt.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return _Base64Kt.encodeBase64(getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public void copyInto(int i6, byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l.d(bArr, "target");
        kotlin.collections.i.d(getData$okio(), bArr, i7, i6, i8 + i6);
    }

    public ByteString digest$okio(String str) {
        kotlin.jvm.internal.l.d(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, size());
        byte[] digest = messageDigest.digest();
        kotlin.jvm.internal.l.c(digest, "digestBytes");
        return new ByteString(digest);
    }

    public final boolean endsWith(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i6) {
        return internalGet$okio(i6);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    public String hex() {
        byte[] data$okio;
        char[] cArr = new char[getData$okio().length * 2];
        int i6 = 0;
        for (byte b6 : getData$okio()) {
            int i7 = i6 + 1;
            cArr[i6] = _ByteStringKt.getHEX_DIGIT_CHARS()[(b6 >> 4) & 15];
            i6 = i7 + 1;
            cArr[i7] = _ByteStringKt.getHEX_DIGIT_CHARS()[b6 & 15];
        }
        return kotlin.text.n.h(cArr);
    }

    public ByteString hmac$okio(String str, ByteString byteString) {
        kotlin.jvm.internal.l.d(str, "algorithm");
        kotlin.jvm.internal.l.d(byteString, "key");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] doFinal = mac.doFinal(this.data);
            kotlin.jvm.internal.l.c(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "key");
        return hmac$okio("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "key");
        return hmac$okio("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "key");
        return hmac$okio("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "other");
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i6) {
        return getData$okio()[i6];
    }

    public final int lastIndexOf(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "other");
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i6, ByteString byteString, int i7, int i8) {
        kotlin.jvm.internal.l.d(byteString, "other");
        return byteString.rangeEquals(i7, getData$okio(), i6, i8);
    }

    public final void setHashCode$okio(int i6) {
        this.hashCode = i6;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "prefix");
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        kotlin.jvm.internal.l.d(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        byte b6;
        for (int i6 = 0; i6 < getData$okio().length; i6++) {
            byte b7 = getData$okio()[i6];
            byte b8 = (byte) 65;
            if (b7 >= b8 && b7 <= (b6 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                kotlin.jvm.internal.l.c(copyOf, "copyOf(this, size)");
                copyOf[i6] = (byte) (b7 + 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b9 = copyOf[i7];
                    if (b9 >= b8 && b9 <= b6) {
                        copyOf[i7] = (byte) (b9 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        byte b6;
        for (int i6 = 0; i6 < getData$okio().length; i6++) {
            byte b7 = getData$okio()[i6];
            byte b8 = (byte) 97;
            if (b7 >= b8 && b7 <= (b6 = (byte) b.j.L0)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                kotlin.jvm.internal.l.c(copyOf, "copyOf(this, size)");
                copyOf[i6] = (byte) (b7 - 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b9 = copyOf[i7];
                    if (b9 >= b8 && b9 <= b6) {
                        copyOf[i7] = (byte) (b9 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        kotlin.jvm.internal.l.c(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public String toString() {
        StringBuilder sb;
        ByteString byteString;
        byte[] h6;
        String str;
        if (!(getData$okio().length == 0)) {
            int access$codePointIndexToCharIndex = _ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
            if (access$codePointIndexToCharIndex != -1) {
                String utf8 = utf8();
                String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String u5 = kotlin.text.n.u(kotlin.text.n.u(kotlin.text.n.u(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (access$codePointIndexToCharIndex >= utf8.length()) {
                    sb = new StringBuilder();
                    sb.append("[text=");
                    sb.append(u5);
                    sb.append(']');
                    return sb.toString();
                }
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData$okio().length);
                sb.append(" text=");
                sb.append(u5);
            } else if (getData$okio().length <= 64) {
                str = "[hex=" + hex() + ']';
            } else {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData$okio().length);
                sb.append(" hex=");
                int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, 64);
                if (!(resolveDefaultParameter <= getData$okio().length)) {
                    throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
                }
                if (!(resolveDefaultParameter + 0 >= 0)) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                if (resolveDefaultParameter == getData$okio().length) {
                    byteString = this;
                } else {
                    h6 = kotlin.collections.i.h(getData$okio(), 0, resolveDefaultParameter);
                    byteString = new ByteString(h6);
                }
                sb.append(byteString.hex());
            }
            sb.append("…]");
            return sb.toString();
        }
        str = "[size=0]";
        return str;
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
            setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    public void write(OutputStream outputStream) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$okio(Buffer buffer, int i6, int i7) {
        kotlin.jvm.internal.l.d(buffer, "buffer");
        _ByteStringKt.commonWrite(this, buffer, i6, i7);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i6, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 2) != 0) {
                i6 = 0;
            }
            return byteString.indexOf(bArr, i6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i6, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 2) != 0) {
                i6 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(bArr, i6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final ByteString of(byte... bArr) {
        return Companion.of(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "other");
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i6 = 0; i6 < min; i6++) {
            int i7 = getByte(i6) & 255;
            int i8 = byteString.getByte(i6) & 255;
            if (i7 != i8) {
                return i7 < i8 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
        }
    }

    public final boolean endsWith(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString, int i6) {
        kotlin.jvm.internal.l.d(byteString, "other");
        return indexOf(byteString.internalArray$okio(), i6);
    }

    public final int lastIndexOf(ByteString byteString, int i6) {
        kotlin.jvm.internal.l.d(byteString, "other");
        return lastIndexOf(byteString.internalArray$okio(), i6);
    }

    public boolean rangeEquals(int i6, byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l.d(bArr, "other");
        return i6 >= 0 && i6 <= getData$okio().length - i8 && i7 >= 0 && i7 <= bArr.length - i8 && _UtilKt.arrayRangeEquals(getData$okio(), i6, bArr, i7, i8);
    }

    public final boolean startsWith(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "prefix");
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final ByteString substring(int i6) {
        return substring$default(this, i6, 0, 2, null);
    }

    public static final ByteString of(byte[] bArr, int i6, int i7) {
        return Companion.of(bArr, i6, i7);
    }

    public final int indexOf(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "other");
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "other");
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public ByteString substring(int i6, int i7) {
        byte[] h6;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, i7);
        if (i6 >= 0) {
            if (!(resolveDefaultParameter <= getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
            if (resolveDefaultParameter - i6 >= 0) {
                if (i6 == 0 && resolveDefaultParameter == getData$okio().length) {
                    return this;
                }
                h6 = kotlin.collections.i.h(getData$okio(), i6, resolveDefaultParameter);
                return new ByteString(h6);
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public int indexOf(byte[] bArr, int i6) {
        kotlin.jvm.internal.l.d(bArr, "other");
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i6, 0);
        if (max <= length) {
            while (!_UtilKt.arrayRangeEquals(getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i6) {
        kotlin.jvm.internal.l.d(bArr, "other");
        for (int min = Math.min(_UtilKt.resolveDefaultParameter(this, i6), getData$okio().length - bArr.length); -1 < min; min--) {
            if (_UtilKt.arrayRangeEquals(getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }
}
