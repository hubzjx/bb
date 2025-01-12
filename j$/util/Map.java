package j$.util;

import e.AbstractC0227j$a;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes2.dex */
public interface Map {

    /* renamed from: j$.util.Map$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static Object $default$compute(java.util.Map map, Object obj, BiFunction biFunction) {
            biFunction.getClass();
            Object obj2 = map.get(obj);
            Object p5 = biFunction.p(obj, obj2);
            if (p5 != null) {
                map.put(obj, p5);
                return p5;
            } else if (obj2 != null || map.containsKey(obj)) {
                map.remove(obj);
                return null;
            } else {
                return null;
            }
        }

        public static Object $default$computeIfAbsent(java.util.Map map, Object obj, Function function) {
            Object a6;
            function.getClass();
            Object obj2 = map.get(obj);
            if (obj2 != null || (a6 = function.a(obj)) == null) {
                return obj2;
            }
            map.put(obj, a6);
            return a6;
        }

        public static Object $default$computeIfPresent(java.util.Map map, Object obj, BiFunction biFunction) {
            biFunction.getClass();
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Object p5 = biFunction.p(obj, obj2);
                if (p5 != null) {
                    map.put(obj, p5);
                    return p5;
                }
                map.remove(obj);
            }
            return null;
        }

        public static void $default$forEach(java.util.Map map, BiConsumer biConsumer) {
            biConsumer.getClass();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    biConsumer.n(entry.getKey(), entry.getValue());
                } catch (IllegalStateException e6) {
                    throw new ConcurrentModificationException(e6);
                }
            }
        }

        public static Object $default$merge(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
            biFunction.getClass();
            obj2.getClass();
            Object obj3 = map.get(obj);
            if (obj3 != null) {
                obj2 = biFunction.p(obj3, obj2);
            }
            if (obj2 == null) {
                map.remove(obj);
            } else {
                map.put(obj, obj2);
            }
            return obj2;
        }

        public static Object $default$putIfAbsent(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return obj3 == null ? map.put(obj, obj2) : obj3;
        }

        public static boolean $default$remove(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            if (AbstractC0227j$a.x(obj3, obj2)) {
                if (obj3 != null || map.containsKey(obj)) {
                    map.remove(obj);
                    return true;
                }
                return false;
            }
            return false;
        }

        public static boolean $default$replace(java.util.Map map, Object obj, Object obj2, Object obj3) {
            Object obj4 = map.get(obj);
            if (AbstractC0227j$a.x(obj4, obj2)) {
                if (obj4 != null || map.containsKey(obj)) {
                    map.put(obj, obj3);
                    return true;
                }
                return false;
            }
            return false;
        }

        public static void $default$replaceAll(java.util.Map map, BiFunction biFunction) {
            biFunction.getClass();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    try {
                        entry.setValue(biFunction.p(entry.getKey(), entry.getValue()));
                    } catch (IllegalStateException e6) {
                        throw new ConcurrentModificationException(e6);
                    }
                } catch (IllegalStateException e7) {
                    throw new ConcurrentModificationException(e7);
                }
            }
        }
    }

    Object compute(Object obj, BiFunction biFunction);

    Object computeIfAbsent(Object obj, Function function);

    Object computeIfPresent(Object obj, BiFunction biFunction);

    void forEach(BiConsumer biConsumer);

    Object getOrDefault(Object obj, Object obj2);

    Object merge(Object obj, Object obj2, BiFunction biFunction);

    Object putIfAbsent(Object obj, Object obj2);

    boolean remove(Object obj, Object obj2);

    Object replace(Object obj, Object obj2);

    boolean replace(Object obj, Object obj2, Object obj3);

    void replaceAll(BiFunction biFunction);
}
