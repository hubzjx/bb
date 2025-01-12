package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import e0.b0;
import e0.r;
import e0.s;
import e0.t;
import e0.u;
import e0.v0;
import io.jsonwebtoken.JwtParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements r, s {

    /* renamed from: v  reason: collision with root package name */
    static final String f1503v;

    /* renamed from: w  reason: collision with root package name */
    static final Class[] f1504w;

    /* renamed from: x  reason: collision with root package name */
    static final ThreadLocal f1505x;

    /* renamed from: y  reason: collision with root package name */
    static final Comparator f1506y;

    /* renamed from: z  reason: collision with root package name */
    private static final d0.f f1507z;

    /* renamed from: b  reason: collision with root package name */
    private final List f1508b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a f1509c;

    /* renamed from: d  reason: collision with root package name */
    private final List f1510d;

    /* renamed from: e  reason: collision with root package name */
    private final List f1511e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f1512f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1513g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f1514h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1515i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1516j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f1517k;

    /* renamed from: l  reason: collision with root package name */
    private View f1518l;

    /* renamed from: m  reason: collision with root package name */
    private View f1519m;

    /* renamed from: n  reason: collision with root package name */
    private f f1520n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1521o;

    /* renamed from: p  reason: collision with root package name */
    private v0 f1522p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1523q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f1524r;

    /* renamed from: s  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f1525s;

    /* renamed from: t  reason: collision with root package name */
    private u f1526t;

    /* renamed from: u  reason: collision with root package name */
    private final t f1527u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements u {
        a() {
        }

        @Override // e0.u
        public v0 a(View view, v0 v0Var) {
            return CoordinatorLayout.this.U(v0Var);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public b() {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
            if (i7 == 0) {
                return z(coordinatorLayout, view, view2, view3, i6);
            }
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
            if (i6 == 0) {
                B(coordinatorLayout, view, view2);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public v0 f(CoordinatorLayout coordinatorLayout, View view, v0 v0Var) {
            return v0Var;
        }

        public void g(e eVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, int i8, int i9) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f6, float f7, boolean z5) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f6, float f7) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int[] iArr, int i8) {
            if (i8 == 0) {
                p(coordinatorLayout, view, view2, i6, i7, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int i8, int i9) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int i8, int i9, int i10) {
            if (i10 == 0) {
                r(coordinatorLayout, view, view2, i6, i7, i8, i9);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
            iArr[0] = iArr[0] + i8;
            iArr[1] = iArr[1] + i9;
            s(coordinatorLayout, view, view2, i6, i7, i8, i9, i10);
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
            if (i7 == 0) {
                u(coordinatorLayout, view, view2, view3, i6);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z5) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface c {
        Class value();
    }

    /* loaded from: classes.dex */
    private class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1525s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.F(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1525s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        b f1530a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1531b;

        /* renamed from: c  reason: collision with root package name */
        public int f1532c;

        /* renamed from: d  reason: collision with root package name */
        public int f1533d;

        /* renamed from: e  reason: collision with root package name */
        public int f1534e;

        /* renamed from: f  reason: collision with root package name */
        int f1535f;

        /* renamed from: g  reason: collision with root package name */
        public int f1536g;

        /* renamed from: h  reason: collision with root package name */
        public int f1537h;

        /* renamed from: i  reason: collision with root package name */
        int f1538i;

        /* renamed from: j  reason: collision with root package name */
        int f1539j;

        /* renamed from: k  reason: collision with root package name */
        View f1540k;

        /* renamed from: l  reason: collision with root package name */
        View f1541l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f1542m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f1543n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f1544o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f1545p;

        /* renamed from: q  reason: collision with root package name */
        final Rect f1546q;

        /* renamed from: r  reason: collision with root package name */
        Object f1547r;

        public e(int i6, int i7) {
            super(i6, i7);
            this.f1531b = false;
            this.f1532c = 0;
            this.f1533d = 0;
            this.f1534e = -1;
            this.f1535f = -1;
            this.f1536g = 0;
            this.f1537h = 0;
            this.f1546q = new Rect();
        }

        private void m(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f1535f);
            this.f1540k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f1541l = findViewById;
                    return;
                } else if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1535f) + " to anchor view " + view);
            }
            this.f1541l = null;
            this.f1540k = null;
        }

        private boolean r(View view, int i6) {
            int b6 = e0.d.b(((e) view.getLayoutParams()).f1536g, i6);
            return b6 != 0 && (e0.d.b(this.f1537h, i6) & b6) == b6;
        }

        private boolean s(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1540k.getId() != this.f1535f) {
                return false;
            }
            View view2 = this.f1540k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f1541l = null;
                    this.f1540k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f1541l = view2;
            return true;
        }

        boolean a() {
            return this.f1540k == null && this.f1535f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b bVar;
            return view2 == this.f1541l || r(view2, b0.B(coordinatorLayout)) || ((bVar = this.f1530a) != null && bVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f1530a == null) {
                this.f1542m = false;
            }
            return this.f1542m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1535f == -1) {
                this.f1541l = null;
                this.f1540k = null;
                return null;
            }
            if (this.f1540k == null || !s(view, coordinatorLayout)) {
                m(view, coordinatorLayout);
            }
            return this.f1540k;
        }

        public b e() {
            return this.f1530a;
        }

        boolean f() {
            return this.f1545p;
        }

        Rect g() {
            return this.f1546q;
        }

        boolean h(CoordinatorLayout coordinatorLayout, View view) {
            boolean z5 = this.f1542m;
            if (z5) {
                return true;
            }
            b bVar = this.f1530a;
            boolean a6 = (bVar != null ? bVar.a(coordinatorLayout, view) : false) | z5;
            this.f1542m = a6;
            return a6;
        }

        boolean i(int i6) {
            if (i6 != 0) {
                if (i6 != 1) {
                    return false;
                }
                return this.f1544o;
            }
            return this.f1543n;
        }

        void j() {
            this.f1545p = false;
        }

        void k(int i6) {
            q(i6, false);
        }

        void l() {
            this.f1542m = false;
        }

        public void n(b bVar) {
            b bVar2 = this.f1530a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.j();
                }
                this.f1530a = bVar;
                this.f1547r = null;
                this.f1531b = true;
                if (bVar != null) {
                    bVar.g(this);
                }
            }
        }

        void o(boolean z5) {
            this.f1545p = z5;
        }

        void p(Rect rect) {
            this.f1546q.set(rect);
        }

        void q(int i6, boolean z5) {
            if (i6 == 0) {
                this.f1543n = z5;
            } else if (i6 != 1) {
            } else {
                this.f1544o = z5;
            }
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1531b = false;
            this.f1532c = 0;
            this.f1533d = 0;
            this.f1534e = -1;
            this.f1535f = -1;
            this.f1536g = 0;
            this.f1537h = 0;
            this.f1546q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.c.f12904e);
            this.f1532c = obtainStyledAttributes.getInteger(r.c.f12905f, 0);
            this.f1535f = obtainStyledAttributes.getResourceId(r.c.f12906g, -1);
            this.f1533d = obtainStyledAttributes.getInteger(r.c.f12907h, 0);
            this.f1534e = obtainStyledAttributes.getInteger(r.c.f12911l, -1);
            this.f1536g = obtainStyledAttributes.getInt(r.c.f12910k, 0);
            this.f1537h = obtainStyledAttributes.getInt(r.c.f12909j, 0);
            int i6 = r.c.f12908i;
            boolean hasValue = obtainStyledAttributes.hasValue(i6);
            this.f1531b = hasValue;
            if (hasValue) {
                this.f1530a = CoordinatorLayout.I(context, attributeSet, obtainStyledAttributes.getString(i6));
            }
            obtainStyledAttributes.recycle();
            b bVar = this.f1530a;
            if (bVar != null) {
                bVar.g(this);
            }
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1531b = false;
            this.f1532c = 0;
            this.f1533d = 0;
            this.f1534e = -1;
            this.f1535f = -1;
            this.f1536g = 0;
            this.f1537h = 0;
            this.f1546q = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1531b = false;
            this.f1532c = 0;
            this.f1533d = 0;
            this.f1534e = -1;
            this.f1535f = -1;
            this.f1536g = 0;
            this.f1537h = 0;
            this.f1546q = new Rect();
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f1531b = false;
            this.f1532c = 0;
            this.f1533d = 0;
            this.f1534e = -1;
            this.f1535f = -1;
            this.f1536g = 0;
            this.f1537h = 0;
            this.f1546q = new Rect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.F(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class g extends h0.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        SparseArray f1549c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public g[] newArray(int i6) {
                return new g[i6];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1549c = new SparseArray(readInt);
            for (int i6 = 0; i6 < readInt; i6++) {
                this.f1549c.append(iArr[i6], readParcelableArray[i6]);
            }
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            SparseArray sparseArray = this.f1549c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = this.f1549c.keyAt(i7);
                parcelableArr[i7] = (Parcelable) this.f1549c.valueAt(i7);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i6);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    static class h implements Comparator {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float L = b0.L(view);
            float L2 = b0.L(view2);
            if (L > L2) {
                return -1;
            }
            return L < L2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f1503v = r02 != null ? r02.getName() : null;
        f1506y = new h();
        f1504w = new Class[]{Context.class, AttributeSet.class};
        f1505x = new ThreadLocal();
        f1507z = new d0.h(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, r.a.coordinatorLayoutStyle);
    }

    private void A(View view, int i6) {
        e eVar = (e) view.getLayoutParams();
        Rect a6 = a();
        a6.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.f1522p != null && b0.y(this) && !b0.y(view)) {
            a6.left += this.f1522p.g();
            a6.top += this.f1522p.i();
            a6.right -= this.f1522p.h();
            a6.bottom -= this.f1522p.f();
        }
        Rect a7 = a();
        e0.d.a(Q(eVar.f1532c), view.getMeasuredWidth(), view.getMeasuredHeight(), a6, a7, i6);
        view.layout(a7.left, a7.top, a7.right, a7.bottom);
        M(a6);
        M(a7);
    }

    private void B(View view, View view2, int i6) {
        Rect a6 = a();
        Rect a7 = a();
        try {
            r(view2, a6);
            s(view, i6, a6, a7);
            view.layout(a7.left, a7.top, a7.right, a7.bottom);
        } finally {
            M(a6);
            M(a7);
        }
    }

    private void C(View view, int i6, int i7) {
        e eVar = (e) view.getLayoutParams();
        int b6 = e0.d.b(R(eVar.f1532c), i7);
        int i8 = b6 & 7;
        int i9 = b6 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i7 == 1) {
            i6 = width - i6;
        }
        int u5 = u(i6) - measuredWidth;
        if (i8 == 1) {
            u5 += measuredWidth / 2;
        } else if (i8 == 5) {
            u5 += measuredWidth;
        }
        int i10 = 0;
        if (i9 == 16) {
            i10 = 0 + (measuredHeight / 2);
        } else if (i9 == 80) {
            i10 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(u5, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i10, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void D(View view, Rect rect, int i6) {
        boolean z5;
        boolean z6;
        int width;
        int i7;
        int i8;
        int i9;
        int height;
        int i10;
        int i11;
        int i12;
        if (b0.R(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b e6 = eVar.e();
            Rect a6 = a();
            Rect a7 = a();
            a7.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (e6 == null || !e6.b(this, view, a6)) {
                a6.set(a7);
            } else if (!a7.contains(a6)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a6.toShortString() + " | Bounds:" + a7.toShortString());
            }
            M(a7);
            if (a6.isEmpty()) {
                M(a6);
                return;
            }
            int b6 = e0.d.b(eVar.f1537h, i6);
            boolean z7 = true;
            if ((b6 & 48) != 48 || (i11 = (a6.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.f1539j) >= (i12 = rect.top)) {
                z5 = false;
            } else {
                T(view, i12 - i11);
                z5 = true;
            }
            if ((b6 & 80) == 80 && (height = ((getHeight() - a6.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.f1539j) < (i10 = rect.bottom)) {
                T(view, height - i10);
                z5 = true;
            }
            if (!z5) {
                T(view, 0);
            }
            if ((b6 & 3) != 3 || (i8 = (a6.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.f1538i) >= (i9 = rect.left)) {
                z6 = false;
            } else {
                S(view, i9 - i8);
                z6 = true;
            }
            if ((b6 & 5) != 5 || (width = ((getWidth() - a6.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.f1538i) >= (i7 = rect.right)) {
                z7 = z6;
            } else {
                S(view, width - i7);
            }
            if (!z7) {
                S(view, 0);
            }
            M(a6);
        }
    }

    static b I(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f1503v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + JwtParser.SEPARATOR_CHAR + str;
            }
        }
        try {
            ThreadLocal threadLocal = f1505x;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f1504w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e6) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e6);
        }
    }

    private boolean J(MotionEvent motionEvent, int i6) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f1510d;
        x(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) list.get(i7);
            e eVar = (e) view.getLayoutParams();
            b e6 = eVar.e();
            if (!(z5 || z6) || actionMasked == 0) {
                if (!z5 && e6 != null) {
                    if (i6 == 0) {
                        z5 = e6.k(this, view, motionEvent);
                    } else if (i6 == 1) {
                        z5 = e6.D(this, view, motionEvent);
                    }
                    if (z5) {
                        this.f1518l = view;
                    }
                }
                boolean c6 = eVar.c();
                boolean h6 = eVar.h(this, view);
                z6 = h6 && !c6;
                if (h6 && !z6) {
                    break;
                }
            } else if (e6 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i6 == 0) {
                    e6.k(this, view, motionEvent2);
                } else if (i6 == 1) {
                    e6.D(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z5;
    }

    private void K() {
        this.f1508b.clear();
        this.f1509c.c();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            e w5 = w(childAt);
            w5.d(this, childAt);
            this.f1509c.b(childAt);
            for (int i7 = 0; i7 < childCount; i7++) {
                if (i7 != i6) {
                    View childAt2 = getChildAt(i7);
                    if (w5.b(this, childAt, childAt2)) {
                        if (!this.f1509c.d(childAt2)) {
                            this.f1509c.b(childAt2);
                        }
                        this.f1509c.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f1508b.addAll(this.f1509c.h());
        Collections.reverse(this.f1508b);
    }

    private static void M(Rect rect) {
        rect.setEmpty();
        f1507z.a(rect);
    }

    private void O(boolean z5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            b e6 = ((e) childAt.getLayoutParams()).e();
            if (e6 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z5) {
                    e6.k(this, childAt, obtain);
                } else {
                    e6.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            ((e) getChildAt(i7).getLayoutParams()).l();
        }
        this.f1518l = null;
        this.f1515i = false;
    }

    private static int P(int i6) {
        if (i6 == 0) {
            return 17;
        }
        return i6;
    }

    private static int Q(int i6) {
        if ((i6 & 7) == 0) {
            i6 |= 8388611;
        }
        return (i6 & 112) == 0 ? i6 | 48 : i6;
    }

    private static int R(int i6) {
        if (i6 == 0) {
            return 8388661;
        }
        return i6;
    }

    private void S(View view, int i6) {
        e eVar = (e) view.getLayoutParams();
        int i7 = eVar.f1538i;
        if (i7 != i6) {
            b0.W(view, i6 - i7);
            eVar.f1538i = i6;
        }
    }

    private void T(View view, int i6) {
        e eVar = (e) view.getLayoutParams();
        int i7 = eVar.f1539j;
        if (i7 != i6) {
            b0.X(view, i6 - i7);
            eVar.f1539j = i6;
        }
    }

    private void V() {
        if (!b0.y(this)) {
            b0.w0(this, null);
            return;
        }
        if (this.f1526t == null) {
            this.f1526t = new a();
        }
        b0.w0(this, this.f1526t);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect rect = (Rect) f1507z.b();
        return rect == null ? new Rect() : rect;
    }

    private static int c(int i6, int i7, int i8) {
        return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
    }

    private void d(e eVar, Rect rect, int i6, int i7) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i6) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i7) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(max, max2, i6 + max, i7 + max2);
    }

    private v0 e(v0 v0Var) {
        b e6;
        if (v0Var.l()) {
            return v0Var;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (b0.y(childAt) && (e6 = ((e) childAt.getLayoutParams()).e()) != null) {
                v0Var = e6.f(this, childAt, v0Var);
                if (v0Var.l()) {
                    break;
                }
            }
        }
        return v0Var;
    }

    private void t(View view, int i6, Rect rect, Rect rect2, e eVar, int i7, int i8) {
        int b6 = e0.d.b(P(eVar.f1532c), i6);
        int b7 = e0.d.b(Q(eVar.f1533d), i6);
        int i9 = b6 & 7;
        int i10 = b6 & 112;
        int i11 = b7 & 7;
        int i12 = b7 & 112;
        int width = i11 != 1 ? i11 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i12 != 16 ? i12 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i9 == 1) {
            width -= i7 / 2;
        } else if (i9 != 5) {
            width -= i7;
        }
        if (i10 == 16) {
            height -= i8 / 2;
        } else if (i10 != 80) {
            height -= i8;
        }
        rect2.set(width, height, i7 + width, i8 + height);
    }

    private int u(int i6) {
        StringBuilder sb;
        int[] iArr = this.f1517k;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i6);
        } else if (i6 >= 0 && i6 < iArr.length) {
            return iArr[i6];
        } else {
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i6);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    private void x(List list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i6) : i6));
        }
        Comparator comparator = f1506y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean y(View view) {
        return this.f1509c.i(view);
    }

    void E(View view, int i6) {
        b e6;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f1540k != null) {
            Rect a6 = a();
            Rect a7 = a();
            Rect a8 = a();
            r(eVar.f1540k, a6);
            boolean z5 = false;
            p(view, false, a7);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            t(view, i6, a6, a8, eVar, measuredWidth, measuredHeight);
            z5 = (a8.left == a7.left && a8.top == a7.top) ? true : true;
            d(eVar, a8, measuredWidth, measuredHeight);
            int i7 = a8.left - a7.left;
            int i8 = a8.top - a7.top;
            if (i7 != 0) {
                b0.W(view, i7);
            }
            if (i8 != 0) {
                b0.X(view, i8);
            }
            if (z5 && (e6 = eVar.e()) != null) {
                e6.h(this, view, eVar.f1540k);
            }
            M(a6);
            M(a7);
            M(a8);
        }
    }

    final void F(int i6) {
        boolean z5;
        int B = b0.B(this);
        int size = this.f1508b.size();
        Rect a6 = a();
        Rect a7 = a();
        Rect a8 = a();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) this.f1508b.get(i7);
            e eVar = (e) view.getLayoutParams();
            if (i6 != 0 || view.getVisibility() != 8) {
                for (int i8 = 0; i8 < i7; i8++) {
                    if (eVar.f1541l == ((View) this.f1508b.get(i8))) {
                        E(view, B);
                    }
                }
                p(view, true, a7);
                if (eVar.f1536g != 0 && !a7.isEmpty()) {
                    int b6 = e0.d.b(eVar.f1536g, B);
                    int i9 = b6 & 112;
                    if (i9 == 48) {
                        a6.top = Math.max(a6.top, a7.bottom);
                    } else if (i9 == 80) {
                        a6.bottom = Math.max(a6.bottom, getHeight() - a7.top);
                    }
                    int i10 = b6 & 7;
                    if (i10 == 3) {
                        a6.left = Math.max(a6.left, a7.right);
                    } else if (i10 == 5) {
                        a6.right = Math.max(a6.right, getWidth() - a7.left);
                    }
                }
                if (eVar.f1537h != 0 && view.getVisibility() == 0) {
                    D(view, a6, B);
                }
                if (i6 != 2) {
                    v(view, a8);
                    if (!a8.equals(a7)) {
                        L(view, a7);
                    }
                }
                for (int i11 = i7 + 1; i11 < size; i11++) {
                    View view2 = (View) this.f1508b.get(i11);
                    e eVar2 = (e) view2.getLayoutParams();
                    b e6 = eVar2.e();
                    if (e6 != null && e6.e(this, view2, view)) {
                        if (i6 == 0 && eVar2.f()) {
                            eVar2.j();
                        } else {
                            if (i6 != 2) {
                                z5 = e6.h(this, view2, view);
                            } else {
                                e6.i(this, view2, view);
                                z5 = true;
                            }
                            if (i6 == 1) {
                                eVar2.o(z5);
                            }
                        }
                    }
                }
            }
        }
        M(a6);
        M(a7);
        M(a8);
    }

    public void G(View view, int i6) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = eVar.f1540k;
        if (view2 != null) {
            B(view, view2, i6);
            return;
        }
        int i7 = eVar.f1534e;
        if (i7 >= 0) {
            C(view, i7, i6);
        } else {
            A(view, i6);
        }
    }

    public void H(View view, int i6, int i7, int i8, int i9) {
        measureChildWithMargins(view, i6, i7, i8, i9);
    }

    void L(View view, Rect rect) {
        ((e) view.getLayoutParams()).p(rect);
    }

    void N() {
        if (this.f1516j && this.f1520n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1520n);
        }
        this.f1521o = false;
    }

    final v0 U(v0 v0Var) {
        if (d0.d.a(this.f1522p, v0Var)) {
            return v0Var;
        }
        this.f1522p = v0Var;
        boolean z5 = true;
        boolean z6 = v0Var != null && v0Var.i() > 0;
        this.f1523q = z6;
        setWillNotDraw((z6 || getBackground() != null) ? false : false);
        v0 e6 = e(v0Var);
        requestLayout();
        return e6;
    }

    void b() {
        if (this.f1516j) {
            if (this.f1520n == null) {
                this.f1520n = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1520n);
        }
        this.f1521o = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j6) {
        e eVar = (e) view.getLayoutParams();
        b bVar = eVar.f1530a;
        if (bVar != null) {
            float d6 = bVar.d(this, view);
            if (d6 > 0.0f) {
                if (this.f1512f == null) {
                    this.f1512f = new Paint();
                }
                this.f1512f.setColor(eVar.f1530a.c(this, view));
                this.f1512f.setAlpha(c(Math.round(d6 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f1512f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1524r;
        boolean z5 = false;
        if (drawable != null && drawable.isStateful()) {
            z5 = false | drawable.setState(drawableState);
        }
        if (z5) {
            invalidate();
        }
    }

    void f() {
        int childCount = getChildCount();
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (y(getChildAt(i6))) {
                z5 = true;
                break;
            } else {
                i6++;
            }
        }
        if (z5 != this.f1521o) {
            if (z5) {
                b();
            } else {
                N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    final List<View> getDependencySortedChildren() {
        K();
        return Collections.unmodifiableList(this.f1508b);
    }

    public final v0 getLastWindowInsets() {
        return this.f1522p;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1527u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f1524r;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // e0.r
    public void h(View view, View view2, int i6, int i7) {
        b e6;
        this.f1527u.c(view, view2, i6, i7);
        this.f1519m = view2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i7) && (e6 = eVar.e()) != null) {
                e6.v(this, childAt, view, view2, i6, i7);
            }
        }
    }

    @Override // e0.r
    public void i(View view, int i6) {
        this.f1527u.d(view, i6);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i6)) {
                b e6 = eVar.e();
                if (e6 != null) {
                    e6.C(this, childAt, view, i6);
                }
                eVar.k(i6);
                eVar.j();
            }
        }
        this.f1519m = null;
    }

    @Override // e0.r
    public void j(View view, int i6, int i7, int[] iArr, int i8) {
        b e6;
        int childCount = getChildCount();
        boolean z5 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i8) && (e6 = eVar.e()) != null) {
                    int[] iArr2 = this.f1513g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    e6.q(this, childAt, view, i6, i7, iArr2, i8);
                    int[] iArr3 = this.f1513g;
                    i9 = i6 > 0 ? Math.max(i9, iArr3[0]) : Math.min(i9, iArr3[0]);
                    int[] iArr4 = this.f1513g;
                    i10 = i7 > 0 ? Math.max(i10, iArr4[1]) : Math.min(i10, iArr4[1]);
                    z5 = true;
                }
            }
        }
        iArr[0] = i9;
        iArr[1] = i10;
        if (z5) {
            F(1);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: k */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: l */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // e0.s
    public void m(View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        b e6;
        int childCount = getChildCount();
        boolean z5 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i10) && (e6 = eVar.e()) != null) {
                    int[] iArr2 = this.f1513g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    e6.t(this, childAt, view, i6, i7, i8, i9, i10, iArr2);
                    int[] iArr3 = this.f1513g;
                    i11 = i8 > 0 ? Math.max(i11, iArr3[0]) : Math.min(i11, iArr3[0]);
                    i12 = i9 > 0 ? Math.max(i12, this.f1513g[1]) : Math.min(i12, this.f1513g[1]);
                    z5 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i11;
        iArr[1] = iArr[1] + i12;
        if (z5) {
            F(1);
        }
    }

    @Override // e0.r
    public void n(View view, int i6, int i7, int i8, int i9, int i10) {
        m(view, i6, i7, i8, i9, 0, this.f1514h);
    }

    @Override // e0.r
    public boolean o(View view, View view2, int i6, int i7) {
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b e6 = eVar.e();
                if (e6 != null) {
                    boolean A = e6.A(this, childAt, view, view2, i6, i7);
                    z5 |= A;
                    eVar.q(i7, A);
                } else {
                    eVar.q(i7, false);
                }
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O(false);
        if (this.f1521o) {
            if (this.f1520n == null) {
                this.f1520n = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1520n);
        }
        if (this.f1522p == null && b0.y(this)) {
            b0.i0(this);
        }
        this.f1516j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O(false);
        if (this.f1521o && this.f1520n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1520n);
        }
        View view = this.f1519m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f1516j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1523q || this.f1524r == null) {
            return;
        }
        v0 v0Var = this.f1522p;
        int i6 = v0Var != null ? v0Var.i() : 0;
        if (i6 > 0) {
            this.f1524r.setBounds(0, 0, getWidth(), i6);
            this.f1524r.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            O(true);
        }
        boolean J = J(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            O(true);
        }
        return J;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        b e6;
        int B = b0.B(this);
        int size = this.f1508b.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = (View) this.f1508b.get(i10);
            if (view.getVisibility() != 8 && ((e6 = ((e) view.getLayoutParams()).e()) == null || !e6.l(this, view, B))) {
                G(view, B);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        b e6;
        e eVar;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        K();
        f();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int B = b0.B(this);
        boolean z5 = B == 1;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        int i18 = paddingLeft + paddingRight;
        int i19 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z6 = this.f1522p != null && b0.y(this);
        int size3 = this.f1508b.size();
        int i20 = suggestedMinimumWidth;
        int i21 = suggestedMinimumHeight;
        int i22 = 0;
        int i23 = 0;
        while (i23 < size3) {
            View view = (View) this.f1508b.get(i23);
            if (view.getVisibility() == 8) {
                i16 = i23;
                i13 = size3;
                i14 = paddingLeft;
            } else {
                e eVar2 = (e) view.getLayoutParams();
                int i24 = eVar2.f1534e;
                if (i24 < 0 || mode == 0) {
                    i8 = i22;
                } else {
                    int u5 = u(i24);
                    int b6 = e0.d.b(R(eVar2.f1532c), B) & 7;
                    i8 = i22;
                    if ((b6 == 3 && !z5) || (b6 == 5 && z5)) {
                        i9 = Math.max(0, (size - paddingRight) - u5);
                    } else if ((b6 == 5 && !z5) || (b6 == 3 && z5)) {
                        i9 = Math.max(0, u5 - paddingLeft);
                    }
                    if (z6 || b0.y(view)) {
                        i10 = i6;
                        i11 = i7;
                    } else {
                        i10 = View.MeasureSpec.makeMeasureSpec(size - (this.f1522p.g() + this.f1522p.h()), mode);
                        i11 = View.MeasureSpec.makeMeasureSpec(size2 - (this.f1522p.i() + this.f1522p.f()), mode2);
                    }
                    e6 = eVar2.e();
                    if (e6 == null) {
                        eVar = eVar2;
                        i15 = i8;
                        i16 = i23;
                        i12 = i21;
                        i14 = paddingLeft;
                        i17 = i20;
                        i13 = size3;
                    } else {
                        eVar = eVar2;
                        i12 = i21;
                        i13 = size3;
                        i14 = paddingLeft;
                        i15 = i8;
                        i16 = i23;
                        i17 = i20;
                    }
                    H(view, i10, i9, i11, 0);
                    e eVar3 = eVar;
                    int max = Math.max(i17, i18 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar3).leftMargin + ((ViewGroup.MarginLayoutParams) eVar3).rightMargin);
                    int max2 = Math.max(i12, i19 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin);
                    i22 = View.combineMeasuredStates(i15, view.getMeasuredState());
                    i20 = max;
                    i21 = max2;
                }
                i9 = 0;
                if (z6) {
                }
                i10 = i6;
                i11 = i7;
                e6 = eVar2.e();
                if (e6 == null) {
                }
                H(view, i10, i9, i11, 0);
                e eVar32 = eVar;
                int max3 = Math.max(i17, i18 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar32).leftMargin + ((ViewGroup.MarginLayoutParams) eVar32).rightMargin);
                int max22 = Math.max(i12, i19 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar32).topMargin + ((ViewGroup.MarginLayoutParams) eVar32).bottomMargin);
                i22 = View.combineMeasuredStates(i15, view.getMeasuredState());
                i20 = max3;
                i21 = max22;
            }
            i23 = i16 + 1;
            paddingLeft = i14;
            size3 = i13;
        }
        int i25 = i22;
        setMeasuredDimension(View.resolveSizeAndState(i20, i6, (-16777216) & i25), View.resolveSizeAndState(i21, i7, i25 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f6, float f7, boolean z5) {
        b e6;
        int childCount = getChildCount();
        boolean z6 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (e6 = eVar.e()) != null) {
                    z6 |= e6.n(this, childAt, view, f6, f7, z5);
                }
            }
        }
        if (z6) {
            F(1);
        }
        return z6;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f6, float f7) {
        b e6;
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (e6 = eVar.e()) != null) {
                    z5 |= e6.o(this, childAt, view, f6, f7);
                }
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i6, int i7, int[] iArr) {
        j(view, i6, i7, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i6, int i7, int i8, int i9) {
        n(view, i6, i7, i8, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i6) {
        h(view, view2, i6, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.e());
        SparseArray sparseArray = gVar.f1549c;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            b e6 = w(childAt).e();
            if (id != -1 && e6 != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                e6.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable y5;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            b e6 = ((e) childAt.getLayoutParams()).e();
            if (id != -1 && e6 != null && (y5 = e6.y(this, childAt)) != null) {
                sparseArray.append(id, y5);
            }
        }
        gVar.f1549c = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i6) {
        return o(view, view2, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean D;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f1518l == null) {
            z5 = J(motionEvent, 1);
        } else {
            z5 = false;
        }
        b e6 = ((e) this.f1518l.getLayoutParams()).e();
        if (e6 != null) {
            D = e6.D(this, this.f1518l, motionEvent);
            motionEvent2 = null;
            if (this.f1518l != null) {
                D |= super.onTouchEvent(motionEvent);
            } else if (z5) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                O(false);
            }
            return D;
        }
        D = false;
        motionEvent2 = null;
        if (this.f1518l != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked != 1) {
        }
        O(false);
        return D;
    }

    void p(View view, boolean z5, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z5) {
            r(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List q(View view) {
        List g6 = this.f1509c.g(view);
        this.f1511e.clear();
        if (g6 != null) {
            this.f1511e.addAll(g6);
        }
        return this.f1511e;
    }

    void r(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        b e6 = ((e) view.getLayoutParams()).e();
        if (e6 == null || !e6.w(this, view, rect, z5)) {
            return super.requestChildRectangleOnScreen(view, rect, z5);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        super.requestDisallowInterceptTouchEvent(z5);
        if (!z5 || this.f1515i) {
            return;
        }
        O(false);
        this.f1515i = true;
    }

    void s(View view, int i6, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        t(view, i6, rect, rect2, eVar, measuredWidth, measuredHeight);
        d(eVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z5) {
        super.setFitsSystemWindows(z5);
        V();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1525s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1524r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f1524r = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f1524r.setState(getDrawableState());
                }
                x.b.m(this.f1524r, b0.B(this));
                this.f1524r.setVisible(getVisibility() == 0, false);
                this.f1524r.setCallback(this);
            }
            b0.c0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i6) {
        setStatusBarBackground(new ColorDrawable(i6));
    }

    public void setStatusBarBackgroundResource(int i6) {
        setStatusBarBackground(i6 != 0 ? u.c.c(getContext(), i6) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        boolean z5 = i6 == 0;
        Drawable drawable = this.f1524r;
        if (drawable == null || drawable.isVisible() == z5) {
            return;
        }
        this.f1524r.setVisible(z5, false);
    }

    void v(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).g());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1524r;
    }

    e w(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f1531b) {
            c cVar = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                cVar = (c) cls.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    eVar.n((b) cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e6) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e6);
                }
            }
            eVar.f1531b = true;
        }
        return eVar;
    }

    public boolean z(View view, int i6, int i7) {
        Rect a6 = a();
        r(view, a6);
        try {
            return a6.contains(i6, i7);
        } finally {
            M(a6);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1508b = new ArrayList();
        this.f1509c = new androidx.coordinatorlayout.widget.a();
        this.f1510d = new ArrayList();
        this.f1511e = new ArrayList();
        this.f1513g = new int[2];
        this.f1514h = new int[2];
        this.f1527u = new t(this);
        int[] iArr = r.c.f12901b;
        TypedArray obtainStyledAttributes = i6 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, r.b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = r.c.f12901b;
            if (i6 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, 0, r.b.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, i6, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(r.c.f12902c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f1517k = resources.getIntArray(resourceId);
            float f6 = resources.getDisplayMetrics().density;
            int length = this.f1517k.length;
            for (int i7 = 0; i7 < length; i7++) {
                int[] iArr3 = this.f1517k;
                iArr3[i7] = (int) (iArr3[i7] * f6);
            }
        }
        this.f1524r = obtainStyledAttributes.getDrawable(r.c.f12903d);
        obtainStyledAttributes.recycle();
        V();
        super.setOnHierarchyChangeListener(new d());
        if (b0.z(this) == 0) {
            b0.u0(this, 1);
        }
    }
}
