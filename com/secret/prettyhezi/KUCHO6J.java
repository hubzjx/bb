package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.User.TK1dGVzP;
import e4.c;
/* loaded from: classes.dex */
public class KUCHO6J extends WVGAB1kU {
    c N;
    e4.c O;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Cache.a f6687a;

        a(com.secret.prettyhezi.Cache.a aVar) {
            this.f6687a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6 = this.f6687a.pageIndex;
            KUCHO6J kucho6j = KUCHO6J.this;
            CrD7389U.Z0(kucho6j.f8111s, i6, kucho6j.N.ts[i6 - 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6689d;

        b(int i6) {
            this.f6689d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            if (MainApplication.f6711r.r() == null) {
                TK1dGVzP.S0("查看小说内容需要登录");
                return;
            }
            KUCHO6J kucho6j = KUCHO6J.this;
            c cVar = kucho6j.N;
            if (cVar != null) {
                int i6 = kucho6j.f8111s;
                int i7 = this.f6689d;
                CrD7389U.Z0(i6, i7, cVar.ts[i7 - 1]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends com.secret.prettyhezi.Server.j {
        public int am;
        public String[] ts;

        c() {
        }
    }

    /* loaded from: classes.dex */
    class d extends com.secret.prettyhezi.Server.w {
        public c data;

        d() {
        }
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void X0() {
        e4.c cVar = new e4.c(this);
        this.O = cVar;
        cVar.setPadding(g4.i.r(8.0f), g4.i.r(10.0f), 0, 0);
        this.f8115w.addView(this.O, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void h1(String str) {
        int i6;
        d dVar = (d) f.d(str, d.class);
        if (dVar.code != 200) {
            w0(dVar);
            return;
        }
        this.N = dVar.data;
        com.secret.prettyhezi.Cache.a GetLastItem = com.secret.prettyhezi.Cache.a.GetLastItem();
        if (GetLastItem == null || GetLastItem.id != this.f8111s || (i6 = GetLastItem.pageIndex) <= 0 || i6 > this.N.ts.length) {
            c cVar = this.N;
            com.secret.prettyhezi.Cache.a.SetBook(cVar.id, cVar.na);
        } else {
            this.f8115w.postDelayed(new a(GetLastItem), 2L);
        }
        y1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8118z.setSingleLine(false);
        this.f8118z.setTextSize(16.0f);
    }

    void y1() {
        super.v1(this.N);
        this.O.removeAllViews();
        int r5 = (((o().x - g4.i.r(8.0f)) / ((o().x - g4.i.r(8.0f)) / (g4.i.r(92.0f) + g4.i.r(8.0f)))) - g4.i.r(8.0f)) - 1;
        for (int i6 = 1; i6 <= this.N.am; i6++) {
            TextView b6 = g4.d.b(this, 14.0f, -16777216, String.format(s0(C0382R.string.SectionFormat), Integer.valueOf(i6)));
            b6.setGravity(17);
            c.a aVar = new c.a(r5, g4.i.r(40.0f));
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = g4.i.r(8.0f);
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(12.0f);
            this.O.addView(b6, aVar);
            b6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#aaaa00"), 6.0f), g4.i.b(Color.parseColor("#ffff00"), 6.0f)));
            b6.setOnClickListener(new b(i6));
        }
    }
}
