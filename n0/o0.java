package n0;

import android.view.View;
import android.view.WindowId;
/* loaded from: classes.dex */
class o0 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f12166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(View view) {
        this.f12166a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof o0) && ((o0) obj).f12166a.equals(this.f12166a);
    }

    public int hashCode() {
        return this.f12166a.hashCode();
    }
}
