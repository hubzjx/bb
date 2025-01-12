package q2;

import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public final class h0 implements l {

    /* renamed from: a  reason: collision with root package name */
    private final l f12770a;

    /* renamed from: b  reason: collision with root package name */
    private final j f12771b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12772c;

    /* renamed from: d  reason: collision with root package name */
    private long f12773d;

    public h0(l lVar, j jVar) {
        this.f12770a = (l) com.google.android.exoplayer2.util.a.e(lVar);
        this.f12771b = (j) com.google.android.exoplayer2.util.a.e(jVar);
    }

    @Override // q2.l
    public long b(o oVar) {
        long b6 = this.f12770a.b(oVar);
        this.f12773d = b6;
        if (b6 == 0) {
            return 0L;
        }
        if (oVar.f12801h == -1 && b6 != -1) {
            oVar = oVar.f(0L, b6);
        }
        this.f12772c = true;
        this.f12771b.b(oVar);
        return this.f12773d;
    }

    @Override // q2.l
    public void close() {
        try {
            this.f12770a.close();
        } finally {
            if (this.f12772c) {
                this.f12772c = false;
                this.f12771b.close();
            }
        }
    }

    @Override // q2.l
    public Map f() {
        return this.f12770a.f();
    }

    @Override // q2.l
    public void i(i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        this.f12770a.i(i0Var);
    }

    @Override // q2.l
    public Uri k() {
        return this.f12770a.k();
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (this.f12773d == 0) {
            return -1;
        }
        int read = this.f12770a.read(bArr, i6, i7);
        if (read > 0) {
            this.f12771b.write(bArr, i6, read);
            long j6 = this.f12773d;
            if (j6 != -1) {
                this.f12773d = j6 - read;
            }
        }
        return read;
    }
}
