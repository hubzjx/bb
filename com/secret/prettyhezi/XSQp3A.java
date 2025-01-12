package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.t;
import com.secret.prettyhezi.View.c0;
import com.secret.prettyhezi.View.y;
import com.secret.prettyhezi.controls.z;
import java.io.Serializable;
import java.util.HashSet;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class XSQp3A extends WVGAB1kU {
    static HashSet S = new HashSet();
    com.secret.prettyhezi.Server.t N;
    RelativeLayout O;
    com.secret.prettyhezi.View.y Q;
    com.secret.prettyhezi.controls.a P = null;
    boolean R = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements y.d {
        a() {
        }

        @Override // com.secret.prettyhezi.View.y.d
        public void a(int i6, boolean z5) {
            if (z5) {
                XSQp3A.this.j1();
                return;
            }
            XSQp3A xSQp3A = XSQp3A.this;
            int i7 = xSQp3A.f8110r;
            int i8 = xSQp3A.f8111s;
            String[] images = xSQp3A.N.images();
            XSQp3A xSQp3A2 = XSQp3A.this;
            WOqyeiK.S0(xSQp3A, i7, i8, images, i6, xSQp3A2.R ? xSQp3A2.d1() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ z f8140d;

        b(z zVar) {
            this.f8140d = zVar;
        }

        @Override // g4.f
        protected void a(View view) {
            XSQp3A.this.Q.T();
            XSQp3A.this.O.setLayoutParams(new LinearLayout.LayoutParams(-1, XSQp3A.this.Q.getViewHeight()));
            this.f8140d.a(XSQp3A.this.Q.U ? C0382R.drawable.collapse_icn : C0382R.drawable.expand_icn);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public boolean st;
            public t.a[] ts;
        }
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void X0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.O = relativeLayout;
        this.f8115w.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    String e1() {
        return "查看全部" + this.N.am + "张";
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void h1(String str) {
        com.secret.prettyhezi.Server.t detail;
        if (this.f8110r == 1) {
            k kVar = (k) f.d(str, k.class);
            if (kVar.code != 200) {
                w0(kVar);
                return;
            }
            detail = kVar.data;
        } else {
            l lVar = (l) f.d(str, l.class);
            if (lVar.code != 200) {
                w0(lVar);
                return;
            } else {
                this.R = !lVar.data.st;
                detail = lVar.detail();
            }
        }
        this.N = detail;
        z1();
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void k1(String str) {
        c cVar = (c) f.d(str, c.class);
        if (cVar.code != 200) {
            s.d(this, cVar.err);
        } else if (cVar.data.st) {
            x1();
            this.N.ts = cVar.data.ts;
            this.R = false;
            z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (S == null) {
            S = new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.P != null) {
            this.O.removeAllViews();
            this.P.a();
            this.P = null;
        }
    }

    boolean y1() {
        t.a[] aVarArr = this.N.ts;
        String str = aVarArr.length > 0 ? aVarArr[0].f7131m : null;
        return (str == null || str.isEmpty()) ? false : true;
    }

    void z1() {
        super.v1(this.N);
        com.secret.prettyhezi.controls.a aVar = this.P;
        if (aVar != null) {
            aVar.a();
        }
        this.O.removeAllViews();
        if (this.f8110r != 1) {
            c0 c0Var = new c0(this, this.N.uc);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = g4.i.r(10.0f);
            layoutParams.leftMargin = g4.i.r(6.0f);
            c0Var.setScaleX(1.1f);
            c0Var.setScaleY(1.1f);
            this.O.addView(c0Var, layoutParams);
            if (this.R) {
                t1();
            } else {
                l1();
            }
        }
        t.a[] aVarArr = this.N.ts;
        if (aVarArr == null || aVarArr.length == 0) {
            q("数据不存在");
        } else if (!y1()) {
            this.O.setLayoutParams(new LinearLayout.LayoutParams(-1, b1()));
            com.secret.prettyhezi.controls.a aVar2 = new com.secret.prettyhezi.controls.a(this, this.f8110r, this.f8111s, this.N.images(), this.R ? d1() : null);
            this.P = aVar2;
            this.O.addView(aVar2, 0, new RelativeLayout.LayoutParams(-1, -1));
        } else {
            this.Q = new com.secret.prettyhezi.View.y(this, this.N.ts, this.f8114v.getHeight(), new a());
            this.O.setLayoutParams(new LinearLayout.LayoutParams(-1, this.Q.getViewHeight()));
            this.O.addView(this.Q, 0, new RelativeLayout.LayoutParams(-1, -1));
            TextView c6 = g4.d.c(this, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET + this.N.ts.length, 17);
            c6.setBackground(ZZcINlcxH.g0(Color.parseColor("#8c000000"), 12.5f, Color.parseColor("#8cffffff"), 0.5f));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(20.0f));
            layoutParams2.addRule(11, -1);
            layoutParams2.topMargin = g4.i.r(10.0f);
            layoutParams2.rightMargin = g4.i.r(6.0f);
            this.O.addView(c6, layoutParams2);
            if (this.Q.T) {
                z zVar = new z(this, C0382R.drawable.expand_icn);
                com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(zVar, 36, 36);
                a6.setBackground(g4.i.d(ZZcINlcxH.g0(Color.parseColor("#80ffffff"), 5.0f, -16777216, 1.0f), ZZcINlcxH.g0(Color.parseColor("#30ffffff"), 5.0f, -16777216, 1.0f)));
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
                layoutParams3.addRule(11, -1);
                layoutParams3.addRule(12, -1);
                layoutParams3.bottomMargin = g4.i.r(10.0f);
                layoutParams3.rightMargin = g4.i.r(6.0f);
                this.O.addView(a6, layoutParams3);
                a6.setOnClickListener(new b(zVar));
            }
        }
    }
}
