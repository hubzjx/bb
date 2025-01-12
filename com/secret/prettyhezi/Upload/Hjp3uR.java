package com.secret.prettyhezi.Upload;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.WVGAB1kU;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Hjp3uR extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f7306r;

    /* renamed from: s  reason: collision with root package name */
    int f7307s;

    /* renamed from: t  reason: collision with root package name */
    String f7308t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f7309u;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f7310v;

    /* renamed from: w  reason: collision with root package name */
    EditText f7311w;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            Class Z0 = WVGAB1kU.Z0(Hjp3uR.this.f7306r);
            Hjp3uR hjp3uR = Hjp3uR.this;
            hjp3uR.O0(Z0, hjp3uR.f7307s, hjp3uR.f7306r);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                int i6 = (MainApplication.f6711r.r().integral.all > 100.0d ? 1 : (MainApplication.f6711r.r().integral.all == 100.0d ? 0 : -1));
                Hjp3uR hjp3uR = Hjp3uR.this;
                if (i6 < 0) {
                    hjp3uR.D("积分不够", null, true);
                } else {
                    hjp3uR.T0();
                }
            }
        }

        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (Hjp3uR.this.f7311w.getText().toString().trim().length() < 5) {
                Hjp3uR.this.y("申诉理由必须大于5个字");
                return;
            }
            Hjp3uR hjp3uR = Hjp3uR.this;
            hjp3uR.C("申诉将会扣除100积分作为保证金，若申诉不通过，不会返还保证金", new String[]{hjp3uR.s0(C0382R.string.cancel), "申诉"}, new a(), true);
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            Hjp3uR.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements s.f {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainApplication.f6711r.r().integral.all -= 100.0d;
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
                Hjp3uR.this.finish();
            }
        }

        d() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            Hjp3uR.this.f7309u.postDelayed(new a(), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements Serializable {
        String content;
        int id;

        /* renamed from: t  reason: collision with root package name */
        int f7318t;

        public e(int i6, int i7, String str) {
            this.id = i6;
            this.f7318t = i7;
            this.content = str;
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH, String str, int i6, int i7) {
        Intent intent = new Intent();
        intent.setClass(zZcINlcxH, Hjp3uR.class);
        Bundle bundle = new Bundle();
        bundle.putString("extra", str);
        bundle.putInt("id", i7);
        bundle.putInt("type", i6);
        intent.putExtras(bundle);
        zZcINlcxH.startActivity(intent);
    }

    void T0() {
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "report/appeal/json", new e(this.f7307s, this.f7306r, this.f7311w.getText().toString().trim()), true, new s.e(this, new d()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7308t = extras.getString("extra");
            this.f7306r = extras.getInt("type");
            this.f7307s = extras.getInt("id");
        }
        LinearLayout C0 = C0();
        this.f7309u = C0;
        M(C0, "申诉");
        LinearLayout e6 = e(this.f7309u);
        this.f7310v = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        if (this.f7308t.isEmpty()) {
            str = "你上传的内容被用户举报";
        } else {
            TextView b6 = g4.d.b(this, 14.0f, -65536, this.f7308t);
            b6.setPadding(0, g4.i.r(6.0f), 0, g4.i.r(20.0f));
            this.f7310v.addView(b6, new LinearLayout.LayoutParams(-1, -2));
            str = "你上传的内容被用户举报有如上问题";
        }
        this.f7310v.addView(g4.d.c(this, 16, -16777216, str + "，且系统判断属实。如对系统审核有异议，请即刻向系统申诉，申诉需要扣除100积分，如申诉成功，系统返还申诉积分并返还由于被审核违规而扣除的积分。", 3), new LinearLayout.LayoutParams(-2, -2));
        EditText editText = new EditText(this);
        this.f7311w = editText;
        editText.setTextSize(14.0f);
        this.f7311w.setBackground(g4.i.c(-1, 5.0f, -16777216, 1.0f));
        this.f7311w.setGravity(51);
        this.f7311w.setTextColor(-16777216);
        this.f7311w.setHintTextColor(Color.parseColor("#666666"));
        this.f7311w.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        this.f7311w.setHint("请填写申诉理由");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(120.0f));
        layoutParams.topMargin = g4.i.r(10.0f);
        this.f7310v.addView(this.f7311w, layoutParams);
        TextView U = U(this.f7310v, "查看内容详情", 40, 40);
        U.setBackground(g4.i.d(ZZcINlcxH.f0(Color.parseColor("#000000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#333333"), 2.5f)));
        U.setOnClickListener(new a());
        U(this.f7310v, "申诉", 40, 40).setOnClickListener(new b());
        U(this.f7310v, s0(C0382R.string.cancel), 20, 40).setOnClickListener(new c());
    }
}
