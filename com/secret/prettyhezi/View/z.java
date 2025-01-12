package com.secret.prettyhezi.View;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class z extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f8074b;

    /* renamed from: c  reason: collision with root package name */
    int f8075c;

    /* renamed from: d  reason: collision with root package name */
    String[] f8076d;

    /* renamed from: e  reason: collision with root package name */
    int[] f8077e;

    /* renamed from: f  reason: collision with root package name */
    b[] f8078f;

    /* renamed from: g  reason: collision with root package name */
    a f8079g;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b(int i6, boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends a0 {

        /* renamed from: k  reason: collision with root package name */
        int f8080k;

        /* renamed from: l  reason: collision with root package name */
        boolean f8081l;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ z f8083d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f8084e;

            a(z zVar, int i6) {
                this.f8083d = zVar;
                this.f8084e = i6;
            }

            @Override // g4.f
            public void a(View view) {
                b bVar;
                a aVar;
                int i6;
                b bVar2 = b.this;
                if (!bVar2.f7848f) {
                    int i7 = this.f8084e;
                    if (i7 > 0) {
                        z zVar = z.this;
                        bVar2.g(zVar.c(zVar.f8077e[i7]));
                    }
                    z.this.e(this.f8084e);
                    bVar = b.this;
                    z zVar2 = z.this;
                    aVar = zVar2.f8079g;
                    i6 = zVar2.f8077e[this.f8084e];
                } else if (this.f8084e <= 0) {
                    z.this.f8079g.a();
                    return;
                } else {
                    bVar2.g(!bVar2.f8081l);
                    bVar = b.this;
                    z zVar3 = z.this;
                    aVar = zVar3.f8079g;
                    i6 = zVar3.f8077e[this.f8084e];
                }
                aVar.b(i6, bVar.f8081l);
            }
        }

        public b(int i6) {
            super(z.this.f8074b, z.this.f8076d[i6]);
            this.f8081l = false;
            this.f8080k = i6;
            setOnClickListener(new a(z.this, i6));
        }

        @Override // com.secret.prettyhezi.View.a0
        public void b(boolean z5) {
            super.b(z5);
            if (z5) {
                return;
            }
            e(HttpUrl.FRAGMENT_ENCODE_SET);
            this.f7844b.setText(z.this.f8076d[this.f8080k]);
        }

        public void g(boolean z5) {
            this.f8081l = z5;
            TextView textView = this.f7844b;
            StringBuilder sb = new StringBuilder();
            sb.append(z.this.f8076d[this.f8080k]);
            sb.append(z5 ? "↓" : "↑");
            textView.setText(sb.toString());
        }
    }

    public z(EjNkL ejNkL, int i6) {
        super(ejNkL);
        this.f8074b = ejNkL;
        this.f8075c = i6;
        this.f8077e = new int[]{0, 1, 7, 30, 100};
        this.f8076d = new String[]{ejNkL.s0(C0382R.string.Newest), ejNkL.s0(C0382R.string.TodayHottest), ejNkL.s0(C0382R.string.WeekHottest), ejNkL.s0(C0382R.string.MonthHottest), ejNkL.s0(C0382R.string.Hottest)};
        setOrientation(0);
        setGravity(1);
        this.f8078f = new b[this.f8077e.length];
        boolean z5 = ejNkL.o().x > g4.i.r(500.0f);
        for (int i7 = 0; i7 < this.f8077e.length; i7++) {
            this.f8078f[i7] = new b(i7);
            addView(this.f8078f[i7], z5 ? new LinearLayout.LayoutParams(g4.i.r(80.0f), -1) : new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
    }

    public void a(String str) {
        int i6 = 0;
        while (true) {
            b[] bVarArr = this.f8078f;
            if (i6 >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i6];
            if (bVar.f7848f) {
                bVar.e(str);
            }
            i6++;
        }
    }

    public void b(int i6, boolean z5) {
        e(i6);
        if (i6 > 0) {
            this.f8078f[i6].g(z5);
        }
    }

    boolean c(int i6) {
        return true;
    }

    public int d(int i6) {
        return this.f8077e[i6];
    }

    void e(int i6) {
        int i7 = 0;
        while (true) {
            b[] bVarArr = this.f8078f;
            if (i7 >= bVarArr.length) {
                return;
            }
            bVarArr[i7].b(i7 == i6);
            i7++;
        }
    }

    public void setListener(a aVar) {
        this.f8079g = aVar;
    }
}
