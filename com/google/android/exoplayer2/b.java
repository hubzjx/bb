package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3553a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3554b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3555c;

    /* loaded from: classes.dex */
    private final class a extends BroadcastReceiver implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final InterfaceC0037b f3556a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f3557b;

        public a(Handler handler, InterfaceC0037b interfaceC0037b) {
            this.f3557b = handler;
            this.f3556a = interfaceC0037b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f3557b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f3555c) {
                this.f3556a.t();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037b {
        void t();
    }

    public b(Context context, Handler handler, InterfaceC0037b interfaceC0037b) {
        this.f3553a = context.getApplicationContext();
        this.f3554b = new a(handler, interfaceC0037b);
    }

    public void b(boolean z5) {
        boolean z6;
        if (z5 && !this.f3555c) {
            this.f3553a.registerReceiver(this.f3554b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            z6 = true;
        } else if (z5 || !this.f3555c) {
            return;
        } else {
            this.f3553a.unregisterReceiver(this.f3554b);
            z6 = false;
        }
        this.f3555c = z6;
    }
}
