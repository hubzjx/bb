package c1;
/* loaded from: classes.dex */
public abstract class c {
    public static void a(long j6, com.google.android.exoplayer2.util.y yVar, a0[] a0VarArr) {
        while (true) {
            if (yVar.a() <= 1) {
                return;
            }
            int c6 = c(yVar);
            int c7 = c(yVar);
            int d6 = yVar.d() + c7;
            if (c7 == -1 || c7 > yVar.a()) {
                com.google.android.exoplayer2.util.n.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                d6 = yVar.e();
            } else if (c6 == 4 && c7 >= 8) {
                int A = yVar.A();
                int G = yVar.G();
                int k6 = G == 49 ? yVar.k() : 0;
                int A2 = yVar.A();
                if (G == 47) {
                    yVar.N(1);
                }
                boolean z5 = A == 181 && (G == 49 || G == 47) && A2 == 3;
                if (G == 49) {
                    z5 &= k6 == 1195456820;
                }
                if (z5) {
                    b(j6, yVar, a0VarArr);
                }
            }
            yVar.M(d6);
        }
    }

    public static void b(long j6, com.google.android.exoplayer2.util.y yVar, a0[] a0VarArr) {
        int A = yVar.A();
        if ((A & 64) != 0) {
            yVar.N(1);
            int i6 = (A & 31) * 3;
            int d6 = yVar.d();
            for (a0 a0Var : a0VarArr) {
                yVar.M(d6);
                a0Var.a(yVar, i6);
                a0Var.d(j6, 1, i6, 0, null);
            }
        }
    }

    private static int c(com.google.android.exoplayer2.util.y yVar) {
        int i6 = 0;
        while (yVar.a() != 0) {
            int A = yVar.A();
            i6 += A;
            if (A != 255) {
                return i6;
            }
        }
        return -1;
    }
}
