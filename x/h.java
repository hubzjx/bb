package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: i  reason: collision with root package name */
    private static Method f14154i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f14154i == null) {
            try {
                f14154i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e6) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e6);
            }
        }
    }

    @Override // x.g
    protected boolean c() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.f14153g;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f14153g.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f14153g.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f14153g;
        if (drawable != null && (method = f14154i) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e6) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e6);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f6, float f7) {
        this.f14153g.setHotspot(f6, f7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i6, int i7, int i8, int i9) {
        this.f14153g.setHotspotBounds(i6, i7, i8, i9);
    }

    @Override // x.g, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // x.g, android.graphics.drawable.Drawable
    public void setTint(int i6) {
        if (c()) {
            super.setTint(i6);
        } else {
            this.f14153g.setTint(i6);
        }
    }

    @Override // x.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f14153g.setTintList(colorStateList);
        }
    }

    @Override // x.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f14153g.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, Resources resources) {
        super(iVar, resources);
        g();
    }
}
