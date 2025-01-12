package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public abstract class e extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private View f8219b;

    /* renamed from: c  reason: collision with root package name */
    private d f8220c;

    /* renamed from: d  reason: collision with root package name */
    private d f8221d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8222a;

        static {
            int[] iArr = new int[d.values().length];
            f8222a = iArr;
            try {
                iArr[d.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8222a[d.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8222a[d.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8222a[d.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8222a[d.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public e(Context context) {
        this(context, null);
    }

    protected abstract View a(Context context, AttributeSet attributeSet);

    protected void b(Context context, AttributeSet attributeSet) {
        View a6 = a(context, attributeSet);
        this.f8219b = a6;
        if (a6 == null) {
            throw new NullPointerException("Loading view can not be null.");
        }
        addView(this.f8219b, new FrameLayout.LayoutParams(-1, -2));
    }

    protected void c() {
    }

    public void d(float f6) {
    }

    protected abstract void e();

    protected abstract void f();

    protected abstract void g();

    public abstract int getContentSize();

    /* JADX INFO: Access modifiers changed from: protected */
    public d getPreState() {
        return this.f8221d;
    }

    public d getState() {
        return this.f8220c;
    }

    protected abstract void h();

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(d dVar, d dVar2) {
        int i6 = a.f8222a[dVar.ordinal()];
        if (i6 == 1) {
            h();
        } else if (i6 == 2) {
            g();
        } else if (i6 == 3) {
            e();
        } else if (i6 == 4) {
            f();
        } else if (i6 != 5) {
        } else {
            c();
        }
    }

    public void j(boolean z5) {
        if (z5 == (getVisibility() == 0)) {
            return;
        }
        setVisibility(z5 ? 0 : 8);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setPullLabel(CharSequence charSequence) {
    }

    public void setRefreshingLabel(CharSequence charSequence) {
    }

    public void setReleaseLabel(CharSequence charSequence) {
    }

    public void setState(d dVar) {
        d dVar2 = this.f8220c;
        if (dVar2 != dVar) {
            this.f8221d = dVar2;
            this.f8220c = dVar;
            i(dVar, dVar2);
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        d dVar = d.NONE;
        this.f8220c = dVar;
        this.f8221d = dVar;
        b(context, attributeSet);
    }
}
