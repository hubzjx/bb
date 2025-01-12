package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class f1 {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f896a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f897b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f898c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private static Class f899d;

    static {
        try {
            f899d = Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean a(Drawable drawable) {
        Drawable drawable2;
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof x.f) {
                drawable2 = ((x.f) drawable).b();
            } else if (drawable instanceof f.d) {
                drawable2 = ((f.d) drawable).a();
            } else if (!(drawable instanceof ScaleDrawable)) {
                return true;
            } else {
                drawable2 = ((ScaleDrawable) drawable).getDrawable();
            }
            return a(drawable2);
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState instanceof DrawableContainer.DrawableContainerState) {
            for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!a(drawable3)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f896a);
        } else {
            drawable.setState(f897b);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode d(int i6, PorterDuff.Mode mode) {
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 9) {
                    switch (i6) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
