package com.secret.prettyhezi.Registration;

import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.message.AWsQxAQ;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {

        /* renamed from: com.secret.prettyhezi.Registration.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0096a extends ZZcINlcxH.q {
            C0096a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                ZZcINlcxH j6 = g4.i.j();
                if ((j6 instanceof AWsQxAQ) || (j6 instanceof UUS6bYTjG)) {
                    j6.finish();
                }
            }
        }

        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            b bVar = (b) com.secret.prettyhezi.f.d(str, b.class);
            if (bVar.code != 200) {
                d(bVar.err);
                return;
            }
            int i6 = bVar.grade;
            if (i6 <= 0 || MainApplication.f6711r.r().grade != 0) {
                return;
            }
            MainApplication.f6711r.r().grade = i6;
            MainApplication.f6711r.x();
            EjNkL.N.f6165r.n();
            com.secret.prettyhezi.i.f8489j.r(2, 1);
            g4.i.j().D("注册码购买成功，你已成为正式会员", new C0096a(), false);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends w {
        public int grade;
    }

    public static void a() {
        if (MainApplication.f6711r.r().grade > 0) {
            return;
        }
        com.secret.prettyhezi.j.o(v.f7132a + "user/grade/info/json", true, new a(g4.i.j()));
    }
}
