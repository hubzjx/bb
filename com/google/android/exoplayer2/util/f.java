package com.google.android.exoplayer2.util;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final c f4607a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4608b;

    public f() {
        this(c.f4589a);
    }

    public synchronized void a() {
        while (!this.f4608b) {
            wait();
        }
    }

    public synchronized boolean b() {
        boolean z5;
        z5 = this.f4608b;
        this.f4608b = false;
        return z5;
    }

    public synchronized boolean c() {
        return this.f4608b;
    }

    public synchronized boolean d() {
        if (this.f4608b) {
            return false;
        }
        this.f4608b = true;
        notifyAll();
        return true;
    }

    public f(c cVar) {
        this.f4607a = cVar;
    }
}
