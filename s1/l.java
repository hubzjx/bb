package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class l extends i {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13161b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f13162c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public l[] newArray(int i6) {
            return new l[i6];
        }
    }

    l(Parcel parcel) {
        super("PRIV");
        this.f13161b = (String) s0.j(parcel.readString());
        this.f13162c = (byte[]) s0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return s0.c(this.f13161b, lVar.f13161b) && Arrays.equals(this.f13162c, lVar.f13162c);
    }

    public int hashCode() {
        String str = this.f13161b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f13162c);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13161b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": owner=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13161b);
        parcel.writeByteArray(this.f13162c);
    }

    public l(String str, byte[] bArr) {
        super("PRIV");
        this.f13161b = str;
        this.f13162c = bArr;
    }
}
