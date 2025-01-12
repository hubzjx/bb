package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
/* loaded from: classes.dex */
public final class Services {
    private static final List<ClassLoaderAccessor> CLASS_LOADER_ACCESSORS = Collections.arrayToList(new ClassLoaderAccessor[]{new ClassLoaderAccessor() { // from class: io.jsonwebtoken.impl.lang.Services.1
        @Override // io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor
        public ClassLoader getClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }, new ClassLoaderAccessor() { // from class: io.jsonwebtoken.impl.lang.Services.2
        @Override // io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor
        public ClassLoader getClassLoader() {
            return Services.class.getClassLoader();
        }
    }, new ClassLoaderAccessor() { // from class: io.jsonwebtoken.impl.lang.Services.3
        @Override // io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor
        public ClassLoader getClassLoader() {
            return ClassLoader.getSystemClassLoader();
        }
    }});

    /* loaded from: classes.dex */
    private interface ClassLoaderAccessor {
        ClassLoader getClassLoader();
    }

    private Services() {
    }

    public static <T> List<T> loadAll(Class<T> cls) {
        Assert.notNull(cls, "Parameter 'spi' must not be null.");
        for (ClassLoaderAccessor classLoaderAccessor : CLASS_LOADER_ACCESSORS) {
            List loadAll = loadAll(cls, classLoaderAccessor.getClassLoader());
            if (!loadAll.isEmpty()) {
                return java.util.Collections.unmodifiableList(loadAll);
            }
        }
        throw new UnavailableImplementationException(cls);
    }

    public static <T> T loadFirst(Class<T> cls) {
        Assert.notNull(cls, "Parameter 'spi' must not be null.");
        for (ClassLoaderAccessor classLoaderAccessor : CLASS_LOADER_ACCESSORS) {
            T t5 = (T) loadFirst(cls, classLoaderAccessor.getClassLoader());
            if (t5 != null) {
                return t5;
            }
        }
        throw new UnavailableImplementationException(cls);
    }

    private static <T> List<T> loadAll(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        ArrayList arrayList = new ArrayList();
        Iterator it = load.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    private static <T> T loadFirst(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        if (load.iterator().hasNext()) {
            return (T) load.iterator().next();
        }
        return null;
    }
}
