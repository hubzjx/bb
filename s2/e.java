package s2;

import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.y;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final List f13190a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13191b;

    private e(List list, int i6) {
        this.f13190a = list;
        this.f13191b = i6;
    }

    public static e a(y yVar) {
        try {
            yVar.N(21);
            int A = yVar.A() & 3;
            int A2 = yVar.A();
            int d6 = yVar.d();
            int i6 = 0;
            for (int i7 = 0; i7 < A2; i7++) {
                yVar.N(1);
                int G = yVar.G();
                for (int i8 = 0; i8 < G; i8++) {
                    int G2 = yVar.G();
                    i6 += G2 + 4;
                    yVar.N(G2);
                }
            }
            yVar.M(d6);
            byte[] bArr = new byte[i6];
            int i9 = 0;
            for (int i10 = 0; i10 < A2; i10++) {
                yVar.N(1);
                int G3 = yVar.G();
                for (int i11 = 0; i11 < G3; i11++) {
                    int G4 = yVar.G();
                    byte[] bArr2 = com.google.android.exoplayer2.util.r.f4652a;
                    System.arraycopy(bArr2, 0, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(yVar.c(), yVar.d(), bArr, length, G4);
                    i9 = length + G4;
                    yVar.N(G4);
                }
            }
            return new e(i6 == 0 ? null : Collections.singletonList(bArr), A + 1);
        } catch (ArrayIndexOutOfBoundsException e6) {
            throw new f1("Error parsing HEVC config", e6);
        }
    }
}
