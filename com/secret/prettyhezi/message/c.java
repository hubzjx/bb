package com.secret.prettyhezi.message;

import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile com.secret.prettyhezi.message.a[] f8698a;

    /* renamed from: b  reason: collision with root package name */
    static long f8699b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.e {

        /* renamed from: com.secret.prettyhezi.message.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0137a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ZZcINlcxH f8700a;

            RunnableC0137a(ZZcINlcxH zZcINlcxH) {
                this.f8700a = zZcINlcxH;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((HYYYBI) this.f8700a).Y0();
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EjNkL.N.f6165r.l();
            }
        }

        /* renamed from: com.secret.prettyhezi.message.c$a$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0138c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ZZcINlcxH f8703a;

            RunnableC0138c(ZZcINlcxH zZcINlcxH) {
                this.f8703a = zZcINlcxH;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((AWsQxAQ) this.f8703a).l1();
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.secret.prettyhezi.i.p();
            }
        }

        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        @Override // com.secret.prettyhezi.j.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(String str) {
            Runnable runnableC0138c;
            b bVar = (b) com.secret.prettyhezi.f.d(str, b.class);
            if (bVar.code != 200) {
                return;
            }
            c.a(bVar.data);
            ZZcINlcxH j6 = g4.i.j();
            if (j6 instanceof HYYYBI) {
                runnableC0138c = new RunnableC0137a(j6);
            } else if (!(j6 instanceof EjNkL)) {
                if (j6 instanceof AWsQxAQ) {
                    runnableC0138c = new RunnableC0138c(j6);
                }
                if (c.e() <= 0) {
                    j6.runOnUiThread(new d());
                    return;
                }
                return;
            } else {
                runnableC0138c = new b();
            }
            j6.runOnUiThread(runnableC0138c);
            if (c.e() <= 0) {
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends w {
        com.secret.prettyhezi.message.a[] data;

        b() {
        }
    }

    static void a(com.secret.prettyhezi.message.a[] aVarArr) {
        if (aVarArr == null || f8698a == null) {
            f8698a = aVarArr;
        }
        if (f8698a.length != aVarArr.length) {
            f8698a = aVarArr;
        }
        for (com.secret.prettyhezi.message.a aVar : aVarArr) {
            com.secret.prettyhezi.message.a d6 = d(aVar.id);
            if (d6 == null) {
                f8698a = aVarArr;
                return;
            }
            d6.msgs = aVar.msgs;
        }
    }

    public static void b() {
        f8699b = System.currentTimeMillis();
        com.secret.prettyhezi.j.o(v.f7132a + "chat/json", true, new a());
    }

    public static void c() {
        long currentTimeMillis = System.currentTimeMillis() - f8699b;
        if (currentTimeMillis < 60000) {
            return;
        }
        if (f() || currentTimeMillis >= 600000) {
            b();
        }
    }

    public static com.secret.prettyhezi.message.a d(int i6) {
        com.secret.prettyhezi.message.a[] aVarArr;
        if (f8698a == null) {
            return null;
        }
        for (com.secret.prettyhezi.message.a aVar : f8698a) {
            if (aVar.id == i6) {
                return aVar;
            }
        }
        return null;
    }

    public static int e() {
        if (f8698a != null) {
            int i6 = 0;
            for (com.secret.prettyhezi.message.a aVar : f8698a) {
                i6 += aVar.msgs;
            }
            return i6;
        }
        return 0;
    }

    public static boolean f() {
        return f8698a != null && f8698a.length > 0;
    }
}
