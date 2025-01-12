package com.secret.AD;

import android.graphics.Color;
import android.graphics.Point;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.UQGjREUX;
import com.secret.prettyhezi.ZZcINlcxH;
import g4.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.secret.AD.a {

    /* renamed from: i  reason: collision with root package name */
    static boolean f5917i;

    /* renamed from: f  reason: collision with root package name */
    TextView f5918f;

    /* renamed from: g  reason: collision with root package name */
    int f5919g;

    /* renamed from: h  reason: collision with root package name */
    Runnable f5920h;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            h hVar = h.this;
            hVar.f5919g = 0;
            hVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f();
        }
    }

    public h(ZZcINlcxH zZcINlcxH, Runnable runnable) {
        super(zZcINlcxH);
        this.f5919g = 6;
        f5917i = true;
        this.f5920h = runnable;
        ArrayList a6 = c.a(1);
        if (a6.size() == 0) {
            setVisibility(8);
            return;
        }
        int d6 = g4.g.a().d("splashADIndex", 0);
        c((g.a) a6.get(d6 % a6.size()));
        int i6 = d6 + 1;
        g4.g.a().n("splashADIndex", i6 < a6.size() * 10 ? i6 : 0);
        TextView c6 = g4.d.c(zZcINlcxH, 14, -1, "5 跳过", 17);
        this.f5918f = c6;
        c6.setBackground(i.d(i.b(Color.parseColor("#3f000000"), 20.0f), i.b(Color.parseColor("#6f000000"), 20.0f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i.r(60.0f), i.r(40.0f));
        layoutParams.topMargin = i.r(20.0f);
        layoutParams.rightMargin = i.r(20.0f);
        layoutParams.addRule(11, -1);
        addView(this.f5918f, layoutParams);
        f();
        this.f5918f.setOnClickListener(new a());
    }

    public static boolean i() {
        return (f5917i || g4.g.a().e().isEmpty()) ? false : true;
    }

    @Override // com.secret.AD.a
    public RelativeLayout.LayoutParams a() {
        Point o5 = this.f5892b.o();
        return new RelativeLayout.LayoutParams(o5.x, o5.y);
    }

    public void f() {
        if (!((UQGjREUX) this.f5892b).f7161s) {
            this.f5919g--;
        }
        int i6 = this.f5919g;
        if (i6 <= 0) {
            if (i6 == 0) {
                h();
                return;
            }
            return;
        }
        this.f5918f.setVisibility(i6 >= 4 ? 8 : 0);
        this.f5918f.setText(this.f5919g + " 跳过");
        postDelayed(new b(), 1000L);
    }

    public boolean g() {
        return this.f5893c == null || this.f5919g <= 0;
    }

    void h() {
        this.f5920h.run();
    }
}
