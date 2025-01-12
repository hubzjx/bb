package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.b;
/* loaded from: classes.dex */
public class w extends Spinner {

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f1093j = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final androidx.appcompat.widget.e f1094b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1095c;

    /* renamed from: d  reason: collision with root package name */
    private i1 f1096d;

    /* renamed from: e  reason: collision with root package name */
    private SpinnerAdapter f1097e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1098f;

    /* renamed from: g  reason: collision with root package name */
    private g f1099g;

    /* renamed from: h  reason: collision with root package name */
    int f1100h;

    /* renamed from: i  reason: collision with root package name */
    final Rect f1101i;

    /* loaded from: classes.dex */
    class a extends i1 {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ e f1102k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f1102k = eVar;
        }

        @Override // androidx.appcompat.widget.i1
        public i.e b() {
            return this.f1102k;
        }

        @Override // androidx.appcompat.widget.i1
        public boolean c() {
            if (w.this.getInternalPopup().c()) {
                return true;
            }
            w.this.b();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().c()) {
                w.this.b();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements g, DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.app.b f1105b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1106c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f1107d;

        c() {
        }

        @Override // androidx.appcompat.widget.w.g
        public boolean c() {
            androidx.appcompat.app.b bVar = this.f1105b;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.w.g
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f1105b;
            if (bVar != null) {
                bVar.dismiss();
                this.f1105b = null;
            }
        }

        @Override // androidx.appcompat.widget.w.g
        public Drawable f() {
            return null;
        }

        @Override // androidx.appcompat.widget.w.g
        public void h(CharSequence charSequence) {
            this.f1107d = charSequence;
        }

        @Override // androidx.appcompat.widget.w.g
        public void i(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void j(int i6) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void k(int i6) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void l(int i6) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void m(int i6, int i7) {
            if (this.f1106c == null) {
                return;
            }
            b.a aVar = new b.a(w.this.getPopupContext());
            CharSequence charSequence = this.f1107d;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.b create = aVar.g(this.f1106c, w.this.getSelectedItemPosition(), this).create();
            this.f1105b = create;
            ListView g6 = create.g();
            g6.setTextDirection(i6);
            g6.setTextAlignment(i7);
            this.f1105b.show();
        }

        @Override // androidx.appcompat.widget.w.g
        public int n() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence o() {
            return this.f1107d;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            w.this.setSelection(i6);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i6, this.f1106c.getItemId(i6));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.w.g
        public void p(ListAdapter listAdapter) {
            this.f1106c = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private SpinnerAdapter f1109b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1110c;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            Resources.Theme dropDownViewTheme;
            this.f1109b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1110c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !x.a(spinnerAdapter)) {
                return;
            }
            ThemedSpinnerAdapter a6 = y.a(spinnerAdapter);
            dropDownViewTheme = a6.getDropDownViewTheme();
            if (dropDownViewTheme != theme) {
                a6.setDropDownViewTheme(theme);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1110c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i6, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i6, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i6) {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i6);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i6) {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i6);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i6) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            return getDropDownView(i6, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i6) {
            ListAdapter listAdapter = this.f1110c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i6);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1109b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends n1 implements g {
        private CharSequence K;
        ListAdapter L;
        private final Rect M;
        private int N;

        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ w f1111b;

            a(w wVar) {
                this.f1111b = wVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                w.this.setSelection(i6);
                if (w.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    w.this.performItemClick(view, i6, eVar.L.getItemId(i6));
                }
                e.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.U(w.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.S();
                e.super.a();
            }
        }

        /* loaded from: classes.dex */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1114b;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1114b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1114b);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i6) {
            super(context, attributeSet, i6);
            this.M = new Rect();
            D(w.this);
            J(true);
            O(0);
            L(new a(w.this));
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void S() {
            int i6;
            int i7;
            Drawable f6 = f();
            if (f6 != null) {
                f6.getPadding(w.this.f1101i);
                i6 = j2.b(w.this) ? w.this.f1101i.right : -w.this.f1101i.left;
            } else {
                Rect rect = w.this.f1101i;
                rect.right = 0;
                rect.left = 0;
                i6 = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            w wVar = w.this;
            int i8 = wVar.f1100h;
            if (i8 == -2) {
                int a6 = wVar.a((SpinnerAdapter) this.L, f());
                int i9 = w.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = w.this.f1101i;
                int i10 = (i9 - rect2.left) - rect2.right;
                if (a6 > i10) {
                    a6 = i10;
                }
                i7 = Math.max(a6, (width - paddingLeft) - paddingRight);
            } else if (i8 != -1) {
                F(i8);
                l(!j2.b(w.this) ? i6 + (((width - paddingRight) - z()) - T()) : i6 + paddingLeft + T());
            } else {
                i7 = (width - paddingLeft) - paddingRight;
            }
            F(i7);
            l(!j2.b(w.this) ? i6 + (((width - paddingRight) - z()) - T()) : i6 + paddingLeft + T());
        }

        public int T() {
            return this.N;
        }

        boolean U(View view) {
            return e0.b0.Q(view) && view.getGlobalVisibleRect(this.M);
        }

        @Override // androidx.appcompat.widget.w.g
        public void h(CharSequence charSequence) {
            this.K = charSequence;
        }

        @Override // androidx.appcompat.widget.w.g
        public void k(int i6) {
            this.N = i6;
        }

        @Override // androidx.appcompat.widget.w.g
        public void m(int i6, int i7) {
            ViewTreeObserver viewTreeObserver;
            boolean c6 = c();
            S();
            I(2);
            super.a();
            ListView g6 = g();
            g6.setChoiceMode(1);
            g6.setTextDirection(i6);
            g6.setTextAlignment(i7);
            P(w.this.getSelectedItemPosition());
            if (c6 || (viewTreeObserver = w.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            K(new c(bVar));
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence o() {
            return this.K;
        }

        @Override // androidx.appcompat.widget.n1, androidx.appcompat.widget.w.g
        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.L = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f1116a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public f[] newArray(int i6) {
                return new f[i6];
            }
        }

        f(Parcel parcel) {
            super(parcel);
            this.f1116a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeByte(this.f1116a ? (byte) 1 : (byte) 0);
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        boolean c();

        int d();

        void dismiss();

        Drawable f();

        void h(CharSequence charSequence);

        void i(Drawable drawable);

        void j(int i6);

        void k(int i6);

        void l(int i6);

        void m(int i6, int i7);

        int n();

        CharSequence o();

        void p(ListAdapter listAdapter);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.spinnerStyle);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i6 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i7 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i7 = Math.max(i7, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f1101i);
            Rect rect = this.f1101i;
            return i7 + rect.left + rect.right;
        }
        return i7;
    }

    void b() {
        this.f1099g.m(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f1099g;
        return gVar != null ? gVar.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f1099g;
        return gVar != null ? gVar.n() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1099g != null ? this.f1100h : super.getDropDownWidth();
    }

    final g getInternalPopup() {
        return this.f1099g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f1099g;
        return gVar != null ? gVar.f() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1095c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f1099g;
        return gVar != null ? gVar.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f1099g;
        if (gVar == null || !gVar.c()) {
            return;
        }
        this.f1099g.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.f1099g == null || View.MeasureSpec.getMode(i6) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i6)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.f1116a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f1099g;
        fVar.f1116a = gVar != null && gVar.c();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i1 i1Var = this.f1096d;
        if (i1Var == null || !i1Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f1099g;
        if (gVar != null) {
            if (gVar.c()) {
                return true;
            }
            b();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i6) {
        g gVar = this.f1099g;
        if (gVar == null) {
            super.setDropDownHorizontalOffset(i6);
            return;
        }
        gVar.k(i6);
        this.f1099g.l(i6);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i6) {
        g gVar = this.f1099g;
        if (gVar != null) {
            gVar.j(i6);
        } else {
            super.setDropDownVerticalOffset(i6);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i6) {
        if (this.f1099g != null) {
            this.f1100h = i6;
        } else {
            super.setDropDownWidth(i6);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f1099g;
        if (gVar != null) {
            gVar.i(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i6) {
        setPopupBackgroundDrawable(e.b.d(getPopupContext(), i6));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f1099g;
        if (gVar != null) {
            gVar.h(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.f1094b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public w(Context context, AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1098f) {
            this.f1097e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1099g != null) {
            Context context = this.f1095c;
            if (context == null) {
                context = getContext();
            }
            this.f1099g.p(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public w(Context context, AttributeSet attributeSet, int i6, int i7) {
        this(context, attributeSet, i6, i7, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r11 == null) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.w] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w(Context context, AttributeSet attributeSet, int i6, int i7, Resources.Theme theme) {
        super(context, attributeSet, i6);
        h.d dVar;
        ?? r11;
        TypedArray typedArray;
        TypedArray typedArray2;
        CharSequence[] q5;
        SpinnerAdapter spinnerAdapter;
        this.f1101i = new Rect();
        y1.a(this, getContext());
        c2 v5 = c2.v(context, attributeSet, b.j.A2, i6, 0);
        this.f1094b = new androidx.appcompat.widget.e(this);
        try {
            if (theme != null) {
                dVar = new h.d(context, theme);
            } else {
                int n5 = v5.n(b.j.F2, 0);
                if (n5 == 0) {
                    this.f1095c = context;
                    r11 = -1;
                    typedArray = null;
                    if (i7 == -1) {
                        try {
                            typedArray2 = context.obtainStyledAttributes(attributeSet, f1093j, i6, 0);
                            try {
                                boolean hasValue = typedArray2.hasValue(0);
                                r11 = typedArray2;
                                if (hasValue) {
                                    i7 = typedArray2.getInt(0, 0);
                                    r11 = typedArray2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                r11 = typedArray2;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            typedArray2 = null;
                        } catch (Throwable th) {
                            th = th;
                            if (typedArray != null) {
                                typedArray.recycle();
                            }
                            throw th;
                        }
                        r11.recycle();
                    }
                    if (i7 != 0) {
                        c cVar = new c();
                        this.f1099g = cVar;
                        cVar.h(v5.o(b.j.D2));
                    } else if (i7 == 1) {
                        e eVar = new e(this.f1095c, attributeSet, i6);
                        c2 v6 = c2.v(this.f1095c, attributeSet, b.j.A2, i6, 0);
                        this.f1100h = v6.m(b.j.E2, -2);
                        eVar.i(v6.g(b.j.C2));
                        eVar.h(v5.o(b.j.D2));
                        v6.w();
                        this.f1099g = eVar;
                        this.f1096d = new a(this, eVar);
                    }
                    q5 = v5.q(b.j.B2);
                    if (q5 != null) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, q5);
                        arrayAdapter.setDropDownViewResource(b.g.support_simple_spinner_dropdown_item);
                        setAdapter(arrayAdapter);
                    }
                    v5.w();
                    this.f1098f = true;
                    spinnerAdapter = this.f1097e;
                    if (spinnerAdapter != null) {
                        setAdapter(spinnerAdapter);
                        this.f1097e = null;
                    }
                    this.f1094b.e(attributeSet, i6);
                    return;
                }
                dVar = new h.d(context, n5);
            }
            if (i7 == -1) {
            }
            if (i7 != 0) {
            }
            q5 = v5.q(b.j.B2);
            if (q5 != null) {
            }
            v5.w();
            this.f1098f = true;
            spinnerAdapter = this.f1097e;
            if (spinnerAdapter != null) {
            }
            this.f1094b.e(attributeSet, i6);
            return;
        } catch (Throwable th2) {
            th = th2;
            typedArray = r11;
        }
        this.f1095c = dVar;
        r11 = -1;
        typedArray = null;
    }
}
