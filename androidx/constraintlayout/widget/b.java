package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import p.h;
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: b  reason: collision with root package name */
    protected int[] f1249b;

    /* renamed from: c  reason: collision with root package name */
    protected int f1250c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f1251d;

    /* renamed from: e  reason: collision with root package name */
    protected h f1252e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f1253f;

    /* renamed from: g  reason: collision with root package name */
    protected String f1254g;

    /* renamed from: h  reason: collision with root package name */
    private View[] f1255h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f1256i;

    public b(Context context) {
        super(context);
        this.f1249b = new int[32];
        this.f1253f = false;
        this.f1255h = null;
        this.f1256i = new HashMap();
        this.f1251d = context;
        e(null);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f1251d == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int d6 = d(trim);
        if (d6 != 0) {
            this.f1256i.put(Integer.valueOf(d6), trim);
            b(d6);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void b(int i6) {
        if (i6 == getId()) {
            return;
        }
        int i7 = this.f1250c + 1;
        int[] iArr = this.f1249b;
        if (i7 > iArr.length) {
            this.f1249b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1249b;
        int i8 = this.f1250c;
        iArr2[i8] = i6;
        this.f1250c = i8 + 1;
    }

    private int c(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f1251d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = constraintLayout.getChildAt(i6);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int d(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i6 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object f6 = constraintLayout.f(0, str);
            if (f6 instanceof Integer) {
                i6 = ((Integer) f6).intValue();
            }
        }
        if (i6 == 0 && constraintLayout != null) {
            i6 = c(constraintLayout, str);
        }
        if (i6 == 0) {
            try {
                i6 = f.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i6 == 0 ? this.f1251d.getResources().getIdentifier(str, "id", this.f1251d.getPackageName()) : i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.f1349a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == g.f1409k1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1254g = string;
                    setIds(string);
                }
            }
        }
    }

    public abstract void f(p.e eVar, boolean z5);

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1249b, this.f1250c);
    }

    public void h(ConstraintLayout constraintLayout) {
    }

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
        String str;
        int c6;
        if (isInEditMode()) {
            setIds(this.f1254g);
        }
        h hVar = this.f1252e;
        if (hVar == null) {
            return;
        }
        hVar.b();
        for (int i6 = 0; i6 < this.f1250c; i6++) {
            int i7 = this.f1249b[i6];
            View h6 = constraintLayout.h(i7);
            if (h6 == null && (c6 = c(constraintLayout, (str = (String) this.f1256i.get(Integer.valueOf(i7))))) != 0) {
                this.f1249b[i6] = c6;
                this.f1256i.put(Integer.valueOf(c6), str);
                h6 = constraintLayout.h(c6);
            }
            if (h6 != null) {
                this.f1252e.c(constraintLayout.i(h6));
            }
        }
        this.f1252e.a(constraintLayout.f1169d);
    }

    public void k() {
        if (this.f1252e == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f1218n0 = (p.e) this.f1252e;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1254g;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.f1253f) {
            super.onMeasure(i6, i7);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void setIds(String str) {
        this.f1254g = str;
        if (str == null) {
            return;
        }
        int i6 = 0;
        this.f1250c = 0;
        while (true) {
            int indexOf = str.indexOf(44, i6);
            if (indexOf == -1) {
                a(str.substring(i6));
                return;
            } else {
                a(str.substring(i6, indexOf));
                i6 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1254g = null;
        this.f1250c = 0;
        for (int i6 : iArr) {
            b(i6);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1249b = new int[32];
        this.f1253f = false;
        this.f1255h = null;
        this.f1256i = new HashMap();
        this.f1251d = context;
        e(attributeSet);
    }
}
