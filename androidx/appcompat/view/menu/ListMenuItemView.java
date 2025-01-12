package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.c2;
import e0.b0;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    private g f474b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f475c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f476d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f477e;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f478f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f479g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f480h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f481i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f482j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f483k;

    /* renamed from: l  reason: collision with root package name */
    private int f484l;

    /* renamed from: m  reason: collision with root package name */
    private Context f485m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f486n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f487o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f488p;

    /* renamed from: q  reason: collision with root package name */
    private LayoutInflater f489q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f490r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i6) {
        LinearLayout linearLayout = this.f482j;
        if (linearLayout != null) {
            linearLayout.addView(view, i6);
        } else {
            addView(view, i6);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(b.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f478f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(b.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f475c = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(b.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f476d = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f489q == null) {
            this.f489q = LayoutInflater.from(getContext());
        }
        return this.f489q;
    }

    private void setSubMenuArrowVisible(boolean z5) {
        ImageView imageView = this.f480h;
        if (imageView != null) {
            imageView.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f481i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f481i.getLayoutParams();
        rect.top += this.f481i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i6) {
        this.f474b = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f474b;
    }

    public void h(boolean z5, char c6) {
        int i6 = (z5 && this.f474b.A()) ? 0 : 8;
        if (i6 == 0) {
            this.f479g.setText(this.f474b.h());
        }
        if (this.f479g.getVisibility() != i6) {
            this.f479g.setVisibility(i6);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b0.o0(this, this.f483k);
        TextView textView = (TextView) findViewById(b.f.title);
        this.f477e = textView;
        int i6 = this.f484l;
        if (i6 != -1) {
            textView.setTextAppearance(this.f485m, i6);
        }
        this.f479g = (TextView) findViewById(b.f.shortcut);
        ImageView imageView = (ImageView) findViewById(b.f.submenuarrow);
        this.f480h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f487o);
        }
        this.f481i = (ImageView) findViewById(b.f.group_divider);
        this.f482j = (LinearLayout) findViewById(b.f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.f475c != null && this.f486n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f475c.getLayoutParams();
            int i8 = layoutParams.height;
            if (i8 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i8;
            }
        }
        super.onMeasure(i6, i7);
    }

    public void setCheckable(boolean z5) {
        CompoundButton compoundButton;
        View view;
        if (!z5 && this.f476d == null && this.f478f == null) {
            return;
        }
        if (this.f474b.m()) {
            if (this.f476d == null) {
                g();
            }
            compoundButton = this.f476d;
            view = this.f478f;
        } else {
            if (this.f478f == null) {
                c();
            }
            compoundButton = this.f478f;
            view = this.f476d;
        }
        if (z5) {
            compoundButton.setChecked(this.f474b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f478f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f476d;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z5) {
        CompoundButton compoundButton;
        if (this.f474b.m()) {
            if (this.f476d == null) {
                g();
            }
            compoundButton = this.f476d;
        } else {
            if (this.f478f == null) {
                c();
            }
            compoundButton = this.f478f;
        }
        compoundButton.setChecked(z5);
    }

    public void setForceShowIcon(boolean z5) {
        this.f490r = z5;
        this.f486n = z5;
    }

    public void setGroupDividerEnabled(boolean z5) {
        ImageView imageView = this.f481i;
        if (imageView != null) {
            imageView.setVisibility((this.f488p || !z5) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z5 = this.f474b.z() || this.f490r;
        if (z5 || this.f486n) {
            ImageView imageView = this.f475c;
            if (imageView == null && drawable == null && !this.f486n) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f486n) {
                this.f475c.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f475c;
            if (!z5) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f475c.getVisibility() != 0) {
                this.f475c.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i6;
        TextView textView;
        if (charSequence != null) {
            this.f477e.setText(charSequence);
            if (this.f477e.getVisibility() == 0) {
                return;
            }
            textView = this.f477e;
            i6 = 0;
        } else {
            i6 = 8;
            if (this.f477e.getVisibility() == 8) {
                return;
            }
            textView = this.f477e;
        }
        textView.setVisibility(i6);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet);
        c2 v5 = c2.v(getContext(), attributeSet, b.j.W1, i6, 0);
        this.f483k = v5.g(b.j.Y1);
        this.f484l = v5.n(b.j.X1, -1);
        this.f486n = v5.a(b.j.Z1, false);
        this.f485m = context;
        this.f487o = v5.g(b.j.f2715a2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, b.a.dropDownListViewStyle, 0);
        this.f488p = obtainStyledAttributes.hasValue(0);
        v5.w();
        obtainStyledAttributes.recycle();
    }
}
