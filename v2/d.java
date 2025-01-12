package v2;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f13680a;

    /* renamed from: b  reason: collision with root package name */
    private long f13681b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f13682c;

    /* renamed from: d  reason: collision with root package name */
    private int f13683d;

    /* renamed from: e  reason: collision with root package name */
    private int f13684e;

    public d(long j6, long j7) {
        this.f13682c = null;
        this.f13683d = 0;
        this.f13684e = 1;
        this.f13680a = j6;
        this.f13681b = j7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(ValueAnimator valueAnimator) {
        d dVar = new d(valueAnimator.getStartDelay(), valueAnimator.getDuration(), e(valueAnimator));
        dVar.f13683d = valueAnimator.getRepeatCount();
        dVar.f13684e = valueAnimator.getRepeatMode();
        return dVar;
    }

    private static TimeInterpolator e(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f13674b : interpolator instanceof AccelerateInterpolator ? a.f13675c : interpolator instanceof DecelerateInterpolator ? a.f13676d : interpolator;
    }

    public long b() {
        return this.f13680a;
    }

    public long c() {
        return this.f13681b;
    }

    public TimeInterpolator d() {
        TimeInterpolator timeInterpolator = this.f13682c;
        return timeInterpolator != null ? timeInterpolator : a.f13674b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (b() == dVar.b() && c() == dVar.c() && f() == dVar.f() && g() == dVar.g()) {
                return d().getClass().equals(dVar.d().getClass());
            }
            return false;
        }
        return false;
    }

    public int f() {
        return this.f13683d;
    }

    public int g() {
        return this.f13684e;
    }

    public int hashCode() {
        return (((((((((int) (b() ^ (b() >>> 32))) * 31) + ((int) (c() ^ (c() >>> 32)))) * 31) + d().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + b() + " duration: " + c() + " interpolator: " + d().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public d(long j6, long j7, TimeInterpolator timeInterpolator) {
        this.f13683d = 0;
        this.f13684e = 1;
        this.f13680a = j6;
        this.f13681b = j7;
        this.f13682c = timeInterpolator;
    }
}
