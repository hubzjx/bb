package j1;

import c1.x;
import c1.y;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final f f11150a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11151b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11152c;

    /* renamed from: d  reason: collision with root package name */
    private final i f11153d;

    /* renamed from: e  reason: collision with root package name */
    private int f11154e;

    /* renamed from: f  reason: collision with root package name */
    private long f11155f;

    /* renamed from: g  reason: collision with root package name */
    private long f11156g;

    /* renamed from: h  reason: collision with root package name */
    private long f11157h;

    /* renamed from: i  reason: collision with root package name */
    private long f11158i;

    /* renamed from: j  reason: collision with root package name */
    private long f11159j;

    /* renamed from: k  reason: collision with root package name */
    private long f11160k;

    /* renamed from: l  reason: collision with root package name */
    private long f11161l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements x {
        private b() {
        }

        @Override // c1.x
        public boolean f() {
            return true;
        }

        @Override // c1.x
        public x.a i(long j6) {
            return new x.a(new y(j6, s0.s((a.this.f11151b + ((a.this.f11153d.b(j6) * (a.this.f11152c - a.this.f11151b)) / a.this.f11155f)) - 30000, a.this.f11151b, a.this.f11152c - 1)));
        }

        @Override // c1.x
        public long j() {
            return a.this.f11153d.a(a.this.f11155f);
        }
    }

    public a(i iVar, long j6, long j7, long j8, long j9, boolean z5) {
        com.google.android.exoplayer2.util.a.a(j6 >= 0 && j7 > j6);
        this.f11153d = iVar;
        this.f11151b = j6;
        this.f11152c = j7;
        if (j8 == j7 - j6 || z5) {
            this.f11155f = j9;
            this.f11154e = 4;
        } else {
            this.f11154e = 0;
        }
        this.f11150a = new f();
    }

    private long i(c1.j jVar) {
        if (this.f11158i == this.f11159j) {
            return -1L;
        }
        long p5 = jVar.p();
        if (!this.f11150a.e(jVar, this.f11159j)) {
            long j6 = this.f11158i;
            if (j6 != p5) {
                return j6;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f11150a.b(jVar, false);
        jVar.g();
        long j7 = this.f11157h;
        f fVar = this.f11150a;
        long j8 = fVar.f11180c;
        long j9 = j7 - j8;
        int i6 = fVar.f11185h + fVar.f11186i;
        if (0 > j9 || j9 >= 72000) {
            int i7 = (j9 > 0L ? 1 : (j9 == 0L ? 0 : -1));
            if (i7 < 0) {
                this.f11159j = p5;
                this.f11161l = j8;
            } else {
                this.f11158i = jVar.p() + i6;
                this.f11160k = this.f11150a.f11180c;
            }
            long j10 = this.f11159j;
            long j11 = this.f11158i;
            if (j10 - j11 < 100000) {
                this.f11159j = j11;
                return j11;
            }
            long j12 = i6 * (i7 <= 0 ? 2L : 1L);
            long j13 = this.f11159j;
            long j14 = this.f11158i;
            return s0.s((jVar.p() - j12) + ((j9 * (j13 - j14)) / (this.f11161l - this.f11160k)), j14, j13 - 1);
        }
        return -1L;
    }

    private void k(c1.j jVar) {
        while (true) {
            this.f11150a.d(jVar);
            this.f11150a.b(jVar, false);
            f fVar = this.f11150a;
            if (fVar.f11180c > this.f11157h) {
                jVar.g();
                return;
            }
            jVar.h(fVar.f11185h + fVar.f11186i);
            this.f11158i = jVar.p();
            this.f11160k = this.f11150a.f11180c;
        }
    }

    @Override // j1.g
    public long b(c1.j jVar) {
        int i6 = this.f11154e;
        if (i6 == 0) {
            long p5 = jVar.p();
            this.f11156g = p5;
            this.f11154e = 1;
            long j6 = this.f11152c - 65307;
            if (j6 > p5) {
                return j6;
            }
        } else if (i6 != 1) {
            if (i6 == 2) {
                long i7 = i(jVar);
                if (i7 != -1) {
                    return i7;
                }
                this.f11154e = 3;
            } else if (i6 != 3) {
                if (i6 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(jVar);
            this.f11154e = 4;
            return -(this.f11160k + 2);
        }
        this.f11155f = j(jVar);
        this.f11154e = 4;
        return this.f11156g;
    }

    @Override // j1.g
    public void c(long j6) {
        this.f11157h = s0.s(j6, 0L, this.f11155f - 1);
        this.f11154e = 2;
        this.f11158i = this.f11151b;
        this.f11159j = this.f11152c;
        this.f11160k = 0L;
        this.f11161l = this.f11155f;
    }

    @Override // j1.g
    /* renamed from: h */
    public b a() {
        if (this.f11155f != 0) {
            return new b();
        }
        return null;
    }

    long j(c1.j jVar) {
        this.f11150a.c();
        if (this.f11150a.d(jVar)) {
            do {
                this.f11150a.b(jVar, false);
                f fVar = this.f11150a;
                jVar.h(fVar.f11185h + fVar.f11186i);
                f fVar2 = this.f11150a;
                if ((fVar2.f11179b & 4) == 4 || !fVar2.d(jVar)) {
                    break;
                }
            } while (jVar.p() < this.f11152c);
            return this.f11150a.f11180c;
        }
        throw new EOFException();
    }
}
