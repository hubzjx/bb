package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class n extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView[] f7961b;

    /* renamed from: c  reason: collision with root package name */
    int f7962c;

    /* renamed from: d  reason: collision with root package name */
    b f7963d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7964d;

        a(int i6) {
            this.f7964d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            n.this.setCurrentTab(this.f7964d);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i6);

        void b(int i6);
    }

    public n(ZZcINlcxH zZcINlcxH, b bVar) {
        super(zZcINlcxH);
        this.f7963d = bVar;
        this.f7962c = -1;
        setOrientation(0);
        setBackgroundColor(Color.parseColor("#f0f0f0"));
        setPadding(0, 0, 0, 0);
    }

    void a(ZZcINlcxH zZcINlcxH, String[] strArr, int i6) {
        this.f7961b = new TextView[strArr.length];
        for (int i7 = 0; i7 < strArr.length; i7++) {
            this.f7961b[i7] = g4.d.c(zZcINlcxH, i6, -16777216, strArr[i7], 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            int r5 = g4.i.r(1.0f);
            layoutParams.rightMargin = r5;
            layoutParams.leftMargin = r5;
            addView(this.f7961b[i7], layoutParams);
            int parseColor = Color.parseColor("#c0c0c0");
            this.f7961b[i7].setBackground(g4.i.i(Color.parseColor("#e0e0e0"), parseColor, parseColor));
            this.f7961b[i7].setOnClickListener(new a(i7));
        }
    }

    public void setCurrentTab(int i6) {
        if (this.f7962c == i6) {
            this.f7963d.b(i6);
            return;
        }
        int i7 = 0;
        while (true) {
            TextView[] textViewArr = this.f7961b;
            if (i7 >= textViewArr.length) {
                this.f7962c = i6;
                this.f7963d.a(i6);
                return;
            }
            textViewArr[i7].setSelected(i7 == i6);
            i7++;
        }
    }

    public n(ZZcINlcxH zZcINlcxH, int[] iArr, b bVar) {
        this(zZcINlcxH, bVar);
        String[] strArr = new String[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            strArr[i6] = zZcINlcxH.s0(iArr[i6]);
        }
        a(zZcINlcxH, strArr, 16);
    }

    public n(ZZcINlcxH zZcINlcxH, String[] strArr, int i6, b bVar) {
        this(zZcINlcxH, bVar);
        a(zZcINlcxH, strArr, i6);
    }

    public n(ZZcINlcxH zZcINlcxH, String[] strArr, b bVar) {
        this(zZcINlcxH, bVar);
        a(zZcINlcxH, strArr, 16);
    }
}
