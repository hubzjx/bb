package com.secret.prettyhezi.Game;

import c.abc;
import com.secret.prettyhezi.Server.o;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.IOException;
import java.io.Serializable;
/* loaded from: classes.dex */
public class m0 extends com.secret.prettyhezi.View.t {
    int Q;

    /* loaded from: classes.dex */
    class a extends s.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f6630c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.View.t tVar, int i6) {
            super(zZcINlcxH, tVar);
            this.f6630c = i6;
        }

        @Override // com.secret.prettyhezi.s.d, com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            super.a(iOException);
            ((com.secret.prettyhezi.View.t) m0.this).I = false;
        }

        @Override // com.secret.prettyhezi.s.d, com.secret.prettyhezi.j.e
        public void b(int i6) {
            super.b(i6);
            ((com.secret.prettyhezi.View.t) m0.this).I = false;
        }

        @Override // com.secret.prettyhezi.s.d
        public void f(String str) {
            com.secret.prettyhezi.Server.o c6 = com.secret.prettyhezi.f.c(str, n0.class);
            if (c6.code != 200) {
                e(c6.err);
                return;
            }
            int i6 = c6.data.total;
            if (i6 > 0 && this.f6630c == 1) {
                m0.this.E(i6);
            }
            m0 m0Var = m0.this;
            o.a aVar = c6.data;
            m0Var.f8009c = aVar.pages;
            m0Var.k(aVar.items);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Serializable {
        String key = abc.c(7);
        int page;
        int user_id;

        public b(int i6, int i7) {
            this.page = i6;
            this.user_id = i7;
        }
    }

    public m0(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, d.class);
        this.Q = i6;
        this.f8029w = false;
        this.f8013g = g4.i.r(4.0f);
        this.f8020n = 3;
        this.f8019m = i.a();
        g("api/bonus/user/json?page=999");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: R */
    public o0 l(ZZcINlcxH zZcINlcxH, n0 n0Var, int i6) {
        return new o0(zZcINlcxH);
    }

    @Override // com.secret.prettyhezi.View.t
    protected int a() {
        return 1;
    }

    @Override // com.secret.prettyhezi.View.t
    protected void q() {
        int i6 = this.f8010d;
        com.secret.prettyhezi.j.t(this.f8019m + "api/bonus/user/json", com.secret.prettyhezi.f.e(new b(this.f8010d, this.Q)), null, this.f8020n, new a(this.f8008b, this, i6));
    }
}
