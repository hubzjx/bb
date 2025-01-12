package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import v.h;
/* loaded from: classes.dex */
public class b extends f implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    private C0025b f2552c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2553d;

    /* renamed from: e  reason: collision with root package name */
    private ArgbEvaluator f2554e;

    /* renamed from: f  reason: collision with root package name */
    private Animator.AnimatorListener f2555f;

    /* renamed from: g  reason: collision with root package name */
    ArrayList f2556g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable.Callback f2557h;

    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
            b.this.scheduleSelf(runnable, j6);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.vectordrawable.graphics.drawable.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2559a;

        /* renamed from: b  reason: collision with root package name */
        g f2560b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f2561c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList f2562d;

        /* renamed from: e  reason: collision with root package name */
        l.a f2563e;

        public C0025b(Context context, C0025b c0025b, Drawable.Callback callback, Resources resources) {
            if (c0025b != null) {
                this.f2559a = c0025b.f2559a;
                g gVar = c0025b.f2560b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    this.f2560b = (g) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    g gVar2 = (g) this.f2560b.mutate();
                    this.f2560b = gVar2;
                    gVar2.setCallback(callback);
                    this.f2560b.setBounds(c0025b.f2560b.getBounds());
                    this.f2560b.h(false);
                }
                ArrayList arrayList = c0025b.f2562d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2562d = new ArrayList(size);
                    this.f2563e = new l.a(size);
                    for (int i6 = 0; i6 < size; i6++) {
                        Animator animator = (Animator) c0025b.f2562d.get(i6);
                        Animator clone = animator.clone();
                        String str = (String) c0025b.f2563e.get(animator);
                        clone.setTarget(this.f2560b.d(str));
                        this.f2562d.add(clone);
                        this.f2563e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f2561c == null) {
                this.f2561c = new AnimatorSet();
            }
            this.f2561c.playTogether(this.f2562d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2559a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: classes.dex */
    private static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2564a;

        public c(Drawable.ConstantState constantState) {
            this.f2564a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2564a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2564a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.f2564a.newDrawable();
            bVar.f2567b = newDrawable;
            newDrawable.setCallback(bVar.f2557h);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.f2564a.newDrawable(resources);
            bVar.f2567b = newDrawable;
            newDrawable.setCallback(bVar.f2557h);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.f2564a.newDrawable(resources, theme);
            bVar.f2567b = newDrawable;
            newDrawable.setCallback(bVar.f2557h);
            return bVar;
        }
    }

    b() {
        this(null, null, null);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f2552c.f2560b.d(str));
        C0025b c0025b = this.f2552c;
        if (c0025b.f2562d == null) {
            c0025b.f2562d = new ArrayList();
            this.f2552c.f2563e = new l.a();
        }
        this.f2552c.f2562d.add(animator);
        this.f2552c.f2563e.put(animator, str);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            return x.b.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f2552c.f2560b.draw(canvas);
        if (this.f2552c.f2561c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2567b;
        return drawable != null ? x.b.d(drawable) : this.f2552c.f2560b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2552c.f2559a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2567b;
        return drawable != null ? x.b.e(drawable) : this.f2552c.f2560b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2567b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f2567b.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2552c.f2560b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2552c.f2560b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getOpacity() : this.f2552c.f2560b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2567b;
        return drawable != null ? x.b.h(drawable) : this.f2552c.f2560b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f2567b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2552c.f2561c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.isStateful() : this.f2552c.f2560b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2552c.f2560b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i6) {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.setLevel(i6) : this.f2552c.f2560b.setLevel(i6);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.setState(iArr) : this.f2552c.f2560b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setAlpha(i6);
        } else {
            this.f2552c.f2560b.setAlpha(i6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.j(drawable, z5);
        } else {
            this.f2552c.f2560b.setAutoMirrored(z5);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i6) {
        super.setChangingConfigurations(i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i6, PorterDuff.Mode mode) {
        super.setColorFilter(i6, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z5) {
        super.setFilterBitmap(z5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f6, float f7) {
        super.setHotspot(f6, f7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i6, int i7, int i8, int i9) {
        super.setHotspotBounds(i6, i7, i8, i9);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.n(drawable, i6);
        } else {
            this.f2552c.f2560b.setTint(i6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.o(drawable, colorStateList);
        } else {
            this.f2552c.f2560b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.p(drawable, mode);
        } else {
            this.f2552c.f2560b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            return drawable.setVisible(z5, z6);
        }
        this.f2552c.f2560b.setVisible(z5, z6);
        return super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f2552c.f2561c.isStarted()) {
        } else {
            this.f2552c.f2561c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2552c.f2561c.end();
        }
    }

    private b(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2544e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        g b6 = g.b(resources, resourceId, theme);
                        b6.h(false);
                        b6.setCallback(this.f2557h);
                        g gVar = this.f2552c.f2560b;
                        if (gVar != null) {
                            gVar.setCallback(null);
                        }
                        this.f2552c.f2560b = b6;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f2545f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2553d;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f2552c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2552c.f2560b.setColorFilter(colorFilter);
        }
    }

    private b(Context context, C0025b c0025b, Resources resources) {
        this.f2554e = null;
        this.f2555f = null;
        this.f2556g = null;
        a aVar = new a();
        this.f2557h = aVar;
        this.f2553d = context;
        if (c0025b != null) {
            this.f2552c = c0025b;
        } else {
            this.f2552c = new C0025b(context, c0025b, aVar, resources);
        }
    }
}
