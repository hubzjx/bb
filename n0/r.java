package n0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/* loaded from: classes.dex */
abstract class r {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f12170a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f12171b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f12172c;

    static {
        int i6 = Build.VERSION.SDK_INT;
        f12170a = true;
        f12171b = true;
        f12172c = i6 >= 28;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        a0.i(view, matrix);
        a0.j(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b6 = b(view, matrix, rectF, viewGroup);
        if (b6 != null) {
            imageView.setImageBitmap(b6);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z5;
        boolean z6;
        boolean z7;
        ViewGroup viewGroup2;
        int i6;
        int round;
        int round2;
        if (f12170a) {
            z5 = !view.isAttachedToWindow();
            if (viewGroup != null) {
                z6 = viewGroup.isAttachedToWindow();
                z7 = f12171b;
                Bitmap bitmap = null;
                if (z7 || !z5) {
                    viewGroup2 = null;
                    i6 = 0;
                } else if (!z6) {
                    return null;
                } else {
                    viewGroup2 = (ViewGroup) view.getParent();
                    i6 = viewGroup2.indexOfChild(view);
                    viewGroup.getOverlay().add(view);
                }
                round = Math.round(rectF.width());
                round2 = Math.round(rectF.height());
                if (round > 0 && round2 > 0) {
                    float min = Math.min(1.0f, 1048576.0f / (round * round2));
                    int round3 = Math.round(round * min);
                    int round4 = Math.round(round2 * min);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(min, min);
                    if (f12172c) {
                        bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.concat(matrix);
                        view.draw(canvas);
                    } else {
                        Picture picture = new Picture();
                        Canvas beginRecording = picture.beginRecording(round3, round4);
                        beginRecording.concat(matrix);
                        view.draw(beginRecording);
                        picture.endRecording();
                        bitmap = Bitmap.createBitmap(picture);
                    }
                }
                if (z7 && z5) {
                    viewGroup.getOverlay().remove(view);
                    viewGroup2.addView(view, i6);
                }
                return bitmap;
            }
        } else {
            z5 = false;
        }
        z6 = false;
        z7 = f12171b;
        Bitmap bitmap2 = null;
        if (z7) {
        }
        viewGroup2 = null;
        i6 = 0;
        round = Math.round(rectF.width());
        round2 = Math.round(rectF.height());
        if (round > 0) {
            float min2 = Math.min(1.0f, 1048576.0f / (round * round2));
            int round32 = Math.round(round * min2);
            int round42 = Math.round(round2 * min2);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min2, min2);
            if (f12172c) {
            }
        }
        if (z7) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i6);
        }
        return bitmap2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
