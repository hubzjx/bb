package o2;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.q1;
import com.google.android.exoplayer2.s0;
import com.google.common.collect.c1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import o2.a;
import o2.h;
import o2.j;
import o2.l;
import okhttp3.internal.http2.Http2;
import w1.x0;
import w1.y0;
/* loaded from: classes.dex */
public class f extends h {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f12369g = new int[0];

    /* renamed from: h  reason: collision with root package name */
    private static final c1 f12370h = c1.from(new Comparator() { // from class: o2.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int w5;
            w5 = f.w((Integer) obj, (Integer) obj2);
            return w5;
        }
    });

    /* renamed from: i  reason: collision with root package name */
    private static final c1 f12371i = c1.from(new Comparator() { // from class: o2.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int x5;
            x5 = f.x((Integer) obj, (Integer) obj2);
            return x5;
        }
    });

    /* renamed from: d  reason: collision with root package name */
    private final j.b f12372d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference f12373e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12374f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f12375a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12376b;

        /* renamed from: c  reason: collision with root package name */
        private final c f12377c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f12378d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12379e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12380f;

        /* renamed from: g  reason: collision with root package name */
        private final int f12381g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f12382h;

        /* renamed from: k  reason: collision with root package name */
        private final int f12383k;

        /* renamed from: l  reason: collision with root package name */
        private final int f12384l;

        /* renamed from: m  reason: collision with root package name */
        private final int f12385m;

        public a(s0 s0Var, c cVar, int i6) {
            this.f12377c = cVar;
            this.f12376b = f.z(s0Var.f4047c);
            int i7 = 0;
            this.f12378d = f.t(i6, false);
            this.f12379e = f.q(s0Var, cVar.f12465a, false);
            boolean z5 = true;
            this.f12382h = (s0Var.f4048d & 1) != 0;
            int i8 = s0Var.A;
            this.f12383k = i8;
            this.f12384l = s0Var.B;
            int i9 = s0Var.f4052h;
            this.f12385m = i9;
            if ((i9 != -1 && i9 > cVar.f12403y) || (i8 != -1 && i8 > cVar.f12402x)) {
                z5 = false;
            }
            this.f12375a = z5;
            String[] d02 = com.google.android.exoplayer2.util.s0.d0();
            int i10 = 0;
            while (true) {
                if (i10 >= d02.length) {
                    i10 = Integer.MAX_VALUE;
                    break;
                }
                int q5 = f.q(s0Var, d02[i10], false);
                if (q5 > 0) {
                    i7 = q5;
                    break;
                }
                i10++;
            }
            this.f12380f = i10;
            this.f12381g = i7;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            c1 reverse = (this.f12375a && this.f12378d) ? f.f12370h : f.f12370h.reverse();
            com.google.common.collect.n e6 = com.google.common.collect.n.i().f(this.f12378d, aVar.f12378d).d(this.f12379e, aVar.f12379e).f(this.f12375a, aVar.f12375a).e(Integer.valueOf(this.f12385m), Integer.valueOf(aVar.f12385m), this.f12377c.D ? f.f12370h.reverse() : f.f12371i).f(this.f12382h, aVar.f12382h).e(Integer.valueOf(this.f12380f), Integer.valueOf(aVar.f12380f), c1.natural().reverse()).d(this.f12381g, aVar.f12381g).e(Integer.valueOf(this.f12383k), Integer.valueOf(aVar.f12383k), reverse).e(Integer.valueOf(this.f12384l), Integer.valueOf(aVar.f12384l), reverse);
            Integer valueOf = Integer.valueOf(this.f12385m);
            Integer valueOf2 = Integer.valueOf(aVar.f12385m);
            if (!com.google.android.exoplayer2.util.s0.c(this.f12376b, aVar.f12376b)) {
                reverse = f.f12371i;
            }
            return e6.e(valueOf, valueOf2, reverse).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class b implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f12386a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f12387b;

        public b(s0 s0Var, int i6) {
            this.f12386a = (s0Var.f4048d & 1) != 0;
            this.f12387b = f.t(i6, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            return com.google.common.collect.n.i().f(this.f12387b, bVar.f12387b).f(this.f12386a, bVar.f12386a).h();
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends l {
        public final boolean A;
        public final boolean B;
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final int G;
        private final SparseArray H;
        private final SparseBooleanArray I;

        /* renamed from: h  reason: collision with root package name */
        public final int f12388h;

        /* renamed from: k  reason: collision with root package name */
        public final int f12389k;

        /* renamed from: l  reason: collision with root package name */
        public final int f12390l;

        /* renamed from: m  reason: collision with root package name */
        public final int f12391m;

        /* renamed from: n  reason: collision with root package name */
        public final int f12392n;

        /* renamed from: o  reason: collision with root package name */
        public final int f12393o;

        /* renamed from: p  reason: collision with root package name */
        public final int f12394p;

        /* renamed from: q  reason: collision with root package name */
        public final int f12395q;

        /* renamed from: r  reason: collision with root package name */
        public final boolean f12396r;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f12397s;

        /* renamed from: t  reason: collision with root package name */
        public final boolean f12398t;

        /* renamed from: u  reason: collision with root package name */
        public final int f12399u;

        /* renamed from: v  reason: collision with root package name */
        public final int f12400v;

        /* renamed from: w  reason: collision with root package name */
        public final boolean f12401w;

        /* renamed from: x  reason: collision with root package name */
        public final int f12402x;

        /* renamed from: y  reason: collision with root package name */
        public final int f12403y;

        /* renamed from: z  reason: collision with root package name */
        public final boolean f12404z;
        public static final c J = new d().a();
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i6) {
                return new c[i6];
            }
        }

        c(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z5, boolean z6, boolean z7, int i14, int i15, boolean z8, String str, int i16, int i17, boolean z9, boolean z10, boolean z11, boolean z12, String str2, int i18, boolean z13, int i19, boolean z14, boolean z15, boolean z16, int i20, SparseArray sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i18, z13, i19);
            this.f12388h = i6;
            this.f12389k = i7;
            this.f12390l = i8;
            this.f12391m = i9;
            this.f12392n = i10;
            this.f12393o = i11;
            this.f12394p = i12;
            this.f12395q = i13;
            this.f12396r = z5;
            this.f12397s = z6;
            this.f12398t = z7;
            this.f12399u = i14;
            this.f12400v = i15;
            this.f12401w = z8;
            this.f12402x = i16;
            this.f12403y = i17;
            this.f12404z = z9;
            this.A = z10;
            this.B = z11;
            this.C = z12;
            this.D = z14;
            this.E = z15;
            this.F = z16;
            this.G = i20;
            this.H = sparseArray;
            this.I = sparseBooleanArray;
        }

        private static boolean e(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i6)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean f(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i6));
                if (indexOfKey < 0 || !g((Map) sparseArray.valueAt(i6), (Map) sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static boolean g(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                y0 y0Var = (y0) entry.getKey();
                if (!map2.containsKey(y0Var) || !com.google.android.exoplayer2.util.s0.c(entry.getValue(), map2.get(y0Var))) {
                    return false;
                }
                while (r4.hasNext()) {
                }
            }
            return true;
        }

        public static c h(Context context) {
            return new d(context).a();
        }

        private static SparseArray l(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray sparseArray = new SparseArray(readInt);
            for (int i6 = 0; i6 < readInt; i6++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i7 = 0; i7 < readInt3; i7++) {
                    hashMap.put((y0) com.google.android.exoplayer2.util.a.e((y0) parcel.readParcelable(y0.class.getClassLoader())), (e) parcel.readParcelable(e.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void m(Parcel parcel, SparseArray sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = sparseArray.keyAt(i6);
                Map map = (Map) sparseArray.valueAt(i6);
                int size2 = map.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : map.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        @Override // o2.l, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // o2.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return super.equals(obj) && this.f12388h == cVar.f12388h && this.f12389k == cVar.f12389k && this.f12390l == cVar.f12390l && this.f12391m == cVar.f12391m && this.f12392n == cVar.f12392n && this.f12393o == cVar.f12393o && this.f12394p == cVar.f12394p && this.f12395q == cVar.f12395q && this.f12396r == cVar.f12396r && this.f12397s == cVar.f12397s && this.f12398t == cVar.f12398t && this.f12401w == cVar.f12401w && this.f12399u == cVar.f12399u && this.f12400v == cVar.f12400v && this.f12402x == cVar.f12402x && this.f12403y == cVar.f12403y && this.f12404z == cVar.f12404z && this.A == cVar.A && this.B == cVar.B && this.C == cVar.C && this.D == cVar.D && this.E == cVar.E && this.F == cVar.F && this.G == cVar.G && e(this.I, cVar.I) && f(this.H, cVar.H);
        }

        @Override // o2.l
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.f12388h) * 31) + this.f12389k) * 31) + this.f12390l) * 31) + this.f12391m) * 31) + this.f12392n) * 31) + this.f12393o) * 31) + this.f12394p) * 31) + this.f12395q) * 31) + (this.f12396r ? 1 : 0)) * 31) + (this.f12397s ? 1 : 0)) * 31) + (this.f12398t ? 1 : 0)) * 31) + (this.f12401w ? 1 : 0)) * 31) + this.f12399u) * 31) + this.f12400v) * 31) + this.f12402x) * 31) + this.f12403y) * 31) + (this.f12404z ? 1 : 0)) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + this.G;
        }

        public final boolean i(int i6) {
            return this.I.get(i6);
        }

        public final e j(int i6, y0 y0Var) {
            Map map = (Map) this.H.get(i6);
            if (map != null) {
                return (e) map.get(y0Var);
            }
            return null;
        }

        public final boolean k(int i6, y0 y0Var) {
            Map map = (Map) this.H.get(i6);
            return map != null && map.containsKey(y0Var);
        }

        @Override // o2.l, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f12388h);
            parcel.writeInt(this.f12389k);
            parcel.writeInt(this.f12390l);
            parcel.writeInt(this.f12391m);
            parcel.writeInt(this.f12392n);
            parcel.writeInt(this.f12393o);
            parcel.writeInt(this.f12394p);
            parcel.writeInt(this.f12395q);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.f12396r);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.f12397s);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.f12398t);
            parcel.writeInt(this.f12399u);
            parcel.writeInt(this.f12400v);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.f12401w);
            parcel.writeInt(this.f12402x);
            parcel.writeInt(this.f12403y);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.f12404z);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.A);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.B);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.C);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.D);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.E);
            com.google.android.exoplayer2.util.s0.X0(parcel, this.F);
            parcel.writeInt(this.G);
            m(parcel, this.H);
            parcel.writeSparseBooleanArray(this.I);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f12388h = parcel.readInt();
            this.f12389k = parcel.readInt();
            this.f12390l = parcel.readInt();
            this.f12391m = parcel.readInt();
            this.f12392n = parcel.readInt();
            this.f12393o = parcel.readInt();
            this.f12394p = parcel.readInt();
            this.f12395q = parcel.readInt();
            this.f12396r = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.f12397s = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.f12398t = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.f12399u = parcel.readInt();
            this.f12400v = parcel.readInt();
            this.f12401w = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.f12402x = parcel.readInt();
            this.f12403y = parcel.readInt();
            this.f12404z = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.A = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.B = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.C = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.D = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.E = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.F = com.google.android.exoplayer2.util.s0.D0(parcel);
            this.G = parcel.readInt();
            this.H = l(parcel);
            this.I = (SparseBooleanArray) com.google.android.exoplayer2.util.s0.j(parcel.readSparseBooleanArray());
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends l.b {
        private boolean A;
        private boolean B;
        private int C;
        private final SparseArray D;
        private final SparseBooleanArray E;

        /* renamed from: f  reason: collision with root package name */
        private int f12405f;

        /* renamed from: g  reason: collision with root package name */
        private int f12406g;

        /* renamed from: h  reason: collision with root package name */
        private int f12407h;

        /* renamed from: i  reason: collision with root package name */
        private int f12408i;

        /* renamed from: j  reason: collision with root package name */
        private int f12409j;

        /* renamed from: k  reason: collision with root package name */
        private int f12410k;

        /* renamed from: l  reason: collision with root package name */
        private int f12411l;

        /* renamed from: m  reason: collision with root package name */
        private int f12412m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f12413n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f12414o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f12415p;

        /* renamed from: q  reason: collision with root package name */
        private int f12416q;

        /* renamed from: r  reason: collision with root package name */
        private int f12417r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f12418s;

        /* renamed from: t  reason: collision with root package name */
        private int f12419t;

        /* renamed from: u  reason: collision with root package name */
        private int f12420u;

        /* renamed from: v  reason: collision with root package name */
        private boolean f12421v;

        /* renamed from: w  reason: collision with root package name */
        private boolean f12422w;

        /* renamed from: x  reason: collision with root package name */
        private boolean f12423x;

        /* renamed from: y  reason: collision with root package name */
        private boolean f12424y;

        /* renamed from: z  reason: collision with root package name */
        private boolean f12425z;

        public d() {
            e();
            this.D = new SparseArray();
            this.E = new SparseBooleanArray();
        }

        private void e() {
            this.f12405f = Integer.MAX_VALUE;
            this.f12406g = Integer.MAX_VALUE;
            this.f12407h = Integer.MAX_VALUE;
            this.f12408i = Integer.MAX_VALUE;
            this.f12413n = true;
            this.f12414o = false;
            this.f12415p = true;
            this.f12416q = Integer.MAX_VALUE;
            this.f12417r = Integer.MAX_VALUE;
            this.f12418s = true;
            this.f12419t = Integer.MAX_VALUE;
            this.f12420u = Integer.MAX_VALUE;
            this.f12421v = true;
            this.f12422w = false;
            this.f12423x = false;
            this.f12424y = false;
            this.f12425z = false;
            this.A = false;
            this.B = true;
            this.C = 0;
        }

        @Override // o2.l.b
        /* renamed from: d */
        public c a() {
            return new c(this.f12405f, this.f12406g, this.f12407h, this.f12408i, this.f12409j, this.f12410k, this.f12411l, this.f12412m, this.f12413n, this.f12414o, this.f12415p, this.f12416q, this.f12417r, this.f12418s, this.f12470a, this.f12419t, this.f12420u, this.f12421v, this.f12422w, this.f12423x, this.f12424y, this.f12471b, this.f12472c, this.f12473d, this.f12474e, this.f12425z, this.A, this.B, this.C, this.D, this.E);
        }

        @Override // o2.l.b
        /* renamed from: f */
        public d b(Context context) {
            super.b(context);
            return this;
        }

        public d g(int i6, int i7, boolean z5) {
            this.f12416q = i6;
            this.f12417r = i7;
            this.f12418s = z5;
            return this;
        }

        public d h(Context context, boolean z5) {
            Point M = com.google.android.exoplayer2.util.s0.M(context);
            return g(M.x, M.y, z5);
        }

        public d(Context context) {
            super(context);
            e();
            this.D = new SparseArray();
            this.E = new SparseBooleanArray();
            h(context, true);
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final int f12426a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f12427b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12428c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12429d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12430e;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public e[] newArray(int i6) {
                return new e[i6];
            }
        }

        public e(int i6, int... iArr) {
            this(i6, iArr, 2, 0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean e(int i6) {
            for (int i7 : this.f12427b) {
                if (i7 == i6) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f12426a == eVar.f12426a && Arrays.equals(this.f12427b, eVar.f12427b) && this.f12429d == eVar.f12429d && this.f12430e == eVar.f12430e;
        }

        public int hashCode() {
            return (((((this.f12426a * 31) + Arrays.hashCode(this.f12427b)) * 31) + this.f12429d) * 31) + this.f12430e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f12426a);
            parcel.writeInt(this.f12427b.length);
            parcel.writeIntArray(this.f12427b);
            parcel.writeInt(this.f12429d);
            parcel.writeInt(this.f12430e);
        }

        public e(int i6, int[] iArr, int i7, int i8) {
            this.f12426a = i6;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f12427b = copyOf;
            this.f12428c = iArr.length;
            this.f12429d = i7;
            this.f12430e = i8;
            Arrays.sort(copyOf);
        }

        e(Parcel parcel) {
            this.f12426a = parcel.readInt();
            int readByte = parcel.readByte();
            this.f12428c = readByte;
            int[] iArr = new int[readByte];
            this.f12427b = iArr;
            parcel.readIntArray(iArr);
            this.f12429d = parcel.readInt();
            this.f12430e = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o2.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0202f implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f12431a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f12432b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f12433c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f12434d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12435e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12436f;

        /* renamed from: g  reason: collision with root package name */
        private final int f12437g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f12438h;

        public C0202f(s0 s0Var, c cVar, int i6, String str) {
            boolean z5 = false;
            this.f12432b = f.t(i6, false);
            int i7 = s0Var.f4048d & (~cVar.f12469e);
            boolean z6 = (i7 & 1) != 0;
            this.f12433c = z6;
            boolean z7 = (i7 & 2) != 0;
            this.f12434d = z7;
            int q5 = f.q(s0Var, cVar.f12466b, cVar.f12468d);
            this.f12435e = q5;
            int bitCount = Integer.bitCount(s0Var.f4049e & cVar.f12467c);
            this.f12436f = bitCount;
            this.f12438h = (s0Var.f4049e & 1088) != 0;
            int q6 = f.q(s0Var, str, f.z(str) == null);
            this.f12437g = q6;
            if (q5 > 0 || ((cVar.f12466b == null && bitCount > 0) || z6 || (z7 && q6 > 0))) {
                z5 = true;
            }
            this.f12431a = z5;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0202f c0202f) {
            com.google.common.collect.n d6 = com.google.common.collect.n.i().f(this.f12432b, c0202f.f12432b).d(this.f12435e, c0202f.f12435e).d(this.f12436f, c0202f.f12436f).f(this.f12433c, c0202f.f12433c).e(Boolean.valueOf(this.f12434d), Boolean.valueOf(c0202f.f12434d), this.f12435e == 0 ? c1.natural() : c1.natural().reverse()).d(this.f12437g, c0202f.f12437g);
            if (this.f12436f == 0) {
                d6 = d6.g(this.f12438h, c0202f.f12438h);
            }
            return d6.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class g implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f12439a;

        /* renamed from: b  reason: collision with root package name */
        private final c f12440b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f12441c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f12442d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12443e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12444f;

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
            if (r10 < r8.f12394p) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
            if (r10 < r8.f12395q) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public g(s0 s0Var, c cVar, int i6, boolean z5) {
            boolean z6;
            int i7;
            int i8;
            float f6;
            int i9;
            int i10;
            int i11;
            int i12;
            this.f12440b = cVar;
            boolean z7 = true;
            if (z5 && (((i10 = s0Var.f4061s) == -1 || i10 <= cVar.f12388h) && ((i11 = s0Var.f4062t) == -1 || i11 <= cVar.f12389k))) {
                float f7 = s0Var.f4063u;
                if ((f7 == -1.0f || f7 <= cVar.f12390l) && ((i12 = s0Var.f4052h) == -1 || i12 <= cVar.f12391m)) {
                    z6 = true;
                    this.f12439a = z6;
                    if (z5 && (((i7 = s0Var.f4061s) == -1 || i7 >= cVar.f12392n) && ((i8 = s0Var.f4062t) == -1 || i8 >= cVar.f12393o))) {
                        f6 = s0Var.f4063u;
                        if (f6 != -1.0f) {
                        }
                        i9 = s0Var.f4052h;
                        if (i9 != -1) {
                        }
                        this.f12441c = z7;
                        this.f12442d = f.t(i6, false);
                        this.f12443e = s0Var.f4052h;
                        this.f12444f = s0Var.g();
                    }
                    z7 = false;
                    this.f12441c = z7;
                    this.f12442d = f.t(i6, false);
                    this.f12443e = s0Var.f4052h;
                    this.f12444f = s0Var.g();
                }
            }
            z6 = false;
            this.f12439a = z6;
            if (z5) {
                f6 = s0Var.f4063u;
                if (f6 != -1.0f) {
                }
                i9 = s0Var.f4052h;
                if (i9 != -1) {
                }
                this.f12441c = z7;
                this.f12442d = f.t(i6, false);
                this.f12443e = s0Var.f4052h;
                this.f12444f = s0Var.g();
            }
            z7 = false;
            this.f12441c = z7;
            this.f12442d = f.t(i6, false);
            this.f12443e = s0Var.f4052h;
            this.f12444f = s0Var.g();
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(g gVar) {
            c1 reverse = (this.f12439a && this.f12442d) ? f.f12370h : f.f12370h.reverse();
            return com.google.common.collect.n.i().f(this.f12442d, gVar.f12442d).f(this.f12439a, gVar.f12439a).f(this.f12441c, gVar.f12441c).e(Integer.valueOf(this.f12443e), Integer.valueOf(gVar.f12443e), this.f12440b.D ? f.f12370h.reverse() : f.f12371i).e(Integer.valueOf(this.f12444f), Integer.valueOf(gVar.f12444f), reverse).e(Integer.valueOf(this.f12443e), Integer.valueOf(gVar.f12443e), reverse).h();
        }
    }

    public f(Context context) {
        this(context, new a.d());
    }

    private static boolean A(int[][] iArr, y0 y0Var, j jVar) {
        if (jVar == null) {
            return false;
        }
        int f6 = y0Var.f(jVar.k());
        for (int i6 = 0; i6 < jVar.length(); i6++) {
            if (o1.f(iArr[f6][jVar.f(i6)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private static j.a B(y0 y0Var, int[][] iArr, int i6, c cVar) {
        y0 y0Var2 = y0Var;
        c cVar2 = cVar;
        int i7 = cVar2.f12398t ? 24 : 16;
        boolean z5 = cVar2.f12397s && (i6 & i7) != 0;
        int i8 = 0;
        while (i8 < y0Var2.f14101a) {
            x0 e6 = y0Var2.e(i8);
            int i9 = i8;
            int[] p5 = p(e6, iArr[i8], z5, i7, cVar2.f12388h, cVar2.f12389k, cVar2.f12390l, cVar2.f12391m, cVar2.f12392n, cVar2.f12393o, cVar2.f12394p, cVar2.f12395q, cVar2.f12399u, cVar2.f12400v, cVar2.f12401w);
            if (p5.length > 0) {
                return new j.a(e6, p5);
            }
            i8 = i9 + 1;
            y0Var2 = y0Var;
            cVar2 = cVar;
        }
        return null;
    }

    private static j.a E(y0 y0Var, int[][] iArr, c cVar) {
        int i6 = -1;
        x0 x0Var = null;
        g gVar = null;
        for (int i7 = 0; i7 < y0Var.f14101a; i7++) {
            x0 e6 = y0Var.e(i7);
            List s5 = s(e6, cVar.f12399u, cVar.f12400v, cVar.f12401w);
            int[] iArr2 = iArr[i7];
            for (int i8 = 0; i8 < e6.f14093a; i8++) {
                s0 e7 = e6.e(i8);
                if ((e7.f4049e & Http2.INITIAL_MAX_FRAME_SIZE) == 0 && t(iArr2[i8], cVar.F)) {
                    g gVar2 = new g(e7, cVar, iArr2[i8], s5.contains(Integer.valueOf(i8)));
                    if ((gVar2.f12439a || cVar.f12396r) && (gVar == null || gVar2.compareTo(gVar) > 0)) {
                        x0Var = e6;
                        i6 = i8;
                        gVar = gVar2;
                    }
                }
            }
        }
        if (x0Var == null) {
            return null;
        }
        return new j.a(x0Var, i6);
    }

    private static void m(x0 x0Var, int[] iArr, int i6, String str, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!v(x0Var.e(intValue), str, iArr[intValue], i6, i7, i8, i9, i10, i11, i12, i13, i14)) {
                list.remove(size);
            }
        }
    }

    private static int[] n(x0 x0Var, int[] iArr, int i6, int i7, boolean z5, boolean z6, boolean z7) {
        s0 e6 = x0Var.e(i6);
        int[] iArr2 = new int[x0Var.f14093a];
        int i8 = 0;
        for (int i9 = 0; i9 < x0Var.f14093a; i9++) {
            if (i9 == i6 || u(x0Var.e(i9), iArr[i9], e6, i7, z5, z6, z7)) {
                iArr2[i8] = i9;
                i8++;
            }
        }
        return Arrays.copyOf(iArr2, i8);
    }

    private static int o(x0 x0Var, int[] iArr, int i6, String str, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, List list) {
        int i15 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            int intValue = ((Integer) list.get(i16)).intValue();
            if (v(x0Var.e(intValue), str, iArr[intValue], i6, i7, i8, i9, i10, i11, i12, i13, i14)) {
                i15++;
            }
        }
        return i15;
    }

    private static int[] p(x0 x0Var, int[] iArr, boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z6) {
        String str;
        int i17;
        int i18;
        HashSet hashSet;
        if (x0Var.f14093a < 2) {
            return f12369g;
        }
        List s5 = s(x0Var, i15, i16, z6);
        if (s5.size() < 2) {
            return f12369g;
        }
        if (z5) {
            str = null;
        } else {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i19 = 0;
            int i20 = 0;
            while (i20 < s5.size()) {
                String str3 = x0Var.e(((Integer) s5.get(i20)).intValue()).f4056n;
                if (hashSet2.add(str3)) {
                    i17 = i19;
                    i18 = i20;
                    hashSet = hashSet2;
                    int o5 = o(x0Var, iArr, i6, str3, i7, i8, i9, i10, i11, i12, i13, i14, s5);
                    if (o5 > i17) {
                        i19 = o5;
                        str2 = str3;
                        i20 = i18 + 1;
                        hashSet2 = hashSet;
                    }
                } else {
                    i17 = i19;
                    i18 = i20;
                    hashSet = hashSet2;
                }
                i19 = i17;
                i20 = i18 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        m(x0Var, iArr, i6, str, i7, i8, i9, i10, i11, i12, i13, i14, s5);
        return s5.size() < 2 ? f12369g : com.google.common.primitives.b.h(s5);
    }

    protected static int q(s0 s0Var, String str, boolean z5) {
        if (TextUtils.isEmpty(str) || !str.equals(s0Var.f4047c)) {
            String z6 = z(str);
            String z7 = z(s0Var.f4047c);
            if (z7 == null || z6 == null) {
                return (z5 && z7 == null) ? 1 : 0;
            } else if (z7.startsWith(z6) || z6.startsWith(z7)) {
                return 3;
            } else {
                return com.google.android.exoplayer2.util.s0.L0(z7, "-")[0].equals(com.google.android.exoplayer2.util.s0.L0(z6, "-")[0]) ? 2 : 0;
            }
        }
        return 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000d, code lost:
        if ((r6 > r7) != (r4 > r5)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Point r(boolean z5, int i6, int i7, int i8, int i9) {
        if (z5) {
        }
        i7 = i6;
        i6 = i7;
        int i10 = i8 * i6;
        int i11 = i9 * i7;
        return i10 >= i11 ? new Point(i7, com.google.android.exoplayer2.util.s0.l(i11, i8)) : new Point(com.google.android.exoplayer2.util.s0.l(i10, i9), i6);
    }

    private static List s(x0 x0Var, int i6, int i7, boolean z5) {
        int i8;
        ArrayList arrayList = new ArrayList(x0Var.f14093a);
        for (int i9 = 0; i9 < x0Var.f14093a; i9++) {
            arrayList.add(Integer.valueOf(i9));
        }
        if (i6 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < x0Var.f14093a; i11++) {
                s0 e6 = x0Var.e(i11);
                int i12 = e6.f4061s;
                if (i12 > 0 && (i8 = e6.f4062t) > 0) {
                    Point r5 = r(z5, i6, i7, i12, i8);
                    int i13 = e6.f4061s;
                    int i14 = e6.f4062t;
                    int i15 = i13 * i14;
                    if (i13 >= ((int) (r5.x * 0.98f)) && i14 >= ((int) (r5.y * 0.98f)) && i15 < i10) {
                        i10 = i15;
                    }
                }
            }
            if (i10 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int g6 = x0Var.e(((Integer) arrayList.get(size)).intValue()).g();
                    if (g6 == -1 || g6 > i10) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean t(int i6, boolean z5) {
        int d6 = o1.d(i6);
        return d6 == 4 || (z5 && d6 == 3);
    }

    private static boolean u(s0 s0Var, int i6, s0 s0Var2, int i7, boolean z5, boolean z6, boolean z7) {
        int i8;
        String str;
        int i9;
        if (t(i6, false)) {
            int i10 = s0Var.f4052h;
            if (i10 == -1 || i10 <= i7) {
                if (z7 || ((i9 = s0Var.A) != -1 && i9 == s0Var2.A)) {
                    if (z5 || ((str = s0Var.f4056n) != null && TextUtils.equals(str, s0Var2.f4056n))) {
                        return z6 || ((i8 = s0Var.B) != -1 && i8 == s0Var2.B);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean v(s0 s0Var, String str, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        if ((s0Var.f4049e & Http2.INITIAL_MAX_FRAME_SIZE) == 0 && t(i6, false) && (i6 & i7) != 0) {
            if (str == null || com.google.android.exoplayer2.util.s0.c(s0Var.f4056n, str)) {
                int i16 = s0Var.f4061s;
                if (i16 == -1 || (i12 <= i16 && i16 <= i8)) {
                    int i17 = s0Var.f4062t;
                    if (i17 == -1 || (i13 <= i17 && i17 <= i9)) {
                        float f6 = s0Var.f4063u;
                        if (f6 == -1.0f || (i14 <= f6 && f6 <= i10)) {
                            int i18 = s0Var.f4052h;
                            return i18 == -1 || (i15 <= i18 && i18 <= i11);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int w(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x(Integer num, Integer num2) {
        return 0;
    }

    private static void y(h.a aVar, int[][][] iArr, q1[] q1VarArr, j[] jVarArr, int i6) {
        boolean z5;
        if (i6 == 0) {
            return;
        }
        boolean z6 = false;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < aVar.c(); i9++) {
            int d6 = aVar.d(i9);
            j jVar = jVarArr[i9];
            if ((d6 == 1 || d6 == 2) && jVar != null && A(iArr[i9], aVar.e(i9), jVar)) {
                if (d6 == 1) {
                    if (i8 != -1) {
                        z5 = false;
                        break;
                    }
                    i8 = i9;
                } else if (i7 != -1) {
                    z5 = false;
                    break;
                } else {
                    i7 = i9;
                }
            }
        }
        z5 = true;
        if (i8 != -1 && i7 != -1) {
            z6 = true;
        }
        if (z5 && z6) {
            q1 q1Var = new q1(i6);
            q1VarArr[i8] = q1Var;
            q1VarArr[i7] = q1Var;
        }
    }

    protected static String z(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected j.a[] C(h.a aVar, int[][][] iArr, int[] iArr2, c cVar) {
        int i6;
        String str;
        int i7;
        a aVar2;
        String str2;
        int i8;
        int c6 = aVar.c();
        j.a[] aVarArr = new j.a[c6];
        int i9 = 0;
        boolean z5 = false;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= c6) {
                break;
            }
            if (2 == aVar.d(i10)) {
                if (!z5) {
                    j.a H = H(aVar.e(i10), iArr[i10], iArr2[i10], cVar, true);
                    aVarArr[i10] = H;
                    z5 = H != null;
                }
                i11 |= aVar.e(i10).f14101a <= 0 ? 0 : 1;
            }
            i10++;
        }
        a aVar3 = null;
        String str3 = null;
        int i12 = -1;
        int i13 = 0;
        while (i13 < c6) {
            if (i6 == aVar.d(i13)) {
                i7 = i12;
                aVar2 = aVar3;
                str2 = str3;
                i8 = i13;
                Pair D = D(aVar.e(i13), iArr[i13], iArr2[i13], cVar, this.f12374f || i11 == 0);
                if (D != null && (aVar2 == null || ((a) D.second).compareTo(aVar2) > 0)) {
                    if (i7 != -1) {
                        aVarArr[i7] = null;
                    }
                    j.a aVar4 = (j.a) D.first;
                    aVarArr[i8] = aVar4;
                    str3 = aVar4.f12456a.e(aVar4.f12457b[0]).f4047c;
                    aVar3 = (a) D.second;
                    i12 = i8;
                    i13 = i8 + 1;
                    i6 = 1;
                }
            } else {
                i7 = i12;
                aVar2 = aVar3;
                str2 = str3;
                i8 = i13;
            }
            i12 = i7;
            aVar3 = aVar2;
            str3 = str2;
            i13 = i8 + 1;
            i6 = 1;
        }
        String str4 = str3;
        C0202f c0202f = null;
        int i14 = -1;
        while (i9 < c6) {
            int d6 = aVar.d(i9);
            if (d6 != 1) {
                if (d6 != 2) {
                    if (d6 != 3) {
                        aVarArr[i9] = F(d6, aVar.e(i9), iArr[i9], cVar);
                    } else {
                        str = str4;
                        Pair G = G(aVar.e(i9), iArr[i9], cVar, str);
                        if (G != null && (c0202f == null || ((C0202f) G.second).compareTo(c0202f) > 0)) {
                            if (i14 != -1) {
                                aVarArr[i14] = null;
                            }
                            aVarArr[i9] = (j.a) G.first;
                            c0202f = (C0202f) G.second;
                            i14 = i9;
                        }
                    }
                }
                str = str4;
            } else {
                str = str4;
            }
            i9++;
            str4 = str;
        }
        return aVarArr;
    }

    protected Pair D(y0 y0Var, int[][] iArr, int i6, c cVar, boolean z5) {
        j.a aVar = null;
        a aVar2 = null;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < y0Var.f14101a; i9++) {
            x0 e6 = y0Var.e(i9);
            int[] iArr2 = iArr[i9];
            for (int i10 = 0; i10 < e6.f14093a; i10++) {
                if (t(iArr2[i10], cVar.F)) {
                    a aVar3 = new a(e6.e(i10), cVar, iArr2[i10]);
                    if ((aVar3.f12375a || cVar.f12404z) && (aVar2 == null || aVar3.compareTo(aVar2) > 0)) {
                        i7 = i9;
                        i8 = i10;
                        aVar2 = aVar3;
                    }
                }
            }
        }
        if (i7 == -1) {
            return null;
        }
        x0 e7 = y0Var.e(i7);
        if (!cVar.E && !cVar.D && z5) {
            int[] n5 = n(e7, iArr[i7], i8, cVar.f12403y, cVar.A, cVar.B, cVar.C);
            if (n5.length > 1) {
                aVar = new j.a(e7, n5);
            }
        }
        if (aVar == null) {
            aVar = new j.a(e7, i8);
        }
        return Pair.create(aVar, (a) com.google.android.exoplayer2.util.a.e(aVar2));
    }

    protected j.a F(int i6, y0 y0Var, int[][] iArr, c cVar) {
        x0 x0Var = null;
        b bVar = null;
        int i7 = 0;
        for (int i8 = 0; i8 < y0Var.f14101a; i8++) {
            x0 e6 = y0Var.e(i8);
            int[] iArr2 = iArr[i8];
            for (int i9 = 0; i9 < e6.f14093a; i9++) {
                if (t(iArr2[i9], cVar.F)) {
                    b bVar2 = new b(e6.e(i9), iArr2[i9]);
                    if (bVar == null || bVar2.compareTo(bVar) > 0) {
                        x0Var = e6;
                        i7 = i9;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (x0Var == null) {
            return null;
        }
        return new j.a(x0Var, i7);
    }

    protected Pair G(y0 y0Var, int[][] iArr, c cVar, String str) {
        int i6 = -1;
        x0 x0Var = null;
        C0202f c0202f = null;
        for (int i7 = 0; i7 < y0Var.f14101a; i7++) {
            x0 e6 = y0Var.e(i7);
            int[] iArr2 = iArr[i7];
            for (int i8 = 0; i8 < e6.f14093a; i8++) {
                if (t(iArr2[i8], cVar.F)) {
                    C0202f c0202f2 = new C0202f(e6.e(i8), cVar, iArr2[i8], str);
                    if (c0202f2.f12431a && (c0202f == null || c0202f2.compareTo(c0202f) > 0)) {
                        x0Var = e6;
                        i6 = i8;
                        c0202f = c0202f2;
                    }
                }
            }
        }
        if (x0Var == null) {
            return null;
        }
        return Pair.create(new j.a(x0Var, i6), (C0202f) com.google.android.exoplayer2.util.a.e(c0202f));
    }

    protected j.a H(y0 y0Var, int[][] iArr, int i6, c cVar, boolean z5) {
        j.a B = (cVar.E || cVar.D || !z5) ? null : B(y0Var, iArr, i6, cVar);
        return B == null ? E(y0Var, iArr, cVar) : B;
    }

    @Override // o2.h
    protected final Pair h(h.a aVar, int[][][] iArr, int[] iArr2) {
        c cVar = (c) this.f12373e.get();
        int c6 = aVar.c();
        j.a[] C = C(aVar, iArr, iArr2, cVar);
        int i6 = 0;
        while (true) {
            if (i6 >= c6) {
                break;
            }
            if (cVar.i(i6)) {
                C[i6] = null;
            } else {
                y0 e6 = aVar.e(i6);
                if (cVar.k(i6, e6)) {
                    e j6 = cVar.j(i6, e6);
                    C[i6] = j6 != null ? new j.a(e6.e(j6.f12426a), j6.f12427b, j6.f12429d, Integer.valueOf(j6.f12430e)) : null;
                }
            }
            i6++;
        }
        j[] a6 = this.f12372d.a(C, a());
        q1[] q1VarArr = new q1[c6];
        for (int i7 = 0; i7 < c6; i7++) {
            q1VarArr[i7] = !cVar.i(i7) && (aVar.d(i7) == 6 || a6[i7] != null) ? q1.f4024b : null;
        }
        y(aVar, iArr, q1VarArr, a6, cVar.G);
        return Pair.create(q1VarArr, a6);
    }

    public f(Context context, j.b bVar) {
        this(c.h(context), bVar);
    }

    public f(c cVar, j.b bVar) {
        this.f12372d = bVar;
        this.f12373e = new AtomicReference(cVar);
    }
}
