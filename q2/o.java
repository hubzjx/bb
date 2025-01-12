package q2;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f12794a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12795b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12796c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f12797d;

    /* renamed from: e  reason: collision with root package name */
    public final Map f12798e;

    /* renamed from: f  reason: collision with root package name */
    public final long f12799f;

    /* renamed from: g  reason: collision with root package name */
    public final long f12800g;

    /* renamed from: h  reason: collision with root package name */
    public final long f12801h;

    /* renamed from: i  reason: collision with root package name */
    public final String f12802i;

    /* renamed from: j  reason: collision with root package name */
    public final int f12803j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f12804k;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Uri f12805a;

        /* renamed from: b  reason: collision with root package name */
        private long f12806b;

        /* renamed from: c  reason: collision with root package name */
        private int f12807c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f12808d;

        /* renamed from: e  reason: collision with root package name */
        private Map f12809e;

        /* renamed from: f  reason: collision with root package name */
        private long f12810f;

        /* renamed from: g  reason: collision with root package name */
        private long f12811g;

        /* renamed from: h  reason: collision with root package name */
        private String f12812h;

        /* renamed from: i  reason: collision with root package name */
        private int f12813i;

        /* renamed from: j  reason: collision with root package name */
        private Object f12814j;

        public b() {
            this.f12807c = 1;
            this.f12809e = Collections.emptyMap();
            this.f12811g = -1L;
        }

        public o a() {
            com.google.android.exoplayer2.util.a.j(this.f12805a, "The uri must be set.");
            return new o(this.f12805a, this.f12806b, this.f12807c, this.f12808d, this.f12809e, this.f12810f, this.f12811g, this.f12812h, this.f12813i, this.f12814j);
        }

        public b b(int i6) {
            this.f12813i = i6;
            return this;
        }

        public b c(byte[] bArr) {
            this.f12808d = bArr;
            return this;
        }

        public b d(int i6) {
            this.f12807c = i6;
            return this;
        }

        public b e(Map map) {
            this.f12809e = map;
            return this;
        }

        public b f(String str) {
            this.f12812h = str;
            return this;
        }

        public b g(long j6) {
            this.f12811g = j6;
            return this;
        }

        public b h(long j6) {
            this.f12810f = j6;
            return this;
        }

        public b i(Uri uri) {
            this.f12805a = uri;
            return this;
        }

        public b j(String str) {
            this.f12805a = Uri.parse(str);
            return this;
        }

        public b k(long j6) {
            this.f12806b = j6;
            return this;
        }

        private b(o oVar) {
            this.f12805a = oVar.f12794a;
            this.f12806b = oVar.f12795b;
            this.f12807c = oVar.f12796c;
            this.f12808d = oVar.f12797d;
            this.f12809e = oVar.f12798e;
            this.f12810f = oVar.f12800g;
            this.f12811g = oVar.f12801h;
            this.f12812h = oVar.f12802i;
            this.f12813i = oVar.f12803j;
            this.f12814j = oVar.f12804k;
        }
    }

    public o(Uri uri) {
        this(uri, 0L, -1L);
    }

    public static String c(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return "HEAD";
                }
                throw new IllegalStateException();
            }
            return "POST";
        }
        return "GET";
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f12796c);
    }

    public boolean d(int i6) {
        return (this.f12803j & i6) == i6;
    }

    public o e(long j6) {
        long j7 = this.f12801h;
        return f(j6, j7 != -1 ? j7 - j6 : -1L);
    }

    public o f(long j6, long j7) {
        return (j6 == 0 && this.f12801h == j7) ? this : new o(this.f12794a, this.f12795b, this.f12796c, this.f12797d, this.f12798e, this.f12800g + j6, j7, this.f12802i, this.f12803j, this.f12804k);
    }

    public String toString() {
        String b6 = b();
        String valueOf = String.valueOf(this.f12794a);
        long j6 = this.f12800g;
        long j7 = this.f12801h;
        String str = this.f12802i;
        int i6 = this.f12803j;
        StringBuilder sb = new StringBuilder(String.valueOf(b6).length() + 70 + valueOf.length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(b6);
        sb.append(" ");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(j6);
        sb.append(", ");
        sb.append(j7);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i6);
        sb.append("]");
        return sb.toString();
    }

    private o(Uri uri, long j6, int i6, byte[] bArr, Map map, long j7, long j8, String str, int i7, Object obj) {
        byte[] bArr2 = bArr;
        long j9 = j6 + j7;
        boolean z5 = true;
        com.google.android.exoplayer2.util.a.a(j9 >= 0);
        com.google.android.exoplayer2.util.a.a(j7 >= 0);
        if (j8 <= 0 && j8 != -1) {
            z5 = false;
        }
        com.google.android.exoplayer2.util.a.a(z5);
        this.f12794a = uri;
        this.f12795b = j6;
        this.f12796c = i6;
        this.f12797d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f12798e = Collections.unmodifiableMap(new HashMap(map));
        this.f12800g = j7;
        this.f12799f = j9;
        this.f12801h = j8;
        this.f12802i = str;
        this.f12803j = i7;
        this.f12804k = obj;
    }

    public o(Uri uri, long j6, long j7) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j6, j7, null, 0, null);
    }
}
