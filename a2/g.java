package a2;

import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f88a;

    /* renamed from: b  reason: collision with root package name */
    public final String f89b;

    /* renamed from: c  reason: collision with root package name */
    public final String f90c;

    /* renamed from: d  reason: collision with root package name */
    public final String f91d;

    /* renamed from: e  reason: collision with root package name */
    public final String f92e;

    public g(String str, String str2, String str3, String str4, String str5) {
        this.f88a = str;
        this.f89b = str2;
        this.f90c = str3;
        this.f91d = str4;
        this.f92e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return s0.c(this.f88a, gVar.f88a) && s0.c(this.f89b, gVar.f89b) && s0.c(this.f90c, gVar.f90c) && s0.c(this.f91d, gVar.f91d) && s0.c(this.f92e, gVar.f92e);
    }

    public int hashCode() {
        String str = this.f88a;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f89b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f90c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f91d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f92e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
