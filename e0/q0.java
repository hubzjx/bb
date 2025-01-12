package e0;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public abstract class q0 {
    public static boolean a(ViewParent viewParent, View view, float f6, float f7, boolean z5) {
        try {
            return viewParent.onNestedFling(view, f6, f7, z5);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e6);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f6, float f7) {
        try {
            return viewParent.onNestedPreFling(view, f6, f7);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e6);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i6, int i7, int[] iArr, int i8) {
        if (viewParent instanceof r) {
            ((r) viewParent).j(view, i6, i7, iArr, i8);
        } else if (i8 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i6, i7, iArr);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e6);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        if (viewParent instanceof s) {
            ((s) viewParent).m(view, i6, i7, i8, i9, i10, iArr);
            return;
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (viewParent instanceof r) {
            ((r) viewParent).n(view, i6, i7, i8, i9, i10);
        } else if (i10 == 0) {
            try {
                viewParent.onNestedScroll(view, i6, i7, i8, i9);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e6);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i6, int i7) {
        if (viewParent instanceof r) {
            ((r) viewParent).h(view, view2, i6, i7);
        } else if (i7 == 0) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i6);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e6);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i6, int i7) {
        if (viewParent instanceof r) {
            return ((r) viewParent).o(view, view2, i6, i7);
        }
        if (i7 == 0) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i6);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e6);
                return false;
            }
        }
        return false;
    }

    public static void g(ViewParent viewParent, View view, int i6) {
        if (viewParent instanceof r) {
            ((r) viewParent).i(view, i6);
        } else if (i6 == 0) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e6);
            }
        }
    }

    public static boolean h(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
