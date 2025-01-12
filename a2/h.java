package a2;

import android.net.Uri;
import com.google.android.exoplayer2.util.m0;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final long f93a;

    /* renamed from: b  reason: collision with root package name */
    public final long f94b;

    /* renamed from: c  reason: collision with root package name */
    private final String f95c;

    /* renamed from: d  reason: collision with root package name */
    private int f96d;

    public h(String str, long j6, long j7) {
        this.f95c = str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        this.f93a = j6;
        this.f94b = j7;
    }

    public h a(h hVar, String str) {
        String c6 = c(str);
        if (hVar != null && c6.equals(hVar.c(str))) {
            long j6 = this.f94b;
            if (j6 != -1) {
                long j7 = this.f93a;
                if (j7 + j6 == hVar.f93a) {
                    long j8 = hVar.f94b;
                    return new h(c6, j7, j8 != -1 ? j6 + j8 : -1L);
                }
            }
            long j9 = hVar.f94b;
            if (j9 != -1) {
                long j10 = hVar.f93a;
                if (j10 + j9 == this.f93a) {
                    return new h(c6, j10, j6 != -1 ? j9 + j6 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return m0.d(str, this.f95c);
    }

    public String c(String str) {
        return m0.c(str, this.f95c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f93a == hVar.f93a && this.f94b == hVar.f94b && this.f95c.equals(hVar.f95c);
    }

    public int hashCode() {
        if (this.f96d == 0) {
            this.f96d = ((((527 + ((int) this.f93a)) * 31) + ((int) this.f94b)) * 31) + this.f95c.hashCode();
        }
        return this.f96d;
    }

    public String toString() {
        String str = this.f95c;
        long j6 = this.f93a;
        long j7 = this.f94b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 81);
        sb.append("RangedUri(referenceUri=");
        sb.append(str);
        sb.append(", start=");
        sb.append(j6);
        sb.append(", length=");
        sb.append(j7);
        sb.append(")");
        return sb.toString();
    }
}
