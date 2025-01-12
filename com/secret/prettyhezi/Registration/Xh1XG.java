package com.secret.prettyhezi.Registration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class Xh1XG extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6943r;

    /* renamed from: s  reason: collision with root package name */
    e f6944s;

    /* renamed from: t  reason: collision with root package name */
    boolean f6945t = false;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            Xh1XG.this.M0(EXLrpMw8U.class);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            Xh1XG xh1XG = Xh1XG.this;
            xh1XG.f6945t = true;
            xh1XG.M0(PFqTwYaD.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6943r = C0;
        C0.setGravity(1);
        N(this.f6943r, "注册码", "已使用", new a());
        TextView c6 = g4.d.c(this, 16, -1, "兑换注册码", 17);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f)));
        c6.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(40.0f));
        int r5 = g4.i.r(12.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        this.f6943r.addView(c6, layoutParams);
        e eVar = new e(this, 1);
        this.f6944s = eVar;
        this.f6943r.addView(eVar, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f6945t) {
            this.f6945t = false;
            this.f6944s.p(true, 0L);
        }
    }
}
