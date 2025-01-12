package okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class HashingSink extends ForwardingSink {
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

        public final HashingSink hmacSha1(Sink sink, ByteString byteString) {
            kotlin.jvm.internal.l.d(sink, "sink");
            kotlin.jvm.internal.l.d(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA1");
        }

        public final HashingSink hmacSha256(Sink sink, ByteString byteString) {
            kotlin.jvm.internal.l.d(sink, "sink");
            kotlin.jvm.internal.l.d(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        public final HashingSink hmacSha512(Sink sink, ByteString byteString) {
            kotlin.jvm.internal.l.d(sink, "sink");
            kotlin.jvm.internal.l.d(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        public final HashingSink md5(Sink sink) {
            kotlin.jvm.internal.l.d(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        public final HashingSink sha1(Sink sink) {
            kotlin.jvm.internal.l.d(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        public final HashingSink sha256(Sink sink) {
            kotlin.jvm.internal.l.d(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        public final HashingSink sha512(Sink sink) {
            kotlin.jvm.internal.l.d(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashingSink(Sink sink, String str) {
        this(sink, r3);
        kotlin.jvm.internal.l.d(sink, "sink");
        kotlin.jvm.internal.l.d(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        kotlin.jvm.internal.l.c(messageDigest, "getInstance(algorithm)");
    }

    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m180deprecated_hash() {
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

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "source");
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j6);
        Segment segment = buffer.head;
        kotlin.jvm.internal.l.b(segment);
        long j7 = 0;
        while (j7 < j6) {
            int min = (int) Math.min(j6 - j7, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                Mac mac = this.mac;
                kotlin.jvm.internal.l.b(mac);
                mac.update(segment.data, segment.pos, min);
            }
            j7 += min;
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
        }
        super.write(buffer, j6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, MessageDigest messageDigest) {
        super(sink);
        kotlin.jvm.internal.l.d(sink, "sink");
        kotlin.jvm.internal.l.d(messageDigest, "digest");
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, Mac mac) {
        super(sink);
        kotlin.jvm.internal.l.d(sink, "sink");
        kotlin.jvm.internal.l.d(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashingSink(Sink sink, ByteString byteString, String str) {
        this(sink, r0);
        kotlin.jvm.internal.l.d(sink, "sink");
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
