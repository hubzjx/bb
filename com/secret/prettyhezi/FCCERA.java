package com.secret.prettyhezi;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.controls.d0;
/* loaded from: classes.dex */
public abstract class FCCERA extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6200r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6201s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6202t;

    /* renamed from: u  reason: collision with root package name */
    int f6203u;

    /* renamed from: v  reason: collision with root package name */
    boolean f6204v = true;

    /* renamed from: w  reason: collision with root package name */
    ValueAnimator f6205w = null;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            FCCERA.this.f6201s.scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6207a;

        b(int i6) {
            this.f6207a = i6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) FCCERA.this.f6202t.getLayoutParams();
            marginLayoutParams.topMargin = intValue - this.f6207a;
            FCCERA.this.f6202t.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends d0 {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FCCERA.this.f6205w = null;
        }
    }

    public abstract RelativeLayout S0();

    public void T0(boolean z5) {
        this.f6204v = z5;
        ValueAnimator valueAnimator = this.f6205w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int height = this.f6202t.getHeight();
        int i6 = ((LinearLayout.LayoutParams) this.f6202t.getLayoutParams()).topMargin + height;
        ValueAnimator ofInt = z5 ? ValueAnimator.ofInt(i6, height) : ValueAnimator.ofInt(i6, 0);
        this.f6205w = ofInt;
        ofInt.setDuration(300L);
        this.f6205w.setInterpolator(new DecelerateInterpolator());
        this.f6205w.addUpdateListener(new b(height));
        this.f6205w.addListener(new c());
        this.f6205w.start();
    }

    public abstract View U0();

    public void V0(int i6) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0() {
    }

    @Override // x0.b
    public void a(x0.c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f6201s.getScrollY() == 0) {
            cVar = x0.c.DOWN;
        }
        if (cVar != x0.c.DOWN) {
            if (this.f6204v) {
                T0(false);
            }
        } else if (this.f6204v) {
        } else {
            this.f6202t.setVisibility(0);
            T0(true);
        }
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.f6203u == i6) {
            return;
        }
        this.f6203u = i6;
        V0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W0();
        this.f6200r = B0(3, 4);
        RelativeLayout S0 = S0();
        this.f6202t = S0;
        S0.setOnClickListener(new a());
        x0.a aVar = new x0.a(this);
        this.f6201s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6200r.addView(this.f6201s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f6201s.addView(U0());
    }
}
