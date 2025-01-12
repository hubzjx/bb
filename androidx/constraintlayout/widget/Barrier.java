package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: j  reason: collision with root package name */
    private int f1164j;

    /* renamed from: k  reason: collision with root package name */
    private int f1165k;

    /* renamed from: l  reason: collision with root package name */
    private p.a f1166l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r6 == 6) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r6 == 6) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m(p.e eVar, int i6, boolean z5) {
        this.f1165k = i6;
        if (z5) {
            int i7 = this.f1164j;
            if (i7 != 5) {
            }
            this.f1165k = 1;
        } else {
            int i8 = this.f1164j;
            if (i8 != 5) {
            }
            this.f1165k = 0;
        }
        if (eVar instanceof p.a) {
            ((p.a) eVar).L0(this.f1165k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.f1166l = new p.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.f1349a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == g.f1391h1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == g.f1385g1) {
                    this.f1166l.K0(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == g.f1397i1) {
                    this.f1166l.M0(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.f1252e = this.f1166l;
        k();
    }

    @Override // androidx.constraintlayout.widget.b
    public void f(p.e eVar, boolean z5) {
        m(eVar, this.f1164j, z5);
    }

    public int getMargin() {
        return this.f1166l.I0();
    }

    public int getType() {
        return this.f1164j;
    }

    public boolean l() {
        return this.f1166l.G0();
    }

    public void setAllowsGoneWidget(boolean z5) {
        this.f1166l.K0(z5);
    }

    public void setDpMargin(int i6) {
        p.a aVar = this.f1166l;
        aVar.M0((int) ((i6 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i6) {
        this.f1166l.M0(i6);
    }

    public void setType(int i6) {
        this.f1164j = i6;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
