package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.CAr0jaumF;
import com.secret.prettyhezi.Game.Try.Hg8b72NJ;
/* loaded from: classes.dex */
public class j extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f6395b;

    /* renamed from: c  reason: collision with root package name */
    TextView f6396c;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ POjTJ f6397d;

        a(POjTJ pOjTJ) {
            this.f6397d = pOjTJ;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6397d.N0(CAr0jaumF.class, 1);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ POjTJ f6399d;

        b(POjTJ pOjTJ) {
            this.f6399d = pOjTJ;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6399d.N0(Hg8b72NJ.class, 0);
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ POjTJ f6401d;

        c(POjTJ pOjTJ) {
            this.f6401d = pOjTJ;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6401d.N0(Hg8b72NJ.class, 1);
        }
    }

    public j(POjTJ pOjTJ) {
        super(pOjTJ);
        this.f6395b = null;
        this.f6396c = null;
        setOrientation(0);
        setGravity(17);
        View c6 = g4.d.c(pOjTJ, 14, -1, pOjTJ.d1() + "记录", 17);
        c6.setBackground(g4.i.e(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f)));
        c6.setOnClickListener(new a(pOjTJ));
        addView(c6, new LinearLayout.LayoutParams(g4.i.r(76.0f), g4.i.r(36.0f)));
        TextView c7 = g4.d.c(pOjTJ, 14, -1, "试玩日榜", 17);
        this.f6395b = c7;
        c7.setBackground(g4.i.e(g4.i.b(-65536, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f)));
        this.f6395b.setOnClickListener(new b(pOjTJ));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(76.0f), g4.i.r(36.0f));
        layoutParams.leftMargin = g4.i.r(12.0f);
        addView(this.f6395b, layoutParams);
        TextView c8 = g4.d.c(pOjTJ, 14, -1, "试玩周榜", 17);
        this.f6396c = c8;
        c8.setBackground(g4.i.e(g4.i.b(-65536, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f)));
        this.f6396c.setOnClickListener(new c(pOjTJ));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(76.0f), g4.i.r(36.0f));
        layoutParams2.leftMargin = g4.i.r(12.0f);
        addView(this.f6396c, layoutParams2);
        this.f6395b.setVisibility(8);
        this.f6396c.setVisibility(8);
    }
}
