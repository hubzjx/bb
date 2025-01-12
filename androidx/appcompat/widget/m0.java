package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;
import v.f;
/* loaded from: classes.dex */
class m0 {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f992a;

    /* renamed from: b  reason: collision with root package name */
    private a2 f993b;

    /* renamed from: c  reason: collision with root package name */
    private a2 f994c;

    /* renamed from: d  reason: collision with root package name */
    private a2 f995d;

    /* renamed from: e  reason: collision with root package name */
    private a2 f996e;

    /* renamed from: f  reason: collision with root package name */
    private a2 f997f;

    /* renamed from: g  reason: collision with root package name */
    private a2 f998g;

    /* renamed from: h  reason: collision with root package name */
    private a2 f999h;

    /* renamed from: i  reason: collision with root package name */
    private final z0 f1000i;

    /* renamed from: j  reason: collision with root package name */
    private int f1001j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1002k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1003l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1004m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1005a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1006b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f1007c;

        a(int i6, int i7, WeakReference weakReference) {
            this.f1005a = i6;
            this.f1006b = i7;
            this.f1007c = weakReference;
        }

        @Override // v.f.a
        public void d(int i6) {
        }

        @Override // v.f.a
        public void e(Typeface typeface) {
            int i6;
            if (Build.VERSION.SDK_INT >= 28 && (i6 = this.f1005a) != -1) {
                typeface = Typeface.create(typeface, i6, (this.f1006b & 2) != 0);
            }
            m0.this.n(this.f1007c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(TextView textView) {
        this.f992a = textView;
        this.f1000i = new z0(textView);
    }

    private void A(int i6, float f6) {
        this.f1000i.v(i6, f6);
    }

    private void B(Context context, c2 c2Var) {
        String o5;
        Typeface create;
        Typeface typeface;
        this.f1001j = c2Var.k(b.j.M2, this.f1001j);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            int k6 = c2Var.k(b.j.R2, -1);
            this.f1002k = k6;
            if (k6 != -1) {
                this.f1001j = (this.f1001j & 2) | 0;
            }
        }
        int i7 = b.j.Q2;
        if (!c2Var.s(i7) && !c2Var.s(b.j.S2)) {
            int i8 = b.j.L2;
            if (c2Var.s(i8)) {
                this.f1004m = false;
                int k7 = c2Var.k(i8, 1);
                if (k7 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (k7 == 2) {
                    typeface = Typeface.SERIF;
                } else if (k7 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.f1003l = typeface;
                return;
            }
            return;
        }
        this.f1003l = null;
        int i9 = b.j.S2;
        if (c2Var.s(i9)) {
            i7 = i9;
        }
        int i10 = this.f1002k;
        int i11 = this.f1001j;
        if (!context.isRestricted()) {
            try {
                Typeface j6 = c2Var.j(i7, this.f1001j, new a(i10, i11, new WeakReference(this.f992a)));
                if (j6 != null) {
                    if (i6 >= 28 && this.f1002k != -1) {
                        j6 = Typeface.create(Typeface.create(j6, 0), this.f1002k, (this.f1001j & 2) != 0);
                    }
                    this.f1003l = j6;
                }
                this.f1004m = this.f1003l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1003l != null || (o5 = c2Var.o(i7)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1002k == -1) {
            create = Typeface.create(o5, this.f1001j);
        } else {
            create = Typeface.create(Typeface.create(o5, 0), this.f1002k, (this.f1001j & 2) != 0);
        }
        this.f1003l = create;
    }

    private void a(Drawable drawable, a2 a2Var) {
        if (drawable == null || a2Var == null) {
            return;
        }
        j.i(drawable, a2Var, this.f992a.getDrawableState());
    }

    private static a2 d(Context context, j jVar, int i6) {
        ColorStateList f6 = jVar.f(context, i6);
        if (f6 != null) {
            a2 a2Var = new a2();
            a2Var.f830d = true;
            a2Var.f827a = f6;
            return a2Var;
        }
        return null;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f992a.getCompoundDrawablesRelative();
            TextView textView = this.f992a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
        } else {
            Drawable[] compoundDrawablesRelative2 = this.f992a.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f992a;
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
            Drawable[] compoundDrawables = this.f992a.getCompoundDrawables();
            TextView textView3 = this.f992a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void y() {
        a2 a2Var = this.f999h;
        this.f993b = a2Var;
        this.f994c = a2Var;
        this.f995d = a2Var;
        this.f996e = a2Var;
        this.f997f = a2Var;
        this.f998g = a2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f993b != null || this.f994c != null || this.f995d != null || this.f996e != null) {
            Drawable[] compoundDrawables = this.f992a.getCompoundDrawables();
            a(compoundDrawables[0], this.f993b);
            a(compoundDrawables[1], this.f994c);
            a(compoundDrawables[2], this.f995d);
            a(compoundDrawables[3], this.f996e);
        }
        if (this.f997f == null && this.f998g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f992a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f997f);
        a(compoundDrawablesRelative[2], this.f998g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1000i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1000i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1000i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1000i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f1000i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1000i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        a2 a2Var = this.f999h;
        if (a2Var != null) {
            return a2Var.f827a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        a2 a2Var = this.f999h;
        if (a2Var != null) {
            return a2Var.f828b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f1000i.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(AttributeSet attributeSet, int i6) {
        String str;
        ColorStateList colorStateList;
        String str2;
        boolean z5;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        boolean z6;
        String str3;
        int i7;
        int i8;
        String str4;
        j jVar;
        Typeface typeface;
        c2 u5;
        int i9;
        int i10;
        int i11;
        int f6;
        int f7;
        int f8;
        int[] k6;
        int autoSizeStepGranularity;
        LocaleList forLanguageTags;
        Context context = this.f992a.getContext();
        j b6 = j.b();
        int[] iArr = b.j.f2713a0;
        c2 v5 = c2.v(context, attributeSet, iArr, i6, 0);
        TextView textView = this.f992a;
        e0.b0.j0(textView, textView.getContext(), iArr, attributeSet, v5.r(), i6, 0);
        int n5 = v5.n(b.j.f2718b0, -1);
        int i12 = b.j.f2733e0;
        if (v5.s(i12)) {
            this.f993b = d(context, b6, v5.n(i12, 0));
        }
        int i13 = b.j.f2723c0;
        if (v5.s(i13)) {
            this.f994c = d(context, b6, v5.n(i13, 0));
        }
        int i14 = b.j.f2738f0;
        if (v5.s(i14)) {
            this.f995d = d(context, b6, v5.n(i14, 0));
        }
        int i15 = b.j.f2728d0;
        if (v5.s(i15)) {
            this.f996e = d(context, b6, v5.n(i15, 0));
        }
        int i16 = Build.VERSION.SDK_INT;
        int i17 = b.j.f2743g0;
        if (v5.s(i17)) {
            this.f997f = d(context, b6, v5.n(i17, 0));
        }
        int i18 = b.j.f2748h0;
        if (v5.s(i18)) {
            this.f998g = d(context, b6, v5.n(i18, 0));
        }
        v5.w();
        boolean z7 = this.f992a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n5 != -1) {
            c2 t5 = c2.t(context, n5, b.j.J2);
            if (!z7) {
                int i19 = b.j.U2;
                if (t5.s(i19)) {
                    z5 = t5.a(i19, false);
                    z6 = true;
                    B(context, t5);
                    if (i16 >= 23) {
                        int i20 = b.j.N2;
                        colorStateList = t5.s(i20) ? t5.c(i20) : null;
                        int i21 = b.j.O2;
                        colorStateList2 = t5.s(i21) ? t5.c(i21) : null;
                        int i22 = b.j.P2;
                        if (t5.s(i22)) {
                            colorStateList3 = t5.c(i22);
                            int i23 = b.j.V2;
                            str2 = t5.s(i23) ? t5.o(i23) : null;
                            if (i16 >= 26) {
                                int i24 = b.j.T2;
                                if (t5.s(i24)) {
                                    str = t5.o(i24);
                                    t5.w();
                                }
                            }
                            str = null;
                            t5.w();
                        }
                    } else {
                        colorStateList = null;
                        colorStateList2 = null;
                    }
                    colorStateList3 = null;
                    int i232 = b.j.V2;
                    if (t5.s(i232)) {
                    }
                    if (i16 >= 26) {
                    }
                    str = null;
                    t5.w();
                }
            }
            z5 = false;
            z6 = false;
            B(context, t5);
            if (i16 >= 23) {
            }
            colorStateList3 = null;
            int i2322 = b.j.V2;
            if (t5.s(i2322)) {
            }
            if (i16 >= 26) {
            }
            str = null;
            t5.w();
        } else {
            str = null;
            colorStateList = null;
            str2 = null;
            z5 = false;
            colorStateList2 = null;
            colorStateList3 = null;
            z6 = false;
        }
        c2 v6 = c2.v(context, attributeSet, b.j.J2, i6, 0);
        if (!z7) {
            int i25 = b.j.U2;
            if (v6.s(i25)) {
                str3 = str;
                z5 = v6.a(i25, false);
                i7 = 23;
                z6 = true;
                if (i16 < i7) {
                    int i26 = b.j.N2;
                    if (v6.s(i26)) {
                        colorStateList = v6.c(i26);
                    }
                    int i27 = b.j.O2;
                    if (v6.s(i27)) {
                        colorStateList2 = v6.c(i27);
                    }
                    int i28 = b.j.P2;
                    if (v6.s(i28)) {
                        colorStateList3 = v6.c(i28);
                    }
                }
                i8 = b.j.V2;
                if (v6.s(i8)) {
                    str2 = v6.o(i8);
                }
                if (i16 >= 26) {
                    int i29 = b.j.T2;
                    if (v6.s(i29)) {
                        str4 = v6.o(i29);
                        if (i16 >= 28) {
                            int i30 = b.j.K2;
                            if (v6.s(i30)) {
                                jVar = b6;
                                if (v6.f(i30, -1) == 0) {
                                    this.f992a.setTextSize(0, 0.0f);
                                }
                                B(context, v6);
                                v6.w();
                                if (colorStateList != null) {
                                    this.f992a.setTextColor(colorStateList);
                                }
                                if (colorStateList2 != null) {
                                    this.f992a.setHintTextColor(colorStateList2);
                                }
                                if (colorStateList3 != null) {
                                    this.f992a.setLinkTextColor(colorStateList3);
                                }
                                if (!z7 && z6) {
                                    r(z5);
                                }
                                typeface = this.f1003l;
                                if (typeface != null) {
                                    if (this.f1002k == -1) {
                                        this.f992a.setTypeface(typeface, this.f1001j);
                                    } else {
                                        this.f992a.setTypeface(typeface);
                                    }
                                }
                                if (str4 != null) {
                                    this.f992a.setFontVariationSettings(str4);
                                }
                                if (str2 != null) {
                                    if (i16 >= 24) {
                                        TextView textView2 = this.f992a;
                                        forLanguageTags = LocaleList.forLanguageTags(str2);
                                        textView2.setTextLocales(forLanguageTags);
                                    } else {
                                        this.f992a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
                                    }
                                }
                                this.f1000i.q(attributeSet, i6);
                                if (androidx.core.widget.b.f1665a && this.f1000i.l() != 0) {
                                    k6 = this.f1000i.k();
                                    if (k6.length > 0) {
                                        autoSizeStepGranularity = this.f992a.getAutoSizeStepGranularity();
                                        if (autoSizeStepGranularity != -1.0f) {
                                            this.f992a.setAutoSizeTextTypeUniformWithConfiguration(this.f1000i.i(), this.f1000i.h(), this.f1000i.j(), 0);
                                        } else {
                                            this.f992a.setAutoSizeTextTypeUniformWithPresetSizes(k6, 0);
                                        }
                                    }
                                }
                                u5 = c2.u(context, attributeSet, b.j.f2753i0);
                                int n6 = u5.n(b.j.f2793q0, -1);
                                j jVar2 = jVar;
                                Drawable c6 = n6 == -1 ? jVar2.c(context, n6) : null;
                                int n7 = u5.n(b.j.f2818v0, -1);
                                Drawable c7 = n7 == -1 ? jVar2.c(context, n7) : null;
                                int n8 = u5.n(b.j.f2798r0, -1);
                                Drawable c8 = n8 == -1 ? jVar2.c(context, n8) : null;
                                int n9 = u5.n(b.j.f2783o0, -1);
                                Drawable c9 = n9 == -1 ? jVar2.c(context, n9) : null;
                                int n10 = u5.n(b.j.f2803s0, -1);
                                Drawable c10 = n10 == -1 ? jVar2.c(context, n10) : null;
                                int n11 = u5.n(b.j.f2788p0, -1);
                                x(c6, c7, c8, c9, c10, n11 == -1 ? jVar2.c(context, n11) : null);
                                i9 = b.j.f2808t0;
                                if (u5.s(i9)) {
                                    androidx.core.widget.v.g(this.f992a, u5.c(i9));
                                }
                                i10 = b.j.f2813u0;
                                if (u5.s(i10)) {
                                    i11 = -1;
                                } else {
                                    i11 = -1;
                                    androidx.core.widget.v.h(this.f992a, f1.d(u5.k(i10, -1), null));
                                }
                                f6 = u5.f(b.j.f2823w0, i11);
                                f7 = u5.f(b.j.f2828x0, i11);
                                f8 = u5.f(b.j.f2833y0, i11);
                                u5.w();
                                if (f6 != i11) {
                                    androidx.core.widget.v.j(this.f992a, f6);
                                }
                                if (f7 != i11) {
                                    androidx.core.widget.v.k(this.f992a, f7);
                                }
                                if (f8 == i11) {
                                    androidx.core.widget.v.l(this.f992a, f8);
                                    return;
                                }
                                return;
                            }
                        }
                        jVar = b6;
                        B(context, v6);
                        v6.w();
                        if (colorStateList != null) {
                        }
                        if (colorStateList2 != null) {
                        }
                        if (colorStateList3 != null) {
                        }
                        if (!z7) {
                            r(z5);
                        }
                        typeface = this.f1003l;
                        if (typeface != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str2 != null) {
                        }
                        this.f1000i.q(attributeSet, i6);
                        if (androidx.core.widget.b.f1665a) {
                            k6 = this.f1000i.k();
                            if (k6.length > 0) {
                            }
                        }
                        u5 = c2.u(context, attributeSet, b.j.f2753i0);
                        int n62 = u5.n(b.j.f2793q0, -1);
                        j jVar22 = jVar;
                        if (n62 == -1) {
                        }
                        int n72 = u5.n(b.j.f2818v0, -1);
                        if (n72 == -1) {
                        }
                        int n82 = u5.n(b.j.f2798r0, -1);
                        if (n82 == -1) {
                        }
                        int n92 = u5.n(b.j.f2783o0, -1);
                        if (n92 == -1) {
                        }
                        int n102 = u5.n(b.j.f2803s0, -1);
                        if (n102 == -1) {
                        }
                        int n112 = u5.n(b.j.f2788p0, -1);
                        x(c6, c7, c8, c9, c10, n112 == -1 ? jVar22.c(context, n112) : null);
                        i9 = b.j.f2808t0;
                        if (u5.s(i9)) {
                        }
                        i10 = b.j.f2813u0;
                        if (u5.s(i10)) {
                        }
                        f6 = u5.f(b.j.f2823w0, i11);
                        f7 = u5.f(b.j.f2828x0, i11);
                        f8 = u5.f(b.j.f2833y0, i11);
                        u5.w();
                        if (f6 != i11) {
                        }
                        if (f7 != i11) {
                        }
                        if (f8 == i11) {
                        }
                    }
                }
                str4 = str3;
                if (i16 >= 28) {
                }
                jVar = b6;
                B(context, v6);
                v6.w();
                if (colorStateList != null) {
                }
                if (colorStateList2 != null) {
                }
                if (colorStateList3 != null) {
                }
                if (!z7) {
                }
                typeface = this.f1003l;
                if (typeface != null) {
                }
                if (str4 != null) {
                }
                if (str2 != null) {
                }
                this.f1000i.q(attributeSet, i6);
                if (androidx.core.widget.b.f1665a) {
                }
                u5 = c2.u(context, attributeSet, b.j.f2753i0);
                int n622 = u5.n(b.j.f2793q0, -1);
                j jVar222 = jVar;
                if (n622 == -1) {
                }
                int n722 = u5.n(b.j.f2818v0, -1);
                if (n722 == -1) {
                }
                int n822 = u5.n(b.j.f2798r0, -1);
                if (n822 == -1) {
                }
                int n922 = u5.n(b.j.f2783o0, -1);
                if (n922 == -1) {
                }
                int n1022 = u5.n(b.j.f2803s0, -1);
                if (n1022 == -1) {
                }
                int n1122 = u5.n(b.j.f2788p0, -1);
                x(c6, c7, c8, c9, c10, n1122 == -1 ? jVar222.c(context, n1122) : null);
                i9 = b.j.f2808t0;
                if (u5.s(i9)) {
                }
                i10 = b.j.f2813u0;
                if (u5.s(i10)) {
                }
                f6 = u5.f(b.j.f2823w0, i11);
                f7 = u5.f(b.j.f2828x0, i11);
                f8 = u5.f(b.j.f2833y0, i11);
                u5.w();
                if (f6 != i11) {
                }
                if (f7 != i11) {
                }
                if (f8 == i11) {
                }
            }
        }
        str3 = str;
        i7 = 23;
        if (i16 < i7) {
        }
        i8 = b.j.V2;
        if (v6.s(i8)) {
        }
        if (i16 >= 26) {
        }
        str4 = str3;
        if (i16 >= 28) {
        }
        jVar = b6;
        B(context, v6);
        v6.w();
        if (colorStateList != null) {
        }
        if (colorStateList2 != null) {
        }
        if (colorStateList3 != null) {
        }
        if (!z7) {
        }
        typeface = this.f1003l;
        if (typeface != null) {
        }
        if (str4 != null) {
        }
        if (str2 != null) {
        }
        this.f1000i.q(attributeSet, i6);
        if (androidx.core.widget.b.f1665a) {
        }
        u5 = c2.u(context, attributeSet, b.j.f2753i0);
        int n6222 = u5.n(b.j.f2793q0, -1);
        j jVar2222 = jVar;
        if (n6222 == -1) {
        }
        int n7222 = u5.n(b.j.f2818v0, -1);
        if (n7222 == -1) {
        }
        int n8222 = u5.n(b.j.f2798r0, -1);
        if (n8222 == -1) {
        }
        int n9222 = u5.n(b.j.f2783o0, -1);
        if (n9222 == -1) {
        }
        int n10222 = u5.n(b.j.f2803s0, -1);
        if (n10222 == -1) {
        }
        int n11222 = u5.n(b.j.f2788p0, -1);
        x(c6, c7, c8, c9, c10, n11222 == -1 ? jVar2222.c(context, n11222) : null);
        i9 = b.j.f2808t0;
        if (u5.s(i9)) {
        }
        i10 = b.j.f2813u0;
        if (u5.s(i10)) {
        }
        f6 = u5.f(b.j.f2823w0, i11);
        f7 = u5.f(b.j.f2828x0, i11);
        f8 = u5.f(b.j.f2833y0, i11);
        u5.w();
        if (f6 != i11) {
        }
        if (f7 != i11) {
        }
        if (f8 == i11) {
        }
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.f1004m) {
            this.f1003l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f1001j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z5, int i6, int i7, int i8, int i9) {
        if (androidx.core.widget.b.f1665a) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i6) {
        String o5;
        ColorStateList c6;
        c2 t5 = c2.t(context, i6, b.j.J2);
        int i7 = b.j.U2;
        if (t5.s(i7)) {
            r(t5.a(i7, false));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 23) {
            int i9 = b.j.N2;
            if (t5.s(i9) && (c6 = t5.c(i9)) != null) {
                this.f992a.setTextColor(c6);
            }
        }
        int i10 = b.j.K2;
        if (t5.s(i10) && t5.f(i10, -1) == 0) {
            this.f992a.setTextSize(0, 0.0f);
        }
        B(context, t5);
        if (i8 >= 26) {
            int i11 = b.j.T2;
            if (t5.s(i11) && (o5 = t5.o(i11)) != null) {
                this.f992a.setFontVariationSettings(o5);
            }
        }
        t5.w();
        Typeface typeface = this.f1003l;
        if (typeface != null) {
            this.f992a.setTypeface(typeface, this.f1001j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z5) {
        this.f992a.setAllCaps(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i6, int i7, int i8, int i9) {
        this.f1000i.r(i6, i7, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i6) {
        this.f1000i.s(iArr, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i6) {
        this.f1000i.t(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.f999h == null) {
            this.f999h = new a2();
        }
        a2 a2Var = this.f999h;
        a2Var.f827a = colorStateList;
        a2Var.f830d = colorStateList != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.f999h == null) {
            this.f999h = new a2();
        }
        a2 a2Var = this.f999h;
        a2Var.f828b = mode;
        a2Var.f829c = mode != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i6, float f6) {
        if (androidx.core.widget.b.f1665a || l()) {
            return;
        }
        A(i6, f6);
    }
}
