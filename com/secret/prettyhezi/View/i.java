package com.secret.prettyhezi.View;

import com.secret.prettyhezi.LpyhZ;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.SLUjG;
import com.secret.prettyhezi.WVGAB1kU;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.d;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public abstract class i extends u {

    /* renamed from: m  reason: collision with root package name */
    public com.secret.prettyhezi.Server.h f7945m;

    /* loaded from: classes.dex */
    class a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7946a;

        /* renamed from: com.secret.prettyhezi.View.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0128a implements s.f {
            C0128a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                MainApplication.f6711r.m().f(i.this.f7945m.f7112t);
                t j6 = i.this.j();
                i iVar = i.this;
                j6.z(iVar.f8044i, iVar);
            }
        }

        a(ZZcINlcxH zZcINlcxH) {
            this.f7946a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f7946a.I0();
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + com.secret.prettyhezi.g.b(i.this.f7945m.f7112t) + "/unlock/destory/json?id=" + i.this.f8044i.id, true, new s.e(this.f7946a, new C0128a()));
        }
    }

    public i(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
    }

    @Override // com.secret.prettyhezi.View.u
    public void k() {
        ZZcINlcxH zZcINlcxH = (ZZcINlcxH) getContext();
        if ((zZcINlcxH instanceof LpyhZ) || (zZcINlcxH instanceof SLUjG)) {
            super.k();
        } else {
            zZcINlcxH.B("移除后再次观看需要重新解锁，确定移除？", new a(zZcINlcxH), true);
        }
    }

    public void p() {
        com.secret.prettyhezi.Server.a0 r5 = MainApplication.f6711r.r();
        com.secret.prettyhezi.Server.h hVar = this.f7945m;
        int i6 = hVar.f7112t;
        boolean z5 = false;
        if (r5.grade == 0) {
            z5 = (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) ? true : true;
            if (z5 || hVar.fc >= 999) {
                com.secret.prettyhezi.User.f.k(g4.i.j(), z5 ? 1 : 2);
                return;
            }
        } else if (hVar.fc >= 999 && !MainApplication.f6711r.r().permission.f7107p1 && (i6 == 1 || i6 == 3)) {
            WVGAB1kU.s1(g4.i.j(), false);
            return;
        }
        Class Z0 = WVGAB1kU.Z0(this.f7945m.f7112t);
        if (Z0 != null) {
            com.secret.prettyhezi.Server.h hVar2 = this.f7945m;
            ((ZZcINlcxH) getContext()).O0(Z0, hVar2.id, hVar2.f7112t);
        }
        d.a GetModeItems = com.secret.prettyhezi.d.GetModeItems(this.f7945m.f7112t);
        if (GetModeItems != null) {
            GetModeItems.addItem((com.secret.prettyhezi.Server.h) com.secret.prettyhezi.f.a(this.f7945m, com.secret.prettyhezi.Server.h.class));
        }
    }
}
