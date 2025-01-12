package io.jsonwebtoken.lang;

import java.util.Collection;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class Assert {
    private Assert() {
    }

    public static void doesNotContain(String str, String str2) {
        doesNotContain(str, str2, "[Assertion failed] - this String argument must not contain the substring [" + str2 + "]");
    }

    public static void hasLength(String str) {
        hasLength(str, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasText(String str) {
        hasText(str, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void isAssignable(Class cls, Class cls2) {
        isAssignable(cls, cls2, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static void isInstanceOf(Class cls, Object obj) {
        isInstanceOf(cls, obj, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static void isNull(Object obj) {
        isNull(obj, "[Assertion failed] - the object argument must be null");
    }

    public static void isTrue(boolean z5) {
        isTrue(z5, "[Assertion failed] - this expression must be true");
    }

    public static void noNullElements(Object[] objArr) {
        noNullElements(objArr, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(Collection collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notNull(Object obj) {
        notNull(obj, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void state(boolean z5) {
        state(z5, "[Assertion failed] - this state invariant must be true");
    }

    public static void doesNotContain(String str, String str2, String str3) {
        if (Strings.hasLength(str) && Strings.hasLength(str2) && str.indexOf(str2) != -1) {
            throw new IllegalArgumentException(str3);
        }
    }

    public static void hasLength(String str, String str2) {
        if (!Strings.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void hasText(String str, String str2) {
        if (!Strings.hasText(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void isAssignable(Class cls, Class cls2, String str) {
        notNull(cls, "Type to check against must not be null");
        if (cls2 == null || !cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(str + cls2 + " is not assignable to " + cls);
        }
    }

    public static void isInstanceOf(Class cls, Object obj, String str) {
        notNull(cls, "Type to check against must not be null");
        if (cls.isInstance(obj)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("Object of class [");
        sb.append(obj != null ? obj.getClass().getName() : "null");
        sb.append("] must be an instance of ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void isNull(Object obj, String str) {
        if (obj != null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void noNullElements(Object[] objArr, String str) {
        if (objArr != null) {
            for (Object obj : objArr) {
                if (obj == null) {
                    throw new IllegalArgumentException(str);
                }
            }
        }
    }

    public static void notEmpty(Collection collection, String str) {
        if (Collections.isEmpty(collection)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void state(boolean z5, String str) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }

    public static void notEmpty(Map map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    public static void notEmpty(Map map, String str) {
        if (Collections.isEmpty(map)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(byte[] bArr, String str) {
        if (Objects.isEmpty(bArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Object[] objArr) {
        notEmpty(objArr, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Object[] objArr, String str) {
        if (Objects.isEmpty(objArr)) {
            throw new IllegalArgumentException(str);
        }
    }
}
