package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a extends i {
    public static final Parcelable.Creator<a> CREATOR = new C0214a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13124b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13125c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13126d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f13127e;

    /* renamed from: s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0214a implements Parcelable.Creator {
        C0214a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    a(Parcel parcel) {
        super("APIC");
        this.f13124b = (String) s0.j(parcel.readString());
        this.f13125c = parcel.readString();
        this.f13126d = parcel.readInt();
        this.f13127e = (byte[]) s0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13126d == aVar.f13126d && s0.c(this.f13124b, aVar.f13124b) && s0.c(this.f13125c, aVar.f13125c) && Arrays.equals(this.f13127e, aVar.f13127e);
    }

    public int hashCode() {
        int i6 = (527 + this.f13126d) * 31;
        String str = this.f13124b;
        int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13125c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f13127e);
    }

    @Override // s1.i
    public String toString() {
        String str = this.f13152a;
        String str2 = this.f13124b;
        String str3 = this.f13125c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13124b);
        parcel.writeString(this.f13125c);
        parcel.writeInt(this.f13126d);
        parcel.writeByteArray(this.f13127e);
    }

    public a(String str, String str2, int i6, byte[] bArr) {
        super("APIC");
        this.f13124b = str;
        this.f13125c = str2;
        this.f13126d = i6;
        this.f13127e = bArr;
    }
}
