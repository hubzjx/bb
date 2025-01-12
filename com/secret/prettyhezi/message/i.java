package com.secret.prettyhezi.message;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Pc3DTln6R;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.j;
import java.io.File;
import java.io.IOException;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends LinearLayout {

    /* renamed from: l  reason: collision with root package name */
    static int f8716l;

    /* renamed from: m  reason: collision with root package name */
    static int f8717m;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f8718b;

    /* renamed from: c  reason: collision with root package name */
    TextView f8719c;

    /* renamed from: d  reason: collision with root package name */
    TextView f8720d;

    /* renamed from: e  reason: collision with root package name */
    TextView f8721e;

    /* renamed from: f  reason: collision with root package name */
    View f8722f;

    /* renamed from: g  reason: collision with root package name */
    View f8723g;

    /* renamed from: h  reason: collision with root package name */
    boolean f8724h;

    /* renamed from: i  reason: collision with root package name */
    boolean f8725i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f8726j;

    /* renamed from: k  reason: collision with root package name */
    e f8727k;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AWsQxAQ f8728d;

        a(AWsQxAQ aWsQxAQ) {
            this.f8728d = aWsQxAQ;
        }

        @Override // g4.f
        public void a(View view) {
            String d6;
            String GetFakeUrl = i.this.f8727k.GetFakeUrl();
            if (GetFakeUrl == null || (d6 = g4.b.g().d(GetFakeUrl)) == null) {
                return;
            }
            Pc3DTln6R.R0(this.f8728d, new String[]{d6}, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8730a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8731b;

        b(String str, String str2) {
            this.f8730a = str;
            this.f8731b = str2;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            String str2;
            e eVar = i.this.f8727k;
            if (eVar == null || (str2 = eVar.image) == null || str2 != this.f8730a) {
                return;
            }
            d dVar = (d) com.secret.prettyhezi.f.d(str, d.class);
            if (dVar.code == 200) {
                String str3 = g4.i.j().getFilesDir() + File.separator + "tmpSessionFile" + this.f8730a + System.currentTimeMillis() + ".jpg";
                g4.i.S(dVar.data, str3);
                Bitmap decodeFile = BitmapFactory.decodeFile(str3);
                if (decodeFile != null) {
                    g4.b.g().a(this.f8731b, str3, true);
                    i.this.setBitmap(decodeFile);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bitmap f8733a;

        c(Bitmap bitmap) {
            this.f8733a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6;
            int width;
            i.this.f8722f.setBackground(new BitmapDrawable(this.f8733a));
            if (this.f8733a.getWidth() > this.f8733a.getHeight()) {
                width = i.f8717m;
                i6 = (this.f8733a.getHeight() * width) / this.f8733a.getWidth();
            } else {
                i6 = i.f8717m;
                width = (this.f8733a.getWidth() * i6) / this.f8733a.getHeight();
            }
            i.this.f8722f.setLayoutParams(new LinearLayout.LayoutParams(width, i6));
        }
    }

    /* loaded from: classes.dex */
    static class d extends w {
        public String data;

        d() {
        }
    }

    public i(AWsQxAQ aWsQxAQ) {
        super(aWsQxAQ);
        this.f8724h = true;
        this.f8725i = false;
        this.f8726j = false;
        if (f8716l == 0 || f8717m == 0) {
            int r5 = aWsQxAQ.o().x - g4.i.r(78.0f);
            f8716l = r5;
            f8717m = r5 - g4.i.r(24.0f);
        }
        setOrientation(0);
        setGravity(48);
        setBaselineAligned(false);
        setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        int r6 = g4.i.r(59.0f);
        View view = new View(aWsQxAQ);
        this.f8723g = view;
        addView(view, new LinearLayout.LayoutParams(0, 46, 1.0f));
        LinearLayout linearLayout = new LinearLayout(aWsQxAQ);
        this.f8718b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f8718b, new LinearLayout.LayoutParams(-2, -2));
        TextView a6 = g4.d.a(aWsQxAQ, 12.0f, -16776961);
        this.f8719c = a6;
        this.f8718b.addView(a6, new LinearLayout.LayoutParams(-2, -2));
        TextView a7 = g4.d.a(aWsQxAQ, 16.0f, -1);
        this.f8720d = a7;
        a7.setTextIsSelectable(true);
        this.f8718b.addView(this.f8720d, new LinearLayout.LayoutParams(-2, -2));
        View view2 = new View(aWsQxAQ);
        this.f8722f = view2;
        LinearLayout linearLayout2 = this.f8718b;
        int i6 = f8717m;
        linearLayout2.addView(view2, new LinearLayout.LayoutParams(i6, i6));
        this.f8722f.setOnClickListener(new a(aWsQxAQ));
        TextView a8 = g4.d.a(aWsQxAQ, 12.0f, Color.parseColor("#666666"));
        this.f8721e = a8;
        a8.setBackground(g4.i.c(-1, 10.0f, Color.parseColor("#888888"), 0.5f));
        this.f8721e.setPadding(0, 0, 0, 0);
        this.f8721e.setGravity(17);
        addView(this.f8721e, new LinearLayout.LayoutParams(g4.i.r(46.0f), g4.i.r(46.0f)));
        setMinimumHeight(r6);
    }

    public void a() {
        this.f8720d.setTextColor(-65536);
        this.f8725i = true;
    }

    public void b(e eVar, boolean z5, boolean z6) {
        String str;
        this.f8727k = eVar;
        if (this.f8724h != z5 || z6 || this.f8725i) {
            this.f8724h = z5;
            this.f8725i = false;
            if (z5) {
                f();
            } else {
                g();
                if (this.f8726j && (str = eVar.sender_share) != null && str.length() > 0) {
                    this.f8719c.setVisibility(0);
                    this.f8719c.setText(eVar.sender_share);
                }
            }
            this.f8719c.setVisibility(8);
        }
        boolean z7 = !eVar.IsImage();
        TextView textView = this.f8720d;
        if (z7) {
            textView.setVisibility(0);
            this.f8722f.setVisibility(8);
            this.f8722f.setBackground(null);
            this.f8720d.setText(eVar.GetText());
        } else {
            textView.setVisibility(8);
            this.f8722f.setVisibility(0);
            String GetFakeUrl = eVar.GetFakeUrl();
            String d6 = g4.b.g().d(GetFakeUrl);
            Bitmap decodeFile = d6 != null ? BitmapFactory.decodeFile(d6) : null;
            if (decodeFile != null) {
                setBitmap(decodeFile);
            } else {
                e(eVar, GetFakeUrl);
            }
        }
        c(z5, z7);
        Date date = new Date(eVar.created_at * 1000);
        this.f8721e.setText(String.format("%02d/%02d\n%02d:%02d", Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes())));
    }

    void c(boolean z5, boolean z6) {
        View view;
        int i6;
        removeView(this.f8718b);
        if (z6) {
            this.f8720d.measure(View.MeasureSpec.makeMeasureSpec(f8717m, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f8720d.setLayoutParams(new LinearLayout.LayoutParams(this.f8720d.getMeasuredWidth(), this.f8720d.getMeasuredHeight()));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (z5) {
            layoutParams.rightMargin = g4.i.r(8.0f);
            view = this.f8718b;
            i6 = 1;
        } else {
            layoutParams.leftMargin = g4.i.r(8.0f);
            view = this.f8718b;
            i6 = 2;
        }
        addView(view, i6, layoutParams);
    }

    j.e d(String str, String str2) {
        return new b(str, str2);
    }

    void e(e eVar, String str) {
        j.e d6 = d(eVar.image, str);
        String str2 = eVar.chat_id > 0 ? "chat?id=" : "message?id=";
        String p5 = MainApplication.f6711r.p(19);
        com.secret.prettyhezi.j.q(p5 + str2 + eVar.image, null, 6, d6);
    }

    void f() {
        this.f8718b.setBackgroundResource(C0382R.drawable.msg_box_from_me);
        this.f8718b.setPadding(g4.i.r(8.0f), g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(6.0f));
        this.f8720d.setTextColor(-1);
        this.f8723g.setVisibility(0);
    }

    void g() {
        this.f8718b.setBackgroundResource(C0382R.drawable.msg_box_to_me);
        this.f8718b.setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(8.0f));
        this.f8720d.setTextColor(-16777216);
        this.f8723g.setVisibility(8);
    }

    void setBitmap(Bitmap bitmap) {
        this.f8722f.post(new c(bitmap));
    }
}
