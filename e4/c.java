package e4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private final b f9521b;

    /* renamed from: c  reason: collision with root package name */
    List f9522c;

    /* renamed from: d  reason: collision with root package name */
    List f9523d;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        private boolean f9524a;

        /* renamed from: b  reason: collision with root package name */
        private int f9525b;

        /* renamed from: c  reason: collision with root package name */
        private float f9526c;

        public a(int i6, int i7) {
            super(i6, i7);
            this.f9524a = false;
            this.f9525b = 0;
            this.f9526c = -1.0f;
        }

        public int a() {
            return this.f9525b;
        }

        public float b() {
            return this.f9526c;
        }

        public boolean c() {
            return this.f9524a;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9524a = false;
            this.f9525b = 0;
            this.f9526c = -1.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9524a = false;
            this.f9525b = 0;
            this.f9526c = -1.0f;
        }
    }

    public c(Context context) {
        super(context);
        this.f9522c = new ArrayList();
        this.f9523d = new ArrayList();
        b bVar = new b();
        this.f9521b = bVar;
        bVar.r(0);
        bVar.l(false);
        bVar.s(0.0f);
        bVar.m(0);
        bVar.o(0);
    }

    private void a(d dVar) {
        List h6 = dVar.h();
        int size = h6.size();
        for (int i6 = 0; i6 < size; i6++) {
            e eVar = (e) h6.get(i6);
            eVar.j().measure(View.MeasureSpec.makeMeasureSpec(eVar.l(), 1073741824), View.MeasureSpec.makeMeasureSpec(eVar.b(), 1073741824));
        }
    }

    private Paint b(int i6) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i6);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    private boolean c() {
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("debugDraw", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private void d(Canvas canvas, View view) {
        float top;
        float f6;
        float f7;
        Canvas canvas2;
        float f8;
        if (h()) {
            Paint b6 = b(-256);
            Paint b7 = b(-65536);
            a aVar = (a) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) aVar).rightMargin > 0) {
                float right = view.getRight();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top2, right + ((ViewGroup.MarginLayoutParams) aVar).rightMargin, top2, b6);
                int i6 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                canvas.drawLine((i6 + right) - 4.0f, top2 - 4.0f, right + i6, top2, b6);
                int i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                canvas.drawLine((i7 + right) - 4.0f, top2 + 4.0f, right + i7, top2, b6);
            }
            if (((ViewGroup.MarginLayoutParams) aVar).leftMargin > 0) {
                float left = view.getLeft();
                float top3 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(left, top3, left - ((ViewGroup.MarginLayoutParams) aVar).leftMargin, top3, b6);
                int i8 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                canvas.drawLine((left - i8) + 4.0f, top3 - 4.0f, left - i8, top3, b6);
                int i9 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                canvas.drawLine((left - i9) + 4.0f, top3 + 4.0f, left - i9, top3, b6);
            }
            if (((ViewGroup.MarginLayoutParams) aVar).bottomMargin > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left2, bottom, left2, bottom + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, b6);
                int i10 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                canvas.drawLine(left2 - 4.0f, (i10 + bottom) - 4.0f, left2, bottom + i10, b6);
                int i11 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                canvas.drawLine(left2 + 4.0f, (i11 + bottom) - 4.0f, left2, bottom + i11, b6);
            }
            if (((ViewGroup.MarginLayoutParams) aVar).topMargin > 0) {
                float left3 = view.getLeft() + (view.getWidth() / 2.0f);
                float top4 = view.getTop();
                canvas.drawLine(left3, top4, left3, top4 - ((ViewGroup.MarginLayoutParams) aVar).topMargin, b6);
                int i12 = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                canvas.drawLine(left3 - 4.0f, (top4 - i12) + 4.0f, left3, top4 - i12, b6);
                int i13 = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                canvas.drawLine(left3 + 4.0f, (top4 - i13) + 4.0f, left3, top4 - i13, b6);
            }
            if (aVar.c()) {
                if (this.f9521b.f() == 0) {
                    f7 = view.getLeft();
                    float top5 = view.getTop() + (view.getHeight() / 2.0f);
                    f8 = top5 - 6.0f;
                    top = top5 + 6.0f;
                    canvas2 = canvas;
                    f6 = f7;
                } else {
                    float left4 = view.getLeft() + (view.getWidth() / 2.0f);
                    top = view.getTop();
                    f6 = left4 - 6.0f;
                    f7 = left4 + 6.0f;
                    canvas2 = canvas;
                    f8 = top;
                }
                canvas2.drawLine(f6, f8, f7, top, b7);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j6) {
        boolean drawChild = super.drawChild(canvas, view, j6);
        d(canvas, view);
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getGravity() {
        return this.f9521b.a();
    }

    @Override // android.view.View, android.view.ViewParent
    public int getLayoutDirection() {
        b bVar = this.f9521b;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    public int getOrientation() {
        return this.f9521b.f();
    }

    public float getWeightDefault() {
        return this.f9521b.h();
    }

    public boolean h() {
        return this.f9521b.j() || c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int size = this.f9522c.size();
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) this.f9522c.get(i10);
            int size2 = dVar.h().size();
            for (int i11 = 0; i11 < size2; i11++) {
                e eVar = (e) dVar.h().get(i11);
                View j6 = eVar.j();
                a aVar = (a) j6.getLayoutParams();
                j6.layout(getPaddingLeft() + dVar.i() + eVar.d() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin, getPaddingTop() + dVar.j() + eVar.e() + ((ViewGroup.MarginLayoutParams) aVar).topMargin, getPaddingLeft() + dVar.i() + eVar.d() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + eVar.l(), getPaddingTop() + dVar.j() + eVar.e() + ((ViewGroup.MarginLayoutParams) aVar).topMargin + eVar.b());
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int childCount = getChildCount();
        this.f9523d.clear();
        this.f9522c.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                childAt.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) aVar).width), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) aVar).height));
                e eVar = new e(this.f9521b, childAt);
                eVar.x(childAt.getMeasuredWidth());
                eVar.p(childAt.getMeasuredHeight());
                eVar.u(aVar.c());
                eVar.o(aVar.a());
                eVar.w(aVar.b());
                eVar.t(((ViewGroup.MarginLayoutParams) aVar).leftMargin, ((ViewGroup.MarginLayoutParams) aVar).topMargin, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin);
                this.f9523d.add(eVar);
            }
        }
        this.f9521b.q((View.MeasureSpec.getSize(i6) - getPaddingRight()) - getPaddingLeft());
        this.f9521b.p((View.MeasureSpec.getSize(i7) - getPaddingTop()) - getPaddingBottom());
        this.f9521b.t(View.MeasureSpec.getMode(i6));
        this.f9521b.n(View.MeasureSpec.getMode(i7));
        b bVar = this.f9521b;
        bVar.k(bVar.c() != 0);
        e4.a.d(this.f9523d, this.f9522c, this.f9521b);
        e4.a.c(this.f9522c);
        int size = this.f9522c.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = Math.max(i11, ((d) this.f9522c.get(i12)).d());
        }
        List list = this.f9522c;
        d dVar = (d) list.get(list.size() - 1);
        int f6 = dVar.f() + dVar.g();
        e4.a.b(this.f9522c, e4.a.e(this.f9521b.c(), this.f9521b.d(), i11), e4.a.e(this.f9521b.g(), this.f9521b.e(), f6), this.f9521b);
        for (int i13 = 0; i13 < size; i13++) {
            a((d) this.f9522c.get(i13));
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f9521b.f() == 0) {
            i8 = paddingLeft + i11;
            i9 = paddingBottom + f6;
        } else {
            i8 = paddingLeft + f6;
            i9 = paddingBottom + i11;
        }
        setMeasuredDimension(View.resolveSize(i8, i6), View.resolveSize(i9, i7));
    }

    public void setDebugDraw(boolean z5) {
        this.f9521b.l(z5);
        invalidate();
    }

    public void setGravity(int i6) {
        this.f9521b.m(i6);
        requestLayout();
    }

    @Override // android.view.View
    public void setLayoutDirection(int i6) {
        this.f9521b.o(i6);
        requestLayout();
    }

    public void setOrientation(int i6) {
        this.f9521b.r(i6);
        requestLayout();
    }

    public void setWeightDefault(float f6) {
        this.f9521b.s(f6);
        requestLayout();
    }
}
