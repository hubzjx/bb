package com.google.android.exoplayer2;

import android.os.Handler;
/* loaded from: classes.dex */
public final class k1 {

    /* renamed from: a  reason: collision with root package name */
    private final b f3784a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3785b;

    /* renamed from: c  reason: collision with root package name */
    private final y1 f3786c;

    /* renamed from: d  reason: collision with root package name */
    private int f3787d;

    /* renamed from: e  reason: collision with root package name */
    private Object f3788e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f3789f;

    /* renamed from: g  reason: collision with root package name */
    private int f3790g;

    /* renamed from: h  reason: collision with root package name */
    private long f3791h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3792i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3793j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3794k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3795l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3796m;

    /* loaded from: classes.dex */
    public interface a {
        void a(k1 k1Var);
    }

    /* loaded from: classes.dex */
    public interface b {
        void p(int i6, Object obj);
    }

    public k1(a aVar, b bVar, y1 y1Var, int i6, Handler handler) {
        this.f3785b = aVar;
        this.f3784a = bVar;
        this.f3786c = y1Var;
        this.f3789f = handler;
        this.f3790g = i6;
    }

    public synchronized boolean a() {
        com.google.android.exoplayer2.util.a.g(this.f3793j);
        com.google.android.exoplayer2.util.a.g(this.f3789f.getLooper().getThread() != Thread.currentThread());
        while (!this.f3795l) {
            wait();
        }
        return this.f3794k;
    }

    public boolean b() {
        return this.f3792i;
    }

    public Handler c() {
        return this.f3789f;
    }

    public Object d() {
        return this.f3788e;
    }

    public long e() {
        return this.f3791h;
    }

    public b f() {
        return this.f3784a;
    }

    public y1 g() {
        return this.f3786c;
    }

    public int h() {
        return this.f3787d;
    }

    public int i() {
        return this.f3790g;
    }

    public synchronized boolean j() {
        return this.f3796m;
    }

    public synchronized void k(boolean z5) {
        this.f3794k = z5 | this.f3794k;
        this.f3795l = true;
        notifyAll();
    }

    public k1 l() {
        com.google.android.exoplayer2.util.a.g(!this.f3793j);
        if (this.f3791h == -9223372036854775807L) {
            com.google.android.exoplayer2.util.a.a(this.f3792i);
        }
        this.f3793j = true;
        this.f3785b.a(this);
        return this;
    }

    public k1 m(Object obj) {
        com.google.android.exoplayer2.util.a.g(!this.f3793j);
        this.f3788e = obj;
        return this;
    }

    public k1 n(int i6) {
        com.google.android.exoplayer2.util.a.g(!this.f3793j);
        this.f3787d = i6;
        return this;
    }
}
