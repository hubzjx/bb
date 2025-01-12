package com.secret.prettyhezi.User;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.controls.v;
import com.secret.prettyhezi.s;
import java.io.IOException;
/* loaded from: classes.dex */
public class KUDZxA extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7555r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f7556s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7557t;

    /* renamed from: u  reason: collision with root package name */
    private v f7558u;

    /* renamed from: v  reason: collision with root package name */
    TextView f7559v;

    /* renamed from: w  reason: collision with root package name */
    TextView f7560w = null;

    /* renamed from: x  reason: collision with root package name */
    e0 f7561x = new d();

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            KUDZxA.this.U0();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            KUDZxA kUDZxA = KUDZxA.this;
            kUDZxA.T0(kUDZxA.f7557t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7564b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ZZcINlcxH zZcINlcxH, String str) {
            super(zZcINlcxH);
            this.f7564b = str;
        }

        @Override // com.secret.prettyhezi.s.g, com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            super.a(iOException);
            KUDZxA.this.k0();
        }

        @Override // com.secret.prettyhezi.s.g, com.secret.prettyhezi.j.e
        public void b(int i6) {
            super.b(i6);
            KUDZxA.this.k0();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code != 200) {
                f(pVar.err);
                return;
            }
            MainApplication.f6711r.A(pVar.data);
            KUDZxA kUDZxA = KUDZxA.this;
            kUDZxA.H(kUDZxA.s0(C0382R.string.SaveSuccessfully));
            g4.g.a().k(g4.g.a().e(), this.f7564b, pVar.data.token);
            KUDZxA.this.f7560w.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    class d extends e0 {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            KUDZxA.this.f7559v.setEnabled(!KUDZxA.this.f7558u.f8469b.getText().toString().trim().isEmpty());
        }
    }

    void T0(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        k(createBitmap);
    }

    void U0() {
        String trim = this.f7558u.f8469b.getText().toString().trim();
        I0();
        com.secret.prettyhezi.Server.v.r(trim, new c(this, trim));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7555r = C0;
        C0.setBackgroundColor(-1);
        this.f7556s = M(this.f7555r, s0(C0382R.string.ChangePassword));
        LinearLayout e6 = e(this.f7555r);
        this.f7557t = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        v vVar = new v(this, 0);
        this.f7558u = vVar;
        vVar.f8469b.setHint(s0(C0382R.string.NewPassword));
        this.f7558u.setMaxLength(32);
        this.f7558u.f8469b.addTextChangedListener(this.f7561x);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams.topMargin = g4.i.r(20.0f);
        this.f7557t.addView(this.f7558u, layoutParams);
        TextView U = U(this.f7557t, s0(C0382R.string.Save), 30, 0);
        this.f7559v = U;
        U.setEnabled(false);
        this.f7559v.setOnClickListener(new a());
        TextView U2 = U(this.f7557t, s0(C0382R.string.CaptureScreenAndSave), g4.i.r(10.0f), 0);
        this.f7560w = U2;
        U2.setOnClickListener(new b());
        this.f7560w.setVisibility(8);
        this.f7558u.setHidden(false);
    }
}
