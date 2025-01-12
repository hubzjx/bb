package q2;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
public final class g0 implements l {

    /* renamed from: a  reason: collision with root package name */
    private final l f12766a;

    /* renamed from: b  reason: collision with root package name */
    private long f12767b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f12768c = Uri.EMPTY;

    /* renamed from: d  reason: collision with root package name */
    private Map f12769d = Collections.emptyMap();

    public g0(l lVar) {
        this.f12766a = (l) com.google.android.exoplayer2.util.a.e(lVar);
    }

    @Override // q2.l
    public long b(o oVar) {
        this.f12768c = oVar.f12794a;
        this.f12769d = Collections.emptyMap();
        long b6 = this.f12766a.b(oVar);
        this.f12768c = (Uri) com.google.android.exoplayer2.util.a.e(k());
        this.f12769d = f();
        return b6;
    }

    @Override // q2.l
    public void close() {
        this.f12766a.close();
    }

    @Override // q2.l
    public Map f() {
        return this.f12766a.f();
    }

    @Override // q2.l
    public void i(i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        this.f12766a.i(i0Var);
    }

    @Override // q2.l
    public Uri k() {
        return this.f12766a.k();
    }

    public long q() {
        return this.f12767b;
    }

    public Uri r() {
        return this.f12768c;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        int read = this.f12766a.read(bArr, i6, i7);
        if (read != -1) {
            this.f12767b += read;
        }
        return read;
    }

    public Map s() {
        return this.f12769d;
    }

    public void t() {
        this.f12767b = 0L;
    }
}
