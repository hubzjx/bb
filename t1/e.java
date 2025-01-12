package t1;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class e extends b {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public e[] newArray(int i6) {
            return new e[i6];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
    }
}
