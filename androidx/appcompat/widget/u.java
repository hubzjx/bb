package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* loaded from: classes.dex */
public class u extends SeekBar {

    /* renamed from: b  reason: collision with root package name */
    private final v f1077b;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1077b.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1077b.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1077b.g(canvas);
    }

    public u(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        y1.a(this, getContext());
        v vVar = new v(this);
        this.f1077b = vVar;
        vVar.c(attributeSet, i6);
    }
}
