package n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import n0.l;
/* loaded from: classes.dex */
public abstract class n0 extends l {
    private static final String[] M = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f12150a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f12151b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f12152c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f12150a = viewGroup;
            this.f12151b = view;
            this.f12152c = view2;
        }

        @Override // n0.m, n0.l.f
        public void a(l lVar) {
            if (this.f12151b.getParent() == null) {
                x.a(this.f12150a).a(this.f12151b);
            } else {
                n0.this.cancel();
            }
        }

        @Override // n0.l.f
        public void b(l lVar) {
            this.f12152c.setTag(i.save_overlay_view, null);
            x.a(this.f12150a).c(this.f12151b);
            lVar.O(this);
        }

        @Override // n0.m, n0.l.f
        public void c(l lVar) {
            x.a(this.f12150a).c(this.f12151b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements l.f {

        /* renamed from: a  reason: collision with root package name */
        private final View f12154a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12155b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f12156c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f12157d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f12158e;

        /* renamed from: f  reason: collision with root package name */
        boolean f12159f = false;

        b(View view, int i6, boolean z5) {
            this.f12154a = view;
            this.f12155b = i6;
            this.f12156c = (ViewGroup) view.getParent();
            this.f12157d = z5;
            g(true);
        }

        private void f() {
            if (!this.f12159f) {
                a0.h(this.f12154a, this.f12155b);
                ViewGroup viewGroup = this.f12156c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z5) {
            ViewGroup viewGroup;
            if (!this.f12157d || this.f12158e == z5 || (viewGroup = this.f12156c) == null) {
                return;
            }
            this.f12158e = z5;
            x.c(viewGroup, z5);
        }

        @Override // n0.l.f
        public void a(l lVar) {
            g(true);
        }

        @Override // n0.l.f
        public void b(l lVar) {
            f();
            lVar.O(this);
        }

        @Override // n0.l.f
        public void c(l lVar) {
            g(false);
        }

        @Override // n0.l.f
        public void d(l lVar) {
        }

        @Override // n0.l.f
        public void e(l lVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12159f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f12159f) {
                return;
            }
            a0.h(this.f12154a, this.f12155b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f12159f) {
                return;
            }
            a0.h(this.f12154a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f12160a;

        /* renamed from: b  reason: collision with root package name */
        boolean f12161b;

        /* renamed from: c  reason: collision with root package name */
        int f12162c;

        /* renamed from: d  reason: collision with root package name */
        int f12163d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f12164e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f12165f;

        c() {
        }
    }

    private void b0(s sVar) {
        sVar.f12173a.put("android:visibility:visibility", Integer.valueOf(sVar.f12174b.getVisibility()));
        sVar.f12173a.put("android:visibility:parent", sVar.f12174b.getParent());
        int[] iArr = new int[2];
        sVar.f12174b.getLocationOnScreen(iArr);
        sVar.f12173a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r9 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
        if (r0.f12164e == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        if (r0.f12162c == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c c0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f12160a = false;
        cVar.f12161b = false;
        if (sVar == null || !sVar.f12173a.containsKey("android:visibility:visibility")) {
            cVar.f12162c = -1;
            cVar.f12164e = null;
        } else {
            cVar.f12162c = ((Integer) sVar.f12173a.get("android:visibility:visibility")).intValue();
            cVar.f12164e = (ViewGroup) sVar.f12173a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f12173a.containsKey("android:visibility:visibility")) {
            cVar.f12163d = -1;
            cVar.f12165f = null;
        } else {
            cVar.f12163d = ((Integer) sVar2.f12173a.get("android:visibility:visibility")).intValue();
            cVar.f12165f = (ViewGroup) sVar2.f12173a.get("android:visibility:parent");
        }
        if (sVar == null || sVar2 == null) {
            if (sVar != null || cVar.f12163d != 0) {
                if (sVar2 == null) {
                }
                return cVar;
            }
            cVar.f12161b = true;
        } else {
            int i6 = cVar.f12162c;
            int i7 = cVar.f12163d;
            if (i6 == i7 && cVar.f12164e == cVar.f12165f) {
                return cVar;
            }
            if (i6 != i7) {
                if (i6 != 0) {
                }
                cVar.f12161b = false;
            } else {
                if (cVar.f12165f != null) {
                }
                cVar.f12161b = false;
            }
        }
        cVar.f12160a = true;
        return cVar;
    }

    @Override // n0.l
    public String[] C() {
        return M;
    }

    @Override // n0.l
    public boolean E(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar == null || sVar2 == null || sVar2.f12173a.containsKey("android:visibility:visibility") == sVar.f12173a.containsKey("android:visibility:visibility")) {
            c c02 = c0(sVar, sVar2);
            if (c02.f12160a) {
                return c02.f12162c == 0 || c02.f12163d == 0;
            }
            return false;
        }
        return false;
    }

    public abstract Animator d0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator e0(ViewGroup viewGroup, s sVar, int i6, s sVar2, int i7) {
        if ((this.L & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f12174b.getParent();
            if (c0(s(view, false), D(view, false)).f12160a) {
                return null;
            }
        }
        return d0(viewGroup, sVar2.f12174b, sVar, sVar2);
    }

    @Override // n0.l
    public void f(s sVar) {
        b0(sVar);
    }

    public abstract Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        if (r17.f12129y != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator g0(ViewGroup viewGroup, s sVar, int i6, s sVar2, int i7) {
        View view;
        boolean z5;
        boolean z6;
        View view2;
        if ((this.L & 2) == 2 && sVar != null) {
            View view3 = sVar.f12174b;
            View view4 = sVar2 != null ? sVar2.f12174b : null;
            int i8 = i.save_overlay_view;
            View view5 = (View) view3.getTag(i8);
            if (view5 != null) {
                view2 = null;
                z6 = true;
            } else if (view4 == null || view4.getParent() == null) {
                if (view4 != null) {
                    view = null;
                    z5 = false;
                    if (z5) {
                        if (view3.getParent() != null) {
                            if (view3.getParent() instanceof View) {
                                View view6 = (View) view3.getParent();
                                if (c0(D(view6, true), s(view6, true)).f12160a) {
                                    int id = view6.getId();
                                    if (view6.getParent() == null) {
                                        if (id != -1) {
                                            if (viewGroup.findViewById(id) != null) {
                                            }
                                        }
                                    }
                                } else {
                                    view4 = r.a(viewGroup, view3, view6);
                                }
                            }
                        }
                        view2 = view;
                        z6 = false;
                        view5 = view3;
                    }
                    z6 = false;
                    View view7 = view;
                    view5 = view4;
                    view2 = view7;
                }
                view4 = null;
                view = null;
                z5 = true;
                if (z5) {
                }
                z6 = false;
                View view72 = view;
                view5 = view4;
                view2 = view72;
            } else {
                if (i7 == 4 || view3 == view4) {
                    view = view4;
                    z5 = false;
                    view4 = null;
                    if (z5) {
                    }
                    z6 = false;
                    View view722 = view;
                    view5 = view4;
                    view2 = view722;
                }
                view4 = null;
                view = null;
                z5 = true;
                if (z5) {
                }
                z6 = false;
                View view7222 = view;
                view5 = view4;
                view2 = view7222;
            }
            if (view5 == null) {
                if (view2 != null) {
                    int visibility = view2.getVisibility();
                    a0.h(view2, 0);
                    Animator f02 = f0(viewGroup, view2, sVar, sVar2);
                    if (f02 != null) {
                        b bVar = new b(view2, i7, true);
                        f02.addListener(bVar);
                        n0.a.a(f02, bVar);
                        a(bVar);
                    } else {
                        a0.h(view2, visibility);
                    }
                    return f02;
                }
                return null;
            }
            if (!z6) {
                int[] iArr = (int[]) sVar.f12173a.get("android:visibility:screenLocation");
                int i9 = iArr[0];
                int i10 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view5.offsetLeftAndRight((i9 - iArr2[0]) - view5.getLeft());
                view5.offsetTopAndBottom((i10 - iArr2[1]) - view5.getTop());
                x.a(viewGroup).a(view5);
            }
            Animator f03 = f0(viewGroup, view5, sVar, sVar2);
            if (!z6) {
                if (f03 == null) {
                    x.a(viewGroup).c(view5);
                } else {
                    view3.setTag(i8, view5);
                    a(new a(viewGroup, view5, view3));
                }
            }
            return f03;
        }
        return null;
    }

    public void h0(int i6) {
        if ((i6 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.L = i6;
    }

    @Override // n0.l
    public void i(s sVar) {
        b0(sVar);
    }

    @Override // n0.l
    public Animator m(ViewGroup viewGroup, s sVar, s sVar2) {
        c c02 = c0(sVar, sVar2);
        if (c02.f12160a) {
            if (c02.f12164e == null && c02.f12165f == null) {
                return null;
            }
            return c02.f12161b ? e0(viewGroup, sVar, c02.f12162c, sVar2, c02.f12163d) : g0(viewGroup, sVar, c02.f12162c, sVar2, c02.f12163d);
        }
        return null;
    }
}
