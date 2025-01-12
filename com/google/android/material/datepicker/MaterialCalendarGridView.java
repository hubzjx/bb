package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import e0.b0;
import f0.y;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: b  reason: collision with root package name */
    private final Calendar f5138b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5139c;

    /* loaded from: classes.dex */
    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            yVar.Y(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i6, Rect rect) {
        int b6;
        if (i6 == 33) {
            b6 = getAdapter2().g();
        } else if (i6 != 130) {
            super.onFocusChanged(true, i6, rect);
            return;
        } else {
            b6 = getAdapter2().b();
        }
        setSelection(b6);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b */
    public j getAdapter2() {
        return (j) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j adapter2 = getAdapter2();
        adapter2.getClass();
        adapter2.getItem(adapter2.b());
        adapter2.getItem(adapter2.g());
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z5, int i6, Rect rect) {
        if (z5) {
            a(i6, rect);
        } else {
            super.onFocusChanged(false, i6, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (super.onKeyDown(i6, keyEvent)) {
            if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
                return true;
            }
            if (19 == i6) {
                setSelection(getAdapter2().b());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i6, int i7) {
        if (!this.f5139c) {
            super.onMeasure(i6, i7);
            return;
        }
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i6) {
        if (i6 < getAdapter2().b()) {
            i6 = getAdapter2().b();
        }
        super.setSelection(i6);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5138b = s.k();
        if (MaterialDatePicker.B1(getContext())) {
            setNextFocusLeftId(u2.e.cancel_button);
            setNextFocusRightId(u2.e.confirm_button);
        }
        this.f5139c = MaterialDatePicker.C1(getContext());
        b0.l0(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof j)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), j.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
