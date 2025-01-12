package com.secret.prettyhezi;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Upload.ENV4IYF;
/* loaded from: classes.dex */
public class r extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    EjNkL f8800b;

    /* renamed from: c  reason: collision with root package name */
    q f8801c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8802d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Class f8803e;

        a(int i6, Class cls) {
            this.f8802d = i6;
            this.f8803e = cls;
        }

        @Override // g4.f
        protected void a(View view) {
            r.this.f8801c.a();
            int i6 = this.f8802d;
            if (i6 == -1) {
                r.this.f8800b.M0(this.f8803e);
            } else {
                r.this.f8800b.N0(this.f8803e, i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8805d;

        b(int i6) {
            this.f8805d = i6;
        }

        @Override // g4.f
        protected void a(View view) {
            r.this.f8801c.a();
            int i6 = this.f8805d;
            if (i6 == 101) {
                r.this.f8800b.g1();
            } else if (i6 == 103 || i6 == 104) {
                r.this.f8800b.d1(i6);
            } else {
                r.this.f8800b.f1(i6, 0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8807d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f8808e;

        c(int i6, int i7) {
            this.f8807d = i6;
            this.f8808e = i7;
        }

        @Override // g4.f
        protected void a(View view) {
            r.this.f8801c.a();
            r.this.f8800b.j1(this.f8807d, this.f8808e);
        }
    }

    public r(EjNkL ejNkL, q qVar) {
        super(ejNkL);
        setOrientation(1);
        setBackgroundColor(Color.parseColor("#efefef"));
        this.f8800b = ejNkL;
        this.f8801c = qVar;
        setPadding(g4.i.r(2.0f), g4.i.r(6.0f), 0, g4.i.r(6.0f));
        f();
        g();
        h();
        i();
        j();
        k();
        l();
    }

    TextView a(LinearLayout linearLayout, String str, int i6) {
        TextView c6 = g4.d.c(this.f8800b, i6, -16777216, str, 17);
        c6.setBackground(g4.i.f(0, Color.parseColor("#c0c0c0")));
        c6.setPadding(g4.i.r(5.0f), 0, g4.i.r(5.0f), 0);
        linearLayout.addView(c6, new LinearLayout.LayoutParams(-2, -1));
        return c6;
    }

    TextView b(LinearLayout linearLayout, String str, int i6, Class cls) {
        return c(linearLayout, str, i6, cls, -1);
    }

    TextView c(LinearLayout linearLayout, String str, int i6, Class cls, int i7) {
        TextView a6 = a(linearLayout, str, i6);
        a6.setOnClickListener(new a(i7, cls));
        return a6;
    }

    LinearLayout d() {
        LinearLayout linearLayout = new LinearLayout(this.f8800b);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(32.0f)));
        return linearLayout;
    }

    TextView e(LinearLayout linearLayout, String str, int i6, int i7) {
        TextView a6 = a(linearLayout, str, i6);
        a6.setOnClickListener(new b(i7));
        return a6;
    }

    void f() {
        LinearLayout d6 = d();
        e(d6, "关 注", 20, androidx.constraintlayout.widget.g.W0);
        e(d6, "盒 子", 20, 100);
        e(d6, "我的盒子", 14, androidx.constraintlayout.widget.g.T0);
        b(d6, "浏览记录", 14, LpyhZ.class);
    }

    void g() {
        LinearLayout d6 = d();
        e(d6, "短视频", 18, 2);
        e(d6, "影视", 18, 4);
        m(d6, "长视频", 18, 5, -1);
        m(d6, "自拍", 14, 5, 7);
    }

    void h() {
        LinearLayout d6 = d();
        m(d6, "动漫", 14, 5, 4);
        m(d6, "直播", 14, 5, 1);
        m(d6, "偷拍", 14, 5, 6);
        m(d6, "无码", 14, 5, 2);
        m(d6, "有码", 14, 5, 3);
        m(d6, "欧美", 14, 5, 5);
    }

    void i() {
        LinearLayout d6 = d();
        m(d6, "三级", 14, 5, 9);
        m(d6, "asmr", 14, 5, 12);
        m(d6, "电影", 14, 5, 10);
        m(d6, "电视剧", 14, 5, 11);
        m(d6, "其他", 14, 5, 8);
        b(d6, "已解锁", 18, ENV4IYF.class);
    }

    void j() {
        LinearLayout d6 = d();
        e(d6, "散图", 18, 1);
        m(d6, "套图", 18, 6, -1);
        m(d6, "网红/福利姬", 14, 6, 1);
        m(d6, "国模/私拍", 14, 6, 2);
    }

    void k() {
        LinearLayout d6 = d();
        m(d6, "日韩套图", 14, 6, 3);
        m(d6, "欧美套图", 14, 6, 4);
        m(d6, "漫画", 14, 6, 6);
        m(d6, "其他", 14, 6, 5);
    }

    void l() {
        LinearLayout d6 = d();
        e(d6, "小说", 18, 3);
        m(d6, "语音", 18, 7, -1);
        m(d6, "有声小说", 14, 7, 1);
        m(d6, "性爱录音", 14, 7, 2);
    }

    TextView m(LinearLayout linearLayout, String str, int i6, int i7, int i8) {
        TextView a6 = a(linearLayout, str, i6);
        a6.setOnClickListener(new c(i7, i8));
        return a6;
    }
}
