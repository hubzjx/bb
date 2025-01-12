package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0047a();

    /* renamed from: a  reason: collision with root package name */
    private final i f5162a;

    /* renamed from: b  reason: collision with root package name */
    private final i f5163b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5164c;

    /* renamed from: d  reason: collision with root package name */
    private i f5165d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5166e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5167f;

    /* renamed from: com.google.android.material.datepicker.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0047a implements Parcelable.Creator {
        C0047a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a((i) parcel.readParcelable(i.class.getClassLoader()), (i) parcel.readParcelable(i.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (i) parcel.readParcelable(i.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        static final long f5168e = s.a(i.f(1900, 0).f5198f);

        /* renamed from: f  reason: collision with root package name */
        static final long f5169f = s.a(i.f(2100, 11).f5198f);

        /* renamed from: a  reason: collision with root package name */
        private long f5170a;

        /* renamed from: b  reason: collision with root package name */
        private long f5171b;

        /* renamed from: c  reason: collision with root package name */
        private Long f5172c;

        /* renamed from: d  reason: collision with root package name */
        private c f5173d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(a aVar) {
            this.f5170a = f5168e;
            this.f5171b = f5169f;
            this.f5173d = g.e(Long.MIN_VALUE);
            this.f5170a = aVar.f5162a.f5198f;
            this.f5171b = aVar.f5163b.f5198f;
            this.f5172c = Long.valueOf(aVar.f5165d.f5198f);
            this.f5173d = aVar.f5164c;
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f5173d);
            i g6 = i.g(this.f5170a);
            i g7 = i.g(this.f5171b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l6 = this.f5172c;
            return new a(g6, g7, cVar, l6 == null ? null : i.g(l6.longValue()), null);
        }

        public b b(long j6) {
            this.f5172c = Long.valueOf(j6);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface c extends Parcelable {
        boolean a(long j6);
    }

    private a(i iVar, i iVar2, c cVar, i iVar3) {
        this.f5162a = iVar;
        this.f5163b = iVar2;
        this.f5165d = iVar3;
        this.f5164c = cVar;
        if (iVar3 != null && iVar.compareTo(iVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (iVar3 != null && iVar3.compareTo(iVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f5167f = iVar.o(iVar2) + 1;
        this.f5166e = (iVar2.f5195c - iVar.f5195c) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f5162a.equals(aVar.f5162a) && this.f5163b.equals(aVar.f5163b) && d0.d.a(this.f5165d, aVar.f5165d) && this.f5164c.equals(aVar.f5164c);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5162a, this.f5163b, this.f5165d, this.f5164c});
    }

    public c i() {
        return this.f5164c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i j() {
        return this.f5163b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f5167f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i l() {
        return this.f5165d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i m() {
        return this.f5162a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f5166e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f5162a, 0);
        parcel.writeParcelable(this.f5163b, 0);
        parcel.writeParcelable(this.f5165d, 0);
        parcel.writeParcelable(this.f5164c, 0);
    }

    /* synthetic */ a(i iVar, i iVar2, c cVar, i iVar3, C0047a c0047a) {
        this(iVar, iVar2, cVar, iVar3);
    }
}
