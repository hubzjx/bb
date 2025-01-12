package com.secret.prettyhezi;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.View.a0;
import com.secret.prettyhezi.controls.d0;
/* loaded from: classes.dex */
public class McNiD extends UoWMF implements x0.b {
    static final String[] J = {"匹配度", "最新", "收藏量", "关注量"};
    static final String[] K = {"匹配度", "最新", "收藏量", "解锁量"};
    static final String[] L = {"匹配度", "最新", "收藏量"};
    TextView A;
    com.secret.prettyhezi.View.q B;
    int E;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6742r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6743s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6744t;

    /* renamed from: u  reason: collision with root package name */
    RelativeLayout f6745u;

    /* renamed from: v  reason: collision with root package name */
    String f6746v;

    /* renamed from: w  reason: collision with root package name */
    String f6747w;

    /* renamed from: x  reason: collision with root package name */
    String f6748x;

    /* renamed from: y  reason: collision with root package name */
    int f6749y;

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.View.t f6750z;
    LinearLayout C = null;
    a0[] D = null;
    boolean F = true;
    ValueAnimator G = null;
    boolean H = false;
    long I = 0;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            McNiD.this.f6743s.scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f6752d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f6753e;

        b(a0 a0Var, int i6) {
            this.f6752d = a0Var;
            this.f6753e = i6;
        }

