package com.secret.SideMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.secret.SideMenu.c;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class b extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f5949b;

    /* renamed from: c  reason: collision with root package name */
    private a f5950c;

    /* renamed from: d  reason: collision with root package name */
    private View f5951d;

    /* renamed from: e  reason: collision with root package name */
    private View f5952e;

    /* renamed from: f  reason: collision with root package name */
    private int f5953f;

    /* renamed from: g  reason: collision with root package name */
    private int f5954g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5955h;

    /* renamed from: i  reason: collision with root package name */
    private int f5956i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5957j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f5958k;

    /* renamed from: l  reason: collision with root package name */
    private float f5959l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f5960m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f5961n;

    /* renamed from: o  reason: collision with root package name */
    private int f5962o;

    /* renamed from: p  reason: collision with root package name */
    private float f5963p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5964q;

    /* renamed from: r  reason: collision with root package name */
    private Bitmap f5965r;

    /* renamed from: s  reason: collision with root package name */
    private View f5966s;

    public b(Context context) {
        this(context, null);
    }

    private int getSelectorTop() {
        return this.f5966s.getTop() + ((this.f5966s.getHeight() - this.f5965r.getHeight()) / 2);
    }

    public void a(View view, Canvas canvas, float f6) {
        int i6;
        if (this.f5957j) {
            int i7 = 0;
            this.f5958k.setColor(Color.argb((int) (this.f5963p * 255.0f * Math.abs(1.0f - f6)), 0, 0, 0));
            int i8 = this.f5956i;
            if (i8 == 0) {
                i7 = view.getLeft() - getBehindWidth();
                i6 = view.getLeft();
            } else {
                if (i8 != 1) {
                    if (i8 == 2) {
                        canvas.drawRect(view.getLeft() - getBehindWidth(), 0.0f, view.getLeft(), getHeight(), this.f5958k);
                    } else {
                        i6 = 0;
                    }
                }
                i7 = view.getRight();
                i6 = view.getRight() + getBehindWidth();
            }
            canvas.drawRect(i7, 0.0f, i6, getHeight(), this.f5958k);
        }
    }

    public void b(View view, Canvas canvas, float f6) {
        View view2;
        Bitmap bitmap;
        int width;
        if (this.f5964q && this.f5965r != null && (view2 = this.f5966s) != null && ((String) view2.getTag(C0382R.id.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int width2 = (int) (this.f5965r.getWidth() * f6);
            int i6 = this.f5956i;
            if (i6 != 0) {
                if (i6 == 1) {
                    int right = view.getRight();
                    int i7 = width2 + right;
                    canvas.clipRect(right, 0, i7, getHeight());
                    bitmap = this.f5965r;
                    width = i7 - bitmap.getWidth();
                }
                canvas.restore();
            }
            int left = view.getLeft();
            width = left - width2;
            canvas.clipRect(width, 0, left, getHeight());
            bitmap = this.f5965r;
            canvas.drawBitmap(bitmap, width, getSelectorTop(), (Paint) null);
            canvas.restore();
        }
    }

    public void c(View view, Canvas canvas) {
        int i6;
        if (this.f5960m == null || this.f5962o <= 0) {
            return;
        }
        int i7 = this.f5956i;
        if (i7 != 0) {
            if (i7 == 1) {
                i6 = view.getRight();
            } else if (i7 != 2) {
                i6 = 0;
            } else if (this.f5961n != null) {
                int right = view.getRight();
                this.f5961n.setBounds(right, 0, this.f5962o + right, getHeight());
                this.f5961n.draw(canvas);
            }
            this.f5960m.setBounds(i6, 0, this.f5962o + i6, getHeight());
            this.f5960m.draw(canvas);
        }
        i6 = view.getLeft() - this.f5962o;
        this.f5960m.setBounds(i6, 0, this.f5962o + i6, getHeight());
        this.f5960m.draw(canvas);
    }

    public int d(View view) {
        int i6 = this.f5956i;
        if (i6 == 0 || i6 == 2) {
            return view.getLeft() - getBehindWidth();
        }
        if (i6 == 1) {
            return view.getLeft();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public int e(View view) {
        int i6 = this.f5956i;
        if (i6 == 0) {
            return view.getLeft();
        }
        if (i6 == 1 || i6 == 2) {
            return view.getLeft() + getBehindWidth();
        }
        return 0;
    }

    public int f(View view, int i6) {
        int i7 = this.f5956i;
        if (i7 == 0) {
            if (i6 == 0) {
                return view.getLeft() - getBehindWidth();
            }
            if (i6 == 2) {
                return view.getLeft();
            }
        } else if (i7 == 1) {
            if (i6 == 0) {
                return view.getLeft();
            }
            if (i6 == 2) {
                return view.getLeft() + getBehindWidth();
            }
        } else if (i7 == 2) {
            if (i6 == 0) {
                return view.getLeft() - getBehindWidth();
            }
            if (i6 == 2) {
                return view.getLeft() + getBehindWidth();
            }
        }
        return view.getLeft();
    }

    public int g(int i6) {
        if (i6 > 1) {
            i6 = 2;
        } else if (i6 < 1) {
            i6 = 0;
        }
        int i7 = this.f5956i;
        if (i7 != 0 || i6 <= 1) {
            if (i7 != 1 || i6 >= 1) {
                return i6;
            }
            return 2;
        }
        return 0;
    }

    public int getBehindWidth() {
        return this.f5951d.getWidth();
    }

    public View getContent() {
        return this.f5951d;
    }

    public int getMarginThreshold() {
        return this.f5953f;
    }

    public int getMode() {
        return this.f5956i;
    }

    public float getScrollScale() {
        return this.f5959l;
    }

    public View getSecondaryContent() {
        return this.f5952e;
    }

    public boolean h(View view, int i6) {
        int left = view.getLeft();
        int right = view.getRight();
        int i7 = this.f5956i;
        if (i7 == 0) {
            return i6 >= left && i6 <= this.f5953f + left;
        } else if (i7 == 1) {
            return i6 <= right && i6 >= right - this.f5953f;
        } else if (i7 == 2) {
            return (i6 >= left && i6 <= this.f5953f + left) || (i6 <= right && i6 >= right - this.f5953f);
        } else {
            return false;
        }
    }

    public boolean i(float f6) {
        int i6 = this.f5956i;
        return i6 == 0 ? f6 > 0.0f : i6 == 1 ? f6 < 0.0f : i6 == 2;
    }

    public boolean j(float f6) {
        int i6 = this.f5956i;
        return i6 == 0 ? f6 < 0.0f : i6 == 1 ? f6 > 0.0f : i6 == 2;
    }

    public boolean k(View view, int i6, float f6) {
        int i7 = this.f5949b;
        return i7 != 0 ? i7 == 1 : l(view, i6, f6);
    }

    public boolean l(View view, int i6, float f6) {
        int i7 = this.f5956i;
        return (i7 == 0 || (i7 == 2 && i6 == 0)) ? f6 >= ((float) view.getLeft()) : (i7 == 1 || (i7 == 2 && i6 == 2)) && f6 <= ((float) view.getRight());
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        if (r6 <= r5.getLeft()) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(View view, int i6, int i7) {
        float behindWidth;
        int i8 = this.f5956i;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f5951d.setVisibility(i6 >= view.getLeft() ? 4 : 0);
                    this.f5952e.setVisibility(i6 <= view.getLeft() ? 4 : 0);
                    r2 = i6 == 0 ? 4 : 0;
                }
                if (r2 == 4) {
                    Log.v("CustomViewBehind", "behind INVISIBLE");
                }
                setVisibility(r2);
            } else if (i6 <= view.getLeft()) {
                r2 = 4;
            }
            behindWidth = (getBehindWidth() - getWidth()) + ((i6 - getBehindWidth()) * this.f5959l);
            scrollTo((int) behindWidth, i7);
            if (r2 == 4) {
            }
            setVisibility(r2);
        } else if (i6 >= view.getLeft()) {
            r2 = 4;
        }
        behindWidth = (i6 + getBehindWidth()) * this.f5959l;
        scrollTo((int) behindWidth, i7);
        if (r2 == 4) {
        }
        setVisibility(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5950c.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        this.f5951d.layout(0, 0, i10 - this.f5954g, i11);
        View view = this.f5952e;
        if (view != null) {
            view.layout(0, 0, i10 - this.f5954g, i11);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int defaultSize = View.getDefaultSize(0, i6);
        int defaultSize2 = View.getDefaultSize(0, i7);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, 0, defaultSize - this.f5954g);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, 0, defaultSize2);
        this.f5951d.measure(childMeasureSpec, childMeasureSpec2);
        View view = this.f5952e;
        if (view != null) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5950c.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        super.scrollTo(i6, i7);
    }

    public void setCanvasTransformer(c.InterfaceC0065c interfaceC0065c) {
    }

    public void setChildrenEnabled(boolean z5) {
        this.f5955h = z5;
    }

    public void setContent(View view) {
        View view2 = this.f5951d;
        if (view2 != null) {
            removeView(view2);
        }
        this.f5951d = view;
        addView(view);
    }

    public void setCustomViewAbove(a aVar) {
        this.f5950c = aVar;
    }

    public void setFadeDegree(float f6) {
        if (f6 > 1.0f || f6 < 0.0f) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.f5963p = f6;
    }

    public void setFadeEnabled(boolean z5) {
        this.f5957j = z5;
    }

    public void setMarginThreshold(int i6) {
        this.f5953f = i6;
    }

    public void setMode(int i6) {
        if (i6 == 0 || i6 == 1) {
            View view = this.f5951d;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f5952e;
            if (view2 != null) {
                view2.setVisibility(4);
            }
        }
        this.f5956i = i6;
    }

    public void setScrollScale(float f6) {
        this.f5959l = f6;
    }

    public void setSecondaryContent(View view) {
        View view2 = this.f5952e;
        if (view2 != null) {
            removeView(view2);
        }
        this.f5952e = view;
        addView(view);
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.f5961n = drawable;
        invalidate();
    }

    public void setSelectedView(View view) {
        View view2 = this.f5966s;
        if (view2 != null) {
            view2.setTag(C0382R.id.selected_view, null);
            this.f5966s = null;
        }
        if (view == null || view.getParent() == null) {
            return;
        }
        this.f5966s = view;
        view.setTag(C0382R.id.selected_view, "CustomViewBehindSelectedView");
        invalidate();
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.f5965r = bitmap;
        refreshDrawableState();
    }

    public void setSelectorEnabled(boolean z5) {
        this.f5964q = z5;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f5960m = drawable;
        invalidate();
    }

    public void setShadowWidth(int i6) {
        this.f5962o = i6;
        invalidate();
    }

    public void setTouchMode(int i6) {
        this.f5949b = i6;
    }

    public void setWidthOffset(int i6) {
        this.f5954g = i6;
        requestLayout();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5949b = 0;
        this.f5958k = new Paint();
        this.f5964q = true;
        this.f5953f = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
    }
}
