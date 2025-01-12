package w0;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.o;
/* loaded from: classes.dex */
public abstract class l extends o {

    /* renamed from: d  reason: collision with root package name */
    private m f13730d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView.ScaleType f13731e;

    public l(Context context) {
        this(context, null);
    }

    private void c() {
        this.f13730d = new m(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f13731e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f13731e = null;
        }
    }

    public m getAttacher() {
        return this.f13730d;
    }

    public RectF getDisplayRect() {
        return this.f13730d.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f13730d.E();
    }

    public float getMaximumScale() {
        return this.f13730d.H();
    }

    public float getMediumScale() {
        return this.f13730d.I();
    }

    public float getMinimumScale() {
        return this.f13730d.J();
    }

    public float getScale() {
        return this.f13730d.K();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f13730d.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z5) {
        this.f13730d.O(z5);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i6, int i7, int i8, int i9) {
        boolean frame = super.setFrame(i6, i7, i8, i9);
        if (frame) {
            this.f13730d.l0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.o, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.f13730d;
        if (mVar != null) {
            mVar.l0();
        }
    }

    @Override // androidx.appcompat.widget.o, android.widget.ImageView
    public void setImageResource(int i6) {
        super.setImageResource(i6);
        m mVar = this.f13730d;
        if (mVar != null) {
            mVar.l0();
        }
    }

    @Override // androidx.appcompat.widget.o, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.f13730d;
        if (mVar != null) {
            mVar.l0();
        }
    }

    public void setMaximumScale(float f6) {
        this.f13730d.Q(f6);
    }

    public void setMediumScale(float f6) {
        this.f13730d.R(f6);
    }

    public void setMinimumScale(float f6) {
        this.f13730d.S(f6);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f13730d.T(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f13730d.U(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f13730d.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(e eVar) {
        this.f13730d.W(eVar);
    }

    public void setOnOutsidePhotoTapListener(f fVar) {
        this.f13730d.X(fVar);
    }

    public void setOnPhotoTapListener(g gVar) {
        this.f13730d.Y(gVar);
    }

    public void setOnScaleChangeListener(h hVar) {
        this.f13730d.Z(hVar);
    }

    public void setOnSingleFlingListener(i iVar) {
        this.f13730d.a0(iVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.f13730d.b0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.f13730d.c0(kVar);
    }

    public void setRotationBy(float f6) {
        this.f13730d.d0(f6);
    }

    public void setRotationTo(float f6) {
        this.f13730d.e0(f6);
    }

    public void setScale(float f6) {
        this.f13730d.f0(f6);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        m mVar = this.f13730d;
        if (mVar == null) {
            this.f13731e = scaleType;
        } else {
            mVar.i0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i6) {
        this.f13730d.j0(i6);
    }

    public void setZoomable(boolean z5) {
        this.f13730d.k0(z5);
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        c();
    }
}
