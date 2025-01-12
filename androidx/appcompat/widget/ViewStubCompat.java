package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f812b;

    /* renamed from: c  reason: collision with root package name */
    private int f813c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference f814d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f815e;

    /* loaded from: classes.dex */
    public interface a {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f812b != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f815e;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f812b, viewGroup, false);
                int i6 = this.f813c;
                if (i6 != -1) {
                    inflate.setId(i6);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f814d = new WeakReference(inflate);
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f813c;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f815e;
    }

    public int getLayoutResource() {
        return this.f812b;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i6) {
        this.f813c = i6;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f815e = layoutInflater;
    }

    public void setLayoutResource(int i6) {
        this.f812b = i6;
    }

    public void setOnInflateListener(a aVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        WeakReference weakReference = this.f814d;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i6);
            return;
        }
        super.setVisibility(i6);
        if (i6 == 0 || i6 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f812b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.H3, i6, 0);
        this.f813c = obtainStyledAttributes.getResourceId(b.j.K3, -1);
        this.f812b = obtainStyledAttributes.getResourceId(b.j.J3, 0);
        setId(obtainStyledAttributes.getResourceId(b.j.I3, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
