package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* loaded from: classes.dex */
public class e extends EditText {

    /* renamed from: b  reason: collision with root package name */
    private int f8308b;

    /* renamed from: c  reason: collision with root package name */
    private int f8309c;

    /* renamed from: d  reason: collision with root package name */
    private int f8310d;

    /* renamed from: e  reason: collision with root package name */
    private int f8311e;

    /* renamed from: f  reason: collision with root package name */
    private int f8312f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f8313g;

    /* renamed from: h  reason: collision with root package name */
    private a f8314h;

    /* renamed from: i  reason: collision with root package name */
    Drawable f8315i;

    /* renamed from: j  reason: collision with root package name */
    Drawable f8316j;

    /* renamed from: k  reason: collision with root package name */
    Drawable f8317k;

    /* loaded from: classes.dex */
    public interface a {
        void a(CharSequence charSequence, int i6);
    }

    public e(Context context, int i6) {
        super(context);
        this.f8313g = new Rect();
        this.f8309c = i6;
        int r5 = g4.i.r(40.0f);
        this.f8311e = r5;
        this.f8310d = r5;
        this.f8312f = 20;
        this.f8315i = g4.i.c(0, 7.5f, -7829368, 1.0f);
        this.f8316j = g4.i.c(Color.parseColor("#ffff00"), 7.5f, Color.parseColor("#F8C193"), 1.0f);
        this.f8317k = g4.i.c(0, 7.5f, Color.parseColor("#F8C193"), 1.0f);
        setBackgroundColor(0);
        setLongClickable(false);
        setCursorVisible(false);
        setInputType(2);
        j.a(this, i6, 2);
    }

    private void a(Canvas canvas) {
        Drawable drawable;
        Rect rect = this.f8313g;
        rect.left = 0;
        rect.top = 0;
        rect.right = this.f8310d;
        rect.bottom = this.f8311e;
        int length = getEditableText().length();
        for (int i6 = 0; i6 < this.f8309c; i6++) {
            Rect rect2 = this.f8313g;
            int i7 = this.f8310d;
            int i8 = (i7 * i6) + (this.f8312f * i6);
            rect2.left = i8;
            rect2.right = i8 + i7;
            if (i6 < length) {
                this.f8317k.setBounds(rect2);
                drawable = this.f8317k;
            } else if (i6 == length) {
                this.f8316j.setBounds(rect2);
                drawable = this.f8316j;
            } else {
                this.f8315i.setBounds(rect2);
                drawable = this.f8315i;
            }
            drawable.draw(canvas);
        }
    }

    private void b(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.translate(0.0f, 0.0f);
        int length = getEditableText().length();
        for (int i6 = 0; i6 < length; i6++) {
            String valueOf = String.valueOf(getEditableText().charAt(i6));
            TextPaint paint = getPaint();
            paint.setColor(this.f8308b);
            paint.getTextBounds(valueOf, 0, 1, this.f8313g);
            int i7 = this.f8310d;
            canvas.drawText(valueOf, ((i7 / 2) + ((i7 + this.f8312f) * i6)) - this.f8313g.centerX(), (canvas.getHeight() / 2) + (this.f8313g.height() / 2), paint);
        }
        canvas.restoreToCount(saveCount);
    }

    public void c() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 2);
        }
    }

    public void d() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 1);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f8308b = getCurrentTextColor();
        setTextColor(0);
        super.onDraw(canvas);
        setTextColor(this.f8308b);
        a(canvas);
        b(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10 = i8 - i6;
        int r5 = (i10 / this.f8309c) - g4.i.r(4.0f);
        if (r5 > g4.i.r(50.0f)) {
            r5 = g4.i.r(50.0f);
        }
        this.f8311e = r5;
        this.f8310d = r5;
        int i11 = this.f8309c;
        this.f8312f = (i10 - (r5 * i11)) / (i11 - 1);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        super.onTextChanged(charSequence, i6, i7, i8);
        if (getEditableText().length() == this.f8309c) {
            c();
            a aVar = this.f8314h;
            if (aVar != null) {
                aVar.a(getEditableText().toString(), this.f8309c);
            }
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i6) {
        return false;
    }

    public void setOnTextFinishListener(a aVar) {
        this.f8314h = aVar;
    }
}
