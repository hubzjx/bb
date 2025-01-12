package x2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import androidx.core.widget.d;
import com.google.android.material.internal.j;
import e3.c;
import u2.i;
/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: g  reason: collision with root package name */
    private static final int f14191g = i.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: h  reason: collision with root package name */
    private static final int[][] f14192h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f14193e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14194f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.f13432d);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f14193e == null) {
            int[][] iArr = f14192h;
            int[] iArr2 = new int[iArr.length];
            int c6 = y2.a.c(this, u2.a.f13433g);
            int c7 = y2.a.c(this, u2.a.colorSurface);
            int c8 = y2.a.c(this, u2.a.colorOnSurface);
            iArr2[0] = y2.a.g(c7, c6, 1.0f);
            iArr2[1] = y2.a.g(c7, c8, 0.54f);
            iArr2[2] = y2.a.g(c7, c8, 0.38f);
            iArr2[3] = y2.a.g(c7, c8, 0.38f);
            this.f14193e = new ColorStateList(iArr, iArr2);
        }
        return this.f14193e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14194f && d.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z5) {
        this.f14194f = z5;
        d.c(this, z5 ? getMaterialThemeColorsTintList() : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r4), attributeSet, i6);
        int i7 = f14191g;
        Context context2 = getContext();
        TypedArray h6 = j.h(context2, attributeSet, u2.j.J2, i6, i7, new int[0]);
        int i8 = u2.j.K2;
        if (h6.hasValue(i8)) {
            d.c(this, c.a(context2, h6, i8));
        }
        this.f14194f = h6.getBoolean(u2.j.L2, false);
        h6.recycle();
    }
}
