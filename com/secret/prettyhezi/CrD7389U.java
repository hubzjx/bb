package com.secret.prettyhezi;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flask.colorpicker.a;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.controls.z;
import java.io.FileInputStream;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class CrD7389U extends FCCERA {
    public static g4.b F = g4.b.g();
    int A;
    LinearLayout B;
    TextView C;
    LinearLayout D;
    boolean E = false;

    /* renamed from: x  reason: collision with root package name */
    int f6045x;

    /* renamed from: y  reason: collision with root package name */
    int f6046y;

    /* renamed from: z  reason: collision with root package name */
    String f6047z;

    /* loaded from: classes.dex */
    class a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f6048a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f6049b;

        /* renamed from: com.secret.prettyhezi.CrD7389U$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class DialogInterface$OnClickListenerC0067a implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f6051b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f6052c;

            DialogInterface$OnClickListenerC0067a(boolean z5, int i6) {
                this.f6051b = z5;
                this.f6052c = i6;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                CrD7389U.this.Y0(this.f6051b, this.f6052c);
            }
        }

        /* loaded from: classes.dex */
        class b implements t0.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f6054a;

            b(boolean z5) {
                this.f6054a = z5;
            }

            @Override // t0.a
            public void a(DialogInterface dialogInterface, int i6, Integer[] numArr) {
                CrD7389U.this.Y0(this.f6054a, i6);
            }
        }

        /* loaded from: classes.dex */
        class c implements s0.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f6056a;

            c(boolean z5) {
                this.f6056a = z5;
            }

            @Override // s0.c
            public void a(int i6) {
                CrD7389U.this.Y0(this.f6056a, i6);
            }
        }

        a(com.secret.prettyhezi.controls.x xVar, String[] strArr) {
            this.f6048a = xVar;
            this.f6049b = strArr;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (!CrD7389U.this.j(this.f6048a) || i6 == 0) {
                return;
            }
            boolean z5 = i6 == 2;
            int X0 = CrD7389U.this.X0(z5);
            t0.b.s(CrD7389U.this).o(this.f6049b[i6]).h(X0).r(a.c.FLOWER).d(12).m(new c(z5)).n(CrD7389U.this.s0(C0382R.string.ok), new b(z5)).l(CrD7389U.this.s0(C0382R.string.cancel), new DialogInterface$OnClickListenerC0067a(z5, X0)).c().show();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int currentScrollY = CrD7389U.this.f6201s.getCurrentScrollY() - (CrD7389U.this.o().y * 5);
            if (currentScrollY < 0) {
                currentScrollY = 0;
            }
            CrD7389U.this.f6201s.scrollTo(0, currentScrollY);
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int currentScrollY = CrD7389U.this.f6201s.getCurrentScrollY() + (CrD7389U.this.o().y * 5);
            if (currentScrollY > CrD7389U.this.B.getHeight() - CrD7389U.this.f6201s.getHeight()) {
                currentScrollY = CrD7389U.this.B.getHeight() - CrD7389U.this.f6201s.getHeight();
            }
            if (currentScrollY < 0) {
                currentScrollY = 0;
            }
            CrD7389U.this.f6201s.scrollTo(0, currentScrollY);
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CrD7389U crD7389U = CrD7389U.this;
            crD7389U.b1(crD7389U.A - 1);
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CrD7389U crD7389U = CrD7389U.this;
            crD7389U.b1(crD7389U.A + 1);
        }
    }

    /* loaded from: classes.dex */
    private class f extends AsyncTask {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.Cache.a f6063a;

            a(com.secret.prettyhezi.Cache.a aVar) {
                this.f6063a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                CrD7389U.this.f6201s.scrollTo(0, this.f6063a.position);
            }
        }

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            String str = strArr[0];
            String d6 = str.startsWith("/") ? str : CrD7389U.F.d(str);
            String a12 = d6 != null ? CrD7389U.this.a1(d6) : null;
            if (a12 != null) {
                return a12;
            }
            String n5 = g4.c.n();
            if (j.e(MainApplication.f6711r.s(str), n5) == 200 && (a12 = CrD7389U.this.a1(n5)) != null) {
                CrD7389U.F.a(str, n5, true);
            }
            return a12;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            CrD7389U.this.j0();
            CrD7389U.this.C.setText(str);
            CrD7389U.this.E = true;
            com.secret.prettyhezi.Cache.a GetLastItem = com.secret.prettyhezi.Cache.a.GetLastItem();
            if (GetLastItem != null) {
                int i6 = GetLastItem.id;
                CrD7389U crD7389U = CrD7389U.this;
                if (i6 == crD7389U.f6045x && GetLastItem.pageIndex == crD7389U.f6046y) {
                    crD7389U.C.postDelayed(new a(GetLastItem), 80L);
                    return;
                }
            }
            com.secret.prettyhezi.Cache.a.SetPage(CrD7389U.this.f6046y);
        }

        /* synthetic */ f(CrD7389U crD7389U, a aVar) {
            this();
        }
    }

    public static void Z0(int i6, int i7, String str) {
        Intent intent = new Intent(g4.i.j(), CrD7389U.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", i6);
        bundle.putInt("type", i7);
        bundle.putString("extra", str);
        intent.putExtras(bundle);
        g4.i.j().startActivity(intent);
    }

    @Override // com.secret.prettyhezi.FCCERA
    public RelativeLayout S0() {
        LinearLayout linearLayout = this.f6200r;
        return P(linearLayout, "第" + this.f6046y + "节");
    }

    @Override // com.secret.prettyhezi.FCCERA
    public void T0(boolean z5) {
        super.T0(z5);
        this.D.setVisibility(z5 ? 0 : 8);
    }

    @Override // com.secret.prettyhezi.FCCERA
    public View U0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.B = linearLayout;
        linearLayout.setOrientation(1);
        this.B.setPadding(g4.i.r(12.0f), g4.i.r(8.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        TextView b6 = g4.d.b(this, this.A, X0(false), HttpUrl.FRAGMENT_ENCODE_SET);
        this.C = b6;
        this.B.addView(b6, new LinearLayout.LayoutParams(-1, -2));
        relativeLayout.addView(this.B, new RelativeLayout.LayoutParams(-1, -2));
        this.f6200r.setBackgroundColor(X0(true));
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.D = linearLayout2;
        linearLayout2.setBackground(g4.i.b(Color.parseColor("#99333333"), 4.0f));
        this.D.setOrientation(1);
        this.D.setPadding(g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(6.0f), g4.i.r(10.0f));
        TextView c6 = g4.d.c(this, 26, Color.parseColor("#333333"), "-", 17);
        c6.setBackground(g4.i.d(g4.i.b(-1, 20.0f), g4.i.b(Color.parseColor("#888888"), 20.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams.bottomMargin = g4.i.r(16.0f);
        this.D.addView(c6, layoutParams);
        TextView c7 = g4.d.c(this, 26, Color.parseColor("#333333"), k5.d.ANY_NON_NULL_MARKER, 17);
        c7.setBackground(g4.i.d(g4.i.b(-1, 20.0f), g4.i.b(Color.parseColor("#888888"), 20.0f)));
        this.D.addView(c7, new LinearLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f)));
        z zVar = new z(this, C0382R.drawable.backward_icon);
        zVar.setRotation(90.0f);
        com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(zVar, 20, 15);
        a6.setBackground(g4.i.d(g4.i.b(-16777216, 20.0f), g4.i.b(Color.parseColor("#555555"), 20.0f)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams2.topMargin = g4.i.r(16.0f);
        this.D.addView(a6, layoutParams2);
        z zVar2 = new z(this, C0382R.drawable.backward_icon);
        zVar2.setRotation(270.0f);
        com.secret.prettyhezi.controls.u a7 = com.secret.prettyhezi.controls.u.a(zVar2, 20, 15);
        a7.setBackground(g4.i.d(g4.i.b(-16777216, 20.0f), g4.i.b(Color.parseColor("#555555"), 20.0f)));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams3.topMargin = g4.i.r(16.0f);
        this.D.addView(a7, layoutParams3);
        a6.setOnClickListener(new b());
        a7.setOnClickListener(new c());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = o().x / 2;
        layoutParams4.leftMargin = g4.i.r(6.0f);
        relativeLayout.addView(this.D, layoutParams4);
        c6.setOnClickListener(new d());
        c7.setOnClickListener(new e());
        return relativeLayout;
    }

    @Override // com.secret.prettyhezi.FCCERA
    public void V0(int i6) {
        super.V0(i6);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.topMargin = (o().x / 2) + i6;
        this.D.setLayoutParams(layoutParams);
        com.secret.prettyhezi.Cache.a.SetPosition(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.FCCERA
    public void W0() {
        super.W0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6045x = extras.getInt("id");
            this.f6046y = extras.getInt("type");
            this.f6047z = extras.getString("extra");
        }
        y0();
        this.A = g4.g.a().d("bookFontSize", 18);
        new f(this, null).execute(this.f6047z);
        I0();
    }

    int X0(boolean z5) {
        return z5 ? g4.g.a().d("keyBookBGColor", Color.rgb(254, 242, 216)) : g4.g.a().d("keyBookTextColor", -16777216);
    }

    void Y0(boolean z5, int i6) {
        if (z5) {
            g4.g.a().n("keyBookBGColor", i6);
            this.f6200r.setBackgroundColor(i6);
            return;
        }
        g4.g.a().n("keyBookTextColor", i6);
        this.C.setTextColor(i6);
    }

    String a1(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            return new String(bArr, "utf-8");
        } catch (Exception e6) {
            return e6.toString();
        }
    }

    void b1(int i6) {
        if (i6 < 4) {
            i6 = 4;
        }
        if (i6 > 60) {
            i6 = 60;
        }
        if (this.A != i6) {
            this.A = i6;
            g4.g.a().n("bookFontSize", this.A);
            this.C.setTextSize(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.FCCERA, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.E) {
            com.secret.prettyhezi.Cache.a.SetPosition(this.f6201s.getCurrentScrollY(), true);
        }
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    protected void u0() {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        xVar.f(s0(C0382R.string.ChooseColorFor));
        String[] strArr = {s0(C0382R.string.cancel), s0(C0382R.string.Text), s0(C0382R.string.Background)};
        xVar.d(strArr, new a(xVar, strArr));
        x(xVar, null, true);
    }
}
