package com.secret.prettyhezi.Registration;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class ZsblHj3O extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6948r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6949s;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            g4.g.a().n("buyCodeExampleRead", 1);
            ZsblHj3O.this.finish();
        }
    }

    public static boolean S0() {
        return g4.g.a().d("buyCodeExampleRead", 0) == 1;
    }

    void T0(LinearLayout linearLayout, int i6) {
        View view = new View(this);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i6);
        int r5 = o().x - g4.i.r(24.0f);
        view.setBackgroundResource(i6);
        decodeResource.recycle();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r5, (decodeResource.getHeight() * r5) / decodeResource.getWidth());
        layoutParams.bottomMargin = g4.i.r(6.0f);
        linearLayout.addView(view, layoutParams);
    }

    void U0() {
        LinearLayout Y0 = Y0("第一步：选择卖家买入");
        TextView a6 = g4.d.a(this, 16.0f, Color.parseColor("#333333"));
        a6.setText("每个订单标识了付款方式，价格和发布时间， 排最前面的是最近刚发布的，说明卖家越有可能还在使用App，能及时确认成交，请选择自己方便的支付方式。");
        Y0.addView(a6, new LinearLayout.LayoutParams(-1, -2));
        T0(Y0, C0382R.drawable.buy_code_step1);
    }

    void V0() {
        LinearLayout Y0 = Y0("第二步：扫码支付");
        TextView a6 = g4.d.a(this, 16.0f, Color.parseColor("#333333"));
        a6.setText("根据卖家的收款方式，扫卖家微信或支付宝收款码，支付订单的准确金额给卖家。点击“支付方式”按钮，可以显示和隐藏卖家收款码，可以通过保存收款码到相册，然后通过微信或支付宝识别收款码付款。");
        Y0.addView(a6, new LinearLayout.LayoutParams(-1, -2));
    }

    void W0() {
        LinearLayout Y0 = Y0("第三步：点击已付款");
        TextView a6 = g4.d.a(this, 16.0f, Color.parseColor("#333333"));
        a6.setText("支付成功后，点击已付款按钮，等待卖家确认收到款。");
        Y0.addView(a6, new LinearLayout.LayoutParams(-1, -2));
        T0(Y0, C0382R.drawable.buy_step2);
    }

    void X0() {
        LinearLayout Y0 = Y0("第四步：与卖家沟通分歧");
        TextView a6 = g4.d.a(this, 16.0f, Color.parseColor("#333333"));
        a6.setText("若卖方表示未收到款，可以先与卖家沟通，出示更多的支付凭证或信息，如沟通无法解决问题，可以“申请仲裁”，如果确认自己未付款成功，可以点击“我未付款”按钮取消订单。");
        Y0.addView(a6, new LinearLayout.LayoutParams(-1, -2));
        T0(Y0, C0382R.drawable.buy_step4);
    }

    LinearLayout Y0(String str) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        this.f6949s.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(this, 18, -16777216, str, 17);
        c6.setPadding(0, 0, 0, g4.i.r(4.0f));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6948r = C0;
        M(C0, "买注册码流程");
        LinearLayout e6 = e(this.f6948r);
        this.f6949s = e6;
        e6.setPadding(0, 0, 0, g4.i.r(20.0f));
        U0();
        V0();
        W0();
        X0();
        U(this.f6949s, "我已阅读", 12, 30).setOnClickListener(new a());
    }
}
