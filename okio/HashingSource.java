package okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final HashingSource hmacSha1(Source source, ByteString byteString) {
            kotlin.jvm.internal.l.d(source, "source");
            kotlin.jvm.internal.l.d(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        public final HashingSource hmacSha256(Source source, ByteString byteString) {
            kotlin.jvm.internal.l.d(source, "source");
            kotlin.jvm.internal.l.d(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        public final HashingSource hmacSha512(Source source, ByteString byteString) {
            kotlin.jvm.internal.l.d(source, "source");
            kotlin.jvm.internal.l.d(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        public final HashingSource md5(Source source) {
            kotlin.jvm.internal.l.d(source, "source");
            return new HashingSource(source, "MD5");
        }

        public final HashingSource sha1(Source source) {
            kotlin.jvm.internal.l.d(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        public final HashingSource sha256(Source source) {
            kotlin.jvm.internal.l.d(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        public final HashingSource sha512(Source source) {
            kotlin.jvm.internal.l.d(source, "source");
            return new HashingSource(source, "SHA-512");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashingSource(Source source, String str) {
        this(source, r3);
        kotlin.jvm.internal.l.d(source, "source");
        kotlin.jvm.internal.l.d(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        kotlin.jvm.internal.l.c(messageDigest, "getInstance(algorithm)");
    }

    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m181deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        byte[] doFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            doFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            kotlin.jvm.internal.l.b(mac);
            doFinal = mac.doFinal();
        }
        kotlin.jvm.internal.l.c(doFinal, "result");
        return new ByteString(doFinal);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        long read = super.read(buffer, j6);
        if (read != -1) {
            long size = buffer.size() - read;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            kotlin.jvm.internal.l.b(segment);
            while (size2 > size) {
                segment = segment.prev;
                kotlin.jvm.internal.l.b(segment);
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < buffer.size()) {
                int i6 = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i6, segment.limit - i6);
                } else {
                    Mac mac = this.mac;
                    kotlin.jvm.internal.l.b(mac);
                    mac.update(segment.data, i6, segment.limit - i6);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                kotlin.jvm.internal.l.b(segment);
                size = size2;
            }
        }
        return read;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, MessageDigest messageDigest) {
        super(source);
        kotlin.jvm.internal.l.d(source, "source");
        kotlin.jvm.internal.l.d(messageDigest, "digest");
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, Mac mac) {
        super(source);
        kotlin.jvm.internal.l.d(source, "source");
        kotlin.jvm.internal.l.d(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashingSource(Source source, ByteString byteString, String str) {
        this(source, r0);
        kotlin.jvm.internal.l.d(source, "source");
        kotlin.jvm.internal.l.d(byteString, "key");
        kotlin.jvm.internal.l.d(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            h4.q qVar = h4.q.f10774a;
            kotlin.jvm.internal.l.c(mac, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }
}
