package androidx.fragment.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: c  reason: collision with root package name */
    static final e f1783c = new e();

    /* renamed from: b  reason: collision with root package name */
    private e f1784b = null;

    public abstract l a();

    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public e c() {
        if (this.f1784b == null) {
            this.f1784b = f1783c;
        }
        return this.f1784b;
    }

    public abstract List d();

    public abstract void e(int i6, int i7);

    public abstract boolean f();

    public void g(e eVar) {
        this.f1784b = eVar;
    }
}
