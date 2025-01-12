package b0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
abstract class g {

    /* loaded from: classes.dex */
    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f2881a;

        /* renamed from: b  reason: collision with root package name */
        private int f2882b;

        /* renamed from: b0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0030a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            private final int f2883a;

            C0030a(Runnable runnable, String str, int i6) {
                super(runnable, str);
                this.f2883a = i6;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f2883a);
                super.run();
            }
        }

        a(String str, int i6) {
            this.f2881a = str;
            this.f2882b = i6;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0030a(runnable, this.f2881a, this.f2882b);
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Callable f2884a;

        /* renamed from: b  reason: collision with root package name */
        private d0.a f2885b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f2886c;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d0.a f2887a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f2888b;

            a(d0.a aVar, Object obj) {
                this.f2887a = aVar;
                this.f2888b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2887a.a(this.f2888b);
            }
        }

        b(Handler handler, Callable callable, d0.a aVar) {
            this.f2884a = callable;
            this.f2885b = aVar;
            this.f2886c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f2884a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f2886c.post(new a(this.f2885b, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(String str, int i6, int i7) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i7, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i6));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Executor executor, Callable callable, d0.a aVar) {
        executor.execute(new b(b0.b.a(), callable, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object c(ExecutorService executorService, Callable callable, int i6) {
        try {
            return executorService.submit(callable).get(i6, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e6) {
            throw e6;
        } catch (ExecutionException e7) {
            throw new RuntimeException(e7);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
