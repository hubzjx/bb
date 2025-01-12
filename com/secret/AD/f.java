package com.secret.AD;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.Q65u46F;
import com.secret.prettyhezi.ZZcINlcxH;
import g4.i;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class f extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f5911b;

    /* renamed from: c  reason: collision with root package name */
    TextView f5912c;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f5913d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f5913d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f5913d.M0(Q65u46F.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f5911b.isDestroyed() || f.this.f5911b.isFinishing()) {
                return;
            }
            if (f.this.f5911b == i.j() && f.this.getVisibility() == 0) {
                f.this.a();
            }
            f.this.b();
        }
    }

    public f(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f5911b = zZcINlcxH;
        TextView c6 = g4.d.c(zZcINlcxH, 18, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f5912c = c6;
        c6.setBackgroundColor(Color.parseColor("#ff0000"));
        this.f5912c.setPadding(i.r(20.0f), 0, i.r(20.0f), 0);
        addView(this.f5912c, new RelativeLayout.LayoutParams(-1, -1));
        setOnClickListener(new a(zZcINlcxH));
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        com.secret.prettyhezi.Game.d b6 = com.secret.prettyhezi.Game.b.b();
        if (b6 == null) {
            return;
        }
        this.f5912c.setText("恭喜 " + b6.nickname + "\n" + b6.bonus);
        this.f5911b.f(this.f5912c, 1.3f);
    }

    void b() {
        postDelayed(new b(), 3000L);
    }
}
