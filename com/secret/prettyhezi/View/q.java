package com.secret.prettyhezi.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class q extends LinearLayout {

    /* renamed from: m  reason: collision with root package name */
    static final int[] f7976m = {-300, -100, -30, -10, 0, 10, 30, 100, 300};

    /* renamed from: n  reason: collision with root package name */
    static final int[] f7977n = {-50, -20, -10, -5, 0, 5, 10, 20, 50};

    /* renamed from: o  reason: collision with root package name */
    static final int[] f7978o = {-20, -10, -5, -3, 0, 3, 5, 10, 20};

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f7979b;

    /* renamed from: c  reason: collision with root package name */
    t f7980c;

    /* renamed from: d  reason: collision with root package name */
    int f7981d;

    /* renamed from: e  reason: collision with root package name */
    int f7982e;

    /* renamed from: f  reason: collision with root package name */
    int[] f7983f;

    /* renamed from: g  reason: collision with root package name */
    TextView[] f7984g;

    /* renamed from: h  reason: collision with root package name */
    View f7985h;

    /* renamed from: i  reason: collision with root package name */
    com.secret.prettyhezi.controls.u f7986i;

    /* renamed from: j  reason: collision with root package name */
    View f7987j;

    /* renamed from: k  reason: collision with root package name */
    com.secret.prettyhezi.controls.u f7988k;

    /* renamed from: l  reason: collision with root package name */
    LinearLayout f7989l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7990d;

        a(int i6) {
            this.f7990d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            q qVar = q.this;
            t tVar = qVar.f7980c;
            if (tVar != null) {
                tVar.o(qVar.f7982e + this.f7990d);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            t tVar = q.this.f7980c;
            if (tVar != null) {
                tVar.o(1);
            }
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            q qVar = q.this;
            t tVar = qVar.f7980c;
            if (tVar != null) {
                tVar.o(qVar.f7981d);
            }
        }
    }

    public q(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f7980c = null;
        this.f7981d = 0;
        this.f7982e = 1;
        this.f7983f = null;
        this.f7984g = new TextView[9];
        this.f7979b = zZcINlcxH;
        setBackgroundColor(Color.parseColor("#99ffffff"));
        setOrientation(1);
        setOnClickListener(new b());
        this.f7983f = f7976m;
        this.f7985h = new View(zZcINlcxH);
        Bitmap decodeResource = BitmapFactory.decodeResource(zZcINlcxH.getResources(), C0382R.drawable.ic_bottom);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeResource);
        x.b.o(bitmapDrawable, g4.i.q(-16777216, -16777216, -16777216, -7829368));
        this.f7985h.setBackground(bitmapDrawable);
        this.f7985h.setRotation(180.0f);
        com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(this.f7985h, 32, 32);
        this.f7986i = a6;
        a6.setBackground(g4.i.f(0, Color.parseColor("#ccffffff")));
        this.f7987j = new View(zZcINlcxH);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(decodeResource);
        x.b.o(bitmapDrawable2, g4.i.q(-16777216, -16777216, -16777216, -7829368));
        this.f7987j.setBackground(bitmapDrawable2);
        com.secret.prettyhezi.controls.u a7 = com.secret.prettyhezi.controls.u.a(this.f7987j, 32, 32);
        this.f7988k = a7;
        a7.setBackground(g4.i.f(0, Color.parseColor("#ccffffff")));
        addView(this.f7986i, new LinearLayout.LayoutParams(-1, g4.i.r(46.0f)));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        this.f7989l = linearLayout;
        linearLayout.setOrientation(1);
        this.f7989l.setGravity(17);
        int i6 = 0;
        while (true) {
            int[] iArr = this.f7983f;
            if (i6 >= iArr.length) {
                addView(this.f7989l, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                addView(this.f7988k, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
                this.f7986i.setOnClickListener(new c());
                this.f7988k.setOnClickListener(new d());
                return;
            }
            this.f7984g[i6] = d(iArr[i6]);
            i6++;
        }
    }

    public static TextView e(ZZcINlcxH zZcINlcxH) {
        TextView b6 = g4.d.b(zZcINlcxH, 18.0f, Color.parseColor("#cc000000"), zZcINlcxH.s0(C0382R.string.Random));
        b6.getPaint().setFakeBoldText(true);
        b6.setBackground(g4.i.f(Color.parseColor("#99ffffff"), Color.parseColor("#ccffffff")));
        b6.setGravity(17);
        return b6;
    }

    public void a(int i6) {
        this.f7982e = i6;
        TextView textView = this.f7984g[4];
        textView.setText(this.f7979b.s0(C0382R.string.IndexP) + this.f7982e);
        boolean z5 = i6 > 1;
        this.f7985h.setEnabled(z5);
        this.f7986i.setEnabled(z5);
        boolean z6 = i6 < this.f7981d;
        this.f7987j.setEnabled(z6);
        this.f7988k.setEnabled(z6);
        int i7 = 0;
        while (true) {
            int[] iArr = this.f7983f;
            if (i7 >= iArr.length) {
                return;
            }
            int i8 = iArr[i7] + i6;
            this.f7984g[i7].setEnabled(i8 >= 1 && i8 <= this.f7981d);
            i7++;
        }
    }

    public void b(t tVar) {
        this.f7980c = tVar;
    }

    public void c(int i6) {
        if (i6 < 5) {
            setVisibility(8);
        }
        this.f7981d = i6;
        int[] iArr = i6 > 200 ? f7976m : i6 > 50 ? f7977n : f7978o;
        if (iArr == this.f7983f) {
            return;
        }
        this.f7989l.removeAllViews();
        this.f7983f = iArr;
        int i7 = 0;
        while (true) {
            int[] iArr2 = this.f7983f;
            if (i7 >= iArr2.length) {
                return;
            }
            this.f7984g[i7] = d(iArr2[i7]);
            i7++;
        }
    }

    TextView d(int i6) {
        Context context = getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(i6 > 0 ? k5.d.ANY_NON_NULL_MARKER : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(i6);
        TextView c6 = g4.d.c(context, 16, -16777216, sb.toString(), 17);
        c6.setTextColor(g4.i.q(-16777216, -16777216, -16777216, -7829368));
        this.f7989l.addView(c6, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        if (i6 != 0) {
            c6.setBackground(g4.i.g(0, Color.parseColor("#ccffffff"), 0));
            c6.setOnClickListener(new a(i6));
        } else {
            c6.setBackgroundColor(Color.parseColor("#33ffff00"));
        }
        return c6;
    }
}
