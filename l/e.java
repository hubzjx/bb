package l;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap f11372a;

    /* renamed from: b  reason: collision with root package name */
    private int f11373b;

    /* renamed from: c  reason: collision with root package name */
    private int f11374c;

    /* renamed from: d  reason: collision with root package name */
    private int f11375d;

    /* renamed from: e  reason: collision with root package name */
    private int f11376e;

    /* renamed from: f  reason: collision with root package name */
    private int f11377f;

    /* renamed from: g  reason: collision with root package name */
    private int f11378g;

    /* renamed from: h  reason: collision with root package name */
    private int f11379h;

    public e(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f11374c = i6;
        this.f11372a = new LinkedHashMap(0, 0.75f, true);
    }

    private int e(Object obj, Object obj2) {
        int f6 = f(obj, obj2);
        if (f6 >= 0) {
            return f6;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    protected Object a(Object obj) {
        return null;
    }

    protected void b(boolean z5, Object obj, Object obj2, Object obj3) {
    }

    public final Object c(Object obj) {
        Object put;
        if (obj != null) {
            synchronized (this) {
                Object obj2 = this.f11372a.get(obj);
                if (obj2 != null) {
                    this.f11378g++;
                    return obj2;
                }
                this.f11379h++;
                Object a6 = a(obj);
                if (a6 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f11376e++;
                    put = this.f11372a.put(obj, a6);
                    if (put != null) {
                        this.f11372a.put(obj, put);
                    } else {
                        this.f11373b += e(obj, a6);
                    }
                }
                if (put != null) {
                    b(false, obj, a6, put);
                    return put;
                }
                g(this.f11374c);
                return a6;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final Object d(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f11375d++;
            this.f11373b += e(obj, obj2);
            put = this.f11372a.put(obj, obj2);
            if (put != null) {
                this.f11373b -= e(obj, put);
            }
        }
        if (put != null) {
            b(false, obj, put, obj2);
        }
        g(this.f11374c);
        return put;
    }

    protected int f(Object obj, Object obj2) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i6) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.f11373b >= 0 && (!this.f11372a.isEmpty() || this.f11373b == 0)) {
                    if (this.f11373b <= i6 || this.f11372a.isEmpty()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) this.f11372a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f11372a.remove(key);
                    this.f11373b -= e(key, value);
                    this.f11377f++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i6;
        int i7;
        i6 = this.f11378g;
        i7 = this.f11379h + i6;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f11374c), Integer.valueOf(this.f11378g), Integer.valueOf(this.f11379h), Integer.valueOf(i7 != 0 ? (i6 * 100) / i7 : 0));
    }
}
