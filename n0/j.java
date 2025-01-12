package n0;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
/* loaded from: classes.dex */
class j implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private Rect f12105a;

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Rect evaluate(float f6, Rect rect, Rect rect2) {
        int i6 = rect.left;
        int i7 = i6 + ((int) ((rect2.left - i6) * f6));
        int i8 = rect.top;
        int i9 = i8 + ((int) ((rect2.top - i8) * f6));
        int i10 = rect.right;
        int i11 = i10 + ((int) ((rect2.right - i10) * f6));
        int i12 = rect.bottom;
        int i13 = i12 + ((int) ((rect2.bottom - i12) * f6));
        Rect rect3 = this.f12105a;
        if (rect3 == null) {
            return new Rect(i7, i9, i11, i13);
        }
        rect3.set(i7, i9, i11, i13);
        return this.f12105a;
    }
}
