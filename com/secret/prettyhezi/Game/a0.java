package com.secret.prettyhezi.Game;

import com.secret.prettyhezi.ZZcINlcxH;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a0 extends com.secret.prettyhezi.View.t {
    public a0(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, b0.class);
        this.f8029w = false;
        this.f8013g = g4.i.r(2.0f);
        d();
        g("loot/list/json?ltyid=" + i6 + "&page=999");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: N */
    public z l(ZZcINlcxH zZcINlcxH, b0 b0Var, int i6) {
        return new z(zZcINlcxH);
    }

    @Override // com.secret.prettyhezi.View.t
    protected int a() {
        return 1;
    }
}
