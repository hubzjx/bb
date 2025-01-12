package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final c f5543a;

    /* renamed from: b  reason: collision with root package name */
    private final c f5544b;

    /* renamed from: c  reason: collision with root package name */
    final int f5545c;

    /* renamed from: d  reason: collision with root package name */
    int f5546d;

    /* renamed from: e  reason: collision with root package name */
    int f5547e;

    /* renamed from: f  reason: collision with root package name */
    int f5548f;

    /* renamed from: g  reason: collision with root package name */
    int f5549g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public e[] newArray(int i6) {
            return new e[i6];
        }
    }

    public e() {
        this(0);
    }

    public static String e(Resources resources, CharSequence charSequence) {
        return f(resources, charSequence, "%02d");
    }

    public static String f(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int j(int i6) {
        return i6 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f5546d == eVar.f5546d && this.f5547e == eVar.f5547e && this.f5545c == eVar.f5545c && this.f5548f == eVar.f5548f;
        }
        return false;
    }

    public int g() {
        if (this.f5545c == 1) {
            return this.f5546d % 24;
        }
        int i6 = this.f5546d;
        if (i6 % 12 == 0) {
            return 12;
        }
        return this.f5549g == 1 ? i6 - 12 : i6;
    }

    public c h() {
        return this.f5544b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5545c), Integer.valueOf(this.f5546d), Integer.valueOf(this.f5547e), Integer.valueOf(this.f5548f)});
    }

    public c i() {
        return this.f5543a;
    }

    public void k(int i6) {
        if (this.f5545c == 1) {
            this.f5546d = i6;
        } else {
            this.f5546d = (i6 % 12) + (this.f5549g != 1 ? 0 : 12);
        }
    }

    public void l(int i6) {
        this.f5547e = i6 % 60;
    }

    public void m(int i6) {
        int i7;
        if (i6 != this.f5549g) {
            this.f5549g = i6;
            int i8 = this.f5546d;
            if (i8 < 12 && i6 == 1) {
                i7 = i8 + 12;
            } else if (i8 < 12 || i6 != 0) {
                return;
            } else {
                i7 = i8 - 12;
            }
            this.f5546d = i7;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f5546d);
        parcel.writeInt(this.f5547e);
        parcel.writeInt(this.f5548f);
        parcel.writeInt(this.f5545c);
    }

    public e(int i6) {
        this(0, 0, 10, i6);
    }

    public e(int i6, int i7, int i8, int i9) {
        this.f5546d = i6;
        this.f5547e = i7;
        this.f5548f = i8;
        this.f5545c = i9;
        this.f5549g = j(i6);
        this.f5543a = new c(59);
        this.f5544b = new c(i9 == 1 ? 24 : 12);
    }

    protected e(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
