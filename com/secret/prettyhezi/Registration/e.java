package com.secret.prettyhezi.Registration;

import android.view.View;
import com.secret.prettyhezi.Registration.d;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class e extends com.secret.prettyhezi.controls.PullToRefresh.h {
    int E;

    /* loaded from: classes.dex */
    class a extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6977b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f6977b = i6;
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
            e eVar = e.this;
            d.a aVar = dVar.data;
            eVar.h0(aVar.items, aVar.pages > this.f6977b);
        }
    }

    public e(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.E = i6;
        this.f8262y.setDividerHeight(g4.i.r(0.5f));
        this.f8262y.setBackgroundColor(-1);
        W();
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public void b0(int i6) {
        com.secret.prettyhezi.j.o(v.f7132a + "user/registration/code/json?t=" + this.E + "&page=" + i6, true, new a((ZZcINlcxH) getContext(), i6));
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
