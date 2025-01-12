package com.secret.prettyhezi.Upload;

import android.os.Bundle;
import android.widget.LinearLayout;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.n;
/* loaded from: classes.dex */
public class KSglG extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7343r;

    /* renamed from: v  reason: collision with root package name */
    public x0.a f7347v;

    /* renamed from: x  reason: collision with root package name */
    int f7349x;

    /* renamed from: s  reason: collision with root package name */
    int[] f7344s = {2, 5};

    /* renamed from: t  reason: collision with root package name */
    int[] f7345t = {C0382R.string.ShortVideo, C0382R.string.LongVideo};

    /* renamed from: u  reason: collision with root package name */
    int f7346u = -1;

    /* renamed from: w  reason: collision with root package name */
    i f7348w = null;

    /* loaded from: classes.dex */
    class a implements n.b {
        a() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            KSglG kSglG = KSglG.this;
            kSglG.f7346u = i6;
            i iVar = kSglG.f7348w;
            if (iVar != null) {
                kSglG.f7347v.removeView(iVar);
            }
            KSglG kSglG2 = KSglG.this;
            KSglG kSglG3 = KSglG.this;
            kSglG2.f7348w = new i(kSglG3, kSglG3.f7344s[i6]);
            KSglG kSglG4 = KSglG.this;
            kSglG4.f7347v.addView(kSglG4.f7348w, new LinearLayout.LayoutParams(-1, -2));
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
        }
    }

    public void S0() {
        i iVar = this.f7348w;
        if (iVar != null) {
            iVar.S();
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
        if (this.f7349x == i6) {
            return;
        }
        this.f7349x = i6;
        i iVar = this.f7348w;
        if (iVar != null) {
            iVar.D(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7343r = C0;
        M(C0, abc.ams("s2"));
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f7345t, new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(1.0f);
        this.f7343r.addView(nVar, layoutParams);
        x0.a aVar = new x0.a(this);
        this.f7347v = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f7343r.addView(this.f7347v, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        nVar.setCurrentTab(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i iVar = this.f7348w;
        if (iVar != null) {
            iVar.b();
        }
    }
}
