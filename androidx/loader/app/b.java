package androidx.loader.app;

import androidx.lifecycle.f;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import l.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: a  reason: collision with root package name */
    private final f f2005a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2006b;

    /* loaded from: classes.dex */
    static class a extends m {

        /* renamed from: e  reason: collision with root package name */
        private static final n.a f2007e = new C0018a();

        /* renamed from: c  reason: collision with root package name */
        private h f2008c = new h();

        /* renamed from: d  reason: collision with root package name */
        private boolean f2009d = false;

        /* renamed from: androidx.loader.app.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0018a implements n.a {
            C0018a() {
            }

            @Override // androidx.lifecycle.n.a
            public m a(Class cls) {
                return new a();
            }
        }

        a() {
        }

        static a e(o oVar) {
            return (a) new n(oVar, f2007e).a(a.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.m
        public void c() {
            super.c();
            if (this.f2008c.k() <= 0) {
                this.f2008c.b();
            } else {
                android.support.v4.media.a.a(this.f2008c.l(0));
                throw null;
            }
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2008c.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f2008c.k() <= 0) {
                    return;
                }
                android.support.v4.media.a.a(this.f2008c.l(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f2008c.h(0));
                printWriter.print(": ");
                throw null;
            }
        }

        void f() {
            if (this.f2008c.k() <= 0) {
                return;
            }
            android.support.v4.media.a.a(this.f2008c.l(0));
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(f fVar, o oVar) {
        this.f2005a = fVar;
        this.f2006b = a.e(oVar);
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2006b.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f2006b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d0.b.a(this.f2005a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
