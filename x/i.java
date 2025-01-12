package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f14155a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f14156b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f14157c;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f14158d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(i iVar) {
        this.f14157c = null;
        this.f14158d = g.f14147h;
        if (iVar != null) {
            this.f14155a = iVar.f14155a;
            this.f14156b = iVar.f14156b;
            this.f14157c = iVar.f14157c;
            this.f14158d = iVar.f14158d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f14156b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i6 = this.f14155a;
        Drawable.ConstantState constantState = this.f14156b;
        return i6 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new h(this, resources);
    }
}
