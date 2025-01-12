package j$.util.concurrent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    l[] f11096a;

    /* renamed from: b  reason: collision with root package name */
    l f11097b = null;

    /* renamed from: c  reason: collision with root package name */
    o f11098c;

    /* renamed from: d  reason: collision with root package name */
    o f11099d;

    /* renamed from: e  reason: collision with root package name */
    int f11100e;

    /* renamed from: f  reason: collision with root package name */
    int f11101f;

    /* renamed from: g  reason: collision with root package name */
    int f11102g;

    /* renamed from: h  reason: collision with root package name */
    final int f11103h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l[] lVarArr, int i6, int i7, int i8) {
        this.f11096a = lVarArr;
        this.f11103h = i6;
        this.f11100e = i7;
        this.f11101f = i7;
        this.f11102g = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l a() {
        l[] lVarArr;
        int length;
        int i6;
        o oVar;
        l lVar = this.f11097b;
        if (lVar != null) {
            lVar = lVar.f11091d;
        }
        while (lVar == null) {
            if (this.f11101f >= this.f11102g || (lVarArr = this.f11096a) == null || (length = lVarArr.length) <= (i6 = this.f11100e) || i6 < 0) {
                this.f11097b = null;
                return null;
            }
            l m5 = ConcurrentHashMap.m(lVarArr, i6);
            if (m5 == null || m5.f11088a >= 0) {
                lVar = m5;
            } else if (m5 instanceof g) {
                this.f11096a = ((g) m5).f11081e;
                o oVar2 = this.f11099d;
                if (oVar2 != null) {
                    this.f11099d = oVar2.f11095d;
                } else {
                    oVar2 = new o();
                }
                oVar2.f11094c = lVarArr;
                oVar2.f11092a = length;
                oVar2.f11093b = i6;
                oVar2.f11095d = this.f11098c;
                this.f11098c = oVar2;
                lVar = null;
            } else {
                lVar = m5 instanceof q ? ((q) m5).f11107f : null;
            }
            if (this.f11098c != null) {
                while (true) {
                    oVar = this.f11098c;
                    if (oVar == null) {
                        break;
                    }
                    int i7 = this.f11100e;
                    int i8 = oVar.f11092a;
                    int i9 = i7 + i8;
                    this.f11100e = i9;
                    if (i9 < length) {
                        break;
                    }
                    this.f11100e = oVar.f11093b;
                    this.f11096a = oVar.f11094c;
                    oVar.f11094c = null;
                    o oVar3 = oVar.f11095d;
                    oVar.f11095d = this.f11099d;
                    this.f11098c = oVar3;
                    this.f11099d = oVar;
                    length = i8;
                }
                if (oVar == null) {
                    int i10 = this.f11100e + this.f11103h;
                    this.f11100e = i10;
                    if (i10 >= length) {
                        int i11 = this.f11101f + 1;
                        this.f11101f = i11;
                        this.f11100e = i11;
                    }
                }
            } else {
                int i12 = i6 + this.f11103h;
                this.f11100e = i12;
                if (i12 >= length) {
                    int i13 = this.f11101f + 1;
                    this.f11101f = i13;
                    this.f11100e = i13;
                }
            }
        }
        this.f11097b = lVar;
        return lVar;
    }
}
