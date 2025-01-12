package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class MKY2nH extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6705r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6706s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f6707d;

        a(e eVar) {
            this.f6707d = eVar;
        }

        @Override // g4.f
        public void a(View view) {
            MKY2nH mKY2nH = MKY2nH.this;
            e eVar = this.f6707d;
            Ghv8lE.T0(mKY2nH, eVar.name, eVar.url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {
        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            d dVar = (d) f.d(str, d.class);
            if (dVar.code == 200) {
                MKY2nH.this.U0(dVar.data);
            } else {
                f(dVar.err);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6710a;

        c(int i6) {
            this.f6710a = i6;
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            d dVar = (d) f.d(str, d.class);
            dVar.version = this.f6710a;
            g4.g.a().o("keyAboutCt", f.e(dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends com.secret.prettyhezi.Server.w {
        e[] data;
        int version;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements Serializable {
        public String name;
        public String url;
        public String value;

        e() {
        }
    }

    public static void S0() {
        String h6 = g4.g.a().h("keyAboutCt", HttpUrl.FRAGMENT_ENCODE_SET);
        int i6 = h6.length() > 0 ? ((d) f.d(h6, d.class)).version : 0;
        int i7 = MainApplication.f6711r.k().sys.about;
        if (i7 > i6) {
            j.q(com.secret.prettyhezi.Server.v.f7133b + "about", null, 0, new c(i7));
        }
    }

    void T0() {
        j.q(com.secret.prettyhezi.Server.v.f7133b + "about", null, 0, new b(this));
    }

    void U0(e[] eVarArr) {
        this.f6706s.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        for (e eVar : eVarArr) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
            linearLayout.setGravity(16);
            this.f6706s.addView(linearLayout, layoutParams);
            linearLayout.addView(g4.d.b(this, 16.0f, -16777216, eVar.name), new LinearLayout.LayoutParams(0, -2, 1.0f));
            linearLayout.addView(g4.d.b(this, 14.0f, -16777216, eVar.value), new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setBackground(g4.i.f(0, Color.parseColor("#a0a0a0")));
            linearLayout.setOnClickListener(new a(eVar));
            W(this.f6706s, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
        }
    }

    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6705r = C0;
        M(C0, s0(C0382R.string.About));
        LinearLayout e6 = e(this.f6705r);
        this.f6706s = e6;
        e6.setGravity(1);
        String h6 = g4.g.a().h("keyAboutCt", HttpUrl.FRAGMENT_ENCODE_SET);
        if (h6.length() > 0) {
            d dVar = (d) f.d(h6, d.class);
            U0(dVar.data);
            if (MainApplication.f6711r.k().sys.about <= dVar.version) {
                return;
            }
        }
        T0();
    }
}
