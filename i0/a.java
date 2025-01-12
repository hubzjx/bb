package i0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import e0.b0;
import e0.q0;
import f0.a0;
import f0.y;
import f0.z;
import i0.b;
import java.util.ArrayList;
import java.util.List;
import l.h;
import okhttp3.dnsoverhttps.DnsOverHttps;
/* loaded from: classes.dex */
public abstract class a extends e0.a {

    /* renamed from: n  reason: collision with root package name */
    private static final Rect f10828n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o  reason: collision with root package name */
    private static final b.a f10829o = new C0175a();

    /* renamed from: p  reason: collision with root package name */
    private static final b.InterfaceC0176b f10830p = new b();

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f10835h;

    /* renamed from: i  reason: collision with root package name */
    private final View f10836i;

    /* renamed from: j  reason: collision with root package name */
    private c f10837j;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10831d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f10832e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f10833f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f10834g = new int[2];

    /* renamed from: k  reason: collision with root package name */
    int f10838k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    int f10839l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private int f10840m = Integer.MIN_VALUE;

    /* renamed from: i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0175a implements b.a {
        C0175a() {
        }

        @Override // i0.b.a
        /* renamed from: b */
        public void a(y yVar, Rect rect) {
            yVar.l(rect);
        }
    }

    /* loaded from: classes.dex */
    static class b implements b.InterfaceC0176b {
        b() {
        }

        @Override // i0.b.InterfaceC0176b
        /* renamed from: c */
        public y a(h hVar, int i6) {
            return (y) hVar.l(i6);
        }

        @Override // i0.b.InterfaceC0176b
        /* renamed from: d */
        public int b(h hVar) {
            return hVar.k();
        }
    }

    /* loaded from: classes.dex */
    private class c extends z {
        c() {
        }

        @Override // f0.z
        public y b(int i6) {
            return y.M(a.this.H(i6));
        }

        @Override // f0.z
        public y d(int i6) {
            int i7 = i6 == 2 ? a.this.f10838k : a.this.f10839l;
            if (i7 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i7);
        }

        @Override // f0.z
        public boolean f(int i6, int i7, Bundle bundle) {
            return a.this.P(i6, i7, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f10836i = view;
        this.f10835h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (b0.z(view) == 0) {
            b0.u0(view, 1);
        }
    }

    private static Rect D(View view, int i6, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i6 == 17) {
            rect.set(width, 0, width, height);
        } else if (i6 == 33) {
            rect.set(0, height, width, height);
        } else if (i6 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i6 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f10836i.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.f10836i;
        do {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    private static int F(int i6) {
        if (i6 != 19) {
            if (i6 != 21) {
                return i6 != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean G(int i6, Rect rect) {
        Object d6;
        h y5 = y();
        int i7 = this.f10839l;
        y yVar = i7 == Integer.MIN_VALUE ? null : (y) y5.e(i7);
        if (i6 == 1 || i6 == 2) {
            d6 = i0.b.d(y5, f10830p, f10829o, yVar, i6, b0.B(this.f10836i) == 1, false);
        } else if (i6 != 17 && i6 != 33 && i6 != 66 && i6 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            Rect rect2 = new Rect();
            int i8 = this.f10839l;
            if (i8 != Integer.MIN_VALUE) {
                z(i8, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f10836i, i6, rect2);
            }
            d6 = i0.b.c(y5, f10830p, f10829o, yVar, rect2, i6);
        }
        y yVar2 = (y) d6;
        return T(yVar2 != null ? y5.h(y5.g(yVar2)) : Integer.MIN_VALUE);
    }

    private boolean Q(int i6, int i7, Bundle bundle) {
        return i7 != 1 ? i7 != 2 ? i7 != 64 ? i7 != 128 ? J(i6, i7, bundle) : n(i6) : S(i6) : o(i6) : T(i6);
    }

    private boolean R(int i6, Bundle bundle) {
        return b0.b0(this.f10836i, i6, bundle);
    }

    private boolean S(int i6) {
        int i7;
        if (this.f10835h.isEnabled() && this.f10835h.isTouchExplorationEnabled() && (i7 = this.f10838k) != i6) {
            if (i7 != Integer.MIN_VALUE) {
                n(i7);
            }
            this.f10838k = i6;
            this.f10836i.invalidate();
            U(i6, 32768);
            return true;
        }
        return false;
    }

    private void V(int i6) {
        int i7 = this.f10840m;
        if (i7 == i6) {
            return;
        }
        this.f10840m = i6;
        U(i6, 128);
        U(i7, 256);
    }

    private boolean n(int i6) {
        if (this.f10838k == i6) {
            this.f10838k = Integer.MIN_VALUE;
            this.f10836i.invalidate();
            U(i6, DnsOverHttps.MAX_RESPONSE_SIZE);
            return true;
        }
        return false;
    }

    private boolean p() {
        int i6 = this.f10839l;
        return i6 != Integer.MIN_VALUE && J(i6, 16, null);
    }

    private AccessibilityEvent q(int i6, int i7) {
        return i6 != -1 ? r(i6, i7) : s(i7);
    }

    private AccessibilityEvent r(int i6, int i7) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i7);
        y H = H(i6);
        obtain.getText().add(H.v());
        obtain.setContentDescription(H.q());
        obtain.setScrollable(H.H());
        obtain.setPassword(H.G());
        obtain.setEnabled(H.C());
        obtain.setChecked(H.A());
        L(i6, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(H.o());
        a0.c(obtain, this.f10836i, i6);
        obtain.setPackageName(this.f10836i.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent s(int i6) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i6);
        this.f10836i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private y t(int i6) {
        y K = y.K();
        K.c0(true);
        K.e0(true);
        K.W("android.view.View");
        Rect rect = f10828n;
        K.S(rect);
        K.T(rect);
        K.l0(this.f10836i);
        N(i6, K);
        if (K.v() == null && K.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        K.l(this.f10832e);
        if (this.f10832e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int j6 = K.j();
        if ((j6 & 64) == 0) {
            if ((j6 & 128) == 0) {
                K.j0(this.f10836i.getContext().getPackageName());
                K.q0(this.f10836i, i6);
                if (this.f10838k == i6) {
                    K.Q(true);
                    K.a(128);
                } else {
                    K.Q(false);
                    K.a(64);
                }
                boolean z5 = this.f10839l == i6;
                if (z5) {
                    K.a(2);
                } else if (K.D()) {
                    K.a(1);
                }
                K.f0(z5);
                this.f10836i.getLocationOnScreen(this.f10834g);
                K.m(this.f10831d);
                if (this.f10831d.equals(rect)) {
                    K.l(this.f10831d);
                    if (K.f9734b != -1) {
                        y K2 = y.K();
                        for (int i7 = K.f9734b; i7 != -1; i7 = K2.f9734b) {
                            K2.m0(this.f10836i, -1);
                            K2.S(f10828n);
                            N(i7, K2);
                            K2.l(this.f10832e);
                            Rect rect2 = this.f10831d;
                            Rect rect3 = this.f10832e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        K2.O();
                    }
                    this.f10831d.offset(this.f10834g[0] - this.f10836i.getScrollX(), this.f10834g[1] - this.f10836i.getScrollY());
                }
                if (this.f10836i.getLocalVisibleRect(this.f10833f)) {
                    this.f10833f.offset(this.f10834g[0] - this.f10836i.getScrollX(), this.f10834g[1] - this.f10836i.getScrollY());
                    if (this.f10831d.intersect(this.f10833f)) {
                        K.T(this.f10831d);
                        if (E(this.f10831d)) {
                            K.u0(true);
                        }
                    }
                }
                return K;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    private y u() {
        y L = y.L(this.f10836i);
        b0.Z(this.f10836i, L);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (L.n() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                L.c(this.f10836i, ((Integer) arrayList.get(i6)).intValue());
            }
            return L;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private h y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h hVar = new h();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            hVar.i(i6, t(i6));
        }
        return hVar;
    }

    private void z(int i6, Rect rect) {
        H(i6).l(rect);
    }

    public final int A() {
        return this.f10839l;
    }

    protected abstract int B(float f6, float f7);

    protected abstract void C(List list);

    y H(int i6) {
        return i6 == -1 ? u() : t(i6);
    }

    public final void I(boolean z5, int i6, Rect rect) {
        int i7 = this.f10839l;
        if (i7 != Integer.MIN_VALUE) {
            o(i7);
        }
        if (z5) {
            G(i6, rect);
        }
    }

    protected abstract boolean J(int i6, int i7, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i6, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void M(y yVar);

    protected abstract void N(int i6, y yVar);

    protected abstract void O(int i6, boolean z5);

    boolean P(int i6, int i7, Bundle bundle) {
        return i6 != -1 ? Q(i6, i7, bundle) : R(i7, bundle);
    }

    public final boolean T(int i6) {
        int i7;
        if ((this.f10836i.isFocused() || this.f10836i.requestFocus()) && (i7 = this.f10839l) != i6) {
            if (i7 != Integer.MIN_VALUE) {
                o(i7);
            }
            this.f10839l = i6;
            O(i6, true);
            U(i6, 8);
            return true;
        }
        return false;
    }

    public final boolean U(int i6, int i7) {
        ViewParent parent;
        if (i6 == Integer.MIN_VALUE || !this.f10835h.isEnabled() || (parent = this.f10836i.getParent()) == null) {
            return false;
        }
        return q0.h(parent, this.f10836i, q(i6, i7));
    }

    @Override // e0.a
    public z b(View view) {
        if (this.f10837j == null) {
            this.f10837j = new c();
        }
        return this.f10837j;
    }

    @Override // e0.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // e0.a
    public void g(View view, y yVar) {
        super.g(view, yVar);
        M(yVar);
    }

    public final boolean o(int i6) {
        if (this.f10839l != i6) {
            return false;
        }
        this.f10839l = Integer.MIN_VALUE;
        O(i6, false);
        U(i6, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (this.f10835h.isEnabled() && this.f10835h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int B = B(motionEvent.getX(), motionEvent.getY());
                V(B);
                return B != Integer.MIN_VALUE;
            } else if (action == 10 && this.f10840m != Integer.MIN_VALUE) {
                V(Integer.MIN_VALUE);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i6 = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return G(2, null);
                }
                if (keyEvent.hasModifiers(1)) {
                    return G(1, null);
                }
                return false;
            }
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (keyEvent.hasNoModifiers()) {
                            int F = F(keyCode);
                            int repeatCount = keyEvent.getRepeatCount() + 1;
                            boolean z5 = false;
                            while (i6 < repeatCount && G(F, null)) {
                                i6++;
                                z5 = true;
                            }
                            return z5;
                        }
                        return false;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                p();
                return true;
            }
            return false;
        }
        return false;
    }

    public final int x() {
        return this.f10838k;
    }
}
