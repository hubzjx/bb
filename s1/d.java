package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class d extends i {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13135b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13136c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13137d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f13138e;

    /* renamed from: f  reason: collision with root package name */
    private final i[] f13139f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public d[] newArray(int i6) {
            return new d[i6];
        }
    }

    d(Parcel parcel) {
        super("CTOC");
        this.f13135b = (String) s0.j(parcel.readString());
        this.f13136c = parcel.readByte() != 0;
        this.f13137d = parcel.readByte() != 0;
        this.f13138e = (String[]) s0.j(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f13139f = new i[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            this.f13139f[i6] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f13136c == dVar.f13136c && this.f13137d == dVar.f13137d && s0.c(this.f13135b, dVar.f13135b) && Arrays.equals(this.f13138e, dVar.f13138e) && Arrays.equals(this.f13139f, dVar.f13139f);
    }

    public int hashCode() {
        int i6 = (((527 + (this.f13136c ? 1 : 0)) * 31) + (this.f13137d ? 1 : 0)) * 31;
        String str = this.f13135b;
        return i6 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13135b);
        parcel.writeByte(this.f13136c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f13137d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f13138e);
        parcel.writeInt(this.f13139f.length);
        for (i iVar : this.f13139f) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    public d(String str, boolean z5, boolean z6, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f13135b = str;
        this.f13136c = z5;
        this.f13137d = z6;
        this.f13138e = strArr;
        this.f13139f = iVarArr;
    }
}
