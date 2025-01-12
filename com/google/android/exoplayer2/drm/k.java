package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public final class k implements Comparator, Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final b[] f3701a;

    /* renamed from: b  reason: collision with root package name */
    private int f3702b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3703c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3704d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public k[] newArray(int i6) {
            return new k[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private int f3705a;

        /* renamed from: b  reason: collision with root package name */
        public final UUID f3706b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3707c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3708d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f3709e;

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
            this.f3706b = new UUID(parcel.readLong(), parcel.readLong());
            this.f3707c = parcel.readString();
            this.f3708d = (String) s0.j(parcel.readString());
            this.f3709e = parcel.createByteArray();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean e(b bVar) {
            return g() && !bVar.g() && h(bVar.f3706b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                if (obj == this) {
                    return true;
                }
                b bVar = (b) obj;
                return s0.c(this.f3707c, bVar.f3707c) && s0.c(this.f3708d, bVar.f3708d) && s0.c(this.f3706b, bVar.f3706b) && Arrays.equals(this.f3709e, bVar.f3709e);
            }
            return false;
        }

        public b f(byte[] bArr) {
            return new b(this.f3706b, this.f3707c, this.f3708d, bArr);
        }

        public boolean g() {
            return this.f3709e != null;
        }

        public boolean h(UUID uuid) {
            return com.google.android.exoplayer2.p.f3948a.equals(this.f3706b) || uuid.equals(this.f3706b);
        }

        public int hashCode() {
            if (this.f3705a == 0) {
                int hashCode = this.f3706b.hashCode() * 31;
                String str = this.f3707c;
                this.f3705a = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f3708d.hashCode()) * 31) + Arrays.hashCode(this.f3709e);
            }
            return this.f3705a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeLong(this.f3706b.getMostSignificantBits());
            parcel.writeLong(this.f3706b.getLeastSignificantBits());
            parcel.writeString(this.f3707c);
            parcel.writeString(this.f3708d);
            parcel.writeByteArray(this.f3709e);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.f3706b = (UUID) com.google.android.exoplayer2.util.a.e(uuid);
            this.f3707c = str;
            this.f3708d = (String) com.google.android.exoplayer2.util.a.e(str2);
            this.f3709e = bArr;
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }
    }

    k(Parcel parcel) {
        this.f3703c = parcel.readString();
        b[] bVarArr = (b[]) s0.j((b[]) parcel.createTypedArray(b.CREATOR));
        this.f3701a = bVarArr;
        this.f3704d = bVarArr.length;
    }

    private static boolean f(ArrayList arrayList, int i6, UUID uuid) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (((b) arrayList.get(i7)).f3706b.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static k h(k kVar, k kVar2) {
        String str;
        b[] bVarArr;
        b[] bVarArr2;
        ArrayList arrayList = new ArrayList();
        if (kVar != null) {
            str = kVar.f3703c;
            for (b bVar : kVar.f3701a) {
                if (bVar.g()) {
                    arrayList.add(bVar);
                }
            }
        } else {
            str = null;
        }
        if (kVar2 != null) {
            if (str == null) {
                str = kVar2.f3703c;
            }
            int size = arrayList.size();
            for (b bVar2 : kVar2.f3701a) {
                if (bVar2.g() && !f(arrayList, size, bVar2.f3706b)) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new k(str, arrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    /* renamed from: e */
    public int compare(b bVar, b bVar2) {
        UUID uuid = com.google.android.exoplayer2.p.f3948a;
        return uuid.equals(bVar.f3706b) ? uuid.equals(bVar2.f3706b) ? 0 : 1 : bVar.f3706b.compareTo(bVar2.f3706b);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return s0.c(this.f3703c, kVar.f3703c) && Arrays.equals(this.f3701a, kVar.f3701a);
    }

    public k g(String str) {
        return s0.c(this.f3703c, str) ? this : new k(str, false, this.f3701a);
    }

    public int hashCode() {
        if (this.f3702b == 0) {
            String str = this.f3703c;
            this.f3702b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f3701a);
        }
        return this.f3702b;
    }

    public b i(int i6) {
        return this.f3701a[i6];
    }

    public k j(k kVar) {
        String str;
        String str2 = this.f3703c;
        com.google.android.exoplayer2.util.a.g(str2 == null || (str = kVar.f3703c) == null || TextUtils.equals(str2, str));
        String str3 = this.f3703c;
        if (str3 == null) {
            str3 = kVar.f3703c;
        }
        return new k(str3, (b[]) s0.x0(this.f3701a, kVar.f3701a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3703c);
        parcel.writeTypedArray(this.f3701a, 0);
    }

    public k(String str, List list) {
        this(str, false, (b[]) list.toArray(new b[0]));
    }

    private k(String str, boolean z5, b... bVarArr) {
        this.f3703c = str;
        bVarArr = z5 ? (b[]) bVarArr.clone() : bVarArr;
        this.f3701a = bVarArr;
        this.f3704d = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public k(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public k(List list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    public k(b... bVarArr) {
        this((String) null, bVarArr);
    }
}
