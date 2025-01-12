package com.secret.prettyhezi.User;

import android.graphics.Color;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.UUS6bYTjG;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import java.io.Serializable;
/* loaded from: classes.dex */
public class f extends x {

    /* renamed from: g  reason: collision with root package name */
    ZZcINlcxH f7729g;

    /* loaded from: classes.dex */
    class a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7730a;

        a(ZZcINlcxH zZcINlcxH) {
            this.f7730a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (this.f7730a.j(f.this)) {
                if (i6 == 1) {
                    f.this.l();
                } else if (i6 == 2) {
                    f.this.f7729g.M0(UUS6bYTjG.class);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f7732a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f7733b;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
                if (zVar.code != 200) {
                    f(zVar.err);
                    return;
                }
                b bVar = b.this;
                f.this.f7729g.j(bVar.f7732a);
                f.this.f7729g.D("你已成为正式会员", null, true);
                MainApplication.f6711r.r().grade = 1;
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.n();
            }
        }

        b(x xVar, EditText editText) {
            this.f7732a = xVar;
            this.f7733b = editText;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (i6 == 0) {
                f.this.f7729g.j(this.f7732a);
            } else if (i6 == 1) {
                String trim = this.f7733b.getText().toString().trim();
                if (trim.length() < 5 || trim.length() > 7) {
                    f.this.f7729g.q("请输入正确的注册码");
                    return;
                }
                f.this.f7729g.I0();
                com.secret.prettyhezi.j.r(v.f7132a + "user/grade/json", new d(trim), true, new a(f.this.f7729g));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f7736a;

        c(EditText editText) {
            this.f7736a = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7736a.requestFocus();
        }
    }

    /* loaded from: classes.dex */
    static class d implements Serializable {
        public String code;

        d(String str) {
            this.code = str;
        }
    }

    public f(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f7729g = zZcINlcxH;
        f(i6 != 2 ? i6 != 3 ? "成为正式会员解锁此功能" : "今日额度已用完,成为正式会员查看更多" : "非正式会员不能查看热门资源");
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TextView b6 = g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), "正式会员可以开通盒子，积分，游戏等功能");
        b6.setLineSpacing(g4.i.r(2.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(8.0f);
        linearLayout.addView(b6, layoutParams);
        TextView c6 = g4.d.c(zZcINlcxH, 12, -65536, "现在成为正式会员将获得24小时全站超级权限卡", 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(8.0f);
        linearLayout.addView(c6, layoutParams2);
        e(linearLayout);
        d(new String[]{zZcINlcxH.s0(C0382R.string.cancel), "已有注册码", "立即购买"}, new a(zZcINlcxH));
    }

    public static void j(ZZcINlcxH zZcINlcxH) {
        k(zZcINlcxH, 1);
    }

    public static void k(ZZcINlcxH zZcINlcxH, int i6) {
        zZcINlcxH.x(new f(zZcINlcxH, i6), null, true);
    }

    void l() {
        x xVar = new x(this.f7729g);
        xVar.f("输入注册码成为正式用户");
        LinearLayout linearLayout = new LinearLayout(this.f7729g);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), 0);
        EditText editText = new EditText(getContext());
        editText.setTextSize(16.0f);
        editText.setTextColor(-16777216);
        editText.setPadding(g4.i.r(4.0f), g4.i.r(6.0f), g4.i.r(4.0f), g4.i.r(6.0f));
        editText.setGravity(16);
        editText.setBackground(g4.i.c(Color.parseColor("#f2f2f2"), 4.0f, Color.parseColor("#888888"), 1.0f));
        com.secret.prettyhezi.controls.j.a(editText, 8, 6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(160.0f), g4.i.r(40.0f));
        layoutParams.topMargin = g4.i.r(10.0f);
        layoutParams.bottomMargin = g4.i.r(4.0f);
        linearLayout.addView(editText, layoutParams);
        xVar.e(linearLayout);
        xVar.d(new String[]{this.f7729g.s0(C0382R.string.cancel), this.f7729g.s0(C0382R.string.ok)}, new b(xVar, editText));
        this.f7729g.x(xVar, null, true);
        editText.postDelayed(new c(editText), 200L);
    }
}
