package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public abstract class c {
    public Fragment c(Context context, String str, Bundle bundle) {
        return Fragment.N(context, str, bundle);
    }

    public abstract View d(int i6);

    public abstract boolean e();
}
