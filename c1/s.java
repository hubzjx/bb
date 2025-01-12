package c1;

import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final int f3225a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3226b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3227c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3228d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3229e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3230f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3231g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3232h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3233i;

    /* renamed from: j  reason: collision with root package name */
    public final long f3234j;

    /* renamed from: k  reason: collision with root package name */
    public final a f3235k;

    /* renamed from: l  reason: collision with root package name */
    private final n1.a f3236l;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f3237a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3238b;

        public a(long[] jArr, long[] jArr2) {
            this.f3237a = jArr;
            this.f3238b = jArr2;
        }
    }

    private s(int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j6, a aVar, n1.a aVar2) {
        this.f3225a = i6;
        this.f3226b = i7;
        this.f3227c = i8;
        this.f3228d = i9;
        this.f3229e = i10;
        this.f3230f = k(i10);
        this.f3231g = i11;
        this.f3232h = i12;
        this.f3233i = f(i12);
        this.f3234j = j6;
        this.f3235k = aVar;
        this.f3236l = aVar2;
    }

    private static n1.a a(List list, List list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = (String) list.get(i6);
            String[] L0 = s0.L0(str, "=");
            if (L0.length != 2) {
                String valueOf = String.valueOf(str);
                com.google.android.exoplayer2.util.n.h("FlacStreamMetadata", valueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(valueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new q1.b(L0[0], L0[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new n1.a(arrayList);
    }

    private static int f(int i6) {
        if (i6 != 8) {
            if (i6 != 12) {
                if (i6 != 16) {
                    if (i6 != 20) {
                        return i6 != 24 ? -1 : 6;
                    }
                    return 5;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static int k(int i6) {
        switch (i6) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public s b(List list) {
        return new s(this.f3225a, this.f3226b, this.f3227c, this.f3228d, this.f3229e, this.f3231g, this.f3232h, this.f3234j, this.f3235k, i(a(Collections.emptyList(), list)));
    }

    public s c(a aVar) {
        return new s(this.f3225a, this.f3226b, this.f3227c, this.f3228d, this.f3229e, this.f3231g, this.f3232h, this.f3234j, aVar, this.f3236l);
    }

    public s d(List list) {
        return new s(this.f3225a, this.f3226b, this.f3227c, this.f3228d, this.f3229e, this.f3231g, this.f3232h, this.f3234j, this.f3235k, i(a(list, Collections.emptyList())));
    }

    public long e() {
        long j6;
        long j7;
        int i6 = this.f3228d;
        if (i6 > 0) {
            j6 = (i6 + this.f3227c) / 2;
            j7 = 1;
        } else {
            int i7 = this.f3225a;
            j6 = ((((i7 != this.f3226b || i7 <= 0) ? 4096L : i7) * this.f3231g) * this.f3232h) / 8;
            j7 = 64;
        }
        return j6 + j7;
    }

    public long g() {
        long j6 = this.f3234j;
        if (j6 == 0) {
            return -9223372036854775807L;
        }
        return (j6 * 1000000) / this.f3229e;
    }

    public com.google.android.exoplayer2.s0 h(byte[] bArr, n1.a aVar) {
        bArr[4] = Byte.MIN_VALUE;
        int i6 = this.f3228d;
        if (i6 <= 0) {
            i6 = -1;
        }
        return new s0.b().e0("audio/flac").W(i6).H(this.f3231g).f0(this.f3229e).T(Collections.singletonList(bArr)).X(i(aVar)).E();
    }

    public n1.a i(n1.a aVar) {
        n1.a aVar2 = this.f3236l;
        return aVar2 == null ? aVar : aVar2.f(aVar);
    }

    public long j(long j6) {
        return com.google.android.exoplayer2.util.s0.s((j6 * this.f3229e) / 1000000, 0L, this.f3234j - 1);
    }

    public s(byte[] bArr, int i6) {
        com.google.android.exoplayer2.util.x xVar = new com.google.android.exoplayer2.util.x(bArr);
        xVar.p(i6 * 8);
        this.f3225a = xVar.h(16);
        this.f3226b = xVar.h(16);
        this.f3227c = xVar.h(24);
        this.f3228d = xVar.h(24);
        int h6 = xVar.h(20);
        this.f3229e = h6;
        this.f3230f = k(h6);
        this.f3231g = xVar.h(3) + 1;
        int h7 = xVar.h(5) + 1;
        this.f3232h = h7;
        this.f3233i = f(h7);
        this.f3234j = xVar.j(36);
        this.f3235k = null;
        this.f3236l = null;
    }
}
