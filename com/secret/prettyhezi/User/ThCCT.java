package com.secret.prettyhezi.User;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import java.io.IOException;
/* loaded from: classes.dex */
public class ThCCT extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7684r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7685s;

    /* renamed from: t  reason: collision with root package name */
    com.secret.prettyhezi.controls.d f7686t;

    /* renamed from: u  reason: collision with root package name */
    TextView f7687u;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            ThCCT.this.S0();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            ThCCT.this.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {
        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g, com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            super.a(iOException);
            ThCCT.this.k0();
        }

        @Override // com.secret.prettyhezi.s.g, com.secret.prettyhezi.j.e
        public void b(int i6) {
            super.b(i6);
            ThCCT.this.k0();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code != 200) {
                f(pVar.err);
                return;
            }
            MainApplication.f6711r.A(pVar.data);
            EjNkL.N.f6165r.j();
            if (ThCCT.this.isFinishing() || ThCCT.this.isDestroyed()) {
                return;
            }
            ThCCT.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f7691a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7692b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7693c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String[] f7694d;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ThCCT.this.finish();
            }
        }

        d(x xVar, String str, String str2, String[] strArr) {
            this.f7691a = xVar;
            this.f7692b = str;
            this.f7693c = str2;
            this.f7694d = strArr;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (ThCCT.this.j(this.f7691a)) {
                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#000000"));
                paint.setTextSize(48.0f);
                paint.setAntiAlias(true);
                Bitmap createBitmap = Bitmap.createBitmap(480, 400, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(-1);
                canvas.drawText(this.f7692b, 100.0f, 80.0f, paint);
                canvas.drawText(this.f7693c, 100.0f, 160.0f, paint);
                paint.setTextSize(30.0f);
                paint.setColor(Color.parseColor("#0000ff"));
                paint.setTextSize(60.0f);
                canvas.drawText("BeautyBox", 100.0f, 330.0f, paint);
                ThCCT.this.l(createBitmap, "你的照片已保存");
                ThCCT.this.f7684r.postDelayed(new a(), ThCCT.this.p0(this.f7694d) ? 1000L : 5000L);
            }
        }
    }

    void S0() {
        U0(g4.g.a().e(), g4.g.a().f());
    }

    void T0() {
        String trim = this.f7686t.getText().toString().trim();
        I0();
        v.A(trim, new c(this));
    }

    void U0(String str, String str2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView c6 = g4.d.c(this, 16, -16777216, str, 17);
        TextView c7 = g4.d.c(this, 16, -16777216, str2, 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, g4.i.r(40.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, g4.i.r(40.0f));
        linearLayout.addView(c6, layoutParams);
        linearLayout.addView(c7, layoutParams2);
        TextView c8 = g4.d.c(this, 20, -16776961, "BeautyBox", 17);
        linearLayout.addView(c8, new LinearLayout.LayoutParams(-2, g4.i.r(60.0f)));
        c8.setVisibility(8);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        TextView c9 = g4.d.c(this, 14, Color.parseColor("#333333"), "请注意保存好你的账号密码照片，点击确认，将会保存你的账号密码图片到相册", 17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = g4.i.r(20.0f);
        linearLayout2.addView(c9, layoutParams3);
        x xVar = new x(this);
        xVar.e(linearLayout2);
        xVar.d(new String[]{s0(C0382R.string.ok)}, new d(xVar, str, str2, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}));
        x(xVar, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7684r = C0;
        C0.setBackgroundColor(Color.parseColor("#aaaaaa"));
        N(this.f7684r, s0(C0382R.string.NickName), "跳过", new a()).removeViewAt(0);
        LinearLayout e6 = e(this.f7684r);
        this.f7685s = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        this.f7685s.setBackgroundColor(Color.parseColor("#aaaaaa"));
        this.f7685s.setGravity(1);
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7686t = dVar;
        dVar.setMaxLength(10);
        this.f7686t.f8305c.setText(MainApplication.f6711r.r().nickname);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(48.0f));
        int r5 = g4.i.r(20.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        this.f7685s.addView(this.f7686t, layoutParams);
        TextView U = U(this.f7685s, s0(C0382R.string.Save), 0, 40);
        this.f7687u = U;
        U.setOnClickListener(new b());
    }
}
