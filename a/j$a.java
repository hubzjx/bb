package a;

import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public abstract /* synthetic */ class j$a {
    public static /* synthetic */ long a(long j6, long j7) {
        long j8 = j6 + j7;
        if (((j7 ^ j6) < 0) || ((j6 ^ j8) >= 0)) {
            return j8;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ boolean b(Unsafe unsafe, Object obj, long j6, Object obj2) {
        while (!unsafe.compareAndSwapObject(obj, j6, (Object) null, obj2)) {
            if (unsafe.getObject(obj, j6) != null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ long c(long j6, long j7) {
        long j8 = j6 % j7;
        if (j8 == 0) {
            return 0L;
        }
        return (((j6 ^ j7) >> 63) | 1) > 0 ? j8 : j8 + j7;
    }

    public static /* synthetic */ long d(long j6) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(-1001L) + Long.numberOfLeadingZeros(1000L) + Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j6);
        if (numberOfLeadingZeros > 65) {
            return j6 * 1000;
        }
        if (numberOfLeadingZeros >= 64) {
            int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
            if ((i6 >= 0) | true) {
                long j7 = j6 * 1000;
                if (i6 == 0 || j7 / j6 == 1000) {
                    return j7;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long e(long j6, long j7) {
        long j8 = j6 / j7;
        return (j6 - (j7 * j8) != 0 && (((j6 ^ j7) >> 63) | 1) < 0) ? j8 - 1 : j8;
    }
}