        @Override // g4.f
        public void a(View view) {
            if (this.f6752d.f7848f) {
                McNiD.this.f6743s.scrollTo(0, 0);
            } else {
                McNiD.this.b1(this.f6753e);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH j6 = g4.i.j();
            McNiD mcNiD = McNiD.this;
            if (j6 != mcNiD) {
                mcNiD.f6750z.B();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6756a;

        d(int i6) {
            this.f6756a = i6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) McNiD.this.f6744t.getLayoutParams();
            marginLayoutParams.topMargin = intValue - this.f6756a;
            McNiD.this.f6744t.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends d0 {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            McNiD.this.G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            McNiD.this.f6743s.scrollTo(0, 0);
            McNiD.this.f6750z.C();
            McNiD.this.A.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            McNiD.this.Y0();
        }
    }

    public static void S0(Context context, String str, String str2, int i6) {
        Intent intent = new Intent(context, McNiD.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("page", str2);
        bundle.putInt("type", i6);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    void T0(int i6, String str) {
        a0 a0Var = new a0(this, str);
        this.D[i6 - 1] = a0Var;
        this.C.addView(a0Var, new LinearLayout.LayoutParams(0, -1, 1.0f));
        a0Var.setOnClickListener(new b(a0Var, i6));
        a0Var.b(false);
    }

    void U0() {
        String[] X0 = X0();
        if (X0 != null) {
            this.f6748x = this.f6747w;
            int i6 = 0;
            if (this.f6749y == 100) {
                StringBuilder sb = new StringBuilder();
                String str = this.f6748x;
                sb.append(str.substring(0, str.length() - 8));
                sb.append("desc=");
                sb.append(3);
                sb.append("&page=999");
                this.f6747w = sb.toString();
            }
            LinearLayout linearLayout = new LinearLayout(this);
            this.C = linearLayout;
            linearLayout.setBackgroundColor(Color.parseColor("#fcfcfc"));
            this.C.setOrientation(0);
            this.f6742r.addView(this.C, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
            this.D = new a0[X0.length];
            while (i6 < X0.length) {
                int i7 = i6 + 1;
                T0(i7, X0[i6] + "↓");
                i6 = i7;
            }
        }
    }

    public void V0(boolean z5) {
        this.F = z5;
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int height = this.f6744t.getHeight();
        int i6 = ((LinearLayout.LayoutParams) this.f6744t.getLayoutParams()).topMargin + height;
        ValueAnimator ofInt = z5 ? ValueAnimator.ofInt(i6, height) : ValueAnimator.ofInt(i6, 0);
        this.G = ofInt;
        ofInt.setDuration(300L);
        this.G.setInterpolator(new DecelerateInterpolator());
        this.G.addUpdateListener(new d(height));
        this.G.addListener(new e());
        this.G.start();
    }

    com.secret.prettyhezi.View.t W0(ZZcINlcxH zZcINlcxH) {
        int i6 = this.f6749y;
        if (i6 == 3) {
            return new com.secret.prettyhezi.View.k(zZcINlcxH, 3);
        }
        if (i6 == 7) {
            return new com.secret.prettyhezi.View.k(zZcINlcxH, 7);
        }
        if (i6 == 4) {
            return new com.secret.prettyhezi.View.j(zZcINlcxH, 4);
        }
        if (i6 == 100) {
            return new com.secret.prettyhezi.View.f(zZcINlcxH);
        }
        if (i6 == 5) {
            com.secret.prettyhezi.View.j jVar = new com.secret.prettyhezi.View.j(zZcINlcxH, 5);
            jVar.R = 2;
            return jVar;
        } else if (i6 == 2) {
            return new com.secret.prettyhezi.View.j(zZcINlcxH, 2);
        } else {
            if (i6 == 1) {
                return new com.secret.prettyhezi.View.j(zZcINlcxH, 1);
            }
            if (i6 == 6) {
                com.secret.prettyhezi.View.j jVar2 = new com.secret.prettyhezi.View.j(zZcINlcxH, this.f6749y);
                jVar2.R = 2;
                return jVar2;
            }
            return null;
        }
    }

    String[] X0() {
        int i6 = this.f6749y;
        if (i6 == 2 || i6 == 1 || i6 == 3 || i6 == 4) {
            return L;
        }
        if (i6 == 5 || i6 == 6 || i6 == 7) {
            return K;
        }
        if (i6 == 100) {
            return J;
        }
        return null;
    }

    void Y0() {
        if (System.currentTimeMillis() - this.I > 2900) {
            this.A.setVisibility(8);
            this.B.setVisibility(4);
        }
    }

    public void Z0(int i6) {
        com.secret.prettyhezi.View.t tVar = this.f6750z;
        if (tVar != null) {
            tVar.D(i6);
        }
    }

    @Override // x0.b
    public void a(x0.c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f6743s.getScrollY() == 0) {
            cVar = x0.c.DOWN;
        }
        boolean z5 = false;
        if (cVar == x0.c.DOWN) {
            if (!this.F) {
                this.f6744t.setVisibility(0);
                V0(true);
            }
            if (this.f6750z.f8009c > 5) {
                z5 = true;
            }
        } else if (this.F) {
            V0(false);
        }
        a1(z5);
    }

    void a1(boolean z5) {
        if (this.H == z5) {
            return;
        }
        this.H = z5;
        if (!z5) {
            TextView textView = this.A;
            if (textView != null) {
                textView.setVisibility(8);
                this.B.setVisibility(8);
                return;
            }
            return;
        }
        if (this.A == null) {
            this.A = com.secret.prettyhezi.View.q.e(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, g4.i.r(42.0f));
            layoutParams.addRule(12, -1);
            this.f6745u.addView(this.A, layoutParams);
            this.A.setOnClickListener(new f());
            this.B = new com.secret.prettyhezi.View.q(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(60.0f), -1);
            layoutParams2.addRule(11, -1);
            this.f6745u.addView(this.B, layoutParams2);
            this.f6750z.e(this.B, this.A);
        }
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.I = System.currentTimeMillis();
        this.f6745u.postDelayed(new g(), 3000L);
    }

    @Override // x0.b
    public void b() {
    }

    void b1(int i6) {
        int i7 = 0;
        while (true) {
            a0[] a0VarArr = this.D;
            if (i7 >= a0VarArr.length) {
                StringBuilder sb = new StringBuilder();
                String str = this.f6748x;
                sb.append(str.substring(0, str.length() - 8));
                sb.append("desc=");
                sb.append(i6);
                sb.append("&page=999");
                this.f6750z.g(sb.toString());
                this.f6750z.o(0);
                return;
            }
            a0VarArr[i7].b(i6 + (-1) == i7);
            i7++;
        }
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.E == i6) {
            return;
        }
        this.E = i6;
        Z0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6746v = extras.getString("title");
            this.f6747w = extras.getString("page");
            this.f6749y = extras.getInt("type");
        }
        LinearLayout B0 = B0(3, 4);
        this.f6742r = B0;
        RelativeLayout M = M(B0, this.f6746v);
        this.f6744t = M;
        M.setOnClickListener(new a());
        U0();
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f6745u = relativeLayout;
        this.f6742r.addView(relativeLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        x0.a aVar = new x0.a(this);
        this.f6743s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6745u.addView(this.f6743s, new RelativeLayout.LayoutParams(-1, -1));
        com.secret.prettyhezi.View.t W0 = W0(this);
        this.f6750z = W0;
        this.f6743s.addView(W0);
        b1(this.f6749y != 100 ? 1 : 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.View.t tVar = this.f6750z;
        if (tVar != null) {
            tVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        com.secret.prettyhezi.View.t tVar = this.f6750z;
        if (tVar != null) {
            tVar.postDelayed(new c(), 1000L);
        }
    }
}
