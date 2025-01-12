package j1;

import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.y;
import java.io.EOFException;
/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    public int f11178a;

    /* renamed from: b  reason: collision with root package name */
    public int f11179b;

    /* renamed from: c  reason: collision with root package name */
    public long f11180c;

    /* renamed from: d  reason: collision with root package name */
    public long f11181d;

    /* renamed from: e  reason: collision with root package name */
    public long f11182e;

    /* renamed from: f  reason: collision with root package name */
    public long f11183f;

    /* renamed from: g  reason: collision with root package name */
    public int f11184g;

    /* renamed from: h  reason: collision with root package name */
    public int f11185h;

    /* renamed from: i  reason: collision with root package name */
    public int f11186i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f11187j = new int[255];

    /* renamed from: k  reason: collision with root package name */
    private final y f11188k = new y(255);

    private static boolean a(c1.j jVar, byte[] bArr, int i6, int i7, boolean z5) {
        try {
            return jVar.l(bArr, i6, i7, z5);
        } catch (EOFException e6) {
            if (z5) {
                return false;
            }
            throw e6;
        }
    }

    public boolean b(c1.j jVar, boolean z5) {
        c();
        this.f11188k.I(27);
        if (a(jVar, this.f11188k.c(), 0, 27, z5) && this.f11188k.C() == 1332176723) {
            int A = this.f11188k.A();
            this.f11178a = A;
            if (A != 0) {
                if (z5) {
                    return false;
                }
                throw new f1("unsupported bit stream revision");
            }
            this.f11179b = this.f11188k.A();
            this.f11180c = this.f11188k.o();
            this.f11181d = this.f11188k.q();
            this.f11182e = this.f11188k.q();
            this.f11183f = this.f11188k.q();
            int A2 = this.f11188k.A();
            this.f11184g = A2;
            this.f11185h = A2 + 27;
            this.f11188k.I(A2);
            jVar.n(this.f11188k.c(), 0, this.f11184g);
            for (int i6 = 0; i6 < this.f11184g; i6++) {
                this.f11187j[i6] = this.f11188k.A();
                this.f11186i += this.f11187j[i6];
            }
            return true;
        }
        return false;
    }

    public void c() {
        this.f11178a = 0;
        this.f11179b = 0;
        this.f11180c = 0L;
        this.f11181d = 0L;
        this.f11182e = 0L;
        this.f11183f = 0L;
        this.f11184g = 0;
        this.f11185h = 0;
        this.f11186i = 0;
    }

    public boolean d(c1.j jVar) {
        return e(jVar, -1L);
    }

    public boolean e(c1.j jVar, long j6) {
        int i6;
        com.google.android.exoplayer2.util.a.a(jVar.p() == jVar.m());
        while (true) {
            i6 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
            if ((i6 == 0 || jVar.p() + 4 < j6) && a(jVar, this.f11188k.c(), 0, 4, true)) {
                this.f11188k.I(4);
                if (this.f11188k.C() == 1332176723) {
                    jVar.g();
                    return true;
                }
                jVar.h(1);
            }
        }
        do {
            if (i6 != 0 && jVar.p() >= j6) {
                break;
            }
        } while (jVar.c(1) != -1);
        return false;
    }
}
