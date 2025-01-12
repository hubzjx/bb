package y1;

import c1.a0;
import w1.q0;
import y1.f;
/* loaded from: classes.dex */
public final class c implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f14261a;

    /* renamed from: b  reason: collision with root package name */
    private final q0[] f14262b;

    public c(int[] iArr, q0[] q0VarArr) {
        this.f14261a = iArr;
        this.f14262b = q0VarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f14262b.length];
        int i6 = 0;
        while (true) {
            q0[] q0VarArr = this.f14262b;
            if (i6 >= q0VarArr.length) {
                return iArr;
            }
            iArr[i6] = q0VarArr[i6].D();
            i6++;
        }
    }

    public void b(long j6) {
        for (q0 q0Var : this.f14262b) {
            q0Var.W(j6);
        }
    }

    @Override // y1.f.a
    public a0 e(int i6, int i7) {
        int i8 = 0;
        while (true) {
            int[] iArr = this.f14261a;
            if (i8 >= iArr.length) {
                StringBuilder sb = new StringBuilder(36);
                sb.append("Unmatched track of type: ");
                sb.append(i7);
                com.google.android.exoplayer2.util.n.c("BaseMediaChunkOutput", sb.toString());
                return new c1.h();
            } else if (i7 == iArr[i8]) {
                return this.f14262b[i8];
            } else {
                i8++;
            }
        }
    }
}
