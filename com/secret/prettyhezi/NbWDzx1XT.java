package com.secret.prettyhezi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.controls.o;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class NbWDzx1XT extends ZZcINlcxH {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6772r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6773s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6774t;

    /* renamed from: u  reason: collision with root package name */
    TextView f6775u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6776v;

    /* renamed from: w  reason: collision with root package name */
    com.secret.prettyhezi.controls.o f6777w;

    /* renamed from: q  reason: collision with root package name */
    public boolean f6771q = false;

    /* renamed from: x  reason: collision with root package name */
    String f6778x = HttpUrl.FRAGMENT_ENCODE_SET;

    /* loaded from: classes.dex */
    class a implements o.b {

        /* renamed from: com.secret.prettyhezi.NbWDzx1XT$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0086a implements Runnable {
            RunnableC0086a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NbWDzx1XT.this.finish();
            }
        }

        a() {
        }

        @Override // com.secret.prettyhezi.controls.o.b
        public void a(String str) {
            NbWDzx1XT nbWDzx1XT;
            TextView textView;
            int i6;
            NbWDzx1XT nbWDzx1XT2 = NbWDzx1XT.this;
            if (!nbWDzx1XT2.f6771q) {
                if (!g4.i.K(str).equals(g4.g.a().c())) {
                    NbWDzx1XT.this.f6775u.setVisibility(0);
                    NbWDzx1XT.this.f6777w.c(true);
                    return;
                }
                MainApplication.f6711r.f6729o = System.currentTimeMillis();
                NbWDzx1XT.this.finish();
                return;
            }
            if (nbWDzx1XT2.f6778x.length() > 0) {
                if (NbWDzx1XT.this.f6778x.equals(str)) {
                    NbWDzx1XT nbWDzx1XT3 = NbWDzx1XT.this;
                    nbWDzx1XT3.H(nbWDzx1XT3.s0(C0382R.string.SetupSuccess));
                    g4.g.a().m(g4.i.K(str));
                    NbWDzx1XT.this.f6772r.setEnabled(false);
                    NbWDzx1XT.this.f6773s.postDelayed(new RunnableC0086a(), 200L);
                    return;
                }
                NbWDzx1XT.this.f6777w.c(true);
                NbWDzx1XT.this.f6775u.setVisibility(0);
                nbWDzx1XT = NbWDzx1XT.this;
                textView = nbWDzx1XT.f6775u;
                i6 = C0382R.string.UnMatchPattern;
            } else if (str.length() >= 4) {
                NbWDzx1XT nbWDzx1XT4 = NbWDzx1XT.this;
                nbWDzx1XT4.f6778x = str;
                nbWDzx1XT4.f6774t.setText(nbWDzx1XT4.s0(C0382R.string.DrawPatternAgain));
                NbWDzx1XT.this.f6776v.setVisibility(0);
                NbWDzx1XT.this.f6777w.b();
                return;
            } else {
                NbWDzx1XT.this.f6777w.c(true);
                NbWDzx1XT.this.f6775u.setVisibility(0);
                nbWDzx1XT = NbWDzx1XT.this;
                textView = nbWDzx1XT.f6775u;
                i6 = C0382R.string.Atleast4Points;
            }
            textView.setText(nbWDzx1XT.s0(i6));
        }

        @Override // com.secret.prettyhezi.controls.o.b
        public void b() {
            NbWDzx1XT.this.f6775u.setVisibility(8);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            NbWDzx1XT nbWDzx1XT = NbWDzx1XT.this;
            nbWDzx1XT.f6774t.setText(nbWDzx1XT.s0(C0382R.string.DrawUnlockPattern));
            NbWDzx1XT nbWDzx1XT2 = NbWDzx1XT.this;
            nbWDzx1XT2.f6778x = HttpUrl.FRAGMENT_ENCODE_SET;
            nbWDzx1XT2.f6776v.setVisibility(8);
            NbWDzx1XT.this.f6777w.b();
            NbWDzx1XT.this.f6777w.c(false);
        }
    }

    public static void R0(Context context, boolean z5) {
        Intent intent = new Intent();
        intent.setClass(context, NbWDzx1XT.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSet", z5);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6771q = extras.getBoolean("isSet");
        }
        LinearLayout C0 = C0();
        this.f6772r = C0;
        if (this.f6771q) {
            M(C0, s0(C0382R.string.ScreenLockSetup));
        }
        this.f6772r.setBackgroundColor(-1);
        this.f6772r.setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6773s = linearLayout;
        linearLayout.setOrientation(1);
        this.f6773s.setGravity(1);
        this.f6772r.addView(this.f6773s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        Point o5 = o();
        int r5 = g4.i.r(20.0f);
        int r6 = g4.i.r(270.0f);
        int r7 = g4.i.r(270.0f);
        int i6 = (r5 * 2) + r6;
        int i7 = o5.x;
        if (i6 > i7) {
            r5 = (i7 - r6) / 2;
        }
        this.f6773s.setPadding(0, r5, 0, r5);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.f6773s.addView(relativeLayout, new LinearLayout.LayoutParams(-2, 0, 1.0f));
        this.f6773s.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        this.f6773s.addView(linearLayout3, new LinearLayout.LayoutParams(-2, 0, 1.0f));
        TextView b6 = g4.d.b(this, 16.0f, Color.parseColor("#333333"), s0(this.f6771q ? C0382R.string.DrawUnlockPattern : C0382R.string.ConfirmYourPattern));
        this.f6774t = b6;
        b6.setId(androidx.constraintlayout.widget.g.T0);
        TextView b7 = g4.d.b(this, 14.0f, Color.parseColor("#aa000000"), s0(this.f6771q ? C0382R.string.UnMatchPattern : C0382R.string.WrongPattern));
        this.f6775u = b7;
        b7.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.addView(this.f6774t, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.topMargin = g4.i.r(7.0f);
        layoutParams2.addRule(3, this.f6774t.getId());
        relativeLayout.addView(this.f6775u, layoutParams2);
        com.secret.prettyhezi.controls.o oVar = new com.secret.prettyhezi.controls.o(this);
        this.f6777w = oVar;
        oVar.e(C0382R.drawable.gesture_normal_green, C0382R.drawable.gesture_normal_red, C0382R.drawable.gesture_pressed_green, C0382R.drawable.gesture_pressed_red, g4.i.r(60.0f));
        this.f6777w.d(Color.parseColor("#10caa5"), Color.parseColor("#ff3333"), g4.i.s(2.0f));
        this.f6777w.setPadding(r5, r5, r5, r5);
        this.f6777w.a();
        int i8 = r5 * 2;
        linearLayout2.addView(this.f6777w, new LinearLayout.LayoutParams(r6 + i8, r7 + i8));
        this.f6777w.setCallBack(new a());
        linearLayout3.setGravity(17);
        if (this.f6771q) {
            TextView b8 = g4.d.b(this, 14.0f, Color.parseColor("#0000aa"), s0(C0382R.string.ResetPattern));
            this.f6776v = b8;
            b8.setOnClickListener(new b());
            this.f6776v.setVisibility(8);
        } else {
            this.f6776v = g4.d.b(this, 14.0f, Color.parseColor("#0000aa"), s0(C0382R.string.ForgetPatternHint));
        }
        int r8 = g4.i.r(10.0f);
        this.f6776v.setPadding(r8, r8, r8, r8);
        linearLayout3.addView(this.f6776v);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4 && keyEvent.getAction() == 0) {
            if (this.f6771q) {
                return super.onKeyDown(i6, keyEvent);
            }
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    protected boolean t0() {
        return this.f6771q;
    }
}
