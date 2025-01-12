package com.google.zxing;
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private final float f5848a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5849b;

    public p(float f6, float f7) {
        this.f5848a = f6;
        this.f5849b = f7;
    }

    private static float a(p pVar, p pVar2, p pVar3) {
        float f6 = pVar2.f5848a;
        float f7 = pVar2.f5849b;
        return ((pVar3.f5848a - f6) * (pVar.f5849b - f7)) - ((pVar3.f5849b - f7) * (pVar.f5848a - f6));
    }

    public static float b(p pVar, p pVar2) {
        return t3.a.a(pVar.f5848a, pVar.f5849b, pVar2.f5848a, pVar2.f5849b);
    }

    public static void e(p[] pVarArr) {
        p pVar;
        p pVar2;
        p pVar3;
        float b6 = b(pVarArr[0], pVarArr[1]);
        float b7 = b(pVarArr[1], pVarArr[2]);
        float b8 = b(pVarArr[0], pVarArr[2]);
        if (b7 >= b6 && b7 >= b8) {
            pVar = pVarArr[0];
            pVar2 = pVarArr[1];
            pVar3 = pVarArr[2];
        } else if (b8 < b7 || b8 < b6) {
            pVar = pVarArr[2];
            pVar2 = pVarArr[0];
            pVar3 = pVarArr[1];
        } else {
            pVar = pVarArr[1];
            pVar2 = pVarArr[0];
            pVar3 = pVarArr[2];
        }
        if (a(pVar2, pVar, pVar3) < 0.0f) {
            p pVar4 = pVar3;
            pVar3 = pVar2;
            pVar2 = pVar4;
        }
        pVarArr[0] = pVar2;
        pVarArr[1] = pVar;
        pVarArr[2] = pVar3;
    }

    public final float c() {
        return this.f5848a;
    }

    public final float d() {
        return this.f5849b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f5848a == pVar.f5848a && this.f5849b == pVar.f5849b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f5848a) * 31) + Float.floatToIntBits(this.f5849b);
    }

    public final String toString() {
        return "(" + this.f5848a + ',' + this.f5849b + ')';
    }
}
