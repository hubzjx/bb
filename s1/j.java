package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class j extends i {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13153b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13154c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13155d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public j[] newArray(int i6) {
            return new j[i6];
        }
    }

    j(Parcel parcel) {
        super("----");
        this.f13153b = (String) s0.j(parcel.readString());
        this.f13154c = (String) s0.j(parcel.readString());
        this.f13155d = (String) s0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return s0.c(this.f13154c, jVar.f13154c) && s0.c(this.f13153b, jVar.f13153b) && s0.c(this.f13155d, jVar.f13155d);
    }

    public int hashCode() {
        String str = this.f13153b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13154c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13155d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13153b;
        String str3 = this.f13154c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": domain=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13152a);
        parcel.writeString(this.f13153b);
        parcel.writeString(this.f13155d);
    }

    public j(String str, String str2, String str3) {
        super("----");
        this.f13153b = str;
        this.f13154c = str2;
        this.f13155d = str3;
    }
}
