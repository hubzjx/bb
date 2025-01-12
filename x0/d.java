package x0;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f14174b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14175c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14176d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14177e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f14178f;

    /* renamed from: g  reason: collision with root package name */
    private MotionEvent f14179g;

    /* renamed from: h  reason: collision with root package name */
    private a f14180h;

    /* loaded from: classes.dex */
    public interface a {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        boolean c(MotionEvent motionEvent, boolean z5, float f6, float f7);

        void d(MotionEvent motionEvent, float f6, float f7);
    }

    public d(Context context) {
        super(context);
    }

    private void a(MotionEvent motionEvent, MotionEvent... motionEventArr) {
        if (motionEvent == null) {
            return;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                if (rect.contains((int) obtainNoHistory.getX(), (int) obtainNoHistory.getY())) {
                    float f6 = -childAt.getLeft();
                    float f7 = -childAt.getTop();
                    int i6 = 0;
                    if (motionEventArr != null) {
                        int length = motionEventArr.length;
                        int i7 = 0;
                        while (i6 < length) {
                            MotionEvent motionEvent2 = motionEventArr[i6];
                            if (motionEvent2 != null) {
                                MotionEvent obtainNoHistory2 = MotionEvent.obtainNoHistory(motionEvent2);
                                obtainNoHistory2.offsetLocation(f6, f7);
                                i7 |= childAt.dispatchTouchEvent(obtainNoHistory2);
                            }
                            i6++;
                        }
                        i6 = i7;
                    }
                    obtainNoHistory.offsetLocation(f6, f7);
                    if ((childAt.dispatchTouchEvent(obtainNoHistory) | i6) != 0) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private MotionEvent b(MotionEvent motionEvent, int i6) {
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        obtainNoHistory.setAction(i6);
        return obtainNoHistory;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f14180h == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f14178f = new PointF(motionEvent.getX(), motionEvent.getY());
            this.f14179g = MotionEvent.obtainNoHistory(motionEvent);
            this.f14175c = true;
            boolean c6 = this.f14180h.c(motionEvent, false, 0.0f, 0.0f);
            this.f14174b = c6;
            this.f14176d = c6;
            this.f14177e = false;
            return c6;
        } else if (actionMasked != 2) {
            return false;
        } else {
            if (this.f14178f == null) {
                this.f14178f = new PointF(motionEvent.getX(), motionEvent.getY());
            }
            boolean c7 = this.f14180h.c(motionEvent, true, motionEvent.getX() - this.f14178f.x, motionEvent.getY() - this.f14178f.y);
            this.f14174b = c7;
            return c7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != 3) goto L42;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14180h != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (this.f14178f == null) {
                            this.f14178f = new PointF(motionEvent.getX(), motionEvent.getY());
                        }
                        float x5 = motionEvent.getX() - this.f14178f.x;
                        float y5 = motionEvent.getY() - this.f14178f.y;
                        boolean c6 = this.f14180h.c(motionEvent, true, x5, y5);
                        this.f14174b = c6;
                        if (c6) {
                            if (!this.f14176d) {
                                this.f14176d = true;
                                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(this.f14179g);
                                obtainNoHistory.setLocation(motionEvent.getX(), motionEvent.getY());
                                this.f14180h.b(obtainNoHistory);
                                this.f14178f = new PointF(motionEvent.getX(), motionEvent.getY());
                                x5 = 0.0f;
                                y5 = 0.0f;
                            }
                            if (!this.f14177e) {
                                this.f14177e = true;
                                a(b(motionEvent, 3), new MotionEvent[0]);
                            }
                            this.f14180h.d(motionEvent, x5, y5);
                            this.f14175c = true;
                            return true;
                        }
                        if (this.f14175c) {
                            this.f14175c = false;
                            MotionEvent obtainNoHistory2 = MotionEvent.obtainNoHistory(this.f14179g);
                            obtainNoHistory2.setLocation(motionEvent.getX(), motionEvent.getY());
                            a(motionEvent, obtainNoHistory2);
                        } else {
                            a(motionEvent, new MotionEvent[0]);
                        }
                        this.f14176d = false;
                        this.f14177e = false;
                    }
                }
                this.f14176d = false;
                if (this.f14174b) {
                    this.f14180h.a(motionEvent);
                }
                if (!this.f14177e) {
                    this.f14177e = true;
                    if (this.f14175c) {
                        this.f14175c = false;
                        MotionEvent obtainNoHistory3 = MotionEvent.obtainNoHistory(this.f14179g);
                        obtainNoHistory3.setLocation(motionEvent.getX(), motionEvent.getY());
                        a(motionEvent, obtainNoHistory3);
                    } else {
                        a(motionEvent, new MotionEvent[0]);
                    }
                }
                return true;
            } else if (this.f14174b) {
                this.f14180h.b(motionEvent);
                a(motionEvent, new MotionEvent[0]);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollInterceptionListener(a aVar) {
        this.f14180h = aVar;
    }
}
