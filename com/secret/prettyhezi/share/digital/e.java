package com.secret.prettyhezi.share.digital;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import g4.f;
import g4.i;
/* loaded from: classes.dex */
public class e extends u {

    /* renamed from: m  reason: collision with root package name */
    b f9018m;

    /* renamed from: n  reason: collision with root package name */
    TextView f9019n;

    /* renamed from: o  reason: collision with root package name */
    TextView f9020o;

    /* renamed from: p  reason: collision with root package name */
    TextView f9021p;

    /* renamed from: q  reason: collision with root package name */
    TextView f9022q;

    /* renamed from: r  reason: collision with root package name */
    TextView f9023r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f9024s;

    /* loaded from: classes.dex */
    class a extends f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f9025d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f9025d = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            d dVar = (d) ((u) e.this).f8044i;
            int i6 = dVar.status;
            if (i6 == 0 || i6 == 1) {
                this.f9025d.N0(JqUSUBK.class, dVar.id);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends LinearLayout {
        public b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
            setOrientation(0);
            setGravity(16);
        }

        public void a(d dVar) {
            Context context;
            StringBuilder sb;
            String str;
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(130.0f), -2);
            layoutParams.rightMargin = i.r(2.0f);
            Context context2 = getContext();
            addView(g4.d.b(context2, 10.0f, -7829368, "下单：" + i.v(dVar.created_at)), layoutParams);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i.r(120.0f), -2);
            long j6 = dVar.updated_at;
            if (j6 > 0 && dVar.status == 1) {
                context = getContext();
                sb = new StringBuilder();
                str = "成交：";
            } else if (j6 <= 0 || dVar.status != -1) {
                return;
            } else {
                context = getContext();
                sb = new StringBuilder();
                str = "失败：";
            }
            sb.append(str);
            sb.append(i.v(dVar.updated_at));
            addView(g4.d.b(context, 10.0f, -7829368, sb.toString()), layoutParams2);
        }
    }

    public e(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setPadding(i.r(6.0f), i.r(2.0f), i.r(6.0f), i.r(2.0f));
        setOrientation(0);
        setGravity(16);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, i.r(30.0f)));
        this.f9020o = g4.d.a(zZcINlcxH, 12.0f, -16777216);
        this.f9021p = g4.d.a(zZcINlcxH, 12.0f, -65536);
        linearLayout2.addView(this.f9020o, new LinearLayout.LayoutParams(i.r(130.0f), -2));
        linearLayout2.addView(this.f9021p, new LinearLayout.LayoutParams(i.r(120.0f), -2));
        LinearLayout linearLayout3 = new LinearLayout(zZcINlcxH);
        this.f9024s = linearLayout3;
        linearLayout3.setOrientation(0);
        this.f9024s.setGravity(16);
        linearLayout.addView(this.f9024s, new LinearLayout.LayoutParams(-1, i.r(30.0f)));
        this.f9022q = g4.d.a(zZcINlcxH, 12.0f, -16777216);
        this.f9023r = g4.d.a(zZcINlcxH, 12.0f, -65536);
        this.f9024s.addView(this.f9022q, new LinearLayout.LayoutParams(i.r(130.0f), -2));
        this.f9024s.addView(this.f9023r, new LinearLayout.LayoutParams(i.r(120.0f), -2));
        b bVar = new b(zZcINlcxH);
        this.f9018m = bVar;
        linearLayout.addView(bVar, new LinearLayout.LayoutParams(-1, i.r(30.0f)));
        this.f9019n = g4.d.c(zZcINlcxH, 14, -1, "操作", 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(70.0f), i.r(40.0f));
        layoutParams.rightMargin = i.r(6.0f);
        addView(this.f9019n, layoutParams);
        setOnClickListener(new a(zZcINlcxH));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        d dVar = (d) nVar;
        this.f9018m.a(dVar);
        TextView textView = this.f9020o;
        textView.setText("预兑" + i.C(dVar.score0) + "积分");
        TextView textView2 = this.f9021p;
        textView2.setText("约需" + i.C(dVar.amount0) + "USDT");
        if (dVar.status == 1) {
            this.f9024s.setVisibility(0);
            TextView textView3 = this.f9022q;
            textView3.setText("实兑" + i.C(dVar.score1) + "积分");
            TextView textView4 = this.f9023r;
            textView4.setText("实付" + i.C(dVar.amount1) + "USDT");
        } else {
            this.f9024s.setVisibility(8);
        }
        this.f9019n.setText(dVar.StatusName());
        int i6 = dVar.status;
        if (i6 != -2 && i6 != -1) {
            if (i6 == 0) {
                this.f9019n.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
                this.f9019n.setEnabled(true);
                this.f9019n.setTextColor(-65536);
                return;
            } else if (i6 != 1) {
                return;
            }
        }
        this.f9019n.setEnabled(false);
        this.f9019n.setTextColor(-1);
        this.f9019n.setBackground(i.b(Color.parseColor("#666666"), 5.0f));
    }
}
