package com.secret.prettyhezi.User;

import android.view.View;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.secret.prettyhezi.controls.PullToRefresh.h {

    /* loaded from: classes.dex */
    class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            e.this.X();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            d dVar = (d) com.secret.prettyhezi.f.d(str, d.class);
            if (dVar.code != 200) {
                f(dVar.err);
                return;
            }
            R8yk5xS.f7609u = null;
            a0 r5 = MainApplication.f6711r.r();
            b[] bVarArr = dVar.data;
            if (bVarArr != null && bVarArr.length > 0) {
                for (b bVar : bVarArr) {
                    bVar.isMe = bVar.cert_id == r5.token.cert;
                    if (bVar.bind) {
                        R8yk5xS.f7609u = bVar;
                    }
                }
                ((R8yk5xS) e.this.getContext()).T0();
            }
            e.this.h0(dVar.data, false);
        }
    }

    public e(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8262y.setDividerHeight(g4.i.r(0.5f));
        this.f8262y.setBackgroundColor(-1);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public void b0(int i6) {
        com.secret.prettyhezi.j.o(v.f7132a + "user/cert/json", true, new a((ZZcINlcxH) getContext()));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public boolean d0() {
        return true;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    /* renamed from: i0 */
    public c Y(View view, b bVar) {
        c cVar = (view == null || !(view instanceof c)) ? new c((ZZcINlcxH) getContext()) : (c) view;
        cVar.b(bVar);
        return cVar;
    }
}
