package com.secret.prettyhezi.message;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.y;
/* loaded from: classes.dex */
public class b extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f8692b;

    /* renamed from: c  reason: collision with root package name */
    TextView f8693c;

    /* renamed from: d  reason: collision with root package name */
    y f8694d;

    /* renamed from: e  reason: collision with root package name */
    com.secret.prettyhezi.message.a f8695e;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8696d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f8696d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            ZZcINlcxH zZcINlcxH = this.f8696d;
            com.secret.prettyhezi.message.a aVar = b.this.f8695e;
            AWsQxAQ.S0(zZcINlcxH, 5, aVar.id, -1, aVar.name);
        }
    }

    public b(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8692b = zZcINlcxH;
        setOrientation(1);
        setBackground(g4.i.d(g4.i.b(-1, 4.0f), g4.i.b(Color.parseColor("#cccccc"), 4.0f)));
        setPadding(g4.i.r(8.0f), g4.i.r(10.0f), g4.i.r(8.0f), g4.i.r(10.0f));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, g4.i.r(6.0f), 0, g4.i.r(6.0f));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView a6 = g4.d.a(zZcINlcxH, 14.0f, -16777216);
        this.f8693c = a6;
        linearLayout.addView(a6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f8694d = new y(zZcINlcxH);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(20.0f));
        layoutParams.leftMargin = g4.i.r(4.0f);
        linearLayout.addView(this.f8694d, layoutParams);
        setOnClickListener(new a(zZcINlcxH));
    }

    public void a(com.secret.prettyhezi.message.a aVar) {
        this.f8695e = aVar;
        this.f8693c.setText(aVar.name);
        this.f8694d.b(aVar.msgs);
    }
}
