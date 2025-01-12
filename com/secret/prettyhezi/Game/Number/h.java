package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.Number.k;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.t;
import java.util.ArrayList;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class h extends LinearLayout implements i {

    /* renamed from: b  reason: collision with root package name */
    POjTJ f6377b;

    /* renamed from: c  reason: collision with root package name */
    int f6378c;

    /* renamed from: d  reason: collision with root package name */
    int f6379d;

    /* renamed from: e  reason: collision with root package name */
    com.secret.prettyhezi.Game.Number.e[] f6380e;

    /* renamed from: f  reason: collision with root package name */
    TextView f6381f;

    /* renamed from: g  reason: collision with root package name */
    t f6382g;

    /* renamed from: h  reason: collision with root package name */
    com.secret.prettyhezi.Game.Number.a f6383h;

    /* renamed from: i  reason: collision with root package name */
    TextView f6384i;

    /* renamed from: j  reason: collision with root package name */
    TextView f6385j;

    /* renamed from: k  reason: collision with root package name */
    TextView f6386k;

    /* renamed from: l  reason: collision with root package name */
    LinearLayout f6387l;

    /* renamed from: m  reason: collision with root package name */
    public int f6388m;

    /* loaded from: classes.dex */
    class a implements com.secret.prettyhezi.e {
        a() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            h.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements com.secret.prettyhezi.e {
        b() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            h.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements com.secret.prettyhezi.e {
        c() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            h.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                h.this.c();
            }
        }

        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            h.this.f6377b.B("重置所有选择？", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            h.this.f();
        }
    }

    public h(POjTJ pOjTJ, int i6) {
        super(pOjTJ);
        this.f6377b = pOjTJ;
        this.f6378c = i6;
        this.f6388m = pOjTJ.M.pl.one_number_integral;
        setOrientation(1);
        k.a aVar = k.f6403a[i6];
        LinearLayout linearLayout = new LinearLayout(pOjTJ);
        int i7 = 0;
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(Color.parseColor("#dddddd"));
        linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(30.0f)));
        linearLayout.addView(g4.d.c(pOjTJ, 12, Color.parseColor("#333333"), aVar.f6406c, 16), new LinearLayout.LayoutParams(0, -1, 1.0f));
        g4.d.c(pOjTJ, 12, -65536, "单注奖:" + pOjTJ.M.pl.GetWinGold(i6), 16);
        new LinearLayout.LayoutParams(-2, -1);
        this.f6380e = new com.secret.prettyhezi.Game.Number.e[aVar.f6407d.length];
        while (true) {
            String[] strArr = aVar.f6407d;
            if (i7 >= strArr.length) {
                d();
                e();
                return;
            }
            this.f6380e[i7] = new com.secret.prettyhezi.Game.Number.e(pOjTJ, strArr[i7], aVar.f6408e[i7], new a());
            addView(this.f6380e[i7], new LinearLayout.LayoutParams(-1, -2));
            pOjTJ.V(this, Color.parseColor("#cccccc"), 0.5f, 0, 0);
            i7++;
        }
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public LinearLayout a() {
        return this.f6387l;
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public void b(int i6) {
        com.secret.prettyhezi.Game.Number.e eVar;
        com.secret.prettyhezi.Game.Number.e eVar2;
        c();
        int i7 = i6 / 100;
        int i8 = (i6 % 100) / 10;
        int i9 = i6 % 10;
        com.secret.prettyhezi.Game.Number.e[] eVarArr = this.f6380e;
        if (eVarArr.length == 1) {
            eVarArr[0].d(String.format("%03d", Integer.valueOf(i6)));
        }
        int i10 = this.f6378c;
        if (i10 == 0) {
            this.f6380e[0].c(i7);
            this.f6380e[1].c(i8);
            eVar2 = this.f6380e[2];
        } else if (i10 == 2) {
            this.f6380e[0].c(i8);
            eVar2 = this.f6380e[1];
        } else if (i10 == 4) {
            eVar2 = this.f6380e[0];
        } else if (i10 == 1) {
            eVar2 = this.f6380e[0];
            i9 = i9 + i8 + i7;
        } else if (i10 != 3) {
            if (i10 == 5) {
                if (((i7 == i8 && i7 == i9) || i9 != i8) && i9 != i7 && i8 != i7) {
                    return;
                }
                this.f6380e[0].c(i9);
                this.f6380e[0].c(i8);
                eVar = this.f6380e[0];
            } else if (i10 != 6 || i7 == i8 || i7 == i9 || i8 == i9) {
                return;
            } else {
                this.f6380e[0].c(i9);
                this.f6380e[0].c(i8);
                eVar = this.f6380e[0];
            }
            eVar.c(i7);
            return;
        } else {
            eVar2 = this.f6380e[0];
            i9 += i8;
        }
        eVar2.c(i9);
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public void c() {
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.e[] eVarArr = this.f6380e;
            if (i6 >= eVarArr.length) {
                break;
            }
            eVarArr[i6].a();
            i6++;
        }
        com.secret.prettyhezi.Game.Number.a aVar = this.f6383h;
        if (aVar != null) {
            aVar.c(1);
        }
        h(0L);
    }

    void d() {
        LinearLayout linearLayout = new LinearLayout(this.f6377b);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(g4.i.c(Color.parseColor("#dddddd"), 5.0f, -16777216, 2.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(12.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        layoutParams.topMargin = g4.i.r(6.0f);
        addView(linearLayout, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.f6377b);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(8.0f);
        layoutParams2.bottomMargin = g4.i.r(4.0f);
        linearLayout.addView(linearLayout2, layoutParams2);
        TextView b6 = g4.d.b(this.f6377b, 14.0f, -16777216, "单注:");
        TextView b7 = g4.d.b(this.f6377b, 14.0f, -65536, HttpUrl.FRAGMENT_ENCODE_SET + this.f6388m);
        TextView b8 = g4.d.b(this.f6377b, 14.0f, -16777216, this.f6377b.d1() + "       单注返奖:");
        TextView b9 = g4.d.b(this.f6377b, 14.0f, -65536, HttpUrl.FRAGMENT_ENCODE_SET + this.f6377b.M.pl.GetWinGold(this.f6378c));
        POjTJ pOjTJ = this.f6377b;
        TextView b10 = g4.d.b(pOjTJ, 14.0f, -16777216, pOjTJ.d1());
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(b7, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(b8, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(b9, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(b10, new LinearLayout.LayoutParams(-2, -2));
        this.f6377b.Q(linearLayout, Color.parseColor("#666666"), 0.5f, 8, 4, 8);
        LinearLayout linearLayout3 = new LinearLayout(this.f6377b);
        linearLayout3.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = g4.i.r(6.0f);
        linearLayout.addView(linearLayout3, layoutParams3);
        float f6 = 14;
        this.f6381f = g4.d.b(this.f6377b, f6, -65536, "0");
        linearLayout3.addView(g4.d.b(this.f6377b, f6, -16777216, "共"), new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(this.f6381f, new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(g4.d.b(this.f6377b, f6, -16777216, "注"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        int GetBetLimit = this.f6377b.M.pl.GetBetLimit(this.f6378c);
        this.f6379d = GetBetLimit;
        if (GetBetLimit > 0) {
            TextView c6 = g4.d.c(this.f6377b, 12, -65536, "(限投" + this.f6379d + "倍)", 16);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams4.rightMargin = g4.i.r(4.0f);
            linearLayout3.addView(c6, layoutParams4);
        }
        linearLayout3.addView(g4.d.b(this.f6377b, f6, -16777216, "投"), new LinearLayout.LayoutParams(-2, -2));
        POjTJ pOjTJ2 = this.f6377b;
        int i6 = this.f6379d;
        if (i6 <= 0) {
            i6 = 9999;
        }
        this.f6382g = new t(pOjTJ2, i6);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, g4.i.r(30.0f));
        int r6 = g4.i.r(2.0f);
        layoutParams5.rightMargin = r6;
        layoutParams5.leftMargin = r6;
        linearLayout3.addView(this.f6382g, layoutParams5);
        this.f6382g.b(new b());
        linearLayout3.addView(g4.d.b(this.f6377b, f6, -16777216, "倍"), new LinearLayout.LayoutParams(-2, -2));
        this.f6377b.Q(linearLayout, Color.parseColor("#666666"), 0.5f, 8, 4, 8);
        POjTJ pOjTJ3 = this.f6377b;
        if (pOjTJ3.M.buy_num > 1) {
            this.f6383h = new com.secret.prettyhezi.Game.Number.a(pOjTJ3, new c());
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.topMargin = g4.i.r(2.0f);
            linearLayout.addView(this.f6383h, layoutParams6);
            this.f6377b.Q(linearLayout, Color.parseColor("#666666"), 0.5f, 8, 4, 8);
        }
        LinearLayout linearLayout4 = new LinearLayout(this.f6377b);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        linearLayout4.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
        linearLayout.addView(linearLayout4, new LinearLayout.LayoutParams(-1, g4.i.r(42.0f)));
        linearLayout4.addView(g4.d.b(this.f6377b, f6, -16777216, "共"), new LinearLayout.LayoutParams(-2, -2));
        TextView b11 = g4.d.b(this.f6377b, f6, -65536, "0");
        this.f6384i = b11;
        linearLayout4.addView(b11, new LinearLayout.LayoutParams(-2, -2));
        POjTJ pOjTJ4 = this.f6377b;
        linearLayout4.addView(g4.d.b(pOjTJ4, f6, -16777216, pOjTJ4.d1()), new LinearLayout.LayoutParams(-2, -2));
        linearLayout4.addView(new View(this.f6377b), new LinearLayout.LayoutParams(0, g4.i.r(20.0f), 1.0f));
        TextView f7 = com.secret.prettyhezi.Game.Number.c.f(this.f6377b, linearLayout4);
        this.f6385j = f7;
        f7.setOnClickListener(new d());
        TextView d6 = com.secret.prettyhezi.Game.Number.c.d(this.f6377b, linearLayout4);
        this.f6386k = d6;
        d6.setOnClickListener(new e());
        this.f6386k.setEnabled(false);
        LinearLayout linearLayout5 = new LinearLayout(this.f6377b);
        this.f6387l = linearLayout5;
        linearLayout5.setOrientation(1);
        linearLayout.addView(this.f6387l, new LinearLayout.LayoutParams(-1, -2));
    }

    void e() {
        c();
        this.f6386k.setEnabled(this.f6377b.L.open == 0);
        this.f6377b.q1();
    }

    void f() {
        ArrayList b6;
        int parseInt = Integer.parseInt(this.f6381f.getText().toString());
        int parseInt2 = Integer.parseInt(this.f6384i.getText().toString());
        int a6 = this.f6382g.a();
        k.b bVar = new k.b();
        bVar.id = this.f6377b.M.id;
        com.secret.prettyhezi.Game.Number.e[] eVarArr = this.f6380e;
        int length = eVarArr.length;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (length > 1) {
            for (int i6 = 0; i6 < this.f6380e.length; i6++) {
                if (i6 > 0) {
                    str = str + ",";
                }
                for (int i7 = 0; i7 < this.f6380e[i6].b().size(); i7++) {
                    str = str + b6.get(i7);
                }
            }
        } else {
            ArrayList b7 = eVarArr[0].b();
            for (int i8 = 0; i8 < b7.size(); i8++) {
                if (i8 > 0) {
                    str = str + ",";
                }
                str = str + b7.get(i8);
            }
        }
        bVar.vote_con = str;
        bVar.vote_number = parseInt;
        bVar.vote_multiple = a6;
        bVar.vote_integral = parseInt2;
        bVar.integralSum = parseInt2;
        bVar.vote_type = k.f6403a[this.f6378c].f6404a;
        if (this.f6377b.M.buy_num > 1) {
            int a7 = this.f6383h.a();
            bVar.num = a7;
            bVar.vote_integral = parseInt2 / a7;
            bVar.is_bonus_stop = this.f6383h.b() ? 1 : 0;
        }
        this.f6377b.S0(bVar);
    }

    public void g() {
        int size;
        int i6;
        int i7;
        long j6;
        int size2;
        com.secret.prettyhezi.Game.Number.e eVar;
        int i8 = this.f6378c;
        if (i8 == 0) {
            size = this.f6380e[0].b().size() * this.f6380e[1].b().size();
            eVar = this.f6380e[2];
        } else if (i8 != 2) {
            if (i8 == 4) {
                size2 = this.f6380e[0].b().size();
                j6 = size2;
                h(j6);
            }
            long j7 = 0;
            if (i8 == 1) {
                ArrayList b6 = this.f6380e[0].b();
                if (b6.size() != 0) {
                    i7 = 0;
                    for (int i9 = 0; i9 < b6.size(); i9++) {
                        int intValue = ((Integer) b6.get(i9)).intValue();
                        for (int i10 = 0; i10 <= 9; i10++) {
                            for (int i11 = 0; i11 <= 9; i11++) {
                                for (int i12 = 0; i12 <= 9; i12++) {
                                    if (i10 + i11 + i12 == intValue) {
                                        i7++;
                                    }
                                }
                            }
                        }
                    }
                    j6 = i7;
                }
                h(j7);
                return;
            } else if (i8 == 3) {
                ArrayList b7 = this.f6380e[0].b();
                if (b7.size() == 0) {
                    h(0L);
                }
                i7 = 0;
                for (int i13 = 0; i13 < b7.size(); i13++) {
                    int intValue2 = ((Integer) b7.get(i13)).intValue();
                    for (int i14 = 0; i14 <= 9; i14++) {
                        for (int i15 = 0; i15 <= 9; i15++) {
                            if (i14 + i15 == intValue2) {
                                i7++;
                            }
                        }
                    }
                }
                j6 = i7;
            } else if (i8 != 5) {
                if (i8 == 6) {
                    int size3 = this.f6380e[0].b().size();
                    if (size3 >= 3) {
                        j7 = 1;
                        for (int i16 = 4; i16 <= size3; i16++) {
                            j7 *= i16;
                        }
                        for (int i17 = 2; i17 <= size3 - 3; i17++) {
                            j7 /= i17;
                        }
                    }
                    h(j7);
                    return;
                }
                return;
            } else {
                size = this.f6380e[0].b().size();
                i6 = size - 1;
                size2 = size * i6;
                j6 = size2;
            }
            h(j6);
        } else {
            size = this.f6380e[0].b().size();
            eVar = this.f6380e[1];
        }
        i6 = eVar.b().size();
        size2 = size * i6;
        j6 = size2;
        h(j6);
    }

    void h(long j6) {
        TextView textView = this.f6381f;
        textView.setText(j6 + HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6386k.setEnabled(j6 > 0 && this.f6377b.L.open == 0);
        i();
    }

    void i() {
        int parseInt = Integer.parseInt(this.f6381f.getText().toString()) * this.f6382g.a();
        if (this.f6377b.M.buy_num > 1) {
            parseInt *= this.f6383h.a();
        }
        int i6 = parseInt * this.f6388m;
        TextView textView = this.f6384i;
        textView.setText(i6 + HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public void setGameEnabled(boolean z5) {
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.e[] eVarArr = this.f6380e;
            if (i6 >= eVarArr.length) {
                break;
            }
            eVarArr[i6].setEnabled(z5);
            i6++;
        }
        if (this.f6377b.L.open == 0) {
            TextView textView = this.f6386k;
            if (z5 && Integer.parseInt(this.f6384i.getText().toString()) > 0) {
                z6 = true;
            }
            textView.setEnabled(z6);
        }
    }
}
