package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.c;
import e0.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends androidx.fragment.app.g implements LayoutInflater.Factory2 {
    static boolean I;
    static final Interpolator J = new DecelerateInterpolator(2.5f);
    static final Interpolator K = new DecelerateInterpolator(1.5f);
    ArrayList A;
    ArrayList B;
    ArrayList C;
    ArrayList F;
    private androidx.fragment.app.j G;

    /* renamed from: d  reason: collision with root package name */
    ArrayList f1785d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1786e;

    /* renamed from: i  reason: collision with root package name */
    ArrayList f1790i;

    /* renamed from: j  reason: collision with root package name */
    ArrayList f1791j;

    /* renamed from: k  reason: collision with root package name */
    private OnBackPressedDispatcher f1792k;

    /* renamed from: m  reason: collision with root package name */
    ArrayList f1794m;

    /* renamed from: n  reason: collision with root package name */
    ArrayList f1795n;

    /* renamed from: o  reason: collision with root package name */
    ArrayList f1796o;

    /* renamed from: r  reason: collision with root package name */
    androidx.fragment.app.f f1799r;

    /* renamed from: s  reason: collision with root package name */
    androidx.fragment.app.c f1800s;

    /* renamed from: t  reason: collision with root package name */
    Fragment f1801t;

    /* renamed from: u  reason: collision with root package name */
    Fragment f1802u;

    /* renamed from: v  reason: collision with root package name */
    boolean f1803v;

    /* renamed from: w  reason: collision with root package name */
    boolean f1804w;

    /* renamed from: x  reason: collision with root package name */
    boolean f1805x;

    /* renamed from: y  reason: collision with root package name */
    boolean f1806y;

    /* renamed from: z  reason: collision with root package name */
    boolean f1807z;

    /* renamed from: f  reason: collision with root package name */
    int f1787f = 0;

    /* renamed from: g  reason: collision with root package name */
    final ArrayList f1788g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    final HashMap f1789h = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private final androidx.activity.b f1793l = new a(false);

    /* renamed from: p  reason: collision with root package name */
    private final CopyOnWriteArrayList f1797p = new CopyOnWriteArrayList();

    /* renamed from: q  reason: collision with root package name */
    int f1798q = 0;
    Bundle D = null;
    SparseArray E = null;
    Runnable H = new b();

    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z5) {
            super(z5);
        }

        @Override // androidx.activity.b
        public void b() {
            h.this.B0();
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1811b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f1811b.l() != null) {
                    c.this.f1811b.d1(null);
                    c cVar = c.this;
                    h hVar = h.this;
                    Fragment fragment = cVar.f1811b;
                    hVar.R0(fragment, fragment.H(), 0, 0, false);
                }
            }
        }

        c(ViewGroup viewGroup, Fragment fragment) {
            this.f1810a = viewGroup;
            this.f1811b = fragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1810a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1814a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f1815b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1816c;

        d(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1814a = viewGroup;
            this.f1815b = view;
            this.f1816c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1814a.endViewTransition(this.f1815b);
            Animator m5 = this.f1816c.m();
            this.f1816c.e1(null);
            if (m5 == null || this.f1814a.indexOfChild(this.f1815b) >= 0) {
                return;
            }
            h hVar = h.this;
            Fragment fragment = this.f1816c;
            hVar.R0(fragment, fragment.H(), 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1818a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f1819b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1820c;

        e(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1818a = viewGroup;
            this.f1819b = view;
            this.f1820c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1818a.endViewTransition(this.f1819b);
            animator.removeListener(this);
            Fragment fragment = this.f1820c;
            View view = fragment.H;
            if (view == null || !fragment.f1714z) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends androidx.fragment.app.e {
        f() {
        }

        @Override // androidx.fragment.app.e
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.f fVar = h.this.f1799r;
            return fVar.c(fVar.i(), str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f1823a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f1824b;

        g(Animator animator) {
            this.f1823a = null;
            this.f1824b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        g(Animation animation) {
            this.f1823a = animation;
            this.f1824b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0016h extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f1825a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1826b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1827c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1828d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1829e;

        RunnableC0016h(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1829e = true;
            this.f1825a = viewGroup;
            this.f1826b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j6, Transformation transformation) {
            this.f1829e = true;
            if (this.f1827c) {
                return !this.f1828d;
            }
            if (!super.getTransformation(j6, transformation)) {
                this.f1827c = true;
                w.a(this.f1825a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1827c || !this.f1829e) {
                this.f1825a.endViewTransition(this.f1826b);
                this.f1828d = true;
                return;
            }
            this.f1829e = false;
            this.f1825a.post(this);
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j6, Transformation transformation, float f6) {
            this.f1829e = true;
            if (this.f1827c) {
                return !this.f1828d;
            }
            if (!super.getTransformation(j6, transformation, f6)) {
                this.f1827c = true;
                w.a(this.f1825a, this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f1830a = {16842755, 16842960, 16842961};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface j {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* loaded from: classes.dex */
    private class k implements j {

        /* renamed from: a  reason: collision with root package name */
        final String f1831a;

        /* renamed from: b  reason: collision with root package name */
        final int f1832b;

        /* renamed from: c  reason: collision with root package name */
        final int f1833c;

        k(String str, int i6, int i7) {
            this.f1831a = str;
            this.f1832b = i6;
            this.f1833c = i7;
        }

        @Override // androidx.fragment.app.h.j
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = h.this.f1802u;
            if (fragment == null || this.f1832b >= 0 || this.f1831a != null || !fragment.o().f()) {
                return h.this.V0(arrayList, arrayList2, this.f1831a, this.f1832b, this.f1833c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l implements Fragment.f {

        /* renamed from: a  reason: collision with root package name */
        final boolean f1835a;

        /* renamed from: b  reason: collision with root package name */
        final androidx.fragment.app.a f1836b;

        /* renamed from: c  reason: collision with root package name */
        private int f1837c;

        l(androidx.fragment.app.a aVar, boolean z5) {
            this.f1835a = z5;
            this.f1836b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.f
        public void a() {
            int i6 = this.f1837c - 1;
            this.f1837c = i6;
            if (i6 != 0) {
                return;
            }
            this.f1836b.f1758s.h1();
        }

        @Override // androidx.fragment.app.Fragment.f
        public void b() {
            this.f1837c++;
        }

        public void c() {
            androidx.fragment.app.a aVar = this.f1836b;
            aVar.f1758s.t(aVar, this.f1835a, false, false);
        }

        public void d() {
            boolean z5 = this.f1837c > 0;
            h hVar = this.f1836b.f1758s;
            int size = hVar.f1788g.size();
            for (int i6 = 0; i6 < size; i6++) {
                Fragment fragment = (Fragment) hVar.f1788g.get(i6);
                fragment.j1(null);
                if (z5 && fragment.Q()) {
                    fragment.l1();
                }
            }
            androidx.fragment.app.a aVar = this.f1836b;
            aVar.f1758s.t(aVar, this.f1835a, !z5, true);
        }

        public boolean e() {
            return this.f1837c == 0;
        }
    }

    private boolean E0(Fragment fragment) {
        return (fragment.D && fragment.E) || fragment.f1709u.q();
    }

    static g K0(float f6, float f7) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f6, f7);
        alphaAnimation.setInterpolator(K);
        alphaAnimation.setDuration(220L);
        return new g(alphaAnimation);
    }

    static g M0(float f6, float f7, float f8, float f9) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f6, f7, f6, f7, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(J);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f8, f9);
        alphaAnimation.setInterpolator(K);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new g(animationSet);
    }

    private void N0(l.b bVar) {
        int size = bVar.size();
        for (int i6 = 0; i6 < size; i6++) {
            Fragment fragment = (Fragment) bVar.h(i6);
            if (!fragment.f1700l) {
                View a12 = fragment.a1();
                fragment.P = a12.getAlpha();
                a12.setAlpha(0.0f);
            }
        }
    }

    private boolean U0(String str, int i6, int i7) {
        j0();
        h0(true);
        Fragment fragment = this.f1802u;
        if (fragment == null || i6 >= 0 || str != null || !fragment.o().f()) {
            boolean V0 = V0(this.A, this.B, str, i6, i7);
            if (V0) {
                this.f1786e = true;
                try {
                    Z0(this.A, this.B);
                } finally {
                    s();
                }
            }
            p1();
            e0();
            p();
            return V0;
        }
        return true;
    }

    private void V(Fragment fragment) {
        if (fragment == null || this.f1789h.get(fragment.f1694f) != fragment) {
            return;
        }
        fragment.S0();
    }

    private int W0(ArrayList arrayList, ArrayList arrayList2, int i6, int i7, l.b bVar) {
        int i8 = i7;
        for (int i9 = i7 - 1; i9 >= i6; i9--) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i9);
            boolean booleanValue = ((Boolean) arrayList2.get(i9)).booleanValue();
            if (aVar.v() && !aVar.t(arrayList, i9 + 1, i7)) {
                if (this.F == null) {
                    this.F = new ArrayList();
                }
                l lVar = new l(aVar, booleanValue);
                this.F.add(lVar);
                aVar.x(lVar);
                if (booleanValue) {
                    aVar.o();
                } else {
                    aVar.p(false);
                }
                i8--;
                if (i9 != i8) {
                    arrayList.remove(i9);
                    arrayList.add(i8, aVar);
                }
                h(bVar);
            }
        }
        return i8;
    }

    private void Z0(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        n0(arrayList, arrayList2);
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i6)).f1880q) {
                if (i7 != i6) {
                    m0(arrayList, arrayList2, i7, i6);
                }
                i7 = i6 + 1;
                if (((Boolean) arrayList2.get(i6)).booleanValue()) {
                    while (i7 < size && ((Boolean) arrayList2.get(i7)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i7)).f1880q) {
                        i7++;
                    }
                }
                m0(arrayList, arrayList2, i6, i7);
                i6 = i7 - 1;
            }
            i6++;
        }
        if (i7 != size) {
            m0(arrayList, arrayList2, i7, size);
        }
    }

    private void c0(int i6) {
        try {
            this.f1786e = true;
            P0(i6, false);
            this.f1786e = false;
            j0();
        } catch (Throwable th) {
            this.f1786e = false;
            throw th;
        }
    }

    public static int d1(int i6) {
        if (i6 != 4097) {
            if (i6 != 4099) {
                return i6 != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    private void f0() {
        for (Fragment fragment : this.f1789h.values()) {
            if (fragment != null) {
                if (fragment.l() != null) {
                    int H = fragment.H();
                    View l6 = fragment.l();
                    Animation animation = l6.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        l6.clearAnimation();
                    }
                    fragment.d1(null);
                    R0(fragment, H, 0, 0, false);
                } else if (fragment.m() != null) {
                    fragment.m().end();
                }
            }
        }
    }

    private void h(l.b bVar) {
        int i6 = this.f1798q;
        if (i6 < 1) {
            return;
        }
        int min = Math.min(i6, 3);
        int size = this.f1788g.size();
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragment = (Fragment) this.f1788g.get(i7);
            if (fragment.f1690b < min) {
                R0(fragment, min, fragment.x(), fragment.y(), false);
                if (fragment.H != null && !fragment.f1714z && fragment.N) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void h0(boolean z5) {
        if (this.f1786e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1799r == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f1799r.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z5) {
            r();
        }
        if (this.A == null) {
            this.A = new ArrayList();
            this.B = new ArrayList();
        }
        this.f1786e = true;
        try {
            n0(null, null);
        } finally {
            this.f1786e = false;
        }
    }

    private static void l0(ArrayList arrayList, ArrayList arrayList2, int i6, int i7) {
        while (i6 < i7) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i6);
            if (((Boolean) arrayList2.get(i6)).booleanValue()) {
                aVar.k(-1);
                aVar.p(i6 == i7 + (-1));
            } else {
                aVar.k(1);
                aVar.o();
            }
            i6++;
        }
    }

    private void m(Fragment fragment, g gVar, int i6) {
        View view = fragment.H;
        ViewGroup viewGroup = fragment.G;
        viewGroup.startViewTransition(view);
        fragment.k1(i6);
        if (gVar.f1823a != null) {
            RunnableC0016h runnableC0016h = new RunnableC0016h(gVar.f1823a, viewGroup, view);
            fragment.d1(fragment.H);
            runnableC0016h.setAnimationListener(new c(viewGroup, fragment));
            fragment.H.startAnimation(runnableC0016h);
            return;
        }
        Animator animator = gVar.f1824b;
        fragment.e1(animator);
        animator.addListener(new d(viewGroup, view, fragment));
        animator.setTarget(fragment.H);
        animator.start();
    }

    private void m0(ArrayList arrayList, ArrayList arrayList2, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i6;
        boolean z5 = ((androidx.fragment.app.a) arrayList.get(i10)).f1880q;
        ArrayList arrayList3 = this.C;
        if (arrayList3 == null) {
            this.C = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.C.addAll(this.f1788g);
        Fragment z02 = z0();
        boolean z6 = false;
        for (int i11 = i10; i11 < i7; i11++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i11);
            z02 = !((Boolean) arrayList2.get(i11)).booleanValue() ? aVar.q(this.C, z02) : aVar.y(this.C, z02);
            z6 = z6 || aVar.f1871h;
        }
        this.C.clear();
        if (!z5) {
            m.B(this, arrayList, arrayList2, i6, i7, false);
        }
        l0(arrayList, arrayList2, i6, i7);
        if (z5) {
            l.b bVar = new l.b();
            h(bVar);
            int W0 = W0(arrayList, arrayList2, i6, i7, bVar);
            N0(bVar);
            i8 = W0;
        } else {
            i8 = i7;
        }
        if (i8 != i10 && z5) {
            m.B(this, arrayList, arrayList2, i6, i8, true);
            P0(this.f1798q, true);
        }
        while (i10 < i7) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue() && (i9 = aVar2.f1760u) >= 0) {
                t0(i9);
                aVar2.f1760u = -1;
            }
            aVar2.w();
            i10++;
        }
        if (z6) {
            b1();
        }
    }

    private void n0(ArrayList arrayList, ArrayList arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList arrayList3 = this.F;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i6 = 0;
        while (i6 < size) {
            l lVar = (l) this.F.get(i6);
            if (arrayList == null || lVar.f1835a || (indexOf2 = arrayList.indexOf(lVar.f1836b)) == -1 || !((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                if (lVar.e() || (arrayList != null && lVar.f1836b.t(arrayList, 0, arrayList.size()))) {
                    this.F.remove(i6);
                    i6--;
                    size--;
                    if (arrayList == null || lVar.f1835a || (indexOf = arrayList.indexOf(lVar.f1836b)) == -1 || !((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        lVar.d();
                    }
                }
                i6++;
            } else {
                this.F.remove(i6);
                i6--;
                size--;
            }
            lVar.c();
            i6++;
        }
    }

    private void n1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new d0.c("FragmentManager"));
        androidx.fragment.app.f fVar = this.f1799r;
        try {
            if (fVar != null) {
                fVar.l("  ", null, printWriter, new String[0]);
            } else {
                b("  ", null, printWriter, new String[0]);
            }
        } catch (Exception e6) {
            Log.e("FragmentManager", "Failed dumping state", e6);
        }
        throw runtimeException;
    }

    public static int o1(int i6, boolean z5) {
        if (i6 == 4097) {
            return z5 ? 1 : 2;
        } else if (i6 == 4099) {
            return z5 ? 5 : 6;
        } else if (i6 != 8194) {
            return -1;
        } else {
            return z5 ? 3 : 4;
        }
    }

    private void p() {
        this.f1789h.values().removeAll(Collections.singleton(null));
    }

    private void p1() {
        ArrayList arrayList = this.f1785d;
        boolean z5 = true;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f1793l.f((v0() <= 0 || !F0(this.f1801t)) ? false : false);
        } else {
            this.f1793l.f(true);
        }
    }

    private void r() {
        if (H0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private Fragment r0(Fragment fragment) {
        ViewGroup viewGroup = fragment.G;
        View view = fragment.H;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f1788g.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = (Fragment) this.f1788g.get(indexOf);
                if (fragment2.G == viewGroup && fragment2.H != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void s() {
        this.f1786e = false;
        this.B.clear();
        this.A.clear();
    }

    private void s0() {
        if (this.F != null) {
            while (!this.F.isEmpty()) {
                ((l) this.F.remove(0)).d();
            }
        }
    }

    private boolean u0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this) {
            ArrayList arrayList3 = this.f1785d;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size = this.f1785d.size();
                boolean z5 = false;
                for (int i6 = 0; i6 < size; i6++) {
                    z5 |= ((j) this.f1785d.get(i6)).a(arrayList, arrayList2);
                }
                this.f1785d.clear();
                this.f1799r.j().removeCallbacks(this.H);
                return z5;
            }
            return false;
        }
    }

    public boolean A(Menu menu, MenuInflater menuInflater) {
        if (this.f1798q < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null && fragment.F0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z5 = true;
            }
        }
        if (this.f1791j != null) {
            for (int i7 = 0; i7 < this.f1791j.size(); i7++) {
                Fragment fragment2 = (Fragment) this.f1791j.get(i7);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.f0();
                }
            }
        }
        this.f1791j = arrayList;
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.o A0(Fragment fragment) {
        return this.G.i(fragment);
    }

    public void B() {
        this.f1806y = true;
        j0();
        c0(0);
        this.f1799r = null;
        this.f1800s = null;
        this.f1801t = null;
        if (this.f1792k != null) {
            this.f1793l.d();
            this.f1792k = null;
        }
    }

    void B0() {
        j0();
        if (this.f1793l.c()) {
            f();
        } else {
            this.f1792k.c();
        }
    }

    public void C() {
        c0(1);
    }

    public void C0(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f1714z) {
            return;
        }
        fragment.f1714z = true;
        fragment.O = true ^ fragment.O;
    }

    public void D() {
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null) {
                fragment.L0();
            }
        }
    }

    public boolean D0() {
        return this.f1806y;
    }

    public void E(boolean z5) {
        for (int size = this.f1788g.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1788g.get(size);
            if (fragment != null) {
                fragment.M0(z5);
            }
        }
    }

    void F(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).F(fragment, bundle, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        h hVar = fragment.f1707s;
        return fragment == hVar.z0() && F0(hVar.f1801t);
    }

    void G(Fragment fragment, Context context, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).G(fragment, context, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G0(int i6) {
        return this.f1798q >= i6;
    }

    void H(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).H(fragment, bundle, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public boolean H0() {
        return this.f1804w || this.f1805x;
    }

    void I(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).I(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    g I0(Fragment fragment, int i6, boolean z5, int i7) {
        int o12;
        int x5 = fragment.x();
        boolean z6 = false;
        fragment.h1(0);
        ViewGroup viewGroup = fragment.G;
        if (viewGroup == null || viewGroup.getLayoutTransition() == null) {
            Animation a02 = fragment.a0(i6, z5, x5);
            if (a02 != null) {
                return new g(a02);
            }
            Animator b02 = fragment.b0(i6, z5, x5);
            if (b02 != null) {
                return new g(b02);
            }
            if (x5 != 0) {
                boolean equals = "anim".equals(this.f1799r.i().getResources().getResourceTypeName(x5));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.f1799r.i(), x5);
                        if (loadAnimation != null) {
                            return new g(loadAnimation);
                        }
                        z6 = true;
                    } catch (Resources.NotFoundException e6) {
                        throw e6;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z6) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(this.f1799r.i(), x5);
                        if (loadAnimator != null) {
                            return new g(loadAnimator);
                        }
                    } catch (RuntimeException e7) {
                        if (equals) {
                            throw e7;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f1799r.i(), x5);
                        if (loadAnimation2 != null) {
                            return new g(loadAnimation2);
                        }
                    }
                }
            }
            if (i6 != 0 && (o12 = o1(i6, z5)) >= 0) {
                switch (o12) {
                    case 1:
                        return M0(1.125f, 1.0f, 0.0f, 1.0f);
                    case 2:
                        return M0(1.0f, 0.975f, 1.0f, 0.0f);
                    case 3:
                        return M0(0.975f, 1.0f, 0.0f, 1.0f);
                    case 4:
                        return M0(1.0f, 1.075f, 1.0f, 0.0f);
                    case 5:
                        return K0(0.0f, 1.0f);
                    case 6:
                        return K0(1.0f, 0.0f);
                    default:
                        if (i7 == 0 && this.f1799r.p()) {
                            this.f1799r.o();
                        }
                        return null;
                }
            }
            return null;
        }
        return null;
    }

    void J(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).J(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J0(Fragment fragment) {
        if (this.f1789h.get(fragment.f1694f) != null) {
            return;
        }
        this.f1789h.put(fragment.f1694f, fragment);
        if (fragment.C) {
            if (fragment.B) {
                k(fragment);
            } else {
                a1(fragment);
            }
            fragment.C = false;
        }
        if (I) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void K(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).K(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    void L(Fragment fragment, Context context, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).L(fragment, context, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    void L0(Fragment fragment) {
        if (this.f1789h.get(fragment.f1694f) == null) {
            return;
        }
        if (I) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f1789h.values()) {
            if (fragment2 != null && fragment.f1694f.equals(fragment2.f1697i)) {
                fragment2.f1696h = fragment;
                fragment2.f1697i = null;
            }
        }
        this.f1789h.put(fragment.f1694f, null);
        a1(fragment);
        String str = fragment.f1697i;
        if (str != null) {
            fragment.f1696h = (Fragment) this.f1789h.get(str);
        }
        fragment.M();
    }

    void M(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).M(fragment, bundle, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    void N(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).N(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    void O(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).O(fragment, bundle, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.f1789h.containsKey(fragment.f1694f)) {
            if (I) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f1798q + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i6 = this.f1798q;
        if (fragment.f1701m) {
            i6 = fragment.P() ? Math.min(i6, 1) : Math.min(i6, 0);
        }
        R0(fragment, i6, fragment.y(), fragment.z(), false);
        if (fragment.H != null) {
            Fragment r02 = r0(fragment);
            if (r02 != null) {
                View view = r02.H;
                ViewGroup viewGroup = fragment.G;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.H);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.H, indexOfChild);
                }
            }
            if (fragment.N && fragment.G != null) {
                float f6 = fragment.P;
                if (f6 > 0.0f) {
                    fragment.H.setAlpha(f6);
                }
                fragment.P = 0.0f;
                fragment.N = false;
                g I0 = I0(fragment, fragment.y(), true, fragment.z());
                if (I0 != null) {
                    Animation animation = I0.f1823a;
                    if (animation != null) {
                        fragment.H.startAnimation(animation);
                    } else {
                        I0.f1824b.setTarget(fragment.H);
                        I0.f1824b.start();
                    }
                }
            }
        }
        if (fragment.O) {
            u(fragment);
        }
    }

    void P(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).P(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(int i6, boolean z5) {
        androidx.fragment.app.f fVar;
        if (this.f1799r == null && i6 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z5 || i6 != this.f1798q) {
            this.f1798q = i6;
            int size = this.f1788g.size();
            for (int i7 = 0; i7 < size; i7++) {
                O0((Fragment) this.f1788g.get(i7));
            }
            for (Fragment fragment : this.f1789h.values()) {
                if (fragment != null && (fragment.f1701m || fragment.A)) {
                    if (!fragment.N) {
                        O0(fragment);
                    }
                }
            }
            m1();
            if (this.f1803v && (fVar = this.f1799r) != null && this.f1798q == 4) {
                fVar.r();
                this.f1803v = false;
            }
        }
    }

    void Q(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).Q(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    void Q0(Fragment fragment) {
        R0(fragment, this.f1798q, 0, 0, false);
    }

    void R(Fragment fragment, View view, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).R(fragment, view, bundle, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
        if (r0 != 3) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:272:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R0(Fragment fragment, int i6, int i7, int i8, boolean z5) {
        int i9;
        Fragment fragment2;
        ViewGroup viewGroup;
        String str;
        String str2;
        ViewGroup viewGroup2;
        String str3;
        int i10;
        int i11 = 1;
        boolean z6 = true;
        boolean isChangingConfigurations = true;
        if (!fragment.f1700l || fragment.A) {
            i9 = i6;
            if (i9 > 1) {
                i9 = 1;
            }
        } else {
            i9 = i6;
        }
        if (fragment.f1701m && i9 > (i10 = fragment.f1690b)) {
            i9 = (i10 == 0 && fragment.P()) ? 1 : fragment.f1690b;
        }
        if (fragment.J && fragment.f1690b < 3 && i9 > 2) {
            i9 = 2;
        }
        c.b bVar = fragment.S;
        int min = bVar == c.b.CREATED ? Math.min(i9, 1) : Math.min(i9, bVar.ordinal());
        int i12 = fragment.f1690b;
        if (i12 <= min) {
            if (fragment.f1702n && !fragment.f1703o) {
                return;
            }
            if (fragment.l() != null || fragment.m() != null) {
                fragment.d1(null);
                fragment.e1(null);
                R0(fragment, fragment.H(), 0, 0, true);
            }
            int i13 = fragment.f1690b;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                    }
                    if (min > 2) {
                        if (I) {
                            Log.v("FragmentManager", "moveto STARTED: " + fragment);
                        }
                        fragment.V0();
                        P(fragment, false);
                    }
                    if (min > 3) {
                        if (I) {
                            Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                        }
                        fragment.T0();
                        N(fragment, false);
                        fragment.f1691c = null;
                        fragment.f1692d = null;
                    }
                }
            } else if (min > 0) {
                if (I) {
                    Log.v("FragmentManager", "moveto CREATED: " + fragment);
                }
                Bundle bundle = fragment.f1691c;
                if (bundle != null) {
                    bundle.setClassLoader(this.f1799r.i().getClassLoader());
                    fragment.f1692d = fragment.f1691c.getSparseParcelableArray("android:view_state");
                    Fragment x02 = x0(fragment.f1691c, "android:target_state");
                    String str4 = x02 != null ? x02.f1694f : null;
                    fragment.f1697i = str4;
                    if (str4 != null) {
                        fragment.f1698j = fragment.f1691c.getInt("android:target_req_state", 0);
                    }
                    Boolean bool = fragment.f1693e;
                    if (bool != null) {
                        fragment.K = bool.booleanValue();
                        fragment.f1693e = null;
                    } else {
                        fragment.K = fragment.f1691c.getBoolean("android:user_visible_hint", true);
                    }
                    if (!fragment.K) {
                        fragment.J = true;
                        if (min > 2) {
                            min = 2;
                        }
                    }
                }
                androidx.fragment.app.f fVar = this.f1799r;
                fragment.f1708t = fVar;
                Fragment fragment3 = this.f1801t;
                fragment.f1710v = fragment3;
                fragment.f1707s = fragment3 != null ? fragment3.f1709u : fVar.f1782f;
                Fragment fragment4 = fragment.f1696h;
                if (fragment4 != null) {
                    Object obj = this.f1789h.get(fragment4.f1694f);
                    Fragment fragment5 = fragment.f1696h;
                    if (obj != fragment5) {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.f1696h + " that does not belong to this FragmentManager!");
                    }
                    if (fragment5.f1690b < 1) {
                        str = "Fragment ";
                        str2 = " declared target fragment ";
                        R0(fragment5, 1, 0, 0, true);
                    } else {
                        str = "Fragment ";
                        str2 = " declared target fragment ";
                    }
                    fragment.f1697i = fragment.f1696h.f1694f;
                    fragment.f1696h = null;
                } else {
                    str = "Fragment ";
                    str2 = " declared target fragment ";
                }
                String str5 = fragment.f1697i;
                if (str5 != null) {
                    Fragment fragment6 = (Fragment) this.f1789h.get(str5);
                    if (fragment6 == null) {
                        throw new IllegalStateException(str + fragment + str2 + fragment.f1697i + " that does not belong to this FragmentManager!");
                    } else if (fragment6.f1690b < 1) {
                        R0(fragment6, 1, 0, 0, true);
                    }
                }
                L(fragment, this.f1799r.i(), false);
                fragment.B0();
                Fragment fragment7 = fragment.f1710v;
                if (fragment7 == null) {
                    this.f1799r.k(fragment);
                } else {
                    fragment7.X(fragment);
                }
                G(fragment, this.f1799r.i(), false);
                if (fragment.R) {
                    fragment.b1(fragment.f1691c);
                    fragment.f1690b = 1;
                } else {
                    M(fragment, fragment.f1691c, false);
                    fragment.E0(fragment.f1691c);
                    H(fragment, fragment.f1691c, false);
                }
            }
            if (min > 0) {
                i0(fragment);
            }
            if (min > 1) {
                if (I) {
                    Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                }
                if (!fragment.f1702n) {
                    int i14 = fragment.f1712x;
                    if (i14 != 0) {
                        if (i14 == -1) {
                            n1(new IllegalArgumentException("Cannot create fragment " + fragment + " for a container view with no id"));
                        }
                        viewGroup2 = (ViewGroup) this.f1800s.d(fragment.f1712x);
                        if (viewGroup2 == null && !fragment.f1704p) {
                            try {
                                str3 = fragment.C().getResourceName(fragment.f1712x);
                            } catch (Resources.NotFoundException unused) {
                                str3 = "unknown";
                            }
                            n1(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.f1712x) + " (" + str3 + ") for fragment " + fragment));
                        }
                    } else {
                        viewGroup2 = null;
                    }
                    fragment.G = viewGroup2;
                    fragment.G0(fragment.K0(fragment.f1691c), viewGroup2, fragment.f1691c);
                    View view = fragment.H;
                    if (view != null) {
                        fragment.I = view;
                        view.setSaveFromParentEnabled(false);
                        if (viewGroup2 != null) {
                            viewGroup2.addView(fragment.H);
                        }
                        if (fragment.f1714z) {
                            fragment.H.setVisibility(8);
                        }
                        fragment.y0(fragment.H, fragment.f1691c);
                        R(fragment, fragment.H, fragment.f1691c, false);
                        fragment.N = (fragment.H.getVisibility() != 0 || fragment.G == null) ? false : false;
                    } else {
                        fragment.I = null;
                    }
                }
                fragment.A0(fragment.f1691c);
                F(fragment, fragment.f1691c, false);
                if (fragment.H != null) {
                    fragment.c1(fragment.f1691c);
                }
                fragment.f1691c = null;
            }
            if (min > 2) {
            }
            if (min > 3) {
            }
        } else if (i12 > min) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 == 4) {
                            if (min < 4) {
                                if (I) {
                                    Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                                }
                                fragment.P0();
                                K(fragment, false);
                            }
                        }
                    }
                    if (min < 3) {
                        if (I) {
                            Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                        }
                        fragment.W0();
                        Q(fragment, false);
                    }
                }
                if (min < 2) {
                    if (I) {
                        Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                    }
                    if (fragment.H != null && this.f1799r.q(fragment) && fragment.f1692d == null) {
                        g1(fragment);
                    }
                    fragment.I0();
                    S(fragment, false);
                    View view2 = fragment.H;
                    if (view2 != null && (viewGroup = fragment.G) != null) {
                        viewGroup.endViewTransition(view2);
                        fragment.H.clearAnimation();
                        if (fragment.A() == null || !fragment.A().f1701m) {
                            g I0 = (this.f1798q <= 0 || this.f1806y || fragment.H.getVisibility() != 0 || fragment.P < 0.0f) ? null : I0(fragment, i7, false, i8);
                            fragment.P = 0.0f;
                            if (I0 != null) {
                                m(fragment, I0, min);
                            }
                            fragment.G.removeView(fragment.H);
                        }
                    }
                    fragment.G = null;
                    fragment.H = null;
                    fragment.U = null;
                    fragment.V.g(null);
                    fragment.I = null;
                    fragment.f1703o = false;
                }
            }
            if (min < 1) {
                if (this.f1806y) {
                    if (fragment.l() != null) {
                        View l6 = fragment.l();
                        fragment.d1(null);
                        l6.clearAnimation();
                    } else if (fragment.m() != null) {
                        Animator m5 = fragment.m();
                        fragment.e1(null);
                        m5.cancel();
                    }
                }
                if (fragment.l() != null || fragment.m() != null) {
                    fragment.k1(min);
                    if (fragment.f1690b == i11) {
                        Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i11 + " found " + fragment.f1690b);
                        fragment.f1690b = i11;
                        return;
                    }
                    return;
                }
                if (I) {
                    Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                }
                boolean z7 = fragment.f1701m && !fragment.P();
                if (z7 || this.G.l(fragment)) {
                    androidx.fragment.app.f fVar2 = this.f1799r;
                    if (fVar2 instanceof androidx.lifecycle.p) {
                        isChangingConfigurations = this.G.j();
                    } else if (fVar2.i() instanceof Activity) {
                        isChangingConfigurations = true ^ ((Activity) this.f1799r.i()).isChangingConfigurations();
                    }
                    if (z7 || isChangingConfigurations) {
                        this.G.e(fragment);
                    }
                    fragment.H0();
                    I(fragment, false);
                } else {
                    fragment.f1690b = 0;
                }
                fragment.J0();
                J(fragment, false);
                if (!z5) {
                    if (z7 || this.G.l(fragment)) {
                        L0(fragment);
                    } else {
                        fragment.f1708t = null;
                        fragment.f1710v = null;
                        fragment.f1707s = null;
                        String str6 = fragment.f1697i;
                        if (str6 != null && (fragment2 = (Fragment) this.f1789h.get(str6)) != null && fragment2.D()) {
                            fragment.f1696h = fragment2;
                        }
                    }
                }
            }
        }
        i11 = min;
        if (fragment.f1690b == i11) {
        }
    }

    void S(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f1801t;
        if (fragment2 != null) {
            androidx.fragment.app.g u5 = fragment2.u();
            if (u5 instanceof h) {
                ((h) u5).S(fragment, true);
            }
        }
        Iterator it = this.f1797p.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public void S0() {
        this.f1804w = false;
        this.f1805x = false;
        int size = this.f1788g.size();
        for (int i6 = 0; i6 < size; i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null) {
                fragment.S();
            }
        }
    }

    public boolean T(MenuItem menuItem) {
        if (this.f1798q < 1) {
            return false;
        }
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null && fragment.N0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void T0(Fragment fragment) {
        if (fragment.J) {
            if (this.f1786e) {
                this.f1807z = true;
                return;
            }
            fragment.J = false;
            R0(fragment, this.f1798q, 0, 0, false);
        }
    }

    public void U(Menu menu) {
        if (this.f1798q < 1) {
            return;
        }
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null) {
                fragment.O0(menu);
            }
        }
    }

    boolean V0(ArrayList arrayList, ArrayList arrayList2, String str, int i6, int i7) {
        int i8;
        ArrayList arrayList3 = this.f1790i;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i6 < 0 && (i7 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1790i.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i6 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f1790i.get(size2);
                    if ((str != null && str.equals(aVar.r())) || (i6 >= 0 && i6 == aVar.f1760u)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i7 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f1790i.get(size2);
                        if (str == null || !str.equals(aVar2.r())) {
                            if (i6 < 0 || i6 != aVar2.f1760u) {
                                break;
                            }
                        }
                    }
                }
                i8 = size2;
            } else {
                i8 = -1;
            }
            if (i8 == this.f1790i.size() - 1) {
                return false;
            }
            for (int size3 = this.f1790i.size() - 1; size3 > i8; size3--) {
                arrayList.add(this.f1790i.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void W() {
        c0(3);
    }

    public void X(boolean z5) {
        for (int size = this.f1788g.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1788g.get(size);
            if (fragment != null) {
                fragment.Q0(z5);
            }
        }
    }

    public void X0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f1707s != this) {
            n1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f1694f);
    }

    public boolean Y(Menu menu) {
        if (this.f1798q < 1) {
            return false;
        }
        boolean z5 = false;
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null && fragment.R0(menu)) {
                z5 = true;
            }
        }
        return z5;
    }

    public void Y0(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f1706r);
        }
        boolean z5 = !fragment.P();
        if (!fragment.A || z5) {
            synchronized (this.f1788g) {
                this.f1788g.remove(fragment);
            }
            if (E0(fragment)) {
                this.f1803v = true;
            }
            fragment.f1700l = false;
            fragment.f1701m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        p1();
        V(this.f1802u);
    }

    @Override // androidx.fragment.app.g
    public androidx.fragment.app.l a() {
        return new androidx.fragment.app.a(this);
    }

    public void a0() {
        this.f1804w = false;
        this.f1805x = false;
        c0(4);
    }

    void a1(Fragment fragment) {
        if (H0()) {
            if (I) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.G.k(fragment) && I) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // androidx.fragment.app.g
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f1789h.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f1789h.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.d(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f1788g.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i6 = 0; i6 < size5; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.f1788g.get(i6)).toString());
            }
        }
        ArrayList arrayList = this.f1791j;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i7 = 0; i7 < size4; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.f1791j.get(i7)).toString());
            }
        }
        ArrayList arrayList2 = this.f1790i;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i8 = 0; i8 < size3; i8++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f1790i.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.m(str2, printWriter);
            }
        }
        synchronized (this) {
            ArrayList arrayList3 = this.f1794m;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i9 = 0; i9 < size2; i9++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i9);
                    printWriter.print(": ");
                    printWriter.println((androidx.fragment.app.a) this.f1794m.get(i9));
                }
            }
            ArrayList arrayList4 = this.f1795n;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1795n.toArray()));
            }
        }
        ArrayList arrayList5 = this.f1785d;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i10 = 0; i10 < size; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println((j) this.f1785d.get(i10));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1799r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1800s);
        if (this.f1801t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1801t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1798q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1804w);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1805x);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1806y);
        if (this.f1803v) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1803v);
        }
    }

    public void b0() {
        this.f1804w = false;
        this.f1805x = false;
        c0(3);
    }

    void b1() {
        ArrayList arrayList = this.f1796o;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.a.a(this.f1796o.get(0));
        throw null;
    }

    @Override // androidx.fragment.app.g
    public androidx.fragment.app.e c() {
        if (super.c() == androidx.fragment.app.g.f1783c) {
            Fragment fragment = this.f1801t;
            if (fragment != null) {
                return fragment.f1707s.c();
            }
            g(new f());
        }
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c1(Parcelable parcelable) {
        androidx.fragment.app.k kVar;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.i iVar = (androidx.fragment.app.i) parcelable;
        if (iVar.f1838a == null) {
            return;
        }
        for (Fragment fragment : this.G.h()) {
            if (I) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator it = iVar.f1838a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = (androidx.fragment.app.k) it.next();
                if (kVar.f1851b.equals(fragment.f1694f)) {
                    break;
                }
            }
            if (kVar == null) {
                if (I) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + iVar.f1838a);
                }
                R0(fragment, 1, 0, 0, false);
                fragment.f1701m = true;
                R0(fragment, 0, 0, 0, false);
            } else {
                kVar.f1863p = fragment;
                fragment.f1692d = null;
                fragment.f1706r = 0;
                fragment.f1703o = false;
                fragment.f1700l = false;
                Fragment fragment2 = fragment.f1696h;
                fragment.f1697i = fragment2 != null ? fragment2.f1694f : null;
                fragment.f1696h = null;
                Bundle bundle = kVar.f1862o;
                if (bundle != null) {
                    bundle.setClassLoader(this.f1799r.i().getClassLoader());
                    fragment.f1692d = kVar.f1862o.getSparseParcelableArray("android:view_state");
                    fragment.f1691c = kVar.f1862o;
                }
            }
        }
        this.f1789h.clear();
        Iterator it2 = iVar.f1838a.iterator();
        while (it2.hasNext()) {
            androidx.fragment.app.k kVar2 = (androidx.fragment.app.k) it2.next();
            if (kVar2 != null) {
                Fragment e6 = kVar2.e(this.f1799r.i().getClassLoader(), c());
                e6.f1707s = this;
                if (I) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + e6.f1694f + "): " + e6);
                }
                this.f1789h.put(e6.f1694f, e6);
                kVar2.f1863p = null;
            }
        }
        this.f1788g.clear();
        ArrayList arrayList = iVar.f1839b;
        if (arrayList != null) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str = (String) it3.next();
                Fragment fragment3 = (Fragment) this.f1789h.get(str);
                if (fragment3 == null) {
                    n1(new IllegalStateException("No instantiated fragment for (" + str + ")"));
                }
                fragment3.f1700l = true;
                if (I) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragment3);
                }
                if (this.f1788g.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.f1788g) {
                    this.f1788g.add(fragment3);
                }
            }
        }
        if (iVar.f1840c != null) {
            this.f1790i = new ArrayList(iVar.f1840c.length);
            int i6 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = iVar.f1840c;
                if (i6 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a e7 = bVarArr[i6].e(this);
                if (I) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + e7.f1760u + "): " + e7);
                    PrintWriter printWriter = new PrintWriter(new d0.c("FragmentManager"));
                    e7.n("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1790i.add(e7);
                int i7 = e7.f1760u;
                if (i7 >= 0) {
                    i1(i7, e7);
                }
                i6++;
            }
        } else {
            this.f1790i = null;
        }
        String str2 = iVar.f1841d;
        if (str2 != null) {
            Fragment fragment4 = (Fragment) this.f1789h.get(str2);
            this.f1802u = fragment4;
            V(fragment4);
        }
        this.f1787f = iVar.f1842e;
    }

    @Override // androidx.fragment.app.g
    public List d() {
        List list;
        if (this.f1788g.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1788g) {
            list = (List) this.f1788g.clone();
        }
        return list;
    }

    public void d0() {
        this.f1805x = true;
        c0(2);
    }

    @Override // androidx.fragment.app.g
    public void e(int i6, int i7) {
        if (i6 >= 0) {
            g0(new k(null, i6, i7), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i6);
    }

    void e0() {
        if (this.f1807z) {
            this.f1807z = false;
            m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable e1() {
        ArrayList arrayList;
        int size;
        s0();
        f0();
        j0();
        this.f1804w = true;
        androidx.fragment.app.b[] bVarArr = null;
        if (this.f1789h.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(this.f1789h.size());
        boolean z5 = false;
        for (Fragment fragment : this.f1789h.values()) {
            if (fragment != null) {
                if (fragment.f1707s != this) {
                    n1(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                androidx.fragment.app.k kVar = new androidx.fragment.app.k(fragment);
                arrayList2.add(kVar);
                if (fragment.f1690b <= 0 || kVar.f1862o != null) {
                    kVar.f1862o = fragment.f1691c;
                } else {
                    kVar.f1862o = f1(fragment);
                    String str = fragment.f1697i;
                    if (str != null) {
                        Fragment fragment2 = (Fragment) this.f1789h.get(str);
                        if (fragment2 == null) {
                            n1(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f1697i));
                        }
                        if (kVar.f1862o == null) {
                            kVar.f1862o = new Bundle();
                        }
                        X0(kVar.f1862o, "android:target_state", fragment2);
                        int i6 = fragment.f1698j;
                        if (i6 != 0) {
                            kVar.f1862o.putInt("android:target_req_state", i6);
                        }
                    }
                }
                if (I) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + kVar.f1862o);
                }
                z5 = true;
            }
        }
        if (!z5) {
            if (I) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f1788g.size();
        if (size2 > 0) {
            arrayList = new ArrayList(size2);
            Iterator it = this.f1788g.iterator();
            while (it.hasNext()) {
                Fragment fragment3 = (Fragment) it.next();
                arrayList.add(fragment3.f1694f);
                if (fragment3.f1707s != this) {
                    n1(new IllegalStateException("Failure saving state: active " + fragment3 + " was removed from the FragmentManager"));
                }
                if (I) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment3.f1694f + "): " + fragment3);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList3 = this.f1790i;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i7 = 0; i7 < size; i7++) {
                bVarArr[i7] = new androidx.fragment.app.b((androidx.fragment.app.a) this.f1790i.get(i7));
                if (I) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i7 + ": " + this.f1790i.get(i7));
                }
            }
        }
        androidx.fragment.app.i iVar = new androidx.fragment.app.i();
        iVar.f1838a = arrayList2;
        iVar.f1839b = arrayList;
        iVar.f1840c = bVarArr;
        Fragment fragment4 = this.f1802u;
        if (fragment4 != null) {
            iVar.f1841d = fragment4.f1694f;
        }
        iVar.f1842e = this.f1787f;
        return iVar;
    }

    @Override // androidx.fragment.app.g
    public boolean f() {
        r();
        return U0(null, -1, 0);
    }

    Bundle f1(Fragment fragment) {
        if (this.D == null) {
            this.D = new Bundle();
        }
        fragment.U0(this.D);
        O(fragment, this.D, false);
        Bundle bundle = null;
        if (!this.D.isEmpty()) {
            Bundle bundle2 = this.D;
            this.D = null;
            bundle = bundle2;
        }
        if (fragment.H != null) {
            g1(fragment);
        }
        if (fragment.f1692d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f1692d);
        }
        if (!fragment.K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.K);
        }
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g0(j jVar, boolean z5) {
        if (!z5) {
            r();
        }
        synchronized (this) {
            if (!this.f1806y && this.f1799r != null) {
                if (this.f1785d == null) {
                    this.f1785d = new ArrayList();
                }
                this.f1785d.add(jVar);
                h1();
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    void g1(Fragment fragment) {
        if (fragment.I == null) {
            return;
        }
        SparseArray sparseArray = this.E;
        if (sparseArray == null) {
            this.E = new SparseArray();
        } else {
            sparseArray.clear();
        }
        fragment.I.saveHierarchyState(this.E);
        if (this.E.size() > 0) {
            fragment.f1692d = this.E;
            this.E = null;
        }
    }

    void h1() {
        synchronized (this) {
            ArrayList arrayList = this.F;
            boolean z5 = false;
            boolean z6 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ArrayList arrayList2 = this.f1785d;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z5 = true;
            }
            if (z6 || z5) {
                this.f1799r.j().removeCallbacks(this.H);
                this.f1799r.j().post(this.H);
                p1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(androidx.fragment.app.a aVar) {
        if (this.f1790i == null) {
            this.f1790i = new ArrayList();
        }
        this.f1790i.add(aVar);
    }

    void i0(Fragment fragment) {
        if (!fragment.f1702n || fragment.f1705q) {
            return;
        }
        fragment.G0(fragment.K0(fragment.f1691c), null, fragment.f1691c);
        View view = fragment.H;
        if (view == null) {
            fragment.I = null;
            return;
        }
        fragment.I = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.f1714z) {
            fragment.H.setVisibility(8);
        }
        fragment.y0(fragment.H, fragment.f1691c);
        R(fragment, fragment.H, fragment.f1691c, false);
    }

    public void i1(int i6, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.f1794m == null) {
                this.f1794m = new ArrayList();
            }
            int size = this.f1794m.size();
            if (i6 < size) {
                if (I) {
                    Log.v("FragmentManager", "Setting back stack index " + i6 + " to " + aVar);
                }
                this.f1794m.set(i6, aVar);
            } else {
                while (size < i6) {
                    this.f1794m.add(null);
                    if (this.f1795n == null) {
                        this.f1795n = new ArrayList();
                    }
                    if (I) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1795n.add(Integer.valueOf(size));
                    size++;
                }
                if (I) {
                    Log.v("FragmentManager", "Adding back stack index " + i6 + " with " + aVar);
                }
                this.f1794m.add(aVar);
            }
        }
    }

    public void j(Fragment fragment, boolean z5) {
        if (I) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        J0(fragment);
        if (fragment.A) {
            return;
        }
        if (this.f1788g.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f1788g) {
            this.f1788g.add(fragment);
        }
        fragment.f1700l = true;
        fragment.f1701m = false;
        if (fragment.H == null) {
            fragment.O = false;
        }
        if (E0(fragment)) {
            this.f1803v = true;
        }
        if (z5) {
            Q0(fragment);
        }
    }

    public boolean j0() {
        h0(true);
        boolean z5 = false;
        while (u0(this.A, this.B)) {
            this.f1786e = true;
            try {
                Z0(this.A, this.B);
                s();
                z5 = true;
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        p1();
        e0();
        p();
        return z5;
    }

    public void j1(Fragment fragment, c.b bVar) {
        if (this.f1789h.get(fragment.f1694f) == fragment && (fragment.f1708t == null || fragment.u() == this)) {
            fragment.S = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void k(Fragment fragment) {
        if (H0()) {
            if (I) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.G.d(fragment) && I) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public void k0(j jVar, boolean z5) {
        if (z5 && (this.f1799r == null || this.f1806y)) {
            return;
        }
        h0(z5);
        if (jVar.a(this.A, this.B)) {
            this.f1786e = true;
            try {
                Z0(this.A, this.B);
            } finally {
                s();
            }
        }
        p1();
        e0();
        p();
    }

    public void k1(Fragment fragment) {
        if (fragment == null || (this.f1789h.get(fragment.f1694f) == fragment && (fragment.f1708t == null || fragment.u() == this))) {
            Fragment fragment2 = this.f1802u;
            this.f1802u = fragment;
            V(fragment2);
            V(this.f1802u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public int l(androidx.fragment.app.a aVar) {
        synchronized (this) {
            ArrayList arrayList = this.f1795n;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = this.f1795n;
                int intValue = ((Integer) arrayList2.remove(arrayList2.size() - 1)).intValue();
                if (I) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                }
                this.f1794m.set(intValue, aVar);
                return intValue;
            }
            if (this.f1794m == null) {
                this.f1794m = new ArrayList();
            }
            int size = this.f1794m.size();
            if (I) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.f1794m.add(aVar);
            return size;
        }
    }

    public void l1(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f1714z) {
            fragment.f1714z = false;
            fragment.O = !fragment.O;
        }
    }

    void m1() {
        for (Fragment fragment : this.f1789h.values()) {
            if (fragment != null) {
                T0(fragment);
            }
        }
    }

    public void n(androidx.fragment.app.f fVar, androidx.fragment.app.c cVar, Fragment fragment) {
        if (this.f1799r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1799r = fVar;
        this.f1800s = cVar;
        this.f1801t = fragment;
        if (fragment != null) {
            p1();
        }
        if (fVar instanceof androidx.activity.c) {
            androidx.activity.c cVar2 = (androidx.activity.c) fVar;
            OnBackPressedDispatcher a6 = cVar2.a();
            this.f1792k = a6;
            androidx.lifecycle.f fVar2 = cVar2;
            if (fragment != null) {
                fVar2 = fragment;
            }
            a6.a(fVar2, this.f1793l);
        }
        this.G = fragment != null ? fragment.f1707s.w0(fragment) : fVar instanceof androidx.lifecycle.p ? androidx.fragment.app.j.g(((androidx.lifecycle.p) fVar).g()) : new androidx.fragment.app.j(false);
    }

    public void o(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            if (fragment.f1700l) {
                return;
            }
            if (this.f1788g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (I) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f1788g) {
                this.f1788g.add(fragment);
            }
            fragment.f1700l = true;
            if (E0(fragment)) {
                this.f1803v = true;
            }
        }
    }

    public Fragment o0(int i6) {
        for (int size = this.f1788g.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1788g.get(size);
            if (fragment != null && fragment.f1711w == i6) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f1789h.values()) {
            if (fragment2 != null && fragment2.f1711w == i6) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f1830a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (str2 == null || !androidx.fragment.app.e.b(context.getClassLoader(), str2)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
            }
            Fragment o02 = resourceId != -1 ? o0(resourceId) : null;
            if (o02 == null && string != null) {
                o02 = p0(string);
            }
            if (o02 == null && id != -1) {
                o02 = o0(id);
            }
            if (I) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + o02);
            }
            if (o02 == null) {
                o02 = c().a(context.getClassLoader(), str2);
                o02.f1702n = true;
                o02.f1711w = resourceId != 0 ? resourceId : id;
                o02.f1712x = id;
                o02.f1713y = string;
                o02.f1703o = true;
                o02.f1707s = this;
                androidx.fragment.app.f fVar = this.f1799r;
                o02.f1708t = fVar;
                o02.l0(fVar.i(), attributeSet, o02.f1691c);
                j(o02, true);
            } else if (o02.f1703o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            } else {
                o02.f1703o = true;
                androidx.fragment.app.f fVar2 = this.f1799r;
                o02.f1708t = fVar2;
                o02.l0(fVar2.i(), attributeSet, o02.f1691c);
            }
            Fragment fragment = o02;
            if (this.f1798q >= 1 || !fragment.f1702n) {
                Q0(fragment);
            } else {
                R0(fragment, 1, 0, 0, false);
            }
            View view2 = fragment.H;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (fragment.H.getTag() == null) {
                    fragment.H.setTag(string);
                }
                return fragment.H;
            }
            throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
        }
        return null;
    }

    public Fragment p0(String str) {
        if (str != null) {
            for (int size = this.f1788g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f1788g.get(size);
                if (fragment != null && str.equals(fragment.f1713y)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (Fragment fragment2 : this.f1789h.values()) {
                if (fragment2 != null && str.equals(fragment2.f1713y)) {
                    return fragment2;
                }
            }
            return null;
        }
        return null;
    }

    boolean q() {
        boolean z5 = false;
        for (Fragment fragment : this.f1789h.values()) {
            if (fragment != null) {
                z5 = E0(fragment);
                continue;
            }
            if (z5) {
                return true;
            }
        }
        return false;
    }

    public Fragment q0(String str) {
        Fragment f6;
        for (Fragment fragment : this.f1789h.values()) {
            if (fragment != null && (f6 = fragment.f(str)) != null) {
                return f6;
            }
        }
        return null;
    }

    void t(androidx.fragment.app.a aVar, boolean z5, boolean z6, boolean z7) {
        if (z5) {
            aVar.p(z7);
        } else {
            aVar.o();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z5));
        if (z6) {
            m.B(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z7) {
            P0(this.f1798q, true);
        }
        for (Fragment fragment : this.f1789h.values()) {
            if (fragment != null && fragment.H != null && fragment.N && aVar.s(fragment.f1712x)) {
                float f6 = fragment.P;
                if (f6 > 0.0f) {
                    fragment.H.setAlpha(f6);
                }
                if (z7) {
                    fragment.P = 0.0f;
                } else {
                    fragment.P = -1.0f;
                    fragment.N = false;
                }
            }
        }
    }

    public void t0(int i6) {
        synchronized (this) {
            this.f1794m.set(i6, null);
            if (this.f1795n == null) {
                this.f1795n = new ArrayList();
            }
            if (I) {
                Log.v("FragmentManager", "Freeing back stack index " + i6);
            }
            this.f1795n.add(Integer.valueOf(i6));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f1801t;
        if (obj == null) {
            obj = this.f1799r;
        }
        d0.b.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    void u(Fragment fragment) {
        Animator animator;
        if (fragment.H != null) {
            g I0 = I0(fragment, fragment.y(), !fragment.f1714z, fragment.z());
            if (I0 == null || (animator = I0.f1824b) == null) {
                if (I0 != null) {
                    fragment.H.startAnimation(I0.f1823a);
                    I0.f1823a.start();
                }
                fragment.H.setVisibility((!fragment.f1714z || fragment.O()) ? 0 : 8);
                if (fragment.O()) {
                    fragment.g1(false);
                }
            } else {
                animator.setTarget(fragment.H);
                if (!fragment.f1714z) {
                    fragment.H.setVisibility(0);
                } else if (fragment.O()) {
                    fragment.g1(false);
                } else {
                    ViewGroup viewGroup = fragment.G;
                    View view = fragment.H;
                    viewGroup.startViewTransition(view);
                    I0.f1824b.addListener(new e(viewGroup, view, fragment));
                }
                I0.f1824b.start();
            }
        }
        if (fragment.f1700l && E0(fragment)) {
            this.f1803v = true;
        }
        fragment.O = false;
        fragment.j0(fragment.f1714z);
    }

    public void v(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        if (fragment.f1700l) {
            if (I) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f1788g) {
                this.f1788g.remove(fragment);
            }
            if (E0(fragment)) {
                this.f1803v = true;
            }
            fragment.f1700l = false;
        }
    }

    public int v0() {
        ArrayList arrayList = this.f1790i;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void w() {
        this.f1804w = false;
        this.f1805x = false;
        c0(2);
    }

    androidx.fragment.app.j w0(Fragment fragment) {
        return this.G.f(fragment);
    }

    public void x(Configuration configuration) {
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null) {
                fragment.C0(configuration);
            }
        }
    }

    public Fragment x0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = (Fragment) this.f1789h.get(string);
        if (fragment == null) {
            n1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    public boolean y(MenuItem menuItem) {
        if (this.f1798q < 1) {
            return false;
        }
        for (int i6 = 0; i6 < this.f1788g.size(); i6++) {
            Fragment fragment = (Fragment) this.f1788g.get(i6);
            if (fragment != null && fragment.D0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 y0() {
        return this;
    }

    public void z() {
        this.f1804w = false;
        this.f1805x = false;
        c0(1);
    }

    public Fragment z0() {
        return this.f1802u;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
