package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f2705a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f2706b;

    @Override // androidx.lifecycle.d
    public void a(f fVar, c.a aVar) {
        if (aVar == c.a.ON_DESTROY) {
            this.f2705a.removeCallbacks(this.f2706b);
            fVar.h().c(this);
        }
    }
}
