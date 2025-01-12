package com.secret.prettyhezi.Upload;

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
import com.secret.prettyhezi.DHwJuV;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.h;
/* loaded from: classes.dex */
public class AW1jL extends ZZcINlcxH {

    /* renamed from: q  reason: collision with root package name */
    String[] f7206q;

    /* renamed from: s  reason: collision with root package name */
    String f7208s;

    /* renamed from: t  reason: collision with root package name */
    private w0.c f7209t;

    /* renamed from: u  reason: collision with root package name */
    RelativeLayout f7210u;

    /* renamed from: r  reason: collision with root package name */
    int f7207r = -1;

    /* renamed from: v  reason: collision with root package name */
    w0.g f7211v = new b();

    /* renamed from: w  reason: collision with root package name */
    androidx.viewpager.widget.a f7212w = new c();

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            AW1jL.this.S0();
        }
    }

    /* loaded from: classes.dex */
    class b implements w0.g {
        b() {
        }

        @Override // w0.g
        public void a(ImageView imageView, float f6, float f7) {
            AW1jL.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class c extends androidx.viewpager.widget.a {
        c() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return AW1jL.this.f7206q.length;
        }

        @Override // androidx.viewpager.widget.a
        public Object g(ViewGroup viewGroup, int i6) {
            AW1jL aW1jL = AW1jL.this;
            d dVar = new d(aW1jL, i6);
            viewGroup.addView(dVar, new ViewGroup.LayoutParams(-1, -1));
            return dVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean h(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes.dex */
    class d extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        View f7216b;

        /* renamed from: c  reason: collision with root package name */
        b f7217c;

        /* renamed from: d  reason: collision with root package name */
        Bitmap f7218d;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AW1jL f7220d;

            a(AW1jL aW1jL) {
                this.f7220d = aW1jL;
            }

            @Override // g4.f
            public void a(View view) {
                AW1jL.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class b extends com.secret.prettyhezi.controls.s {

            /* loaded from: classes.dex */
            class a implements h.b {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f7223a;

                a(d dVar) {
                    this.f7223a = dVar;
                }

                @Override // com.secret.prettyhezi.controls.h.b
                public void a(int i6, String str, String str2, String str3) {
                    AW1jL aW1jL = AW1jL.this;
                    d.this.addView(new com.secret.prettyhezi.View.w(aW1jL, i6, 5, aW1jL.f7207r, str2, str3), 0, new RelativeLayout.LayoutParams(-1, -1));
                }
            }

            b(Context context, String str) {
                super(context, null);
                d(new a(d.this));
                e(str);
                setOnPhotoTapListener(AW1jL.this.f7211v);
            }

            @Override // com.secret.prettyhezi.controls.s
            protected void f(Bitmap bitmap) {
                d.this.f7216b.clearAnimation();
                d dVar = d.this;
                dVar.removeView(dVar.f7216b);
                if (bitmap != null) {
                    d.this.f7218d = bitmap;
                    setImageBitmap(bitmap);
                    d.this.addView(this, 0, new RelativeLayout.LayoutParams(-1, -1));
                }
            }
        }

        d(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            TextView b6 = g4.d.b(zZcINlcxH, 12.0f, -1, String.format("%d/%d", Integer.valueOf(i6 + 1), Integer.valueOf(AW1jL.this.f7206q.length)));
            b6.setGravity(17);
            b6.setPadding(g4.i.r(6.5f), 0, g4.i.r(6.5f), 0);
            b6.setBackground(ZZcINlcxH.g0(0, 12.5f, Color.parseColor("#4cffffff"), 1.0f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(25.0f));
            layoutParams.rightMargin = g4.i.r(10.0f);
            layoutParams.bottomMargin = g4.i.r(18.0f);
            layoutParams.addRule(11, 1);
            layoutParams.addRule(12, 1);
            addView(b6, layoutParams);
            this.f7216b = AW1jL.this.e0();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ZZcINlcxH.i0(34.0f), ZZcINlcxH.i0(34.0f));
            layoutParams2.addRule(13, 1);
            addView(this.f7216b, layoutParams2);
            this.f7217c = new b(zZcINlcxH, AW1jL.this.f7206q[i6]);
            setOnClickListener(new a(AW1jL.this));
        }
    }

    public static void R0(Context context, int i6, String[] strArr, String str) {
        Intent intent = new Intent();
        intent.setClass(context, AW1jL.class);
        Bundle bundle = new Bundle();
        if (strArr != null) {
            bundle.putStringArray("photos", strArr);
        }
        bundle.putInt("id", i6);
        if (str != null) {
            bundle.putString("hint", str);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    void S0() {
        int size = ZZcINlcxH.f8162n.size();
        if (size > 2) {
            int i6 = size - 2;
            if (ZZcINlcxH.f8162n.get(i6) instanceof DHwJuV) {
                finish();
                ((DHwJuV) ZZcINlcxH.f8162n.get(i6)).j1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7206q = extras.getStringArray("photos");
            this.f7207r = extras.getInt("id");
            this.f7208s = extras.getString("hint");
        }
        RelativeLayout E0 = E0();
        this.f7210u = E0;
        E0.setBackgroundColor(-16777216);
        F0(Color.parseColor("#202020"));
        w0.c cVar = new w0.c(this);
        this.f7209t = cVar;
        cVar.setBackgroundColor(-16777216);
        this.f7210u.addView(this.f7209t, new RelativeLayout.LayoutParams(-1, -1));
        this.f7209t.setAdapter(this.f7212w);
        this.f7209t.setCurrentItem(0);
        this.f7209t.setOffscreenPageLimit(2);
        TextView b6 = g4.d.b(this, 14.0f, -1, this.f7208s);
        b6.setPadding(g4.i.r(5.0f), 0, g4.i.r(5.0f), 0);
        b6.setGravity(17);
        b6.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(36.0f));
        layoutParams.bottomMargin = g4.i.r(15.0f);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(12, -1);
        b6.setOnClickListener(new a());
        this.f7210u.addView(b6, layoutParams);
    }
}
