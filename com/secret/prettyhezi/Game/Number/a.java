package com.secret.prettyhezi.Game.Number;

import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.controls.t;
/* loaded from: classes.dex */
public class a extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    com.secret.prettyhezi.controls.c f6331b;

    /* renamed from: c  reason: collision with root package name */
    t f6332c;

    /* renamed from: com.secret.prettyhezi.Game.Number.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0079a implements com.secret.prettyhezi.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.e f6333a;

        C0079a(com.secret.prettyhezi.e eVar) {
            this.f6333a = eVar;
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            a.this.f6331b.setEnabled(i6 > 1);
            a.this.f6331b.setVisibility(i6 <= 1 ? 4 : 0);
            this.f6333a.a(i6);
        }
    }

    public a(POjTJ pOjTJ, com.secret.prettyhezi.e eVar) {
        super(pOjTJ);
        setPadding(g4.i.r(1.0f), 0, g4.i.r(8.0f), 0);
        setOrientation(0);
        setGravity(16);
        com.secret.prettyhezi.controls.c cVar = new com.secret.prettyhezi.controls.c(pOjTJ, "中奖即停");
        this.f6331b = cVar;
        cVar.setSelected(false);
        this.f6331b.setVisibility(4);
        addView(this.f6331b, new LinearLayout.LayoutParams(0, -2, 1.0f));
        View c6 = g4.d.c(pOjTJ, 12, -65536, String.format("(限追%d期)", Integer.valueOf(pOjTJ.M.buy_num)), 16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.rightMargin = g4.i.r(4.0f);
        addView(c6, layoutParams);
        float f6 = 14;
        addView(g4.d.b(pOjTJ, f6, -16777216, "追"), new LinearLayout.LayoutParams(-2, -2));
        this.f6332c = new t(pOjTJ, pOjTJ.M.buy_num);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, g4.i.r(30.0f));
        int r5 = g4.i.r(2.0f);
        layoutParams2.rightMargin = r5;
        layoutParams2.leftMargin = r5;
        addView(this.f6332c, layoutParams2);
        this.f6332c.b(new C0079a(eVar));
        addView(g4.d.b(pOjTJ, f6, -16777216, "期"), new LinearLayout.LayoutParams(-2, -2));
    }

    public int a() {
        return this.f6332c.a();
    }

    public boolean b() {
        return this.f6331b.isSelected();
    }

    public void c(int i6) {
        this.f6332c.c(i6);
    }
}
