package j1;

import com.google.android.exoplayer2.audio.d1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import j1.i;
import java.util.Arrays;
import okio.Utf8;
/* loaded from: classes.dex */
final class h extends i {

    /* renamed from: o  reason: collision with root package name */
    private static final byte[] f11189o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: n  reason: collision with root package name */
    private boolean f11190n;

    private long l(byte[] bArr) {
        int i6;
        int i7 = bArr[0] & 255;
        int i8 = i7 & 3;
        if (i8 != 0) {
            i6 = 2;
            if (i8 != 1 && i8 != 2) {
                i6 = bArr[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i6 = 1;
        }
        int i9 = i7 >> 3;
        int i10 = i9 & 3;
        return i6 * (i9 >= 16 ? 2500 << i10 : i9 >= 12 ? 10000 << (i10 & 1) : i10 == 3 ? 60000 : 10000 << i10);
    }

    public static boolean m(y yVar) {
        int a6 = yVar.a();
        byte[] bArr = f11189o;
        if (a6 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        yVar.i(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // j1.i
    protected long e(y yVar) {
        return b(l(yVar.c()));
    }

    @Override // j1.i
    protected boolean h(y yVar, long j6, i.b bVar) {
        if (this.f11190n) {
            boolean z5 = yVar.k() == 1332770163;
            yVar.M(0);
            return z5;
        }
        byte[] copyOf = Arrays.copyOf(yVar.c(), yVar.e());
        bVar.f11204a = new s0.b().e0("audio/opus").H(d1.c(copyOf)).f0(48000).T(d1.a(copyOf)).E();
        this.f11190n = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j1.i
    public void j(boolean z5) {
        super.j(z5);
        if (z5) {
            this.f11190n = false;
        }
    }
}
