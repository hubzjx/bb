package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class p extends o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends kotlin.jvm.internal.m implements p4.l {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // p4.l
        public final String invoke(String str) {
            kotlin.jvm.internal.l.d(str, "line");
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends kotlin.jvm.internal.m implements p4.l {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // p4.l
        public final String invoke(String str) {
            kotlin.jvm.internal.l.d(str, "line");
            return this.$indent + str;
        }
    }

    private static final p4.l b(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    public static final String c(String str, String str2, String str3) {
        int i6;
        String str4;
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "newIndent");
        kotlin.jvm.internal.l.d(str3, "marginPrefix");
        if (!w.n(str3)) {
            List W = x.W(str);
            int length = str.length() + (str2.length() * W.size());
            p4.l b6 = b(str2);
            int h6 = kotlin.collections.l.h(W);
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            for (Object obj : W) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    kotlin.collections.l.o();
                }
                String str5 = (String) obj;
                String str6 = null;
                if ((i7 == 0 || i7 == h6) && w.n(str5)) {
                    str5 = null;
                } else {
                    int length2 = str5.length();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length2) {
                            i6 = -1;
                            break;
                        } else if (!kotlin.text.b.c(str5.charAt(i9))) {
                            i6 = i9;
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (i6 != -1) {
                        int i10 = i6;
                        if (n.x(str5, str3, i6, false, 4, null)) {
                            str6 = str5.substring(i10 + str3.length());
                            kotlin.jvm.internal.l.c(str6, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str6 != null && (str4 = (String) b6.invoke(str6)) != null) {
                        str5 = str4;
                    }
                }
                if (str5 != null) {
                    arrayList.add(str5);
                }
                i7 = i8;
            }
            String sb = ((StringBuilder) kotlin.collections.l.D(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, b.j.N0, null)).toString();
            kotlin.jvm.internal.l.c(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static final String d(String str, String str2) {
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(str2, "marginPrefix");
        return c(str, HttpUrl.FRAGMENT_ENCODE_SET, str2);
    }

    public static /* synthetic */ String e(String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str2 = "|";
        }
        return d(str, str2);
    }
}
