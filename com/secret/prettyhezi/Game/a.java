package com.secret.prettyhezi.Game;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class a extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f6555b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6556c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f6557d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6558e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6559f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f6560g;

    /* renamed from: com.secret.prettyhezi.Game.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0084a implements View.OnClickListener {
        View$OnClickListenerC0084a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.c(false);
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.c(true);
        }
    }

    public a(ZZcINlcxH zZcINlcxH, String str, String str2) {
        super(zZcINlcxH);
        setOrientation(0);
        setGravity(17);
        TextView b6 = g4.d.b(zZcINlcxH, 14.0f, -16777216, str);
        this.f6555b = b6;
        addView(b6, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        this.f6557d = linearLayout;
        linearLayout.setOrientation(0);
        this.f6557d.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int r5 = g4.i.r(8.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        addView(this.f6557d, layoutParams);
        this.f6557d.setBackground(g4.i.b(-16777216, 5.0f));
        TextView c6 = g4.d.c(zZcINlcxH, 18, -1, "--", 17);
        this.f6559f = c6;
        this.f6557d.addView(c6, new LinearLayout.LayoutParams(g4.i.r(42.0f), -2));
        EditText editText = new EditText(zZcINlcxH);
        this.f6560g = editText;
        editText.setGravity(17);
        this.f6560g.setTextColor(-16777216);
        this.f6560g.setTextSize(20.0f);
        this.f6560g.setBackgroundColor(-1);
        this.f6560g.setInputType(2);
        com.secret.prettyhezi.controls.j.a(this.f6560g, 4, 2);
        this.f6560g.setPadding(0, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(66.0f), -1);
        int r6 = g4.i.r(1.0f);
        layoutParams2.bottomMargin = r6;
        layoutParams2.topMargin = r6;
        this.f6557d.addView(this.f6560g, layoutParams2);
        TextView c7 = g4.d.c(zZcINlcxH, 18, -1, k5.d.ANY_NON_NULL_MARKER, 17);
        this.f6558e = c7;
        this.f6557d.addView(c7, new LinearLayout.LayoutParams(g4.i.r(42.0f), -2));
        TextView b7 = g4.d.b(zZcINlcxH, 14.0f, -16777216, str2);
        this.f6556c = b7;
        addView(b7, new LinearLayout.LayoutParams(-2, -2));
        this.f6559f.setOnClickListener(new View$OnClickListenerC0084a());
        this.f6558e.setOnClickListener(new b());
        b();
    }

    public int a() {
        int parseInt = Integer.parseInt(this.f6560g.getText().toString().trim());
        if (parseInt <= 0) {
            return 0;
        }
        return parseInt;
    }

    public void b() {
        this.f6560g.setText("1");
    }

    void c(boolean z5) {
        int parseInt;
        String trim = this.f6560g.getText().toString().trim();
        int i6 = 0;
        if (!trim.isEmpty() && (parseInt = Integer.parseInt(trim)) > 0) {
            i6 = parseInt;
        }
        if (z5 || i6 > 1) {
            int i7 = i6 + (z5 ? 1 : -1);
            EditText editText = this.f6560g;
            editText.setText(HttpUrl.FRAGMENT_ENCODE_SET + i7);
        }
    }
}
