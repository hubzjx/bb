package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: b  reason: collision with root package name */
    private static int f324b = -100;

    /* renamed from: c  reason: collision with root package name */
    private static final l.b f325c = new l.b();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f326d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(c cVar) {
        synchronized (f326d) {
            y(cVar);
            f325c.add(new WeakReference(cVar));
        }
    }

    public static c g(Activity activity, d.a aVar) {
        return new d(activity, aVar);
    }

    public static c h(Dialog dialog, d.a aVar) {
        return new d(dialog, aVar);
    }

    public static int j() {
        return f324b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x(c cVar) {
        synchronized (f326d) {
            y(cVar);
        }
    }

    private static void y(c cVar) {
        synchronized (f326d) {
            Iterator it = f325c.iterator();
            while (it.hasNext()) {
                c cVar2 = (c) ((WeakReference) it.next()).get();
                if (cVar2 == cVar || cVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void A(int i6);

    public abstract void B(View view);

    public abstract void C(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void D(int i6);

    public abstract void E(CharSequence charSequence);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract View i(int i6);

    public abstract int k();

    public abstract MenuInflater l();

    public abstract a m();

    public abstract void n();

    public abstract void o();

    public abstract void p(Configuration configuration);

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w();

    public abstract boolean z(int i6);
}
