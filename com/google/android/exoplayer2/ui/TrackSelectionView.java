package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import o2.f;
import o2.h;
import w1.x0;
import w1.y0;
/* loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private final int f4507b;

    /* renamed from: c  reason: collision with root package name */
    private final LayoutInflater f4508c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckedTextView f4509d;

    /* renamed from: e  reason: collision with root package name */
    private final CheckedTextView f4510e;

    /* renamed from: f  reason: collision with root package name */
    private final b f4511f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray f4512g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4513h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4514i;

    /* renamed from: j  reason: collision with root package name */
    private p2.e f4515j;

    /* renamed from: k  reason: collision with root package name */
    private CheckedTextView[][] f4516k;

    /* renamed from: l  reason: collision with root package name */
    private h.a f4517l;

    /* renamed from: m  reason: collision with root package name */
    private int f4518m;

    /* renamed from: n  reason: collision with root package name */
    private y0 f4519n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f4520o;

    /* renamed from: p  reason: collision with root package name */
    private Comparator f4521p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f4523a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4524b;

        /* renamed from: c  reason: collision with root package name */
        public final s0 f4525c;

        public c(int i6, int i7, s0 s0Var) {
            this.f4523a = i6;
            this.f4524b = i7;
            this.f4525c = s0Var;
        }
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int[] b(int[] iArr, int i6) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i6;
        return copyOf;
    }

    private static int[] c(int[] iArr, int i6) {
        int[] iArr2 = new int[iArr.length - 1];
        int i7 = 0;
        for (int i8 : iArr) {
            if (i8 != i6) {
                iArr2[i7] = i8;
                i7++;
            }
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        if (view == this.f4509d) {
            f();
        } else if (view == this.f4510e) {
            e();
        } else {
            g(view);
        }
        j();
    }

    private void e() {
        this.f4520o = false;
        this.f4512g.clear();
    }

    private void f() {
        this.f4520o = true;
        this.f4512g.clear();
    }

    private void g(View view) {
        SparseArray sparseArray;
        f.e eVar;
        SparseArray sparseArray2;
        f.e eVar2;
        this.f4520o = false;
        c cVar = (c) com.google.android.exoplayer2.util.a.e(view.getTag());
        int i6 = cVar.f4523a;
        int i7 = cVar.f4524b;
        f.e eVar3 = (f.e) this.f4512g.get(i6);
        com.google.android.exoplayer2.util.a.e(this.f4517l);
        if (eVar3 != null) {
            int i8 = eVar3.f12428c;
            int[] iArr = eVar3.f12427b;
            boolean isChecked = ((CheckedTextView) view).isChecked();
            boolean h6 = h(i6);
            boolean z5 = h6 || i();
            if (isChecked && z5) {
                if (i8 == 1) {
                    this.f4512g.remove(i6);
                    return;
                }
                int[] c6 = c(iArr, i7);
                sparseArray2 = this.f4512g;
                eVar2 = new f.e(i6, c6);
            } else if (isChecked) {
                return;
            } else {
                if (h6) {
                    int[] b6 = b(iArr, i7);
                    sparseArray2 = this.f4512g;
                    eVar2 = new f.e(i6, b6);
                } else {
                    sparseArray = this.f4512g;
                    eVar = new f.e(i6, i7);
                }
            }
            sparseArray2.put(i6, eVar2);
            return;
        }
        if (!this.f4514i && this.f4512g.size() > 0) {
            this.f4512g.clear();
        }
        sparseArray = this.f4512g;
        eVar = new f.e(i6, i7);
        sparseArray.put(i6, eVar);
    }

    private boolean h(int i6) {
        return this.f4513h && this.f4519n.e(i6).f14093a > 1 && this.f4517l.a(this.f4518m, i6, false) != 0;
    }

    private boolean i() {
        return this.f4514i && this.f4519n.f14101a > 1;
    }

    private void j() {
        this.f4509d.setChecked(this.f4520o);
        this.f4510e.setChecked(!this.f4520o && this.f4512g.size() == 0);
        for (int i6 = 0; i6 < this.f4516k.length; i6++) {
            f.e eVar = (f.e) this.f4512g.get(i6);
            int i7 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f4516k[i6];
                if (i7 < checkedTextViewArr.length) {
                    if (eVar != null) {
                        this.f4516k[i6][i7].setChecked(eVar.e(((c) com.google.android.exoplayer2.util.a.e(checkedTextViewArr[i7].getTag())).f4524b));
                    } else {
                        checkedTextViewArr[i7].setChecked(false);
                    }
                    i7++;
                }
            }
        }
    }

    private void k() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f4517l == null) {
            this.f4509d.setEnabled(false);
            this.f4510e.setEnabled(false);
            return;
        }
        this.f4509d.setEnabled(true);
        this.f4510e.setEnabled(true);
        y0 e6 = this.f4517l.e(this.f4518m);
        this.f4519n = e6;
        this.f4516k = new CheckedTextView[e6.f14101a];
        boolean i6 = i();
        int i7 = 0;
        while (true) {
            y0 y0Var = this.f4519n;
            if (i7 >= y0Var.f14101a) {
                j();
                return;
            }
            x0 e7 = y0Var.e(i7);
            boolean h6 = h(i7);
            CheckedTextView[][] checkedTextViewArr = this.f4516k;
            int i8 = e7.f14093a;
            checkedTextViewArr[i7] = new CheckedTextView[i8];
            c[] cVarArr = new c[i8];
            for (int i9 = 0; i9 < e7.f14093a; i9++) {
                cVarArr[i9] = new c(i7, i9, e7.e(i9));
            }
            Comparator comparator = this.f4521p;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i10 = 0; i10 < i8; i10++) {
                if (i10 == 0) {
                    addView(this.f4508c.inflate(p2.b.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f4508c.inflate((h6 || i6) ? 17367056 : 17367055, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f4507b);
                checkedTextView.setText(this.f4515j.a(cVarArr[i10].f4525c));
                if (this.f4517l.f(this.f4518m, i7, i10) == 4) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setTag(cVarArr[i10]);
                    checkedTextView.setOnClickListener(this.f4511f);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f4516k[i7][i10] = checkedTextView;
                addView(checkedTextView);
            }
            i7++;
        }
    }

    public boolean getIsDisabled() {
        return this.f4520o;
    }

    public List<f.e> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f4512g.size());
        for (int i6 = 0; i6 < this.f4512g.size(); i6++) {
            arrayList.add((f.e) this.f4512g.valueAt(i6));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z5) {
        if (this.f4513h != z5) {
            this.f4513h = z5;
            k();
        }
    }

    public void setAllowMultipleOverrides(boolean z5) {
        if (this.f4514i != z5) {
            this.f4514i = z5;
            if (!z5 && this.f4512g.size() > 1) {
                for (int size = this.f4512g.size() - 1; size > 0; size--) {
                    this.f4512g.remove(size);
                }
            }
            k();
        }
    }

    public void setShowDisableOption(boolean z5) {
        this.f4509d.setVisibility(z5 ? 0 : 8);
    }

    public void setTrackNameProvider(p2.e eVar) {
        this.f4515j = (p2.e) com.google.android.exoplayer2.util.a.e(eVar);
        k();
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        setOrientation(1);
        this.f4512g = new SparseArray();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f4507b = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f4508c = from;
        b bVar = new b();
        this.f4511f = bVar;
        this.f4515j = new p2.a(getResources());
        this.f4519n = y0.f14100d;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f4509d = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(p2.c.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(p2.b.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f4510e = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(p2.c.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }
}
