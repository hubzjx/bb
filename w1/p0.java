package w1;

import c1.a0;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import w1.q0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    private final q2.b f13964a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13965b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f13966c;

    /* renamed from: d  reason: collision with root package name */
    private a f13967d;

    /* renamed from: e  reason: collision with root package name */
    private a f13968e;

    /* renamed from: f  reason: collision with root package name */
    private a f13969f;

    /* renamed from: g  reason: collision with root package name */
    private long f13970g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f13971a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13972b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f13973c;

        /* renamed from: d  reason: collision with root package name */
        public q2.a f13974d;

        /* renamed from: e  reason: collision with root package name */
        public a f13975e;

        public a(long j6, int i6) {
            this.f13971a = j6;
            this.f13972b = j6 + i6;
        }

        public a a() {
            this.f13974d = null;
            a aVar = this.f13975e;
            this.f13975e = null;
            return aVar;
        }

        public void b(q2.a aVar, a aVar2) {
            this.f13974d = aVar;
            this.f13975e = aVar2;
            this.f13973c = true;
        }

        public int c(long j6) {
            return ((int) (j6 - this.f13971a)) + this.f13974d.f12709b;
        }
    }

    public p0(q2.b bVar) {
        this.f13964a = bVar;
        int e6 = bVar.e();
        this.f13965b = e6;
        this.f13966c = new com.google.android.exoplayer2.util.y(32);
        a aVar = new a(0L, e6);
        this.f13967d = aVar;
        this.f13968e = aVar;
        this.f13969f = aVar;
    }

    private void a(long j6) {
        while (true) {
            a aVar = this.f13968e;
            if (j6 < aVar.f13972b) {
                return;
            }
            this.f13968e = aVar.f13975e;
        }
    }

    private void b(a aVar) {
        if (aVar.f13973c) {
            a aVar2 = this.f13969f;
            int i6 = (aVar2.f13973c ? 1 : 0) + (((int) (aVar2.f13971a - aVar.f13971a)) / this.f13965b);
            q2.a[] aVarArr = new q2.a[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                aVarArr[i7] = aVar.f13974d;
                aVar = aVar.a();
            }
            this.f13964a.b(aVarArr);
        }
    }

    private void f(int i6) {
        long j6 = this.f13970g + i6;
        this.f13970g = j6;
        a aVar = this.f13969f;
        if (j6 == aVar.f13972b) {
            this.f13969f = aVar.f13975e;
        }
    }

    private int g(int i6) {
        a aVar = this.f13969f;
        if (!aVar.f13973c) {
            aVar.b(this.f13964a.d(), new a(this.f13969f.f13972b, this.f13965b));
        }
        return Math.min(i6, (int) (this.f13969f.f13972b - this.f13970g));
    }

    private void h(long j6, ByteBuffer byteBuffer, int i6) {
        a(j6);
        while (i6 > 0) {
            int min = Math.min(i6, (int) (this.f13968e.f13972b - j6));
            a aVar = this.f13968e;
            byteBuffer.put(aVar.f13974d.f12708a, aVar.c(j6), min);
            i6 -= min;
            j6 += min;
            a aVar2 = this.f13968e;
            if (j6 == aVar2.f13972b) {
                this.f13968e = aVar2.f13975e;
            }
        }
    }

    private void i(long j6, byte[] bArr, int i6) {
        a(j6);
        int i7 = i6;
        while (i7 > 0) {
            int min = Math.min(i7, (int) (this.f13968e.f13972b - j6));
            a aVar = this.f13968e;
            System.arraycopy(aVar.f13974d.f12708a, aVar.c(j6), bArr, i6 - i7, min);
            i7 -= min;
            j6 += min;
            a aVar2 = this.f13968e;
            if (j6 == aVar2.f13972b) {
                this.f13968e = aVar2.f13975e;
            }
        }
    }

    private void j(com.google.android.exoplayer2.decoder.j jVar, q0.a aVar) {
        int i6;
        long j6 = aVar.f14012b;
        this.f13966c.I(1);
        i(j6, this.f13966c.c(), 1);
        long j7 = j6 + 1;
        byte b6 = this.f13966c.c()[0];
        boolean z5 = (b6 & 128) != 0;
        int i7 = b6 & Byte.MAX_VALUE;
        com.google.android.exoplayer2.decoder.b bVar = jVar.f3599a;
        byte[] bArr = bVar.f3576a;
        if (bArr == null) {
            bVar.f3576a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        i(j7, bVar.f3576a, i7);
        long j8 = j7 + i7;
        if (z5) {
            this.f13966c.I(2);
            i(j8, this.f13966c.c(), 2);
            j8 += 2;
            i6 = this.f13966c.G();
        } else {
            i6 = 1;
        }
        int[] iArr = bVar.f3579d;
        if (iArr == null || iArr.length < i6) {
            iArr = new int[i6];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar.f3580e;
        if (iArr3 == null || iArr3.length < i6) {
            iArr3 = new int[i6];
        }
        int[] iArr4 = iArr3;
        if (z5) {
            int i8 = i6 * 6;
            this.f13966c.I(i8);
            i(j8, this.f13966c.c(), i8);
            j8 += i8;
            this.f13966c.M(0);
            for (int i9 = 0; i9 < i6; i9++) {
                iArr2[i9] = this.f13966c.G();
                iArr4[i9] = this.f13966c.E();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.f14011a - ((int) (j8 - aVar.f14012b));
        }
        a0.a aVar2 = (a0.a) com.google.android.exoplayer2.util.s0.j(aVar.f14013c);
        bVar.c(i6, iArr2, iArr4, aVar2.f3157b, bVar.f3576a, aVar2.f3156a, aVar2.f3158c, aVar2.f3159d);
        long j9 = aVar.f14012b;
        int i10 = (int) (j8 - j9);
        aVar.f14012b = j9 + i10;
        aVar.f14011a -= i10;
    }

    public void c(long j6) {
        a aVar;
        if (j6 == -1) {
            return;
        }
        while (true) {
            aVar = this.f13967d;
            if (j6 < aVar.f13972b) {
                break;
            }
            this.f13964a.a(aVar.f13974d);
            this.f13967d = this.f13967d.a();
        }
        if (this.f13968e.f13971a < aVar.f13971a) {
            this.f13968e = aVar;
        }
    }

    public void d(long j6) {
        this.f13970g = j6;
        if (j6 != 0) {
            a aVar = this.f13967d;
            if (j6 != aVar.f13971a) {
                while (this.f13970g > aVar.f13972b) {
                    aVar = aVar.f13975e;
                }
                a aVar2 = aVar.f13975e;
                b(aVar2);
                a aVar3 = new a(aVar.f13972b, this.f13965b);
                aVar.f13975e = aVar3;
                if (this.f13970g == aVar.f13972b) {
                    aVar = aVar3;
                }
                this.f13969f = aVar;
                if (this.f13968e == aVar2) {
                    this.f13968e = aVar3;
                    return;
                }
                return;
            }
        }
        b(this.f13967d);
        a aVar4 = new a(this.f13970g, this.f13965b);
        this.f13967d = aVar4;
        this.f13968e = aVar4;
        this.f13969f = aVar4;
    }

    public long e() {
        return this.f13970g;
    }

    public void k(com.google.android.exoplayer2.decoder.j jVar, q0.a aVar) {
        long j6;
        ByteBuffer byteBuffer;
        if (jVar.h()) {
            j(jVar, aVar);
        }
        if (jVar.hasSupplementalData()) {
            this.f13966c.I(4);
            i(aVar.f14012b, this.f13966c.c(), 4);
            int E = this.f13966c.E();
            aVar.f14012b += 4;
            aVar.f14011a -= 4;
            jVar.f(E);
            h(aVar.f14012b, jVar.f3600b, E);
            aVar.f14012b += E;
            int i6 = aVar.f14011a - E;
            aVar.f14011a = i6;
            jVar.k(i6);
            j6 = aVar.f14012b;
            byteBuffer = jVar.f3603e;
        } else {
            jVar.f(aVar.f14011a);
            j6 = aVar.f14012b;
            byteBuffer = jVar.f3600b;
        }
        h(j6, byteBuffer, aVar.f14011a);
    }

    public void l() {
        b(this.f13967d);
        a aVar = new a(0L, this.f13965b);
        this.f13967d = aVar;
        this.f13968e = aVar;
        this.f13969f = aVar;
        this.f13970g = 0L;
        this.f13964a.c();
    }

    public void m() {
        this.f13968e = this.f13967d;
    }

    public int n(q2.h hVar, int i6, boolean z5) {
        int g6 = g(i6);
        a aVar = this.f13969f;
        int read = hVar.read(aVar.f13974d.f12708a, aVar.c(this.f13970g), g6);
        if (read != -1) {
            f(read);
            return read;
        } else if (z5) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void o(com.google.android.exoplayer2.util.y yVar, int i6) {
        while (i6 > 0) {
            int g6 = g(i6);
            a aVar = this.f13969f;
            yVar.i(aVar.f13974d.f12708a, aVar.c(this.f13970g), g6);
            i6 -= g6;
            f(g6);
        }
    }
}
