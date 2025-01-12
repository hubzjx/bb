package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class m extends i {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13163b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13164c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public m[] newArray(int i6) {
            return new m[i6];
        }
    }

    m(Parcel parcel) {
        super((String) s0.j(parcel.readString()));
        this.f13163b = parcel.readString();
        this.f13164c = (String) s0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f13152a.equals(mVar.f13152a) && s0.c(this.f13163b, mVar.f13163b) && s0.c(this.f13164c, mVar.f13164c);
    }

    public int hashCode() {
        int hashCode = (527 + this.f13152a.hashCode()) * 31;
        String str = this.f13163b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13164c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13163b;
        String str3 = this.f13164c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": value=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13152a);
        parcel.writeString(this.f13163b);
        parcel.writeString(this.f13164c);
    }

    public m(String str, String str2, String str3) {
        super(str);
        this.f13163b = str2;
        this.f13164c = str3;
    }
}
