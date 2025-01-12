package me.imid.swipebacklayout.lib;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.m;
import java.util.ArrayList;
import java.util.List;
import me.imid.swipebacklayout.lib.a;
/* loaded from: classes.dex */
public class SwipeBackLayout extends FrameLayout {

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f12009t = {1, 2, 8, 11};

    /* renamed from: b  reason: collision with root package name */
    private int f12010b;

    /* renamed from: c  reason: collision with root package name */
    private float f12011c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f12012d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12013e;

    /* renamed from: f  reason: collision with root package name */
    private View f12014f;

    /* renamed from: g  reason: collision with root package name */
    private me.imid.swipebacklayout.lib.a f12015g;

    /* renamed from: h  reason: collision with root package name */
    private float f12016h;

    /* renamed from: i  reason: collision with root package name */
    private int f12017i;

    /* renamed from: j  reason: collision with root package name */
    private int f12018j;

    /* renamed from: k  reason: collision with root package name */
    private List f12019k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f12020l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f12021m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f12022n;

    /* renamed from: o  reason: collision with root package name */
    private float f12023o;

    /* renamed from: p  reason: collision with root package name */
    private int f12024p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12025q;

    /* renamed from: r  reason: collision with root package name */
    private Rect f12026r;

    /* renamed from: s  reason: collision with root package name */
    private int f12027s;

    /* loaded from: classes.dex */
    public interface b {
        void b();

        void c(int i6);

        void d(int i6, float f6);
    }

    /* loaded from: classes.dex */
    public interface c extends b {
        void a();
    }

    /* loaded from: classes.dex */
    private class d extends a.c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12028a;

