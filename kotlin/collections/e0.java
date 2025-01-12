package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e0 extends d0 {
    public static Map d() {
        return y.INSTANCE;
    }

    public static Map e(h4.j... jVarArr) {
        int a6;
        kotlin.jvm.internal.l.d(jVarArr, "pairs");
        a6 = d0.a(jVarArr.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a6);
        h(linkedHashMap, jVarArr);
        return linkedHashMap;
    }

    public static final Map f(Map map) {
        Map d6;
        kotlin.jvm.internal.l.d(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : d0.c(map);
        }
        d6 = d();
        return d6;
    }

    public static final void g(Map map, Iterable iterable) {
        kotlin.jvm.internal.l.d(map, "<this>");
        kotlin.jvm.internal.l.d(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            h4.j jVar = (h4.j) it.next();
            map.put(jVar.component1(), jVar.component2());
        }
    }

    public static final void h(Map map, h4.j[] jVarArr) {
        kotlin.jvm.internal.l.d(map, "<this>");
        kotlin.jvm.internal.l.d(jVarArr, "pairs");
        for (h4.j jVar : jVarArr) {
            map.put(jVar.component1(), jVar.component2());
        }
    }

    public static Map i(Iterable iterable) {
        Map d6;
        int a6;
        kotlin.jvm.internal.l.d(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                d6 = d();
                return d6;
            } else if (size == 1) {
                return d0.b((h4.j) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
            } else {
                a6 = d0.a(collection.size());
                return j(iterable, new LinkedHashMap(a6));
            }
        }
        return f(j(iterable, new LinkedHashMap()));
    }

    public static final Map j(Iterable iterable, Map map) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        kotlin.jvm.internal.l.d(map, "destination");
        g(map, iterable);
        return map;
    }

    public static Map k(Map map) {
        Map d6;
        Map l6;
        kotlin.jvm.internal.l.d(map, "<this>");
        int size = map.size();
        if (size == 0) {
            d6 = d();
            return d6;
        } else if (size != 1) {
            l6 = l(map);
            return l6;
        } else {
            return d0.c(map);
        }
    }

    public static Map l(Map map) {
        kotlin.jvm.internal.l.d(map, "<this>");
        return new LinkedHashMap(map);
    }
}
