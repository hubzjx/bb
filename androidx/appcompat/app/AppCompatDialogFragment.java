package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
/* loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog q1(Bundle bundle) {
        return new d.h(p(), p1());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void s1(Dialog dialog, int i6) {
        if (!(dialog instanceof d.h)) {
            super.s1(dialog, i6);
            return;
        }
        d.h hVar = (d.h) dialog;
        if (i6 != 1 && i6 != 2) {
            if (i6 != 3) {
                return;
            }
            dialog.getWindow().addFlags(24);
        }
        hVar.e(1);
    }
}
