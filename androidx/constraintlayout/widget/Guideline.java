package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i6) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f1191a = i6;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i6) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f1193b = i6;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f6) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f1195c = f6;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
