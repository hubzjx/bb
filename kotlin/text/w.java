package kotlin.text;

import io.jsonwebtoken.JwtParser;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.a0;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class w extends v {
    public static String h(char[] cArr) {
        kotlin.jvm.internal.l.d(cArr, "<this>");
        return new String(cArr);
    }

    public static String i(char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(cArr, "<this>");
        kotlin.collections.b.Companion.a(i6, i7, cArr.length);
        return new String(cArr, i6, i7 - i6);
    }

    public static boolean j(String str, String str2, boolean z5) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "suffix");
        return !z5 ? str.endsWith(str2) : o(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean k(String str, String str2, boolean z5, int i6, Object obj) {
        boolean j6;
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        j6 = j(str, str2, z5);
        return j6;
    }

    public static boolean l(String str, String str2, boolean z5) {
        return str == null ? str2 == null : !z5 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator m(kotlin.jvm.internal.u uVar) {
        kotlin.jvm.internal.l.d(uVar, "<this>");
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.l.c(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final boolean n(CharSequence charSequence) {
        boolean z5;
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        if (charSequence.length() != 0) {
            r4.c H = x.H(charSequence);
            if (!(H instanceof Collection) || !((Collection) H).isEmpty()) {
                Iterator it = H.iterator();
                while (it.hasNext()) {
                    if (!b.c(charSequence.charAt(((a0) it).a()))) {
                        z5 = false;
                        break;
                    }
                }
            }
            z5 = true;
            return z5;
        }
        return true;
    }

    public static final boolean o(String str, int i6, String str2, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "other");
        return !z5 ? str.regionMatches(i6, str2, i7, i8) : str.regionMatches(z5, i6, str2, i7, i8);
    }

    public static /* synthetic */ boolean p(String str, int i6, String str2, int i7, int i8, boolean z5, int i9, Object obj) {
        return o(str, i6, str2, i7, i8, (i9 & 16) != 0 ? false : z5);
    }

    public static String q(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        int i7 = 1;
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i6 + JwtParser.SEPARATOR_CHAR).toString());
        } else if (i6 != 0) {
            if (i6 != 1) {
                int length = charSequence.length();
                if (length != 0) {
                    if (length == 1) {
                        char charAt = charSequence.charAt(0);
                        char[] cArr = new char[i6];
                        for (int i8 = 0; i8 < i6; i8++) {
                            cArr[i8] = charAt;
                        }
                        return new String(cArr);
                    }
                    StringBuilder sb = new StringBuilder(charSequence.length() * i6);
                    if (1 <= i6) {
                        while (true) {
                            sb.append(charSequence);
                            if (i7 == i6) {
                                break;
                            }
                            i7++;
                        }
                    }
                    String sb2 = sb.toString();
                    kotlin.jvm.internal.l.c(sb2, "{\n                    va…tring()\n                }");
                    return sb2;
                }
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            return charSequence.toString();
        } else {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static final String r(String str, char c6, char c7, boolean z5) {
        String sb;
        String str2;
        kotlin.jvm.internal.l.d(str, "<this>");
        if (z5) {
            StringBuilder sb2 = new StringBuilder(str.length());
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (c.d(charAt, c6, z5)) {
                    charAt = c7;
                }
                sb2.append(charAt);
            }
            sb = sb2.toString();
            str2 = "StringBuilder(capacity).…builderAction).toString()";
        } else {
            sb = str.replace(c6, c7);
            str2 = "this as java.lang.String…replace(oldChar, newChar)";
        }
        kotlin.jvm.internal.l.c(sb, str2);
        return sb;
    }

    public static final String s(String str, String str2, String str3, boolean z5) {
        int b6;
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "oldValue");
        kotlin.jvm.internal.l.d(str3, "newValue");
        int i6 = 0;
        int K = x.K(str, str2, 0, z5);
        if (K < 0) {
            return str;
        }
        int length = str2.length();
        b6 = r4.f.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i6, K);
                sb.append(str3);
                i6 = K + length;
                if (K >= str.length()) {
                    break;
                }
                K = x.K(str, str2, K + b6, z5);
            } while (K > 0);
            sb.append((CharSequence) str, i6, str.length());
            String sb2 = sb.toString();
            kotlin.jvm.internal.l.c(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String t(String str, char c6, char c7, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return r(str, c6, c7, z5);
    }

    public static /* synthetic */ String u(String str, String str2, String str3, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return s(str, str2, str3, z5);
    }

    public static boolean v(String str, String str2, int i6, boolean z5) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "prefix");
        return !z5 ? str.startsWith(str2, i6) : o(str, i6, str2, 0, str2.length(), z5);
    }

    public static boolean w(String str, String str2, boolean z5) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "prefix");
        return !z5 ? str.startsWith(str2) : o(str, 0, str2, 0, str2.length(), z5);
    }

    public static /* synthetic */ boolean x(String str, String str2, int i6, boolean z5, int i7, Object obj) {
        boolean v5;
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        v5 = v(str, str2, i6, z5);
        return v5;
    }

    public static /* synthetic */ boolean y(String str, String str2, boolean z5, int i6, Object obj) {
        boolean w5;
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        w5 = w(str, str2, z5);
        return w5;
    }
}
