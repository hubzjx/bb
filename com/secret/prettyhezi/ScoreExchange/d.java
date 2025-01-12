package com.secret.prettyhezi.ScoreExchange;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.message.AWsQxAQ;
import g4.i;
/* loaded from: classes.dex */
public class d extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    boolean f7066b;

    /* renamed from: c  reason: collision with root package name */
    com.secret.prettyhezi.ScoreExchange.b f7067c;

    /* renamed from: d  reason: collision with root package name */
    AWsQxAQ f7068d;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            d.this.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        View f7070b;

        /* renamed from: c  reason: collision with root package name */
        Bitmap f7071c;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ d f7073d;

            a(d dVar) {
                this.f7073d = dVar;
            }

            @Override // g4.f
            protected void a(View view) {
                b bVar = b.this;
                if (bVar.f7071c == null) {
                    d.this.f7068d.H("请等待收款码加载完成");
                } else {
                    bVar.a();
                }
            }
        }

        public b(String str, int i6) {
            super(d.this.f7068d);
            this.f7071c = null;
            setOrientation(1);
            setGravity(1);
            this.f7070b = new View(d.this.f7068d);
            addView(this.f7070b, new LinearLayout.LayoutParams(i6, i6));
            new c(str, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            AWsQxAQ aWsQxAQ = d.this.f7068d;
            addView(g4.d.c(aWsQxAQ, 10, -65536, "金额：" + i.B(d.this.f7067c.price) + "元", 17), new LinearLayout.LayoutParams(-1, -2));
            View c6 = g4.d.c(d.this.f7068d, 12, -1, "保存收款码到相册", 17);
            c6.setBackground(i.e(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            c6.setOnClickListener(new a(d.this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(120.0f), i.r(36.0f));
            layoutParams.topMargin = i.r(6.0f);
            layoutParams.bottomMargin = i.r(8.0f);
            addView(c6, layoutParams);
        }

        void a() {
            Bitmap createBitmap = Bitmap.createBitmap(this.f7071c.getWidth(), (int) (this.f7071c.getHeight() * 1.2d), Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#ff0000"));
            paint.setTextSize(this.f7071c.getWidth() / 12);
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(this.f7071c, 0.0f, 0.0f, paint);
            canvas.drawText(i.v(d.this.f7067c.create_time) + "      " + (d.this.f7067c.price + "元"), (int) (this.f7071c.getWidth() * 0.06d), (int) (this.f7071c.getHeight() * 1.08d), paint);
            d.this.f7068d.l(createBitmap, "收款码已保存到相册");
        }
    }

    /* loaded from: classes.dex */
    class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        String f7075a;

        /* renamed from: b  reason: collision with root package name */
        b f7076b;

        public c(String str, b bVar) {
            this.f7075a = str;
            this.f7076b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            return com.secret.prettyhezi.share.a.a(this.f7075a, BitmapFactory.decodeResource(d.this.getResources(), com.secret.prettyhezi.Payment.a.b(this.f7075a) ? C0382R.drawable.wx : C0382R.drawable.ali));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            b bVar = this.f7076b;
            bVar.f7071c = bitmap;
            bVar.f7070b.setBackground(new BitmapDrawable(bitmap));
        }
    }

    public d(AWsQxAQ aWsQxAQ, com.secret.prettyhezi.ScoreExchange.b bVar, boolean z5) {
        super(aWsQxAQ);
        StringBuilder sb;
        String str;
        String[] strArr;
        this.f7068d = aWsQxAQ;
        this.f7066b = z5;
        this.f7067c = bVar;
        setGravity(1);
        setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(aWsQxAQ);
        relativeLayout.setBackgroundColor(Color.parseColor("#333333"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.r(36.0f));
        layoutParams.bottomMargin = i.r(4.0f);
        addView(relativeLayout, layoutParams);
        String str2 = "请扫码支付" + i.B(bVar.price) + "元";
        if (z5) {
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("购买");
            sb.append(bVar.amount);
            str = "积分";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = "购买注册码";
        }
        sb.append(str);
        TextView b6 = g4.d.b(aWsQxAQ, 14.0f, -65536, sb.toString());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        relativeLayout.addView(b6, layoutParams2);
        TextView c6 = g4.d.c(aWsQxAQ, 14, -65536, "X", 17);
        c6.setBackground(i.c(-1, 14.0f, -65536, 1.0f));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i.r(28.0f), i.r(28.0f));
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = i.r(6.0f);
        layoutParams3.addRule(11, -1);
        relativeLayout.addView(c6, layoutParams3);
        relativeLayout.setOnClickListener(new a());
        LinearLayout linearLayout = new LinearLayout(aWsQxAQ);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        String[] strArr2 = bVar.paycode;
        if (strArr2 != null && strArr2.length > 0) {
            int i6 = 0;
            for (String str3 : strArr2) {
                if (com.secret.prettyhezi.Payment.a.b(str3) || com.secret.prettyhezi.Payment.a.a(str3)) {
                    i6++;
                }
            }
            if (i6 > 0) {
                int r5 = i.r(10.0f);
                int i7 = aWsQxAQ.o().x;
                int i8 = i6 + 1;
                int i9 = (i7 - (r5 * i8)) / i6;
                int r6 = i.r(120.0f);
                if (i9 > r6) {
                    r5 = (i7 - (r6 * i6)) / i8;
                    i9 = r6;
                }
                for (String str4 : bVar.paycode) {
                    if (com.secret.prettyhezi.Payment.a.b(str4) || com.secret.prettyhezi.Payment.a.a(str4)) {
                        b bVar2 = new b(str4, i9);
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i9, -2);
                        layoutParams4.leftMargin = r5;
                        if (i6 == 1 || linearLayout.getChildCount() == 1) {
                            layoutParams4.rightMargin = r5;
                        }
                        linearLayout.addView(bVar2, layoutParams4);
                    }
                }
            } else {
                linearLayout.addView(g4.d.c(aWsQxAQ, 14, -65536, "无支付信息，请联系卖家用其他方式支付", 17), new LinearLayout.LayoutParams(-1, i.r(40.0f)));
            }
        }
        if (bVar.status != 1) {
            setVisibility(8);
        }
    }
}
