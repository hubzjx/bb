package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class t extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    EditText f8461b;

    /* renamed from: c  reason: collision with root package name */
    int f8462c;

    /* renamed from: d  reason: collision with root package name */
    com.secret.prettyhezi.e f8463d;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int a6 = t.this.a();
            if (a6 > 1) {
                EditText editText = t.this.f8461b;
                editText.setText(HttpUrl.FRAGMENT_ENCODE_SET + (a6 - 1));
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8465b;

        b(int i6) {
            this.f8465b = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int a6 = t.this.a();
            if (a6 < this.f8465b) {
                EditText editText = t.this.f8461b;
                editText.setText(HttpUrl.FRAGMENT_ENCODE_SET + (a6 + 1));
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends e0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8467b;

        c(int i6) {
            this.f8467b = i6;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            t tVar;
            int i6;
            String trim = t.this.f8461b.getText().toString().trim();
            if (trim.length() == 0) {
                t.this.f8461b.setText("1");
                tVar = t.this;
                i6 = 1;
            } else {
                int parseInt = Integer.parseInt(trim);
                if (parseInt <= this.f8467b) {
                    t.this.d(parseInt);
                    return;
                }
                EditText editText = t.this.f8461b;
                editText.setText(HttpUrl.FRAGMENT_ENCODE_SET + this.f8467b);
                tVar = t.this;
                i6 = this.f8467b;
            }
            tVar.d(i6);
        }
    }

    public t(Context context, int i6) {
        super(context);
        this.f8463d = null;
        this.f8462c = i6;
        setOrientation(0);
        setGravity(17);
        setBackground(g4.i.c(Color.parseColor("#a0a0a0"), 4.0f, -16777216, 1.0f));
        setPadding(0, 0, 0, 0);
        TextView c6 = g4.d.c(context, 18, -16777216, "-", 17);
        addView(c6, new LinearLayout.LayoutParams(g4.i.r(30.0f), g4.i.r(30.0f)));
        EditText editText = new EditText(context);
        this.f8461b = editText;
        editText.setTextSize(14.0f);
        this.f8461b.setTextColor(-16777216);
        this.f8461b.setGravity(17);
        this.f8461b.setText("1");
        this.f8461b.setInputType(2);
        this.f8461b.setBackground(g4.i.c(-1, 0.0f, -16777216, 1.0f));
        this.f8461b.setPadding(0, 0, 0, 0);
        j.a(this.f8461b, (i6 + HttpUrl.FRAGMENT_ENCODE_SET).length(), 2);
        addView(this.f8461b, new LinearLayout.LayoutParams(g4.i.r(50.0f), g4.i.r(30.0f)));
        TextView c7 = g4.d.c(context, 18, -16777216, k5.d.ANY_NON_NULL_MARKER, 17);
        addView(c7, new LinearLayout.LayoutParams(g4.i.r(30.0f), g4.i.r(30.0f)));
        c6.setOnClickListener(new a());
        c7.setOnClickListener(new b(i6));
        this.f8461b.addTextChangedListener(new c(i6));
    }

    public int a() {
        String trim = this.f8461b.getText().toString().trim();
        if (trim.length() > 0) {
            return Integer.parseInt(trim);
        }
        return 1;
    }

    public void b(com.secret.prettyhezi.e eVar) {
        this.f8463d = eVar;
    }

    public void c(int i6) {
        EditText editText = this.f8461b;
        editText.setText(HttpUrl.FRAGMENT_ENCODE_SET + i6);
    }

    void d(int i6) {
        com.secret.prettyhezi.e eVar = this.f8463d;
        if (eVar != null) {
            eVar.a(i6);
        }
    }
}
