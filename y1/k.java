package y1;

import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import okhttp3.internal.http2.Http2;
/* loaded from: classes.dex */
public abstract class k extends e {

    /* renamed from: j  reason: collision with root package name */
    private byte[] f14325j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f14326k;

    public k(q2.l lVar, q2.o oVar, int i6, s0 s0Var, int i7, Object obj, byte[] bArr) {
        super(lVar, oVar, i6, s0Var, i7, obj, -9223372036854775807L, -9223372036854775807L);
        k kVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = com.google.android.exoplayer2.util.s0.f4678f;
            kVar = this;
        } else {
            kVar = this;
            bArr2 = bArr;
        }
        kVar.f14325j = bArr2;
    }

    private void i(int i6) {
        byte[] bArr = this.f14325j;
        if (bArr.length < i6 + Http2.INITIAL_MAX_FRAME_SIZE) {
            this.f14325j = Arrays.copyOf(bArr, bArr.length + Http2.INITIAL_MAX_FRAME_SIZE);
        }
    }

    @Override // q2.d0.e
    public final void a() {
        try {
            this.f14288i.b(this.f14281b);
            int i6 = 0;
            int i7 = 0;
            while (i6 != -1 && !this.f14326k) {
                i(i7);
                i6 = this.f14288i.read(this.f14325j, i7, Http2.INITIAL_MAX_FRAME_SIZE);
                if (i6 != -1) {
                    i7 += i6;
                }
            }
            if (!this.f14326k) {
                g(this.f14325j, i7);
            }
        } finally {
            com.google.android.exoplayer2.util.s0.o(this.f14288i);
        }
    }

    @Override // q2.d0.e
    public final void c() {
        this.f14326k = true;
    }

    protected abstract void g(byte[] bArr, int i6);

    public byte[] h() {
        return this.f14325j;
    }
}
