package com.secret.SideMenu;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.secret.SideMenu.a;
import com.secret.prettyhezi.m;
/* loaded from: classes.dex */
public class c extends RelativeLayout {

    /* renamed from: g  reason: collision with root package name */
    private static final String f5967g = "c";

    /* renamed from: b  reason: collision with root package name */
    private boolean f5968b;

    /* renamed from: c  reason: collision with root package name */
    private com.secret.SideMenu.a f5969c;

    /* renamed from: d  reason: collision with root package name */
    private com.secret.SideMenu.b f5970d;

    /* renamed from: e  reason: collision with root package name */
    private f f5971e;

    /* renamed from: f  reason: collision with root package name */
    private f f5972f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.c {
        a() {
        }

        @Override // com.secret.SideMenu.a.c
        public void a(int i6, float f6, int i7) {
        }

        @Override // com.secret.SideMenu.a.c
        public void b(int i6) {
            f fVar;
            if (i6 != 0 || c.this.f5971e == null) {
                if (i6 == 1) {
                    c.this.getClass();
                }
                if (i6 != 2 || c.this.f5972f == null) {
                    return;
                }
                fVar = c.this.f5972f;
            } else {
                fVar = c.this.f5971e;
            }
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5974a;

        b(int i6) {
            this.f5974a = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = c.f5967g;
            StringBuilder sb = new StringBuilder();
            sb.append("changing layerType. hardware? ");
            sb.append(this.f5974a == 2);
            Log.v(str, sb.toString());
            c.this.getContent().setLayerType(this.f5974a, null);
            c.this.getMenu().setLayerType(this.f5974a, null);
            if (c.this.getSecondaryMenu() != null) {
                c.this.getSecondaryMenu().setLayerType(this.f5974a, null);
            }
        }
    }

    /* renamed from: com.secret.SideMenu.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065c {
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    /* loaded from: classes.dex */
    public static class h extends View.BaseSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f5976a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public h[] newArray(int i6) {
                return new h[i6];
            }
        }

        private h(Parcel parcel) {
            super(parcel);
            this.f5976a = parcel.readInt();
        }

