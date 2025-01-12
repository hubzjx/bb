package com.secret.prettyhezi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.c;
import com.secret.prettyhezi.Server.c0;
import com.secret.prettyhezi.Server.d;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.l;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class SLUjG extends UoWMF {
    com.secret.prettyhezi.View.j A;
    com.secret.prettyhezi.View.j B;
    com.secret.prettyhezi.View.k C;
    com.secret.prettyhezi.View.j D;
    LinearLayout E;
    int F;
    p M;
    TextView N;
    TextView O;

    /* renamed from: s  reason: collision with root package name */
    public int f6987s;

    /* renamed from: u  reason: collision with root package name */
    FrameLayout f6989u;

    /* renamed from: v  reason: collision with root package name */
    RelativeLayout f6990v;

    /* renamed from: w  reason: collision with root package name */
    com.secret.prettyhezi.controls.l f6991w;

    /* renamed from: x  reason: collision with root package name */
    l f6992x;

    /* renamed from: y  reason: collision with root package name */
    com.secret.prettyhezi.View.j[] f6993y;

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.View.k f6994z;

    /* renamed from: r  reason: collision with root package name */
    public c.a f6986r = null;

    /* renamed from: t  reason: collision with root package name */
    View.OnClickListener f6988t = new c();
    boolean G = false;
    com.secret.prettyhezi.Server.d H = null;
    com.secret.prettyhezi.View.t I = null;
    int J = 0;
    ArrayList K = null;
    int L = -1;
    l.f P = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.Server.c cVar = (com.secret.prettyhezi.Server.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.c.class);
            if (cVar.code != 200) {
                SLUjG.this.w0(cVar);
                return;
            }
            SLUjG sLUjG = SLUjG.this;
            sLUjG.f6986r = cVar.data;
            sLUjG.X0();
        }
    }

    /* loaded from: classes.dex */
    class b implements l.f {
        b() {
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public int a() {
            return SLUjG.this.F;
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public String b(int i6) {
            SLUjG sLUjG;
            int i7;
            switch (i6) {
                case 0:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.Images;
                    break;
                case 1:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.Gallerys;
                    break;
                case 2:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.Audios;
                    break;
                case 3:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.ShortVideos;
                    break;
                case 4:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.Films;
                    break;
                case 5:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.Novels;
                    break;
                case 6:
                    sLUjG = SLUjG.this;
                    i7 = C0382R.string.LongVideo;
                    break;
                default:
                    return null;
            }
            return sLUjG.s0(i7);
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public String c(int i6) {
            StringBuilder sb;
            int i7;
            switch (i6) {
                case 0:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.pc;
                    break;
                case 1:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.gc;
                    break;
                case 2:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.mc;
                    break;
                case 3:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.vc;
                    break;
                case 4:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.lc;
                    break;
                case 5:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.bc;
                    break;
                case 6:
                    sb = new StringBuilder();
                    i7 = SLUjG.this.f6986r.tj.rc;
                    break;
                default:
                    return null;
            }
            sb.append(i7);
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            return sb.toString();
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public View d(int i6) {
            SLUjG sLUjG = SLUjG.this;
            d.a aVar = sLUjG.f6986r.tj;
            if (i6 == 0 || i6 == 1) {
                int i7 = i6 == 0 ? aVar.pc : i6 == 1 ? aVar.gc : aVar.mc;
                int i8 = i6 == 0 ? 1 : 6;
                if (i7 > 0) {
                    com.secret.prettyhezi.View.j[] jVarArr = sLUjG.f6993y;
                    if (jVarArr[i6] == null) {
                        jVarArr[i6] = new com.secret.prettyhezi.View.j(SLUjG.this, i8);
                        SLUjG sLUjG2 = SLUjG.this;
                        sLUjG2.f6993y[i6].N(sLUjG2.f6986r.id, sLUjG2.G);
                    }
                    return SLUjG.this.f6993y[i6];
                }
                return sLUjG.f6991w.r();
            } else if (i6 == 2) {
                if (aVar.mc > 0) {
                    if (sLUjG.f6994z == null) {
                        sLUjG.f6994z = new com.secret.prettyhezi.View.k(SLUjG.this, 7);
                        SLUjG sLUjG3 = SLUjG.this;
                        sLUjG3.f6994z.N(sLUjG3.f6987s, sLUjG3.G);
                    }
                    return SLUjG.this.f6994z;
                }
                return sLUjG.f6991w.r();
            } else if (i6 == 3) {
                if (aVar.vc > 0) {
                    if (sLUjG.A == null) {
                        sLUjG.A = new com.secret.prettyhezi.View.j(SLUjG.this, 2);
                        SLUjG sLUjG4 = SLUjG.this;
                        sLUjG4.A.N(sLUjG4.f6986r.id, sLUjG4.G);
                    }
                    return SLUjG.this.A;
                }
                return sLUjG.f6991w.r();
            } else if (i6 == 4) {
                if (aVar.lc > 0) {
                    if (sLUjG.B == null) {
                        sLUjG.B = new com.secret.prettyhezi.View.j(SLUjG.this, 4);
                        SLUjG sLUjG5 = SLUjG.this;
                        sLUjG5.B.N(sLUjG5.f6986r.id, sLUjG5.G);
                    }
                    return SLUjG.this.B;
                }
                return sLUjG.f6991w.r();
            } else if (i6 == 5) {
                if (aVar.bc > 0) {
                    if (sLUjG.C == null) {
                        sLUjG.C = new com.secret.prettyhezi.View.k(SLUjG.this, 3);
                        SLUjG sLUjG6 = SLUjG.this;
                        sLUjG6.C.N(sLUjG6.f6987s, sLUjG6.G);
                    }
                    return SLUjG.this.C;
                }
                return sLUjG.f6991w.r();
            } else if (i6 == 6) {
                if (aVar.rc > 0) {
                    if (sLUjG.D == null) {
                        sLUjG.D = new com.secret.prettyhezi.View.j(SLUjG.this, 5);
                        SLUjG sLUjG7 = SLUjG.this;
                        com.secret.prettyhezi.View.j jVar = sLUjG7.D;
                        jVar.R = 2;
                        jVar.N(sLUjG7.f6986r.id, sLUjG7.G);
                    }
                    return SLUjG.this.D;
                }
                return sLUjG.f6991w.r();
            } else {
                return null;
            }
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public View e() {
            return SLUjG.this.E;
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            SLUjG sLUjG = SLUjG.this;
            sLUjG.N0(Yzg4R57AT.class, sLUjG.f6986r.uf.uu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            if (SLUjG.this.N.getText().toString().equals(SLUjG.this.s0(C0382R.string.edit))) {
                SLUjG.this.b1();
            } else {
                SLUjG.this.S0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            SLUjG.this.c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.SLUjG$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0097a implements s.f {
                C0097a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    SLUjG.this.M.b(false);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                SLUjG sLUjG = SLUjG.this;
                s.f(sLUjG.f6987s, sLUjG, new C0097a());
            }
        }

        /* loaded from: classes.dex */
        class b implements s.f {
            b() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                SLUjG.this.M.b(true);
                MainApplication.f6711r.r().integral.all -= MainApplication.f6711r.j();
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
                EjNkL.N.f6165r.i();
            }
        }

        f() {
        }

        @Override // g4.f
        public void a(View view) {
            SLUjG sLUjG = SLUjG.this;
            if (sLUjG.M.f8746d) {
                sLUjG.B(sLUjG.s0(C0382R.string.UnfollowBox), new a(), true);
            } else {
                s.b(sLUjG.f6987s, sLUjG, new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.SLUjG$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0098a implements s.f {
                C0098a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    SLUjG.this.H("操作成功");
                    SLUjG.this.finish();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                SLUjG.this.I0();
                com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "box/del/json?id=" + SLUjG.this.f6987s, true, new s.e(SLUjG.this, new C0098a()));
            }
        }

        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            SLUjG.this.B("删除该盒子?", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends ZZcINlcxH.q {
        h() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            SLUjG sLUjG = SLUjG.this;
            sLUjG.J0(sLUjG.L == 0 ? "正在删除" : "正在迁移");
            SLUjG.this.Z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f7008a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SLUjG.this.U0();
            }
        }

        /* loaded from: classes.dex */
        class b extends j.e {
            b() {
            }

            @Override // com.secret.prettyhezi.j.e
            public void a(IOException iOException) {
                i.this.d();
            }

            @Override // com.secret.prettyhezi.j.e
            public void b(int i6) {
                i.this.d();
            }

            @Override // com.secret.prettyhezi.j.e
            public void c(String str) {
                i.this.g();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SLUjG.this.Z0();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ArrayList f7013a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.View.t f7014b;

            d(ArrayList arrayList, com.secret.prettyhezi.View.t tVar) {
                this.f7013a = arrayList;
                this.f7014b = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = this.f7013a.iterator();
                while (it.hasNext()) {
                    com.secret.prettyhezi.Server.n nVar = (com.secret.prettyhezi.Server.n) it.next();
                    com.secret.prettyhezi.View.t tVar = this.f7014b;
                    tVar.z(nVar, tVar.t(nVar));
                }
            }
        }

        i(String[] strArr) {
            this.f7008a = strArr;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            d();
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            d();
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            com.secret.prettyhezi.Server.d dVar;
            f();
            SLUjG sLUjG = SLUjG.this;
            if (sLUjG.L != 1 || (dVar = sLUjG.H) == null) {
                g();
            } else {
                com.secret.prettyhezi.Server.v.o(this.f7008a, sLUjG.J, dVar.id, new b());
            }
        }

        void d() {
            SLUjG.this.runOnUiThread(new a());
        }

        void e() {
            SLUjG.this.runOnUiThread(new c());
        }

        void f() {
            SLUjG sLUjG = SLUjG.this;
            sLUjG.runOnUiThread(new d(sLUjG.K, sLUjG.I));
        }

        void g() {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.w f7016d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f7017e;

        /* loaded from: classes.dex */
        class a extends s.g {

            /* renamed from: com.secret.prettyhezi.SLUjG$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0099a extends g4.f {

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ com.secret.prettyhezi.controls.w f7020d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ com.secret.prettyhezi.Server.d f7021e;

                C0099a(com.secret.prettyhezi.controls.w wVar, com.secret.prettyhezi.Server.d dVar) {
                    this.f7020d = wVar;
                    this.f7021e = dVar;
                }

                @Override // g4.f
                public void a(View view) {
                    SLUjG.this.j(this.f7020d);
                    SLUjG.this.a1(1);
                    SLUjG.this.H = this.f7021e;
                }
            }

            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                LinearLayout linearLayout;
                com.secret.prettyhezi.Server.o c6 = com.secret.prettyhezi.f.c(str, com.secret.prettyhezi.Server.d.class);
                if (c6.code != 200) {
                    f(c6.err);
                } else if (c6.data.total > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (com.secret.prettyhezi.Server.n nVar : c6.data.items) {
                        com.secret.prettyhezi.Server.d dVar = (com.secret.prettyhezi.Server.d) nVar;
                        if (dVar.id != SLUjG.this.f6987s) {
                            arrayList.add(dVar);
                        }
                    }
                    if (arrayList.size() == 0) {
                        SLUjG.this.D("你没有其他盒子可以转移，请先创建", null, true);
                        return;
                    }
                    com.secret.prettyhezi.controls.w wVar = new com.secret.prettyhezi.controls.w(SLUjG.this);
                    wVar.setPadding(g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(10.0f), g4.i.r(10.0f));
                    wVar.setOrientation(1);
                    wVar.addView(g4.d.c(SLUjG.this, 16, -16777216, "请选择目标盒子", 17), new LinearLayout.LayoutParams(-1, g4.i.r(32.0f)));
                    if (arrayList.size() > 6) {
                        ScrollView scrollView = new ScrollView(SLUjG.this);
                        scrollView.setHorizontalScrollBarEnabled(false);
                        scrollView.setVerticalScrollBarEnabled(false);
                        wVar.addView(scrollView, new LinearLayout.LayoutParams(-1, g4.i.r(320.0f)));
                        linearLayout = new LinearLayout(SLUjG.this);
                        linearLayout.setOrientation(1);
                        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
                    } else {
                        linearLayout = wVar;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        com.secret.prettyhezi.Server.d dVar2 = (com.secret.prettyhezi.Server.d) it.next();
                        TextView c7 = g4.d.c(SLUjG.this, 16, -16777216, dVar2.na, 17);
                        c7.setBackground(g4.i.d(g4.i.c(Color.parseColor("#f0f0f0"), 5.0f, Color.parseColor("#888888"), 1.0f), g4.i.b(-7829368, 5.0f)));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42));
                        int r5 = g4.i.r(4.0f);
                        layoutParams.bottomMargin = r5;
                        layoutParams.topMargin = r5;
                        linearLayout.addView(c7, layoutParams);
                        c7.setOnClickListener(new C0099a(wVar, dVar2));
                    }
                    SLUjG.this.x(wVar, null, true);
                }
            }
        }

        j(com.secret.prettyhezi.controls.w wVar, int i6) {
            this.f7016d = wVar;
            this.f7017e = i6;
        }

        @Override // g4.f
        public void a(View view) {
            SLUjG.this.j(this.f7016d);
            int i6 = this.f7017e;
            if (i6 == 0) {
                SLUjG.this.a1(i6);
            } else if (i6 == 1) {
                SLUjG.this.J0("正在获取盒子列表");
                com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + com.secret.prettyhezi.Server.v.k(MainApplication.f(), 1), true, new a(SLUjG.this));
            } else if (i6 == 2) {
                SLUjG sLUjG = SLUjG.this;
                sLUjG.N.setText(sLUjG.s0(C0382R.string.cancel));
                SLUjG.this.f6991w.g(true);
            }
        }
    }

    /* loaded from: classes.dex */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH j6 = g4.i.j();
            SLUjG sLUjG = SLUjG.this;
            if (j6 != sLUjG) {
                sLUjG.f6991w.t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f7024b;

        /* renamed from: c  reason: collision with root package name */
        TextView f7025c;

        /* renamed from: d  reason: collision with root package name */
        TextView f7026d;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ SLUjG f7028d;

            a(SLUjG sLUjG) {
                this.f7028d = sLUjG;
            }

            @Override // g4.f
            public void a(View view) {
                SLUjG sLUjG = SLUjG.this;
                sLUjG.O0(PTnimM.class, sLUjG.f6987s, 1);
            }
        }

        public l() {
            super(SLUjG.this);
            setOrientation(1);
            setBackgroundColor(-1);
            LinearLayout linearLayout = new LinearLayout(SLUjG.this);
            this.f7024b = linearLayout;
            linearLayout.setOrientation(0);
            this.f7024b.setGravity(16);
            this.f7025c = g4.d.b(SLUjG.this, 12.0f, Color.parseColor("#aaaaaa"), SLUjG.this.f6986r.tj.cc + SLUjG.this.s0(C0382R.string.items));
            String str = SLUjG.this.f6986r.tj.fc + SLUjG.this.s0(C0382R.string.followers);
            if (SLUjG.this.f6986r.tj.fc > 0) {
                str = str + ">";
            }
            TextView b6 = g4.d.b(SLUjG.this, 12.0f, -16777216, str);
            this.f7026d = b6;
            b6.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
            this.f7026d.setGravity(17);
            this.f7026d.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#e2e2e2"), 4.0f)));
            if (SLUjG.this.f6986r.tj.fc > 0) {
                this.f7026d.setOnClickListener(new a(SLUjG.this));
            }
            this.f7024b.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
            c0 c0Var = SLUjG.this.f6986r.uf;
            if (c0Var != null) {
                com.secret.prettyhezi.View.d dVar = new com.secret.prettyhezi.View.d(SLUjG.this);
                dVar.setOnClickListener(SLUjG.this.f6988t);
                TextView b7 = g4.d.b(SLUjG.this, 14.0f, -16777216, c0Var.nk);
                b7.setOnClickListener(SLUjG.this.f6988t);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(36.0f), g4.i.r(36.0f));
                layoutParams.rightMargin = g4.i.r(8.0f);
                this.f7024b.addView(dVar, layoutParams);
                this.f7024b.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams2.rightMargin = g4.i.r(12.0f);
            this.f7025c.setGravity(5);
            this.f7024b.addView(this.f7025c, layoutParams2);
            this.f7024b.addView(this.f7026d, new LinearLayout.LayoutParams(-2, g4.i.r(40)));
            addView(this.f7024b, new LinearLayout.LayoutParams(-1, g4.i.r(60.0f)));
        }
    }

    void S0() {
        this.N.setText(s0(C0382R.string.edit));
        this.f6991w.g(false);
        if (this.L != -1) {
            this.L = -1;
            this.H = null;
            this.O.setVisibility(8);
            this.f6991w.h(false);
            T0();
        }
    }

    void T0() {
        com.secret.prettyhezi.View.j jVar = this.D;
        if (jVar != null) {
            jVar.m();
            this.D.K(false);
        }
        com.secret.prettyhezi.View.j jVar2 = this.B;
        if (jVar2 != null) {
            jVar2.m();
            this.B.K(false);
        }
        com.secret.prettyhezi.View.k kVar = this.C;
        if (kVar != null) {
            kVar.m();
            this.C.K(false);
        }
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.View.j[] jVarArr = this.f6993y;
            if (i6 >= jVarArr.length) {
                break;
            }
            com.secret.prettyhezi.View.j jVar3 = jVarArr[i6];
            if (jVar3 != null) {
                jVar3.m();
                this.f6993y[i6].K(false);
            }
            i6++;
        }
        com.secret.prettyhezi.View.k kVar2 = this.f6994z;
        if (kVar2 != null) {
            kVar2.m();
            this.f6994z.K(false);
        }
        com.secret.prettyhezi.View.j jVar4 = this.A;
        if (jVar4 != null) {
            jVar4.m();
            this.A.K(false);
        }
    }

    void U0() {
        String str;
        j0();
        if (this.L == 0) {
            str = "删除资源出错";
        } else {
            str = "转移资源到" + this.H.na + "出错";
        }
        D(str, null, false);
    }

    void V0() {
        String str;
        j0();
        if (this.L == 0) {
            str = "成功删除所选资源";
        } else {
            str = "成功转移所选资源到" + this.H.na;
        }
        D(str, null, true);
        S0();
    }

    int W0() {
        d.a aVar = this.f6986r.tj;
        if (aVar.pc > 0) {
            return 0;
        }
        if (aVar.gc > 0) {
            return 1;
        }
        if (aVar.mc > 0) {
            return 2;
        }
        if (aVar.vc > 0) {
            return 3;
        }
        if (aVar.lc > 0) {
            return 4;
        }
        if (aVar.bc > 0) {
            return 5;
        }
        return aVar.rc > 0 ? 6 : 0;
    }

    void X0() {
        a0 r5;
        LinearLayout linearLayout = new LinearLayout(this);
        this.E = linearLayout;
        linearLayout.setOrientation(1);
        this.E.setBackgroundColor(-1);
        RelativeLayout O = O(this.E, this.f6986r.na);
        this.f6990v = O;
        this.F = O.getLayoutParams().height;
        if (MainApplication.f() == this.f6986r.uf.uu) {
            this.G = true;
        } else {
            this.G = false;
        }
        this.M = new p(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11, -1);
        this.f6990v.addView(this.M, layoutParams);
        if (this.G) {
            p pVar = this.M;
            pVar.removeView(pVar.f8744b);
            TextView b6 = g4.d.b(this, 14.0f, -16777216, s0(C0382R.string.edit));
            this.N = b6;
            b6.setGravity(17);
            this.N.setBackground(g4.i.d(g4.i.b(-1, 10.0f), g4.i.b(-65536, 10.0f)));
            this.N.setOnClickListener(new d());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(52.0f), g4.i.r(36.0f));
            layoutParams2.rightMargin = g4.i.r(12.0f);
            this.M.addView(this.N, 0, layoutParams2);
            TextView b7 = g4.d.b(this, 14.0f, -16777216, s0(C0382R.string.edit));
            this.O = b7;
            b7.setPadding(g4.i.r(10.0f), 0, g4.i.r(10.0f), 0);
            this.O.setGravity(17);
            this.O.setBackground(g4.i.d(g4.i.b(-65536, 10.0f), g4.i.b(-256, 10.0f)));
            this.O.setOnClickListener(new e());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, g4.i.r(36.0f));
            layoutParams3.rightMargin = g4.i.r(0.0f);
            this.M.addView(this.O, 0, layoutParams3);
            this.O.setVisibility(8);
        } else {
            this.M.f8744b.setOnClickListener(new f());
        }
        l lVar = new l();
        this.f6992x = lVar;
        this.E.addView(lVar, new LinearLayout.LayoutParams(-1, -2));
        this.F += g4.i.r(60.0f);
        this.f6993y = new com.secret.prettyhezi.View.j[2];
        com.secret.prettyhezi.controls.l lVar2 = new com.secret.prettyhezi.controls.l(this, 7, this.P);
        this.f6991w = lVar2;
        lVar2.f8384r = true;
        lVar2.f(W0());
        this.f6989u.addView(this.f6991w, new FrameLayout.LayoutParams(-1, -1));
        this.M.b(this.f6986r.ff);
        if (Fc3zRvpgB.f6210z && (r5 = MainApplication.f6711r.r()) != null && r5.mas) {
            this.M.setVisibility(8);
            TextView c6 = g4.d.c(this, 14, -1, getString(C0382R.string.Delete), 17);
            c6.setBackground(g4.i.d(g4.i.b(-65536, 5.0f), g4.i.b(Color.parseColor("#88ff0000"), 5.0f)));
            c6.setOnClickListener(new g());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(36.0f));
            layoutParams4.addRule(11, -1);
            layoutParams4.addRule(15, -1);
            layoutParams4.rightMargin = g4.i.r(12.0f);
            this.f6990v.addView(c6, layoutParams4);
        }
    }

    void Y0(Intent intent) {
        this.f6993y = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.f6994z = null;
        I0();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f6987s = extras.getInt("id");
        }
        com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + com.secret.prettyhezi.Server.v.d(this.f6987s), true, new a(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void Z0() {
        int i6;
        ArrayList arrayList;
        this.K = null;
        com.secret.prettyhezi.View.j jVar = this.f6993y[0];
        if (jVar != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems = jVar.getSelectedItems();
            this.K = selectedItems;
            if (selectedItems != null) {
                this.I = this.f6993y[0];
                this.J = 1;
                arrayList = this.K;
                if (arrayList == null) {
                    V0();
                    return;
                }
                String[] strArr = new String[arrayList.size()];
                for (int i7 = 0; i7 < this.K.size(); i7++) {
                    strArr[i7] = ((com.secret.prettyhezi.Server.n) this.K.get(i7)).id + HttpUrl.FRAGMENT_ENCODE_SET;
                }
                com.secret.prettyhezi.Server.v.z(strArr, this.J, this.f6987s, new i(strArr));
                return;
            }
        }
        com.secret.prettyhezi.View.j jVar2 = this.f6993y[1];
        if (jVar2 != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems2 = jVar2.getSelectedItems();
            this.K = selectedItems2;
            if (selectedItems2 != null) {
                this.I = this.f6993y[1];
                i6 = 6;
                this.J = i6;
                arrayList = this.K;
                if (arrayList == null) {
                }
            }
        }
        com.secret.prettyhezi.View.k kVar = this.f6994z;
        if (kVar != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems3 = kVar.getSelectedItems();
            this.K = selectedItems3;
            if (selectedItems3 != null) {
                this.I = this.f6994z;
                i6 = 7;
                this.J = i6;
                arrayList = this.K;
                if (arrayList == null) {
                }
            }
        }
        com.secret.prettyhezi.View.j jVar3 = this.A;
        if (jVar3 != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems4 = jVar3.getSelectedItems();
            this.K = selectedItems4;
            if (selectedItems4 != null) {
                this.I = this.A;
                i6 = 2;
                this.J = i6;
                arrayList = this.K;
                if (arrayList == null) {
                }
            }
        }
        com.secret.prettyhezi.View.k kVar2 = this.C;
        if (kVar2 != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems5 = kVar2.getSelectedItems();
            this.K = selectedItems5;
            if (selectedItems5 != null) {
                this.I = this.C;
                i6 = 3;
                this.J = i6;
                arrayList = this.K;
                if (arrayList == null) {
                }
            }
        }
        com.secret.prettyhezi.View.j jVar4 = this.B;
        if (jVar4 != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems6 = jVar4.getSelectedItems();
            this.K = selectedItems6;
            if (selectedItems6 != null) {
                this.I = this.B;
                i6 = 4;
                this.J = i6;
                arrayList = this.K;
                if (arrayList == null) {
                }
            }
        }
        com.secret.prettyhezi.View.j jVar5 = this.D;
        if (jVar5 != null) {
            ArrayList<com.secret.prettyhezi.Server.n> selectedItems7 = jVar5.getSelectedItems();
            this.K = selectedItems7;
            if (selectedItems7 != null) {
                this.I = this.D;
                i6 = 5;
                this.J = i6;
            }
        }
        arrayList = this.K;
        if (arrayList == null) {
        }
    }

    void a1(int i6) {
        this.O.setVisibility(0);
        this.O.setText(i6 == 0 ? "删除" : "迁移");
        this.N.setText(s0(C0382R.string.cancel));
        this.L = i6;
        this.f6991w.h(true);
    }

    void b1() {
        com.secret.prettyhezi.controls.w wVar = new com.secret.prettyhezi.controls.w(this);
        wVar.setOrientation(1);
        wVar.setPadding(g4.i.r(10.0f), g4.i.r(20.0f), g4.i.r(10.0f), g4.i.r(20.0f));
        String[] strArr = {"批量删除", "批量迁移到其他盒子", "修改封面", s0(C0382R.string.cancel)};
        for (int i6 = 0; i6 < 4; i6++) {
            TextView c6 = g4.d.c(this, 16, -16777216, strArr[i6], 17);
            c6.setBackground(g4.i.d(g4.i.c(Color.parseColor("#f0f0f0"), 5.0f, Color.parseColor("#888888"), 1.0f), g4.i.b(-7829368, 5.0f)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(46.0f));
            int r5 = g4.i.r(5.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            wVar.addView(c6, layoutParams);
            c6.setOnClickListener(new j(wVar, i6));
        }
        x(wVar, null, true);
    }

    void c1() {
        String str;
        if (this.L == 0) {
            str = "确定删除所选的所有资源？";
        } else {
            str = "确定移动所选的所有资源到" + this.H.na + "？";
        }
        B(str, new h(), true);
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    public String n() {
        String str = " boxId" + this.f6987s;
        if (this.f6991w != null) {
            return str + " tabIndex:" + this.f6991w.e() + "       ";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6989u = A0(3, 4);
        Y0(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.View.j jVar = this.D;
        if (jVar != null) {
            jVar.b();
        }
        com.secret.prettyhezi.View.j jVar2 = this.B;
        if (jVar2 != null) {
            jVar2.b();
        }
        com.secret.prettyhezi.View.k kVar = this.C;
        if (kVar != null) {
            kVar.b();
        }
        if (this.f6993y != null) {
            int i6 = 0;
            while (true) {
                com.secret.prettyhezi.View.j[] jVarArr = this.f6993y;
                if (i6 >= jVarArr.length) {
                    break;
                }
                com.secret.prettyhezi.View.j jVar3 = jVarArr[i6];
                if (jVar3 != null) {
                    jVar3.b();
                }
                i6++;
            }
        }
        com.secret.prettyhezi.View.k kVar2 = this.f6994z;
        if (kVar2 != null) {
            kVar2.b();
        }
        com.secret.prettyhezi.View.j jVar4 = this.A;
        if (jVar4 != null) {
            jVar4.b();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f6989u.removeAllViews();
        Y0(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        com.secret.prettyhezi.controls.l lVar = this.f6991w;
        if (lVar != null) {
            lVar.postDelayed(new k(), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        com.secret.prettyhezi.controls.l lVar = this.f6991w;
        if (lVar != null) {
            lVar.u();
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (this.f6991w == null || System.currentTimeMillis() - this.f6991w.A >= 500) {
            super.startActivity(intent);
        }
    }
}
