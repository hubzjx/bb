package w1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class y0 implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public final int f14101a;

    /* renamed from: b  reason: collision with root package name */
    private final x0[] f14102b;

    /* renamed from: c  reason: collision with root package name */
    private int f14103c;

    /* renamed from: d  reason: collision with root package name */
    public static final y0 f14100d = new y0(new x0[0]);
    public static final Parcelable.Creator<y0> CREATOR = new a();

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public y0 createFromParcel(Parcel parcel) {
            return new y0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public y0[] newArray(int i6) {
            return new y0[i6];
        }
    }

    y0(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f14101a = readInt;
        this.f14102b = new x0[readInt];
        for (int i6 = 0; i6 < this.f14101a; i6++) {
            this.f14102b[i6] = (x0) parcel.readParcelable(x0.class.getClassLoader());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public x0 e(int i6) {
        return this.f14102b[i6];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f14101a == y0Var.f14101a && Arrays.equals(this.f14102b, y0Var.f14102b);
    }

    public int f(x0 x0Var) {
        for (int i6 = 0; i6 < this.f14101a; i6++) {
            if (this.f14102b[i6] == x0Var) {
                return i6;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f14103c == 0) {
            this.f14103c = Arrays.hashCode(this.f14102b);
        }
        return this.f14103c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f14101a);
        for (int i7 = 0; i7 < this.f14101a; i7++) {
            parcel.writeParcelable(this.f14102b[i7], 0);
        }
    }

    public y0(x0... x0VarArr) {
        this.f14102b = x0VarArr;
        this.f14101a = x0VarArr.length;
    }
}
