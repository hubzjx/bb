package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
class f {

    /* renamed from: b  reason: collision with root package name */
    int f2486b;

    /* renamed from: c  reason: collision with root package name */
    int f2487c;

    /* renamed from: d  reason: collision with root package name */
    int f2488d;

    /* renamed from: e  reason: collision with root package name */
    int f2489e;

    /* renamed from: h  reason: collision with root package name */
    boolean f2492h;

    /* renamed from: i  reason: collision with root package name */
    boolean f2493i;

    /* renamed from: a  reason: collision with root package name */
    boolean f2485a = true;

    /* renamed from: f  reason: collision with root package name */
    int f2490f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f2491g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.z zVar) {
        int i6 = this.f2487c;
        return i6 >= 0 && i6 < zVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.u uVar) {
        View o5 = uVar.o(this.f2487c);
        this.f2487c += this.f2488d;
        return o5;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2486b + ", mCurrentPosition=" + this.f2487c + ", mItemDirection=" + this.f2488d + ", mLayoutDirection=" + this.f2489e + ", mStartLine=" + this.f2490f + ", mEndLine=" + this.f2491g + '}';
    }
}
