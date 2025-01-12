package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
abstract class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.z zVar, i iVar, View view, View view2, RecyclerView.o oVar, boolean z5) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z5) {
            return Math.min(iVar.n(), iVar.d(view2) - iVar.g(view));
        }
        return Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.z zVar, i iVar, View view, View view2, RecyclerView.o oVar, boolean z5, boolean z6) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z6 ? Math.max(0, (zVar.b() - Math.max(oVar.h0(view), oVar.h0(view2))) - 1) : Math.max(0, Math.min(oVar.h0(view), oVar.h0(view2)));
        if (z5) {
            return Math.round((max * (Math.abs(iVar.d(view2) - iVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1))) + (iVar.m() - iVar.g(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.z zVar, i iVar, View view, View view2, RecyclerView.o oVar, boolean z5) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z5) {
            return (int) (((iVar.d(view2) - iVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1)) * zVar.b());
        }
        return zVar.b();
    }
}
