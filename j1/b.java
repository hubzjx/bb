package j1;

import c1.p;
import c1.q;
import c1.r;
import c1.s;
import c1.x;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import j1.i;
import java.util.Arrays;
/* loaded from: classes.dex */
final class b extends i {

    /* renamed from: n  reason: collision with root package name */
    private s f11163n;

    /* renamed from: o  reason: collision with root package name */
    private a f11164o;

    /* loaded from: classes.dex */
    private static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        private s f11165a;

        /* renamed from: b  reason: collision with root package name */
        private s.a f11166b;

        /* renamed from: c  reason: collision with root package name */
        private long f11167c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f11168d = -1;

        public a(s sVar, s.a aVar) {
            this.f11165a = sVar;
            this.f11166b = aVar;
        }

        @Override // j1.g
        public x a() {
            com.google.android.exoplayer2.util.a.g(this.f11167c != -1);
            return new r(this.f11165a, this.f11167c);
        }

        @Override // j1.g
        public long b(c1.j jVar) {
            long j6 = this.f11168d;
            if (j6 >= 0) {
                long j7 = -(j6 + 2);
                this.f11168d = -1L;
                return j7;
            }
            return -1L;
        }

        @Override // j1.g
        public void c(long j6) {
            long[] jArr = this.f11166b.f3237a;
            this.f11168d = jArr[s0.i(jArr, j6, true, true)];
        }

        public void d(long j6) {
            this.f11167c = j6;
        }
    }

    private int l(y yVar) {
        int i6 = (yVar.c()[2] & 255) >> 4;
        if (i6 == 6 || i6 == 7) {
            yVar.N(4);
            yVar.H();
        }
        int j6 = p.j(yVar, i6);
        yVar.M(0);
        return j6;
    }

    private static boolean m(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean n(y yVar) {
        return yVar.a() >= 5 && yVar.A() == 127 && yVar.C() == 1179402563;
    }

    @Override // j1.i
    protected long e(y yVar) {
        if (m(yVar.c())) {
            return l(yVar);
        }
        return -1L;
    }

    @Override // j1.i
    protected boolean h(y yVar, long j6, i.b bVar) {
        byte[] c6 = yVar.c();
        s sVar = this.f11163n;
        if (sVar == null) {
            s sVar2 = new s(c6, 17);
            this.f11163n = sVar2;
            bVar.f11204a = sVar2.h(Arrays.copyOfRange(c6, 9, yVar.e()), null);
            return true;
        } else if ((c6[0] & Byte.MAX_VALUE) == 3) {
            s.a h6 = q.h(yVar);
            s c7 = sVar.c(h6);
            this.f11163n = c7;
            this.f11164o = new a(c7, h6);
            return true;
        } else if (m(c6)) {
            a aVar = this.f11164o;
            if (aVar != null) {
                aVar.d(j6);
                bVar.f11205b = this.f11164o;
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j1.i
    public void j(boolean z5) {
        super.j(z5);
        if (z5) {
            this.f11163n = null;
            this.f11164o = null;
        }
    }
}
