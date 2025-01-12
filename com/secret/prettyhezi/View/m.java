package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.graphics.Point;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class m extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    int f7955b;

    /* renamed from: c  reason: collision with root package name */
    int f7956c;

    /* renamed from: d  reason: collision with root package name */
    int[] f7957d;

    /* renamed from: e  reason: collision with root package name */
    int f7958e;

    /* renamed from: f  reason: collision with root package name */
    ZZcINlcxH f7959f;

    /* renamed from: g  reason: collision with root package name */
    int f7960g;

    public m(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f7958e = g4.i.r(8.0f);
        this.f7959f = zZcINlcxH;
        this.f7960g = i6;
        setBackgroundColor(Color.parseColor("#f0f0f0"));
        setPadding(0, 0, 0, this.f7958e);
        Point o5 = zZcINlcxH.o();
        float f6 = zZcINlcxH.getResources().getDisplayMetrics().density;
        int i7 = o5.x;
        this.f7956c = 2;
        if (i7 / f6 > 600.0f) {
            this.f7956c = 3;
        }
        int i8 = this.f7956c;
        this.f7955b = (i7 - ((i8 + 1) * this.f7958e)) / i8;
        this.f7957d = new int[i8];
    }

    public void a(Object obj) {
        u b6 = b(this.f7959f, obj, this.f7955b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f7955b, b6.getItemHeight());
        int i6 = 0;
        for (int i7 = 1; i7 < this.f7956c; i7++) {
            int[] iArr = this.f7957d;
            if (iArr[i7] < iArr[i6]) {
                i6 = i7;
            }
        }
        int i8 = this.f7958e;
        layoutParams.leftMargin = ((i6 + 1) * i8) + (this.f7955b * i6);
        int[] iArr2 = this.f7957d;
        int i9 = iArr2[i6] + i8;
        layoutParams.topMargin = i9;
        iArr2[i6] = i9 + b6.f8037b;
        addView(b6, layoutParams);
    }

    protected u b(ZZcINlcxH zZcINlcxH, Object obj, int i6) {
        if (this.f7960g == 100) {
            e eVar = new e(zZcINlcxH, i6);
            eVar.b((com.secret.prettyhezi.Server.d) obj);
            eVar.s();
            return eVar;
        }
        return null;
    }

    public void c() {
        int i6 = 0;
        for (int i7 = 1; i7 < this.f7956c; i7++) {
            int[] iArr = this.f7957d;
            if (iArr[i7] > iArr[i6]) {
                i6 = i7;
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f7957d[i6] + this.f7958e;
        setLayoutParams(layoutParams);
    }
}
