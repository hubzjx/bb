package com.secret.prettyhezi.message;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class f extends u {

    /* renamed from: m  reason: collision with root package name */
    private ZZcINlcxH f8706m;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f8707n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f8708o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f8709p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f8710q;

    /* renamed from: r  reason: collision with root package name */
    public e f8711r;

    /* renamed from: s  reason: collision with root package name */
    private int f8712s;

    public f(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f8706m = zZcINlcxH;
        setBackground(null);
        setPadding(g4.i.r(12.0f), g4.i.r(2.0f), g4.i.r(12.0f), g4.i.r(2.0f));
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f8707n = relativeLayout;
        relativeLayout.setPadding(g4.i.r(8.0f), g4.i.r(6.0f), g4.i.r(8.0f), g4.i.r(6.0f));
        addView(this.f8707n, new LinearLayout.LayoutParams(-1, -2));
        TextView a6 = g4.d.a(zZcINlcxH, 12.0f, -16777216);
        this.f8709p = a6;
        a6.setGravity(16);
        this.f8709p.setSingleLine();
        this.f8707n.addView(this.f8709p, new RelativeLayout.LayoutParams(-2, g4.i.r(24.0f)));
        TextView a7 = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#888888"));
        this.f8710q = a7;
        a7.setGravity(16);
        this.f8710q.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(24.0f));
        layoutParams.addRule(11, -1);
        this.f8707n.addView(this.f8710q, layoutParams);
        this.f8708o = g4.d.a(zZcINlcxH, 18.0f, -16777216);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = g4.i.r(28.0f);
        this.f8707n.addView(this.f8708o, layoutParams2);
        this.f8707n.setBackground(g4.i.d(g4.i.b(-1, u.f8036l), g4.i.b(Color.parseColor("#cccccc"), u.f8036l)));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        String str;
        e eVar = (e) nVar;
        this.f8711r = eVar;
        this.f8708o.setText(eVar.GetText());
        TextView textView = this.f8709p;
        String str2 = this.f8711r.sender_share;
        if (str2 == null || str2.length() <= 0) {
            str = HttpUrl.FRAGMENT_ENCODE_SET + this.f8711r.sender;
        } else {
            str = this.f8711r.sender_share;
        }
        textView.setText(str);
        TextView textView2 = this.f8710q;
        e eVar2 = this.f8711r;
        long j6 = eVar2.updated_at;
        if (j6 <= 0) {
            j6 = eVar2.created_at;
        }
        textView2.setText(g4.i.v(j6));
        measure(View.MeasureSpec.makeMeasureSpec(this.f8706m.o().x, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f8712s = getMeasuredHeight();
    }

    @Override // com.secret.prettyhezi.View.u
    public int getItemHeight() {
        return this.f8712s;
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f8707n;
    }
}
