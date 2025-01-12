package f3;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import h3.g;
import h3.k;
import h3.n;
import x.e;
/* loaded from: classes.dex */
public class a extends Drawable implements n, e {

    /* renamed from: b  reason: collision with root package name */
    private b f9880b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        g f9881a;

        /* renamed from: b  reason: collision with root package name */
        boolean f9882b;

        public b(b bVar) {
            this.f9881a = (g) bVar.f9881a.getConstantState().newDrawable();
            this.f9882b = bVar.f9882b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(g gVar) {
            this.f9881a = gVar;
            this.f9882b = false;
        }
    }

    private a(b bVar) {
        this.f9880b = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a */
    public a mutate() {
        this.f9880b = new b(this.f9880b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f9880b;
        if (bVar.f9882b) {
            bVar.f9881a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9880b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f9880b.f9881a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9880b.f9881a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f9880b.f9881a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b6 = f3.b.b(iArr);
        b bVar = this.f9880b;
        if (bVar.f9882b != b6) {
            bVar.f9882b = b6;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f9880b.f9881a.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9880b.f9881a.setColorFilter(colorFilter);
    }

    @Override // h3.n
    public void setShapeAppearanceModel(k kVar) {
        this.f9880b.f9881a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i6) {
        this.f9880b.f9881a.setTint(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f9880b.f9881a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f9880b.f9881a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }
}
