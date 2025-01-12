package h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.c2;
import androidx.appcompat.widget.f1;
import e0.n;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import okio.internal._BufferKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class[] f10548e;

    /* renamed from: f  reason: collision with root package name */
    static final Class[] f10549f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f10550a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f10551b;

    /* renamed from: c  reason: collision with root package name */
    Context f10552c;

    /* renamed from: d  reason: collision with root package name */
    private Object f10553d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class[] f10554c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f10555a;

        /* renamed from: b  reason: collision with root package name */
        private Method f10556b;

        public a(Object obj, String str) {
            this.f10555a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f10556b = cls.getMethod(str, f10554c);
            } catch (Exception e6) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e6);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f10556b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f10556b.invoke(this.f10555a, menuItem)).booleanValue();
                }
                this.f10556b.invoke(this.f10555a, menuItem);
                return true;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        e0.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f10557a;

        /* renamed from: b  reason: collision with root package name */
        private int f10558b;

        /* renamed from: c  reason: collision with root package name */
        private int f10559c;

        /* renamed from: d  reason: collision with root package name */
        private int f10560d;

        /* renamed from: e  reason: collision with root package name */
        private int f10561e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10562f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10563g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f10564h;

        /* renamed from: i  reason: collision with root package name */
        private int f10565i;

        /* renamed from: j  reason: collision with root package name */
        private int f10566j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f10567k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f10568l;

        /* renamed from: m  reason: collision with root package name */
        private int f10569m;

        /* renamed from: n  reason: collision with root package name */
        private char f10570n;

        /* renamed from: o  reason: collision with root package name */
        private int f10571o;

        /* renamed from: p  reason: collision with root package name */
        private char f10572p;

        /* renamed from: q  reason: collision with root package name */
        private int f10573q;

        /* renamed from: r  reason: collision with root package name */
        private int f10574r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f10575s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f10576t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f10577u;

        /* renamed from: v  reason: collision with root package name */
        private int f10578v;

        /* renamed from: w  reason: collision with root package name */
        private int f10579w;

        /* renamed from: x  reason: collision with root package name */
        private String f10580x;

        /* renamed from: y  reason: collision with root package name */
        private String f10581y;

        /* renamed from: z  reason: collision with root package name */
        private String f10582z;

        public b(Menu menu) {
            this.f10557a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f10552c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e6) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e6);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z5 = false;
            menuItem.setChecked(this.f10575s).setVisible(this.f10576t).setEnabled(this.f10577u).setCheckable(this.f10574r >= 1).setTitleCondensed(this.f10568l).setIcon(this.f10569m);
            int i6 = this.f10578v;
            if (i6 >= 0) {
                menuItem.setShowAsAction(i6);
            }
            if (this.f10582z != null) {
                if (g.this.f10552c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f10582z));
            }
            if (this.f10574r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof i.c) {
                    ((i.c) menuItem).h(true);
                }
            }
            String str = this.f10580x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f10548e, g.this.f10550a));
                z5 = true;
            }
            int i7 = this.f10579w;
            if (i7 > 0) {
                if (z5) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i7);
                }
            }
            e0.b bVar = this.A;
            if (bVar != null) {
                n.a(menuItem, bVar);
            }
            n.c(menuItem, this.B);
            n.g(menuItem, this.C);
            n.b(menuItem, this.f10570n, this.f10571o);
            n.f(menuItem, this.f10572p, this.f10573q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                n.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                n.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f10564h = true;
            i(this.f10557a.add(this.f10558b, this.f10565i, this.f10566j, this.f10567k));
        }

        public SubMenu b() {
            this.f10564h = true;
            SubMenu addSubMenu = this.f10557a.addSubMenu(this.f10558b, this.f10565i, this.f10566j, this.f10567k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f10564h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f10552c.obtainStyledAttributes(attributeSet, b.j.f2799r1);
            this.f10558b = obtainStyledAttributes.getResourceId(b.j.f2809t1, 0);
            this.f10559c = obtainStyledAttributes.getInt(b.j.f2819v1, 0);
            this.f10560d = obtainStyledAttributes.getInt(b.j.f2824w1, 0);
            this.f10561e = obtainStyledAttributes.getInt(b.j.f2829x1, 0);
            this.f10562f = obtainStyledAttributes.getBoolean(b.j.f2814u1, true);
            this.f10563g = obtainStyledAttributes.getBoolean(b.j.f2804s1, true);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            c2 u5 = c2.u(g.this.f10552c, attributeSet, b.j.f2834y1);
            this.f10565i = u5.n(b.j.B1, 0);
            this.f10566j = (u5.k(b.j.E1, this.f10559c) & (-65536)) | (u5.k(b.j.F1, this.f10560d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f10567k = u5.p(b.j.G1);
            this.f10568l = u5.p(b.j.H1);
            this.f10569m = u5.n(b.j.f2839z1, 0);
            this.f10570n = c(u5.o(b.j.I1));
            this.f10571o = u5.k(b.j.P1, _BufferKt.SEGMENTING_THRESHOLD);
            this.f10572p = c(u5.o(b.j.J1));
            this.f10573q = u5.k(b.j.T1, _BufferKt.SEGMENTING_THRESHOLD);
            int i6 = b.j.K1;
            this.f10574r = u5.s(i6) ? u5.a(i6, false) : this.f10561e;
            this.f10575s = u5.a(b.j.C1, false);
            this.f10576t = u5.a(b.j.D1, this.f10562f);
            this.f10577u = u5.a(b.j.A1, this.f10563g);
            this.f10578v = u5.k(b.j.U1, -1);
            this.f10582z = u5.o(b.j.L1);
            this.f10579w = u5.n(b.j.M1, 0);
            this.f10580x = u5.o(b.j.O1);
            String o5 = u5.o(b.j.N1);
            this.f10581y = o5;
            boolean z5 = o5 != null;
            if (z5 && this.f10579w == 0 && this.f10580x == null) {
                this.A = (e0.b) e(o5, g.f10549f, g.this.f10551b);
            } else {
                if (z5) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u5.p(b.j.Q1);
            this.C = u5.p(b.j.V1);
            int i7 = b.j.S1;
            if (u5.s(i7)) {
                this.E = f1.d(u5.k(i7, -1), this.E);
            } else {
                this.E = null;
            }
            int i8 = b.j.R1;
            if (u5.s(i8)) {
                this.D = u5.c(i8);
            } else {
                this.D = null;
            }
            u5.w();
            this.f10564h = false;
        }

        public void h() {
            this.f10558b = 0;
            this.f10559c = 0;
            this.f10560d = 0;
            this.f10561e = 0;
            this.f10562f = true;
            this.f10563g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f10548e = clsArr;
        f10549f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f10552c = context;
        Object[] objArr = {context};
        this.f10550a = objArr;
        this.f10551b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r6 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r15 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r15 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r15 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r15.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r15.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r0.d() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (r15.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (r15.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r15.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
        if (r15.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
        if (r15.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            }
        }
    }

    Object b() {
        if (this.f10553d == null) {
            this.f10553d = a(this.f10552c);
        }
        return this.f10553d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i6, Menu menu) {
        if (!(menu instanceof y.a)) {
            super.inflate(i6, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f10552c.getResources().getLayout(i6);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e6) {
                    throw new InflateException("Error inflating menu XML", e6);
                }
            } catch (IOException e7) {
                throw new InflateException("Error inflating menu XML", e7);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
