package w0;

import android.widget.ImageView;
/* loaded from: classes.dex */
abstract class n {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13771a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f13771a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f6, float f7, float f8) {
        if (f6 >= f7) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f7 >= f8) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i6) {
        return (i6 & 65280) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (a.f13771a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
