package com.secret.prettyhezi.Video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.s0;
import com.google.common.collect.a0;
import com.google.common.collect.y;
import com.google.common.collect.z;
import com.secret.prettyhezi.Video.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q2.e;
import q2.i0;
import q2.l;
import q2.o;
/* loaded from: classes.dex */
public final class a implements e, i0 {

    /* renamed from: r  reason: collision with root package name */
    public static final z f7811r = k();

    /* renamed from: s  reason: collision with root package name */
    public static final y f7812s = y.of(6100000L, 3800000L, 2100000L, 1300000L, 590000L);

    /* renamed from: t  reason: collision with root package name */
    public static final y f7813t = y.of(218000L, 159000L, 145000L, 130000L, 112000L);

    /* renamed from: u  reason: collision with root package name */
    public static final y f7814u = y.of(2200000L, 1300000L, 930000L, 730000L, 530000L);

    /* renamed from: v  reason: collision with root package name */
    public static final y f7815v = y.of(4800000L, 2700000L, 1800000L, 1200000L, 630000L);

    /* renamed from: w  reason: collision with root package name */
    public static final y f7816w = y.of(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);

    /* renamed from: a  reason: collision with root package name */
    private final Context f7817a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f7818b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.C0208a f7819c;

    /* renamed from: d  reason: collision with root package name */
    private final e0 f7820d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c f7821e;

    /* renamed from: f  reason: collision with root package name */
    private int f7822f;

    /* renamed from: g  reason: collision with root package name */
    private long f7823g;

    /* renamed from: h  reason: collision with root package name */
    private long f7824h;

    /* renamed from: i  reason: collision with root package name */
    private long f7825i;

    /* renamed from: j  reason: collision with root package name */
    private int f7826j;

    /* renamed from: k  reason: collision with root package name */
    private long f7827k;

    /* renamed from: l  reason: collision with root package name */
    private long f7828l;

    /* renamed from: m  reason: collision with root package name */
    private long f7829m;

    /* renamed from: n  reason: collision with root package name */
    private long f7830n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7831o;

    /* renamed from: p  reason: collision with root package name */
    private int f7832p;

    /* renamed from: q  reason: collision with root package name */
    MSqCZ2mQ f7833q;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7834a;

        /* renamed from: b  reason: collision with root package name */
        private Map f7835b;

        /* renamed from: c  reason: collision with root package name */
        private int f7836c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.util.c f7837d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7838e;

        public b(Context context) {
            this.f7834a = context == null ? null : context.getApplicationContext();
            this.f7835b = c(s0.L(context));
            this.f7836c = 2000;
            this.f7837d = com.google.android.exoplayer2.util.c.f4589a;
            this.f7838e = true;
        }

        private static y b(String str) {
            y yVar = a.f7811r.get((Object) str);
            return yVar.isEmpty() ? y.of(2, 2, 2, 2, 2) : yVar;
        }

        private static Map c(String str) {
            y b6 = b(str);
            HashMap hashMap = new HashMap(6);
            hashMap.put(0, 1000000L);
            y yVar = a.f7812s;
            hashMap.put(2, (Long) yVar.get(((Integer) b6.get(0)).intValue()));
            hashMap.put(3, (Long) a.f7813t.get(((Integer) b6.get(1)).intValue()));
            hashMap.put(4, (Long) a.f7814u.get(((Integer) b6.get(2)).intValue()));
            hashMap.put(5, (Long) a.f7815v.get(((Integer) b6.get(3)).intValue()));
            hashMap.put(9, (Long) a.f7816w.get(((Integer) b6.get(4)).intValue()));
            hashMap.put(7, (Long) yVar.get(((Integer) b6.get(0)).intValue()));
            return hashMap;
        }

        public a a() {
            return new a(this.f7834a, this.f7835b, this.f7836c, this.f7837d, this.f7838e);
        }

        public b d(int i6, long j6) {
            this.f7835b.put(Integer.valueOf(i6), Long.valueOf(j6));
            return this;
        }

