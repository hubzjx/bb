package r3;

import b.j;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    static final String[] f13038b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: c  reason: collision with root package name */
    static final int[][] f13039c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f13040d;

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f13041e;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13042a;

    /* loaded from: classes.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.d() - fVar2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, 5, 256);
        f13040d = iArr;
        iArr[0][32] = 1;
        for (int i6 = 65; i6 <= 90; i6++) {
            f13040d[0][i6] = (i6 - 65) + 2;
        }
        f13040d[1][32] = 1;
        for (int i7 = 97; i7 <= 122; i7++) {
            f13040d[1][i7] = (i7 - 97) + 2;
        }
        f13040d[2][32] = 1;
        for (int i8 = 48; i8 <= 57; i8++) {
            f13040d[2][i8] = (i8 - 48) + 2;
        }
        int[] iArr2 = f13040d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, j.N0, WebSocketProtocol.PAYLOAD_SHORT, 127};
        for (int i9 = 0; i9 < 28; i9++) {
            f13040d[3][iArr3[i9]] = i9;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, j.M0, 125};
        for (int i10 = 0; i10 < 31; i10++) {
            int i11 = iArr4[i10];
            if (i11 > 0) {
                f13040d[4][i11] = i10;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(Integer.TYPE, 6, 6);
        f13041e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f13041e;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public d(byte[] bArr) {
        this.f13042a = bArr;
    }

    private static Collection b(Iterable iterable) {
        boolean z5;
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z5 = true;
                    break;
                }
                f fVar2 = (f) it2.next();
                if (fVar2.f(fVar)) {
                    z5 = false;
                    break;
                } else if (fVar.f(fVar2)) {
                    it2.remove();
                }
            }
            if (z5) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i6, Collection collection) {
        char c6 = (char) (this.f13042a[i6] & 255);
        boolean z5 = f13040d[fVar.e()][c6] > 0;
        f fVar2 = null;
        for (int i7 = 0; i7 <= 4; i7++) {
            int i8 = f13040d[i7][c6];
            if (i8 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i6);
                }
                if (!z5 || i7 == fVar.e() || i7 == 2) {
                    collection.add(fVar2.g(i7, i8));
                }
                if (!z5 && f13041e[fVar.e()][i7] >= 0) {
                    collection.add(fVar2.h(i7, i8));
                }
            }
        }
        if (fVar.c() > 0 || f13040d[fVar.e()][c6] == 0) {
            collection.add(fVar.a(i6));
        }
    }

    private static void d(f fVar, int i6, int i7, Collection collection) {
        f b6 = fVar.b(i6);
        collection.add(b6.g(4, i7));
        if (fVar.e() != 4) {
            collection.add(b6.h(4, i7));
        }
        if (i7 == 3 || i7 == 4) {
            collection.add(b6.g(2, 16 - i7).g(2, 1));
        }
        if (fVar.c() > 0) {
            collection.add(fVar.a(i6).a(i6 + 1));
        }
    }

    private Collection e(Iterable iterable, int i6) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((f) it.next(), i6, linkedList);
        }
        return b(linkedList);
    }

    private static Collection f(Iterable iterable, int i6, int i7) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            d((f) it.next(), i6, i7, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s3.a a() {
        int i6;
        Collection singletonList = Collections.singletonList(f.f13046e);
        int i7 = 0;
        while (true) {
            byte[] bArr = this.f13042a;
            if (i7 >= bArr.length) {
                return ((f) Collections.min(singletonList, new a())).i(this.f13042a);
            }
            int i8 = i7 + 1;
            byte b6 = i8 < bArr.length ? bArr[i8] : (byte) 0;
            byte b7 = bArr[i7];
            if (b7 == 13) {
                if (b6 == 10) {
                    i6 = 2;
                    if (i6 <= 0) {
                    }
                    i7++;
                }
                i6 = 0;
                if (i6 <= 0) {
                }
                i7++;
            } else if (b7 == 44) {
                if (b6 == 32) {
                    i6 = 4;
                    if (i6 <= 0) {
                    }
                    i7++;
                }
                i6 = 0;
                if (i6 <= 0) {
                }
                i7++;
            } else if (b7 != 46) {
                if (b7 == 58 && b6 == 32) {
                    i6 = 5;
                    if (i6 <= 0) {
                        singletonList = f(singletonList, i7, i6);
                        i7 = i8;
                    } else {
                        singletonList = e(singletonList, i7);
                    }
                    i7++;
                }
                i6 = 0;
                if (i6 <= 0) {
                }
                i7++;
            } else {
                if (b6 == 32) {
                    i6 = 3;
                    if (i6 <= 0) {
                    }
                    i7++;
                }
                i6 = 0;
                if (i6 <= 0) {
                }
                i7++;
            }
        }
    }
}
