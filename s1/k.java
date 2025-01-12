package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class k extends i {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f13156b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13157c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13158d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f13159e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f13160f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public k[] newArray(int i6) {
            return new k[i6];
        }
    }

    public k(int i6, int i7, int i8, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f13156b = i6;
        this.f13157c = i7;
        this.f13158d = i8;
        this.f13159e = iArr;
        this.f13160f = iArr2;
    }

    @Override // s1.i, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f13156b == kVar.f13156b && this.f13157c == kVar.f13157c && this.f13158d == kVar.f13158d && Arrays.equals(this.f13159e, kVar.f13159e) && Arrays.equals(this.f13160f, kVar.f13160f);
    }

    public int hashCode() {
        return ((((((((527 + this.f13156b) * 31) + this.f13157c) * 31) + this.f13158d) * 31) + Arrays.hashCode(this.f13159e)) * 31) + Arrays.hashCode(this.f13160f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f13156b);
        parcel.writeInt(this.f13157c);
        parcel.writeInt(this.f13158d);
        parcel.writeIntArray(this.f13159e);
        parcel.writeIntArray(this.f13160f);
    }

    k(Parcel parcel) {
        super("MLLT");
        this.f13156b = parcel.readInt();
        this.f13157c = parcel.readInt();
        this.f13158d = parcel.readInt();
        this.f13159e = (int[]) s0.j(parcel.createIntArray());
        this.f13160f = (int[]) s0.j(parcel.createIntArray());
    }
}
