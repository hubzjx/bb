package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class l extends com.secret.prettyhezi.View.u {

    /* renamed from: w  reason: collision with root package name */
    static final int f6614w = Color.parseColor("#333333");

    /* renamed from: m  reason: collision with root package name */
    TextView f6615m;

    /* renamed from: n  reason: collision with root package name */
    LinearLayout f6616n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6617o;

    /* renamed from: p  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f6618p;

    /* renamed from: q  reason: collision with root package name */
    TextView f6619q;

    /* renamed from: r  reason: collision with root package name */
    TextView f6620r;

    /* renamed from: s  reason: collision with root package name */
    View f6621s;

    /* renamed from: t  reason: collision with root package name */
    com.secret.prettyhezi.controls.u f6622t;

    /* renamed from: u  reason: collision with root package name */
    int f6623u;

    /* renamed from: v  reason: collision with root package name */
    String f6624v;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6625d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6625d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6625d.N0(HFqjgQ.class, l.this.f6623u);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6627d;

        b(ZZcINlcxH zZcINlcxH) {
            this.f6627d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            String[] split = ((k) ((com.secret.prettyhezi.View.u) l.this).f8044i).vote_content.split("\\|");
            if (split.length == 4) {
                this.f6627d.E(split[0], (("\n下注：" + split[1]) + "\n注数：" + split[2]) + "      倍数：" + split[3], null, true);
            }
        }
    }

    public l(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f8037b = g4.i.r(32.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        setOrientation(0);
        setGravity(16);
        int i6 = f6614w;
        this.f6615m = g4.d.a(zZcINlcxH, 10.0f, i6);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        this.f6616n = linearLayout;
        linearLayout.setGravity(16);
        this.f6616n.setOrientation(0);
        this.f6617o = g4.d.a(zZcINlcxH, 10.0f, i6);
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.ic_dropdown);
        this.f6618p = zVar;
        zVar.setAlpha(0.8f);
        this.f6619q = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#ffcc33"));
        this.f6620r = g4.d.a(zZcINlcxH, 10.0f, i6);
        View view = new View(zZcINlcxH);
        this.f6621s = view;
        View a6 = com.secret.prettyhezi.controls.u.a(view, 14, 14);
        this.f6616n.addView(this.f6617o, new LinearLayout.LayoutParams(-2, -2));
        this.f6616n.addView(this.f6618p, new LinearLayout.LayoutParams(g4.i.r(16.0f), g4.i.r(16.0f)));
        addView(this.f6615m, new LinearLayout.LayoutParams(0, -2, 4.0f));
        addView(this.f6616n, new LinearLayout.LayoutParams(0, -1, 3.0f));
        addView(this.f6619q, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(this.f6620r, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(a6, new LinearLayout.LayoutParams(0, -2, 3.0f));
        this.f6622t = com.secret.prettyhezi.controls.u.a(new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.ic_right_arrow), 7, 13);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = g4.i.r(6.0f);
        addView(this.f6622t, layoutParams);
        setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        setOnClickListener(new a(zZcINlcxH));
        this.f6616n.setOnClickListener(new b(zZcINlcxH));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    @Override // com.secret.prettyhezi.View.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.secret.prettyhezi.Server.n nVar) {
        boolean z5;
        k kVar = (k) nVar;
        this.f6623u = kVar.order_id;
        String str = kVar.number_no;
        this.f6624v = str;
        this.f6615m.setText(str);
        if (kVar.vote_content.indexOf(b.j.N0) > 0) {
            String[] split = kVar.vote_content.split("\\|");
            if (split.length == 4) {
                this.f6618p.setVisibility(0);
                this.f6616n.setEnabled(true);
                this.f6617o.setText(split[0]);
                z5 = false;
                if (z5) {
                    this.f6618p.setVisibility(8);
                    this.f6616n.setEnabled(false);
                    this.f6617o.setText(kVar.vote_content);
                }
                TextView textView = this.f6619q;
                textView.setText(kVar.vote_integral + HttpUrl.FRAGMENT_ENCODE_SET);
                this.f6620r.setText(kVar.speed);
                this.f6621s.setBackground(g4.i.b(kVar.is_bonus_stop != 1 ? -16711936 : -7829368, 7.0f));
            }
        }
        z5 = true;
        if (z5) {
        }
        TextView textView2 = this.f6619q;
        textView2.setText(kVar.vote_integral + HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6620r.setText(kVar.speed);
        this.f6621s.setBackground(g4.i.b(kVar.is_bonus_stop != 1 ? -16711936 : -7829368, 7.0f));
    }
}
