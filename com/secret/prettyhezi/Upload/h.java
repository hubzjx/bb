package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class h extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    private ZZcINlcxH f7463m;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f7464n;

    /* renamed from: o  reason: collision with root package name */
    private com.secret.prettyhezi.controls.r f7465o;

    /* renamed from: p  reason: collision with root package name */
    private com.secret.prettyhezi.Server.h f7466p;

    public h(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
        this.f7463m = zZcINlcxH;
        setGravity(1);
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f7464n = relativeLayout;
        addView(relativeLayout, new LinearLayout.LayoutParams(i6, 100));
        com.secret.prettyhezi.controls.r rVar = new com.secret.prettyhezi.controls.r(zZcINlcxH, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f7465o = rVar;
        rVar.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f7464n.addView(this.f7465o, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        this.f7466p = (com.secret.prettyhezi.Server.h) nVar;
        this.f7465o.setBackgroundColor(Color.parseColor("#cccccc"));
        com.secret.prettyhezi.Server.l lVar = this.f7466p.co;
        this.f7465o.b(lVar.f7128p);
        this.f8037b = (lVar.f7127h * this.f8039d) / lVar.f7129w;
        this.f7464n.setLayoutParams(new LinearLayout.LayoutParams(this.f8039d, this.f8037b));
    }
}
