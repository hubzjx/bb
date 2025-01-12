package h3;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(int i6) {
        return i6 != 0 ? i6 != 1 ? b() : new e() : new j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f c() {
        return new f();
    }

    public static void d(View view, float f6) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).T(f6);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.M()) {
            gVar.X(com.google.android.material.internal.l.c(view));
        }
    }
}
