package r2;

import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0210a extends IOException {
        public C0210a(String str) {
            super(str);
        }

        public C0210a(String str, Throwable th) {
            super(str, th);
        }

        public C0210a(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar, j jVar);

        void b(a aVar, j jVar);

        void e(a aVar, j jVar, j jVar2);
    }

    File a(String str, long j6, long j7);

    void b(File file, long j6);

    void c(j jVar);

    n d(String str);

    j e(String str, long j6, long j7);

    void f(j jVar);

    void g(String str, o oVar);

    j h(String str, long j6, long j7);
}
