package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f2641d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f2642e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2643f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2644g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2645h;

    /* renamed from: i  reason: collision with root package name */
    private int f2646i;

    /* renamed from: j  reason: collision with root package name */
    private int f2647j;

    /* renamed from: k  reason: collision with root package name */
    private int f2648k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), HttpUrl.FRAGMENT_ENCODE_SET, new l.a(), new l.a(), new l.a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f2642e.writeInt(-1);
            return;
        }
        this.f2642e.writeInt(bArr.length);
        this.f2642e.writeByteArray(bArr);
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2642e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i6) {
        this.f2642e.writeInt(i6);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f2642e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f2642e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i6 = this.f2646i;
        if (i6 >= 0) {
            int i7 = this.f2641d.get(i6);
            int dataPosition = this.f2642e.dataPosition();
            this.f2642e.setDataPosition(i7);
            this.f2642e.writeInt(dataPosition - i7);
            this.f2642e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f2642e;
        int dataPosition = parcel.dataPosition();
        int i6 = this.f2647j;
        if (i6 == this.f2643f) {
            i6 = this.f2644g;
        }
        int i7 = i6;
        return new b(parcel, dataPosition, i7, this.f2645h + "  ", this.f2638a, this.f2639b, this.f2640c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f2642e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f2642e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2642e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2642e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i6) {
        while (this.f2647j < this.f2644g) {
            int i7 = this.f2648k;
            if (i7 == i6) {
                return true;
            }
            if (String.valueOf(i7).compareTo(String.valueOf(i6)) > 0) {
                return false;
            }
            this.f2642e.setDataPosition(this.f2647j);
            int readInt = this.f2642e.readInt();
            this.f2648k = this.f2642e.readInt();
            this.f2647j += readInt;
        }
        return this.f2648k == i6;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f2642e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.f2642e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f2642e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i6) {
        a();
        this.f2646i = i6;
        this.f2641d.put(i6, this.f2642e.dataPosition());
        E(0);
        E(i6);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z5) {
        this.f2642e.writeInt(z5 ? 1 : 0);
    }

    private b(Parcel parcel, int i6, int i7, String str, l.a aVar, l.a aVar2, l.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2641d = new SparseIntArray();
        this.f2646i = -1;
        this.f2648k = -1;
        this.f2642e = parcel;
        this.f2643f = i6;
        this.f2644g = i7;
        this.f2647j = i6;
        this.f2645h = str;
    }
}
