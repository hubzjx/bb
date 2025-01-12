package com.google.android.exoplayer2.decoder;

import java.util.ArrayDeque;
/* loaded from: classes.dex */
public abstract class l implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f3606a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f3607b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque f3608c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque f3609d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    private final j[] f3610e;

    /* renamed from: f  reason: collision with root package name */
    private final k[] f3611f;

    /* renamed from: g  reason: collision with root package name */
    private int f3612g;

    /* renamed from: h  reason: collision with root package name */
    private int f3613h;

    /* renamed from: i  reason: collision with root package name */
    private j f3614i;

    /* renamed from: j  reason: collision with root package name */
    private i f3615j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3616k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3617l;

    /* renamed from: m  reason: collision with root package name */
    private int f3618m;

    /* loaded from: classes.dex */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            l.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(j[] jVarArr, k[] kVarArr) {
        this.f3610e = jVarArr;
        this.f3612g = jVarArr.length;
        for (int i6 = 0; i6 < this.f3612g; i6++) {
            this.f3610e[i6] = h();
        }
        this.f3611f = kVarArr;
        this.f3613h = kVarArr.length;
        for (int i7 = 0; i7 < this.f3613h; i7++) {
            this.f3611f[i7] = i();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f3606a = aVar;
        aVar.start();
    }

    private boolean g() {
        return !this.f3608c.isEmpty() && this.f3613h > 0;
    }

    private boolean l() {
        i j6;
        synchronized (this.f3607b) {
            while (!this.f3617l && !g()) {
                this.f3607b.wait();
            }
            if (this.f3617l) {
                return false;
            }
            j jVar = (j) this.f3608c.removeFirst();
            k[] kVarArr = this.f3611f;
            int i6 = this.f3613h - 1;
            this.f3613h = i6;
            k kVar = kVarArr[i6];
            boolean z5 = this.f3616k;
            this.f3616k = false;
            if (jVar.isEndOfStream()) {
                kVar.addFlag(4);
            } else {
                if (jVar.isDecodeOnly()) {
                    kVar.addFlag(Integer.MIN_VALUE);
                }
                try {
                    j6 = k(jVar, kVar, z5);
                } catch (OutOfMemoryError | RuntimeException e6) {
                    j6 = j(e6);
                }
                if (j6 != null) {
                    synchronized (this.f3607b) {
                        this.f3615j = j6;
                    }
                    return false;
                }
            }
            synchronized (this.f3607b) {
                if (!this.f3616k) {
                    if (kVar.isDecodeOnly()) {
                        this.f3618m++;
                    } else {
                        kVar.skippedOutputBufferCount = this.f3618m;
                        this.f3618m = 0;
                        this.f3609d.addLast(kVar);
                        r(jVar);
                    }
                }
                kVar.release();
                r(jVar);
            }
            return true;
        }
    }

    private void o() {
        if (g()) {
            this.f3607b.notify();
        }
    }

    private void p() {
        i iVar = this.f3615j;
        if (iVar != null) {
            throw iVar;
        }
    }

    private void r(j jVar) {
        jVar.clear();
        j[] jVarArr = this.f3610e;
        int i6 = this.f3612g;
        this.f3612g = i6 + 1;
        jVarArr[i6] = jVar;
    }

    private void t(k kVar) {
        kVar.clear();
        k[] kVarArr = this.f3611f;
        int i6 = this.f3613h;
        this.f3613h = i6 + 1;
        kVarArr[i6] = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        do {
            try {
            } catch (InterruptedException e6) {
                throw new IllegalStateException(e6);
            }
        } while (l());
    }

    @Override // com.google.android.exoplayer2.decoder.g
    public void a() {
        synchronized (this.f3607b) {
            this.f3617l = true;
            this.f3607b.notify();
        }
        try {
            this.f3606a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.g
    public final void flush() {
        synchronized (this.f3607b) {
            this.f3616k = true;
            this.f3618m = 0;
            j jVar = this.f3614i;
            if (jVar != null) {
                r(jVar);
                this.f3614i = null;
            }
            while (!this.f3608c.isEmpty()) {
                r((j) this.f3608c.removeFirst());
            }
            while (!this.f3609d.isEmpty()) {
                ((k) this.f3609d.removeFirst()).release();
            }
        }
    }

    protected abstract j h();

    protected abstract k i();

    protected abstract i j(Throwable th);

    protected abstract i k(j jVar, k kVar, boolean z5);

    @Override // com.google.android.exoplayer2.decoder.g
    /* renamed from: m */
    public final j e() {
        j jVar;
        synchronized (this.f3607b) {
            p();
            com.google.android.exoplayer2.util.a.g(this.f3614i == null);
            int i6 = this.f3612g;
            if (i6 == 0) {
                jVar = null;
            } else {
                j[] jVarArr = this.f3610e;
                int i7 = i6 - 1;
                this.f3612g = i7;
                jVar = jVarArr[i7];
            }
            this.f3614i = jVar;
        }
        return jVar;
    }

    @Override // com.google.android.exoplayer2.decoder.g
    /* renamed from: n */
    public final k d() {
        synchronized (this.f3607b) {
            p();
            if (this.f3609d.isEmpty()) {
                return null;
            }
            return (k) this.f3609d.removeFirst();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.g
    /* renamed from: q */
    public final void c(j jVar) {
        synchronized (this.f3607b) {
            p();
            com.google.android.exoplayer2.util.a.a(jVar == this.f3614i);
            this.f3608c.addLast(jVar);
            o();
            this.f3614i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(k kVar) {
        synchronized (this.f3607b) {
            t(kVar);
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(int i6) {
        com.google.android.exoplayer2.util.a.g(this.f3612g == this.f3610e.length);
        for (j jVar : this.f3610e) {
            jVar.f(i6);
        }
    }
}
