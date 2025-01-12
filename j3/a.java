package j3;

import b.j;
import java.math.RoundingMode;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.http2.Http2Connection;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f11240a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f11241b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f11242c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f11243d = {1, 1, 2, 6, 24, j.J0, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e  reason: collision with root package name */
    static int[] f11244e = {Integer.MAX_VALUE, Integer.MAX_VALUE, DnsOverHttps.MAX_RESPONSE_SIZE, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* renamed from: j3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0182a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11245a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f11245a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11245a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11245a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11245a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11245a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11245a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11245a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11245a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(int i6) {
        return (i6 > 0) & ((i6 & (i6 + (-1))) == 0);
    }

    static int b(int i6, int i7) {
        return (~(~(i6 - i7))) >>> 31;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int c(int i6, RoundingMode roundingMode) {
        b.a("x", i6);
        switch (C0182a.f11245a[roundingMode.ordinal()]) {
            case 1:
                b.b(a(i6));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i6 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i6);
                return (31 - numberOfLeadingZeros) + b((-1257966797) >>> numberOfLeadingZeros, i6);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i6);
    }

    public static int d(int i6, int i7) {
        return com.google.common.primitives.b.g(i6 + i7);
    }
}
