package com.secret.prettyhezi.Upload;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Ghv8lE;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.s;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.Upload.x;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class BNyrYM5KT extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7225r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7226s;

    /* renamed from: t  reason: collision with root package name */
    int[] f7227t = {5, 2, 1, 6, 7, 3};

    /* renamed from: u  reason: collision with root package name */
    int[] f7228u = {C0382R.string.LongVideos, C0382R.string.ShortVideos, C0382R.string.Images, C0382R.string.Gallerys, C0382R.string.Audios, C0382R.string.Novels};

    /* renamed from: v  reason: collision with root package name */
    h f7229v = null;

    /* renamed from: w  reason: collision with root package name */
    public boolean f7230w = false;

    /* renamed from: x  reason: collision with root package name */
    z f7231x = null;

    /* renamed from: y  reason: collision with root package name */
    int f7232y = 0;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            BNyrYM5KT.S0(BNyrYM5KT.this);
        }
    }

    /* loaded from: classes.dex */
    class b implements n.b {
        b() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            BNyrYM5KT bNyrYM5KT = BNyrYM5KT.this;
            h hVar = bNyrYM5KT.f7229v;
            if (hVar != null) {
                bNyrYM5KT.f7225r.removeView(hVar);
            }
            BNyrYM5KT bNyrYM5KT2 = BNyrYM5KT.this;
            BNyrYM5KT bNyrYM5KT3 = BNyrYM5KT.this;
            bNyrYM5KT2.f7229v = new h(bNyrYM5KT3.f7227t[i6]);
            BNyrYM5KT bNyrYM5KT4 = BNyrYM5KT.this;
            bNyrYM5KT4.f7225r.addView(bNyrYM5KT4.f7229v, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            h hVar = BNyrYM5KT.this.f7229v;
            if (hVar != null) {
                hVar.scrollTo(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                y.s();
                Intent intent = new Intent("android.intent.action.PICK", BNyrYM5KT.this.f7232y == 7 ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                if (BNyrYM5KT.this.f7232y == 2) {
                    intent.setType("video/*");
                }
                BNyrYM5KT.this.startActivityForResult(intent, 100);
            } catch (Exception unused) {
                BNyrYM5KT.this.y("系统错误，请换个手机试试或者反馈给管理员");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BNyrYM5KT.this.X0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            BNyrYM5KT bNyrYM5KT = BNyrYM5KT.this;
            bNyrYM5KT.f7232y = 2;
            bNyrYM5KT.V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            BNyrYM5KT bNyrYM5KT = BNyrYM5KT.this;
            bNyrYM5KT.f7232y = 7;
            bNyrYM5KT.V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends ZZcINlcxH.q {
        g() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            double d6 = MainApplication.f6711r.r().integral.all;
            if (d6 >= 300.0d) {
                BNyrYM5KT.this.U0();
                return;
            }
            BNyrYM5KT bNyrYM5KT = BNyrYM5KT.this;
            bNyrYM5KT.F("你的积分为" + g4.i.F(d6) + "，小于300积分，暂时不能上传", null, BNyrYM5KT.this.s0(C0382R.string.IKnow), null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends com.secret.prettyhezi.controls.PullToRefresh.h {
        int E;

        /* loaded from: classes.dex */
        class a extends s.g {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f7240b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ZZcINlcxH zZcINlcxH, int i6) {
                super(zZcINlcxH);
                this.f7240b = i6;
            }

            @Override // com.secret.prettyhezi.s.g
            public void f(String str) {
                super.f(str);
                h.this.X();
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                x xVar = (x) com.secret.prettyhezi.f.d(str, x.class);
                if (xVar.code != 200) {
                    f(xVar.err);
                    return;
                }
                for (w wVar : xVar.data.items) {
                    wVar.f7515t = h.this.E;
                }
                h hVar = h.this;
                x.a aVar = xVar.data;
                hVar.h0(aVar.items, aVar.pages > this.f7240b);
            }
        }

        public h(int i6) {
            super(BNyrYM5KT.this);
            this.E = i6;
            this.f8262y.setDividerHeight(g4.i.r(0.5f));
            this.f8262y.setBackgroundColor(-1);
            V("暂无数据");
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        public void b0(int i6) {
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + (com.secret.prettyhezi.g.b(this.E) + "/my/json?page=") + i6, true, new a(BNyrYM5KT.this, i6));
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        public boolean d0() {
            return true;
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        public boolean e0() {
            return false;
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.h
        /* renamed from: i0 */
        public m Y(View view, w wVar) {
            m mVar = (view == null || !(view instanceof m)) ? new m(BNyrYM5KT.this) : (m) view;
            mVar.b(wVar);
            return mVar;
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH) {
        String p5 = MainApplication.f6711r.p(17);
        Ghv8lE.S0(zZcINlcxH, "上传说明", p5 + "help.html");
    }

    void T0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7226s = linearLayout;
        linearLayout.setBackgroundColor(Color.rgb(255, 255, 160));
        this.f7226s.setGravity(1);
        this.f7225r.addView(this.f7226s, new LinearLayout.LayoutParams(-1, -2));
    }

    void U0() {
        if (y.b() == null) {
            y.B();
        }
        r(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new c());
    }

    void V0() {
        String str;
        String str2;
        s.a GetItem = com.secret.prettyhezi.Server.s.GetItem(1);
        if (GetItem != null) {
            String str3 = GetItem.name;
            str2 = GetItem.content;
            str = str3;
        } else {
            str = "上传须知";
            str2 = str;
        }
        com.secret.prettyhezi.controls.x G = G(str, str2, "好的", new g(), true, 3);
        G.b();
        G.f8479f.setGravity(3);
    }

    void W0() {
        this.f7226s.removeAllViews();
        if (y.e()) {
            this.f7231x = new z(this);
            X0();
            this.f7226s.addView(this.f7231x, new LinearLayout.LayoutParams(-1, -2));
            return;
        }
        this.f7231x = null;
        TextView c6 = g4.d.c(this, 16, -16777216, "上传视频", 17);
        c6.setOnClickListener(new e());
        c6.setBackground(g4.i.d(g4.i.c(-1, 5.0f, -16776961, 1.0f), g4.i.c(-7829368, 5.0f, -16776961, 1.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(40.0f));
        int r5 = g4.i.r(12.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        this.f7226s.addView(c6, layoutParams);
        TextView c7 = g4.d.c(this, 16, -16777216, "上传语音", 17);
        c7.setOnClickListener(new f());
        c7.setBackground(g4.i.d(g4.i.c(-1, 5.0f, -16776961, 1.0f), g4.i.c(-7829368, 5.0f, -16776961, 1.0f)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(40.0f));
        int r6 = g4.i.r(12.0f);
        layoutParams2.bottomMargin = r6;
        layoutParams2.topMargin = r6;
        layoutParams2.leftMargin = g4.i.r(30.0f);
        this.f7226s.addView(c7, layoutParams2);
    }

    void X0() {
        if (this.f7231x == null || g4.i.j() != this) {
            return;
        }
        if (!y.e()) {
            W0();
            return;
        }
        this.f7231x.a();
        this.f7226s.postDelayed(new d(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r7 == null) goto L11;
     */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i6, int i7, Intent intent) {
        if (i6 != 100) {
            super.onActivityResult(i6, i7, intent);
        } else if (i7 == -1) {
            Uri data = intent.getData();
            String path = data.getPath();
            if (path == null || path.isEmpty() || !g4.c.e(path)) {
                Cursor cursor = null;
                try {
                    try {
                        String[] strArr = {"_data"};
                        cursor = getContentResolver().query(data, strArr, null, null, null);
                        cursor.moveToFirst();
                        path = cursor.getString(cursor.getColumnIndex(strArr[0]));
                        if (path == null || path.isEmpty() || !g4.c.e(path)) {
                            path = g4.h.b(this, data);
                        }
                    } catch (Exception unused) {
                        y("加载失败，请换个手机试试或者换个文件试试");
                    }
                    cursor.close();
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (path == null || path.isEmpty() || !g4.c.e(path)) {
                y("加载失败，请换个手机试试或者换个文件试试");
                return;
            }
            Intent intent2 = new Intent(this, QwjwwM.class);
            Bundle bundle = new Bundle();
            bundle.putInt("type", this.f7232y);
            bundle.putString("path", path);
            intent2.putExtras(bundle);
            startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f7225r = B0;
        N(B0, s0(C0382R.string.my_uploads), "上传说明", new a());
        T0();
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f7228u, new b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(1.0f);
        this.f7225r.addView(nVar, layoutParams);
        nVar.setCurrentTab(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        W0();
        if (this.f7230w) {
            h hVar = this.f7229v;
            if (hVar != null) {
                hVar.p(true, 0L);
            }
            this.f7230w = false;
        }
    }
}
