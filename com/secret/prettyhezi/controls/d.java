package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.C0382R;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class d extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f8304b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f8305c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            d.this.f8305c.setText(HttpUrl.FRAGMENT_ENCODE_SET);
            d.this.f8305c.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends e0 {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.this.f8304b.setVisibility(editable.toString().length() > 0 ? 0 : 8);
        }
    }

    public d(Context context) {
        super(context);
        a(context, 0, C0382R.drawable.ic_clear_text);
    }

    void a(Context context, int i6, int i7) {
        setBackground(g4.i.b(Color.parseColor("#f2f2f2"), 4.0f));
        setPadding(g4.i.r(12.0f), 0, 0, 0);
        View view = new View(context);
        this.f8304b = view;
        view.setBackgroundResource(i7);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(44.0f), g4.i.r(44.0f));
        layoutParams.addRule(11, 1);
        layoutParams.addRule(15, 1);
        addView(this.f8304b, layoutParams);
        this.f8304b.setId(androidx.constraintlayout.widget.g.T0);
        this.f8304b.setVisibility(8);
        EditText editText = new EditText(context);
        this.f8305c = editText;
        editText.setBackground(null);
        this.f8305c.setGravity(16);
        this.f8305c.setSingleLine(true);
        this.f8305c.setPadding(0, 0, 0, 0);
        this.f8305c.setInputType(this.f8305c.getInputType() & (-524289));
        this.f8305c.setTextSize(16.0f);
        this.f8305c.setTextColor(-16777216);
        this.f8305c.setHintTextColor(Color.parseColor("#aaaaaa"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(0, this.f8304b.getId());
        layoutParams2.leftMargin = g4.i.r(i6);
        addView(this.f8305c, layoutParams2);
        this.f8304b.setOnClickListener(new a());
        this.f8305c.addTextChangedListener(new b());
    }

    public String getText() {
        return this.f8305c.getText().toString();
    }

    public void setMaxLength(int i6) {
        j.b(this.f8305c, i6);
    }

    public d(Context context, int i6) {
        super(context);
        a(context, i6, C0382R.drawable.ic_clear_text);
    }
}
