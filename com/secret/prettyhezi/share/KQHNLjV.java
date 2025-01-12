package com.secret.prettyhezi.share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.QHHnp8H;
import com.secret.prettyhezi.Registration.Xh1XG;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.s;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.g;
import com.secret.prettyhezi.s;
import java.io.File;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class KQHNLjV extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8862r;

    /* renamed from: s  reason: collision with root package name */
    String f8863s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f8864t;

    /* renamed from: u  reason: collision with root package name */
    ScrollView f8865u;

    /* renamed from: v  reason: collision with root package name */
    TextView f8866v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f8867w;

    /* renamed from: x  reason: collision with root package name */
    LinearLayout f8868x;

    /* renamed from: y  reason: collision with root package name */
    LinearLayout f8869y;

    /* renamed from: z  reason: collision with root package name */
    q f8870z = null;
    boolean A = true;
    com.secret.prettyhezi.controls.g B = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.A = true;
            kQHNLjV.g1(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.A = false;
            kQHNLjV.g1(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.A = false;
            kQHNLjV.g1(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8874a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8875b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8876c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8877d;

        d(String str, String str2, String str3, int i6) {
            this.f8874a = str;
            this.f8875b = str2;
            this.f8876c = str3;
            this.f8877d = i6;
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void a() {
            KQHNLjV.this.y("下载失败，请稍后重试");
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void b() {
            if (!KQHNLjV.l1(this.f8874a, this.f8875b, "123456")) {
                KQHNLjV.this.q("压缩失败，请告知管理员");
                return;
            }
            g4.g.a().o("savedApkVersion", this.f8876c);
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.b1(this.f8877d, kQHNLjV.A ? this.f8875b : this.f8874a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8879a;

        e(String str) {
            this.f8879a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "BeautyBox_" + g4.a.c() + ".apk";
            if (KQHNLjV.this.A) {
                str = str + ".zip";
            }
            g4.c.c(str);
            if (!g4.c.b(this.f8879a, str)) {
                KQHNLjV.this.q("保存失败");
                return;
            }
            KQHNLjV.this.H("成功保存到" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.c f8881a;

        f(g.c cVar) {
            this.f8881a = cVar;
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void a() {
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.j(kQHNLjV.B);
            this.f8881a.a();
            KQHNLjV.this.B = null;
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void b() {
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.j(kQHNLjV.B);
            this.f8881a.b();
            KQHNLjV.this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f8883d;

        g(Class cls) {
            this.f8883d = cls;
        }

        @Override // g4.f
        public void a(View view) {
            if (this.f8883d == MWCuVB.class || !KQHNLjV.this.X()) {
                KQHNLjV.this.M0(this.f8883d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        protected void a(View view) {
            ZZcINlcxH.g(KQHNLjV.this.f8863s);
            KQHNLjV.this.H("已复制到剪贴板");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends ZZcINlcxH.q {
        i() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.share.KQHNLjV$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0141a implements a.f {
                C0141a() {
                }

                @Override // com.secret.prettyhezi.Device.a.f
                public void a(String str) {
                    KQHNLjV.this.Y0(true);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                com.secret.prettyhezi.Device.a.b(KQHNLjV.this, new C0141a());
            }
        }

        j() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (KQHNLjV.this.X()) {
                return;
            }
            KQHNLjV.this.B("确定花费1000积分申请专属安装包?", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends g4.f {
        k() {
        }

        @Override // g4.f
        protected void a(View view) {
            KQHNLjV.this.k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends g4.f {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                KQHNLjV.this.Y0(false);
            }
        }

        l() {
        }

        @Override // g4.f
        protected void a(View view) {
            com.secret.prettyhezi.Device.a.b(KQHNLjV.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends s.g {
        m(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            KQHNLjV.this.f8869y.removeAllViews();
            r rVar = (r) com.secret.prettyhezi.f.d(str, r.class);
            if (rVar.code != 200) {
                f(rVar.err);
                return;
            }
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.f8870z = rVar.data;
            kQHNLjV.f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8894b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(ZZcINlcxH zZcINlcxH, boolean z5) {
            super(zZcINlcxH);
            this.f8894b = z5;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
            if (zVar.code != 200) {
                f(zVar.err);
                return;
            }
            if (this.f8894b) {
                MainApplication.f6711r.r().integral.all -= 1000.0d;
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
            }
            KQHNLjV.this.h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            KQHNLjV kQHNLjV = KQHNLjV.this;
            kQHNLjV.A = true;
            kQHNLjV.g1(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class p implements Serializable {
        public long created_at;
        public int status;
        public long updated_at;
        public String urlpath;
        public String version;

        p() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class q implements Serializable {
        public p info;
        public boolean ishas;

        q() {
        }
    }

    /* loaded from: classes.dex */
    static class r extends w {
        public q data;

        r() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class s extends v.f {
        public String version = g4.a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        String f8897a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Bitmap f8899d;

            a(Bitmap bitmap) {
                this.f8899d = bitmap;
            }

            @Override // g4.f
            protected void a(View view) {
                KQHNLjV.this.k(this.f8899d);
            }
        }

        public t(String str) {
            this.f8897a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            return com.secret.prettyhezi.share.a.a(this.f8897a, BitmapFactory.decodeResource(KQHNLjV.this.getResources(), C0382R.drawable.ic_launcher));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            KQHNLjV.this.f8864t.removeAllViews();
            if (bitmap == null) {
                return;
            }
            View view = new View(KQHNLjV.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(200.0f));
            int r5 = g4.i.r(16.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            KQHNLjV.this.f8864t.addView(view, layoutParams);
            view.setBackground(new BitmapDrawable(bitmap));
            TextView c6 = g4.d.c(KQHNLjV.this, 12, -1, "保存二维码图片", 17);
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f)));
            KQHNLjV.this.f8864t.addView(c6, new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(40.0f)));
            c6.setOnClickListener(new a(bitmap));
        }
    }

    static {
        File file = new File(g4.i.j().getFilesDir().getAbsolutePath() + File.separator + "share");
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    static String d1() {
        StringBuilder sb = new StringBuilder();
        sb.append(g4.i.j().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("share");
        sb.append(str);
        sb.append("BeautyBox.apk");
        return sb.toString();
    }

    static String e1() {
        StringBuilder sb = new StringBuilder();
        sb.append(g4.i.j().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("share");
        sb.append(str);
        sb.append("BeautyBox.zip");
        return sb.toString();
    }

    static boolean l1(String str, String str2, String str3) {
        g4.c.c(str2);
        e5.q qVar = new e5.q();
        qVar.w(f5.d.STORE);
        qVar.v(f5.c.FASTEST);
        qVar.x(true);
        qVar.y(f5.e.ZIP_STANDARD);
        try {
            new w4.a(str2, str3.toCharArray()).a(str, qVar);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void S0(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/octet-stream");
        g4.c.m(str);
        intent.putExtra("android.intent.extra.STREAM", FileProvider.e(this, getPackageName() + ".fileprovider", new File(str)));
        try {
            startActivity(Intent.createChooser(intent, "Please choose the provider to share"));
        } catch (Exception unused) {
            q("分享失败");
        }
    }

    LinearLayout T0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        int r5 = g4.i.r(80.0f);
        int r6 = ((o().x - (r5 * 4)) - g4.i.r(24.0f)) / 8;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r5, g4.i.r(40.0f));
        layoutParams.rightMargin = r6;
        layoutParams.leftMargin = r6;
        linearLayout.addView(a1(s0(C0382R.string.InviteRecord), MWCuVB.class), layoutParams);
        linearLayout.addView(a1("注册码", Xh1XG.class), layoutParams);
        linearLayout.addView(a1("出售注册码", QHHnp8H.class), layoutParams);
        return linearLayout;
    }

    LinearLayout U0(LinearLayout linearLayout, int i6) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        View view = new View(this);
        view.setBackground(g4.i.b(-16777216, 3.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(6.0f), g4.i.r(6.0f));
        layoutParams.rightMargin = g4.i.r(4.0f);
        layoutParams.topMargin = g4.i.r(5.0f);
        linearLayout2.addView(view, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(i6);
        linearLayout.addView(linearLayout2, layoutParams2);
        return linearLayout2;
    }

    void V0() {
        LinearLayout.LayoutParams layoutParams;
        TextView textView;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(g4.i.c(-1, 5.0f, Color.parseColor("#888888"), 1.0f));
        linearLayout.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        this.f8867w.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        s.a GetItem = com.secret.prettyhezi.Server.s.GetItem(7);
        if (GetItem != null) {
            textView = g4.d.a(this, 12.0f, -16777216);
            textView.setText(Html.fromHtml(GetItem.content));
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            LinearLayout U0 = U0(linearLayout, 0);
            com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f(this);
            fVar.a("通过你的邀请码注册的用户，当该用户使用了注册码成为了正式会员时，系统将会赠送你", -16777216, 12.0f);
            fVar.a("1000积分", -65536, 12.0f);
            fVar.a(" + ", -16777216, 12.0f);
            fVar.a("一张权限卡", -65536, 12.0f);
            fVar.a("。", -16777216, 12.0f);
            fVar.b();
            fVar.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
            U0.addView(fVar.f8319b, new LinearLayout.LayoutParams(0, -2, 1.0f));
            LinearLayout U02 = U0(linearLayout, 6);
            com.secret.prettyhezi.controls.f fVar2 = new com.secret.prettyhezi.controls.f(this);
            fVar2.a("购买并使用了你的注册码的新用户，积分奖励分以下2种情况：\n", -16777216, 12.0f);
            fVar2.a("1) 新用户未填写邀请人，系统赠送你", -16777216, 12.0f);
            fVar2.a("1000积分", -65536, 12.0f);
            fVar2.a(" + ", -16777216, 12.0f);
            fVar2.a("一张权限卡", -65536, 12.0f);
            fVar2.a("。\n", -16777216, 12.0f);
            fVar2.a("2) 新用户填写的是别人的邀请码，你没有任何奖励。", Color.parseColor("#0036ff"), 12.0f);
            fVar2.a("\nPS：权限卡是24小时全站无限浏览卡", -16777216, 12.0f);
            fVar2.b();
            fVar2.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
            U02.addView(fVar2.f8319b, new LinearLayout.LayoutParams(0, -2, 1.0f));
            com.secret.prettyhezi.controls.f fVar3 = new com.secret.prettyhezi.controls.f(this);
            fVar3.a("另外，被邀请人消费的每一个积分，您将获得35%的积分提成和35%的推广贡献值，", -16777216, 12.0f);
            fVar3.a("例如：如果您邀请的用户开通了永久热门权限+永久精华权限，您将获得(26666+66666) *0.35 = 32666.2积分和32666.2的推广贡献值。", -16777216, 12.0f);
            fVar3.a("如果您邀请的用户解锁了一个内容花费", -16777216, 12.0f);
            fVar3.a("1积分", -65536, 12.0f);
            fVar3.a("，您将获得", -16777216, 12.0f);
            fVar3.a("0.35积分", -65536, 12.0f);
            fVar3.a("和", -16777216, 12.0f);
            fVar3.a("0.35的推广贡献值", -65536, 12.0f);
            fVar3.a("。所获得的积分，您可以自己用来兑换权限，也可以在积分交易市场转给需要的人。", -16777216, 12.0f);
            fVar3.b();
            fVar3.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = g4.i.r(6.0f);
            textView = fVar3.f8319b;
        }
        linearLayout.addView(textView, layoutParams);
    }

    void W0() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(14.0f);
        this.f8867w.addView(g4.d.b(this, 14.0f, -16777216, "我的专属安装包:"), layoutParams);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8868x = linearLayout;
        linearLayout.setOrientation(1);
        this.f8868x.setGravity(1);
        this.f8868x.setPadding(g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(6.0f), g4.i.r(16.0f));
        this.f8868x.setBackground(g4.i.c(-1, 5.0f, Color.parseColor("#888888"), 1.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(6.0f);
        this.f8867w.addView(this.f8868x, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f8869y = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f8869y.setGravity(1);
        this.f8868x.addView(this.f8869y, new LinearLayout.LayoutParams(-1, -2));
        if (MainApplication.f6711r.r().grade > 0) {
            h1();
        } else {
            f1();
        }
        TextView b6 = g4.d.b(this, 14.0f, -65536, "加密压缩包解压密码为: 123456");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = g4.i.r(20.0f);
        layoutParams3.bottomMargin = g4.i.r(10.0f);
        this.f8868x.addView(b6, layoutParams3);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        this.f8868x.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(38.0f));
        layoutParams4.rightMargin = g4.i.r(20.0f);
        TextView Z0 = Z0("分享加密安装包给朋友");
        linearLayout3.addView(Z0, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(38.0f));
        TextView Z02 = Z0("保存加密安装包到手机");
        linearLayout3.addView(Z02, layoutParams5);
        Z0.setOnClickListener(new o());
        Z02.setOnClickListener(new a());
        TextView b7 = g4.d.b(this, 14.0f, -65536, "为了安全起见，大家尽量使用上面导出的加密安装包，如果不会用或者其他问题，才尝试使用下面按钮导出的未加密码的apk安装包");
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = g4.i.r(40.0f);
        layoutParams6.bottomMargin = g4.i.r(10.0f);
        this.f8868x.addView(b7, layoutParams6);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(17);
        this.f8868x.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(38.0f));
        layoutParams7.rightMargin = g4.i.r(20.0f);
        TextView Z03 = Z0("分享apk安装包给朋友");
        linearLayout4.addView(Z03, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(38.0f));
        TextView Z04 = Z0("保存apk安装包到手机");
        linearLayout4.addView(Z04, layoutParams8);
        Z03.setOnClickListener(new b());
        Z04.setOnClickListener(new c());
    }

    void X0() {
        String str;
        a0 r5 = MainApplication.f6711r.r();
        if (r5 == null || (str = r5.sharehash) == null || r5.shareurl == null || str.isEmpty() || r5.shareurl.isEmpty()) {
            return;
        }
        this.f8863s = MainApplication.f6711r.r().shareurl + "/?t=" + MainApplication.f6711r.r().sharehash;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackground(g4.i.c(-1, 5.0f, Color.parseColor("#888888"), 1.0f));
        linearLayout.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        this.f8867w.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView b6 = g4.d.b(this, 12.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET);
        b6.setText("我的邀请链接：" + this.f8863s);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c6 = g4.d.c(this, 12, -1, "复制链接", 17);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f)));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(g4.i.r(66.0f), g4.i.r(40.0f)));
        c6.setOnClickListener(new h());
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f8864t = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f8864t.setGravity(1);
        this.f8867w.addView(this.f8864t, new LinearLayout.LayoutParams(-1, -2));
        new t(this.f8863s).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    void Y0(boolean z5) {
        if (z5 && MainApplication.f6711r.r().integral.all < 1000.0d) {
            q("积分不够");
            return;
        }
        com.secret.prettyhezi.j.r(v.f7132a + "user/apk/new/json", new s(), true, new n(this, z5));
    }

    TextView Z0(String str) {
        TextView c6 = g4.d.c(this, 11, -1, str, 17);
        new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(38.0f));
        c6.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        return c6;
    }

    TextView a1(String str, Class cls) {
        TextView c6 = g4.d.c(this, str.length() <= 4 ? 12 : 11, -1, str, 17);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f)));
        if (cls != null) {
            c6.setOnClickListener(new g(cls));
        }
        return c6;
    }

    void b1(int i6, String str) {
        if (i6 == 1) {
            j1(str);
        } else {
            i1(str);
        }
    }

    void c1(String str, g.c cVar) {
        g4.c.c(str);
        q qVar = this.f8870z;
        if (qVar != null && qVar.ishas) {
            p pVar = qVar.info;
            if (pVar.status == 1) {
                com.secret.prettyhezi.controls.g gVar = new com.secret.prettyhezi.controls.g(this, MainApplication.f6711r.s(pVar.urlpath), str, new f(cVar));
                this.B = gVar;
                x(gVar, null, false);
                return;
            }
        }
        g4.a.a(this, str, cVar);
    }

    void f1() {
        TextView c6;
        View.OnClickListener jVar;
        q qVar;
        q qVar2 = this.f8870z;
        if (qVar2 == null || !qVar2.ishas) {
            c6 = g4.d.c(this, 12, -1, "申请我的专属安装包", 17);
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f)));
            this.f8869y.addView(c6, new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(40.0f)));
            jVar = new j();
        } else if (qVar2.info.status == 0) {
            c6 = g4.d.c(this, 12, -1, "专属安装包正在等待生成", 17);
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#888888"), 5.0f), g4.i.b(Color.parseColor("#888888"), 5.0f)));
            this.f8869y.addView(c6, new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(40.0f)));
            jVar = new k();
        } else {
            if (this.f8870z.info.version.equals(g4.a.c())) {
                this.f8869y.addView(g4.d.c(this, 14, -16777216, "你的最新专属安装包已生成", 17), new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
                qVar = this.f8870z;
                if (qVar != null || !qVar.ishas) {
                    LinearLayout U0 = U0(this.f8869y, 12);
                    com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f(this);
                    fVar.a("开通专属安装包需要花费", -16777216, 12.0f);
                    fVar.a("1000积分", -65536, 12.0f);
                    fVar.a("，申请后请等待系统打包完成", -16777216, 12.0f);
                    fVar.b();
                    fVar.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
                    U0.addView(fVar.f8319b, new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
                LinearLayout U02 = U0(this.f8869y, 6);
                com.secret.prettyhezi.controls.f fVar2 = new com.secret.prettyhezi.controls.f(this);
                fVar2.a("使用专属安装包安装的新用户，自动填写您的邀请码。", -65536, 12.0f);
                fVar2.b();
                fVar2.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
                U02.addView(fVar2.f8319b, new LinearLayout.LayoutParams(0, -2, 1.0f));
                U0(this.f8869y, 6).addView(g4.d.b(this, 12.0f, -16777216, "版本更新后请更新您的专属包"), new LinearLayout.LayoutParams(-1, -2));
                U0(this.f8869y, 6).addView(g4.d.b(this, 12.0f, -16777216, "推荐使用以下方式下载分享安装包(申请专属安装包后，以下下载自动替换为专属安装包下载)"), new LinearLayout.LayoutParams(-1, -2));
            }
            c6 = g4.d.c(this, 12, -1, "免费升级专属安装包", 17);
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f)));
            this.f8869y.addView(c6, new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(40.0f)));
            jVar = new l();
        }
        c6.setOnClickListener(jVar);
        qVar = this.f8870z;
        if (qVar != null) {
        }
        LinearLayout U03 = U0(this.f8869y, 12);
        com.secret.prettyhezi.controls.f fVar3 = new com.secret.prettyhezi.controls.f(this);
        fVar3.a("开通专属安装包需要花费", -16777216, 12.0f);
        fVar3.a("1000积分", -65536, 12.0f);
        fVar3.a("，申请后请等待系统打包完成", -16777216, 12.0f);
        fVar3.b();
        fVar3.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
        U03.addView(fVar3.f8319b, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout U022 = U0(this.f8869y, 6);
        com.secret.prettyhezi.controls.f fVar22 = new com.secret.prettyhezi.controls.f(this);
        fVar22.a("使用专属安装包安装的新用户，自动填写您的邀请码。", -65536, 12.0f);
        fVar22.b();
        fVar22.f8319b.setLineSpacing(g4.i.r(2.0f), 1.0f);
        U022.addView(fVar22.f8319b, new LinearLayout.LayoutParams(0, -2, 1.0f));
        U0(this.f8869y, 6).addView(g4.d.b(this, 12.0f, -16777216, "版本更新后请更新您的专属包"), new LinearLayout.LayoutParams(-1, -2));
        U0(this.f8869y, 6).addView(g4.d.b(this, 12.0f, -16777216, "推荐使用以下方式下载分享安装包(申请专属安装包后，以下下载自动替换为专属安装包下载)"), new LinearLayout.LayoutParams(-1, -2));
    }

    void g1(int i6) {
        String c6 = g4.a.c();
        String h6 = g4.g.a().h("savedApkVersion", HttpUrl.FRAGMENT_ENCODE_SET);
        String d12 = d1();
        String e12 = e1();
        q qVar = this.f8870z;
        if (qVar != null && qVar.ishas) {
            p pVar = qVar.info;
            if (pVar.status == 0) {
                k1();
                return;
            } else if (!c6.equals(pVar.version)) {
                z("请先升级专属安装包");
                return;
            } else {
                c6 = c6 + "_" + MainApplication.f6711r.r().sharehash;
            }
        }
        String str = c6;
        if (!h6.isEmpty() && !str.equals(h6)) {
            g4.c.c(d12);
            g4.c.c(e12);
            g4.g.a().j("savedApkVersion");
        }
        if (!h6.equals(str) || !g4.c.e(e12) || !g4.c.e(d12)) {
            c1(d12, new d(d12, e12, str, i6));
            return;
        }
        if (this.A) {
            d12 = e12;
        }
        b1(i6, d12);
    }

    void h1() {
        I0();
        com.secret.prettyhezi.j.o(v.f7132a + "user/apk/status/json", true, new m(this));
    }

    void i1(String str) {
        r(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new e(str));
    }

    void j1(String str) {
        S0(str);
    }

    void k1() {
        F("专属安装包正在打包, 请等待打包完成", null, s0(C0382R.string.IKnow), new i(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (MainApplication.f6711r.r() == null) {
            M0(TK1dGVzP.class);
            finish();
            return;
        }
        LinearLayout C0 = C0();
        this.f8862r = C0;
        C0.setGravity(1);
        M(this.f8862r, s0(C0382R.string.Share));
        LinearLayout e6 = e(this.f8862r);
        this.f8867w = e6;
        this.f8865u = (ScrollView) e6.getParent();
        this.f8867w.setGravity(1);
        this.f8867w.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(20.0f));
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "亲爱的 " + MainApplication.f6711r.r().nickname + ":\n\t\t\t\t首先感谢您对BeautyBox的认可。\n\t\t\t\t将BeautyBox分享给更多的人，意味着更多的资源被发掘出来，更多的盒子被创建，以及更多的关注以鼓励那些创建盒子的人们。");
        b6.setBackground(g4.i.c(-1, 5.0f, Color.parseColor("#888888"), 1.0f));
        b6.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        b6.setLineSpacing((float) g4.i.r(4.0f), 1.0f);
        this.f8867w.addView(b6, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout T0 = T0();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(16.0f);
        layoutParams.topMargin = r5;
        layoutParams.bottomMargin = r5;
        this.f8867w.addView(T0, layoutParams);
        X0();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(14.0f);
        layoutParams2.bottomMargin = g4.i.r(6.0f);
        TextView b7 = g4.d.b(this, 14.0f, -16777216, "赚取积分规则:");
        this.f8866v = b7;
        this.f8867w.addView(b7, layoutParams2);
        V0();
        W0();
    }
}
