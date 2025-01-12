package androidx.media;

import android.os.Build;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    f f2112a;

    public e(String str, int i6, int i7) {
        this.f2112a = Build.VERSION.SDK_INT >= 28 ? new j(str, i6, i7) : new k(str, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f2112a.equals(((e) obj).f2112a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2112a.hashCode();
    }
}
