package e0;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private int f9370a;

    /* renamed from: b  reason: collision with root package name */
    private int f9371b;

    public t(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f9370a | this.f9371b;
    }

    public void b(View view, View view2, int i6) {
        c(view, view2, i6, 0);
    }

    public void c(View view, View view2, int i6, int i7) {
        if (i7 == 1) {
            this.f9371b = i6;
        } else {
            this.f9370a = i6;
        }
    }

    public void d(View view, int i6) {
        if (i6 == 1) {
            this.f9371b = 0;
        } else {
            this.f9370a = 0;
        }
    }
}
