package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import v.f;
/* loaded from: classes.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f858a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f859b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f860c;

    private c2(Context context, TypedArray typedArray) {
        this.f858a = context;
        this.f859b = typedArray;
    }

    public static c2 t(Context context, int i6, int[] iArr) {
        return new c2(context, context.obtainStyledAttributes(i6, iArr));
    }

    public static c2 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new c2(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static c2 v(Context context, AttributeSet attributeSet, int[] iArr, int i6, int i7) {
        return new c2(context, context.obtainStyledAttributes(attributeSet, iArr, i6, i7));
    }

    public boolean a(int i6, boolean z5) {
        return this.f859b.getBoolean(i6, z5);
    }

    public int b(int i6, int i7) {
        return this.f859b.getColor(i6, i7);
    }

    public ColorStateList c(int i6) {
        int resourceId;
        ColorStateList c6;
        return (!this.f859b.hasValue(i6) || (resourceId = this.f859b.getResourceId(i6, 0)) == 0 || (c6 = e.b.c(this.f858a, resourceId)) == null) ? this.f859b.getColorStateList(i6) : c6;
    }

    public float d(int i6, float f6) {
        return this.f859b.getDimension(i6, f6);
    }

    public int e(int i6, int i7) {
        return this.f859b.getDimensionPixelOffset(i6, i7);
    }

    public int f(int i6, int i7) {
        return this.f859b.getDimensionPixelSize(i6, i7);
    }

    public Drawable g(int i6) {
        int resourceId;
        return (!this.f859b.hasValue(i6) || (resourceId = this.f859b.getResourceId(i6, 0)) == 0) ? this.f859b.getDrawable(i6) : e.b.d(this.f858a, resourceId);
    }

    public Drawable h(int i6) {
        int resourceId;
        if (!this.f859b.hasValue(i6) || (resourceId = this.f859b.getResourceId(i6, 0)) == 0) {
            return null;
        }
        return j.b().d(this.f858a, resourceId, true);
    }

    public float i(int i6, float f6) {
        return this.f859b.getFloat(i6, f6);
    }

    public Typeface j(int i6, int i7, f.a aVar) {
        int resourceId = this.f859b.getResourceId(i6, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f860c == null) {
            this.f860c = new TypedValue();
        }
        return v.f.d(this.f858a, resourceId, this.f860c, i7, aVar);
    }

    public int k(int i6, int i7) {
        return this.f859b.getInt(i6, i7);
    }

    public int l(int i6, int i7) {
        return this.f859b.getInteger(i6, i7);
    }

    public int m(int i6, int i7) {
        return this.f859b.getLayoutDimension(i6, i7);
    }

    public int n(int i6, int i7) {
        return this.f859b.getResourceId(i6, i7);
    }

    public String o(int i6) {
        return this.f859b.getString(i6);
    }

    public CharSequence p(int i6) {
        return this.f859b.getText(i6);
    }

    public CharSequence[] q(int i6) {
        return this.f859b.getTextArray(i6);
    }

    public TypedArray r() {
        return this.f859b;
    }

    public boolean s(int i6) {
        return this.f859b.hasValue(i6);
    }

    public void w() {
        this.f859b.recycle();
    }
}
