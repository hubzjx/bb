package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import e0.b0;
import e0.u;
import e0.v0;
/* loaded from: classes.dex */
public abstract class l {

    /* loaded from: classes.dex */
    static class a implements u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f5311a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f5312b;

        a(c cVar, d dVar) {
            this.f5311a = cVar;
            this.f5312b = dVar;
        }

        @Override // e0.u
        public v0 a(View view, v0 v0Var) {
            return this.f5311a.a(view, v0Var, new d(this.f5312b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            b0.i0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        v0 a(View view, v0 v0Var, d dVar);
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f5313a;

        /* renamed from: b  reason: collision with root package name */
        public int f5314b;

        /* renamed from: c  reason: collision with root package name */
        public int f5315c;

        /* renamed from: d  reason: collision with root package name */
        public int f5316d;

        public d(int i6, int i7, int i8, int i9) {
            this.f5313a = i6;
            this.f5314b = i7;
            this.f5315c = i8;
            this.f5316d = i9;
        }

        public d(d dVar) {
            this.f5313a = dVar.f5313a;
            this.f5314b = dVar.f5314b;
            this.f5315c = dVar.f5315c;
            this.f5316d = dVar.f5316d;
        }
    }

    public static void a(View view, c cVar) {
        b0.w0(view, new a(cVar, new d(b0.G(view), view.getPaddingTop(), b0.F(view), view.getPaddingBottom())));
        f(view);
    }

    public static float b(Context context, int i6) {
        return TypedValue.applyDimension(1, i6, context.getResources().getDisplayMetrics());
    }

    public static float c(View view) {
        float f6 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f6 += b0.w((View) parent);
        }
        return f6;
    }

    public static boolean d(View view) {
        return b0.B(view) == 1;
    }

    public static PorterDuff.Mode e(int i6, PorterDuff.Mode mode) {
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 9) {
                    switch (i6) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void f(View view) {
        if (b0.Q(view)) {
            b0.i0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }
}
