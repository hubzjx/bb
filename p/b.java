package p;

import java.util.ArrayList;
import p.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, o.d dVar, int i6) {
        int i7;
        c[] cVarArr;
        int i8;
        if (i6 == 0) {
            i7 = fVar.G0;
            cVarArr = fVar.J0;
            i8 = 0;
        } else {
            i7 = fVar.H0;
            cVarArr = fVar.I0;
            i8 = 2;
        }
        for (int i9 = 0; i9 < i7; i9++) {
            c cVar = cVarArr[i9];
            cVar.a();
            b(fVar, dVar, i6, i8, cVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r7 == 2) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r7 == 2) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x024a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x038d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0385 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:326:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void b(f fVar, o.d dVar, int i6, int i7, c cVar) {
        boolean z5;
        boolean z6;
        boolean z7;
        ArrayList arrayList;
        e eVar;
        d dVar2;
        d dVar3;
        d dVar4;
        int i8;
        e eVar2;
        int i9;
        d dVar5;
        o.i iVar;
        d dVar6;
        o.i iVar2;
        e eVar3;
        d dVar7;
        int b6;
        int i10;
        int b7;
        d dVar8;
        o.i iVar3;
        o.i iVar4;
        e eVar4;
        o.i iVar5;
        int size;
        int i11;
        ArrayList arrayList2;
        boolean z8;
        boolean z9;
        boolean z10;
        e eVar5;
        int i12;
        e eVar6 = cVar.f12511a;
        e eVar7 = cVar.f12513c;
        e eVar8 = cVar.f12512b;
        e eVar9 = cVar.f12514d;
        e eVar10 = cVar.f12515e;
        float f6 = cVar.f12521k;
        boolean z11 = fVar.M[i6] == e.b.WRAP_CONTENT;
        if (i6 == 0) {
            int i13 = eVar10.f12567m0;
            z5 = i13 == 0;
            z6 = i13 == 1;
        } else {
            int i14 = eVar10.f12569n0;
            z5 = i14 == 0;
            z6 = i14 == 1;
        }
        boolean z12 = z6;
        boolean z13 = false;
        boolean z14 = z5;
        e eVar11 = eVar6;
        while (true) {
            if (z13) {
                break;
            }
            d dVar9 = eVar11.J[i7];
            int i15 = z7 ? 1 : 4;
            int b8 = dVar9.b();
            e.b bVar = eVar11.M[i6];
            float f7 = f6;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && eVar11.f12568n[i6] == 0) {
                z8 = z13;
                z9 = true;
            } else {
                z8 = z13;
                z9 = false;
            }
            d dVar10 = dVar9.f12536d;
            if (dVar10 != null && eVar11 != eVar6) {
                b8 += dVar10.b();
            }
            int i16 = b8;
            if (!z7 || eVar11 == eVar6 || eVar11 == eVar8) {
                z10 = z14;
            } else {
                z10 = z14;
                i15 = 5;
            }
            d dVar11 = dVar9.f12536d;
            e eVar12 = eVar10;
            if (dVar11 != null) {
                if (eVar11 == eVar8) {
                    eVar5 = eVar6;
                    dVar.h(dVar9.f12539g, dVar11.f12539g, i16, 6);
                } else {
                    eVar5 = eVar6;
                    dVar.h(dVar9.f12539g, dVar11.f12539g, i16, 8);
                }
                dVar.e(dVar9.f12539g, dVar9.f12536d.f12539g, i16, (!z9 || z7) ? i15 : 5);
            } else {
                eVar5 = eVar6;
            }
            if (z11) {
                if (eVar11.M() == 8 || eVar11.M[i6] != bVar2) {
                    i12 = 0;
                } else {
                    d[] dVarArr = eVar11.J;
                    i12 = 0;
                    dVar.h(dVarArr[i7 + 1].f12539g, dVarArr[i7].f12539g, 0, 5);
                }
                dVar.h(eVar11.J[i7].f12539g, fVar.J[i7].f12539g, i12, 8);
            }
            d dVar12 = eVar11.J[i7 + 1].f12536d;
            if (dVar12 != null) {
                e eVar13 = dVar12.f12534b;
                d dVar13 = eVar13.J[i7].f12536d;
                if (dVar13 != null && dVar13.f12534b == eVar11) {
                    r20 = eVar13;
                }
            }
            if (r20 != null) {
                eVar11 = r20;
                z13 = z8;
            } else {
                z13 = true;
            }
            z14 = z10;
            f6 = f7;
            eVar10 = eVar12;
            eVar6 = eVar5;
        }
        e eVar14 = eVar10;
        float f8 = f6;
        e eVar15 = eVar6;
        boolean z15 = z14;
        if (eVar9 != null) {
            int i17 = i7 + 1;
            if (eVar7.J[i17].f12536d != null) {
                d dVar14 = eVar9.J[i17];
                if ((eVar9.M[i6] == e.b.MATCH_CONSTRAINT && eVar9.f12568n[i6] == 0) && !z7) {
                    d dVar15 = dVar14.f12536d;
                    if (dVar15.f12534b == fVar) {
                        dVar.e(dVar14.f12539g, dVar15.f12539g, -dVar14.b(), 5);
                        dVar.j(dVar14.f12539g, eVar7.J[i17].f12536d.f12539g, -dVar14.b(), 6);
                        if (z11) {
                            int i18 = i7 + 1;
                            o.i iVar6 = fVar.J[i18].f12539g;
                            d dVar16 = eVar7.J[i18];
                            dVar.h(iVar6, dVar16.f12539g, dVar16.b(), 8);
                        }
                        arrayList = cVar.f12518h;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            float f9 = (cVar.f12528r || cVar.f12530t) ? f8 : cVar.f12520j;
                            float f10 = 0.0f;
                            e eVar16 = null;
                            i11 = 0;
                            float f11 = 0.0f;
                            while (i11 < size) {
                                e eVar17 = (e) arrayList.get(i11);
                                float f12 = eVar17.f12575q0[i6];
                                if (f12 < f10) {
                                    if (cVar.f12530t) {
                                        d[] dVarArr2 = eVar17.J;
                                        dVar.e(dVarArr2[i7 + 1].f12539g, dVarArr2[i7].f12539g, 0, 4);
                                        arrayList2 = arrayList;
                                        i11++;
                                        arrayList = arrayList2;
                                        f10 = 0.0f;
                                    } else {
                                        f12 = 1.0f;
                                    }
                                }
                                if (f12 == f10) {
                                    d[] dVarArr3 = eVar17.J;
                                    dVar.e(dVarArr3[i7 + 1].f12539g, dVarArr3[i7].f12539g, 0, 8);
                                    arrayList2 = arrayList;
                                    i11++;
                                    arrayList = arrayList2;
                                    f10 = 0.0f;
                                } else {
                                    if (eVar16 != null) {
                                        d[] dVarArr4 = eVar16.J;
                                        o.i iVar7 = dVarArr4[i7].f12539g;
                                        int i19 = i7 + 1;
                                        o.i iVar8 = dVarArr4[i19].f12539g;
                                        d[] dVarArr5 = eVar17.J;
                                        o.i iVar9 = dVarArr5[i7].f12539g;
                                        o.i iVar10 = dVarArr5[i19].f12539g;
                                        arrayList2 = arrayList;
                                        o.b r5 = dVar.r();
                                        r5.l(f11, f9, f12, iVar7, iVar8, iVar9, iVar10);
                                        dVar.d(r5);
                                    } else {
                                        arrayList2 = arrayList;
                                    }
                                    eVar16 = eVar17;
                                    f11 = f12;
                                    i11++;
                                    arrayList = arrayList2;
                                    f10 = 0.0f;
                                }
                            }
                        }
                        if (eVar8 == null && (eVar8 == eVar9 || z7)) {
                            d dVar17 = eVar15.J[i7];
                            int i20 = i7 + 1;
                            d dVar18 = eVar7.J[i20];
                            d dVar19 = dVar17.f12536d;
                            o.i iVar11 = dVar19 != null ? dVar19.f12539g : null;
                            d dVar20 = dVar18.f12536d;
                            o.i iVar12 = dVar20 != null ? dVar20.f12539g : null;
                            d dVar21 = eVar8.J[i7];
                            d dVar22 = eVar9.J[i20];
                            if (iVar11 != null && iVar12 != null) {
                                dVar.c(dVar21.f12539g, iVar11, dVar21.b(), i6 == 0 ? eVar14.f12545b0 : eVar14.f12547c0, iVar12, dVar22.f12539g, dVar22.b(), 7);
                            }
                        } else if (z15 || eVar8 == null) {
                            int i21 = 8;
                            if (z12 && eVar8 != null) {
                                int i22 = cVar.f12520j;
                                boolean z16 = i22 <= 0 && cVar.f12519i == i22;
                                eVar = eVar8;
                                e eVar18 = eVar;
                                while (eVar != null) {
                                    e eVar19 = eVar.f12579s0[i6];
                                    while (eVar19 != null && eVar19.M() == i21) {
                                        eVar19 = eVar19.f12579s0[i6];
                                    }
                                    if (eVar == eVar8 || eVar == eVar9 || eVar19 == null) {
                                        eVar2 = eVar18;
                                        i9 = 8;
                                    } else {
                                        e eVar20 = eVar19 == eVar9 ? null : eVar19;
                                        d dVar23 = eVar.J[i7];
                                        o.i iVar13 = dVar23.f12539g;
                                        d dVar24 = dVar23.f12536d;
                                        if (dVar24 != null) {
                                            o.i iVar14 = dVar24.f12539g;
                                        }
                                        int i23 = i7 + 1;
                                        o.i iVar15 = eVar18.J[i23].f12539g;
                                        int b9 = dVar23.b();
                                        int b10 = eVar.J[i23].b();
                                        if (eVar20 != null) {
                                            dVar5 = eVar20.J[i7];
                                            iVar = dVar5.f12539g;
                                            dVar6 = dVar5.f12536d;
                                            if (dVar6 == null) {
                                                iVar2 = null;
                                                if (dVar5 != null) {
                                                    b10 += dVar5.b();
                                                }
                                                int i24 = b10;
                                                int b11 = eVar18.J[i23].b() + b9;
                                                int i25 = !z16 ? 8 : 4;
                                                if (iVar13 != null || iVar15 == null || iVar == null || iVar2 == null) {
                                                    eVar3 = eVar20;
                                                    eVar2 = eVar18;
                                                    i9 = 8;
                                                } else {
                                                    eVar3 = eVar20;
                                                    eVar2 = eVar18;
                                                    i9 = 8;
                                                    dVar.c(iVar13, iVar15, b11, 0.5f, iVar, iVar2, i24, i25);
                                                }
                                                eVar19 = eVar3;
                                            }
                                        } else {
                                            dVar5 = eVar9.J[i7];
                                            iVar = dVar5 != null ? dVar5.f12539g : null;
                                            dVar6 = eVar.J[i23];
                                        }
                                        iVar2 = dVar6.f12539g;
                                        if (dVar5 != null) {
                                        }
                                        int i242 = b10;
                                        int b112 = eVar18.J[i23].b() + b9;
                                        if (!z16) {
                                        }
                                        if (iVar13 != null) {
                                        }
                                        eVar3 = eVar20;
                                        eVar2 = eVar18;
                                        i9 = 8;
                                        eVar19 = eVar3;
                                    }
                                    if (eVar.M() == i9) {
                                        eVar = eVar2;
                                    }
                                    eVar18 = eVar;
                                    i21 = 8;
                                    eVar = eVar19;
                                }
                                d dVar25 = eVar8.J[i7];
                                dVar2 = eVar15.J[i7].f12536d;
                                int i26 = i7 + 1;
                                dVar3 = eVar9.J[i26];
                                dVar4 = eVar7.J[i26].f12536d;
                                if (dVar2 != null) {
                                    i8 = 5;
                                } else if (eVar8 != eVar9) {
                                    i8 = 5;
                                    dVar.e(dVar25.f12539g, dVar2.f12539g, dVar25.b(), 5);
                                } else {
                                    i8 = 5;
                                    if (dVar4 != null) {
                                        dVar.c(dVar25.f12539g, dVar2.f12539g, dVar25.b(), 0.5f, dVar3.f12539g, dVar4.f12539g, dVar3.b(), 5);
                                    }
                                }
                                if (dVar4 != null && eVar8 != eVar9) {
                                    dVar.e(dVar3.f12539g, dVar4.f12539g, -dVar3.b(), i8);
                                }
                            }
                        } else {
                            int i27 = cVar.f12520j;
                            boolean z17 = i27 > 0 && cVar.f12519i == i27;
                            e eVar21 = eVar8;
                            e eVar22 = eVar21;
                            while (eVar21 != null) {
                                e eVar23 = eVar21.f12579s0[i6];
                                while (eVar23 != null && eVar23.M() == 8) {
                                    eVar23 = eVar23.f12579s0[i6];
                                }
                                if (eVar23 != null || eVar21 == eVar9) {
                                    d dVar26 = eVar21.J[i7];
                                    o.i iVar16 = dVar26.f12539g;
                                    d dVar27 = dVar26.f12536d;
                                    o.i iVar17 = dVar27 != null ? dVar27.f12539g : null;
                                    if (eVar22 != eVar21) {
                                        dVar7 = eVar22.J[i7 + 1];
                                    } else {
                                        if (eVar21 == eVar8 && eVar22 == eVar21) {
                                            dVar7 = eVar15.J[i7].f12536d;
                                            if (dVar7 == null) {
                                                iVar17 = null;
                                            }
                                        }
                                        b6 = dVar26.b();
                                        i10 = i7 + 1;
                                        b7 = eVar21.J[i10].b();
                                        if (eVar23 == null) {
                                            dVar8 = eVar23.J[i7];
                                            o.i iVar18 = dVar8.f12539g;
                                            iVar4 = eVar21.J[i10].f12539g;
                                            iVar3 = iVar18;
                                        } else {
                                            dVar8 = eVar7.J[i10].f12536d;
                                            iVar3 = dVar8 != null ? dVar8.f12539g : null;
                                            iVar4 = eVar21.J[i10].f12539g;
                                        }
                                        if (dVar8 != null) {
                                            b7 += dVar8.b();
                                        }
                                        if (eVar22 != null) {
                                            b6 += eVar22.J[i10].b();
                                        }
                                        if (iVar16 != null && iVar17 != null && iVar3 != null && iVar4 != null) {
                                            if (eVar21 == eVar8) {
                                                b6 = eVar8.J[i7].b();
                                            }
                                            int i28 = b6;
                                            eVar4 = eVar23;
                                            dVar.c(iVar16, iVar17, i28, 0.5f, iVar3, iVar4, eVar21 != eVar9 ? eVar9.J[i10].b() : b7, !z17 ? 8 : 5);
                                            if (eVar21.M() != 8) {
                                                eVar22 = eVar21;
                                            }
                                            eVar21 = eVar4;
                                        }
                                    }
                                    iVar17 = dVar7.f12539g;
                                    b6 = dVar26.b();
                                    i10 = i7 + 1;
                                    b7 = eVar21.J[i10].b();
                                    if (eVar23 == null) {
                                    }
                                    if (dVar8 != null) {
                                    }
                                    if (eVar22 != null) {
                                    }
                                    if (iVar16 != null) {
                                        if (eVar21 == eVar8) {
                                        }
                                        int i282 = b6;
                                        if (eVar21 != eVar9) {
                                        }
                                        eVar4 = eVar23;
                                        dVar.c(iVar16, iVar17, i282, 0.5f, iVar3, iVar4, eVar21 != eVar9 ? eVar9.J[i10].b() : b7, !z17 ? 8 : 5);
                                        if (eVar21.M() != 8) {
                                        }
                                        eVar21 = eVar4;
                                    }
                                }
                                eVar4 = eVar23;
                                if (eVar21.M() != 8) {
                                }
                                eVar21 = eVar4;
                            }
                        }
                        if ((z15 && !z12) || eVar8 == null || eVar8 == eVar9) {
                            return;
                        }
                        d[] dVarArr6 = eVar8.J;
                        d dVar28 = dVarArr6[i7];
                        int i29 = i7 + 1;
                        d dVar29 = eVar9.J[i29];
                        d dVar30 = dVar28.f12536d;
                        iVar5 = dVar30 != null ? dVar30.f12539g : null;
                        d dVar31 = dVar29.f12536d;
                        o.i iVar19 = dVar31 != null ? dVar31.f12539g : null;
                        if (eVar7 != eVar9) {
                            d dVar32 = eVar7.J[i29].f12536d;
                            iVar19 = dVar32 != null ? dVar32.f12539g : null;
                        }
                        if (eVar8 == eVar9) {
                            dVar29 = dVarArr6[i29];
                        }
                        if (iVar5 == null || iVar19 == null) {
                            return;
                        }
                        dVar.c(dVar28.f12539g, iVar5, dVar28.b(), 0.5f, iVar19, dVar29.f12539g, eVar9.J[i29].b(), 5);
                        return;
                    }
                }
                if (z7) {
                    d dVar33 = dVar14.f12536d;
                    if (dVar33.f12534b == fVar) {
                        dVar.e(dVar14.f12539g, dVar33.f12539g, -dVar14.b(), 4);
                    }
                }
                dVar.j(dVar14.f12539g, eVar7.J[i17].f12536d.f12539g, -dVar14.b(), 6);
                if (z11) {
                }
                arrayList = cVar.f12518h;
                if (arrayList != null) {
                    if (cVar.f12528r) {
                    }
                    float f102 = 0.0f;
                    e eVar162 = null;
                    i11 = 0;
                    float f112 = 0.0f;
                    while (i11 < size) {
                    }
                }
                if (eVar8 == null) {
                }
                if (z15) {
                }
                int i212 = 8;
                if (z12) {
                    int i222 = cVar.f12520j;
                    if (i222 <= 0) {
                    }
                    eVar = eVar8;
                    e eVar182 = eVar;
                    while (eVar != null) {
                    }
                    d dVar252 = eVar8.J[i7];
                    dVar2 = eVar15.J[i7].f12536d;
                    int i262 = i7 + 1;
                    dVar3 = eVar9.J[i262];
                    dVar4 = eVar7.J[i262].f12536d;
                    if (dVar2 != null) {
                    }
                    if (dVar4 != null) {
                        dVar.e(dVar3.f12539g, dVar4.f12539g, -dVar3.b(), i8);
                    }
                }
                if (z15) {
                }
                d[] dVarArr62 = eVar8.J;
                d dVar282 = dVarArr62[i7];
                int i292 = i7 + 1;
                d dVar292 = eVar9.J[i292];
                d dVar302 = dVar282.f12536d;
                if (dVar302 != null) {
                }
                d dVar312 = dVar292.f12536d;
                if (dVar312 != null) {
                }
                if (eVar7 != eVar9) {
                }
                if (eVar8 == eVar9) {
                }
                if (iVar5 == null) {
                    return;
                }
                return;
            }
        }
        if (z11) {
        }
        arrayList = cVar.f12518h;
        if (arrayList != null) {
        }
        if (eVar8 == null) {
        }
        if (z15) {
        }
        int i2122 = 8;
        if (z12) {
        }
        if (z15) {
        }
        d[] dVarArr622 = eVar8.J;
        d dVar2822 = dVarArr622[i7];
        int i2922 = i7 + 1;
        d dVar2922 = eVar9.J[i2922];
        d dVar3022 = dVar2822.f12536d;
        if (dVar3022 != null) {
        }
        d dVar3122 = dVar2922.f12536d;
        if (dVar3122 != null) {
        }
        if (eVar7 != eVar9) {
        }
        if (eVar8 == eVar9) {
        }
        if (iVar5 == null) {
        }
    }
}
