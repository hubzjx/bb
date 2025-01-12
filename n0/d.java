package n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d extends n0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f12083a;

        a(View view) {
            this.f12083a = view;
        }

        @Override // n0.l.f
        public void b(l lVar) {
            a0.g(this.f12083a, 1.0f);
            a0.a(this.f12083a);
            lVar.O(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f12085a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12086b = false;

        b(View view) {
            this.f12085a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a0.g(this.f12085a, 1.0f);
            if (this.f12086b) {
                this.f12085a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e0.b0.N(this.f12085a) && this.f12085a.getLayerType() == 0) {
                this.f12086b = true;
                this.f12085a.setLayerType(2, null);
            }
        }
    }

    public d(int i6) {
        h0(i6);
    }

    private Animator i0(View view, float f6, float f7) {
        if (f6 == f7) {
            return null;
        }
        a0.g(view, f6);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, a0.f12055b, f7);
        ofFloat.addListener(new b(view));
        a(new a(view));
        return ofFloat;
    }

    private static float j0(s sVar, float f6) {
        Float f7;
        return (sVar == null || (f7 = (Float) sVar.f12173a.get("android:fade:transitionAlpha")) == null) ? f6 : f7.floatValue();
    }

    @Override // n0.n0
    public Animator d0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float j02 = j0(sVar, 0.0f);
        return i0(view, j02 != 1.0f ? j02 : 0.0f, 1.0f);
    }

    @Override // n0.n0
    public Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        a0.e(view);
        return i0(view, j0(sVar, 1.0f), 0.0f);
    }

    @Override // n0.n0, n0.l
    public void i(s sVar) {
        super.i(sVar);
        sVar.f12173a.put("android:fade:transitionAlpha", Float.valueOf(a0.c(sVar.f12174b)));
    }
}
