package t1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new C0217a();

    /* renamed from: a  reason: collision with root package name */
    public final long f13342a;

    /* renamed from: b  reason: collision with root package name */
    public final long f13343b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f13344c;

    /* renamed from: t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0217a implements Parcelable.Creator {
        C0217a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    private a(long j6, byte[] bArr, long j7) {
        this.f13342a = j7;
        this.f13343b = j6;
        this.f13344c = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a e(y yVar, int i6, long j6) {
        long C = yVar.C();
        int i7 = i6 - 4;
        byte[] bArr = new byte[i7];
        yVar.i(bArr, 0, i7);
        return new a(C, bArr, j6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f13342a);
        parcel.writeLong(this.f13343b);
        parcel.writeByteArray(this.f13344c);
    }

    private a(Parcel parcel) {
        this.f13342a = parcel.readLong();
        this.f13343b = parcel.readLong();
        this.f13344c = (byte[]) s0.j(parcel.createByteArray());
    }

    /* synthetic */ a(Parcel parcel, C0217a c0217a) {
        this(parcel);
    }
}
