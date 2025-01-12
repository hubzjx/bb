package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
/* loaded from: classes.dex */
public class e implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private static final e f2566a = new e();

    public static e a() {
        return f2566a;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f6, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f7 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = pow3 + (f6 * (((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f6), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f7 + (((((intValue2 >> 24) & 255) / 255.0f) - f7) * f6)) * 255.0f) << 24) | (Math.round(((float) Math.pow(pow2 + ((((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f6), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f));
    }
}
