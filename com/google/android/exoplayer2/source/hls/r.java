package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.s0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n1.a;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class r implements a.b {
    public static final Parcelable.Creator<r> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f4369a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4370b;

    /* renamed from: c  reason: collision with root package name */
    public final List f4371c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public r createFromParcel(Parcel parcel) {
            return new r(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public r[] newArray(int i6) {
            return new r[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final int f4372a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4373b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4374c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4375d;

        /* renamed from: e  reason: collision with root package name */
        public final String f4376e;

        /* renamed from: f  reason: collision with root package name */
        public final String f4377f;

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

        public b(int i6, int i7, String str, String str2, String str3, String str4) {
            this.f4372a = i6;
            this.f4373b = i7;
            this.f4374c = str;
            this.f4375d = str2;
            this.f4376e = str3;
            this.f4377f = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4372a == bVar.f4372a && this.f4373b == bVar.f4373b && TextUtils.equals(this.f4374c, bVar.f4374c) && TextUtils.equals(this.f4375d, bVar.f4375d) && TextUtils.equals(this.f4376e, bVar.f4376e) && TextUtils.equals(this.f4377f, bVar.f4377f);
        }

        public int hashCode() {
            int i6 = ((this.f4372a * 31) + this.f4373b) * 31;
            String str = this.f4374c;
            int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f4375d;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f4376e;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f4377f;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f4372a);
            parcel.writeInt(this.f4373b);
            parcel.writeString(this.f4374c);
            parcel.writeString(this.f4375d);
            parcel.writeString(this.f4376e);
            parcel.writeString(this.f4377f);
        }

        b(Parcel parcel) {
            this.f4372a = parcel.readInt();
            this.f4373b = parcel.readInt();
            this.f4374c = parcel.readString();
            this.f4375d = parcel.readString();
            this.f4376e = parcel.readString();
            this.f4377f = parcel.readString();
        }
    }

    r(Parcel parcel) {
        this.f4369a = parcel.readString();
        this.f4370b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add((b) parcel.readParcelable(b.class.getClassLoader()));
        }
        this.f4371c = Collections.unmodifiableList(arrayList);
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return TextUtils.equals(this.f4369a, rVar.f4369a) && TextUtils.equals(this.f4370b, rVar.f4370b) && this.f4371c.equals(rVar.f4371c);
    }

    public int hashCode() {
        String str = this.f4369a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4370b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f4371c.hashCode();
    }

    public String toString() {
        String str;
        String str2 = this.f4369a;
        if (str2 != null) {
            String str3 = this.f4370b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 5 + String.valueOf(str3).length());
            sb.append(" [");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append("]");
            str = sb.toString();
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f4369a);
        parcel.writeString(this.f4370b);
        int size = this.f4371c.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeParcelable((Parcelable) this.f4371c.get(i7), 0);
        }
    }

    public r(String str, String str2, List list) {
        this.f4369a = str;
        this.f4370b = str2;
        this.f4371c = Collections.unmodifiableList(new ArrayList(list));
    }
}
