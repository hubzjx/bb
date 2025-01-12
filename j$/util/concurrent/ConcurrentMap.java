package j$.util.concurrent;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Map;
/* loaded from: classes2.dex */
public interface ConcurrentMap extends Map {

    /* renamed from: j$.util.concurrent.ConcurrentMap$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static Object $default$compute(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, BiFunction biFunction) {
            biFunction.getClass();
            while (true) {
                Object obj2 = concurrentMap.get(obj);
                while (true) {
                    Object p5 = biFunction.p(obj, obj2);
                    if (p5 == null) {
                        if ((obj2 == null && !concurrentMap.containsKey(obj)) || concurrentMap.remove(obj, obj2)) {
                            return null;
                        }
                    } else if (obj2 == null) {
                        obj2 = concurrentMap.putIfAbsent(obj, p5);
                        if (obj2 == null) {
                            return p5;
                        }
                    } else if (concurrentMap.replace(obj, obj2, p5)) {
                        return p5;
                    }
                }
            }
        }

        public static Object $default$computeIfAbsent(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Function function) {
            Object a6;
            function.getClass();
            Object obj2 = concurrentMap.get(obj);
            return (obj2 == null && (a6 = function.a(obj)) != null && (obj2 = concurrentMap.putIfAbsent(obj, a6)) == null) ? a6 : obj2;
        }

        public static Object $default$computeIfPresent(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, BiFunction biFunction) {
            biFunction.getClass();
            while (true) {
                Object obj2 = concurrentMap.get(obj);
                if (obj2 == null) {
                    return obj2;
                }
                Object p5 = biFunction.p(obj, obj2);
                if (p5 != null) {
                    if (concurrentMap.replace(obj, obj2, p5)) {
                        return p5;
                    }
                } else if (concurrentMap.remove(obj, obj2)) {
                    return null;
                }
            }
        }

        public static void $default$forEach(java.util.concurrent.ConcurrentMap concurrentMap, BiConsumer biConsumer) {
            biConsumer.getClass();
            for (Map.Entry entry : concurrentMap.entrySet()) {
                try {
                    biConsumer.n(entry.getKey(), entry.getValue());
                } catch (IllegalStateException unused) {
                }
            }
        }

        public static Object $default$merge(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Object obj2, BiFunction biFunction) {
            biFunction.getClass();
            obj2.getClass();
            while (true) {
                Object obj3 = concurrentMap.get(obj);
                while (obj3 == null) {
                    obj3 = concurrentMap.putIfAbsent(obj, obj2);
                    if (obj3 == null) {
                        return obj2;
                    }
                }
                Object p5 = biFunction.p(obj3, obj2);
                if (p5 != null) {
                    if (concurrentMap.replace(obj, obj3, p5)) {
                        return p5;
                    }
                } else if (concurrentMap.remove(obj, obj3)) {
                    return null;
                }
            }
        }

        public static void $default$replaceAll(final java.util.concurrent.ConcurrentMap concurrentMap, final BiFunction biFunction) {
            biFunction.getClass();
            BiConsumer biConsumer = new BiConsumer() { // from class: j$.util.concurrent.t
                @Override // j$.util.function.BiConsumer
                public final void n(Object obj, Object obj2) {
                    do {
                        Object p5 = biFunction.p(obj, obj2);
                        java.util.concurrent.ConcurrentMap concurrentMap2 = concurrentMap;
                        if (concurrentMap2.replace(obj, obj2, p5)) {
                            return;
                        }
                        obj2 = concurrentMap2.get(obj);
                    } while (obj2 != null);
                }
            };
            if (concurrentMap instanceof ConcurrentMap) {
                ((ConcurrentMap) concurrentMap).forEach(biConsumer);
            } else {
                $default$forEach(concurrentMap, biConsumer);
            }
        }
    }

    @Override // j$.util.Map
    Object compute(Object obj, BiFunction biFunction);

    @Override // j$.util.Map
    Object computeIfAbsent(Object obj, Function function);

    @Override // j$.util.Map
    Object computeIfPresent(Object obj, BiFunction biFunction);

    @Override // j$.util.Map
    void forEach(BiConsumer biConsumer);

    @Override // java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    Object getOrDefault(Object obj, Object obj2);

    @Override // j$.util.Map
    Object merge(Object obj, Object obj2, BiFunction biFunction);

    @Override // j$.util.Map
    void replaceAll(BiFunction biFunction);
}
