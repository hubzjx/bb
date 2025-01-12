package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z0 {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f1146l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap f1147m = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap f1148n = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private int f1149a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1150b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f1151c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f1152d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1153e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1154f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f1155g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f1156h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f1157i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1158j;

    /* renamed from: k  reason: collision with root package name */
    private final c f1159k;

    /* loaded from: classes.dex */
    private static class a extends c {
        a() {
        }

        @Override // androidx.appcompat.widget.z0.c
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) z0.o(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* loaded from: classes.dex */
    private static class b extends a {
        b() {
        }

        @Override // androidx.appcompat.widget.z0.a, androidx.appcompat.widget.z0.c
        void a(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.z0.c
        boolean b(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) z0.o(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(TextView textView) {
        this.f1157i = textView;
        this.f1158j = textView.getContext();
        int i6 = Build.VERSION.SDK_INT;
        this.f1159k = i6 >= 29 ? new b() : i6 >= 23 ? new a() : new c();
    }

    private boolean A() {
        return !(this.f1157i instanceof k);
    }

    private void B(float f6, float f7, float f8) {
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f6 + "px) is less or equal to (0px)");
        } else if (f7 <= f6) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f7 + "px) is less or equal to minimum auto-size text size (" + f6 + "px)");
        } else if (f8 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f8 + "px) is less or equal to (0px)");
        } else {
            this.f1149a = 1;
            this.f1152d = f6;
            this.f1153e = f7;
            this.f1151c = f8;
            this.f1155g = false;
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            if (i6 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i6)) < 0) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr2[i7] = ((Integer) arrayList.get(i7)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1149a = 0;
        this.f1152d = -1.0f;
        this.f1153e = -1.0f;
        this.f1151c = -1.0f;
        this.f1154f = new int[0];
        this.f1150b = false;
    }

    private StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i6, int i7) {
        StaticLayout.Builder obtain;
        StaticLayout.Builder alignment2;
        StaticLayout.Builder lineSpacing;
        StaticLayout.Builder includePad;
        int breakStrategy;
        StaticLayout.Builder breakStrategy2;
        int hyphenationFrequency;
        StaticLayout.Builder hyphenationFrequency2;
        StaticLayout build;
        obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1156h, i6);
        alignment2 = obtain.setAlignment(alignment);
        lineSpacing = alignment2.setLineSpacing(this.f1157i.getLineSpacingExtra(), this.f1157i.getLineSpacingMultiplier());
        includePad = lineSpacing.setIncludePad(this.f1157i.getIncludeFontPadding());
        breakStrategy = this.f1157i.getBreakStrategy();
        breakStrategy2 = includePad.setBreakStrategy(breakStrategy);
        hyphenationFrequency = this.f1157i.getHyphenationFrequency();
        hyphenationFrequency2 = breakStrategy2.setHyphenationFrequency(hyphenationFrequency);
        if (i7 == -1) {
            i7 = Integer.MAX_VALUE;
        }
        hyphenationFrequency2.setMaxLines(i7);
        try {
            this.f1159k.a(obtain, this.f1157i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        build = obtain.build();
        return build;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i6) {
        return new StaticLayout(charSequence, this.f1156h, i6, alignment, this.f1157i.getLineSpacingMultiplier(), this.f1157i.getLineSpacingExtra(), this.f1157i.getIncludeFontPadding());
    }

    private int g(RectF rectF) {
        int length = this.f1154f.length;
        if (length != 0) {
            int i6 = 1;
            int i7 = length - 1;
            int i8 = 0;
            while (i6 <= i7) {
                int i9 = (i6 + i7) / 2;
                if (z(this.f1154f[i9], rectF)) {
                    int i10 = i9 + 1;
                    i8 = i6;
                    i6 = i10;
                } else {
                    i8 = i9 - 1;
                    i7 = i8;
                }
            }
            return this.f1154f[i8];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method m(String str) {
        try {
            Method method = (Method) f1147m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1147m.put(str, method);
            }
            return method;
        } catch (Exception e6) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e6);
            return null;
        }
    }

    static Object o(Object obj, String str, Object obj2) {
        try {
            return m(str).invoke(obj, new Object[0]);
        } catch (Exception e6) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e6);
            return obj2;
        }
    }

    private void u(float f6) {
        if (f6 != this.f1157i.getPaint().getTextSize()) {
            this.f1157i.getPaint().setTextSize(f6);
            boolean isInLayout = this.f1157i.isInLayout();
            if (this.f1157i.getLayout() != null) {
                this.f1150b = false;
                try {
                    Method m5 = m("nullLayouts");
                    if (m5 != null) {
                        m5.invoke(this.f1157i, new Object[0]);
                    }
                } catch (Exception e6) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e6);
                }
                if (isInLayout) {
                    this.f1157i.forceLayout();
                } else {
                    this.f1157i.requestLayout();
                }
                this.f1157i.invalidate();
            }
        }
    }

    private boolean w() {
        if (A() && this.f1149a == 1) {
            if (!this.f1155g || this.f1154f.length == 0) {
                int floor = ((int) Math.floor((this.f1153e - this.f1152d) / this.f1151c)) + 1;
                int[] iArr = new int[floor];
                for (int i6 = 0; i6 < floor; i6++) {
                    iArr[i6] = Math.round(this.f1152d + (i6 * this.f1151c));
                }
                this.f1154f = b(iArr);
            }
            this.f1150b = true;
        } else {
            this.f1150b = false;
        }
        return this.f1150b;
    }

    private void x(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = typedArray.getDimensionPixelSize(i6, -1);
            }
            this.f1154f = b(iArr);
            y();
        }
    }

    private boolean y() {
        int[] iArr = this.f1154f;
        int length = iArr.length;
        boolean z5 = length > 0;
        this.f1155g = z5;
        if (z5) {
            this.f1149a = 1;
            this.f1152d = iArr[0];
            this.f1153e = iArr[length - 1];
            this.f1151c = -1.0f;
        }
        return z5;
    }

    private boolean z(int i6, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1157i.getText();
        TransformationMethod transformationMethod = this.f1157i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1157i)) != null) {
            text = transformation;
        }
        int maxLines = this.f1157i.getMaxLines();
        n(i6);
        StaticLayout d6 = d(text, (Layout.Alignment) o(this.f1157i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d6.getLineCount() <= maxLines && d6.getLineEnd(d6.getLineCount() - 1) == text.length())) && ((float) d6.getHeight()) <= rectF.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (p()) {
            if (this.f1150b) {
                if (this.f1157i.getMeasuredHeight() <= 0 || this.f1157i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1159k.b(this.f1157i) ? 1048576 : (this.f1157i.getMeasuredWidth() - this.f1157i.getTotalPaddingLeft()) - this.f1157i.getTotalPaddingRight();
                int height = (this.f1157i.getHeight() - this.f1157i.getCompoundPaddingBottom()) - this.f1157i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1146l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float g6 = g(rectF);
                    if (g6 != this.f1157i.getTextSize()) {
                        v(0, g6);
                    }
                }
            }
            this.f1150b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i6, int i7) {
        return Build.VERSION.SDK_INT >= 23 ? e(charSequence, alignment, i6, i7) : f(charSequence, alignment, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f1153e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return Math.round(this.f1152d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return Math.round(this.f1151c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] k() {
        return this.f1154f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f1149a;
    }

    void n(int i6) {
        TextPaint textPaint = this.f1156h;
        if (textPaint == null) {
            this.f1156h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1156h.set(this.f1157i.getPaint());
        this.f1156h.setTextSize(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return A() && this.f1149a != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(AttributeSet attributeSet, int i6) {
        int resourceId;
        Context context = this.f1158j;
        int[] iArr = b.j.f2753i0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        TextView textView = this.f1157i;
        e0.b0.j0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i6, 0);
        int i7 = b.j.f2778n0;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.f1149a = obtainStyledAttributes.getInt(i7, 0);
        }
        int i8 = b.j.f2773m0;
        float dimension = obtainStyledAttributes.hasValue(i8) ? obtainStyledAttributes.getDimension(i8, -1.0f) : -1.0f;
        int i9 = b.j.f2763k0;
        float dimension2 = obtainStyledAttributes.hasValue(i9) ? obtainStyledAttributes.getDimension(i9, -1.0f) : -1.0f;
        int i10 = b.j.f2758j0;
        float dimension3 = obtainStyledAttributes.hasValue(i10) ? obtainStyledAttributes.getDimension(i10, -1.0f) : -1.0f;
        int i11 = b.j.f2768l0;
        if (obtainStyledAttributes.hasValue(i11) && (resourceId = obtainStyledAttributes.getResourceId(i11, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            x(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!A()) {
            this.f1149a = 0;
        } else if (this.f1149a == 1) {
            if (!this.f1155g) {
                DisplayMetrics displayMetrics = this.f1158j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                B(dimension2, dimension3, dimension);
            }
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i6, int i7, int i8, int i9) {
        if (A()) {
            DisplayMetrics displayMetrics = this.f1158j.getResources().getDisplayMetrics();
            B(TypedValue.applyDimension(i9, i6, displayMetrics), TypedValue.applyDimension(i9, i7, displayMetrics), TypedValue.applyDimension(i9, i8, displayMetrics));
            if (w()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int[] iArr, int i6) {
        if (A()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i6 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1158j.getResources().getDisplayMetrics();
                    for (int i7 = 0; i7 < length; i7++) {
                        iArr2[i7] = Math.round(TypedValue.applyDimension(i6, iArr[i7], displayMetrics));
                    }
                }
                this.f1154f = b(iArr2);
                if (!y()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1155g = false;
            }
            if (w()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i6) {
        if (A()) {
            if (i6 == 0) {
                c();
            } else if (i6 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i6);
            } else {
                DisplayMetrics displayMetrics = this.f1158j.getResources().getDisplayMetrics();
                B(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (w()) {
                    a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i6, float f6) {
        Context context = this.f1158j;
        u(TypedValue.applyDimension(i6, f6, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
