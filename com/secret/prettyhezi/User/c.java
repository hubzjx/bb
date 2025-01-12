package com.secret.prettyhezi.User;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.l;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends u {

    /* renamed from: m  reason: collision with root package name */
    TextView f7716m;

    /* renamed from: n  reason: collision with root package name */
    TextView f7717n;

    /* renamed from: o  reason: collision with root package name */
    TextView f7718o;

    /* renamed from: p  reason: collision with root package name */
    com.secret.prettyhezi.User.b f7719p;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            c.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ R8yk5xS f7721a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f7722b;

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                MainApplication.f6711r.r().bindcert = b.this.f7722b;
                MainApplication.f6711r.x();
                b.this.f7721a.S0();
            }
        }

        b(R8yk5xS r8yk5xS, boolean z5) {
            this.f7721a = r8yk5xS;
            this.f7722b = z5;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f7721a.I0();
            StringBuilder sb = new StringBuilder();
            sb.append(v.f7132a);
            sb.append(this.f7722b ? "user/cert/bound/json" : c.this.f7719p.isMe ? "user/cert/unbound/json" : "cert/json");
            com.secret.prettyhezi.j.r(sb.toString(), c.this.f7719p.isMe ? new v.f() : new l("b"), true, new s.e((ZZcINlcxH) c.this.getContext(), new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.User.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0122c implements a.f {
        C0122c() {
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            c.this.p(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements a.f {
        d() {
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            c.this.p(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements a.f {
        e() {
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            c.this.p(false);
        }
    }

    public c(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setOrientation(0);
        setGravity(16);
        setPadding(g4.i.r(12.0f), g4.i.r(4.0f), g4.i.r(12.0f), g4.i.r(4.0f));
        TextView a6 = g4.d.a(zZcINlcxH, 13.0f, -16777216);
        this.f7716m = a6;
        addView(a6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f7717n = g4.d.a(zZcINlcxH, 11.0f, Color.parseColor("#333333"));
        addView(this.f7717n, new LinearLayout.LayoutParams(-2, -2));
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, "移除", 17);
        this.f7718o = c6;
        c6.setOnClickListener(new a());
        this.f7718o.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(36.0f));
        layoutParams.leftMargin = g4.i.r(12.0f);
        addView(this.f7718o, layoutParams);
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        com.secret.prettyhezi.User.b bVar = (com.secret.prettyhezi.User.b) nVar;
        this.f7719p = bVar;
        this.f7716m.setText(bVar.company);
        boolean z5 = false;
        int i6 = (this.f7719p.logined_at > 0L ? 1 : (this.f7719p.logined_at == 0L ? 0 : -1));
        TextView textView = this.f7717n;
        if (i6 > 0) {
            textView.setText("上次登录：\n" + g4.i.y(this.f7719p.logined_at));
            this.f7717n.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f7718o;
        com.secret.prettyhezi.User.b bVar2 = this.f7719p;
        textView2.setVisibility((bVar2.isMe || bVar2.bind) ? 0 : 4);
        com.secret.prettyhezi.User.b bVar3 = this.f7719p;
        if (!bVar3.isMe) {
            this.f7718o.setText(bVar3.bind ? "解除绑定" : HttpUrl.FRAGMENT_ENCODE_SET);
            return;
        }
        if (!bVar3.bind && R8yk5xS.f7609u != null) {
            z5 = true;
        }
        this.f7718o.setEnabled(!z5);
        this.f7718o.setText(this.f7719p.bind ? "解除绑定" : z5 ? "本机" : "绑定本机");
    }

    void p(boolean z5) {
        StringBuilder sb;
        String str;
        R8yk5xS r8yk5xS = (R8yk5xS) getContext();
        if (z5) {
            sb = new StringBuilder();
            sb.append("绑定本账号与设备 ");
            sb.append(this.f7719p.company);
            str = " ?";
        } else {
            sb = new StringBuilder();
            sb.append("解除本账号与设备 ");
            sb.append(this.f7719p.company);
            str = " 的绑定？";
        }
        sb.append(str);
        r8yk5xS.B(sb.toString(), new b(r8yk5xS, z5), true);
    }

    void q() {
        R8yk5xS r8yk5xS;
        a.f eVar;
        com.secret.prettyhezi.User.b bVar = this.f7719p;
        if (!bVar.isMe) {
            r8yk5xS = (R8yk5xS) getContext();
            eVar = new e();
        } else if (bVar.bind) {
            com.secret.prettyhezi.Device.a.b((R8yk5xS) getContext(), new d());
            return;
        } else {
            r8yk5xS = (R8yk5xS) getContext();
            eVar = new C0122c();
        }
        com.secret.prettyhezi.Device.a.d(r8yk5xS, eVar);
    }
}
