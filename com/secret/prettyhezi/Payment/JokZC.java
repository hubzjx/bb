package com.secret.prettyhezi.Payment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class JokZC extends UoWMF {
    g4.f A = new e();
    View B = null;

    /* renamed from: r  reason: collision with root package name */
    int f6784r;

    /* renamed from: s  reason: collision with root package name */
    int f6785s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6786t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f6787u;

    /* renamed from: v  reason: collision with root package name */
    Switch f6788v;

    /* renamed from: w  reason: collision with root package name */
    TextView f6789w;

    /* renamed from: x  reason: collision with root package name */
    Bitmap f6790x;

    /* renamed from: y  reason: collision with root package name */
    TextView f6791y;

    /* renamed from: z  reason: collision with root package name */
    TextView f6792z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f6793a;

        /* renamed from: com.secret.prettyhezi.Payment.JokZC$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0087a implements a.f {
            C0087a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                a aVar = a.this;
                JokZC.this.V0(aVar.f6793a);
            }
        }

        a(boolean z5) {
            this.f6793a = z5;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.e();
            com.secret.prettyhezi.Device.a.b(JokZC.this, new C0087a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements s.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Payment.b f6796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f6797b;

        b(com.secret.prettyhezi.Payment.b bVar, boolean z5) {
            this.f6796a = bVar;
            this.f6797b = z5;
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            this.f6796a.status = this.f6797b ? 1 : 0;
            JokZC.this.b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            JokZC.this.Y0(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            JokZC.this.X0();
        }
    }

    /* loaded from: classes.dex */
    class e extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                JokZC.this.T0();
            }
        }

        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            JokZC jokZC = JokZC.this;
            jokZC.B("请上传" + com.secret.prettyhezi.Payment.d.b(JokZC.this.f6784r) + "的收款码", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ZZcINlcxH.p {
        f() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.p
        public void a() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.p
        public void b(Bitmap bitmap) {
            if (bitmap.getWidth() > 1024 || bitmap.getHeight() > 1100) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
            JokZC.this.J0("正在识别二维码");
            new o(bitmap).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6804a;

        g(String str) {
            this.f6804a = str;
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            JokZC.this.W0(this.f6804a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements s.f {
        h() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            JokZC.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements s.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Payment.b f6807a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6808b;

        i(com.secret.prettyhezi.Payment.b bVar, String str) {
            this.f6807a = bVar;
            this.f6808b = str;
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            this.f6807a.account = this.f6808b;
            JokZC.this.H("已保存");
            JokZC.this.b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                JokZC.this.U0();
            }
        }

        j() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.e();
            com.secret.prettyhezi.Device.a.b(JokZC.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements s.f {
        k() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            JokZC.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l extends v.f {
        String account;

        /* renamed from: t  reason: collision with root package name */
        int f6813t;

        l(int i6, String str) {
            this.f6813t = i6;
            this.account = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m extends v.f {
        String account;

        m(String str) {
            this.account = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        String f6814a;

        public n(String str) {
            this.f6814a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            JokZC jokZC = JokZC.this;
            return com.secret.prettyhezi.share.a.a(this.f6814a, BitmapFactory.decodeResource(jokZC.getResources(), jokZC.f6784r == 2 ? C0382R.drawable.wx : C0382R.drawable.ali));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            JokZC.this.j0();
            JokZC.this.a1(bitmap);
        }
    }

    /* loaded from: classes.dex */
    class o extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        Bitmap f6816a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements x.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ x f6818a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f6819b;

            a(x xVar, String str) {
                this.f6818a = xVar;
                this.f6819b = str;
            }

            @Override // com.secret.prettyhezi.controls.x.c
            public void a(int i6) {
                if (JokZC.this.j(this.f6818a) && i6 == 1) {
                    JokZC.this.Z0(this.f6819b);
                }
            }
        }

        public o(Bitmap bitmap) {
            this.f6816a = bitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            return com.secret.prettyhezi.Payment.a.c(this.f6816a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            JokZC jokZC;
            String str2;
            JokZC.this.j0();
            if (str == null || str.length() == 0) {
                jokZC = JokZC.this;
                str2 = "识别不到收款码";
            } else if (JokZC.this.f6784r == 2 && !com.secret.prettyhezi.Payment.a.b(str)) {
                jokZC = JokZC.this;
                str2 = "请上传微信收款码";
            } else if (JokZC.this.f6784r != 1 || com.secret.prettyhezi.Payment.a.a(str)) {
                JokZC jokZC2 = JokZC.this;
                if (jokZC2.f6785s == 0 || !com.secret.prettyhezi.Payment.d.a(jokZC2.f6784r).account.equals(str)) {
                    JokZC.this.f6790x = this.f6816a;
                    x xVar = new x(JokZC.this);
                    ImageView imageView = new ImageView(JokZC.this);
                    imageView.setImageBitmap(JokZC.this.f6790x);
                    xVar.h("上传此收款码？", imageView, 16);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    int r5 = g4.i.r(200.0f);
                    layoutParams.height = r5;
                    layoutParams.width = r5;
                    imageView.setLayoutParams(layoutParams);
                    xVar.d(new String[]{JokZC.this.s0(C0382R.string.cancel), JokZC.this.s0(C0382R.string.ok)}, new a(xVar, str));
                    JokZC.this.x(xVar, null, false);
                    return;
                }
                jokZC = JokZC.this;
                str2 = "请上传不同的收款码";
            } else {
                jokZC = JokZC.this;
                str2 = "请上传支付宝收款码";
            }
            jokZC.y(str2);
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(-1);
        this.f6787u.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        z zVar = new z(this, com.secret.prettyhezi.Payment.d.c(this.f6784r));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(36.0f), g4.i.r(36.0f));
        layoutParams.leftMargin = g4.i.r(12.0f);
        layoutParams.rightMargin = g4.i.r(8.0f);
        linearLayout.addView(zVar, layoutParams);
        linearLayout.addView(g4.d.b(this, 16.0f, -16777216, com.secret.prettyhezi.Payment.d.b(this.f6784r) + "收款码"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        com.secret.prettyhezi.Payment.b a6 = com.secret.prettyhezi.Payment.d.a(this.f6784r);
        if (a6 != null) {
            TextView b6 = g4.d.b(this, 14.0f, -16777216, a6.status == 0 ? "启用" : "已启用");
            this.f6789w = b6;
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
            Switch r6 = new Switch(this);
            this.f6788v = r6;
            r6.setBackgroundColor(-1);
            this.f6788v.setChecked(a6.status == 1);
            this.f6788v.setTextSize(16.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(50.0f), g4.i.r(24.0f));
            layoutParams2.rightMargin = g4.i.r(12.0f);
            linearLayout.addView(this.f6788v, layoutParams2);
            this.f6788v.setOnCheckedChangeListener(new c());
        }
        V(this.f6787u, Color.parseColor("#cccccc"), 0.5f, 0, 0);
    }

    void T0() {
        v(new f());
    }

    void U0() {
        com.secret.prettyhezi.Payment.b a6 = com.secret.prettyhezi.Payment.d.a(this.f6784r);
        com.secret.prettyhezi.j.r(v.f7132a + "user/payment/json?ac=del&id=" + a6.id, new v.f(), true, new s.e(this, new k()));
    }

    void V0(boolean z5) {
        com.secret.prettyhezi.Payment.b a6 = com.secret.prettyhezi.Payment.d.a(this.f6784r);
        StringBuilder sb = new StringBuilder();
        sb.append(v.f7132a);
        sb.append("user/payment/json?ac=status&id=");
        sb.append(a6.id);
        sb.append("&t=");
        sb.append(z5 ? "1" : "0");
        com.secret.prettyhezi.j.r(sb.toString(), new v.f(), true, new s.e(this, new b(a6, z5)));
    }

    void W0(String str) {
        com.secret.prettyhezi.Payment.b a6 = com.secret.prettyhezi.Payment.d.a(this.f6784r);
        if (a6 == null) {
            com.secret.prettyhezi.j.r(v.f7132a + "user/payment/json?ac=new", new l(this.f6784r, str), true, new s.e(this, new h()));
            return;
        }
        com.secret.prettyhezi.j.r(v.f7132a + "user/payment/json?ac=edit&id=" + a6.id, new m(str), true, new s.e(this, new i(a6, str)));
    }

    void X0() {
        B("删除当前收款码？", new j(), false);
    }

    void Y0(boolean z5) {
        this.f6788v.setChecked(com.secret.prettyhezi.Payment.d.a(this.f6784r).status == 1);
        StringBuilder sb = new StringBuilder();
        sb.append(z5 ? "启用" : "停用");
        sb.append(com.secret.prettyhezi.Payment.d.b(this.f6784r));
        sb.append("收款?");
        B(sb.toString(), new a(z5), false);
    }

    void Z0(String str) {
        com.secret.prettyhezi.Device.a.e();
        com.secret.prettyhezi.Device.a.b(this, new g(str));
    }

    void a1(Bitmap bitmap) {
        if (bitmap == null) {
            View view = this.B;
            if (view != null) {
                this.f6787u.removeView(view);
                this.B = null;
                return;
            }
            return;
        }
        if (this.B == null) {
            this.B = new View(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(200.0f));
            int r5 = g4.i.r(20.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            this.f6787u.addView(this.B, 2, layoutParams);
            this.B.setOnClickListener(this.A);
        }
        this.B.setBackground(new BitmapDrawable(bitmap));
    }

    void b1() {
        this.f6787u.removeAllViews();
        this.B = null;
        S0();
        this.f6785s = com.secret.prettyhezi.Payment.d.d(this.f6784r);
        LinearLayout linearLayout = this.f6787u;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6785s == 0 ? "上传" : "更换");
        sb.append(com.secret.prettyhezi.Payment.d.b(this.f6784r));
        sb.append("收款码");
        TextView U = U(linearLayout, sb.toString(), 30, 40);
        this.f6791y = U;
        U.setOnClickListener(this.A);
        if (this.f6785s != 0) {
            TextView U2 = U(this.f6787u, "删除收款码", 30, 40);
            this.f6792z = U2;
            U2.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#888888"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#333333"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#888888"), 2.5f)));
            this.f6792z.setOnClickListener(new d());
            J0("正在加载收款码图片");
            new n(com.secret.prettyhezi.Payment.d.a(this.f6784r).account).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6784r = extras.getInt("type");
        }
        LinearLayout C0 = C0();
        this.f6786t = C0;
        M(C0, "收款方式设置");
        V(this.f6786t, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(this.f6786t);
        this.f6787u = e6;
        e6.setGravity(1);
        this.f6787u.setPadding(0, 0, 0, g4.i.r(30.0f));
        this.f6787u.setBackgroundColor(-1);
        b1();
    }
}
