package com.secret.prettyhezi.Server;

import android.os.AsyncTask;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.UQGjREUX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public int f7138a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7140c;

    /* renamed from: d  reason: collision with root package name */
    public g.b f7141d;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f7139b = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public long f7142e = -1;

    /* renamed from: f  reason: collision with root package name */
    com.secret.prettyhezi.e f7143f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7144g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f7145h = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends AsyncTask {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
            r3 = ((com.secret.prettyhezi.Server.g.b) r18.f7146a.f7139b.get(0)).delay;
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
            if (r13 >= r18.f7146a.f7139b.size()) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
            r1 = ((com.secret.prettyhezi.Server.g.b) r18.f7146a.f7139b.get(r13)).delay;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
            if (r1 <= 0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
            if (r3 == (-1)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
            if (r1 >= r3) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a5, code lost:
            r3 = r1;
            r6 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a7, code lost:
            r13 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
            r1 = r18.f7146a;
            r1.f7141d = (com.secret.prettyhezi.Server.g.b) r1.f7139b.get(r6);
            r18.f7146a.f7142e = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
            return java.lang.Long.valueOf(r3);
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Long doInBackground(Void... voidArr) {
            long currentTimeMillis = System.currentTimeMillis();
            long j6 = 99999999;
            int i6 = 10000;
            int i7 = 0;
            while (true) {
                int i8 = 1;
                if (i7 >= x.this.f7139b.size()) {
                    break;
                }
                g.b bVar = (g.b) x.this.f7139b.get(i7);
                long j7 = bVar.disableTime;
                int i9 = i7;
                if (j7 > 0) {
                    if (j7 < currentTimeMillis) {
                        bVar.disableTime = 0L;
                    } else {
                        bVar.delay = 10000L;
                        bVar.detected = true;
                        i7 = i9 + 1;
                    }
                }
                x xVar = x.this;
                if (xVar.f7140c && bVar.sort < i6 && j6 < 10000) {
                    break;
                }
                i6 = bVar.sort;
                long h6 = x.h(bVar.api_url, xVar.f7138a);
                bVar.delay = h6;
                bVar.detected = true;
                if (h6 != -1 && h6 < j6) {
                    if (h6 < 2000) {
                        x xVar2 = x.this;
                        xVar2.f7141d = bVar;
                        xVar2.f7142e = h6;
                        return Long.valueOf(h6);
                    }
                    j6 = h6;
                }
                i7 = i9 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Long l6) {
            x xVar = x.this;
            long j6 = xVar.f7142e;
            xVar.f7144g = false;
            if (xVar.f7138a == 1) {
                v.n(UQGjREUX.h1(xVar.f7141d.api_url));
            }
            x xVar2 = x.this;
            com.secret.prettyhezi.e eVar = xVar2.f7143f;
            if (eVar != null) {
                eVar.a(xVar2.f7142e <= 0 ? -1 : 0);
            }
        }
    }

    /* loaded from: classes.dex */
    private class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        g.b f7147a;

        c(g.b bVar) {
            this.f7147a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Long doInBackground(Void... voidArr) {
            return Long.valueOf(x.h(this.f7147a.api_url, x.this.f7138a));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Long l6) {
            long longValue = l6.longValue();
            x.this.j(this.f7147a, longValue);
            x xVar = x.this;
            xVar.f7145h--;
            if (longValue != -1) {
                long j6 = xVar.f7142e;
                if (j6 == -1 || longValue < j6) {
                    xVar.f7141d = this.f7147a;
                    xVar.f7142e = longValue;
                    x.i(this.f7147a.api_url + " min:" + x.this.f7142e, x.this.f7138a);
                }
            }
            x xVar2 = x.this;
            if (xVar2.f7145h == 0) {
                long j7 = xVar2.f7142e;
            }
        }
    }

    public x(int i6) {
        g.b[] bVarArr;
        this.f7140c = false;
        this.f7141d = null;
        this.f7138a = i6;
        if (MainApplication.f6711r.k() != null) {
            for (g.b bVar : MainApplication.f6711r.k().apiserves) {
                if (bVar.type == i6) {
                    this.f7139b.add(bVar);
                    if (bVar.sort != 0) {
                        this.f7140c = true;
                    }
                }
            }
        }
        if (!this.f7140c && this.f7139b.size() > 1) {
            for (int i7 = 0; i7 < 5; i7++) {
                int random = ((int) (Math.random() * 100.0d)) % this.f7139b.size();
                int random2 = ((int) (Math.random() * 100.0d)) % this.f7139b.size();
                if (random != random2) {
                    Collections.swap(this.f7139b, random, random2);
                }
            }
        }
        if (this.f7139b.size() == 1) {
            this.f7141d = (g.b) this.f7139b.get(0);
        }
    }

    public static long h(String str, int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i6 == 1 ? "/echo/json" : "/echo.js");
        String sb2 = sb.toString();
        if (!sb2.startsWith("http")) {
            sb2 = "http://" + sb2;
        }
        long a6 = com.secret.prettyhezi.j.a(sb2);
        i(sb2 + " " + a6, i6);
        return a6;
    }

    public static void i(String str, int i6) {
    }

    public String a() {
        g.b bVar = this.f7141d;
        if (bVar == null && !this.f7139b.isEmpty()) {
            bVar = (g.b) this.f7139b.get(0);
        }
        if (bVar != null) {
            return bVar.api_url;
        }
        return null;
    }

    public String b(int i6) {
        g.b bVar = this.f7141d;
        int i7 = 0;
        if (bVar == null && !this.f7139b.isEmpty()) {
            bVar = (g.b) this.f7139b.get(0);
        }
        if (bVar != null) {
            if (i6 >= 0 && bVar.cdns != null) {
                while (true) {
                    g.c[] cVarArr = bVar.cdns;
                    if (i7 >= cVarArr.length) {
                        break;
                    }
                    g.c cVar = cVarArr[i7];
                    if (i6 == cVar.type) {
                        return cVar.api_url;
                    }
                    i7++;
                }
            }
            return bVar.api_url;
        }
        return null;
    }

    public void c(com.secret.prettyhezi.e eVar) {
        this.f7143f = eVar;
    }

    public void d() {
        e(true);
    }

    public void e(boolean z5) {
        boolean z6;
        if (this.f7144g) {
            return;
        }
        if (this.f7139b.size() < 2) {
            if (this.f7143f != null) {
                this.f7141d = (g.b) this.f7139b.get(0);
                this.f7143f.a(0);
                return;
            }
            return;
        }
        if (!z5) {
            Iterator it = this.f7139b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z6 = false;
                    break;
                }
                g.b bVar = (g.b) it.next();
                long j6 = bVar.disableTime;
                if (j6 > 0 && j6 < System.currentTimeMillis()) {
                    bVar.disableTime = 0L;
                    z6 = true;
                    break;
                }
            }
            if (!z6 && (!this.f7140c || this.f7141d.equals(((g.b) this.f7139b.get(0)).api_url))) {
                return;
            }
        }
        this.f7144g = true;
        g();
        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void f() {
        g();
        this.f7145h = this.f7139b.size();
        Iterator it = this.f7139b.iterator();
        while (it.hasNext()) {
            new c((g.b) it.next()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void g() {
        this.f7142e = -1L;
        Iterator it = this.f7139b.iterator();
        while (it.hasNext()) {
            g.b bVar = (g.b) it.next();
            bVar.detected = false;
            bVar.delay = -1L;
        }
    }

    void j(g.b bVar, long j6) {
        bVar.delay = j6;
        bVar.detected = true;
    }
}
