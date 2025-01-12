package com.secret.prettyhezi.Game;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class CAr0jaumF extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6242r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6243s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6244t;

    /* renamed from: u  reason: collision with root package name */
    k0 f6245u;

    /* renamed from: v  reason: collision with root package name */
    boolean f6246v = false;

    /* renamed from: w  reason: collision with root package name */
    int f6247w;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            CAr0jaumF.this.f6243s.scrollTo(0, 0);
        }
    }

    public void S0(int i6) {
        k0 k0Var = this.f6245u;
        if (k0Var != null) {
            k0Var.D(i6);
        }
    }

    @Override // x0.b
    public void a(x0.c cVar) {
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.f6247w == i6) {
            return;
        }
        this.f6247w = i6;
        S0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6246v = extras.getInt("id") == 1;
        } else {
            this.f6246v = false;
        }
        LinearLayout B0 = B0(3, 4);
        this.f6242r = B0;
        RelativeLayout M = M(B0, this.f6246v ? "玩币记录" : "金币记录");
        this.f6244t = M;
        M.setOnClickListener(new a());
        x0.a aVar = new x0.a(this);
        this.f6243s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6242r.addView(this.f6243s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        k0 k0Var = new k0(this, this.f6246v);
        this.f6245u = k0Var;
        this.f6243s.addView(k0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k0 k0Var = this.f6245u;
        if (k0Var != null) {
            k0Var.b();
        }
    }
}
