package com.secret.prettyhezi;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.share.KQHNLjV;
/* loaded from: classes.dex */
public class p extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f8744b;

    /* renamed from: c  reason: collision with root package name */
    ZZcINlcxH f8745c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8746d;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            p.this.f8745c.M0(KQHNLjV.class);
        }
    }

    public p(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8746d = false;
        this.f8745c = zZcINlcxH;
        setOrientation(0);
        setGravity(16);
        if (MainApplication.f6711r.a()) {
            View a6 = a(zZcINlcxH);
            addView(a6);
            a6.setOnClickListener(new a());
        }
        TextView b6 = g4.d.b(zZcINlcxH, 14.0f, -1, k5.d.ANY_NON_NULL_MARKER + zZcINlcxH.s0(C0382R.string.follow));
        this.f8744b = b6;
        b6.setGravity(17);
        this.f8744b.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(68.0f), g4.i.r(30.0f));
        layoutParams.rightMargin = g4.i.r(18.0f);
        addView(this.f8744b, layoutParams);
    }

    static z a(ZZcINlcxH zZcINlcxH) {
        z zVar = new z(zZcINlcxH, C0382R.drawable.ic_share);
        int r5 = g4.i.r(8.0f);
        zVar.setPadding(r5, r5, r5, r5);
        zVar.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#cccccc"), 4.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
        layoutParams.rightMargin = g4.i.r(12.0f);
        zVar.setLayoutParams(layoutParams);
        return zVar;
    }

    public void b(boolean z5) {
        String str;
        this.f8746d = z5;
        this.f8744b.setBackground(!z5 ? g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)) : g4.i.d(g4.i.b(Color.parseColor("#aa0000"), 4.0f), g4.i.b(Color.parseColor("#dd0000"), 4.0f)));
        TextView textView = this.f8744b;
        if (z5) {
            str = this.f8745c.s0(C0382R.string.followed);
        } else {
            str = k5.d.ANY_NON_NULL_MARKER + this.f8745c.s0(C0382R.string.follow);
        }
        textView.setText(str);
    }
}
