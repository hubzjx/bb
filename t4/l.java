package t4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.text.o;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class l extends k {

    /* loaded from: classes.dex */
    public static final class a implements Iterable, q4.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f13398a;

        public a(d dVar) {
            this.f13398a = dVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f13398a.iterator();
        }
    }

    public static Iterable d(d dVar) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        return new a(dVar);
    }

    public static d e(d dVar, int i6) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        if (i6 >= 0) {
            return i6 == 0 ? dVar : dVar instanceof b ? ((b) dVar).a(i6) : new t4.a(dVar, i6);
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    public static final Appendable f(d dVar, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        kotlin.jvm.internal.l.d(appendable, "buffer");
        kotlin.jvm.internal.l.d(charSequence, "separator");
        kotlin.jvm.internal.l.d(charSequence2, "prefix");
        kotlin.jvm.internal.l.d(charSequence3, "postfix");
        kotlin.jvm.internal.l.d(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i7 = 0;
        for (Object obj : dVar) {
            i7++;
            if (i7 > 1) {
                appendable.append(charSequence);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            o.a(appendable, obj, lVar);
        }
        if (i6 >= 0 && i7 > i6) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String g(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        kotlin.jvm.internal.l.d(charSequence, "separator");
        kotlin.jvm.internal.l.d(charSequence2, "prefix");
        kotlin.jvm.internal.l.d(charSequence3, "postfix");
        kotlin.jvm.internal.l.d(charSequence4, "truncated");
        String sb = ((StringBuilder) f(dVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i6, charSequence4, lVar)).toString();
        kotlin.jvm.internal.l.c(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String h(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        int i8 = i7 & 2;
        CharSequence charSequence5 = HttpUrl.FRAGMENT_ENCODE_SET;
        CharSequence charSequence6 = i8 != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence2;
        if ((i7 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i9 = (i7 & 8) != 0 ? -1 : i6;
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i7 & 32) != 0) {
            lVar = null;
        }
        return g(dVar, charSequence, charSequence6, charSequence5, i9, charSequence7, lVar);
    }

    public static d i(d dVar, p4.l lVar) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        kotlin.jvm.internal.l.d(lVar, "transform");
        return new m(dVar, lVar);
    }

    public static final Collection j(d dVar, Collection collection) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        kotlin.jvm.internal.l.d(collection, "destination");
        for (Object obj : dVar) {
            collection.add(obj);
        }
        return collection;
    }

    public static List k(d dVar) {
        List l6;
        kotlin.jvm.internal.l.d(dVar, "<this>");
        l6 = n.l(l(dVar));
        return l6;
    }

    public static final List l(d dVar) {
        kotlin.jvm.internal.l.d(dVar, "<this>");
        return (List) j(dVar, new ArrayList());
    }
}
