package androidx.lifecycle;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final a f2002a;

    /* renamed from: b  reason: collision with root package name */
    private final o f2003b;

    /* loaded from: classes.dex */
    public interface a {
        m a(Class cls);
    }

    public n(o oVar, a aVar) {
        this.f2002a = aVar;
        this.f2003b = oVar;
    }

    public m a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public m b(String str, Class cls) {
        m b6 = this.f2003b.b(str);
        if (cls.isInstance(b6)) {
            return b6;
        }
        m a6 = this.f2002a.a(cls);
        this.f2003b.c(str, a6);
        return a6;
    }
}
