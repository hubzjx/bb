package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class v extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public EditText f8469b;

    /* renamed from: c  reason: collision with root package name */
    boolean f8470c;

    /* renamed from: d  reason: collision with root package name */
    View f8471d;

    /* renamed from: e  reason: collision with root package name */
    int f8472e;

    /* renamed from: f  reason: collision with root package name */
    int f8473f;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            v vVar = v.this;
            vVar.setHidden(!vVar.f8470c);
        }
    }

    public v(Context context, int i6) {
        this(context, i6, C0382R.drawable.ic_password_see_on, C0382R.drawable.ic_password_see);
    }

    public void setHidden(boolean z5) {
        EditText editText;
        int i6;
        this.f8470c = z5;
        int selectionStart = this.f8469b.getSelectionStart();
        int selectionEnd = this.f8469b.getSelectionEnd();
        if (z5) {
            this.f8471d.setBackgroundResource(this.f8473f);
            editText = this.f8469b;
            i6 = 129;
        } else {
            this.f8471d.setBackgroundResource(this.f8472e);
            editText = this.f8469b;
            i6 = 1;
        }
        editText.setInputType(i6);
        this.f8469b.setSelection(selectionStart, selectionEnd);
    }

    public void setMaxLength(int i6) {
        this.f8469b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i6)});
    }

    public v(Context context, int i6, int i7, int i8) {
        super(context);
        this.f8470c = true;
        this.f8472e = i7;
        this.f8473f = i8;
        setBackground(g4.i.b(Color.parseColor("#f2f2f2"), 4.0f));
        setPadding(g4.i.r(12.0f), 0, 0, 0);
        View view = new View(context);
        this.f8471d = view;
        view.setBackgroundResource(i8);
        View a6 = u.a(this.f8471d, 20, 20);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(44.0f), g4.i.r(44.0f));
        layoutParams.addRule(11, 1);
        layoutParams.addRule(15, 1);
        addView(a6, layoutParams);
        a6.setId(androidx.constraintlayout.widget.g.T0);
        EditText editText = new EditText(context);
        this.f8469b = editText;
        editText.setBackground(null);
        this.f8469b.setGravity(16);
        this.f8469b.setSingleLine(true);
        this.f8469b.setPadding(0, 0, 0, 0);
        this.f8469b.setTextSize(16.0f);
        this.f8469b.setTextColor(-16777216);
        this.f8469b.setHintTextColor(Color.parseColor("#aaaaaa"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(0, a6.getId());
        layoutParams2.leftMargin = g4.i.r(i6);
        addView(this.f8469b, layoutParams2);
        this.f8469b.setInputType(129);
        a6.setOnClickListener(new a());
    }
}
