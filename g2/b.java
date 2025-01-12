package g2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.x;
import e2.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class b {

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f10413h = {0, 7, 8, 15};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f10414i = {0, 119, -120, -1};

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f10415j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f10416a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f10417b;

    /* renamed from: c  reason: collision with root package name */
    private final Canvas f10418c;

    /* renamed from: d  reason: collision with root package name */
    private final C0169b f10419d;

    /* renamed from: e  reason: collision with root package name */
    private final a f10420e;

    /* renamed from: f  reason: collision with root package name */
    private final h f10421f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f10422g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10423a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f10424b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f10425c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f10426d;

        public a(int i6, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f10423a = i6;
            this.f10424b = iArr;
            this.f10425c = iArr2;
            this.f10426d = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0169b {

        /* renamed from: a  reason: collision with root package name */
        public final int f10427a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10428b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10429c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10430d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10431e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10432f;

        public C0169b(int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f10427a = i6;
            this.f10428b = i7;
            this.f10429c = i8;
            this.f10430d = i9;
            this.f10431e = i10;
            this.f10432f = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f10433a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10434b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f10435c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f10436d;

        public c(int i6, boolean z5, byte[] bArr, byte[] bArr2) {
            this.f10433a = i6;
            this.f10434b = z5;
            this.f10435c = bArr;
            this.f10436d = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f10437a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10438b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10439c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray f10440d;

        public d(int i6, int i7, int i8, SparseArray sparseArray) {
            this.f10437a = i6;
            this.f10438b = i7;
            this.f10439c = i8;
            this.f10440d = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f10441a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10442b;

        public e(int i6, int i7) {
            this.f10441a = i6;
            this.f10442b = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f10443a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10444b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10445c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10446d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10447e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10448f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10449g;

        /* renamed from: h  reason: collision with root package name */
        public final int f10450h;

        /* renamed from: i  reason: collision with root package name */
        public final int f10451i;

        /* renamed from: j  reason: collision with root package name */
        public final int f10452j;

        /* renamed from: k  reason: collision with root package name */
        public final SparseArray f10453k;

        public f(int i6, boolean z5, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, SparseArray sparseArray) {
            this.f10443a = i6;
            this.f10444b = z5;
            this.f10445c = i7;
            this.f10446d = i8;
            this.f10447e = i9;
            this.f10448f = i10;
            this.f10449g = i11;
            this.f10450h = i12;
            this.f10451i = i13;
            this.f10452j = i14;
            this.f10453k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray sparseArray = fVar.f10453k;
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                this.f10453k.put(sparseArray.keyAt(i6), (g) sparseArray.valueAt(i6));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f10454a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10455b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10456c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10457d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10458e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10459f;

        public g(int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f10454a = i6;
            this.f10455b = i7;
            this.f10456c = i8;
            this.f10457d = i9;
            this.f10458e = i10;
            this.f10459f = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f10460a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10461b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray f10462c = new SparseArray();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray f10463d = new SparseArray();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray f10464e = new SparseArray();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray f10465f = new SparseArray();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray f10466g = new SparseArray();

        /* renamed from: h  reason: collision with root package name */
        public C0169b f10467h;

        /* renamed from: i  reason: collision with root package name */
        public d f10468i;

        public h(int i6, int i7) {
            this.f10460a = i6;
            this.f10461b = i7;
        }

        public void a() {
            this.f10462c.clear();
            this.f10463d.clear();
            this.f10464e.clear();
            this.f10465f.clear();
            this.f10466g.clear();
            this.f10467h = null;
            this.f10468i = null;
        }
    }

    public b(int i6, int i7) {
        Paint paint = new Paint();
        this.f10416a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f10417b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f10418c = new Canvas();
        this.f10419d = new C0169b(719, 575, 0, 719, 0, 575);
        this.f10420e = new a(0, c(), d(), e());
        this.f10421f = new h(i6, i7);
    }

    private static byte[] a(int i6, int i7, x xVar) {
        byte[] bArr = new byte[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            bArr[i8] = (byte) xVar.h(i7);
        }
        return bArr;
    }

    private static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i6 = 1; i6 < 16; i6++) {
            if (i6 < 8) {
                iArr[i6] = f(255, (i6 & 1) != 0 ? 255 : 0, (i6 & 2) != 0 ? 255 : 0, (i6 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i6] = f(255, (i6 & 1) != 0 ? 127 : 0, (i6 & 2) != 0 ? 127 : 0, (i6 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            if (i6 < 8) {
                iArr[i6] = f(63, (i6 & 1) != 0 ? 255 : 0, (i6 & 2) != 0 ? 255 : 0, (i6 & 4) == 0 ? 0 : 255);
            } else {
                int i7 = i6 & 136;
                if (i7 == 0) {
                    iArr[i6] = f(255, ((i6 & 1) != 0 ? 85 : 0) + ((i6 & 16) != 0 ? 170 : 0), ((i6 & 2) != 0 ? 85 : 0) + ((i6 & 32) != 0 ? 170 : 0), ((i6 & 4) == 0 ? 0 : 85) + ((i6 & 64) == 0 ? 0 : 170));
                } else if (i7 == 8) {
                    iArr[i6] = f(127, ((i6 & 1) != 0 ? 85 : 0) + ((i6 & 16) != 0 ? 170 : 0), ((i6 & 2) != 0 ? 85 : 0) + ((i6 & 32) != 0 ? 170 : 0), ((i6 & 4) == 0 ? 0 : 85) + ((i6 & 64) == 0 ? 0 : 170));
                } else if (i7 == 128) {
                    iArr[i6] = f(255, ((i6 & 1) != 0 ? 43 : 0) + 127 + ((i6 & 16) != 0 ? 85 : 0), ((i6 & 2) != 0 ? 43 : 0) + 127 + ((i6 & 32) != 0 ? 85 : 0), ((i6 & 4) == 0 ? 0 : 43) + 127 + ((i6 & 64) == 0 ? 0 : 85));
                } else if (i7 == 136) {
                    iArr[i6] = f(255, ((i6 & 1) != 0 ? 43 : 0) + ((i6 & 16) != 0 ? 85 : 0), ((i6 & 2) != 0 ? 43 : 0) + ((i6 & 32) != 0 ? 85 : 0), ((i6 & 4) == 0 ? 0 : 43) + ((i6 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int f(int i6, int i7, int i8, int i9) {
        return (i6 << 24) | (i7 << 16) | (i8 << 8) | i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b A[LOOP:0: B:3:0x0009->B:33:0x007b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(x xVar, int[] iArr, byte[] bArr, int i6, int i7, Paint paint, Canvas canvas) {
        boolean z5;
        int i8;
        int h6;
        int i9 = i6;
        boolean z6 = false;
        while (true) {
            byte h7 = xVar.h(2);
            if (h7 != 0) {
                z5 = z6;
            } else {
                if (xVar.g()) {
                    h6 = xVar.h(3) + 3;
                } else if (xVar.g()) {
                    z5 = z6;
                    h7 = 0;
                } else {
                    int h8 = xVar.h(2);
                    if (h8 == 0) {
                        h7 = 0;
                        z5 = true;
                    } else if (h8 == 1) {
                        z5 = z6;
                        h7 = 0;
                        i8 = 2;
                        if (i8 != 0 && paint != null) {
                            if (bArr != null) {
                                h7 = bArr[h7];
                            }
                            paint.setColor(iArr[h7]);
                            canvas.drawRect(i9, i7, i9 + i8, i7 + 1, paint);
                        }
                        i9 += i8;
                        if (!z5) {
                            return i9;
                        }
                        z6 = z5;
                    } else if (h8 == 2) {
                        h6 = xVar.h(4) + 12;
                    } else if (h8 != 3) {
                        z5 = z6;
                        h7 = 0;
                    } else {
                        h6 = xVar.h(8) + 29;
                    }
                    i8 = 0;
                    if (i8 != 0) {
                        if (bArr != null) {
                        }
                        paint.setColor(iArr[h7]);
                        canvas.drawRect(i9, i7, i9 + i8, i7 + 1, paint);
                    }
                    i9 += i8;
                    if (!z5) {
                    }
                }
                z5 = z6;
                i8 = h6;
                h7 = xVar.h(2);
                if (i8 != 0) {
                }
                i9 += i8;
                if (!z5) {
                }
            }
            i8 = 1;
            if (i8 != 0) {
            }
            i9 += i8;
            if (!z5) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087 A[LOOP:0: B:3:0x0009->B:36:0x0087, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int h(x xVar, int[] iArr, byte[] bArr, int i6, int i7, Paint paint, Canvas canvas) {
        boolean z5;
        int i8;
        int h6;
        int i9 = i6;
        boolean z6 = false;
        while (true) {
            byte h7 = xVar.h(4);
            if (h7 != 0) {
                z5 = z6;
            } else {
                if (xVar.g()) {
                    if (xVar.g()) {
                        int h8 = xVar.h(2);
                        if (h8 == 0) {
                            z5 = z6;
                            h7 = 0;
                        } else if (h8 == 1) {
                            z5 = z6;
                            h7 = 0;
                            i8 = 2;
                        } else if (h8 == 2) {
                            h6 = xVar.h(4) + 9;
                        } else if (h8 != 3) {
                            z5 = z6;
                            h7 = 0;
                            i8 = 0;
                        } else {
                            h6 = xVar.h(8) + 25;
                        }
                    } else {
                        h6 = xVar.h(2) + 4;
                    }
                    z5 = z6;
                    i8 = h6;
                    h7 = xVar.h(4);
                } else {
                    int h9 = xVar.h(3);
                    if (h9 != 0) {
                        z5 = z6;
                        i8 = h9 + 2;
                        h7 = 0;
                    } else {
                        h7 = 0;
                        z5 = true;
                        i8 = 0;
                    }
                }
                if (i8 != 0 && paint != null) {
                    if (bArr != null) {
                        h7 = bArr[h7];
                    }
                    paint.setColor(iArr[h7]);
                    canvas.drawRect(i9, i7, i9 + i8, i7 + 1, paint);
                }
                i9 += i8;
                if (!z5) {
                    return i9;
                }
                z6 = z5;
            }
            i8 = 1;
            if (i8 != 0) {
                if (bArr != null) {
                }
                paint.setColor(iArr[h7]);
                canvas.drawRect(i9, i7, i9 + i8, i7 + 1, paint);
            }
            i9 += i8;
            if (!z5) {
            }
        }
    }

    private static int i(x xVar, int[] iArr, byte[] bArr, int i6, int i7, Paint paint, Canvas canvas) {
        boolean z5;
        int h6;
        int i8 = i6;
        boolean z6 = false;
        while (true) {
            byte h7 = xVar.h(8);
            if (h7 != 0) {
                z5 = z6;
                h6 = 1;
            } else if (xVar.g()) {
                z5 = z6;
                h6 = xVar.h(7);
                h7 = xVar.h(8);
            } else {
                int h8 = xVar.h(7);
                if (h8 != 0) {
                    z5 = z6;
                    h6 = h8;
                    h7 = 0;
                } else {
                    h7 = 0;
                    z5 = true;
                    h6 = 0;
                }
            }
            if (h6 != 0 && paint != null) {
                if (bArr != null) {
                    h7 = bArr[h7];
                }
                paint.setColor(iArr[h7]);
                canvas.drawRect(i8, i7, i8 + h6, i7 + 1, paint);
            }
            i8 += h6;
            if (z5) {
                return i8;
            }
            z6 = z5;
        }
    }

    private static void j(byte[] bArr, int[] iArr, int i6, int i7, int i8, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        x xVar = new x(bArr);
        int i9 = i7;
        int i10 = i8;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (xVar.b() != 0) {
            int h6 = xVar.h(8);
            if (h6 != 240) {
                switch (h6) {
                    case 16:
                        if (i6 != 3) {
                            if (i6 != 2) {
                                bArr2 = null;
                                i9 = g(xVar, iArr, bArr2, i9, i10, paint, canvas);
                                xVar.c();
                                break;
                            } else {
                                bArr3 = bArr7 == null ? f10413h : bArr7;
                            }
                        } else {
                            bArr3 = bArr5 == null ? f10414i : bArr5;
                        }
                        bArr2 = bArr3;
                        i9 = g(xVar, iArr, bArr2, i9, i10, paint, canvas);
                        xVar.c();
                    case 17:
                        if (i6 == 3) {
                            bArr4 = bArr6 == null ? f10415j : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i9 = h(xVar, iArr, bArr4, i9, i10, paint, canvas);
                        xVar.c();
                        break;
                    case 18:
                        i9 = i(xVar, iArr, null, i9, i10, paint, canvas);
                        break;
                    default:
                        switch (h6) {
                            case 32:
                                bArr7 = a(4, 4, xVar);
                                continue;
                            case 33:
                                bArr5 = a(4, 8, xVar);
                                continue;
                            case 34:
                                bArr6 = a(16, 8, xVar);
                                continue;
                        }
                }
            } else {
                i10 += 2;
                i9 = i7;
            }
        }
    }

    private static void k(c cVar, a aVar, int i6, int i7, int i8, Paint paint, Canvas canvas) {
        int[] iArr = i6 == 3 ? aVar.f10426d : i6 == 2 ? aVar.f10425c : aVar.f10424b;
        j(cVar.f10435c, iArr, i6, i7, i8, paint, canvas);
        j(cVar.f10436d, iArr, i6, i7, i8 + 1, paint, canvas);
    }

    private static a l(x xVar, int i6) {
        int h6;
        int i7;
        int h7;
        int h8;
        int i8;
        int i9 = 8;
        int h9 = xVar.h(8);
        xVar.r(8);
        int i10 = 2;
        int i11 = i6 - 2;
        int[] c6 = c();
        int[] d6 = d();
        int[] e6 = e();
        while (i11 > 0) {
            int h10 = xVar.h(i9);
            int h11 = xVar.h(i9);
            int i12 = i11 - 2;
            int[] iArr = (h11 & 128) != 0 ? c6 : (h11 & 64) != 0 ? d6 : e6;
            if ((h11 & 1) != 0) {
                h8 = xVar.h(i9);
                i8 = xVar.h(i9);
                h6 = xVar.h(i9);
                h7 = xVar.h(i9);
                i7 = i12 - 4;
            } else {
                int h12 = xVar.h(4) << 4;
                h6 = xVar.h(4) << 4;
                i7 = i12 - 2;
                h7 = xVar.h(i10) << 6;
                h8 = xVar.h(6) << i10;
                i8 = h12;
            }
            if (h8 == 0) {
                i8 = 0;
                h6 = 0;
                h7 = 255;
            }
            double d7 = h8;
            double d8 = i8 - 128;
            double d9 = h6 - 128;
            iArr[h10] = f((byte) (255 - (h7 & 255)), s0.r((int) (d7 + (1.402d * d8)), 0, 255), s0.r((int) ((d7 - (0.34414d * d9)) - (d8 * 0.71414d)), 0, 255), s0.r((int) (d7 + (d9 * 1.772d)), 0, 255));
            i11 = i7;
            h9 = h9;
            i9 = 8;
            i10 = 2;
        }
        return new a(h9, c6, d6, e6);
    }

    private static C0169b m(x xVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        xVar.r(4);
        boolean g6 = xVar.g();
        xVar.r(3);
        int h6 = xVar.h(16);
        int h7 = xVar.h(16);
        if (g6) {
            int h8 = xVar.h(16);
            int h9 = xVar.h(16);
            int h10 = xVar.h(16);
            i7 = xVar.h(16);
            i6 = h9;
            i9 = h10;
            i8 = h8;
        } else {
            i6 = h6;
            i7 = h7;
            i8 = 0;
            i9 = 0;
        }
        return new C0169b(h6, h7, i8, i6, i9, i7);
    }

    private static c n(x xVar) {
        byte[] bArr;
        int h6 = xVar.h(16);
        xVar.r(4);
        int h7 = xVar.h(2);
        boolean g6 = xVar.g();
        xVar.r(1);
        byte[] bArr2 = s0.f4678f;
        if (h7 == 1) {
            xVar.r(xVar.h(8) * 16);
        } else if (h7 == 0) {
            int h8 = xVar.h(16);
            int h9 = xVar.h(16);
            if (h8 > 0) {
                bArr2 = new byte[h8];
                xVar.k(bArr2, 0, h8);
            }
            if (h9 > 0) {
                bArr = new byte[h9];
                xVar.k(bArr, 0, h9);
                return new c(h6, g6, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(h6, g6, bArr2, bArr);
    }

    private static d o(x xVar, int i6) {
        int h6 = xVar.h(8);
        int h7 = xVar.h(4);
        int h8 = xVar.h(2);
        xVar.r(2);
        int i7 = i6 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int h9 = xVar.h(8);
            xVar.r(8);
            i7 -= 6;
            sparseArray.put(h9, new e(xVar.h(16), xVar.h(16)));
        }
        return new d(h6, h7, h8, sparseArray);
    }

    private static f p(x xVar, int i6) {
        int h6;
        int h7;
        int h8 = xVar.h(8);
        xVar.r(4);
        boolean g6 = xVar.g();
        xVar.r(3);
        int i7 = 16;
        int h9 = xVar.h(16);
        int h10 = xVar.h(16);
        int h11 = xVar.h(3);
        int h12 = xVar.h(3);
        int i8 = 2;
        xVar.r(2);
        int h13 = xVar.h(8);
        int h14 = xVar.h(8);
        int h15 = xVar.h(4);
        int h16 = xVar.h(2);
        xVar.r(2);
        int i9 = i6 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i9 > 0) {
            int h17 = xVar.h(i7);
            int h18 = xVar.h(i8);
            int h19 = xVar.h(i8);
            int h20 = xVar.h(12);
            int i10 = h16;
            xVar.r(4);
            int h21 = xVar.h(12);
            i9 -= 6;
            if (h18 == 1 || h18 == 2) {
                i9 -= 2;
                h6 = xVar.h(8);
                h7 = xVar.h(8);
            } else {
                h6 = 0;
                h7 = 0;
            }
            sparseArray.put(h17, new g(h18, h19, h20, h21, h6, h7));
            h16 = i10;
            i8 = 2;
            i7 = 16;
        }
        return new f(h8, g6, h9, h10, h11, h12, h13, h14, h15, h16, sparseArray);
    }

    private static void q(x xVar, h hVar) {
        f fVar;
        SparseArray sparseArray;
        a aVar;
        int i6;
        a aVar2;
        c cVar;
        int h6 = xVar.h(8);
        int h7 = xVar.h(16);
        int h8 = xVar.h(16);
        int d6 = xVar.d() + h8;
        if (h8 * 8 > xVar.b()) {
            n.h("DvbParser", "Data field length exceeds limit");
            xVar.r(xVar.b());
            return;
        }
        switch (h6) {
            case 16:
                if (h7 == hVar.f10460a) {
                    d dVar = hVar.f10468i;
                    d o5 = o(xVar, h8);
                    if (o5.f10439c == 0) {
                        if (dVar != null && dVar.f10438b != o5.f10438b) {
                            hVar.f10468i = o5;
                            break;
                        }
                    } else {
                        hVar.f10468i = o5;
                        hVar.f10462c.clear();
                        hVar.f10463d.clear();
                        hVar.f10464e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f10468i;
                if (h7 == hVar.f10460a && dVar2 != null) {
                    f p5 = p(xVar, h8);
                    if (dVar2.f10439c == 0 && (fVar = (f) hVar.f10462c.get(p5.f10443a)) != null) {
                        p5.a(fVar);
                    }
                    hVar.f10462c.put(p5.f10443a, p5);
                    break;
                }
                break;
            case 18:
                if (h7 == hVar.f10460a) {
                    a l6 = l(xVar, h8);
                    sparseArray = hVar.f10463d;
                    aVar = l6;
                } else if (h7 == hVar.f10461b) {
                    a l7 = l(xVar, h8);
                    sparseArray = hVar.f10465f;
                    aVar = l7;
                }
                i6 = aVar.f10423a;
                aVar2 = aVar;
                sparseArray.put(i6, aVar2);
                break;
            case 19:
                if (h7 == hVar.f10460a) {
                    c n5 = n(xVar);
                    sparseArray = hVar.f10464e;
                    cVar = n5;
                } else if (h7 == hVar.f10461b) {
                    c n6 = n(xVar);
                    sparseArray = hVar.f10466g;
                    cVar = n6;
                }
                i6 = cVar.f10433a;
                aVar2 = cVar;
                sparseArray.put(i6, aVar2);
                break;
            case 20:
                if (h7 == hVar.f10460a) {
                    hVar.f10467h = m(xVar);
                    break;
                }
                break;
        }
        xVar.s(d6 - xVar.d());
    }

    public List b(byte[] bArr, int i6) {
        int i7;
        SparseArray sparseArray;
        x xVar = new x(bArr, i6);
        while (xVar.b() >= 48 && xVar.h(8) == 15) {
            q(xVar, this.f10421f);
        }
        h hVar = this.f10421f;
        d dVar = hVar.f10468i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0169b c0169b = hVar.f10467h;
        if (c0169b == null) {
            c0169b = this.f10419d;
        }
        Bitmap bitmap = this.f10422g;
        if (bitmap == null || c0169b.f10427a + 1 != bitmap.getWidth() || c0169b.f10428b + 1 != this.f10422g.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(c0169b.f10427a + 1, c0169b.f10428b + 1, Bitmap.Config.ARGB_8888);
            this.f10422g = createBitmap;
            this.f10418c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = dVar.f10440d;
        for (int i8 = 0; i8 < sparseArray2.size(); i8++) {
            this.f10418c.save();
            e eVar = (e) sparseArray2.valueAt(i8);
            f fVar = (f) this.f10421f.f10462c.get(sparseArray2.keyAt(i8));
            int i9 = eVar.f10441a + c0169b.f10429c;
            int i10 = eVar.f10442b + c0169b.f10431e;
            this.f10418c.clipRect(i9, i10, Math.min(fVar.f10445c + i9, c0169b.f10430d), Math.min(fVar.f10446d + i10, c0169b.f10432f));
            a aVar = (a) this.f10421f.f10463d.get(fVar.f10449g);
            if (aVar == null && (aVar = (a) this.f10421f.f10465f.get(fVar.f10449g)) == null) {
                aVar = this.f10420e;
            }
            SparseArray sparseArray3 = fVar.f10453k;
            int i11 = 0;
            while (i11 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i11);
                g gVar = (g) sparseArray3.valueAt(i11);
                c cVar = (c) this.f10421f.f10464e.get(keyAt);
                c cVar2 = cVar == null ? (c) this.f10421f.f10466g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i7 = i11;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f10448f, gVar.f10456c + i9, i10 + gVar.f10457d, cVar2.f10434b ? null : this.f10416a, this.f10418c);
                } else {
                    i7 = i11;
                    sparseArray = sparseArray3;
                }
                i11 = i7 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f10444b) {
                int i12 = fVar.f10448f;
                this.f10417b.setColor(i12 == 3 ? aVar.f10426d[fVar.f10450h] : i12 == 2 ? aVar.f10425c[fVar.f10451i] : aVar.f10424b[fVar.f10452j]);
                this.f10418c.drawRect(i9, i10, fVar.f10445c + i9, fVar.f10446d + i10, this.f10417b);
            }
            arrayList.add(new b.C0159b().f(Bitmap.createBitmap(this.f10422g, i9, i10, fVar.f10445c, fVar.f10446d)).j(i9 / c0169b.f10427a).k(0).h(i10 / c0169b.f10428b, 0).i(0).l(fVar.f10445c / c0169b.f10427a).g(fVar.f10446d / c0169b.f10428b).a());
            this.f10418c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f10418c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f10421f.a();
    }
}
