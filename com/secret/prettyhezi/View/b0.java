package com.secret.prettyhezi.View;

import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class b0 extends LinearLayout {

    /* renamed from: j  reason: collision with root package name */
    static final int[] f7853j = {2, 3, 100};

    /* renamed from: k  reason: collision with root package name */
    static final String[] f7854k = {"普通区", "精华区", "已解锁"};

    /* renamed from: l  reason: collision with root package name */
    static final String[] f7855l = {"最新", "解锁量", "解锁率"};

    /* renamed from: m  reason: collision with root package name */
    static final String[] f7856m = {"最新", "解锁量", "收藏量"};

    /* renamed from: n  reason: collision with root package name */
    static final int[] f7857n = {0, 1, 2};

    /* renamed from: o  reason: collision with root package name */
    static final int[] f7858o = {0, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f7859b;

    /* renamed from: c  reason: collision with root package name */
    a0[] f7860c;

    /* renamed from: d  reason: collision with root package name */
    String[] f7861d;

    /* renamed from: e  reason: collision with root package name */
    int f7862e;

    /* renamed from: f  reason: collision with root package name */
    boolean f7863f;

    /* renamed from: g  reason: collision with root package name */
    int f7864g;

    /* renamed from: h  reason: collision with root package name */
    int f7865h;

    /* renamed from: i  reason: collision with root package name */
    b f7866i;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7867d;

        a(int i6) {
            this.f7867d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            b0.this.c(this.f7867d);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(int i6, int i7);
    }

    public b0(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f7862e = 0;
        this.f7863f = false;
        this.f7864g = 0;
        this.f7865h = 0;
        this.f7859b = zZcINlcxH;
        this.f7861d = i6 == 6 ? f7856m : f7855l;
        setOrientation(0);
        setGravity(1);
        this.f7860c = new a0[f7854k.length];
        boolean z5 = zZcINlcxH.o().x > g4.i.r(500.0f);
        int i7 = 0;
        while (true) {
            String[] strArr = f7854k;
            if (i7 >= strArr.length) {
                break;
            }
            this.f7860c[i7] = new a0(zZcINlcxH, strArr[i7]);
            addView(this.f7860c[i7], z5 ? new LinearLayout.LayoutParams(g4.i.r(120.0f), -1) : new LinearLayout.LayoutParams(0, -1, 1.0f));
            this.f7860c[i7].setOnClickListener(new a(i7));
            i7++;
        }
        b();
        int i8 = 0;
        while (true) {
            a0[] a0VarArr = this.f7860c;
            if (i8 >= a0VarArr.length) {
                return;
            }
            a0VarArr[i8].b(i8 == 0);
            i8++;
        }
    }

    public void a(int i6, int i7) {
        a0 a0Var = this.f7860c[0];
        a0Var.c(i6 + HttpUrl.FRAGMENT_ENCODE_SET);
        a0 a0Var2 = this.f7860c[1];
        a0Var2.c(i7 + HttpUrl.FRAGMENT_ENCODE_SET);
    }

    void b() {
        this.f7864g = 0;
        this.f7865h = 0;
        this.f7860c[0].e(this.f7861d[f7857n[0]]);
        this.f7860c[1].e(this.f7861d[f7858o[this.f7865h]]);
    }

    void c(int i6) {
        int i7 = this.f7862e;
        if (i7 == i6) {
            if (i7 == 2) {
                this.f7866i.a();
            }
            d();
        } else if (i6 == 2 && MainApplication.f6711r.r() == null) {
            this.f7859b.M0(TK1dGVzP.class);
            return;
        } else {
            int i8 = 0;
            while (true) {
                a0[] a0VarArr = this.f7860c;
                boolean z5 = true;
                if (i8 >= a0VarArr.length) {
                    break;
                }
                a0 a0Var = a0VarArr[i8];
                if (i6 != i8) {
                    z5 = false;
                }
                a0Var.b(z5);
                i8++;
            }
            b();
            if (i6 == 0) {
                this.f7863f = false;
            } else if (i6 == 1) {
                this.f7863f = true;
            }
            this.f7862e = i6;
        }
        this.f7866i.b(f7853j[this.f7862e], this.f7863f ? f7858o[this.f7865h] : f7857n[this.f7864g]);
    }

    void d() {
        a0 a0Var;
        String str;
        if (this.f7863f) {
            int i6 = this.f7865h + 1;
            this.f7865h = i6;
            int[] iArr = f7858o;
            if (i6 == iArr.length) {
                this.f7865h = 0;
            }
            a0Var = this.f7860c[1];
            str = this.f7861d[iArr[this.f7865h]];
        } else {
            int i7 = this.f7864g + 1;
            this.f7864g = i7;
            int[] iArr2 = f7857n;
            if (i7 == iArr2.length) {
                this.f7864g = 0;
            }
            a0Var = this.f7860c[0];
            str = this.f7861d[iArr2[this.f7864g]];
        }
        a0Var.e(str);
    }

    public void setListener(b bVar) {
        this.f7866i = bVar;
    }
}
