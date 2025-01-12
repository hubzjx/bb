package androidx.loader.app;

import androidx.lifecycle.f;
import androidx.lifecycle.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class a {
    public static a b(f fVar) {
        return new b(fVar, ((p) fVar).g());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
