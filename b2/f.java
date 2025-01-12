package b2;

import com.google.android.exoplayer2.drm.k;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public final int f2960d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2961e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2962f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2963g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2964h;

    /* renamed from: i  reason: collision with root package name */
    public final long f2965i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2966j;

    /* renamed from: k  reason: collision with root package name */
    public final long f2967k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f2968l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f2969m;

    /* renamed from: n  reason: collision with root package name */
    public final k f2970n;

    /* renamed from: o  reason: collision with root package name */
    public final List f2971o;

    /* renamed from: p  reason: collision with root package name */
    public final long f2972p;

    /* loaded from: classes.dex */
    public static final class a implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final String f2973a;

        /* renamed from: b  reason: collision with root package name */
        public final a f2974b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2975c;

        /* renamed from: d  reason: collision with root package name */
        public final String f2976d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2977e;

        /* renamed from: f  reason: collision with root package name */
        public final long f2978f;

        /* renamed from: g  reason: collision with root package name */
        public final k f2979g;

        /* renamed from: h  reason: collision with root package name */
        public final String f2980h;

        /* renamed from: k  reason: collision with root package name */
        public final String f2981k;

        /* renamed from: l  reason: collision with root package name */
        public final long f2982l;

        /* renamed from: m  reason: collision with root package name */
        public final long f2983m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f2984n;

        public a(String str, long j6, long j7, String str2, String str3) {
            this(str, null, HttpUrl.FRAGMENT_ENCODE_SET, 0L, -1, -9223372036854775807L, null, str2, str3, j6, j7, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(Long l6) {
            if (this.f2978f > l6.longValue()) {
                return 1;
            }
            return this.f2978f < l6.longValue() ? -1 : 0;
        }

        public a(String str, a aVar, String str2, long j6, int i6, long j7, k kVar, String str3, String str4, long j8, long j9, boolean z5) {
            this.f2973a = str;
            this.f2974b = aVar;
            this.f2976d = str2;
            this.f2975c = j6;
            this.f2977e = i6;
            this.f2978f = j7;
            this.f2979g = kVar;
            this.f2980h = str3;
            this.f2981k = str4;
            this.f2982l = j8;
            this.f2983m = j9;
            this.f2984n = z5;
        }
    }

    public f(int i6, String str, List list, long j6, long j7, boolean z5, int i7, long j8, int i8, long j9, boolean z6, boolean z7, boolean z8, k kVar, List list2) {
        super(str, list, z6);
        this.f2960d = i6;
        this.f2962f = j7;
        this.f2963g = z5;
        this.f2964h = i7;
        this.f2965i = j8;
        this.f2966j = i8;
        this.f2967k = j9;
        this.f2968l = z7;
        this.f2969m = z8;
        this.f2970n = kVar;
        this.f2971o = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.f2972p = 0L;
        } else {
            a aVar = (a) list2.get(list2.size() - 1);
            this.f2972p = aVar.f2978f + aVar.f2975c;
        }
        this.f2961e = j6 == -9223372036854775807L ? -9223372036854775807L : j6 >= 0 ? j6 : this.f2972p + j6;
    }

    @Override // u1.c
    /* renamed from: b */
    public f a(List list) {
        return this;
    }

    public f c(long j6, int i6) {
        return new f(this.f2960d, this.f2985a, this.f2986b, this.f2961e, j6, true, i6, this.f2965i, this.f2966j, this.f2967k, this.f2987c, this.f2968l, this.f2969m, this.f2970n, this.f2971o);
    }

    public f d() {
        return this.f2968l ? this : new f(this.f2960d, this.f2985a, this.f2986b, this.f2961e, this.f2962f, this.f2963g, this.f2964h, this.f2965i, this.f2966j, this.f2967k, this.f2987c, true, this.f2969m, this.f2970n, this.f2971o);
    }

    public long e() {
        return this.f2962f + this.f2972p;
    }

    public boolean f(f fVar) {
        if (fVar != null) {
            long j6 = this.f2965i;
            long j7 = fVar.f2965i;
            if (j6 > j7) {
                return true;
            }
            if (j6 < j7) {
                return false;
            }
            int size = this.f2971o.size();
            int size2 = fVar.f2971o.size();
            if (size <= size2) {
                return size == size2 && this.f2968l && !fVar.f2968l;
            }
            return true;
        }
        return true;
    }
}
