package com.secret.prettyhezi.Game.Try;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.i;
import com.secret.prettyhezi.Game.l0;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.e;
import com.secret.prettyhezi.f;
import com.secret.prettyhezi.j;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static d f6503a;

    /* renamed from: com.secret.prettyhezi.Game.Try.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0081a extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6504a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f6505b;

        /* renamed from: com.secret.prettyhezi.Game.Try.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0082a implements Runnable {
            RunnableC0082a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0081a.this.f6505b.a(200);
            }
        }

        C0081a(ZZcINlcxH zZcINlcxH, e eVar) {
            this.f6504a = zZcINlcxH;
            this.f6505b = eVar;
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            b bVar = (b) f.d(str, b.class);
            if (bVar.code == 200) {
                l0 l0Var = i.f6608a;
                b.C0083a c0083a = bVar.data;
                l0Var.integral = c0083a.integral;
                d dVar = a.f6503a;
                dVar.integral = c0083a.integral_demo;
                dVar.get_num = c0083a.get_num;
                dVar.spend = c0083a.spend;
                if (this.f6504a.isFinishing() || this.f6504a.isDestroyed()) {
                    return;
                }
                this.f6504a.runOnUiThread(new RunnableC0082a());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends w {
        public C0083a data;

        /* renamed from: com.secret.prettyhezi.Game.Try.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0083a implements Serializable {
            public int get_num;
            public int integral;
            public int integral_demo;
            public int spend;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends w {
        public d data;
    }

    /* loaded from: classes.dex */
    public static class d implements Serializable {
        public int get_num;
        public int integral;
        public int spend;
        public int status;
        public int uid;
        public String username;
    }

    public static void a(ZZcINlcxH zZcINlcxH, e eVar) {
        j.t(i.a() + "demo/auth/integral/json", f.e(new i.b()), i.f6608a.token.token, 3, new C0081a(zZcINlcxH, eVar));
    }

    public static TextView b(ZZcINlcxH zZcINlcxH, LinearLayout linearLayout) {
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, "数字游戏有奖试玩", 17);
        c6.setBackground(g4.i.d(g4.i.b(-16777216, 10.0f), g4.i.b(Color.parseColor("#88000000"), 10.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(50.0f));
        layoutParams.topMargin = g4.i.r(20.0f);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        linearLayout.addView(c6, layoutParams);
        return c6;
    }
}
