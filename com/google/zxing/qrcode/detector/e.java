package com.google.zxing.qrcode.detector;

import com.google.zxing.k;
import com.google.zxing.p;
import com.google.zxing.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final s3.b f5885a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5887c;

    /* renamed from: b  reason: collision with root package name */
    private final List f5886b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final int[] f5888d = new int[5];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements Serializable, Comparator {
        private final float average;

        private b(float f6) {
            this.average = f6;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            int compare = Integer.compare(dVar2.h(), dVar.h());
            return compare == 0 ? Float.compare(Math.abs(dVar.i() - this.average), Math.abs(dVar2.i() - this.average)) : compare;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements Serializable, Comparator {
        private final float average;

        private c(float f6) {
            this.average = f6;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.i() - this.average), Math.abs(dVar.i() - this.average));
        }
    }

    public e(s3.b bVar, q qVar) {
        this.f5885a = bVar;
    }

    private static float a(int[] iArr, int i6) {
        return ((i6 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean c(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int[] j6 = j();
        int i11 = 0;
        while (i6 >= i11 && i7 >= i11 && this.f5885a.e(i7 - i11, i6 - i11)) {
            j6[2] = j6[2] + 1;
            i11++;
        }
        if (j6[2] == 0) {
            return false;
        }
        while (i6 >= i11 && i7 >= i11 && !this.f5885a.e(i7 - i11, i6 - i11)) {
            j6[1] = j6[1] + 1;
            i11++;
        }
        if (j6[1] == 0) {
            return false;
        }
        while (i6 >= i11 && i7 >= i11 && this.f5885a.e(i7 - i11, i6 - i11)) {
            j6[0] = j6[0] + 1;
            i11++;
        }
        if (j6[0] == 0) {
            return false;
        }
        int g6 = this.f5885a.g();
        int i12 = this.f5885a.i();
        int i13 = 1;
        while (true) {
            int i14 = i6 + i13;
            if (i14 >= g6 || (i10 = i7 + i13) >= i12 || !this.f5885a.e(i10, i14)) {
                break;
            }
            j6[2] = j6[2] + 1;
            i13++;
        }
        while (true) {
            int i15 = i6 + i13;
            if (i15 >= g6 || (i9 = i7 + i13) >= i12 || this.f5885a.e(i9, i15)) {
                break;
            }
            j6[3] = j6[3] + 1;
            i13++;
        }
        if (j6[3] == 0) {
            return false;
        }
        while (true) {
            int i16 = i6 + i13;
            if (i16 >= g6 || (i8 = i7 + i13) >= i12 || !this.f5885a.e(i8, i16)) {
                break;
            }
            j6[4] = j6[4] + 1;
            i13++;
        }
        if (j6[4] == 0) {
            return false;
        }
        return i(j6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
        if (r2[3] < r13) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
        if (r11 >= r1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008c, code lost:
        if (r0.e(r11, r12) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008e, code lost:
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0090, code lost:
        if (r9 >= r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0092, code lost:
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r12 < r13) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b1, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (h(r2) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00be, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float d(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        s3.b bVar = this.f5885a;
        int i12 = bVar.i();
        int[] j6 = j();
        int i13 = i6;
        while (i13 >= 0 && bVar.e(i13, i7)) {
            j6[2] = j6[2] + 1;
            i13--;
        }
        if (i13 < 0) {
            return Float.NaN;
        }
        while (i13 >= 0 && !bVar.e(i13, i7)) {
            int i14 = j6[1];
            if (i14 > i8) {
                break;
            }
            j6[1] = i14 + 1;
            i13--;
        }
        if (i13 >= 0 && j6[1] <= i8) {
            while (i13 >= 0 && bVar.e(i13, i7) && (i11 = j6[0]) <= i8) {
                j6[0] = i11 + 1;
                i13--;
            }
            if (j6[0] > i8) {
                return Float.NaN;
            }
            int i15 = i6 + 1;
            while (i15 < i12 && bVar.e(i15, i7)) {
                j6[2] = j6[2] + 1;
                i15++;
            }
            if (i15 == i12) {
                return Float.NaN;
            }
            while (i15 < i12 && !bVar.e(i15, i7) && (i10 = j6[3]) < i8) {
                j6[3] = i10 + 1;
                i15++;
            }
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
        if (r2[3] < r13) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
        if (r11 >= r1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008c, code lost:
        if (r0.e(r12, r11) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008e, code lost:
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0090, code lost:
        if (r9 >= r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0092, code lost:
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r12 < r13) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b3, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < (r14 * 2)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b5, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
        if (h(r2) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c0, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float e(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        s3.b bVar = this.f5885a;
        int g6 = bVar.g();
        int[] j6 = j();
        int i12 = i6;
        while (i12 >= 0 && bVar.e(i7, i12)) {
            j6[2] = j6[2] + 1;
            i12--;
        }
        if (i12 < 0) {
            return Float.NaN;
        }
        while (i12 >= 0 && !bVar.e(i7, i12)) {
            int i13 = j6[1];
            if (i13 > i8) {
                break;
            }
            j6[1] = i13 + 1;
            i12--;
        }
        if (i12 >= 0 && j6[1] <= i8) {
            while (i12 >= 0 && bVar.e(i7, i12) && (i11 = j6[0]) <= i8) {
                j6[0] = i11 + 1;
                i12--;
            }
            if (j6[0] > i8) {
                return Float.NaN;
            }
            int i14 = i6 + 1;
            while (i14 < g6 && bVar.e(i7, i14)) {
                j6[2] = j6[2] + 1;
                i14++;
            }
            if (i14 == g6) {
                return Float.NaN;
            }
            while (i14 < g6 && !bVar.e(i7, i14) && (i10 = j6[3]) < i8) {
                j6[3] = i10 + 1;
                i14++;
            }
        }
        return Float.NaN;
    }

    private int g() {
        if (this.f5886b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f5886b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f5887c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean h(int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 7) {
            return false;
        }
        float f6 = i6 / 7.0f;
        float f7 = f6 / 2.0f;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs(f6 - ((float) iArr[1])) < f7 && Math.abs((f6 * 3.0f) - ((float) iArr[2])) < 3.0f * f7 && Math.abs(f6 - ((float) iArr[3])) < f7 && Math.abs(f6 - ((float) iArr[4])) < f7;
    }

    protected static boolean i(int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 7) {
            return false;
        }
        float f6 = i6 / 7.0f;
        float f7 = f6 / 1.333f;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs(f6 - ((float) iArr[1])) < f7 && Math.abs((f6 * 3.0f) - ((float) iArr[2])) < 3.0f * f7 && Math.abs(f6 - ((float) iArr[3])) < f7 && Math.abs(f6 - ((float) iArr[4])) < f7;
    }

    private int[] j() {
        b(this.f5888d);
        return this.f5888d;
    }

    private boolean l() {
        int size = this.f5886b.size();
        float f6 = 0.0f;
        int i6 = 0;
        float f7 = 0.0f;
        for (d dVar : this.f5886b) {
            if (dVar.h() >= 2) {
                i6++;
                f7 += dVar.i();
            }
        }
        if (i6 < 3) {
            return false;
        }
        float f8 = f7 / size;
        for (d dVar2 : this.f5886b) {
            f6 += Math.abs(dVar2.i() - f8);
        }
        return f6 <= f7 * 0.05f;
    }

    private d[] m() {
        float f6;
        int size = this.f5886b.size();
        if (size >= 3) {
            float f7 = 0.0f;
            if (size > 3) {
                float f8 = 0.0f;
                float f9 = 0.0f;
                for (d dVar : this.f5886b) {
                    float i6 = dVar.i();
                    f8 += i6;
                    f9 += i6 * i6;
                }
                float f10 = f8 / size;
                float sqrt = (float) Math.sqrt((f9 / f6) - (f10 * f10));
                Collections.sort(this.f5886b, new c(f10));
                float max = Math.max(0.2f * f10, sqrt);
                int i7 = 0;
                while (i7 < this.f5886b.size() && this.f5886b.size() > 3) {
                    if (Math.abs(((d) this.f5886b.get(i7)).i() - f10) > max) {
                        this.f5886b.remove(i7);
                        i7--;
                    }
                    i7++;
                }
            }
            if (this.f5886b.size() > 3) {
                for (d dVar2 : this.f5886b) {
                    f7 += dVar2.i();
                }
                Collections.sort(this.f5886b, new b(f7 / this.f5886b.size()));
                List list = this.f5886b;
                list.subList(3, list.size()).clear();
            }
            return new d[]{(d) this.f5886b.get(0), (d) this.f5886b.get(1), (d) this.f5886b.get(2)};
        }
        throw k.getNotFoundInstance();
    }

    protected final void b(int[] iArr) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f f(Map map) {
        boolean z5 = map != null && map.containsKey(com.google.zxing.e.TRY_HARDER);
        int g6 = this.f5885a.g();
        int i6 = this.f5885a.i();
        int i7 = ((g6 * 3) / 388 < 3 || z5) ? 3 : 3;
        int[] iArr = new int[5];
        int i8 = i7 - 1;
        boolean z6 = false;
        while (i8 < g6 && !z6) {
            b(iArr);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i6) {
                if (this.f5885a.e(i9, i8)) {
                    if ((i10 & 1) == 1) {
                        i10++;
                    }
                    iArr[i10] = iArr[i10] + 1;
                } else if ((i10 & 1) != 0) {
                    iArr[i10] = iArr[i10] + 1;
                } else if (i10 != 4) {
                    i10++;
                    iArr[i10] = iArr[i10] + 1;
                } else if (h(iArr) && k(iArr, i8, i9)) {
                    if (this.f5887c) {
                        z6 = l();
                    } else {
                        int g7 = g();
                        int i11 = iArr[2];
                        if (g7 > i11) {
                            i8 += (g7 - i11) - 2;
                            i9 = i6 - 1;
                        }
                    }
                    b(iArr);
                    i7 = 2;
                    i10 = 0;
                } else {
                    n(iArr);
                    i10 = 3;
                }
                i9++;
            }
            if (h(iArr) && k(iArr, i8, i6)) {
                i7 = iArr[0];
                if (this.f5887c) {
                    z6 = l();
                }
            }
            i8 += i7;
        }
        d[] m5 = m();
        p.e(m5);
        return new f(m5);
    }

    protected final boolean k(int[] iArr, int i6, int i7) {
        boolean z5 = false;
        int i8 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a6 = (int) a(iArr, i7);
        float e6 = e(i6, a6, iArr[2], i8);
        if (!Float.isNaN(e6)) {
            int i9 = (int) e6;
            float d6 = d(a6, i9, iArr[2], i8);
            if (!Float.isNaN(d6) && c(i9, (int) d6)) {
                float f6 = i8 / 7.0f;
                int i10 = 0;
                while (true) {
                    if (i10 >= this.f5886b.size()) {
                        break;
                    }
                    d dVar = (d) this.f5886b.get(i10);
                    if (dVar.f(f6, e6, d6)) {
                        this.f5886b.set(i10, dVar.g(e6, d6, f6));
                        z5 = true;
                        break;
                    }
                    i10++;
                }
                if (!z5) {
                    this.f5886b.add(new d(d6, e6, f6));
                }
                return true;
            }
        }
        return false;
    }

    protected final void n(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
