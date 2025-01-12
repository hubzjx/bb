package i1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
import n1.a;
/* loaded from: classes.dex */
public final class h implements a.b {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f10951a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f10952b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10953c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10954d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public h[] newArray(int i6) {
            return new h[i6];
        }
    }

    private h(Parcel parcel) {
        this.f10951a = (String) s0.j(parcel.readString());
        this.f10952b = (byte[]) s0.j(parcel.createByteArray());
        this.f10953c = parcel.readInt();
        this.f10954d = parcel.readInt();
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
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f10951a.equals(hVar.f10951a) && Arrays.equals(this.f10952b, hVar.f10952b) && this.f10953c == hVar.f10953c && this.f10954d == hVar.f10954d;
    }

    public int hashCode() {
        return ((((((527 + this.f10951a.hashCode()) * 31) + Arrays.hashCode(this.f10952b)) * 31) + this.f10953c) * 31) + this.f10954d;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f10951a);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f10951a);
        parcel.writeByteArray(this.f10952b);
        parcel.writeInt(this.f10953c);
        parcel.writeInt(this.f10954d);
    }

    /* synthetic */ h(Parcel parcel, a aVar) {
        this(parcel);
    }

    public h(String str, byte[] bArr, int i6, int i7) {
        this.f10951a = str;
        this.f10952b = bArr;
        this.f10953c = i6;
        this.f10954d = i7;
    }
}
