package r2;

import java.util.Comparator;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class r implements d {

    /* renamed from: a  reason: collision with root package name */
    private final long f13010a;

    /* renamed from: b  reason: collision with root package name */
    private final TreeSet f13011b = new TreeSet(new Comparator() { // from class: r2.q
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h6;
            h6 = r.h((j) obj, (j) obj2);
            return h6;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private long f13012c;

    public r(long j6) {
        this.f13010a = j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(j jVar, j jVar2) {
        long j6 = jVar.f12979f;
        long j7 = jVar2.f12979f;
        return j6 - j7 == 0 ? jVar.compareTo(jVar2) : j6 < j7 ? -1 : 1;
    }

    private void i(a aVar, long j6) {
        while (this.f13012c + j6 > this.f13010a && !this.f13011b.isEmpty()) {
            aVar.f((j) this.f13011b.first());
        }
    }

    @Override // r2.a.b
    public void a(a aVar, j jVar) {
        this.f13011b.add(jVar);
        this.f13012c += jVar.f12976c;
        i(aVar, 0L);
    }

    @Override // r2.a.b
    public void b(a aVar, j jVar) {
        this.f13011b.remove(jVar);
        this.f13012c -= jVar.f12976c;
    }

    @Override // r2.d
    public void c() {
    }

    @Override // r2.d
    public boolean d() {
        return true;
    }

    @Override // r2.a.b
    public void e(a aVar, j jVar, j jVar2) {
        b(aVar, jVar);
        a(aVar, jVar2);
    }

    @Override // r2.d
    public void f(a aVar, String str, long j6, long j7) {
        if (j7 != -1) {
            i(aVar, j7);
        }
    }
}
