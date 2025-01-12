package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements Comparable, Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f5193a;

    /* renamed from: b  reason: collision with root package name */
    final int f5194b;

    /* renamed from: c  reason: collision with root package name */
    final int f5195c;

    /* renamed from: d  reason: collision with root package name */
    final int f5196d;

    /* renamed from: e  reason: collision with root package name */
    final int f5197e;

    /* renamed from: f  reason: collision with root package name */
    final long f5198f;

    /* renamed from: g  reason: collision with root package name */
    private String f5199g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public i createFromParcel(Parcel parcel) {
            return i.f(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public i[] newArray(int i6) {
            return new i[i6];
        }
    }

    private i(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d6 = s.d(calendar);
        this.f5193a = d6;
        this.f5194b = d6.get(2);
        this.f5195c = d6.get(1);
        this.f5196d = d6.getMaximum(7);
        this.f5197e = d6.getActualMaximum(5);
        this.f5198f = d6.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i f(int i6, int i7) {
        Calendar k6 = s.k();
        k6.set(1, i6);
        k6.set(2, i7);
        return new i(k6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i g(long j6) {
        Calendar k6 = s.k();
        k6.setTimeInMillis(j6);
        return new i(k6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i h() {
        return new i(s.i());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(i iVar) {
        return this.f5193a.compareTo(iVar.f5193a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return this.f5194b == iVar.f5194b && this.f5195c == iVar.f5195c;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5194b), Integer.valueOf(this.f5195c)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        int firstDayOfWeek = this.f5193a.get(7) - this.f5193a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f5196d : firstDayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j(int i6) {
        Calendar d6 = s.d(this.f5193a);
        d6.set(5, i6);
        return d6.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(long j6) {
        Calendar d6 = s.d(this.f5193a);
        d6.setTimeInMillis(j6);
        return d6.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l(Context context) {
        if (this.f5199g == null) {
            this.f5199g = f.c(context, this.f5193a.getTimeInMillis());
        }
        return this.f5199g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m() {
        return this.f5193a.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i n(int i6) {
        Calendar d6 = s.d(this.f5193a);
        d6.add(2, i6);
        return new i(d6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o(i iVar) {
        if (this.f5193a instanceof GregorianCalendar) {
            return ((iVar.f5195c - this.f5195c) * 12) + (iVar.f5194b - this.f5194b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f5195c);
        parcel.writeInt(this.f5194b);
    }
}
