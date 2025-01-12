package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Yzg4R57AT;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    TextView f6583m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6584n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6585o;

    /* renamed from: p  reason: collision with root package name */
    int f6586p;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6587d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6587d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6587d.O0(Yzg4R57AT.class, e.this.f6586p, 1);
        }
    }

    public e(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setOrientation(0);
        setGravity(17);
        this.f8037b = g4.i.r(40.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        setBackground(g4.i.f(-1, Color.parseColor("#eeeeee")));
        this.f6583m = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f6585o = g4.d.a(zZcINlcxH, 12.0f, -65536);
        this.f6583m.setSingleLine();
        this.f6584n = g4.d.c(zZcINlcxH, 12, Color.parseColor("#888888"), HttpUrl.FRAGMENT_ENCODE_SET, 5);
        addView(this.f6583m, new LinearLayout.LayoutParams(g4.i.r(100.0f), -2));
        addView(this.f6585o, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.f6584n, new LinearLayout.LayoutParams(g4.i.r(90.0f), -2));
        setOnClickListener(new a(zZcINlcxH));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        d dVar = (d) nVar;
        this.f6583m.setText(dVar.nickname);
        this.f6584n.setText(g4.i.x(dVar.created_at));
        this.f6585o.setText(dVar.bonus);
        this.f6586p = dVar.user_id;
    }
}
