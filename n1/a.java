package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0199a();

    /* renamed from: a  reason: collision with root package name */
    private final b[] f12183a;

    /* renamed from: n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0199a implements Parcelable.Creator {
        C0199a() {
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

    /* loaded from: classes.dex */
    public interface b extends Parcelable {
        s0 b();

        byte[] d();
    }

    a(Parcel parcel) {
        this.f12183a = new b[parcel.readInt()];
        int i6 = 0;
        while (true) {
            b[] bVarArr = this.f12183a;
            if (i6 >= bVarArr.length) {
                return;
            }
            bVarArr[i6] = (b) parcel.readParcelable(b.class.getClassLoader());
            i6++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a e(b... bVarArr) {
        return bVarArr.length == 0 ? this : new a((b[]) com.google.android.exoplayer2.util.s0.x0(this.f12183a, bVarArr));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f12183a, ((a) obj).f12183a);
    }

    public a f(a aVar) {
        return aVar == null ? this : e(aVar.f12183a);
    }

    public b g(int i6) {
        return this.f12183a[i6];
    }

    public int h() {
        return this.f12183a.length;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12183a);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f12183a));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f12183a.length);
        for (b bVar : this.f12183a) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public a(List list) {
        this.f12183a = (b[]) list.toArray(new b[0]);
    }

    public a(b... bVarArr) {
        this.f12183a = bVarArr;
    }
}
