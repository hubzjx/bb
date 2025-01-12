package com.secret.prettyhezi.Game;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class NPHwyx5X extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6295r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6296s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6297t;

    /* renamed from: u  reason: collision with root package name */
    f f6298u;

    /* renamed from: v  reason: collision with root package name */
    int f6299v;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            NPHwyx5X.this.f6296s.scrollTo(0, 0);
        }
    }

    public void S0(int i6) {
        f fVar = this.f6298u;
        if (fVar != null) {
            fVar.D(i6);
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
        if (this.f6299v == i6) {
            return;
        }
        this.f6299v = i6;
        S0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f6295r = B0;
        RelativeLayout M = M(B0, "赢家榜");
        this.f6297t = M;
        M.setOnClickListener(new a());
        x0.a aVar = new x0.a(this);
        this.f6296s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6295r.addView(this.f6296s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        f fVar = new f(this);
        this.f6298u = fVar;
        this.f6296s.addView(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f fVar = this.f6298u;
        if (fVar != null) {
            fVar.b();
        }
    }
}
