package e0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import e0.a;
import e0.v0;
import f0.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: c  reason: collision with root package name */
    private static Field f9331c;

    /* renamed from: e  reason: collision with root package name */
    private static ThreadLocal f9333e;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f9329a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static WeakHashMap f9330b = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f9332d = false;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f9334f = {s.b.accessibility_custom_action_0, s.b.accessibility_custom_action_1, s.b.accessibility_custom_action_2, s.b.accessibility_custom_action_3, s.b.accessibility_custom_action_4, s.b.accessibility_custom_action_5, s.b.accessibility_custom_action_6, s.b.accessibility_custom_action_7, s.b.accessibility_custom_action_8, s.b.accessibility_custom_action_9, s.b.accessibility_custom_action_10, s.b.accessibility_custom_action_11, s.b.accessibility_custom_action_12, s.b.accessibility_custom_action_13, s.b.accessibility_custom_action_14, s.b.accessibility_custom_action_15, s.b.accessibility_custom_action_16, s.b.accessibility_custom_action_17, s.b.accessibility_custom_action_18, s.b.accessibility_custom_action_19, s.b.accessibility_custom_action_20, s.b.accessibility_custom_action_21, s.b.accessibility_custom_action_22, s.b.accessibility_custom_action_23, s.b.accessibility_custom_action_24, s.b.accessibility_custom_action_25, s.b.accessibility_custom_action_26, s.b.accessibility_custom_action_27, s.b.accessibility_custom_action_28, s.b.accessibility_custom_action_29, s.b.accessibility_custom_action_30, s.b.accessibility_custom_action_31};

    /* renamed from: g  reason: collision with root package name */
    private static final v f9335g = new a();

    /* renamed from: h  reason: collision with root package name */
    private static f f9336h = new f();

    /* loaded from: classes.dex */
    class a implements v {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g {
        b(int i6, Class cls, int i7) {
            super(i6, cls, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: i */
        public Boolean d(View view) {
            boolean isScreenReaderFocusable;
            isScreenReaderFocusable = view.isScreenReaderFocusable();
            return Boolean.valueOf(isScreenReaderFocusable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g {
        c(int i6, Class cls, int i7, int i8) {
            super(i6, cls, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: i */
        public CharSequence d(View view) {
            CharSequence accessibilityPaneTitle;
            accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            return accessibilityPaneTitle;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g {
        d(int i6, Class cls, int i7, int i8) {
            super(i6, cls, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g {
        e(int i6, Class cls, int i7) {
            super(i6, cls, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: i */
        public Boolean d(View view) {
            boolean isAccessibilityHeading;
            isAccessibilityHeading = view.isAccessibilityHeading();
            return Boolean.valueOf(isAccessibilityHeading);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.b0.g
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* loaded from: classes.dex */
    static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private WeakHashMap f9337b = new WeakHashMap();

        f() {
        }

        private void a(View view, boolean z5) {
            boolean z6 = view.getVisibility() == 0;
            if (z5 != z6) {
                b0.V(view, z6 ? 16 : 32);
                this.f9337b.put(view, Boolean.valueOf(z6));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.f9337b.entrySet()) {
                    a((View) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        private final int f9338a;

        /* renamed from: b  reason: collision with root package name */
        private final Class f9339b;

        /* renamed from: c  reason: collision with root package name */
        private final int f9340c;

        /* renamed from: d  reason: collision with root package name */
        private final int f9341d;

        g(int i6, Class cls, int i7) {
            this(i6, cls, 0, i7);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f9340c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        abstract Object d(View view);

        abstract void e(View view, Object obj);

        Object f(View view) {
            if (c()) {
                return d(view);
            }
            if (b()) {
                Object tag = view.getTag(this.f9338a);
                if (this.f9339b.isInstance(tag)) {
                    return tag;
                }
                return null;
            }
            return null;
        }

        void g(View view, Object obj) {
            if (c()) {
                e(view, obj);
            } else if (b() && h(f(view), obj)) {
                b0.E(view);
                view.setTag(this.f9338a, obj);
                b0.V(view, this.f9341d);
            }
        }

        abstract boolean h(Object obj, Object obj2);

        g(int i6, Class cls, int i7, int i8) {
            this.f9338a = i6;
            this.f9339b = cls;
            this.f9341d = i7;
            this.f9340c = i8;
        }
    }

    /* loaded from: classes.dex */
    private static class h {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            v0 f9342a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f9343b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ u f9344c;

            a(View view, u uVar) {
                this.f9343b = view;
                this.f9344c = uVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                v0 t5 = v0.t(windowInsets, view);
                int i6 = Build.VERSION.SDK_INT;
                if (i6 < 30) {
                    h.a(windowInsets, this.f9343b);
                    if (t5.equals(this.f9342a)) {
                        return this.f9344c.a(view, t5).r();
                    }
                }
                this.f9342a = t5;
                v0 a6 = this.f9344c.a(view, t5);
                if (i6 >= 30) {
                    return a6.r();
                }
                b0.i0(view);
                return a6.r();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(s.b.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static v0 b(View view, v0 v0Var, Rect rect) {
            WindowInsets r5 = v0Var.r();
            if (r5 != null) {
                return v0.t(view.computeSystemWindowInsets(r5, rect), view);
            }
            rect.setEmpty();
            return v0Var;
        }

        public static v0 c(View view) {
            return v0.a.a(view);
        }

        static void d(View view, u uVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(s.b.tag_on_apply_window_listener, uVar);
            }
            if (uVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(s.b.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, uVar));
            }
        }
    }

    /* loaded from: classes.dex */
    private static class i {
        public static v0 a(View view) {
            WindowInsets rootWindowInsets;
            rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            v0 s5 = v0.s(rootWindowInsets);
            s5.p(s5);
            s5.d(view.getRootView());
            return s5;
        }
    }

    /* loaded from: classes.dex */
    private static class j {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i6, int i7) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i6, i7);
        }
    }

    /* loaded from: classes.dex */
    static class k {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList f9345d = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap f9346a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray f9347b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference f9348c = null;

        k() {
        }

        static k a(View view) {
            int i6 = s.b.tag_unhandled_key_event_manager;
            k kVar = (k) view.getTag(i6);
            if (kVar == null) {
                k kVar2 = new k();
                view.setTag(i6, kVar2);
                return kVar2;
            }
            return kVar;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f9346a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c6 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c6 != null) {
                            return c6;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.f9347b == null) {
                this.f9347b = new SparseArray();
            }
            return this.f9347b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(s.b.tag_unhandled_key_listeners);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.a.a(arrayList.get(size));
            throw null;
        }

        private void g() {
            WeakHashMap weakHashMap = this.f9346a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f9345d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f9346a == null) {
                    this.f9346a = new WeakHashMap();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList arrayList2 = f9345d;
                    View view = (View) ((WeakReference) arrayList2.get(size)).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f9346a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f9346a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c6 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c6 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c6));
                }
            }
            return c6 != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int indexOfKey;
            WeakReference weakReference2 = this.f9348c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                this.f9348c = new WeakReference(keyEvent);
                SparseArray d6 = d();
                if (keyEvent.getAction() != 1 || (indexOfKey = d6.indexOfKey(keyEvent.getKeyCode())) < 0) {
                    weakReference = null;
                } else {
                    weakReference = (WeakReference) d6.valueAt(indexOfKey);
                    d6.removeAt(indexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) d6.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view = (View) weakReference.get();
                    if (view != null && b0.Q(view)) {
                        e(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static int A(View view) {
        int importantForAutofill;
        if (Build.VERSION.SDK_INT >= 26) {
            importantForAutofill = view.getImportantForAutofill();
            return importantForAutofill;
        }
        return 0;
    }

    private static void A0(View view) {
        if (z(view) == 0) {
            u0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (z((View) parent) == 4) {
                u0(view, 2);
                return;
            }
        }
    }

    public static int B(View view) {
        return view.getLayoutDirection();
    }

    private static g B0() {
        return new d(s.b.tag_state_description, CharSequence.class, 64, 30);
    }

    public static int C(View view) {
        return view.getMinimumHeight();
    }

    public static void C0(View view) {
        view.stopNestedScroll();
    }

    public static int D(View view) {
        return view.getMinimumWidth();
    }

    private static void D0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    static e0.a E(View view) {
        e0.a l6 = l(view);
        if (l6 == null) {
            l6 = new e0.a();
        }
        l0(view, l6);
        return l6;
    }

    public static int F(View view) {
        return view.getPaddingEnd();
    }

    public static int G(View view) {
        return view.getPaddingStart();
    }

    public static v0 H(View view) {
        return Build.VERSION.SDK_INT >= 23 ? i.a(view) : h.c(view);
    }

    public static final CharSequence I(View view) {
        return (CharSequence) B0().f(view);
    }

    public static String J(View view) {
        return view.getTransitionName();
    }

    public static int K(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float L(View view) {
        return view.getZ();
    }

    public static boolean M(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean N(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean O(View view) {
        return view.hasTransientState();
    }

    public static boolean P(View view) {
        Boolean bool = (Boolean) a().f(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean Q(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean R(View view) {
        return view.isLaidOut();
    }

    public static boolean S(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean T(View view) {
        return view.isPaddingRelative();
    }

    public static boolean U(View view) {
        Boolean bool = (Boolean) k0().f(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    static void V(View view, int i6) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z5 = p(view) != null && view.getVisibility() == 0;
            if (o(view) != 0 || z5) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z5 ? 32 : 2048);
                obtain.setContentChangeTypes(i6);
                if (z5) {
                    obtain.getText().add(p(view));
                    A0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i6 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i6);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i6);
                } catch (AbstractMethodError e6) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e6);
                }
            }
        }
    }

    public static void W(View view, int i6) {
        boolean z5;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i6);
            return;
        }
        Rect x5 = x();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            x5.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z5 = !x5.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z5 = false;
        }
        e(view, i6);
        if (z5 && x5.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(x5);
        }
    }

    public static void X(View view, int i6) {
        boolean z5;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i6);
            return;
        }
        Rect x5 = x();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            x5.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z5 = !x5.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z5 = false;
        }
        f(view, i6);
        if (z5 && x5.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(x5);
        }
    }

    public static v0 Y(View view, v0 v0Var) {
        WindowInsets r5 = v0Var.r();
        if (r5 != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(r5);
            if (!onApplyWindowInsets.equals(r5)) {
                return v0.t(onApplyWindowInsets, view);
            }
        }
        return v0Var;
    }

    public static void Z(View view, f0.y yVar) {
        view.onInitializeAccessibilityNodeInfo(yVar.v0());
    }

    private static g a() {
        return new e(s.b.tag_accessibility_heading, Boolean.class, 28);
    }

    private static g a0() {
        return new c(s.b.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static int b(View view, CharSequence charSequence, f0.b0 b0Var) {
        int r5 = r(view);
        if (r5 != -1) {
            c(view, new y.a(r5, charSequence, b0Var));
        }
        return r5;
    }

    public static boolean b0(View view, int i6, Bundle bundle) {
        return view.performAccessibilityAction(i6, bundle);
    }

    private static void c(View view, y.a aVar) {
        E(view);
        g0(aVar.b(), view);
        q(view).add(aVar);
        V(view, 0);
    }

    public static void c0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static r0 d(View view) {
        if (f9330b == null) {
            f9330b = new WeakHashMap();
        }
        r0 r0Var = (r0) f9330b.get(view);
        if (r0Var == null) {
            r0 r0Var2 = new r0(view);
            f9330b.put(view, r0Var2);
            return r0Var2;
        }
        return r0Var;
    }

    public static void d0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    private static void e(View view, int i6) {
        view.offsetLeftAndRight(i6);
        if (view.getVisibility() == 0) {
            D0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                D0((View) parent);
            }
        }
    }

    public static void e0(View view, Runnable runnable, long j6) {
        view.postOnAnimationDelayed(runnable, j6);
    }

    private static void f(View view, int i6) {
        view.offsetTopAndBottom(i6);
        if (view.getVisibility() == 0) {
            D0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                D0((View) parent);
            }
        }
    }

    public static void f0(View view, int i6) {
        g0(i6, view);
        V(view, 0);
    }

    public static v0 g(View view, v0 v0Var, Rect rect) {
        return h.b(view, v0Var, rect);
    }

    private static void g0(int i6, View view) {
        List q5 = q(view);
        for (int i7 = 0; i7 < q5.size(); i7++) {
            if (((y.a) q5.get(i7)).b() == i6) {
                q5.remove(i7);
                return;
            }
        }
    }

    public static v0 h(View view, v0 v0Var) {
        WindowInsets r5 = v0Var.r();
        if (r5 != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(r5);
            if (!dispatchApplyWindowInsets.equals(r5)) {
                return v0.t(dispatchApplyWindowInsets, view);
            }
        }
        return v0Var;
    }

    public static void h0(View view, y.a aVar, CharSequence charSequence, f0.b0 b0Var) {
        if (b0Var == null && charSequence == null) {
            f0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, b0Var));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).b(view, keyEvent);
    }

    public static void i0(View view) {
        view.requestApplyInsets();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).f(keyEvent);
    }

    public static void j0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i6, i7);
        }
    }

    public static int k() {
        return View.generateViewId();
    }

    private static g k0() {
        return new b(s.b.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static e0.a l(View view) {
        View.AccessibilityDelegate m5 = m(view);
        if (m5 == null) {
            return null;
        }
        return m5 instanceof a.C0156a ? ((a.C0156a) m5).f9325a : new e0.a(m5);
    }

    public static void l0(View view, e0.a aVar) {
        if (aVar == null && (m(view) instanceof a.C0156a)) {
            aVar = new e0.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    private static View.AccessibilityDelegate m(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
            return accessibilityDelegate;
        }
        return n(view);
    }

    public static void m0(View view, boolean z5) {
        a().g(view, Boolean.valueOf(z5));
    }

    private static View.AccessibilityDelegate n(View view) {
        if (f9332d) {
            return null;
        }
        if (f9331c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f9331c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f9332d = true;
                return null;
            }
        }
        try {
            Object obj = f9331c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f9332d = true;
            return null;
        }
    }

    public static void n0(View view, int i6) {
        view.setAccessibilityLiveRegion(i6);
    }

    public static int o(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static void o0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static CharSequence p(View view) {
        return (CharSequence) a0().f(view);
    }

    public static void p0(View view, ColorStateList colorStateList) {
        int i6 = Build.VERSION.SDK_INT;
        view.setBackgroundTintList(colorStateList);
        if (i6 == 21) {
            Drawable background = view.getBackground();
            boolean z5 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z5) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static List q(View view) {
        int i6 = s.b.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i6);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i6, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void q0(View view, PorterDuff.Mode mode) {
        int i6 = Build.VERSION.SDK_INT;
        view.setBackgroundTintMode(mode);
        if (i6 == 21) {
            Drawable background = view.getBackground();
            boolean z5 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z5) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static int r(View view) {
        List q5 = q(view);
        int i6 = 0;
        int i7 = -1;
        while (true) {
            int[] iArr = f9334f;
            if (i6 >= iArr.length || i7 != -1) {
                break;
            }
            int i8 = iArr[i6];
            boolean z5 = true;
            for (int i9 = 0; i9 < q5.size(); i9++) {
                z5 &= ((y.a) q5.get(i9)).b() != i8;
            }
            if (z5) {
                i7 = i8;
            }
            i6++;
        }
        return i7;
    }

    public static void r0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static ColorStateList s(View view) {
        return view.getBackgroundTintList();
    }

    public static void s0(View view, float f6) {
        view.setElevation(f6);
    }

    public static PorterDuff.Mode t(View view) {
        return view.getBackgroundTintMode();
    }

    public static void t0(View view, boolean z5) {
        view.setHasTransientState(z5);
    }

    public static Rect u(View view) {
        return view.getClipBounds();
    }

    public static void u0(View view, int i6) {
        view.setImportantForAccessibility(i6);
    }

    public static Display v(View view) {
        return view.getDisplay();
    }

    public static void v0(View view, int i6) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i6);
        }
    }

    public static float w(View view) {
        return view.getElevation();
    }

    public static void w0(View view, u uVar) {
        h.d(view, uVar);
    }

    private static Rect x() {
        if (f9333e == null) {
            f9333e = new ThreadLocal();
        }
        Rect rect = (Rect) f9333e.get();
        if (rect == null) {
            rect = new Rect();
            f9333e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void x0(View view, int i6, int i7, int i8, int i9) {
        view.setPaddingRelative(i6, i7, i8, i9);
    }

    public static boolean y(View view) {
        return view.getFitsSystemWindows();
    }

    public static void y0(View view, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i6, i7);
        }
    }

    public static int z(View view) {
        return view.getImportantForAccessibility();
    }

    public static void z0(View view, String str) {
        view.setTransitionName(str);
    }
}
