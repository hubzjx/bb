package com.secret.prettyhezi.User.Ticket;

import android.graphics.Color;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.User.Ticket.f;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class c extends u {

    /* renamed from: m  reason: collision with root package name */
    com.secret.prettyhezi.User.Ticket.b f7703m;

    /* renamed from: n  reason: collision with root package name */
    TextView f7704n;

    /* renamed from: o  reason: collision with root package name */
    TextView f7705o;

    /* renamed from: p  reason: collision with root package name */
    TextView f7706p;

    /* renamed from: q  reason: collision with root package name */
    TextView f7707q;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            c.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7709a;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                f fVar = (f) com.secret.prettyhezi.f.d(str, f.class);
                if (fVar.code != 200) {
                    f(fVar.err);
                    return;
                }
                a0 r5 = MainApplication.f6711r.r();
                f.a aVar = fVar.data;
                r5.integral = aVar.integral;
                r5.expire = aVar.expire;
                r5.permission = aVar.permission;
                MainApplication.f6711r.x();
                b.this.f7709a.H("已使用，祝你观看愉快");
                for (ViewParent parent = c.this.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent instanceof e) {
                        ((e) parent).p(true, 1L);
                        return;
                    }
                }
            }
        }

        b(ZZcINlcxH zZcINlcxH) {
            this.f7709a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            j.o(v.f7132a + "user/card/edit/json?id=" + c.this.f7703m.id, true, new a(this.f7709a));
        }
    }

    public c(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setBackground(i.f(-1, Color.parseColor("#f0f0f0")));
        setOrientation(0);
        setGravity(16);
        setPadding(i.r(12.0f), i.r(4.0f), i.r(12.0f), 0);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        View c6 = g4.d.c(zZcINlcxH, 18, -1, "使用", 17);
        c6.setOnClickListener(new a());
        c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(80.0f), i.r(40.0f));
        layoutParams.leftMargin = i.r(12.0f);
        addView(c6, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, i.r(32.0f)));
        LinearLayout linearLayout3 = new LinearLayout(zZcINlcxH);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, i.r(24.0f)));
        TextView a6 = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f7704n = a6;
        a6.setSingleLine();
        TextView c7 = g4.d.c(zZcINlcxH, 16, Color.parseColor("#ff0000"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7705o = c7;
        c7.setBackground(i.c(-1, 4.0f, -16777216, 1.0f));
        linearLayout2.addView(this.f7704n, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(this.f7705o, new LinearLayout.LayoutParams(i.r(60.0f), i.r(28.0f)));
        this.f7706p = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f7707q = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#888888"));
        linearLayout3.addView(this.f7706p, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout3.addView(this.f7707q, new LinearLayout.LayoutParams(-2, -2));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        com.secret.prettyhezi.User.Ticket.b bVar = (com.secret.prettyhezi.User.Ticket.b) nVar;
        this.f7703m = bVar;
        this.f7704n.setText(bVar.GetName());
        TextView textView = this.f7705o;
        textView.setText(this.f7703m.value + "天");
        this.f7706p.setText(this.f7703m.GetSource());
        this.f7707q.setText(i.y(this.f7703m.created_at));
    }

    void p() {
        ZZcINlcxH zZcINlcxH = (ZZcINlcxH) getContext();
        zZcINlcxH.B("使用此券可以兑换" + this.f7703m.value + "天上传普通区，精华区以及热门视频的权限", new b(zZcINlcxH), true);
    }
}
