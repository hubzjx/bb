package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.f2;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.n0;
/* loaded from: classes.dex */
public class ActionMenuItemView extends n0 implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: f  reason: collision with root package name */
    g f459f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f460g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f461h;

    /* renamed from: i  reason: collision with root package name */
    e.b f462i;

    /* renamed from: j  reason: collision with root package name */
    private i1 f463j;

    /* renamed from: k  reason: collision with root package name */
    b f464k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f465l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f466m;

    /* renamed from: n  reason: collision with root package name */
    private int f467n;

    /* renamed from: o  reason: collision with root package name */
    private int f468o;

    /* renamed from: p  reason: collision with root package name */
    private int f469p;

    /* loaded from: classes.dex */
    private class a extends i1 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.i1
        public i.e b() {
            b bVar = ActionMenuItemView.this.f464k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.i1
        protected boolean c() {
            i.e b6;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f462i;
            return bVar != null && bVar.a(actionMenuItemView.f459f) && (b6 = b()) != null && b6.c();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract i.e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i6 = configuration.screenWidthDp;
        return i6 >= 480 || (i6 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(this.f460g);
        if (this.f461h != null && (!this.f459f.B() || (!this.f465l && !this.f466m))) {
            z5 = false;
        }
        boolean z7 = z6 & z5;
        setText(z7 ? this.f460g : null);
        CharSequence contentDescription = this.f459f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z7 ? null : this.f459f.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f459f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            f2.a(this, z7 ? null : this.f459f.getTitle());
        } else {
            f2.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f459f.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i6) {
        this.f459f = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f463j == null) {
            this.f463j = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f459f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f462i;
        if (bVar != null) {
            bVar.a(this.f459f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f465l = g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.n0, android.widget.TextView, android.view.View
    public void onMeasure(int i6, int i7) {
        int i8;
        boolean f6 = f();
        if (f6 && (i8 = this.f468o) >= 0) {
            super.setPadding(i8, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f467n) : this.f467n;
        if (mode != 1073741824 && this.f467n > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i7);
        }
        if (f6 || this.f461h == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f461h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i1 i1Var;
        if (this.f459f.hasSubMenu() && (i1Var = this.f463j) != null && i1Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z5) {
    }

    public void setChecked(boolean z5) {
    }

    public void setExpandedFormat(boolean z5) {
        if (this.f466m != z5) {
            this.f466m = z5;
            g gVar = this.f459f;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f461h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i6 = this.f469p;
            if (intrinsicWidth > i6) {
                intrinsicHeight = (int) (intrinsicHeight * (i6 / intrinsicWidth));
                intrinsicWidth = i6;
            }
            if (intrinsicHeight > i6) {
                intrinsicWidth = (int) (intrinsicWidth * (i6 / intrinsicHeight));
            } else {
                i6 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i6);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(e.b bVar) {
        this.f462i = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i6, int i7, int i8, int i9) {
        this.f468o = i6;
        super.setPadding(i6, i7, i8, i9);
    }

    public void setPopupCallback(b bVar) {
        this.f464k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f460g = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        Resources resources = context.getResources();
        this.f465l = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.f2817v, i6, 0);
        this.f467n = obtainStyledAttributes.getDimensionPixelSize(b.j.f2822w, 0);
        obtainStyledAttributes.recycle();
        this.f469p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f468o = -1;
        setSaveEnabled(false);
    }
}
