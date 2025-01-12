package a2;

import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f75a;

    /* renamed from: b  reason: collision with root package name */
    public final String f76b;

    /* renamed from: c  reason: collision with root package name */
    public final String f77c;

    public d(String str, String str2, String str3) {
        this.f75a = str;
        this.f76b = str2;
        this.f77c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return s0.c(this.f75a, dVar.f75a) && s0.c(this.f76b, dVar.f76b) && s0.c(this.f77c, dVar.f77c);
    }

    public int hashCode() {
        int hashCode = this.f75a.hashCode() * 31;
        String str = this.f76b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f77c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
