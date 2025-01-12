package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.s;
import java.io.Serializable;
/* loaded from: classes.dex */
public class A0TdcT extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f5977r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f5978s;

    /* renamed from: t  reason: collision with root package name */
    EditText f5979t;

    /* renamed from: u  reason: collision with root package name */
    TextView f5980u;

    /* renamed from: v  reason: collision with root package name */
    TextView f5981v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f5982w;

    /* loaded from: classes.dex */
    class a extends e0 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = A0TdcT.this.f5979t.getText().toString().trim();
            TextView textView = A0TdcT.this.f5980u;
            textView.setText(trim.length() + "/500");
            A0TdcT.this.f5981v.setEnabled(trim.length() > 2);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a implements s.f {

            /* renamed from: com.secret.prettyhezi.A0TdcT$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0066a implements Runnable {
                RunnableC0066a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    A0TdcT.this.finish();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                A0TdcT.this.f5977r.postDelayed(new RunnableC0066a(), 500L);
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            A0TdcT.this.I0();
            c cVar = new c(A0TdcT.this.f5979t.getText().toString().trim());
            j.t(com.secret.prettyhezi.Server.v.f7133b + com.secret.prettyhezi.Server.v.f7135d, f.e(cVar), null, 4, new s.e(A0TdcT.this, new a()));
        }
    }

    /* loaded from: classes.dex */
    static class c implements Serializable {
        public String content;
        public String device = Settings.Secure.getString(g4.i.j().getContentResolver(), "android_id");
        public String os_version = g4.i.m();
        public String company = Build.MANUFACTURER + "(" + Build.MODEL + ")";
        public String appVersion = MainApplication.i();
        public int userid = MainApplication.f();

        public c(String str) {
            this.content = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ A0TdcT f5988d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.Server.q f5989e;

            a(A0TdcT a0TdcT, com.secret.prettyhezi.Server.q qVar) {
                this.f5988d = a0TdcT;
                this.f5989e = qVar;
            }

            @Override // g4.f
            public void a(View view) {
                A0TdcT.this.N0(VpEEnM.class, this.f5989e.id);
            }
        }

        public d(com.secret.prettyhezi.Server.q qVar) {
            super(A0TdcT.this);
            setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), g4.i.r(10.0f));
            addView(g4.d.b(A0TdcT.this, 16.0f, Color.parseColor("#333333"), qVar.name), new LinearLayout.LayoutParams(-1, -2));
            setBackground(g4.i.f(0, Color.parseColor("#aaaaaa")));
            setOnClickListener(new a(A0TdcT.this, qVar));
        }
    }

    public static TextView S0(ZZcINlcxH zZcINlcxH) {
        TextView a6 = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#666666"));
        a6.setText("系统全自动运行，多研究，不违规就不会有什么问题，遇到bug或者建议可以提，不定期会过来看看的。");
        return a6;
    }

    void T0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.f5982w = linearLayout;
        linearLayout.setOrientation(1);
        this.f5982w.setBackgroundColor(Color.parseColor("#f0f0f0"));
        com.secret.prettyhezi.Server.r rVar = com.secret.prettyhezi.Server.r.notices;
        if (rVar != null) {
            com.secret.prettyhezi.Server.q[] qVarArr = rVar.data.items;
            if (qVarArr.length == 0) {
                return;
            }
            for (com.secret.prettyhezi.Server.q qVar : qVarArr) {
                this.f5982w.addView(new d(qVar), new LinearLayout.LayoutParams(-1, -2));
                W(this.f5982w, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g4.g.a().n(com.secret.prettyhezi.Server.r.keyCheckedNoticeVersion, com.secret.prettyhezi.Server.r.GetNoticeVersion());
        LinearLayout C0 = C0();
        this.f5977r = C0;
        C0.setBackgroundColor(-1);
        this.f5977r.setGravity(5);
        this.f5978s = M(this.f5977r, s0(C0382R.string.BulletinBoard));
        V(this.f5977r, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        T0();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setScrollBarSize(0);
        this.f5977r.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        scrollView.setBackgroundColor(Color.parseColor("#f0f0f0"));
        scrollView.addView(this.f5982w, new FrameLayout.LayoutParams(-1, -2));
        V(this.f5977r, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        EditText editText = new EditText(this);
        this.f5979t = editText;
        editText.setBackground(g4.i.b(Color.parseColor("#f2f2f2"), 4.0f));
        this.f5979t.setTextColor(-16777216);
        this.f5979t.setTextSize(16.0f);
        this.f5979t.setHintTextColor(-7829368);
        this.f5979t.setGravity(51);
        this.f5979t.setHint("Please give us your feedback and suggestions, we are sorry that we can't reply, but we will pay attention, thank you!");
        this.f5979t.setPadding(g4.i.r(12.0f), g4.i.r(14.0f), g4.i.r(12.0f), g4.i.r(0.0f));
        com.secret.prettyhezi.controls.j.a(this.f5979t, 200, 15);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(160.0f));
        layoutParams.topMargin = g4.i.r(20.0f);
        int r5 = g4.i.r(20.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        this.f5977r.addView(this.f5979t, layoutParams);
        TextView c6 = g4.d.c(this, 14, Color.parseColor("#888888"), "0/500", 21);
        this.f5980u = c6;
        c6.setPadding(0, 0, g4.i.r(12.0f), 0);
        this.f5980u.setBackgroundColor(-1);
        new LinearLayout.LayoutParams(-1, g4.i.r(30.0f)).bottomMargin = g4.i.r(20.0f);
        this.f5979t.addTextChangedListener(new a());
        TextView S0 = S0(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(4.0f);
        int r6 = g4.i.r(20.0f);
        layoutParams2.rightMargin = r6;
        layoutParams2.leftMargin = r6;
        this.f5977r.addView(S0, layoutParams2);
        TextView c7 = g4.d.c(this, 16, Color.parseColor("#000000"), s0(C0382R.string.Submit), 17);
        this.f5981v = c7;
        c7.setTextColor(g4.i.q(Color.parseColor("#333333"), -16777216, -7829368, -7829368));
        this.f5981v.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#f0f0f0"), 4.0f)));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(70.0f), g4.i.r(42.0f));
        layoutParams3.topMargin = g4.i.r(8.0f);
        layoutParams3.rightMargin = g4.i.r(20.0f);
        layoutParams3.bottomMargin = g4.i.r(20.0f);
        this.f5977r.addView(this.f5981v, layoutParams3);
        this.f5981v.setEnabled(false);
        this.f5981v.setOnClickListener(new b());
    }
}
