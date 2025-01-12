package r2;

import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.s0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import q2.j;
import r2.a;
/* loaded from: classes.dex */
public final class b implements q2.j {

    /* renamed from: a  reason: collision with root package name */
    private final r2.a f12928a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12929b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12930c;

    /* renamed from: d  reason: collision with root package name */
    private q2.o f12931d;

    /* renamed from: e  reason: collision with root package name */
    private long f12932e;

    /* renamed from: f  reason: collision with root package name */
    private File f12933f;

    /* renamed from: g  reason: collision with root package name */
    private OutputStream f12934g;

    /* renamed from: h  reason: collision with root package name */
    private long f12935h;

    /* renamed from: i  reason: collision with root package name */
    private long f12936i;

    /* renamed from: j  reason: collision with root package name */
    private b0 f12937j;

    /* loaded from: classes.dex */
    public static final class a extends a.C0210a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    /* renamed from: r2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0211b implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private r2.a f12938a;

        /* renamed from: b  reason: collision with root package name */
        private long f12939b = 5242880;

        /* renamed from: c  reason: collision with root package name */
        private int f12940c = 20480;

        @Override // q2.j.a
        public q2.j a() {
            return new b((r2.a) com.google.android.exoplayer2.util.a.e(this.f12938a), this.f12939b, this.f12940c);
        }

        public C0211b b(int i6) {
            this.f12940c = i6;
            return this;
        }

        public C0211b c(r2.a aVar) {
            this.f12938a = aVar;
            return this;
        }

        public C0211b d(long j6) {
            this.f12939b = j6;
            return this;
        }
    }

    public b(r2.a aVar, long j6, int i6) {
        com.google.android.exoplayer2.util.a.h(j6 > 0 || j6 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i7 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
        if (i7 != 0 && j6 < 2097152) {
            com.google.android.exoplayer2.util.n.h("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f12928a = (r2.a) com.google.android.exoplayer2.util.a.e(aVar);
        this.f12929b = i7 == 0 ? Long.MAX_VALUE : j6;
        this.f12930c = i6;
    }

    private void a() {
        OutputStream outputStream = this.f12934g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            s0.n(this.f12934g);
            this.f12934g = null;
            this.f12933f = null;
            this.f12928a.b((File) s0.j(this.f12933f), this.f12935h);
        } catch (Throwable th) {
            s0.n(this.f12934g);
            this.f12934g = null;
            this.f12933f = null;
            ((File) s0.j(this.f12933f)).delete();
            throw th;
        }
    }

    private void c(q2.o oVar) {
        long j6 = oVar.f12801h;
        this.f12933f = this.f12928a.a((String) s0.j(oVar.f12802i), oVar.f12800g + this.f12936i, j6 != -1 ? Math.min(j6 - this.f12936i, this.f12932e) : -1L);
        OutputStream fileOutputStream = new FileOutputStream(this.f12933f);
        if (this.f12930c > 0) {
            b0 b0Var = this.f12937j;
            if (b0Var == null) {
                this.f12937j = new b0(fileOutputStream, this.f12930c);
            } else {
                b0Var.a(fileOutputStream);
            }
            fileOutputStream = this.f12937j;
        }
        this.f12934g = fileOutputStream;
        this.f12935h = 0L;
    }

    @Override // q2.j
    public void b(q2.o oVar) {
        com.google.android.exoplayer2.util.a.e(oVar.f12802i);
        if (oVar.f12801h == -1 && oVar.d(2)) {
            this.f12931d = null;
            return;
        }
        this.f12931d = oVar;
        this.f12932e = oVar.d(4) ? this.f12929b : Long.MAX_VALUE;
        this.f12936i = 0L;
        try {
            c(oVar);
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // q2.j
    public void close() {
        if (this.f12931d == null) {
            return;
        }
        try {
            a();
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // q2.j
    public void write(byte[] bArr, int i6, int i7) {
        q2.o oVar = this.f12931d;
        if (oVar == null) {
            return;
        }
        int i8 = 0;
        while (i8 < i7) {
            try {
                if (this.f12935h == this.f12932e) {
                    a();
                    c(oVar);
                }
                int min = (int) Math.min(i7 - i8, this.f12932e - this.f12935h);
                ((OutputStream) s0.j(this.f12934g)).write(bArr, i6 + i8, min);
                i8 += min;
                long j6 = min;
                this.f12935h += j6;
                this.f12936i += j6;
            } catch (IOException e6) {
                throw new a(e6);
            }
        }
    }
}
