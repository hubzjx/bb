package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class i2 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f958b;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f959a;

    public i2(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f959a = new WeakReference(context);
    }

    public static boolean a() {
        return f958b;
    }

    public static boolean b() {
        a();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable c(int i6) {
        return super.getDrawable(i6);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i6) {
        Context context = (Context) this.f959a.get();
        return context != null ? t1.h().t(context, this, i6) : super.getDrawable(i6);
    }
}
