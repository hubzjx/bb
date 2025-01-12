package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import e4.c;
import java.util.ArrayList;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f6361b;

    /* renamed from: c  reason: collision with root package name */
    TextView f6362c;

    /* renamed from: d  reason: collision with root package name */
    TextView[] f6363d;

    /* renamed from: e  reason: collision with root package name */
    e4.c f6364e;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.e f6365b;

        a(com.secret.prettyhezi.e eVar) {
            this.f6365b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.setSelected(!view.isSelected());
            this.f6365b.a(0);
        }
    }

    public e(POjTJ pOjTJ, String str, int i6, com.secret.prettyhezi.e eVar) {
        super(pOjTJ);
        int i7 = 0;
        setOrientation(0);
        int i8 = -1;
        setBackgroundColor(-1);
        setPadding(g4.i.r(12.0f), 0, 0, g4.i.r(12.0f));
        LinearLayout linearLayout = new LinearLayout(pOjTJ);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(72.0f), -1);
        addView(linearLayout, layoutParams);
        TextView c6 = g4.d.c(pOjTJ, 12, -16777216, str, 17);
        this.f6361b = c6;
        c6.setBackground(g4.i.b(Color.parseColor("#dddddd"), 5.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(26.0f));
        layoutParams2.topMargin = g4.i.r(13.0f);
        linearLayout.addView(this.f6361b, layoutParams2);
        TextView c7 = g4.d.c(pOjTJ, 18, -65536, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6362c = c7;
        c7.setBackground(g4.i.c(-1, 5.0f, -65536, 1.0f));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g4.i.r(26.0f));
        layoutParams3.topMargin = g4.i.r(18.0f);
        linearLayout.addView(this.f6362c, layoutParams3);
        this.f6362c.setVisibility(8);
        e4.c cVar = new e4.c(pOjTJ);
        this.f6364e = cVar;
        addView(cVar, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f6363d = new TextView[i6];
        int r5 = g4.i.r(36.0f);
        int r6 = (pOjTJ.o().x - g4.i.r(24.0f)) - layoutParams.width;
        int r7 = r6 / (g4.i.r(6.0f) + r5);
        int i9 = ((i6 + r7) - 1) / r7;
        int i10 = ((i6 + i9) - 1) / i9;
        int i11 = (r6 - (i10 * r5)) / (i10 + 1);
        while (i7 < i6) {
            TextView[] textViewArr = this.f6363d;
            textViewArr[i7] = g4.d.c(pOjTJ, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET + i7, 17);
            this.f6363d[i7].setTextColor(g4.i.p(-16777216, i8, i8));
            this.f6363d[i7].setBackground(g4.i.h(g4.i.c(Color.parseColor("#cccccc"), 18.0f, Color.parseColor("#aaaaaa"), 1.0f), g4.i.b(-65536, 18.0f), g4.i.b(-65536, 18.0f)));
            this.f6363d[i7].setOnClickListener(new a(eVar));
            c.a aVar = new c.a(r5, r5);
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = i11;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = g4.i.r(8.0f);
            this.f6364e.addView(this.f6363d[i7], aVar);
            i7++;
            i8 = -1;
        }
    }

    public void a() {
        int i6 = 0;
        while (true) {
            TextView[] textViewArr = this.f6363d;
            if (i6 >= textViewArr.length) {
                return;
            }
            textViewArr[i6].setSelected(false);
            i6++;
        }
    }

    public ArrayList b() {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (true) {
            TextView[] textViewArr = this.f6363d;
            if (i6 >= textViewArr.length) {
                return arrayList;
            }
            if (textViewArr[i6].isSelected()) {
                arrayList.add(Integer.valueOf(i6));
            }
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i6) {
        this.f6363d[i6].setSelected(true);
        g4.i.j().f(this.f6363d[i6], 0.8f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.f6362c.setText(str);
        this.f6362c.setVisibility(0);
        g4.i.j().f(this.f6362c, 0.8f);
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        int i6 = 0;
        while (true) {
            TextView[] textViewArr = this.f6363d;
            if (i6 >= textViewArr.length) {
                return;
            }
            textViewArr[i6].setEnabled(z5);
            i6++;
        }
    }
}
