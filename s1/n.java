package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class n extends i {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13165b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13166c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public n[] newArray(int i6) {
            return new n[i6];
        }
    }

    n(Parcel parcel) {
        super((String) s0.j(parcel.readString()));
        this.f13165b = parcel.readString();
        this.f13166c = (String) s0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f13152a.equals(nVar.f13152a) && s0.c(this.f13165b, nVar.f13165b) && s0.c(this.f13166c, nVar.f13166c);
    }

    public int hashCode() {
        int hashCode = (527 + this.f13152a.hashCode()) * 31;
        String str = this.f13165b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13166c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13166c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13152a);
        parcel.writeString(this.f13165b);
        parcel.writeString(this.f13166c);
    }

    public n(String str, String str2, String str3) {
        super(str);
        this.f13165b = str2;
        this.f13166c = str3;
    }
}
