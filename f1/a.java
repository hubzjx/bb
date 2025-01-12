package f1;

import c1.a0;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import f1.e;
import java.util.Collections;
/* loaded from: classes.dex */
final class a extends e {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f9766e = {5512, 11025, 22050, 44100};

    /* renamed from: b  reason: collision with root package name */
    private boolean f9767b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9768c;

    /* renamed from: d  reason: collision with root package name */
    private int f9769d;

    public a(a0 a0Var) {
        super(a0Var);
    }

    @Override // f1.e
    protected boolean b(y yVar) {
        s0.b f02;
        if (this.f9767b) {
            yVar.N(1);
        } else {
            int A = yVar.A();
            int i6 = (A >> 4) & 15;
            this.f9769d = i6;
            if (i6 == 2) {
                f02 = new s0.b().e0("audio/mpeg").H(1).f0(f9766e[(A >> 2) & 3]);
            } else if (i6 == 7 || i6 == 8) {
                f02 = new s0.b().e0(i6 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").H(1).f0(8000);
            } else {
                if (i6 != 10) {
                    int i7 = this.f9769d;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Audio format not supported: ");
                    sb.append(i7);
                    throw new e.a(sb.toString());
                }
                this.f9767b = true;
            }
            this.f9790a.e(f02.E());
            this.f9768c = true;
            this.f9767b = true;
        }
        return true;
    }

    @Override // f1.e
    protected boolean c(y yVar, long j6) {
        if (this.f9769d == 2) {
            int a6 = yVar.a();
            this.f9790a.a(yVar, a6);
            this.f9790a.d(j6, 1, a6, 0, null);
            return true;
        }
        int A = yVar.A();
        if (A != 0 || this.f9768c) {
            if (this.f9769d != 10 || A == 1) {
                int a7 = yVar.a();
                this.f9790a.a(yVar, a7);
                this.f9790a.d(j6, 1, a7, 0, null);
                return true;
            }
            return false;
        }
        int a8 = yVar.a();
        byte[] bArr = new byte[a8];
        yVar.i(bArr, 0, a8);
        a.b g6 = com.google.android.exoplayer2.audio.a.g(bArr);
        this.f9790a.e(new s0.b().e0("audio/mp4a-latm").I(g6.f3316c).H(g6.f3315b).f0(g6.f3314a).T(Collections.singletonList(bArr)).E());
        this.f9768c = true;
        return false;
    }
}
