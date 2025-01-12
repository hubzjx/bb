package com.secret.prettyhezi.Game;

import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
class k0 extends com.secret.prettyhezi.View.t {
    boolean Q;

    public k0(ZZcINlcxH zZcINlcxH, boolean z5) {
        super(zZcINlcxH, g.class);
        this.Q = z5;
        this.f8029w = false;
        this.f8013g = g4.i.r(4.0f);
        d();
        g(z5 ? "demo/record/integral/json?page=999" : "record/integral/json?page=999");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: N */
    public h l(ZZcINlcxH zZcINlcxH, g gVar, int i6) {
        return new h(zZcINlcxH, this.Q);
    }

    @Override // com.secret.prettyhezi.View.t
    protected int a() {
        return 1;
    }
}
