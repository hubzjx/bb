package com.secret.prettyhezi.Upload;

import android.view.View;
import com.secret.prettyhezi.ZZcINlcxH;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.secret.prettyhezi.View.j {
    boolean S;
    com.secret.prettyhezi.Server.h T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.View.h f7456d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7457e;

        a(com.secret.prettyhezi.View.h hVar, ZZcINlcxH zZcINlcxH) {
            this.f7456d = hVar;
            this.f7457e = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            b bVar = b.this;
            com.secret.prettyhezi.Server.h hVar = this.f7456d.f7945m;
            bVar.T = hVar;
            int i6 = bVar.Q;
            this.f7457e.P0((i6 == 1 || i6 == 6) ? LNoFT.class : i6 == 7 ? null : CnD1H53X.class, hVar.id, i6, bVar.S ? 1 : 0);
        }
    }

    public b(ZZcINlcxH zZcINlcxH, int i6, boolean z5) {
        super(zZcINlcxH, i6);
        this.T = null;
        this.f8029w = false;
        this.S = z5;
        StringBuilder sb = new StringBuilder();
        sb.append(z5 ? "appeal" : "report");
        sb.append("/new/json?t=");
        sb.append(i6);
        sb.append("&page=999");
        g(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.j, com.secret.prettyhezi.View.t
    /* renamed from: U */
    public com.secret.prettyhezi.View.h l(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.h hVar, int i6) {
        com.secret.prettyhezi.View.h l6 = super.l(zZcINlcxH, hVar, i6);
        l6.getTopRelativeLayout().setOnClickListener(new a(l6, zZcINlcxH));
        return l6;
    }

    public void V() {
        com.secret.prettyhezi.Server.h hVar = this.T;
        if (hVar != null) {
            z(hVar, (com.secret.prettyhezi.View.h) hVar.view);
            this.T = null;
            if (this.f8012f.isEmpty()) {
                o(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.j, com.secret.prettyhezi.View.t
    public void setupItem(com.secret.prettyhezi.Server.n nVar) {
        super.setupItem(nVar);
        ((com.secret.prettyhezi.Server.h) nVar).cl = null;
    }
}
