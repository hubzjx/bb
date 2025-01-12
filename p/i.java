package p;

import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class i extends e implements h {

    /* renamed from: w0  reason: collision with root package name */
    public e[] f12599w0 = new e[4];

    /* renamed from: x0  reason: collision with root package name */
    public int f12600x0 = 0;

    @Override // p.h
    public void a(f fVar) {
    }

    @Override // p.h
    public void b() {
        this.f12600x0 = 0;
        Arrays.fill(this.f12599w0, (Object) null);
    }

    @Override // p.h
    public void c(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i6 = this.f12600x0 + 1;
        e[] eVarArr = this.f12599w0;
        if (i6 > eVarArr.length) {
            this.f12599w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f12599w0;
        int i7 = this.f12600x0;
        eVarArr2[i7] = eVar;
        this.f12600x0 = i7 + 1;
    }
}
