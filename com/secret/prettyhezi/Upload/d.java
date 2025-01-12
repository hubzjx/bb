package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.secret.prettyhezi.controls.PullToRefresh.h {

    /* loaded from: classes.dex */
    class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            d.this.X();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            f fVar = (f) com.secret.prettyhezi.f.d(str, f.class);
            if (fVar.code == 200) {
                d.this.h0(fVar.data, false);
            } else {
                f(fVar.err);
            }
        }
    }

    public d(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8262y.setDividerHeight(g4.i.r(0.5f));
        this.f8262y.setBackgroundColor(-1);
        TextView c6 = g4.d.c(zZcINlcxH, 14, -16777216, abc.ams("s9"), 17);
        c6.setBackgroundColor(Color.parseColor("#cccccc"));
        c6.setPadding(0, g4.i.r(10.0f), 0, g4.i.r(10.0f));
        U(c6);
        V(abc.ams("s8"));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public void b0(int i6) {
        com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "report/audit/income/json", true, new a((ZZcINlcxH) getContext()));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public boolean d0() {
        return true;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    /* renamed from: i0 */
    public e Y(View view, c cVar) {
        e eVar = (view == null || !(view instanceof e)) ? new e((ZZcINlcxH) getContext()) : (e) view;
        eVar.b(cVar);
        return eVar;
    }
}
