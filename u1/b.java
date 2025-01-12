package u1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f13419a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f13420b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13421c;

    /* renamed from: d  reason: collision with root package name */
    public final List f13422d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f13423e;

    /* renamed from: f  reason: collision with root package name */
    public final String f13424f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f13425g;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i6) {
            return new b[i6];
        }
    }

    b(Parcel parcel) {
        this.f13419a = (String) s0.j(parcel.readString());
        this.f13420b = Uri.parse((String) s0.j(parcel.readString()));
        this.f13421c = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add((e) parcel.readParcelable(e.class.getClassLoader()));
        }
        this.f13422d = Collections.unmodifiableList(arrayList);
        this.f13423e = parcel.createByteArray();
        this.f13424f = parcel.readString();
        this.f13425g = (byte[]) s0.j(parcel.createByteArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f13419a.equals(bVar.f13419a) && this.f13420b.equals(bVar.f13420b) && s0.c(this.f13421c, bVar.f13421c) && this.f13422d.equals(bVar.f13422d) && Arrays.equals(this.f13423e, bVar.f13423e) && s0.c(this.f13424f, bVar.f13424f) && Arrays.equals(this.f13425g, bVar.f13425g);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((this.f13419a.hashCode() * 31 * 31) + this.f13420b.hashCode()) * 31;
        String str = this.f13421c;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f13422d.hashCode()) * 31) + Arrays.hashCode(this.f13423e)) * 31;
        String str2 = this.f13424f;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f13425g);
    }

    public String toString() {
        String str = this.f13421c;
        String str2 = this.f13419a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f13419a);
        parcel.writeString(this.f13420b.toString());
        parcel.writeString(this.f13421c);
        parcel.writeInt(this.f13422d.size());
        for (int i7 = 0; i7 < this.f13422d.size(); i7++) {
            parcel.writeParcelable((Parcelable) this.f13422d.get(i7), 0);
        }
        parcel.writeByteArray(this.f13423e);
        parcel.writeString(this.f13424f);
        parcel.writeByteArray(this.f13425g);
    }
}
