package r3;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    static final f f13046e = new f(g.f13051b, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f13047a;

    /* renamed from: b  reason: collision with root package name */
    private final g f13048b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13049c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13050d;

    private f(g gVar, int i6, int i7, int i8) {
        this.f13048b = gVar;
        this.f13047a = i6;
        this.f13049c = i7;
        this.f13050d = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i6) {
        g gVar = this.f13048b;
        int i7 = this.f13047a;
        int i8 = this.f13050d;
        if (i7 == 4 || i7 == 2) {
            int i9 = d.f13039c[i7][0];
            int i10 = 65535 & i9;
            int i11 = i9 >> 16;
            gVar = gVar.a(i10, i11);
            i8 += i11;
            i7 = 0;
        }
        int i12 = this.f13049c;
        f fVar = new f(gVar, i7, i12 + 1, i8 + ((i12 == 0 || i12 == 31) ? 18 : i12 == 62 ? 9 : 8));
        return fVar.f13049c == 2078 ? fVar.b(i6 + 1) : fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(int i6) {
        int i7 = this.f13049c;
        return i7 == 0 ? this : new f(this.f13048b.b(i6 - i7, i7), this.f13047a, 0, this.f13050d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f13049c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f13050d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f13047a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(f fVar) {
        int i6;
        int i7 = this.f13050d + (d.f13039c[this.f13047a][fVar.f13047a] >> 16);
        int i8 = fVar.f13049c;
        if (i8 > 0 && ((i6 = this.f13049c) == 0 || i6 > i8)) {
            i7 += 10;
        }
        return i7 <= fVar.f13050d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g(int i6, int i7) {
        int i8 = this.f13050d;
        g gVar = this.f13048b;
        int i9 = this.f13047a;
        if (i6 != i9) {
            int i10 = d.f13039c[i9][i6];
            int i11 = 65535 & i10;
            int i12 = i10 >> 16;
            gVar = gVar.a(i11, i12);
            i8 += i12;
        }
        int i13 = i6 == 2 ? 4 : 5;
        return new f(gVar.a(i7, i13), i6, 0, i8 + i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f h(int i6, int i7) {
        g gVar = this.f13048b;
        int i8 = this.f13047a;
        int i9 = i8 == 2 ? 4 : 5;
        return new f(gVar.a(d.f13041e[i8][i6], i9).a(i7, 5), this.f13047a, 0, this.f13050d + i9 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3.a i(byte[] bArr) {
        LinkedList<g> linkedList = new LinkedList();
        for (g gVar = b(bArr.length).f13048b; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        s3.a aVar = new s3.a();
        for (g gVar2 : linkedList) {
            gVar2.c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f13038b[this.f13047a], Integer.valueOf(this.f13050d), Integer.valueOf(this.f13049c));
    }
}
