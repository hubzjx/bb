package com.secret.prettyhezi.View;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.secret.prettyhezi.Server.t;
import com.secret.prettyhezi.ZZcINlcxH;
import java.util.ArrayList;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class y extends NestedScrollView {
    ZZcINlcxH D;
    t.a[] E;
    d F;
    FrameLayout G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    float N;
    float[] O;
    int P;
    int Q;
    int R;
    int S;
    public boolean T;
    public boolean U;
    int V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            b bVar = (b) view;
            y.this.S(bVar.f8072c, bVar.f8071b.f8073k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        c f8071b;

        /* renamed from: c  reason: collision with root package name */
        int f8072c;

        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
            setGravity(17);
            setBackgroundColor(Color.parseColor("#f0f0f0"));
            c cVar = new c(zZcINlcxH);
            this.f8071b = cVar;
            addView(cVar);
        }

        void a(int i6, String str, int i7, int i8, boolean z5) {
            this.f8072c = i6;
            c cVar = this.f8071b;
            cVar.f8073k = z5;
            if (str != cVar.f8444b) {
                cVar.setBackground(null);
                this.f8071b.b(str);
                this.f8071b.setLayoutParams(new LinearLayout.LayoutParams(i7, i8));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends com.secret.prettyhezi.controls.r {

        /* renamed from: k  reason: collision with root package name */
        boolean f8073k;

        public c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH, HttpUrl.FRAGMENT_ENCODE_SET);
            this.f8073k = false;
        }

        @Override // com.secret.prettyhezi.controls.r
        protected void d(Bitmap bitmap) {
            if (bitmap == null) {
                return;
            }
            String str = this.f8444b;
            if (str == null || str.length() <= 0) {
                bitmap.recycle();
            } else if (!this.f8073k) {
                setBackground(new BitmapDrawable(bitmap));
            } else {
                Bitmap M = g4.i.M(bitmap);
                bitmap.recycle();
                setBackground(new BitmapDrawable(M));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i6, boolean z5);
    }

    public y(ZZcINlcxH zZcINlcxH, t.a[] aVarArr, int i6, d dVar) {
        super(zZcINlcxH);
        this.V = -1;
        this.D = zZcINlcxH;
        this.E = aVarArr;
        this.F = dVar;
        setVerticalScrollBarEnabled(false);
        setBackgroundColor(-1);
        R(i6);
        this.R = -1;
        this.S = -1;
        U(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r5 > 6) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void R(int i6) {
        Point o5;
        int i7;
        int i8;
        this.M = g4.i.r(2.0f);
        float ratio = getRatio();
        this.N = ratio;
        int r5 = g4.i.r(ratio > 1.0f ? 120.0f : 90.0f);
        int i9 = this.D.o().x;
        int i10 = this.M;
        int i11 = (i9 - i10) / (r5 + i10);
        this.H = i11;
        int i12 = i11 >= 3 ? 6 : 3;
        this.H = i12;
        int i13 = this.H;
        int i14 = ((i9 - i10) / i13) - i10;
        this.P = i14;
        int i15 = (int) (i14 / this.N);
        this.Q = i15;
        int length = ((this.E.length + i13) - 1) / i13;
        float f6 = ((o5.y / 2) + i10) / (i15 + i10);
        int i16 = i6 / (i15 + i10);
        this.K = i16;
        if (i16 > 1 && f6 > i16) {
            f6 = i16;
        }
        if (f6 > 4.0f) {
            i7 = 4;
        } else if (f6 < 2.0f) {
            this.I = 2;
            i8 = this.I;
            if (i8 <= length) {
                this.J = ((i15 + i10) * length) - i10;
            } else {
                this.J = (int) ((i15 + i10) * (i8 - 0.5f));
                if (i8 < i16) {
                    this.T = true;
                    this.U = false;
                    if (i16 > length) {
                        this.L = ((i15 + i10) * length) - i10;
                    } else {
                        this.L = i6 > 0 ? i6 - g4.i.r(40.0f) : (int) ((i15 + i10) * (i16 - 0.3f));
                    }
                    int i17 = this.Q;
                    int i18 = this.M;
                    int i19 = ((i17 + i18) * length) - i18;
                    this.G = new FrameLayout(this.D);
                    View view = new View(this.D);
                    view.setBackgroundColor(-1);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
                    layoutParams.topMargin = i19 - 1;
                    this.G.addView(view, layoutParams);
                    addView(this.G, new FrameLayout.LayoutParams(-1, i19));
                }
            }
            this.T = false;
            this.U = false;
            int i172 = this.Q;
            int i182 = this.M;
            int i192 = ((i172 + i182) * length) - i182;
            this.G = new FrameLayout(this.D);
            View view2 = new View(this.D);
            view2.setBackgroundColor(-1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 1);
            layoutParams2.topMargin = i192 - 1;
            this.G.addView(view2, layoutParams2);
            addView(this.G, new FrameLayout.LayoutParams(-1, i192));
        } else {
            i7 = (int) (f6 + 0.5f);
        }
        this.I = i7;
        i8 = this.I;
        if (i8 <= length) {
        }
        this.T = false;
        this.U = false;
        int i1722 = this.Q;
        int i1822 = this.M;
        int i1922 = ((i1722 + i1822) * length) - i1822;
        this.G = new FrameLayout(this.D);
        View view22 = new View(this.D);
        view22.setBackgroundColor(-1);
        FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-1, 1);
        layoutParams22.topMargin = i1922 - 1;
        this.G.addView(view22, layoutParams22);
        addView(this.G, new FrameLayout.LayoutParams(-1, i1922));
    }

    void S(int i6, boolean z5) {
        this.F.a(i6, z5);
    }

    public void T() {
        this.U = !this.U;
        U(this.V);
    }

    void U(int i6) {
        b bVar;
        int i7;
        int i8;
        this.V = i6;
        int i9 = this.Q;
        int i10 = this.H;
        int i11 = ((int) ((i6 - (i9 * 1.5f)) / (i9 + this.M))) * i10;
        if (i11 < 0) {
            i11 = 0;
        }
        int i12 = ((i10 * ((this.U ? this.K : this.I) + 3)) + i11) - 1;
        t.a[] aVarArr = this.E;
        if (i12 >= aVarArr.length) {
            i12 = aVarArr.length - 1;
        }
        if (i11 == this.R && i12 == this.S) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = this.G.getChildCount();
        for (int i13 = 1; i13 < childCount; i13++) {
            b bVar2 = (b) this.G.getChildAt(i13);
            int i14 = bVar2.f8072c;
            if (i14 < i11 || i14 > i12) {
                bVar2.f8072c = -1;
                arrayList.add(bVar2);
            }
        }
        for (int i15 = i11; i15 <= i12; i15++) {
            if (i15 < this.R || i15 > this.S) {
                if (arrayList.isEmpty()) {
                    bVar = new b(this.D);
                    bVar.setOnClickListener(new a());
                    this.G.addView(bVar);
                } else {
                    bVar = (b) arrayList.remove(0);
                }
                float f6 = this.O[i15];
                if (f6 > this.N) {
                    int i16 = this.P;
                    i8 = (int) (i16 / f6);
                    i7 = i16;
                } else {
                    int i17 = this.Q;
                    i7 = (int) (i17 * f6);
                    i8 = i17;
                }
                t.a aVar = this.E[i15];
                String str = aVar.f7131m;
                String str2 = aVar.f7128p;
                bVar.a(i15, str, i7, i8, str2 == null || str2.isEmpty());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.P, this.Q);
                int i18 = this.H;
                int i19 = this.M;
                layoutParams.leftMargin = ((i15 % i18) * (this.P + i19)) + i19;
                layoutParams.topMargin = (i15 / i18) * (this.Q + i19);
                bVar.setLayoutParams(layoutParams);
            }
        }
        arrayList.clear();
        this.R = i11;
        this.S = i12;
    }

    float getRatio() {
        t.a[] aVarArr;
        this.O = new float[this.E.length];
        float f6 = 0.0f;
        int i6 = 0;
        float f7 = 0.0f;
        while (true) {
            aVarArr = this.E;
            if (i6 >= aVarArr.length) {
                break;
            }
            float[] fArr = this.O;
            t.a aVar = aVarArr[i6];
            float f8 = aVar.f7129w / aVar.f7127h;
            fArr[i6] = f8;
            f7 += f8;
            i6++;
        }
        float length = f7 / aVarArr.length;
        if (length > 1.0f) {
            double d6 = length;
            if (d6 < 1.1d) {
                length = (float) (d6 - 0.05d);
            }
        }
        float f9 = 1000.0f;
        for (int i7 = 0; i7 < this.E.length; i7++) {
            float f10 = this.O[i7] - length;
            float abs = Math.abs(f10);
            if (abs < f9) {
                f6 = f10;
                f9 = abs;
            }
        }
        return length + f6;
    }

    public int getViewHeight() {
        return this.U ? this.L : this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        U(i7);
    }
}
