package com.secret.AD;

import android.widget.LinearLayout;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends u {

    /* renamed from: o  reason: collision with root package name */
    static int f5899o;

    /* renamed from: p  reason: collision with root package name */
    static ArrayList f5900p;

    /* renamed from: m  reason: collision with root package name */
    g f5901m;

    /* renamed from: n  reason: collision with root package name */
    f f5902n;

    public b(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
        this.f5901m = null;
        this.f5902n = null;
        this.f8041f = false;
        this.f8045j = false;
        f fVar = new f(zZcINlcxH);
        this.f5902n = fVar;
        addView(fVar, new LinearLayout.LayoutParams(this.f8039d, -1));
        g gVar = new g(zZcINlcxH, i6);
        this.f5901m = gVar;
        addView(gVar, new LinearLayout.LayoutParams(this.f8039d, -1));
    }

    public static g.a p() {
        if (f5900p == null) {
            f5900p = c.a(2);
            f5899o = 0;
        }
        if (f5900p.size() == 0) {
            return null;
        }
        g.a aVar = (g.a) f5900p.get(f5899o);
        int i6 = f5899o + 1;
        f5899o = i6;
        if (i6 == f5900p.size()) {
            f5899o = 0;
        }
        return aVar;
    }

    public static void q() {
        if (f5900p == null) {
            f5900p = c.a(2);
            f5899o = 0;
        }
        ArrayList arrayList = f5900p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(f5900p.size());
        arrayList2.addAll(f5900p);
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            int random = (int) (Math.random() * size);
            if (random != 0) {
                arrayList2.add(0, (g.a) arrayList2.remove(random));
            }
        }
        f5900p = arrayList2;
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        if (com.secret.prettyhezi.Game.b.a() && Math.random() > 0.8500000238418579d) {
            this.f8037b = this.f8039d;
            this.f5901m.setVisibility(8);
            this.f5902n.setVisibility(0);
            this.f5902n.a();
            return;
        }
        this.f5901m.setVisibility(0);
        this.f5902n.setVisibility(8);
        com.secret.prettyhezi.Server.a aVar = (com.secret.prettyhezi.Server.a) nVar;
        this.f8037b = g.f(aVar.ad, this.f8039d);
        this.f5901m.c(aVar.ad);
    }
}
