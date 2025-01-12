package com.secret.prettyhezi.controls;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class x extends w {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f8475b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f8476c;

    /* renamed from: d  reason: collision with root package name */
    public c f8477d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f8478e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f8479f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8480d;

        a(int i6) {
            this.f8480d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            c cVar = x.this.f8477d;
            if (cVar != null) {
                cVar.a(this.f8480d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8482a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8483b;

        b(int i6, int i7) {
            this.f8482a = i6;
            this.f8483b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.c(this.f8482a, this.f8483b - 1);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i6);
    }

    public x(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        this.f8478e = null;
        this.f8479f = null;
        setBackground(ZZcINlcxH.f0(-1, 12.5f));
        setGravity(1);
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        this.f8475b = linearLayout;
        linearLayout.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(25.0f);
        layoutParams.bottomMargin = g4.i.r(25.0f);
        this.f8475b.setGravity(1);
        this.f8475b.setOrientation(1);
        addView(this.f8475b, layoutParams);
        zZcINlcxH.V(this, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        this.f8476c = new LinearLayout(zZcINlcxH);
        addView(this.f8476c, new LinearLayout.LayoutParams(-1, g4.i.r(46.0f)));
    }

    public void b() {
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setVerticalScrollBarEnabled(false);
        removeView(this.f8475b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ((ZZcINlcxH) getContext()).o().y / 2);
        layoutParams.topMargin = g4.i.r(25.0f);
        layoutParams.bottomMargin = g4.i.r(25.0f);
        addView(scrollView, 0, layoutParams);
        scrollView.addView(this.f8475b, new ViewGroup.LayoutParams(-1, -2));
    }

    public void c(int i6, int i7) {
        TextView textView = (TextView) this.f8476c.getChildAt(i6 * 2);
        String charSequence = textView.getText().toString();
        if (charSequence.contains("(")) {
            charSequence = charSequence.substring(0, charSequence.lastIndexOf("("));
        }
        if (i7 <= 0) {
            textView.setText(charSequence);
            textView.setEnabled(true);
            textView.setTextColor(-16777216);
            return;
        }
        textView.setText(charSequence + "(" + i7 + ")");
        textView.setEnabled(false);
        textView.setTextColor(-7829368);
        textView.postDelayed(new b(i6, i7), 1000L);
    }

    public void d(String[] strArr, c cVar) {
        this.f8477d = cVar;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (i6 > 0) {
                View view = new View(getContext());
                view.setBackgroundColor(Color.parseColor("#cccccc"));
                this.f8476c.addView(view, new LinearLayout.LayoutParams(g4.i.r(0.5f), -1));
            }
            TextView c6 = g4.d.c(getContext(), 16, -16777216, strArr[i6], 17);
            if (strArr[i6].equals(g4.i.j().s0(C0382R.string.cancel))) {
                g4.d.d(c6, 16.0f, Color.parseColor("#666666"));
            }
            c6.setBackground(g4.i.f(0, Color.parseColor("#3f000000")));
            this.f8476c.addView(c6, layoutParams);
            c6.setOnClickListener(new a(i6));
        }
    }

    public x e(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(20.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        this.f8475b.addView(view, layoutParams);
        return this;
    }

    public x f(String str) {
        return g(str, 16, -16777216);
    }

    public x g(String str, int i6, int i7) {
        TextView b6 = g4.d.b(getContext(), i6, i7, str);
        this.f8478e = b6;
        b6.setGravity(17);
        if (str.length() > 20) {
            this.f8478e.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        }
        this.f8475b.addView(this.f8478e, new LinearLayout.LayoutParams(-2, -2));
        return this;
    }

    public x h(String str, View view, int i6) {
        f(str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(i6);
        this.f8475b.addView(view, layoutParams);
        return this;
    }

    public x i(String str, String str2) {
        TextView c6 = g4.d.c(getContext(), 14, -16777216, str2, 17);
        this.f8479f = c6;
        return h(str, c6, 6);
    }
}
