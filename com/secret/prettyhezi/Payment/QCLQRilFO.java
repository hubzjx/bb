package com.secret.prettyhezi.Payment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.f;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class QCLQRilFO extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6821r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f6822s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6823t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (QCLQRilFO.this.isDestroyed() || QCLQRilFO.this.isFinishing()) {
                return;
            }
            c cVar = (c) f.d(str, c.class);
            if (cVar.code != 200) {
                s.d(QCLQRilFO.this, cVar.err);
                return;
            }
            d.f6827a = cVar.data;
            QCLQRilFO.this.U0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6825d;

        b(int i6) {
            this.f6825d = i6;
        }

        @Override // g4.f
        protected void a(View view) {
            QCLQRilFO.this.O0(JokZC.class, 0, this.f6825d);
        }
    }

    void S0(int i6, int i7) {
        String str;
        String str2;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(i.r(10.0f), i.r(15.0f), i.r(8.0f), i.r(15.0f));
        linearLayout.setGravity(16);
        linearLayout.setBackground(i.f(0, Color.parseColor("#f0f0f0")));
        z zVar = new z(this, d.c(i6));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(24.0f), i.r(24.0f));
        layoutParams.rightMargin = i.r(6.0f);
        linearLayout.addView(zVar, layoutParams);
        TextView b6 = g4.d.b(this, 20.0f, -16777216, d.b(i6));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = i.r(6.0f);
        linearLayout.addView(b6, layoutParams2);
        if (i7 == 0) {
            str = "(未设置)";
            str2 = "添加";
        } else if (i7 == 1) {
            str = "(已停用)";
            str2 = "启用";
        } else if (i7 == 2) {
            str = "(已设置)";
            str2 = "修改";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linearLayout.addView(g4.d.b(this, 14.0f, i7 == 2 ? -16711936 : -65536, str), new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView b7 = g4.d.b(this, 14.0f, Color.parseColor("#333333"), str2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = i.r(6.0f);
        linearLayout.addView(b7, layoutParams3);
        linearLayout.addView(new z(this, C0382R.drawable.ic_right_arrow), new LinearLayout.LayoutParams(i.r(7.0f), i.r(14.0f)));
        this.f6823t.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOnClickListener(new b(i6));
    }

    void T0() {
        G0();
        j.m(v.f7132a + "user/payment/json?ac=list", new a(this));
    }

    void U0() {
        W(this.f6823t, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
        S0(1, d.d(1));
        W(this.f6823t, Color.parseColor("#cccccc"), 0.5f, 8, 0, 0);
        S0(2, d.d(2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6821r = C0;
        this.f6822s = M(C0, "收款方式设置");
        LinearLayout e6 = e(this.f6821r);
        this.f6823t = e6;
        e6.setGravity(1);
        this.f6823t.setBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f6823t.removeAllViews();
        T0();
    }
}
