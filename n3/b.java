package n3;

import com.google.gson.internal.e;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f12252a;

    static {
        f12252a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f12252a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
