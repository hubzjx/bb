package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b extends i {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f13128b;

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
        super((String) s0.j(parcel.readString()));
        this.f13128b = (byte[]) s0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13152a.equals(bVar.f13152a) && Arrays.equals(this.f13128b, bVar.f13128b);
    }

    public int hashCode() {
        return ((527 + this.f13152a.hashCode()) * 31) + Arrays.hashCode(this.f13128b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13152a);
        parcel.writeByteArray(this.f13128b);
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.f13128b = bArr;
    }
}
