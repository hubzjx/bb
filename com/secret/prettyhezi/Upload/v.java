package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Upload.u;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.WOqyeiK;
/* loaded from: classes.dex */
public class v extends com.secret.prettyhezi.Upload.a {

    /* renamed from: n  reason: collision with root package name */
    RelativeLayout f7512n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0 f7513d;

        a(d0 d0Var) {
            this.f7513d = d0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            d0 d0Var = this.f7513d;
            String[] strArr = d0Var.ps;
            if (strArr == null || strArr.length <= 0) {
                MSqCZ2mQ.T0(v.this.f7437l, d0Var.f7110me.f7128p, 0, 0, 0L);
            } else {
                WOqyeiK.T0(v.this.f7437l, strArr, d0Var.f7110me.f7128p);
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends com.secret.prettyhezi.Server.w {
        public u.a data;

        b() {
        }
    }

    public v(KLNPK klnpk, int i6, boolean z5) {
        super(klnpk, i6, z5);
    }

    @Override // com.secret.prettyhezi.Upload.a
    protected void d() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f7437l);
        this.f7512n = relativeLayout;
        addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // com.secret.prettyhezi.Upload.a
    protected void g(String str) {
        b bVar = (b) com.secret.prettyhezi.f.d(str, b.class);
        if (bVar.code == 200) {
            u.a aVar = bVar.data;
            d0 d0Var = aVar.data;
            k(d0Var.id, d0Var.ct, aVar.label, aVar.content, d0Var.na, d0Var.mt, d0Var.cl);
            l(d0Var);
        } else if (bVar.err.equals("Empty")) {
            h();
        } else {
            com.secret.prettyhezi.s.d(this.f7437l, bVar.err);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r4 > r0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void l(d0 d0Var) {
        int i6 = this.f7437l.o().x;
        int maxContentHeight = getMaxContentHeight();
        com.secret.prettyhezi.Server.l lVar = d0Var.co;
        int i7 = lVar.f7129w;
        int i8 = lVar.f7127h;
        int i9 = (i7 * maxContentHeight) / i8;
        int i10 = (i8 * i6) / i7;
        if (i10 <= maxContentHeight) {
            maxContentHeight = i10;
        }
        i6 = i9;
        this.f7512n.setLayoutParams(new LinearLayout.LayoutParams(i6, maxContentHeight));
        this.f7512n.addView(new com.secret.prettyhezi.controls.r(this.f7437l, d0Var.co.f7128p), new RelativeLayout.LayoutParams(i6, maxContentHeight));
        LinearLayout linearLayout = new LinearLayout(this.f7437l);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#33000000"));
        linearLayout.setPadding(g4.i.r(2.0f), 0, g4.i.r(2.0f), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
        layoutParams.addRule(11, -1);
        this.f7512n.addView(linearLayout, layoutParams);
        linearLayout.addView(new com.secret.prettyhezi.controls.z(this.f7437l, C0382R.drawable.ic_duration), new LinearLayout.LayoutParams(g4.i.r(18.0f), g4.i.r(18.0f)));
        linearLayout.addView(g4.d.b(this.f7437l, 12.0f, -1, g4.i.G(d0Var.dur)), new LinearLayout.LayoutParams(-2, -2));
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this.f7437l, C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams2.addRule(13, -1);
        this.f7512n.addView(zVar, layoutParams2);
        this.f7512n.setOnClickListener(new a(d0Var));
    }
}
