package com.secret.prettyhezi.share.digital;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Ghv8lE;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import g4.f;
import g4.i;
/* loaded from: classes.dex */
public class P1o1yR extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8969r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8970s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8971d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f8972e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f8973f;

        a(ZZcINlcxH zZcINlcxH, String str, String str2) {
            this.f8971d = zZcINlcxH;
            this.f8972e = str;
            this.f8973f = str2;
        }

        @Override // g4.f
        public void a(View view) {
            Ghv8lE.S0(this.f8971d, this.f8972e, this.f8973f);
        }
    }

    public static LinearLayout S0(ZZcINlcxH zZcINlcxH) {
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.addView(g4.d.b(zZcINlcxH, 14.0f, Color.parseColor("#333333"), "TRC20-USDT兑换积分说明：\n\n1.单次兑换数量为万的整数倍积分，具体积分数量以数字货币到账时刻即时汇率计算为准；\n2.数字货币只接受泰达币/USDT（只接收TRC20，不接收ERC20）；\n3.必须拥有数字货币（开通币安，火币或者OK账号获取TRC20-USDT币）；\n4.申请权限需要花费500积分，不论是否通过申请，积分不退，请谨慎申请；\n5.数字货币兑换的积分可以在积分交易中心出售为人民币，也可以用来兑换系统权限和消费；\n6.为了保证系统平衡，每日积分兑换有限额，兑完即止。\n\n\n\n积分兑换TRC20-USDT说明：\n\n1.单次兑换数量为100的整数倍USDT，具体积分数量以审核通过时刻即时汇率计算为准；\n2.数字货币只支持泰达币/USDT（只支持TRC20，不支持ERC20）；\n3.必须拥有数字货币账号（开通币安，火币或者OK账号获取USDT币）；\n4.申请权限需要花费500积分，不论是否通过申请，积分不退，请谨慎申请；\n5.每次兑换USDT需要支付1USDT转账手续费； \n6.为了保证系统平衡，每日USDT兑换有限额，兑完即止。\n"), new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setGravity(17);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, i.r(60.0f)));
        String str = MainApplication.f6711r.p(17) + "coin/index.html";
        linearLayout2.addView(T0(zZcINlcxH, "如何开通火币", str, 0, 10));
        linearLayout2.addView(T0(zZcINlcxH, "如何开通币安", str, 0, 0));
        linearLayout2.addView(T0(zZcINlcxH, "如何开OK币", str, 10, 0));
        return linearLayout;
    }

    public static TextView T0(ZZcINlcxH zZcINlcxH, String str, String str2, int i6, int i7) {
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, str, 17);
        c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#000000"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(90.0f), i.r(32.0f));
        layoutParams.leftMargin = i.r(i6);
        layoutParams.rightMargin = i.r(i7);
        c6.setLayoutParams(layoutParams);
        c6.setOnClickListener(new a(zZcINlcxH, str, str2));
        return c6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f8969r = C0;
        M(C0, "USDT兑换说明");
        LinearLayout e6 = e(this.f8969r);
        this.f8970s = e6;
        e6.setGravity(1);
        this.f8970s.setPadding(i.r(12.0f), i.r(10.0f), i.r(12.0f), i.r(20.0f));
        this.f8970s.addView(S0(this), new LinearLayout.LayoutParams(-1, -2));
    }
}
