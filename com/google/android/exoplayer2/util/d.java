package com.google.android.exoplayer2.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f4590a = {0, 0, 0, 1};

    public static String a(int i6, int i7, int i8) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    public static List b(boolean z5) {
        return Collections.singletonList(z5 ? new byte[]{1} : new byte[]{0});
    }

    public static byte[] c(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = f4590a;
        byte[] bArr3 = new byte[bArr2.length + i7];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i6, bArr3, bArr2.length, i7);
        return bArr3;
    }

    private static int d(byte[] bArr, int i6) {
        int length = bArr.length - f4590a.length;
        while (i6 <= length) {
            if (e(bArr, i6)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    private static boolean e(byte[] bArr, int i6) {
        if (bArr.length - i6 <= f4590a.length) {
            return false;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f4590a;
            if (i7 >= bArr2.length) {
                return true;
            }
            if (bArr[i6 + i7] != bArr2[i7]) {
                return false;
            }
            i7++;
        }
    }

    public static Pair f(byte[] bArr) {
        y yVar = new y(bArr);
        yVar.M(9);
        int A = yVar.A();
        yVar.M(20);
        return Pair.create(Integer.valueOf(yVar.E()), Integer.valueOf(A));
    }

    public static boolean g(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    public static byte[][] h(byte[] bArr) {
        if (e(bArr, 0)) {
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            do {
                arrayList.add(Integer.valueOf(i6));
                i6 = d(bArr, i6 + f4590a.length);
            } while (i6 != -1);
            byte[][] bArr2 = new byte[arrayList.size()];
            int i7 = 0;
            while (i7 < arrayList.size()) {
                int intValue = ((Integer) arrayList.get(i7)).intValue();
                int intValue2 = (i7 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i7 + 1)).intValue() : bArr.length) - intValue;
                byte[] bArr3 = new byte[intValue2];
                System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
                bArr2[i7] = bArr3;
                i7++;
            }
            return bArr2;
        }
        return null;
    }
}
