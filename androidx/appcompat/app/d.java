package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.c2;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.i2;
import androidx.appcompat.widget.j2;
import androidx.lifecycle.c;
import e0.b0;
import e0.e;
import e0.r0;
import e0.t0;
import e0.u;
import e0.v0;
import h.b;
import h.f;
import java.util.List;
import okio.Segment;
import okio.internal._BufferKt;
import org.xmlpull.v1.XmlPullParser;
import v.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends androidx.appcompat.app.c implements e.a, LayoutInflater.Factory2 {

    /* renamed from: b0  reason: collision with root package name */
    private static final l.g f327b0 = new l.g();

    /* renamed from: c0  reason: collision with root package name */
    private static final boolean f328c0 = false;

    /* renamed from: d0  reason: collision with root package name */
    private static final int[] f329d0 = {16842836};

    /* renamed from: e0  reason: collision with root package name */
    private static final boolean f330e0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: f0  reason: collision with root package name */
    private static final boolean f331f0 = true;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private q[] H;
    private q I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private j S;
    private j T;
    boolean U;
    int V;
    private final Runnable W;
    private boolean X;
    private Rect Y;
    private Rect Z;

    /* renamed from: a0  reason: collision with root package name */
    private androidx.appcompat.app.e f332a0;

    /* renamed from: e  reason: collision with root package name */
    final Object f333e;

    /* renamed from: f  reason: collision with root package name */
    final Context f334f;

    /* renamed from: g  reason: collision with root package name */
    Window f335g;

    /* renamed from: h  reason: collision with root package name */
    private h f336h;

    /* renamed from: i  reason: collision with root package name */
    final d.a f337i;

    /* renamed from: j  reason: collision with root package name */
    androidx.appcompat.app.a f338j;

    /* renamed from: k  reason: collision with root package name */
    MenuInflater f339k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f340l;

    /* renamed from: m  reason: collision with root package name */
    private d1 f341m;

    /* renamed from: n  reason: collision with root package name */
    private f f342n;

    /* renamed from: o  reason: collision with root package name */
    private r f343o;

    /* renamed from: p  reason: collision with root package name */
    h.b f344p;

    /* renamed from: q  reason: collision with root package name */
    ActionBarContextView f345q;

    /* renamed from: r  reason: collision with root package name */
    PopupWindow f346r;

    /* renamed from: s  reason: collision with root package name */
    Runnable f347s;

    /* renamed from: t  reason: collision with root package name */
    r0 f348t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f349u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f350v;

    /* renamed from: w  reason: collision with root package name */
    ViewGroup f351w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f352x;

    /* renamed from: y  reason: collision with root package name */
    private View f353y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f354z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if ((dVar.V & 1) != 0) {
                dVar.U(0);
            }
            d dVar2 = d.this;
            if ((dVar2.V & _BufferKt.SEGMENTING_THRESHOLD) != 0) {
                dVar2.U(androidx.constraintlayout.widget.g.Z0);
            }
            d dVar3 = d.this;
            dVar3.U = false;
            dVar3.V = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements u {
        b() {
        }

        @Override // e0.u
        public v0 a(View view, v0 v0Var) {
            int i6 = v0Var.i();
            int L0 = d.this.L0(v0Var, null);
            if (i6 != L0) {
                v0Var = v0Var.m(v0Var.g(), L0, v0Var.h(), v0Var.f());
            }
            return b0.Y(view, v0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            d.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0009d implements Runnable {

        /* renamed from: androidx.appcompat.app.d$d$a */
        /* loaded from: classes.dex */
        class a extends t0 {
            a() {
            }

            @Override // e0.s0
            public void b(View view) {
                d.this.f345q.setAlpha(1.0f);
                d.this.f348t.f(null);
                d.this.f348t = null;
            }

            @Override // e0.t0, e0.s0
            public void c(View view) {
                d.this.f345q.setVisibility(0);
            }
        }

        RunnableC0009d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.f346r.showAtLocation(dVar.f345q, 55, 0, 0);
            d.this.V();
            if (!d.this.D0()) {
                d.this.f345q.setAlpha(1.0f);
                d.this.f345q.setVisibility(0);
                return;
            }
            d.this.f345q.setAlpha(0.0f);
            d dVar2 = d.this;
            dVar2.f348t = b0.d(dVar2.f345q).a(1.0f);
            d.this.f348t.f(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends t0 {
        e() {
        }

        @Override // e0.s0
        public void b(View view) {
            d.this.f345q.setAlpha(1.0f);
            d.this.f348t.f(null);
            d.this.f348t = null;
        }

        @Override // e0.t0, e0.s0
        public void c(View view) {
            d.this.f345q.setVisibility(0);
            d.this.f345q.sendAccessibilityEvent(32);
            if (d.this.f345q.getParent() instanceof View) {
                b0.i0((View) d.this.f345q.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z5) {
            d.this.L(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback f02 = d.this.f0();
            if (f02 != null) {
                f02.onMenuOpened(androidx.constraintlayout.widget.g.Z0, eVar);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f362a;

        /* loaded from: classes.dex */
        class a extends t0 {
            a() {
            }

            @Override // e0.s0
            public void b(View view) {
                d.this.f345q.setVisibility(8);
                d dVar = d.this;
                PopupWindow popupWindow = dVar.f346r;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (dVar.f345q.getParent() instanceof View) {
                    b0.i0((View) d.this.f345q.getParent());
                }
                d.this.f345q.removeAllViews();
                d.this.f348t.f(null);
                d dVar2 = d.this;
                dVar2.f348t = null;
                b0.i0(dVar2.f351w);
            }
        }

        public g(b.a aVar) {
            this.f362a = aVar;
        }

        @Override // h.b.a
        public boolean a(h.b bVar, MenuItem menuItem) {
            return this.f362a.a(bVar, menuItem);
        }

        @Override // h.b.a
        public boolean b(h.b bVar, Menu menu) {
            return this.f362a.b(bVar, menu);
        }

        @Override // h.b.a
        public boolean c(h.b bVar, Menu menu) {
            b0.i0(d.this.f351w);
            return this.f362a.c(bVar, menu);
        }

        @Override // h.b.a
        public void d(h.b bVar) {
            this.f362a.d(bVar);
            d dVar = d.this;
            if (dVar.f346r != null) {
                dVar.f335g.getDecorView().removeCallbacks(d.this.f347s);
            }
            d dVar2 = d.this;
            if (dVar2.f345q != null) {
                dVar2.V();
                d dVar3 = d.this;
                dVar3.f348t = b0.d(dVar3.f345q).a(0.0f);
                d.this.f348t.f(new a());
            }
            d dVar4 = d.this;
            d.a aVar = dVar4.f337i;
            if (aVar != null) {
                aVar.i(dVar4.f344p);
            }
            d dVar5 = d.this;
            dVar5.f344p = null;
            b0.i0(dVar5.f351w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends h.m {
        h(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(d.this.f334f, callback);
            h.b F0 = d.this.F0(aVar);
            if (F0 != null) {
                return aVar.e(F0);
            }
            return null;
        }

        @Override // h.m, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return d.this.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // h.m, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || d.this.r0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // h.m, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i6, Menu menu) {
            if (i6 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i6, menu);
            }
            return false;
        }

        @Override // h.m, android.view.Window.Callback
        public boolean onMenuOpened(int i6, Menu menu) {
            super.onMenuOpened(i6, menu);
            d.this.u0(i6);
            return true;
        }

        @Override // h.m, android.view.Window.Callback
        public void onPanelClosed(int i6, Menu menu) {
            super.onPanelClosed(i6, menu);
            d.this.v0(i6);
        }

        @Override // h.m, android.view.Window.Callback
        public boolean onPreparePanel(int i6, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i6 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i6, view, menu);
            if (eVar != null) {
                eVar.a0(false);
            }
            return onPreparePanel;
        }

        @Override // h.m, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i6) {
            androidx.appcompat.view.menu.e eVar;
            q d02 = d.this.d0(0, true);
            if (d02 == null || (eVar = d02.f383j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i6);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i6);
            }
        }

        @Override // h.m, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return d.this.m0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // h.m, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i6) {
            return (d.this.m0() && i6 == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends j {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f366c;

        i(Context context) {
            super();
            this.f366c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.d.j
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.d.j
        public int c() {
            return this.f366c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.d.j
        public void d() {
            d.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class j {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f368a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                j.this.d();
            }
        }

        j() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f368a;
            if (broadcastReceiver != null) {
                try {
                    d.this.f334f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f368a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b6 = b();
            if (b6 == null || b6.countActions() == 0) {
                return;
            }
            if (this.f368a == null) {
                this.f368a = new a();
            }
            d.this.f334f.registerReceiver(this.f368a, b6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends j {

        /* renamed from: c  reason: collision with root package name */
        private final androidx.appcompat.app.h f371c;

        k(androidx.appcompat.app.h hVar) {
            super();
            this.f371c = hVar;
        }

        @Override // androidx.appcompat.app.d.j
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.d.j
        public int c() {
            return this.f371c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.d.j
        public void d() {
            d.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i6 = configuration.densityDpi;
            int i7 = configuration2.densityDpi;
            if (i6 != i7) {
                configuration3.densityDpi = i7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales;
            LocaleList locales2;
            boolean equals;
            locales = configuration.getLocales();
            locales2 = configuration2.getLocales();
            equals = locales.equals(locales2);
            if (equals) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            i6 = configuration.colorMode;
            int i14 = i6 & 3;
            i7 = configuration2.colorMode;
            if (i14 != (i7 & 3)) {
                i12 = configuration3.colorMode;
                i13 = configuration2.colorMode;
                configuration3.colorMode = i12 | (i13 & 3);
            }
            i8 = configuration.colorMode;
            int i15 = i8 & 12;
            i9 = configuration2.colorMode;
            if (i15 != (i9 & 12)) {
                i10 = configuration3.colorMode;
                i11 = configuration2.colorMode;
                configuration3.colorMode = i10 | (i11 & 12);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class o {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class p extends ContentFrameLayout {
        public p(Context context) {
            super(context);
        }

        private boolean b(int i6, int i7) {
            return i6 < -5 || i7 < -5 || i6 > getWidth() + 5 || i7 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return d.this.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                d.this.N(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i6) {
            setBackgroundDrawable(e.b.d(getContext(), i6));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class q {

        /* renamed from: a  reason: collision with root package name */
        int f374a;

        /* renamed from: b  reason: collision with root package name */
        int f375b;

        /* renamed from: c  reason: collision with root package name */
        int f376c;

        /* renamed from: d  reason: collision with root package name */
        int f377d;

        /* renamed from: e  reason: collision with root package name */
        int f378e;

        /* renamed from: f  reason: collision with root package name */
        int f379f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f380g;

        /* renamed from: h  reason: collision with root package name */
        View f381h;

        /* renamed from: i  reason: collision with root package name */
        View f382i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.e f383j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.c f384k;

        /* renamed from: l  reason: collision with root package name */
        Context f385l;

        /* renamed from: m  reason: collision with root package name */
        boolean f386m;

        /* renamed from: n  reason: collision with root package name */
        boolean f387n;

        /* renamed from: o  reason: collision with root package name */
        boolean f388o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f389p;

        /* renamed from: q  reason: collision with root package name */
        boolean f390q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f391r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f392s;

        q(int i6) {
            this.f374a = i6;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f383j == null) {
                return null;
            }
            if (this.f384k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f385l, b.g.abc_list_menu_item_layout);
                this.f384k = cVar;
                cVar.k(aVar);
                this.f383j.b(this.f384k);
            }
            return this.f384k.c(this.f380g);
        }

        public boolean b() {
            if (this.f381h == null) {
                return false;
            }
            return this.f382i != null || this.f384k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f383j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.O(this.f384k);
            }
            this.f383j = eVar;
            if (eVar == null || (cVar = this.f384k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(b.a.actionBarPopupTheme, typedValue, true);
            int i6 = typedValue.resourceId;
            if (i6 != 0) {
                newTheme.applyStyle(i6, true);
            }
            newTheme.resolveAttribute(b.a.panelMenuListTheme, typedValue, true);
            int i7 = typedValue.resourceId;
            if (i7 == 0) {
                i7 = b.i.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i7, true);
            h.d dVar = new h.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f385l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(b.j.f2838z0);
            this.f375b = obtainStyledAttributes.getResourceId(b.j.C0, 0);
            this.f379f = obtainStyledAttributes.getResourceId(b.j.B0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class r implements j.a {
        r() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z5) {
            androidx.appcompat.view.menu.e D = eVar.D();
            boolean z6 = D != eVar;
            d dVar = d.this;
            if (z6) {
                eVar = D;
            }
            q Y = dVar.Y(eVar);
            if (Y != null) {
                if (!z6) {
                    d.this.O(Y, z5);
                    return;
                }
                d.this.K(Y.f374a, Y, D);
                d.this.O(Y, true);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback f02;
            if (eVar == eVar.D()) {
                d dVar = d.this;
                if (!dVar.B || (f02 = dVar.f0()) == null || d.this.N) {
                    return true;
                }
                f02.onMenuOpened(androidx.constraintlayout.widget.g.Z0, eVar);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity, d.a aVar) {
        this(activity, null, aVar, activity);
    }

    private boolean A0(q qVar, KeyEvent keyEvent) {
        d1 d1Var;
        d1 d1Var2;
        d1 d1Var3;
        if (this.N) {
            return false;
        }
        if (qVar.f386m) {
            return true;
        }
        q qVar2 = this.I;
        if (qVar2 != null && qVar2 != qVar) {
            O(qVar2, false);
        }
        Window.Callback f02 = f0();
        if (f02 != null) {
            qVar.f382i = f02.onCreatePanelView(qVar.f374a);
        }
        int i6 = qVar.f374a;
        boolean z5 = i6 == 0 || i6 == 108;
        if (z5 && (d1Var3 = this.f341m) != null) {
            d1Var3.c();
        }
        if (qVar.f382i == null) {
            if (z5) {
                y0();
            }
            androidx.appcompat.view.menu.e eVar = qVar.f383j;
            if (eVar == null || qVar.f391r) {
                if (eVar == null && (!j0(qVar) || qVar.f383j == null)) {
                    return false;
                }
                if (z5 && this.f341m != null) {
                    if (this.f342n == null) {
                        this.f342n = new f();
                    }
                    this.f341m.a(qVar.f383j, this.f342n);
                }
                qVar.f383j.d0();
                if (!f02.onCreatePanelMenu(qVar.f374a, qVar.f383j)) {
                    qVar.c(null);
                    if (z5 && (d1Var = this.f341m) != null) {
                        d1Var.a(null, this.f342n);
                    }
                    return false;
                }
                qVar.f391r = false;
            }
            qVar.f383j.d0();
            Bundle bundle = qVar.f392s;
            if (bundle != null) {
                qVar.f383j.P(bundle);
                qVar.f392s = null;
            }
            if (!f02.onPreparePanel(0, qVar.f382i, qVar.f383j)) {
                if (z5 && (d1Var2 = this.f341m) != null) {
                    d1Var2.a(null, this.f342n);
                }
                qVar.f383j.c0();
                return false;
            }
            boolean z6 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            qVar.f389p = z6;
            qVar.f383j.setQwertyMode(z6);
            qVar.f383j.c0();
        }
        qVar.f386m = true;
        qVar.f387n = false;
        this.I = qVar;
        return true;
    }

    private void B0(boolean z5) {
        d1 d1Var = this.f341m;
        if (d1Var == null || !d1Var.g() || (ViewConfiguration.get(this.f334f).hasPermanentMenuKey() && !this.f341m.d())) {
            q d02 = d0(0, true);
            d02.f390q = true;
            O(d02, false);
            x0(d02, null);
            return;
        }
        Window.Callback f02 = f0();
        if (this.f341m.b() && z5) {
            this.f341m.e();
            if (this.N) {
                return;
            }
            f02.onPanelClosed(androidx.constraintlayout.widget.g.Z0, d0(0, true).f383j);
        } else if (f02 == null || this.N) {
        } else {
            if (this.U && (this.V & 1) != 0) {
                this.f335g.getDecorView().removeCallbacks(this.W);
                this.W.run();
            }
            q d03 = d0(0, true);
            androidx.appcompat.view.menu.e eVar = d03.f383j;
            if (eVar == null || d03.f391r || !f02.onPreparePanel(0, d03.f382i, eVar)) {
                return;
            }
            f02.onMenuOpened(androidx.constraintlayout.widget.g.Z0, d03.f383j);
            this.f341m.f();
        }
    }

    private int C0(int i6) {
        if (i6 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return androidx.constraintlayout.widget.g.Z0;
        } else if (i6 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i6;
        }
    }

    private boolean E0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f335g.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || b0.Q((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean G(boolean z5) {
        if (this.N) {
            return false;
        }
        int J = J();
        boolean J0 = J0(n0(this.f334f, J), z5);
        if (J == 0) {
            c0(this.f334f).e();
        } else {
            j jVar = this.S;
            if (jVar != null) {
                jVar.a();
            }
        }
        if (J == 3) {
            b0(this.f334f).e();
        } else {
            j jVar2 = this.T;
            if (jVar2 != null) {
                jVar2.a();
            }
        }
        return J0;
    }

    private void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f351w.findViewById(16908290);
        View decorView = this.f335g.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f334f.obtainStyledAttributes(b.j.f2838z0);
        obtainStyledAttributes.getValue(b.j.L0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(b.j.M0, contentFrameLayout.getMinWidthMinor());
        int i6 = b.j.J0;
        if (obtainStyledAttributes.hasValue(i6)) {
            obtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedWidthMajor());
        }
        int i7 = b.j.K0;
        if (obtainStyledAttributes.hasValue(i7)) {
            obtainStyledAttributes.getValue(i7, contentFrameLayout.getFixedWidthMinor());
        }
        int i8 = b.j.H0;
        if (obtainStyledAttributes.hasValue(i8)) {
            obtainStyledAttributes.getValue(i8, contentFrameLayout.getFixedHeightMajor());
        }
        int i9 = b.j.I0;
        if (obtainStyledAttributes.hasValue(i9)) {
            obtainStyledAttributes.getValue(i9, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void H0() {
        if (this.f350v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void I(Window window) {
        if (this.f335g != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof h) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        h hVar = new h(callback);
        this.f336h = hVar;
        window.setCallback(hVar);
        c2 u5 = c2.u(this.f334f, null, f329d0);
        Drawable h6 = u5.h(0);
        if (h6 != null) {
            window.setBackgroundDrawable(h6);
        }
        u5.w();
        this.f335g = window;
    }

    private AppCompatActivity I0() {
        for (Context context = this.f334f; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int J() {
        int i6 = this.O;
        return i6 != -100 ? i6 : androidx.appcompat.app.c.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean J0(int i6, boolean z5) {
        boolean z6;
        Configuration P = P(this.f334f, i6, null);
        boolean l02 = l0();
        int i7 = this.f334f.getResources().getConfiguration().uiMode & 48;
        int i8 = P.uiMode & 48;
        boolean z7 = true;
        if (i7 != i8 && z5 && !l02 && this.K && (f330e0 || this.L)) {
            Object obj = this.f333e;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                t.a.k((Activity) this.f333e);
                z6 = true;
                if (!z6 || i7 == i8) {
                    z7 = z6;
                } else {
                    K0(i8, l02, null);
                }
                if (z7) {
                    Object obj2 = this.f333e;
                    if (obj2 instanceof AppCompatActivity) {
                        ((AppCompatActivity) obj2).x(i6);
                    }
                }
                return z7;
            }
        }
        z6 = false;
        if (z6) {
        }
        z7 = z6;
        if (z7) {
        }
        return z7;
    }

    private void K0(int i6, boolean z5, Configuration configuration) {
        Resources resources = this.f334f.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i6 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26) {
            androidx.appcompat.app.f.a(resources);
        }
        int i8 = this.P;
        if (i8 != 0) {
            this.f334f.setTheme(i8);
            if (i7 >= 23) {
                this.f334f.getTheme().applyStyle(this.P, true);
            }
        }
        if (z5) {
            Object obj = this.f333e;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.f) {
                    if (!((androidx.lifecycle.f) activity).h().b().isAtLeast(c.b.STARTED)) {
                        return;
                    }
                } else if (!this.M) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private void M() {
        j jVar = this.S;
        if (jVar != null) {
            jVar.a();
        }
        j jVar2 = this.T;
        if (jVar2 != null) {
            jVar2.a();
        }
    }

    private void M0(View view) {
        Context context;
        int i6;
        if ((b0.K(view) & Segment.SIZE) != 0) {
            context = this.f334f;
            i6 = b.c.abc_decor_view_status_guard_light;
        } else {
            context = this.f334f;
            i6 = b.c.abc_decor_view_status_guard;
        }
        view.setBackgroundColor(u.c.a(context, i6));
    }

    private Configuration P(Context context, int i6, Configuration configuration) {
        int i7 = i6 != 1 ? i6 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i7 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup Q() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f334f.obtainStyledAttributes(b.j.f2838z0);
        int i6 = b.j.E0;
        if (!obtainStyledAttributes.hasValue(i6)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(b.j.N0, false)) {
            z(1);
        } else if (obtainStyledAttributes.getBoolean(i6, false)) {
            z(androidx.constraintlayout.widget.g.Z0);
        }
        if (obtainStyledAttributes.getBoolean(b.j.F0, false)) {
            z(109);
        }
        if (obtainStyledAttributes.getBoolean(b.j.G0, false)) {
            z(10);
        }
        this.E = obtainStyledAttributes.getBoolean(b.j.A0, false);
        obtainStyledAttributes.recycle();
        X();
        this.f335g.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f334f);
        if (this.F) {
            viewGroup = (ViewGroup) from.inflate(this.D ? b.g.abc_screen_simple_overlay_action_mode : b.g.abc_screen_simple, (ViewGroup) null);
        } else if (this.E) {
            viewGroup = (ViewGroup) from.inflate(b.g.abc_dialog_title_material, (ViewGroup) null);
            this.C = false;
            this.B = false;
        } else if (this.B) {
            TypedValue typedValue = new TypedValue();
            this.f334f.getTheme().resolveAttribute(b.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new h.d(this.f334f, typedValue.resourceId) : this.f334f).inflate(b.g.abc_screen_toolbar, (ViewGroup) null);
            d1 d1Var = (d1) viewGroup.findViewById(b.f.decor_content_parent);
            this.f341m = d1Var;
            d1Var.setWindowCallback(f0());
            if (this.C) {
                this.f341m.k(109);
            }
            if (this.f354z) {
                this.f341m.k(2);
            }
            if (this.A) {
                this.f341m.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        b0.w0(viewGroup, new b());
        if (this.f341m == null) {
            this.f352x = (TextView) viewGroup.findViewById(b.f.title);
        }
        j2.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f335g.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f335g.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void W() {
        if (this.f350v) {
            return;
        }
        this.f351w = Q();
        CharSequence e02 = e0();
        if (!TextUtils.isEmpty(e02)) {
            d1 d1Var = this.f341m;
            if (d1Var != null) {
                d1Var.setWindowTitle(e02);
            } else if (y0() != null) {
                y0().t(e02);
            } else {
                TextView textView = this.f352x;
                if (textView != null) {
                    textView.setText(e02);
                }
            }
        }
        H();
        w0(this.f351w);
        this.f350v = true;
        q d02 = d0(0, false);
        if (this.N) {
            return;
        }
        if (d02 == null || d02.f383j == null) {
            k0(androidx.constraintlayout.widget.g.Z0);
        }
    }

    private void X() {
        if (this.f335g == null) {
            Object obj = this.f333e;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f335g == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration Z(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f6 = configuration.fontScale;
            float f7 = configuration2.fontScale;
            if (f6 != f7) {
                configuration3.fontScale = f7;
            }
            int i6 = configuration.mcc;
            int i7 = configuration2.mcc;
            if (i6 != i7) {
                configuration3.mcc = i7;
            }
            int i8 = configuration.mnc;
            int i9 = configuration2.mnc;
            if (i8 != i9) {
                configuration3.mnc = i9;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                m.a(configuration, configuration2, configuration3);
            } else if (!d0.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i11 = configuration.touchscreen;
            int i12 = configuration2.touchscreen;
            if (i11 != i12) {
                configuration3.touchscreen = i12;
            }
            int i13 = configuration.keyboard;
            int i14 = configuration2.keyboard;
            if (i13 != i14) {
                configuration3.keyboard = i14;
            }
            int i15 = configuration.keyboardHidden;
            int i16 = configuration2.keyboardHidden;
            if (i15 != i16) {
                configuration3.keyboardHidden = i16;
            }
            int i17 = configuration.navigation;
            int i18 = configuration2.navigation;
            if (i17 != i18) {
                configuration3.navigation = i18;
            }
            int i19 = configuration.navigationHidden;
            int i20 = configuration2.navigationHidden;
            if (i19 != i20) {
                configuration3.navigationHidden = i20;
            }
            int i21 = configuration.orientation;
            int i22 = configuration2.orientation;
            if (i21 != i22) {
                configuration3.orientation = i22;
            }
            int i23 = configuration.screenLayout & 15;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 15)) {
                configuration3.screenLayout |= i24 & 15;
            }
            int i25 = configuration.screenLayout & 192;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 192)) {
                configuration3.screenLayout |= i26 & 192;
            }
            int i27 = configuration.screenLayout & 48;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 48)) {
                configuration3.screenLayout |= i28 & 48;
            }
            int i29 = configuration.screenLayout & 768;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 768)) {
                configuration3.screenLayout |= i30 & 768;
            }
            if (i10 >= 26) {
                n.a(configuration, configuration2, configuration3);
            }
            int i31 = configuration.uiMode & 15;
            int i32 = configuration2.uiMode;
            if (i31 != (i32 & 15)) {
                configuration3.uiMode |= i32 & 15;
            }
            int i33 = configuration.uiMode & 48;
            int i34 = configuration2.uiMode;
            if (i33 != (i34 & 48)) {
                configuration3.uiMode |= i34 & 48;
            }
            int i35 = configuration.screenWidthDp;
            int i36 = configuration2.screenWidthDp;
            if (i35 != i36) {
                configuration3.screenWidthDp = i36;
            }
            int i37 = configuration.screenHeightDp;
            int i38 = configuration2.screenHeightDp;
            if (i37 != i38) {
                configuration3.screenHeightDp = i38;
            }
            int i39 = configuration.smallestScreenWidthDp;
            int i40 = configuration2.smallestScreenWidthDp;
            if (i39 != i40) {
                configuration3.smallestScreenWidthDp = i40;
            }
            l.a(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private j b0(Context context) {
        if (this.T == null) {
            this.T = new i(context);
        }
        return this.T;
    }

    private j c0(Context context) {
        if (this.S == null) {
            this.S = new k(androidx.appcompat.app.h.a(context));
        }
        return this.S;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g0() {
        androidx.appcompat.app.i iVar;
        androidx.appcompat.app.a aVar;
        W();
        if (!this.B || this.f338j != null) {
            return;
        }
        Object obj = this.f333e;
        if (!(obj instanceof Activity)) {
            if (obj instanceof Dialog) {
                iVar = new androidx.appcompat.app.i((Dialog) this.f333e);
            }
            aVar = this.f338j;
            if (aVar == null) {
                aVar.r(this.X);
                return;
            }
            return;
        }
        iVar = new androidx.appcompat.app.i((Activity) this.f333e, this.C);
        this.f338j = iVar;
        aVar = this.f338j;
        if (aVar == null) {
        }
    }

    private boolean h0(q qVar) {
        View view = qVar.f382i;
        if (view != null) {
            qVar.f381h = view;
            return true;
        } else if (qVar.f383j == null) {
            return false;
        } else {
            if (this.f343o == null) {
                this.f343o = new r();
            }
            View view2 = (View) qVar.a(this.f343o);
            qVar.f381h = view2;
            return view2 != null;
        }
    }

    private boolean i0(q qVar) {
        qVar.d(a0());
        qVar.f380g = new p(qVar.f385l);
        qVar.f376c = 81;
        return true;
    }

    private boolean j0(q qVar) {
        Resources.Theme theme;
        Context context = this.f334f;
        int i6 = qVar.f374a;
        if ((i6 == 0 || i6 == 108) && this.f341m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(b.a.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(b.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(b.a.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                h.d dVar = new h.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        qVar.c(eVar);
        return true;
    }

    private void k0(int i6) {
        this.V = (1 << i6) | this.V;
        if (this.U) {
            return;
        }
        b0.d0(this.f335g.getDecorView(), this.W);
        this.U = true;
    }

    private boolean l0() {
        if (!this.R && (this.f333e instanceof Activity)) {
            PackageManager packageManager = this.f334f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i6 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f334f, this.f333e.getClass()), i6 >= 29 ? 269221888 : i6 >= 24 ? 786432 : 0);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e6) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e6);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    private boolean q0(int i6, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            q d02 = d0(i6, true);
            if (d02.f388o) {
                return false;
            }
            return A0(d02, keyEvent);
        }
        return false;
    }

    private boolean t0(int i6, KeyEvent keyEvent) {
        boolean z5;
        d1 d1Var;
        if (this.f344p != null) {
            return false;
        }
        boolean z6 = true;
        q d02 = d0(i6, true);
        if (i6 != 0 || (d1Var = this.f341m) == null || !d1Var.g() || ViewConfiguration.get(this.f334f).hasPermanentMenuKey()) {
            boolean z7 = d02.f388o;
            if (z7 || d02.f387n) {
                O(d02, true);
                z6 = z7;
            } else {
                if (d02.f386m) {
                    if (d02.f391r) {
                        d02.f386m = false;
                        z5 = A0(d02, keyEvent);
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        x0(d02, keyEvent);
                    }
                }
                z6 = false;
            }
        } else if (this.f341m.b()) {
            z6 = this.f341m.e();
        } else {
            if (!this.N && A0(d02, keyEvent)) {
                z6 = this.f341m.f();
            }
            z6 = false;
        }
        if (z6) {
            AudioManager audioManager = (AudioManager) this.f334f.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z6;
    }

    private void x0(q qVar, KeyEvent keyEvent) {
        int i6;
        ViewGroup.LayoutParams layoutParams;
        if (qVar.f388o || this.N) {
            return;
        }
        if (qVar.f374a == 0) {
            if ((this.f334f.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback f02 = f0();
        if (f02 != null && !f02.onMenuOpened(qVar.f374a, qVar.f383j)) {
            O(qVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f334f.getSystemService("window");
        if (windowManager != null && A0(qVar, keyEvent)) {
            ViewGroup viewGroup = qVar.f380g;
            if (viewGroup == null || qVar.f390q) {
                if (viewGroup == null) {
                    if (!i0(qVar) || qVar.f380g == null) {
                        return;
                    }
                } else if (qVar.f390q && viewGroup.getChildCount() > 0) {
                    qVar.f380g.removeAllViews();
                }
                if (!h0(qVar) || !qVar.b()) {
                    qVar.f390q = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = qVar.f381h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                qVar.f380g.setBackgroundResource(qVar.f375b);
                ViewParent parent = qVar.f381h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(qVar.f381h);
                }
                qVar.f380g.addView(qVar.f381h, layoutParams2);
                if (!qVar.f381h.hasFocus()) {
                    qVar.f381h.requestFocus();
                }
            } else {
                View view = qVar.f382i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i6 = -1;
                    qVar.f387n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i6, -2, qVar.f377d, qVar.f378e, 1002, 8519680, -3);
                    layoutParams3.gravity = qVar.f376c;
                    layoutParams3.windowAnimations = qVar.f379f;
                    windowManager.addView(qVar.f380g, layoutParams3);
                    qVar.f388o = true;
                }
            }
            i6 = -2;
            qVar.f387n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i6, -2, qVar.f377d, qVar.f378e, 1002, 8519680, -3);
            layoutParams32.gravity = qVar.f376c;
            layoutParams32.windowAnimations = qVar.f379f;
            windowManager.addView(qVar.f380g, layoutParams32);
            qVar.f388o = true;
        }
    }

    private boolean z0(q qVar, int i6, KeyEvent keyEvent, int i7) {
        androidx.appcompat.view.menu.e eVar;
        boolean z5 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((qVar.f386m || A0(qVar, keyEvent)) && (eVar = qVar.f383j) != null) {
            z5 = eVar.performShortcut(i6, keyEvent, i7);
        }
        if (z5 && (i7 & 1) == 0 && this.f341m == null) {
            O(qVar, true);
        }
        return z5;
    }

    @Override // androidx.appcompat.app.c
    public void A(int i6) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.f351w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f334f).inflate(i6, viewGroup);
        this.f336h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void B(View view) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.f351w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f336h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void C(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.f351w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f336h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void D(int i6) {
        this.P = i6;
    }

    final boolean D0() {
        ViewGroup viewGroup;
        return this.f350v && (viewGroup = this.f351w) != null && b0.R(viewGroup);
    }

    @Override // androidx.appcompat.app.c
    public final void E(CharSequence charSequence) {
        this.f340l = charSequence;
        d1 d1Var = this.f341m;
        if (d1Var != null) {
            d1Var.setWindowTitle(charSequence);
        } else if (y0() != null) {
            y0().t(charSequence);
        } else {
            TextView textView = this.f352x;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public boolean F() {
        return G(true);
    }

    public h.b F0(b.a aVar) {
        d.a aVar2;
        if (aVar != null) {
            h.b bVar = this.f344p;
            if (bVar != null) {
                bVar.c();
            }
            g gVar = new g(aVar);
            androidx.appcompat.app.a m5 = m();
            if (m5 != null) {
                h.b u5 = m5.u(gVar);
                this.f344p = u5;
                if (u5 != null && (aVar2 = this.f337i) != null) {
                    aVar2.f(u5);
                }
            }
            if (this.f344p == null) {
                this.f344p = G0(gVar);
            }
            return this.f344p;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    h.b G0(b.a aVar) {
        h.b bVar;
        Context context;
        h.b bVar2;
        d.a aVar2;
        V();
        h.b bVar3 = this.f344p;
        if (bVar3 != null) {
            bVar3.c();
        }
        if (!(aVar instanceof g)) {
            aVar = new g(aVar);
        }
        d.a aVar3 = this.f337i;
        if (aVar3 != null && !this.N) {
            try {
                bVar = aVar3.d(aVar);
            } catch (AbstractMethodError unused) {
            }
            if (bVar == null) {
                this.f344p = bVar;
            } else {
                if (this.f345q == null) {
                    if (this.E) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = this.f334f.getTheme();
                        theme.resolveAttribute(b.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme newTheme = this.f334f.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new h.d(this.f334f, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.f334f;
                        }
                        this.f345q = new ActionBarContextView(context);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, b.a.actionModePopupWindowStyle);
                        this.f346r = popupWindow;
                        androidx.core.widget.k.b(popupWindow, 2);
                        this.f346r.setContentView(this.f345q);
                        this.f346r.setWidth(-1);
                        context.getTheme().resolveAttribute(b.a.actionBarSize, typedValue, true);
                        this.f345q.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.f346r.setHeight(-2);
                        this.f347s = new RunnableC0009d();
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.f351w.findViewById(b.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(a0()));
                            this.f345q = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.f345q != null) {
                    V();
                    this.f345q.k();
                    h.e eVar = new h.e(this.f345q.getContext(), this.f345q, aVar, this.f346r == null);
                    if (aVar.b(eVar, eVar.e())) {
                        eVar.k();
                        this.f345q.h(eVar);
                        this.f344p = eVar;
                        if (D0()) {
                            this.f345q.setAlpha(0.0f);
                            r0 a6 = b0.d(this.f345q).a(1.0f);
                            this.f348t = a6;
                            a6.f(new e());
                        } else {
                            this.f345q.setAlpha(1.0f);
                            this.f345q.setVisibility(0);
                            this.f345q.sendAccessibilityEvent(32);
                            if (this.f345q.getParent() instanceof View) {
                                b0.i0((View) this.f345q.getParent());
                            }
                        }
                        if (this.f346r != null) {
                            this.f335g.getDecorView().post(this.f347s);
                        }
                    } else {
                        this.f344p = null;
                    }
                }
            }
            bVar2 = this.f344p;
            if (bVar2 != null && (aVar2 = this.f337i) != null) {
                aVar2.f(bVar2);
            }
            return this.f344p;
        }
        bVar = null;
        if (bVar == null) {
        }
        bVar2 = this.f344p;
        if (bVar2 != null) {
            aVar2.f(bVar2);
        }
        return this.f344p;
    }

    void K(int i6, q qVar, Menu menu) {
        if (menu == null) {
            if (qVar == null && i6 >= 0) {
                q[] qVarArr = this.H;
                if (i6 < qVarArr.length) {
                    qVar = qVarArr[i6];
                }
            }
            if (qVar != null) {
                menu = qVar.f383j;
            }
        }
        if ((qVar == null || qVar.f388o) && !this.N) {
            this.f336h.a().onPanelClosed(i6, menu);
        }
    }

    void L(androidx.appcompat.view.menu.e eVar) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.f341m.l();
        Window.Callback f02 = f0();
        if (f02 != null && !this.N) {
            f02.onPanelClosed(androidx.constraintlayout.widget.g.Z0, eVar);
        }
        this.G = false;
    }

    final int L0(v0 v0Var, Rect rect) {
        boolean z5;
        boolean z6;
        int i6 = v0Var != null ? v0Var.i() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f345q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z5 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f345q.getLayoutParams();
            if (this.f345q.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect2 = this.Y;
                Rect rect3 = this.Z;
                if (v0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(v0Var.g(), v0Var.i(), v0Var.h(), v0Var.f());
                }
                j2.a(this.f351w, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                v0 H = b0.H(this.f351w);
                int g6 = H == null ? 0 : H.g();
                int h6 = H == null ? 0 : H.h();
                if (marginLayoutParams.topMargin == i7 && marginLayoutParams.leftMargin == i8 && marginLayoutParams.rightMargin == i9) {
                    z6 = false;
                } else {
                    marginLayoutParams.topMargin = i7;
                    marginLayoutParams.leftMargin = i8;
                    marginLayoutParams.rightMargin = i9;
                    z6 = true;
                }
                if (i7 <= 0 || this.f353y != null) {
                    View view = this.f353y;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i10 = marginLayoutParams2.height;
                        int i11 = marginLayoutParams.topMargin;
                        if (i10 != i11 || marginLayoutParams2.leftMargin != g6 || marginLayoutParams2.rightMargin != h6) {
                            marginLayoutParams2.height = i11;
                            marginLayoutParams2.leftMargin = g6;
                            marginLayoutParams2.rightMargin = h6;
                            this.f353y.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f334f);
                    this.f353y = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = g6;
                    layoutParams.rightMargin = h6;
                    this.f351w.addView(this.f353y, -1, layoutParams);
                }
                View view3 = this.f353y;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    M0(this.f353y);
                }
                if (!this.D && r5) {
                    i6 = 0;
                }
                z5 = r5;
                r5 = z6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z5 = false;
            } else {
                z5 = false;
                r5 = false;
            }
            if (r5) {
                this.f345q.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f353y;
        if (view4 != null) {
            view4.setVisibility(z5 ? 0 : 8);
        }
        return i6;
    }

    void N(int i6) {
        O(d0(i6, true), true);
    }

    void O(q qVar, boolean z5) {
        ViewGroup viewGroup;
        d1 d1Var;
        if (z5 && qVar.f374a == 0 && (d1Var = this.f341m) != null && d1Var.b()) {
            L(qVar.f383j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f334f.getSystemService("window");
        if (windowManager != null && qVar.f388o && (viewGroup = qVar.f380g) != null) {
            windowManager.removeView(viewGroup);
            if (z5) {
                K(qVar.f374a, qVar, null);
            }
        }
        qVar.f386m = false;
        qVar.f387n = false;
        qVar.f388o = false;
        qVar.f381h = null;
        qVar.f390q = true;
        if (this.I == qVar) {
            this.I = null;
        }
    }

    public View R(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z5;
        androidx.appcompat.app.e eVar;
        boolean z6 = false;
        if (this.f332a0 == null) {
            String string = this.f334f.obtainStyledAttributes(b.j.f2838z0).getString(b.j.D0);
            if (string == null) {
                eVar = new androidx.appcompat.app.e();
            } else {
                try {
                    this.f332a0 = (androidx.appcompat.app.e) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    eVar = new androidx.appcompat.app.e();
                }
            }
            this.f332a0 = eVar;
        }
        boolean z7 = f328c0;
        if (z7) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z6 = E0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z6 = true;
            }
            z5 = z6;
        } else {
            z5 = false;
        }
        return this.f332a0.q(view, str, context, attributeSet, z5, z7, true, i2.b());
    }

    void S() {
        androidx.appcompat.view.menu.e eVar;
        d1 d1Var = this.f341m;
        if (d1Var != null) {
            d1Var.l();
        }
        if (this.f346r != null) {
            this.f335g.getDecorView().removeCallbacks(this.f347s);
            if (this.f346r.isShowing()) {
                try {
                    this.f346r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f346r = null;
        }
        V();
        q d02 = d0(0, false);
        if (d02 == null || (eVar = d02.f383j) == null) {
            return;
        }
        eVar.close();
    }

    boolean T(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f333e;
        if (((obj instanceof e.a) || (obj instanceof d.h)) && (decorView = this.f335g.getDecorView()) != null && e0.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f336h.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? p0(keyCode, keyEvent) : s0(keyCode, keyEvent);
    }

    void U(int i6) {
        q d02;
        q d03 = d0(i6, true);
        if (d03.f383j != null) {
            Bundle bundle = new Bundle();
            d03.f383j.Q(bundle);
            if (bundle.size() > 0) {
                d03.f392s = bundle;
            }
            d03.f383j.d0();
            d03.f383j.clear();
        }
        d03.f391r = true;
        d03.f390q = true;
        if ((i6 != 108 && i6 != 0) || this.f341m == null || (d02 = d0(0, false)) == null) {
            return;
        }
        d02.f386m = false;
        A0(d02, null);
    }

    void V() {
        r0 r0Var = this.f348t;
        if (r0Var != null) {
            r0Var.b();
        }
    }

    q Y(Menu menu) {
        q[] qVarArr = this.H;
        int length = qVarArr != null ? qVarArr.length : 0;
        for (int i6 = 0; i6 < length; i6++) {
            q qVar = qVarArr[i6];
            if (qVar != null && qVar.f383j == menu) {
                return qVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        q Y;
        Window.Callback f02 = f0();
        if (f02 == null || this.N || (Y = Y(eVar.D())) == null) {
            return false;
        }
        return f02.onMenuItemSelected(Y.f374a, menuItem);
    }

    final Context a0() {
        androidx.appcompat.app.a m5 = m();
        Context k6 = m5 != null ? m5.k() : null;
        return k6 == null ? this.f334f : k6;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        B0(true);
    }

    @Override // androidx.appcompat.app.c
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ((ViewGroup) this.f351w.findViewById(16908290)).addView(view, layoutParams);
        this.f336h.a().onContentChanged();
    }

    protected q d0(int i6, boolean z5) {
        q[] qVarArr = this.H;
        if (qVarArr == null || qVarArr.length <= i6) {
            q[] qVarArr2 = new q[i6 + 1];
            if (qVarArr != null) {
                System.arraycopy(qVarArr, 0, qVarArr2, 0, qVarArr.length);
            }
            this.H = qVarArr2;
            qVarArr = qVarArr2;
        }
        q qVar = qVarArr[i6];
        if (qVar == null) {
            q qVar2 = new q(i6);
            qVarArr[i6] = qVar2;
            return qVar2;
        }
        return qVar;
    }

    final CharSequence e0() {
        Object obj = this.f333e;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f340l;
    }

    @Override // androidx.appcompat.app.c
    public Context f(Context context) {
        this.K = true;
        int n02 = n0(context, J());
        if (f331f0 && (context instanceof ContextThemeWrapper)) {
            try {
                o.a((ContextThemeWrapper) context, P(context, n02, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof h.d) {
            try {
                ((h.d) context).a(P(context, n02, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (f330e0) {
            try {
                Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
                Configuration configuration2 = context.getResources().getConfiguration();
                Configuration P = P(context, n02, configuration.equals(configuration2) ? null : Z(configuration, configuration2));
                h.d dVar = new h.d(context, b.i.Theme_AppCompat_Empty);
                dVar.a(P);
                boolean z5 = false;
                try {
                    z5 = context.getTheme() != null;
                } catch (NullPointerException unused3) {
                }
                if (z5) {
                    f.b.a(dVar.getTheme());
                }
                return super.f(dVar);
            } catch (PackageManager.NameNotFoundException e6) {
                throw new RuntimeException("Application failed to obtain resources from itself", e6);
            }
        }
        return super.f(context);
    }

    final Window.Callback f0() {
        return this.f335g.getCallback();
    }

    @Override // androidx.appcompat.app.c
    public View i(int i6) {
        W();
        return this.f335g.findViewById(i6);
    }

    @Override // androidx.appcompat.app.c
    public int k() {
        return this.O;
    }

    @Override // androidx.appcompat.app.c
    public MenuInflater l() {
        if (this.f339k == null) {
            g0();
            androidx.appcompat.app.a aVar = this.f338j;
            this.f339k = new h.g(aVar != null ? aVar.k() : this.f334f);
        }
        return this.f339k;
    }

    @Override // androidx.appcompat.app.c
    public androidx.appcompat.app.a m() {
        g0();
        return this.f338j;
    }

    public boolean m0() {
        return this.f349u;
    }

    @Override // androidx.appcompat.app.c
    public void n() {
        LayoutInflater from = LayoutInflater.from(this.f334f);
        if (from.getFactory() == null) {
            e0.f.a(from, this);
        } else if (from.getFactory2() instanceof d) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int n0(Context context, int i6) {
        j c02;
        Object systemService;
        if (i6 != -100) {
            if (i6 != -1) {
                if (i6 == 0) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        systemService = context.getApplicationContext().getSystemService(UiModeManager.class);
                        if (((UiModeManager) systemService).getNightMode() == 0) {
                            return -1;
                        }
                    }
                    c02 = c0(context);
                } else if (i6 != 1 && i6 != 2) {
                    if (i6 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    c02 = b0(context);
                }
                return c02.c();
            }
            return i6;
        }
        return -1;
    }

    @Override // androidx.appcompat.app.c
    public void o() {
        androidx.appcompat.app.a m5 = m();
        if (m5 == null || !m5.l()) {
            k0(0);
        }
    }

    boolean o0() {
        h.b bVar = this.f344p;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a m5 = m();
        return m5 != null && m5.h();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return R(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.c
    public void p(Configuration configuration) {
        androidx.appcompat.app.a m5;
        if (this.B && this.f350v && (m5 = m()) != null) {
            m5.m(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.f334f);
        G(false);
    }

    boolean p0(int i6, KeyEvent keyEvent) {
        if (i6 == 4) {
            this.J = (keyEvent.getFlags() & 128) != 0;
        } else if (i6 == 82) {
            q0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.c
    public void q(Bundle bundle) {
        String str;
        this.K = true;
        G(false);
        X();
        Object obj = this.f333e;
        if (obj instanceof Activity) {
            try {
                str = t.j.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                androidx.appcompat.app.a y02 = y0();
                if (y02 == null) {
                    this.X = true;
                } else {
                    y02.r(true);
                }
            }
            androidx.appcompat.app.c.c(this);
        }
        this.L = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    @Override // androidx.appcompat.app.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r() {
        androidx.appcompat.app.a aVar;
        if (this.f333e instanceof Activity) {
            androidx.appcompat.app.c.x(this);
        }
        if (this.U) {
            this.f335g.getDecorView().removeCallbacks(this.W);
        }
        this.M = false;
        this.N = true;
        if (this.O != -100) {
            Object obj = this.f333e;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f327b0.put(this.f333e.getClass().getName(), Integer.valueOf(this.O));
                aVar = this.f338j;
                if (aVar != null) {
                    aVar.n();
                }
                M();
            }
        }
        f327b0.remove(this.f333e.getClass().getName());
        aVar = this.f338j;
        if (aVar != null) {
        }
        M();
    }

    boolean r0(int i6, KeyEvent keyEvent) {
        androidx.appcompat.app.a m5 = m();
        if (m5 == null || !m5.o(i6, keyEvent)) {
            q qVar = this.I;
            if (qVar != null && z0(qVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                q qVar2 = this.I;
                if (qVar2 != null) {
                    qVar2.f387n = true;
                }
                return true;
            }
            if (this.I == null) {
                q d02 = d0(0, true);
                A0(d02, keyEvent);
                boolean z02 = z0(d02, keyEvent.getKeyCode(), keyEvent, 1);
                d02.f386m = false;
                if (z02) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.app.c
    public void s(Bundle bundle) {
        W();
    }

    boolean s0(int i6, KeyEvent keyEvent) {
        if (i6 == 4) {
            boolean z5 = this.J;
            this.J = false;
            q d02 = d0(0, false);
            if (d02 != null && d02.f388o) {
                if (!z5) {
                    O(d02, true);
                }
                return true;
            } else if (o0()) {
                return true;
            }
        } else if (i6 == 82) {
            t0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.c
    public void t() {
        androidx.appcompat.app.a m5 = m();
        if (m5 != null) {
            m5.s(true);
        }
    }

    @Override // androidx.appcompat.app.c
    public void u(Bundle bundle) {
    }

    void u0(int i6) {
        androidx.appcompat.app.a m5;
        if (i6 != 108 || (m5 = m()) == null) {
            return;
        }
        m5.i(true);
    }

    @Override // androidx.appcompat.app.c
    public void v() {
        this.M = true;
        F();
    }

    void v0(int i6) {
        if (i6 == 108) {
            androidx.appcompat.app.a m5 = m();
            if (m5 != null) {
                m5.i(false);
            }
        } else if (i6 == 0) {
            q d02 = d0(i6, true);
            if (d02.f388o) {
                O(d02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.c
    public void w() {
        this.M = false;
        androidx.appcompat.app.a m5 = m();
        if (m5 != null) {
            m5.s(false);
        }
    }

    void w0(ViewGroup viewGroup) {
    }

    final androidx.appcompat.app.a y0() {
        return this.f338j;
    }

    @Override // androidx.appcompat.app.c
    public boolean z(int i6) {
        int C0 = C0(i6);
        if (this.F && C0 == 108) {
            return false;
        }
        if (this.B && C0 == 1) {
            this.B = false;
        }
        if (C0 == 1) {
            H0();
            this.F = true;
            return true;
        } else if (C0 == 2) {
            H0();
            this.f354z = true;
            return true;
        } else if (C0 == 5) {
            H0();
            this.A = true;
            return true;
        } else if (C0 == 10) {
            H0();
            this.D = true;
            return true;
        } else if (C0 == 108) {
            H0();
            this.B = true;
            return true;
        } else if (C0 != 109) {
            return this.f335g.requestFeature(C0);
        } else {
            H0();
            this.C = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Dialog dialog, d.a aVar) {
        this(dialog.getContext(), dialog.getWindow(), aVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private d(Context context, Window window, d.a aVar, Object obj) {
        AppCompatActivity I0;
        this.f348t = null;
        this.f349u = true;
        this.O = -100;
        this.W = new a();
        this.f334f = context;
        this.f337i = aVar;
        this.f333e = obj;
        if (this.O == -100 && (obj instanceof Dialog) && (I0 = I0()) != null) {
            this.O = I0.u().k();
        }
        if (this.O == -100) {
            l.g gVar = f327b0;
            Integer num = (Integer) gVar.get(obj.getClass().getName());
            if (num != null) {
                this.O = num.intValue();
                gVar.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.j.h();
    }
}
