package com.secret.prettyhezi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class Pc3DTln6R extends ZZcINlcxH {

    /* renamed from: q  reason: collision with root package name */
    String[] f6828q;

    /* renamed from: s  reason: collision with root package name */
    private w0.c f6830s;

    /* renamed from: t  reason: collision with root package name */
    RelativeLayout f6831t;

    /* renamed from: r  reason: collision with root package name */
    int f6829r = 0;

    /* renamed from: u  reason: collision with root package name */
    int f6832u = 100;

    /* renamed from: v  reason: collision with root package name */
    int f6833v = 0;

    /* renamed from: w  reason: collision with root package name */
    w0.g f6834w = new a();

    /* renamed from: x  reason: collision with root package name */
    androidx.viewpager.widget.a f6835x = new b();

    /* loaded from: classes.dex */
    class a implements w0.g {
        a() {
        }

        @Override // w0.g
        public void a(ImageView imageView, float f6, float f7) {
            Pc3DTln6R.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.viewpager.widget.a {
        b() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return Pc3DTln6R.this.f6828q.length;
        }

        @Override // androidx.viewpager.widget.a
        public Object g(ViewGroup viewGroup, int i6) {
            Pc3DTln6R pc3DTln6R = Pc3DTln6R.this;
            c cVar = new c(pc3DTln6R, i6);
            viewGroup.addView(cVar, new ViewGroup.LayoutParams(-1, -1));
            return cVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean h(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes.dex */
    class c extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        View f6838b;

        /* renamed from: c  reason: collision with root package name */
        b f6839c;

        /* renamed from: d  reason: collision with root package name */
        Bitmap f6840d;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Pc3DTln6R f6842d;

            a(Pc3DTln6R pc3DTln6R) {
                this.f6842d = pc3DTln6R;
            }

            @Override // g4.f
            public void a(View view) {
                Pc3DTln6R.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class b extends com.secret.prettyhezi.controls.s {
            b(Context context, String str) {
                super(context, str);
                setOnPhotoTapListener(Pc3DTln6R.this.f6834w);
            }

            @Override // com.secret.prettyhezi.controls.s
            protected void f(Bitmap bitmap) {
                c.this.f6838b.clearAnimation();
                c cVar = c.this;
                cVar.removeView(cVar.f6838b);
                if (bitmap != null) {
                    c.this.f6840d = bitmap;
                    setImageBitmap(bitmap);
                    c.this.addView(this, 0, new RelativeLayout.LayoutParams(-1, -1));
                    return;
                }
                com.secret.prettyhezi.controls.n nVar = new com.secret.prettyhezi.controls.n(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, 1);
                c.this.addView(nVar, 0, layoutParams);
            }
        }

        c(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i6 > Pc3DTln6R.this.f6832u ? i6 : i6 + 1);
            objArr[1] = Integer.valueOf(Pc3DTln6R.this.f6828q.length - Pc3DTln6R.this.f6833v);
            TextView b6 = g4.d.b(zZcINlcxH, 12.0f, -1, String.format("%d/%d", objArr));
            b6.setGravity(17);
            b6.setPadding(g4.i.r(6.5f), 0, g4.i.r(6.5f), 0);
            b6.setBackground(ZZcINlcxH.g0(0, 12.5f, Color.parseColor("#4cffffff"), 1.0f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(25.0f));
            layoutParams.rightMargin = g4.i.r(10.0f);
            layoutParams.bottomMargin = g4.i.r(18.0f);
            layoutParams.addRule(11, 1);
            layoutParams.addRule(12, 1);
            addView(b6, layoutParams);
            this.f6838b = Pc3DTln6R.this.e0();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ZZcINlcxH.i0(34.0f), ZZcINlcxH.i0(34.0f));
            layoutParams2.addRule(13, 1);
            addView(this.f6838b, layoutParams2);
            this.f6839c = new b(zZcINlcxH, Pc3DTln6R.this.f6828q[i6]);
            setOnClickListener(new a(Pc3DTln6R.this));
        }
    }

    public static void R0(Context context, String[] strArr, int i6) {
        Intent intent = new Intent();
        intent.setClass(context, Pc3DTln6R.class);
        Bundle bundle = new Bundle();
        if (strArr != null) {
            bundle.putStringArray("photos", strArr);
            bundle.putInt("index", i6);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    void S0() {
        w0.c cVar = new w0.c(this);
        this.f6830s = cVar;
        cVar.setBackgroundColor(-16777216);
        this.f6831t.addView(this.f6830s, new RelativeLayout.LayoutParams(-1, -1));
        this.f6830s.setAdapter(this.f6835x);
        this.f6830s.setCurrentItem(this.f6829r);
        this.f6830s.setOffscreenPageLimit(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6828q = extras.getStringArray("photos");
            this.f6829r = extras.getInt("index");
        }
        RelativeLayout E0 = E0();
        this.f6831t = E0;
        E0.setBackgroundColor(-16777216);
        F0(Color.parseColor("#202020"));
        if (this.f6828q != null) {
            S0();
        }
    }
}
