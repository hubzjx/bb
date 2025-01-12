package p;

import java.util.ArrayList;
import okhttp3.HttpUrl;
import p.d;
import q.l;
import q.m;
/* loaded from: classes.dex */
public class e {

    /* renamed from: v0  reason: collision with root package name */
    public static float f12541v0 = 0.5f;
    d I;
    public d[] J;
    protected ArrayList K;
    private boolean[] L;
    public b[] M;
    public e N;
    int O;
    int P;
    public float Q;
    protected int R;
    protected int S;
    protected int T;
    int U;
    int V;
    protected int W;
    protected int X;
    int Y;
    protected int Z;

    /* renamed from: a0  reason: collision with root package name */
    protected int f12543a0;

    /* renamed from: b0  reason: collision with root package name */
    float f12545b0;

    /* renamed from: c  reason: collision with root package name */
    public q.c f12546c;

    /* renamed from: c0  reason: collision with root package name */
    float f12547c0;

    /* renamed from: d  reason: collision with root package name */
    public q.c f12548d;

    /* renamed from: d0  reason: collision with root package name */
    private Object f12549d0;

    /* renamed from: e0  reason: collision with root package name */
    private int f12551e0;

    /* renamed from: f0  reason: collision with root package name */
    private int f12553f0;

    /* renamed from: g0  reason: collision with root package name */
    private String f12555g0;

    /* renamed from: h0  reason: collision with root package name */
    private String f12557h0;

    /* renamed from: i0  reason: collision with root package name */
    boolean f12559i0;

    /* renamed from: j0  reason: collision with root package name */
    boolean f12561j0;

    /* renamed from: k0  reason: collision with root package name */
    boolean f12563k0;

    /* renamed from: l0  reason: collision with root package name */
    boolean f12565l0;

    /* renamed from: m0  reason: collision with root package name */
    int f12567m0;

    /* renamed from: n0  reason: collision with root package name */
    int f12569n0;

    /* renamed from: o0  reason: collision with root package name */
    boolean f12571o0;

    /* renamed from: p0  reason: collision with root package name */
    boolean f12573p0;

    /* renamed from: q0  reason: collision with root package name */
    public float[] f12575q0;

    /* renamed from: r0  reason: collision with root package name */
    protected e[] f12577r0;

    /* renamed from: s0  reason: collision with root package name */
    protected e[] f12579s0;

    /* renamed from: t0  reason: collision with root package name */
    e f12581t0;

    /* renamed from: u0  reason: collision with root package name */
    e f12583u0;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12588z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12542a = false;

    /* renamed from: b  reason: collision with root package name */
    public m[] f12544b = new m[2];

    /* renamed from: e  reason: collision with root package name */
    public q.j f12550e = new q.j(this);

    /* renamed from: f  reason: collision with root package name */
    public l f12552f = new l(this);

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f12554g = {true, true};

    /* renamed from: h  reason: collision with root package name */
    public int[] f12556h = {0, 0, 0, 0};

    /* renamed from: i  reason: collision with root package name */
    boolean f12558i = false;

    /* renamed from: j  reason: collision with root package name */
    public int f12560j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f12562k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f12564l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f12566m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int[] f12568n = new int[2];

    /* renamed from: o  reason: collision with root package name */
    public int f12570o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f12572p = 0;

    /* renamed from: q  reason: collision with root package name */
    public float f12574q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    public int f12576r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f12578s = 0;

    /* renamed from: t  reason: collision with root package name */
    public float f12580t = 1.0f;

    /* renamed from: u  reason: collision with root package name */
    int f12582u = -1;

    /* renamed from: v  reason: collision with root package name */
    float f12584v = 1.0f;

    /* renamed from: w  reason: collision with root package name */
    private int[] f12585w = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: x  reason: collision with root package name */
    private float f12586x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    private boolean f12587y = false;
    private boolean A = false;
    public d B = new d(this, d.b.LEFT);
    public d C = new d(this, d.b.TOP);
    public d D = new d(this, d.b.RIGHT);
    public d E = new d(this, d.b.BOTTOM);
    d F = new d(this, d.b.BASELINE);
    d G = new d(this, d.b.CENTER_X);
    d H = new d(this, d.b.CENTER_Y);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12589a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f12590b;

        static {
            int[] iArr = new int[b.values().length];
            f12590b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12590b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12590b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12590b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f12589a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12589a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12589a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12589a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12589a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12589a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12589a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12589a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12589a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.I = dVar;
        this.J = new d[]{this.B, this.D, this.C, this.E, this.F, dVar};
        this.K = new ArrayList();
        this.L = new boolean[2];
        b bVar = b.FIXED;
        this.M = new b[]{bVar, bVar};
        this.N = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f6 = f12541v0;
        this.f12545b0 = f6;
        this.f12547c0 = f6;
        this.f12551e0 = 0;
        this.f12553f0 = 0;
        this.f12555g0 = null;
        this.f12557h0 = null;
        this.f12563k0 = false;
        this.f12565l0 = false;
        this.f12567m0 = 0;
        this.f12569n0 = 0;
        this.f12575q0 = new float[]{-1.0f, -1.0f};
        this.f12577r0 = new e[]{null, null};
        this.f12579s0 = new e[]{null, null};
        this.f12581t0 = null;
        this.f12583u0 = null;
        d();
    }

    private boolean S(int i6) {
        d dVar;
        d dVar2;
        int i7 = i6 * 2;
        d[] dVarArr = this.J;
        d dVar3 = dVarArr[i7];
        d dVar4 = dVar3.f12536d;
        return (dVar4 == null || dVar4.f12536d == dVar3 || (dVar2 = (dVar = dVarArr[i7 + 1]).f12536d) == null || dVar2.f12536d != dVar) ? false : true;
    }

    private void d() {
        this.K.add(this.B);
        this.K.add(this.C);
        this.K.add(this.D);
        this.K.add(this.E);
        this.K.add(this.G);
        this.K.add(this.H);
        this.K.add(this.I);
        this.K.add(this.F);
    }

