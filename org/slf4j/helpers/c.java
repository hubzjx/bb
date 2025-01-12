package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class c {
    public static final a a(String str, Object[] objArr) {
        Throwable i6 = i(objArr);
        if (i6 != null) {
            objArr = q(objArr);
        }
        return b(str, objArr, i6);
    }

    public static final a b(String str, Object[] objArr, Throwable th) {
        Object obj;
        HashMap hashMap;
        int i6;
        if (str == null) {
            return new a(null, objArr, th);
        }
        if (objArr == null) {
            return new a(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i7 = 0;
        int i8 = 0;
        while (i7 < objArr.length) {
            int indexOf = str.indexOf("{}", i8);
            if (indexOf == -1) {
                if (i8 == 0) {
                    return new a(str, objArr, th);
                }
                sb.append((CharSequence) str, i8, str.length());
                return new a(sb.toString(), objArr, th);
            }
            if (!l(str, indexOf)) {
                sb.append((CharSequence) str, i8, indexOf);
                obj = objArr[i7];
                hashMap = new HashMap();
            } else if (k(str, indexOf)) {
                sb.append((CharSequence) str, i8, indexOf - 1);
                obj = objArr[i7];
                hashMap = new HashMap();
            } else {
                i7--;
                sb.append((CharSequence) str, i8, indexOf - 1);
                sb.append('{');
                i6 = indexOf + 1;
                i8 = i6;
                i7++;
            }
            f(sb, obj, hashMap);
            i6 = indexOf + 2;
            i8 = i6;
            i7++;
        }
        sb.append((CharSequence) str, i8, str.length());
        return new a(sb.toString(), objArr, th);
    }

    private static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(zArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append((int) bArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(cArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void f(StringBuilder sb, Object obj, Map map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            o(sb, obj);
        } else if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            e(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            p(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            j(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            m(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            n(sb, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(dArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(fArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final Throwable i(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void j(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(iArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final boolean k(String str, int i6) {
        return i6 >= 2 && str.charAt(i6 - 2) == '\\';
    }

    static final boolean l(String str, int i6) {
        return i6 != 0 && str.charAt(i6 - 1) == '\\';
    }

    private static void m(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(jArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void n(StringBuilder sb, Object[] objArr, Map map) {
        sb.append('[');
        if (map.containsKey(objArr)) {
            sb.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                f(sb, objArr[i6], map);
                if (i6 != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        }
        sb.append(']');
    }

    private static void o(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            i.b("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    private static void p(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append((int) sArr[i6]);
            if (i6 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static Object[] q(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }
}
