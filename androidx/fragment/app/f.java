package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class f extends c {

    /* renamed from: b  reason: collision with root package name */
    private final Activity f1778b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1779c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f1780d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1781e;

    /* renamed from: f  reason: collision with root package name */
    final h f1782f;

    f(Activity activity, Context context, Handler handler, int i6) {
        this.f1782f = new h();
        this.f1778b = activity;
        this.f1779c = (Context) d0.i.d(context, "context == null");
        this.f1780d = (Handler) d0.i.d(handler, "handler == null");
        this.f1781e = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity f() {
        return this.f1778b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context i() {
        return this.f1779c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler j() {
        return this.f1780d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void k(Fragment fragment);

    public abstract void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object m();

    public abstract LayoutInflater n();

    public abstract int o();

    public abstract boolean p();

    public abstract boolean q(Fragment fragment);

    public abstract void r();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }
}
