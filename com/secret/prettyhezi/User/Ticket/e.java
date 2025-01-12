package com.secret.prettyhezi.User.Ticket;

import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.User.Ticket.d;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.PullToRefresh.h;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.KQHNLjV;
import g4.i;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class e extends h {

    /* loaded from: classes.dex */
    class a extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7712b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f7712b = i6;
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
            eVar.h0(aVar.items, aVar.pages > this.f7712b);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7714d;

        b(ZZcINlcxH zZcINlcxH) {
            this.f7714d = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            this.f7714d.M0(KQHNLjV.class);
        }
    }

    public e(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8262y.setDividerHeight(i.r(0.5f));
        this.f8262y.setBackgroundColor(-1);
        W();
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public View T() {
        ZZcINlcxH zZcINlcxH = (ZZcINlcxH) getContext();
        if (zZcINlcxH instanceof Alv5GBDA) {
            ((Alv5GBDA) zZcINlcxH).f7698s.setVisibility(8);
        }
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TextView c6 = g4.d.c(getContext(), 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        c6.setText(Html.fromHtml("<u><font color=\"#000000\">暂时没有卡券，可以通过<font color=\"#ff0000\"><b>邀请用户注册</b></font>获取卡券</font></u>"));
        c6.setPadding(0, i.r(20.0f), 0, i.r(10.0f));
        c6.setOnClickListener(new b(zZcINlcxH));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public void b0(int i6) {
        j.o(v.f7132a + "user/card/json?page=" + i6, true, new a((ZZcINlcxH) getContext(), i6));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    public boolean d0() {
        return true;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.h
    /* renamed from: i0 */
    public c Y(View view, com.secret.prettyhezi.User.Ticket.b bVar) {
        c cVar = (view == null || !(view instanceof c)) ? new c((ZZcINlcxH) getContext()) : (c) view;
        cVar.b(bVar);
        return cVar;
    }
}
