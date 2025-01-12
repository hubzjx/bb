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
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.NbWDzx1XT;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class If7AjsI extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    TextView f7553r;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            If7AjsI.this.W0();
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH) {
        if (T0()) {
            zZcINlcxH.M0(If7AjsI.class);
        }
    }

    public static boolean T0() {
        long d6 = g4.g.a().d("keyLastShowAccountAndPassword", 0);
        return d6 == 0 || ((System.currentTimeMillis() / 1000) / 60) - d6 > 4320;
    }

    public static void U0() {
        g4.g.a().n("keyLastShowAccountAndPassword", (int) ((System.currentTimeMillis() / 1000) / 60));
    }

    LinearLayout V0(String str) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(g4.d.b(this, 14.0f, -16777216, str), new LinearLayout.LayoutParams(g4.i.r(100.0f), -2));
        return linearLayout;
    }

    void W0() {
        String str = s0(C0382R.string.Account) + ":" + g4.g.a().e();
        String str2 = s0(C0382R.string.Password) + ":" + g4.g.a().f();
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
        paint.setTextSize(48.0f);
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(480, (Math.max(str.length(), str2.length()) * 30) + 240), 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.drawText(str, 80.0f, 80.0f, paint);
        canvas.drawText(str2, 80.0f, 160.0f, paint);
        paint.setColor(Color.parseColor("#0000ff"));
        paint.setTextSize(50.0f);
        canvas.drawText("BeautyBox", 80.0f, 330.0f, paint);
        l(createBitmap, "你的账号已保存相册");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        U0();
        LinearLayout C0 = C0();
        M(C0, s0(C0382R.string.AccountAndPassword));
        C0.setGravity(1);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        C0.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        String e6 = g4.g.a().e();
        String f6 = g4.g.a().f();
        LinearLayout V0 = V0(s0(C0382R.string.Account) + ":");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        linearLayout.addView(V0, layoutParams);
        V0.addView(g4.d.b(this, 14.0f, -16777216, e6), new LinearLayout.LayoutParams(-2, -2));
        LinearLayout V02 = V0(s0(C0382R.string.Password) + ":");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = g4.i.r(20.0f);
        linearLayout.addView(V02, layoutParams2);
        V02.addView(g4.d.b(this, 14.0f, -16777216, f6), new LinearLayout.LayoutParams(-2, -2));
        TextView U = U(C0, s0(C0382R.string.CaptureScreenAndSave), 30, 50);
        this.f7553r = U;
        U.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (g4.g.a().c().length() <= 0 || System.currentTimeMillis() - MainApplication.f6711r.f6729o <= 10000) {
            return;
        }
        NbWDzx1XT.R0(this, false);
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    protected boolean t0() {
        return false;
    }
}
