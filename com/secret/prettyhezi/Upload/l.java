package com.secret.prettyhezi.Upload;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class l extends HorizontalScrollView {

    /* renamed from: l  reason: collision with root package name */
    static int f7474l = g4.i.r(50.0f);

    /* renamed from: b  reason: collision with root package name */
    q[][] f7475b;

    /* renamed from: c  reason: collision with root package name */
    d f7476c;

    /* renamed from: d  reason: collision with root package name */
    c f7477d;

    /* renamed from: e  reason: collision with root package name */
    int f7478e;

    /* renamed from: f  reason: collision with root package name */
    ZZcINlcxH f7479f;

    /* renamed from: g  reason: collision with root package name */
    LinearLayout f7480g;

    /* renamed from: h  reason: collision with root package name */
    int f7481h;

    /* renamed from: i  reason: collision with root package name */
    boolean f7482i;

    /* renamed from: j  reason: collision with root package name */
    int f7483j;

    /* renamed from: k  reason: collision with root package name */
    int f7484k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7486b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f7486b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            r rVar = (r) com.secret.prettyhezi.f.d(str, r.class);
            if (rVar.code != 200) {
                f(rVar.err);
                return;
            }
            l lVar = l.this;
            q[][] qVarArr = lVar.f7475b;
            int i6 = this.f7486b;
            qVarArr[i6] = rVar.data.items;
            if (i6 == lVar.f7481h) {
                lVar.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        TextView f7488b;

        /* renamed from: c  reason: collision with root package name */
        TextView f7489c;

        /* renamed from: d  reason: collision with root package name */
        int f7490d;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ l f7492d;

            a(l lVar) {
                this.f7492d = lVar;
            }

            @Override // g4.f
            public void a(View view) {
                if (c.this.isSelected()) {
                    return;
                }
                c cVar = c.this;
                l lVar = l.this;
                lVar.f7478e = cVar.f7490d;
                lVar.f7477d.setSelected(false);
                c.this.setSelected(true);
                c cVar2 = c.this;
                l lVar2 = l.this;
                lVar2.f7477d = cVar2;
                lVar2.f7476c.b(cVar2.f7490d);
            }
        }

        public c(Context context, int i6, String str, int i7) {
            super(context);
            this.f7490d = i6;
            setOrientation(1);
            setGravity(17);
            setBackground(g4.i.i(0, -256, -256));
            TextView c6 = g4.d.c(context, str.length() > 5 ? 12 : str.length() > 4 ? 13 : 14, -16777216, str, 17);
            this.f7488b = c6;
            c6.setSingleLine(true);
            int parseColor = Color.parseColor("#333333");
            this.f7489c = g4.d.c(context, 12, parseColor, HttpUrl.FRAGMENT_ENCODE_SET + i7, 1);
            addView(this.f7488b, new LinearLayout.LayoutParams(-2, g4.i.r(18.0f)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = g4.i.r(1.0f);
            addView(this.f7489c, layoutParams);
            this.f7488b.setTextColor(g4.i.p(-16777216, -65536, -65536));
            this.f7489c.setTextColor(g4.i.p(Color.parseColor("#333333"), -65536, -65536));
            setSelected(this.f7490d == l.this.f7478e);
            if (this.f7490d == l.this.f7478e) {
                l.this.f7477d = this;
            }
            setOnClickListener(new a(l.this));
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i6, int i7);

        void b(int i6);
    }

    public l(ZZcINlcxH zZcINlcxH, d dVar) {
        super(zZcINlcxH);
        this.f7477d = null;
        this.f7481h = 0;
        this.f7483j = 0;
        this.f7484k = 0;
        this.f7475b = new q[8];
        this.f7476c = dVar;
        this.f7479f = zZcINlcxH;
        setHorizontalScrollBarEnabled(false);
        setBackgroundColor(Color.parseColor("#f0e0e000"));
        LinearLayout linearLayout = new LinearLayout(this.f7479f);
        this.f7480g = linearLayout;
        linearLayout.setOrientation(0);
        this.f7480g.setPadding(0, 0, f7474l, 0);
        addView(this.f7480g, new FrameLayout.LayoutParams(-2, -1));
    }

    public void a(int i6, boolean z5, int i7) {
        this.f7482i = z5;
        if (this.f7481h != i6) {
            this.f7481h = i6;
            this.f7478e = i7;
            b(i6);
            e();
            return;
        }
        if (i7 != this.f7478e) {
            c cVar = this.f7477d;
            int i8 = 0;
            if (cVar != null) {
                cVar.setSelected(false);
            }
            while (true) {
                if (i8 >= this.f7480g.getChildCount()) {
                    break;
                }
                c cVar2 = (c) this.f7480g.getChildAt(i8);
                if (cVar2.f7490d == i7) {
                    cVar2.setSelected(true);
                    this.f7477d = cVar2;
                    break;
                }
                i8++;
            }
            c();
        }
        this.f7478e = i7;
        d();
    }

    void b(int i6) {
        com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + com.secret.prettyhezi.g.b(i6) + "/node/json", true, new b(this.f7479f, i6));
    }

    void c() {
        int i6;
        if (this.f7477d == null || getVisibility() != 0) {
            return;
        }
        int right = this.f7477d.getRight();
        int left = this.f7477d.getLeft();
        int scrollX = getScrollX();
        int width = getWidth() - f7474l;
        if (left < scrollX) {
            i6 = Math.max(0, left - this.f7477d.getWidth());
        } else if (right <= scrollX + width) {
            return;
        } else {
            i6 = right - width;
        }
        scrollTo(i6, 0);
    }

    void d() {
        if (this.f7480g.getChildCount() == 0) {
            return;
        }
        q[] qVarArr = this.f7475b[this.f7481h];
        int i6 = 0;
        TextView textView = ((c) this.f7480g.getChildAt(0)).f7489c;
        StringBuilder sb = new StringBuilder();
        sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(this.f7482i ? this.f7483j : this.f7484k);
        textView.setText(sb.toString());
        while (i6 < qVarArr.length) {
            int i7 = this.f7482i ? qVarArr[i6].total_hot : qVarArr[i6].total_normal;
            i6++;
            TextView textView2 = ((c) this.f7480g.getChildAt(i6)).f7489c;
            textView2.setText(HttpUrl.FRAGMENT_ENCODE_SET + i7);
        }
    }

    void e() {
        this.f7480g.removeAllViews();
        this.f7477d = null;
        q[] qVarArr = this.f7475b[this.f7481h];
        if (qVarArr == null) {
            return;
        }
        boolean z5 = false;
        int i6 = 3;
        for (q qVar : qVarArr) {
            if (qVar.name.length() > i6) {
                i6 = qVar.name.length();
            }
            if (qVar.id == this.f7478e) {
                z5 = true;
            }
        }
        if (!z5) {
            this.f7478e = -1;
        }
        int r5 = g4.i.r(i6 > 3 ? 72.0f : 54.0f);
        int length = (this.f7479f.o().x - f7474l) / (qVarArr.length + 1);
        if (length > r5) {
            r5 = length;
        }
        this.f7483j = 0;
        this.f7484k = 0;
        for (int i7 = 0; i7 < qVarArr.length; i7++) {
            int i8 = this.f7483j;
            q qVar2 = qVarArr[i7];
            int i9 = qVar2.total_hot;
            this.f7483j = i8 + i9;
            int i10 = this.f7484k;
            int i11 = qVar2.total_normal;
            this.f7484k = i10 + i11;
            int i12 = this.f7482i ? i9 : i11;
            ZZcINlcxH zZcINlcxH = this.f7479f;
            q qVar3 = qVarArr[i7];
            this.f7480g.addView(new c(zZcINlcxH, qVar3.id, qVar3.name, i12), new LinearLayout.LayoutParams(r5, -1));
        }
        this.f7476c.a(this.f7484k, this.f7483j);
        this.f7480g.addView(new c(this.f7479f, -1, "全部", this.f7482i ? this.f7483j : this.f7484k), 0, new LinearLayout.LayoutParams(r5, -1));
        postDelayed(new a(), 200L);
    }
}
