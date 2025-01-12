package com.secret.AD;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.ZZcINlcxH;
import g4.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends com.secret.AD.a {

    /* renamed from: f  reason: collision with root package name */
    ArrayList f5904f;

    /* renamed from: g  reason: collision with root package name */
    View f5905g;

    /* renamed from: h  reason: collision with root package name */
    int f5906h;

    /* renamed from: i  reason: collision with root package name */
    public int f5907i;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            d.this.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f5892b == i.j() && d.this.getVisibility() == 0) {
                d dVar = d.this;
                int i6 = dVar.f5906h + 1;
                dVar.f5906h = i6;
                if (i6 == dVar.f5904f.size()) {
                    d.this.f5906h = 0;
                }
                d dVar2 = d.this;
                dVar2.c((g.a) dVar2.f5904f.get(dVar2.f5906h));
            }
            d dVar3 = d.this;
            if (dVar3.f5895e) {
                return;
            }
            dVar3.h();
        }
    }

    public d(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f5905g = null;
        this.f5906h = 0;
        this.f5907i = 5000;
        ArrayList a6 = c.a(i6);
        this.f5904f = a6;
        if (a6.size() == 0) {
            setVisibility(8);
            return;
        }
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, "X", 17);
        this.f5905g = c6;
        c6.setBackground(i.b(-12303292, 12.0f));
        this.f5905g.setOnClickListener(new a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i.r(24.0f), i.r(24.0f));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(10, -1);
        addView(this.f5905g, layoutParams);
        int random = (int) (Math.random() * this.f5904f.size());
        this.f5906h = random;
        c((g.a) this.f5904f.get(random));
        if (this.f5904f.size() > 1) {
            h();
        }
    }

    @Override // com.secret.AD.a
    public RelativeLayout.LayoutParams a() {
        return new RelativeLayout.LayoutParams(-1, f());
    }

    public int f() {
        g.a aVar = this.f5893c;
        if (aVar == null) {
            return 1;
        }
        if (aVar.width <= 0) {
            return i.r(aVar.height);
        }
        int i6 = i.j().o().x;
        g.a aVar2 = this.f5893c;
        return (i6 * aVar2.height) / aVar2.width;
    }

    public void g() {
        View view = this.f5905g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    void h() {
        postDelayed(new b(), this.f5907i);
    }
}
