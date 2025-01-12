package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f192a;

    /* renamed from: b  reason: collision with root package name */
    public int f193b;

    /* renamed from: c  reason: collision with root package name */
    public int f194c;

    /* renamed from: d  reason: collision with root package name */
    public int f195d;

    /* renamed from: e  reason: collision with root package name */
    public int f196e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i6) {
            return new ParcelableVolumeInfo[i6];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f192a = parcel.readInt();
        this.f194c = parcel.readInt();
        this.f195d = parcel.readInt();
        this.f196e = parcel.readInt();
        this.f193b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f192a);
        parcel.writeInt(this.f194c);
        parcel.writeInt(this.f195d);
        parcel.writeInt(this.f196e);
        parcel.writeInt(this.f193b);
    }
}
