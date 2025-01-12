package p3;

import com.google.gson.internal.b;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final Class f12633a;

    /* renamed from: b  reason: collision with root package name */
    final Type f12634b;

    /* renamed from: c  reason: collision with root package name */
    final int f12635c;

    a(Type type) {
        Type b6 = b.b((Type) com.google.gson.internal.a.b(type));
        this.f12634b = b6;
        this.f12633a = b.k(b6);
        this.f12635c = b6.hashCode();
    }

    public static a a(Class cls) {
        return new a(cls);
    }

    public static a b(Type type) {
        return new a(type);
    }

    public final Class c() {
        return this.f12633a;
    }

    public final Type d() {
        return this.f12634b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f12634b, ((a) obj).f12634b);
    }

    public final int hashCode() {
        return this.f12635c;
    }

    public final String toString() {
        return b.u(this.f12634b);
    }
}
