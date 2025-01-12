package e2;

import com.google.android.exoplayer2.decoder.k;
import java.nio.ByteBuffer;
import okio.Segment;
/* loaded from: classes.dex */
public abstract class d extends com.google.android.exoplayer2.decoder.l implements g {

    /* renamed from: n  reason: collision with root package name */
    private final String f9467n;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str) {
        super(new j[2], new k[2]);
        this.f9467n = str;
        v(Segment.SHARE_MINIMUM);
    }

    protected abstract f A(byte[] bArr, int i6, boolean z5);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.l
    /* renamed from: B */
    public final h k(j jVar, k kVar, boolean z5) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(jVar.f3600b);
            kVar.e(jVar.f3602d, A(byteBuffer.array(), byteBuffer.limit(), z5), jVar.f9470h);
            kVar.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (h e6) {
            return e6;
        }
    }

    @Override // e2.g
    public void b(long j6) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.l
    /* renamed from: x */
    public final j h() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.l
    /* renamed from: y */
    public final k i() {
        return new e(new k.a() { // from class: e2.c
            @Override // com.google.android.exoplayer2.decoder.k.a
            public final void a(com.google.android.exoplayer2.decoder.k kVar) {
                d.this.s((k) kVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.l
    /* renamed from: z */
    public final h j(Throwable th) {
        return new h("Unexpected decode error", th);
    }
}
