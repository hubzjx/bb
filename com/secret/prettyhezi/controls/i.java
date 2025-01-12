package com.secret.prettyhezi.controls;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class i extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    z f8352b;

    /* renamed from: c  reason: collision with root package name */
    boolean f8353c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f8354d;

    /* renamed from: e  reason: collision with root package name */
    com.secret.prettyhezi.e f8355e;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            i iVar = i.this;
            iVar.b(!iVar.f8353c, null);
        }
    }

    public i(Context context, String str) {
        super(context);
        this.f8353c = false;
        this.f8352b = new z(context, C0382R.drawable.ic_dropdown);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(20.0f), g4.i.r(20.0f));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.rightMargin = g4.i.r(4.0f);
        addView(this.f8352b, layoutParams);
        TextView c6 = g4.d.c(context, 16, -16777216, str, 17);
        this.f8354d = c6;
        addView(c6, new RelativeLayout.LayoutParams(-1, -1));
        setBackground(g4.i.d(g4.i.c(0, 5.0f, -7829368, 1.0f), g4.i.c(-3355444, 5.0f, -7829368, 1.0f)));
        setOnClickListener(new a());
        b(false, str);
    }

    public void a(com.secret.prettyhezi.e eVar) {
        this.f8355e = eVar;
    }

    public void b(boolean z5, String str) {
        this.f8353c = z5;
        this.f8352b.setRotation(z5 ? 180.0f : 0.0f);
        if (str != null) {
            this.f8354d.setText(str);
        }
        com.secret.prettyhezi.e eVar = this.f8355e;
        if (eVar != null) {
            eVar.a(z5 ? 1 : 0);
        }
    }
}