        public int e() {
            return this.f5976a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f5976a);
        }

        /* synthetic */ h(Parcel parcel, a aVar) {
            this(parcel);
        }

        public h(Parcelable parcelable, int i6) {
            super(parcelable);
            this.f5976a = i6;
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public void e(Activity activity, int i6) {
        f(activity, i6, false);
    }

    public void f(Activity activity, int i6, boolean z5) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
        }
        if (getParent() != null) {
            throw new IllegalStateException("This SlidingMenu appears to already be attached");
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (i6 == 0) {
            this.f5968b = false;
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup2.setBackgroundResource(resourceId);
            viewGroup.removeView(viewGroup2);
            viewGroup.addView(this);
            setContent(viewGroup2);
        } else if (i6 != 1) {
        } else {
            this.f5968b = z5;
            ViewGroup viewGroup3 = (ViewGroup) activity.findViewById(16908290);
            View childAt = viewGroup3.getChildAt(0);
            viewGroup3.removeView(childAt);
            viewGroup3.addView(this);
            setContent(childAt);
            if (childAt.getBackground() == null) {
                childAt.setBackgroundResource(resourceId);
            }
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        int i6 = rect.left;
        int i7 = rect.right;
        int i8 = rect.top;
        int i9 = rect.bottom;
        if (this.f5968b) {
            return true;
        }
        Log.v(f5967g, "setting padding!");
        setPadding(i6, i8, i7, i9);
        return true;
    }

    public boolean g() {
        return this.f5969c.getCurrentItem() == 0 || this.f5969c.getCurrentItem() == 2;
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.f5970d.getLayoutParams()).rightMargin;
    }

    public float getBehindScrollScale() {
        return this.f5970d.getScrollScale();
    }

    public View getContent() {
        return this.f5969c.getContent();
    }

    public View getMenu() {
        return this.f5970d.getContent();
    }

    public int getMode() {
        return this.f5970d.getMode();
    }

    public View getSecondaryMenu() {
        return this.f5970d.getSecondaryContent();
    }

    public int getTouchModeAbove() {
        return this.f5969c.getTouchMode();
    }

    public int getTouchmodeMarginThreshold() {
        return this.f5970d.getMarginThreshold();
    }

    public void h(float f6) {
        int i6 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1)) > 0 && (f6 > 1.0f ? 1 : (f6 == 1.0f ? 0 : -1)) < 0 ? 2 : 0;
        if (i6 != getContent().getLayerType()) {
            getHandler().post(new b(i6));
        }
    }

    public void i() {
        j(true);
    }

    public void j(boolean z5) {
        this.f5969c.s(1, z5);
    }

    public void k() {
        l(true);
    }

    public void l(boolean z5) {
        this.f5969c.s(0, z5);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        this.f5969c.setCurrentItem(hVar.e());
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new h(super.onSaveInstanceState(), this.f5969c.getCurrentItem());
    }

    public void setAboveOffset(int i6) {
        this.f5969c.setAboveOffset(i6);
    }

    public void setAboveOffsetRes(int i6) {
        setAboveOffset((int) getContext().getResources().getDimension(i6));
    }

    public void setBehindCanvasTransformer(InterfaceC0065c interfaceC0065c) {
        this.f5970d.setCanvasTransformer(interfaceC0065c);
    }

    public void setBehindOffset(int i6) {
        this.f5970d.setWidthOffset(i6);
    }

    public void setBehindOffsetRes(int i6) {
        setBehindOffset((int) getContext().getResources().getDimension(i6));
    }

    public void setBehindScrollScale(float f6) {
        if (f6 < 0.0f && f6 > 1.0f) {
            throw new IllegalStateException("ScrollScale must be between 0 and 1");
        }
        this.f5970d.setScrollScale(f6);
    }

    public void setBehindWidth(int i6) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class).invoke(defaultDisplay, point);
            width = point.x;
        } catch (Exception unused) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i6);
    }

    public void setBehindWidthRes(int i6) {
        setBehindWidth((int) getContext().getResources().getDimension(i6));
    }

    public void setContent(int i6) {
        setContent(LayoutInflater.from(getContext()).inflate(i6, (ViewGroup) null));
    }

    public void setFadeDegree(float f6) {
        this.f5970d.setFadeDegree(f6);
    }

    public void setFadeEnabled(boolean z5) {
        this.f5970d.setFadeEnabled(z5);
    }

    public void setMenu(int i6) {
        setMenu(LayoutInflater.from(getContext()).inflate(i6, (ViewGroup) null));
    }

    public void setMode(int i6) {
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
        }
        this.f5970d.setMode(i6);
    }

    public void setOnCloseListener(d dVar) {
    }

    public void setOnClosedListener(e eVar) {
        this.f5969c.setOnClosedListener(eVar);
    }

    public void setOnOpenListener(f fVar) {
        this.f5971e = fVar;
    }

    public void setOnOpenedListener(g gVar) {
        this.f5969c.setOnOpenedListener(gVar);
    }

    public void setSecondaryMenu(int i6) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i6, (ViewGroup) null));
    }

    public void setSecondaryOnOpenListner(f fVar) {
        this.f5972f = fVar;
    }

    public void setSecondaryShadowDrawable(int i6) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i6));
    }

    public void setSelectedView(View view) {
        this.f5970d.setSelectedView(view);
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.f5970d.setSelectorBitmap(bitmap);
    }

    public void setSelectorDrawable(int i6) {
        this.f5970d.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i6));
    }

    public void setSelectorEnabled(boolean z5) {
        this.f5970d.setSelectorEnabled(true);
    }

    public void setShadowDrawable(int i6) {
        setShadowDrawable(getContext().getResources().getDrawable(i6));
    }

    public void setShadowWidth(int i6) {
        this.f5970d.setShadowWidth(i6);
    }

    public void setShadowWidthRes(int i6) {
        setShadowWidth((int) getResources().getDimension(i6));
    }

    public void setSlidingEnabled(boolean z5) {
        this.f5969c.setSlidingEnabled(z5);
    }

    public void setStatic(boolean z5) {
        if (z5) {
            setSlidingEnabled(false);
            this.f5969c.setCustomViewBehind(null);
            this.f5969c.setCurrentItem(1);
            return;
        }
        this.f5969c.setCurrentItem(1);
        this.f5969c.setCustomViewBehind(this.f5970d);
        setSlidingEnabled(true);
    }

    public void setTouchModeAbove(int i6) {
        if (i6 != 1 && i6 != 0 && i6 != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.f5969c.setTouchMode(i6);
    }

    public void setTouchModeBehind(int i6) {
        if (i6 != 1 && i6 != 0 && i6 != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.f5970d.setTouchMode(i6);
    }

    public void setTouchmodeMarginThreshold(int i6) {
        this.f5970d.setMarginThreshold(i6);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setContent(View view) {
        this.f5969c.setContent(view);
        i();
    }

    public void setMenu(View view) {
        this.f5970d.setContent(view);
    }

    public void setSecondaryMenu(View view) {
        this.f5970d.setSecondaryContent(view);
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.f5970d.setSecondaryShadowDrawable(drawable);
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f5970d.setShadowDrawable(drawable);
    }

    public c(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5968b = false;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.secret.SideMenu.b bVar = new com.secret.SideMenu.b(context);
        this.f5970d = bVar;
        addView(bVar, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        com.secret.SideMenu.a aVar = new com.secret.SideMenu.a(context);
        this.f5969c = aVar;
        addView(aVar, layoutParams2);
        this.f5969c.setCustomViewBehind(this.f5970d);
        this.f5970d.setCustomViewAbove(this.f5969c);
        this.f5969c.setOnPageChangeListener(new a());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f8572l1);
        setMode(obtainStyledAttributes.getInt(5, 0));
        int resourceId = obtainStyledAttributes.getResourceId(12, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent(new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(13, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu(new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(10, 0));
        setTouchModeBehind(obtainStyledAttributes.getInt(11, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(0, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(2, -1.0f);
        if (dimension != -1 && dimension2 != -1) {
            throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
        }
        if (dimension != -1) {
            setBehindOffset(dimension);
        } else if (dimension2 != -1) {
            setBehindWidth(dimension2);
        } else {
            setBehindOffset(0);
        }
        setBehindScrollScale(obtainStyledAttributes.getFloat(1, 0.33f));
        int resourceId3 = obtainStyledAttributes.getResourceId(8, -1);
        if (resourceId3 != -1) {
            setShadowDrawable(resourceId3);
        }
        setShadowWidth((int) obtainStyledAttributes.getDimension(9, 0.0f));
        setFadeEnabled(obtainStyledAttributes.getBoolean(4, true));
        setFadeDegree(obtainStyledAttributes.getFloat(3, 0.33f));
        setSelectorEnabled(obtainStyledAttributes.getBoolean(7, false));
        int resourceId4 = obtainStyledAttributes.getResourceId(6, -1);
        if (resourceId4 != -1) {
            setSelectorDrawable(resourceId4);
        }
        obtainStyledAttributes.recycle();
    }
}
