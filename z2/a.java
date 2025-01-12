package z2;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    private final Dialog f14351b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14352c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14353d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14354e;

    public a(Dialog dialog, Rect rect) {
        this.f14351b = dialog;
        this.f14352c = rect.left;
        this.f14353d = rect.top;
        this.f14354e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f14352c + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f14353d + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i6 = this.f14354e;
            obtain.setLocation((-i6) - 1, (-i6) - 1);
        }
        view.performClick();
        return this.f14351b.onTouchEvent(obtain);
    }
}
