package com.secret.prettyhezi.Game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.secret.prettyhezi.View.u {

    /* renamed from: y  reason: collision with root package name */
    static final int f6648y = Color.parseColor("#333333");

    /* renamed from: m  reason: collision with root package name */
    TextView f6649m;

    /* renamed from: n  reason: collision with root package name */
    LinearLayout f6650n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6651o;

    /* renamed from: p  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f6652p;

    /* renamed from: q  reason: collision with root package name */
    TextView f6653q;

    /* renamed from: r  reason: collision with root package name */
    TextView f6654r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6655s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6656t;

    /* renamed from: u  reason: collision with root package name */
    TextView f6657u;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.controls.u f6658v;

    /* renamed from: w  reason: collision with root package name */
    int f6659w;

    /* renamed from: x  reason: collision with root package name */
    String f6660x;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6661d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6661d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            Intent intent = new Intent(this.f6661d, OFuSfzrsP.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", r.this.f6659w);
            bundle.putString("extra", r.this.f6660x);
            intent.putExtras(bundle);
            this.f6661d.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6663d;

        b(ZZcINlcxH zZcINlcxH) {
            this.f6663d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            String[] split = ((q) ((com.secret.prettyhezi.View.u) r.this).f8044i).vote_content.split("\\|");
            if (split.length == 4) {
                this.f6663d.E(split[0], (("\n下注：" + split[1]) + "\n注数：" + split[2]) + "      倍数：" + split[3], null, true);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ q f6665d;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                r.this.r();
            }
        }

        c(q qVar) {
            this.f6665d = qVar;
        }

        @Override // g4.f
        protected void a(View view) {
            ZZcINlcxH j6 = g4.i.j();
            j6.B("撤销 " + this.f6665d.number_no + " 期的下注？", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HFqjgQ f6668b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ZZcINlcxH zZcINlcxH, HFqjgQ hFqjgQ) {
            super(zZcINlcxH);
            this.f6668b = hFqjgQ;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
            if (zVar.code != 200) {
                f(zVar.err);
                this.f6668b.V0();
                return;
            }
            r.this.f6657u.setVisibility(8);
            r.this.f6656t.setText("已撤");
            r.this.f6656t.setVisibility(0);
            r.this.f6656t.setTextColor(Color.parseColor("#f00000"));
            q qVar = (q) ((com.secret.prettyhezi.View.u) r.this).f8044i;
            qVar.cancel = -1;
            qVar.is_cancel = 0;
            this.f6668b.W0();
        }
    }

    public r(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f6657u = null;
        this.f8037b = g4.i.r(32.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        setOrientation(0);
        setGravity(16);
        int i6 = f6648y;
        this.f6649m = g4.d.a(zZcINlcxH, 10.0f, i6);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        this.f6650n = linearLayout;
        linearLayout.setGravity(16);
        this.f6650n.setOrientation(0);
        this.f6651o = g4.d.a(zZcINlcxH, 10.0f, i6);
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.ic_dropdown);
        this.f6652p = zVar;
        zVar.setAlpha(0.8f);
        this.f6653q = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#ffcc33"));
        this.f6654r = g4.d.a(zZcINlcxH, 10.0f, i6);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        this.f6655s = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f6656t = g4.d.a(zZcINlcxH, 12.0f, i6);
        this.f6650n.addView(this.f6651o, new LinearLayout.LayoutParams(-2, -2));
        this.f6650n.addView(this.f6652p, new LinearLayout.LayoutParams(g4.i.r(16.0f), g4.i.r(16.0f)));
        addView(this.f6649m, new LinearLayout.LayoutParams(0, -2, 4.0f));
        addView(this.f6650n, new LinearLayout.LayoutParams(0, -1, 3.0f));
        addView(this.f6653q, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(this.f6654r, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(this.f6655s, new LinearLayout.LayoutParams(0, -2, 3.0f));
        this.f6655s.addView(this.f6656t, new LinearLayout.LayoutParams(-2, -2));
        this.f6658v = com.secret.prettyhezi.controls.u.a(new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.ic_right_arrow), 7, 13);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = g4.i.r(6.0f);
        addView(this.f6658v, layoutParams);
        setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        setOnClickListener(new a(zZcINlcxH));
        this.f6650n.setOnClickListener(new b(zZcINlcxH));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015c  */
    @Override // com.secret.prettyhezi.View.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.secret.prettyhezi.Server.n nVar) {
        boolean z5;
        String str;
        TextView textView;
        int i6;
        q qVar = (q) nVar;
        this.f6659w = qVar.number_id;
        String str2 = qVar.number_no;
        this.f6660x = str2;
        this.f6649m.setText(str2);
        if (qVar.vote_content.indexOf(b.j.N0) > 0) {
            String[] split = qVar.vote_content.split("\\|");
            if (split.length == 4) {
                this.f6652p.setVisibility(0);
                this.f6650n.setEnabled(true);
                this.f6651o.setText(split[0]);
                z5 = false;
                if (z5) {
                    this.f6652p.setVisibility(8);
                    this.f6650n.setEnabled(false);
                    this.f6651o.setText(qVar.vote_content);
                }
                this.f6653q.setText(qVar.vote_integral + HttpUrl.FRAGMENT_ENCODE_SET);
                str = qVar.open_award;
                if (!str.isEmpty()) {
                    str = "--";
                } else if (qVar.award_result.length() == 3) {
                    str = str + "(" + qVar.award_result + ")";
                }
                this.f6654r.setText(str);
                this.f6656t.setText(qVar.bonus + HttpUrl.FRAGMENT_ENCODE_SET);
                if (qVar.bonus <= 0) {
                    textView = this.f6656t;
                    i6 = Color.parseColor("#ffcc00");
                } else {
                    textView = this.f6656t;
                    i6 = f6648y;
                }
                textView.setTextColor(i6);
                if (qVar.bonus_state != 1) {
                    setEnabled(true);
                    this.f6658v.setVisibility(0);
                } else {
                    setEnabled(false);
                    this.f6658v.setVisibility(4);
                    this.f6656t.setText("--");
                }
                if (qVar.cancel == -1) {
                    this.f6656t.setText("已撤");
                    this.f6656t.setTextColor(Color.parseColor("#f00000"));
                }
                if (qVar.is_cancel == 1) {
                    TextView textView2 = this.f6657u;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    this.f6656t.setVisibility(0);
                    return;
                }
                TextView textView3 = this.f6657u;
                if (textView3 == null) {
                    TextView b6 = g4.d.b(g4.i.j(), 14.0f, -1, "撤单");
                    this.f6657u = b6;
                    b6.setGravity(17);
                    this.f6657u.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
                    this.f6655s.addView(this.f6657u, new LinearLayout.LayoutParams(g4.i.r(60.0f), -1));
                    this.f6657u.setOnClickListener(new c(qVar));
                } else {
                    textView3.setVisibility(0);
                }
                this.f6656t.setVisibility(8);
                return;
            }
        }
        z5 = true;
        if (z5) {
        }
        this.f6653q.setText(qVar.vote_integral + HttpUrl.FRAGMENT_ENCODE_SET);
        str = qVar.open_award;
        if (!str.isEmpty()) {
        }
        this.f6654r.setText(str);
        this.f6656t.setText(qVar.bonus + HttpUrl.FRAGMENT_ENCODE_SET);
        if (qVar.bonus <= 0) {
        }
        textView.setTextColor(i6);
        if (qVar.bonus_state != 1) {
        }
        if (qVar.cancel == -1) {
        }
        if (qVar.is_cancel == 1) {
        }
    }

    void r() {
        HFqjgQ hFqjgQ = (HFqjgQ) g4.i.j();
        hFqjgQ.I0();
        com.secret.prettyhezi.j.q(i.a() + "order/cancel/json?ids=" + ((q) this.f8044i).id, i.f6608a.token.token, 3, new d(hFqjgQ, hFqjgQ));
    }
}
