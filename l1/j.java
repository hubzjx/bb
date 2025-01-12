package l1;

import android.util.SparseArray;
import com.google.android.exoplayer2.s0;
import java.util.ArrayList;
import java.util.List;
import l1.i0;
/* loaded from: classes.dex */
public final class j implements i0.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f11566a;

    /* renamed from: b  reason: collision with root package name */
    private final List f11567b;

    public j(int i6) {
        this(i6, com.google.common.collect.y.of());
    }

    private d0 c(i0.b bVar) {
        return new d0(e(bVar));
    }

    private k0 d(i0.b bVar) {
        return new k0(e(bVar));
    }

    private List e(i0.b bVar) {
        String str;
        int i6;
        if (f(32)) {
            return this.f11567b;
        }
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(bVar.f11560d);
        List list = this.f11567b;
        while (yVar.a() > 0) {
            int A = yVar.A();
            int d6 = yVar.d() + yVar.A();
            if (A == 134) {
                list = new ArrayList();
                int A2 = yVar.A() & 31;
                for (int i7 = 0; i7 < A2; i7++) {
                    String x5 = yVar.x(3);
                    int A3 = yVar.A();
                    boolean z5 = (A3 & 128) != 0;
                    if (z5) {
                        i6 = A3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i6 = 1;
                    }
                    byte A4 = (byte) yVar.A();
                    yVar.N(1);
                    list.add(new s0.b().e0(str).V(x5).F(i6).T(z5 ? com.google.android.exoplayer2.util.d.b((A4 & 64) != 0) : null).E());
                }
            }
            yVar.M(d6);
        }
        return list;
    }

    private boolean f(int i6) {
        return (i6 & this.f11566a) != 0;
    }

    @Override // l1.i0.c
    public SparseArray a() {
        return new SparseArray();
    }

    @Override // l1.i0.c
    public i0 b(int i6, i0.b bVar) {
        if (i6 != 2) {
            if (i6 == 3 || i6 == 4) {
                return new w(new t(bVar.f11558b));
            }
            if (i6 != 21) {
                if (i6 == 27) {
                    if (f(4)) {
                        return null;
                    }
                    return new w(new p(c(bVar), f(1), f(8)));
                } else if (i6 != 36) {
                    if (i6 != 89) {
                        if (i6 != 138) {
                            if (i6 != 172) {
                                if (i6 != 257) {
                                    if (i6 != 129) {
                                        if (i6 != 130) {
                                            if (i6 == 134) {
                                                if (f(16)) {
                                                    return null;
                                                }
                                                return new c0(new v("application/x-scte35"));
                                            } else if (i6 != 135) {
                                                switch (i6) {
                                                    case 15:
                                                        if (f(2)) {
                                                            return null;
                                                        }
                                                        return new w(new i(false, bVar.f11558b));
                                                    case 16:
                                                        return new w(new o(d(bVar)));
                                                    case 17:
                                                        if (f(2)) {
                                                            return null;
                                                        }
                                                        return new w(new s(bVar.f11558b));
                                                    default:
                                                        return null;
                                                }
                                            }
                                        } else if (!f(64)) {
                                            return null;
                                        }
                                    }
                                    return new w(new c(bVar.f11558b));
                                }
                                return new c0(new v("application/vnd.dvb.ait"));
                            }
                            return new w(new f(bVar.f11558b));
                        }
                        return new w(new k(bVar.f11558b));
                    }
                    return new w(new l(bVar.f11559c));
                } else {
                    return new w(new q(c(bVar)));
                }
            }
            return new w(new r());
        }
        return new w(new n(d(bVar)));
    }

    public j(int i6, List list) {
        this.f11566a = i6;
        this.f11567b = list;
    }
}
