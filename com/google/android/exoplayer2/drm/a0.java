package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.s0;
import java.util.UUID;
/* loaded from: classes.dex */
public final class a0 implements y {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3620d;

    /* renamed from: a  reason: collision with root package name */
    public final UUID f3621a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3622b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3623c;

    static {
        boolean z5;
        if ("Amazon".equals(s0.f4675c)) {
            String str = s0.f4676d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z5 = true;
                f3620d = z5;
            }
        }
        z5 = false;
        f3620d = z5;
    }

    public a0(UUID uuid, byte[] bArr, boolean z5) {
        this.f3621a = uuid;
        this.f3622b = bArr;
        this.f3623c = z5;
    }
}
