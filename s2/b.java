package s2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f13172a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13173b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13174c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f13175d;

    /* renamed from: e  reason: collision with root package name */
    private int f13176e;

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

    public b(int i6, int i7, int i8, byte[] bArr) {
        this.f13172a = i6;
        this.f13173b = i7;
        this.f13174c = i8;
        this.f13175d = bArr;
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
        return this.f13172a == bVar.f13172a && this.f13173b == bVar.f13173b && this.f13174c == bVar.f13174c && Arrays.equals(this.f13175d, bVar.f13175d);
    }

    public int hashCode() {
        if (this.f13176e == 0) {
            this.f13176e = ((((((527 + this.f13172a) * 31) + this.f13173b) * 31) + this.f13174c) * 31) + Arrays.hashCode(this.f13175d);
        }
        return this.f13176e;
    }

    public String toString() {
        int i6 = this.f13172a;
        int i7 = this.f13173b;
        int i8 = this.f13174c;
        boolean z5 = this.f13175d != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i6);
        sb.append(", ");
        sb.append(i7);
        sb.append(", ");
        sb.append(i8);
        sb.append(", ");
        sb.append(z5);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f13172a);
        parcel.writeInt(this.f13173b);
        parcel.writeInt(this.f13174c);
        s0.X0(parcel, this.f13175d != null);
        byte[] bArr = this.f13175d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    b(Parcel parcel) {
        this.f13172a = parcel.readInt();
        this.f13173b = parcel.readInt();
        this.f13174c = parcel.readInt();
        this.f13175d = s0.D0(parcel) ? parcel.createByteArray() : null;
    }
}
