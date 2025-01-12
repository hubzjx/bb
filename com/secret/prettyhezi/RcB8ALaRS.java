package com.secret.prettyhezi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.View.c0;
import com.secret.prettyhezi.b;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import java.util.HashSet;
/* loaded from: classes.dex */
public class RcB8ALaRS extends WVGAB1kU {
    static HashSet T = new HashSet();
    com.secret.prettyhezi.a N;
    RelativeLayout O;
    com.secret.prettyhezi.View.c P;
    c0 Q;
    TextView R;
    boolean S = false;

    /* loaded from: classes.dex */
    class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {

            /* renamed from: p  reason: collision with root package name */
            public String f6869p;
            public boolean st;
        }
    }

    public static void y1(ZZcINlcxH zZcINlcxH) {
        for (int size = ZZcINlcxH.f8162n.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) ZZcINlcxH.f8162n.get(size);
            if (activity != zZcINlcxH && (activity instanceof RcB8ALaRS)) {
                ((RcB8ALaRS) activity).P.f();
            }
        }
    }

    void A1() {
        super.v1(this.N);
        this.Q.a(this.N.uc);
        this.R.setText(g4.i.G(this.N.dur));
        this.P.b(this.N.f8204p, this.S);
        B1();
    }

    void B1() {
        if (this.S) {
            t1();
        } else {
            l1();
        }
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void X0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.O = relativeLayout;
        relativeLayout.setBackgroundColor(-16777216);
        this.f8115w.addView(this.O, new LinearLayout.LayoutParams(-1, g4.i.r(200.0f)));
        this.Q = new c0(this, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10, -1);
        this.O.addView(this.Q, layoutParams);
        TextView c6 = g4.d.c(this, 12, -1, "0", 16);
        this.R = c6;
        c6.setBackgroundColor(Color.parseColor("#55000000"));
        this.R.setPadding(g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(21, -1);
        layoutParams2.addRule(10, -1);
        this.O.addView(this.R, layoutParams2);
        com.secret.prettyhezi.View.c cVar = new com.secret.prettyhezi.View.c(this, this.f8111s);
        this.P = cVar;
        this.O.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void h1(String str) {
        com.secret.prettyhezi.b bVar = (com.secret.prettyhezi.b) f.d(str, com.secret.prettyhezi.b.class);
        if (bVar.code != 200) {
            w0(bVar);
            return;
        }
        b.a aVar = bVar.data;
        this.N = aVar.vv;
        this.S = !aVar.st;
        A1();
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void k1(String str) {
        b bVar = (b) f.d(str, b.class);
        if (bVar.code != 200) {
            s.d(this, bVar.err);
        } else if (bVar.data.st) {
            x1();
            this.N.f8204p = bVar.data.f6869p;
            this.S = false;
            A1();
            this.P.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (T == null) {
            T = new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.P.h();
    }

    public void z1() {
        if (T.contains(new Integer(this.f8111s))) {
            return;
        }
        j.o(com.secret.prettyhezi.Server.v.f7132a + "audio/try/json?id=" + this.f8111s, true, new a(this));
        T.add(new Integer(this.f8111s));
    }
}