        private d() {
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int a(View view, int i6, int i7) {
            if ((SwipeBackLayout.this.f12027s & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i6, 0));
            }
            if ((SwipeBackLayout.this.f12027s & 2) != 0) {
                return Math.min(0, Math.max(i6, -view.getWidth()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int b(View view, int i6, int i7) {
            if ((SwipeBackLayout.this.f12027s & 8) != 0) {
                return Math.min(0, Math.max(i6, -view.getHeight()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int d(View view) {
            return SwipeBackLayout.this.f12010b & 3;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int e(View view) {
            return SwipeBackLayout.this.f12010b & 8;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public void j(int i6) {
            super.j(i6);
            if (SwipeBackLayout.this.f12019k == null || SwipeBackLayout.this.f12019k.isEmpty()) {
                return;
            }
            for (b bVar : SwipeBackLayout.this.f12019k) {
                bVar.d(i6, SwipeBackLayout.this.f12016h);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b2 A[LOOP:0: B:23:0x00ac->B:25:0x00b2, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0113 A[LOOP:1: B:37:0x010d->B:39:0x0113, LOOP_END] */
        @Override // me.imid.swipebacklayout.lib.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void k(View view, int i6, int i7, int i8, int i9) {
            SwipeBackLayout swipeBackLayout;
            float f6;
            int height;
            int intrinsicHeight;
            Drawable drawable;
            super.k(view, i6, i7, i8, i9);
            if ((SwipeBackLayout.this.f12027s & 1) != 0) {
                swipeBackLayout = SwipeBackLayout.this;
                f6 = i6;
                height = swipeBackLayout.f12014f.getWidth();
                drawable = SwipeBackLayout.this.f12020l;
            } else if ((SwipeBackLayout.this.f12027s & 2) == 0) {
                if ((SwipeBackLayout.this.f12027s & 8) != 0) {
                    swipeBackLayout = SwipeBackLayout.this;
                    f6 = i7;
                    height = swipeBackLayout.f12014f.getHeight();
                    intrinsicHeight = SwipeBackLayout.this.f12022n.getIntrinsicHeight();
                    swipeBackLayout.f12016h = Math.abs(f6 / (height + intrinsicHeight));
                }
                SwipeBackLayout.this.f12017i = i6;
                SwipeBackLayout.this.f12018j = i7;
                SwipeBackLayout.this.invalidate();
                if (SwipeBackLayout.this.f12016h < SwipeBackLayout.this.f12011c && !this.f12028a) {
                    this.f12028a = true;
                }
                if (SwipeBackLayout.this.f12019k != null && !SwipeBackLayout.this.f12019k.isEmpty()) {
                    for (b bVar : SwipeBackLayout.this.f12019k) {
                        bVar.d(SwipeBackLayout.this.f12015g.u(), SwipeBackLayout.this.f12016h);
                    }
                }
                if (SwipeBackLayout.this.f12019k != null && !SwipeBackLayout.this.f12019k.isEmpty() && SwipeBackLayout.this.f12015g.u() == 1 && SwipeBackLayout.this.f12016h >= SwipeBackLayout.this.f12011c && this.f12028a) {
                    this.f12028a = false;
                    for (b bVar2 : SwipeBackLayout.this.f12019k) {
                        bVar2.b();
                    }
                }
                if (SwipeBackLayout.this.f12016h >= 1.0f || SwipeBackLayout.this.f12019k == null || SwipeBackLayout.this.f12019k.isEmpty()) {
                    return;
                }
                for (b bVar3 : SwipeBackLayout.this.f12019k) {
                    if (bVar3 instanceof c) {
                        ((c) bVar3).a();
                    }
                }
                return;
            } else {
                swipeBackLayout = SwipeBackLayout.this;
                f6 = i6;
                height = swipeBackLayout.f12014f.getWidth();
                drawable = SwipeBackLayout.this.f12021m;
            }
            intrinsicHeight = drawable.getIntrinsicWidth();
            swipeBackLayout.f12016h = Math.abs(f6 / (height + intrinsicHeight));
            SwipeBackLayout.this.f12017i = i6;
            SwipeBackLayout.this.f12018j = i7;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.f12016h < SwipeBackLayout.this.f12011c) {
                this.f12028a = true;
            }
            if (SwipeBackLayout.this.f12019k != null) {
                while (r3.hasNext()) {
                }
            }
            if (SwipeBackLayout.this.f12019k != null) {
                this.f12028a = false;
                while (r3.hasNext()) {
                }
            }
            if (SwipeBackLayout.this.f12016h >= 1.0f) {
            }
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public void l(View view, float f6, float f7) {
            int i6;
            int width = view.getWidth();
            int height = view.getHeight();
            int i7 = 0;
            if ((SwipeBackLayout.this.f12027s & 1) != 0) {
                int i8 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                i7 = (i8 > 0 || (i8 == 0 && SwipeBackLayout.this.f12016h > SwipeBackLayout.this.f12011c)) ? width + SwipeBackLayout.this.f12020l.getIntrinsicWidth() + 10 : 0;
            } else if ((SwipeBackLayout.this.f12027s & 2) != 0) {
                i7 = (f6 < 0.0f || (f6 == 0.0f && SwipeBackLayout.this.f12016h > SwipeBackLayout.this.f12011c)) ? -(width + SwipeBackLayout.this.f12020l.getIntrinsicWidth() + 10) : 0;
            } else if ((SwipeBackLayout.this.f12027s & 8) != 0 && (f7 < 0.0f || (f7 == 0.0f && SwipeBackLayout.this.f12016h > SwipeBackLayout.this.f12011c))) {
                i6 = -(height + SwipeBackLayout.this.f12022n.getIntrinsicHeight() + 10);
                SwipeBackLayout.this.f12015g.J(i7, i6);
                SwipeBackLayout.this.invalidate();
            }
            i6 = 0;
            SwipeBackLayout.this.f12015g.J(i7, i6);
            SwipeBackLayout.this.invalidate();
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public boolean m(View view, int i6) {
            boolean d6;
            boolean w5 = SwipeBackLayout.this.f12015g.w(SwipeBackLayout.this.f12010b, i6);
            boolean z5 = true;
            if (w5) {
                if (SwipeBackLayout.this.f12015g.w(1, i6)) {
                    SwipeBackLayout.this.f12027s = 1;
                } else if (SwipeBackLayout.this.f12015g.w(2, i6)) {
                    SwipeBackLayout.this.f12027s = 2;
                } else if (SwipeBackLayout.this.f12015g.w(8, i6)) {
                    SwipeBackLayout.this.f12027s = 8;
                }
                if (SwipeBackLayout.this.f12019k != null && !SwipeBackLayout.this.f12019k.isEmpty()) {
                    for (b bVar : SwipeBackLayout.this.f12019k) {
                        bVar.c(SwipeBackLayout.this.f12027s);
                    }
                }
                this.f12028a = true;
            }
            if (SwipeBackLayout.this.f12010b == 1 || SwipeBackLayout.this.f12010b == 2) {
                d6 = SwipeBackLayout.this.f12015g.d(2, i6);
            } else if (SwipeBackLayout.this.f12010b != 8) {
                if (SwipeBackLayout.this.f12010b != 11) {
                    z5 = false;
                }
                return w5 & z5;
            } else {
                d6 = SwipeBackLayout.this.f12015g.d(1, i6);
            }
            z5 = true ^ d6;
            return w5 & z5;
        }
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0382R.attr.SwipeBackLayoutStyle);
    }

    private void q(Canvas canvas, View view) {
        int i6 = this.f12024p;
        int i7 = (i6 & 16777215) | (((int) ((((-16777216) & i6) >>> 24) * this.f12023o)) << 24);
        int i8 = this.f12027s;
        if ((i8 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i8 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i8 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i7);
    }

    private void r(Canvas canvas, View view) {
        Rect rect = this.f12026r;
        view.getHitRect(rect);
        if ((this.f12010b & 1) != 0) {
            Drawable drawable = this.f12020l;
            drawable.setBounds(rect.left - drawable.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.f12020l.setAlpha((int) (this.f12023o * 255.0f));
            this.f12020l.draw(canvas);
        }
        if ((this.f12010b & 2) != 0) {
            Drawable drawable2 = this.f12021m;
            int i6 = rect.right;
            drawable2.setBounds(i6, rect.top, drawable2.getIntrinsicWidth() + i6, rect.bottom);
            this.f12021m.setAlpha((int) (this.f12023o * 255.0f));
            this.f12021m.draw(canvas);
        }
        if ((this.f12010b & 8) != 0) {
            Drawable drawable3 = this.f12022n;
            int i7 = rect.left;
            int i8 = rect.bottom;
            drawable3.setBounds(i7, i8, rect.right, drawable3.getIntrinsicHeight() + i8);
            this.f12022n.setAlpha((int) (this.f12023o * 255.0f));
            this.f12022n.draw(canvas);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f12023o = 1.0f - this.f12016h;
        if (this.f12015g.l(true)) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j6) {
        boolean z5 = view == this.f12014f;
        boolean drawChild = super.drawChild(canvas, view, j6);
        if (this.f12023o > 0.0f && z5 && this.f12015g.u() != 0) {
            r(canvas, view);
            q(canvas, view);
        }
        return drawChild;
    }

    public void o(b bVar) {
        if (this.f12019k == null) {
            this.f12019k = new ArrayList();
        }
        this.f12019k.add(bVar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f12013e) {
            try {
                return this.f12015g.K(motionEvent);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        this.f12025q = true;
        View view = this.f12014f;
        if (view != null) {
            int i10 = this.f12017i;
            view.layout(i10, this.f12018j, view.getMeasuredWidth() + i10, this.f12018j + this.f12014f.getMeasuredHeight());
        }
        this.f12025q = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12013e) {
            this.f12015g.z(motionEvent);
            return true;
        }
        return false;
    }

    public void p(Activity activity) {
        this.f12012d = activity;
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        o(new v4.b(activity));
        viewGroup.addView(this);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f12025q) {
            return;
        }
        super.requestLayout();
    }

    public void s(int i6, int i7) {
        t(getResources().getDrawable(i6), i7);
    }

    public void setContentView(View view) {
        this.f12014f = view;
    }

    public void setEdgeSize(int i6) {
        this.f12015g.F(i6);
    }

    public void setEdgeTrackingEnabled(int i6) {
        this.f12010b = i6;
        this.f12015g.G(i6);
    }

    public void setEnableGesture(boolean z5) {
        this.f12013e = z5;
    }

    public void setScrimColor(int i6) {
        this.f12024p = i6;
        invalidate();
    }

    public void setScrollThresHold(float f6) {
        if (f6 >= 1.0f || f6 <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.f12011c = f6;
    }

    @Deprecated
    public void setSwipeListener(b bVar) {
        o(bVar);
    }

    public void t(Drawable drawable, int i6) {
        if ((i6 & 1) != 0) {
            this.f12020l = drawable;
        } else if ((i6 & 2) != 0) {
            this.f12021m = drawable;
        } else if ((i6 & 8) != 0) {
            this.f12022n = drawable;
        }
        invalidate();
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet);
        this.f12011c = 0.3f;
        this.f12013e = true;
        this.f12024p = -1728053248;
        this.f12026r = new Rect();
        this.f12015g = me.imid.swipebacklayout.lib.a.m(this, new d());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f8602v1, i6, C0382R.style.SwipeBackLayout);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(f12009t[obtainStyledAttributes.getInt(0, 0)]);
        int resourceId = obtainStyledAttributes.getResourceId(3, C0382R.drawable.shadow_left);
        int resourceId2 = obtainStyledAttributes.getResourceId(4, C0382R.drawable.shadow_right);
        int resourceId3 = obtainStyledAttributes.getResourceId(2, C0382R.drawable.shadow_bottom);
        s(resourceId, 1);
        s(resourceId2, 2);
        s(resourceId3, 8);
        obtainStyledAttributes.recycle();
        float f6 = getResources().getDisplayMetrics().density * 400.0f;
        this.f12015g.I(f6);
        this.f12015g.H(f6 * 2.0f);
    }
}
