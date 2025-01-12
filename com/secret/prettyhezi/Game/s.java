package com.secret.prettyhezi.Game;

import com.secret.prettyhezi.ZZcINlcxH;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.secret.prettyhezi.View.t {
    public s(ZZcINlcxH zZcINlcxH, boolean z5) {
        super(zZcINlcxH, q.class);
        this.f8029w = false;
        this.f8013g = g4.i.r(2.0f);
        d();
        g(z5 ? "demo/order/record/json?page=999" : "order/record/json?page=999");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: N */
    public r l(ZZcINlcxH zZcINlcxH, q qVar, int i6) {
        return new r(zZcINlcxH);
    }

    @Override // com.secret.prettyhezi.View.t
    protected int a() {
        return 1;
    }
}
