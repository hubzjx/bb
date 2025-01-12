package com.secret.prettyhezi;

import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Registration.QHHnp8H;
import com.secret.prettyhezi.Registration.UUS6bYTjG;
import com.secret.prettyhezi.ScoreExchange.ESXWxWYN;
import com.secret.prettyhezi.ScoreExchange.JrBjWAK;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.message.AWsQxAQ;
import java.io.IOException;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class i {

    /* renamed from: j  reason: collision with root package name */
    public static i f8489j;

    /* renamed from: k  reason: collision with root package name */
    static Ringtone f8490k;

    /* renamed from: e  reason: collision with root package name */
    public e f8495e;

    /* renamed from: f  reason: collision with root package name */
    long f8496f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f8497g = false;

    /* renamed from: h  reason: collision with root package name */
    public C0134i f8498h = null;

    /* renamed from: i  reason: collision with root package name */
    boolean f8499i = false;

    /* renamed from: a  reason: collision with root package name */
    com.secret.prettyhezi.ScoreExchange.b[][] f8491a = new com.secret.prettyhezi.ScoreExchange.b[4];

    /* renamed from: b  reason: collision with root package name */
    int[] f8492b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    String[] f8493c = {"buyStatus", "selStatus", "buyCodeStatus", "sellCodeStatus"};

    /* renamed from: d  reason: collision with root package name */
    boolean[] f8494d = new boolean[4];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8500a;

        a(ZZcINlcxH zZcINlcxH) {
            this.f8500a = zZcINlcxH;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.u(this.f8500a);
            ZZcINlcxH zZcINlcxH = this.f8500a;
            if (!(zZcINlcxH instanceof AWsQxAQ) || zZcINlcxH.isDestroyed() || this.f8500a.isFinishing()) {
                return;
            }
            ((AWsQxAQ) this.f8500a).m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8502a;

        b(int i6) {
            this.f8502a = i6;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            i.this.f8494d[this.f8502a] = false;
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            boolean[] zArr = i.this.f8494d;
            int i7 = this.f8502a;
            zArr[i7] = false;
            if (i7 == 2) {
                com.secret.prettyhezi.Registration.f.a();
            }
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            boolean z5;
            boolean z6;
            boolean z7 = false;
            i.this.f8494d[this.f8502a] = false;
            com.secret.prettyhezi.ScoreExchange.c cVar = (com.secret.prettyhezi.ScoreExchange.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.ScoreExchange.c.class);
            if (cVar.code != 200) {
                d();
                return;
            }
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr = cVar.data;
            if (bVarArr.length > 0) {
                int length = bVarArr.length;
                int i6 = 0;
                z6 = false;
                while (true) {
                    if (i6 >= length) {
                        z5 = false;
                        break;
                    }
                    com.secret.prettyhezi.ScoreExchange.b bVar = bVarArr[i6];
                    if (bVar.canTalk()) {
                        z5 = true;
                        break;
                    }
                    if (bVar.status == 0) {
                        z6 = true;
                    }
                    i6++;
                }
            } else {
                z5 = false;
                z6 = false;
            }
            if (!z5 && !z6) {
                i.this.r(this.f8502a, 1);
            }
            if (!z5) {
                i.this.f8495e.f8506a[this.f8502a] = false;
            }
            i iVar = i.this;
            if (!iVar.m(iVar.f8491a[this.f8502a], cVar.data)) {
                int i7 = this.f8502a;
                if (i7 == 1 || i7 == 3) {
                    i iVar2 = i.this;
                    boolean k6 = iVar2.k(iVar2.f8491a[i7], cVar.data, 1);
                    i iVar3 = i.this;
                    boolean k7 = iVar3.k(iVar3.f8491a[this.f8502a], cVar.data, 2);
                    boolean l6 = i.this.l(cVar.data, 1);
                    boolean l7 = i.this.l(cVar.data, 2);
                    if (k6 || k7) {
                        i.p();
                    }
                    int i8 = this.f8502a;
                    if (i8 == 1) {
                        e eVar = i.this.f8495e;
                        eVar.f8509d = l6 && (eVar.f8509d || k6);
                        if (l7 && (eVar.f8510e || k7)) {
                            z7 = true;
                        }
                        eVar.f8510e = z7;
                    } else if (i8 == 3) {
                        e eVar2 = i.this.f8495e;
                        eVar2.f8511f = l6 && (eVar2.f8511f || k6);
                        if (l7 && (eVar2.f8512g || k7)) {
                            z7 = true;
                        }
                        eVar2.f8512g = z7;
                    }
                } else if (i7 == 0) {
                    i iVar4 = i.this;
                    iVar4.f8495e.f8507b = iVar4.l(cVar.data, 1);
                } else if (i7 == 2) {
                    i iVar5 = i.this;
                    iVar5.f8495e.f8508c = iVar5.l(cVar.data, 1);
                }
                i iVar6 = i.this;
                iVar6.f8491a[this.f8502a] = cVar.data;
                iVar6.t();
            }
            if (z5) {
                i.this.i();
            }
        }

        void d() {
            i.this.f8494d[this.f8502a] = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends j.e {
        c() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            i.this.f8499i = false;
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            i.this.f8499i = false;
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            e eVar;
            i.this.f8499i = false;
            C0134i c0134i = (C0134i) com.secret.prettyhezi.f.d(str, C0134i.class);
            if (c0134i.code != 200) {
                d();
                return;
            }
            if (c0134i.countAll() > 0) {
                C0134i c0134i2 = i.this.f8498h;
                if (c0134i2 != null && c0134i2.isSame(c0134i)) {
                    return;
                }
                i iVar = i.this;
                iVar.f8498h = c0134i;
                eVar = iVar.f8495e;
            } else {
                i iVar2 = i.this;
                iVar2.f8498h = null;
                eVar = iVar2.f8495e;
            }
            eVar.f();
            i.this.t();
        }

        void d() {
            i.this.f8499i = false;
        }
    }

    /* loaded from: classes.dex */
    public class d extends Thread {
        public d() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!i.this.f8497g && MainApplication.f() != 0 && i.this.n()) {
                long currentTimeMillis = System.currentTimeMillis();
                i iVar = i.this;
                if (currentTimeMillis - iVar.f8496f >= 30000) {
                    iVar.f8496f = currentTimeMillis;
                    for (int i6 = 0; i6 < 4; i6++) {
                        i iVar2 = i.this;
                        if (iVar2.f8492b[i6] == 2) {
                            iVar2.h(i6);
                        }
                    }
                }
                try {
                    Thread.sleep(20000L);
                } catch (Exception unused) {
                }
            }
            i.this.f8496f = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean[] f8506a = new boolean[4];

        /* renamed from: b  reason: collision with root package name */
        public boolean f8507b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8508c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8509d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8510e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8511f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8512g = false;

        public e() {
        }

        boolean a() {
            return this.f8506a[2];
        }

        boolean b() {
            return this.f8506a[0];
        }

        boolean c() {
            return this.f8506a[3] || this.f8511f || this.f8512g;
        }

        boolean d() {
            return this.f8506a[1] || this.f8509d || this.f8510e;
        }

        boolean e() {
            for (int i6 = 0; i6 < 4; i6++) {
                if (this.f8506a[i6]) {
                    return false;
                }
            }
            return (this.f8509d || this.f8510e || this.f8511f || this.f8512g || this.f8507b || this.f8508c) ? false : true;
        }

        void f() {
            for (int i6 = 0; i6 < 4; i6++) {
                i iVar = i.this;
                C0134i c0134i = iVar.f8498h;
                boolean z5 = c0134i != null && c0134i.count(iVar.f8491a[i6]) > 0;
                if (z5 && !this.f8506a[i6]) {
                    i.p();
                }
                this.f8506a[i6] = z5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends LinearLayout {

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ i f8515d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ ZZcINlcxH f8516e;

            a(i iVar, ZZcINlcxH zZcINlcxH) {
                this.f8515d = iVar;
                this.f8516e = zZcINlcxH;
            }

            @Override // g4.f
            public void a(View view) {
                ((ViewGroup) f.this.getParent()).removeView(f.this);
                this.f8516e.f8165b = false;
                i.s();
                e eVar = i.this.f8495e;
                boolean[] zArr = eVar.f8506a;
                if (!zArr[0]) {
                    if (!zArr[1]) {
                        if (!zArr[3]) {
                            if (eVar.d()) {
                                eVar = i.this.f8495e;
                            } else if (i.this.f8495e.c()) {
                                eVar = i.this.f8495e;
                            } else {
                                e eVar2 = i.this.f8495e;
                                if (!eVar2.f8507b) {
                                    if (eVar2.f8506a[2] || eVar2.f8508c) {
                                        this.f8516e.z0(UUS6bYTjG.class);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        eVar.f8511f = false;
                        eVar.f8512g = false;
                        this.f8516e.z0(QHHnp8H.class);
                        return;
                    }
                    eVar.f8509d = false;
                    eVar.f8510e = false;
                    this.f8516e.z0(ESXWxWYN.class);
                    return;
                }
                this.f8516e.z0(JrBjWAK.class);
            }
        }

        public f(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
            setPadding(g4.i.r(6.0f), g4.i.r(4.0f), g4.i.r(6.0f), g4.i.r(4.0f));
            setOrientation(0);
            setBackground(g4.i.c(Color.parseColor("#eeffffff"), 1.0f, -65536, 4.0f));
            setGravity(17);
            String str = "您有买单需要处理，请立刻处理以免超时";
            int i6 = 15;
            if (!i.this.f8495e.b()) {
                if (i.this.f8495e.d()) {
                    str = "您有卖单需要处理，请立刻处理以免超时影响您的售卖积分权限";
                } else if (i.this.f8495e.c()) {
                    str = "您有卖单需要处理，请立刻处理以免超时影响您的售卖注册码权限";
                } else {
                    e eVar = i.this.f8495e;
                    if (!eVar.f8507b && !eVar.a()) {
                        if (i.this.f8495e.f8508c) {
                            str = "您正在购买注册码，请立刻处理以免超时";
                        } else {
                            str = HttpUrl.FRAGMENT_ENCODE_SET;
                        }
                    }
                }
                i6 = 14;
            }
            addView(g4.d.c(zZcINlcxH, i6, -65536, str, 17), new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (i.this.f8495e.f8507b) {
                com.secret.prettyhezi.ScoreExchange.b j6 = i.this.j(i.this.f8491a[0], 1);
                if (j6 != null) {
                    addView(new g(zZcINlcxH, (int) (1800 - ((System.currentTimeMillis() / 1000) - (j6.update_time + g4.i.o())))), new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(40.0f)));
                } else {
                    i.this.f8495e.f8507b = false;
                }
            }
            if (i.this.f8495e.f8508c) {
                com.secret.prettyhezi.ScoreExchange.b j7 = i.this.j(i.this.f8491a[2], 1);
                if (j7 != null) {
                    addView(new g(zZcINlcxH, (int) (1800 - ((System.currentTimeMillis() / 1000) - (j7.update_time + g4.i.o())))), new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(40.0f)));
                } else {
                    i.this.f8495e.f8508c = false;
                }
            }
            setOnClickListener(new a(i.this, zZcINlcxH));
        }
    }

    /* loaded from: classes.dex */
    class g extends TextView {

        /* renamed from: b  reason: collision with root package name */
        int f8518b;

        /* renamed from: c  reason: collision with root package name */
        ZZcINlcxH f8519c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar;
                if (g.this.getParent() == null || g.this.f8519c.isFinishing() || g.this.f8519c.isDestroyed()) {
                    return;
                }
                gVar.f8518b--;
                g.this.b();
                g.this.a();
            }
        }

        public g(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f8519c = zZcINlcxH;
            this.f8518b = i6;
            setTextSize(18.0f);
            setTextColor(-1);
            setGravity(17);
            setTypeface(null, 1);
            setBackground(g4.i.c(-16777216, 5.0f, -65536, 1.0f));
            b();
            a();
        }

        void a() {
            postDelayed(new a(), 1000L);
        }

        void b() {
            int i6 = this.f8518b;
            setText(String.format("%02d:%02d", Integer.valueOf(i6 / 60), Integer.valueOf(i6 % 60)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h implements Serializable {
        public int chat_id;
        public int msgs;

        h() {
        }
    }

    /* renamed from: com.secret.prettyhezi.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0134i extends com.secret.prettyhezi.Server.w {
        public h[] data;

        public int count(com.secret.prettyhezi.ScoreExchange.b[] bVarArr) {
            h[] hVarArr;
            if (bVarArr == null || bVarArr.length == 0 || (hVarArr = this.data) == null || hVarArr.length == 0) {
                return 0;
            }
            int i6 = 0;
            for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr) {
                h[] hVarArr2 = this.data;
                int length = hVarArr2.length;
                int i7 = 0;
                while (true) {
                    if (i7 < length) {
                        h hVar = hVarArr2[i7];
                        if (hVar.chat_id == bVar.chat_id) {
                            i6 += hVar.msgs;
                            break;
                        }
                        i7++;
                    }
                }
            }
            return i6;
        }

        public int countAll() {
            h[] hVarArr = this.data;
            if (hVarArr == null || hVarArr.length == 0) {
                return 0;
            }
            int i6 = 0;
            for (h hVar : hVarArr) {
                i6 += hVar.msgs;
            }
            return i6;
        }

        public int getCountFor(int i6) {
            h[] hVarArr;
            for (h hVar : this.data) {
                if (hVar.chat_id == i6) {
                    return hVar.msgs;
                }
            }
            return 0;
        }

        public boolean isSame(C0134i c0134i) {
            h[] hVarArr = this.data;
            if (hVarArr.length != c0134i.data.length) {
                return false;
            }
            for (h hVar : hVarArr) {
                if (hVar.msgs != c0134i.getCountFor(hVar.chat_id)) {
                    return false;
                }
            }
            return true;
        }
    }

    public i() {
        for (int i6 = 0; i6 < 4; i6++) {
            this.f8492b[i6] = g4.g.a().d(this.f8493c[i6], 0);
            int[] iArr = this.f8492b;
            if (iArr[i6] != 1) {
                iArr[i6] = 2;
            }
        }
        o();
        this.f8495e = new e();
        f8489j = this;
    }

    public static void p() {
        Ringtone ringtone = RingtoneManager.getRingtone(MainApplication.f6711r, RingtoneManager.getDefaultUri(2));
        f8490k = ringtone;
        ringtone.play();
    }

    public static void s() {
        Ringtone ringtone = f8490k;
        if (ringtone != null) {
            if (ringtone.isPlaying()) {
                f8490k.stop();
            }
            f8490k = null;
        }
    }

    public void a() {
        if (n() && this.f8496f == 0 && MainApplication.f() != 0) {
            new d().start();
        }
    }

    public void b(int i6) {
        h[] hVarArr;
        C0134i c0134i = this.f8498h;
        if (c0134i == null) {
            return;
        }
        for (h hVar : c0134i.data) {
            if (hVar.chat_id == i6) {
                hVar.msgs = 0;
            }
        }
        this.f8495e.f();
    }

    public void c() {
        this.f8497g = true;
    }

    public com.secret.prettyhezi.ScoreExchange.b d(int i6, int i7) {
        com.secret.prettyhezi.ScoreExchange.b[] bVarArr = this.f8491a[i6];
        if (bVarArr != null && bVarArr.length != 0) {
            for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr) {
                if (bVar.chat_id == i7) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public int e(int i6) {
        C0134i c0134i = this.f8498h;
        if (c0134i == null) {
            return 0;
        }
        return c0134i.getCountFor(i6);
    }

    public void f() {
        a0 r5 = MainApplication.f6711r.r();
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = 2;
            if (r5 != null && ((i6 != 2 && r5.grade == 0) || (i6 == 2 && r5.grade > 0))) {
                i7 = 1;
            }
            this.f8492b[i6] = i7;
            g4.g.a().n(this.f8493c[i6], i7);
        }
        a();
    }

    public void g(int i6) {
        int[] iArr = this.f8492b;
        if (iArr[i6] == 2) {
            return;
        }
        iArr[i6] = 2;
        g4.g.a().n(this.f8493c[i6], 2);
        a();
    }

    public void h(int i6) {
        String str;
        com.secret.prettyhezi.Registration.g gVar;
        boolean[] zArr = this.f8494d;
        if (zArr[i6]) {
            return;
        }
        zArr[i6] = true;
        b bVar = new b(i6);
        if (i6 == 0 || i6 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(com.secret.prettyhezi.Server.v.f7132a);
            sb.append(i6 == 0 ? "transaction/buyer/json" : "transaction/seller/json");
            j.o(sb.toString(), true, bVar);
            return;
        }
        if (i6 == 3) {
            str = com.secret.prettyhezi.Server.v.f7132a + "registration/seller/json";
            gVar = new com.secret.prettyhezi.Registration.g("a");
        } else if (i6 != 2) {
            return;
        } else {
            str = com.secret.prettyhezi.Server.v.f7132a + "registration/buyer/json";
            gVar = new com.secret.prettyhezi.Registration.g("a");
        }
        j.r(str, gVar, true, bVar);
    }

    void i() {
        if (this.f8499i) {
            return;
        }
        this.f8499i = true;
        j.o(com.secret.prettyhezi.Server.v.f7132a + "chat/msgs/json", true, new c());
    }

    com.secret.prettyhezi.ScoreExchange.b j(com.secret.prettyhezi.ScoreExchange.b[] bVarArr, int i6) {
        if (bVarArr != null && bVarArr.length != 0) {
            for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr) {
                if (bVar.status == i6) {
                    return bVar;
                }
            }
        }
        return null;
    }

    boolean k(com.secret.prettyhezi.ScoreExchange.b[] bVarArr, com.secret.prettyhezi.ScoreExchange.b[] bVarArr2, int i6) {
        boolean z5;
        if (bVarArr2 != null && bVarArr2.length != 0) {
            boolean z6 = bVarArr != null && bVarArr.length > 0;
            for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr2) {
                if (bVar.status == i6) {
                    if (!z6) {
                        return true;
                    }
                    int length = bVarArr.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            z5 = false;
                            break;
                        }
                        com.secret.prettyhezi.ScoreExchange.b bVar2 = bVarArr[i7];
                        if (bVar2.id != bVar.id) {
                            i7++;
                        } else if (bVar2.status != i6) {
                            return true;
                        } else {
                            z5 = true;
                        }
                    }
                    if (!z5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean l(com.secret.prettyhezi.ScoreExchange.b[] bVarArr, int i6) {
        return j(bVarArr, i6) != null;
    }

    boolean m(com.secret.prettyhezi.ScoreExchange.b[] bVarArr, com.secret.prettyhezi.ScoreExchange.b[] bVarArr2) {
        boolean z5;
        boolean z6 = bVarArr != null && bVarArr.length > 0;
        if (z6 != (bVarArr2 != null && bVarArr2.length > 0)) {
            return false;
        }
        if (z6) {
            if (bVarArr.length != bVarArr2.length) {
                return false;
            }
            for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr) {
                int length = bVarArr2.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z5 = false;
                        break;
                    }
                    com.secret.prettyhezi.ScoreExchange.b bVar2 = bVarArr2[i6];
                    if (bVar2.id != bVar.id) {
                        i6++;
                    } else if (bVar2.status != bVar.status) {
                        return false;
                    } else {
                        z5 = true;
                    }
                }
                if (!z5) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    boolean n() {
        for (int i6 = 0; i6 < 4; i6++) {
            if (this.f8492b[i6] != 1) {
                return true;
            }
        }
        return false;
    }

    void o() {
        a0 r5 = MainApplication.f6711r.r();
        if (r5 != null) {
            if (r5.grade != 0) {
                this.f8492b[2] = 1;
                return;
            }
            int[] iArr = this.f8492b;
            iArr[1] = 1;
            iArr[0] = 1;
            iArr[3] = 1;
        }
    }

    public void q(View view) {
        if (view == null || !(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (viewGroup.getChildAt(i6) instanceof f) {
                ((f) viewGroup.getChildAt(i6)).removeAllViews();
                viewGroup.removeViewAt(i6);
                return;
            }
        }
    }

    public void r(int i6, int i7) {
        this.f8492b[i6] = i7;
        g4.g.a().n(this.f8493c[i6], i7);
    }

    void t() {
        ZZcINlcxH j6 = g4.i.j();
        if (j6 != null) {
            j6.runOnUiThread(new a(j6));
        }
    }

    public void u(ZZcINlcxH zZcINlcxH) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (!(!this.f8495e.e())) {
            if (zZcINlcxH.f8165b) {
                zZcINlcxH.f8165b = false;
                q(zZcINlcxH.m0());
            }
        } else if (this.f8495e.c() && (zZcINlcxH instanceof QHHnp8H)) {
            e eVar = this.f8495e;
            eVar.f8511f = false;
            eVar.f8512g = false;
            ((QHHnp8H) zZcINlcxH).S0();
        } else if (this.f8495e.d() && (zZcINlcxH instanceof ESXWxWYN)) {
            e eVar2 = this.f8495e;
            eVar2.f8509d = false;
            eVar2.f8510e = false;
            ((ESXWxWYN) zZcINlcxH).S0();
        } else if (this.f8495e.b() && (zZcINlcxH instanceof JrBjWAK)) {
            ((JrBjWAK) zZcINlcxH).S0();
        } else if (this.f8495e.a() && (zZcINlcxH instanceof UUS6bYTjG)) {
            ((UUS6bYTjG) zZcINlcxH).S0();
        } else {
            View m02 = zZcINlcxH.m0();
            if (m02 == null || !(m02 instanceof ViewGroup)) {
                return;
            }
            q(m02);
            ViewGroup viewGroup = (ViewGroup) m02;
            zZcINlcxH.f8165b = true;
            View fVar = new f(zZcINlcxH);
            int r5 = g4.i.r(52.0f);
            if (viewGroup instanceof LinearLayout) {
                marginLayoutParams = new LinearLayout.LayoutParams(-1, r5);
                int r6 = g4.i.r(46.0f);
                marginLayoutParams.rightMargin = r6;
                marginLayoutParams.leftMargin = r6;
                viewGroup.addView(fVar, 0, marginLayoutParams);
            } else {
                if (viewGroup instanceof FrameLayout) {
                    marginLayoutParams = new FrameLayout.LayoutParams(-1, r5);
                } else if (viewGroup instanceof RelativeLayout) {
                    marginLayoutParams = new RelativeLayout.LayoutParams(-1, r5);
                } else {
                    marginLayoutParams = null;
                }
                int r7 = g4.i.r(46.0f);
                marginLayoutParams.rightMargin = r7;
                marginLayoutParams.leftMargin = r7;
                viewGroup.addView(fVar, marginLayoutParams);
            }
            if (marginLayoutParams == null) {
                zZcINlcxH.f8165b = false;
            }
        }
    }
}
