package g1;

import c1.j;
import com.google.android.exoplayer2.f1;
import java.util.ArrayDeque;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f10330a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque f10331b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final g f10332c = new g();

    /* renamed from: d  reason: collision with root package name */
    private g1.b f10333d;

    /* renamed from: e  reason: collision with root package name */
    private int f10334e;

    /* renamed from: f  reason: collision with root package name */
    private int f10335f;

    /* renamed from: g  reason: collision with root package name */
    private long f10336g;

    /* loaded from: classes.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f10337a;

        /* renamed from: b  reason: collision with root package name */
        private final long f10338b;

        private b(int i6, long j6) {
            this.f10337a = i6;
            this.f10338b = j6;
        }
    }

    private long d(j jVar) {
        jVar.g();
        while (true) {
            jVar.n(this.f10330a, 0, 4);
            int c6 = g.c(this.f10330a[0]);
            if (c6 != -1 && c6 <= 4) {
                int a6 = (int) g.a(this.f10330a, c6, false);
                if (this.f10333d.d(a6)) {
                    jVar.h(c6);
                    return a6;
                }
            }
            jVar.h(1);
        }
    }

    private double e(j jVar, int i6) {
        long f6 = f(jVar, i6);
        return i6 == 4 ? Float.intBitsToFloat((int) f6) : Double.longBitsToDouble(f6);
    }

    private long f(j jVar, int i6) {
        jVar.readFully(this.f10330a, 0, i6);
        long j6 = 0;
        for (int i7 = 0; i7 < i6; i7++) {
            j6 = (j6 << 8) | (this.f10330a[i7] & 255);
        }
        return j6;
    }

    private static String g(j jVar, int i6) {
        if (i6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        byte[] bArr = new byte[i6];
        jVar.readFully(bArr, 0, i6);
        while (i6 > 0 && bArr[i6 - 1] == 0) {
            i6--;
        }
        return new String(bArr, 0, i6);
    }

    @Override // g1.c
    public void a(g1.b bVar) {
        this.f10333d = bVar;
    }

    @Override // g1.c
    public boolean b(j jVar) {
        com.google.android.exoplayer2.util.a.i(this.f10333d);
        while (true) {
            b bVar = (b) this.f10331b.peek();
            if (bVar != null && jVar.p() >= bVar.f10338b) {
                this.f10333d.a(((b) this.f10331b.pop()).f10337a);
                return true;
            }
            if (this.f10334e == 0) {
                long d6 = this.f10332c.d(jVar, true, false, 4);
                if (d6 == -2) {
                    d6 = d(jVar);
                }
                if (d6 == -1) {
                    return false;
                }
                this.f10335f = (int) d6;
                this.f10334e = 1;
            }
            if (this.f10334e == 1) {
                this.f10336g = this.f10332c.d(jVar, false, true, 8);
                this.f10334e = 2;
            }
            int b6 = this.f10333d.b(this.f10335f);
            if (b6 != 0) {
                if (b6 == 1) {
                    long p5 = jVar.p();
                    this.f10331b.push(new b(this.f10335f, this.f10336g + p5));
                    this.f10333d.g(this.f10335f, p5, this.f10336g);
                    this.f10334e = 0;
                    return true;
                } else if (b6 == 2) {
                    long j6 = this.f10336g;
                    if (j6 <= 8) {
                        this.f10333d.h(this.f10335f, f(jVar, (int) j6));
                        this.f10334e = 0;
                        return true;
                    }
                    long j7 = this.f10336g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j7);
                    throw new f1(sb.toString());
                } else if (b6 == 3) {
                    long j8 = this.f10336g;
                    if (j8 <= 2147483647L) {
                        this.f10333d.f(this.f10335f, g(jVar, (int) j8));
                        this.f10334e = 0;
                        return true;
                    }
                    long j9 = this.f10336g;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j9);
                    throw new f1(sb2.toString());
                } else if (b6 == 4) {
                    this.f10333d.e(this.f10335f, (int) this.f10336g, jVar);
                    this.f10334e = 0;
                    return true;
                } else if (b6 != 5) {
                    StringBuilder sb3 = new StringBuilder(32);
                    sb3.append("Invalid element type ");
                    sb3.append(b6);
                    throw new f1(sb3.toString());
                } else {
                    long j10 = this.f10336g;
                    if (j10 == 4 || j10 == 8) {
                        this.f10333d.c(this.f10335f, e(jVar, (int) j10));
                        this.f10334e = 0;
                        return true;
                    }
                    long j11 = this.f10336g;
                    StringBuilder sb4 = new StringBuilder(40);
                    sb4.append("Invalid float size: ");
                    sb4.append(j11);
                    throw new f1(sb4.toString());
                }
            }
            jVar.h((int) this.f10336g);
            this.f10334e = 0;
        }
    }

    @Override // g1.c
    public void c() {
        this.f10334e = 0;
        this.f10331b.clear();
        this.f10332c.e();
    }
}
