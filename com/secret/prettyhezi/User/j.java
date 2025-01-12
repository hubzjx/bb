package com.secret.prettyhezi.User;

import android.view.View;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.secret.prettyhezi.controls.PullToRefresh.h {

    /* loaded from: classes.dex */
    class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            j.this.X();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            i iVar = (i) com.secret.prettyhezi.f.d(str, i.class);
            if (iVar.code == 200) {
                j.this.h0(iVar.data, false);
            } else {
                f(iVar.err);
            }
        }
    }

    public j(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8262y.setDividerHeight(g4.i.r(0.5f));
        this.f8262y.setBackgroundColor(-1);
        W();
        V("暂时没有经验值变动信息");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public void b0(int i6) {
        com.secret.prettyhezi.j.o(v.f7132a + "user/exp/record/json", true, new a((ZZcINlcxH) getContext()));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public boolean d0() {
        return true;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    /* renamed from: i0 */
    public h Y(View view, g gVar) {
        h hVar = (view == null || !(view instanceof h)) ? new h((ZZcINlcxH) getContext()) : (h) view;
        hVar.b(gVar);
        return hVar;
    }
}
