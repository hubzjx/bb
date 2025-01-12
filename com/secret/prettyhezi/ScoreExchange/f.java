package com.secret.prettyhezi.ScoreExchange;

import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static b.a f7098a;

    /* loaded from: classes.dex */
    class a extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7099a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.e f7100b;

        /* renamed from: com.secret.prettyhezi.ScoreExchange.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0109a implements Runnable {
            RunnableC0109a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f7100b.a(0);
            }
        }

        a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.e eVar) {
            this.f7099a = zZcINlcxH;
            this.f7100b = eVar;
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            b bVar = (b) com.secret.prettyhezi.f.d(str, b.class);
            if (bVar.code == 200) {
                f.f7098a = bVar.data;
                if (this.f7099a.isFinishing() && this.f7099a.isDestroyed()) {
                    return;
                }
                this.f7099a.runOnUiThread(new RunnableC0109a());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public c[] news;
            public d[] types;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public float cny;
    }

    /* loaded from: classes.dex */
    public static class d implements Serializable {
        public int amount;
        public int id;
    }

    public static void a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.e eVar) {
        if (f7098a != null) {
            eVar.a(0);
            return;
        }
        j.o(v.f7132a + "transaction/load/json", true, new a(zZcINlcxH, eVar));
    }
}
