package com.secret.prettyhezi.share;

import android.view.View;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.secret.prettyhezi.controls.PullToRefresh.h {

    /* loaded from: classes.dex */
    class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            h.this.X();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            g gVar = (g) com.secret.prettyhezi.f.d(str, g.class);
            if (gVar.code == 200) {
                h.this.h0(gVar.data, false);
            } else {
                f(gVar.err);
            }
        }
    }

    public h(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8262y.setDividerHeight(g4.i.r(0.5f));
        this.f8262y.setBackgroundColor(-1);
        W();
        V("暂时没有积分变动信息");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public void b0(int i6) {
        com.secret.prettyhezi.j.o(v.f7132a + "user/integral/record/json", true, new a((ZZcINlcxH) getContext()));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public boolean d0() {
        return true;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    /* renamed from: i0 */
    public f Y(View view, e eVar) {
        f fVar = (view == null || !(view instanceof f)) ? new f((ZZcINlcxH) getContext()) : (f) view;
        fVar.b(eVar);
        return fVar;
    }
}
