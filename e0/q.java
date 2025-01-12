package e0;

import android.view.View;
import android.view.ViewParent;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f9355a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f9356b;

    /* renamed from: c  reason: collision with root package name */
    private final View f9357c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9358d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f9359e;

    public q(View view) {
        this.f9357c = view;
    }

    private boolean g(int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2) {
        ViewParent h6;
        int i11;
        int i12;
        int[] iArr3;
        if (!l() || (h6 = h(i10)) == null) {
            return false;
        }
        if (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f9357c.getLocationInWindow(iArr);
            i11 = iArr[0];
            i12 = iArr[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr2 == null) {
            int[] i13 = i();
            i13[0] = 0;
            i13[1] = 0;
            iArr3 = i13;
        } else {
            iArr3 = iArr2;
        }
        q0.d(h6, this.f9357c, i6, i7, i8, i9, i10, iArr3);
        if (iArr != null) {
            this.f9357c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i11;
            iArr[1] = iArr[1] - i12;
        }
        return true;
    }

    private ViewParent h(int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                return null;
            }
            return this.f9356b;
        }
        return this.f9355a;
    }

    private int[] i() {
        if (this.f9359e == null) {
            this.f9359e = new int[2];
        }
        return this.f9359e;
    }

    private void n(int i6, ViewParent viewParent) {
        if (i6 == 0) {
            this.f9355a = viewParent;
        } else if (i6 != 1) {
        } else {
            this.f9356b = viewParent;
        }
    }

    public boolean a(float f6, float f7, boolean z5) {
        ViewParent h6;
        if (!l() || (h6 = h(0)) == null) {
            return false;
        }
        return q0.a(h6, this.f9357c, f6, f7, z5);
    }

    public boolean b(float f6, float f7) {
        ViewParent h6;
        if (!l() || (h6 = h(0)) == null) {
            return false;
        }
        return q0.b(h6, this.f9357c, f6, f7);
    }

    public boolean c(int i6, int i7, int[] iArr, int[] iArr2) {
        return d(i6, i7, iArr, iArr2, 0);
    }

    public boolean d(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        ViewParent h6;
        int i9;
        int i10;
        if (!l() || (h6 = h(i8)) == null) {
            return false;
        }
        if (i6 == 0 && i7 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f9357c.getLocationInWindow(iArr2);
            i9 = iArr2[0];
            i10 = iArr2[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr == null) {
            iArr = i();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        q0.c(h6, this.f9357c, i6, i7, iArr, i8);
        if (iArr2 != null) {
            this.f9357c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i9;
            iArr2[1] = iArr2[1] - i10;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2) {
        g(i6, i7, i8, i9, iArr, i10, iArr2);
    }

    public boolean f(int i6, int i7, int i8, int i9, int[] iArr) {
        return g(i6, i7, i8, i9, iArr, 0, null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i6) {
        return h(i6) != null;
    }

    public boolean l() {
        return this.f9358d;
    }

    public void m(boolean z5) {
        if (this.f9358d) {
            b0.C0(this.f9357c);
        }
        this.f9358d = z5;
    }

    public boolean o(int i6) {
        return p(i6, 0);
    }

    public boolean p(int i6, int i7) {
        if (k(i7)) {
            return true;
        }
        if (l()) {
            View view = this.f9357c;
            for (ViewParent parent = this.f9357c.getParent(); parent != null; parent = parent.getParent()) {
                if (q0.f(parent, view, this.f9357c, i6, i7)) {
                    n(i7, parent);
                    q0.e(parent, view, this.f9357c, i6, i7);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i6) {
        ViewParent h6 = h(i6);
        if (h6 != null) {
            q0.g(h6, this.f9357c, i6);
            n(i6, null);
        }
    }
}
