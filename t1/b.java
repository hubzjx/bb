package t1;

import com.google.android.exoplayer2.s0;
import n1.a;
/* loaded from: classes.dex */
public abstract class b implements a.b {
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

    public String toString() {
        String simpleName = getClass().getSimpleName();
        return simpleName.length() != 0 ? "SCTE-35 splice command: type=".concat(simpleName) : new String("SCTE-35 splice command: type=");
    }
}
