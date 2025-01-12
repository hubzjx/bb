package j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11140a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f11141b = Executors.newFixedThreadPool(2, new a());

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f11142c;

    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f11143a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f11143a.getAndIncrement())));
            return thread;
        }
    }

    @Override // j.c
    public void a(Runnable runnable) {
        this.f11141b.execute(runnable);
    }

    @Override // j.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // j.c
    public void c(Runnable runnable) {
        if (this.f11142c == null) {
            synchronized (this.f11140a) {
                if (this.f11142c == null) {
                    this.f11142c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f11142c.post(runnable);
    }
}
