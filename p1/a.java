package p1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import n1.a;
/* loaded from: classes.dex */
public final class a implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final String f12611a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12612b;

    /* renamed from: c  reason: collision with root package name */
    public final long f12613c;

    /* renamed from: d  reason: collision with root package name */
    public final long f12614d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f12615e;

    /* renamed from: f  reason: collision with root package name */
    private int f12616f;

    /* renamed from: g  reason: collision with root package name */
    private static final s0 f12609g = new s0.b().e0("application/id3").E();

    /* renamed from: h  reason: collision with root package name */
    private static final s0 f12610h = new s0.b().e0("application/x-scte35").E();
    public static final Parcelable.Creator<a> CREATOR = new C0205a();

    /* renamed from: p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0205a implements Parcelable.Creator {
        C0205a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    a(Parcel parcel) {
        this.f12611a = (String) com.google.android.exoplayer2.util.s0.j(parcel.readString());
        this.f12612b = (String) com.google.android.exoplayer2.util.s0.j(parcel.readString());
        this.f12613c = parcel.readLong();
        this.f12614d = parcel.readLong();
        this.f12615e = (byte[]) com.google.android.exoplayer2.util.s0.j(parcel.createByteArray());
    }

    @Override // n1.a.b
    public s0 b() {
        String str = this.f12611a;
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c6 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c6 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c6 = 2;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return f12610h;
            case 1:
            case 2:
                return f12609g;
            default:
                return null;
        }
    }

    @Override // n1.a.b
    public byte[] d() {
        if (b() != null) {
            return this.f12615e;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12613c == aVar.f12613c && this.f12614d == aVar.f12614d && com.google.android.exoplayer2.util.s0.c(this.f12611a, aVar.f12611a) && com.google.android.exoplayer2.util.s0.c(this.f12612b, aVar.f12612b) && Arrays.equals(this.f12615e, aVar.f12615e);
    }

    public int hashCode() {
        if (this.f12616f == 0) {
            String str = this.f12611a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f12612b;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j6 = this.f12613c;
            long j7 = this.f12614d;
            this.f12616f = ((((((hashCode + hashCode2) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + Arrays.hashCode(this.f12615e);
        }
        return this.f12616f;
    }

    public String toString() {
        String str = this.f12611a;
        long j6 = this.f12614d;
        long j7 = this.f12613c;
        String str2 = this.f12612b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j6);
        sb.append(", durationMs=");
        sb.append(j7);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f12611a);
        parcel.writeString(this.f12612b);
        parcel.writeLong(this.f12613c);
        parcel.writeLong(this.f12614d);
        parcel.writeByteArray(this.f12615e);
    }

    public a(String str, String str2, long j6, long j7, byte[] bArr) {
        this.f12611a = str;
        this.f12612b = str2;
        this.f12613c = j6;
        this.f12614d = j7;
        this.f12615e = bArr;
    }
}
