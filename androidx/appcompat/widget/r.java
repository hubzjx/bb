package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class r {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1056c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    private final ProgressBar f1057a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f1058b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ProgressBar progressBar) {
        this.f1057a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable d(Drawable drawable, boolean z5) {
        if (drawable instanceof x.f) {
            x.f fVar = (x.f) drawable;
            Drawable b6 = fVar.b();
            if (b6 != null) {
                fVar.a(d(b6, z5));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i6 = 0; i6 < numberOfLayers; i6++) {
                int id = layerDrawable.getId(i6);
                drawableArr[i6] = d(layerDrawable.getDrawable(i6), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i7 = 0; i7 < numberOfLayers; i7++) {
                layerDrawable2.setId(i7, layerDrawable.getId(i7));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1058b == null) {
                this.f1058b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(a());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z5 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable e(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i6 = 0; i6 < numberOfFrames; i6++) {
                Drawable d6 = d(animationDrawable.getFrame(i6), true);
                d6.setLevel(10000);
                animationDrawable2.addFrame(d6, animationDrawable.getDuration(i6));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b() {
        return this.f1058b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i6) {
        c2 v5 = c2.v(this.f1057a.getContext(), attributeSet, f1056c, i6, 0);
        Drawable h6 = v5.h(0);
        if (h6 != null) {
            this.f1057a.setIndeterminateDrawable(e(h6));
        }
        Drawable h7 = v5.h(1);
        if (h7 != null) {
            this.f1057a.setProgressDrawable(d(h7, false));
        }
        v5.w();
    }
}
