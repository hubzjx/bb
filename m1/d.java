package m1;

import android.util.Pair;
import c1.j;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
abstract class d {

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11992a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11993b;

        private a(int i6, long j6) {
            this.f11992a = i6;
            this.f11993b = j6;
        }

        public static a a(j jVar, y yVar) {
            jVar.n(yVar.c(), 0, 8);
            yVar.M(0);
            return new a(yVar.k(), yVar.q());
        }
    }

    public static c a(j jVar) {
        a a6;
        byte[] bArr;
        com.google.android.exoplayer2.util.a.e(jVar);
        y yVar = new y(16);
        if (a.a(jVar, yVar).f11992a != 1380533830) {
            return null;
        }
        jVar.n(yVar.c(), 0, 4);
        yVar.M(0);
        int k6 = yVar.k();
        if (k6 != 1463899717) {
            StringBuilder sb = new StringBuilder(36);
            sb.append("Unsupported RIFF format: ");
            sb.append(k6);
            n.c("WavHeaderReader", sb.toString());
            return null;
        }
        while (true) {
            a6 = a.a(jVar, yVar);
            if (a6.f11992a == 1718449184) {
                break;
            }
            jVar.o((int) a6.f11993b);
        }
        com.google.android.exoplayer2.util.a.g(a6.f11993b >= 16);
        jVar.n(yVar.c(), 0, 16);
        yVar.M(0);
        int s5 = yVar.s();
        int s6 = yVar.s();
        int r5 = yVar.r();
        int r6 = yVar.r();
        int s7 = yVar.s();
        int s8 = yVar.s();
        int i6 = ((int) a6.f11993b) - 16;
        if (i6 > 0) {
            byte[] bArr2 = new byte[i6];
            jVar.n(bArr2, 0, i6);
            bArr = bArr2;
        } else {
            bArr = s0.f4678f;
        }
        return new c(s5, s6, r5, r6, s7, s8, bArr);
    }

    public static Pair b(j jVar) {
        com.google.android.exoplayer2.util.a.e(jVar);
        jVar.g();
        y yVar = new y(8);
        while (true) {
            a a6 = a.a(jVar, yVar);
            int i6 = a6.f11992a;
            if (i6 == 1684108385) {
                jVar.h(8);
                long p5 = jVar.p();
                long j6 = a6.f11993b + p5;
                long a7 = jVar.a();
                if (a7 != -1 && j6 > a7) {
                    StringBuilder sb = new StringBuilder(69);
                    sb.append("Data exceeds input length: ");
                    sb.append(j6);
                    sb.append(", ");
                    sb.append(a7);
                    n.h("WavHeaderReader", sb.toString());
                    j6 = a7;
                }
                return Pair.create(Long.valueOf(p5), Long.valueOf(j6));
            }
            if (i6 != 1380533830 && i6 != 1718449184) {
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("Ignoring unknown WAV chunk: ");
                sb2.append(i6);
                n.h("WavHeaderReader", sb2.toString());
            }
            long j7 = a6.f11993b + 8;
            if (a6.f11992a == 1380533830) {
                j7 = 12;
            }
            if (j7 > 2147483647L) {
                int i7 = a6.f11992a;
                StringBuilder sb3 = new StringBuilder(51);
                sb3.append("Chunk is too large (~2GB+) to skip; id: ");
                sb3.append(i7);
                throw new f1(sb3.toString());
            }
            jVar.h((int) j7);
        }
    }
}
