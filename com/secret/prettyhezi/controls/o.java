package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private List f8408b;

    /* renamed from: c  reason: collision with root package name */
    private float f8409c;

    /* renamed from: d  reason: collision with root package name */
    private float f8410d;

    /* renamed from: e  reason: collision with root package name */
    private int f8411e;

    /* renamed from: f  reason: collision with root package name */
    private int f8412f;

    /* renamed from: g  reason: collision with root package name */
    private int f8413g;

    /* renamed from: h  reason: collision with root package name */
    private int f8414h;

    /* renamed from: i  reason: collision with root package name */
    private float f8415i;

    /* renamed from: j  reason: collision with root package name */
    private float f8416j;

    /* renamed from: k  reason: collision with root package name */
    private int f8417k;

    /* renamed from: l  reason: collision with root package name */
    private int f8418l;

    /* renamed from: m  reason: collision with root package name */
    private float f8419m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8420n;

    /* renamed from: o  reason: collision with root package name */
    private Paint f8421o;

    /* renamed from: p  reason: collision with root package name */
    private Paint f8422p;

    /* renamed from: q  reason: collision with root package name */
    private StringBuilder f8423q;

    /* renamed from: r  reason: collision with root package name */
    private b f8424r;

    /* renamed from: s  reason: collision with root package name */
    boolean f8425s;

    /* renamed from: t  reason: collision with root package name */
    Runnable f8426t;

    /* renamed from: u  reason: collision with root package name */
    boolean f8427u;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.c(false);
            o.this.b();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends View {

        /* renamed from: b  reason: collision with root package name */
        private int f8429b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8430c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8431d;

        public c(Context context, int i6) {
            super(context);
            this.f8430c = false;
            this.f8431d = false;
            this.f8429b = i6;
            setBackgroundResource(o.this.f8411e);
        }

        public void a() {
            setBackgroundResource(this.f8431d ? this.f8430c ? o.this.f8414h : o.this.f8413g : this.f8430c ? o.this.f8412f : o.this.f8411e);
        }

        public int b() {
            return (getLeft() + getRight()) / 2;
        }

        public int c() {
            return (getTop() + getBottom()) / 2;
        }

        public int d() {
            return this.f8429b;
        }

        public boolean e() {
            return this.f8430c;
        }

        public void f(boolean z5) {
            if (this.f8431d != z5) {
                this.f8431d = z5;
                a();
            }
        }

        public void g(boolean z5) {
            if (this.f8430c != z5) {
                this.f8430c = z5;
                a();
            }
        }
    }

    public o(Context context) {
        super(context);
        this.f8408b = new ArrayList();
        this.f8423q = new StringBuilder();
        this.f8425s = false;
        this.f8426t = new a();
        this.f8427u = false;
    }

    private c j(float f6, float f7) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            c cVar = (c) getChildAt(i6);
            if (f6 >= cVar.getLeft() - this.f8416j && f6 < cVar.getRight() + this.f8416j && f7 >= cVar.getTop() - this.f8416j && f7 < cVar.getBottom() + this.f8416j) {
                return cVar;
            }
        }
        return null;
    }

    private c k(c cVar, c cVar2) {
        int i6;
        if (cVar.d() > cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        if (cVar.d() % 3 == 1 && cVar2.d() - cVar.d() == 2) {
            i6 = cVar.d();
        } else if (cVar.d() <= 3 && cVar2.d() - cVar.d() == 6) {
            i6 = cVar.d() + 2;
        } else if ((cVar.d() != 1 || cVar2.d() != 9) && (cVar.d() != 3 || cVar2.d() != 7)) {
            return null;
        } else {
            i6 = 4;
        }
        return (c) getChildAt(i6);
    }

    public void a() {
        Paint paint = new Paint(4);
        this.f8421o = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f8421o.setStrokeWidth(this.f8419m);
        this.f8421o.setColor(this.f8417k);
        this.f8421o.setAntiAlias(true);
        Paint paint2 = new Paint(4);
        this.f8422p = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f8422p.setStrokeWidth(this.f8419m);
        this.f8422p.setColor(this.f8418l);
        this.f8422p.setAntiAlias(true);
        int i6 = 0;
        while (i6 < 9) {
            i6++;
            addView(new c(getContext(), i6));
        }
        setWillNotDraw(false);
    }

    public void b() {
        this.f8408b.clear();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            ((c) getChildAt(i6)).g(false);
        }
        invalidate();
    }

    public void c(boolean z5) {
        if (this.f8427u == z5) {
            return;
        }
        this.f8427u = z5;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            ((c) getChildAt(i6)).f(z5);
        }
        if (z5) {
            postDelayed(this.f8426t, 2000L);
        } else {
            removeCallbacks(this.f8426t);
            b bVar = this.f8424r;
            if (bVar != null) {
                bVar.b();
            }
        }
        invalidate();
    }

    public void d(int i6, int i7, float f6) {
        this.f8417k = i6;
        this.f8418l = i7;
        this.f8419m = f6;
    }

    public void e(int i6, int i7, int i8, int i9, int i10) {
        this.f8411e = i6;
        this.f8413g = i7;
        this.f8412f = i8;
        this.f8414h = i9;
        this.f8415i = i10;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = this.f8427u ? this.f8422p : this.f8421o;
        for (int i6 = 1; i6 < this.f8408b.size(); i6++) {
            c cVar = (c) this.f8408b.get(i6 - 1);
            c cVar2 = (c) this.f8408b.get(i6);
            canvas.drawLine(cVar.b(), cVar.c(), cVar2.b(), cVar2.c(), paint);
        }
        if (this.f8408b.size() <= 0 || !this.f8425s) {
            return;
        }
        List list = this.f8408b;
        c cVar3 = (c) list.get(list.size() - 1);
        canvas.drawLine(cVar3.b(), cVar3.c(), this.f8409c, this.f8410d, paint);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        float f6;
        float f7;
        int i10;
        if (!z5 || this.f8415i <= 0.0f) {
            return;
        }
        int paddingLeft = ((i8 - i6) - getPaddingLeft()) - getPaddingRight();
        int paddingTop = ((i9 - i7) - getPaddingTop()) - getPaddingBottom();
        for (int i11 = 0; i11 < 9; i11++) {
            c cVar = (c) getChildAt(i11);
            int i12 = i11 / 3;
            int i13 = i11 % 3;
            if (i13 == 0) {
                i10 = 0;
            } else {
                if (i13 == 1) {
                    f6 = paddingLeft / 2;
                    f7 = this.f8415i / 2.0f;
                } else {
                    f6 = paddingLeft;
                    f7 = this.f8415i;
                }
                i10 = (int) (f6 - f7);
            }
            int i14 = i12 == 0 ? 0 : (int) (i12 == 1 ? (paddingTop / 2) - (this.f8415i / 2.0f) : paddingTop - this.f8415i);
            int paddingLeft2 = i10 + getPaddingLeft();
            int paddingTop2 = i14 + getPaddingTop();
            float f8 = this.f8415i;
            cVar.layout(paddingLeft2, paddingTop2, (int) (paddingLeft2 + f8), (int) (paddingTop2 + f8));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bb, code lost:
        if (r4.f8408b.size() > 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            this.f8425s = false;
            if (this.f8408b.size() > 0) {
                if (this.f8424r != null) {
                    this.f8423q.setLength(0);
                    for (c cVar : this.f8408b) {
                        this.f8423q.append(cVar.d());
                    }
                    this.f8424r.a(this.f8423q.toString());
                }
                invalidate();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            c(false);
            if (this.f8408b.size() > 0) {
                b();
            }
        }
        this.f8425s = true;
        this.f8409c = motionEvent.getX();
        float y5 = motionEvent.getY();
        this.f8410d = y5;
        c j6 = j(this.f8409c, y5);
        if (j6 != null && !j6.e()) {
            if (this.f8408b.size() > 0 && this.f8420n) {
                List list = this.f8408b;
                c k6 = k((c) list.get(list.size() - 1), j6);
                if (k6 != null && !k6.e()) {
                    k6.g(true);
                    this.f8408b.add(k6);
                }
            }
            j6.g(true);
            this.f8408b.add(j6);
        }
    }

    public void setCallBack(b bVar) {
        this.f8424r = bVar;
    }
}
