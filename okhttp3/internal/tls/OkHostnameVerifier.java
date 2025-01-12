package okhttp3.internal.tls;

import io.jsonwebtoken.JwtParser;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import k5.d;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
/* loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (isAscii(str)) {
            Locale locale = Locale.US;
            l.c(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            l.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        return str;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i6) {
        List<String> f6;
        Object obj;
        List<String> f7;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                f7 = n.f();
                return f7;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && l.a(list.get(0), Integer.valueOf(i6)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            f6 = n.f();
            return f6;
        }
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) Utf8.size$default(str, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String str, String str2) {
        boolean y5;
        boolean k6;
        boolean y6;
        boolean k7;
        boolean k8;
        boolean k9;
        boolean D;
        boolean y7;
        int N;
        boolean k10;
        int S;
        if (!(str == null || str.length() == 0)) {
            y5 = w.y(str, ".", false, 2, null);
            if (!y5) {
                k6 = w.k(str, "..", false, 2, null);
                if (!k6) {
                    if (!(str2 == null || str2.length() == 0)) {
                        y6 = w.y(str2, ".", false, 2, null);
                        if (!y6) {
                            k7 = w.k(str2, "..", false, 2, null);
                            if (!k7) {
                                k8 = w.k(str, ".", false, 2, null);
                                if (!k8) {
                                    str = l.i(str, ".");
                                }
                                String str3 = str;
                                k9 = w.k(str2, ".", false, 2, null);
                                if (!k9) {
                                    str2 = l.i(str2, ".");
                                }
                                String asciiToLowercase = asciiToLowercase(str2);
                                D = x.D(asciiToLowercase, d.ANY_MARKER, false, 2, null);
                                if (!D) {
                                    return l.a(str3, asciiToLowercase);
                                }
                                y7 = w.y(asciiToLowercase, "*.", false, 2, null);
                                if (y7) {
                                    N = x.N(asciiToLowercase, '*', 1, false, 4, null);
                                    if (N == -1 && str3.length() >= asciiToLowercase.length() && !l.a("*.", asciiToLowercase)) {
                                        String substring = asciiToLowercase.substring(1);
                                        l.c(substring, "this as java.lang.String).substring(startIndex)");
                                        k10 = w.k(str3, substring, false, 2, null);
                                        if (k10) {
                                            int length = str3.length() - substring.length();
                                            if (length > 0) {
                                                S = x.S(str3, JwtParser.SEPARATOR_CHAR, length - 1, false, 4, null);
                                                if (S != -1) {
                                                    return false;
                                                }
                                            }
                                            return true;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (l.a(canonicalHost, HostnamesKt.toCanonicalHost(str2))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        List<String> H;
        l.d(x509Certificate, "certificate");
        H = v.H(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
        return H;
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        l.d(str, "host");
        l.d(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate) : verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (INSTANCE.verifyHostname(asciiToLowercase, str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        Certificate certificate;
        l.d(str, "host");
        l.d(sSLSession, "session");
        if (isAscii(str)) {
            try {
                certificate = sSLSession.getPeerCertificates()[0];
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(str, (X509Certificate) certificate);
    }
}
