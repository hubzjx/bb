package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class w extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    int f8059b;

    /* renamed from: c  reason: collision with root package name */
    int f8060c;

    /* renamed from: d  reason: collision with root package name */
    int f8061d;

    /* renamed from: e  reason: collision with root package name */
    String f8062e;

    /* renamed from: f  reason: collision with root package name */
    String f8063f;

    /* renamed from: g  reason: collision with root package name */
    TextView f8064g;

    /* renamed from: h  reason: collision with root package name */
    boolean f8065h;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            w.this.d();
        }
    }

    /* loaded from: classes.dex */
    static class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        w f8067a;

        b(w wVar) {
            this.f8067a = wVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(String... strArr) {
            return Integer.valueOf(com.secret.prettyhezi.j.h(strArr[0]));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            this.f8067a.f8059b = num.intValue();
            TextView textView = this.f8067a.f8064g;
            textView.setText("加载失败：" + num);
            this.f8067a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        w f8068a;

        c(w wVar) {
            this.f8068a = wVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return g4.i.J(strArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            w wVar = this.f8068a;
            wVar.f8063f = str;
            wVar.c();
        }
    }

    public w(ZZcINlcxH zZcINlcxH, int i6, int i7, int i8, String str, String str2) {
        this(zZcINlcxH, i7, i8, str);
        this.f8059b = i6;
        this.f8063f = str2;
        TextView textView = this.f8064g;
        textView.setText("加载失败：" + i6);
    }

    public void a() {
        new b(this).execute(this.f8062e);
    }

    public void b() {
        new c(this).execute(this.f8062e);
    }

    public void c() {
        if (!this.f8065h || this.f8059b == -1 || this.f8063f == null) {
            return;
        }
        g4.i.j().j0();
        this.f8065h = false;
        com.secret.prettyhezi.controls.r.e(this.f8059b, this.f8060c, this.f8061d, this.f8062e, this.f8063f);
    }

    void d() {
        String str;
        if (com.secret.prettyhezi.controls.r.c(this.f8062e)) {
            int i6 = this.f8059b;
            if (i6 >= 0 && (str = this.f8063f) != null) {
                com.secret.prettyhezi.controls.r.e(i6, this.f8060c, this.f8061d, this.f8062e, str);
                return;
            }
            this.f8065h = true;
            g4.i.j().I0();
            if (this.f8063f == null) {
                b();
            }
        }
    }

    public w(ZZcINlcxH zZcINlcxH, int i6, int i7, String str) {
        super(zZcINlcxH);
        this.f8065h = false;
        this.f8060c = i6;
        this.f8061d = i7;
        this.f8062e = str;
        this.f8059b = -1;
        setOrientation(1);
        setGravity(17);
        setBackgroundColor(Color.parseColor("#cccccc"));
        addView(new View(getContext()), new LinearLayout.LayoutParams(-1, 0, 3.0f));
        this.f8064g = g4.d.c(getContext(), 14, -65536, "加载失败", 17);
        addView(this.f8064g, new LinearLayout.LayoutParams(-1, -2));
        View c6 = g4.d.c(getContext(), 16, -65536, "提交反馈", 17);
        c6.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#333333"), 5.0f)));
        c6.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(50.0f));
        layoutParams.topMargin = g4.i.r(30.0f);
        addView(c6, layoutParams);
        addView(new View(getContext()), new LinearLayout.LayoutParams(-1, 0, 7.0f));
    }
}
