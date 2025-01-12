package j$.util.concurrent;

import a.j$a;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public class ConcurrentHashMap extends AbstractMap implements java.util.concurrent.ConcurrentMap, Serializable, ConcurrentMap {

    /* renamed from: g  reason: collision with root package name */
    private static final int f11059g = (1 << (32 - 16)) - 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11060h = 32 - 16;

    /* renamed from: i  reason: collision with root package name */
    static final int f11061i = Runtime.getRuntime().availableProcessors();

    /* renamed from: j  reason: collision with root package name */
    private static final Unsafe f11062j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f11063k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f11064l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f11065m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f11066n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f11067o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f11068p;

    /* renamed from: q  reason: collision with root package name */
    private static final int f11069q;

    /* renamed from: a  reason: collision with root package name */
    volatile transient l[] f11070a;

    /* renamed from: b  reason: collision with root package name */
    private volatile transient l[] f11071b;
    private volatile transient long baseCount;

    /* renamed from: c  reason: collision with root package name */
    private volatile transient c[] f11072c;
    private volatile transient int cellsBusy;

    /* renamed from: d  reason: collision with root package name */
    private transient i f11073d;

    /* renamed from: e  reason: collision with root package name */
    private transient s f11074e;

    /* renamed from: f  reason: collision with root package name */
    private transient e f11075f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    static {
        new ObjectStreamField("segments", n[].class);
        Class cls = Integer.TYPE;
        new ObjectStreamField("segmentMask", cls);
        new ObjectStreamField("segmentShift", cls);
        try {
            Unsafe c6 = u.c();
            f11062j = c6;
            f11063k = c6.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            f11064l = c6.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            f11065m = c6.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            f11066n = c6.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            f11067o = c6.objectFieldOffset(c.class.getDeclaredField("value"));
            f11068p = c6.arrayBaseOffset(l[].class);
            int arrayIndexScale = c6.arrayIndexScale(l[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            f11069q = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
        } catch (Exception e6) {
            throw new Error(e6);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i6 >= 536870912 ? 1073741824 : n(i6 + (i6 >>> 1) + 1);
    }

    public ConcurrentHashMap(int i6, float f6, int i7) {
        if (f6 <= 0.0f || i6 < 0 || i7 <= 0) {
            throw new IllegalArgumentException();
        }
        long j6 = (long) (((i6 < i7 ? i7 : i6) / f6) + 1.0d);
        this.sizeCtl = j6 >= 1073741824 ? 1073741824 : n((int) j6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r1.compareAndSwapLong(r11, r3, r5, r9) == false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(long j6, int i6) {
        int length;
        c cVar;
        long l6;
        l[] lVarArr;
        int length2;
        l[] lVarArr2;
        c[] cVarArr = this.f11072c;
        if (cVarArr == null) {
            Unsafe unsafe = f11062j;
            long j7 = f11065m;
            long j8 = this.baseCount;
            l6 = j8 + j6;
        }
        boolean z5 = true;
        if (cVarArr != null && (length = cVarArr.length - 1) >= 0 && (cVar = cVarArr[length & A.c()]) != null) {
            Unsafe unsafe2 = f11062j;
            long j9 = f11067o;
            long j10 = cVar.value;
            boolean compareAndSwapLong = unsafe2.compareAndSwapLong(cVar, j9, j10, j10 + j6);
            if (!compareAndSwapLong) {
                z5 = compareAndSwapLong;
            } else if (i6 <= 1) {
                return;
            } else {
                l6 = l();
                if (i6 < 0) {
                    return;
                }
                while (true) {
                    int i7 = this.sizeCtl;
                    if (l6 < i7 || (lVarArr = this.f11070a) == null || (length2 = lVarArr.length) >= 1073741824) {
                        return;
                    }
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(length2) | 32768;
                    int i8 = f11060h;
                    if (i7 < 0) {
                        if ((i7 >>> i8) != numberOfLeadingZeros || i7 == numberOfLeadingZeros + 1 || i7 == numberOfLeadingZeros + f11059g || (lVarArr2 = this.f11071b) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (f11062j.compareAndSwapInt(this, f11063k, i7, i7 + 1)) {
                            o(lVarArr, lVarArr2);
                        }
                    } else if (f11062j.compareAndSwapInt(this, f11063k, i7, (numberOfLeadingZeros << i8) + 2)) {
                        o(lVarArr, null);
                    }
                    l6 = l();
                }
            }
        }
        e(j6, z5);
    }

    static final boolean b(l[] lVarArr, int i6, l lVar) {
        return j$a.b(f11062j, lVarArr, (i6 << f11069q) + f11068p, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (obj instanceof Comparable) {
            Class<?> cls = obj.getClass();
            if (cls == String.class) {
                return cls;
            }
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces != null) {
                for (Type type : genericInterfaces) {
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                            return cls;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
        if (r24.f11072c != r7) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009f, code lost:
        r1 = new j$.util.concurrent.c[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a4, code lost:
        if (r2 >= r8) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a6, code lost:
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
        r24.f11072c = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(long j6, boolean z5) {
        int i6;
        boolean z6;
        boolean z7;
        int length;
        boolean z8;
        int length2;
        int c6 = A.c();
        if (c6 == 0) {
            A.g();
            i6 = A.c();
            z6 = true;
        } else {
            i6 = c6;
            z6 = z5;
        }
        int i7 = i6;
        while (true) {
            boolean z9 = false;
            while (true) {
                c[] cVarArr = this.f11072c;
                if (cVarArr != null && (length = cVarArr.length) > 0) {
                    c cVar = cVarArr[(length - 1) & i7];
                    if (cVar != null) {
                        if (z6) {
                            Unsafe unsafe = f11062j;
                            long j7 = f11067o;
                            long j8 = cVar.value;
                            if (unsafe.compareAndSwapLong(cVar, j7, j8, j8 + j6)) {
                                return;
                            }
                            if (this.f11072c == cVarArr && length < f11061i) {
                                if (!z9) {
                                    z9 = true;
                                } else if (this.cellsBusy == 0 && unsafe.compareAndSwapInt(this, f11066n, 0, 1)) {
                                    try {
                                        break;
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            z6 = true;
                        }
                        i7 = A.a(i7);
                    } else if (this.cellsBusy == 0) {
                        c cVar2 = new c(j6);
                        if (this.cellsBusy == 0 && f11062j.compareAndSwapInt(this, f11066n, 0, 1)) {
                            try {
                                c[] cVarArr2 = this.f11072c;
                                if (cVarArr2 != null && (length2 = cVarArr2.length) > 0) {
                                    int i8 = (length2 - 1) & i7;
                                    if (cVarArr2[i8] == null) {
                                        cVarArr2[i8] = cVar2;
                                        z8 = true;
                                        if (!z8) {
                                            return;
                                        }
                                    }
                                }
                                z8 = false;
                                if (!z8) {
                                }
                            } finally {
                            }
                        }
                    }
                    z9 = false;
                    i7 = A.a(i7);
                } else if (this.cellsBusy == 0 && this.f11072c == cVarArr && f11062j.compareAndSwapInt(this, f11066n, 0, 1)) {
                    try {
                        if (this.f11072c == cVarArr) {
                            c[] cVarArr3 = new c[2];
                            cVarArr3[i7 & 1] = new c(j6);
                            this.f11072c = cVarArr3;
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            return;
                        }
                    } finally {
                    }
                } else {
                    Unsafe unsafe2 = f11062j;
                    long j9 = f11065m;
                    long j10 = this.baseCount;
                    if (unsafe2.compareAndSwapLong(this, j9, j10, j10 + j6)) {
                        return;
                    }
                }
            }
        }
    }

    private final l[] g() {
        while (true) {
            l[] lVarArr = this.f11070a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i6 = this.sizeCtl;
            if (i6 < 0) {
                Thread.yield();
            } else if (f11062j.compareAndSwapInt(this, f11063k, i6, -1)) {
                try {
                    l[] lVarArr2 = this.f11070a;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i7 = i6 > 0 ? i6 : 16;
                        l[] lVarArr3 = new l[i7];
                        this.f11070a = lVarArr3;
                        i6 = i7 - (i7 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    this.sizeCtl = i6;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i6;
                    throw th;
                }
            }
        }
    }

    static final void j(l[] lVarArr, int i6, l lVar) {
        f11062j.putObjectVolatile(lVarArr, (i6 << f11069q) + f11068p, lVar);
    }

    static final int k(int i6) {
        return (i6 ^ (i6 >>> 16)) & Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final l m(l[] lVarArr, int i6) {
        return (l) f11062j.getObjectVolatile(lVarArr, (i6 << f11069q) + f11068p);
    }

    private static final int n(int i6) {
        int i7 = i6 - 1;
        int i8 = i7 | (i7 >>> 1);
        int i9 = i8 | (i8 >>> 2);
        int i10 = i9 | (i9 >>> 4);
        int i11 = i10 | (i10 >>> 8);
        int i12 = i11 | (i11 >>> 16);
        if (i12 < 0) {
            return 1;
        }
        if (i12 >= 1073741824) {
            return 1073741824;
        }
        return 1 + i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r15v17, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r6v17, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r6v22, types: [j$.util.concurrent.l] */
    private final void o(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        ConcurrentHashMap concurrentHashMap;
        l[] lVarArr4;
        int i6;
        int i7;
        g gVar;
        ConcurrentHashMap concurrentHashMap2;
        int i8;
        r rVar;
        r rVar2;
        ConcurrentHashMap concurrentHashMap3 = this;
        int length = lVarArr.length;
        int i9 = f11061i;
        int i10 = i9 > 1 ? (length >>> 3) / i9 : length;
        int i11 = i10 < 16 ? 16 : i10;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr5 = new l[length << 1];
                concurrentHashMap3.f11071b = lVarArr5;
                concurrentHashMap3.transferIndex = length;
                lVarArr3 = lVarArr5;
            } catch (Throwable unused) {
                concurrentHashMap3.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar2 = new g(lVarArr3);
        l[] lVarArr6 = lVarArr;
        ConcurrentHashMap concurrentHashMap4 = concurrentHashMap3;
        int i12 = 0;
        int i13 = 0;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            if (z5) {
                int i14 = i12 - 1;
                if (i14 >= i13 || z6) {
                    concurrentHashMap = concurrentHashMap4;
                    lVarArr4 = lVarArr6;
                    i12 = i14;
                    i13 = i13;
                } else {
                    int i15 = concurrentHashMap4.transferIndex;
                    if (i15 <= 0) {
                        concurrentHashMap = concurrentHashMap4;
                        lVarArr4 = lVarArr6;
                        i12 = -1;
                    } else {
                        Unsafe unsafe = f11062j;
                        long j6 = f11064l;
                        int i16 = i15 > i11 ? i15 - i11 : 0;
                        concurrentHashMap = concurrentHashMap4;
                        lVarArr4 = lVarArr6;
                        int i17 = i13;
                        if (unsafe.compareAndSwapInt(this, j6, i15, i16)) {
                            i12 = i15 - 1;
                            i13 = i16;
                        } else {
                            lVarArr6 = lVarArr4;
                            i12 = i14;
                            i13 = i17;
                            concurrentHashMap4 = concurrentHashMap;
                        }
                    }
                }
                lVarArr6 = lVarArr4;
                concurrentHashMap4 = concurrentHashMap;
                z5 = false;
            } else {
                ConcurrentHashMap concurrentHashMap5 = concurrentHashMap4;
                l[] lVarArr7 = lVarArr6;
                int i18 = i13;
                r rVar3 = null;
                if (i12 < 0 || i12 >= length || (i8 = i12 + length) >= length2) {
                    i6 = i11;
                    i7 = length2;
                    gVar = gVar2;
                    if (z6) {
                        this.f11071b = null;
                        this.f11070a = lVarArr3;
                        this.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    concurrentHashMap2 = this;
                    Unsafe unsafe2 = f11062j;
                    long j7 = f11063k;
                    int i19 = concurrentHashMap2.sizeCtl;
                    int i20 = i12;
                    if (!unsafe2.compareAndSwapInt(this, j7, i19, i19 - 1)) {
                        concurrentHashMap4 = concurrentHashMap2;
                        lVarArr6 = lVarArr7;
                        i12 = i20;
                    } else if (i19 - 2 != ((Integer.numberOfLeadingZeros(length) | 32768) << f11060h)) {
                        return;
                    } else {
                        i12 = length;
                        concurrentHashMap4 = concurrentHashMap2;
                        lVarArr6 = lVarArr7;
                        z5 = true;
                        z6 = true;
                    }
                } else {
                    l m5 = m(lVarArr7, i12);
                    if (m5 == null) {
                        z5 = b(lVarArr7, i12, gVar2);
                        i6 = i11;
                        i7 = length2;
                        gVar = gVar2;
                        lVarArr6 = lVarArr7;
                        concurrentHashMap4 = concurrentHashMap5;
                    } else {
                        int i21 = m5.f11088a;
                        if (i21 == -1) {
                            concurrentHashMap2 = concurrentHashMap3;
                            i6 = i11;
                            i7 = length2;
                            gVar = gVar2;
                            lVarArr6 = lVarArr7;
                            concurrentHashMap4 = concurrentHashMap5;
                            z5 = true;
                        } else {
                            synchronized (m5) {
                                if (m(lVarArr7, i12) == m5) {
                                    if (i21 >= 0) {
                                        int i22 = i21 & length;
                                        r rVar4 = m5;
                                        for (r rVar5 = m5.f11091d; rVar5 != null; rVar5 = rVar5.f11091d) {
                                            int i23 = rVar5.f11088a & length;
                                            if (i23 != i22) {
                                                rVar4 = rVar5;
                                                i22 = i23;
                                            }
                                        }
                                        if (i22 == 0) {
                                            rVar = rVar4;
                                        } else {
                                            rVar = null;
                                            rVar3 = rVar4;
                                        }
                                        l lVar = m5;
                                        while (lVar != rVar4) {
                                            int i24 = lVar.f11088a;
                                            int i25 = i11;
                                            Object obj = lVar.f11089b;
                                            int i26 = length2;
                                            Object obj2 = lVar.f11090c;
                                            if ((i24 & length) == 0) {
                                                rVar2 = rVar4;
                                                rVar = new l(i24, obj, obj2, rVar);
                                            } else {
                                                rVar2 = rVar4;
                                                rVar3 = new l(i24, obj, obj2, rVar3);
                                            }
                                            lVar = lVar.f11091d;
                                            i11 = i25;
                                            length2 = i26;
                                            rVar4 = rVar2;
                                        }
                                        i6 = i11;
                                        i7 = length2;
                                        j(lVarArr3, i12, rVar);
                                        j(lVarArr3, i8, rVar3);
                                        j(lVarArr7, i12, gVar2);
                                        gVar = gVar2;
                                    } else {
                                        i6 = i11;
                                        i7 = length2;
                                        if (m5 instanceof q) {
                                            q qVar = (q) m5;
                                            r rVar6 = null;
                                            r rVar7 = null;
                                            l lVar2 = qVar.f11107f;
                                            int i27 = 0;
                                            int i28 = 0;
                                            r rVar8 = null;
                                            while (lVar2 != null) {
                                                q qVar2 = qVar;
                                                int i29 = lVar2.f11088a;
                                                g gVar3 = gVar2;
                                                r rVar9 = new r(i29, lVar2.f11089b, lVar2.f11090c, null, null);
                                                if ((i29 & length) == 0) {
                                                    rVar9.f11112h = rVar7;
                                                    if (rVar7 == null) {
                                                        rVar3 = rVar9;
                                                    } else {
                                                        rVar7.f11091d = rVar9;
                                                    }
                                                    i27++;
                                                    rVar7 = rVar9;
                                                } else {
                                                    rVar9.f11112h = rVar6;
                                                    if (rVar6 == null) {
                                                        rVar8 = rVar9;
                                                    } else {
                                                        rVar6.f11091d = rVar9;
                                                    }
                                                    i28++;
                                                    rVar6 = rVar9;
                                                }
                                                lVar2 = lVar2.f11091d;
                                                qVar = qVar2;
                                                gVar2 = gVar3;
                                            }
                                            q qVar3 = qVar;
                                            g gVar4 = gVar2;
                                            l r5 = i27 <= 6 ? r(rVar3) : i28 != 0 ? new q(rVar3) : qVar3;
                                            l r6 = i28 <= 6 ? r(rVar8) : i27 != 0 ? new q(rVar8) : qVar3;
                                            j(lVarArr3, i12, r5);
                                            j(lVarArr3, i8, r6);
                                            gVar = gVar4;
                                            j(lVarArr, i12, gVar);
                                            lVarArr7 = lVarArr;
                                        }
                                    }
                                    z5 = true;
                                } else {
                                    i6 = i11;
                                    i7 = length2;
                                }
                                gVar = gVar2;
                            }
                            concurrentHashMap4 = this;
                            lVarArr6 = lVarArr7;
                        }
                    }
                    concurrentHashMap2 = this;
                }
                gVar2 = gVar;
                concurrentHashMap3 = concurrentHashMap2;
                i13 = i18;
                i11 = i6;
                length2 = i7;
            }
        }
    }

    private final void p(l[] lVarArr, int i6) {
        int length = lVarArr.length;
        if (length < 64) {
            q(length << 1);
            return;
        }
        l m5 = m(lVarArr, i6);
        if (m5 == null || m5.f11088a < 0) {
            return;
        }
        synchronized (m5) {
            if (m(lVarArr, i6) == m5) {
                r rVar = null;
                l lVar = m5;
                r rVar2 = null;
                while (lVar != null) {
                    r rVar3 = new r(lVar.f11088a, lVar.f11089b, lVar.f11090c, null, null);
                    rVar3.f11112h = rVar2;
                    if (rVar2 == null) {
                        rVar = rVar3;
                    } else {
                        rVar2.f11091d = rVar3;
                    }
                    lVar = lVar.f11091d;
                    rVar2 = rVar3;
                }
                j(lVarArr, i6, new q(rVar));
            }
        }
    }

    private final void q(int i6) {
        int length;
        l[] lVarArr;
        int n5 = i6 >= 536870912 ? 1073741824 : n(i6 + (i6 >>> 1) + 1);
        while (true) {
            int i7 = this.sizeCtl;
            if (i7 < 0) {
                return;
            }
            l[] lVarArr2 = this.f11070a;
            if (lVarArr2 == null || (length = lVarArr2.length) == 0) {
                int i8 = i7 > n5 ? i7 : n5;
                if (f11062j.compareAndSwapInt(this, f11063k, i7, -1)) {
                    try {
                        if (this.f11070a == lVarArr2) {
                            this.f11070a = new l[i8];
                            i7 = i8 - (i8 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i7;
                    }
                } else {
                    continue;
                }
            } else if (n5 <= i7 || length >= 1073741824) {
                return;
            } else {
                if (lVarArr2 == this.f11070a) {
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(length) | 32768;
                    int i9 = f11060h;
                    if (i7 < 0) {
                        if ((i7 >>> i9) != numberOfLeadingZeros || i7 == numberOfLeadingZeros + 1 || i7 == numberOfLeadingZeros + f11059g || (lVarArr = this.f11071b) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (f11062j.compareAndSwapInt(this, f11063k, i7, i7 + 1)) {
                            o(lVarArr2, lVarArr);
                        }
                    } else if (f11062j.compareAndSwapInt(this, f11063k, i7, (numberOfLeadingZeros << i9) + 2)) {
                        o(lVarArr2, null);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [j$.util.concurrent.l] */
    static l r(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (r rVar2 = rVar; rVar2 != null; rVar2 = rVar2.f11091d) {
            l lVar3 = new l(rVar2.f11088a, rVar2.f11089b, rVar2.f11090c, null);
            if (lVar2 == null) {
                lVar = lVar3;
            } else {
                lVar2.f11091d = lVar3;
            }
            lVar2 = lVar3;
        }
        return lVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        l m5;
        l[] lVarArr = this.f11070a;
        long j6 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (lVarArr != null && i6 < lVarArr.length) {
                m5 = m(lVarArr, i6);
                if (m5 == null) {
                    i6++;
                } else {
                    int i7 = m5.f11088a;
                    if (i7 == -1) {
                        break;
                    }
                    synchronized (m5) {
                        if (m(lVarArr, i6) == m5) {
                            for (l lVar = i7 >= 0 ? m5 : m5 instanceof q ? ((q) m5).f11107f : null; lVar != null; lVar = lVar.f11091d) {
                                j6--;
                            }
                            j(lVarArr, i6, null);
                            i6++;
                        }
                    }
                }
            }
            lVarArr = f(lVarArr, m5);
        }
        if (j6 != 0) {
            a(j6, -1);
        }
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        int i6;
        l lVar;
        Object obj2;
        Object obj3;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        int i7 = 0;
        Object obj4 = null;
        int i8 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i9 = (length - 1) & k6;
                    l m5 = m(lVarArr, i9);
                    if (m5 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (b(lVarArr, i9, mVar)) {
                                Object p5 = biFunction.p(obj, null);
                                if (p5 != null) {
                                    lVar = new l(k6, obj, p5, null);
                                    i6 = 1;
                                } else {
                                    i6 = i7;
                                    lVar = null;
                                }
                                j(lVarArr, i9, lVar);
                                i7 = i6;
                                obj4 = p5;
                                i8 = 1;
                            }
                        }
                        if (i8 != 0) {
                        }
                    } else {
                        int i10 = m5.f11088a;
                        if (i10 == -1) {
                            lVarArr = f(lVarArr, m5);
                        } else {
                            synchronized (m5) {
                                try {
                                    if (m(lVarArr, i9) == m5) {
                                        if (i10 >= 0) {
                                            l lVar2 = null;
                                            l lVar3 = m5;
                                            int i11 = 1;
                                            while (true) {
                                                if (lVar3.f11088a != k6 || ((obj3 = lVar3.f11089b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                    l lVar4 = lVar3.f11091d;
                                                    if (lVar4 == null) {
                                                        Object p6 = biFunction.p(obj, null);
                                                        if (p6 != null) {
                                                            lVar3.f11091d = new l(k6, obj, p6, null);
                                                            obj2 = p6;
                                                            i7 = 1;
                                                        } else {
                                                            obj2 = p6;
                                                        }
                                                    } else {
                                                        i11++;
                                                        lVar2 = lVar3;
                                                        lVar3 = lVar4;
                                                    }
                                                }
                                            }
                                            obj2 = biFunction.p(obj, lVar3.f11090c);
                                            if (obj2 != null) {
                                                lVar3.f11090c = obj2;
                                            } else {
                                                l lVar5 = lVar3.f11091d;
                                                if (lVar2 != null) {
                                                    lVar2.f11091d = lVar5;
                                                } else {
                                                    j(lVarArr, i9, lVar5);
                                                }
                                                i7 = -1;
                                            }
                                            i8 = i11;
                                            obj4 = obj2;
                                        } else if (m5 instanceof q) {
                                            q qVar = (q) m5;
                                            r rVar = qVar.f11106e;
                                            r b6 = rVar != null ? rVar.b(k6, obj, null) : null;
                                            Object p7 = biFunction.p(obj, b6 == null ? null : b6.f11090c);
                                            if (p7 == null) {
                                                if (b6 != null) {
                                                    if (qVar.g(b6)) {
                                                        j(lVarArr, i9, r(qVar.f11107f));
                                                    }
                                                    obj4 = p7;
                                                    i7 = -1;
                                                    i8 = 1;
                                                }
                                                obj4 = p7;
                                                i8 = 1;
                                            } else if (b6 != null) {
                                                b6.f11090c = p7;
                                                obj4 = p7;
                                                i8 = 1;
                                            } else {
                                                qVar.f(k6, obj, p7);
                                                obj4 = p7;
                                                i7 = 1;
                                                i8 = 1;
                                            }
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (i8 != 0) {
                                if (i8 >= 8) {
                                    p(lVarArr, i9);
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = g();
        }
        if (i7 != 0) {
            a(i7, i8);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        r b6;
        Object a6;
        Object obj2;
        Object obj3;
        if (obj == null || function == null) {
            throw null;
        }
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        Object obj4 = null;
        int i6 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i7 = (length - 1) & k6;
                    l m5 = m(lVarArr, i7);
                    boolean z5 = true;
                    if (m5 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (b(lVarArr, i7, mVar)) {
                                Object a7 = function.a(obj);
                                j(lVarArr, i7, a7 != null ? new l(k6, obj, a7, null) : null);
                                obj4 = a7;
                                i6 = 1;
                            }
                        }
                        if (i6 != 0) {
                            break;
                        }
                    } else {
                        int i8 = m5.f11088a;
                        if (i8 == -1) {
                            lVarArr = f(lVarArr, m5);
                        } else {
                            synchronized (m5) {
                                if (m(lVarArr, i7) == m5) {
                                    if (i8 >= 0) {
                                        l lVar = m5;
                                        int i9 = 1;
                                        while (true) {
                                            if (lVar.f11088a != k6 || ((obj3 = lVar.f11089b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                l lVar2 = lVar.f11091d;
                                                if (lVar2 == null) {
                                                    a6 = function.a(obj);
                                                    if (a6 != null) {
                                                        lVar.f11091d = new l(k6, obj, a6, null);
                                                    } else {
                                                        obj2 = a6;
                                                    }
                                                } else {
                                                    i9++;
                                                    lVar = lVar2;
                                                }
                                            }
                                        }
                                        obj2 = lVar.f11090c;
                                        a6 = obj2;
                                        z5 = false;
                                        i6 = i9;
                                        obj4 = a6;
                                    } else if (m5 instanceof q) {
                                        q qVar = (q) m5;
                                        r rVar = qVar.f11106e;
                                        if (rVar == null || (b6 = rVar.b(k6, obj, null)) == null) {
                                            obj4 = function.a(obj);
                                            if (obj4 != null) {
                                                qVar.f(k6, obj, obj4);
                                                i6 = 2;
                                            }
                                        } else {
                                            obj4 = b6.f11090c;
                                        }
                                        i6 = 2;
                                    }
                                }
                                z5 = false;
                            }
                            if (i6 != 0) {
                                if (i6 >= 8) {
                                    p(lVarArr, i7);
                                }
                                if (!z5) {
                                    return obj4;
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = g();
        }
        if (obj4 != null) {
            a(1L, i6);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        r b6;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        int i6 = 0;
        Object obj3 = null;
        int i7 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i8 = (length - 1) & k6;
                    l m5 = m(lVarArr, i8);
                    if (m5 == null) {
                        break;
                    }
                    int i9 = m5.f11088a;
                    if (i9 == -1) {
                        lVarArr = f(lVarArr, m5);
                    } else {
                        synchronized (m5) {
                            try {
                                if (m(lVarArr, i8) == m5) {
                                    if (i9 >= 0) {
                                        i7 = 1;
                                        l lVar = null;
                                        l lVar2 = m5;
                                        while (true) {
                                            if (lVar2.f11088a != k6 || ((obj2 = lVar2.f11089b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                                                l lVar3 = lVar2.f11091d;
                                                if (lVar3 == null) {
                                                    break;
                                                }
                                                i7++;
                                                lVar = lVar2;
                                                lVar2 = lVar3;
                                            }
                                        }
                                        obj3 = biFunction.p(obj, lVar2.f11090c);
                                        if (obj3 != null) {
                                            lVar2.f11090c = obj3;
                                        } else {
                                            l lVar4 = lVar2.f11091d;
                                            if (lVar != null) {
                                                lVar.f11091d = lVar4;
                                            } else {
                                                j(lVarArr, i8, lVar4);
                                            }
                                            i6 = -1;
                                        }
                                    } else if (m5 instanceof q) {
                                        q qVar = (q) m5;
                                        r rVar = qVar.f11106e;
                                        if (rVar != null && (b6 = rVar.b(k6, obj, null)) != null) {
                                            obj3 = biFunction.p(obj, b6.f11090c);
                                            if (obj3 != null) {
                                                b6.f11090c = obj3;
                                            } else {
                                                if (qVar.g(b6)) {
                                                    j(lVarArr, i8, r(qVar.f11107f));
                                                }
                                                i6 = -1;
                                            }
                                        }
                                        i7 = 2;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i7 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArr = g();
        }
        if (i6 != 0) {
            a(i6, i7);
        }
        return obj3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f11070a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a6 = pVar.a();
                if (a6 == null) {
                    break;
                }
                Object obj2 = a6.f11090c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        e eVar = this.f11075f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f11075f = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        Object value;
        Object obj2;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                l[] lVarArr = this.f11070a;
                int length = lVarArr == null ? 0 : lVarArr.length;
                p pVar = new p(lVarArr, length, 0, length);
                while (true) {
                    l a6 = pVar.a();
                    if (a6 == null) {
                        for (Map.Entry entry : map.entrySet()) {
                            Object key = entry.getKey();
                            if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                                return false;
                            }
                        }
                        return true;
                    }
                    Object obj3 = a6.f11090c;
                    Object obj4 = map.get(a6.f11089b);
                    if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                        break;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    final l[] f(l[] lVarArr, l lVar) {
        l[] lVarArr2;
        int i6;
        if (!(lVar instanceof g) || (lVarArr2 = ((g) lVar).f11081e) == null) {
            return this.f11070a;
        }
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (true) {
            if (lVarArr2 != this.f11071b || this.f11070a != lVarArr || (i6 = this.sizeCtl) >= 0 || (i6 >>> f11060h) != numberOfLeadingZeros || i6 == numberOfLeadingZeros + 1 || i6 == f11059g + numberOfLeadingZeros || this.transferIndex <= 0) {
                break;
            } else if (f11062j.compareAndSwapInt(this, f11063k, i6, i6 + 1)) {
                o(lVarArr, lVarArr2);
                break;
            }
        }
        return lVarArr2;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f11070a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a6 = pVar.a();
            if (a6 == null) {
                return;
            }
            biConsumer.n(a6.f11089b, a6.f11090c);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
        return r1.f11090c;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object get(Object obj) {
        int length;
        l m5;
        Object obj2;
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        if (lVarArr != null && (length = lVarArr.length) > 0 && (m5 = m(lVarArr, (length - 1) & k6)) != null) {
            int i6 = m5.f11088a;
            if (i6 == k6) {
                Object obj3 = m5.f11089b;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    return m5.f11090c;
                }
            } else if (i6 < 0) {
                l a6 = m5.a(k6, obj);
                if (a6 != null) {
                    return a6.f11090c;
                }
                return null;
            }
            while (true) {
                m5 = m5.f11091d;
                if (m5 == null) {
                    break;
                } else if (m5.f11088a != k6 || ((obj2 = m5.f11089b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                }
            }
        }
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        r7 = r6.f11090c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
        if (r11 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
        r6.f11090c = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, Object obj2, boolean z5) {
        Object obj3;
        Object obj4;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        int i6 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i7 = (length - 1) & k6;
                    l m5 = m(lVarArr, i7);
                    if (m5 != null) {
                        int i8 = m5.f11088a;
                        if (i8 == -1) {
                            lVarArr = f(lVarArr, m5);
                        } else {
                            synchronized (m5) {
                                if (m(lVarArr, i7) == m5) {
                                    if (i8 >= 0) {
                                        i6 = 1;
                                        l lVar = m5;
                                        while (true) {
                                            if (lVar.f11088a != k6 || ((obj4 = lVar.f11089b) != obj && (obj4 == null || !obj.equals(obj4)))) {
                                                l lVar2 = lVar.f11091d;
                                                if (lVar2 == null) {
                                                    lVar.f11091d = new l(k6, obj, obj2, null);
                                                    break;
                                                }
                                                i6++;
                                                lVar = lVar2;
                                            }
                                        }
                                    } else if (m5 instanceof q) {
                                        r f6 = ((q) m5).f(k6, obj, obj2);
                                        if (f6 != null) {
                                            Object obj5 = f6.f11090c;
                                            if (!z5) {
                                                f6.f11090c = obj2;
                                            }
                                            obj3 = obj5;
                                        } else {
                                            obj3 = null;
                                        }
                                        i6 = 2;
                                    }
                                }
                                obj3 = null;
                            }
                            if (i6 != 0) {
                                if (i6 >= 8) {
                                    p(lVarArr, i7);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (b(lVarArr, i7, new l(k6, obj, obj2, null))) {
                        break;
                    }
                }
            }
            lVarArr = g();
        }
        a(1L, i6);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        l[] lVarArr = this.f11070a;
        int i6 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a6 = pVar.a();
                if (a6 == null) {
                    break;
                }
                i6 += a6.f11090c.hashCode() ^ a6.f11089b.hashCode();
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object i(Object obj, Object obj2, Object obj3) {
        int length;
        int i6;
        l m5;
        boolean z5;
        Object obj4;
        r b6;
        l r5;
        Object obj5;
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (m5 = m(lVarArr, (i6 = (length - 1) & k6))) == null) {
                break;
            }
            int i7 = m5.f11088a;
            if (i7 == -1) {
                lVarArr = f(lVarArr, m5);
            } else {
                synchronized (m5) {
                    try {
                        if (m(lVarArr, i6) == m5) {
                            z5 = true;
                            if (i7 >= 0) {
                                l lVar = null;
                                l lVar2 = m5;
                                while (true) {
                                    if (lVar2.f11088a != k6 || ((obj5 = lVar2.f11089b) != obj && (obj5 == null || !obj.equals(obj5)))) {
                                        l lVar3 = lVar2.f11091d;
                                        if (lVar3 == null) {
                                            break;
                                        }
                                        lVar = lVar2;
                                        lVar2 = lVar3;
                                    }
                                }
                                obj4 = lVar2.f11090c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        lVar2.f11090c = obj2;
                                    } else if (lVar != null) {
                                        lVar.f11091d = lVar2.f11091d;
                                    } else {
                                        r5 = lVar2.f11091d;
                                        j(lVarArr, i6, r5);
                                    }
                                }
                                obj4 = null;
                            } else if (m5 instanceof q) {
                                q qVar = (q) m5;
                                r rVar = qVar.f11106e;
                                if (rVar != null && (b6 = rVar.b(k6, obj, null)) != null) {
                                    obj4 = b6.f11090c;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            b6.f11090c = obj2;
                                        } else if (qVar.g(b6)) {
                                            r5 = r(qVar.f11107f);
                                            j(lVarArr, i6, r5);
                                        }
                                    }
                                }
                                obj4 = null;
                            }
                        }
                        z5 = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z5) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return l() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        i iVar = this.f11073d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.f11073d = iVar2;
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long l() {
        c[] cVarArr = this.f11072c;
        long j6 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j6 += cVar.value;
                }
            }
        }
        return j6;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i6;
        Object obj3;
        Object obj4;
        Object obj5 = obj2;
        if (obj == null || obj5 == null || biFunction == null) {
            throw null;
        }
        int k6 = k(obj.hashCode());
        l[] lVarArr = this.f11070a;
        int i7 = 0;
        Object obj6 = null;
        int i8 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i9 = (length - 1) & k6;
                    l m5 = m(lVarArr, i9);
                    i6 = 1;
                    if (m5 != null) {
                        int i10 = m5.f11088a;
                        if (i10 == -1) {
                            lVarArr = f(lVarArr, m5);
                        } else {
                            synchronized (m5) {
                                try {
                                    if (m(lVarArr, i9) == m5) {
                                        if (i10 >= 0) {
                                            l lVar = null;
                                            l lVar2 = m5;
                                            int i11 = 1;
                                            while (true) {
                                                if (lVar2.f11088a != k6 || ((obj4 = lVar2.f11089b) != obj && (obj4 == null || !obj.equals(obj4)))) {
                                                    l lVar3 = lVar2.f11091d;
                                                    if (lVar3 == null) {
                                                        lVar2.f11091d = new l(k6, obj, obj5, null);
                                                        obj3 = obj5;
                                                        i8 = 1;
                                                        break;
                                                    }
                                                    i11++;
                                                    lVar = lVar2;
                                                    lVar2 = lVar3;
                                                }
                                            }
                                            obj3 = biFunction.p(lVar2.f11090c, obj5);
                                            if (obj3 != null) {
                                                lVar2.f11090c = obj3;
                                            } else {
                                                l lVar4 = lVar2.f11091d;
                                                if (lVar != null) {
                                                    lVar.f11091d = lVar4;
                                                } else {
                                                    j(lVarArr, i9, lVar4);
                                                }
                                                i8 = -1;
                                            }
                                            i7 = i11;
                                            obj6 = obj3;
                                        } else if (m5 instanceof q) {
                                            q qVar = (q) m5;
                                            r rVar = qVar.f11106e;
                                            r b6 = rVar == null ? null : rVar.b(k6, obj, null);
                                            Object p5 = b6 == null ? obj5 : biFunction.p(b6.f11090c, obj5);
                                            if (p5 == null) {
                                                if (b6 != null) {
                                                    if (qVar.g(b6)) {
                                                        j(lVarArr, i9, r(qVar.f11107f));
                                                    }
                                                    obj6 = p5;
                                                    i7 = 2;
                                                    i8 = -1;
                                                }
                                                obj6 = p5;
                                                i7 = 2;
                                            } else if (b6 != null) {
                                                b6.f11090c = p5;
                                                obj6 = p5;
                                                i7 = 2;
                                            } else {
                                                qVar.f(k6, obj, p5);
                                                obj6 = p5;
                                                i7 = 2;
                                                i8 = 1;
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (i7 != 0) {
                                if (i7 >= 8) {
                                    p(lVarArr, i9);
                                }
                                i6 = i8;
                                obj5 = obj6;
                            }
                        }
                    } else if (b(lVarArr, i9, new l(k6, obj, obj5, null))) {
                        break;
                    }
                }
            }
            lVarArr = g();
        }
        if (i6 != 0) {
            a(i6, i7);
        }
        return obj5;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return h(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        q(map.size());
        for (Map.Entry entry : map.entrySet()) {
            h(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        return h(obj, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        return i(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || i(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw null;
        }
        return i(obj, obj2, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return i(obj, obj3, obj2) != null;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f11070a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a6 = pVar.a();
            if (a6 == null) {
                return;
            }
            Object obj = a6.f11090c;
            Object obj2 = a6.f11089b;
            do {
                Object p5 = biFunction.p(obj2, obj);
                p5.getClass();
                if (i(obj2, p5, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long l6 = l();
        if (l6 < 0) {
            return 0;
        }
        if (l6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) l6;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        l[] lVarArr = this.f11070a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l a6 = pVar.a();
        if (a6 != null) {
            while (true) {
                Object obj = a6.f11089b;
                Object obj2 = a6.f11090c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a6 = pVar.a();
                if (a6 == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        s sVar = this.f11074e;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.f11074e = sVar2;
        return sVar2;
    }
}
