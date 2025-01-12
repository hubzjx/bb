package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import n1.a;
/* loaded from: classes.dex */
public final class c implements a.b {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f12925a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12926b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12927c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c[] newArray(int i6) {
            return new c[i6];
        }
    }

    c(Parcel parcel) {
        this.f12925a = (byte[]) com.google.android.exoplayer2.util.a.e(parcel.createByteArray());
        this.f12926b = parcel.readString();
        this.f12927c = parcel.readString();
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
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f12925a, ((c) obj).f12925a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12925a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f12926b, this.f12927c, Integer.valueOf(this.f12925a.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeByteArray(this.f12925a);
        parcel.writeString(this.f12926b);
        parcel.writeString(this.f12927c);
    }

    public c(byte[] bArr, String str, String str2) {
        this.f12925a = bArr;
        this.f12926b = str;
        this.f12927c = str2;
    }
}
