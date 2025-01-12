package com.secret.prettyhezi.Game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class o extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    TextView f6632m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6633n;

    /* renamed from: o  reason: collision with root package name */
    View[] f6634o;

    /* renamed from: p  reason: collision with root package name */
    int f6635p;

    /* renamed from: q  reason: collision with root package name */
    String f6636q;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6637d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6637d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            Intent intent = new Intent(this.f6637d, OFuSfzrsP.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", o.this.f6635p);
            bundle.putString("extra", o.this.f6636q);
            intent.putExtras(bundle);
            this.f6637d.startActivity(intent);
        }
    }

    public o(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f8037b = g4.i.r(40.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        setOrientation(0);
        setGravity(16);
        this.f6632m = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f6633n = g4.d.c(zZcINlcxH, 12, Color.parseColor("#000000"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        addView(this.f6632m, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(this.f6633n, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f6634o = new View[6];
        int i6 = 0;
        while (true) {
            View[] viewArr = this.f6634o;
            if (i6 >= viewArr.length) {
                View a6 = com.secret.prettyhezi.controls.u.a(new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.ic_right_arrow), 7, 13);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.leftMargin = g4.i.r(6.0f);
                addView(a6, layoutParams);
                setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
                setOnClickListener(new a(zZcINlcxH));
                return;
            }
            viewArr[i6] = new View(zZcINlcxH);
            addView(com.secret.prettyhezi.controls.u.a(this.f6634o[i6], 14, 14), new LinearLayout.LayoutParams(0, -1, 1.0f));
            i6++;
        }
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        n nVar2 = (n) nVar;
        this.f6635p = nVar2.id;
        String str = nVar2.number_no;
        this.f6636q = str;
        this.f6632m.setText(str);
        this.f6633n.setText(nVar2.award_result);
        int parseInt = Integer.parseInt(nVar2.award_result);
        int i6 = parseInt / 100;
        int i7 = (parseInt % 100) / 10;
        int i8 = parseInt % 10;
        int i9 = i6 + i7 + i8;
        boolean z5 = i9 >= 14;
        boolean z6 = i9 % 2 == 1;
        boolean[] zArr = {z5, !z5, z6, !z6, !(i6 == i7 && i6 == i8) && (i6 == i7 || i6 == i8 || i7 == i8), (i6 == i7 || i6 == i8 || i7 == i8) ? false : true};
        for (int i10 = 0; i10 < 6; i10++) {
            this.f6634o[i10].setBackground(g4.i.b(zArr[i10] ? -16711936 : -7829368, 7.0f));
        }
    }
}
