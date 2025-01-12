package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import n1.a;
/* loaded from: classes.dex */
public final class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f12706a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12707b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i6) {
            return new b[i6];
        }
    }

    b(Parcel parcel) {
        this.f12706a = (String) s0.j(parcel.readString());
        this.f12707b = (String) s0.j(parcel.readString());
    }

    @Override // n1.a.b
    public /* synthetic */ com.google.android.exoplayer2.s0 b() {
        return n1.b.b(this);
    }

    @Override // n1.a.b
    public /* synthetic */ byte[] d() {
        return n1.b.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12706a.equals(bVar.f12706a) && this.f12707b.equals(bVar.f12707b);
    }

    public int hashCode() {
        return ((527 + this.f12706a.hashCode()) * 31) + this.f12707b.hashCode();
    }

    public String toString() {
        String str = this.f12706a;
        String str2 = this.f12707b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length());
        sb.append("VC: ");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f12706a);
        parcel.writeString(this.f12707b);
    }

    public b(String str, String str2) {
        this.f12706a = str;
        this.f12707b = str2;
    }
}
