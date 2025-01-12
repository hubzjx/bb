package io.jsonwebtoken.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
/* loaded from: classes.dex */
public final class Collections {

    /* loaded from: classes.dex */
    private static class EnumerationIterator<E> implements Iterator<E> {
        private Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration) {
            this.enumeration = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.enumeration.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private Collections() {
    }

    public static List arrayToList(Object obj) {
        return java.util.Arrays.asList(Objects.toObjectArray(obj));
    }

    public static boolean contains(Enumeration enumeration, Object obj) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                if (Objects.nullSafeEquals(enumeration.nextElement(), obj)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean containsAny(Collection collection, Collection collection2) {
        if (!isEmpty(collection) && !isEmpty(collection2)) {
            for (Object obj : collection2) {
                if (collection.contains(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsInstance(Collection collection, Object obj) {
        if (collection != null) {
            for (Object obj2 : collection) {
                if (obj2 == obj) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static Class<?> findCommonElementType(Collection collection) {
        if (isEmpty(collection)) {
            return null;
        }
        Class<?> cls = null;
        for (Object obj : collection) {
            if (obj != null) {
                if (cls == null) {
                    cls = obj.getClass();
                } else if (cls != obj.getClass()) {
                    return null;
                }
            }
        }
        return cls;
    }

    public static Object findFirstMatch(Collection collection, Collection collection2) {
        if (!isEmpty(collection) && !isEmpty(collection2)) {
            for (Object obj : collection2) {
                if (collection.contains(obj)) {
                    return obj;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T findValueOfType(Collection<?> collection, Class<T> cls) {
        if (isEmpty(collection)) {
            return null;
        }
        T t5 = null;
        for (Object obj : collection) {
            if (cls == null || cls.isInstance(obj)) {
                if (t5 != null) {
                    return null;
                }
                t5 = obj;
            }
        }
        return t5;
    }

    public static boolean hasUniqueObject(Collection collection) {
        if (isEmpty(collection)) {
            return false;
        }
        Object obj = null;
        boolean z5 = false;
        for (Object obj2 : collection) {
            if (!z5) {
                obj = obj2;
                z5 = true;
            } else if (obj != obj2) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static void mergeArrayIntoCollection(Object obj, Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        for (Object obj2 : Objects.toObjectArray(obj)) {
            collection.add(obj2);
        }
    }

    public static void mergePropertiesIntoMap(Properties properties, Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        if (properties != null) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                Object property = properties.getProperty(str);
                if (property == null) {
                    property = properties.get(str);
                }
                map.put(str, property);
            }
        }
    }

    public static int size(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] aArr) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return (A[]) arrayList.toArray(aArr);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new EnumerationIterator(enumeration);
    }

    public static boolean contains(Iterator it, Object obj) {
        if (it != null) {
            while (it.hasNext()) {
                if (Objects.nullSafeEquals(it.next(), obj)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] clsArr) {
        if (!isEmpty(collection) && !Objects.isEmpty(clsArr)) {
            for (Class<?> cls : clsArr) {
                Object findValueOfType = findValueOfType(collection, cls);
                if (findValueOfType != null) {
                    return findValueOfType;
                }
            }
        }
        return null;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static int size(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
