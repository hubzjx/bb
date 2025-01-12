package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class e extends i {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13140b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13141c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13142d;

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

    e(Parcel parcel) {
        super("COMM");
        this.f13140b = (String) s0.j(parcel.readString());
        this.f13141c = (String) s0.j(parcel.readString());
        this.f13142d = (String) s0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return s0.c(this.f13141c, eVar.f13141c) && s0.c(this.f13140b, eVar.f13140b) && s0.c(this.f13142d, eVar.f13142d);
    }

    public int hashCode() {
        String str = this.f13140b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13141c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13142d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13140b;
        String str3 = this.f13141c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": language=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13152a);
        parcel.writeString(this.f13140b);
        parcel.writeString(this.f13142d);
    }

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f13140b = str;
        this.f13141c = str2;
        this.f13142d = str3;
    }
}
