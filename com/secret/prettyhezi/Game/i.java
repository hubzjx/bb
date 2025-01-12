package com.secret.prettyhezi.Game;

import com.secret.prettyhezi.Game.Number.POjTJ;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static l0 f6608a;

    /* renamed from: b  reason: collision with root package name */
    static long f6609b;

    /* loaded from: classes.dex */
    class a extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6610a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.e f6611b;

        /* renamed from: com.secret.prettyhezi.Game.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0085a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f6612a;

            RunnableC0085a(c cVar) {
                this.f6612a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                ZZcINlcxH zZcINlcxH = a.this.f6610a;
                if (zZcINlcxH instanceof POjTJ) {
                    long j6 = this.f6612a.data.loss;
                    if (j6 > 0) {
                        i.c(zZcINlcxH, j6);
                    }
                }
                a.this.f6611b.a(200);
            }
        }

        a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.e eVar) {
            this.f6610a = zZcINlcxH;
            this.f6611b = eVar;
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            c cVar = (c) com.secret.prettyhezi.f.d(str, c.class);
            if (cVar.code == 200) {
                i.f6608a.integral = cVar.data.integral;
                if (this.f6610a.isFinishing() || this.f6610a.isDestroyed()) {
                    return;
                }
                this.f6610a.runOnUiThread(new RunnableC0085a(cVar));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Serializable {
    }

    /* loaded from: classes.dex */
    public static class c extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int integral;
            public long loss;
        }
    }

    public static String a() {
        return MainApplication.f6711r.p(16);
    }

    public static void b(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.e eVar) {
        com.secret.prettyhezi.j.t(a() + "auth/integral/json", com.secret.prettyhezi.f.e(new b()), f6608a.token.token, 3, new a(zZcINlcxH, eVar));
    }

    static void c(ZZcINlcxH zZcINlcxH, long j6) {
        if (j6 > f6609b) {
            f6609b = j6;
            zZcINlcxH.y("你今日已经输掉超过" + j6 + "金币，请注意心态");
        }
    }
}
