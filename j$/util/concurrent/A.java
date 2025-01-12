package j$.util.concurrent;

import g.AbstractC0350j$s0;
import g.C0277j$a0;
import g.C0310j$i0;
import g.j$B;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
/* loaded from: classes2.dex */
public final class A extends Random {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f11052d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicLong f11053e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal f11054f;

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal f11055g;

    /* renamed from: a  reason: collision with root package name */
    long f11056a;

    /* renamed from: b  reason: collision with root package name */
    int f11057b;

    /* renamed from: c  reason: collision with root package name */
    boolean f11058c = true;

    static {
        long i6;
        if (((Boolean) AccessController.doPrivileged(new v())).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            i6 = seed[0] & 255;
            for (int i7 = 1; i7 < 8; i7++) {
                i6 = (i6 << 8) | (seed[i7] & 255);
            }
        } else {
            i6 = i(System.nanoTime()) ^ i(System.currentTimeMillis());
        }
        f11053e = new AtomicLong(i6);
        f11054f = new ThreadLocal();
        f11055g = new w();
        new ObjectStreamField("rnd", Long.TYPE);
        new ObjectStreamField("initialized", Boolean.TYPE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int a(int i6) {
        int i7 = i6 ^ (i6 << 13);
        int i8 = i7 ^ (i7 >>> 17);
        int i9 = i8 ^ (i8 << 5);
        ((A) f11055g.get()).f11057b = i9;
        return i9;
    }

    public static A b() {
        A a6 = (A) f11055g.get();
        if (a6.f11057b == 0) {
            g();
        }
        return a6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int c() {
        return ((A) f11055g.get()).f11057b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void g() {
        int addAndGet = f11052d.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long i6 = i(f11053e.getAndAdd(-4942790177534073029L));
        A a6 = (A) f11055g.get();
        a6.f11056a = i6;
        a6.f11057b = addAndGet;
    }

    private static int h(long j6) {
        long j7 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        return (int) (((j7 ^ (j7 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    private static long i(long j6) {
        long j7 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
        return j8 ^ (j8 >>> 33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double d(double d6, double d7) {
        double nextLong = (nextLong() >>> 11) * 1.1102230246251565E-16d;
        if (d6 < d7) {
            double d8 = ((d7 - d6) * nextLong) + d6;
            return d8 >= d7 ? Double.longBitsToDouble(Double.doubleToLongBits(d7) - 1) : d8;
        }
        return nextLong;
    }

    @Override // java.util.Random
    public final DoubleStream doubles() {
        return j$B.g(AbstractC0350j$s0.U(new x(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d)));
    }

    @Override // java.util.Random
    public final DoubleStream doubles(double d6, double d7) {
        if (d6 < d7) {
            return j$B.g(AbstractC0350j$s0.U(new x(0L, Long.MAX_VALUE, d6, d7)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j6) {
        if (j6 >= 0) {
            return j$B.g(AbstractC0350j$s0.U(new x(0L, j6, Double.MAX_VALUE, 0.0d)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j6, double d6, double d7) {
        if (j6 >= 0) {
            if (d6 < d7) {
                return j$B.g(AbstractC0350j$s0.U(new x(0L, j6, d6, d7)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e(int i6, int i7) {
        int i8;
        int h6 = h(j());
        if (i6 < i7) {
            int i9 = i7 - i6;
            int i10 = i9 - 1;
            if ((i9 & i10) == 0) {
                i8 = h6 & i10;
            } else if (i9 > 0) {
                int i11 = h6 >>> 1;
                while (true) {
                    int i12 = i11 + i10;
                    i8 = i11 % i9;
                    if (i12 - i8 >= 0) {
                        break;
                    }
                    i11 = h(j()) >>> 1;
                }
            } else {
                while (true) {
                    if (h6 >= i6 && h6 < i7) {
                        return h6;
                    }
                    h6 = h(j());
                }
            }
            return i8 + i6;
        }
        return h6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long f(long j6, long j7) {
        long i6 = i(j());
        if (j6 >= j7) {
            return i6;
        }
        long j8 = j7 - j6;
        long j9 = j8 - 1;
        if ((j8 & j9) == 0) {
            return (i6 & j9) + j6;
        }
        if (j8 > 0) {
            while (true) {
                long j10 = i6 >>> 1;
                long j11 = j10 + j9;
                long j12 = j10 % j8;
                if (j11 - j12 >= 0) {
                    return j12 + j6;
                }
                i6 = i(j());
            }
        } else {
            while (true) {
                if (i6 >= j6 && i6 < j7) {
                    return i6;
                }
                i6 = i(j());
            }
        }
    }

    @Override // java.util.Random
    public final IntStream ints() {
        return C0277j$a0.g(AbstractC0350j$s0.e0(new y(0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0)));
    }

    @Override // java.util.Random
    public final IntStream ints(int i6, int i7) {
        if (i6 < i7) {
            return C0277j$a0.g(AbstractC0350j$s0.e0(new y(0L, Long.MAX_VALUE, i6, i7)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final IntStream ints(long j6) {
        if (j6 >= 0) {
            return C0277j$a0.g(AbstractC0350j$s0.e0(new y(0L, j6, Integer.MAX_VALUE, 0)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final IntStream ints(long j6, int i6, int i7) {
        if (j6 >= 0) {
            if (i6 < i7) {
                return C0277j$a0.g(AbstractC0350j$s0.e0(new y(0L, j6, i6, i7)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    final long j() {
        long j6 = this.f11056a - 7046029254386353131L;
        this.f11056a = j6;
        return j6;
    }

    @Override // java.util.Random
    public final LongStream longs() {
        return C0310j$i0.g(AbstractC0350j$s0.g0(new z(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L)));
    }

    @Override // java.util.Random
    public final LongStream longs(long j6) {
        if (j6 >= 0) {
            return C0310j$i0.g(AbstractC0350j$s0.g0(new z(0L, j6, Long.MAX_VALUE, 0L)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final LongStream longs(long j6, long j7) {
        if (j6 < j7) {
            return C0310j$i0.g(AbstractC0350j$s0.g0(new z(0L, Long.MAX_VALUE, j6, j7)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final LongStream longs(long j6, long j7, long j8) {
        if (j6 >= 0) {
            if (j7 < j8) {
                return C0310j$i0.g(AbstractC0350j$s0.g0(new z(0L, j6, j7, j8)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    protected final int next(int i6) {
        return (int) (i(j()) >>> (64 - i6));
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return h(j()) < 0;
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return (i(j()) >>> 11) * 1.1102230246251565E-16d;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (h(j()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public final double nextGaussian() {
        ThreadLocal threadLocal = f11054f;
        Double d6 = (Double) threadLocal.get();
        if (d6 != null) {
            threadLocal.set(null);
            return d6.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d7 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d7 < 1.0d && d7 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d7) * (-2.0d)) / d7);
                f11054f.set(new Double(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    @Override // java.util.Random
    public final int nextInt() {
        return h(j());
    }

    @Override // java.util.Random
    public final int nextInt(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        int h6 = h(j());
        int i7 = i6 - 1;
        if ((i6 & i7) == 0) {
            return h6 & i7;
        }
        while (true) {
            int i8 = h6 >>> 1;
            int i9 = i8 + i7;
            int i10 = i8 % i6;
            if (i9 - i10 >= 0) {
                return i10;
            }
            h6 = h(j());
        }
    }

    @Override // java.util.Random
    public final long nextLong() {
        return i(j());
    }

    @Override // java.util.Random
    public final void setSeed(long j6) {
        if (this.f11058c) {
            throw new UnsupportedOperationException();
        }
    }
}
