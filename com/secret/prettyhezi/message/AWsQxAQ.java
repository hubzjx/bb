package com.secret.prettyhezi.message;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.QHHnp8H;
import com.secret.prettyhezi.Registration.UUS6bYTjG;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class AWsQxAQ extends UoWMF {
    static com.secret.prettyhezi.ScoreExchange.b H;
    static com.secret.prettyhezi.ScoreExchange.b I;
    static long J;
    com.secret.prettyhezi.ScoreExchange.b B;
    com.secret.prettyhezi.ScoreExchange.b C;
    com.secret.prettyhezi.ScoreExchange.d D;
    LinearLayout E;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8615r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f8616s;

    /* renamed from: t  reason: collision with root package name */
    com.secret.prettyhezi.message.j f8617t;

    /* renamed from: u  reason: collision with root package name */
    EditText f8618u;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f8619v;

    /* renamed from: w  reason: collision with root package name */
    public int f8620w;

    /* renamed from: x  reason: collision with root package name */
    int f8621x;

    /* renamed from: y  reason: collision with root package name */
    int f8622y;

    /* renamed from: z  reason: collision with root package name */
    String f8623z;
    boolean A = false;
    TextView F = null;
    e0 G = new s();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8624a;

        a(com.secret.prettyhezi.controls.x xVar) {
            this.f8624a = xVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            AWsQxAQ.this.j(this.f8624a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a0 implements Serializable {
        public int chat_id;
        public String content;
        public String image;
        public int target;

        a0() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.j1();
        }
    }

    /* loaded from: classes.dex */
    class b0 extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public class a implements Serializable {
            String image;

            public a() {
            }
        }

        b0() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {
        i() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.u1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {
        j() {
        }

        @Override // g4.f
        public void a(View view) {
            AWsQxAQ.this.u1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AWsQxAQ.this.c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f8637b;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f8639a;

            /* renamed from: com.secret.prettyhezi.message.AWsQxAQ$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0135a implements s.f {
                C0135a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    AWsQxAQ.this.H("取消成功");
                    com.secret.prettyhezi.i.f8489j.h(0);
                    AWsQxAQ.this.finish();
                }
            }

            /* loaded from: classes.dex */
            class b implements s.f {
                b() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    AWsQxAQ.this.H("取消成功");
                    com.secret.prettyhezi.i.f8489j.h(2);
                    AWsQxAQ.this.finish();
                }
            }

            a(int i6) {
                this.f8639a = i6;
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                AWsQxAQ.this.I0();
                if (AWsQxAQ.this.B == null) {
                    com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "registration/buyer/json", new com.secret.prettyhezi.Registration.h(AWsQxAQ.this.C.id, this.f8639a), true, new s.e(AWsQxAQ.this, new b()));
                    return;
                }
                com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "transaction/buyer/cancel/json?id=" + AWsQxAQ.this.B.id + "&t=" + this.f8639a, true, new s.e(AWsQxAQ.this, new C0135a()));
            }
        }

        l(com.secret.prettyhezi.controls.x xVar, String[] strArr) {
            this.f8636a = xVar;
            this.f8637b = strArr;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            AWsQxAQ.this.j(this.f8636a);
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            aWsQxAQ.C("确定" + this.f8637b[i6], new String[]{"取消", this.f8637b[i6]}, new a(i6), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8643a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8644b;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
                if (zVar.code != 200) {
                    f(zVar.err);
                    return;
                }
                AWsQxAQ.this.H("处理完成");
                AWsQxAQ.this.finish();
            }
        }

        m(boolean z5, boolean z6) {
            this.f8643a = z5;
            this.f8644b = z6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            String str = this.f8643a ? "appeal/c2c/buyer/violation/json" : "appeal/c2c/seller/violation/json";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?t=");
            sb.append(this.f8644b ? "1" : "2");
            sb.append("&id=");
            sb.append((this.f8644b ? AWsQxAQ.this.B : AWsQxAQ.this.C).id);
            String sb2 = sb.toString();
            AWsQxAQ.this.I0();
            com.secret.prettyhezi.j.m(com.secret.prettyhezi.Server.v.f7132a + sb2, new a(AWsQxAQ.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends g4.f {
        n() {
        }

        @Override // g4.f
        protected void a(View view) {
            AWsQxAQ.this.F.setVisibility(8);
            AWsQxAQ.this.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            if (System.currentTimeMillis() - AWsQxAQ.J < 3000) {
                AWsQxAQ.this.H("请不要频繁发送消息");
                return;
            }
            AWsQxAQ.J = System.currentTimeMillis();
            String trim = AWsQxAQ.this.f8618u.getText().toString().trim();
            if (trim.length() == 0) {
                AWsQxAQ.this.q1();
            } else if (trim.length() < 1) {
                AWsQxAQ.this.H("消息内容太短");
            } else {
                AWsQxAQ.this.t1(trim, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bitmap f8649b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8650c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(ZZcINlcxH zZcINlcxH, Bitmap bitmap, String str) {
            super(zZcINlcxH);
            this.f8649b = bitmap;
            this.f8650c = str;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            b0 b0Var = (b0) com.secret.prettyhezi.f.d(str, b0.class);
            if (b0Var.code != 200) {
                f(b0Var.err);
                return;
            }
            com.secret.prettyhezi.message.e eVar = new com.secret.prettyhezi.message.e();
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            if (aWsQxAQ.f8620w == 0) {
                eVar.target = aWsQxAQ.f8622y;
            } else {
                eVar.chat_id = aWsQxAQ.f8621x;
            }
            eVar.sender = MainApplication.f();
            if (this.f8649b == null) {
                eVar.content = this.f8650c;
            } else {
                eVar.image = b0Var.data.image;
                String str2 = g4.i.j().getFilesDir() + File.separator + "tmpSessionFile" + eVar.image + System.currentTimeMillis() + ".jpg";
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    if (this.f8649b.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (Exception e6) {
                    AWsQxAQ.this.q("未知错误: " + e6.getMessage());
                }
                g4.b.g().a(eVar.GetFakeUrl(), str2, true);
            }
            eVar.created_at = System.currentTimeMillis() / 1000;
            AWsQxAQ.this.f8617t.T(eVar);
            AWsQxAQ.this.f8618u.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements ZZcINlcxH.p {
        q() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.p
        public void a() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.p
        public void b(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > height * 3 || height > width * 4) {
                AWsQxAQ.this.y("请不要发太长的图");
                return;
            }
            if (width + height > 3072) {
                while (width + height > 3072) {
                    width /= 2;
                    height /= 2;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
            AWsQxAQ.this.t1(null, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends ZZcINlcxH.q {
        r() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            AWsQxAQ.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class s extends e0 {
        s() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AWsQxAQ.this.f8619v.a(AWsQxAQ.this.f8618u.getText().toString().trim().length() > 0 ? C0382R.drawable.send : C0382R.drawable.image);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                AWsQxAQ aWsQxAQ = AWsQxAQ.this;
                aWsQxAQ.B.status = 2;
                aWsQxAQ.s1();
                AWsQxAQ.this.w1();
                com.secret.prettyhezi.i.f8489j.h(0);
                AWsQxAQ.this.H("操作成功");
            }
        }

        /* loaded from: classes.dex */
        class b implements s.f {
            b() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                AWsQxAQ aWsQxAQ = AWsQxAQ.this;
                aWsQxAQ.C.status = 2;
                aWsQxAQ.s1();
                AWsQxAQ.this.w1();
                com.secret.prettyhezi.i.f8489j.h(2);
                AWsQxAQ.this.H("操作成功");
            }
        }

        t() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            if (aWsQxAQ.A) {
                com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "registration/buyer/json", new com.secret.prettyhezi.Registration.j("d", AWsQxAQ.this.C.id), true, new s.e(AWsQxAQ.this, new b()));
                return;
            }
            aWsQxAQ.I0();
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "transaction/buyer/payment/json?id=" + AWsQxAQ.this.B.id, true, new s.e(AWsQxAQ.this, new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                AWsQxAQ.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class b implements s.f {
            b() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                AWsQxAQ.this.finish();
            }
        }

        u() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            if (aWsQxAQ.A) {
                com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "registration/buyer/json", new com.secret.prettyhezi.Registration.j("f", AWsQxAQ.this.C.id), true, new s.e(AWsQxAQ.this, new b()));
                return;
            }
            aWsQxAQ.I0();
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "transaction/buyer/nopayment/json?id=" + AWsQxAQ.this.B.id, true, new s.e(AWsQxAQ.this, new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.message.AWsQxAQ$v$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0136a implements s.f {
                C0136a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    AWsQxAQ.this.finish();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "transaction/seller/confirm/json?id=" + AWsQxAQ.this.B.id, new v.f(), true, new s.e(AWsQxAQ.this, new C0136a()));
            }
        }

        /* loaded from: classes.dex */
        class b implements s.f {
            b() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                AWsQxAQ.this.H("操作成功");
                AWsQxAQ.this.finish();
            }
        }

        v() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            if (!aWsQxAQ.A) {
                com.secret.prettyhezi.Device.a.b(aWsQxAQ, new a());
                return;
            }
            com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "registration/seller/json", new com.secret.prettyhezi.Registration.n("d", AWsQxAQ.this.C.id), true, new s.e(AWsQxAQ.this, new b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w implements s.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8665a;

        w(boolean z5) {
            this.f8665a = z5;
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            if (this.f8665a) {
                UUS6bYTjG.f6930x = false;
            } else {
                QHHnp8H.f6914z = false;
            }
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            aWsQxAQ.C.status = 4;
            aWsQxAQ.w1();
            AWsQxAQ.this.s1();
            AWsQxAQ.this.H("已申诉");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class x extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                AWsQxAQ.this.e1();
            }
        }

        x() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            if (aWsQxAQ.f8620w == 2) {
                com.secret.prettyhezi.Device.a.b(aWsQxAQ, new a());
            } else {
                aWsQxAQ.e1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y implements s.f {
        y() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            AWsQxAQ aWsQxAQ = AWsQxAQ.this;
            aWsQxAQ.B.status = 4;
            aWsQxAQ.w1();
            AWsQxAQ.this.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class z extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                AWsQxAQ.this.H("举报成功");
            }
        }

        z() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "chat/report/json?id=" + AWsQxAQ.this.f8621x, true, new s.e(AWsQxAQ.this, new a()));
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH, int i6, int i7, int i8, String str) {
        Intent intent = new Intent(zZcINlcxH, AWsQxAQ.class);
        Bundle bundle = new Bundle();
        bundle.putInt("keyTalkType", i6);
        bundle.putInt("id", i7);
        bundle.putInt("keyTarget", i8);
        bundle.putString("keyTargetName", str);
        intent.putExtras(bundle);
        zZcINlcxH.startActivity(intent);
    }

    public static void T0(ZZcINlcxH zZcINlcxH, int i6, int i7, com.secret.prettyhezi.ScoreExchange.b bVar) {
        H = bVar;
        S0(zZcINlcxH, i6, i7, -1, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static void U0(ZZcINlcxH zZcINlcxH, int i6, int i7, String str) {
        S0(zZcINlcxH, 0, i6, i7, str);
    }

    public static void V0(ZZcINlcxH zZcINlcxH, int i6, int i7, com.secret.prettyhezi.ScoreExchange.b bVar) {
        I = bVar;
        S0(zZcINlcxH, i6, i7, -1, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    void W0() {
        if (this.f8620w == 1) {
            com.secret.prettyhezi.ScoreExchange.b bVar = this.B;
            this.D = new com.secret.prettyhezi.ScoreExchange.d(this, bVar != null ? bVar : this.C, bVar != null);
            this.f8615r.addView(this.D, new LinearLayout.LayoutParams(-1, -2));
        }
        LinearLayout linearLayout = new LinearLayout(this);
        this.E = linearLayout;
        linearLayout.setPadding(g4.i.r(2.0f), g4.i.r(2.0f), g4.i.r(2.0f), g4.i.r(2.0f));
        this.E.setOrientation(0);
        this.E.setGravity(16);
        this.f8615r.addView(this.E, new LinearLayout.LayoutParams(-1, -2));
        w1();
    }

    void X0() {
        if (this.f8620w == 5) {
            TextView c6 = g4.d.c(this, 14, -1, "新消息,点击查看", 17);
            this.F = c6;
            c6.setBackground(g4.i.b(-16776961, 5.0f));
            this.F.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.rightMargin = g4.i.r(6.0f);
            int r5 = g4.i.r(6.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            layoutParams.addRule(11, -1);
            this.F.setOnClickListener(new n());
            this.f8616s.addView(this.F, layoutParams);
            this.F.setVisibility(8);
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setPadding(g4.i.r(6.0f), g4.i.r(4.0f), g4.i.r(4.0f), g4.i.r(6.0f));
        this.f8615r.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(this);
        this.f8618u = editText;
        editText.setTextSize(16.0f);
        this.f8618u.setHint("消息内容");
        this.f8618u.setTextColor(Color.parseColor("#333333"));
        this.f8618u.setPadding(g4.i.r(5.0f), g4.i.r(5.0f), g4.i.r(5.0f), g4.i.r(5.0f));
        this.f8618u.setBackground(ZZcINlcxH.g0(Color.parseColor("#f0f0f0"), 6.0f, Color.parseColor("#cccccc"), 1.0f));
        this.f8618u.setMinHeight(g4.i.r(40.0f));
        this.f8618u.setMaxHeight(g4.i.r(110.0f));
        this.f8618u.addTextChangedListener(this.G);
        com.secret.prettyhezi.controls.j.a(this.f8618u, 200, 15);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.rightMargin = g4.i.r(4.0f);
        linearLayout.addView(this.f8618u, layoutParams2);
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this, C0382R.drawable.image);
        this.f8619v = zVar;
        linearLayout.addView(zVar, new ViewGroup.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f)));
        this.f8619v.setOnClickListener(new o());
    }

    void Y0() {
        TextView d12 = d1(this.f8620w == 1 ? "支付方式" : "订单详情", true);
        d12.setOnClickListener(new h());
        this.E.addView(d12);
    }

    void Z0() {
        com.secret.prettyhezi.message.a d6 = com.secret.prettyhezi.message.c.d(this.f8621x);
        if (d6 != null) {
            G(d6.getTypeName(), d6.description, "我知道了", null, false, 1);
        }
        c1();
    }

    void a1() {
        TextView d12 = d1("举报", true);
        d12.setOnClickListener(new g());
        this.E.addView(d12);
    }

    void b1() {
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "transaction/dispute/json?id=" + this.B.id, new v.f(), true, new s.e(this, new y()));
    }

    void c1() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (this.F.getVisibility() != 0) {
            com.secret.prettyhezi.message.c.b();
        } else {
            l1();
        }
        this.f8615r.postDelayed(new k(), 5000L);
    }

    TextView d1(String str, boolean z5) {
        LinearLayout.LayoutParams layoutParams;
        TextView c6 = g4.d.c(this, 16, -16777216, str, 17);
        c6.setBackground(g4.i.d(g4.i.c(-1, 10.0f, -16777216, 1.0f), g4.i.c(-3355444, 10.0f, -16777216, 1.0f)));
        if (z5) {
            layoutParams = new LinearLayout.LayoutParams(-2, g4.i.r(36.0f));
            c6.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, g4.i.r(36.0f), 1.0f);
        }
        int r5 = g4.i.r(2.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        c6.setLayoutParams(layoutParams);
        return c6;
    }

    void e1() {
        if (this.A) {
            h1();
        } else {
            b1();
        }
    }

    public int f1() {
        if (this.f8620w == 3) {
            com.secret.prettyhezi.ScoreExchange.b bVar = this.B;
            if (bVar == null) {
                bVar = this.C;
            }
            return bVar.seller_id;
        }
        return -1;
    }

    s.g g1(String str, Bitmap bitmap) {
        return new p(this, bitmap, str);
    }

    void h1() {
        boolean z5 = MainApplication.f6711r.r().grade == 0;
        StringBuilder sb = new StringBuilder();
        sb.append(com.secret.prettyhezi.Server.v.f7132a);
        sb.append(z5 ? "registration/buyer/json" : "registration/seller/json");
        com.secret.prettyhezi.j.r(sb.toString(), z5 ? new com.secret.prettyhezi.Registration.j("e", this.C.id) : new com.secret.prettyhezi.Registration.n("e", this.C.id), true, new s.e(this, new w(z5)));
    }

    void i1() {
        C("确认已付款？ \n\n虚假操作会禁止交易或封号处理。", new String[]{s0(C0382R.string.cancel), "已付款"}, new t(), false);
    }

    void j1() {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        xVar.i("请选择取消原因", "请如实选择取消原因，每日最多允许取消交易3次。取消交易不影响诚信值。");
        String[] strArr = {"不想买了", "无法支付"};
        xVar.d(strArr, new l(xVar, strArr));
        x(xVar, null, true);
    }

    void k1() {
        com.secret.prettyhezi.ScoreExchange.d dVar;
        int i6 = 0;
        if (this.f8620w == 1) {
            if (this.D.getVisibility() == 0) {
                dVar = this.D;
                i6 = 8;
            } else {
                dVar = this.D;
            }
            dVar.setVisibility(i6);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.addView(this.A ? com.secret.prettyhezi.Registration.a.p(this, this.C) : com.secret.prettyhezi.ScoreExchange.e.p(this, this.B), new LinearLayout.LayoutParams(-2, -2));
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        xVar.e(linearLayout);
        xVar.d(new String[]{s0(C0382R.string.ok)}, new a(xVar));
        x(xVar, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l1() {
        com.secret.prettyhezi.message.a d6;
        if (this.f8620w != 5 || (d6 = com.secret.prettyhezi.message.c.d(this.f8621x)) == null || d6.msgs <= 0) {
            return;
        }
        if (!this.f8617t.R()) {
            this.F.setVisibility(0);
            return;
        }
        this.F.setVisibility(8);
        s1();
    }

    public void m1() {
        int i6 = this.f8620w;
        if (i6 == 0 || i6 == 5) {
            return;
        }
        if (com.secret.prettyhezi.i.f8489j.e(this.f8621x) > 0) {
            s1();
            com.secret.prettyhezi.i.f8489j.b(this.f8621x);
        }
        int i7 = this.f8620w;
        int i8 = 1;
        if (i7 == 1 && this.B != null) {
            i8 = 0;
        } else if (i7 != 2) {
            i8 = -1;
        } else if (this.B == null) {
            i8 = 3;
        }
        if (i8 != -1) {
            com.secret.prettyhezi.ScoreExchange.b d6 = com.secret.prettyhezi.i.f8489j.d(i8, this.f8621x);
            if (d6 != null && !d6.canTalk()) {
                d6 = null;
            }
            if (d6 == null) {
                D("交易已结束", new r(), false);
            } else if (this.B != null) {
                this.B = d6;
            } else if (this.C != null) {
                this.C = d6;
            }
            w1();
        }
    }

    void n1() {
        C("确认自己未付款且不想买了？ 若你想继续购买，可以支付给卖家让卖家确认收款即可成交", new String[]{"再想想", "未付款且不买了"}, new u(), false).f8478e.setGravity(3);
    }

    void o1() {
        C("对方在聊天中有发送与订单无关的信息？如果恶意举报，会被系统处罚。", new String[]{"取消", "举报"}, new z(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        StringBuilder sb;
        String str2;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (extras != null) {
            this.f8620w = extras.getInt("keyTalkType");
            this.f8621x = extras.getInt("id");
            this.f8622y = extras.getInt("keyTarget");
            String string = extras.getString("keyTargetName");
            this.f8623z = string;
            if (string == null) {
                this.f8623z = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            int i6 = this.f8620w;
            if (i6 == 1) {
                sb = new StringBuilder();
                str2 = "卖家";
            } else if (i6 == 2) {
                sb = new StringBuilder();
                str2 = "买家";
            } else if (i6 == 3) {
                str = H != null ? "积分" : "注册码";
                this.f8623z = str;
            }
            sb.append(str2);
            sb.append(this.f8623z);
            str = sb.toString();
            this.f8623z = str;
        }
        com.secret.prettyhezi.ScoreExchange.b bVar = H;
        this.B = bVar;
        com.secret.prettyhezi.ScoreExchange.b bVar2 = I;
        this.C = bVar2;
        H = null;
        I = null;
        this.A = bVar == null && bVar2 != null;
        if (this.f8620w == 0 && MainApplication.f6711r.r().grade == 0) {
            this.A = true;
        }
        com.secret.prettyhezi.ScoreExchange.b bVar3 = this.B;
        boolean z5 = bVar3 != null && bVar3.status == 4;
        com.secret.prettyhezi.ScoreExchange.b bVar4 = this.C;
        if (bVar4 != null && bVar4.status == 4) {
            z5 = true;
        }
        if (z5) {
            this.f8623z += "(仲裁中)";
        }
        LinearLayout C0 = C0();
        this.f8615r = C0;
        this.f8616s = M(C0, this.f8623z);
        com.secret.prettyhezi.message.j jVar = new com.secret.prettyhezi.message.j(this, this.f8621x, this.f8620w);
        this.f8617t = jVar;
        jVar.setBackgroundColor(Color.parseColor("#f0f0f0"));
        this.f8615r.addView(this.f8617t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        int i7 = this.f8620w;
        if (i7 != 0 && i7 != 5) {
            W0();
        }
        X0();
        if (this.f8620w == 5) {
            Z0();
        }
        int i8 = this.f8620w;
        if (i8 == 1 || i8 == 2) {
            if (i8 == 1) {
                str3 = "与卖家沟通时，请勿谈论与订单无关的信息，请注意隐私安全，不要泄漏个人信息，如果确认自己该订单未付款且不想交易，请点击下方“我未付款”按钮，如果沟通无果，可以点击“申请仲裁”按钮";
            } else if (i8 == 2) {
                str3 = "与买家沟通时，请勿谈论与订单无关的信息，请注意隐私安全，不要泄漏个人信息，如果确认自己该订单已收到款，请点击下方“已收到款”按钮，如果沟通无果，可以点击“申请仲裁”按钮";
            }
            G("提示", str3, "我知道了", null, false, 1).f8479f.setGravity(3);
        }
    }

    void p1() {
        C(this.A ? "确认自己已收到款，把注册码给买家？" : "确认自己已收到款，把积分给买家？", new String[]{"暂不处理", "已收到款"}, new v(), false);
    }

    void q1() {
        v(new q());
    }

    void r1() {
        long j6 = (this.A ? this.C : this.B).update_time;
        if (j6 <= 0 || (System.currentTimeMillis() / 1000) - (j6 + g4.i.o()) >= 300) {
            C(MainApplication.f6711r.r().grade > 0 ? "系统仲裁会比较慢，请尽量自行沟通解决，沟通无法解决的才申请仲裁。申请系统仲裁后，需要买卖双方提交各自的证据给系统做仲裁，不诚信的一方会受到系统的处罚，可能会冻结积分或封号" : "系统仲裁会比较慢，请尽量自行沟通解决，沟通无法解决的才申请仲裁。申请系统仲裁后，需要买卖双方提交各自的证据给系统做仲裁，不诚信的一方会受到系统的处罚，可能会封设备", new String[]{"取消", "申请仲裁"}, new x(), false).f8478e.setGravity(3);
        } else {
            D("沟通时间少于5分钟不接受系统仲裁，请先与对方沟通，5分钟内无法沟通成功的再考虑系统仲裁", null, true);
        }
    }

    public void s1() {
        this.f8617t.V();
    }

    void t1(String str, Bitmap bitmap) {
        I0();
        a0 a0Var = new a0();
        if (this.f8620w == 0) {
            a0Var.target = this.f8622y;
        } else {
            a0Var.chat_id = this.f8621x;
        }
        if (bitmap == null) {
            a0Var.content = str;
        } else {
            a0Var.image = com.secret.prettyhezi.share.b.a(bitmap);
        }
        String str2 = this.f8620w == 0 ? "notify/message/new/json" : "chat/new/json";
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + str2, a0Var, true, g1(str, bitmap));
    }

    void u1(boolean z5) {
        boolean z6 = this.B != null;
        StringBuilder sb = new StringBuilder();
        sb.append("确定此");
        sb.append(z6 ? "积分" : "注册码");
        sb.append("交易");
        sb.append(z5 ? "买家" : "卖家");
        sb.append("违规?");
        B(sb.toString(), new m(z5, z6), false);
    }

    void v1() {
        TextView d12 = d1("卖家违规", false);
        d12.setOnClickListener(new i());
        this.E.addView(d12);
        TextView d13 = d1("买家违规", false);
        d13.setOnClickListener(new j());
        this.E.addView(d13);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void w1() {
        com.secret.prettyhezi.ScoreExchange.b bVar;
        TextView d12;
        View.OnClickListener eVar;
        com.secret.prettyhezi.ScoreExchange.b bVar2;
        this.E.removeAllViews();
        int i6 = this.f8620w;
        if (i6 == 3) {
            v1();
        } else {
            com.secret.prettyhezi.ScoreExchange.b bVar3 = this.B;
            boolean z5 = false;
            boolean z6 = (bVar3 != null && bVar3.status > 1) || ((bVar = this.C) != null && bVar.status > 1);
            if (i6 != 1) {
                if (i6 == 2) {
                    d12 = d1("已收到款", false);
                    eVar = new e();
                }
                if (z6) {
                    com.secret.prettyhezi.ScoreExchange.b bVar4 = this.B;
                    if ((bVar4 != null && bVar4.status == 4) || ((bVar2 = this.C) != null && bVar2.status == 4)) {
                        z5 = true;
                    }
                    if (!z5) {
                        TextView d13 = d1("申请仲裁", true);
                        d13.setOnClickListener(new f());
                        this.E.addView(d13);
                    }
                }
                a1();
            } else if (z6) {
                d12 = d1("我未付款", false);
                eVar = new d();
            } else {
                TextView d14 = d1(s0(C0382R.string.cancel), false);
                d14.setOnClickListener(new b());
                this.E.addView(d14);
                d12 = d1("已付款", false);
                eVar = new c();
            }
            d12.setOnClickListener(eVar);
            this.E.addView(d12);
            if (z6) {
            }
            a1();
        }
        Y0();
    }
}
