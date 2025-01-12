package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.View.a0;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.ZZcINlcxH;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class QQfREcfuV extends UoWMF implements x0.b {
    w C;

    /* renamed from: r  reason: collision with root package name */
    RelativeLayout f6850r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6851s;

    /* renamed from: t  reason: collision with root package name */
    RelativeLayout f6852t;

    /* renamed from: z  reason: collision with root package name */
    ArrayList f6858z;

    /* renamed from: u  reason: collision with root package name */
    TextView f6853u = null;

    /* renamed from: v  reason: collision with root package name */
    int[] f6854v = {2, 4, 5};

    /* renamed from: w  reason: collision with root package name */
    int[] f6855w = {C0382R.string.ShortVideo, C0382R.string.Film, C0382R.string.LongVideo};

    /* renamed from: x  reason: collision with root package name */
    int f6856x = -1;

    /* renamed from: y  reason: collision with root package name */
    boolean f6857y = true;
    d[] A = new d[2];
    x0.a B = null;
    int D = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements n.b {
        a() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            QQfREcfuV qQfREcfuV = QQfREcfuV.this;
            qQfREcfuV.f6856x = i6;
            if (qQfREcfuV.B != null) {
                qQfREcfuV.W0(qQfREcfuV.f6854v[i6], qQfREcfuV.f6857y);
            }
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            x0.a aVar = QQfREcfuV.this.B;
            if (aVar != null) {
                aVar.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.QQfREcfuV$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0088a implements Runnable {
                RunnableC0088a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    QQfREcfuV.this.U0();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                g4.i.j().r(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new RunnableC0088a());
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            QQfREcfuV.this.B("转移后，所有视频会从这里删除，你可以在你的相册里找到它们。\n确定转移所有视频到相册？", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QQfREcfuV.this.V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends a0 {

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ QQfREcfuV f6865d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ boolean f6866e;

            a(QQfREcfuV qQfREcfuV, boolean z5) {
                this.f6865d = qQfREcfuV;
                this.f6866e = z5;
            }

            @Override // g4.f
            public void a(View view) {
                d dVar = d.this;
                boolean z5 = dVar.f7848f;
                QQfREcfuV qQfREcfuV = QQfREcfuV.this;
                if (z5) {
                    qQfREcfuV.B.scrollTo(0, 0);
                    return;
                }
                boolean z6 = this.f6866e;
                qQfREcfuV.f6857y = z6;
                qQfREcfuV.W0(qQfREcfuV.f6854v[qQfREcfuV.f6856x], z6);
            }
        }

        public d(String str, boolean z5) {
            super(QQfREcfuV.this, str);
            setOnClickListener(new a(QQfREcfuV.this, z5));
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        this.A[0] = new d(s0(C0382R.string.Completed), true);
        this.A[1] = new d(s0(C0382R.string.downloading), false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(106.0f), -1);
        linearLayout.addView(this.A[0], layoutParams);
        linearLayout.addView(this.A[1], layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(14, -1);
        this.f6852t.addView(linearLayout, layoutParams2);
        W0(this.f6854v[this.f6856x], true);
    }

    void T0() {
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f6855w, new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(1.0f);
        this.f6851s.addView(nVar, layoutParams);
        nVar.setCurrentTab(0);
    }

    void U0() {
        ArrayList d6 = MainApplication.f6711r.l().d(2, true);
        this.f6858z = d6;
        if (d6 == null || d6.size() <= 0) {
            return;
        }
        I0();
        V0();
    }

    void V0() {
        com.secret.prettyhezi.Cache.g gVar = (com.secret.prettyhezi.Cache.g) this.f6858z.get(0);
        this.f6858z.remove(0);
        f4.c.a(gVar.mp4File, false);
        MainApplication.f6711r.l().h(gVar, true);
        ArrayList arrayList = this.f6858z;
        if (arrayList != null && arrayList.size() != 0) {
            this.f6851s.postDelayed(new c(), 100L);
            return;
        }
        this.f6858z = null;
        W0(this.f6854v[this.f6856x], true);
        j0();
    }

    public void W0(int i6, boolean z5) {
        int i7 = 0;
        d[] dVarArr = this.A;
        if (z5) {
            dVarArr[0].b(true);
            this.A[1].b(false);
        } else {
            dVarArr[0].b(false);
            this.A[1].b(true);
        }
        TextView textView = this.f6853u;
        if (textView != null) {
            textView.setVisibility((z5 && i6 == 2) ? 8 : 8);
        }
        w wVar = this.C;
        if (wVar != null) {
            wVar.b();
        }
        this.B.removeAllViews();
        w wVar2 = new w(this, MainApplication.f6711r.l().d(i6, z5), i6, z5);
        this.C = wVar2;
        this.B.addView(wVar2, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // x0.b
    public void a(x0.c cVar) {
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.D == i6) {
            return;
        }
        this.D = i6;
        w wVar = this.C;
        if (wVar != null) {
            wVar.D(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6850r = D0(3, 4);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6851s = linearLayout;
        linearLayout.setOrientation(1);
        this.f6850r.addView(this.f6851s, new RelativeLayout.LayoutParams(-1, -1));
        this.f6852t = L(this.f6851s);
        T0();
        x0.a aVar = new x0.a(this);
        this.B = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6851s.addView(this.B, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        S0();
        TextView c6 = g4.d.c(this, 14, -1, s0(C0382R.string.MoveAllToAlbum), 17);
        this.f6853u = c6;
        c6.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(36.0f));
        layoutParams.leftMargin = g4.i.r(12.0f);
        layoutParams.topMargin = g4.i.r(150.0f);
        this.f6850r.addView(this.f6853u, layoutParams);
        this.f6853u.setBackground(g4.i.b(Color.parseColor("#88ff0000"), 5.0f));
        this.f6853u.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w wVar = this.C;
        if (wVar != null) {
            wVar.b();
        }
    }
}
