package com.secret.prettyhezi.controls;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class c extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f8302b;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            c cVar = c.this;
            cVar.setSelected(!cVar.isSelected());
        }
    }

    public c(Context context, int i6, int i7, String str) {
        super(context);
        setOrientation(0);
        setGravity(16);
        View view = new View(context);
        this.f8302b = view;
        view.setBackground(g4.i.a(i6, i7));
        addView(this.f8302b, new LinearLayout.LayoutParams(g4.i.r(36.0f), g4.i.r(36.0f)));
        if (str != null && !str.isEmpty()) {
            View b6 = g4.d.b(context, 14.0f, -16777216, str);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = g4.i.r(1.0f);
            addView(b6, layoutParams);
        }
        setOnClickListener(new a());
    }

    public c(Context context, String str) {
        this(context, C0382R.drawable.check_normal, C0382R.drawable.check_checked, str);
    }
}
