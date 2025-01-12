package androidx.fragment.app;

import androidx.lifecycle.c;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: b  reason: collision with root package name */
    int f1865b;

    /* renamed from: c  reason: collision with root package name */
    int f1866c;

    /* renamed from: d  reason: collision with root package name */
    int f1867d;

    /* renamed from: e  reason: collision with root package name */
    int f1868e;

    /* renamed from: f  reason: collision with root package name */
    int f1869f;

    /* renamed from: g  reason: collision with root package name */
    int f1870g;

    /* renamed from: h  reason: collision with root package name */
    boolean f1871h;

    /* renamed from: j  reason: collision with root package name */
    String f1873j;

    /* renamed from: k  reason: collision with root package name */
    int f1874k;

    /* renamed from: l  reason: collision with root package name */
    CharSequence f1875l;

    /* renamed from: m  reason: collision with root package name */
    int f1876m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f1877n;

    /* renamed from: o  reason: collision with root package name */
    ArrayList f1878o;

    /* renamed from: p  reason: collision with root package name */
    ArrayList f1879p;

    /* renamed from: r  reason: collision with root package name */
    ArrayList f1881r;

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1864a = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    boolean f1872i = true;

    /* renamed from: q  reason: collision with root package name */
    boolean f1880q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f1882a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f1883b;

        /* renamed from: c  reason: collision with root package name */
        int f1884c;

        /* renamed from: d  reason: collision with root package name */
        int f1885d;

        /* renamed from: e  reason: collision with root package name */
        int f1886e;

        /* renamed from: f  reason: collision with root package name */
        int f1887f;

        /* renamed from: g  reason: collision with root package name */
        c.b f1888g;

        /* renamed from: h  reason: collision with root package name */
        c.b f1889h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i6, Fragment fragment) {
            this.f1882a = i6;
            this.f1883b = fragment;
            c.b bVar = c.b.RESUMED;
            this.f1888g = bVar;
            this.f1889h = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f1864a.add(aVar);
        aVar.f1884c = this.f1865b;
        aVar.f1885d = this.f1866c;
        aVar.f1886e = this.f1867d;
        aVar.f1887f = this.f1868e;
    }

    public abstract int c();

    public abstract int d();

    public abstract void e();

    public l f() {
        if (this.f1871h) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1872i = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i6, Fragment fragment, String str, int i7) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.f1713y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f1713y + " now " + str);
            }
            fragment.f1713y = str;
        }
        if (i6 != 0) {
            if (i6 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i8 = fragment.f1711w;
            if (i8 != 0 && i8 != i6) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f1711w + " now " + i6);
            }
            fragment.f1711w = i6;
            fragment.f1712x = i6;
        }
        b(new a(i7, fragment));
    }

    public l h(Fragment fragment) {
        b(new a(3, fragment));
        return this;
    }

    public l i(int i6, Fragment fragment) {
        return j(i6, fragment, null);
    }

    public l j(int i6, Fragment fragment, String str) {
        if (i6 != 0) {
            g(i6, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
}
