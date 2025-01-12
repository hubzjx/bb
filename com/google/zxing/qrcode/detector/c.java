package com.google.zxing.qrcode.detector;

import com.google.zxing.k;
import com.google.zxing.p;
import com.google.zxing.qrcode.decoder.j;
import java.util.Map;
import s3.g;
import s3.i;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final s3.b f5882a;

    public c(s3.b bVar) {
        this.f5882a = bVar;
    }

    private float b(p pVar, p pVar2) {
        float j6 = j((int) pVar.c(), (int) pVar.d(), (int) pVar2.c(), (int) pVar2.d());
        float j7 = j((int) pVar2.c(), (int) pVar2.d(), (int) pVar.c(), (int) pVar.d());
        return Float.isNaN(j6) ? j7 / 7.0f : Float.isNaN(j7) ? j6 / 7.0f : (j6 + j7) / 14.0f;
    }

    private static int c(p pVar, p pVar2, p pVar3, float f6) {
        int c6 = ((t3.a.c(p.b(pVar, pVar2) / f6) + t3.a.c(p.b(pVar, pVar3) / f6)) / 2) + 7;
        int i6 = c6 & 3;
        if (i6 != 0) {
            if (i6 != 2) {
                if (i6 != 3) {
                    return c6;
                }
                throw k.getNotFoundInstance();
            }
            return c6 - 1;
        }
        return c6 + 1;
    }

    private static s3.k d(p pVar, p pVar2, p pVar3, p pVar4, int i6) {
        float c6;
        float d6;
        float f6;
        float f7 = i6 - 3.5f;
        if (pVar4 != null) {
            c6 = pVar4.c();
            d6 = pVar4.d();
            f6 = f7 - 3.0f;
        } else {
            c6 = (pVar2.c() - pVar.c()) + pVar3.c();
            d6 = (pVar2.d() - pVar.d()) + pVar3.d();
            f6 = f7;
        }
        return s3.k.b(3.5f, 3.5f, f7, 3.5f, f6, f6, 3.5f, f7, pVar.c(), pVar.d(), pVar2.c(), pVar2.d(), c6, d6, pVar3.c(), pVar3.d());
    }

    private static s3.b h(s3.b bVar, s3.k kVar, int i6) {
        return i.b().c(bVar, i6, i6, kVar);
    }

    private float i(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        c cVar;
        boolean z5;
        boolean z6;
        int i15 = 1;
        boolean z7 = Math.abs(i9 - i7) > Math.abs(i8 - i6);
        if (z7) {
            i11 = i6;
            i10 = i7;
            i13 = i8;
            i12 = i9;
        } else {
            i10 = i6;
            i11 = i7;
            i12 = i8;
            i13 = i9;
        }
        int abs = Math.abs(i12 - i10);
        int abs2 = Math.abs(i13 - i11);
        int i16 = (-abs) / 2;
        int i17 = i10 < i12 ? 1 : -1;
        int i18 = i11 < i13 ? 1 : -1;
        int i19 = i12 + i17;
        int i20 = i10;
        int i21 = i11;
        int i22 = 0;
        while (true) {
            if (i20 == i19) {
                i14 = i19;
                break;
            }
            int i23 = z7 ? i21 : i20;
            int i24 = z7 ? i20 : i21;
            if (i22 == i15) {
                cVar = this;
                z5 = z7;
                i14 = i19;
                z6 = true;
            } else {
                cVar = this;
                z5 = z7;
                i14 = i19;
                z6 = false;
            }
            if (z6 == cVar.f5882a.e(i23, i24)) {
                if (i22 == 2) {
                    return t3.a.b(i20, i21, i10, i11);
                }
                i22++;
            }
            i16 += abs2;
            if (i16 > 0) {
                if (i21 == i13) {
                    break;
                }
                i21 += i18;
                i16 -= abs;
            }
            i20 += i17;
            i19 = i14;
            z7 = z5;
            i15 = 1;
        }
        if (i22 == 2) {
            return t3.a.b(i14, i13, i10, i11);
        }
        return Float.NaN;
    }

    private float j(int i6, int i7, int i8, int i9) {
        float f6;
        float f7;
        float i10 = i(i6, i7, i8, i9);
        int i11 = i6 - (i8 - i6);
        int i12 = 0;
        if (i11 < 0) {
            f6 = i6 / (i6 - i11);
            i11 = 0;
        } else if (i11 >= this.f5882a.i()) {
            f6 = ((this.f5882a.i() - 1) - i6) / (i11 - i6);
            i11 = this.f5882a.i() - 1;
        } else {
            f6 = 1.0f;
        }
        float f8 = i7;
        int i13 = (int) (f8 - ((i9 - i7) * f6));
        if (i13 < 0) {
            f7 = f8 / (i7 - i13);
        } else if (i13 >= this.f5882a.g()) {
            f7 = ((this.f5882a.g() - 1) - i7) / (i13 - i7);
            i12 = this.f5882a.g() - 1;
        } else {
            i12 = i13;
            f7 = 1.0f;
        }
        return (i10 + i(i6, i7, (int) (i6 + ((i11 - i6) * f7)), i12)) - 1.0f;
    }

    protected final float a(p pVar, p pVar2, p pVar3) {
        return (b(pVar, pVar2) + b(pVar, pVar3)) / 2.0f;
    }

    public final g e(Map map) {
        if (map != null) {
            android.support.v4.media.a.a(map.get(com.google.zxing.e.NEED_RESULT_POINT_CALLBACK));
        }
        return g(new e(this.f5882a, null).f(map));
    }

    protected final a f(float f6, int i6, int i7, float f7) {
        int i8 = (int) (f7 * f6);
        int max = Math.max(0, i6 - i8);
        int min = Math.min(this.f5882a.i() - 1, i6 + i8) - max;
        float f8 = 3.0f * f6;
        if (min >= f8) {
            int max2 = Math.max(0, i7 - i8);
            int min2 = Math.min(this.f5882a.g() - 1, i7 + i8) - max2;
            if (min2 >= f8) {
                return new b(this.f5882a, max, max2, min, min2, f6, null).c();
            }
            throw k.getNotFoundInstance();
        }
        throw k.getNotFoundInstance();
    }

    protected final g g(f fVar) {
        a aVar;
        d b6 = fVar.b();
        d c6 = fVar.c();
        d a6 = fVar.a();
        float a7 = a(b6, c6, a6);
        if (a7 >= 1.0f) {
            int c7 = c(b6, c6, a6, a7);
            j g6 = j.g(c7);
            int e6 = g6.e() - 7;
            if (g6.d().length > 0) {
                float c8 = (c6.c() - b6.c()) + a6.c();
                float d6 = (c6.d() - b6.d()) + a6.d();
                float f6 = 1.0f - (3.0f / e6);
                int c9 = (int) (b6.c() + ((c8 - b6.c()) * f6));
                int d7 = (int) (b6.d() + (f6 * (d6 - b6.d())));
                for (int i6 = 4; i6 <= 16; i6 <<= 1) {
                    try {
                        aVar = f(a7, c9, d7, i6);
                        break;
                    } catch (k unused) {
                    }
                }
            }
            aVar = null;
            return new g(h(this.f5882a, d(b6, c6, a6, aVar, c7), c7), aVar == null ? new p[]{a6, b6, c6} : new p[]{a6, b6, c6, aVar});
        }
        throw k.getNotFoundInstance();
    }
}
