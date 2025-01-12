package e2;

import java.util.List;
/* loaded from: classes.dex */
public abstract class k extends com.google.android.exoplayer2.decoder.k implements f {

    /* renamed from: a  reason: collision with root package name */
    private f f9471a;

    /* renamed from: b  reason: collision with root package name */
    private long f9472b;

    @Override // e2.f
    public int a(long j6) {
        return ((f) com.google.android.exoplayer2.util.a.e(this.f9471a)).a(j6 - this.f9472b);
    }

    @Override // e2.f
    public long b(int i6) {
        return ((f) com.google.android.exoplayer2.util.a.e(this.f9471a)).b(i6) + this.f9472b;
    }

    @Override // e2.f
    public List c(long j6) {
        return ((f) com.google.android.exoplayer2.util.a.e(this.f9471a)).c(j6 - this.f9472b);
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public void clear() {
        super.clear();
        this.f9471a = null;
    }

    @Override // e2.f
    public int d() {
        return ((f) com.google.android.exoplayer2.util.a.e(this.f9471a)).d();
    }

    public void e(long j6, f fVar, long j7) {
        this.timeUs = j6;
        this.f9471a = fVar;
        if (j7 != Long.MAX_VALUE) {
            j6 = j7;
        }
        this.f9472b = j6;
    }
}
