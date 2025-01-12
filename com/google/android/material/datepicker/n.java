package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
abstract class n extends LinearLayoutManager {

    /* loaded from: classes.dex */
    class a extends androidx.recyclerview.widget.g {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, int i6, boolean z5) {
        super(context, i6, z5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i6) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i6);
        J1(aVar);
    }
}
