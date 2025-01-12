package com.secret.prettyhezi.controls;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.b;
import com.secret.prettyhezi.WOqyeiK;
import com.secret.prettyhezi.XSQp3A;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class a extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f8268b;

    /* renamed from: c  reason: collision with root package name */
    int f8269c;

    /* renamed from: d  reason: collision with root package name */
    int f8270d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f8271e;

    /* renamed from: f  reason: collision with root package name */
    String f8272f;

    /* renamed from: g  reason: collision with root package name */
    androidx.viewpager.widget.b f8273g;

    /* renamed from: h  reason: collision with root package name */
    TextView f8274h;

    /* renamed from: i  reason: collision with root package name */
    boolean f8275i;

    /* renamed from: j  reason: collision with root package name */
    int f8276j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f8277k;

    /* renamed from: l  reason: collision with root package name */
    androidx.viewpager.widget.a f8278l;

    /* renamed from: m  reason: collision with root package name */
    View.OnClickListener f8279m;

    /* renamed from: com.secret.prettyhezi.controls.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnTouchListenerC0132a implements View.OnTouchListener {
        View$OnTouchListenerC0132a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.this.f8275i = false;
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements b.i {
        b() {
        }

        @Override // androidx.viewpager.widget.b.i
        public void a(int i6, float f6, int i7) {
            if (f6 <= a.this.getWidth() / 2 || f6 >= a.this.getWidth()) {
                return;
            }
            a.this.f8275i = false;
        }

        @Override // androidx.viewpager.widget.b.i
        public void b(int i6) {
            TextView textView = a.this.f8274h;
            textView.setText((i6 + 1) + "/" + a.this.f8276j);
        }

        @Override // androidx.viewpager.widget.b.i
        public void c(int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f8275i) {
                if (((ZZcINlcxH) aVar.getContext()) == g4.i.j()) {
                    int currentItem = a.this.f8273g.getCurrentItem() + 1;
                    if (currentItem == 1) {
                        a.this.f8273g.J(currentItem, true);
                        return;
                    }
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f8277k) {
                    return;
                }
                aVar2.b();
            }
        }
    }

    /* loaded from: classes.dex */
    class d extends androidx.viewpager.widget.a {

        /* renamed from: com.secret.prettyhezi.controls.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0133a extends g4.f {
            C0133a() {
            }

            @Override // g4.f
            protected void a(View view) {
                ZZcINlcxH zZcINlcxH = a.this.f8268b;
                if (zZcINlcxH instanceof XSQp3A) {
                    ((XSQp3A) zZcINlcxH).j1();
                }
            }
        }

        d() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return a.this.f8276j;
        }

        @Override // androidx.viewpager.widget.a
        public Object g(ViewGroup viewGroup, int i6) {
            p pVar;
            ViewGroup.LayoutParams layoutParams;
            int i7;
            int i8;
            int width = a.this.getWidth();
            int height = a.this.getHeight();
            if (width <= 0 && (layoutParams = a.this.getLayoutParams()) != null && (i7 = layoutParams.width) > 0 && (i8 = layoutParams.height) > 0) {
                height = i8;
                width = i7;
            }
            if (width <= 0) {
                width = -1;
            }
            if (height <= 0) {
                height = -1;
            }
            a aVar = a.this;
            if (i6 >= aVar.f8271e.length) {
                TextView c6 = g4.d.c(aVar.f8268b, 20, -65536, aVar.f8272f, 17);
                c6.setBackground(g4.i.f(-16777216, -7829368));
                c6.setOnClickListener(new C0133a());
                viewGroup.addView(c6, new ViewGroup.LayoutParams(width, height));
                return c6;
            }
            if (width <= 0 || height <= 0) {
                a aVar2 = a.this;
                pVar = new p(aVar2.f8268b, aVar2.f8271e[i6]);
            } else {
                a aVar3 = a.this;
                pVar = new p(aVar3.f8268b, aVar3.f8271e[i6], width, height);
            }
            viewGroup.addView(pVar, new ViewGroup.LayoutParams(width, height));
            pVar.setTag(new Integer(i6));
            pVar.setOnClickListener(a.this.f8279m);
            return pVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean h(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes.dex */
    class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            a aVar = a.this;
            WOqyeiK.S0(aVar.f8268b, aVar.f8269c, aVar.f8270d, aVar.f8271e, ((Integer) view.getTag()).intValue(), a.this.f8272f);
        }
    }

    public a(ZZcINlcxH zZcINlcxH, int i6, int i7, String[] strArr, String str) {
        super(zZcINlcxH);
        this.f8275i = true;
        this.f8277k = false;
        this.f8278l = new d();
        this.f8279m = new e();
        this.f8268b = zZcINlcxH;
        this.f8269c = i6;
        this.f8270d = i7;
        this.f8271e = strArr;
        this.f8272f = str;
        int length = strArr.length;
        this.f8276j = length;
        if (str != null) {
            this.f8276j = length + 1;
        }
        androidx.viewpager.widget.b bVar = new androidx.viewpager.widget.b(zZcINlcxH);
        this.f8273g = bVar;
        bVar.setOffscreenPageLimit(1);
        addView(this.f8273g, new RelativeLayout.LayoutParams(-1, -1));
        this.f8273g.setAdapter(this.f8278l);
        this.f8273g.setOnTouchListener(new View$OnTouchListenerC0132a());
        this.f8273g.b(new b());
        b();
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setGravity(16);
        linearLayout.setPadding(g4.i.r(6.5f), 0, g4.i.r(6.5f), 0);
        TextView b6 = g4.d.b(zZcINlcxH, 12.0f, -1, "1/" + strArr.length);
        this.f8274h = b6;
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setBackground(ZZcINlcxH.g0(Color.parseColor("#4c000000"), 12.5f, Color.parseColor("#4cffffff"), 0.5f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(25.0f));
        int r5 = g4.i.r(10.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.rightMargin = r5;
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
        addView(linearLayout, layoutParams);
    }

    public void a() {
        this.f8277k = true;
    }

    void b() {
        postDelayed(new c(), 4000L);
    }
}
