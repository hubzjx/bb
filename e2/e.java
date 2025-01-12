package e2;

import com.google.android.exoplayer2.decoder.k;
/* loaded from: classes.dex */
final class e extends k {

    /* renamed from: c  reason: collision with root package name */
    private final k.a f9468c;

    public e(k.a aVar) {
        this.f9468c = aVar;
    }

    @Override // com.google.android.exoplayer2.decoder.k
    public final void release() {
        this.f9468c.a(this);
    }
}
