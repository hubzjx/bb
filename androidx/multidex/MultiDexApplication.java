package androidx.multidex;

import android.app.Application;
import android.content.Context;
import l0.a;
/* loaded from: classes.dex */
public class MultiDexApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.l(this);
    }
}
