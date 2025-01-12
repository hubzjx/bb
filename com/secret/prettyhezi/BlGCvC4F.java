package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.User.Ticket.Alv5GBDA;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.KQHNLjV;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class BlGCvC4F extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6011r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.secret.prettyhezi.Server.n {
        public String content;
        boolean expanded = false;
        public String name;

        a() {
        }
    }

    /* loaded from: classes.dex */
    public class b extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public class a implements Serializable {
            public a[] items;
            public int pages;
            public int total;

            public a() {
            }
        }

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends com.secret.prettyhezi.View.u {

        /* renamed from: m  reason: collision with root package name */
        a f6012m;

        /* renamed from: n  reason: collision with root package name */
        TextView f6013n;

        /* renamed from: o  reason: collision with root package name */
        WebView f6014o;

        /* renamed from: p  reason: collision with root package name */
        z f6015p;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ BlGCvC4F f6017d;

            a(BlGCvC4F blGCvC4F) {
                this.f6017d = blGCvC4F;
            }

            @Override // g4.f
            public void a(View view) {
                c cVar = c.this;
                if (cVar.f6012m.expanded) {
                    cVar.p();
                } else {
                    cVar.q();
                }
                a aVar = c.this.f6012m;
                aVar.expanded = !aVar.expanded;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends WebViewClient {
            b() {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                BlGCvC4F blGCvC4F;
                Class cls;
                if (!str.startsWith("app://")) {
                    Ghv8lE.S0(c.this.getContext(), "详情", str);
                    return true;
                } else if (str.equals("app://mycards")) {
                    if (MainApplication.f6711r.r() != null) {
                        blGCvC4F = BlGCvC4F.this;
                        cls = Alv5GBDA.class;
                        blGCvC4F.M0(cls);
                        return true;
                    }
                    BlGCvC4F.this.M0(TK1dGVzP.class);
                    return true;
                } else if (str.equals("app://share")) {
                    if (MainApplication.f6711r.r() != null) {
                        blGCvC4F = BlGCvC4F.this;
                        cls = KQHNLjV.class;
                        blGCvC4F.M0(cls);
                        return true;
                    }
                    BlGCvC4F.this.M0(TK1dGVzP.class);
                    return true;
                } else if (!str.equals("app://rrvideo_status2") && !str.equals("app://rrvideo_status3")) {
                    str.equals("app://upuser");
                    return true;
                } else {
                    str.equals("app://rrvideo_status3");
                    ZZcINlcxH x02 = BlGCvC4F.this.x0();
                    if (x02 instanceof EjNkL) {
                        BlGCvC4F.this.finish();
                        ((EjNkL) x02).j1(5, -1);
                        return true;
                    }
                    return true;
                }
            }
        }

        public c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH, 0);
            setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), 6);
            LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            this.f6013n = g4.d.c(zZcINlcxH, 18, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
            this.f6015p = new z(zZcINlcxH, C0382R.drawable.ic_dropdown);
            linearLayout.addView(this.f6013n, new LinearLayout.LayoutParams(0, -2, 1.0f));
            this.f6013n.setPadding(g4.i.r(0.0f), g4.i.r(6.0f), 0, g4.i.r(6.0f));
            linearLayout.addView(this.f6015p, new LinearLayout.LayoutParams(g4.i.r(20.0f), g4.i.r(20.0f)));
            linearLayout.setOnClickListener(new a(BlGCvC4F.this));
        }

        @Override // com.secret.prettyhezi.View.u
        public void a(com.secret.prettyhezi.Server.n nVar) {
            a aVar = (a) nVar;
            this.f6012m = aVar;
            this.f6013n.setText(aVar.name);
            if (this.f6012m.expanded) {
                q();
            } else {
                p();
            }
        }

        void p() {
            WebView webView = this.f6014o;
            if (webView != null) {
                removeView(webView);
                this.f6014o = null;
                this.f6015p.setRotation(0.0f);
            }
        }

        void q() {
            if (this.f6014o == null) {
                WebView webView = new WebView(BlGCvC4F.this);
                this.f6014o = webView;
                webView.setBackgroundColor(Color.parseColor("#f0f0f0"));
                this.f6014o.setWebViewClient(new b());
                this.f6014o.setVerticalScrollBarEnabled(false);
                this.f6014o.loadData(this.f6012m.content, "text/html; charset=UTF-8", null);
                addView(this.f6014o, new LinearLayout.LayoutParams(-1, -2));
                this.f6015p.setRotation(180.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends com.secret.prettyhezi.controls.PullToRefresh.h {

        /* loaded from: classes.dex */
        class a extends s.g {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f6020b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ZZcINlcxH zZcINlcxH, int i6) {
                super(zZcINlcxH);
                this.f6020b = i6;
            }

            @Override // com.secret.prettyhezi.s.g
            public void f(String str) {
                super.f(str);
                d.this.X();
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                b bVar = (b) f.d(str, b.class);
                if (bVar.code != 200) {
                    f(bVar.err);
                    return;
                }
                d dVar = d.this;
                b.a aVar = bVar.data;
                dVar.h0(aVar.items, aVar.pages > this.f6020b);
            }
        }

        public d() {
            super(BlGCvC4F.this);
            this.f8262y.setDividerHeight(g4.i.r(0.5f));
            this.f8262y.setBackgroundColor(-1);
            W();
            V("暂无数据");
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        public void b0(int i6) {
            j.q(com.secret.prettyhezi.Server.v.f7133b + "fq?page=" + i6, null, 4, new a(BlGCvC4F.this, i6));
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        public boolean d0() {
            return true;
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        /* renamed from: i0 */
        public c Y(View view, a aVar) {
            c cVar;
            if (view == null || !(view instanceof c)) {
                BlGCvC4F blGCvC4F = BlGCvC4F.this;
                cVar = new c(blGCvC4F);
            } else {
                cVar = (c) view;
            }
            cVar.b(aVar);
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f6011r = B0;
        M(B0, s0(C0382R.string.FAQ));
        this.f6011r.addView(new d(), new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
