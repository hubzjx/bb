package androidx.fragment.app;

import androidx.lifecycle.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements androidx.lifecycle.f {

    /* renamed from: b  reason: collision with root package name */
    private androidx.lifecycle.g f1953b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(c.a aVar) {
        this.f1953b.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f1953b == null) {
            this.f1953b = new androidx.lifecycle.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f1953b != null;
    }

    @Override // androidx.lifecycle.f
    public androidx.lifecycle.c h() {
        d();
        return this.f1953b;
    }
}
