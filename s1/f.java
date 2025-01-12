package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class f extends i {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13143b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13144c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13145d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f13146e;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f[] newArray(int i6) {
            return new f[i6];
        }
    }

    f(Parcel parcel) {
        super("GEOB");
        this.f13143b = (String) s0.j(parcel.readString());
        this.f13144c = (String) s0.j(parcel.readString());
        this.f13145d = (String) s0.j(parcel.readString());
        this.f13146e = (byte[]) s0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return s0.c(this.f13143b, fVar.f13143b) && s0.c(this.f13144c, fVar.f13144c) && s0.c(this.f13145d, fVar.f13145d) && Arrays.equals(this.f13146e, fVar.f13146e);
    }

    public int hashCode() {
        String str = this.f13143b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13144c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13145d;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f13146e);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13143b;
        String str3 = this.f13144c;
        String str4 = this.f13145d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", filename=");
        sb.append(str3);
        sb.append(", description=");
        sb.append(str4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13143b);
        parcel.writeString(this.f13144c);
        parcel.writeString(this.f13145d);
        parcel.writeByteArray(this.f13146e);
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f13143b = str;
        this.f13144c = str2;
        this.f13145d = str3;
        this.f13146e = bArr;
    }
}
