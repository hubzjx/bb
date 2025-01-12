package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class c extends com.secret.AD.a {

    /* renamed from: f  reason: collision with root package name */
    TextView f6565f;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6566d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6566d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6566d.M0(Q65u46F.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.secret.AD.a) c.this).f5892b.isDestroyed() || ((com.secret.AD.a) c.this).f5892b.isFinishing()) {
                return;
            }
            if (((com.secret.AD.a) c.this).f5892b == g4.i.j() && c.this.getVisibility() == 0) {
                c.this.k();
            }
            if (((com.secret.AD.a) c.this).f5895e) {
                return;
            }
            c.this.l();
        }
    }

    public c(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        TextView c6 = g4.d.c(zZcINlcxH, 18, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6565f = c6;
        c6.setBackgroundColor(Color.parseColor("#ff0000"));
        addView(this.f6565f, new RelativeLayout.LayoutParams(-1, -1));
        setOnClickListener(new a(zZcINlcxH));
        k();
        l();
    }

    @Override // com.secret.AD.a
    public RelativeLayout.LayoutParams a() {
        return new RelativeLayout.LayoutParams(-1, f());
    }

    public int f() {
        return g4.i.r(60.0f);
    }

    void k() {
        d b6 = com.secret.prettyhezi.Game.b.b();
        this.f6565f.setText("恭喜 " + b6.nickname + "\n" + b6.bonus);
        this.f5892b.f(this.f6565f, 1.3f);
    }

    void l() {
        postDelayed(new b(), 3000L);
    }
}
