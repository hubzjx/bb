package s1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c extends i {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f13129b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13130c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13131d;

    /* renamed from: e  reason: collision with root package name */
    public final long f13132e;

    /* renamed from: f  reason: collision with root package name */
    public final long f13133f;

    /* renamed from: g  reason: collision with root package name */
    private final i[] f13134g;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c[] newArray(int i6) {
            return new c[i6];
        }
    }

    c(Parcel parcel) {
        super("CHAP");
        this.f13129b = (String) s0.j(parcel.readString());
        this.f13130c = parcel.readInt();
        this.f13131d = parcel.readInt();
        this.f13132e = parcel.readLong();
        this.f13133f = parcel.readLong();
        int readInt = parcel.readInt();
        this.f13134g = new i[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            this.f13134g[i6] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    @Override // s1.i, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f13130c == cVar.f13130c && this.f13131d == cVar.f13131d && this.f13132e == cVar.f13132e && this.f13133f == cVar.f13133f && s0.c(this.f13129b, cVar.f13129b) && Arrays.equals(this.f13134g, cVar.f13134g);
    }

    public int hashCode() {
        int i6 = (((((((527 + this.f13130c) * 31) + this.f13131d) * 31) + ((int) this.f13132e)) * 31) + ((int) this.f13133f)) * 31;
        String str = this.f13129b;
        return i6 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13129b);
        parcel.writeInt(this.f13130c);
        parcel.writeInt(this.f13131d);
        parcel.writeLong(this.f13132e);
        parcel.writeLong(this.f13133f);
        parcel.writeInt(this.f13134g.length);
        for (i iVar : this.f13134g) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    public c(String str, int i6, int i7, long j6, long j7, i[] iVarArr) {
        super("CHAP");
        this.f13129b = str;
        this.f13130c = i6;
        this.f13131d = i7;
        this.f13132e = j6;
        this.f13133f = j7;
        this.f13134g = iVarArr;
    }
}
