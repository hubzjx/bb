package e4;

import android.view.View;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final b f9533a;

    /* renamed from: b  reason: collision with root package name */
    private final View f9534b;

    /* renamed from: c  reason: collision with root package name */
    private int f9535c;

    /* renamed from: d  reason: collision with root package name */
    private float f9536d;

    /* renamed from: e  reason: collision with root package name */
    private int f9537e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9538f;

    /* renamed from: g  reason: collision with root package name */
    private int f9539g;

    /* renamed from: h  reason: collision with root package name */
    private int f9540h;

    /* renamed from: i  reason: collision with root package name */
    private int f9541i;

    /* renamed from: j  reason: collision with root package name */
    private int f9542j;

    /* renamed from: k  reason: collision with root package name */
    private int f9543k;

    /* renamed from: l  reason: collision with root package name */
    private int f9544l;

    /* renamed from: m  reason: collision with root package name */
    private int f9545m;

    public e(b bVar, View view) {
        this.f9533a = bVar;
        this.f9534b = view;
    }

    public int a() {
        return this.f9537e;
    }

    public int b() {
        return this.f9541i;
    }

    public int c() {
        return this.f9535c;
    }

    public int d() {
        return this.f9533a.f() == 0 ? this.f9535c : this.f9539g;
    }

    public int e() {
        return this.f9533a.f() == 0 ? this.f9539g : this.f9535c;
    }

    public int f() {
        return this.f9533a.f() == 0 ? this.f9540h : this.f9541i;
    }

    public int g() {
        int i6;
        int i7;
        if (this.f9533a.f() == 0) {
            i6 = this.f9542j;
            i7 = this.f9544l;
        } else {
            i6 = this.f9543k;
            i7 = this.f9545m;
        }
        return i6 + i7;
    }

    public int h() {
        int i6;
        int i7;
        if (this.f9533a.f() == 0) {
            i6 = this.f9543k;
            i7 = this.f9545m;
        } else {
            i6 = this.f9542j;
            i7 = this.f9544l;
        }
        return i6 + i7;
    }

    public int i() {
        return this.f9533a.f() == 0 ? this.f9541i : this.f9540h;
    }

    public View j() {
        return this.f9534b;
    }

    public float k() {
        return this.f9536d;
    }

    public int l() {
        return this.f9540h;
    }

    public boolean m() {
        return this.f9537e != 0;
    }

    public boolean n() {
        return this.f9538f;
    }

    public void o(int i6) {
        this.f9537e = i6;
    }

    public void p(int i6) {
        this.f9541i = i6;
    }

    public void q(int i6) {
        this.f9535c = i6;
    }

    public void r(int i6) {
        this.f9539g = i6;
    }

    public void s(int i6) {
        if (this.f9533a.f() == 0) {
            this.f9540h = i6;
        } else {
            this.f9541i = i6;
        }
    }

    public void t(int i6, int i7, int i8, int i9) {
        this.f9542j = i6;
        this.f9543k = i7;
        this.f9544l = i8;
        this.f9545m = i9;
    }

    public void u(boolean z5) {
        this.f9538f = z5;
    }

    public void v(int i6) {
        if (this.f9533a.f() == 0) {
            this.f9541i = i6;
        } else {
            this.f9540h = i6;
        }
    }

    public void w(float f6) {
        this.f9536d = f6;
    }

    public void x(int i6) {
        this.f9540h = i6;
    }

    public boolean y() {
        return this.f9536d >= 0.0f;
    }
}