    /* JADX WARN: Code restructure failed: missing block: B:293:0x0433, code lost:
        if (r1[r22] == r4) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0313 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0403 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:303:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(o.d dVar, boolean z5, boolean z6, boolean z7, boolean z8, o.i iVar, o.i iVar2, b bVar, boolean z9, d dVar2, d dVar3, int i6, int i7, int i8, int i9, float f6, boolean z10, boolean z11, boolean z12, boolean z13, int i10, int i11, int i12, int i13, float f7, boolean z14) {
        int i14;
        boolean z15;
        int i15;
        o.i iVar3;
        int i16;
        int i17;
        int i18;
        o.i iVar4;
        o.i iVar5;
        o.i iVar6;
        int i19;
        int i20;
        boolean z16;
        boolean z17;
        o.i q5;
        e eVar;
        d.b bVar2;
        o.i iVar7;
        o.i iVar8;
        o.i iVar9;
        o.i iVar10;
        int i21;
        int i22;
        char c6;
        int i23;
        d dVar4;
        int i24;
        boolean z18;
        int i25;
        boolean z19;
        boolean z20;
        int i26;
        boolean z21;
        boolean z22;
        o.i iVar11;
        e eVar2;
        e eVar3;
        o.i iVar12;
        int i27;
        int i28;
        e eVar4;
        o.i iVar13;
        e eVar5;
        o.i iVar14;
        int i29;
        int i30;
        boolean z23;
        int i31;
        int i32;
        int i33;
        int i34;
        boolean z24;
        int i35;
        int i36;
        int i37;
        int i38;
        boolean z25;
        o.i iVar15;
        int i39;
        o.i q6 = dVar.q(dVar2);
        o.i q7 = dVar.q(dVar3);
        o.i q8 = dVar.q(dVar2.f());
        o.i q9 = dVar.q(dVar3.f());
        o.d.w();
        boolean i40 = dVar2.i();
        boolean i41 = dVar3.i();
        boolean i42 = this.I.i();
        int i43 = i41 ? (i40 ? 1 : 0) + 1 : i40 ? 1 : 0;
        if (i42) {
            i43++;
        }
        int i44 = z10 ? 3 : i10;
        int i45 = a.f12590b[bVar.ordinal()];
        if (i45 == 1 || i45 == 2 || i45 == 3 || i45 != 4) {
            i14 = i44;
        } else {
            i14 = i44;
            if (i14 != 4) {
                z15 = true;
                if (this.f12553f0 != 8) {
                    i15 = 0;
                    z15 = false;
                } else {
                    i15 = i7;
                }
                if (z14) {
                    if (!i40 && !i41 && !i42) {
                        dVar.f(q6, i6);
                    } else if (i40 && !i41) {
                        iVar3 = q9;
                        i16 = 8;
                        dVar.e(q6, q8, dVar2.b(), 8);
                        if (!z15) {
                            if (z9) {
                                dVar.e(q7, q6, 0, 3);
                                if (i8 > 0) {
                                    dVar.h(q7, q6, i8, 8);
                                }
                                if (i9 < Integer.MAX_VALUE) {
                                    dVar.j(q7, q6, i9, 8);
                                }
                            } else {
                                dVar.e(q7, q6, i15, i16);
                            }
                            i20 = i12;
                            i17 = i13;
                            iVar4 = q8;
                            iVar5 = q7;
                        } else if (i43 != 2 && !z10 && (i14 == 1 || i14 == 0)) {
                            int max = Math.max(i12, i15);
                            if (i13 > 0) {
                                max = Math.min(i13, max);
                            }
                            dVar.e(q7, q6, max, 8);
                            z17 = z8;
                            i20 = i12;
                            i17 = i13;
                            iVar4 = q8;
                            iVar5 = q7;
                            iVar6 = iVar3;
                            z16 = false;
                            i19 = i43;
                            if (!z14) {
                            }
                            if (i23 < i22) {
                                return;
                            }
                            return;
                        } else {
                            int i46 = i12 == -2 ? i15 : i12;
                            i17 = i13 == -2 ? i15 : i13;
                            if (i15 > 0 && i14 != 1) {
                                i15 = 0;
                            }
                            if (i46 > 0) {
                                dVar.h(q7, q6, i46, 8);
                                i15 = Math.max(i15, i46);
                            }
                            if (i17 > 0) {
                                if ((z6 && i14 == 1) ? false : true) {
                                    i18 = 8;
                                    dVar.j(q7, q6, i17, 8);
                                } else {
                                    i18 = 8;
                                }
                                i15 = Math.min(i15, i17);
                            } else {
                                i18 = 8;
                            }
                            if (i14 != 1) {
                                if (i14 == 2) {
                                    d.b g6 = dVar2.g();
                                    d.b bVar3 = d.b.TOP;
                                    if (g6 == bVar3 || dVar2.g() == d.b.BOTTOM) {
                                        q5 = dVar.q(this.N.k(bVar3));
                                        eVar = this.N;
                                        bVar2 = d.b.BOTTOM;
                                    } else {
                                        q5 = dVar.q(this.N.k(d.b.LEFT));
                                        eVar = this.N;
                                        bVar2 = d.b.RIGHT;
                                    }
                                    int i47 = i46;
                                    iVar6 = iVar3;
                                    iVar4 = q8;
                                    i19 = i43;
                                    iVar5 = q7;
                                    dVar.d(dVar.r().k(q7, q6, dVar.q(eVar.k(bVar2)), q5, f7));
                                    z17 = z8;
                                    i20 = i47;
                                    z16 = false;
                                } else {
                                    iVar4 = q8;
                                    iVar5 = q7;
                                    int i48 = i46;
                                    iVar6 = iVar3;
                                    i19 = i43;
                                    i20 = i48;
                                    z16 = z15;
                                    z17 = true;
                                }
                                if (!z14) {
                                    iVar7 = iVar2;
                                    iVar8 = iVar5;
                                    iVar9 = q6;
                                    iVar10 = iVar;
                                    i21 = 8;
                                    i22 = 2;
                                    c6 = 1;
                                    i23 = i19;
                                } else if (!z11) {
                                    if ((i40 || i41 || i42) && (!i40 || i41)) {
                                        if (!i40 && i41) {
                                            dVar.e(iVar5, iVar6, -dVar3.b(), 8);
                                            if (z6) {
                                                dVar.h(q6, iVar, 0, 5);
                                            }
                                        } else if (i40 && i41) {
                                            e eVar6 = dVar2.f12536d.f12534b;
                                            e eVar7 = dVar3.f12536d.f12534b;
                                            e E = E();
                                            int i49 = 6;
                                            if (z16) {
                                                if (i14 == 0) {
                                                    if (i17 == 0 && i20 == 0) {
                                                        i37 = 8;
                                                        i38 = 8;
                                                        z25 = false;
                                                        z19 = true;
                                                    } else {
                                                        i37 = 5;
                                                        i38 = 5;
                                                        z25 = true;
                                                        z19 = false;
                                                    }
                                                    if ((eVar6 instanceof p.a) || (eVar7 instanceof p.a)) {
                                                        i26 = i37;
                                                        z20 = z25;
                                                        i24 = 6;
                                                        z18 = false;
                                                        i25 = 4;
                                                    } else {
                                                        i26 = i37;
                                                        z20 = z25;
                                                        i24 = 6;
                                                        z18 = false;
                                                        i25 = i38;
                                                    }
                                                } else {
                                                    if (i14 == 1) {
                                                        i24 = 6;
                                                        z18 = true;
                                                        i25 = 4;
                                                        z19 = false;
                                                    } else if (i14 != 3) {
                                                        i24 = 6;
                                                        z18 = false;
                                                        i25 = 4;
                                                        z19 = false;
                                                        z20 = false;
                                                        i26 = 5;
                                                    } else if (this.f12582u == -1) {
                                                        i24 = z12 ? z6 ? 5 : 4 : 8;
                                                        z18 = true;
                                                        i25 = 5;
                                                        z19 = true;
                                                    } else {
                                                        if (z10) {
                                                            if (i11 != 2 && i11 != 1) {
                                                                z24 = false;
                                                                if (z24) {
                                                                    i35 = 8;
                                                                    i36 = 5;
                                                                } else {
                                                                    i35 = 5;
                                                                    i36 = 4;
                                                                }
                                                                i26 = i35;
                                                                i25 = i36;
                                                                i24 = 6;
                                                                z18 = true;
                                                            }
                                                            z24 = true;
                                                            if (z24) {
                                                            }
                                                            i26 = i35;
                                                            i25 = i36;
                                                            i24 = 6;
                                                            z18 = true;
                                                        } else {
                                                            if (i17 > 0) {
                                                                i24 = 6;
                                                                z18 = true;
                                                                i25 = 5;
                                                            } else if (i17 != 0 || i20 != 0) {
                                                                i24 = 6;
                                                                z18 = true;
                                                                i25 = 4;
                                                            } else if (z12) {
                                                                i26 = (eVar6 == E || eVar7 == E) ? 5 : 4;
                                                                i24 = 6;
                                                                z18 = true;
                                                                i25 = 4;
                                                            } else {
                                                                i24 = 6;
                                                                z18 = true;
                                                                i25 = 8;
                                                            }
                                                            z19 = true;
                                                        }
                                                        z19 = true;
                                                        z20 = true;
                                                    }
                                                    z20 = true;
                                                    i26 = 8;
                                                }
                                                if (z18 || iVar4 != iVar6 || eVar6 == E) {
                                                    z21 = z18;
                                                    z22 = true;
                                                } else {
                                                    z21 = false;
                                                    z22 = false;
                                                }
                                                if (z20) {
                                                    iVar11 = iVar5;
                                                    eVar2 = E;
                                                    eVar3 = eVar6;
                                                    iVar12 = q6;
                                                    i27 = i14;
                                                    i28 = 8;
                                                    eVar4 = eVar7;
                                                } else {
                                                    iVar11 = iVar5;
                                                    eVar2 = E;
                                                    i27 = i14;
                                                    eVar4 = eVar7;
                                                    i28 = 8;
                                                    eVar3 = eVar6;
                                                    iVar12 = q6;
                                                    dVar.c(q6, iVar4, dVar2.b(), f6, iVar6, iVar11, dVar3.b(), this.f12553f0 == 8 ? 4 : i24);
                                                }
                                                if (this.f12553f0 != i28) {
                                                    return;
                                                }
                                                if (z21) {
                                                    if (!z6 || iVar4 == iVar6 || z16) {
                                                        eVar5 = eVar3;
                                                    } else {
                                                        eVar5 = eVar3;
                                                        if ((eVar5 instanceof p.a) || (eVar4 instanceof p.a)) {
                                                            i34 = 6;
                                                            iVar14 = iVar12;
                                                            dVar.h(iVar14, iVar4, dVar2.b(), i34);
                                                            iVar13 = iVar11;
                                                            dVar.j(iVar13, iVar6, -dVar3.b(), i34);
                                                            i26 = i34;
                                                        }
                                                    }
                                                    i34 = i26;
                                                    iVar14 = iVar12;
                                                    dVar.h(iVar14, iVar4, dVar2.b(), i34);
                                                    iVar13 = iVar11;
                                                    dVar.j(iVar13, iVar6, -dVar3.b(), i34);
                                                    i26 = i34;
                                                } else {
                                                    iVar13 = iVar11;
                                                    eVar5 = eVar3;
                                                    iVar14 = iVar12;
                                                }
                                                if (!z6 || !z13 || (eVar5 instanceof p.a) || (eVar4 instanceof p.a)) {
                                                    i29 = i25;
                                                    i30 = i26;
                                                    z23 = z22;
                                                } else {
                                                    z23 = true;
                                                    i29 = 6;
                                                    i30 = 6;
                                                }
                                                if (z23) {
                                                    if (!z19 || (z12 && !z7)) {
                                                        i33 = i29;
                                                    } else {
                                                        if (eVar5 != eVar2 && eVar4 != eVar2) {
                                                            i49 = i29;
                                                        }
                                                        i49 = ((eVar5 instanceof g) || (eVar4 instanceof g)) ? 5 : 5;
                                                        i33 = Math.max(z12 ? 5 : ((eVar5 instanceof p.a) || (eVar4 instanceof p.a)) ? 5 : 5, i29);
                                                    }
                                                    if (z6) {
                                                        i33 = Math.min(i30, i33);
                                                        if (z10 && !z12 && (eVar5 == eVar2 || eVar4 == eVar2)) {
                                                            i33 = 4;
                                                        }
                                                    }
                                                    dVar.e(iVar14, iVar4, dVar2.b(), i33);
                                                    dVar.e(iVar13, iVar6, -dVar3.b(), i33);
                                                }
                                                if (z6) {
                                                    i31 = 8;
                                                    int b6 = iVar == iVar4 ? dVar2.b() : 0;
                                                    if (iVar4 != iVar) {
                                                        dVar.h(iVar14, iVar, b6, 5);
                                                    }
                                                } else {
                                                    i31 = 8;
                                                }
                                                if (z6 && z16 && i8 == 0 && i20 == 0) {
                                                    if (z16 && i27 == 3) {
                                                        i32 = 0;
                                                    } else {
                                                        i32 = 0;
                                                        i31 = 5;
                                                    }
                                                    dVar.h(iVar13, iVar14, i32, i31);
                                                }
                                                if (z6 || !z17) {
                                                    return;
                                                }
                                                if (dVar3.f12536d != null) {
                                                    i39 = dVar3.b();
                                                    iVar15 = iVar2;
                                                } else {
                                                    iVar15 = iVar2;
                                                    i39 = 0;
                                                }
                                                if (iVar6 != iVar15) {
                                                    dVar.h(iVar15, iVar13, i39, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            i24 = 6;
                                            z18 = true;
                                            i25 = 4;
                                            z19 = false;
                                            z20 = true;
                                            i26 = 5;
                                            if (z18) {
                                            }
                                            z21 = z18;
                                            z22 = true;
                                            if (z20) {
                                            }
                                            if (this.f12553f0 != i28) {
                                            }
                                        }
                                    }
                                    iVar13 = iVar5;
                                    if (z6) {
                                        return;
                                    }
                                    return;
                                } else {
                                    iVar7 = iVar2;
                                    iVar8 = iVar5;
                                    iVar9 = q6;
                                    iVar10 = iVar;
                                    i23 = i19;
                                    i21 = 8;
                                    i22 = 2;
                                    c6 = 1;
                                }
                                if (i23 < i22 && z6 && z17) {
                                    dVar.h(iVar9, iVar10, 0, i21);
                                    char c7 = (z5 || this.F.f12536d == null) ? (char) 1 : (char) 0;
                                    if (z5 || (dVar4 = this.F.f12536d) == null) {
                                        c6 = c7;
                                    } else {
                                        e eVar8 = dVar4.f12534b;
                                        if (eVar8.Q != 0.0f) {
                                            b[] bVarArr = eVar8.M;
                                            b bVar4 = bVarArr[0];
                                            b bVar5 = b.MATCH_CONSTRAINT;
                                            if (bVar4 == bVar5) {
                                            }
                                        }
                                        c6 = 0;
                                    }
                                    if (c6 != 0) {
                                        dVar.h(iVar7, iVar8, 0, i21);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (z6) {
                                dVar.e(q7, q6, i15, i18);
                            } else {
                                dVar.e(q7, q6, i15, 5);
                                dVar.j(q7, q6, i15, i18);
                            }
                            iVar4 = q8;
                            iVar5 = q7;
                            i20 = i46;
                        }
                        z16 = z15;
                        iVar6 = iVar3;
                        z17 = z8;
                        i19 = i43;
                        if (!z14) {
                        }
                        if (i23 < i22) {
                        }
                    }
                }
                iVar3 = q9;
                i16 = 8;
                if (!z15) {
                }
                z16 = z15;
                iVar6 = iVar3;
                z17 = z8;
                i19 = i43;
                if (!z14) {
                }
                if (i23 < i22) {
                }
            }
        }
        z15 = false;
        if (this.f12553f0 != 8) {
        }
        if (z14) {
        }
        iVar3 = q9;
        i16 = 8;
        if (!z15) {
        }
        z16 = z15;
        iVar6 = iVar3;
        z17 = z8;
        i19 = i43;
        if (!z14) {
        }
        if (i23 < i22) {
        }
    }

    public int A() {
        return this.f12585w[0];
    }

    public void A0(int i6) {
        this.O = i6;
        int i7 = this.Z;
        if (i6 < i7) {
            this.O = i7;
        }
    }

    public int B() {
        return this.f12543a0;
    }

    public void B0(int i6) {
        this.S = i6;
    }

    public int C() {
        return this.Z;
    }

    public void C0(int i6) {
        this.T = i6;
    }

    public e D(int i6) {
        d dVar;
        d dVar2;
        if (i6 != 0) {
            if (i6 == 1 && (dVar2 = (dVar = this.E).f12536d) != null && dVar2.f12536d == dVar) {
                return dVar2.f12534b;
            }
            return null;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.f12536d;
        if (dVar4 == null || dVar4.f12536d != dVar3) {
            return null;
        }
        return dVar4.f12534b;
    }

    public void D0(boolean z5, boolean z6, boolean z7, boolean z8) {
        if (this.f12582u == -1) {
            if (z7 && !z8) {
                this.f12582u = 0;
            } else if (!z7 && z8) {
                this.f12582u = 1;
                if (this.R == -1) {
                    this.f12584v = 1.0f / this.f12584v;
                }
            }
        }
        if (this.f12582u == 0 && (!this.C.i() || !this.E.i())) {
            this.f12582u = 1;
        } else if (this.f12582u == 1 && (!this.B.i() || !this.D.i())) {
            this.f12582u = 0;
        }
        if (this.f12582u == -1 && (!this.C.i() || !this.E.i() || !this.B.i() || !this.D.i())) {
            if (this.C.i() && this.E.i()) {
                this.f12582u = 0;
            } else if (this.B.i() && this.D.i()) {
                this.f12584v = 1.0f / this.f12584v;
                this.f12582u = 1;
            }
        }
        if (this.f12582u == -1) {
            int i6 = this.f12570o;
            if (i6 > 0 && this.f12576r == 0) {
                this.f12582u = 0;
            } else if (i6 != 0 || this.f12576r <= 0) {
            } else {
                this.f12584v = 1.0f / this.f12584v;
                this.f12582u = 1;
            }
        }
    }

    public e E() {
        return this.N;
    }

    public void E0(boolean z5, boolean z6) {
        int i6;
        int i7;
        boolean k6 = z5 & this.f12550e.k();
        boolean k7 = z6 & this.f12552f.k();
        q.j jVar = this.f12550e;
        int i8 = jVar.f12693h.f12666g;
        l lVar = this.f12552f;
        int i9 = lVar.f12693h.f12666g;
        int i10 = jVar.f12694i.f12666g;
        int i11 = lVar.f12694i.f12666g;
        int i12 = i11 - i9;
        if (i10 - i8 < 0 || i12 < 0 || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE) {
            i10 = 0;
            i8 = 0;
            i11 = 0;
            i9 = 0;
        }
        int i13 = i10 - i8;
        int i14 = i11 - i9;
        if (k6) {
            this.S = i8;
        }
        if (k7) {
            this.T = i9;
        }
        if (this.f12553f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        if (k6) {
            if (this.M[0] == b.FIXED && i13 < (i7 = this.O)) {
                i13 = i7;
            }
            this.O = i13;
            int i15 = this.Z;
            if (i13 < i15) {
                this.O = i15;
            }
        }
        if (k7) {
            if (this.M[1] == b.FIXED && i14 < (i6 = this.P)) {
                i14 = i6;
            }
            this.P = i14;
            int i16 = this.f12543a0;
            if (i14 < i16) {
                this.P = i16;
            }
        }
    }

    public e F(int i6) {
        d dVar;
        d dVar2;
        if (i6 != 0) {
            if (i6 == 1 && (dVar2 = (dVar = this.C).f12536d) != null && dVar2.f12536d == dVar) {
                return dVar2.f12534b;
            }
            return null;
        }
        d dVar3 = this.B;
        d dVar4 = dVar3.f12536d;
        if (dVar4 == null || dVar4.f12536d != dVar3) {
            return null;
        }
        return dVar4.f12534b;
    }

    public void F0(o.d dVar) {
        int x5 = dVar.x(this.B);
        int x6 = dVar.x(this.C);
        int x7 = dVar.x(this.D);
        int x8 = dVar.x(this.E);
        q.j jVar = this.f12550e;
        q.f fVar = jVar.f12693h;
        if (fVar.f12669j) {
            q.f fVar2 = jVar.f12694i;
            if (fVar2.f12669j) {
                x5 = fVar.f12666g;
                x7 = fVar2.f12666g;
            }
        }
        l lVar = this.f12552f;
        q.f fVar3 = lVar.f12693h;
        if (fVar3.f12669j) {
            q.f fVar4 = lVar.f12694i;
            if (fVar4.f12669j) {
                x6 = fVar3.f12666g;
                x8 = fVar4.f12666g;
            }
        }
        int i6 = x8 - x6;
        if (x7 - x5 < 0 || i6 < 0 || x5 == Integer.MIN_VALUE || x5 == Integer.MAX_VALUE || x6 == Integer.MIN_VALUE || x6 == Integer.MAX_VALUE || x7 == Integer.MIN_VALUE || x7 == Integer.MAX_VALUE || x8 == Integer.MIN_VALUE || x8 == Integer.MAX_VALUE) {
            x5 = 0;
            x8 = 0;
            x6 = 0;
            x7 = 0;
        }
        c0(x5, x6, x7, x8);
    }

    public int G() {
        return O() + this.O;
    }

    public m H(int i6) {
        if (i6 == 0) {
            return this.f12550e;
        }
        if (i6 == 1) {
            return this.f12552f;
        }
        return null;
    }

    public float I() {
        return this.f12547c0;
    }

    public int J() {
        return this.f12569n0;
    }

    public b K() {
        return this.M[1];
    }

    public int L() {
        int i6 = this.B != null ? 0 + this.C.f12537e : 0;
        return this.D != null ? i6 + this.E.f12537e : i6;
    }

    public int M() {
        return this.f12553f0;
    }

    public int N() {
        if (this.f12553f0 == 8) {
            return 0;
        }
        return this.O;
    }

    public int O() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.S : ((f) eVar).C0 + this.S;
    }

    public int P() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.T : ((f) eVar).D0 + this.T;
    }

    public boolean Q() {
        return this.f12587y;
    }

    public void R(d.b bVar, e eVar, d.b bVar2, int i6, int i7) {
        k(bVar).a(eVar.k(bVar2), i6, i7, true);
    }

    public boolean T() {
        d dVar = this.B;
        d dVar2 = dVar.f12536d;
        if (dVar2 == null || dVar2.f12536d != dVar) {
            d dVar3 = this.D;
            d dVar4 = dVar3.f12536d;
            return dVar4 != null && dVar4.f12536d == dVar3;
        }
        return true;
    }

    public boolean U() {
        return this.f12588z;
    }

    public boolean V() {
        d dVar = this.C;
        d dVar2 = dVar.f12536d;
        if (dVar2 == null || dVar2.f12536d != dVar) {
            d dVar3 = this.E;
            d dVar4 = dVar3.f12536d;
            return dVar4 != null && dVar4.f12536d == dVar3;
        }
        return true;
    }

    public void W() {
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.N = null;
        this.f12586x = 0.0f;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f12543a0 = 0;
        float f6 = f12541v0;
        this.f12545b0 = f6;
        this.f12547c0 = f6;
        b[] bVarArr = this.M;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f12549d0 = null;
        this.f12551e0 = 0;
        this.f12553f0 = 0;
        this.f12557h0 = null;
        this.f12559i0 = false;
        this.f12561j0 = false;
        this.f12567m0 = 0;
        this.f12569n0 = 0;
        this.f12571o0 = false;
        this.f12573p0 = false;
        float[] fArr = this.f12575q0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f12560j = -1;
        this.f12562k = -1;
        int[] iArr = this.f12585w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f12564l = 0;
        this.f12566m = 0;
        this.f12574q = 1.0f;
        this.f12580t = 1.0f;
        this.f12572p = Integer.MAX_VALUE;
        this.f12578s = Integer.MAX_VALUE;
        this.f12570o = 0;
        this.f12576r = 0;
        this.f12558i = false;
        this.f12582u = -1;
        this.f12584v = 1.0f;
        this.f12563k0 = false;
        this.f12565l0 = false;
        boolean[] zArr = this.f12554g;
        zArr[0] = true;
        zArr[1] = true;
        this.A = false;
        boolean[] zArr2 = this.L;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void X(o.c cVar) {
        this.B.l(cVar);
        this.C.l(cVar);
        this.D.l(cVar);
        this.E.l(cVar);
        this.F.l(cVar);
        this.I.l(cVar);
        this.G.l(cVar);
        this.H.l(cVar);
    }

    public void Y(int i6) {
        this.Y = i6;
        this.f12587y = i6 > 0;
    }

    public void Z(Object obj) {
        this.f12549d0 = obj;
    }

    public void a0(String str) {
        this.f12555g0 = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0087 -> B:41:0x0088). Please submit an issue!!! */
    public void b0(String str) {
        float f6;
        int i6 = 0;
        if (str == null || str.length() == 0) {
            this.Q = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i7 = -1;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            i7 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
            r3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(r3);
            if (substring2.length() > 0) {
                f6 = Float.parseFloat(substring2);
            }
            f6 = 0.0f;
        } else {
            String substring3 = str.substring(r3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f6 = i7 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f6 = 0.0f;
        }
        i6 = (f6 > i6 ? 1 : (f6 == i6 ? 0 : -1));
        if (i6 > 0) {
            this.Q = f6;
            this.R = i7;
        }
    }

    public void c0(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12 = i8 - i6;
        int i13 = i9 - i7;
        this.S = i6;
        this.T = i7;
        if (this.f12553f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        b[] bVarArr = this.M;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i12 < (i11 = this.O)) {
            i12 = i11;
        }
        if (bVarArr[1] == bVar2 && i13 < (i10 = this.P)) {
            i13 = i10;
        }
        this.O = i12;
        this.P = i13;
        int i14 = this.f12543a0;
        if (i13 < i14) {
            this.P = i14;
        }
        int i15 = this.Z;
        if (i12 < i15) {
            this.O = i15;
        }
    }

    public void d0(boolean z5) {
        this.f12587y = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this instanceof g;
    }

    public void e0(int i6) {
        this.P = i6;
        int i7 = this.f12543a0;
        if (i6 < i7) {
            this.P = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(o.d dVar) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z9;
        boolean z10;
        boolean z11;
        b bVar;
        boolean z12;
        o.i iVar;
        o.i iVar2;
        o.i iVar3;
        o.i iVar4;
        o.i iVar5;
        boolean z13;
        q.f fVar;
        o.d dVar2;
        o.i iVar6;
        o.i iVar7;
        o.i iVar8;
        int i10;
        int i11;
        int i12;
        boolean z14;
        o.i iVar9;
        o.i iVar10;
        e eVar;
        o.d dVar3;
        o.i iVar11;
        o.i iVar12;
        o.i iVar13;
        o.i iVar14;
        boolean z15;
        int i13;
        int i14;
        boolean T;
        boolean V;
        e eVar2 = this;
        o.i q5 = dVar.q(eVar2.B);
        o.i q6 = dVar.q(eVar2.D);
        o.i q7 = dVar.q(eVar2.C);
        o.i q8 = dVar.q(eVar2.E);
        o.i q9 = dVar.q(eVar2.F);
        boolean z16 = o.d.f12279r;
        q.j jVar = eVar2.f12550e;
        q.f fVar2 = jVar.f12693h;
        if (fVar2.f12669j && jVar.f12694i.f12669j) {
            l lVar = eVar2.f12552f;
            if (lVar.f12693h.f12669j && lVar.f12694i.f12669j) {
                dVar.f(q5, fVar2.f12666g);
                dVar.f(q6, eVar2.f12550e.f12694i.f12666g);
                dVar.f(q7, eVar2.f12552f.f12693h.f12666g);
                dVar.f(q8, eVar2.f12552f.f12694i.f12666g);
                dVar.f(q9, eVar2.f12552f.f12683k.f12666g);
                e eVar3 = eVar2.N;
                if (eVar3 != null) {
                    boolean z17 = eVar3 != null && eVar3.M[0] == b.WRAP_CONTENT;
                    boolean z18 = eVar3 != null && eVar3.M[1] == b.WRAP_CONTENT;
                    if (z17 && eVar2.f12554g[0] && !T()) {
                        dVar.h(dVar.q(eVar2.N.D), q6, 0, 8);
                    }
                    if (z18 && eVar2.f12554g[1] && !V()) {
                        dVar.h(dVar.q(eVar2.N.E), q8, 0, 8);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        e eVar4 = eVar2.N;
        if (eVar4 != null) {
            boolean z19 = eVar4 != null && eVar4.M[0] == b.WRAP_CONTENT;
            z5 = eVar4 != null && eVar4.M[1] == b.WRAP_CONTENT;
            if (eVar2.S(0)) {
                ((f) eVar2.N).J0(eVar2, 0);
                T = true;
            } else {
                T = T();
            }
            if (eVar2.S(1)) {
                ((f) eVar2.N).J0(eVar2, 1);
                V = true;
            } else {
                V = V();
            }
            if (!T && z19 && eVar2.f12553f0 != 8 && eVar2.B.f12536d == null && eVar2.D.f12536d == null) {
                dVar.h(dVar.q(eVar2.N.D), q6, 0, 1);
            }
            if (!V && z5 && eVar2.f12553f0 != 8 && eVar2.C.f12536d == null && eVar2.E.f12536d == null && eVar2.F == null) {
                dVar.h(dVar.q(eVar2.N.E), q8, 0, 1);
            }
            z6 = z19;
            z8 = T;
            z7 = V;
        } else {
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
        }
        int i15 = eVar2.O;
        int i16 = eVar2.Z;
        if (i15 >= i16) {
            i16 = i15;
        }
        int i17 = eVar2.P;
        int i18 = eVar2.f12543a0;
        if (i17 >= i18) {
            i18 = i17;
        }
        b[] bVarArr = eVar2.M;
        b bVar2 = bVarArr[0];
        b bVar3 = b.MATCH_CONSTRAINT;
        boolean z20 = bVar2 != bVar3;
        b bVar4 = bVarArr[1];
        boolean z21 = bVar4 != bVar3;
        int i19 = eVar2.R;
        eVar2.f12582u = i19;
        int i20 = i16;
        float f6 = eVar2.Q;
        eVar2.f12584v = f6;
        int i21 = i18;
        int i22 = eVar2.f12564l;
        int i23 = eVar2.f12566m;
        if (f6 <= 0.0f || eVar2.f12553f0 == 8) {
            i6 = i23;
            i7 = i22;
            i8 = i20;
            i9 = i21;
            z9 = false;
        } else {
            if (bVar2 == bVar3 && i22 == 0) {
                i22 = 3;
            }
            if (bVar4 == bVar3 && i23 == 0) {
                i23 = 3;
            }
            if (bVar2 == bVar3 && bVar4 == bVar3 && i22 == 3 && i23 == 3) {
                eVar2.D0(z6, z5, z20, z21);
            } else if (bVar2 == bVar3 && i22 == 3) {
                eVar2.f12582u = 0;
                i8 = (int) (f6 * i17);
                i6 = i23;
                if (bVar4 != bVar3) {
                    i9 = i21;
                    z9 = false;
                    i7 = 4;
                } else {
                    i7 = i22;
                    i9 = i21;
                    z9 = true;
                }
            } else if (bVar4 == bVar3 && i23 == 3) {
                eVar2.f12582u = 1;
                if (i19 == -1) {
                    eVar2.f12584v = 1.0f / f6;
                }
                i9 = (int) (eVar2.f12584v * i15);
                if (bVar2 != bVar3) {
                    i7 = i22;
                    i8 = i20;
                    z9 = false;
                    i6 = 4;
                } else {
                    i6 = i23;
                    i7 = i22;
                    i8 = i20;
                    z9 = true;
                }
            }
            i6 = i23;
            i7 = i22;
            i8 = i20;
            i9 = i21;
            z9 = true;
        }
        int[] iArr = eVar2.f12568n;
        iArr[0] = i7;
        iArr[1] = i6;
        eVar2.f12558i = z9;
        if (z9 && ((i14 = eVar2.f12582u) == 0 || i14 == -1)) {
            z10 = true;
            b bVar5 = eVar2.M[0];
            b bVar6 = b.WRAP_CONTENT;
            boolean z22 = bVar5 != bVar6 && (eVar2 instanceof f);
            int i24 = !z22 ? 0 : i8;
            boolean z23 = !eVar2.I.i();
            boolean[] zArr = eVar2.L;
            boolean z24 = zArr[0];
            boolean z25 = zArr[1];
            if (eVar2.f12560j == 2) {
                q.j jVar2 = eVar2.f12550e;
                q.f fVar3 = jVar2.f12693h;
                if (fVar3.f12669j && jVar2.f12694i.f12669j) {
                    dVar.f(q5, fVar3.f12666g);
                    dVar.f(q6, eVar2.f12550e.f12694i.f12666g);
                    if (eVar2.N != null && z6 && eVar2.f12554g[0] && !T()) {
                        dVar.h(dVar.q(eVar2.N.D), q6, 0, 8);
                    }
                    z11 = z5;
                    bVar = bVar6;
                    z12 = z9;
                    z13 = z6;
                    iVar4 = q6;
                    iVar5 = q5;
                    iVar = q9;
                    iVar2 = q8;
                    iVar3 = q7;
                    l lVar2 = eVar2.f12552f;
                    fVar = lVar2.f12693h;
                    if (fVar.f12669j || !lVar2.f12694i.f12669j) {
                        dVar2 = dVar;
                        iVar6 = iVar;
                        iVar7 = iVar2;
                        iVar8 = iVar3;
                        i10 = 8;
                        i11 = 0;
                        i12 = 1;
                        z14 = true;
                    } else {
                        dVar2 = dVar;
                        iVar8 = iVar3;
                        dVar2.f(iVar8, fVar.f12666g);
                        iVar7 = iVar2;
                        dVar2.f(iVar7, eVar2.f12552f.f12694i.f12666g);
                        iVar6 = iVar;
                        dVar2.f(iVar6, eVar2.f12552f.f12683k.f12666g);
                        e eVar5 = eVar2.N;
                        if (eVar5 == null || z7 || !z11) {
                            i10 = 8;
                            i11 = 0;
                            i12 = 1;
                        } else {
                            i12 = 1;
                            if (eVar2.f12554g[1]) {
                                i10 = 8;
                                i11 = 0;
                                dVar2.h(dVar2.q(eVar5.E), iVar7, 0, 8);
                            } else {
                                i10 = 8;
                                i11 = 0;
                            }
                        }
                        z14 = false;
                    }
                    if (eVar2.f12562k == 2 ? false : z14) {
                        boolean z26 = eVar2.M[i12] == bVar && (eVar2 instanceof f);
                        if (z26) {
                            i9 = 0;
                        }
                        boolean z27 = z12 && ((i13 = eVar2.f12582u) == i12 || i13 == -1);
                        e eVar6 = eVar2.N;
                        o.i q10 = eVar6 != null ? dVar2.q(eVar6.E) : null;
                        e eVar7 = eVar2.N;
                        o.i q11 = eVar7 != null ? dVar2.q(eVar7.C) : null;
                        if (eVar2.Y > 0 || eVar2.f12553f0 == i10) {
                            dVar2.e(iVar6, iVar8, l(), i10);
                            d dVar4 = eVar2.F.f12536d;
                            if (dVar4 != null) {
                                dVar2.e(iVar6, dVar2.q(dVar4), i11, i10);
                                if (z11) {
                                    dVar2.h(q10, dVar2.q(eVar2.E), i11, 5);
                                }
                                z15 = false;
                                boolean z28 = z13;
                                iVar9 = iVar7;
                                iVar10 = iVar8;
                                h(dVar, false, z11, z28, eVar2.f12554g[i12], q11, q10, eVar2.M[i12], z26, eVar2.C, eVar2.E, eVar2.T, i9, eVar2.f12543a0, eVar2.f12585w[i12], eVar2.f12547c0, z27, z7, z8, z25, i6, i7, eVar2.f12576r, eVar2.f12578s, eVar2.f12580t, z15);
                            } else if (eVar2.f12553f0 == i10) {
                                dVar2.e(iVar6, iVar8, i11, i10);
                            }
                        }
                        z15 = z23;
                        boolean z282 = z13;
                        iVar9 = iVar7;
                        iVar10 = iVar8;
                        h(dVar, false, z11, z282, eVar2.f12554g[i12], q11, q10, eVar2.M[i12], z26, eVar2.C, eVar2.E, eVar2.T, i9, eVar2.f12543a0, eVar2.f12585w[i12], eVar2.f12547c0, z27, z7, z8, z25, i6, i7, eVar2.f12576r, eVar2.f12578s, eVar2.f12580t, z15);
                    } else {
                        iVar9 = iVar7;
                        iVar10 = iVar8;
                    }
                    if (z12) {
                        int i25 = 8;
                        eVar = this;
                        int i26 = eVar.f12582u;
                        float f7 = eVar.f12584v;
                        if (i26 == 1) {
                            dVar3 = dVar;
                            iVar11 = iVar9;
                            iVar12 = iVar10;
                            iVar13 = iVar4;
                            iVar14 = iVar5;
                        } else {
                            i25 = 8;
                            dVar3 = dVar;
                            iVar11 = iVar4;
                            iVar12 = iVar5;
                            iVar13 = iVar9;
                            iVar14 = iVar10;
                        }
                        dVar3.k(iVar11, iVar12, iVar13, iVar14, f7, i25);
                    } else {
                        eVar = this;
                    }
                    if (eVar.I.i()) {
                        dVar.b(eVar, eVar.I.f().d(), (float) Math.toRadians(eVar.f12586x + 90.0f), eVar.I.b());
                        return;
                    }
                    return;
                }
                e eVar8 = eVar2.N;
                o.i q12 = eVar8 != null ? dVar.q(eVar8.D) : null;
                e eVar9 = eVar2.N;
                z13 = z6;
                iVar4 = q6;
                iVar5 = q5;
                z11 = z5;
                iVar = q9;
                iVar2 = q8;
                iVar3 = q7;
                bVar = bVar6;
                z12 = z9;
                h(dVar, true, z13, z11, eVar2.f12554g[0], eVar9 != null ? dVar.q(eVar9.B) : null, q12, eVar2.M[0], z22, eVar2.B, eVar2.D, eVar2.S, i24, eVar2.Z, eVar2.f12585w[0], eVar2.f12545b0, z10, z8, z7, z24, i7, i6, eVar2.f12570o, eVar2.f12572p, eVar2.f12574q, z23);
            } else {
                z11 = z5;
                bVar = bVar6;
                z12 = z9;
                iVar = q9;
                iVar2 = q8;
                iVar3 = q7;
                iVar4 = q6;
                iVar5 = q5;
                z13 = z6;
            }
            eVar2 = this;
            l lVar22 = eVar2.f12552f;
            fVar = lVar22.f12693h;
            if (fVar.f12669j) {
            }
            dVar2 = dVar;
            iVar6 = iVar;
            iVar7 = iVar2;
            iVar8 = iVar3;
            i10 = 8;
            i11 = 0;
            i12 = 1;
            z14 = true;
            if (eVar2.f12562k == 2 ? false : z14) {
            }
            if (z12) {
            }
            if (eVar.I.i()) {
            }
        }
        z10 = false;
        b bVar52 = eVar2.M[0];
        b bVar62 = b.WRAP_CONTENT;
        if (bVar52 != bVar62) {
        }
        if (!z22) {
        }
        boolean z232 = !eVar2.I.i();
        boolean[] zArr2 = eVar2.L;
        boolean z242 = zArr2[0];
        boolean z252 = zArr2[1];
        if (eVar2.f12560j == 2) {
        }
        eVar2 = this;
        l lVar222 = eVar2.f12552f;
        fVar = lVar222.f12693h;
        if (fVar.f12669j) {
        }
        dVar2 = dVar;
        iVar6 = iVar;
        iVar7 = iVar2;
        iVar8 = iVar3;
        i10 = 8;
        i11 = 0;
        i12 = 1;
        z14 = true;
        if (eVar2.f12562k == 2 ? false : z14) {
        }
        if (z12) {
        }
        if (eVar.I.i()) {
        }
    }

    public void f0(float f6) {
        this.f12545b0 = f6;
    }

    public boolean g() {
        return this.f12553f0 != 8;
    }

    public void g0(int i6) {
        this.f12567m0 = i6;
    }

    public void h0(int i6, int i7) {
        this.S = i6;
        int i8 = i7 - i6;
        this.O = i8;
        int i9 = this.Z;
        if (i8 < i9) {
            this.O = i9;
        }
    }

    public void i(e eVar, float f6, int i6) {
        d.b bVar = d.b.CENTER;
        R(bVar, eVar, bVar, i6, 0);
        this.f12586x = f6;
    }

    public void i0(b bVar) {
        this.M[0] = bVar;
    }

    public void j(o.d dVar) {
        dVar.q(this.B);
        dVar.q(this.C);
        dVar.q(this.D);
        dVar.q(this.E);
        if (this.Y > 0) {
            dVar.q(this.F);
        }
    }

    public void j0(int i6, int i7, int i8, float f6) {
        this.f12564l = i6;
        this.f12570o = i7;
        if (i8 == Integer.MAX_VALUE) {
            i8 = 0;
        }
        this.f12572p = i8;
        this.f12574q = f6;
        if (f6 <= 0.0f || f6 >= 1.0f || i6 != 0) {
            return;
        }
        this.f12564l = 2;
    }

    public d k(d.b bVar) {
        switch (a.f12589a[bVar.ordinal()]) {
            case 1:
                return this.B;
            case 2:
                return this.C;
            case 3:
                return this.D;
            case 4:
                return this.E;
            case 5:
                return this.F;
            case 6:
                return this.I;
            case 7:
                return this.G;
            case 8:
                return this.H;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void k0(float f6) {
        this.f12575q0[0] = f6;
    }

    public int l() {
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0(int i6, boolean z5) {
        this.L[i6] = z5;
    }

    public float m(int i6) {
        if (i6 == 0) {
            return this.f12545b0;
        }
        if (i6 == 1) {
            return this.f12547c0;
        }
        return -1.0f;
    }

    public void m0(boolean z5) {
        this.f12588z = z5;
    }

    public int n() {
        return P() + this.P;
    }

    public void n0(int i6) {
        this.f12585w[1] = i6;
    }

    public Object o() {
        return this.f12549d0;
    }

    public void o0(int i6) {
        this.f12585w[0] = i6;
    }

    public String p() {
        return this.f12555g0;
    }

    public void p0(int i6) {
        if (i6 < 0) {
            i6 = 0;
        }
        this.f12543a0 = i6;
    }

    public b q(int i6) {
        if (i6 == 0) {
            return w();
        }
        if (i6 == 1) {
            return K();
        }
        return null;
    }

    public void q0(int i6) {
        if (i6 < 0) {
            i6 = 0;
        }
        this.Z = i6;
    }

    public float r() {
        return this.Q;
    }

    public void r0(int i6, int i7) {
        this.S = i6;
        this.T = i7;
    }

    public int s() {
        return this.R;
    }

    public void s0(e eVar) {
        this.N = eVar;
    }

    public int t() {
        if (this.f12553f0 == 8) {
            return 0;
        }
        return this.P;
    }

    public void t0(float f6) {
        this.f12547c0 = f6;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.f12557h0;
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (str2 != null) {
            str = "type: " + this.f12557h0 + " ";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (this.f12555g0 != null) {
            str3 = "id: " + this.f12555g0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.S);
        sb.append(", ");
        sb.append(this.T);
        sb.append(") - (");
        sb.append(this.O);
        sb.append(" x ");
        sb.append(this.P);
        sb.append(")");
        return sb.toString();
    }

    public float u() {
        return this.f12545b0;
    }

    public void u0(int i6) {
        this.f12569n0 = i6;
    }

    public int v() {
        return this.f12567m0;
    }

    public void v0(int i6, int i7) {
        this.T = i6;
        int i8 = i7 - i6;
        this.P = i8;
        int i9 = this.f12543a0;
        if (i8 < i9) {
            this.P = i9;
        }
    }

    public b w() {
        return this.M[0];
    }

    public void w0(b bVar) {
        this.M[1] = bVar;
    }

    public int x() {
        d dVar = this.B;
        int i6 = dVar != null ? 0 + dVar.f12537e : 0;
        d dVar2 = this.D;
        return dVar2 != null ? i6 + dVar2.f12537e : i6;
    }

    public void x0(int i6, int i7, int i8, float f6) {
        this.f12566m = i6;
        this.f12576r = i7;
        if (i8 == Integer.MAX_VALUE) {
            i8 = 0;
        }
        this.f12578s = i8;
        this.f12580t = f6;
        if (f6 <= 0.0f || f6 >= 1.0f || i6 != 0) {
            return;
        }
        this.f12566m = 2;
    }

    public int y(int i6) {
        if (i6 == 0) {
            return N();
        }
        if (i6 == 1) {
            return t();
        }
        return 0;
    }

    public void y0(float f6) {
        this.f12575q0[1] = f6;
    }

    public int z() {
        return this.f12585w[1];
    }

    public void z0(int i6) {
        this.f12553f0 = i6;
    }
}
