package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements d {

    /* renamed from: b  reason: collision with root package name */
    private static int f223b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f224c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f225d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f226e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f227a = activity;
    }

    private static void b() {
        try {
            f223b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f225d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f226e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f224c = declaredField3;
            declaredField3.setAccessible(true);
            f223b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar, c.a aVar) {
        if (aVar != c.a.ON_DESTROY) {
            return;
        }
        if (f223b == 0) {
            b();
        }
        if (f223b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f227a.getSystemService("input_method");
            try {
                Object obj = f224c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f225d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f226e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
