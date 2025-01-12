package w0;

import android.content.Context;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class c extends androidx.viewpager.widget.b {
    public c(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.b, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
