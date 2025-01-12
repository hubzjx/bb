package l1;

import android.net.Uri;
import c1.x;
import java.util.Map;
import l1.i0;
import okhttp3.internal.http2.Http2;
/* loaded from: classes.dex */
public final class e implements c1.i {

    /* renamed from: d  reason: collision with root package name */
    public static final c1.o f11462d = new c1.o() { // from class: l1.d
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] e6;
            e6 = e.e();
            return e6;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final f f11463a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11464b = new com.google.android.exoplayer2.util.y((int) Http2.INITIAL_MAX_FRAME_SIZE);

    /* renamed from: c  reason: collision with root package name */
    private boolean f11465c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] e() {
        return new c1.i[]{new e()};
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f11463a.f(kVar, new i0.d(0, 1));
        kVar.g();
        kVar.r(new x.b(-9223372036854775807L));
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f11465c = false;
        this.f11463a.a();
    }

    @Override // c1.i
    public int g(c1.j jVar, c1.w wVar) {
        int read = jVar.read(this.f11464b.c(), 0, Http2.INITIAL_MAX_FRAME_SIZE);
        if (read == -1) {
            return -1;
        }
        this.f11464b.M(0);
        this.f11464b.L(read);
        if (!this.f11465c) {
            this.f11463a.e(0L, 4);
            this.f11465c = true;
        }
        this.f11463a.c(this.f11464b);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        r9.g();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
        if ((r4 - r3) < 8192) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        return false;
     */
    @Override // c1.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(c1.j jVar) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(10);
        int i6 = 0;
        while (true) {
            jVar.n(yVar.c(), 0, 10);
            yVar.M(0);
            if (yVar.D() != 4801587) {
                break;
            }
            yVar.N(3);
            int z5 = yVar.z();
            i6 += z5 + 10;
            jVar.o(z5);
        }
        jVar.g();
        jVar.o(i6);
        int i7 = i6;
        while (true) {
            int i8 = 0;
            while (true) {
                jVar.n(yVar.c(), 0, 7);
                yVar.M(0);
                int G = yVar.G();
                if (G != 44096 && G != 44097) {
                    break;
                }
                i8++;
                if (i8 >= 4) {
                    return true;
                }
                int e6 = com.google.android.exoplayer2.audio.c.e(yVar.c(), G);
                if (e6 == -1) {
                    return false;
                }
                jVar.o(e6 - 7);
            }
            jVar.o(i7);
        }
    }
}
