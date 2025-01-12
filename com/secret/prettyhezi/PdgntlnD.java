package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.g;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class PdgntlnD extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6845r;

    /* renamed from: s  reason: collision with root package name */
    TextView[] f6846s = new TextView[20];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Server.x f6847a;

        a(com.secret.prettyhezi.Server.x xVar) {
            this.f6847a = xVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6847a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PdgntlnD.this.U0();
        }
    }

    void S0(int i6) {
        com.secret.prettyhezi.Server.x n5 = MainApplication.f6711r.n(i6);
        StringBuilder sb = new StringBuilder();
        sb.append(T0(i6));
        g.b bVar = n5.f7141d;
        sb.append(bVar == null ? HttpUrl.FRAGMENT_ENCODE_SET : bVar.api_url);
        TextView b6 = g4.d.b(this, 16.0f, -16777216, sb.toString());
        b6.setPadding(g4.i.r(12.0f), 0, 0, 0);
        b6.setGravity(16);
        b6.setBackgroundColor(Color.parseColor("#f0f0f0"));
        b6.setTag(n5);
        this.f6846s[i6] = b6;
        int i7 = -1;
        this.f6845r.addView(b6, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        V(this.f6845r, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        Iterator it = n5.f7139b.iterator();
        while (it.hasNext()) {
            g.b bVar2 = (g.b) it.next();
            TextView c6 = g4.d.c(this, 14, -16777216, bVar2.api_url + " sort:" + bVar2.sort, 16);
            c6.setPadding(g4.i.r(20.0f), 0, 0, 0);
            c6.setBackgroundColor(i7);
            this.f6845r.addView(c6, new LinearLayout.LayoutParams(i7, g4.i.r(42.0f)));
            V(this.f6845r, Color.parseColor("#cccccc"), 0.5f, 10, 0);
            c6.setTag(bVar2.api_url);
            g.c[] cVarArr = bVar2.cdns;
            if (cVarArr != null && cVarArr.length > 0) {
                for (g.c cVar : cVarArr) {
                    TextView b7 = g4.d.b(this, 10.0f, -16777216, cVar.type + ": " + cVar.api_url);
                    b7.setPadding(g4.i.r(20.0f), 0, 0, 0);
                    b7.setGravity(16);
                    b7.setBackgroundColor(Color.parseColor("#dddddd"));
                    this.f6845r.addView(b7, new LinearLayout.LayoutParams(-1, g4.i.r(26.0f)));
                }
            }
            i7 = -1;
        }
        n5.g();
        this.f6845r.postDelayed(new a(n5), ((i6 - 1) * 1000) + 1);
    }

    String T0(int i6) {
        return i6 == 2 ? "配置服务器" : i6 == 1 ? "数据服务器" : i6 == 3 ? "短视频服务器" : i6 == 4 ? "短视频封面服务器" : i6 == 5 ? "散图服务器" : i6 == 12 ? "套图服务器" : i6 == 13 ? "语音服务器" : i6 == 6 ? "APK服务器" : i6 == 18 ? "专属APK服务器" : i6 == 8 ? "长视频服务器" : i6 == 11 ? "长视频封面" : i6 == 9 ? "视频影视下载" : i6 == 10 ? "长视频下载下载" : i6 == 14 ? "小说服务器" : i6 == 15 ? "图片解锁" : i6 == 19 ? "聊天图片" : i6 == 16 ? "游戏" : i6 == 17 ? "help " : "未知";
    }

    void U0() {
        int childCount = this.f6845r.getChildCount();
        int i6 = 0;
        boolean z5 = false;
        while (true) {
            TextView[] textViewArr = this.f6846s;
            if (i6 >= textViewArr.length) {
                break;
            }
            TextView textView = textViewArr[i6];
            if (textView != null) {
                com.secret.prettyhezi.Server.x xVar = MainApplication.f6711r.f6726l[i6];
                StringBuilder sb = new StringBuilder();
                sb.append(T0(i6));
                g.b bVar = xVar.f7141d;
                sb.append(bVar == null ? HttpUrl.FRAGMENT_ENCODE_SET : bVar.api_url);
                textView.setText(sb.toString());
                Iterator it = xVar.f7139b.iterator();
                while (it.hasNext()) {
                    g.b bVar2 = (g.b) it.next();
                    if (bVar2.detected) {
                        String str = bVar2.api_url + " sort:" + bVar2.sort + ":        " + bVar2.delay;
                        int i7 = 0;
                        while (true) {
                            if (i7 < childCount) {
                                View childAt = this.f6845r.getChildAt(i7);
                                if (childAt.getTag() == null || !childAt.getTag().equals(bVar2.api_url)) {
                                    i7++;
                                } else {
                                    TextView textView2 = (TextView) childAt;
                                    textView2.setText(str);
                                    if (bVar2.delay == -1) {
                                        textView2.setTextColor(-65536);
                                    }
                                }
                            }
                        }
                    } else {
                        z5 = true;
                    }
                }
            }
            i6++;
        }
        if (z5) {
            this.f6845r.postDelayed(new b(), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (MainApplication.f6711r.k() == null) {
            finish();
            return;
        }
        LinearLayout C0 = C0();
        M(C0, "IP 检测");
        this.f6845r = e(C0);
        S0(1);
        S0(5);
        S0(12);
        S0(13);
        S0(4);
        S0(3);
        S0(11);
        S0(8);
        S0(9);
        S0(10);
        S0(14);
        S0(6);
        S0(18);
        S0(15);
        S0(19);
        S0(16);
        S0(17);
        U0();
    }
}
