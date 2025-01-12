package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.l;
import androidx.lifecycle.c;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f1761a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList f1762b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f1763c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f1764d;

    /* renamed from: e  reason: collision with root package name */
    final int f1765e;

    /* renamed from: f  reason: collision with root package name */
    final int f1766f;

    /* renamed from: g  reason: collision with root package name */
    final String f1767g;

    /* renamed from: h  reason: collision with root package name */
    final int f1768h;

    /* renamed from: k  reason: collision with root package name */
    final int f1769k;

    /* renamed from: l  reason: collision with root package name */
    final CharSequence f1770l;

    /* renamed from: m  reason: collision with root package name */
    final int f1771m;

    /* renamed from: n  reason: collision with root package name */
    final CharSequence f1772n;

    /* renamed from: o  reason: collision with root package name */
    final ArrayList f1773o;

    /* renamed from: p  reason: collision with root package name */
    final ArrayList f1774p;

    /* renamed from: q  reason: collision with root package name */
    final boolean f1775q;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
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

    public b(Parcel parcel) {
        this.f1761a = parcel.createIntArray();
        this.f1762b = parcel.createStringArrayList();
        this.f1763c = parcel.createIntArray();
        this.f1764d = parcel.createIntArray();
        this.f1765e = parcel.readInt();
        this.f1766f = parcel.readInt();
        this.f1767g = parcel.readString();
        this.f1768h = parcel.readInt();
        this.f1769k = parcel.readInt();
        this.f1770l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1771m = parcel.readInt();
        this.f1772n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1773o = parcel.createStringArrayList();
        this.f1774p = parcel.createStringArrayList();
        this.f1775q = parcel.readInt() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a e(h hVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(hVar);
        int i6 = 0;
        int i7 = 0;
        while (i6 < this.f1761a.length) {
            l.a aVar2 = new l.a();
            int i8 = i6 + 1;
            aVar2.f1882a = this.f1761a[i6];
            if (h.I) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i7 + " base fragment #" + this.f1761a[i8]);
            }
            String str = (String) this.f1762b.get(i7);
            aVar2.f1883b = str != null ? (Fragment) hVar.f1789h.get(str) : null;
            aVar2.f1888g = c.b.values()[this.f1763c[i7]];
            aVar2.f1889h = c.b.values()[this.f1764d[i7]];
            int[] iArr = this.f1761a;
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            aVar2.f1884c = i10;
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            aVar2.f1885d = i12;
            int i13 = i11 + 1;
            int i14 = iArr[i11];
            aVar2.f1886e = i14;
            int i15 = iArr[i13];
            aVar2.f1887f = i15;
            aVar.f1865b = i10;
            aVar.f1866c = i12;
            aVar.f1867d = i14;
            aVar.f1868e = i15;
            aVar.b(aVar2);
            i7++;
            i6 = i13 + 1;
        }
        aVar.f1869f = this.f1765e;
        aVar.f1870g = this.f1766f;
        aVar.f1873j = this.f1767g;
        aVar.f1760u = this.f1768h;
        aVar.f1871h = true;
        aVar.f1874k = this.f1769k;
        aVar.f1875l = this.f1770l;
        aVar.f1876m = this.f1771m;
        aVar.f1877n = this.f1772n;
        aVar.f1878o = this.f1773o;
        aVar.f1879p = this.f1774p;
        aVar.f1880q = this.f1775q;
        aVar.k(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeIntArray(this.f1761a);
        parcel.writeStringList(this.f1762b);
        parcel.writeIntArray(this.f1763c);
        parcel.writeIntArray(this.f1764d);
        parcel.writeInt(this.f1765e);
        parcel.writeInt(this.f1766f);
        parcel.writeString(this.f1767g);
        parcel.writeInt(this.f1768h);
        parcel.writeInt(this.f1769k);
        TextUtils.writeToParcel(this.f1770l, parcel, 0);
        parcel.writeInt(this.f1771m);
        TextUtils.writeToParcel(this.f1772n, parcel, 0);
        parcel.writeStringList(this.f1773o);
        parcel.writeStringList(this.f1774p);
        parcel.writeInt(this.f1775q ? 1 : 0);
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f1864a.size();
        this.f1761a = new int[size * 5];
        if (!aVar.f1871h) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1762b = new ArrayList(size);
        this.f1763c = new int[size];
        this.f1764d = new int[size];
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            l.a aVar2 = (l.a) aVar.f1864a.get(i6);
            int i8 = i7 + 1;
            this.f1761a[i7] = aVar2.f1882a;
            ArrayList arrayList = this.f1762b;
            Fragment fragment = aVar2.f1883b;
            arrayList.add(fragment != null ? fragment.f1694f : null);
            int[] iArr = this.f1761a;
            int i9 = i8 + 1;
            iArr[i8] = aVar2.f1884c;
            int i10 = i9 + 1;
            iArr[i9] = aVar2.f1885d;
            int i11 = i10 + 1;
            iArr[i10] = aVar2.f1886e;
            iArr[i11] = aVar2.f1887f;
            this.f1763c[i6] = aVar2.f1888g.ordinal();
            this.f1764d[i6] = aVar2.f1889h.ordinal();
            i6++;
            i7 = i11 + 1;
        }
        this.f1765e = aVar.f1869f;
        this.f1766f = aVar.f1870g;
        this.f1767g = aVar.f1873j;
        this.f1768h = aVar.f1760u;
        this.f1769k = aVar.f1874k;
        this.f1770l = aVar.f1875l;
        this.f1771m = aVar.f1876m;
        this.f1772n = aVar.f1877n;
        this.f1773o = aVar.f1878o;
        this.f1774p = aVar.f1879p;
        this.f1775q = aVar.f1880q;
    }
}
