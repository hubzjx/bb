package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.b0;
import f0.b0;
import f0.y;
import i0.c;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b {

    /* renamed from: a  reason: collision with root package name */
    i0.c f4902a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4903b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4905d;

    /* renamed from: c  reason: collision with root package name */
    private float f4904c = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    int f4906e = 2;

    /* renamed from: f  reason: collision with root package name */
    float f4907f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    float f4908g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    float f4909h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    private final c.AbstractC0177c f4910i = new a();

    /* loaded from: classes.dex */
    class a extends c.AbstractC0177c {

        /* renamed from: a  reason: collision with root package name */
        private int f4911a;

        /* renamed from: b  reason: collision with root package name */
        private int f4912b = -1;

        a() {
        }

        private boolean n(View view, float f6) {
            int i6 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
            if (i6 == 0) {
                return Math.abs(view.getLeft() - this.f4911a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f4907f);
            }
            boolean z5 = b0.B(view) == 1;
            int i7 = SwipeDismissBehavior.this.f4906e;
            if (i7 == 2) {
                return true;
            }
            if (i7 == 0) {
                if (z5) {
                    if (f6 >= 0.0f) {
                        return false;
                    }
                } else if (i6 <= 0) {
                    return false;
                }
                return true;
            } else if (i7 == 1) {
                if (z5) {
                    if (i6 <= 0) {
                        return false;
                    }
                } else if (f6 >= 0.0f) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
            r5 = r2.f4911a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (r5 != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
            if (r5 != false) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
            r5 = r2.f4911a - r3.getWidth();
            r3 = r2.f4911a;
         */
        @Override // i0.c.AbstractC0177c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int a(View view, int i6, int i7) {
            int width;
            int width2;
            boolean z5 = b0.B(view) == 1;
            int i8 = SwipeDismissBehavior.this.f4906e;
            if (i8 != 0) {
                if (i8 != 1) {
                    width = this.f4911a - view.getWidth();
                    width2 = view.getWidth() + this.f4911a;
                }
            }
            return SwipeDismissBehavior.G(width, i6, width2);
        }

        @Override // i0.c.AbstractC0177c
        public int b(View view, int i6, int i7) {
            return view.getTop();
        }

        @Override // i0.c.AbstractC0177c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // i0.c.AbstractC0177c
        public void i(View view, int i6) {
            this.f4912b = i6;
            this.f4911a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // i0.c.AbstractC0177c
        public void j(int i6) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // i0.c.AbstractC0177c
        public void k(View view, int i6, int i7, int i8, int i9) {
            float width = this.f4911a + (view.getWidth() * SwipeDismissBehavior.this.f4908g);
            float width2 = this.f4911a + (view.getWidth() * SwipeDismissBehavior.this.f4909h);
            float f6 = i6;
            if (f6 <= width) {
                view.setAlpha(1.0f);
            } else if (f6 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f6), 1.0f));
            }
        }

        @Override // i0.c.AbstractC0177c
        public void l(View view, float f6, float f7) {
            int i6;
            boolean z5;
            this.f4912b = -1;
            int width = view.getWidth();
            if (n(view, f6)) {
                int left = view.getLeft();
                int i7 = this.f4911a;
                i6 = left < i7 ? i7 - width : i7 + width;
                z5 = true;
            } else {
                i6 = this.f4911a;
                z5 = false;
            }
            if (SwipeDismissBehavior.this.f4902a.F(i6, view.getTop())) {
                b0.d0(view, new c(view, z5));
            } else if (z5) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        @Override // i0.c.AbstractC0177c
        public boolean m(View view, int i6) {
            int i7 = this.f4912b;
            return (i7 == -1 || i7 == i6) && SwipeDismissBehavior.this.E(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements f0.b0 {
        b() {
        }

        @Override // f0.b0
        public boolean a(View view, b0.a aVar) {
            boolean z5 = false;
            if (SwipeDismissBehavior.this.E(view)) {
                boolean z6 = e0.b0.B(view) == 1;
                int i6 = SwipeDismissBehavior.this.f4906e;
                if ((i6 == 0 && z6) || (i6 == 1 && !z6)) {
                    z5 = true;
                }
                int width = view.getWidth();
                if (z5) {
                    width = -width;
                }
                e0.b0.W(view, width);
                view.setAlpha(0.0f);
                SwipeDismissBehavior.this.getClass();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f4915a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4916b;

        c(View view, boolean z5) {
            this.f4915a = view;
            this.f4916b = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.c cVar = SwipeDismissBehavior.this.f4902a;
            if (cVar != null && cVar.k(true)) {
                e0.b0.d0(this.f4915a, this);
            } else if (this.f4916b) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    static float F(float f6, float f7, float f8) {
        return Math.min(Math.max(f6, f7), f8);
    }

    static int G(int i6, int i7, int i8) {
        return Math.min(Math.max(i6, i7), i8);
    }

    private void H(ViewGroup viewGroup) {
        if (this.f4902a == null) {
            this.f4902a = this.f4905d ? i0.c.l(viewGroup, this.f4904c, this.f4910i) : i0.c.m(viewGroup, this.f4910i);
        }
    }

    static float I(float f6, float f7, float f8) {
        return (f8 - f6) / (f7 - f6);
    }

    private void M(View view) {
        e0.b0.f0(view, 1048576);
        if (E(view)) {
            e0.b0.h0(view, y.a.f9756y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        i0.c cVar = this.f4902a;
        if (cVar != null) {
            cVar.z(motionEvent);
            return true;
        }
        return false;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f6) {
        this.f4909h = F(0.0f, f6, 1.0f);
    }

    public void K(float f6) {
        this.f4908g = F(0.0f, f6, 1.0f);
    }

    public void L(int i6) {
        this.f4906e = i6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z5 = this.f4903b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z5 = coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f4903b = z5;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4903b = false;
        }
        if (z5) {
            H(coordinatorLayout);
            return this.f4902a.G(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
        boolean l6 = super.l(coordinatorLayout, view, i6);
        if (e0.b0.z(view) == 0) {
            e0.b0.u0(view, 1);
            M(view);
        }
        return l6;
    }
}
