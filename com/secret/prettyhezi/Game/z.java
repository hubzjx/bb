package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class z extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    TextView f6674m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6675n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6676o;

    /* renamed from: p  reason: collision with root package name */
    TextView f6677p;

    /* renamed from: q  reason: collision with root package name */
    TextView f6678q;

    /* renamed from: r  reason: collision with root package name */
    int f6679r;

    /* renamed from: s  reason: collision with root package name */
    String f6680s;

    /* renamed from: t  reason: collision with root package name */
    boolean f6681t;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6682d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6682d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            z zVar = z.this;
            if (zVar.f6681t) {
                this.f6682d.finish();
            } else {
                this.f6682d.N0(VfHLXJ.class, zVar.f6679r);
            }
        }
    }

    public z(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f6681t = false;
        this.f8037b = g4.i.r(40.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        setOrientation(0);
        setGravity(16);
        this.f6674m = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#666666"));
        this.f6675n = g4.d.c(zZcINlcxH, 12, Color.parseColor("#ff0000"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6676o = g4.d.c(zZcINlcxH, 12, Color.parseColor("#666666"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6677p = g4.d.c(zZcINlcxH, 12, Color.parseColor("#666666"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6678q = g4.d.c(zZcINlcxH, 12, Color.parseColor("#ffff00"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        addView(this.f6674m, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.f6675n, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.f6676o, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.f6677p, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.f6678q, new LinearLayout.LayoutParams(0, -2, 1.0f));
        setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        setOnClickListener(new a(zZcINlcxH));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        String str;
        TextView textView;
        String str2;
        b0 b0Var = (b0) nVar;
        this.f6679r = b0Var.id;
        String str3 = b0Var.order_no;
        this.f6680s = str3;
        this.f6674m.setText(str3);
        TextView textView2 = this.f6676o;
        if (b0Var.sy_share == 0) {
            str = "-";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET + b0Var.sy_share;
        }
        textView2.setText(str);
        if (b0Var.result == 0) {
            this.f6678q.setText("立即夺宝");
            this.f6678q.setTextColor(Color.parseColor("#ff0000"));
            this.f6675n.setText("-");
            this.f6681t = true;
        } else {
            this.f6678q.setText("查看详情");
            this.f6678q.setTextColor(Color.parseColor("#333333"));
            this.f6675n.setText(b0Var.lucky_number);
            this.f6681t = false;
        }
        int i6 = b0Var.result;
        if (i6 == 0) {
            textView = this.f6677p;
            str2 = "进行中";
        } else if (i6 == 1) {
            this.f6677p.setText("已抢完");
            if (b0Var.lucky_number.equals("0")) {
                this.f6675n.setText("-");
                return;
            }
            return;
        } else {
            textView = this.f6677p;
            str2 = "已开奖";
        }
        textView.setText(str2);
    }
}
