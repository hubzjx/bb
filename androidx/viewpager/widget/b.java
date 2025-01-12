package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import e0.b0;
import e0.u;
import e0.v0;
import f0.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class b extends ViewGroup {

    /* renamed from: g0  reason: collision with root package name */
    static final int[] f2651g0 = {16842931};

    /* renamed from: h0  reason: collision with root package name */
    private static final Comparator f2652h0 = new a();

    /* renamed from: i0  reason: collision with root package name */
    private static final Interpolator f2653i0 = new animation.InterpolatorC0027b();

    /* renamed from: j0  reason: collision with root package name */
    private static final l f2654j0 = new l();
    private boolean A;
    private int B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private int I;
    private VelocityTracker J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private EdgeEffect P;
    private EdgeEffect Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private List V;
    private i W;

    /* renamed from: a0  reason: collision with root package name */
    private i f2655a0;

    /* renamed from: b  reason: collision with root package name */
    private int f2656b;

    /* renamed from: b0  reason: collision with root package name */
    private List f2657b0;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f2658c;

    /* renamed from: c0  reason: collision with root package name */
    private int f2659c0;

    /* renamed from: d  reason: collision with root package name */
    private final f f2660d;

    /* renamed from: d0  reason: collision with root package name */
    private ArrayList f2661d0;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f2662e;

    /* renamed from: e0  reason: collision with root package name */
    private final Runnable f2663e0;

    /* renamed from: f  reason: collision with root package name */
    androidx.viewpager.widget.a f2664f;

    /* renamed from: f0  reason: collision with root package name */
    private int f2665f0;

    /* renamed from: g  reason: collision with root package name */
    int f2666g;

    /* renamed from: h  reason: collision with root package name */
    private int f2667h;

    /* renamed from: i  reason: collision with root package name */
    private Parcelable f2668i;

    /* renamed from: j  reason: collision with root package name */
    private ClassLoader f2669j;

    /* renamed from: k  reason: collision with root package name */
    private Scroller f2670k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2671l;

    /* renamed from: m  reason: collision with root package name */
    private j f2672m;

    /* renamed from: n  reason: collision with root package name */
    private int f2673n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f2674o;

    /* renamed from: p  reason: collision with root package name */
    private int f2675p;

    /* renamed from: q  reason: collision with root package name */
    private int f2676q;

    /* renamed from: r  reason: collision with root package name */
    private float f2677r;

    /* renamed from: s  reason: collision with root package name */
    private float f2678s;

    /* renamed from: t  reason: collision with root package name */
    private int f2679t;

    /* renamed from: u  reason: collision with root package name */
    private int f2680u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2681v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f2682w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f2683x;

    /* renamed from: y  reason: collision with root package name */
    private int f2684y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f2685z;

    /* loaded from: classes.dex */
    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f2690b - fVar2.f2690b;
        }
    }

    /* renamed from: androidx.viewpager.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class animation.InterpolatorC0027b implements Interpolator {
        animation.InterpolatorC0027b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.setScrollState(0);
            b.this.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements u {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f2687a = new Rect();

        d() {
        }

        @Override // e0.u
        public v0 a(View view, v0 v0Var) {
            v0 Y = b0.Y(view, v0Var);
            if (Y.l()) {
                return Y;
            }
            Rect rect = this.f2687a;
            rect.left = Y.g();
            rect.top = Y.i();
            rect.right = Y.h();
            rect.bottom = Y.f();
            int childCount = b.this.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                v0 h6 = b0.h(b.this.getChildAt(i6), Y);
                rect.left = Math.min(h6.g(), rect.left);
                rect.top = Math.min(h6.i(), rect.top);
                rect.right = Math.min(h6.h(), rect.right);
                rect.bottom = Math.min(h6.f(), rect.bottom);
            }
            return Y.m(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f2689a;

        /* renamed from: b  reason: collision with root package name */
        int f2690b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2691c;

        /* renamed from: d  reason: collision with root package name */
        float f2692d;

        /* renamed from: e  reason: collision with root package name */
        float f2693e;

        f() {
        }
    }

    /* loaded from: classes.dex */
    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2694a;

        /* renamed from: b  reason: collision with root package name */
        public int f2695b;

        /* renamed from: c  reason: collision with root package name */
        float f2696c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2697d;

        /* renamed from: e  reason: collision with root package name */
        int f2698e;

        /* renamed from: f  reason: collision with root package name */
        int f2699f;

        public g() {
            super(-1, -1);
            this.f2696c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2696c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f2651g0);
            this.f2695b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends e0.a {
        h() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = b.this.f2664f;
            return aVar != null && aVar.d() > 1;
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(b.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = b.this.f2664f) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.d());
            accessibilityEvent.setFromIndex(b.this.f2666g);
            accessibilityEvent.setToIndex(b.this.f2666g);
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            yVar.W(b.class.getName());
            yVar.o0(n());
            if (b.this.canScrollHorizontally(1)) {
                yVar.a(_BufferKt.SEGMENTING_THRESHOLD);
            }
            if (b.this.canScrollHorizontally(-1)) {
                yVar.a(Segment.SIZE);
            }
        }

        @Override // e0.a
        public boolean j(View view, int i6, Bundle bundle) {
            b bVar;
            int i7;
            if (super.j(view, i6, bundle)) {
                return true;
            }
            if (i6 != 4096) {
                if (i6 != 8192 || !b.this.canScrollHorizontally(-1)) {
                    return false;
                }
                bVar = b.this;
                i7 = bVar.f2666g - 1;
            } else if (!b.this.canScrollHorizontally(1)) {
                return false;
            } else {
                bVar = b.this;
                i7 = bVar.f2666g + 1;
            }
            bVar.setCurrentItem(i7);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(int i6, float f6, int i7);

        void b(int i6);

        void c(int i6);
    }

    /* loaded from: classes.dex */
    private class j extends DataSetObserver {
        j() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            b.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            b.this.g();
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h0.a {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f2702c;

        /* renamed from: d  reason: collision with root package name */
        Parcelable f2703d;

        /* renamed from: e  reason: collision with root package name */
        ClassLoader f2704e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public k createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new k(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public k[] newArray(int i6) {
                return new k[i6];
            }
        }

        k(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f2702c = parcel.readInt();
            this.f2703d = parcel.readParcelable(classLoader);
            this.f2704e = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f2702c + "}";
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f2702c);
            parcel.writeParcelable(this.f2703d, i6);
        }

        public k(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l implements Comparator {
        l() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z5 = gVar.f2694a;
            return z5 != gVar2.f2694a ? z5 ? 1 : -1 : gVar.f2698e - gVar2.f2698e;
        }
    }

    public b(Context context) {
        super(context);
        this.f2658c = new ArrayList();
        this.f2660d = new f();
        this.f2662e = new Rect();
        this.f2667h = -1;
        this.f2668i = null;
        this.f2669j = null;
        this.f2677r = -3.4028235E38f;
        this.f2678s = Float.MAX_VALUE;
        this.f2684y = 1;
        this.I = -1;
        this.R = true;
        this.S = false;
        this.f2663e0 = new c();
        this.f2665f0 = 0;
        t();
    }

    private boolean A(int i6) {
        if (this.f2658c.size() == 0) {
            if (this.R) {
                return false;
            }
            this.T = false;
            w(0, 0.0f, 0);
            if (this.T) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f r5 = r();
        int clientWidth = getClientWidth();
        int i7 = this.f2673n;
        int i8 = clientWidth + i7;
        float f6 = clientWidth;
        int i9 = r5.f2690b;
        float f7 = ((i6 / f6) - r5.f2693e) / (r5.f2692d + (i7 / f6));
        this.T = false;
        w(i9, f7, (int) (i8 * f7));
        if (this.T) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean B(float f6) {
        boolean z5;
        boolean z6;
        float f7 = this.E - f6;
        this.E = f6;
        float scrollX = getScrollX() + f7;
        float clientWidth = getClientWidth();
        float f8 = this.f2677r * clientWidth;
        float f9 = this.f2678s * clientWidth;
        boolean z7 = false;
        f fVar = (f) this.f2658c.get(0);
        ArrayList arrayList = this.f2658c;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.f2690b != 0) {
            f8 = fVar.f2693e * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (fVar2.f2690b != this.f2664f.d() - 1) {
            f9 = fVar2.f2693e * clientWidth;
            z6 = false;
        } else {
            z6 = true;
        }
        if (scrollX < f8) {
            if (z5) {
                this.P.onPull(Math.abs(f8 - scrollX) / clientWidth);
                z7 = true;
            }
            scrollX = f8;
        } else if (scrollX > f9) {
            if (z6) {
                this.Q.onPull(Math.abs(scrollX - f9) / clientWidth);
                z7 = true;
            }
            scrollX = f9;
        }
        int i6 = (int) scrollX;
        this.E += scrollX - i6;
        scrollTo(i6, getScrollY());
        A(i6);
        return z7;
    }

    private void E(int i6, int i7, int i8, int i9) {
        int min;
        if (i7 <= 0 || this.f2658c.isEmpty()) {
            f s5 = s(this.f2666g);
            min = (int) ((s5 != null ? Math.min(s5.f2693e, this.f2678s) : 0.0f) * ((i6 - getPaddingLeft()) - getPaddingRight()));
            if (min == getScrollX()) {
                return;
            }
            f(false);
        } else if (!this.f2670k.isFinished()) {
            this.f2670k.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((getScrollX() / (((i7 - getPaddingLeft()) - getPaddingRight()) + i9)) * (((i6 - getPaddingLeft()) - getPaddingRight()) + i8));
        }
        scrollTo(min, getScrollY());
    }

    private void F() {
        int i6 = 0;
        while (i6 < getChildCount()) {
            if (!((g) getChildAt(i6).getLayoutParams()).f2694a) {
                removeViewAt(i6);
                i6--;
            }
            i6++;
        }
    }

    private void G(boolean z5) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z5);
        }
    }

    private boolean H() {
        this.I = -1;
        m();
        this.P.onRelease();
        this.Q.onRelease();
        return this.P.isFinished() || this.Q.isFinished();
    }

    private void I(int i6, boolean z5, int i7, boolean z6) {
        f s5 = s(i6);
        int clientWidth = s5 != null ? (int) (getClientWidth() * Math.max(this.f2677r, Math.min(s5.f2693e, this.f2678s))) : 0;
        if (z5) {
            M(clientWidth, 0, i7);
            if (z6) {
                j(i6);
                return;
            }
            return;
        }
        if (z6) {
            j(i6);
        }
        f(false);
        scrollTo(clientWidth, 0);
        A(clientWidth);
    }

    private void N() {
        if (this.f2659c0 != 0) {
            ArrayList arrayList = this.f2661d0;
            if (arrayList == null) {
                this.f2661d0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                this.f2661d0.add(getChildAt(i6));
            }
            Collections.sort(this.f2661d0, f2654j0);
        }
    }

    private void d(f fVar, int i6, f fVar2) {
        int i7;
        int i8;
        f fVar3;
        f fVar4;
        int d6 = this.f2664f.d();
        int clientWidth = getClientWidth();
        float f6 = clientWidth > 0 ? this.f2673n / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i9 = fVar2.f2690b;
            int i10 = fVar.f2690b;
            if (i9 < i10) {
                float f7 = fVar2.f2693e + fVar2.f2692d + f6;
                int i11 = i9 + 1;
                int i12 = 0;
                while (i11 <= fVar.f2690b && i12 < this.f2658c.size()) {
                    while (true) {
                        fVar4 = (f) this.f2658c.get(i12);
                        if (i11 <= fVar4.f2690b || i12 >= this.f2658c.size() - 1) {
                            break;
                        }
                        i12++;
                    }
                    while (i11 < fVar4.f2690b) {
                        f7 += this.f2664f.f(i11) + f6;
                        i11++;
                    }
                    fVar4.f2693e = f7;
                    f7 += fVar4.f2692d + f6;
                    i11++;
                }
            } else if (i9 > i10) {
                int size = this.f2658c.size() - 1;
                float f8 = fVar2.f2693e;
                while (true) {
                    i9--;
                    if (i9 < fVar.f2690b || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = (f) this.f2658c.get(size);
                        if (i9 >= fVar3.f2690b || size <= 0) {
                            break;
                        }
                        size--;
                    }
                    while (i9 > fVar3.f2690b) {
                        f8 -= this.f2664f.f(i9) + f6;
                        i9--;
                    }
                    f8 -= fVar3.f2692d + f6;
                    fVar3.f2693e = f8;
                }
            }
        }
        int size2 = this.f2658c.size();
        float f9 = fVar.f2693e;
        int i13 = fVar.f2690b;
        int i14 = i13 - 1;
        this.f2677r = i13 == 0 ? f9 : -3.4028235E38f;
        int i15 = d6 - 1;
        this.f2678s = i13 == i15 ? (fVar.f2692d + f9) - 1.0f : Float.MAX_VALUE;
        int i16 = i6 - 1;
        while (i16 >= 0) {
            f fVar5 = (f) this.f2658c.get(i16);
            while (true) {
                i8 = fVar5.f2690b;
                if (i14 <= i8) {
                    break;
                }
                f9 -= this.f2664f.f(i14) + f6;
                i14--;
            }
            f9 -= fVar5.f2692d + f6;
            fVar5.f2693e = f9;
            if (i8 == 0) {
                this.f2677r = f9;
            }
            i16--;
            i14--;
        }
        float f10 = fVar.f2693e + fVar.f2692d + f6;
        int i17 = fVar.f2690b + 1;
        int i18 = i6 + 1;
        while (i18 < size2) {
            f fVar6 = (f) this.f2658c.get(i18);
            while (true) {
                i7 = fVar6.f2690b;
                if (i17 >= i7) {
                    break;
                }
                f10 += this.f2664f.f(i17) + f6;
                i17++;
            }
            if (i7 == i15) {
                this.f2678s = (fVar6.f2692d + f10) - 1.0f;
            }
            fVar6.f2693e = f10;
            f10 += fVar6.f2692d + f6;
            i18++;
            i17++;
        }
        this.S = false;
    }

    private void f(boolean z5) {
        boolean z6 = this.f2665f0 == 2;
        if (z6) {
            setScrollingCacheEnabled(false);
            if (!this.f2670k.isFinished()) {
                this.f2670k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f2670k.getCurrX();
                int currY = this.f2670k.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        A(currX);
                    }
                }
            }
        }
        this.f2683x = false;
        for (int i6 = 0; i6 < this.f2658c.size(); i6++) {
            f fVar = (f) this.f2658c.get(i6);
            if (fVar.f2691c) {
                fVar.f2691c = false;
                z6 = true;
            }
        }
        if (z6) {
            if (z5) {
                b0.d0(this, this.f2663e0);
            } else {
                this.f2663e0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int h(int i6, float f6, int i7, int i8) {
        if (Math.abs(i8) <= this.M || Math.abs(i7) <= this.K) {
            i6 += (int) (f6 + (i6 >= this.f2666g ? 0.4f : 0.6f));
        } else if (i7 <= 0) {
            i6++;
        }
        if (this.f2658c.size() > 0) {
            ArrayList arrayList = this.f2658c;
            return Math.max(((f) this.f2658c.get(0)).f2690b, Math.min(i6, ((f) arrayList.get(arrayList.size() - 1)).f2690b));
        }
        return i6;
    }

    private void i(int i6, float f6, int i7) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.a(i6, f6, i7);
        }
        List list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                i iVar2 = (i) this.V.get(i8);
                if (iVar2 != null) {
                    iVar2.a(i6, f6, i7);
                }
            }
        }
        i iVar3 = this.f2655a0;
        if (iVar3 != null) {
            iVar3.a(i6, f6, i7);
        }
    }

    private void j(int i6) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.b(i6);
        }
        List list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                i iVar2 = (i) this.V.get(i7);
                if (iVar2 != null) {
                    iVar2.b(i6);
                }
            }
        }
        i iVar3 = this.f2655a0;
        if (iVar3 != null) {
            iVar3.b(i6);
        }
    }

    private void k(int i6) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.c(i6);
        }
        List list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                i iVar2 = (i) this.V.get(i7);
                if (iVar2 != null) {
                    iVar2.c(i6);
                }
            }
        }
        i iVar3 = this.f2655a0;
        if (iVar3 != null) {
            iVar3.c(i6);
        }
    }

    private void m() {
        this.f2685z = false;
        this.A = false;
        VelocityTracker velocityTracker = this.J;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.J = null;
        }
    }

    private Rect o(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        int bottom = view.getBottom();
        while (true) {
            rect.bottom = bottom;
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                break;
            }
            view = (ViewGroup) parent;
            rect.left += view.getLeft();
            rect.right += view.getRight();
            rect.top += view.getTop();
            bottom = rect.bottom + view.getBottom();
        }
        return rect;
    }

    private f r() {
        int i6;
        int clientWidth = getClientWidth();
        float f6 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f7 = clientWidth > 0 ? this.f2673n / clientWidth : 0.0f;
        f fVar = null;
        float f8 = 0.0f;
        int i7 = -1;
        int i8 = 0;
        boolean z5 = true;
        while (i8 < this.f2658c.size()) {
            f fVar2 = (f) this.f2658c.get(i8);
            if (!z5 && fVar2.f2690b != (i6 = i7 + 1)) {
                fVar2 = this.f2660d;
                fVar2.f2693e = f6 + f8 + f7;
                fVar2.f2690b = i6;
                fVar2.f2692d = this.f2664f.f(i6);
                i8--;
            }
            f fVar3 = fVar2;
            f6 = fVar3.f2693e;
            float f9 = fVar3.f2692d + f6 + f7;
            if (!z5 && scrollX < f6) {
                return fVar;
            }
            if (scrollX < f9 || i8 == this.f2658c.size() - 1) {
                return fVar3;
            }
            int i9 = fVar3.f2690b;
            float f10 = fVar3.f2692d;
            i8++;
            z5 = false;
            i7 = i9;
            f8 = f10;
            fVar = fVar3;
        }
        return fVar;
    }

    private void setScrollingCacheEnabled(boolean z5) {
        if (this.f2682w != z5) {
            this.f2682w = z5;
        }
    }

    private static boolean u(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean v(float f6, float f7) {
        return (f6 < ((float) this.C) && f7 > 0.0f) || (f6 > ((float) (getWidth() - this.C)) && f7 < 0.0f);
    }

    private void x(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.E = motionEvent.getX(i6);
            this.I = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    void C() {
        D(this.f2666g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
        if (r10 >= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ce, code lost:
        if (r10 >= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00dc, code lost:
        if (r10 >= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00de, code lost:
        r5 = (androidx.viewpager.widget.b.f) r17.f2658c.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e7, code lost:
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void D(int i6) {
        f fVar;
        String hexString;
        f fVar2;
        f q5;
        f fVar3;
        int i7 = this.f2666g;
        if (i7 != i6) {
            fVar = s(i7);
            this.f2666g = i6;
        } else {
            fVar = null;
        }
        if (this.f2664f == null) {
            N();
        } else if (this.f2683x) {
            N();
        } else if (getWindowToken() != null) {
            this.f2664f.o(this);
            int i8 = this.f2684y;
            int max = Math.max(0, this.f2666g - i8);
            int d6 = this.f2664f.d();
            int min = Math.min(d6 - 1, this.f2666g + i8);
            if (d6 != this.f2656b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException unused) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f2656b + ", found: " + d6 + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f2664f.getClass());
            }
            int i9 = 0;
            while (true) {
                if (i9 >= this.f2658c.size()) {
                    break;
                }
                fVar2 = (f) this.f2658c.get(i9);
                int i10 = fVar2.f2690b;
                int i11 = this.f2666g;
                if (i10 < i11) {
                    i9++;
                }
            }
            if (fVar2 == null && d6 > 0) {
                fVar2 = a(this.f2666g, i9);
            }
            if (fVar2 != null) {
                int i12 = i9 - 1;
                f fVar4 = i12 >= 0 ? (f) this.f2658c.get(i12) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - fVar2.f2692d) + (getPaddingLeft() / clientWidth);
                float f6 = 0.0f;
                for (int i13 = this.f2666g - 1; i13 >= 0; i13--) {
                    if (f6 < paddingLeft || i13 >= max) {
                        if (fVar4 == null || i13 != fVar4.f2690b) {
                            f6 += a(i13, i12 + 1).f2692d;
                            i9++;
                        } else {
                            f6 += fVar4.f2692d;
                            i12--;
                        }
                    } else if (fVar4 == null) {
                        break;
                    } else {
                        if (i13 == fVar4.f2690b && !fVar4.f2691c) {
                            this.f2658c.remove(i12);
                            this.f2664f.a(this, i13, fVar4.f2689a);
                            i12--;
                            i9--;
                        }
                    }
                    fVar4 = fVar3;
                }
                float f7 = fVar2.f2692d;
                int i14 = i9 + 1;
                if (f7 < 2.0f) {
                    f fVar5 = i14 < this.f2658c.size() ? (f) this.f2658c.get(i14) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    int i15 = this.f2666g;
                    while (true) {
                        i15++;
                        if (i15 >= d6) {
                            break;
                        } else if (f7 < paddingRight || i15 <= min) {
                            if (fVar5 == null || i15 != fVar5.f2690b) {
                                f a6 = a(i15, i14);
                                i14++;
                                f7 += a6.f2692d;
                                fVar5 = i14 < this.f2658c.size() ? (f) this.f2658c.get(i14) : null;
                            } else {
                                f7 += fVar5.f2692d;
                                i14++;
                                if (i14 < this.f2658c.size()) {
                                }
                            }
                        } else if (fVar5 == null) {
                            break;
                        } else if (i15 == fVar5.f2690b && !fVar5.f2691c) {
                            this.f2658c.remove(i14);
                            this.f2664f.a(this, i15, fVar5.f2689a);
                            if (i14 < this.f2658c.size()) {
                            }
                        }
                    }
                }
                d(fVar2, i9, fVar);
                this.f2664f.l(this, this.f2666g, fVar2.f2689a);
            }
            this.f2664f.c(this);
            int childCount = getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                g gVar = (g) childAt.getLayoutParams();
                gVar.f2699f = i16;
                if (!gVar.f2694a && gVar.f2696c == 0.0f && (q5 = q(childAt)) != null) {
                    gVar.f2696c = q5.f2692d;
                    gVar.f2698e = q5.f2690b;
                }
            }
            N();
            if (hasFocus()) {
                View findFocus = findFocus();
                f p5 = findFocus != null ? p(findFocus) : null;
                if (p5 == null || p5.f2690b != this.f2666g) {
                    for (int i17 = 0; i17 < getChildCount(); i17++) {
                        View childAt2 = getChildAt(i17);
                        f q6 = q(childAt2);
                        if (q6 != null && q6.f2690b == this.f2666g && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void J(int i6, boolean z5) {
        this.f2683x = false;
        K(i6, z5, false);
    }

    void K(int i6, boolean z5, boolean z6) {
        L(i6, z5, z6, 0);
    }

    void L(int i6, boolean z5, boolean z6, int i7) {
        androidx.viewpager.widget.a aVar = this.f2664f;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z6 || this.f2666g != i6 || this.f2658c.size() == 0) {
            if (i6 < 0) {
                i6 = 0;
            } else if (i6 >= this.f2664f.d()) {
                i6 = this.f2664f.d() - 1;
            }
            int i8 = this.f2684y;
            int i9 = this.f2666g;
            if (i6 > i9 + i8 || i6 < i9 - i8) {
                for (int i10 = 0; i10 < this.f2658c.size(); i10++) {
                    ((f) this.f2658c.get(i10)).f2691c = true;
                }
            }
            boolean z7 = this.f2666g != i6;
            if (!this.R) {
                D(i6);
                I(i6, z5, i7, z7);
                return;
            }
            this.f2666g = i6;
            if (z7) {
                j(i6);
            }
            requestLayout();
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    void M(int i6, int i7, int i8) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f2670k;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f2671l ? this.f2670k.getCurrX() : this.f2670k.getStartX();
            this.f2670k.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i9 = scrollX;
        int scrollY = getScrollY();
        int i10 = i6 - i9;
        int i11 = i7 - scrollY;
        if (i10 == 0 && i11 == 0) {
            f(false);
            C();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i12 = clientWidth / 2;
        float f6 = clientWidth;
        float f7 = i12;
        float l6 = f7 + (l(Math.min(1.0f, (Math.abs(i10) * 1.0f) / f6)) * f7);
        int abs = Math.abs(i8);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(l6 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / ((f6 * this.f2664f.f(this.f2666g)) + this.f2673n)) + 1.0f) * 100.0f), 600);
        this.f2671l = false;
        this.f2670k.startScroll(i9, scrollY, i10, i11, min);
        b0.c0(this);
    }

    f a(int i6, int i7) {
        f fVar = new f();
        fVar.f2690b = i6;
        fVar.f2689a = this.f2664f.g(this, i6);
        fVar.f2692d = this.f2664f.f(i6);
        if (i7 < 0 || i7 >= this.f2658c.size()) {
            this.f2658c.add(fVar);
        } else {
            this.f2658c.add(i7, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i6, int i7) {
        f q5;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() == 0 && (q5 = q(childAt)) != null && q5.f2690b == this.f2666g) {
                    childAt.addFocusables(arrayList, i6, i7);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i7 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        f q5;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (q5 = q(childAt)) != null && q5.f2690b == this.f2666g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean u5 = gVar.f2694a | u(view);
        gVar.f2694a = u5;
        if (!this.f2681v) {
            super.addView(view, i6, layoutParams);
        } else if (u5) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            gVar.f2697d = true;
            addViewInLayout(view, i6, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.V == null) {
            this.V = new ArrayList();
        }
        this.V.add(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(int i6) {
        boolean z5;
        View findNextFocus;
        boolean z6;
        View findFocus = findFocus();
        boolean z7 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z5 = false;
                        break;
                    } else if (parent == this) {
                        z5 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i6);
            if (findNextFocus != null || findNextFocus == findFocus) {
                if (i6 != 17 || i6 == 1) {
                    z7 = y();
                } else if (i6 == 66 || i6 == 2) {
                    z7 = z();
                }
            } else if (i6 == 17) {
                int i7 = o(this.f2662e, findNextFocus).left;
                int i8 = o(this.f2662e, findFocus).left;
                if (findFocus != null && i7 >= i8) {
                    z6 = y();
                    z7 = z6;
                }
                z6 = findNextFocus.requestFocus();
                z7 = z6;
            } else if (i6 == 66) {
                int i9 = o(this.f2662e, findNextFocus).left;
                int i10 = o(this.f2662e, findFocus).left;
                if (findFocus != null && i9 <= i10) {
                    z6 = z();
                    z7 = z6;
                }
                z6 = findNextFocus.requestFocus();
                z7 = z6;
            }
            if (z7) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i6));
            }
            return z7;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i6);
        if (findNextFocus != null) {
        }
        if (i6 != 17) {
        }
        z7 = y();
        if (z7) {
        }
        return z7;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i6) {
        if (this.f2664f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i6 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f2677r)) : i6 > 0 && scrollX < ((int) (((float) clientWidth) * this.f2678s));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f2671l = true;
        if (this.f2670k.isFinished() || !this.f2670k.computeScrollOffset()) {
            f(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f2670k.getCurrX();
        int currY = this.f2670k.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!A(currX)) {
                this.f2670k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        b0.c0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || n(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f q5;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (q5 = q(childAt)) != null && q5.f2690b == this.f2666g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z5 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f2664f) != null && aVar.d() > 1)) {
            if (!this.P.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f2677r * width);
                this.P.setSize(height, width);
                z5 = false | this.P.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.Q.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f2678s + 1.0f)) * width2);
                this.Q.setSize(height2, width2);
                z5 |= this.Q.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.P.finish();
            this.Q.finish();
        }
        if (z5) {
            b0.c0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2674o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean e(View view, boolean z5, int i6, int i7, int i8) {
        int i9;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i10 = i7 + scrollX;
                if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && (i9 = i8 + scrollY) >= childAt.getTop() && i9 < childAt.getBottom() && e(childAt, true, i6, i10 - childAt.getLeft(), i9 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z5 && view.canScrollHorizontally(-i6);
    }

    void g() {
        int d6 = this.f2664f.d();
        this.f2656b = d6;
        boolean z5 = this.f2658c.size() < (this.f2684y * 2) + 1 && this.f2658c.size() < d6;
        int i6 = this.f2666g;
        int i7 = 0;
        boolean z6 = false;
        while (i7 < this.f2658c.size()) {
            f fVar = (f) this.f2658c.get(i7);
            int e6 = this.f2664f.e(fVar.f2689a);
            if (e6 != -1) {
                if (e6 == -2) {
                    this.f2658c.remove(i7);
                    i7--;
                    if (!z6) {
                        this.f2664f.o(this);
                        z6 = true;
                    }
                    this.f2664f.a(this, fVar.f2690b, fVar.f2689a);
                    int i8 = this.f2666g;
                    if (i8 == fVar.f2690b) {
                        i6 = Math.max(0, Math.min(i8, d6 - 1));
                    }
                } else {
                    int i9 = fVar.f2690b;
                    if (i9 != e6) {
                        if (i9 == this.f2666g) {
                            i6 = e6;
                        }
                        fVar.f2690b = e6;
                    }
                }
                z5 = true;
            }
            i7++;
        }
        if (z6) {
            this.f2664f.c(this);
        }
        Collections.sort(this.f2658c, f2652h0);
        if (z5) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                g gVar = (g) getChildAt(i10).getLayoutParams();
                if (!gVar.f2694a) {
                    gVar.f2696c = 0.0f;
                }
            }
            K(i6, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f2664f;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        if (this.f2659c0 == 2) {
            i7 = (i6 - 1) - i7;
        }
        return ((g) ((View) this.f2661d0.get(i7)).getLayoutParams()).f2699f;
    }

    public int getCurrentItem() {
        return this.f2666g;
    }

    public int getOffscreenPageLimit() {
        return this.f2684y;
    }

    public int getPageMargin() {
        return this.f2673n;
    }

    float l(float f6) {
        return (float) Math.sin((f6 - 0.5f) * 0.47123894f);
    }

    public boolean n(KeyEvent keyEvent) {
        int i6;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return c(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return c(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return z();
                } else {
                    i6 = 66;
                }
            } else if (keyEvent.hasModifiers(2)) {
                return y();
            } else {
                i6 = 17;
            }
            return c(i6);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f2663e0);
        Scroller scroller = this.f2670k;
        if (scroller != null && !scroller.isFinished()) {
            this.f2670k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i6;
        float f6;
        float f7;
        super.onDraw(canvas);
        if (this.f2673n <= 0 || this.f2674o == null || this.f2658c.size() <= 0 || this.f2664f == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f8 = this.f2673n / width2;
        int i7 = 0;
        f fVar = (f) this.f2658c.get(0);
        float f9 = fVar.f2693e;
        int size = this.f2658c.size();
        int i8 = fVar.f2690b;
        int i9 = ((f) this.f2658c.get(size - 1)).f2690b;
        while (i8 < i9) {
            while (true) {
                i6 = fVar.f2690b;
                if (i8 <= i6 || i7 >= size) {
                    break;
                }
                i7++;
                fVar = (f) this.f2658c.get(i7);
            }
            if (i8 == i6) {
                float f10 = fVar.f2693e;
                float f11 = fVar.f2692d;
                f6 = (f10 + f11) * width2;
                f9 = f10 + f11 + f8;
            } else {
                float f12 = this.f2664f.f(i8);
                f6 = (f9 + f12) * width2;
                f9 += f12 + f8;
            }
            if (this.f2673n + f6 > scrollX) {
                f7 = f8;
                this.f2674o.setBounds(Math.round(f6), this.f2675p, Math.round(this.f2673n + f6), this.f2676q);
                this.f2674o.draw(canvas);
            } else {
                f7 = f8;
            }
            if (f6 > scrollX + width) {
                return;
            }
            i8++;
            f8 = f7;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            H();
            return false;
        }
        if (action != 0) {
            if (this.f2685z) {
                return true;
            }
            if (this.A) {
                return false;
            }
        }
        if (action == 0) {
            float x5 = motionEvent.getX();
            this.G = x5;
            this.E = x5;
            float y5 = motionEvent.getY();
            this.H = y5;
            this.F = y5;
            this.I = motionEvent.getPointerId(0);
            this.A = false;
            this.f2671l = true;
            this.f2670k.computeScrollOffset();
            if (this.f2665f0 != 2 || Math.abs(this.f2670k.getFinalX() - this.f2670k.getCurrX()) <= this.N) {
                f(false);
                this.f2685z = false;
            } else {
                this.f2670k.abortAnimation();
                this.f2683x = false;
                C();
                this.f2685z = true;
                G(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i6 = this.I;
            if (i6 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i6);
                float x6 = motionEvent.getX(findPointerIndex);
                float f6 = x6 - this.E;
                float abs = Math.abs(f6);
                float y6 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y6 - this.H);
                int i7 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                if (i7 != 0 && !v(this.E, f6) && e(this, false, (int) f6, (int) x6, (int) y6)) {
                    this.E = x6;
                    this.F = y6;
                    this.A = true;
                    return false;
                }
                int i8 = this.D;
                if (abs > i8 && abs * 0.5f > abs2) {
                    this.f2685z = true;
                    G(true);
                    setScrollState(1);
                    float f7 = this.G;
                    float f8 = this.D;
                    this.E = i7 > 0 ? f7 + f8 : f7 - f8;
                    this.F = y6;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i8) {
                    this.A = true;
                }
                if (this.f2685z && B(x6)) {
                    b0.c0(this);
                }
            }
        } else if (action == 6) {
            x(motionEvent);
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        return this.f2685z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        boolean z6;
        f q5;
        int max;
        int i10;
        int max2;
        int i11;
        int childCount = getChildCount();
        int i12 = i8 - i6;
        int i13 = i9 - i7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f2694a) {
                    int i16 = gVar.f2695b;
                    int i17 = i16 & 7;
                    int i18 = i16 & 112;
                    if (i17 != 1) {
                        if (i17 == 3) {
                            i10 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i17 != 5) {
                            i10 = paddingLeft;
                        } else {
                            max = (i12 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i18 == 16) {
                            if (i18 == 48) {
                                i11 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i18 != 80) {
                                i11 = paddingTop;
                            } else {
                                max2 = (i13 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i19 = paddingLeft + scrollX;
                            childAt.layout(i19, paddingTop, childAt.getMeasuredWidth() + i19, paddingTop + childAt.getMeasuredHeight());
                            i14++;
                            paddingTop = i11;
                            paddingLeft = i10;
                        } else {
                            max2 = Math.max((i13 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i20 = max2;
                        i11 = paddingTop;
                        paddingTop = i20;
                        int i192 = paddingLeft + scrollX;
                        childAt.layout(i192, paddingTop, childAt.getMeasuredWidth() + i192, paddingTop + childAt.getMeasuredHeight());
                        i14++;
                        paddingTop = i11;
                        paddingLeft = i10;
                    } else {
                        max = Math.max((i12 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i21 = max;
                    i10 = paddingLeft;
                    paddingLeft = i21;
                    if (i18 == 16) {
                    }
                    int i202 = max2;
                    i11 = paddingTop;
                    paddingTop = i202;
                    int i1922 = paddingLeft + scrollX;
                    childAt.layout(i1922, paddingTop, childAt.getMeasuredWidth() + i1922, paddingTop + childAt.getMeasuredHeight());
                    i14++;
                    paddingTop = i11;
                    paddingLeft = i10;
                }
            }
        }
        int i22 = (i12 - paddingLeft) - paddingRight;
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt2 = getChildAt(i23);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.f2694a && (q5 = q(childAt2)) != null) {
                    float f6 = i22;
                    int i24 = ((int) (q5.f2693e * f6)) + paddingLeft;
                    if (gVar2.f2697d) {
                        gVar2.f2697d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f6 * gVar2.f2696c), 1073741824), View.MeasureSpec.makeMeasureSpec((i13 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i24, paddingTop, childAt2.getMeasuredWidth() + i24, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f2675p = paddingTop;
        this.f2676q = i13 - paddingBottom;
        this.U = i14;
        if (this.R) {
            z6 = false;
            I(this.f2666g, false, 0, false);
        } else {
            z6 = false;
        }
        this.R = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i6, int i7) {
        g gVar;
        g gVar2;
        int i8;
        int i9;
        int i10;
        setMeasuredDimension(View.getDefaultSize(0, i6), View.getDefaultSize(0, i7));
        int measuredWidth = getMeasuredWidth();
        this.C = Math.min(measuredWidth / 10, this.B);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i11 = 0;
        while (true) {
            boolean z5 = true;
            int i12 = 1073741824;
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.f2694a) {
                int i13 = gVar2.f2695b;
                int i14 = i13 & 7;
                int i15 = i13 & 112;
                boolean z6 = i15 == 48 || i15 == 80;
                if (i14 != 3 && i14 != 5) {
                    z5 = false;
                }
                int i16 = Integer.MIN_VALUE;
                if (z6) {
                    i16 = 1073741824;
                } else if (z5) {
                    i8 = 1073741824;
                    i9 = ((ViewGroup.LayoutParams) gVar2).width;
                    if (i9 == -2) {
                        if (i9 == -1) {
                            i9 = paddingLeft;
                        }
                        i16 = 1073741824;
                    } else {
                        i9 = paddingLeft;
                    }
                    i10 = ((ViewGroup.LayoutParams) gVar2).height;
                    if (i10 != -2) {
                        i10 = measuredHeight;
                        i12 = i8;
                    } else if (i10 == -1) {
                        i10 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i9, i16), View.MeasureSpec.makeMeasureSpec(i10, i12));
                    if (!z6) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z5) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i8 = Integer.MIN_VALUE;
                i9 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i9 == -2) {
                }
                i10 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i10 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i9, i16), View.MeasureSpec.makeMeasureSpec(i10, i12));
                if (!z6) {
                }
            }
            i11++;
        }
        this.f2679t = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f2680u = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f2681v = true;
        C();
        this.f2681v = false;
        int childCount2 = getChildCount();
        for (int i17 = 0; i17 < childCount2; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.f2694a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.f2696c), 1073741824), this.f2680u);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int i7;
        int i8;
        int i9;
        f q5;
        int childCount = getChildCount();
        if ((i6 & 2) != 0) {
            i8 = childCount;
            i7 = 0;
            i9 = 1;
        } else {
            i7 = childCount - 1;
            i8 = -1;
            i9 = -1;
        }
        while (i7 != i8) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0 && (q5 = q(childAt)) != null && q5.f2690b == this.f2666g && childAt.requestFocus(i6, rect)) {
                return true;
            }
            i7 += i9;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.e());
        androidx.viewpager.widget.a aVar = this.f2664f;
        if (aVar != null) {
            aVar.i(kVar.f2703d, kVar.f2704e);
            K(kVar.f2702c, false, true);
            return;
        }
        this.f2667h = kVar.f2702c;
        this.f2668i = kVar.f2703d;
        this.f2669j = kVar.f2704e;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f2702c = this.f2666g;
        androidx.viewpager.widget.a aVar = this.f2664f;
        if (aVar != null) {
            kVar.f2703d = aVar.j();
        }
        return kVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 != i8) {
            int i10 = this.f2673n;
            E(i6, i8, i10, i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        int pointerId;
        if (this.O) {
            return true;
        }
        boolean z5 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f2664f) == null || aVar.d() == 0) {
            return false;
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.f2685z) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.I);
                        if (findPointerIndex != -1) {
                            float x5 = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x5 - this.E);
                            float y5 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y5 - this.F);
                            if (abs > this.D && abs > abs2) {
                                this.f2685z = true;
                                G(true);
                                float f6 = this.G;
                                this.E = x5 - f6 > 0.0f ? f6 + this.D : f6 - this.D;
                                this.F = y5;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        z5 = H();
                    }
                    if (this.f2685z) {
                        z5 = false | B(motionEvent.getX(motionEvent.findPointerIndex(this.I)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.E = motionEvent.getX(actionIndex);
                        pointerId = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        x(motionEvent);
                        this.E = motionEvent.getX(motionEvent.findPointerIndex(this.I));
                    }
                } else if (this.f2685z) {
                    I(this.f2666g, true, 0, false);
                    z5 = H();
                }
            } else if (this.f2685z) {
                VelocityTracker velocityTracker = this.J;
                velocityTracker.computeCurrentVelocity(1000, this.L);
                int xVelocity = (int) velocityTracker.getXVelocity(this.I);
                this.f2683x = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                f r5 = r();
                float f7 = clientWidth;
                L(h(r5.f2690b, ((scrollX / f7) - r5.f2693e) / (r5.f2692d + (this.f2673n / f7)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.I)) - this.G)), true, true, xVelocity);
                z5 = H();
            }
            if (z5) {
                b0.c0(this);
            }
            return true;
        }
        this.f2670k.abortAnimation();
        this.f2683x = false;
        C();
        float x6 = motionEvent.getX();
        this.G = x6;
        this.E = x6;
        float y6 = motionEvent.getY();
        this.H = y6;
        this.F = y6;
        pointerId = motionEvent.getPointerId(0);
        this.I = pointerId;
        if (z5) {
        }
        return true;
    }

    f p(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return q(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    f q(View view) {
        for (int i6 = 0; i6 < this.f2658c.size(); i6++) {
            f fVar = (f) this.f2658c.get(i6);
            if (this.f2664f.h(view, fVar.f2689a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f2681v) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(int i6) {
        for (int i7 = 0; i7 < this.f2658c.size(); i7++) {
            f fVar = (f) this.f2658c.get(i7);
            if (fVar.f2690b == i6) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f2664f;
        if (aVar2 != null) {
            aVar2.m(null);
            this.f2664f.o(this);
            for (int i6 = 0; i6 < this.f2658c.size(); i6++) {
                f fVar = (f) this.f2658c.get(i6);
                this.f2664f.a(this, fVar.f2690b, fVar.f2689a);
            }
            this.f2664f.c(this);
            this.f2658c.clear();
            F();
            this.f2666g = 0;
            scrollTo(0, 0);
        }
        this.f2664f = aVar;
        this.f2656b = 0;
        if (aVar != null) {
            if (this.f2672m == null) {
                this.f2672m = new j();
            }
            this.f2664f.m(this.f2672m);
            this.f2683x = false;
            boolean z5 = this.R;
            this.R = true;
            this.f2656b = this.f2664f.d();
            if (this.f2667h >= 0) {
                this.f2664f.i(this.f2668i, this.f2669j);
                K(this.f2667h, false, true);
                this.f2667h = -1;
                this.f2668i = null;
                this.f2669j = null;
            } else if (z5) {
                requestLayout();
            } else {
                C();
            }
        }
        List list = this.f2657b0;
        if (list == null || list.isEmpty() || this.f2657b0.size() <= 0) {
            return;
        }
        android.support.v4.media.a.a(this.f2657b0.get(0));
        throw null;
    }

    public void setCurrentItem(int i6) {
        this.f2683x = false;
        K(i6, !this.R, false);
    }

    public void setOffscreenPageLimit(int i6) {
        if (i6 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i6 + " too small; defaulting to 1");
            i6 = 1;
        }
        if (i6 != this.f2684y) {
            this.f2684y = i6;
            C();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.W = iVar;
    }

    public void setPageMargin(int i6) {
        int i7 = this.f2673n;
        this.f2673n = i6;
        int width = getWidth();
        E(width, width, i6, i7);
        requestLayout();
    }

    public void setPageMarginDrawable(int i6) {
        setPageMarginDrawable(u.c.c(getContext(), i6));
    }

    void setScrollState(int i6) {
        if (this.f2665f0 == i6) {
            return;
        }
        this.f2665f0 = i6;
        k(i6);
    }

    void t() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f2670k = new Scroller(context, f2653i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f6 = context.getResources().getDisplayMetrics().density;
        this.D = viewConfiguration.getScaledPagingTouchSlop();
        this.K = (int) (400.0f * f6);
        this.L = viewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(context);
        this.Q = new EdgeEffect(context);
        this.M = (int) (25.0f * f6);
        this.N = (int) (2.0f * f6);
        this.B = (int) (f6 * 16.0f);
        b0.l0(this, new h());
        if (b0.z(this) == 0) {
            b0.u0(this, 1);
        }
        b0.w0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2674o;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void w(int i6, float f6, int i7) {
        int max;
        int i8;
        int left;
        if (this.U > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f2694a) {
                    int i10 = gVar.f2695b & 7;
                    if (i10 != 1) {
                        if (i10 == 3) {
                            i8 = childAt.getWidth() + paddingLeft;
                        } else if (i10 != 5) {
                            i8 = paddingLeft;
                        } else {
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i8;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i11 = max;
                    i8 = paddingLeft;
                    paddingLeft = i11;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i8;
                }
            }
        }
        i(i6, f6, i7);
        this.T = true;
    }

    boolean y() {
        int i6 = this.f2666g;
        if (i6 > 0) {
            J(i6 - 1, true);
            return true;
        }
        return false;
    }

    boolean z() {
        androidx.viewpager.widget.a aVar = this.f2664f;
        if (aVar == null || this.f2666g >= aVar.d() - 1) {
            return false;
        }
        J(this.f2666g + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f2674o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }
}
