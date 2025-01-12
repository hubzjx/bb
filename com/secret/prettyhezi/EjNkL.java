package com.secret.prettyhezi;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.OAnkX;
import com.secret.prettyhezi.Device.WIKdIA;
import com.secret.prettyhezi.Upload.l;
import com.secret.prettyhezi.User.If7AjsI;
import com.secret.prettyhezi.View.a0;
import com.secret.prettyhezi.View.b0;
import com.secret.prettyhezi.View.z;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.d0;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.message.HYYYBI;
import java.text.SimpleDateFormat;
import java.util.Date;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class EjNkL extends ZZcINlcxH implements x0.b {
    public static EjNkL N;
    LinearLayout A;
    z B;
    b0 C;
    com.secret.prettyhezi.Upload.l D;
    int E;
    int F;
    int G;
    x0.a H;

    /* renamed from: q  reason: collision with root package name */
    int f6164q;

    /* renamed from: r  reason: collision with root package name */
    public com.secret.prettyhezi.q f6165r;

    /* renamed from: s  reason: collision with root package name */
    TextView f6166s;

    /* renamed from: u  reason: collision with root package name */
    RelativeLayout f6168u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6169v;

    /* renamed from: w  reason: collision with root package name */
    TextView f6170w;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.controls.u f6171x;

    /* renamed from: y  reason: collision with root package name */
    com.secret.prettyhezi.controls.u f6172y;

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f6173z;

    /* renamed from: t  reason: collision with root package name */
    com.secret.prettyhezi.View.q f6167t = null;
    LinearLayout I = null;
    int J = 0;
    boolean K = true;
    ValueAnimator L = null;
    long M = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements z.a {
        a() {
        }

        @Override // com.secret.prettyhezi.View.z.a
        public void a() {
            EjNkL.this.H.scrollTo(0, 0);
        }

        @Override // com.secret.prettyhezi.View.z.a
        public void b(int i6, boolean z5) {
            EjNkL.this.X0();
            EjNkL.this.e1(i6, z5);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f6175a;

        b(View view) {
            this.f6175a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g4.i.j() != EjNkL.this) {
                ((com.secret.prettyhezi.View.t) this.f6175a).B();
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends ZZcINlcxH.q {
        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            try {
                com.secret.prettyhezi.Cache.c p5 = com.secret.prettyhezi.Cache.c.p();
                if (p5 != null) {
                    p5.u();
                }
                g4.b.b();
            } catch (Exception unused) {
            }
            EjNkL.this.finish();
            com.secret.prettyhezi.i.f8489j.c();
            System.exit(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EjNkL.this.Z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6179a;

        e(int i6) {
            this.f6179a = i6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) EjNkL.this.f6168u.getLayoutParams();
            marginLayoutParams.topMargin = intValue - this.f6179a;
            EjNkL.this.f6168u.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends d0 {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            EjNkL.this.L = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f6182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Server.q f6183b;

        g(com.secret.prettyhezi.controls.x xVar, com.secret.prettyhezi.Server.q qVar) {
            this.f6182a = xVar;
            this.f6183b = qVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (EjNkL.this.j(this.f6182a) && i6 == 1) {
                EjNkL.this.N0(VpEEnM.class, this.f6183b.id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EjNkL.this.isFinishing() || EjNkL.this.isDestroyed()) {
                return;
            }
            MainApplication.f6711r.g(false);
            EjNkL.this.a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {
        i() {
        }

        @Override // g4.f
        public void a(View view) {
            EjNkL.this.H.scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {
        j() {
        }

        @Override // g4.f
        public void a(View view) {
            EjNkL.this.f6165r.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends g4.f {
        k() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.View.t tVar;
            boolean z5 = false;
            View childAt = EjNkL.this.H.getChildAt(0);
            if (EjNkL.this.f6170w.getText().toString().equals(EjNkL.this.s0(C0382R.string.edit))) {
                EjNkL ejNkL = EjNkL.this;
                ejNkL.f6170w.setText(ejNkL.s0(C0382R.string.cancel));
                if (!(childAt instanceof com.secret.prettyhezi.View.t)) {
                    return;
                }
                tVar = (com.secret.prettyhezi.View.t) childAt;
                z5 = true;
            } else {
                EjNkL ejNkL2 = EjNkL.this;
                ejNkL2.f6170w.setText(ejNkL2.s0(C0382R.string.edit));
                if (!(childAt instanceof com.secret.prettyhezi.View.t)) {
                    return;
                }
                tVar = (com.secret.prettyhezi.View.t) childAt;
            }
            tVar.J(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends g4.f {
        l() {
        }

        @Override // g4.f
        public void a(View view) {
            EjNkL ejNkL = EjNkL.this;
            ejNkL.O0(BCIpAmH.class, 0, ejNkL.f6164q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends g4.f {
        m() {
        }

        @Override // g4.f
        public void a(View view) {
            EjNkL.this.M0(MuZhM.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends g4.f {
        n() {
        }

        @Override // g4.f
        public void a(View view) {
            EjNkL.this.H.scrollTo(0, 0);
            View R0 = EjNkL.this.R0();
            if (R0 instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) R0).C();
                EjNkL.this.f6166s.setVisibility(4);
            }
        }
    }

    /* loaded from: classes.dex */
    class o implements l.d {
        o() {
        }

        @Override // com.secret.prettyhezi.Upload.l.d
        public void a(int i6, int i7) {
            EjNkL.this.C.a(i6, i7);
        }

        @Override // com.secret.prettyhezi.Upload.l.d
        public void b(int i6) {
            EjNkL ejNkL = EjNkL.this;
            ejNkL.E = i6;
            ejNkL.X0();
            EjNkL ejNkL2 = EjNkL.this;
            ejNkL2.i1(ejNkL2.F, ejNkL2.G);
        }
    }

    /* loaded from: classes.dex */
    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EjNkL.this.M0(WIKdIA.class);
        }
    }

    /* loaded from: classes.dex */
    class q implements b0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6194a;

        q(int i6) {
            this.f6194a = i6;
        }

        @Override // com.secret.prettyhezi.View.b0.b
        public void a() {
            EjNkL.this.H.scrollTo(0, 0);
        }

        @Override // com.secret.prettyhezi.View.b0.b
        public void b(int i6, int i7) {
            EjNkL.this.X0();
            if (i6 == 100) {
                EjNkL.this.D.setVisibility(8);
            } else {
                EjNkL.this.D.setVisibility(0);
                EjNkL ejNkL = EjNkL.this;
                ejNkL.D.a(this.f6194a, i6 == 3, ejNkL.E);
            }
            EjNkL.this.i1(i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends a0 {

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ EjNkL f6197d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f6198e;

            a(EjNkL ejNkL, int i6) {
                this.f6197d = ejNkL;
                this.f6198e = i6;
            }

            @Override // g4.f
            public void a(View view) {
                r rVar = r.this;
                boolean z5 = rVar.f7848f;
                EjNkL ejNkL = EjNkL.this;
                if (z5) {
                    ejNkL.H.scrollTo(0, 0);
                    return;
                }
                ejNkL.f6164q = this.f6198e;
                ejNkL.X0();
                ((r) EjNkL.this.I.getChildAt(0)).b(EjNkL.this.f6164q == 104);
                ((r) EjNkL.this.I.getChildAt(1)).b(EjNkL.this.f6164q == 103);
                EjNkL ejNkL2 = EjNkL.this;
                ejNkL2.f6170w.setVisibility(ejNkL2.f6164q != 103 ? 8 : 0);
                EjNkL.this.b1();
            }
        }

        public r(String str, int i6) {
            super(EjNkL.this, str);
            setOnClickListener(new a(EjNkL.this, i6));
        }
    }

    public View R0() {
        if (this.H.getChildCount() > 0) {
            return this.H.getChildAt(0);
        }
        return null;
    }

    void S0(LinearLayout linearLayout) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f6168u = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        linearLayout.addView(this.f6168u, new LinearLayout.LayoutParams(-1, g4.i.r(52.0f)));
        this.f6168u.setOnClickListener(new i());
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this, C0382R.drawable.home_menu);
        zVar.setId(1000);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ZZcINlcxH.i0(48.0f), ZZcINlcxH.i0(48.0f));
        layoutParams.leftMargin = g4.i.r(4.0f);
        this.f6168u.addView(zVar, layoutParams);
        zVar.setOnClickListener(new j());
        this.f6169v = g4.d.b(this, 16.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        this.f6168u.addView(this.f6169v, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11, -1);
        this.f6168u.addView(linearLayout2, layoutParams3);
        TextView b6 = g4.d.b(this, 14.0f, -16777216, s0(C0382R.string.edit));
        this.f6170w = b6;
        b6.setGravity(17);
        this.f6170w.setBackground(g4.i.d(g4.i.b(-1, 12.0f), g4.i.b(-65536, 12.0f)));
        this.f6170w.setOnClickListener(new k());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(52.0f), g4.i.r(36.0f));
        layoutParams4.rightMargin = g4.i.r(12.0f);
        linearLayout2.addView(this.f6170w, layoutParams4);
        com.secret.prettyhezi.controls.z zVar2 = new com.secret.prettyhezi.controls.z(this, C0382R.drawable.ic_search);
        this.f6173z = zVar2;
        this.f6172y = com.secret.prettyhezi.controls.u.a(zVar2, 24, 24);
        linearLayout2.addView(this.f6172y, new LinearLayout.LayoutParams(g4.i.r(48.0f), -1));
        this.f6172y.setBackground(g4.i.i(0, Color.parseColor("#999999"), Color.parseColor("#aaaaaa")));
        this.f6172y.setOnClickListener(new l());
        com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(new com.secret.prettyhezi.controls.z(this, C0382R.drawable.btn_add), 24, 24);
        this.f6171x = a6;
        a6.setBackground(g4.i.f(0, Color.parseColor("#e2e2e2")));
        this.f6171x.setOnClickListener(new m());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(g4.i.r(48.0f), -1);
        layoutParams5.leftMargin = g4.i.r(2.0f);
        linearLayout2.addView(this.f6171x, layoutParams5);
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.A = linearLayout3;
        linearLayout3.setOrientation(0);
        this.A.setGravity(16);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(11, -1);
        layoutParams6.leftMargin = g4.i.r(52.0f);
        layoutParams6.rightMargin = g4.i.r(48.0f);
        this.f6168u.addView(this.A, layoutParams6);
    }

    void T0(RelativeLayout relativeLayout) {
        this.f6167t = new com.secret.prettyhezi.View.q(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(60.0f), -1);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(this.f6167t, layoutParams);
        this.f6167t.setVisibility(4);
    }

    void U0(com.secret.prettyhezi.View.t tVar) {
        int i6 = this.f6164q;
        if (i6 == 101 || i6 == 103 || i6 == 104) {
            this.f6167t.setVisibility(8);
            this.f6166s.setVisibility(8);
        } else {
            this.f6167t.setVisibility(4);
            this.f6166s.setVisibility(4);
            tVar.e(this.f6167t, this.f6166s);
        }
        this.H.addView(tVar, new ViewGroup.LayoutParams(-1, -2));
    }

    void V0(RelativeLayout relativeLayout) {
        this.f6166s = com.secret.prettyhezi.View.q.e(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.addRule(12, -1);
        layoutParams.rightMargin = g4.i.r(60.0f);
        relativeLayout.addView(this.f6166s, layoutParams);
        this.f6166s.setOnClickListener(new n());
    }

    void W0(boolean z5) {
        this.K = z5;
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i6 = this.f6164q;
        if (i6 >= 1 && i6 <= 100) {
            if (this.f6166s.getVisibility() != 8) {
                this.f6166s.setVisibility(z5 ? 0 : 4);
            }
            if (this.f6167t.getVisibility() != 8) {
                this.f6167t.setVisibility(z5 ? 0 : 4);
            }
            this.M = System.currentTimeMillis();
            this.f6168u.postDelayed(new d(), 3000L);
        }
        int height = this.f6168u.getHeight();
        int i7 = ((LinearLayout.LayoutParams) this.f6168u.getLayoutParams()).topMargin + height;
        ValueAnimator ofInt = z5 ? ValueAnimator.ofInt(i7, height) : ValueAnimator.ofInt(i7, 0);
        this.L = ofInt;
        ofInt.setDuration(300L);
        this.L.setInterpolator(new DecelerateInterpolator());
        this.L.addUpdateListener(new e(height));
        this.L.addListener(new f());
        this.L.start();
    }

    void X0() {
        View R0 = R0();
        if (R0 != null && (R0 instanceof com.secret.prettyhezi.View.t)) {
            ((com.secret.prettyhezi.View.t) R0).b();
        }
        if (!this.K) {
            this.f6168u.setVisibility(0);
            W0(true);
        }
        this.H.removeAllViews();
    }

    void Y0() {
        String h6 = g4.g.a().h("keyLastPopupNoticeDate", HttpUrl.FRAGMENT_ENCODE_SET);
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + MainApplication.f6711r.t();
        com.secret.prettyhezi.Server.q GetPopItem = com.secret.prettyhezi.Server.r.GetPopItem();
        if (h6.equals(str) || GetPopItem == null) {
            if (MainApplication.f6711r.r() == null || g4.g.a().h("keyLastPopupNoticeDateALL", HttpUrl.FRAGMENT_ENCODE_SET).equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))) {
                return;
            }
            M0(HYYYBI.class);
            return;
        }
        g4.g.a().o("keyLastPopupNoticeDate", str);
        if (GetPopItem.content.length() < 400) {
            E(GetPopItem.name, GetPopItem.content, null, true).f8479f.setGravity(3);
            return;
        }
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        xVar.i(GetPopItem.name, GetPopItem.content.substring(0, 400));
        xVar.f8479f.setGravity(3);
        xVar.d(new String[]{s0(C0382R.string.cancel), "详情"}, new g(xVar, GetPopItem));
        x(xVar, null, false);
    }

    void Z0() {
        if (System.currentTimeMillis() - this.M > 2900) {
            if (this.f6166s.getVisibility() != 8) {
                this.f6166s.setVisibility(4);
            }
            if (this.f6167t.getVisibility() != 8) {
                this.f6167t.setVisibility(4);
            }
        }
    }

    @Override // x0.b
    public void a(x0.c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.H.getScrollY() == 0) {
            cVar = x0.c.DOWN;
        }
        if (cVar != x0.c.DOWN) {
            if (this.K) {
                W0(false);
            }
        } else if (this.K) {
        } else {
            this.f6168u.setVisibility(0);
            W0(true);
        }
    }

    void a1() {
        this.f6168u.postDelayed(new h(), 300000L);
    }

    @Override // x0.b
    public void b() {
    }

    void b1() {
        com.secret.prettyhezi.View.t fVar;
        int i6;
        int i7 = this.f6164q;
        if (i7 == 103) {
            fVar = new com.secret.prettyhezi.View.f(this, androidx.constraintlayout.widget.g.V0, 0);
            fVar.A = s0(C0382R.string.Unfollow);
            i6 = C0382R.string.NoFollowingBoxHint;
        } else if (i7 != 104) {
            return;
        } else {
            fVar = new com.secret.prettyhezi.View.v(this);
            i6 = C0382R.string.DefaultNoDataHint;
        }
        fVar.f(s0(i6));
        U0(fVar);
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.J == i6) {
            return;
        }
        this.J = i6;
        if (this.H.getChildCount() > 0) {
            View childAt = this.H.getChildAt(0);
            if (childAt instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) childAt).D(i6);
            }
        }
    }

    void c1() {
        if (this.I == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            this.I = linearLayout;
            linearLayout.setOrientation(0);
            this.I.setGravity(1);
            r rVar = new r(s0(C0382R.string.Default), androidx.constraintlayout.widget.g.W0);
            r rVar2 = new r(s0(C0382R.string.Box), androidx.constraintlayout.widget.g.V0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), -1);
            this.I.addView(rVar, layoutParams);
            this.I.addView(rVar2, layoutParams);
        }
        if (this.I.getParent() == null) {
            this.A.addView(this.I, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d1(int i6) {
        this.f6164q = i6;
        X0();
        this.D.setVisibility(8);
        this.f6169v.setVisibility(8);
        this.f6172y.setVisibility(8);
        this.f6171x.setVisibility(8);
        this.f6170w.setVisibility(i6 == 103 ? 0 : 8);
        this.f6170w.setText(s0(C0382R.string.edit));
        this.A.setVisibility(0);
        this.A.removeAllViews();
        c1();
        ((r) this.I.getChildAt(0)).b(i6 == 104);
        ((r) this.I.getChildAt(1)).b(i6 == 103);
        b1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void e1(int i6, boolean z5) {
        View R0;
        com.secret.prettyhezi.View.f fVar;
        int i7 = this.f6164q;
        if (i7 != 1 && i7 != 2) {
            if (i7 == 3) {
                com.secret.prettyhezi.View.k kVar = new com.secret.prettyhezi.View.k(this, 3);
                kVar.O(i6);
                fVar = kVar;
            } else if (i7 != 4) {
                if (i7 == 100) {
                    fVar = new com.secret.prettyhezi.View.f(this, this.f6164q, i6);
                }
                if (i6 == 0 || !z5 || (R0 = R0()) == null || !(R0 instanceof com.secret.prettyhezi.View.t)) {
                    return;
                }
                ((com.secret.prettyhezi.View.t) R0).c();
                return;
            }
            U0(fVar);
            if (i6 == 0) {
                return;
            }
            return;
        }
        com.secret.prettyhezi.View.j jVar = new com.secret.prettyhezi.View.j(this, this.f6164q);
        jVar.O(i6);
        fVar = jVar;
        U0(fVar);
        if (i6 == 0) {
        }
    }

    public void f1(int i6, int i7, boolean z5) {
        h1();
        this.D.setVisibility(8);
        this.f6164q = i6;
        z zVar = new z(this, i6);
        this.B = zVar;
        zVar.b(i7, z5);
        this.B.setListener(new a());
        this.A.addView(this.B, new LinearLayout.LayoutParams(-1, -1));
        e1(this.B.d(i7), z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g1() {
        this.f6164q = androidx.constraintlayout.widget.g.T0;
        X0();
        this.D.setVisibility(8);
        this.f6172y.setVisibility(8);
        this.f6171x.setVisibility(0);
        this.f6170w.setVisibility(0);
        this.f6170w.setText(s0(C0382R.string.edit));
        this.A.setVisibility(8);
        this.f6169v.setVisibility(0);
        this.f6169v.setText(C0382R.string.my_boxes);
        com.secret.prettyhezi.View.f fVar = new com.secret.prettyhezi.View.f(this, this.f6164q, 0);
        fVar.f8032z = true;
        U0(fVar);
    }

    void h1() {
        X0();
        this.f6169v.setVisibility(8);
        this.f6172y.setVisibility(0);
        this.f6171x.setVisibility(8);
        this.f6170w.setVisibility(8);
        this.A.setVisibility(0);
        this.A.removeAllViews();
        this.B = null;
        this.C = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void i1(int i6, int i7) {
        com.secret.prettyhezi.View.j jVar;
        this.F = i6;
        this.G = i7;
        int i8 = this.f6164q;
        if (i8 == 5 || i8 == 6) {
            com.secret.prettyhezi.View.j jVar2 = new com.secret.prettyhezi.View.j(this, this.f6164q);
            jVar2.S(i6, i7, this.E);
            jVar = jVar2;
        } else if (i8 != 7) {
            return;
        } else {
            com.secret.prettyhezi.View.k kVar = new com.secret.prettyhezi.View.k(this, 7);
            kVar.S(i6, i7, this.E);
            jVar = kVar;
        }
        U0(jVar);
    }

    public void j1(int i6, int i7) {
        this.E = i7;
        if (i6 != this.f6164q || this.F == 100) {
            this.f6164q = i6;
            h1();
            this.D.setVisibility(0);
            this.G = 0;
            this.F = 2;
            b0 b0Var = new b0(this, i6);
            this.C = b0Var;
            b0Var.setListener(new q(i6));
            this.A.addView(this.C, new LinearLayout.LayoutParams(-1, -1));
        } else {
            X0();
        }
        this.D.a(i6, this.F == 3, this.E);
        i1(this.F, this.G);
    }

    public void k1(long j6) {
        z zVar = this.B;
        if (zVar != null) {
            zVar.a(j6 + HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N = this;
        MainApplication.f6711r.K(this);
        RelativeLayout D0 = D0(3, 4);
        this.f6165r = new com.secret.prettyhezi.q(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        D0.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        V0(D0);
        S0(linearLayout);
        com.secret.prettyhezi.Upload.l lVar = new com.secret.prettyhezi.Upload.l(this, new o());
        this.D = lVar;
        linearLayout.addView(lVar, new LinearLayout.LayoutParams(-1, g4.i.r(46.0f)));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        x0.a aVar = new x0.a(this);
        this.H = aVar;
        aVar.setScrollViewCallbacks(this);
        relativeLayout.addView(this.H, new RelativeLayout.LayoutParams(-1, -1));
        T0(relativeLayout);
        if (MainApplication.f6711r.r() != null) {
            d1(androidx.constraintlayout.widget.g.W0);
        } else {
            f1(100, 2, true);
        }
        System.setProperty("http.keepAlive", "false");
        Y0();
        a1();
        if (!OAnkX.f6116y) {
            If7AjsI.S0(this);
            return;
        }
        OAnkX.f6116y = false;
        linearLayout.postDelayed(new p(), 500L);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4 && keyEvent.getAction() == 0) {
            if (this.f6165r.b()) {
                this.f6165r.a();
                return true;
            }
            B(s0(C0382R.string.ExitConfirm), new c(), true);
        }
        return super.onKeyDown(i6, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        View R0 = R0();
        if (R0 == null || !(R0 instanceof com.secret.prettyhezi.View.t)) {
            return;
        }
        R0.postDelayed(new b(R0), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        View R0 = R0();
        if (R0 != null) {
            boolean z5 = R0 instanceof com.secret.prettyhezi.View.t;
        }
        com.secret.prettyhezi.User.Ticket.a.a();
        com.secret.prettyhezi.message.c.c();
    }
}
