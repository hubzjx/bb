package n0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
/* loaded from: classes.dex */
class y implements z {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f12182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(View view) {
        this.f12182a = view.getOverlay();
    }

    @Override // n0.z
    public void b(Drawable drawable) {
        this.f12182a.add(drawable);
    }

    @Override // n0.z
    public void d(Drawable drawable) {
        this.f12182a.remove(drawable);
    }
}
