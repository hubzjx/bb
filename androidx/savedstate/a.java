package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.c;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f2538a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f2539b = new SavedStateRegistry();

    private a(b bVar) {
        this.f2538a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f2539b;
    }

    public void c(Bundle bundle) {
        c h6 = this.f2538a.h();
        if (h6.b() != c.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        h6.a(new Recreator(this.f2538a));
        this.f2539b.b(h6, bundle);
    }

    public void d(Bundle bundle) {
        this.f2539b.c(bundle);
    }
}
