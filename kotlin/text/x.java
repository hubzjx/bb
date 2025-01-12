package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class x extends w {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends kotlin.jvm.internal.m implements p4.p {
        final /* synthetic */ char[] $delimiters;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z5) {
            super(2);
            this.$delimiters = cArr;
            this.$ignoreCase = z5;
        }

        public final h4.j invoke(CharSequence charSequence, int i6) {
            kotlin.jvm.internal.l.d(charSequence, "$this$$receiver");
            int P = x.P(charSequence, this.$delimiters, i6, this.$ignoreCase);
            if (P < 0) {
                return null;
            }
            return h4.n.a(Integer.valueOf(P), 1);
        }

        @Override // p4.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends kotlin.jvm.internal.m implements p4.p {
        final /* synthetic */ List<String> $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<String> list, boolean z5) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z5;
        }

        public final h4.j invoke(CharSequence charSequence, int i6) {
            kotlin.jvm.internal.l.d(charSequence, "$this$$receiver");
            h4.j G = x.G(charSequence, this.$delimitersList, i6, this.$ignoreCase, false);
            if (G != null) {
                return h4.n.a(G.getFirst(), Integer.valueOf(((String) G.getSecond()).length()));
            }
            return null;
        }

        @Override // p4.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends kotlin.jvm.internal.m implements p4.l {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // p4.l
        public final String invoke(r4.c cVar) {
            kotlin.jvm.internal.l.d(cVar, "it");
            return x.o0(this.$this_splitToSequence, cVar);
        }
    }

    public static final boolean A(CharSequence charSequence, char c6, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return n.N(charSequence, c6, 0, z5, 2, null) >= 0;
    }

    public static final boolean B(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (n.O(charSequence, (String) charSequence2, 0, z5, 2, null) >= 0) {
                return true;
            }
        } else if (M(charSequence, charSequence2, 0, charSequence.length(), z5, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, char c6, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return A(charSequence, c6, z5);
    }

    public static /* synthetic */ boolean D(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return B(charSequence, charSequence2, z5);
    }

    public static final boolean E(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(charSequence2, "suffix");
        return (!z5 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? n.k((String) charSequence, (String) charSequence2, false, 2, null) : b0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z5);
    }

    public static /* synthetic */ boolean F(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return E(charSequence, charSequence2, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h4.j G(CharSequence charSequence, Collection collection, int i6, boolean z5, boolean z6) {
        int a6;
        Object obj;
        String str;
        Object obj2;
        if (!z5 && collection.size() == 1) {
            String str2 = (String) kotlin.collections.l.J(collection);
            int O = !z6 ? n.O(charSequence, str2, i6, false, 4, null) : n.T(charSequence, str2, i6, false, 4, null);
            if (O < 0) {
                return null;
            }
            return h4.n.a(Integer.valueOf(O), str2);
        }
        r4.a cVar = !z6 ? new r4.c(r4.d.b(i6, 0), charSequence.length()) : r4.d.e(r4.d.c(i6, I(charSequence)), 0);
        if (charSequence instanceof String) {
            a6 = cVar.a();
            int b6 = cVar.b();
            int c6 = cVar.c();
            if ((c6 > 0 && a6 <= b6) || (c6 < 0 && b6 <= a6)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str3 = (String) obj2;
                        if (w.o(str3, 0, (String) charSequence, a6, str3.length(), z5)) {
                            break;
                        }
                    }
                    str = (String) obj2;
                    if (str == null) {
                        if (a6 == b6) {
                            break;
                        }
                        a6 += c6;
                    } else {
                        break;
                    }
                }
                return h4.n.a(Integer.valueOf(a6), str);
            }
            return null;
        }
        a6 = cVar.a();
        int b7 = cVar.b();
        int c7 = cVar.c();
        if ((c7 > 0 && a6 <= b7) || (c7 < 0 && b7 <= a6)) {
            while (true) {
                Iterator it2 = collection.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    String str4 = (String) obj;
                    if (b0(str4, 0, charSequence, a6, str4.length(), z5)) {
                        break;
                    }
                }
                str = (String) obj;
                if (str == null) {
                    if (a6 == b7) {
                        break;
                    }
                    a6 += c7;
                } else {
                    break;
                }
            }
            return h4.n.a(Integer.valueOf(a6), str);
        }
        return null;
    }

    public static final r4.c H(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return new r4.c(0, charSequence.length() - 1);
    }

    public static final int I(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int J(CharSequence charSequence, char c6, int i6, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? P(charSequence, new char[]{c6}, i6, z5) : ((String) charSequence).indexOf(c6, i6);
    }

    public static final int K(CharSequence charSequence, String str, int i6, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(str, "string");
        return (z5 || !(charSequence instanceof String)) ? M(charSequence, str, i6, charSequence.length(), z5, false, 16, null) : ((String) charSequence).indexOf(str, i6);
    }

    private static final int L(CharSequence charSequence, CharSequence charSequence2, int i6, int i7, boolean z5, boolean z6) {
        r4.a cVar = !z6 ? new r4.c(r4.d.b(i6, 0), r4.d.c(i7, charSequence.length())) : r4.d.e(r4.d.c(i6, I(charSequence)), r4.d.b(i7, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a6 = cVar.a();
            int b6 = cVar.b();
            int c6 = cVar.c();
            if ((c6 <= 0 || a6 > b6) && (c6 >= 0 || b6 > a6)) {
                return -1;
            }
            while (!w.o((String) charSequence2, 0, (String) charSequence, a6, charSequence2.length(), z5)) {
                if (a6 == b6) {
                    return -1;
                }
                a6 += c6;
            }
            return a6;
        }
        int a7 = cVar.a();
        int b7 = cVar.b();
        int c7 = cVar.c();
        if ((c7 <= 0 || a7 > b7) && (c7 >= 0 || b7 > a7)) {
            return -1;
        }
        while (!b0(charSequence2, 0, charSequence, a7, charSequence2.length(), z5)) {
            if (a7 == b7) {
                return -1;
            }
            a7 += c7;
        }
        return a7;
    }

    static /* synthetic */ int M(CharSequence charSequence, CharSequence charSequence2, int i6, int i7, boolean z5, boolean z6, int i8, Object obj) {
        return L(charSequence, charSequence2, i6, i7, z5, (i8 & 16) != 0 ? false : z6);
    }

    public static /* synthetic */ int N(CharSequence charSequence, char c6, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return J(charSequence, c6, i6, z5);
    }

    public static /* synthetic */ int O(CharSequence charSequence, String str, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return K(charSequence, str, i6, z5);
    }

    public static final int P(CharSequence charSequence, char[] cArr, int i6, boolean z5) {
        boolean z6;
        char t5;
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(cArr, "chars");
        if (!z5 && cArr.length == 1 && (charSequence instanceof String)) {
            t5 = kotlin.collections.j.t(cArr);
            return ((String) charSequence).indexOf(t5, i6);
        }
        int b6 = r4.d.b(i6, 0);
        int I = I(charSequence);
        if (b6 > I) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(b6);
            int length = cArr.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    z6 = false;
                    break;
                } else if (kotlin.text.c.d(cArr[i7], charAt, z5)) {
                    z6 = true;
                    break;
                } else {
                    i7++;
                }
            }
            if (z6) {
                return b6;
            }
            if (b6 == I) {
                return -1;
            }
            b6++;
        }
    }

    public static final int Q(CharSequence charSequence, char c6, int i6, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? U(charSequence, new char[]{c6}, i6, z5) : ((String) charSequence).lastIndexOf(c6, i6);
    }

    public static final int R(CharSequence charSequence, String str, int i6, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(str, "string");
        return (z5 || !(charSequence instanceof String)) ? L(charSequence, str, i6, 0, z5, true) : ((String) charSequence).lastIndexOf(str, i6);
    }

    public static /* synthetic */ int S(CharSequence charSequence, char c6, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = I(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return Q(charSequence, c6, i6, z5);
    }

    public static /* synthetic */ int T(CharSequence charSequence, String str, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = I(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return R(charSequence, str, i6, z5);
    }

    public static final int U(CharSequence charSequence, char[] cArr, int i6, boolean z5) {
        char t5;
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(cArr, "chars");
        if (!z5 && cArr.length == 1 && (charSequence instanceof String)) {
            t5 = kotlin.collections.j.t(cArr);
            return ((String) charSequence).lastIndexOf(t5, i6);
        }
        for (int c6 = r4.d.c(i6, I(charSequence)); -1 < c6; c6--) {
            char charAt = charSequence.charAt(c6);
            int length = cArr.length;
            boolean z6 = false;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                } else if (kotlin.text.c.d(cArr[i7], charAt, z5)) {
                    z6 = true;
                    break;
                } else {
                    i7++;
                }
            }
            if (z6) {
                return c6;
            }
        }
        return -1;
    }

    public static final t4.d V(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return l0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List W(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        return t4.g.k(V(charSequence));
    }

    private static final t4.d X(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7) {
        g0(i7);
        return new e(charSequence, i6, i7, new a(cArr, z5));
    }

    private static final t4.d Y(CharSequence charSequence, String[] strArr, int i6, boolean z5, int i7) {
        List c6;
        g0(i7);
        c6 = kotlin.collections.i.c(strArr);
        return new e(charSequence, i6, i7, new b(c6, z5));
    }

    static /* synthetic */ t4.d Z(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        return X(charSequence, cArr, i6, z5, i7);
    }

    static /* synthetic */ t4.d a0(CharSequence charSequence, String[] strArr, int i6, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        return Y(charSequence, strArr, i6, z5, i7);
    }

    public static final boolean b0(CharSequence charSequence, int i6, CharSequence charSequence2, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(charSequence2, "other");
        if (i7 < 0 || i6 < 0 || i6 > charSequence.length() - i8 || i7 > charSequence2.length() - i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!kotlin.text.c.d(charSequence.charAt(i6 + i9), charSequence2.charAt(i7 + i9), z5)) {
                return false;
            }
        }
        return true;
    }

    public static String c0(String str, CharSequence charSequence) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(charSequence, "prefix");
        if (n0(str, charSequence, false, 2, null)) {
            String substring = str.substring(charSequence.length());
            kotlin.jvm.internal.l.c(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    public static String d0(String str, CharSequence charSequence) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(charSequence, "suffix");
        if (F(str, charSequence, false, 2, null)) {
            String substring = str.substring(0, str.length() - charSequence.length());
            kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static String e0(String str, CharSequence charSequence) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(charSequence, "delimiter");
        return f0(str, charSequence, charSequence);
    }

    public static final String f0(String str, CharSequence charSequence, CharSequence charSequence2) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(charSequence, "prefix");
        kotlin.jvm.internal.l.d(charSequence2, "suffix");
        if (str.length() >= charSequence.length() + charSequence2.length() && n0(str, charSequence, false, 2, null) && F(str, charSequence2, false, 2, null)) {
            String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
            kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static final void g0(int i6) {
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i6).toString());
    }

    public static final List h0(CharSequence charSequence, char[] cArr, boolean z5, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(cArr, "delimiters");
        if (cArr.length == 1) {
            return i0(charSequence, String.valueOf(cArr[0]), z5, i6);
        }
        Iterable<r4.c> d6 = t4.g.d(Z(charSequence, cArr, 0, z5, i6, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.l.p(d6, 10));
        for (r4.c cVar : d6) {
            arrayList.add(o0(charSequence, cVar));
        }
        return arrayList;
    }

    private static final List i0(CharSequence charSequence, String str, boolean z5, int i6) {
        g0(i6);
        int i7 = 0;
        int K = K(charSequence, str, 0, z5);
        if (K == -1 || i6 == 1) {
            return kotlin.collections.l.b(charSequence.toString());
        }
        boolean z6 = i6 > 0;
        ArrayList arrayList = new ArrayList(z6 ? r4.d.c(i6, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i7, K).toString());
            i7 = str.length() + K;
            if (z6 && arrayList.size() == i6 - 1) {
                break;
            }
            K = K(charSequence, str, i7, z5);
        } while (K != -1);
        arrayList.add(charSequence.subSequence(i7, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List j0(CharSequence charSequence, char[] cArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return h0(charSequence, cArr, z5, i6);
    }

    public static final t4.d k0(CharSequence charSequence, String[] strArr, boolean z5, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(strArr, "delimiters");
        return t4.g.i(a0(charSequence, strArr, 0, z5, i6, 2, null), new c(charSequence));
    }

    public static /* synthetic */ t4.d l0(CharSequence charSequence, String[] strArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return k0(charSequence, strArr, z5, i6);
    }

    public static final boolean m0(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(charSequence2, "prefix");
        return (!z5 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? n.y((String) charSequence, (String) charSequence2, false, 2, null) : b0(charSequence, 0, charSequence2, 0, charSequence2.length(), z5);
    }

    public static /* synthetic */ boolean n0(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return m0(charSequence, charSequence2, z5);
    }

    public static final String o0(CharSequence charSequence, r4.c cVar) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        kotlin.jvm.internal.l.d(cVar, "range");
        return charSequence.subSequence(cVar.h().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static final String p0(String str, char c6, String str2) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "missingDelimiterValue");
        int N = n.N(str, c6, 0, false, 6, null);
        if (N == -1) {
            return str2;
        }
        String substring = str.substring(N + 1, str.length());
        kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String q0(String str, String str2, String str3) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "delimiter");
        kotlin.jvm.internal.l.d(str3, "missingDelimiterValue");
        int O = n.O(str, str2, 0, false, 6, null);
        if (O == -1) {
            return str3;
        }
        String substring = str.substring(O + str2.length(), str.length());
        kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String r0(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return p0(str, c6, str2);
    }

    public static /* synthetic */ String s0(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return q0(str, str2, str3);
    }

    public static final String t0(String str, char c6, String str2) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "missingDelimiterValue");
        int S = n.S(str, c6, 0, false, 6, null);
        if (S == -1) {
            return str2;
        }
        String substring = str.substring(S + 1, str.length());
        kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String u0(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return t0(str, c6, str2);
    }

    public static CharSequence v0(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean c6 = kotlin.text.b.c(charSequence.charAt(!z5 ? i6 : length));
            if (z5) {
                if (!c6) {
                    break;
                }
                length--;
            } else if (c6) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i6, length + 1);
    }
}
