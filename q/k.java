package q;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: h  reason: collision with root package name */
    public static int f12675h;

    /* renamed from: c  reason: collision with root package name */
    m f12678c;

    /* renamed from: d  reason: collision with root package name */
    m f12679d;

    /* renamed from: f  reason: collision with root package name */
    int f12681f;

    /* renamed from: g  reason: collision with root package name */
    int f12682g;

    /* renamed from: a  reason: collision with root package name */
    public int f12676a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12677b = false;

    /* renamed from: e  reason: collision with root package name */
    ArrayList f12680e = new ArrayList();

    public k(m mVar, int i6) {
        this.f12678c = null;
        this.f12679d = null;
        int i7 = f12675h;
        this.f12681f = i7;
        f12675h = i7 + 1;
        this.f12678c = mVar;
        this.f12679d = mVar;
        this.f12682g = i6;
    }

    private long c(f fVar, long j6) {
        m mVar = fVar.f12663d;
        if (mVar instanceof i) {
            return j6;
        }
        int size = fVar.f12670k.size();
        long j7 = j6;
        for (int i6 = 0; i6 < size; i6++) {
            d dVar = (d) fVar.f12670k.get(i6);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f12663d != mVar) {
                    j7 = Math.min(j7, c(fVar2, fVar2.f12665f + j6));
                }
            }
        }
        if (fVar == mVar.f12694i) {
            long j8 = j6 - mVar.j();
            return Math.min(Math.min(j7, c(mVar.f12693h, j8)), j8 - mVar.f12693h.f12665f);
        }
        return j7;
    }

    private long d(f fVar, long j6) {
        m mVar = fVar.f12663d;
        if (mVar instanceof i) {
            return j6;
        }
        int size = fVar.f12670k.size();
        long j7 = j6;
        for (int i6 = 0; i6 < size; i6++) {
            d dVar = (d) fVar.f12670k.get(i6);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f12663d != mVar) {
                    j7 = Math.max(j7, d(fVar2, fVar2.f12665f + j6));
                }
            }
        }
        if (fVar == mVar.f12693h) {
            long j8 = j6 + mVar.j();
            return Math.max(Math.max(j7, d(mVar.f12694i, j8)), j8 - mVar.f12694i.f12665f);
        }
        return j7;
    }

    public void a(m mVar) {
        this.f12680e.add(mVar);
        this.f12679d = mVar;
    }

    public long b(p.f fVar, int i6) {
        long j6;
        m mVar;
        long j7;
        long j8;
        m mVar2 = this.f12678c;
        if (mVar2 instanceof c) {
            if (((c) mVar2).f12691f != i6) {
                return 0L;
            }
        } else if (i6 == 0) {
            if (!(mVar2 instanceof j)) {
                return 0L;
            }
        } else if (!(mVar2 instanceof l)) {
            return 0L;
        }
        f fVar2 = (i6 == 0 ? fVar.f12550e : fVar.f12552f).f12693h;
        f fVar3 = (i6 == 0 ? fVar.f12550e : fVar.f12552f).f12694i;
        boolean contains = mVar2.f12693h.f12671l.contains(fVar2);
        boolean contains2 = this.f12678c.f12694i.f12671l.contains(fVar3);
        long j9 = this.f12678c.j();
        if (!contains || !contains2) {
            if (contains) {
                f fVar4 = this.f12678c.f12693h;
                j8 = d(fVar4, fVar4.f12665f);
                j7 = this.f12678c.f12693h.f12665f + j9;
            } else if (contains2) {
                f fVar5 = this.f12678c.f12694i;
                long c6 = c(fVar5, fVar5.f12665f);
                j7 = (-this.f12678c.f12694i.f12665f) + j9;
                j8 = -c6;
            } else {
                m mVar3 = this.f12678c;
                j6 = mVar3.f12693h.f12665f + mVar3.j();
                mVar = this.f12678c;
            }
            return Math.max(j8, j7);
        }
        long d6 = d(this.f12678c.f12693h, 0L);
        long c7 = c(this.f12678c.f12694i, 0L);
        long j10 = d6 - j9;
        m mVar4 = this.f12678c;
        int i7 = mVar4.f12694i.f12665f;
        if (j10 >= (-i7)) {
            j10 += i7;
        }
        int i8 = mVar4.f12693h.f12665f;
        long j11 = ((-c7) - j9) - i8;
        if (j11 >= i8) {
            j11 -= i8;
        }
        float m5 = mVar4.f12687b.m(i6);
        float f6 = (float) (m5 > 0.0f ? (((float) j11) / m5) + (((float) j10) / (1.0f - m5)) : 0L);
        long j12 = (f6 * m5) + 0.5f + j9 + (f6 * (1.0f - m5)) + 0.5f;
        mVar = this.f12678c;
        j6 = mVar.f12693h.f12665f + j12;
        return j6 - mVar.f12694i.f12665f;
    }
}
