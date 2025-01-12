package j;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f11135c;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f11136d = new ExecutorC0180a();

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f11137e = new b();

    /* renamed from: a  reason: collision with root package name */
    private c f11138a;

    /* renamed from: b  reason: collision with root package name */
    private c f11139b;

    /* renamed from: j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0180a implements Executor {
        ExecutorC0180a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().c(runnable);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a(runnable);
        }
    }

    private a() {
        j.b bVar = new j.b();
        this.f11139b = bVar;
        this.f11138a = bVar;
    }

    public static a d() {
        if (f11135c != null) {
            return f11135c;
        }
        synchronized (a.class) {
            if (f11135c == null) {
                f11135c = new a();
            }
        }
        return f11135c;
    }

    @Override // j.c
    public void a(Runnable runnable) {
        this.f11138a.a(runnable);
    }

    @Override // j.c
    public boolean b() {
        return this.f11138a.b();
    }

    @Override // j.c
    public void c(Runnable runnable) {
        this.f11138a.c(runnable);
    }
}
