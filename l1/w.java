package l1;

import l1.i0;
/* loaded from: classes.dex */
public final class w implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private final m f11758a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.x f11759b = new com.google.android.exoplayer2.util.x(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f11760c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f11761d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.exoplayer2.util.k0 f11762e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11763f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11764g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11765h;

    /* renamed from: i  reason: collision with root package name */
    private int f11766i;

    /* renamed from: j  reason: collision with root package name */
    private int f11767j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11768k;

    /* renamed from: l  reason: collision with root package name */
    private long f11769l;

    public w(m mVar) {
        this.f11758a = mVar;
    }

    private boolean d(com.google.android.exoplayer2.util.y yVar, byte[] bArr, int i6) {
        int min = Math.min(yVar.a(), i6 - this.f11761d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            yVar.N(min);
        } else {
            yVar.i(bArr, this.f11761d, min);
        }
        int i7 = this.f11761d + min;
        this.f11761d = i7;
        return i7 == i6;
    }

    private boolean e() {
        this.f11759b.p(0);
        int h6 = this.f11759b.h(24);
        if (h6 != 1) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Unexpected start code prefix: ");
            sb.append(h6);
            com.google.android.exoplayer2.util.n.h("PesReader", sb.toString());
            this.f11767j = -1;
            return false;
        }
        this.f11759b.r(8);
        int h7 = this.f11759b.h(16);
        this.f11759b.r(5);
        this.f11768k = this.f11759b.g();
        this.f11759b.r(2);
        this.f11763f = this.f11759b.g();
        this.f11764g = this.f11759b.g();
        this.f11759b.r(6);
        int h8 = this.f11759b.h(8);
        this.f11766i = h8;
        if (h7 != 0) {
            int i6 = ((h7 + 6) - 9) - h8;
            this.f11767j = i6;
            if (i6 < 0) {
                StringBuilder sb2 = new StringBuilder(47);
                sb2.append("Found negative packet payload size: ");
                sb2.append(i6);
                com.google.android.exoplayer2.util.n.h("PesReader", sb2.toString());
            }
            return true;
        }
        this.f11767j = -1;
        return true;
    }

    private void f() {
        this.f11759b.p(0);
        this.f11769l = -9223372036854775807L;
        if (this.f11763f) {
            this.f11759b.r(4);
            this.f11759b.r(1);
            this.f11759b.r(1);
            long h6 = (this.f11759b.h(3) << 30) | (this.f11759b.h(15) << 15) | this.f11759b.h(15);
            this.f11759b.r(1);
            if (!this.f11765h && this.f11764g) {
                this.f11759b.r(4);
                this.f11759b.r(1);
                this.f11759b.r(1);
                this.f11759b.r(1);
                this.f11762e.b((this.f11759b.h(3) << 30) | (this.f11759b.h(15) << 15) | this.f11759b.h(15));
                this.f11765h = true;
            }
            this.f11769l = this.f11762e.b(h6);
        }
    }

    private void g(int i6) {
        this.f11760c = i6;
        this.f11761d = 0;
    }

    @Override // l1.i0
    public final void a() {
        this.f11760c = 0;
        this.f11761d = 0;
        this.f11765h = false;
        this.f11758a.a();
    }

    @Override // l1.i0
    public void b(com.google.android.exoplayer2.util.k0 k0Var, c1.k kVar, i0.d dVar) {
        this.f11762e = k0Var;
        this.f11758a.f(kVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x007a -> B:35:0x007c). Please submit an issue!!! */
    @Override // l1.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(com.google.android.exoplayer2.util.y yVar, int i6) {
        com.google.android.exoplayer2.util.a.i(this.f11762e);
        if ((i6 & 1) != 0) {
            int i7 = this.f11760c;
            if (i7 != 0 && i7 != 1) {
                if (i7 == 2) {
                    com.google.android.exoplayer2.util.n.h("PesReader", "Unexpected start indicator reading extended header");
                } else if (i7 != 3) {
                    throw new IllegalStateException();
                } else {
                    int i8 = this.f11767j;
                    if (i8 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i8);
                        sb.append(" more bytes");
                        com.google.android.exoplayer2.util.n.h("PesReader", sb.toString());
                    }
                    this.f11758a.d();
                }
            }
            g(1);
        }
        while (yVar.a() > 0) {
            int i9 = this.f11760c;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 == 2) {
                        if (d(yVar, this.f11759b.f4688a, Math.min(10, this.f11766i)) && d(yVar, null, this.f11766i)) {
                            f();
                            i6 |= this.f11768k ? 4 : 0;
                            this.f11758a.e(this.f11769l, i6);
                            g(3);
                        }
                    } else if (i9 != 3) {
                        throw new IllegalStateException();
                    } else {
                        int a6 = yVar.a();
                        int i10 = this.f11767j;
                        int i11 = i10 != -1 ? a6 - i10 : 0;
                        if (i11 > 0) {
                            a6 -= i11;
                            yVar.L(yVar.d() + a6);
                        }
                        this.f11758a.c(yVar);
                        int i12 = this.f11767j;
                        if (i12 != -1) {
                            int i13 = i12 - a6;
                            this.f11767j = i13;
                            if (i13 == 0) {
                                this.f11758a.d();
                                g(1);
                                while (yVar.a() > 0) {
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else if (d(yVar, this.f11759b.f4688a, 9)) {
                    g(e() ? 2 : 0);
                }
            } else {
                yVar.N(yVar.a());
            }
        }
    }
}
