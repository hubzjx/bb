package t1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final long f13378a;

    /* renamed from: b  reason: collision with root package name */
    public final long f13379b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public g[] newArray(int i6) {
            return new g[i6];
        }
    }

    private g(long j6, long j7) {
        this.f13378a = j6;
        this.f13379b = j7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g e(y yVar, long j6, k0 k0Var) {
        long f6 = f(yVar, j6);
        return new g(f6, k0Var.b(f6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long f(y yVar, long j6) {
        long A = yVar.A();
        if ((128 & A) != 0) {
            return 8589934591L & ((((A & 1) << 32) | yVar.C()) + j6);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f13378a);
        parcel.writeLong(this.f13379b);
    }

    /* synthetic */ g(long j6, long j7, a aVar) {
        this(j6, j7);
    }
}
