package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;
/* loaded from: classes.dex */
final class z1 {

    /* renamed from: a  reason: collision with root package name */
    private final PowerManager f4860a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f4861b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4862c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4863d;

    public z1(Context context) {
        this.f4860a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private void c() {
        PowerManager.WakeLock wakeLock = this.f4861b;
        if (wakeLock == null) {
            return;
        }
        if (this.f4862c && this.f4863d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void a(boolean z5) {
        if (z5 && this.f4861b == null) {
            PowerManager powerManager = this.f4860a;
            if (powerManager == null) {
                com.google.android.exoplayer2.util.n.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.f4861b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.f4862c = z5;
        c();
    }

    public void b(boolean z5) {
        this.f4863d = z5;
        c();
    }
}
