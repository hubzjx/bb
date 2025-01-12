package okhttp3;

import io.jsonwebtoken.JwtParser;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import k5.d;
import kotlin.collections.j;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
/* loaded from: classes.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            l.d(str, "pattern");
            l.d(strArr, "pins");
            int length = strArr.length;
            int i6 = 0;
            while (i6 < length) {
                String str2 = strArr[i6];
                i6++;
                getPins().add(new Pin(str, str2));
            }
            return this;
        }

        public final CertificatePinner build() {
            Set R;
            R = v.R(this.pins);
            return new CertificatePinner(R, null, 2, null);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String pin(Certificate certificate) {
            l.d(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return l.i("sha256/", sha256Hash((X509Certificate) certificate).base64());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            l.d(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            l.c(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            l.d(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            l.c(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }
    }

    /* loaded from: classes.dex */
    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
            if (r0 != (-1)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
            if (r0 != (-1)) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pin(String str, String str2) {
            boolean y5;
            boolean y6;
            int O;
            boolean z5;
            int O2;
            boolean y7;
            boolean y8;
            ByteString decodeBase64;
            int O3;
            l.d(str, "pattern");
            l.d(str2, "pin");
            y5 = w.y(str, "*.", false, 2, null);
            if (y5) {
                O3 = x.O(str, d.ANY_MARKER, 1, false, 4, null);
            }
            y6 = w.y(str, "**.", false, 2, null);
            if (y6) {
                O2 = x.O(str, d.ANY_MARKER, 2, false, 4, null);
            }
            O = x.O(str, d.ANY_MARKER, 0, false, 6, null);
            if (O != -1) {
                z5 = false;
                if (z5) {
                    throw new IllegalArgumentException(l.i("Unexpected pattern: ", str).toString());
                }
                String canonicalHost = HostnamesKt.toCanonicalHost(str);
                if (canonicalHost == null) {
                    throw new IllegalArgumentException(l.i("Invalid pattern: ", str));
                }
                this.pattern = canonicalHost;
                y7 = w.y(str2, "sha1/", false, 2, null);
                if (y7) {
                    this.hashAlgorithm = "sha1";
                    ByteString.Companion companion = ByteString.Companion;
                    String substring = str2.substring(5);
                    l.c(substring, "this as java.lang.String).substring(startIndex)");
                    decodeBase64 = companion.decodeBase64(substring);
                    if (decodeBase64 == null) {
                        throw new IllegalArgumentException(l.i("Invalid pin hash: ", str2));
                    }
                } else {
                    y8 = w.y(str2, "sha256/", false, 2, null);
                    if (!y8) {
                        throw new IllegalArgumentException(l.i("pins must start with 'sha256/' or 'sha1/': ", str2));
                    }
                    this.hashAlgorithm = "sha256";
                    ByteString.Companion companion2 = ByteString.Companion;
                    String substring2 = str2.substring(7);
                    l.c(substring2, "this as java.lang.String).substring(startIndex)");
                    decodeBase64 = companion2.decodeBase64(substring2);
                    if (decodeBase64 == null) {
                        throw new IllegalArgumentException(l.i("Invalid pin hash: ", str2));
                    }
                }
                this.hash = decodeBase64;
                return;
            }
            z5 = true;
            if (z5) {
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return l.a(this.pattern, pin.pattern) && l.a(this.hashAlgorithm, pin.hashAlgorithm) && l.a(this.hash, pin.hash);
            }
            return false;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            ByteString byteString;
            ByteString sha1Hash;
            l.d(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (l.a(str, "sha256")) {
                byteString = this.hash;
                sha1Hash = CertificatePinner.Companion.sha256Hash(x509Certificate);
            } else if (!l.a(str, "sha1")) {
                return false;
            } else {
                byteString = this.hash;
                sha1Hash = CertificatePinner.Companion.sha1Hash(x509Certificate);
            }
            return l.a(byteString, sha1Hash);
        }

        public final boolean matchesHostname(String str) {
            boolean y5;
            boolean y6;
            boolean p5;
            int S;
            boolean p6;
            l.d(str, "hostname");
            y5 = w.y(this.pattern, "**.", false, 2, null);
            if (y5) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                p6 = w.p(str, str.length() - length, this.pattern, 3, length, false, 16, null);
                if (!p6) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                y6 = w.y(this.pattern, "*.", false, 2, null);
                if (!y6) {
                    return l.a(str, this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                p5 = w.p(str, str.length() - length3, this.pattern, 1, length3, false, 16, null);
                if (!p5) {
                    return false;
                }
                S = x.S(str, JwtParser.SEPARATOR_CHAR, length4 - 1, false, 4, null);
                if (S != -1) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        l.d(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) {
        l.d(str, "hostname");
        l.d(list, "peerCertificates");
        check$okhttp(str, new CertificatePinner$check$1(this, list, str));
    }

    public final void check$okhttp(String str, p4.a aVar) {
        l.d(str, "hostname");
        l.d(aVar, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) aVar.invoke();
        for (X509Certificate x509Certificate : list) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (l.a(hashAlgorithm, "sha256")) {
                    if (byteString == null) {
                        byteString = Companion.sha256Hash(x509Certificate);
                    }
                    if (l.a(pin.getHash(), byteString)) {
                        return;
                    }
                } else if (!l.a(hashAlgorithm, "sha1")) {
                    throw new AssertionError(l.i("unsupported hashAlgorithm: ", pin.getHashAlgorithm()));
                } else {
                    if (byteString2 == null) {
                        byteString2 = Companion.sha1Hash(x509Certificate);
                    }
                    if (l.a(pin.getHash(), byteString2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String sb2 = sb.toString();
        l.c(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (l.a(certificatePinner.pins, this.pins) && l.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String str) {
        List<Pin> f6;
        l.d(str, "hostname");
        Set<Pin> set = this.pins;
        f6 = n.f();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(str)) {
                if (f6.isEmpty()) {
                    f6 = new ArrayList<>();
                }
                kotlin.jvm.internal.v.a(f6).add(obj);
            }
        }
        return f6;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        l.d(certificateChainCleaner, "certificateChainCleaner");
        return l.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i6, g gVar) {
        this(set, (i6 & 2) != 0 ? null : certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) {
        List<? extends Certificate> v5;
        l.d(str, "hostname");
        l.d(certificateArr, "peerCertificates");
        v5 = j.v(certificateArr);
        check(str, v5);
    }
}
