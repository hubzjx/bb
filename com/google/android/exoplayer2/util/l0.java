package com.google.android.exoplayer2.util;

import android.os.Trace;
/* loaded from: classes.dex */
public abstract class l0 {
    public static void a(String str) {
        if (s0.f4673a >= 18) {
            b(str);
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (s0.f4673a >= 18) {
            d();
        }
    }

    private static void d() {
        Trace.endSection();
    }
}
