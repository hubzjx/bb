package com.secret.SideMenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.secret.SideMenu.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends ViewGroup {

    /* renamed from: z  reason: collision with root package name */
    private static final Interpolator f5923z = new animation.InterpolatorC0064a();

    /* renamed from: b  reason: collision with root package name */
    private View f5924b;

    /* renamed from: c  reason: collision with root package name */
    private int f5925c;

    /* renamed from: d  reason: collision with root package name */
    private Scroller f5926d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5927e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5928f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5929g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5930h;

    /* renamed from: i  reason: collision with root package name */
    private int f5931i;

    /* renamed from: j  reason: collision with root package name */
    private float f5932j;

    /* renamed from: k  reason: collision with root package name */
    private float f5933k;

    /* renamed from: l  reason: collision with root package name */
    private float f5934l;

    /* renamed from: m  reason: collision with root package name */
    protected int f5935m;

    /* renamed from: n  reason: collision with root package name */
    protected VelocityTracker f5936n;

    /* renamed from: o  reason: collision with root package name */
    private int f5937o;

    /* renamed from: p  reason: collision with root package name */
    protected int f5938p;

    /* renamed from: q  reason: collision with root package name */
    private int f5939q;

    /* renamed from: r  reason: collision with root package name */
    private com.secret.SideMenu.b f5940r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f5941s;

    /* renamed from: t  reason: collision with root package name */
    private c f5942t;

    /* renamed from: u  reason: collision with root package name */
    private c f5943u;

    /* renamed from: v  reason: collision with root package name */
    private List f5944v;

    /* renamed from: w  reason: collision with root package name */
    protected int f5945w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f5946x;

    /* renamed from: y  reason: collision with root package name */
    private float f5947y;

    /* renamed from: com.secret.SideMenu.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class animation.InterpolatorC0064a implements Interpolator {
        animation.InterpolatorC0064a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends d {
        b() {
        }

        @Override // com.secret.SideMenu.a.c
        public void b(int i6) {
            com.secret.SideMenu.b bVar;
            if (a.this.f5940r != null) {
                boolean z5 = true;
                if (i6 != 0) {
                    if (i6 == 1) {
                        bVar = a.this.f5940r;
                        z5 = false;
                        bVar.setChildrenEnabled(z5);
                    } else if (i6 != 2) {
                        return;
                    }
                }
                bVar = a.this.f5940r;
                bVar.setChildrenEnabled(z5);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i6, float f6, int i7);

        void b(int i6);
    }

    /* loaded from: classes.dex */
    public static class d implements c {
        @Override // com.secret.SideMenu.a.c
        public void a(int i6, float f6, int i7) {
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private void c() {
        if (this.f5928f) {
            setScrollingCacheEnabled(false);
            this.f5926d.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f5926d.getCurrX();
            int currY = this.f5926d.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            m();
        }
        this.f5928f = false;
    }

    private void d(MotionEvent motionEvent) {
        int i6 = this.f5935m;
        int j6 = j(motionEvent, i6);
        if (i6 == -1 || j6 == -1) {
            return;
        }
        float x5 = motionEvent.getX(j6);
        float f6 = x5 - this.f5933k;
        float abs = Math.abs(f6);
        float y5 = motionEvent.getY(j6);
        float abs2 = Math.abs(y5 - this.f5934l);
        if (abs <= (m() ? this.f5931i / 2 : this.f5931i) || abs <= abs2 || !y(f6)) {
            if (abs > this.f5931i) {
                this.f5930h = true;
                return;
            }
            return;
        }
        x();
        this.f5933k = x5;
        this.f5934l = y5;
        setScrollingCacheEnabled(true);
    }

    private int e(float f6, int i6, int i7) {
        int i8 = this.f5925c;
        return (Math.abs(i7) <= this.f5939q || Math.abs(i6) <= this.f5937o) ? Math.round(this.f5925c + f6) : (i6 <= 0 || i7 <= 0) ? (i6 >= 0 || i7 >= 0) ? i8 : i8 + 1 : i8 - 1;
    }

    private void g() {
        this.f5946x = false;
        this.f5929g = false;
        this.f5930h = false;
        this.f5935m = -1;
        VelocityTracker velocityTracker = this.f5936n;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5936n = null;
        }
    }

    private int getLeftBound() {
        return this.f5940r.d(this.f5924b);
    }

    private int getRightBound() {
        return this.f5940r.e(this.f5924b);
    }

    private int j(MotionEvent motionEvent, int i6) {
        int findPointerIndex = motionEvent.findPointerIndex(i6);
        if (findPointerIndex == -1) {
            this.f5935m = -1;
        }
        return findPointerIndex;
    }

    private boolean l(MotionEvent motionEvent) {
        Rect rect = new Rect();
        for (View view : this.f5944v) {
            view.getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    private void o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f5935m) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.f5933k = motionEvent.getX(i6);
            this.f5935m = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.f5936n;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void r(int i6) {
        int width = getWidth();
        int i7 = i6 / width;
        int i8 = i6 % width;
        n(i7, i8 / width, i8);
    }

    private void setScrollingCacheEnabled(boolean z5) {
        if (this.f5927e != z5) {
            this.f5927e = z5;
        }
    }

    private void x() {
        this.f5929g = true;
        this.f5946x = false;
    }

    private boolean y(float f6) {
        return m() ? this.f5940r.j(f6) : this.f5940r.i(f6);
    }

    private boolean z(MotionEvent motionEvent) {
        int x5 = (int) (motionEvent.getX() + this.f5947y);
        if (m()) {
            return this.f5940r.k(this.f5924b, this.f5925c, x5);
        }
        int i6 = this.f5945w;
        if (i6 != 0) {
            if (i6 != 1) {
                return false;
            }
            return !l(motionEvent);
        }
        return this.f5940r.h(this.f5924b, x5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r1.getLeft() <= r0.getLeft()) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r5 != 2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int i6) {
        boolean p5;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i6);
        if (findNextFocus != null && findNextFocus != findFocus) {
            if (i6 != 17) {
                if (i6 == 66) {
                    if (findFocus != null) {
                    }
                }
                p5 = false;
            }
            p5 = findNextFocus.requestFocus();
        } else if (i6 == 17 || i6 == 1) {
            p5 = p();
        } else {
            if (i6 != 66) {
            }
            p5 = q();
        }
        if (p5) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i6));
        }
        return p5;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f5926d.isFinished() || !this.f5926d.computeScrollOffset()) {
            c();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f5926d.getCurrX();
        int currY = this.f5926d.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            r(currX);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f5940r.c(this.f5924b, canvas);
        this.f5940r.a(this.f5924b, canvas, getPercentOpen());
        this.f5940r.b(this.f5924b, canvas, getPercentOpen());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || h(keyEvent);
    }

    float f(float f6) {
        return (float) Math.sin((float) ((f6 - 0.5f) * 0.4712389167638204d));
    }

    public int getBehindWidth() {
        com.secret.SideMenu.b bVar = this.f5940r;
        if (bVar == null) {
            return 0;
        }
        return bVar.getBehindWidth();
    }

    public View getContent() {
        return this.f5924b;
    }

    public int getContentLeft() {
        return this.f5924b.getLeft() + this.f5924b.getPaddingLeft();
    }

    public int getCurrentItem() {
        return this.f5925c;
    }

    protected float getPercentOpen() {
        return Math.abs(this.f5947y - this.f5924b.getLeft()) / getBehindWidth();
    }

    public int getTouchMode() {
        return this.f5945w;
    }

    public boolean h(KeyEvent keyEvent) {
        int i6;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                i6 = 17;
            } else if (keyCode == 22) {
                i6 = 66;
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    i6 = 2;
                } else if (keyEvent.hasModifiers(1)) {
                    return b(1);
                }
            }
            return b(i6);
        }
        return false;
    }

    public int i(int i6) {
        if (i6 != 0) {
            if (i6 == 1) {
                return this.f5924b.getLeft();
            }
            if (i6 != 2) {
                return 0;
            }
        }
        return this.f5940r.f(this.f5924b, i6);
    }

    void k() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f5926d = new Scroller(context, f5923z);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5931i = viewConfiguration.getScaledPagingTouchSlop();
        this.f5937o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5938p = viewConfiguration.getScaledMaximumFlingVelocity();
        v(new b());
        this.f5939q = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    public boolean m() {
        int i6 = this.f5925c;
        return i6 == 0 || i6 == 2;
    }

    protected void n(int i6, float f6, int i7) {
        c cVar = this.f5942t;
        if (cVar != null) {
            cVar.a(i6, f6, i7);
        }
        c cVar2 = this.f5943u;
        if (cVar2 != null) {
            cVar2.a(i6, f6, i7);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5941s) {
            int action = motionEvent.getAction() & 255;
            if (action == 3 || action == 1 || (action != 0 && this.f5930h)) {
                g();
                return false;
            }
            if (action == 0) {
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                this.f5935m = pointerId;
                if (pointerId != -1) {
                    float x5 = motionEvent.getX(actionIndex);
                    this.f5932j = x5;
                    this.f5933k = x5;
                    this.f5934l = motionEvent.getY(actionIndex);
                    if (z(motionEvent)) {
                        this.f5929g = false;
                        this.f5930h = false;
                        if (m() && this.f5940r.l(this.f5924b, this.f5925c, motionEvent.getX() + this.f5947y)) {
                            this.f5946x = true;
                        }
                    } else {
                        this.f5930h = true;
                    }
                }
            } else if (action == 2) {
                d(motionEvent);
            } else if (action == 6) {
                o(motionEvent);
            }
            if (!this.f5929g) {
                if (this.f5936n == null) {
                    this.f5936n = VelocityTracker.obtain();
                }
                this.f5936n.addMovement(motionEvent);
            }
            return this.f5929g || this.f5946x;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        this.f5924b.layout(0, 0, i8 - i6, i9 - i7);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int defaultSize = View.getDefaultSize(0, i6);
        int defaultSize2 = View.getDefaultSize(0, i7);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.f5924b.measure(ViewGroup.getChildMeasureSpec(i6, 0, defaultSize), ViewGroup.getChildMeasureSpec(i7, 0, defaultSize2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 != i8) {
            c();
            scrollTo(i(this.f5925c), getScrollY());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5941s) {
            if (this.f5929g || z(motionEvent)) {
                int action = motionEvent.getAction();
                if (this.f5936n == null) {
                    this.f5936n = VelocityTracker.obtain();
                }
                this.f5936n.addMovement(motionEvent);
                int i6 = action & 255;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 == 2) {
                            if (!this.f5929g) {
                                d(motionEvent);
                                if (this.f5930h) {
                                    return false;
                                }
                            }
                            if (this.f5929g) {
                                int j6 = j(motionEvent, this.f5935m);
                                if (this.f5935m != -1) {
                                    float x5 = motionEvent.getX(j6);
                                    float f6 = this.f5933k - x5;
                                    this.f5933k = x5;
                                    float scrollX = getScrollX() + f6;
                                    float leftBound = getLeftBound();
                                    float rightBound = getRightBound();
                                    if (scrollX < leftBound) {
                                        scrollX = leftBound;
                                    } else if (scrollX > rightBound) {
                                        scrollX = rightBound;
                                    }
                                    int i7 = (int) scrollX;
                                    this.f5933k += scrollX - i7;
                                    scrollTo(i7, getScrollY());
                                    r(i7);
                                }
                            }
                        } else if (i6 != 3) {
                            if (i6 == 5) {
                                int actionIndex = motionEvent.getActionIndex();
                                this.f5933k = motionEvent.getX(actionIndex);
                                this.f5935m = motionEvent.getPointerId(actionIndex);
                            } else if (i6 == 6) {
                                o(motionEvent);
                                int j7 = j(motionEvent, this.f5935m);
                                if (this.f5935m != -1) {
                                    this.f5933k = motionEvent.getX(j7);
                                }
                            }
                        } else if (this.f5929g) {
                            t(this.f5925c, true, true);
                            this.f5935m = -1;
                        }
                    } else if (this.f5929g) {
                        VelocityTracker velocityTracker = this.f5936n;
                        velocityTracker.computeCurrentVelocity(1000, this.f5938p);
                        int xVelocity = (int) velocityTracker.getXVelocity(this.f5935m);
                        u(this.f5935m != -1 ? e((getScrollX() - i(this.f5925c)) / getBehindWidth(), xVelocity, (int) (motionEvent.getX(j(motionEvent, this.f5935m)) - this.f5932j)) : this.f5925c, true, true, xVelocity);
                        this.f5935m = -1;
                    } else if (this.f5946x && this.f5940r.l(this.f5924b, this.f5925c, motionEvent.getX() + this.f5947y)) {
                        setCurrentItem(1);
                    }
                    g();
                } else {
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex2);
                    this.f5935m = pointerId;
                    if (pointerId != -1) {
                        float x6 = motionEvent.getX(actionIndex2);
                        this.f5932j = x6;
                        this.f5933k = x6;
                        this.f5934l = motionEvent.getY(actionIndex2);
                        if (z(motionEvent)) {
                            this.f5929g = false;
                            this.f5930h = false;
                            if (m() && this.f5940r.l(this.f5924b, this.f5925c, motionEvent.getX() + this.f5947y)) {
                                this.f5946x = true;
                            }
                        } else {
                            this.f5930h = true;
                        }
                        return this.f5946x;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    boolean p() {
        int i6 = this.f5925c;
        if (i6 > 0) {
            s(i6 - 1, true);
            return true;
        }
        return false;
    }

    boolean q() {
        int i6 = this.f5925c;
        if (i6 < 1) {
            s(i6 + 1, true);
            return true;
        }
        return false;
    }

    public void s(int i6, boolean z5) {
        t(i6, z5, false);
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        super.scrollTo(i6, i7);
        this.f5947y = i6;
        this.f5940r.m(this.f5924b, i6, i7);
        ((com.secret.SideMenu.c) getParent()).h(getPercentOpen());
    }

    public void setAboveOffset(int i6) {
        View view = this.f5924b;
        view.setPadding(i6, view.getPaddingTop(), this.f5924b.getPaddingRight(), this.f5924b.getPaddingBottom());
    }

    public void setContent(View view) {
        View view2 = this.f5924b;
        if (view2 != null) {
            removeView(view2);
        }
        this.f5924b = view;
        addView(view);
    }

    public void setCurrentItem(int i6) {
        t(i6, true, false);
    }

    public void setCustomViewBehind(com.secret.SideMenu.b bVar) {
        this.f5940r = bVar;
    }

    public void setOnClosedListener(c.e eVar) {
    }

    public void setOnOpenedListener(c.g gVar) {
    }

    public void setOnPageChangeListener(c cVar) {
        this.f5942t = cVar;
    }

    public void setSlidingEnabled(boolean z5) {
        this.f5941s = z5;
    }

    public void setTouchMode(int i6) {
        this.f5945w = i6;
    }

    void t(int i6, boolean z5, boolean z6) {
        u(i6, z5, z6, 0);
    }

    void u(int i6, boolean z5, boolean z6, int i7) {
        c cVar;
        c cVar2;
        if (!z6 && this.f5925c == i6) {
            setScrollingCacheEnabled(false);
            return;
        }
        int g6 = this.f5940r.g(i6);
        boolean z7 = this.f5925c != g6;
        this.f5925c = g6;
        int i8 = i(g6);
        if (z7 && (cVar2 = this.f5942t) != null) {
            cVar2.b(g6);
        }
        if (z7 && (cVar = this.f5943u) != null) {
            cVar.b(g6);
        }
        if (z5) {
            w(i8, 0, i7);
            return;
        }
        c();
        scrollTo(i8, 0);
    }

    c v(c cVar) {
        c cVar2 = this.f5943u;
        this.f5943u = cVar;
        return cVar2;
    }

    void w(int i6, int i7, int i8) {
        int i9;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i10 = i6 - scrollX;
        int i11 = i7 - scrollY;
        if (i10 == 0 && i11 == 0) {
            c();
            m();
            return;
        }
        setScrollingCacheEnabled(true);
        this.f5928f = true;
        int behindWidth = getBehindWidth();
        float f6 = behindWidth / 2;
        float f7 = f6 + (f(Math.min(1.0f, (Math.abs(i10) * 1.0f) / behindWidth)) * f6);
        int abs = Math.abs(i8);
        if (abs > 0) {
            i9 = Math.round(Math.abs(f7 / abs) * 1000.0f) * 4;
        } else {
            Math.abs(i10);
            i9 = 600;
        }
        this.f5926d.startScroll(scrollX, scrollY, i10, i11, Math.min(i9, 600));
        invalidate();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5935m = -1;
        this.f5941s = true;
        this.f5944v = new ArrayList();
        this.f5945w = 0;
        this.f5946x = false;
        this.f5947y = 0.0f;
        k();
    }
}
