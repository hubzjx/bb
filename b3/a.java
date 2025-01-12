package b3;

import android.content.Context;
import android.graphics.Color;
import e3.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3017a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3018b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3019c;

    /* renamed from: d  reason: collision with root package name */
    private final float f3020d;

    public a(Context context) {
        this.f3017a = b.b(context, u2.a.elevationOverlayEnabled, false);
        this.f3018b = y2.a.a(context, u2.a.elevationOverlayColor, 0);
        this.f3019c = y2.a.a(context, u2.a.colorSurface, 0);
        this.f3020d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i6) {
        return w.a.h(i6, 255) == this.f3019c;
    }

    public float a(float f6) {
        float f7 = this.f3020d;
        if (f7 <= 0.0f || f6 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f6 / f7)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i6, float f6) {
        float a6 = a(f6);
        return w.a.h(y2.a.g(w.a.h(i6, 255), this.f3018b, a6), Color.alpha(i6));
    }

    public int c(int i6, float f6) {
        return (this.f3017a && e(i6)) ? b(i6, f6) : i6;
    }

    public boolean d() {
        return this.f3017a;
    }
}
