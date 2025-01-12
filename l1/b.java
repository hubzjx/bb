package l1;

import android.net.Uri;
import c1.x;
import java.util.Map;
import l1.i0;
/* loaded from: classes.dex */
public final class b implements c1.i {

    /* renamed from: d  reason: collision with root package name */
    public static final c1.o f11438d = new c1.o() { // from class: l1.a
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] e6;
            e6 = b.e();
            return e6;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final c f11439a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11440b = new com.google.android.exoplayer2.util.y(2786);

    /* renamed from: c  reason: collision with root package name */
    private boolean f11441c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] e() {
        return new c1.i[]{new b()};
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f11439a.f(kVar, new i0.d(0, 1));
        kVar.g();
        kVar.r(new x.b(-9223372036854775807L));
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f11441c = false;
        this.f11439a.a();
    }

    @Override // c1.i
    public int g(c1.j jVar, c1.w wVar) {
        int read = jVar.read(this.f11440b.c(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f11440b.M(0);
        this.f11440b.L(read);
        if (!this.f11441c) {
            this.f11439a.e(0L, 4);
            this.f11441c = true;
        }
        this.f11439a.c(this.f11440b);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        if ((r4 - r3) < 8192) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        r8.g();
        r4 = r4 + 1;
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
                jVar.n(yVar.c(), 0, 6);
                yVar.M(0);
                if (yVar.G() != 2935) {
                    break;
                }
                i8++;
                if (i8 >= 4) {
                    return true;
                }
                int f6 = com.google.android.exoplayer2.audio.b.f(yVar.c());
                if (f6 == -1) {
                    return false;
                }
                jVar.o(f6 - 6);
            }
            jVar.o(i7);
        }
    }
}
