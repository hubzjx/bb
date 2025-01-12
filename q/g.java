package q;

import q.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m  reason: collision with root package name */
    public int f12672m;

    public g(m mVar) {
        super(mVar);
        this.f12664e = mVar instanceof j ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // q.f
    public void d(int i6) {
        if (this.f12669j) {
            return;
        }
        this.f12669j = true;
        this.f12666g = i6;
        for (d dVar : this.f12670k) {
            dVar.a(dVar);
        }
    }
}
