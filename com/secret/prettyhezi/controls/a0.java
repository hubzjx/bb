package com.secret.prettyhezi.controls;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class a0 extends LinearLayout {

    /* renamed from: i  reason: collision with root package name */
    static long f8286i;

    /* renamed from: j  reason: collision with root package name */
    static long f8287j;

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f8288b;

    /* renamed from: c  reason: collision with root package name */
    f f8289c;

    /* renamed from: d  reason: collision with root package name */
    int f8290d;

    /* renamed from: e  reason: collision with root package name */
    String f8291e;

    /* renamed from: f  reason: collision with root package name */
    View f8292f;

    /* renamed from: g  reason: collision with root package name */
    FrameLayout f8293g;

    /* renamed from: h  reason: collision with root package name */
    String f8294h;

    /* loaded from: classes.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 0) {
                int x5 = (int) motionEvent.getX();
                int y5 = (int) motionEvent.getY();
                String format = String.format("%d,%d", Integer.valueOf((x5 * 300) / a0.this.f8293g.getWidth()), Integer.valueOf((y5 * 240) / a0.this.f8293g.getHeight()));
                if (a0.this.f8294h.isEmpty()) {
                    a0.this.f8294h = format;
                } else {
                    StringBuilder sb = new StringBuilder();
                    a0 a0Var = a0.this;
                    sb.append(a0Var.f8294h);
                    sb.append(",");
                    sb.append(format);
                    a0Var.f8294h = sb.toString();
                }
                a0.this.a(x5, y5);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            a0.this.b();
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8297d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f8298e;

        c(ZZcINlcxH zZcINlcxH, f fVar) {
            this.f8297d = zZcINlcxH;
            this.f8298e = fVar;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f8297d.j(a0.this);
            this.f8298e.a();
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            String str;
            if (a0.this.f8294h.isEmpty() || (str = a0.this.f8291e) == null || str.isEmpty()) {
                return;
            }
            a0.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {
        e(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            c0 c0Var = (c0) com.secret.prettyhezi.f.d(str, c0.class);
            if (c0Var.code != 200) {
                a0.this.f8288b.y(c0Var.err);
                a0.this.f8289c.a();
                return;
            }
            String str2 = a0.this.f8288b.getFilesDir().getAbsolutePath().toString() + "/tmp_robot_thumb.jpg";
            g4.i.S(c0Var.data.thumb, str2);
            Bitmap decodeFile = BitmapFactory.decodeFile(str2);
            String str3 = a0.this.f8288b.getFilesDir().getAbsolutePath().toString() + "/tmp_robot_image.jpg";
            g4.i.S(c0Var.data.image, str3);
            Bitmap decodeFile2 = BitmapFactory.decodeFile(str3);
            a0.this.f8292f.setBackground(new BitmapDrawable(decodeFile));
            a0.this.f8293g.setBackground(new BitmapDrawable(decodeFile2));
            a0 a0Var = a0.this;
            a0Var.f8291e = c0Var.data.key;
            a0Var.f8294h = HttpUrl.FRAGMENT_ENCODE_SET;
            a0Var.f8293g.removeAllViews();
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public void a() {
        }

        public abstract void b(String str, String str2);
    }

    public a0(ZZcINlcxH zZcINlcxH, int i6, f fVar) {
        super(zZcINlcxH);
        this.f8294h = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f8288b = zZcINlcxH;
        this.f8289c = fVar;
        this.f8290d = i6;
        setOrientation(1);
        setGravity(1);
        int r5 = g4.i.r(12.0f);
        setPadding(0, r5, 0, r5);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(g4.i.r(300.0f), -2));
        linearLayout.addView(g4.d.b(zZcINlcxH, 16.0f, -16777216, "请在下图"), new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(g4.d.b(zZcINlcxH, 16.0f, -16776961, "依次"), new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(g4.d.b(zZcINlcxH, 16.0f, -16777216, "点击:"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        View view = new View(zZcINlcxH);
        this.f8292f = view;
        linearLayout.addView(view, new LinearLayout.LayoutParams(g4.i.r(150.0f), g4.i.r(40.0f)));
        this.f8293g = new FrameLayout(zZcINlcxH);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(300.0f), g4.i.r(240.0f));
        layoutParams.topMargin = g4.i.r(8.0f);
        layoutParams.bottomMargin = g4.i.r(16.0f);
        addView(this.f8293g, layoutParams);
        this.f8293g.setOnTouchListener(new a());
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        addView(linearLayout2, new LinearLayout.LayoutParams(g4.i.r(300.0f), -2));
        u a6 = u.a(new z(zZcINlcxH, C0382R.drawable.refresh2), 24, 24);
        linearLayout2.addView(a6, new LinearLayout.LayoutParams(g4.i.r(48.0f), g4.i.r(48.0f)));
        a6.setBackground(g4.i.f(0, Color.parseColor("#f0f0f0")));
        a6.setOnClickListener(new b());
        linearLayout2.addView(new View(zZcINlcxH), new LinearLayout.LayoutParams(0, g4.i.r(10.0f), 1.0f));
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, zZcINlcxH.s0(C0382R.string.cancel), 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(42.0f));
        layoutParams2.rightMargin = g4.i.r(12.0f);
        linearLayout2.addView(c6, layoutParams2);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#0938F7"), 5.0f), g4.i.b(Color.parseColor("#1A94E6"), 5.0f)));
        c6.setOnClickListener(new c(zZcINlcxH, fVar));
        TextView c7 = g4.d.c(zZcINlcxH, 16, -1, zZcINlcxH.s0(C0382R.string.ok), 17);
        linearLayout2.addView(c7, new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(42.0f)));
        c7.setBackground(g4.i.d(g4.i.b(Color.parseColor("#1A1AE6"), 5.0f), g4.i.b(Color.parseColor("#1A94E6"), 5.0f)));
        c7.setOnClickListener(new d());
        b();
    }

    void a(int i6, int i7) {
        View view = new View(this.f8288b);
        view.setBackground(g4.i.c(-65536, 8.0f, -16777216, 1.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g4.i.r(16.0f), g4.i.r(16.0f));
        layoutParams.leftMargin = i6 - (layoutParams.width / 2);
        layoutParams.topMargin = i7 - (layoutParams.height / 2);
        this.f8293g.addView(view, layoutParams);
    }

    void b() {
        if (System.currentTimeMillis() - f8286i < 5000) {
            this.f8288b.q("请不要频繁刷新");
            return;
        }
        f8286i = System.currentTimeMillis();
        this.f8288b.I0();
        String a6 = MainApplication.f6711r.n(15).a();
        com.secret.prettyhezi.j.t(a6 + "/api/captcha", com.secret.prettyhezi.f.e(new b0()), null, 2, new e(this.f8288b));
    }

    void c() {
        if (System.currentTimeMillis() - f8287j < 5000) {
            this.f8288b.q("请不要频繁刷新");
            return;
        }
        f8287j = System.currentTimeMillis();
        this.f8288b.j(this);
        this.f8289c.b(this.f8291e, this.f8294h);
    }
}
