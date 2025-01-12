package com.secret.prettyhezi.Game;

import com.secret.prettyhezi.Game.f;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.j;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static long f6563a;

    /* renamed from: b  reason: collision with root package name */
    public static d[] f6564b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.e {
        a() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            b.f6563a = System.currentTimeMillis();
            com.secret.prettyhezi.Server.o c6 = com.secret.prettyhezi.f.c(str, d.class);
            if (c6.code != 200) {
                return;
            }
            b.f6564b = new d[c6.data.items.length];
            int i6 = 0;
            while (true) {
                com.secret.prettyhezi.Server.n[] nVarArr = c6.data.items;
                if (i6 >= nVarArr.length) {
                    return;
                }
                b.f6564b[i6] = (d) nVarArr[i6];
                i6++;
            }
        }
    }

    public static boolean a() {
        com.secret.prettyhezi.Server.a0 r5 = MainApplication.f6711r.r();
        if (r5 == null || !r5.isa) {
            return false;
        }
        d();
        d[] dVarArr = f6564b;
        return dVarArr != null && dVarArr.length > 2;
    }

    public static d b() {
        d[] dVarArr = f6564b;
        if (dVarArr == null || dVarArr.length == 0) {
            return null;
        }
        return dVarArr[(int) (Math.random() * f6564b.length)];
    }

    public static void c() {
        if (i.a() == null) {
            return;
        }
        com.secret.prettyhezi.j.t(i.a() + "api/bonus/wall/json", com.secret.prettyhezi.f.e(new f.b(1)), null, 3, new a());
    }

    public static void d() {
        if (System.currentTimeMillis() > f6563a + 300000) {
            c();
        }
    }
}
