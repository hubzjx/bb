package com.secret.prettyhezi.Upload;

import android.widget.LinearLayout;
import com.secret.prettyhezi.Upload.s;
/* loaded from: classes.dex */
public class t extends com.secret.prettyhezi.Upload.a {

    /* renamed from: n  reason: collision with root package name */
    LinearLayout f7510n;

    /* renamed from: o  reason: collision with root package name */
    com.secret.prettyhezi.controls.a f7511o;

    /* loaded from: classes.dex */
    static class a extends com.secret.prettyhezi.Server.w {
        public s.a data;

        a() {
        }
    }

    public t(KLNPK klnpk, int i6, boolean z5) {
        super(klnpk, i6, z5);
        this.f7511o = null;
    }

    @Override // com.secret.prettyhezi.Upload.a
    protected void d() {
        LinearLayout linearLayout = new LinearLayout(this.f7437l);
        this.f7510n = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, getMaxContentHeight()));
    }

    @Override // com.secret.prettyhezi.Upload.a
    protected void g(String str) {
        a aVar = (a) com.secret.prettyhezi.f.d(str, a.class);
        if (aVar.code == 200) {
            s.a aVar2 = aVar.data;
            com.secret.prettyhezi.Server.t tVar = aVar2.data;
            k(tVar.id, tVar.ct, aVar2.label, aVar2.content, tVar.na, tVar.mt, tVar.cl);
            l(tVar);
        } else if (aVar.err.equals("Empty")) {
            h();
        } else {
            com.secret.prettyhezi.s.d(this.f7437l, aVar.err);
        }
    }

    void l(com.secret.prettyhezi.Server.t tVar) {
        com.secret.prettyhezi.controls.a aVar = this.f7511o;
        if (aVar != null) {
            aVar.a();
        }
        this.f7510n.removeAllViews();
        com.secret.prettyhezi.controls.a aVar2 = new com.secret.prettyhezi.controls.a(this.f7437l, -1, -1, tVar.images(), null);
        this.f7511o = aVar2;
        this.f7510n.addView(aVar2, new LinearLayout.LayoutParams(-1, getMaxContentHeight()));
    }
}
