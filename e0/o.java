package e0;

import android.view.MotionEvent;
/* loaded from: classes.dex */
public abstract class o {
    public static boolean a(MotionEvent motionEvent, int i6) {
        return (motionEvent.getSource() & i6) == i6;
    }
}
