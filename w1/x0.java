package w1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class x0 implements Parcelable {
    public static final Parcelable.Creator<x0> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f14093a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.s0[] f14094b;

    /* renamed from: c  reason: collision with root package name */
    private int f14095c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public x0 createFromParcel(Parcel parcel) {
            return new x0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public x0[] newArray(int i6) {
            return new x0[i6];
        }
    }

    x0(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f14093a = readInt;
        this.f14094b = new com.google.android.exoplayer2.s0[readInt];
        for (int i6 = 0; i6 < this.f14093a; i6++) {
            this.f14094b[i6] = (com.google.android.exoplayer2.s0) parcel.readParcelable(com.google.android.exoplayer2.s0.class.getClassLoader());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.google.android.exoplayer2.s0 e(int i6) {
        return this.f14094b[i6];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x0.class != obj.getClass()) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.f14093a == x0Var.f14093a && Arrays.equals(this.f14094b, x0Var.f14094b);
    }

    public int f(com.google.android.exoplayer2.s0 s0Var) {
        int i6 = 0;
        while (true) {
            com.google.android.exoplayer2.s0[] s0VarArr = this.f14094b;
            if (i6 >= s0VarArr.length) {
                return -1;
            }
            if (s0Var == s0VarArr[i6]) {
                return i6;
            }
            i6++;
        }
    }

    public int hashCode() {
        if (this.f14095c == 0) {
            this.f14095c = 527 + Arrays.hashCode(this.f14094b);
        }
        return this.f14095c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f14093a);
        for (int i7 = 0; i7 < this.f14093a; i7++) {
            parcel.writeParcelable(this.f14094b[i7], 0);
        }
    }

    public x0(com.google.android.exoplayer2.s0... s0VarArr) {
        com.google.android.exoplayer2.util.a.g(s0VarArr.length > 0);
        this.f14094b = s0VarArr;
        this.f14093a = s0VarArr.length;
    }
}
