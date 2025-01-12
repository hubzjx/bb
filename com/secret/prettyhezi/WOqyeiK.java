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
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.controls.h;
import com.secret.prettyhezi.controls.z;
/* loaded from: classes.dex */
public class WOqyeiK extends UoWMF {
    static int D = 6;

    /* renamed from: r  reason: collision with root package name */
    int f8086r;

    /* renamed from: t  reason: collision with root package name */
    String[] f8088t;

    /* renamed from: v  reason: collision with root package name */
    String f8090v;

    /* renamed from: w  reason: collision with root package name */
    String f8091w;

    /* renamed from: x  reason: collision with root package name */
    private w0.c f8092x;

    /* renamed from: y  reason: collision with root package name */
    RelativeLayout f8093y;

    /* renamed from: s  reason: collision with root package name */
    int f8087s = -1;

    /* renamed from: u  reason: collision with root package name */
    int f8089u = 0;

    /* renamed from: z  reason: collision with root package name */
    int f8094z = 100;
    int A = 0;
    w0.g B = new d();
    androidx.viewpager.widget.a C = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            WOqyeiK wOqyeiK = WOqyeiK.this;
            D8ZS9RTR.S0(wOqyeiK, wOqyeiK.f8087s, g.a(wOqyeiK.f8086r));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            int size = ZZcINlcxH.f8162n.size();
            if (size > 2) {
                int i6 = size - 2;
                if (ZZcINlcxH.f8162n.get(i6) instanceof XSQp3A) {
                    WOqyeiK.this.finish();
                    ((XSQp3A) ZZcINlcxH.f8162n.get(i6)).j1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            WOqyeiK wOqyeiK = WOqyeiK.this;
            MSqCZ2mQ.T0(wOqyeiK, wOqyeiK.f8090v, 0, 0, 0L);
        }
    }

    /* loaded from: classes.dex */
    class d implements w0.g {
        d() {
        }

        @Override // w0.g
        public void a(ImageView imageView, float f6, float f7) {
            WOqyeiK.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class e extends androidx.viewpager.widget.a {
        e() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return WOqyeiK.this.f8088t.length;
        }

        @Override // androidx.viewpager.widget.a
        public Object g(ViewGroup viewGroup, int i6) {
            if (WOqyeiK.this.f8088t[i6] == null) {
                com.secret.AD.e eVar = new com.secret.AD.e(WOqyeiK.this, WOqyeiK.D);
                viewGroup.addView(eVar, new ViewGroup.LayoutParams(-1, -1));
                return eVar;
            }
            WOqyeiK wOqyeiK = WOqyeiK.this;
            f fVar = new f(wOqyeiK, i6);
            viewGroup.addView(fVar, new ViewGroup.LayoutParams(-1, -1));
            return fVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean h(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes.dex */
    class f extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        View f8100b;

        /* renamed from: c  reason: collision with root package name */
        c f8101c;

        /* renamed from: d  reason: collision with root package name */
        Bitmap f8102d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends g4.f {
            a() {
            }

            @Override // g4.f
            public void a(View view) {
                if (MainApplication.f6711r.r() == null) {
                    WOqyeiK.this.M0(TK1dGVzP.class);
                    return;
                }
                f fVar = f.this;
                WOqyeiK.this.s(fVar.f8102d);
            }
        }

        /* loaded from: classes.dex */
        class b extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ WOqyeiK f8105d;

            b(WOqyeiK wOqyeiK) {
                this.f8105d = wOqyeiK;
            }

            @Override // g4.f
            public void a(View view) {
                WOqyeiK.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class c extends com.secret.prettyhezi.controls.s {

            /* loaded from: classes.dex */
            class a implements h.b {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ f f8108a;

                a(f fVar) {
                    this.f8108a = fVar;
                }

                @Override // com.secret.prettyhezi.controls.h.b
                public void a(int i6, String str, String str2, String str3) {
                    WOqyeiK wOqyeiK = WOqyeiK.this;
                    f.this.addView(new com.secret.prettyhezi.View.w(wOqyeiK, i6, wOqyeiK.f8086r, wOqyeiK.f8087s, str2, str3), 0, new RelativeLayout.LayoutParams(-1, -1));
                }
            }

            c(Context context, String str) {
                super(context, null);
                d(new a(f.this));
                e(str);
                setOnPhotoTapListener(WOqyeiK.this.B);
            }

            @Override // com.secret.prettyhezi.controls.s
            protected void f(Bitmap bitmap) {
                f.this.f8100b.clearAnimation();
                f fVar = f.this;
                fVar.removeView(fVar.f8100b);
                if (bitmap != null) {
                    f.this.f8102d = bitmap;
                    setImageBitmap(bitmap);
                    f.this.addView(this, 0, new RelativeLayout.LayoutParams(-1, -1));
                    if (MainApplication.f6711r.a()) {
                        f.this.a();
                    }
                }
            }
        }

        f(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i6 > WOqyeiK.this.f8094z ? i6 : i6 + 1);
            objArr[1] = Integer.valueOf(WOqyeiK.this.f8088t.length - WOqyeiK.this.A);
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
            this.f8100b = WOqyeiK.this.e0();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ZZcINlcxH.i0(34.0f), ZZcINlcxH.i0(34.0f));
            layoutParams2.addRule(13, 1);
            addView(this.f8100b, layoutParams2);
            this.f8101c = new c(zZcINlcxH, WOqyeiK.this.f8088t[i6]);
            setOnClickListener(new b(WOqyeiK.this));
        }

        void a() {
            View a6 = com.secret.prettyhezi.controls.u.a(new z(getContext(), C0382R.drawable.ic_download), 48, 48);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(56.0f), g4.i.r(48.0f));
            layoutParams.bottomMargin = g4.i.r(8.0f);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            addView(a6, layoutParams);
            a6.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#33333333"), 24.0f)));
            a6.setOnClickListener(new a());
        }
    }

