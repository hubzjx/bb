package x1;

import android.net.Uri;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f14181f = new a(new long[0]);

    /* renamed from: a  reason: collision with root package name */
    public final int f14182a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f14183b;

    /* renamed from: c  reason: collision with root package name */
    public final C0225a[] f14184c;

    /* renamed from: d  reason: collision with root package name */
    public final long f14185d;

    /* renamed from: e  reason: collision with root package name */
    public final long f14186e;

    /* renamed from: x1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0225a {

        /* renamed from: a  reason: collision with root package name */
        public final int f14187a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri[] f14188b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f14189c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f14190d;

        public C0225a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        public int a() {
            return b(-1);
        }

        public int b(int i6) {
            int i7;
            int i8 = i6 + 1;
            while (true) {
                int[] iArr = this.f14189c;
                if (i8 >= iArr.length || (i7 = iArr[i8]) == 0 || i7 == 1) {
                    break;
                }
                i8++;
            }
            return i8;
        }

        public boolean c() {
            return this.f14187a == -1 || a() < this.f14187a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0225a.class != obj.getClass()) {
                return false;
            }
            C0225a c0225a = (C0225a) obj;
            return this.f14187a == c0225a.f14187a && Arrays.equals(this.f14188b, c0225a.f14188b) && Arrays.equals(this.f14189c, c0225a.f14189c) && Arrays.equals(this.f14190d, c0225a.f14190d);
        }

        public int hashCode() {
            return (((((this.f14187a * 31) + Arrays.hashCode(this.f14188b)) * 31) + Arrays.hashCode(this.f14189c)) * 31) + Arrays.hashCode(this.f14190d);
        }

        private C0225a(int i6, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.google.android.exoplayer2.util.a.a(iArr.length == uriArr.length);
            this.f14187a = i6;
            this.f14189c = iArr;
            this.f14188b = uriArr;
            this.f14190d = jArr;
        }
    }

    public a(long... jArr) {
        int length = jArr.length;
        this.f14182a = length;
        this.f14183b = Arrays.copyOf(jArr, length);
        this.f14184c = new C0225a[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.f14184c[i6] = new C0225a();
        }
        this.f14185d = 0L;
        this.f14186e = -9223372036854775807L;
    }

    private boolean c(long j6, long j7, int i6) {
        if (j6 == Long.MIN_VALUE) {
            return false;
        }
        long j8 = this.f14183b[i6];
        return j8 == Long.MIN_VALUE ? j7 == -9223372036854775807L || j6 < j7 : j6 < j8;
    }

    public int a(long j6, long j7) {
        if (j6 != Long.MIN_VALUE) {
            if (j7 == -9223372036854775807L || j6 < j7) {
                int i6 = 0;
                while (true) {
                    long[] jArr = this.f14183b;
                    if (i6 >= jArr.length) {
                        break;
                    }
                    long j8 = jArr[i6];
                    if (j8 == Long.MIN_VALUE || (j6 < j8 && this.f14184c[i6].c())) {
                        break;
                    }
                    i6++;
                }
                if (i6 < this.f14183b.length) {
                    return i6;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public int b(long j6, long j7) {
        int length = this.f14183b.length - 1;
        while (length >= 0 && c(j6, j7, length)) {
            length--;
        }
        if (length < 0 || !this.f14184c[length].c()) {
            return -1;
        }
        return length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14182a == aVar.f14182a && this.f14185d == aVar.f14185d && this.f14186e == aVar.f14186e && Arrays.equals(this.f14183b, aVar.f14183b) && Arrays.equals(this.f14184c, aVar.f14184c);
    }

    public int hashCode() {
        return (((((((this.f14182a * 31) + ((int) this.f14185d)) * 31) + ((int) this.f14186e)) * 31) + Arrays.hashCode(this.f14183b)) * 31) + Arrays.hashCode(this.f14184c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adResumePositionUs=");
        sb.append(this.f14185d);
        sb.append(", adGroups=[");
        for (int i6 = 0; i6 < this.f14184c.length; i6++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f14183b[i6]);
            sb.append(", ads=[");
            for (int i7 = 0; i7 < this.f14184c[i6].f14189c.length; i7++) {
                sb.append("ad(state=");
                int i8 = this.f14184c[i6].f14189c[i7];
                sb.append(i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? '?' : '!' : 'P' : 'S' : 'R' : '_');
                sb.append(", durationUs=");
                sb.append(this.f14184c[i6].f14190d[i7]);
                sb.append(')');
                if (i7 < this.f14184c[i6].f14189c.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i6 < this.f14184c.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
