package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f1850a;

    /* renamed from: b  reason: collision with root package name */
    final String f1851b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f1852c;

    /* renamed from: d  reason: collision with root package name */
    final int f1853d;

    /* renamed from: e  reason: collision with root package name */
    final int f1854e;

    /* renamed from: f  reason: collision with root package name */
    final String f1855f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f1856g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f1857h;

    /* renamed from: k  reason: collision with root package name */
    final boolean f1858k;

    /* renamed from: l  reason: collision with root package name */
    final Bundle f1859l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f1860m;

    /* renamed from: n  reason: collision with root package name */
    final int f1861n;

    /* renamed from: o  reason: collision with root package name */
    Bundle f1862o;

    /* renamed from: p  reason: collision with root package name */
    Fragment f1863p;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
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

    k(Parcel parcel) {
        this.f1850a = parcel.readString();
        this.f1851b = parcel.readString();
        this.f1852c = parcel.readInt() != 0;
        this.f1853d = parcel.readInt();
        this.f1854e = parcel.readInt();
        this.f1855f = parcel.readString();
        this.f1856g = parcel.readInt() != 0;
        this.f1857h = parcel.readInt() != 0;
        this.f1858k = parcel.readInt() != 0;
        this.f1859l = parcel.readBundle();
        this.f1860m = parcel.readInt() != 0;
        this.f1862o = parcel.readBundle();
        this.f1861n = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment e(ClassLoader classLoader, e eVar) {
        Fragment fragment;
        Bundle bundle;
        if (this.f1863p == null) {
            Bundle bundle2 = this.f1859l;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            Fragment a6 = eVar.a(classLoader, this.f1850a);
            this.f1863p = a6;
            a6.f1(this.f1859l);
            Bundle bundle3 = this.f1862o;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                fragment = this.f1863p;
                bundle = this.f1862o;
            } else {
                fragment = this.f1863p;
                bundle = new Bundle();
            }
            fragment.f1691c = bundle;
            Fragment fragment2 = this.f1863p;
            fragment2.f1694f = this.f1851b;
            fragment2.f1702n = this.f1852c;
            fragment2.f1704p = true;
            fragment2.f1711w = this.f1853d;
            fragment2.f1712x = this.f1854e;
            fragment2.f1713y = this.f1855f;
            fragment2.B = this.f1856g;
            fragment2.f1701m = this.f1857h;
            fragment2.A = this.f1858k;
            fragment2.f1714z = this.f1860m;
            fragment2.S = c.b.values()[this.f1861n];
            if (h.I) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f1863p);
            }
        }
        return this.f1863p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1850a);
        sb.append(" (");
        sb.append(this.f1851b);
        sb.append(")}:");
        if (this.f1852c) {
            sb.append(" fromLayout");
        }
        if (this.f1854e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1854e));
        }
        String str = this.f1855f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1855f);
        }
        if (this.f1856g) {
            sb.append(" retainInstance");
        }
        if (this.f1857h) {
            sb.append(" removing");
        }
        if (this.f1858k) {
            sb.append(" detached");
        }
        if (this.f1860m) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f1850a);
        parcel.writeString(this.f1851b);
        parcel.writeInt(this.f1852c ? 1 : 0);
        parcel.writeInt(this.f1853d);
        parcel.writeInt(this.f1854e);
        parcel.writeString(this.f1855f);
        parcel.writeInt(this.f1856g ? 1 : 0);
        parcel.writeInt(this.f1857h ? 1 : 0);
        parcel.writeInt(this.f1858k ? 1 : 0);
        parcel.writeBundle(this.f1859l);
        parcel.writeInt(this.f1860m ? 1 : 0);
        parcel.writeBundle(this.f1862o);
        parcel.writeInt(this.f1861n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Fragment fragment) {
        this.f1850a = fragment.getClass().getName();
        this.f1851b = fragment.f1694f;
        this.f1852c = fragment.f1702n;
        this.f1853d = fragment.f1711w;
        this.f1854e = fragment.f1712x;
        this.f1855f = fragment.f1713y;
        this.f1856g = fragment.B;
        this.f1857h = fragment.f1701m;
        this.f1858k = fragment.A;
        this.f1859l = fragment.f1695g;
        this.f1860m = fragment.f1714z;
        this.f1861n = fragment.S.ordinal();
    }
}
