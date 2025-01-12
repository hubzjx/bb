package com.secret.prettyhezi.View;

import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class j extends t {
    public int Q;
    public int R;

    public j(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, com.secret.prettyhezi.Server.h.class);
        this.Q = -1;
        this.R = -1;
    }

    public void N(int i6, boolean z5) {
        this.f8032z = z5;
        g("box/show/json?id=" + i6 + "&page=999&t=" + this.Q);
    }

    public void O(int i6) {
        if (i6 == 0) {
            P();
        } else {
            Q(i6);
        }
    }

    public void P() {
        g(com.secret.prettyhezi.g.b(this.Q) + "/json?page=999");
    }

    public void Q(int i6) {
        g(com.secret.prettyhezi.g.b(this.Q) + "/top/json?page=999&by=" + i6);
    }

    public void R() {
        this.R = 100;
        g(com.secret.prettyhezi.g.b(this.Q) + "/myunlock/json?page=999");
    }

    public void S(int i6, int i7, int i8) {
        if (i6 == 100) {
            R();
        } else {
            T(i6, i7, i8);
        }
    }

    public void T(int i6, int i7, int i8) {
        this.R = i6;
        String b6 = com.secret.prettyhezi.g.b(this.Q);
        if (i8 < 0) {
            i8 = 0;
        }
        String str = b6 + "/json?page=999&id=" + i8;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&t=");
        sb.append(i6 != 3 ? 2 : 3);
        sb.append("&by=");
        sb.append(i7);
        g(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: U */
    public h l(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.h hVar, int i6) {
        return new h(zZcINlcxH, i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    public void setupItem(com.secret.prettyhezi.Server.n nVar) {
        int i6 = this.Q;
        if (i6 >= 0) {
            ((com.secret.prettyhezi.Server.h) nVar).f7112t = i6;
        }
        int i7 = this.R;
        if (i7 >= 0) {
            ((com.secret.prettyhezi.Server.h) nVar).ut = i7;
        }
    }

    public j(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, com.secret.prettyhezi.Server.h.class);
        this.Q = i6;
        this.R = -1;
    }
}
