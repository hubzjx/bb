package j1;

import c1.c0;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import j1.i;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
final class j extends i {

    /* renamed from: n  reason: collision with root package name */
    private a f11206n;

    /* renamed from: o  reason: collision with root package name */
    private int f11207o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11208p;

    /* renamed from: q  reason: collision with root package name */
    private c0.d f11209q;

    /* renamed from: r  reason: collision with root package name */
    private c0.b f11210r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final c0.d f11211a;

        /* renamed from: b  reason: collision with root package name */
        public final c0.b f11212b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11213c;

        /* renamed from: d  reason: collision with root package name */
        public final c0.c[] f11214d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11215e;

        public a(c0.d dVar, c0.b bVar, byte[] bArr, c0.c[] cVarArr, int i6) {
            this.f11211a = dVar;
            this.f11212b = bVar;
            this.f11213c = bArr;
            this.f11214d = cVarArr;
            this.f11215e = i6;
        }
    }

    static void l(y yVar, long j6) {
        if (yVar.b() < yVar.e() + 4) {
            yVar.J(Arrays.copyOf(yVar.c(), yVar.e() + 4));
        } else {
            yVar.L(yVar.e() + 4);
        }
        byte[] c6 = yVar.c();
        c6[yVar.e() - 4] = (byte) (j6 & 255);
        c6[yVar.e() - 3] = (byte) ((j6 >>> 8) & 255);
        c6[yVar.e() - 2] = (byte) ((j6 >>> 16) & 255);
        c6[yVar.e() - 1] = (byte) ((j6 >>> 24) & 255);
    }

    private static int m(byte b6, a aVar) {
        return !aVar.f11214d[n(b6, aVar.f11215e, 1)].f3172a ? aVar.f11211a.f3182g : aVar.f11211a.f3183h;
    }

    static int n(byte b6, int i6, int i7) {
        return (b6 >> i7) & (255 >>> (8 - i6));
    }

    public static boolean p(y yVar) {
        try {
            return c0.l(1, yVar, true);
        } catch (f1 unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j1.i
    public void d(long j6) {
        super.d(j6);
        this.f11208p = j6 != 0;
        c0.d dVar = this.f11209q;
        this.f11207o = dVar != null ? dVar.f3182g : 0;
    }

    @Override // j1.i
    protected long e(y yVar) {
        if ((yVar.c()[0] & 1) == 1) {
            return -1L;
        }
        int m5 = m(yVar.c()[0], this.f11206n);
        long j6 = this.f11208p ? (this.f11207o + m5) / 4 : 0;
        l(yVar, j6);
        this.f11208p = true;
        this.f11207o = m5;
        return j6;
    }

    @Override // j1.i
    protected boolean h(y yVar, long j6, i.b bVar) {
        if (this.f11206n != null) {
            return false;
        }
        a o5 = o(yVar);
        this.f11206n = o5;
        if (o5 == null) {
            return true;
        }
        c0.d dVar = o5.f11211a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f3185j);
        arrayList.add(this.f11206n.f11213c);
        bVar.f11204a = new s0.b().e0("audio/vorbis").G(dVar.f3180e).Z(dVar.f3179d).H(dVar.f3177b).f0(dVar.f3178c).T(arrayList).E();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j1.i
    public void j(boolean z5) {
        super.j(z5);
        if (z5) {
            this.f11206n = null;
            this.f11209q = null;
            this.f11210r = null;
        }
        this.f11207o = 0;
        this.f11208p = false;
    }

    a o(y yVar) {
        if (this.f11209q == null) {
            this.f11209q = c0.j(yVar);
            return null;
        } else if (this.f11210r == null) {
            this.f11210r = c0.h(yVar);
            return null;
        } else {
            byte[] bArr = new byte[yVar.e()];
            System.arraycopy(yVar.c(), 0, bArr, 0, yVar.e());
            c0.c[] k6 = c0.k(yVar, this.f11209q.f3177b);
            return new a(this.f11209q, this.f11210r, bArr, k6, c0.a(k6.length - 1));
        }
    }
}
