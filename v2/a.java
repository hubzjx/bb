package v2;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f13673a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f13674b = new j0.b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f13675c = new j0.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f13676d = new j0.c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f13677e = new DecelerateInterpolator();

    public static float a(float f6, float f7, float f8) {
        return f6 + (f8 * (f7 - f6));
    }

    public static float b(float f6, float f7, float f8, float f9, float f10) {
        return f10 < f8 ? f6 : f10 > f9 ? f7 : a(f6, f7, (f10 - f8) / (f9 - f8));
    }
}