    public static void S0(Context context, int i6, int i7, String[] strArr, int i8, String str) {
        Intent intent = new Intent();
        intent.setClass(context, WOqyeiK.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i6);
        bundle.putInt("id", i7);
        bundle.putStringArray("photos", strArr);
        bundle.putInt("index", i8);
        if (str != null) {
            bundle.putString("unlock", str);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void T0(Context context, String[] strArr, String str) {
        Intent intent = new Intent();
        intent.setClass(context, WOqyeiK.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray("photos", strArr);
        bundle.putString("video", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    void U0() {
        int i6;
        String[] strArr;
        String[] strArr2;
        if (com.secret.AD.c.b(D)) {
            String[] strArr3 = this.f8088t;
            int i7 = strArr3.length >= 6 ? 2 : 1;
            this.A = i7;
            String[] strArr4 = new String[strArr3.length + i7];
            if (i7 == 1) {
                int i8 = 0;
                while (true) {
                    strArr2 = this.f8088t;
                    if (i8 >= strArr2.length) {
                        break;
                    }
                    strArr4[i8] = strArr2[i8];
                    i8++;
                }
                strArr4[strArr2.length] = null;
            } else {
                this.f8094z = strArr3.length / 2;
                int i9 = 0;
                while (true) {
                    i6 = this.f8094z;
                    if (i9 >= i6) {
                        break;
                    }
                    strArr4[i9] = this.f8088t[i9];
                    i9++;
                }
                strArr4[i6] = null;
                while (true) {
                    strArr = this.f8088t;
                    if (i6 >= strArr.length) {
                        break;
                    }
                    int i10 = i6 + 1;
                    strArr4[i10] = strArr[i6];
                    i6 = i10;
                }
                strArr4[strArr.length + 1] = null;
            }
            this.f8088t = strArr4;
        }
        w0.c cVar = new w0.c(this);
        this.f8092x = cVar;
        cVar.setBackgroundColor(-16777216);
        this.f8093y.addView(this.f8092x, new RelativeLayout.LayoutParams(-1, -1));
        this.f8092x.setAdapter(this.C);
        this.f8092x.setCurrentItem(this.f8089u);
        this.f8092x.setOffscreenPageLimit(2);
        if (this.f8087s >= 0) {
            TextView b6 = g4.d.b(this, 14.0f, -1, s0(C0382R.string.collect));
            b6.setGravity(17);
            b6.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(58.0f), g4.i.r(30.0f));
            layoutParams.bottomMargin = g4.i.r(15.0f);
            layoutParams.leftMargin = g4.i.r(6.0f);
            layoutParams.addRule(12, -1);
            b6.setOnClickListener(new a());
            this.f8093y.addView(b6, layoutParams);
            String str = this.f8091w;
            if (str != null) {
                TextView c6 = g4.d.c(this, 14, -1, str, 17);
                c6.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
                c6.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, g4.i.r(30.0f));
                layoutParams2.bottomMargin = g4.i.r(60.0f);
                layoutParams2.addRule(12, -1);
                layoutParams2.addRule(14, -1);
                c6.setOnClickListener(new b());
                this.f8093y.addView(c6, layoutParams2);
            }
        }
        if (this.f8090v != null) {
            TextView b7 = g4.d.b(this, 14.0f, -1, "播放视频");
            b7.setGravity(17);
            b7.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(30.0f));
            layoutParams3.bottomMargin = g4.i.r(15.0f);
            layoutParams3.leftMargin = g4.i.r(6.0f);
            layoutParams3.addRule(12, -1);
            b7.setOnClickListener(new c());
            this.f8093y.addView(b7, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8086r = extras.getInt("type", -1);
            this.f8087s = extras.getInt("id", -1);
            this.f8088t = extras.getStringArray("photos");
            this.f8089u = extras.getInt("index");
            this.f8091w = extras.getString("unlock");
            this.f8090v = extras.getString("video");
        }
        RelativeLayout E0 = E0();
        this.f8093y = E0;
        E0.setBackgroundColor(-16777216);
        F0(Color.parseColor("#202020"));
        U0();
    }
}
