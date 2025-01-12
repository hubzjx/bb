package n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends l {
    private static final String[] O = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property P = new b(PointF.class, "boundsOrigin");
    private static final Property Q = new C0197c(PointF.class, "topLeft");
    private static final Property R = new d(PointF.class, "bottomRight");
    private static final Property S = new e(PointF.class, "bottomRight");
    private static final Property T = new f(PointF.class, "topLeft");
    private static final Property U = new g(PointF.class, "position");
    private static n0.j V = new n0.j();
    private int[] L = new int[2];
    private boolean M = false;
    private boolean N = false;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f12057a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f12058b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f12059c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f12060d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f6) {
            this.f12057a = viewGroup;
            this.f12058b = bitmapDrawable;
            this.f12059c = view;
            this.f12060d = f6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a0.b(this.f12057a).d(this.f12058b);
            a0.g(this.f12059c, this.f12060d);
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property {

        /* renamed from: a  reason: collision with root package name */
        private Rect f12062a;

        b(Class cls, String str) {
            super(cls, str);
            this.f12062a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f12062a);
            Rect rect = this.f12062a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f12062a);
            this.f12062a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f12062a);
        }
    }

    /* renamed from: n0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0197c extends Property {
        C0197c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            a0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    static class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            a0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    static class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            a0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f12063a;
        private k mViewBounds;

        h(k kVar) {
            this.f12063a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12065a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f12066b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f12067c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f12068d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f12069e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f12070f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f12071g;

        i(View view, Rect rect, int i6, int i7, int i8, int i9) {
            this.f12066b = view;
            this.f12067c = rect;
            this.f12068d = i6;
            this.f12069e = i7;
            this.f12070f = i8;
            this.f12071g = i9;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12065a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f12065a) {
                return;
            }
            e0.b0.r0(this.f12066b, this.f12067c);
            a0.f(this.f12066b, this.f12068d, this.f12069e, this.f12070f, this.f12071g);
        }
    }

    /* loaded from: classes.dex */
    class j extends m {

        /* renamed from: a  reason: collision with root package name */
        boolean f12073a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f12074b;

        j(ViewGroup viewGroup) {
            this.f12074b = viewGroup;
        }

        @Override // n0.m, n0.l.f
        public void a(l lVar) {
            x.c(this.f12074b, true);
        }

        @Override // n0.l.f
        public void b(l lVar) {
            if (!this.f12073a) {
                x.c(this.f12074b, false);
            }
            lVar.O(this);
        }

        @Override // n0.m, n0.l.f
        public void c(l lVar) {
            x.c(this.f12074b, false);
        }

        @Override // n0.m, n0.l.f
        public void e(l lVar) {
            x.c(this.f12074b, false);
            this.f12073a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f12076a;

        /* renamed from: b  reason: collision with root package name */
        private int f12077b;

        /* renamed from: c  reason: collision with root package name */
        private int f12078c;

        /* renamed from: d  reason: collision with root package name */
        private int f12079d;

        /* renamed from: e  reason: collision with root package name */
        private View f12080e;

        /* renamed from: f  reason: collision with root package name */
        private int f12081f;

        /* renamed from: g  reason: collision with root package name */
        private int f12082g;

        k(View view) {
            this.f12080e = view;
        }

        private void b() {
            a0.f(this.f12080e, this.f12076a, this.f12077b, this.f12078c, this.f12079d);
            this.f12081f = 0;
            this.f12082g = 0;
        }

        void a(PointF pointF) {
            this.f12078c = Math.round(pointF.x);
            this.f12079d = Math.round(pointF.y);
            int i6 = this.f12082g + 1;
            this.f12082g = i6;
            if (this.f12081f == i6) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f12076a = Math.round(pointF.x);
            this.f12077b = Math.round(pointF.y);
            int i6 = this.f12081f + 1;
            this.f12081f = i6;
            if (i6 == this.f12082g) {
                b();
            }
        }
    }

    private void b0(s sVar) {
        View view = sVar.f12174b;
        if (!e0.b0.R(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f12173a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f12173a.put("android:changeBounds:parent", sVar.f12174b.getParent());
        if (this.N) {
            sVar.f12174b.getLocationInWindow(this.L);
            sVar.f12173a.put("android:changeBounds:windowX", Integer.valueOf(this.L[0]));
            sVar.f12173a.put("android:changeBounds:windowY", Integer.valueOf(this.L[1]));
        }
        if (this.M) {
            sVar.f12173a.put("android:changeBounds:clip", e0.b0.u(view));
        }
    }

    private boolean c0(View view, View view2) {
        if (this.N) {
            s s5 = s(view, true);
            if (s5 == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == s5.f12174b) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // n0.l
    public String[] C() {
        return O;
    }

    @Override // n0.l
    public void f(s sVar) {
        b0(sVar);
    }

    @Override // n0.l
    public void i(s sVar) {
        b0(sVar);
    }

    @Override // n0.l
    public Animator m(ViewGroup viewGroup, s sVar, s sVar2) {
        int i6;
        View view;
        int i7;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c6;
        Path a6;
        Property property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map map = sVar.f12173a;
        Map map2 = sVar2.f12173a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f12174b;
        if (!c0(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) sVar.f12173a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) sVar.f12173a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) sVar2.f12173a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) sVar2.f12173a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.L);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c7 = a0.c(view2);
            a0.g(view2, 0.0f);
            a0.b(viewGroup).b(bitmapDrawable);
            n0.g u5 = u();
            int[] iArr = this.L;
            int i8 = iArr[0];
            int i9 = iArr[1];
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, n0.h.a(P, u5.a(intValue - i8, intValue2 - i9, intValue3 - i8, intValue4 - i9)));
            ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c7));
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.f12173a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.f12173a.get("android:changeBounds:bounds");
        int i10 = rect2.left;
        int i11 = rect3.left;
        int i12 = rect2.top;
        int i13 = rect3.top;
        int i14 = rect2.right;
        int i15 = rect3.right;
        int i16 = rect2.bottom;
        int i17 = rect3.bottom;
        int i18 = i14 - i10;
        int i19 = i16 - i12;
        int i20 = i15 - i11;
        int i21 = i17 - i13;
        Rect rect4 = (Rect) sVar.f12173a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.f12173a.get("android:changeBounds:clip");
        if ((i18 == 0 || i19 == 0) && (i20 == 0 || i21 == 0)) {
            i6 = 0;
        } else {
            i6 = (i10 == i11 && i12 == i13) ? 0 : 1;
            if (i14 != i15 || i16 != i17) {
                i6++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i6++;
        }
        if (i6 > 0) {
            if (this.M) {
                view = view2;
                a0.f(view, i10, i12, Math.max(i18, i20) + i10, Math.max(i19, i21) + i12);
                ObjectAnimator a7 = (i10 == i11 && i12 == i13) ? null : n0.f.a(view, U, u().a(i10, i12, i11, i13));
                if (rect4 == null) {
                    i7 = 0;
                    rect = new Rect(0, 0, i18, i19);
                } else {
                    i7 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i7, i7, i20, i21) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimator = null;
                } else {
                    e0.b0.r0(view, rect);
                    n0.j jVar = V;
                    Object[] objArr = new Object[2];
                    objArr[i7] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                    ofObject.addListener(new i(view, rect5, i11, i13, i15, i17));
                    objectAnimator = ofObject;
                }
                c6 = r.c(a7, objectAnimator);
            } else {
                view = view2;
                a0.f(view, i10, i12, i14, i16);
                if (i6 == 2) {
                    if (i18 == i20 && i19 == i21) {
                        a6 = u().a(i10, i12, i11, i13);
                        property = U;
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a8 = n0.f.a(kVar, Q, u().a(i10, i12, i11, i13));
                        ObjectAnimator a9 = n0.f.a(kVar, R, u().a(i14, i16, i15, i17));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a8, a9);
                        animatorSet.addListener(new h(kVar));
                        c6 = animatorSet;
                    }
                } else if (i10 == i11 && i12 == i13) {
                    a6 = u().a(i14, i16, i15, i17);
                    property = S;
                } else {
                    a6 = u().a(i10, i12, i11, i13);
                    property = T;
                }
                c6 = n0.f.a(view, property, a6);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.c(viewGroup4, true);
                a(new j(viewGroup4));
            }
            return c6;
        }
        return null;
    }
}
