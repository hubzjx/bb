package u1;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class e implements Comparable, Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f13428a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13429b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13430c;

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

    public e(int i6, int i7, int i8) {
        this.f13428a = i6;
        this.f13429b = i7;
        this.f13430c = i8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(e eVar) {
        int i6 = this.f13428a - eVar.f13428a;
        if (i6 == 0) {
            int i7 = this.f13429b - eVar.f13429b;
            return i7 == 0 ? this.f13430c - eVar.f13430c : i7;
        }
        return i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f13428a == eVar.f13428a && this.f13429b == eVar.f13429b && this.f13430c == eVar.f13430c;
    }

    public int hashCode() {
        return (((this.f13428a * 31) + this.f13429b) * 31) + this.f13430c;
    }

    public String toString() {
        int i6 = this.f13428a;
        int i7 = this.f13429b;
        int i8 = this.f13430c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i6);
        sb.append(".");
        sb.append(i7);
        sb.append(".");
        sb.append(i8);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f13428a);
        parcel.writeInt(this.f13429b);
        parcel.writeInt(this.f13430c);
    }

    e(Parcel parcel) {
        this.f13428a = parcel.readInt();
        this.f13429b = parcel.readInt();
        this.f13430c = parcel.readInt();
    }
}
