package com.secret.prettyhezi.share.digital;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Ghv8lE;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.k;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.digital.WuXLOHsS;
import g4.i;
/* loaded from: classes.dex */
public class JqUSUBK extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    public int f8939r;

    /* renamed from: s  reason: collision with root package name */
    com.secret.prettyhezi.share.digital.d f8940s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f8941t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f8942u;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f8943v = null;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            JqUSUBK.this.M0(P1o1yR.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.share.digital.JqUSUBK$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0145a implements s.f {
                C0145a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    JqUSUBK.this.finish();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                j.r(v.f7132a + "tron/json", new f(JqUSUBK.this.f8939r, "e"), true, new s.e(JqUSUBK.this, new C0145a()));
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            JqUSUBK.this.C("取消会影响诚信值，多次取消可能导致取消数字货币权限", new String[]{"暂不取消", "取消交易"}, new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.share.digital.JqUSUBK$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0146a extends s.g {

                /* renamed from: com.secret.prettyhezi.share.digital.JqUSUBK$c$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0147a extends ZZcINlcxH.q {
                    C0147a() {
                    }

                    @Override // com.secret.prettyhezi.ZZcINlcxH.q
                    public void b() {
                        JqUSUBK.this.finish();
                    }
                }

                C0146a(ZZcINlcxH zZcINlcxH) {
                    super(zZcINlcxH);
                }

                @Override // com.secret.prettyhezi.s.g
                public void g(String str) {
                    WuXLOHsS.h hVar = (WuXLOHsS.h) com.secret.prettyhezi.f.d(str, WuXLOHsS.h.class);
                    if (hVar.code != 200) {
                        if (hVar.err.equals("TryLater")) {
                            hVar.err = "系统未查到到账信息，若已支付，请稍后点击已支付按钮查询";
                        }
                        f(hVar.err);
                        return;
                    }
                    com.secret.prettyhezi.share.digital.d dVar = hVar.data;
                    if (dVar.status != 1) {
                        JqUSUBK jqUSUBK = JqUSUBK.this;
                        jqUSUBK.f8940s = dVar;
                        jqUSUBK.U0();
                        return;
                    }
                    JqUSUBK jqUSUBK2 = JqUSUBK.this;
                    jqUSUBK2.f8940s = dVar;
                    jqUSUBK2.U0();
                    JqUSUBK.this.D("系统已收到币，交易完成，请查看积分变化", new C0147a(), false);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                j.r(v.f7132a + "tron/json", new f(JqUSUBK.this.f8939r, "f"), true, new C0146a(JqUSUBK.this));
            }
        }

        c() {
        }

        @Override // g4.f
        protected void a(View view) {
            JqUSUBK.this.B("已支付USDT到给定的地址？\n虚假操作会导致惩罚后果", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f8952a;

        d(TextView textView) {
            this.f8952a = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (JqUSUBK.this.isDestroyed() || JqUSUBK.this.isFinishing()) {
                return;
            }
            JqUSUBK.this.AnimateZoomOut(this.f8952a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {
        e(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            WuXLOHsS.h hVar = (WuXLOHsS.h) com.secret.prettyhezi.f.d(str, WuXLOHsS.h.class);
            if (hVar.code != 200) {
                f(hVar.err);
                return;
            }
            JqUSUBK jqUSUBK = JqUSUBK.this;
            jqUSUBK.f8940s = hVar.data;
            jqUSUBK.U0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f extends k {
        public int xb;

        public f(int i6, String str) {
            super(str);
            this.xb = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        String f8955a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Bitmap f8957d;

            a(Bitmap bitmap) {
                this.f8957d = bitmap;
            }

            @Override // g4.f
            public void a(View view) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f8957d.getWidth(), (int) (this.f8957d.getHeight() * 1.25d), Bitmap.Config.ARGB_8888);
                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#ff0000"));
                paint.setTextSize(this.f8957d.getWidth() / 13);
                paint.setAntiAlias(true);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(-1);
                canvas.drawBitmap(this.f8957d, 0.0f, 0.0f, paint);
                canvas.drawText("USDT(泰达币)钱包地址", (int) (this.f8957d.getWidth() * 0.12d), (int) (this.f8957d.getHeight() * 1.1d), paint);
                JqUSUBK.this.k(createBitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends g4.f {
            b() {
            }

            @Override // g4.f
            public void a(View view) {
                String p5 = MainApplication.f6711r.p(17);
                JqUSUBK jqUSUBK = JqUSUBK.this;
                Ghv8lE.S0(jqUSUBK, "支付帮助", p5 + "coin/pay.html");
            }
        }

        public g(String str) {
            this.f8955a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            return com.secret.prettyhezi.share.a.b(this.f8955a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            JqUSUBK.this.j0();
            JqUSUBK.this.f8943v.removeAllViews();
            View view = new View(JqUSUBK.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(200.0f), i.r(200.0f));
            int r5 = i.r(20.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            JqUSUBK.this.f8943v.addView(view, 0, layoutParams);
            view.setBackground(new BitmapDrawable(bitmap));
            TextView q5 = com.secret.prettyhezi.ScoreExchange.e.q(JqUSUBK.this, "保存钱包图片到相册以便识别");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i.r(240.0f), i.r(42.0f));
            layoutParams2.bottomMargin = i.r(16.0f);
            JqUSUBK.this.f8943v.addView(q5, layoutParams2);
            q5.setOnClickListener(new a(bitmap));
            TextView q6 = com.secret.prettyhezi.ScoreExchange.e.q(JqUSUBK.this, "支付帮助");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i.r(240.0f), i.r(42.0f));
            layoutParams3.bottomMargin = i.r(16.0f);
            JqUSUBK.this.f8943v.addView(q6, layoutParams3);
            q6.setOnClickListener(new b());
            JqUSUBK jqUSUBK = JqUSUBK.this;
            if (jqUSUBK.f8940s.status == 0) {
                jqUSUBK.f8943v.addView(g4.d.c(jqUSUBK, 14, -65536, "请在下单后30分钟内付款\n否则系统自动取消本次交易", 17), new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    void S0(String str, long j6, double d6) {
        TextView b6 = g4.d.b(this, 12.0f, -16777216, str + i.v(j6));
        b6.setPadding(0, i.r(10.0f), 0, 0);
        this.f8942u.addView(b6, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8942u.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(g4.d.b(this, 12.0f, -65536, "USDT价格:" + i.C(1.0d / d6) + "人民币"), new LinearLayout.LayoutParams(i.r(130.0f), -2));
    }

    void T0() {
        j.r(v.f7132a + "tron/json", new f(this.f8939r, "d"), true, new e(this));
    }

    void U0() {
        this.f8942u.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(16);
        this.f8942u.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView b6 = g4.d.b(this, 16.0f, -16777216, "可兑换积分： " + i.C(this.f8940s.score0));
        b6.setPadding(0, i.r(6.0f), 0, i.r(2.0f));
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(-1, -2));
        TextView b7 = g4.d.b(this, 16.0f, -65536, "约需USDT：" + i.C(this.f8940s.amount0));
        b7.setPadding(0, i.r(2.0f), 0, i.r(6.0f));
        linearLayout2.addView(b7, new LinearLayout.LayoutParams(-1, -2));
        StringBuilder sb = new StringBuilder();
        sb.append("估算的币是根据下单时的币的价格计算：\n(");
        sb.append(i.C(this.f8940s.score0));
        sb.append("/100)/");
        sb.append(i.C(1.0d / this.f8940s.cny0));
        sb.append("=");
        com.secret.prettyhezi.share.digital.d dVar = this.f8940s;
        sb.append(i.C((dVar.score0 / 100.0d) * dVar.cny0));
        String sb2 = sb.toString();
        com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f();
        fVar.a(sb2 + "\n由于币的价格波动，", -7829368, 14.0f);
        fVar.a("收到币后系统会根据即时价格计算出积分", -65536, 14.0f);
        TextView b8 = g4.d.b(this, 14.0f, -7829368, sb2);
        b8.setText(fVar.f8321d);
        b8.setPadding(0, 0, 0, i.r(10.0f));
        this.f8942u.addView(b8, new LinearLayout.LayoutParams(-1, -2));
        if (this.f8940s.amount1 > 0.0d) {
            TextView b9 = g4.d.b(this, 16.0f, -65536, "实付USDT：" + i.C(this.f8940s.amount1));
            b9.setPadding(0, i.r(2.0f), 0, i.r(2.0f));
            this.f8942u.addView(b9, new LinearLayout.LayoutParams(-1, -2));
            TextView b10 = g4.d.b(this, 16.0f, -16777216, "实购积分： " + i.C(this.f8940s.score1));
            b10.setPadding(0, i.r(6.0f), 0, i.r(2.0f));
            this.f8942u.addView(b10, new LinearLayout.LayoutParams(-1, -2));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("实购积分是根据付款时的币的价格计算：\n");
            sb3.append(i.C(1.0d / this.f8940s.cny1));
            sb3.append("x");
            sb3.append(i.C(this.f8940s.amount1));
            sb3.append("x100=");
            com.secret.prettyhezi.share.digital.d dVar2 = this.f8940s;
            sb3.append(i.C((dVar2.amount1 * 100.0d) / dVar2.cny1));
            TextView b11 = g4.d.b(this, 14.0f, -7829368, sb3.toString());
            b11.setPadding(0, 0, 0, i.r(10.0f));
            this.f8942u.addView(b11, new LinearLayout.LayoutParams(-1, -2));
        }
        com.secret.prettyhezi.share.digital.d dVar3 = this.f8940s;
        S0("下单时间:", dVar3.created_at, dVar3.cny0);
        com.secret.prettyhezi.share.digital.d dVar4 = this.f8940s;
        if (dVar4.status == 1) {
            S0("成交时间:", dVar4.updated_at, dVar4.cny1);
        }
        com.secret.prettyhezi.share.digital.d dVar5 = this.f8940s;
        if (dVar5.status == 0) {
            TextView q5 = com.secret.prettyhezi.ScoreExchange.e.q(this, "取消");
            q5.setTextColor(-65536);
            linearLayout.addView(q5, new LinearLayout.LayoutParams(i.r(80.0f), i.r(36.0f)));
            q5.setOnClickListener(new b());
        } else {
            TextView q6 = com.secret.prettyhezi.ScoreExchange.e.q(this, dVar5.StatusName());
            q6.setTextColor(-1);
            q6.setBackground(i.b(Color.parseColor("#666666"), 5.0f));
            linearLayout.addView(q6, new LinearLayout.LayoutParams(i.r(80.0f), i.r(36.0f)));
        }
        int i6 = this.f8940s.status;
        if (i6 != 0) {
            if (i6 == 1) {
                new LinearLayout.LayoutParams(-1, -2).topMargin = i.r(20.0f);
                return;
            }
            return;
        }
        TextView q7 = com.secret.prettyhezi.ScoreExchange.e.q(this, "已支付");
        q7.setTextColor(-65536);
        q7.setOnClickListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(200.0f), i.r(40.0f));
        layoutParams.topMargin = i.r(12.0f);
        this.f8942u.addView(q7, layoutParams);
        int parseColor = Color.parseColor("#333333");
        TextView b12 = g4.d.b(this, 16.0f, parseColor, "TRC20-USDT钱包地址：\n" + this.f8940s.address);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i.r(20.0f);
        layoutParams2.bottomMargin = i.r(10.0f);
        this.f8942u.addView(b12, layoutParams2);
        TextView c6 = g4.d.c(this, 14, -65536, "充值地址动态生成，请每次转币前核对地址", 17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = i.r(10.0f);
        this.f8942u.addView(c6, layoutParams3);
        AnimateZoomOut(c6);
        c6.postDelayed(new d(c6), 3000L);
        this.f8942u.addView(h("点击复制USDT钱包地址", this.f8940s.address));
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.f8943v = linearLayout3;
        linearLayout3.setOrientation(1);
        this.f8943v.setGravity(1);
        this.f8942u.addView(this.f8943v, new LinearLayout.LayoutParams(-1, -2));
        J0("正在加载钱包二维码");
        new g(this.f8940s.address).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8939r = extras.getInt("id");
        }
        LinearLayout C0 = C0();
        this.f8941t = C0;
        N(C0, "兑换详情", "兑换说明", new a());
        LinearLayout e6 = e(this.f8941t);
        this.f8942u = e6;
        e6.setGravity(1);
        this.f8942u.setPadding(i.r(12.0f), i.r(10.0f), i.r(12.0f), i.r(20.0f));
        this.f8942u.setPadding(i.r(12.0f), i.r(12.0f), i.r(12.0f), i.r(20.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        I0();
        T0();
    }
}
