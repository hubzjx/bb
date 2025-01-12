package j$.util.concurrent;

import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q extends l {

    /* renamed from: h  reason: collision with root package name */
    private static final Unsafe f11104h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f11105i;

    /* renamed from: e  reason: collision with root package name */
    r f11106e;

    /* renamed from: f  reason: collision with root package name */
    volatile r f11107f;

    /* renamed from: g  reason: collision with root package name */
    volatile Thread f11108g;
    volatile int lockState;

    static {
        try {
            Unsafe c6 = u.c();
            f11104h = c6;
            f11105i = c6.objectFieldOffset(q.class.getDeclaredField("lockState"));
        } catch (Exception e6) {
            throw new Error(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(r rVar) {
        super(-2, null, null, null);
        int d6;
        int j6;
        this.f11107f = rVar;
        r rVar2 = null;
        while (rVar != null) {
            r rVar3 = (r) rVar.f11091d;
            rVar.f11111g = null;
            rVar.f11110f = null;
            if (rVar2 == null) {
                rVar.f11109e = null;
                rVar.f11113i = false;
            } else {
                Object obj = rVar.f11089b;
                int i6 = rVar.f11088a;
                r rVar4 = rVar2;
                Class cls = null;
                while (true) {
                    Object obj2 = rVar4.f11089b;
                    int i7 = rVar4.f11088a;
                    j6 = i7 > i6 ? -1 : i7 < i6 ? 1 : ((cls == null && (cls = ConcurrentHashMap.c(obj)) == null) || (d6 = ConcurrentHashMap.d(cls, obj, obj2)) == 0) ? j(obj, obj2) : d6;
                    r rVar5 = j6 <= 0 ? rVar4.f11110f : rVar4.f11111g;
                    if (rVar5 == null) {
                        break;
                    }
                    rVar4 = rVar5;
                }
                rVar.f11109e = rVar4;
                if (j6 <= 0) {
                    rVar4.f11110f = rVar;
                } else {
                    rVar4.f11111g = rVar;
                }
                rVar = c(rVar2, rVar);
            }
            rVar2 = rVar;
            rVar = rVar3;
        }
        this.f11106e = rVar2;
    }

    static r b(r rVar, r rVar2) {
        while (rVar2 != null && rVar2 != rVar) {
            r rVar3 = rVar2.f11109e;
            if (rVar3 == null) {
                rVar2.f11113i = false;
                return rVar2;
            } else if (rVar2.f11113i) {
                rVar2.f11113i = false;
                return rVar;
            } else {
                r rVar4 = rVar3.f11110f;
                if (rVar4 == rVar2) {
                    rVar4 = rVar3.f11111g;
                    if (rVar4 != null && rVar4.f11113i) {
                        rVar4.f11113i = false;
                        rVar3.f11113i = true;
                        rVar = h(rVar, rVar3);
                        rVar3 = rVar2.f11109e;
                        rVar4 = rVar3 == null ? null : rVar3.f11111g;
                    }
                    if (rVar4 == null) {
                        rVar2 = rVar3;
                    } else {
                        r rVar5 = rVar4.f11110f;
                        r rVar6 = rVar4.f11111g;
                        if ((rVar6 != null && rVar6.f11113i) || (rVar5 != null && rVar5.f11113i)) {
                            if (rVar6 == null || !rVar6.f11113i) {
                                if (rVar5 != null) {
                                    rVar5.f11113i = false;
                                }
                                rVar4.f11113i = true;
                                rVar = i(rVar, rVar4);
                                rVar3 = rVar2.f11109e;
                                rVar4 = rVar3 != null ? rVar3.f11111g : null;
                            }
                            if (rVar4 != null) {
                                rVar4.f11113i = rVar3 == null ? false : rVar3.f11113i;
                                r rVar7 = rVar4.f11111g;
                                if (rVar7 != null) {
                                    rVar7.f11113i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f11113i = false;
                                rVar = h(rVar, rVar3);
                            }
                            rVar2 = rVar;
                            rVar = rVar2;
                        }
                        rVar4.f11113i = true;
                        rVar2 = rVar3;
                    }
                } else {
                    if (rVar4 != null && rVar4.f11113i) {
                        rVar4.f11113i = false;
                        rVar3.f11113i = true;
                        rVar = i(rVar, rVar3);
                        rVar3 = rVar2.f11109e;
                        rVar4 = rVar3 == null ? null : rVar3.f11110f;
                    }
                    if (rVar4 == null) {
                        rVar2 = rVar3;
                    } else {
                        r rVar8 = rVar4.f11110f;
                        r rVar9 = rVar4.f11111g;
                        if ((rVar8 != null && rVar8.f11113i) || (rVar9 != null && rVar9.f11113i)) {
                            if (rVar8 == null || !rVar8.f11113i) {
                                if (rVar9 != null) {
                                    rVar9.f11113i = false;
                                }
                                rVar4.f11113i = true;
                                rVar = h(rVar, rVar4);
                                rVar3 = rVar2.f11109e;
                                rVar4 = rVar3 != null ? rVar3.f11110f : null;
                            }
                            if (rVar4 != null) {
                                rVar4.f11113i = rVar3 == null ? false : rVar3.f11113i;
                                r rVar10 = rVar4.f11110f;
                                if (rVar10 != null) {
                                    rVar10.f11113i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f11113i = false;
                                rVar = i(rVar, rVar3);
                            }
                            rVar2 = rVar;
                            rVar = rVar2;
                        }
                        rVar4.f11113i = true;
                        rVar2 = rVar3;
                    }
                }
            }
        }
        return rVar;
    }

    static r c(r rVar, r rVar2) {
        r rVar3;
        rVar2.f11113i = true;
        while (true) {
            r rVar4 = rVar2.f11109e;
            if (rVar4 == null) {
                rVar2.f11113i = false;
                return rVar2;
            } else if (!rVar4.f11113i || (rVar3 = rVar4.f11109e) == null) {
                break;
            } else {
                r rVar5 = rVar3.f11110f;
                if (rVar4 == rVar5) {
                    rVar5 = rVar3.f11111g;
                    if (rVar5 == null || !rVar5.f11113i) {
                        if (rVar2 == rVar4.f11111g) {
                            rVar = h(rVar, rVar4);
                            r rVar6 = rVar4.f11109e;
                            rVar3 = rVar6 == null ? null : rVar6.f11109e;
                            rVar4 = rVar6;
                            rVar2 = rVar4;
                        }
                        if (rVar4 != null) {
                            rVar4.f11113i = false;
                            if (rVar3 != null) {
                                rVar3.f11113i = true;
                                rVar = i(rVar, rVar3);
                            }
                        }
                    } else {
                        rVar5.f11113i = false;
                        rVar4.f11113i = false;
                        rVar3.f11113i = true;
                        rVar2 = rVar3;
                    }
                } else if (rVar5 == null || !rVar5.f11113i) {
                    if (rVar2 == rVar4.f11110f) {
                        rVar = i(rVar, rVar4);
                        r rVar7 = rVar4.f11109e;
                        rVar3 = rVar7 == null ? null : rVar7.f11109e;
                        rVar4 = rVar7;
                        rVar2 = rVar4;
                    }
                    if (rVar4 != null) {
                        rVar4.f11113i = false;
                        if (rVar3 != null) {
                            rVar3.f11113i = true;
                            rVar = h(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.f11113i = false;
                    rVar4.f11113i = false;
                    rVar3.f11113i = true;
                    rVar2 = rVar3;
                }
            }
        }
        return rVar;
    }

    private final void d() {
        boolean z5 = false;
        while (true) {
            int i6 = this.lockState;
            if ((i6 & (-3)) == 0) {
                if (f11104h.compareAndSwapInt(this, f11105i, i6, 1)) {
                    break;
                }
            } else if ((i6 & 2) == 0) {
                if (f11104h.compareAndSwapInt(this, f11105i, i6, i6 | 2)) {
                    this.f11108g = Thread.currentThread();
                    z5 = true;
                }
            } else if (z5) {
                LockSupport.park(this);
            }
        }
        if (z5) {
            this.f11108g = null;
        }
    }

    private final void e() {
        if (f11104h.compareAndSwapInt(this, f11105i, 0, 1)) {
            return;
        }
        d();
    }

    static r h(r rVar, r rVar2) {
        r rVar3 = rVar2.f11111g;
        if (rVar3 != null) {
            r rVar4 = rVar3.f11110f;
            rVar2.f11111g = rVar4;
            if (rVar4 != null) {
                rVar4.f11109e = rVar2;
            }
            r rVar5 = rVar2.f11109e;
            rVar3.f11109e = rVar5;
            if (rVar5 == null) {
                rVar3.f11113i = false;
                rVar = rVar3;
            } else if (rVar5.f11110f == rVar2) {
                rVar5.f11110f = rVar3;
            } else {
                rVar5.f11111g = rVar3;
            }
            rVar3.f11110f = rVar2;
            rVar2.f11109e = rVar3;
        }
        return rVar;
    }

    static r i(r rVar, r rVar2) {
        r rVar3 = rVar2.f11110f;
        if (rVar3 != null) {
            r rVar4 = rVar3.f11111g;
            rVar2.f11110f = rVar4;
            if (rVar4 != null) {
                rVar4.f11109e = rVar2;
            }
            r rVar5 = rVar2.f11109e;
            rVar3.f11109e = rVar5;
            if (rVar5 == null) {
                rVar3.f11113i = false;
                rVar = rVar3;
            } else if (rVar5.f11111g == rVar2) {
                rVar5.f11111g = rVar3;
            } else {
                rVar5.f11110f = rVar3;
            }
            rVar3.f11111g = rVar2;
            rVar2.f11109e = rVar3;
        }
        return rVar;
    }

    static int j(Object obj, Object obj2) {
        int compareTo;
        return (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : compareTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.concurrent.l
    public final l a(int i6, Object obj) {
        Object obj2;
        Thread thread;
        Thread thread2;
        r rVar = null;
        if (obj != null) {
            l lVar = this.f11107f;
            while (lVar != null) {
                int i7 = this.lockState;
                if ((i7 & 3) == 0) {
                    Unsafe unsafe = f11104h;
                    long j6 = f11105i;
                    if (unsafe.compareAndSwapInt(this, j6, i7, i7 + 4)) {
                        try {
                            r rVar2 = this.f11106e;
                            if (rVar2 != null) {
                                rVar = rVar2.b(i6, obj, null);
                            }
                            if (u.a(unsafe, this, j6) == 6 && (thread2 = this.f11108g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return rVar;
                        } catch (Throwable th) {
                            if (u.a(f11104h, this, f11105i) == 6 && (thread = this.f11108g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th;
                        }
                    }
                } else if (lVar.f11088a == i6 && ((obj2 = lVar.f11089b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return lVar;
                } else {
                    lVar = lVar.f11091d;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r f(int i6, Object obj, Object obj2) {
        int d6;
        int i7;
        r rVar;
        r rVar2 = this.f11106e;
        Class cls = null;
        boolean z5 = false;
        while (true) {
            if (rVar2 == null) {
                r rVar3 = new r(i6, obj, obj2, null, null);
                this.f11106e = rVar3;
                this.f11107f = rVar3;
                break;
            }
            int i8 = rVar2.f11088a;
            if (i8 > i6) {
                i7 = -1;
            } else if (i8 < i6) {
                i7 = 1;
            } else {
                Object obj3 = rVar2.f11089b;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    break;
                } else if ((cls == null && (cls = ConcurrentHashMap.c(obj)) == null) || (d6 = ConcurrentHashMap.d(cls, obj, obj3)) == 0) {
                    if (!z5) {
                        r rVar4 = rVar2.f11110f;
                        if ((rVar4 == null || (r3 = rVar4.b(i6, obj, cls)) == null) && ((rVar = rVar2.f11111g) == null || (r3 = rVar.b(i6, obj, cls)) == null)) {
                            z5 = true;
                        }
                    }
                    i7 = j(obj, obj3);
                } else {
                    i7 = d6;
                }
            }
            r rVar5 = i7 <= 0 ? rVar2.f11110f : rVar2.f11111g;
            if (rVar5 == null) {
                r rVar6 = this.f11107f;
                r rVar7 = new r(i6, obj, obj2, rVar6, rVar2);
                this.f11107f = rVar7;
                if (rVar6 != null) {
                    rVar6.f11112h = rVar7;
                }
                if (i7 <= 0) {
                    rVar2.f11110f = rVar7;
                } else {
                    rVar2.f11111g = rVar7;
                }
                if (rVar2.f11113i) {
                    e();
                    try {
                        this.f11106e = c(this.f11106e, rVar7);
                    } finally {
                        this.lockState = 0;
                    }
                } else {
                    rVar7.f11113i = true;
                }
            } else {
                rVar2 = rVar5;
            }
        }
        return rVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008e A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00aa A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b2 A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ba A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bd A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:22:0x0030, B:26:0x0039, B:29:0x003f, B:31:0x004d, B:39:0x0065, B:41:0x006b, B:42:0x006d, B:57:0x008e, B:64:0x009f, B:60:0x0096, B:62:0x009a, B:63:0x009d, B:65:0x00a5, B:69:0x00ae, B:71:0x00b2, B:73:0x00b6, B:75:0x00ba, B:79:0x00c3, B:76:0x00bd, B:78:0x00c1, B:68:0x00aa, B:45:0x0077, B:47:0x007b, B:48:0x007e, B:32:0x0052, B:34:0x0058, B:36:0x005c, B:37:0x005f, B:38:0x0061), top: B:86:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g(r rVar) {
        r rVar2;
        r rVar3;
        r rVar4 = (r) rVar.f11091d;
        r rVar5 = rVar.f11112h;
        if (rVar5 == null) {
            this.f11107f = rVar4;
        } else {
            rVar5.f11091d = rVar4;
        }
        if (rVar4 != null) {
            rVar4.f11112h = rVar5;
        }
        if (this.f11107f == null) {
            this.f11106e = null;
            return true;
        }
        r rVar6 = this.f11106e;
        if (rVar6 == null || rVar6.f11111g == null || (rVar2 = rVar6.f11110f) == null || rVar2.f11110f == null) {
            return true;
        }
        e();
        try {
            r rVar7 = rVar.f11110f;
            r rVar8 = rVar.f11111g;
            if (rVar7 == null || rVar8 == null) {
                if (rVar7 == null) {
                    if (rVar8 != null) {
                        rVar7 = rVar8;
                    }
                    rVar7 = rVar;
                }
                if (rVar7 != rVar) {
                    r rVar9 = rVar.f11109e;
                    rVar7.f11109e = rVar9;
                    if (rVar9 == null) {
                        rVar6 = rVar7;
                    } else if (rVar == rVar9.f11110f) {
                        rVar9.f11110f = rVar7;
                    } else {
                        rVar9.f11111g = rVar7;
                    }
                    rVar.f11109e = null;
                    rVar.f11111g = null;
                    rVar.f11110f = null;
                }
                if (!rVar.f11113i) {
                    rVar6 = b(rVar6, rVar7);
                }
                this.f11106e = rVar6;
                if (rVar == rVar7 && (rVar3 = rVar.f11109e) != null) {
                    if (rVar != rVar3.f11110f) {
                        rVar3.f11110f = null;
                    } else if (rVar == rVar3.f11111g) {
                        rVar3.f11111g = null;
                    }
                    rVar.f11109e = null;
                }
                return false;
            }
            r rVar10 = rVar8;
            while (true) {
                r rVar11 = rVar10.f11110f;
                if (rVar11 == null) {
                    break;
                }
                rVar10 = rVar11;
            }
            boolean z5 = rVar10.f11113i;
            rVar10.f11113i = rVar.f11113i;
            rVar.f11113i = z5;
            r rVar12 = rVar10.f11111g;
            r rVar13 = rVar.f11109e;
            if (rVar10 == rVar8) {
                rVar.f11109e = rVar10;
                rVar10.f11111g = rVar;
            } else {
                r rVar14 = rVar10.f11109e;
                rVar.f11109e = rVar14;
                if (rVar14 != null) {
                    if (rVar10 == rVar14.f11110f) {
                        rVar14.f11110f = rVar;
                    } else {
                        rVar14.f11111g = rVar;
                    }
                }
                rVar10.f11111g = rVar8;
                rVar8.f11109e = rVar10;
            }
            rVar.f11110f = null;
            rVar.f11111g = rVar12;
            if (rVar12 != null) {
                rVar12.f11109e = rVar;
            }
            rVar10.f11110f = rVar7;
            rVar7.f11109e = rVar10;
            rVar10.f11109e = rVar13;
            if (rVar13 == null) {
                rVar6 = rVar10;
            } else if (rVar == rVar13.f11110f) {
                rVar13.f11110f = rVar10;
            } else {
                rVar13.f11111g = rVar10;
            }
            if (rVar12 != null) {
                rVar7 = rVar12;
                if (rVar7 != rVar) {
                }
                if (!rVar.f11113i) {
                }
                this.f11106e = rVar6;
                if (rVar == rVar7) {
                    if (rVar != rVar3.f11110f) {
                    }
                    rVar.f11109e = null;
                }
                return false;
            }
            rVar7 = rVar;
            if (rVar7 != rVar) {
            }
            if (!rVar.f11113i) {
            }
            this.f11106e = rVar6;
            if (rVar == rVar7) {
            }
            return false;
        } finally {
            this.lockState = 0;
        }
    }
}
