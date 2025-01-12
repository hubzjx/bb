package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class a0 extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f7844b;

    /* renamed from: c  reason: collision with root package name */
    View f7845c;

    /* renamed from: d  reason: collision with root package name */
    int f7846d;

    /* renamed from: e  reason: collision with root package name */
    int f7847e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7848f;

    /* renamed from: g  reason: collision with root package name */
    private com.secret.prettyhezi.controls.y f7849g;

    /* renamed from: h  reason: collision with root package name */
    LinearLayout f7850h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f7851i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f7852j;

    public a0(ZZcINlcxH zZcINlcxH, String str) {
        super(zZcINlcxH);
        this.f7846d = Color.parseColor("#333333");
        int parseColor = Color.parseColor("#666666");
        this.f7847e = parseColor;
        this.f7848f = false;
        this.f7849g = null;
        this.f7850h = null;
        this.f7851i = null;
        this.f7852j = null;
        TextView b6 = g4.d.b(zZcINlcxH, 16.0f, parseColor, str);
        this.f7844b = b6;
        b6.setId(1011);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        addView(this.f7844b, layoutParams);
        this.f7845c = new View(zZcINlcxH);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, g4.i.r(2.0f));
        layoutParams2.addRule(12, -1);
        this.f7845c.setBackgroundColor(this.f7846d);
        addView(this.f7845c, layoutParams2);
        setBackground(g4.i.f(0, Color.parseColor("#f0f0f0")));
    }

    public int a() {
        com.secret.prettyhezi.controls.y yVar = this.f7849g;
        if (yVar == null) {
            return 0;
        }
        return yVar.a();
    }

    public void b(boolean z5) {
        this.f7848f = z5;
        this.f7844b.setTextColor(z5 ? this.f7846d : this.f7847e);
        this.f7845c.setVisibility(z5 ? 0 : 8);
    }

    public void c(String str) {
        TextView textView = this.f7852j;
        if (textView != null) {
            textView.setText(str);
            return;
        }
        f();
        this.f7852j = g4.d.c(getContext(), 12, -65536, str, 17);
        this.f7850h.addView(this.f7852j, 0, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    public void d(int i6) {
        if (this.f7849g == null) {
            this.f7849g = new com.secret.prettyhezi.controls.y(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(20.0f));
            layoutParams.addRule(13, -1);
            layoutParams.leftMargin = g4.i.r(1.0f);
            layoutParams.addRule(1, this.f7844b.getId());
            addView(this.f7849g, layoutParams);
        }
        this.f7849g.b(i6);
    }

    public void e(String str) {
        TextView textView = this.f7851i;
        if (textView != null) {
            textView.setText(str);
            return;
        }
        f();
        this.f7851i = g4.d.c(getContext(), 12, -65536, str, 17);
        this.f7850h.addView(this.f7851i, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    void f() {
        if (this.f7850h == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f7850h = linearLayout;
            linearLayout.setOrientation(0);
            this.f7850h.setGravity(5);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            addView(this.f7850h, layoutParams);
        }
    }
}
