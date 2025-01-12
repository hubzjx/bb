package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.n;
import java.util.List;
import java.util.Map;
import n1.a;
/* loaded from: classes.dex */
public final class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f12919a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12920b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12921c;

    /* renamed from: d  reason: collision with root package name */
    public final String f12922d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f12923e;

    /* renamed from: f  reason: collision with root package name */
    public final int f12924f;

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

    public b(int i6, String str, String str2, String str3, boolean z5, int i7) {
        com.google.android.exoplayer2.util.a.a(i7 == -1 || i7 > 0);
        this.f12919a = i6;
        this.f12920b = str;
        this.f12921c = str2;
        this.f12922d = str3;
        this.f12923e = z5;
        this.f12924f = i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b e(Map map) {
        boolean z5;
        int i6;
        List list;
        String str;
        List list2;
        String str2;
        List list3;
        String str3;
        List list4;
        boolean z6;
        List list5;
        int i7;
        List list6 = (List) map.get("icy-br");
        boolean z7 = true;
        int i8 = -1;
        if (list6 != null) {
            String str4 = (String) list6.get(0);
            try {
                i7 = Integer.parseInt(str4) * 1000;
                if (i7 > 0) {
                    z5 = true;
                } else {
                    try {
                        String valueOf = String.valueOf(str4);
                        n.h("IcyHeaders", valueOf.length() != 0 ? "Invalid bitrate: ".concat(valueOf) : new String("Invalid bitrate: "));
                        z5 = false;
                        i7 = -1;
                    } catch (NumberFormatException unused) {
                        String valueOf2 = String.valueOf(str4);
                        n.h("IcyHeaders", valueOf2.length() != 0 ? "Invalid bitrate header: ".concat(valueOf2) : new String("Invalid bitrate header: "));
                        i6 = i7;
                        z5 = false;
                        list = (List) map.get("icy-genre");
                        if (list == null) {
                        }
                        list2 = (List) map.get("icy-name");
                        if (list2 == null) {
                        }
                        list3 = (List) map.get("icy-url");
                        if (list3 == null) {
                        }
                        list4 = (List) map.get("icy-pub");
                        if (list4 == null) {
                        }
                        list5 = (List) map.get("icy-metaint");
                        if (list5 != null) {
                        }
                        if (z5) {
                        }
                    }
                }
                i6 = i7;
            } catch (NumberFormatException unused2) {
                i7 = -1;
            }
        } else {
            z5 = false;
            i6 = -1;
        }
        list = (List) map.get("icy-genre");
        if (list == null) {
            str = (String) list.get(0);
            z5 = true;
        } else {
            str = null;
        }
        list2 = (List) map.get("icy-name");
        if (list2 == null) {
            str2 = (String) list2.get(0);
            z5 = true;
        } else {
            str2 = null;
        }
        list3 = (List) map.get("icy-url");
        if (list3 == null) {
            str3 = (String) list3.get(0);
            z5 = true;
        } else {
            str3 = null;
        }
        list4 = (List) map.get("icy-pub");
        if (list4 == null) {
            z6 = ((String) list4.get(0)).equals("1");
            z5 = true;
        } else {
            z6 = false;
        }
        list5 = (List) map.get("icy-metaint");
        if (list5 != null) {
            String str5 = (String) list5.get(0);
            try {
                int parseInt = Integer.parseInt(str5);
                if (parseInt > 0) {
                    i8 = parseInt;
                } else {
                    try {
                        String valueOf3 = String.valueOf(str5);
                        n.h("IcyHeaders", valueOf3.length() != 0 ? "Invalid metadata interval: ".concat(valueOf3) : new String("Invalid metadata interval: "));
                        z7 = z5;
                    } catch (NumberFormatException unused3) {
                        i8 = parseInt;
                        String valueOf4 = String.valueOf(str5);
                        n.h("IcyHeaders", valueOf4.length() != 0 ? "Invalid metadata interval: ".concat(valueOf4) : new String("Invalid metadata interval: "));
                        if (z5) {
                        }
                    }
                }
                z5 = z7;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z5) {
            return new b(i6, str, str2, str3, z6, i8);
        }
        return null;
    }

    @Override // n1.a.b
    public /* synthetic */ s0 b() {
        return n1.b.b(this);
    }

    @Override // n1.a.b
    public /* synthetic */ byte[] d() {
        return n1.b.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12919a == bVar.f12919a && com.google.android.exoplayer2.util.s0.c(this.f12920b, bVar.f12920b) && com.google.android.exoplayer2.util.s0.c(this.f12921c, bVar.f12921c) && com.google.android.exoplayer2.util.s0.c(this.f12922d, bVar.f12922d) && this.f12923e == bVar.f12923e && this.f12924f == bVar.f12924f;
    }

    public int hashCode() {
        int i6 = (527 + this.f12919a) * 31;
        String str = this.f12920b;
        int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12921c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12922d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f12923e ? 1 : 0)) * 31) + this.f12924f;
    }

    public String toString() {
        String str = this.f12921c;
        String str2 = this.f12920b;
        int i6 = this.f12919a;
        int i7 = this.f12924f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length());
        sb.append("IcyHeaders: name=\"");
        sb.append(str);
        sb.append("\", genre=\"");
        sb.append(str2);
        sb.append("\", bitrate=");
        sb.append(i6);
        sb.append(", metadataInterval=");
        sb.append(i7);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f12919a);
        parcel.writeString(this.f12920b);
        parcel.writeString(this.f12921c);
        parcel.writeString(this.f12922d);
        com.google.android.exoplayer2.util.s0.X0(parcel, this.f12923e);
        parcel.writeInt(this.f12924f);
    }

    b(Parcel parcel) {
        this.f12919a = parcel.readInt();
        this.f12920b = parcel.readString();
        this.f12921c = parcel.readString();
        this.f12922d = parcel.readString();
        this.f12923e = com.google.android.exoplayer2.util.s0.D0(parcel);
        this.f12924f = parcel.readInt();
    }
}
