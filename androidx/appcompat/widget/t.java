package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
/* loaded from: classes.dex */
public class t extends RatingBar {

    /* renamed from: b  reason: collision with root package name */
    private final r f1066b;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        Bitmap b6 = this.f1066b.b();
        if (b6 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b6.getWidth() * getNumStars(), i6, 0), getMeasuredHeight());
        }
    }

    public t(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        y1.a(this, getContext());
        r rVar = new r(this);
        this.f1066b = rVar;
        rVar.c(attributeSet, i6);
    }
}
