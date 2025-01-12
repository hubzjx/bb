package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class b2 extends u1 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference f832b;

    public b2(Context context, Resources resources) {
        super(resources);
        this.f832b = new WeakReference(context);
    }

    @Override // androidx.appcompat.widget.u1, android.content.res.Resources
    public Drawable getDrawable(int i6) {
        Drawable drawable = super.getDrawable(i6);
        Context context = (Context) this.f832b.get();
        if (drawable != null && context != null) {
            t1.h().x(context, i6, drawable);
        }
        return drawable;
    }
}
