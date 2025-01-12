package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class o extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private final e f1049b;

    /* renamed from: c  reason: collision with root package name */
    private final n f1050c;

    public o(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1049b;
        if (eVar != null) {
            eVar.b();
        }
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1049b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1049b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        n nVar = this.f1050c;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.f1050c;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1050c.e() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1049b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        e eVar = this.f1049b;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i6) {
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.g(i6);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1049b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1049b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.f1050c;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        e eVar = new e(this);
        this.f1049b = eVar;
        eVar.e(attributeSet, i6);
        n nVar = new n(this);
        this.f1050c = nVar;
        nVar.f(attributeSet, i6);
    }
}
