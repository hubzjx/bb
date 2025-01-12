package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
final class g {

    /* renamed from: n  reason: collision with root package name */
    static final int f5285n;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f5286o;

    /* renamed from: p  reason: collision with root package name */
    private static Constructor f5287p;

    /* renamed from: q  reason: collision with root package name */
    private static Object f5288q;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f5289a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f5290b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5291c;

    /* renamed from: e  reason: collision with root package name */
    private int f5293e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5300l;

    /* renamed from: d  reason: collision with root package name */
    private int f5292d = 0;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f5294f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private int f5295g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private float f5296h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f5297i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f5298j = f5285n;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5299k = true;

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f5301m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        f5285n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i6) {
        this.f5289a = charSequence;
        this.f5290b = textPaint;
        this.f5291c = i6;
        this.f5293e = charSequence.length();
    }

    private void b() {
        if (f5286o) {
            return;
        }
        try {
            f5288q = this.f5300l && Build.VERSION.SDK_INT >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f5287p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f5286o = true;
        } catch (Exception e6) {
            throw new a(e6);
        }
    }

    public static g c(CharSequence charSequence, TextPaint textPaint, int i6) {
        return new g(charSequence, textPaint, i6);
    }

    public StaticLayout a() {
        StaticLayout.Builder obtain;
        StaticLayout build;
        if (this.f5289a == null) {
            this.f5289a = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int max = Math.max(0, this.f5291c);
        CharSequence charSequence = this.f5289a;
        if (this.f5295g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f5290b, max, this.f5301m);
        }
        int min = Math.min(charSequence.length(), this.f5293e);
        this.f5293e = min;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) d0.i.c(f5287p)).newInstance(charSequence, Integer.valueOf(this.f5292d), Integer.valueOf(this.f5293e), this.f5290b, Integer.valueOf(max), this.f5294f, d0.i.c(f5288q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f5299k), null, Integer.valueOf(max), Integer.valueOf(this.f5295g));
            } catch (Exception e6) {
                throw new a(e6);
            }
        }
        if (this.f5300l && this.f5295g == 1) {
            this.f5294f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        obtain = StaticLayout.Builder.obtain(charSequence, this.f5292d, min, this.f5290b, max);
        obtain.setAlignment(this.f5294f);
        obtain.setIncludePad(this.f5299k);
        obtain.setTextDirection(this.f5300l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f5301m;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f5295g);
        float f6 = this.f5296h;
        if (f6 != 0.0f || this.f5297i != 1.0f) {
            obtain.setLineSpacing(f6, this.f5297i);
        }
        if (this.f5295g > 1) {
            obtain.setHyphenationFrequency(this.f5298j);
        }
        build = obtain.build();
        return build;
    }

    public g d(Layout.Alignment alignment) {
        this.f5294f = alignment;
        return this;
    }

    public g e(TextUtils.TruncateAt truncateAt) {
        this.f5301m = truncateAt;
        return this;
    }

    public g f(int i6) {
        this.f5298j = i6;
        return this;
    }

    public g g(boolean z5) {
        this.f5299k = z5;
        return this;
    }

    public g h(boolean z5) {
        this.f5300l = z5;
        return this;
    }

    public g i(float f6, float f7) {
        this.f5296h = f6;
        this.f5297i = f7;
        return this;
    }

    public g j(int i6) {
        this.f5295g = i6;
        return this;
    }
}
