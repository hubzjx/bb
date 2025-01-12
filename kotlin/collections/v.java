package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class v extends u {

    /* loaded from: classes.dex */
    public static final class a implements t4.d {

        /* renamed from: a */
        final /* synthetic */ Iterable f11302a;

        public a(Iterable iterable) {
            this.f11302a = iterable;
        }

        @Override // t4.d
        public Iterator iterator() {
            return this.f11302a.iterator();
        }
    }

    public static Object A(List list) {
        kotlin.jvm.internal.l.d(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object B(List list) {
        kotlin.jvm.internal.l.d(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final Appendable C(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        kotlin.jvm.internal.l.d(appendable, "buffer");
        kotlin.jvm.internal.l.d(charSequence, "separator");
        kotlin.jvm.internal.l.d(charSequence2, "prefix");
        kotlin.jvm.internal.l.d(charSequence3, "postfix");
        kotlin.jvm.internal.l.d(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i7 = 0;
        for (Object obj : iterable) {
            i7++;
            if (i7 > 1) {
                appendable.append(charSequence);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            kotlin.text.o.a(appendable, obj, lVar);
        }
        if (i6 >= 0 && i7 > i6) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static /* synthetic */ Appendable D(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar, int i7, Object obj) {
        String str = (i7 & 2) != 0 ? ", " : charSequence;
        int i8 = i7 & 4;
        CharSequence charSequence5 = HttpUrl.FRAGMENT_ENCODE_SET;
        CharSequence charSequence6 = i8 != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence2;
        if ((i7 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return C(iterable, appendable, str, charSequence6, charSequence5, (i7 & 16) != 0 ? -1 : i6, (i7 & 32) != 0 ? "..." : charSequence4, (i7 & 64) != 0 ? null : lVar);
    }

    public static final String E(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        kotlin.jvm.internal.l.d(charSequence, "separator");
        kotlin.jvm.internal.l.d(charSequence2, "prefix");
        kotlin.jvm.internal.l.d(charSequence3, "postfix");
        kotlin.jvm.internal.l.d(charSequence4, "truncated");
        String sb = ((StringBuilder) C(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i6, charSequence4, lVar)).toString();
        kotlin.jvm.internal.l.c(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String F(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, p4.l lVar, int i7, Object obj) {
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
        return E(iterable, charSequence, charSequence6, charSequence5, i9, charSequence7, lVar);
    }

    public static Object G(List list) {
        int h6;
        kotlin.jvm.internal.l.d(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        h6 = n.h(list);
        return list.get(h6);
    }

    public static List H(Collection collection, Iterable iterable) {
        kotlin.jvm.internal.l.d(collection, "<this>");
        kotlin.jvm.internal.l.d(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            s.s(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List I(Collection collection, Object obj) {
        kotlin.jvm.internal.l.d(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object J(Iterable iterable) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        if (iterable instanceof List) {
            return K((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object K(List list) {
        kotlin.jvm.internal.l.d(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static List L(Iterable iterable, Comparator comparator) {
        List c6;
        List O;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        kotlin.jvm.internal.l.d(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List P = P(iterable);
            r.r(P, comparator);
            return P;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            O = O(iterable);
            return O;
        }
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            i.n(array, comparator);
            c6 = i.c(array);
            return c6;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static List M(Iterable iterable, int i6) {
        List l6;
        List b6;
        List O;
        List f6;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        int i7 = 0;
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        } else if (i6 == 0) {
            f6 = n.f();
            return f6;
        } else {
            if (iterable instanceof Collection) {
                if (i6 >= ((Collection) iterable).size()) {
                    O = O(iterable);
                    return O;
                } else if (i6 == 1) {
                    b6 = m.b(z(iterable));
                    return b6;
                }
            }
            ArrayList arrayList = new ArrayList(i6);
            for (Object obj : iterable) {
                arrayList.add(obj);
                i7++;
                if (i7 == i6) {
                    break;
                }
            }
            l6 = n.l(arrayList);
            return l6;
        }
    }

    public static final Collection N(Iterable iterable, Collection collection) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        kotlin.jvm.internal.l.d(collection, "destination");
        for (Object obj : iterable) {
            collection.add(obj);
        }
        return collection;
    }

    public static List O(Iterable iterable) {
        List l6;
        List f6;
        List b6;
        List Q;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            l6 = n.l(P(iterable));
            return l6;
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            f6 = n.f();
            return f6;
        } else if (size != 1) {
            Q = Q(collection);
            return Q;
        } else {
            b6 = m.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            return b6;
        }
    }

    public static final List P(Iterable iterable) {
        List Q;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        if (iterable instanceof Collection) {
            Q = Q((Collection) iterable);
            return Q;
        }
        return (List) N(iterable, new ArrayList());
    }

    public static List Q(Collection collection) {
        kotlin.jvm.internal.l.d(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set R(Iterable iterable) {
        Set b6;
        int a6;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                b6 = i0.b();
                return b6;
            } else if (size == 1) {
                return h0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            } else {
                a6 = d0.a(collection.size());
                return (Set) N(iterable, new LinkedHashSet(a6));
            }
        }
        return i0.c((Set) N(iterable, new LinkedHashSet()));
    }

    public static t4.d x(Iterable iterable) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        return new a(iterable);
    }

    public static List y(List list, int i6) {
        int b6;
        List M;
        kotlin.jvm.internal.l.d(list, "<this>");
        if (i6 >= 0) {
            b6 = r4.f.b(list.size() - i6, 0);
            M = M(list, b6);
            return M;
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    public static final Object z(Iterable iterable) {
        Object A;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        if (iterable instanceof List) {
            A = A((List) iterable);
            return A;
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }
}
