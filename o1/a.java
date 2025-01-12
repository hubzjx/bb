package o1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s0;
import n1.a;
/* loaded from: classes.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0200a();

    /* renamed from: a  reason: collision with root package name */
    public final int f12340a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12341b;

    /* renamed from: o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0200a implements Parcelable.Creator {
        C0200a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel.readInt(), (String) com.google.android.exoplayer2.util.a.e(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    public a(int i6, String str) {
        this.f12340a = i6;
        this.f12341b = str;
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

    public String toString() {
        int i6 = this.f12340a;
        String str = this.f12341b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append("Ait(controlCode=");
        sb.append(i6);
        sb.append(",url=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f12341b);
        parcel.writeInt(this.f12340a);
    }
}
