package t1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class d extends t1.b {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final long f13348a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f13349b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13350c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13351d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f13352e;

    /* renamed from: f  reason: collision with root package name */
    public final long f13353f;

    /* renamed from: g  reason: collision with root package name */
    public final long f13354g;

    /* renamed from: h  reason: collision with root package name */
    public final List f13355h;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f13356k;

    /* renamed from: l  reason: collision with root package name */
    public final long f13357l;

    /* renamed from: m  reason: collision with root package name */
    public final int f13358m;

    /* renamed from: n  reason: collision with root package name */
    public final int f13359n;

    /* renamed from: o  reason: collision with root package name */
    public final int f13360o;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public d[] newArray(int i6) {
            return new d[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f13361a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13362b;

        /* renamed from: c  reason: collision with root package name */
        public final long f13363c;

        private b(int i6, long j6, long j7) {
            this.f13361a = i6;
            this.f13362b = j6;
            this.f13363c = j7;
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f13361a);
            parcel.writeLong(this.f13362b);
            parcel.writeLong(this.f13363c);
        }

        /* synthetic */ b(int i6, long j6, long j7, a aVar) {
            this(i6, j6, j7);
        }
    }

    private d(long j6, boolean z5, boolean z6, boolean z7, boolean z8, long j7, long j8, List list, boolean z9, long j9, int i6, int i7, int i8) {
        this.f13348a = j6;
        this.f13349b = z5;
        this.f13350c = z6;
        this.f13351d = z7;
        this.f13352e = z8;
        this.f13353f = j7;
        this.f13354g = j8;
        this.f13355h = Collections.unmodifiableList(list);
        this.f13356k = z9;
        this.f13357l = j9;
        this.f13358m = i6;
        this.f13359n = i7;
        this.f13360o = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d e(y yVar, long j6, k0 k0Var) {
        List list;
        boolean z5;
        boolean z6;
        long j7;
        boolean z7;
        long j8;
        int i6;
        int i7;
        int i8;
        boolean z8;
        boolean z9;
        long j9;
        long C = yVar.C();
        boolean z10 = (yVar.A() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z10) {
            list = emptyList;
            z5 = false;
            z6 = false;
            j7 = -9223372036854775807L;
            z7 = false;
            j8 = -9223372036854775807L;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            z8 = false;
        } else {
            int A = yVar.A();
            boolean z11 = (A & 128) != 0;
            boolean z12 = (A & 64) != 0;
            boolean z13 = (A & 32) != 0;
            boolean z14 = (A & 16) != 0;
            long f6 = (!z12 || z14) ? -9223372036854775807L : g.f(yVar, j6);
            if (!z12) {
                int A2 = yVar.A();
                ArrayList arrayList = new ArrayList(A2);
                for (int i9 = 0; i9 < A2; i9++) {
                    int A3 = yVar.A();
                    long f7 = !z14 ? g.f(yVar, j6) : -9223372036854775807L;
                    arrayList.add(new b(A3, f7, k0Var.b(f7), null));
                }
                emptyList = arrayList;
            }
            if (z13) {
                long A4 = yVar.A();
                boolean z15 = (128 & A4) != 0;
                j9 = ((((A4 & 1) << 32) | yVar.C()) * 1000) / 90;
                z9 = z15;
            } else {
                z9 = false;
                j9 = -9223372036854775807L;
            }
            i6 = yVar.G();
            z8 = z12;
            i7 = yVar.A();
            i8 = yVar.A();
            list = emptyList;
            long j10 = f6;
            z7 = z9;
            j8 = j9;
            z6 = z14;
            z5 = z11;
            j7 = j10;
        }
        return new d(C, z10, z5, z8, z6, j7, k0Var.b(j7), list, z7, j8, i6, i7, i8);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f13348a);
        parcel.writeByte(this.f13349b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f13350c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f13351d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f13352e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f13353f);
        parcel.writeLong(this.f13354g);
        int size = this.f13355h.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            ((b) this.f13355h.get(i7)).b(parcel);
        }
        parcel.writeByte(this.f13356k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f13357l);
        parcel.writeInt(this.f13358m);
        parcel.writeInt(this.f13359n);
        parcel.writeInt(this.f13360o);
    }

    private d(Parcel parcel) {
        this.f13348a = parcel.readLong();
        this.f13349b = parcel.readByte() == 1;
        this.f13350c = parcel.readByte() == 1;
        this.f13351d = parcel.readByte() == 1;
        this.f13352e = parcel.readByte() == 1;
        this.f13353f = parcel.readLong();
        this.f13354g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add(b.a(parcel));
        }
        this.f13355h = Collections.unmodifiableList(arrayList);
        this.f13356k = parcel.readByte() == 1;
        this.f13357l = parcel.readLong();
        this.f13358m = parcel.readInt();
        this.f13359n = parcel.readInt();
        this.f13360o = parcel.readInt();
    }

    /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }
}
