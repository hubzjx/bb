package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import e4.c;
/* loaded from: classes.dex */
public class l extends e4.c {

    /* renamed from: e  reason: collision with root package name */
    TextView[] f6409e;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6410d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ POjTJ f6411e;

        a(int i6, POjTJ pOjTJ) {
            this.f6410d = i6;
            this.f6411e = pOjTJ;
        }

        @Override // g4.f
        protected void a(View view) {
            l.this.setCurGameType(this.f6410d);
            this.f6411e.k1(this.f6410d);
        }
    }

    public l(POjTJ pOjTJ) {
        super(pOjTJ);
        setBackgroundColor(Color.parseColor("#f0f0f0"));
        setPadding(g4.i.r(8.0f), 0, 0, g4.i.r(6.0f));
        int r5 = pOjTJ.o().x - g4.i.r(16.0f);
        int r6 = g4.i.r(80.0f);
        int r7 = g4.i.r(4.0f);
        int i6 = r5 / (r6 + r7);
        if (i6 > 4 && i6 <= 7) {
            i6 = 4;
        }
        int i7 = (r5 - ((i6 + 1) * r7)) / i6;
        this.f6409e = new TextView[8];
        for (int i8 = 0; i8 < 8; i8++) {
            this.f6409e[i8] = g4.d.c(pOjTJ, 12, -16777216, k.f6403a[i8].f6405b, 17);
            this.f6409e[i8].setBackground(g4.i.h(g4.i.c(-3355444, 5.0f, -7829368, 1.0f), g4.i.c(-1, 5.0f, -65536, 1.0f), g4.i.c(-1, 5.0f, -65536, 1.0f)));
            this.f6409e[i8].setOnClickListener(new a(i8, pOjTJ));
            c.a aVar = new c.a(i7, g4.i.r(36.0f));
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = g4.i.r(6.0f);
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = r7;
            addView(this.f6409e[i8], aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurGameType(int i6) {
        int i7 = 0;
        while (i7 < 8) {
            this.f6409e[i7].setSelected(i7 == i6);
            i7++;
        }
    }
}
