package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
abstract class g extends Drawable implements Drawable.Callback, f, e {

    /* renamed from: h  reason: collision with root package name */
    static final PorterDuff.Mode f14147h = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private int f14148b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f14149c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14150d;

    /* renamed from: e  reason: collision with root package name */
    i f14151e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14152f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f14153g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Drawable drawable) {
        this.f14151e = d();
        a(drawable);
    }

    private i d() {
        return new i(this.f14151e);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        i iVar = this.f14151e;
        if (iVar == null || (constantState = iVar.f14156b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (c()) {
            i iVar = this.f14151e;
            ColorStateList colorStateList = iVar.f14157c;
            PorterDuff.Mode mode = iVar.f14158d;
            if (colorStateList == null || mode == null) {
                this.f14150d = false;
                clearColorFilter();
            } else {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f14150d || colorForState != this.f14148b || mode != this.f14149c) {
                    setColorFilter(colorForState, mode);
                    this.f14148b = colorForState;
                    this.f14149c = mode;
                    this.f14150d = true;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // x.f
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f14153g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f14153g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i iVar = this.f14151e;
            if (iVar != null) {
                iVar.f14156b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // x.f
    public final Drawable b() {
        return this.f14153g;
    }

    protected abstract boolean c();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f14153g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i iVar = this.f14151e;
        return changingConfigurations | (iVar != null ? iVar.getChangingConfigurations() : 0) | this.f14153g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        i iVar = this.f14151e;
        if (iVar == null || !iVar.a()) {
            return null;
        }
        this.f14151e.f14155a = getChangingConfigurations();
        return this.f14151e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f14153g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14153g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14153g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return b.f(this.f14153g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f14153g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f14153g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f14153g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f14153g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f14153g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f14153g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return b.h(this.f14153g);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        i iVar;
        ColorStateList colorStateList = (!c() || (iVar = this.f14151e) == null) ? null : iVar.f14157c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f14153g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f14153g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f14152f && super.mutate() == this) {
            this.f14151e = d();
            Drawable drawable = this.f14153g;
            if (drawable != null) {
                drawable.mutate();
            }
            i iVar = this.f14151e;
            if (iVar != null) {
                Drawable drawable2 = this.f14153g;
                iVar.f14156b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f14152f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f14153g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i6) {
        return b.m(this.f14153g, i6);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i6) {
        return this.f14153g.setLevel(i6);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
        scheduleSelf(runnable, j6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f14153g.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        b.j(this.f14153g, z5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i6) {
        this.f14153g.setChangingConfigurations(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14153g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z5) {
        this.f14153g.setDither(z5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        this.f14153g.setFilterBitmap(z5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f14153g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i6) {
        setTintList(ColorStateList.valueOf(i6));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f14151e.f14157c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f14151e.f14158d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        return super.setVisible(z5, z6) || this.f14153g.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(i iVar, Resources resources) {
        this.f14151e = iVar;
        e(resources);
    }
}
