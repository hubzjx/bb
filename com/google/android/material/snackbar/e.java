package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
class e {

    /* renamed from: c  reason: collision with root package name */
    private static e f5328c;

    /* renamed from: a  reason: collision with root package name */
    private final Object f5329a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f5330b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e eVar = e.this;
            android.support.v4.media.a.a(message.obj);
            eVar.c(null);
            return true;
        }
    }

    /* loaded from: classes.dex */
    interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
    }

    private e() {
    }

    private boolean a(c cVar, int i6) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        if (f5328c == null) {
            f5328c = new e();
        }
        return f5328c;
    }

    private boolean d(b bVar) {
        return false;
    }

    void c(c cVar) {
        synchronized (this.f5329a) {
            a(cVar, 2);
        }
    }

    public void e(b bVar) {
        synchronized (this.f5329a) {
            if (d(bVar)) {
                throw null;
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f5329a) {
            if (d(bVar)) {
                throw null;
            }
        }
    }
}
