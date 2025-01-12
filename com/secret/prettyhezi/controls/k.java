package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class k extends View {

    /* renamed from: b  reason: collision with root package name */
    private Movie f8358b;

    /* renamed from: c  reason: collision with root package name */
    private long f8359c;

    /* renamed from: d  reason: collision with root package name */
    private int f8360d;

    /* renamed from: e  reason: collision with root package name */
    private float f8361e;

    /* renamed from: f  reason: collision with root package name */
    private float f8362f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8363g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f8364h;

    /* renamed from: i  reason: collision with root package name */
    b f8365i;

    /* renamed from: j  reason: collision with root package name */
    b f8366j;

    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // com.secret.prettyhezi.controls.k.b
        public void a() {
            k.this.a();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public k(Context context) {
        this(context, null);
        this.f8365i = this.f8366j;
    }

    private void c(Canvas canvas) {
        this.f8358b.setTime(this.f8360d);
        canvas.save();
        canvas.scale(this.f8361e, this.f8362f);
        this.f8358b.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }

    private void d() {
        if (this.f8363g) {
            postInvalidateOnAnimation();
        }
    }

    private boolean e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f8359c == 0) {
            this.f8359c = uptimeMillis;
        }
        int duration = this.f8358b.duration();
        if (duration == 0) {
            duration = 1000;
        }
        long j6 = this.f8359c;
        long j7 = uptimeMillis - j6;
        long j8 = duration;
        if (j7 < j8) {
            this.f8360d = (int) j7;
            return false;
        }
        this.f8359c = j6 + j8;
        this.f8360d = duration - 1;
        return true;
    }

    public void a() {
        this.f8360d = 0;
        b();
    }

    public void b() {
        this.f8364h = false;
        this.f8359c = SystemClock.uptimeMillis() - this.f8360d;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f8358b != null) {
            if (this.f8364h) {
                c(canvas);
                return;
            }
            boolean e6 = e();
            c(canvas);
            if (e6) {
                this.f8365i.a();
            } else {
                d();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.f8363g = getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        Movie movie = this.f8358b;
        if (movie == null) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
            return;
        }
        int width = movie.width();
        int height = this.f8358b.height();
        this.f8361e = 1.0f;
        int i9 = 0;
        if (View.MeasureSpec.getMode(i6) != 0) {
            i8 = View.MeasureSpec.getSize(i6);
            this.f8361e = i8 / width;
        } else {
            i8 = 0;
        }
        this.f8362f = 1.0f;
        if (View.MeasureSpec.getMode(i7) != 0) {
            i9 = View.MeasureSpec.getSize(i7);
            this.f8362f = i9 / height;
        }
        setMeasuredDimension(i8, i9);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i6) {
        super.onScreenStateChanged(i6);
        this.f8363g = i6 == 1;
        d();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        this.f8363g = i6 == 0;
        d();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        this.f8363g = i6 == 0;
        d();
    }

    public void setGifPath(String str) {
        try {
            this.f8358b = Movie.decodeStream(new FileInputStream(str));
        } catch (Exception unused) {
        }
        requestLayout();
    }

    public void setGifResource(int i6) {
        this.f8358b = Movie.decodeStream(getResources().openRawResource(i6));
        requestLayout();
    }

    public k(Context context, b bVar) {
        super(context);
        this.f8360d = 0;
        this.f8363g = true;
        this.f8364h = false;
        this.f8366j = new a();
        setLayerType(1, null);
        this.f8365i = bVar;
    }

    public void setGifResource(String str) {
        try {
            this.f8358b = Movie.decodeStream(getResources().getAssets().open(str));
        } catch (Exception unused) {
        }
        requestLayout();
    }
}
