package com.secret.prettyhezi.Upload;

import android.view.View;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.secret.prettyhezi.View.t {
    String Q;
    int R;
    com.secret.prettyhezi.Server.h S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: com.secret.prettyhezi.Upload.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0115a extends s.g {
            C0115a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                g gVar = (g) com.secret.prettyhezi.f.d(str, g.class);
                if (gVar.code != 200) {
                    f(gVar.err);
                    return;
                }
                com.secret.prettyhezi.Server.h[] hVarArr = gVar.data;
                if (hVarArr == null || hVarArr.length <= 0) {
                    i.this.h();
                } else {
                    i.this.k(hVarArr);
                }
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.secret.prettyhezi.View.t) i.this).f8008b.I0();
            i iVar = i.this;
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + i.this.Q, iVar.E, new C0115a(((com.secret.prettyhezi.View.t) iVar).f8008b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Server.h f7469d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7470e;

        b(com.secret.prettyhezi.Server.h hVar, ZZcINlcxH zZcINlcxH) {
            this.f7469d = hVar;
            this.f7470e = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            i iVar = i.this;
            com.secret.prettyhezi.Server.h hVar = this.f7469d;
            iVar.S = hVar;
            this.f7470e.O0(XXAJdUV0R.class, hVar.id, iVar.R);
        }
    }

    public i(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, com.secret.prettyhezi.Server.h.class);
        this.Q = HttpUrl.FRAGMENT_ENCODE_SET;
        this.S = null;
        this.f8009c = -1;
        this.f8029w = false;
        this.Q = "repeatedly/audit/new/json?t=" + i6;
        this.R = i6;
        R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: Q */
    public h l(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.h hVar, int i6) {
        h hVar2 = new h(zZcINlcxH, i6);
        hVar2.b(hVar);
        hVar2.setOnClickListener(new b(hVar, zZcINlcxH));
        return hVar2;
    }

    void R() {
        post(new a());
    }

    public void S() {
        com.secret.prettyhezi.Server.h hVar = this.S;
        if (hVar != null) {
            z(hVar, (h) hVar.view);
            this.S = null;
            if (this.f8012f.isEmpty()) {
                this.f8008b.I0();
                R();
            }
        }
    }
}
