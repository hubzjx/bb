package d2;

import android.net.Uri;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.m0;
import i1.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import u1.c;
import u1.e;
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final int f9137a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9138b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9139c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f9140d;

    /* renamed from: e  reason: collision with root package name */
    public final C0154a f9141e;

    /* renamed from: f  reason: collision with root package name */
    public final b[] f9142f;

    /* renamed from: g  reason: collision with root package name */
    public final long f9143g;

    /* renamed from: h  reason: collision with root package name */
    public final long f9144h;

    /* renamed from: d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0154a {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f9145a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f9146b;

        /* renamed from: c  reason: collision with root package name */
        public final p[] f9147c;

        public C0154a(UUID uuid, byte[] bArr, p[] pVarArr) {
            this.f9145a = uuid;
            this.f9146b = bArr;
            this.f9147c = pVarArr;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f9148a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9149b;

        /* renamed from: c  reason: collision with root package name */
        public final long f9150c;

        /* renamed from: d  reason: collision with root package name */
        public final String f9151d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9152e;

        /* renamed from: f  reason: collision with root package name */
        public final int f9153f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9154g;

        /* renamed from: h  reason: collision with root package name */
        public final int f9155h;

        /* renamed from: i  reason: collision with root package name */
        public final String f9156i;

        /* renamed from: j  reason: collision with root package name */
        public final s0[] f9157j;

        /* renamed from: k  reason: collision with root package name */
        public final int f9158k;

        /* renamed from: l  reason: collision with root package name */
        private final String f9159l;

        /* renamed from: m  reason: collision with root package name */
        private final String f9160m;

        /* renamed from: n  reason: collision with root package name */
        private final List f9161n;

        /* renamed from: o  reason: collision with root package name */
        private final long[] f9162o;

        /* renamed from: p  reason: collision with root package name */
        private final long f9163p;

        public b(String str, String str2, int i6, String str3, long j6, String str4, int i7, int i8, int i9, int i10, String str5, s0[] s0VarArr, List list, long j7) {
            this(str, str2, i6, str3, j6, str4, i7, i8, i9, i10, str5, s0VarArr, list, com.google.android.exoplayer2.util.s0.G0(list, 1000000L, j6), com.google.android.exoplayer2.util.s0.F0(j7, 1000000L, j6));
        }

        public Uri a(int i6, int i7) {
            com.google.android.exoplayer2.util.a.g(this.f9157j != null);
            com.google.android.exoplayer2.util.a.g(this.f9161n != null);
            com.google.android.exoplayer2.util.a.g(i7 < this.f9161n.size());
            String num = Integer.toString(this.f9157j[i6].f4052h);
            String l6 = ((Long) this.f9161n.get(i7)).toString();
            return m0.d(this.f9159l, this.f9160m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l6).replace("{start_time}", l6));
        }

        public b b(s0[] s0VarArr) {
            return new b(this.f9159l, this.f9160m, this.f9148a, this.f9149b, this.f9150c, this.f9151d, this.f9152e, this.f9153f, this.f9154g, this.f9155h, this.f9156i, s0VarArr, this.f9161n, this.f9162o, this.f9163p);
        }

        public long c(int i6) {
            if (i6 == this.f9158k - 1) {
                return this.f9163p;
            }
            long[] jArr = this.f9162o;
            return jArr[i6 + 1] - jArr[i6];
        }

        public int d(long j6) {
            return com.google.android.exoplayer2.util.s0.i(this.f9162o, j6, true, true);
        }

        public long e(int i6) {
            return this.f9162o[i6];
        }

        private b(String str, String str2, int i6, String str3, long j6, String str4, int i7, int i8, int i9, int i10, String str5, s0[] s0VarArr, List list, long[] jArr, long j7) {
            this.f9159l = str;
            this.f9160m = str2;
            this.f9148a = i6;
            this.f9149b = str3;
            this.f9150c = j6;
            this.f9151d = str4;
            this.f9152e = i7;
            this.f9153f = i8;
            this.f9154g = i9;
            this.f9155h = i10;
            this.f9156i = str5;
            this.f9157j = s0VarArr;
            this.f9161n = list;
            this.f9162o = jArr;
            this.f9163p = j7;
            this.f9158k = list.size();
        }
    }

    private a(int i6, int i7, long j6, long j7, int i8, boolean z5, C0154a c0154a, b[] bVarArr) {
        this.f9137a = i6;
        this.f9138b = i7;
        this.f9143g = j6;
        this.f9144h = j7;
        this.f9139c = i8;
        this.f9140d = z5;
        this.f9141e = c0154a;
        this.f9142f = bVarArr;
    }

    @Override // u1.c
    /* renamed from: b */
    public final a a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            e eVar = (e) arrayList.get(i6);
            b bVar2 = this.f9142f[eVar.f13429b];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((s0[]) arrayList3.toArray(new s0[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f9157j[eVar.f13430c]);
            i6++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((s0[]) arrayList3.toArray(new s0[0])));
        }
        return new a(this.f9137a, this.f9138b, this.f9143g, this.f9144h, this.f9139c, this.f9140d, this.f9141e, (b[]) arrayList2.toArray(new b[0]));
    }

    public a(int i6, int i7, long j6, long j7, long j8, int i8, boolean z5, C0154a c0154a, b[] bVarArr) {
        this(i6, i7, j7 == 0 ? -9223372036854775807L : com.google.android.exoplayer2.util.s0.F0(j7, 1000000L, j6), j8 != 0 ? com.google.android.exoplayer2.util.s0.F0(j8, 1000000L, j6) : -9223372036854775807L, i8, z5, c0154a, bVarArr);
    }
}
