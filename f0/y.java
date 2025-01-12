package f0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import f0.b0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.http2.Http2;
import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class y {

    /* renamed from: d  reason: collision with root package name */
    private static int f9732d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f9733a;

    /* renamed from: b  reason: collision with root package name */
    public int f9734b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f9735c = -1;

    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;

        /* renamed from: e  reason: collision with root package name */
        public static final a f9736e = new a(1, null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f9737f = new a(2, null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f9738g = new a(4, null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f9739h = new a(8, null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f9740i = new a(16, null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f9741j = new a(32, null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f9742k = new a(64, null);

        /* renamed from: l  reason: collision with root package name */
        public static final a f9743l = new a(128, null);

        /* renamed from: m  reason: collision with root package name */
        public static final a f9744m = new a(256, (CharSequence) null, b0.b.class);

        /* renamed from: n  reason: collision with root package name */
        public static final a f9745n = new a(512, (CharSequence) null, b0.b.class);

        /* renamed from: o  reason: collision with root package name */
        public static final a f9746o = new a((int) Segment.SHARE_MINIMUM, (CharSequence) null, b0.c.class);

        /* renamed from: p  reason: collision with root package name */
        public static final a f9747p = new a(2048, (CharSequence) null, b0.c.class);

        /* renamed from: q  reason: collision with root package name */
        public static final a f9748q = new a(_BufferKt.SEGMENTING_THRESHOLD, null);

        /* renamed from: r  reason: collision with root package name */
        public static final a f9749r = new a(Segment.SIZE, null);

        /* renamed from: s  reason: collision with root package name */
        public static final a f9750s = new a(Http2.INITIAL_MAX_FRAME_SIZE, null);

        /* renamed from: t  reason: collision with root package name */
        public static final a f9751t = new a(32768, null);

        /* renamed from: u  reason: collision with root package name */
        public static final a f9752u = new a(DnsOverHttps.MAX_RESPONSE_SIZE, null);

        /* renamed from: v  reason: collision with root package name */
        public static final a f9753v = new a(131072, (CharSequence) null, b0.g.class);

        /* renamed from: w  reason: collision with root package name */
        public static final a f9754w = new a(262144, null);

        /* renamed from: x  reason: collision with root package name */
        public static final a f9755x = new a(524288, null);

        /* renamed from: y  reason: collision with root package name */
        public static final a f9756y = new a(1048576, null);

        /* renamed from: z  reason: collision with root package name */
        public static final a f9757z = new a(2097152, (CharSequence) null, b0.h.class);

        /* renamed from: a  reason: collision with root package name */
        final Object f9758a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9759b;

        /* renamed from: c  reason: collision with root package name */
        private final Class f9760c;

        /* renamed from: d  reason: collision with root package name */
        protected final b0 f9761d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 23) {
                accessibilityAction30 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                accessibilityAction = accessibilityAction30;
            } else {
                accessibilityAction = null;
            }
            A = new a(accessibilityAction, 16908342, null, null, null);
            if (i6 >= 23) {
                accessibilityAction29 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                accessibilityAction2 = accessibilityAction29;
            } else {
                accessibilityAction2 = null;
            }
            B = new a(accessibilityAction2, 16908343, null, null, b0.e.class);
            if (i6 >= 23) {
                accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                accessibilityAction3 = accessibilityAction28;
            } else {
                accessibilityAction3 = null;
            }
            C = new a(accessibilityAction3, 16908344, null, null, null);
            if (i6 >= 23) {
                accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                accessibilityAction4 = accessibilityAction27;
            } else {
                accessibilityAction4 = null;
            }
            D = new a(accessibilityAction4, 16908345, null, null, null);
            if (i6 >= 23) {
                accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                accessibilityAction5 = accessibilityAction26;
            } else {
                accessibilityAction5 = null;
            }
            E = new a(accessibilityAction5, 16908346, null, null, null);
            if (i6 >= 23) {
                accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                accessibilityAction6 = accessibilityAction25;
            } else {
                accessibilityAction6 = null;
            }
            F = new a(accessibilityAction6, 16908347, null, null, null);
            if (i6 >= 29) {
                accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction7 = accessibilityAction24;
            } else {
                accessibilityAction7 = null;
            }
            G = new a(accessibilityAction7, 16908358, null, null, null);
            if (i6 >= 29) {
                accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction8 = accessibilityAction23;
            } else {
                accessibilityAction8 = null;
            }
            H = new a(accessibilityAction8, 16908359, null, null, null);
            if (i6 >= 29) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction9 = accessibilityAction22;
            } else {
                accessibilityAction9 = null;
            }
            I = new a(accessibilityAction9, 16908360, null, null, null);
            if (i6 >= 29) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction10 = accessibilityAction21;
            } else {
                accessibilityAction10 = null;
            }
            J = new a(accessibilityAction10, 16908361, null, null, null);
            if (i6 >= 23) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                accessibilityAction11 = accessibilityAction20;
            } else {
                accessibilityAction11 = null;
            }
            K = new a(accessibilityAction11, 16908348, null, null, null);
            if (i6 >= 24) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction12 = accessibilityAction19;
            } else {
                accessibilityAction12 = null;
            }
            L = new a(accessibilityAction12, 16908349, null, null, b0.f.class);
            if (i6 >= 26) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction13 = accessibilityAction18;
            } else {
                accessibilityAction13 = null;
            }
            M = new a(accessibilityAction13, 16908354, null, null, b0.d.class);
            if (i6 >= 28) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction14 = accessibilityAction17;
            } else {
                accessibilityAction14 = null;
            }
            N = new a(accessibilityAction14, 16908356, null, null, null);
            if (i6 >= 28) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction15 = accessibilityAction16;
            } else {
                accessibilityAction15 = null;
            }
            O = new a(accessibilityAction15, 16908357, null, null, null);
            P = new a(i6 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            Q = new a(i6 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
        }

        public a(int i6, CharSequence charSequence) {
            this(null, i6, charSequence, null, null);
        }

        public a a(CharSequence charSequence, b0 b0Var) {
            return new a(null, this.f9759b, charSequence, b0Var, this.f9760c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f9758a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f9758a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f9761d != null) {
                Class cls = this.f9760c;
                if (cls != null) {
                    try {
                        android.support.v4.media.a.a(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        throw null;
                    } catch (Exception e6) {
                        Class cls2 = this.f9760c;
                        String name = cls2 == null ? "null" : cls2.getName();
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e6);
                    }
                }
                return this.f9761d.a(view, null);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                Object obj2 = this.f9758a;
                Object obj3 = ((a) obj).f9758a;
                return obj2 == null ? obj3 == null : obj2.equals(obj3);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f9758a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i6, CharSequence charSequence, b0 b0Var) {
            this(null, i6, charSequence, b0Var, null);
        }

        private a(int i6, CharSequence charSequence, Class cls) {
            this(null, i6, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i6, CharSequence charSequence, b0 b0Var, Class cls) {
            this.f9759b = i6;
            this.f9761d = b0Var;
            this.f9758a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i6, charSequence) : obj;
            this.f9760c = cls;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f9762a;

        b(Object obj) {
            this.f9762a = obj;
        }

        public static b a(int i6, int i7, boolean z5, int i8) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i6, i7, z5, i8));
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Object f9763a;

        c(Object obj) {
            this.f9763a = obj;
        }

        public static c a(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i6, i7, i8, i9, z5, z6));
        }
    }

    private y(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f9733a = accessibilityNodeInfo;
    }

    public static y K() {
        return w0(AccessibilityNodeInfo.obtain());
    }

    public static y L(View view) {
        return w0(AccessibilityNodeInfo.obtain(view));
    }

    public static y M(y yVar) {
        return w0(AccessibilityNodeInfo.obtain(yVar.f9733a));
    }

    private void P(View view) {
        SparseArray u5 = u(view);
        if (u5 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < u5.size(); i6++) {
                if (((WeakReference) u5.valueAt(i6)).get() == null) {
                    arrayList.add(Integer.valueOf(i6));
                }
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                u5.remove(((Integer) arrayList.get(i7)).intValue());
            }
        }
    }

    private void R(int i6, boolean z5) {
        Bundle r5 = r();
        if (r5 != null) {
            int i7 = r5.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i6);
            if (!z5) {
                i6 = 0;
            }
            r5.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i6 | i7);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i6) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i6));
    }

    private void f() {
        this.f9733a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f9733a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f9733a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f9733a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List g(String str) {
        ArrayList<Integer> integerArrayList = this.f9733a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f9733a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    private static String i(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                switch (i6) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case Segment.SHARE_MINIMUM /* 1024 */:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case _BufferKt.SEGMENTING_THRESHOLD /* 4096 */:
                        return "ACTION_SCROLL_FORWARD";
                    case Segment.SIZE /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case DnsOverHttps.MAX_RESPONSE_SIZE /* 65536 */:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908372:
                        return "ACTION_IME_ENTER";
                    default:
                        switch (i6) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i6) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean k(int i6) {
        Bundle r5 = r();
        return r5 != null && (r5.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i6) == i6;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray s(View view) {
        SparseArray u5 = u(view);
        if (u5 == null) {
            SparseArray sparseArray = new SparseArray();
            view.setTag(s.b.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return u5;
    }

    private SparseArray u(View view) {
        return (SparseArray) view.getTag(s.b.tag_accessibility_clickable_spans);
    }

    public static y w0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new y(accessibilityNodeInfo);
    }

    private boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int y(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i6)).get())) {
                    return sparseArray.keyAt(i6);
                }
            }
        }
        int i7 = f9732d;
        f9732d = i7 + 1;
        return i7;
    }

    public boolean A() {
        return this.f9733a.isChecked();
    }

    public boolean B() {
        return this.f9733a.isClickable();
    }

    public boolean C() {
        return this.f9733a.isEnabled();
    }

    public boolean D() {
        return this.f9733a.isFocusable();
    }

    public boolean E() {
        return this.f9733a.isFocused();
    }

    public boolean F() {
        return this.f9733a.isLongClickable();
    }

    public boolean G() {
        return this.f9733a.isPassword();
    }

    public boolean H() {
        return this.f9733a.isScrollable();
    }

    public boolean I() {
        return this.f9733a.isSelected();
    }

    public boolean J() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT >= 26) {
            isShowingHintText = this.f9733a.isShowingHintText();
            return isShowingHintText;
        }
        return k(4);
    }

    public boolean N(int i6, Bundle bundle) {
        return this.f9733a.performAction(i6, bundle);
    }

    public void O() {
        this.f9733a.recycle();
    }

    public void Q(boolean z5) {
        this.f9733a.setAccessibilityFocused(z5);
    }

    public void S(Rect rect) {
        this.f9733a.setBoundsInParent(rect);
    }

    public void T(Rect rect) {
        this.f9733a.setBoundsInScreen(rect);
    }

    public void U(boolean z5) {
        this.f9733a.setCheckable(z5);
    }

    public void V(boolean z5) {
        this.f9733a.setChecked(z5);
    }

    public void W(CharSequence charSequence) {
        this.f9733a.setClassName(charSequence);
    }

    public void X(boolean z5) {
        this.f9733a.setClickable(z5);
    }

    public void Y(Object obj) {
        this.f9733a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f9762a);
    }

    public void Z(Object obj) {
        this.f9733a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f9763a);
    }

    public void a(int i6) {
        this.f9733a.addAction(i6);
    }

    public void a0(CharSequence charSequence) {
        this.f9733a.setContentDescription(charSequence);
    }

    public void b(a aVar) {
        this.f9733a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f9758a);
    }

    public void b0(boolean z5) {
        this.f9733a.setDismissable(z5);
    }

    public void c(View view, int i6) {
        this.f9733a.addChild(view, i6);
    }

    public void c0(boolean z5) {
        this.f9733a.setEnabled(z5);
    }

    public void d0(CharSequence charSequence) {
        this.f9733a.setError(charSequence);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            P(view);
            ClickableSpan[] p5 = p(charSequence);
            if (p5 == null || p5.length <= 0) {
                return;
            }
            r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", s.b.accessibility_action_clickable_span);
            SparseArray s5 = s(view);
            for (int i6 = 0; i6 < p5.length; i6++) {
                int y5 = y(p5[i6], s5);
                s5.put(y5, new WeakReference(p5[i6]));
                d(p5[i6], (Spanned) charSequence, y5);
            }
        }
    }

    public void e0(boolean z5) {
        this.f9733a.setFocusable(z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof y)) {
            y yVar = (y) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f9733a;
            if (accessibilityNodeInfo == null) {
                if (yVar.f9733a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(yVar.f9733a)) {
                return false;
            }
            return this.f9735c == yVar.f9735c && this.f9734b == yVar.f9734b;
        }
        return false;
    }

    public void f0(boolean z5) {
        this.f9733a.setFocused(z5);
    }

    public void g0(boolean z5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f9733a.setHeading(z5);
        } else {
            R(2, z5);
        }
    }

    public List h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f9733a.getActionList();
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i6 = 0; i6 < size; i6++) {
                arrayList.add(new a(actionList.get(i6)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void h0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f9733a.setHintText(charSequence);
        } else {
            this.f9733a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f9733a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(int i6) {
        this.f9733a.setMaxTextLength(i6);
    }

    public int j() {
        return this.f9733a.getActions();
    }

    public void j0(CharSequence charSequence) {
        this.f9733a.setPackageName(charSequence);
    }

    public void k0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f9733a.setPaneTitle(charSequence);
        } else {
            this.f9733a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void l(Rect rect) {
        this.f9733a.getBoundsInParent(rect);
    }

    public void l0(View view) {
        this.f9734b = -1;
        this.f9733a.setParent(view);
    }

    public void m(Rect rect) {
        this.f9733a.getBoundsInScreen(rect);
    }

    public void m0(View view, int i6) {
        this.f9734b = i6;
        this.f9733a.setParent(view, i6);
    }

    public int n() {
        return this.f9733a.getChildCount();
    }

    public void n0(boolean z5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f9733a.setScreenReaderFocusable(z5);
        } else {
            R(1, z5);
        }
    }

    public CharSequence o() {
        return this.f9733a.getClassName();
    }

    public void o0(boolean z5) {
        this.f9733a.setScrollable(z5);
    }

    public void p0(boolean z5) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f9733a.setShowingHintText(z5);
        } else {
            R(4, z5);
        }
    }

    public CharSequence q() {
        return this.f9733a.getContentDescription();
    }

    public void q0(View view, int i6) {
        this.f9735c = i6;
        this.f9733a.setSource(view, i6);
    }

    public Bundle r() {
        return this.f9733a.getExtras();
    }

    public void r0(CharSequence charSequence) {
        if (a0.a.a()) {
            this.f9733a.setStateDescription(charSequence);
        } else {
            this.f9733a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void s0(CharSequence charSequence) {
        this.f9733a.setText(charSequence);
    }

    public CharSequence t() {
        return this.f9733a.getPackageName();
    }

    public void t0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f9733a.setTraversalAfter(view);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(t());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(z());
        sb.append("; checked: ");
        sb.append(A());
        sb.append("; focusable: ");
        sb.append(D());
        sb.append("; focused: ");
        sb.append(E());
        sb.append("; selected: ");
        sb.append(I());
        sb.append("; clickable: ");
        sb.append(B());
        sb.append("; longClickable: ");
        sb.append(F());
        sb.append("; enabled: ");
        sb.append(C());
        sb.append("; password: ");
        sb.append(G());
        sb.append("; scrollable: " + H());
        sb.append("; [");
        List h6 = h();
        for (int i6 = 0; i6 < h6.size(); i6++) {
            a aVar = (a) h6.get(i6);
            String i7 = i(aVar.b());
            if (i7.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                i7 = aVar.c().toString();
            }
            sb.append(i7);
            if (i6 != h6.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u0(boolean z5) {
        this.f9733a.setVisibleToUser(z5);
    }

    public CharSequence v() {
        if (x()) {
            List g6 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List g7 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List g8 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List g9 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f9733a.getText(), 0, this.f9733a.getText().length()));
            for (int i6 = 0; i6 < g6.size(); i6++) {
                spannableString.setSpan(new f0.a(((Integer) g9.get(i6)).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) g6.get(i6)).intValue(), ((Integer) g7.get(i6)).intValue(), ((Integer) g8.get(i6)).intValue());
            }
            return spannableString;
        }
        return this.f9733a.getText();
    }

    public AccessibilityNodeInfo v0() {
        return this.f9733a;
    }

    public String w() {
        return this.f9733a.getViewIdResourceName();
    }

    public boolean z() {
        return this.f9733a.isCheckable();
    }
}
