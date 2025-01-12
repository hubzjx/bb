package w0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f13719a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f13720b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final ScaleGestureDetector f13721c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f13722d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13723e;

    /* renamed from: f  reason: collision with root package name */
    private float f13724f;

    /* renamed from: g  reason: collision with root package name */
    private float f13725g;

    /* renamed from: h  reason: collision with root package name */
    private final float f13726h;

    /* renamed from: i  reason: collision with root package name */
    private final float f13727i;

    /* renamed from: j  reason: collision with root package name */
    private d f13728j;

    /* loaded from: classes.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor >= 0.0f) {
                b.this.f13728j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f13727i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f13726h = viewConfiguration.getScaledTouchSlop();
        this.f13728j = dVar;
        this.f13721c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f13720b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f13720b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r0 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        r0.recycle();
        r12.f13722d = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00db, code lost:
        if (r0 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f13719a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f13722d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f13724f = b(motionEvent);
            this.f13725g = c(motionEvent);
            this.f13723e = false;
        } else if (action == 1) {
            this.f13719a = -1;
            if (this.f13723e && this.f13722d != null) {
                this.f13724f = b(motionEvent);
                this.f13725g = c(motionEvent);
                this.f13722d.addMovement(motionEvent);
                this.f13722d.computeCurrentVelocity(1000);
                float xVelocity = this.f13722d.getXVelocity();
                float yVelocity = this.f13722d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f13727i) {
                    this.f13728j.c(this.f13724f, this.f13725g, -xVelocity, -yVelocity);
                }
            }
            velocityTracker = this.f13722d;
        } else if (action == 2) {
            float b6 = b(motionEvent);
            float c6 = c(motionEvent);
            float f6 = b6 - this.f13724f;
            float f7 = c6 - this.f13725g;
            if (!this.f13723e) {
                this.f13723e = Math.sqrt((double) ((f6 * f6) + (f7 * f7))) >= ((double) this.f13726h);
            }
            if (this.f13723e) {
                this.f13728j.b(f6, f7);
                this.f13724f = b6;
                this.f13725g = c6;
                VelocityTracker velocityTracker2 = this.f13722d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f13719a = -1;
            velocityTracker = this.f13722d;
        } else if (action == 6) {
            int b7 = n.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b7) == this.f13719a) {
                int i6 = b7 == 0 ? 1 : 0;
                this.f13719a = motionEvent.getPointerId(i6);
                this.f13724f = motionEvent.getX(i6);
                this.f13725g = motionEvent.getY(i6);
            }
        }
        int i7 = this.f13719a;
        this.f13720b = motionEvent.findPointerIndex(i7 != -1 ? i7 : 0);
        return true;
    }

    public boolean d() {
        return this.f13723e;
    }

    public boolean e() {
        return this.f13721c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f13721c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
