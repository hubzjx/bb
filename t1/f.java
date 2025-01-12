package t1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class f extends t1.b {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List f13364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f[] newArray(int i6) {
            return new f[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f13365a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13366b;

        private b(int i6, long j6) {
            this.f13365a = i6;
            this.f13366b = j6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f13365a);
            parcel.writeLong(this.f13366b);
        }

        /* synthetic */ b(int i6, long j6, a aVar) {
            this(i6, j6);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f13367a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13368b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f13369c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f13370d;

        /* renamed from: e  reason: collision with root package name */
        public final long f13371e;

        /* renamed from: f  reason: collision with root package name */
        public final List f13372f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f13373g;

        /* renamed from: h  reason: collision with root package name */
        public final long f13374h;

        /* renamed from: i  reason: collision with root package name */
        public final int f13375i;

        /* renamed from: j  reason: collision with root package name */
        public final int f13376j;

        /* renamed from: k  reason: collision with root package name */
        public final int f13377k;

        private c(long j6, boolean z5, boolean z6, boolean z7, List list, long j7, boolean z8, long j8, int i6, int i7, int i8) {
            this.f13367a = j6;
            this.f13368b = z5;
            this.f13369c = z6;
            this.f13370d = z7;
            this.f13372f = Collections.unmodifiableList(list);
            this.f13371e = j7;
            this.f13373g = z8;
            this.f13374h = j8;
            this.f13375i = i6;
            this.f13376j = i7;
            this.f13377k = i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c e(y yVar) {
            ArrayList arrayList;
            boolean z5;
            long j6;
            boolean z6;
            long j7;
            int i6;
            int i7;
            int i8;
            boolean z7;
            boolean z8;
            long j8;
            long C = yVar.C();
            boolean z9 = (yVar.A() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z9) {
                arrayList = arrayList2;
                z5 = false;
                j6 = -9223372036854775807L;
                z6 = false;
                j7 = -9223372036854775807L;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                z7 = false;
            } else {
                int A = yVar.A();
                boolean z10 = (A & 128) != 0;
                boolean z11 = (A & 64) != 0;
                boolean z12 = (A & 32) != 0;
                long C2 = z11 ? yVar.C() : -9223372036854775807L;
                if (!z11) {
                    int A2 = yVar.A();
                    ArrayList arrayList3 = new ArrayList(A2);
                    for (int i9 = 0; i9 < A2; i9++) {
                        arrayList3.add(new b(yVar.A(), yVar.C(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z12) {
                    long A3 = yVar.A();
                    boolean z13 = (128 & A3) != 0;
                    j8 = ((((A3 & 1) << 32) | yVar.C()) * 1000) / 90;
                    z8 = z13;
                } else {
                    z8 = false;
                    j8 = -9223372036854775807L;
                }
                int G = yVar.G();
                int A4 = yVar.A();
                z7 = z11;
                i8 = yVar.A();
                j7 = j8;
                arrayList = arrayList2;
                long j9 = C2;
                i6 = G;
                i7 = A4;
                j6 = j9;
                boolean z14 = z10;
                z6 = z8;
                z5 = z14;
            }
            return new c(C, z9, z5, z7, arrayList, j6, z6, j7, i6, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.f13367a);
            parcel.writeByte(this.f13368b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f13369c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f13370d ? (byte) 1 : (byte) 0);
            int size = this.f13372f.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                ((b) this.f13372f.get(i6)).d(parcel);
            }
            parcel.writeLong(this.f13371e);
            parcel.writeByte(this.f13373g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f13374h);
            parcel.writeInt(this.f13375i);
            parcel.writeInt(this.f13376j);
            parcel.writeInt(this.f13377k);
        }

        private c(Parcel parcel) {
            this.f13367a = parcel.readLong();
            this.f13368b = parcel.readByte() == 1;
            this.f13369c = parcel.readByte() == 1;
            this.f13370d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i6 = 0; i6 < readInt; i6++) {
                arrayList.add(b.c(parcel));
            }
            this.f13372f = Collections.unmodifiableList(arrayList);
            this.f13371e = parcel.readLong();
            this.f13373g = parcel.readByte() == 1;
            this.f13374h = parcel.readLong();
            this.f13375i = parcel.readInt();
            this.f13376j = parcel.readInt();
            this.f13377k = parcel.readInt();
        }
    }

    private f(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add(c.d(parcel));
        }
        this.f13364a = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f e(y yVar) {
        int A = yVar.A();
        ArrayList arrayList = new ArrayList(A);
        for (int i6 = 0; i6 < A; i6++) {
            arrayList.add(c.e(yVar));
        }
        return new f(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        int size = this.f13364a.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            ((c) this.f13364a.get(i7)).f(parcel);
        }
    }

    /* synthetic */ f(Parcel parcel, a aVar) {
        this(parcel);
    }

    private f(List list) {
        this.f13364a = Collections.unmodifiableList(list);
    }
}