        public b e(long j6) {
            for (Integer num : this.f7835b.keySet()) {
                d(num.intValue(), j6);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: c  reason: collision with root package name */
        private static c f7839c;

        /* renamed from: a  reason: collision with root package name */
        private final Handler f7840a = new Handler(Looper.getMainLooper());

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f7841b = new ArrayList();

        private c() {
        }

        public static synchronized c b(Context context) {
            c cVar;
            synchronized (c.class) {
                if (f7839c == null) {
                    f7839c = new c();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(f7839c, intentFilter);
                }
                cVar = f7839c;
            }
            return cVar;
        }

        private void e() {
            for (int size = this.f7841b.size() - 1; size >= 0; size--) {
                if (((a) ((WeakReference) this.f7841b.get(size)).get()) == null) {
                    this.f7841b.remove(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public void c(a aVar) {
            aVar.o();
        }

        public synchronized void d(final a aVar) {
            e();
            this.f7841b.add(new WeakReference(aVar));
            this.f7840a.post(new Runnable() { // from class: com.secret.prettyhezi.Video.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.this.c(aVar);
                }
            });
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            e();
            for (int i6 = 0; i6 < this.f7841b.size(); i6++) {
                a aVar = (a) ((WeakReference) this.f7841b.get(i6)).get();
                if (aVar != null) {
                    c(aVar);
                }
            }
        }
    }

    private a(Context context, Map map, int i6, com.google.android.exoplayer2.util.c cVar, boolean z5) {
        this.f7833q = null;
        this.f7817a = context != null ? context.getApplicationContext() : null;
        this.f7818b = a0.copyOf(map);
        this.f7819c = new e.a.C0208a();
        this.f7820d = new e0(i6);
        this.f7821e = cVar;
        int W = context == null ? 0 : s0.W(context);
        this.f7826j = W;
        this.f7829m = l(W);
        if (context == null || !z5) {
            return;
        }
        c.b(context).d(this);
    }

    private static z k() {
        z.a builder = z.builder();
        builder.m("AD", 1, 2, 0, 0, 2);
        builder.m("AE", 1, 4, 4, 4, 1);
        builder.m("AF", 4, 4, 3, 4, 2);
        builder.m("AG", 2, 2, 1, 1, 2);
        builder.m("AI", 1, 2, 2, 2, 2);
        builder.m("AL", 1, 1, 0, 1, 2);
        builder.m("AM", 2, 2, 1, 2, 2);
        builder.m("AO", 3, 4, 4, 2, 2);
        builder.m("AR", 2, 4, 2, 2, 2);
        builder.m("AS", 2, 2, 4, 3, 2);
        builder.m("AT", 0, 3, 0, 0, 2);
        builder.m("AU", 0, 2, 0, 1, 1);
        builder.m("AW", 1, 2, 0, 4, 2);
        builder.m("AX", 0, 2, 2, 2, 2);
        builder.m("AZ", 3, 3, 3, 4, 2);
        builder.m("BA", 1, 1, 0, 1, 2);
        builder.m("BB", 0, 2, 0, 0, 2);
        builder.m("BD", 2, 0, 3, 3, 2);
        builder.m("BE", 0, 1, 2, 3, 2);
        builder.m("BF", 4, 4, 4, 2, 2);
        builder.m("BG", 0, 1, 0, 0, 2);
        builder.m("BH", 1, 0, 2, 4, 2);
        builder.m("BI", 4, 4, 4, 4, 2);
        builder.m("BJ", 4, 4, 3, 4, 2);
        builder.m("BL", 1, 2, 2, 2, 2);
        builder.m("BM", 1, 2, 0, 0, 2);
        builder.m("BN", 4, 0, 1, 1, 2);
        builder.m("BO", 2, 3, 3, 2, 2);
        builder.m("BQ", 1, 2, 1, 2, 2);
        builder.m("BR", 2, 4, 2, 1, 2);
        builder.m("BS", 3, 2, 2, 3, 2);
        builder.m("BT", 3, 0, 3, 2, 2);
        builder.m("BW", 3, 4, 2, 2, 2);
        builder.m("BY", 1, 0, 2, 1, 2);
        builder.m("BZ", 2, 2, 2, 1, 2);
        builder.m("CA", 0, 3, 1, 2, 3);
        builder.m("CD", 4, 3, 2, 2, 2);
        builder.m("CF", 4, 2, 2, 2, 2);
        builder.m("CG", 3, 4, 1, 1, 2);
        builder.m("CH", 0, 1, 0, 0, 0);
        builder.m("CI", 3, 3, 3, 3, 2);
        builder.m("CK", 3, 2, 1, 0, 2);
        builder.m("CL", 1, 1, 2, 3, 2);
        builder.m("CM", 3, 4, 3, 2, 2);
        builder.m("CN", 2, 2, 2, 1, 3);
        builder.m("CO", 2, 4, 3, 2, 2);
        builder.m("CR", 2, 3, 4, 4, 2);
        builder.m("CU", 4, 4, 2, 1, 2);
        builder.m("CV", 2, 3, 3, 3, 2);
        builder.m("CW", 1, 2, 0, 0, 2);
        builder.m("CY", 1, 2, 0, 0, 2);
        builder.m("CZ", 0, 1, 0, 0, 2);
        builder.m("DE", 0, 1, 1, 2, 0);
        builder.m("DJ", 4, 1, 4, 4, 2);
        builder.m("DK", 0, 0, 1, 0, 2);
        builder.m("DM", 1, 2, 2, 2, 2);
        builder.m("DO", 3, 4, 4, 4, 2);
        builder.m("DZ", 3, 2, 4, 4, 2);
        builder.m("EC", 2, 4, 3, 2, 2);
        builder.m("EE", 0, 0, 0, 0, 2);
        builder.m("EG", 3, 4, 2, 1, 2);
        builder.m("EH", 2, 2, 2, 2, 2);
        builder.m("ER", 4, 2, 2, 2, 2);
        builder.m("ES", 0, 1, 2, 1, 2);
        builder.m("ET", 4, 4, 4, 1, 2);
        builder.m("FI", 0, 0, 1, 0, 0);
        builder.m("FJ", 3, 0, 3, 3, 2);
        builder.m("FK", 2, 2, 2, 2, 2);
        builder.m("FM", 4, 2, 4, 3, 2);
        builder.m("FO", 0, 2, 0, 0, 2);
        builder.m("FR", 1, 0, 2, 1, 2);
        builder.m("GA", 3, 3, 1, 0, 2);
        builder.m("GB", 0, 0, 1, 2, 2);
        builder.m("GD", 1, 2, 2, 2, 2);
        builder.m("GE", 1, 0, 1, 3, 2);
        builder.m("GF", 2, 2, 2, 4, 2);
        builder.m("GG", 0, 2, 0, 0, 2);
        builder.m("GH", 3, 2, 3, 2, 2);
        builder.m("GI", 0, 2, 0, 0, 2);
        builder.m("GL", 1, 2, 2, 1, 2);
        builder.m("GM", 4, 3, 2, 4, 2);
        builder.m("GN", 4, 3, 4, 2, 2);
        builder.m("GP", 2, 2, 3, 4, 2);
        builder.m("GQ", 4, 2, 3, 4, 2);
        builder.m("GR", 1, 1, 0, 1, 2);
        builder.m("GT", 3, 2, 3, 2, 2);
        builder.m("GU", 1, 2, 4, 4, 2);
        builder.m("GW", 3, 4, 4, 3, 2);
        builder.m("GY", 3, 3, 1, 0, 2);
        builder.m("HK", 0, 2, 3, 4, 2);
        builder.m("HN", 3, 0, 3, 3, 2);
        builder.m("HR", 1, 1, 0, 1, 2);
        builder.m("HT", 4, 3, 4, 4, 2);
        builder.m("HU", 0, 1, 0, 0, 2);
        builder.m("ID", 3, 2, 2, 3, 2);
        builder.m("IE", 0, 0, 1, 1, 2);
        builder.m("IL", 1, 0, 2, 3, 2);
        builder.m("IM", 0, 2, 0, 1, 2);
        builder.m("IN", 2, 1, 3, 3, 2);
        builder.m("IO", 4, 2, 2, 4, 2);
        builder.m("IQ", 3, 2, 4, 3, 2);
        builder.m("IR", 4, 2, 3, 4, 2);
        builder.m("IS", 0, 2, 0, 0, 2);
        builder.m("IT", 0, 0, 1, 1, 2);
        builder.m("JE", 2, 2, 0, 2, 2);
        builder.m("JM", 3, 3, 4, 4, 2);
        builder.m("JO", 1, 2, 1, 1, 2);
        builder.m("JP", 0, 2, 0, 1, 3);
        builder.m("KE", 3, 4, 2, 2, 2);
        builder.m("KG", 1, 0, 2, 2, 2);
        builder.m("KH", 2, 0, 4, 3, 2);
        builder.m("KI", 4, 2, 3, 1, 2);
        builder.m("KM", 4, 2, 2, 3, 2);
        builder.m("KN", 1, 2, 2, 2, 2);
        builder.m("KP", 4, 2, 2, 2, 2);
        builder.m("KR", 0, 2, 1, 1, 1);
        builder.m("KW", 2, 3, 1, 1, 1);
        builder.m("KY", 1, 2, 0, 0, 2);
        builder.m("KZ", 1, 2, 2, 3, 2);
        builder.m("LA", 2, 2, 1, 1, 2);
        builder.m("LB", 3, 2, 0, 0, 2);
        builder.m("LC", 1, 1, 0, 0, 2);
        builder.m("LI", 0, 2, 2, 2, 2);
        builder.m("LK", 2, 0, 2, 3, 2);
        builder.m("LR", 3, 4, 3, 2, 2);
        builder.m("LS", 3, 3, 2, 3, 2);
        builder.m("LT", 0, 0, 0, 0, 2);
        builder.m("LU", 0, 0, 0, 0, 2);
        builder.m("LV", 0, 0, 0, 0, 2);
        builder.m("LY", 4, 2, 4, 3, 2);
        builder.m("MA", 2, 1, 2, 1, 2);
        builder.m("MC", 0, 2, 2, 2, 2);
        builder.m("MD", 1, 2, 0, 0, 2);
        builder.m("ME", 1, 2, 1, 2, 2);
        builder.m("MF", 1, 2, 1, 0, 2);
        builder.m("MG", 3, 4, 3, 3, 2);
        builder.m("MH", 4, 2, 2, 4, 2);
        builder.m("MK", 1, 0, 0, 0, 2);
        builder.m("ML", 4, 4, 1, 1, 2);
        builder.m("MM", 2, 3, 2, 2, 2);
        builder.m("MN", 2, 4, 1, 1, 2);
        builder.m("MO", 0, 2, 4, 4, 2);
        builder.m("MP", 0, 2, 2, 2, 2);
        builder.m("MQ", 2, 2, 2, 3, 2);
        builder.m("MR", 3, 0, 4, 2, 2);
        builder.m("MS", 1, 2, 2, 2, 2);
        builder.m("MT", 0, 2, 0, 1, 2);
        builder.m("MU", 3, 1, 2, 3, 2);
        builder.m("MV", 4, 3, 1, 4, 2);
        builder.m("MW", 4, 1, 1, 0, 2);
        builder.m("MX", 2, 4, 3, 3, 2);
        builder.m("MY", 2, 0, 3, 3, 2);
        builder.m("MZ", 3, 3, 2, 3, 2);
        builder.m("NA", 4, 3, 2, 2, 2);
        builder.m("NC", 2, 0, 4, 4, 2);
        builder.m("NE", 4, 4, 4, 4, 2);
        builder.m("NF", 2, 2, 2, 2, 2);
        builder.m("NG", 3, 3, 2, 2, 2);
        builder.m("NI", 3, 1, 4, 4, 2);
        builder.m("NL", 0, 2, 4, 2, 0);
        builder.m("NO", 0, 1, 1, 0, 2);
        builder.m("NP", 2, 0, 4, 3, 2);
        builder.m("NR", 4, 2, 3, 1, 2);
        builder.m("NU", 4, 2, 2, 2, 2);
        builder.m("NZ", 0, 2, 1, 2, 4);
        builder.m("OM", 2, 2, 0, 2, 2);
        builder.m("PA", 1, 3, 3, 4, 2);
        builder.m("PE", 2, 4, 4, 4, 2);
        builder.m("PF", 2, 2, 1, 1, 2);
        builder.m("PG", 4, 3, 3, 2, 2);
        builder.m("PH", 3, 0, 3, 4, 4);
        builder.m("PK", 3, 2, 3, 3, 2);
        builder.m("PL", 1, 0, 2, 2, 2);
        builder.m("PM", 0, 2, 2, 2, 2);
        builder.m("PR", 1, 2, 2, 3, 4);
        builder.m("PS", 3, 3, 2, 2, 2);
        builder.m("PT", 1, 1, 0, 0, 2);
        builder.m("PW", 1, 2, 3, 0, 2);
        builder.m("PY", 2, 0, 3, 3, 2);
        builder.m("QA", 2, 3, 1, 2, 2);
        builder.m("RE", 1, 0, 2, 1, 2);
        builder.m("RO", 1, 1, 1, 2, 2);
        builder.m("RS", 1, 2, 0, 0, 2);
        builder.m("RU", 0, 1, 0, 1, 2);
        builder.m("RW", 4, 3, 3, 4, 2);
        builder.m("SA", 2, 2, 2, 1, 2);
        builder.m("SB", 4, 2, 4, 2, 2);
        builder.m("SC", 4, 2, 0, 1, 2);
        builder.m("SD", 4, 4, 4, 3, 2);
        builder.m("SE", 0, 0, 0, 0, 2);
        builder.m("SG", 0, 0, 3, 3, 4);
        builder.m("SH", 4, 2, 2, 2, 2);
        builder.m("SI", 0, 1, 0, 0, 2);
        builder.m("SJ", 2, 2, 2, 2, 2);
        builder.m("SK", 0, 1, 0, 0, 2);
        builder.m("SL", 4, 3, 3, 1, 2);
        builder.m("SM", 0, 2, 2, 2, 2);
        builder.m("SN", 4, 4, 4, 3, 2);
        builder.m("SO", 3, 4, 4, 4, 2);
        builder.m("SR", 3, 2, 3, 1, 2);
        builder.m("SS", 4, 1, 4, 2, 2);
        builder.m("ST", 2, 2, 1, 2, 2);
        builder.m("SV", 2, 1, 4, 4, 2);
        builder.m("SX", 2, 2, 1, 0, 2);
        builder.m("SY", 4, 3, 2, 2, 2);
        builder.m("SZ", 3, 4, 3, 4, 2);
        builder.m("TC", 1, 2, 1, 0, 2);
        builder.m("TD", 4, 4, 4, 4, 2);
        builder.m("TG", 3, 2, 1, 0, 2);
        builder.m("TH", 1, 3, 4, 3, 0);
        builder.m("TJ", 4, 4, 4, 4, 2);
        builder.m("TL", 4, 1, 4, 4, 2);
        builder.m("TM", 4, 2, 1, 2, 2);
        builder.m("TN", 2, 1, 1, 1, 2);
        builder.m("TO", 3, 3, 4, 2, 2);
        builder.m("TR", 1, 2, 1, 1, 2);
        builder.m("TT", 1, 3, 1, 3, 2);
        builder.m("TV", 3, 2, 2, 4, 2);
        builder.m("TW", 0, 0, 0, 0, 1);
        builder.m("TZ", 3, 3, 3, 2, 2);
        builder.m("UA", 0, 3, 0, 0, 2);
        builder.m("UG", 3, 2, 2, 3, 2);
        builder.m("US", 0, 1, 3, 3, 3);
        builder.m("UY", 2, 1, 1, 1, 2);
        builder.m("UZ", 2, 0, 3, 2, 2);
        builder.m("VC", 2, 2, 2, 2, 2);
        builder.m("VE", 4, 4, 4, 4, 2);
        builder.m("VG", 2, 2, 1, 2, 2);
        builder.m("VI", 1, 2, 2, 4, 2);
        builder.m("VN", 0, 1, 4, 4, 2);
        builder.m("VU", 4, 1, 3, 1, 2);
        builder.m("WS", 3, 1, 4, 2, 2);
        builder.m("XK", 1, 1, 1, 0, 2);
        builder.m("YE", 4, 4, 4, 4, 2);
        builder.m("YT", 3, 2, 1, 3, 2);
        builder.m("ZA", 2, 3, 2, 2, 2);
        builder.m("ZM", 3, 2, 2, 3, 2);
        builder.m("ZW", 3, 3, 3, 3, 2);
        return builder.h();
    }

    private long l(int i6) {
        Long l6 = (Long) this.f7818b.get(Integer.valueOf(i6));
        if (l6 == null) {
            l6 = (Long) this.f7818b.get(0);
        }
        if (l6 == null) {
            l6 = 1000000L;
        }
        return l6.longValue();
    }

    private static boolean m(o oVar, boolean z5) {
        return z5 && !oVar.d(8);
    }

    private void n(int i6, long j6, long j7) {
        if (i6 == 0 && j6 == 0 && j7 == this.f7830n) {
            return;
        }
        this.f7830n = j7;
        this.f7819c.c(i6, j6, j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        int W;
        if (this.f7831o) {
            W = this.f7832p;
        } else {
            Context context = this.f7817a;
            W = context == null ? 0 : s0.W(context);
        }
        if (this.f7826j == W) {
            return;
        }
        this.f7826j = W;
        if (W != 1 && W != 0 && W != 8) {
            this.f7829m = l(W);
            long c6 = this.f7821e.c();
            n(this.f7822f > 0 ? (int) (c6 - this.f7823g) : 0, this.f7824h, this.f7829m);
            this.f7823g = c6;
            this.f7824h = 0L;
            this.f7828l = 0L;
            this.f7827k = 0L;
            this.f7820d.i();
        }
    }

    @Override // q2.i0
    public synchronized void a(l lVar, o oVar, boolean z5) {
        if (m(oVar, z5)) {
            if (this.f7822f == 0) {
                this.f7823g = this.f7821e.c();
                this.f7825i = System.currentTimeMillis();
            }
            this.f7822f++;
        }
    }

    @Override // q2.e
    public void b(e.a aVar) {
        this.f7819c.e(aVar);
    }

    @Override // q2.e
    public i0 c() {
        return this;
    }

    @Override // q2.i0
    public synchronized void d(l lVar, o oVar, boolean z5) {
        if (m(oVar, z5)) {
            com.google.android.exoplayer2.util.a.g(this.f7822f > 0);
            long c6 = this.f7821e.c();
            int i6 = (int) (c6 - this.f7823g);
            this.f7827k += i6;
            long j6 = this.f7828l;
            long j7 = this.f7824h;
            this.f7828l = j6 + j7;
            if (i6 > 0) {
                this.f7820d.c((int) Math.sqrt(j7), (((float) j7) * 8000.0f) / i6);
                if (this.f7827k >= 2000 || this.f7828l >= 524288) {
                    this.f7829m = this.f7820d.f(0.5f);
                    MSqCZ2mQ mSqCZ2mQ = this.f7833q;
                    if (mSqCZ2mQ != null) {
                        mSqCZ2mQ.y1();
                    }
                }
                n(i6, this.f7824h, this.f7829m);
                this.f7823g = c6;
                this.f7824h = 0L;
                this.f7825i = System.currentTimeMillis();
            }
            this.f7822f--;
        }
    }

    @Override // q2.e
    public synchronized long e() {
        return this.f7829m;
    }

    @Override // q2.i0
    public void f(l lVar, o oVar, boolean z5) {
    }

    @Override // q2.i0
    public synchronized void g(l lVar, o oVar, boolean z5, int i6) {
        if (m(oVar, z5)) {
            this.f7824h += i6;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f7829m <= 1 || currentTimeMillis - this.f7825i > 2000) {
                this.f7829m = (this.f7824h * 8000) / (currentTimeMillis - this.f7825i);
                this.f7825i = currentTimeMillis;
                MSqCZ2mQ mSqCZ2mQ = this.f7833q;
                if (mSqCZ2mQ != null) {
                    mSqCZ2mQ.y1();
                }
            }
        }
    }

    @Override // q2.e
    public void h(Handler handler, e.a aVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f7819c.b(handler, aVar);
    }

    public void i(MSqCZ2mQ mSqCZ2mQ) {
        this.f7833q = mSqCZ2mQ;
    }
}
