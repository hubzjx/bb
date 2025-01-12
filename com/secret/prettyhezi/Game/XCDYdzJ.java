package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class XCDYdzJ extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6545r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6546s;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            XCDYdzJ.this.M0(YmPvPjhN.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {
        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            c cVar = (c) com.secret.prettyhezi.f.d(str, c.class);
            if (cVar.code == 200) {
                XCDYdzJ.this.S0(cVar.data);
            } else {
                XCDYdzJ.this.w0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c extends com.secret.prettyhezi.Server.w {
        public b0[] data;

        c() {
        }
    }

    void S0(b0[] b0VarArr) {
        this.f6546s.removeAllViews();
        if (b0VarArr == null || b0VarArr.length == 0) {
            this.f6546s.addView(g4.d.c(this, 16, -16777216, "暂无夺宝，敬请期待", 17), new LinearLayout.LayoutParams(-1, g4.i.r(200.0f)));
            return;
        }
        for (b0 b0Var : b0VarArr) {
            this.f6546s.addView(new d0(this, b0Var), new LinearLayout.LayoutParams(-1, -2));
            Q(this.f6546s, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
        }
    }

    void T0() {
        I0();
        com.secret.prettyhezi.j.q(i.a() + "loot/index/json", i.f6608a.token.token, 3, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6545r = C0;
        N(C0, "夺宝游戏", "我的夺宝", new a());
        this.f6545r.setBackgroundColor(-1);
        V(this.f6545r, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(this.f6545r);
        this.f6546s = e6;
        e6.setGravity(1);
        this.f6546s.setPadding(0, 0, 0, g4.i.r(40.0f));
        this.f6546s.setBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        T0();
    }
}
