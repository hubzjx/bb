package com.secret.prettyhezi.Registration;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends u {

    /* renamed from: q  reason: collision with root package name */
    static String f6969q = "copiedCodes";

    /* renamed from: r  reason: collision with root package name */
    public static ArrayList f6970r = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    b f6971m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6972n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6973o;

    /* renamed from: p  reason: collision with root package name */
    TextView f6974p;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6975d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6975d = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            ZZcINlcxH.g(c.this.f6971m.code);
            this.f6975d.H("已复制注册码到剪贴板");
            c.this.f6974p.setEnabled(false);
            c.this.f6974p.setText("已复制");
            c cVar = c.this;
            cVar.p(cVar.f6971m.code);
        }
    }

    static {
        String g6 = g4.c.g(g4.i.j().getFilesDir().getAbsolutePath() + File.separator + f6969q);
        if (g6.isEmpty()) {
            return;
        }
        for (String str : (String[]) com.secret.prettyhezi.f.b(g6, String[].class)) {
            f6970r.add(str);
        }
    }

    public c(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        setOrientation(0);
        setGravity(16);
        setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView a6 = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f6972n = a6;
        linearLayout.addView(a6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView a7 = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f6973o = a7;
        a7.setSingleLine(false);
        linearLayout.addView(this.f6973o, new LinearLayout.LayoutParams(-2, -2));
        TextView c6 = g4.d.c(zZcINlcxH, 14, -1, "复制", 17);
        this.f6974p = c6;
        c6.setOnClickListener(new a(zZcINlcxH));
        this.f6974p.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(36.0f));
        layoutParams.leftMargin = g4.i.r(12.0f);
        addView(this.f6974p, layoutParams);
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        TextView textView;
        String str;
        b bVar = (b) nVar;
        this.f6971m = bVar;
        this.f6972n.setText(bVar.code);
        String str2 = "创建：" + g4.i.y(this.f6971m.created_at);
        b bVar2 = this.f6971m;
        if (bVar2.status) {
            if (f6970r.indexOf(bVar2.code) >= 0) {
                this.f6974p.setEnabled(false);
                textView = this.f6974p;
                str = "已复制";
            } else {
                this.f6974p.setEnabled(true);
                textView = this.f6974p;
                str = "复制";
            }
            textView.setText(str);
        } else {
            this.f6974p.setEnabled(false);
            this.f6974p.setText("已使用");
            str2 = str2 + "\n使用：" + g4.i.y(this.f6971m.updated_at);
        }
        this.f6973o.setText(str2);
    }

    void p(String str) {
        String str2 = g4.i.j().getFilesDir().getAbsolutePath() + File.separator + f6969q;
        f6970r.add(0, str);
        if (f6970r.size() > 60) {
            f6970r.remove(60);
        }
        String[] strArr = new String[f6970r.size()];
        f6970r.toArray(strArr);
        g4.c.k(str2, com.secret.prettyhezi.f.e(strArr));
    }
}
