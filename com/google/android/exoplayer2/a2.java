package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
/* loaded from: classes.dex */
final class a2 {

    /* renamed from: a  reason: collision with root package name */
    private final WifiManager f3308a;

    /* renamed from: b  reason: collision with root package name */
    private WifiManager.WifiLock f3309b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3310c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3311d;

    public a2(Context context) {
        this.f3308a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f3309b;
        if (wifiLock == null) {
            return;
        }
        if (this.f3310c && this.f3311d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void a(boolean z5) {
        if (z5 && this.f3309b == null) {
            WifiManager wifiManager = this.f3308a;
            if (wifiManager == null) {
                com.google.android.exoplayer2.util.n.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.f3309b = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.f3310c = z5;
        c();
    }

    public void b(boolean z5) {
        this.f3311d = z5;
        c();
    }
}
