package n0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
/* loaded from: classes.dex */
class u implements v {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f12180a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ViewGroup viewGroup) {
        this.f12180a = viewGroup.getOverlay();
    }

    @Override // n0.v
    public void a(View view) {
        this.f12180a.add(view);
    }

    @Override // n0.z
    public void b(Drawable drawable) {
        this.f12180a.add(drawable);
    }

    @Override // n0.v
    public void c(View view) {
        this.f12180a.remove(view);
    }

    @Override // n0.z
    public void d(Drawable drawable) {
        this.f12180a.remove(drawable);
    }
}
