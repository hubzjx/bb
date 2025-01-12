package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
abstract class f extends Drawable implements x.e {

    /* renamed from: b  reason: collision with root package name */
    Drawable f2567b;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getState() : super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.i(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i6) {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.setLevel(i6) : super.onLevelChange(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setChangingConfigurations(i6);
        } else {
            super.setChangingConfigurations(i6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i6, PorterDuff.Mode mode) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setColorFilter(i6, mode);
        } else {
            super.setColorFilter(i6, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setFilterBitmap(z5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f6, float f7) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.k(drawable, f6, f7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i6, int i7, int i8, int i9) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.l(drawable, i6, i7, i8, i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
