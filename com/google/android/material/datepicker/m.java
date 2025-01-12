package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
abstract class m extends Fragment {
    protected final LinkedHashSet Z = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m1(l lVar) {
        return this.Z.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n1() {
        this.Z.clear();
    }
}
