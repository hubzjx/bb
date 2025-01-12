package com.secret.prettyhezi;

import android.os.Bundle;
import android.view.View;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.Upload.AW1jL;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import java.util.HashSet;
/* loaded from: classes.dex */
public class DHwJuV extends LQS1CVD {
    static HashSet Q = new HashSet();
    boolean P = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            DHwJuV.this.K1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ZZcINlcxH.q {
        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            DHwJuV.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            if (!DHwJuV.this.D1()) {
                DHwJuV dHwJuV = DHwJuV.this;
                dHwJuV.F("兑换了年或永久热门视频权限即可获取下载权限", null, dHwJuV.s0(C0382R.string.IKnow), null, true);
                return;
            }
            String A1 = DHwJuV.this.A1();
            if (A1 != null) {
                DHwJuV.this.Y0(A1);
            }
            com.secret.prettyhezi.Cache.c l6 = MainApplication.f6711r.l();
            DHwJuV dHwJuV2 = DHwJuV.this;
            l6.b(dHwJuV2.f8110r, dHwJuV2.N);
            DHwJuV dHwJuV3 = DHwJuV.this;
            dHwJuV3.Y0(dHwJuV3.s0(C0382R.string.downloading));
        }
    }

    /* loaded from: classes.dex */
    public static class e extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {

            /* renamed from: me  reason: collision with root package name */
            public e0 f6089me;
            public boolean st;
        }
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public boolean C1() {
        return true;
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public boolean D1() {
        a0 r5 = MainApplication.f6711r.r();
        return r5.f7103p2 || r5.py2 > 0;
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    boolean E1() {
        if (this.P) {
            if (this.N.f7126p2) {
                return MainApplication.f6711r.r().permission.f7108p2;
            }
            return false;
        }
        return true;
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public void G1() {
        e0 e0Var = this.N.f7110me;
        if (e0Var != null) {
            F1(e0Var);
        } else {
            K1();
        }
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public void H1() {
        String A1;
        if (!E1()) {
            Y0("试看").setOnClickListener(new b());
        } else if (this.N.f7110me == null) {
            if (this.P) {
                o1();
            } else {
                D("该内容不存在", new c(), false);
            }
        } else if (!z1() || (A1 = A1()) == null) {
            J1();
        } else {
            Y0(A1);
        }
    }

    void J1() {
        Y0(s0(C0382R.string.Download)).setOnClickListener(new d());
    }

    void K1() {
        if (!Q.contains(new Integer(this.f8111s))) {
            j.o(com.secret.prettyhezi.Server.v.f7132a + "rrvideo/play/json?id=" + this.f8111s, true, new a(this));
            Q.add(new Integer(this.f8111s));
        }
        AW1jL.R0(this, this.f8111s, this.N.ps, d1());
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    String e1() {
        return "观看本内容";
    }

    @Override // com.secret.prettyhezi.LQS1CVD, com.secret.prettyhezi.WVGAB1kU
    protected void h1(String str) {
        v vVar = (v) f.d(str, v.class);
        if (vVar.code != 200) {
            w0(vVar);
            return;
        }
        this.N = vVar.detail();
        this.P = !vVar.data.st;
        I1();
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void k1(String str) {
        e eVar = (e) f.d(str, e.class);
        if (eVar.code != 200) {
            s.d(this, eVar.err);
        } else if (eVar.data.st) {
            x1();
            this.N.f7110me = eVar.data.f6089me;
            this.P = false;
            H1();
            G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Q == null) {
            Q = new HashSet();
        }
    }
}
