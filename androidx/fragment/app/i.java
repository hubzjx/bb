package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1838a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList f1839b;

    /* renamed from: c  reason: collision with root package name */
    b[] f1840c;

    /* renamed from: d  reason: collision with root package name */
    String f1841d;

    /* renamed from: e  reason: collision with root package name */
    int f1842e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public i[] newArray(int i6) {
            return new i[i6];
        }
    }

    public i() {
        this.f1841d = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeTypedList(this.f1838a);
        parcel.writeStringList(this.f1839b);
        parcel.writeTypedArray(this.f1840c, i6);
        parcel.writeString(this.f1841d);
        parcel.writeInt(this.f1842e);
    }

    public i(Parcel parcel) {
        this.f1841d = null;
        this.f1838a = parcel.createTypedArrayList(k.CREATOR);
        this.f1839b = parcel.createStringArrayList();
        this.f1840c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1841d = parcel.readString();
        this.f1842e = parcel.readInt();
    }
}
