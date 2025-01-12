package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public class g implements a.c {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final long f5188a;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public g[] newArray(int i6) {
            return new g[i6];
        }
    }

    private g(long j6) {
        this.f5188a = j6;
    }

    public static g e(long j6) {
        return new g(j6);
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean a(long j6) {
        return j6 >= this.f5188a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f5188a == ((g) obj).f5188a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f5188a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f5188a);
    }

    /* synthetic */ g(long j6, a aVar) {
        this(j6);
    }
}
