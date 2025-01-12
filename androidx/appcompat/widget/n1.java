package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class n1 implements i.e {
    private static Method H;
    private static Method I;
    private static Method J;
    private final c A;
    private Runnable B;
    final Handler C;
    private final Rect D;
    private Rect E;
    private boolean F;
    PopupWindow G;

    /* renamed from: b  reason: collision with root package name */
    private Context f1017b;

    /* renamed from: c  reason: collision with root package name */
    private ListAdapter f1018c;

    /* renamed from: d  reason: collision with root package name */
    g1 f1019d;

    /* renamed from: e  reason: collision with root package name */
    private int f1020e;

    /* renamed from: f  reason: collision with root package name */
    private int f1021f;

    /* renamed from: g  reason: collision with root package name */
    private int f1022g;

    /* renamed from: h  reason: collision with root package name */
    private int f1023h;

    /* renamed from: i  reason: collision with root package name */
    private int f1024i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1025j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1026k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1027l;

    /* renamed from: m  reason: collision with root package name */
    private int f1028m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1029n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1030o;

    /* renamed from: p  reason: collision with root package name */
    int f1031p;

    /* renamed from: q  reason: collision with root package name */
    private View f1032q;

    /* renamed from: r  reason: collision with root package name */
    private int f1033r;

    /* renamed from: s  reason: collision with root package name */
    private DataSetObserver f1034s;

    /* renamed from: t  reason: collision with root package name */
    private View f1035t;

    /* renamed from: u  reason: collision with root package name */
    private Drawable f1036u;

    /* renamed from: v  reason: collision with root package name */
    private AdapterView.OnItemClickListener f1037v;

    /* renamed from: w  reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1038w;

    /* renamed from: x  reason: collision with root package name */
    final g f1039x;

    /* renamed from: y  reason: collision with root package name */
    private final f f1040y;

    /* renamed from: z  reason: collision with root package name */
    private final e f1041z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View t5 = n1.this.t();
            if (t5 == null || t5.getWindowToken() == null) {
                return;
            }
            n1.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i6, long j6) {
            g1 g1Var;
            if (i6 == -1 || (g1Var = n1.this.f1019d) == null) {
                return;
            }
            g1Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.r();
        }
    }

    /* loaded from: classes.dex */
    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (n1.this.c()) {
                n1.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            n1.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i6) {
            if (i6 != 1 || n1.this.A() || n1.this.G.getContentView() == null) {
                return;
            }
            n1 n1Var = n1.this;
            n1Var.C.removeCallbacks(n1Var.f1039x);
            n1.this.f1039x.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x5 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = n1.this.G) != null && popupWindow.isShowing() && x5 >= 0 && x5 < n1.this.G.getWidth() && y5 >= 0 && y5 < n1.this.G.getHeight()) {
                n1 n1Var = n1.this;
                n1Var.C.postDelayed(n1Var.f1039x, 250L);
                return false;
            } else if (action == 1) {
                n1 n1Var2 = n1.this;
                n1Var2.C.removeCallbacks(n1Var2.f1039x);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1 g1Var = n1.this.f1019d;
            if (g1Var == null || !e0.b0.Q(g1Var) || n1.this.f1019d.getCount() <= n1.this.f1019d.getChildCount()) {
                return;
            }
            int childCount = n1.this.f1019d.getChildCount();
            n1 n1Var = n1.this;
            if (childCount <= n1Var.f1031p) {
                n1Var.G.setInputMethodMode(2);
                n1.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public n1(Context context) {
        this(context, null, b.a.listPopupWindowStyle);
    }

    private void C() {
        View view = this.f1032q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1032q);
            }
        }
    }

    private void N(boolean z5) {
        if (Build.VERSION.SDK_INT > 28) {
            this.G.setIsClippedToScreen(z5);
            return;
        }
        Method method = H;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z5));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int q() {
        int i6;
        int i7;
        int makeMeasureSpec;
        int d6;
        int i8;
        int i9 = Integer.MIN_VALUE;
        if (this.f1019d == null) {
            Context context = this.f1017b;
            this.B = new a();
            g1 s5 = s(context, !this.F);
            this.f1019d = s5;
            Drawable drawable = this.f1036u;
            if (drawable != null) {
                s5.setSelector(drawable);
            }
            this.f1019d.setAdapter(this.f1018c);
            this.f1019d.setOnItemClickListener(this.f1037v);
            this.f1019d.setFocusable(true);
            this.f1019d.setFocusableInTouchMode(true);
            this.f1019d.setOnItemSelectedListener(new b());
            this.f1019d.setOnScrollListener(this.f1041z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1038w;
            if (onItemSelectedListener != null) {
                this.f1019d.setOnItemSelectedListener(onItemSelectedListener);
            }
            g1 g1Var = this.f1019d;
            View view = this.f1032q;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i10 = this.f1033r;
                if (i10 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(g1Var, layoutParams);
                } else if (i10 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f1033r);
                } else {
                    linearLayout.addView(g1Var, layoutParams);
                    linearLayout.addView(view);
                }
                int i11 = this.f1021f;
                if (i11 >= 0) {
                    i8 = Integer.MIN_VALUE;
                } else {
                    i11 = 0;
                    i8 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i11, i8), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i6 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                g1Var = linearLayout;
            } else {
                i6 = 0;
            }
            this.G.setContentView(g1Var);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.G.getContentView();
            View view2 = this.f1032q;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i6 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i6 = 0;
            }
        }
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i12 = rect.top;
            i7 = rect.bottom + i12;
            if (!this.f1025j) {
                this.f1023h = -i12;
            }
        } else {
            this.D.setEmpty();
            i7 = 0;
        }
        int u5 = u(t(), this.f1023h, this.G.getInputMethodMode() == 2);
        if (this.f1029n || this.f1020e == -1) {
            return u5 + i7;
        }
        int i13 = this.f1021f;
        if (i13 != -2) {
            i9 = 1073741824;
            if (i13 != -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                d6 = this.f1019d.d(makeMeasureSpec, 0, -1, u5 - i6, -1);
                if (d6 > 0) {
                    i6 += i7 + this.f1019d.getPaddingTop() + this.f1019d.getPaddingBottom();
                }
                return d6 + i6;
            }
        }
        int i14 = this.f1017b.getResources().getDisplayMetrics().widthPixels;
        Rect rect2 = this.D;
        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - (rect2.left + rect2.right), i9);
        d6 = this.f1019d.d(makeMeasureSpec, 0, -1, u5 - i6, -1);
        if (d6 > 0) {
        }
        return d6 + i6;
    }

    private int u(View view, int i6, boolean z5) {
        int maxAvailableHeight;
        if (Build.VERSION.SDK_INT > 23) {
            maxAvailableHeight = this.G.getMaxAvailableHeight(view, i6, z5);
            return maxAvailableHeight;
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, view, Integer.valueOf(i6), Boolean.valueOf(z5))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.G.getMaxAvailableHeight(view, i6);
    }

    public boolean A() {
        return this.G.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.F;
    }

    public void D(View view) {
        this.f1035t = view;
    }

    public void E(int i6) {
        this.G.setAnimationStyle(i6);
    }

    public void F(int i6) {
        Drawable background = this.G.getBackground();
        if (background == null) {
            Q(i6);
            return;
        }
        background.getPadding(this.D);
        Rect rect = this.D;
        this.f1021f = rect.left + rect.right + i6;
    }

    public void G(int i6) {
        this.f1028m = i6;
    }

    public void H(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void I(int i6) {
        this.G.setInputMethodMode(i6);
    }

    public void J(boolean z5) {
        this.F = z5;
        this.G.setFocusable(z5);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1037v = onItemClickListener;
    }

    public void M(boolean z5) {
        this.f1027l = true;
        this.f1026k = z5;
    }

    public void O(int i6) {
        this.f1033r = i6;
    }

    public void P(int i6) {
        g1 g1Var = this.f1019d;
        if (!c() || g1Var == null) {
            return;
        }
        g1Var.setListSelectionHidden(false);
        g1Var.setSelection(i6);
        if (g1Var.getChoiceMode() != 0) {
            g1Var.setItemChecked(i6, true);
        }
    }

    public void Q(int i6) {
        this.f1021f = i6;
    }

    @Override // i.e
    public void a() {
        int q5 = q();
        boolean A = A();
        androidx.core.widget.k.b(this.G, this.f1024i);
        boolean z5 = true;
        if (this.G.isShowing()) {
            if (e0.b0.Q(t())) {
                int i6 = this.f1021f;
                if (i6 == -1) {
                    i6 = -1;
                } else if (i6 == -2) {
                    i6 = t().getWidth();
                }
                int i7 = this.f1020e;
                if (i7 == -1) {
                    if (!A) {
                        q5 = -1;
                    }
                    if (A) {
                        this.G.setWidth(this.f1021f == -1 ? -1 : 0);
                        this.G.setHeight(0);
                    } else {
                        this.G.setWidth(this.f1021f == -1 ? -1 : 0);
                        this.G.setHeight(-1);
                    }
                } else if (i7 != -2) {
                    q5 = i7;
                }
                this.G.setOutsideTouchable((this.f1030o || this.f1029n) ? false : false);
                this.G.update(t(), this.f1022g, this.f1023h, i6 < 0 ? -1 : i6, q5 < 0 ? -1 : q5);
                return;
            }
            return;
        }
        int i8 = this.f1021f;
        if (i8 == -1) {
            i8 = -1;
        } else if (i8 == -2) {
            i8 = t().getWidth();
        }
        int i9 = this.f1020e;
        if (i9 == -1) {
            q5 = -1;
        } else if (i9 != -2) {
            q5 = i9;
        }
        this.G.setWidth(i8);
        this.G.setHeight(q5);
        N(true);
        this.G.setOutsideTouchable((this.f1030o || this.f1029n) ? false : true);
        this.G.setTouchInterceptor(this.f1040y);
        if (this.f1027l) {
            androidx.core.widget.k.a(this.G, this.f1026k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.G, this.E);
                } catch (Exception e6) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e6);
                }
            }
        } else {
            this.G.setEpicenterBounds(this.E);
        }
        androidx.core.widget.k.c(this.G, t(), this.f1022g, this.f1023h, this.f1028m);
        this.f1019d.setSelection(-1);
        if (!this.F || this.f1019d.isInTouchMode()) {
            r();
        }
        if (this.F) {
            return;
        }
        this.C.post(this.A);
    }

    @Override // i.e
    public boolean c() {
        return this.G.isShowing();
    }

    public int d() {
        return this.f1022g;
    }

    @Override // i.e
    public void dismiss() {
        this.G.dismiss();
        C();
        this.G.setContentView(null);
        this.f1019d = null;
        this.C.removeCallbacks(this.f1039x);
    }

    public Drawable f() {
        return this.G.getBackground();
    }

    @Override // i.e
    public ListView g() {
        return this.f1019d;
    }

    public void i(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public void j(int i6) {
        this.f1023h = i6;
        this.f1025j = true;
    }

    public void l(int i6) {
        this.f1022g = i6;
    }

    public int n() {
        if (this.f1025j) {
            return this.f1023h;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1034s;
        if (dataSetObserver == null) {
            this.f1034s = new d();
        } else {
            ListAdapter listAdapter2 = this.f1018c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1018c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1034s);
        }
        g1 g1Var = this.f1019d;
        if (g1Var != null) {
            g1Var.setAdapter(this.f1018c);
        }
    }

    public void r() {
        g1 g1Var = this.f1019d;
        if (g1Var != null) {
            g1Var.setListSelectionHidden(true);
            g1Var.requestLayout();
        }
    }

    g1 s(Context context, boolean z5) {
        return new g1(context, z5);
    }

    public View t() {
        return this.f1035t;
    }

    public Object v() {
        if (c()) {
            return this.f1019d.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (c()) {
            return this.f1019d.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (c()) {
            return this.f1019d.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (c()) {
            return this.f1019d.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.f1021f;
    }

    public n1(Context context, AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, 0);
    }

    public n1(Context context, AttributeSet attributeSet, int i6, int i7) {
        this.f1020e = -2;
        this.f1021f = -2;
        this.f1024i = 1002;
        this.f1028m = 0;
        this.f1029n = false;
        this.f1030o = false;
        this.f1031p = Integer.MAX_VALUE;
        this.f1033r = 0;
        this.f1039x = new g();
        this.f1040y = new f();
        this.f1041z = new e();
        this.A = new c();
        this.D = new Rect();
        this.f1017b = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.f2784o1, i6, i7);
        this.f1022g = obtainStyledAttributes.getDimensionPixelOffset(b.j.f2789p1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(b.j.f2794q1, 0);
        this.f1023h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1025j = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i6, i7);
        this.G = qVar;
        qVar.setInputMethodMode(1);
    }
}
