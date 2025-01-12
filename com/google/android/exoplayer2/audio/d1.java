package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class d1 {
    public static List a(byte[] bArr) {
        long e6 = e(d(bArr));
        long e7 = e(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(e6));
        arrayList.add(b(e7));
        return arrayList;
    }

    private static byte[] b(long j6) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j6).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static int d(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    private static long e(long j6) {
        return (j6 * 1000000000) / 48000;
    }
}
