package e3;

import android.graphics.Typeface;
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f9485a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0160a f9486b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9487c;

    /* renamed from: e3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0160a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0160a interfaceC0160a, Typeface typeface) {
        this.f9485a = typeface;
        this.f9486b = interfaceC0160a;
    }

    private void d(Typeface typeface) {
        if (this.f9487c) {
            return;
        }
        this.f9486b.a(typeface);
    }

    @Override // e3.f
    public void a(int i6) {
        d(this.f9485a);
    }

    @Override // e3.f
    public void b(Typeface typeface, boolean z5) {
        d(typeface);
    }

    public void c() {
        this.f9487c = true;
    }
}
