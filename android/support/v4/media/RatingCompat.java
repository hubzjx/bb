package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f174a;

    /* renamed from: b  reason: collision with root package name */
    private final float f175b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RatingCompat[] newArray(int i6) {
            return new RatingCompat[i6];
        }
    }

    RatingCompat(int i6, float f6) {
        this.f174a = i6;
        this.f175b = f6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f174a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f174a);
        sb.append(" rating=");
        float f6 = this.f175b;
        sb.append(f6 < 0.0f ? "unrated" : String.valueOf(f6));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f174a);
        parcel.writeFloat(this.f175b);
    }
}
