package f3;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9883a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9884b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f9885c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f9886d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f9887e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f9888f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f9889g = {16842913, 16843623, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f9890h = {16842913, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f9891i = {16842913, 16843623};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f9892j = {16842913};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f9893k = {16842910, 16842919};

    /* renamed from: l  reason: collision with root package name */
    static final String f9894l = b.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 22 && i6 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f9893k, 0)) != 0) {
                Log.w(f9894l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean b(int[] iArr) {
        boolean z5 = false;
        boolean z6 = false;
        for (int i6 : iArr) {
            if (i6 == 16842910) {
                z5 = true;
            } else if (i6 == 16842908 || i6 == 16842919 || i6 == 16843623) {
                z6 = true;
            }
        }
        return z5 && z6;
    }
}
