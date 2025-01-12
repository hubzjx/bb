package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Upload.w;
import com.secret.prettyhezi.WVGAB1kU;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class m extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    w f7494m;

    /* renamed from: n  reason: collision with root package name */
    TextView f7495n;

    /* renamed from: o  reason: collision with root package name */
    TextView f7496o;

    /* renamed from: p  reason: collision with root package name */
    TextView f7497p;

    /* renamed from: q  reason: collision with root package name */
    TextView f7498q;

    /* renamed from: r  reason: collision with root package name */
    TextView f7499r;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7500d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f7500d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            Class Z0 = WVGAB1kU.Z0(m.this.f7494m.f7515t);
            ZZcINlcxH zZcINlcxH = this.f7500d;
            w wVar = m.this.f7494m;
            zZcINlcxH.O0(Z0, wVar.id, wVar.f7515t);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7502d;

        b(ZZcINlcxH zZcINlcxH) {
            this.f7502d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            w wVar = m.this.f7494m;
            if (wVar.st == -6) {
                w.a aVar = wVar.rp;
                String str = HttpUrl.FRAGMENT_ENCODE_SET;
                String str2 = aVar == null ? HttpUrl.FRAGMENT_ENCODE_SET : aVar.la;
                if (str2 != null) {
                    str = str2;
                }
                ZZcINlcxH zZcINlcxH = this.f7502d;
                if (zZcINlcxH instanceof BNyrYM5KT) {
                    ((BNyrYM5KT) zZcINlcxH).f7230w = true;
                }
                Hjp3uR.S0(zZcINlcxH, str, wVar.f7515t, wVar.id);
            }
        }
    }

    public m(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        setPadding(g4.i.r(12.0f), g4.i.r(4.0f), g4.i.r(12.0f), g4.i.r(4.0f));
        TextView a6 = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f7495n = a6;
        addView(a6, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, g4.i.r(4.0f), 0, 0);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView a7 = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#555555"));
        this.f7497p = a7;
        linearLayout.addView(a7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c6 = g4.d.c(zZcINlcxH, 13, -1, "查看内容", 17);
        this.f7499r = c6;
        c6.setBackground(g4.i.b(-16777216, 5.0f));
        this.f7499r.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = g4.i.r(12.0f);
        linearLayout.addView(this.f7499r, layoutParams);
        this.f7499r.setOnClickListener(new a(zZcINlcxH));
        TextView a8 = g4.d.a(zZcINlcxH, 13.0f, -1);
        this.f7496o = a8;
        a8.setGravity(17);
        this.f7496o.setBackground(g4.i.b(-16777216, 5.0f));
        this.f7496o.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        this.f7496o.setMinWidth(g4.i.r(120.0f));
        linearLayout.addView(this.f7496o, new LinearLayout.LayoutParams(-2, -2));
        TextView a9 = g4.d.a(zZcINlcxH, 12.0f, -65536);
        this.f7498q = a9;
        a9.setPadding(0, g4.i.r(4.0f), 0, g4.i.r(4.0f));
        addView(this.f7498q, new LinearLayout.LayoutParams(-1, -2));
        this.f7496o.setOnClickListener(new b(zZcINlcxH));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        TextView textView;
        int i6;
        String str;
        w wVar = (w) nVar;
        this.f7494m = wVar;
        this.f7495n.setText(wVar.na);
        this.f7496o.setText(this.f7494m.Status());
        TextView textView2 = this.f7499r;
        int i7 = this.f7494m.st;
        textView2.setVisibility((i7 == -6 || i7 == -8) ? 0 : 4);
        int i8 = this.f7494m.st;
        if (i8 == 0) {
            textView = this.f7496o;
            i6 = -16777216;
        } else if (i8 == -2 || i8 == -3) {
            textView = this.f7496o;
            i6 = -7829368;
        } else {
            textView = this.f7496o;
            i6 = -65536;
        }
        textView.setBackground(g4.i.b(i6, 5.0f));
        this.f7497p.setText(g4.i.v(this.f7494m.ct));
        w.a aVar = this.f7494m.rp;
        if (aVar == null || (str = aVar.la) == null || str.isEmpty()) {
            this.f7498q.setVisibility(8);
            return;
        }
        this.f7498q.setVisibility(0);
        TextView textView3 = this.f7498q;
        textView3.setText("被举报：" + this.f7494m.rp.la);
    }
}
