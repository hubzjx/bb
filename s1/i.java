package s1;

import com.google.android.exoplayer2.s0;
import n1.a;
/* loaded from: classes.dex */
public abstract class i implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final String f13152a;

    public i(String str) {
        this.f13152a = str;
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

    public String toString() {
        return this.f13152a;
    }
}
