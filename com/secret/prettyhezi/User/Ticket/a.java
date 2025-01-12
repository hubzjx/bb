package com.secret.prettyhezi.User.Ticket;

import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.share.DyOuR;
import g4.i;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static long f7700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.User.Ticket.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0121a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7701a;

        C0121a(ZZcINlcxH zZcINlcxH) {
            this.f7701a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f7701a.M0(DyOuR.class);
        }
    }

    public static void a() {
        a0 r5 = MainApplication.f6711r.r();
        ZZcINlcxH j6 = i.j();
        if (r5 == null || j6 == null || r5.permission.f7109p3 || r5.cards <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (f7700a == 0) {
            f7700a = currentTimeMillis;
            j6.B("你有一张超级浏览权限卡，可以无限制浏览全部内容，快去使用吧", new C0121a(j6), false);
        }
    }
}
