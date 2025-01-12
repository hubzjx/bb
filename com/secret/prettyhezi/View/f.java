package com.secret.prettyhezi.View;

import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class f extends t {
    int Q;
    int R;
    public boolean S;

    public f(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, com.secret.prettyhezi.Server.d.class);
        this.S = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: N */
    public e l(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.d dVar, int i6) {
        e eVar = new e(zZcINlcxH, i6);
        if (!this.f8032z && this.Q != 103) {
            eVar.s();
        }
        return eVar;
    }

    public f(ZZcINlcxH zZcINlcxH, int i6, int i7) {
        super(zZcINlcxH, com.secret.prettyhezi.Server.d.class);
        String f6;
        this.S = false;
        this.Q = i6;
        this.R = i7;
        if (i6 == 101) {
            g(com.secret.prettyhezi.Server.v.k(MainApplication.f(), 999));
            this.S = true;
            return;
        }
        if (i6 == 100) {
            f6 = i7 == 0 ? com.secret.prettyhezi.Server.v.e(999) : com.secret.prettyhezi.Server.v.i(999, i7);
        } else if (i6 != 103) {
            return;
        } else {
            f6 = com.secret.prettyhezi.Server.v.f(MainApplication.f(), 999);
        }
        g(f6);
    }
}
