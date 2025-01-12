package s2;

import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List f13167a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13168b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13169c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13170d;

    /* renamed from: e  reason: collision with root package name */
    public final float f13171e;

    private a(List list, int i6, int i7, int i8, float f6) {
        this.f13167a = list;
        this.f13168b = i6;
        this.f13169c = i7;
        this.f13170d = i8;
        this.f13171e = f6;
    }

    private static byte[] a(y yVar) {
        int G = yVar.G();
        int d6 = yVar.d();
        yVar.N(G);
        return com.google.android.exoplayer2.util.d.c(yVar.c(), d6, G);
    }

    public static a b(y yVar) {
        int i6;
        int i7;
        float f6;
        try {
            yVar.N(4);
            int A = (yVar.A() & 3) + 1;
            if (A != 3) {
                ArrayList arrayList = new ArrayList();
                int A2 = yVar.A() & 31;
                for (int i8 = 0; i8 < A2; i8++) {
                    arrayList.add(a(yVar));
                }
                int A3 = yVar.A();
                for (int i9 = 0; i9 < A3; i9++) {
                    arrayList.add(a(yVar));
                }
                if (A2 > 0) {
                    r.b i10 = com.google.android.exoplayer2.util.r.i((byte[]) arrayList.get(0), A, ((byte[]) arrayList.get(0)).length);
                    int i11 = i10.f4663e;
                    int i12 = i10.f4664f;
                    f6 = i10.f4665g;
                    i6 = i11;
                    i7 = i12;
                } else {
                    i6 = -1;
                    i7 = -1;
                    f6 = 1.0f;
                }
                return new a(arrayList, A, i6, i7, f6);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e6) {
            throw new f1("Error parsing AVC config", e6);
        }
    }
}
