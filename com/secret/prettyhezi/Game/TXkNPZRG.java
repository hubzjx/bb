package com.secret.prettyhezi.Game;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.PullToRefresh.f;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class TXkNPZRG extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6472r;

    /* renamed from: s  reason: collision with root package name */
    com.secret.prettyhezi.controls.PullToRefresh.i f6473s;

    /* renamed from: t  reason: collision with root package name */
    String f6474t;

    /* loaded from: classes.dex */
    class a extends f.h {
        a() {
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void a(com.secret.prettyhezi.controls.PullToRefresh.f fVar) {
            super.a(fVar);
            String str = TXkNPZRG.this.f6474t;
            if (str == null || str.isEmpty()) {
                return;
            }
            TXkNPZRG tXkNPZRG = TXkNPZRG.this;
            tXkNPZRG.U0(tXkNPZRG.f6474t);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TXkNPZRG.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f6477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f6478b;

        c(com.secret.prettyhezi.controls.x xVar, EditText editText) {
            this.f6477a = xVar;
            this.f6478b = editText;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            Object tag = this.f6477a.getTag();
            if (tag == null) {
                return;
            }
            this.f6477a.setTag(null);
            ((AlertDialog) tag).dismiss();
            if (i6 != 1) {
                TXkNPZRG.this.finish();
                return;
            }
            String trim = this.f6478b.getText().toString().trim();
            if (trim.length() > 0) {
                TXkNPZRG tXkNPZRG = TXkNPZRG.this;
                tXkNPZRG.f6474t = trim;
                tXkNPZRG.f6473s.p(true, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6480b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ZZcINlcxH zZcINlcxH, String str) {
            super(zZcINlcxH);
            this.f6480b = str;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            q0 q0Var = (q0) com.secret.prettyhezi.f.d(str, q0.class);
            TXkNPZRG.this.f6473s.z();
            if (q0Var.code != 200) {
                TXkNPZRG.this.finish();
                return;
            }
            TXkNPZRG.this.T0(q0Var);
            TXkNPZRG.this.f6474t = this.f6480b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements Serializable {
        String password;

        e(String str) {
            this.password = str;
        }
    }

    void S0() {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), 0);
        EditText editText = new EditText(this);
        editText.setTextSize(16.0f);
        editText.setTextColor(-16777216);
        editText.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        editText.setGravity(16);
        editText.setBackground(g4.i.c(Color.parseColor("#f2f2f2"), 4.0f, Color.parseColor("#888888"), 1.0f));
        editText.setHint("password");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(40.0f));
        layoutParams.topMargin = g4.i.r(10.0f);
        layoutParams.bottomMargin = g4.i.r(4.0f);
        linearLayout.addView(editText, layoutParams);
        xVar.e(linearLayout);
        xVar.d(new String[]{s0(C0382R.string.cancel), s0(C0382R.string.ok)}, new c(xVar, editText));
        x(xVar, null, false);
    }

    void T0(q0 q0Var) {
        this.f6472r.removeAllViews();
        int i6 = 0;
        q0 q0Var2 = q0Var;
        int i7 = 0;
        while (true) {
            p0[] p0VarArr = q0Var2.data.items;
            if (i7 >= p0VarArr.length) {
                return;
            }
            p0 p0Var = p0VarArr[i7];
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setBackground(g4.i.b(-1, 5.0f));
            linearLayout.setPadding(g4.i.r(8.0f), i6, g4.i.r(8.0f), i6);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int r5 = g4.i.r(5.0f);
            layoutParams.topMargin = r5;
            layoutParams.rightMargin = r5;
            layoutParams.leftMargin = r5;
            this.f6472r.addView(linearLayout, layoutParams);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(i6);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(25.0f)));
            linearLayout2.setGravity(16);
            linearLayout2.addView(g4.d.b(this, 14.0f, -16777216, p0Var.f6641a), new LinearLayout.LayoutParams(i6, -2, 1.0f));
            linearLayout2.addView(g4.d.b(this, 14.0f, -16777216, p0Var.f6642b + HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(i6, -2, 1.0f));
            linearLayout2.addView(g4.d.b(this, 14.0f, -16777216, p0Var.f6643c + HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(i6, -2, 1.0f));
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(i6);
            linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, g4.i.r(22.0f)));
            linearLayout3.setGravity(16);
            linearLayout3.addView(g4.d.b(this, 14.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(i6, -2, 1.0f));
            linearLayout3.addView(g4.d.b(this, 14.0f, -16777216, p0Var.f6644d + HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(0, -2, 1.0f));
            linearLayout3.addView(g4.d.b(this, 14.0f, -16777216, p0Var.f6645e + HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(0, -2, 1.0f));
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(0);
            linearLayout.addView(linearLayout4, new LinearLayout.LayoutParams(-1, g4.i.r(25.0f)));
            linearLayout4.setGravity(16);
            linearLayout4.addView(g4.d.b(this, 14.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(0, -2, 1.0f));
            int i8 = -65536;
            int i9 = p0Var.f6646f > 0 ? -65536 : -16711936;
            linearLayout4.addView(g4.d.b(this, 14.0f, i9, p0Var.f6646f + HttpUrl.FRAGMENT_ENCODE_SET), new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (p0Var.f6647g.startsWith("-")) {
                i8 = -16711936;
            }
            linearLayout4.addView(g4.d.b(this, 14.0f, i8, p0Var.f6647g), new LinearLayout.LayoutParams(0, -2, 1.0f));
            i7++;
            q0Var2 = q0Var;
            i6 = 0;
        }
    }

    void U0(String str) {
        com.secret.prettyhezi.j.t(i.a() + abc.amu("u1"), com.secret.prettyhezi.f.e(new e(str)), i.f6608a.token.token, 3, new d(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        M(C0, "信息");
        C0.setBackgroundColor(-1);
        V(C0, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6472r = linearLayout;
        linearLayout.setOrientation(1);
        com.secret.prettyhezi.controls.PullToRefresh.i iVar = new com.secret.prettyhezi.controls.PullToRefresh.i(this);
        this.f6473s = iVar;
        iVar.setScrollBarSize(0);
        C0.addView(this.f6473s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f6473s.setOnRefreshListener(new a());
        ((ScrollView) this.f6473s.getRefreshableView()).addView(this.f6472r, new LinearLayout.LayoutParams(-1, -2));
        this.f6472r.setGravity(1);
        this.f6472r.setPadding(0, 0, 0, g4.i.r(20.0f));
        this.f6472r.setBackgroundColor(Color.parseColor("#f0f0f0"));
        this.f6472r.postDelayed(new b(), 100L);
    }
}
