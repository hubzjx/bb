package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import e0.b0;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f610a;

    /* renamed from: b  reason: collision with root package name */
    private final e f611b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f612c;

    /* renamed from: d  reason: collision with root package name */
    private final int f613d;

    /* renamed from: e  reason: collision with root package name */
    private final int f614e;

    /* renamed from: f  reason: collision with root package name */
    private View f615f;

    /* renamed from: g  reason: collision with root package name */
    private int f616g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f617h;

    /* renamed from: i  reason: collision with root package name */
    private j.a f618i;

    /* renamed from: j  reason: collision with root package name */
    private h f619j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f620k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f621l;

    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z5, int i6) {
        this(context, eVar, view, z5, i6, 0);
    }

    private h a() {
        Display defaultDisplay = ((WindowManager) this.f610a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        h bVar = Math.min(point.x, point.y) >= this.f610a.getResources().getDimensionPixelSize(b.d.abc_cascading_menus_min_smallest_width) ? new b(this.f610a, this.f615f, this.f613d, this.f614e, this.f612c) : new l(this.f610a, this.f611b, this.f615f, this.f613d, this.f614e, this.f612c);
        bVar.l(this.f611b);
        bVar.u(this.f621l);
        bVar.p(this.f615f);
        bVar.k(this.f618i);
        bVar.r(this.f617h);
        bVar.s(this.f616g);
        return bVar;
    }

    private void l(int i6, int i7, boolean z5, boolean z6) {
        h c6 = c();
        c6.v(z6);
        if (z5) {
            if ((e0.d.b(this.f616g, b0.B(this.f615f)) & 7) == 5) {
                i6 -= this.f615f.getWidth();
            }
            c6.t(i6);
            c6.w(i7);
            int i8 = (int) ((this.f610a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c6.q(new Rect(i6 - i8, i7 - i8, i6 + i8, i7 + i8));
        }
        c6.a();
    }

    public void b() {
        if (d()) {
            this.f619j.dismiss();
        }
    }

    public h c() {
        if (this.f619j == null) {
            this.f619j = a();
        }
        return this.f619j;
    }

    public boolean d() {
        h hVar = this.f619j;
        return hVar != null && hVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f619j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f620k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f615f = view;
    }

    public void g(boolean z5) {
        this.f617h = z5;
        h hVar = this.f619j;
        if (hVar != null) {
            hVar.r(z5);
        }
    }

    public void h(int i6) {
        this.f616g = i6;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f620k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f618i = aVar;
        h hVar = this.f619j;
        if (hVar != null) {
            hVar.k(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f615f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i6, int i7) {
        if (d()) {
            return true;
        }
        if (this.f615f == null) {
            return false;
        }
        l(i6, i7, true, true);
        return true;
    }

    public i(Context context, e eVar, View view, boolean z5, int i6, int i7) {
        this.f616g = 8388611;
        this.f621l = new a();
        this.f610a = context;
        this.f611b = eVar;
        this.f615f = view;
        this.f612c = z5;
        this.f613d = i6;
        this.f614e = i7;
    }
}
