package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import n1.a;
/* loaded from: classes.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0207a();

    /* renamed from: a  reason: collision with root package name */
    public final int f12698a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12699b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12700c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12701d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12702e;

    /* renamed from: f  reason: collision with root package name */
    public final int f12703f;

    /* renamed from: g  reason: collision with root package name */
    public final int f12704g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f12705h;

    /* renamed from: q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0207a implements Parcelable.Creator {
        C0207a() {
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

    public a(int i6, String str, String str2, int i7, int i8, int i9, int i10, byte[] bArr) {
        this.f12698a = i6;
        this.f12699b = str;
        this.f12700c = str2;
        this.f12701d = i7;
        this.f12702e = i8;
        this.f12703f = i9;
        this.f12704g = i10;
        this.f12705h = bArr;
    }

    @Override // n1.a.b
    public /* synthetic */ s0 b() {
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
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12698a == aVar.f12698a && this.f12699b.equals(aVar.f12699b) && this.f12700c.equals(aVar.f12700c) && this.f12701d == aVar.f12701d && this.f12702e == aVar.f12702e && this.f12703f == aVar.f12703f && this.f12704g == aVar.f12704g && Arrays.equals(this.f12705h, aVar.f12705h);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f12698a) * 31) + this.f12699b.hashCode()) * 31) + this.f12700c.hashCode()) * 31) + this.f12701d) * 31) + this.f12702e) * 31) + this.f12703f) * 31) + this.f12704g) * 31) + Arrays.hashCode(this.f12705h);
    }

    public String toString() {
        String str = this.f12699b;
        String str2 = this.f12700c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length());
        sb.append("Picture: mimeType=");
        sb.append(str);
        sb.append(", description=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f12698a);
        parcel.writeString(this.f12699b);
        parcel.writeString(this.f12700c);
        parcel.writeInt(this.f12701d);
        parcel.writeInt(this.f12702e);
        parcel.writeInt(this.f12703f);
        parcel.writeInt(this.f12704g);
        parcel.writeByteArray(this.f12705h);
    }

    a(Parcel parcel) {
        this.f12698a = parcel.readInt();
        this.f12699b = (String) com.google.android.exoplayer2.util.s0.j(parcel.readString());
        this.f12700c = (String) com.google.android.exoplayer2.util.s0.j(parcel.readString());
        this.f12701d = parcel.readInt();
        this.f12702e = parcel.readInt();
        this.f12703f = parcel.readInt();
        this.f12704g = parcel.readInt();
        this.f12705h = (byte[]) com.google.android.exoplayer2.util.s0.j(parcel.createByteArray());
    }
}
