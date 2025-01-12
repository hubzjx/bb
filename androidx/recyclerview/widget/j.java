package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class j extends n {

    /* renamed from: d  reason: collision with root package name */
    private i f2506d;

    /* renamed from: e  reason: collision with root package name */
    private i f2507e;

    /* loaded from: classes.dex */
    class a extends g {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.y
        protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            j jVar = j.this;
            int[] c6 = jVar.c(jVar.f2514a.getLayoutManager(), view);
            int i6 = c6[0];
            int i7 = c6[1];
            int w5 = w(Math.max(Math.abs(i6), Math.abs(i7)));
            if (w5 > 0) {
                aVar.d(i6, i7, w5, this.f2495j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.g
        public int x(int i6) {
            return Math.min(100, super.x(i6));
        }
    }

    private int l(RecyclerView.o oVar, View view, i iVar) {
        return (iVar.g(view) + (iVar.e(view) / 2)) - (iVar.m() + (iVar.n() / 2));
    }

    private View m(RecyclerView.o oVar, i iVar) {
        int J = oVar.J();
        View view = null;
        if (J == 0) {
            return null;
        }
        int m5 = iVar.m() + (iVar.n() / 2);
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < J; i7++) {
            View I = oVar.I(i7);
            int abs = Math.abs((iVar.g(I) + (iVar.e(I) / 2)) - m5);
            if (abs < i6) {
                view = I;
                i6 = abs;
            }
        }
        return view;
    }

    private i n(RecyclerView.o oVar) {
        i iVar = this.f2507e;
        if (iVar == null || iVar.f2503a != oVar) {
            this.f2507e = i.a(oVar);
        }
        return this.f2507e;
    }

    private i o(RecyclerView.o oVar) {
        if (oVar.l()) {
            return p(oVar);
        }
        if (oVar.k()) {
            return n(oVar);
        }
        return null;
    }

    private i p(RecyclerView.o oVar) {
        i iVar = this.f2506d;
        if (iVar == null || iVar.f2503a != oVar) {
            this.f2506d = i.c(oVar);
        }
        return this.f2506d;
    }

    private boolean q(RecyclerView.o oVar, int i6, int i7) {
        return oVar.k() ? i6 > 0 : i7 > 0;
    }

    private boolean r(RecyclerView.o oVar) {
        PointF a6;
        int Y = oVar.Y();
        if (!(oVar instanceof RecyclerView.y.b) || (a6 = ((RecyclerView.y.b) oVar).a(Y - 1)) == null) {
            return false;
        }
        return a6.x < 0.0f || a6.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.k()) {
            iArr[0] = l(oVar, view, n(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.l()) {
            iArr[1] = l(oVar, view, p(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.n
    protected g e(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new a(this.f2514a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.n
    public View g(RecyclerView.o oVar) {
        i n5;
        if (oVar.l()) {
            n5 = p(oVar);
        } else if (!oVar.k()) {
            return null;
        } else {
            n5 = n(oVar);
        }
        return m(oVar, n5);
    }

    @Override // androidx.recyclerview.widget.n
    public int h(RecyclerView.o oVar, int i6, int i7) {
        i o5;
        int Y = oVar.Y();
        if (Y == 0 || (o5 = o(oVar)) == null) {
            return -1;
        }
        int J = oVar.J();
        View view = null;
        View view2 = null;
        int i8 = Integer.MIN_VALUE;
        int i9 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < J; i10++) {
            View I = oVar.I(i10);
            if (I != null) {
                int l6 = l(oVar, I, o5);
                if (l6 <= 0 && l6 > i8) {
                    view2 = I;
                    i8 = l6;
                }
                if (l6 >= 0 && l6 < i9) {
                    view = I;
                    i9 = l6;
                }
            }
        }
        boolean q5 = q(oVar, i6, i7);
        if (!q5 || view == null) {
            if (q5 || view2 == null) {
                if (q5) {
                    view = view2;
                }
                if (view == null) {
                    return -1;
                }
                int h02 = oVar.h0(view) + (r(oVar) == q5 ? -1 : 1);
                if (h02 < 0 || h02 >= Y) {
                    return -1;
                }
                return h02;
            }
            return oVar.h0(view2);
        }
        return oVar.h0(view);
    }
}
