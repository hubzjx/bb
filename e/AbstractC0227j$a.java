package e;

import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import f.InterfaceC0272j$t;
import g.AbstractC0350j$s0;
import g.j$M2;
import j$.util.Comparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.SortedSet;
/* renamed from: e.j$a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0227j$a {
    public static j$J A(Collection collection) {
        if (collection instanceof InterfaceC0228j$b) {
            return ((InterfaceC0228j$b) collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            LinkedHashSet linkedHashSet = (LinkedHashSet) collection;
            linkedHashSet.getClass();
            return new j$V(linkedHashSet, 17);
        } else if (collection instanceof SortedSet) {
            final SortedSet sortedSet = (SortedSet) collection;
            return new j$V(sortedSet) { // from class: e.j$z
                @Override // e.j$V, e.j$J
                public final Comparator getComparator() {
                    return sortedSet.comparator();
                }
            };
        } else if (collection instanceof Set) {
            Set set = (Set) collection;
            set.getClass();
            return new j$V(set, 1);
        } else if (!(collection instanceof List)) {
            collection.getClass();
            return new j$V(collection, 0);
        } else {
            List list = (List) collection;
            list.getClass();
            return new j$V(list, 16);
        }
    }

    public static /* synthetic */ Comparator B(Comparator comparator, Comparator comparator2) {
        return comparator instanceof j$.util.Comparator ? ((j$.util.Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public static void a(InterfaceC0245j$s interfaceC0245j$s, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0261j$i) {
            ((j$N) interfaceC0245j$s).c((InterfaceC0261j$i) interfaceC0257j$e);
            return;
        }
        interfaceC0257j$e.getClass();
        if (j$Z.f9280a) {
            j$Z.a(interfaceC0245j$s.getClass(), "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
            throw null;
        }
        ((j$N) interfaceC0245j$s).c(new C0243j$q(interfaceC0257j$e));
    }

    public static void d(j$B j_b, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0261j$i) {
            j_b.k((InterfaceC0261j$i) interfaceC0257j$e);
        } else if (j$Z.f9280a) {
            j$Z.a(j_b.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        } else {
            interfaceC0257j$e.getClass();
            j_b.k(new C0243j$q(interfaceC0257j$e));
        }
    }

    public static void e(j$D j_d, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0272j$t) {
            j_d.l((InterfaceC0272j$t) interfaceC0257j$e);
        } else if (j$Z.f9280a) {
            j$Z.a(j_d.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        } else {
            interfaceC0257j$e.getClass();
            j_d.l(new C0246j$t(interfaceC0257j$e));
        }
    }

    public static void f(j$F j_f, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof f.j$E) {
            j_f.c((f.j$E) interfaceC0257j$e);
        } else if (j$Z.f9280a) {
            j$Z.a(j_f.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        } else {
            interfaceC0257j$e.getClass();
            j_f.c(new C0249j$w(interfaceC0257j$e));
        }
    }

    public static long h(j$J j_j) {
        if ((j_j.characteristics() & 64) == 0) {
            return -1L;
        }
        return j_j.estimateSize();
    }

    public static boolean i(j$J j_j, int i6) {
        return (j_j.characteristics() & i6) == i6;
    }

    public static boolean j(Collection collection, f.j$S j_s) {
        if (AbstractC0231j$e.f9286a.isInstance(collection)) {
            return AbstractC0231j$e.a(collection, j_s);
        }
        j_s.getClass();
        Iterator it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (j_s.l(it.next())) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    public static j$M2 m(Collection collection) {
        return AbstractC0350j$s0.r0(A(collection), false);
    }

    public static boolean o(j$B j_b, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0261j$i) {
            return j_b.n((InterfaceC0261j$i) interfaceC0257j$e);
        }
        if (j$Z.f9280a) {
            j$Z.a(j_b.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        interfaceC0257j$e.getClass();
        return j_b.n(new C0243j$q(interfaceC0257j$e));
    }

    public static boolean q(j$D j_d, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0272j$t) {
            return j_d.g((InterfaceC0272j$t) interfaceC0257j$e);
        }
        if (j$Z.f9280a) {
            j$Z.a(j_d.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        interfaceC0257j$e.getClass();
        return j_d.g(new C0246j$t(interfaceC0257j$e));
    }

    public static boolean s(j$F j_f, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof f.j$E) {
            return j_f.p((f.j$E) interfaceC0257j$e);
        }
        if (j$Z.f9280a) {
            j$Z.a(j_f.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        interfaceC0257j$e.getClass();
        return j_f.p(new C0249j$w(interfaceC0257j$e));
    }

    public static Optional t(C0239j$m c0239j$m) {
        if (c0239j$m == null) {
            return null;
        }
        return c0239j$m.c() ? Optional.of(c0239j$m.b()) : Optional.empty();
    }

    public static OptionalDouble u(C0240j$n c0240j$n) {
        if (c0240j$n == null) {
            return null;
        }
        return c0240j$n.c() ? OptionalDouble.of(c0240j$n.b()) : OptionalDouble.empty();
    }

    public static OptionalInt v(C0241j$o c0241j$o) {
        if (c0241j$o == null) {
            return null;
        }
        return c0241j$o.c() ? OptionalInt.of(c0241j$o.b()) : OptionalInt.empty();
    }

    public static OptionalLong w(C0242j$p c0242j$p) {
        if (c0242j$p == null) {
            return null;
        }
        return c0242j$p.c() ? OptionalLong.of(c0242j$p.b()) : OptionalLong.empty();
    }

    public static boolean x(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void y(Collection collection, InterfaceC0257j$e interfaceC0257j$e) {
        if (collection instanceof InterfaceC0228j$b) {
            ((InterfaceC0228j$b) collection).b(interfaceC0257j$e);
            return;
        }
        interfaceC0257j$e.getClass();
        for (Object obj : collection) {
            interfaceC0257j$e.j(obj);
        }
    }

    public static void z(List list, java.util.Comparator comparator) {
        if (AbstractC0231j$e.f9287b.isInstance(list)) {
            AbstractC0231j$e.b(list, comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    public int characteristics() {
        return 16448;
    }

    public long estimateSize() {
        return 0L;
    }

    public void forEachRemaining(Object obj) {
        obj.getClass();
    }

    public boolean tryAdvance(Object obj) {
        obj.getClass();
        return false;
    }

    public j$J trySplit() {
        return null;
    }
}
