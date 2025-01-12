package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z1 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1160c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList f1161d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1162a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1163b;

    private z1(Context context) {
        super(context);
        if (!i2.b()) {
            this.f1162a = new b2(this, context.getResources());
            this.f1163b = null;
            return;
        }
        i2 i2Var = new i2(this, context.getResources());
        this.f1162a = i2Var;
        Resources.Theme newTheme = i2Var.newTheme();
        this.f1163b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        return ((context instanceof z1) || (context.getResources() instanceof b2) || (context.getResources() instanceof i2) || !i2.b()) ? false : true;
    }

    public static Context b(Context context) {
        if (a(context)) {
            synchronized (f1160c) {
                ArrayList arrayList = f1161d;
                if (arrayList == null) {
                    f1161d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f1161d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1161d.remove(size);
                        }
                    }
                    for (int size2 = f1161d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f1161d.get(size2);
                        z1 z1Var = weakReference2 != null ? (z1) weakReference2.get() : null;
                        if (z1Var != null && z1Var.getBaseContext() == context) {
                            return z1Var;
                        }
                    }
                }
                z1 z1Var2 = new z1(context);
                f1161d.add(new WeakReference(z1Var2));
                return z1Var2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1162a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1162a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1163b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i6) {
        Resources.Theme theme = this.f1163b;
        if (theme == null) {
            super.setTheme(i6);
        } else {
            theme.applyStyle(i6, true);
        }
    }
}
