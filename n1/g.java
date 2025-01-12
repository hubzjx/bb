package n1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.t0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class g extends o implements Handler.Callback {

    /* renamed from: o  reason: collision with root package name */
    private final d f12186o;

    /* renamed from: p  reason: collision with root package name */
    private final f f12187p;

    /* renamed from: q  reason: collision with root package name */
    private final Handler f12188q;

    /* renamed from: r  reason: collision with root package name */
    private final e f12189r;

    /* renamed from: s  reason: collision with root package name */
    private final a[] f12190s;

    /* renamed from: t  reason: collision with root package name */
    private final long[] f12191t;

    /* renamed from: u  reason: collision with root package name */
    private int f12192u;

    /* renamed from: v  reason: collision with root package name */
    private int f12193v;

    /* renamed from: w  reason: collision with root package name */
    private c f12194w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f12195x;

    /* renamed from: y  reason: collision with root package name */
    private long f12196y;

    public g(f fVar, Looper looper) {
        this(fVar, looper, d.f12184a);
    }

    private void P(a aVar, List list) {
        for (int i6 = 0; i6 < aVar.h(); i6++) {
            s0 b6 = aVar.g(i6).b();
            if (b6 == null || !this.f12186o.a(b6)) {
                list.add(aVar.g(i6));
            } else {
                c b7 = this.f12186o.b(b6);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(aVar.g(i6).d());
                this.f12189r.clear();
                this.f12189r.f(bArr.length);
                ((ByteBuffer) com.google.android.exoplayer2.util.s0.j(this.f12189r.f3600b)).put(bArr);
                this.f12189r.g();
                a a6 = b7.a(this.f12189r);
                if (a6 != null) {
                    P(a6, list);
                }
            }
        }
    }

    private void Q() {
        Arrays.fill(this.f12190s, (Object) null);
        this.f12192u = 0;
        this.f12193v = 0;
    }

    private void R(a aVar) {
        Handler handler = this.f12188q;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            S(aVar);
        }
    }

    private void S(a aVar) {
        this.f12187p.O(aVar);
    }

    @Override // com.google.android.exoplayer2.o
    protected void G() {
        Q();
        this.f12194w = null;
    }

    @Override // com.google.android.exoplayer2.o
    protected void I(long j6, boolean z5) {
        Q();
        this.f12195x = false;
    }

    @Override // com.google.android.exoplayer2.o
    protected void M(s0[] s0VarArr, long j6, long j7) {
        this.f12194w = this.f12186o.b(s0VarArr[0]);
    }

    @Override // com.google.android.exoplayer2.p1
    public int a(s0 s0Var) {
        if (this.f12186o.a(s0Var)) {
            return o1.a(s0Var.G == null ? 4 : 2);
        }
        return o1.a(0);
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean d() {
        return this.f12195x;
    }

    @Override // com.google.android.exoplayer2.n1, com.google.android.exoplayer2.p1
    public String f() {
        return "MetadataRenderer";
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean g() {
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            S((a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.n1
    public void o(long j6, long j7) {
        if (!this.f12195x && this.f12193v < 5) {
            this.f12189r.clear();
            t0 C = C();
            int N = N(C, this.f12189r, false);
            if (N == -4) {
                if (this.f12189r.isEndOfStream()) {
                    this.f12195x = true;
                } else {
                    e eVar = this.f12189r;
                    eVar.f12185h = this.f12196y;
                    eVar.g();
                    a a6 = ((c) com.google.android.exoplayer2.util.s0.j(this.f12194w)).a(this.f12189r);
                    if (a6 != null) {
                        ArrayList arrayList = new ArrayList(a6.h());
                        P(a6, arrayList);
                        if (!arrayList.isEmpty()) {
                            a aVar = new a(arrayList);
                            int i6 = this.f12192u;
                            int i7 = this.f12193v;
                            int i8 = (i6 + i7) % 5;
                            this.f12190s[i8] = aVar;
                            this.f12191t[i8] = this.f12189r.f3602d;
                            this.f12193v = i7 + 1;
                        }
                    }
                }
            } else if (N == -5) {
                this.f12196y = ((s0) com.google.android.exoplayer2.util.a.e(C.f4441b)).f4060r;
            }
        }
        if (this.f12193v > 0) {
            long[] jArr = this.f12191t;
            int i9 = this.f12192u;
            if (jArr[i9] <= j6) {
                R((a) com.google.android.exoplayer2.util.s0.j(this.f12190s[i9]));
                a[] aVarArr = this.f12190s;
                int i10 = this.f12192u;
                aVarArr[i10] = null;
                this.f12192u = (i10 + 1) % 5;
                this.f12193v--;
            }
        }
    }

    public g(f fVar, Looper looper, d dVar) {
        super(4);
        this.f12187p = (f) com.google.android.exoplayer2.util.a.e(fVar);
        this.f12188q = looper == null ? null : com.google.android.exoplayer2.util.s0.w(looper, this);
        this.f12186o = (d) com.google.android.exoplayer2.util.a.e(dVar);
        this.f12189r = new e();
        this.f12190s = new a[5];
        this.f12191t = new long[5];
    }
}
