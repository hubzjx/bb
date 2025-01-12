package com.secret.prettyhezi.Game.Number;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.KhdftsixH;
import com.secret.prettyhezi.Game.Number.k;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class f extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    POjTJ f6367b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f6368c;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ POjTJ f6369d;

        a(POjTJ pOjTJ) {
            this.f6369d = pOjTJ;
        }

        @Override // g4.f
        protected void a(View view) {
            POjTJ pOjTJ = this.f6369d;
            pOjTJ.N0(KhdftsixH.class, pOjTJ.f6302s ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k.c f6371d;

        b(k.c cVar) {
            this.f6371d = cVar;
        }

        @Override // g4.f
        protected void a(View view) {
            POjTJ pOjTJ = f.this.f6367b;
            if (pOjTJ.L.open == 1) {
                pOjTJ.D("没开场，请晚些再来玩", new ZZcINlcxH.q(), true);
            } else if (pOjTJ.f6303t != 1) {
            } else {
                k.b bVar = new k.b();
                bVar.CopyFrom(this.f6371d);
                bVar.integralSum = this.f6371d.Value();
                POjTJ pOjTJ2 = f.this.f6367b;
                bVar.id = pOjTJ2.M.id;
                pOjTJ2.S0(bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends s.g {
        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k.d dVar = (k.d) com.secret.prettyhezi.f.d(str, k.d.class);
            if (dVar.code != 200) {
                f.this.f6367b.w0(dVar);
                return;
            }
            f.this.f6368c.removeAllViews();
            k.c[] cVarArr = dVar.data;
            if (cVarArr == null || cVarArr.length == 0) {
                f.this.a();
                return;
            }
            int i6 = 0;
            while (true) {
                k.c[] cVarArr2 = dVar.data;
                if (i6 >= cVarArr2.length) {
                    return;
                }
                f.this.b(cVarArr2[i6]);
                i6++;
            }
        }
    }

    public f(POjTJ pOjTJ) {
        super(pOjTJ);
        this.f6367b = pOjTJ;
        setOrientation(1);
        setBackground(g4.i.c(Color.parseColor("#dddddd"), 5.0f, -16777216, 2.0f));
        LinearLayout linearLayout = new LinearLayout(pOjTJ);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(g4.i.r(10.0f), 0, g4.i.r(10.0f), 0);
        linearLayout.addView(g4.d.b(pOjTJ, 14.0f, -16777216, "上期投注记录:"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(50.0f)));
        TextView c6 = g4.d.c(pOjTJ, 16, -1, "所有投注记录", 17);
        c6.setBackground(g4.i.e(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f)));
        c6.setOnClickListener(new a(pOjTJ));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(38.0f)));
        LinearLayout linearLayout2 = new LinearLayout(pOjTJ);
        this.f6368c = linearLayout2;
        linearLayout2.setOrientation(1);
        addView(this.f6368c, new LinearLayout.LayoutParams(-1, -2));
    }

    public static LinearLayout c(Context context, k.c cVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(g4.i.r(10.0f), 0, g4.i.r(10.0f), 0);
        linearLayout.addView(g4.d.b(context, 12.0f, -16777216, cVar.Name()), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(g4.d.b(context, 10.0f, Color.parseColor("#333333"), "下注 "));
        int parseColor = Color.parseColor("#ff0000");
        linearLayout.addView(g4.d.b(context, 12.0f, parseColor, cVar.Value() + HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(g4.i.r(60.0f), -2));
        return linearLayout;
    }

    void a() {
        this.f6367b.Q(this.f6368c, Color.parseColor("#666666"), 0.5f, 0, 0, 0);
        this.f6368c.addView(g4.d.c(this.f6367b, 16, -16777216, "上期没有下注", 17), new LinearLayout.LayoutParams(-1, g4.i.r(38.0f)));
    }

    void b(k.c cVar) {
        this.f6367b.Q(this.f6368c, Color.parseColor("#666666"), 0.5f, 0, 0, 0);
        LinearLayout c6 = c(this.f6367b, cVar);
        TextView e6 = com.secret.prettyhezi.Game.Number.c.e(this.f6367b, "追投", c6);
        int i6 = this.f6367b.L.open;
        if (i6 == 1 || i6 == 2) {
            e6.setEnabled(false);
        }
        e6.setOnClickListener(new b(cVar));
        this.f6368c.addView(c6, new LinearLayout.LayoutParams(-1, g4.i.r(42.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        com.secret.prettyhezi.j.q(this.f6367b.j1() + "order/record/up/json", com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new c(this.f6367b));
    }
}
