package q;

import java.util.ArrayList;
import java.util.Iterator;
import p.e;
/* loaded from: classes.dex */
public class c extends m {

    /* renamed from: k  reason: collision with root package name */
    ArrayList f12649k;

    /* renamed from: l  reason: collision with root package name */
    private int f12650l;

    public c(p.e eVar, int i6) {
        super(eVar);
        this.f12649k = new ArrayList();
        this.f12691f = i6;
        q();
    }

    private void q() {
        p.e eVar;
        p.e eVar2 = this.f12687b;
        do {
            eVar = eVar2;
            eVar2 = eVar2.F(this.f12691f);
        } while (eVar2 != null);
        this.f12687b = eVar;
        this.f12649k.add(eVar.H(this.f12691f));
        p.e D = eVar.D(this.f12691f);
        while (D != null) {
            this.f12649k.add(D.H(this.f12691f));
            D = D.D(this.f12691f);
        }
        Iterator it = this.f12649k.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            int i6 = this.f12691f;
            if (i6 == 0) {
                mVar.f12687b.f12546c = this;
            } else if (i6 == 1) {
                mVar.f12687b.f12548d = this;
            }
        }
        if ((this.f12691f == 0 && ((p.f) this.f12687b.E()).V0()) && this.f12649k.size() > 1) {
            ArrayList arrayList = this.f12649k;
            this.f12687b = ((m) arrayList.get(arrayList.size() - 1)).f12687b;
        }
        this.f12650l = this.f12691f == 0 ? this.f12687b.v() : this.f12687b.J();
    }

    private p.e r() {
        for (int i6 = 0; i6 < this.f12649k.size(); i6++) {
            m mVar = (m) this.f12649k.get(i6);
            if (mVar.f12687b.M() != 8) {
                return mVar.f12687b;
            }
        }
        return null;
    }

    private p.e s() {
        for (int size = this.f12649k.size() - 1; size >= 0; size--) {
            m mVar = (m) this.f12649k.get(size);
            if (mVar.f12687b.M() != 8) {
                return mVar.f12687b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01a0, code lost:
        if (r1 != r7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01c6, code lost:
        if (r1 != r7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01c8, code lost:
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01cb, code lost:
        r9.f12690e.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x03eb, code lost:
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    @Override // q.m, q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f6;
        boolean z5;
        int i11;
        int i12;
        int i13;
        boolean z6;
        int i14;
        int i15;
        float f7;
        int i16;
        int max;
        int i17;
        int i18;
        if (this.f12693h.f12669j && this.f12694i.f12669j) {
            p.e E = this.f12687b.E();
            boolean V0 = (E == null || !(E instanceof p.f)) ? false : ((p.f) E).V0();
            int i19 = this.f12694i.f12666g - this.f12693h.f12666g;
            int size = this.f12649k.size();
            int i20 = 0;
            while (true) {
                i6 = -1;
                i7 = 8;
                if (i20 >= size) {
                    i20 = -1;
                    break;
                } else if (((m) this.f12649k.get(i20)).f12687b.M() != 8) {
                    break;
                } else {
                    i20++;
                }
            }
            int i21 = size - 1;
            int i22 = i21;
            while (true) {
                if (i22 < 0) {
                    break;
                }
                if (((m) this.f12649k.get(i22)).f12687b.M() != 8) {
                    i6 = i22;
                    break;
                }
                i22--;
            }
            int i23 = 0;
            while (i23 < 2) {
                int i24 = 0;
                i9 = 0;
                i10 = 0;
                int i25 = 0;
                f6 = 0.0f;
                while (i24 < size) {
                    m mVar = (m) this.f12649k.get(i24);
                    if (mVar.f12687b.M() != i7) {
                        i25++;
                        if (i24 > 0 && i24 >= i20) {
                            i9 += mVar.f12693h.f12665f;
                        }
                        g gVar = mVar.f12690e;
                        int i26 = gVar.f12666g;
                        boolean z7 = mVar.f12689d != e.b.MATCH_CONSTRAINT;
                        if (z7) {
                            int i27 = this.f12691f;
                            if (i27 == 0 && !mVar.f12687b.f12550e.f12690e.f12669j) {
                                return;
                            }
                            if (i27 == 1 && !mVar.f12687b.f12552f.f12690e.f12669j) {
                                return;
                            }
                            i17 = i26;
                        } else {
                            i17 = i26;
                            if (mVar.f12686a == 1 && i23 == 0) {
                                i18 = gVar.f12672m;
                                i10++;
                            } else if (gVar.f12669j) {
                                i18 = i17;
                            }
                            z7 = true;
                            if (z7) {
                                i10++;
                                float f8 = mVar.f12687b.f12575q0[this.f12691f];
                                if (f8 >= 0.0f) {
                                    f6 += f8;
                                }
                            } else {
                                i9 += i18;
                            }
                            if (i24 < i21 && i24 < i6) {
                                i9 += -mVar.f12694i.f12665f;
                            }
                        }
                        i18 = i17;
                        if (z7) {
                        }
                        if (i24 < i21) {
                            i9 += -mVar.f12694i.f12665f;
                        }
                    }
                    i24++;
                    i7 = 8;
                }
                if (i9 < i19 || i10 == 0) {
                    i8 = i25;
                    break;
                } else {
                    i23++;
                    i7 = 8;
                }
            }
            i8 = 0;
            i9 = 0;
            i10 = 0;
            f6 = 0.0f;
            int i28 = this.f12693h.f12666g;
            if (V0) {
                i28 = this.f12694i.f12666g;
            }
            if (i9 > i19) {
                int i29 = (int) (((i9 - i19) / 2.0f) + 0.5f);
                i28 = V0 ? i28 + i29 : i28 - i29;
            }
            if (i10 > 0) {
                float f9 = i19 - i9;
                int i30 = (int) ((f9 / i10) + 0.5f);
                int i31 = 0;
                int i32 = 0;
                while (i31 < size) {
                    m mVar2 = (m) this.f12649k.get(i31);
                    int i33 = i30;
                    int i34 = i9;
                    if (mVar2.f12687b.M() != 8 && mVar2.f12689d == e.b.MATCH_CONSTRAINT) {
                        g gVar2 = mVar2.f12690e;
                        if (!gVar2.f12669j) {
                            if (f6 > 0.0f) {
                                i15 = i28;
                                i16 = (int) (((mVar2.f12687b.f12575q0[this.f12691f] * f9) / f6) + 0.5f);
                            } else {
                                i15 = i28;
                                i16 = i33;
                            }
                            if (this.f12691f == 0) {
                                p.e eVar = mVar2.f12687b;
                                f7 = f9;
                                int i35 = eVar.f12572p;
                                z6 = V0;
                                i14 = i8;
                                max = Math.max(eVar.f12570o, mVar2.f12686a == 1 ? Math.min(i16, gVar2.f12672m) : i16);
                                if (i35 > 0) {
                                    max = Math.min(i35, max);
                                }
                            } else {
                                z6 = V0;
                                i14 = i8;
                                f7 = f9;
                                p.e eVar2 = mVar2.f12687b;
                                int i36 = eVar2.f12578s;
                                max = Math.max(eVar2.f12576r, mVar2.f12686a == 1 ? Math.min(i16, gVar2.f12672m) : i16);
                                if (i36 > 0) {
                                    max = Math.min(i36, max);
                                }
                            }
                        }
                    }
                    z6 = V0;
                    i14 = i8;
                    i15 = i28;
                    f7 = f9;
                    i31++;
                    i30 = i33;
                    i9 = i34;
                    i28 = i15;
                    f9 = f7;
                    V0 = z6;
                    i8 = i14;
                }
                z5 = V0;
                i11 = i8;
                i12 = i28;
                int i37 = i9;
                if (i32 > 0) {
                    i10 -= i32;
                    int i38 = 0;
                    for (int i39 = 0; i39 < size; i39++) {
                        m mVar3 = (m) this.f12649k.get(i39);
                        if (mVar3.f12687b.M() != 8) {
                            if (i39 > 0 && i39 >= i20) {
                                i38 += mVar3.f12693h.f12665f;
                            }
                            i38 += mVar3.f12690e.f12666g;
                            if (i39 < i21 && i39 < i6) {
                                i38 += -mVar3.f12694i.f12665f;
                            }
                        }
                    }
                    i9 = i38;
                } else {
                    i9 = i37;
                }
                i13 = 2;
                if (this.f12650l == 2 && i32 == 0) {
                    this.f12650l = 0;
                }
            } else {
                z5 = V0;
                i11 = i8;
                i12 = i28;
                i13 = 2;
            }
            if (i9 > i19) {
                this.f12650l = i13;
            }
            if (i11 > 0 && i10 == 0 && i20 == i6) {
                this.f12650l = i13;
            }
            int i40 = this.f12650l;
            int i41 = i11;
            if (i40 == 1) {
                int i42 = i41 > 1 ? (i19 - i9) / (i41 - 1) : i41 == 1 ? (i19 - i9) / 2 : 0;
                if (i10 > 0) {
                    i42 = 0;
                }
                int i43 = i12;
                for (int i44 = 0; i44 < size; i44++) {
                    m mVar4 = (m) this.f12649k.get(z5 ? size - (i44 + 1) : i44);
                    if (mVar4.f12687b.M() == 8) {
                        mVar4.f12693h.d(i43);
                        mVar4.f12694i.d(i43);
                    } else {
                        if (i44 > 0) {
                            i43 = z5 ? i43 - i42 : i43 + i42;
                        }
                        if (i44 > 0 && i44 >= i20) {
                            int i45 = mVar4.f12693h.f12665f;
                            i43 = z5 ? i43 - i45 : i43 + i45;
                        }
                        (z5 ? mVar4.f12694i : mVar4.f12693h).d(i43);
                        g gVar3 = mVar4.f12690e;
                        int i46 = gVar3.f12666g;
                        if (mVar4.f12689d == e.b.MATCH_CONSTRAINT && mVar4.f12686a == 1) {
                            i46 = gVar3.f12672m;
                        }
                        i43 = z5 ? i43 - i46 : i43 + i46;
                        (z5 ? mVar4.f12693h : mVar4.f12694i).d(i43);
                        mVar4.f12692g = true;
                        if (i44 < i21 && i44 < i6) {
                            int i47 = -mVar4.f12694i.f12665f;
                            i43 = z5 ? i43 - i47 : i43 + i47;
                        }
                    }
                }
            } else if (i40 == 0) {
                int i48 = (i19 - i9) / (i41 + 1);
                if (i10 > 0) {
                    i48 = 0;
                }
                int i49 = i12;
                for (int i50 = 0; i50 < size; i50++) {
                    m mVar5 = (m) this.f12649k.get(z5 ? size - (i50 + 1) : i50);
                    if (mVar5.f12687b.M() == 8) {
                        mVar5.f12693h.d(i49);
                        mVar5.f12694i.d(i49);
                    } else {
                        int i51 = z5 ? i49 - i48 : i49 + i48;
                        if (i50 > 0 && i50 >= i20) {
                            int i52 = mVar5.f12693h.f12665f;
                            i51 = z5 ? i51 - i52 : i51 + i52;
                        }
                        (z5 ? mVar5.f12694i : mVar5.f12693h).d(i51);
                        g gVar4 = mVar5.f12690e;
                        int i53 = gVar4.f12666g;
                        if (mVar5.f12689d == e.b.MATCH_CONSTRAINT && mVar5.f12686a == 1) {
                            i53 = Math.min(i53, gVar4.f12672m);
                        }
                        i49 = z5 ? i51 - i53 : i51 + i53;
                        (z5 ? mVar5.f12693h : mVar5.f12694i).d(i49);
                        if (i50 < i21 && i50 < i6) {
                            int i54 = -mVar5.f12694i.f12665f;
                            i49 = z5 ? i49 - i54 : i49 + i54;
                        }
                    }
                }
            } else if (i40 == 2) {
                float u5 = this.f12691f == 0 ? this.f12687b.u() : this.f12687b.I();
                if (z5) {
                    u5 = 1.0f - u5;
                }
                int i55 = (((int) ((((float) (i19 - i9)) * u5) + 0.5f)) < 0 || i10 > 0) ? 0 : 0;
                int i56 = z5 ? i12 - i55 : i12 + i55;
                for (int i57 = 0; i57 < size; i57++) {
                    m mVar6 = (m) this.f12649k.get(z5 ? size - (i57 + 1) : i57);
                    if (mVar6.f12687b.M() == 8) {
                        mVar6.f12693h.d(i56);
                        mVar6.f12694i.d(i56);
                    } else {
                        if (i57 > 0 && i57 >= i20) {
                            int i58 = mVar6.f12693h.f12665f;
                            i56 = z5 ? i56 - i58 : i56 + i58;
                        }
                        (z5 ? mVar6.f12694i : mVar6.f12693h).d(i56);
                        g gVar5 = mVar6.f12690e;
                        int i59 = gVar5.f12666g;
                        if (mVar6.f12689d == e.b.MATCH_CONSTRAINT && mVar6.f12686a == 1) {
                            i59 = gVar5.f12672m;
                        }
                        i56 += i59;
                        (z5 ? mVar6.f12693h : mVar6.f12694i).d(i56);
                        if (i57 < i21 && i57 < i6) {
                            int i60 = -mVar6.f12694i.f12665f;
                            i56 = z5 ? i56 - i60 : i56 + i60;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
        b(r5.f12694i, r1, -r0);
     */
    @Override // q.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        f i6;
        int b6;
        Iterator it = this.f12649k.iterator();
        while (it.hasNext()) {
            ((m) it.next()).d();
        }
        int size = this.f12649k.size();
        if (size < 1) {
            return;
        }
        p.e eVar = ((m) this.f12649k.get(0)).f12687b;
        p.e eVar2 = ((m) this.f12649k.get(size - 1)).f12687b;
        if (this.f12691f == 0) {
            p.d dVar = eVar.B;
            p.d dVar2 = eVar2.D;
            f i7 = i(dVar, 0);
            int b7 = dVar.b();
            p.e r5 = r();
            if (r5 != null) {
                b7 = r5.B.b();
            }
            if (i7 != null) {
                b(this.f12693h, i7, b7);
            }
            i6 = i(dVar2, 0);
            b6 = dVar2.b();
            p.e s5 = s();
            if (s5 != null) {
                b6 = s5.D.b();
            }
        } else {
            p.d dVar3 = eVar.C;
            p.d dVar4 = eVar2.E;
            f i8 = i(dVar3, 1);
            int b8 = dVar3.b();
            p.e r6 = r();
            if (r6 != null) {
                b8 = r6.C.b();
            }
            if (i8 != null) {
                b(this.f12693h, i8, b8);
            }
            i6 = i(dVar4, 1);
            b6 = dVar4.b();
            p.e s6 = s();
            if (s6 != null) {
                b6 = s6.E.b();
            }
        }
        this.f12693h.f12660a = this;
        this.f12694i.f12660a = this;
    }

    @Override // q.m
    public void e() {
        for (int i6 = 0; i6 < this.f12649k.size(); i6++) {
            ((m) this.f12649k.get(i6)).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void f() {
        this.f12688c = null;
        Iterator it = this.f12649k.iterator();
        while (it.hasNext()) {
            ((m) it.next()).f();
        }
    }

    @Override // q.m
    public long j() {
        int size = this.f12649k.size();
        long j6 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            m mVar = (m) this.f12649k.get(i6);
            j6 = j6 + mVar.f12693h.f12665f + mVar.j() + mVar.f12694i.f12665f;
        }
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public boolean m() {
        int size = this.f12649k.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!((m) this.f12649k.get(i6)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        Iterator it;
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f12691f == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        while (this.f12649k.iterator().hasNext()) {
            sb2 = ((sb2 + "<") + ((m) it.next())) + "> ";
        }
        return sb2;
    }
}
