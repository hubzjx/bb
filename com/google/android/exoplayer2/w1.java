package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4748a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f4749b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4750c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioManager f4751d;

    /* renamed from: e  reason: collision with root package name */
    private final c f4752e;

    /* renamed from: f  reason: collision with root package name */
    private int f4753f;

    /* renamed from: g  reason: collision with root package name */
    private int f4754g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4755h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4756i;

    /* loaded from: classes.dex */
    public interface b {
        void l(int i6, boolean z5);

        void q(int i6);
    }

    /* loaded from: classes.dex */
    private final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = w1.this.f4749b;
            final w1 w1Var = w1.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.x1
                @Override // java.lang.Runnable
                public final void run() {
                    w1.b(w1.this);
                }
            });
        }
    }

    public w1(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f4748a = applicationContext;
        this.f4749b = handler;
        this.f4750c = bVar;
        AudioManager audioManager = (AudioManager) com.google.android.exoplayer2.util.a.i((AudioManager) applicationContext.getSystemService("audio"));
        this.f4751d = audioManager;
        this.f4753f = 3;
        this.f4754g = f(audioManager, 3);
        this.f4755h = e(audioManager, this.f4753f);
        c cVar = new c();
        this.f4752e = cVar;
        applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(w1 w1Var) {
        w1Var.i();
    }

    private static boolean e(AudioManager audioManager, int i6) {
        boolean isStreamMute;
        if (com.google.android.exoplayer2.util.s0.f4673a < 23) {
            return audioManager.getStreamVolume(i6) == 0;
        }
        isStreamMute = audioManager.isStreamMute(i6);
        return isStreamMute;
    }

    private static int f(AudioManager audioManager, int i6) {
        return audioManager.getStreamVolume(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int f6 = f(this.f4751d, this.f4753f);
        boolean e6 = e(this.f4751d, this.f4753f);
        if (this.f4754g == f6 && this.f4755h == e6) {
            return;
        }
        this.f4754g = f6;
        this.f4755h = e6;
        this.f4750c.l(f6, e6);
    }

    public int c() {
        return this.f4751d.getStreamMaxVolume(this.f4753f);
    }

    public int d() {
        int streamMinVolume;
        if (com.google.android.exoplayer2.util.s0.f4673a >= 28) {
            streamMinVolume = this.f4751d.getStreamMinVolume(this.f4753f);
            return streamMinVolume;
        }
        return 0;
    }

    public void g() {
        if (this.f4756i) {
            return;
        }
        this.f4748a.unregisterReceiver(this.f4752e);
        this.f4756i = true;
    }

    public void h(int i6) {
        if (this.f4753f == i6) {
            return;
        }
        this.f4753f = i6;
        i();
        this.f4750c.q(i6);
    }
}
