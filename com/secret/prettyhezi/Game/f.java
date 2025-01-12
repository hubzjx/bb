package com.secret.prettyhezi.Game;

import c.abc;
import com.secret.prettyhezi.Server.o;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.IOException;
import java.io.Serializable;
/* loaded from: classes.dex */
class f extends com.secret.prettyhezi.View.t {

    /* loaded from: classes.dex */
    class a extends s.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f6589c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.View.t tVar, int i6) {
            super(zZcINlcxH, tVar);
            this.f6589c = i6;
        }

        @Override // com.secret.prettyhezi.s.d, com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            super.a(iOException);
            ((com.secret.prettyhezi.View.t) f.this).I = false;
        }

        @Override // com.secret.prettyhezi.s.d, com.secret.prettyhezi.j.e
        public void b(int i6) {
            super.b(i6);
            ((com.secret.prettyhezi.View.t) f.this).I = false;
        }

        @Override // com.secret.prettyhezi.s.d
        public void f(String str) {
            com.secret.prettyhezi.Server.o c6 = com.secret.prettyhezi.f.c(str, d.class);
            if (c6.code != 200) {
                e(c6.err);
                return;
            }
            int i6 = c6.data.total;
            if (i6 > 0 && this.f6589c == 1) {
                f.this.E(i6);
            }
            f fVar = f.this;
            o.a aVar = c6.data;
            fVar.f8009c = aVar.pages;
            fVar.k(aVar.items);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Serializable {
        String key = abc.c(7);
        int page;

        public b(int i6) {
            this.page = i6;
        }
    }

    public f(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, d.class);
        this.f8029w = false;
        this.f8013g = g4.i.r(4.0f);
        this.f8020n = 3;
        this.f8019m = i.a();
        g("api/bonus/wall/json?page=999");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: R */
    public e l(ZZcINlcxH zZcINlcxH, d dVar, int i6) {
        return new e(zZcINlcxH);
    }

    @Override // com.secret.prettyhezi.View.t
    protected int a() {
        return 1;
    }

    @Override // com.secret.prettyhezi.View.t
    protected void q() {
        int i6 = this.f8010d;
        com.secret.prettyhezi.j.t(this.f8019m + "api/bonus/wall/json", com.secret.prettyhezi.f.e(new b(this.f8010d)), null, this.f8020n, new a(this.f8008b, this, i6));
    }
}
