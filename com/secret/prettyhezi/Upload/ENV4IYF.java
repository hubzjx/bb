package com.secret.prettyhezi.Upload;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.n;
/* loaded from: classes.dex */
public class ENV4IYF extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    RelativeLayout f7295r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7296s;

    /* renamed from: t  reason: collision with root package name */
    public x0.a f7297t;

    /* renamed from: u  reason: collision with root package name */
    com.secret.prettyhezi.View.t f7298u = null;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.View.q f7299v = null;

    /* renamed from: w  reason: collision with root package name */
    int[] f7300w = {6, 7, 5};

    /* renamed from: x  reason: collision with root package name */
    int[] f7301x = {C0382R.string.Gallery, C0382R.string.Audios, C0382R.string.LongVideo};

    /* renamed from: y  reason: collision with root package name */
    long f7302y = 0;

    /* renamed from: z  reason: collision with root package name */
    int f7303z;

    /* loaded from: classes.dex */
    class a implements n.b {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            com.secret.prettyhezi.View.j jVar;
            ENV4IYF env4iyf = ENV4IYF.this;
            com.secret.prettyhezi.View.t tVar = env4iyf.f7298u;
            if (tVar != null) {
                env4iyf.f7297t.removeView(tVar);
                ENV4IYF.this.f7298u.b();
                ENV4IYF.this.f7298u = null;
            }
            if (i6 != 0 && i6 != 2) {
                if (i6 == 1) {
                    ENV4IYF env4iyf2 = ENV4IYF.this;
                    com.secret.prettyhezi.View.k kVar = new com.secret.prettyhezi.View.k(env4iyf2, env4iyf2.f7300w[i6]);
                    kVar.R();
                    jVar = kVar;
                }
                ENV4IYF env4iyf3 = ENV4IYF.this;
                env4iyf3.f7298u.e(env4iyf3.f7299v, null);
                ENV4IYF env4iyf4 = ENV4IYF.this;
                env4iyf4.f7297t.addView(env4iyf4.f7298u, new ViewGroup.LayoutParams(-1, -2));
            }
            ENV4IYF env4iyf5 = ENV4IYF.this;
            com.secret.prettyhezi.View.j jVar2 = new com.secret.prettyhezi.View.j(env4iyf5, env4iyf5.f7300w[i6]);
            jVar2.R();
            jVar = jVar2;
            ENV4IYF.this.f7298u = jVar;
            ENV4IYF env4iyf32 = ENV4IYF.this;
            env4iyf32.f7298u.e(env4iyf32.f7299v, null);
            ENV4IYF env4iyf42 = ENV4IYF.this;
            env4iyf42.f7297t.addView(env4iyf42.f7298u, new ViewGroup.LayoutParams(-1, -2));
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            x0.a aVar = ENV4IYF.this.f7297t;
            if (aVar != null) {
                aVar.scrollTo(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ENV4IYF.this.S0();
        }
    }

    void S0() {
        if (System.currentTimeMillis() - this.f7302y > 2900) {
            this.f7299v.setVisibility(8);
        }
    }

    void T0() {
        this.f7302y = System.currentTimeMillis();
        this.f7296s.postDelayed(new b(), 3000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // x0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(x0.c cVar) {
        boolean z5;
        if (this.f7297t.getScrollY() == 0) {
            cVar = x0.c.DOWN;
        }
        if (cVar == x0.c.DOWN) {
            View childAt = this.f7297t.getChildAt(0);
            if ((childAt instanceof com.secret.prettyhezi.View.t) && ((com.secret.prettyhezi.View.t) childAt).f8009c >= 5) {
                z5 = true;
                this.f7299v.setVisibility(z5 ? 0 : 8);
                if (z5) {
                    return;
                }
                T0();
                return;
            }
        }
        z5 = false;
        this.f7299v.setVisibility(z5 ? 0 : 8);
        if (z5) {
        }
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.f7303z == i6) {
            return;
        }
        this.f7303z = i6;
        com.secret.prettyhezi.View.t tVar = this.f7298u;
        if (tVar != null) {
            tVar.D(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7295r = D0(3, 4);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7296s = linearLayout;
        linearLayout.setOrientation(1);
        this.f7295r.addView(this.f7296s, new RelativeLayout.LayoutParams(-1, -1));
        M(this.f7296s, "已解锁");
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f7301x, new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(1.0f);
        this.f7296s.addView(nVar, layoutParams);
        x0.a aVar = new x0.a(this);
        this.f7297t = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f7296s.addView(this.f7297t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f7299v = new com.secret.prettyhezi.View.q(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(60.0f), -1);
        layoutParams2.addRule(11, -1);
        layoutParams2.topMargin = g4.i.r(52.0f);
        this.f7295r.addView(this.f7299v, layoutParams2);
        T0();
        nVar.setCurrentTab(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.View.t tVar = this.f7298u;
        if (tVar != null) {
            tVar.b();
        }
    }
}
