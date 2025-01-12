package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: i  reason: collision with root package name */
    static final Object f1558i = new Object();

    /* renamed from: j  reason: collision with root package name */
    static final HashMap f1559j = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    b f1560b;

    /* renamed from: c  reason: collision with root package name */
    h f1561c;

    /* renamed from: d  reason: collision with root package name */
    a f1562d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1563e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f1564f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f1565g = false;

    /* renamed from: h  reason: collision with root package name */
    final ArrayList f1566h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a6 = JobIntentService.this.a();
                if (a6 == null) {
                    return null;
                }
                JobIntentService.this.e(a6.getIntent());
                a6.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onCancelled(Void r12) {
            JobIntentService.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r12) {
            JobIntentService.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        e a();

        IBinder b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends h {

        /* renamed from: d  reason: collision with root package name */
        private final Context f1568d;

        /* renamed from: e  reason: collision with root package name */
        private final PowerManager.WakeLock f1569e;

        /* renamed from: f  reason: collision with root package name */
        private final PowerManager.WakeLock f1570f;

        /* renamed from: g  reason: collision with root package name */
        boolean f1571g;

        /* renamed from: h  reason: collision with root package name */
        boolean f1572h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f1568d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f1569e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f1570f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                if (this.f1572h) {
                    if (this.f1571g) {
                        this.f1569e.acquire(60000L);
                    }
                    this.f1572h = false;
                    this.f1570f.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                if (!this.f1572h) {
                    this.f1572h = true;
                    this.f1570f.acquire(600000L);
                    this.f1569e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f1571g = false;
            }
        }
    }

    /* loaded from: classes.dex */
    final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f1573a;

        /* renamed from: b  reason: collision with root package name */
        final int f1574b;

        d(Intent intent, int i6) {
            this.f1573a = intent;
            this.f1574b = i6;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f1574b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f1573a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* loaded from: classes.dex */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f1576a;

        /* renamed from: b  reason: collision with root package name */
        final Object f1577b;

        /* renamed from: c  reason: collision with root package name */
        JobParameters f1578c;

        /* loaded from: classes.dex */
        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f1579a;

            a(JobWorkItem jobWorkItem) {
                this.f1579a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f1577b) {
                    JobParameters jobParameters = f.this.f1578c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f1579a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                Intent intent;
                intent = this.f1579a.getIntent();
                return intent;
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f1577b = new Object();
            this.f1576a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public e a() {
            JobWorkItem dequeueWork;
            Intent intent;
            synchronized (this.f1577b) {
                JobParameters jobParameters = this.f1578c;
                if (jobParameters == null) {
                    return null;
                }
                dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork != null) {
                    intent = dequeueWork.getIntent();
                    intent.setExtrasClassLoader(this.f1576a.getClassLoader());
                    return new a(dequeueWork);
                }
                return null;
            }
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder b() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f1578c = jobParameters;
            this.f1576a.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b6 = this.f1576a.b();
            synchronized (this.f1577b) {
                this.f1578c = null;
            }
            return b6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g extends h {

        /* renamed from: d  reason: collision with root package name */
        private final JobInfo f1581d;

        /* renamed from: e  reason: collision with root package name */
        private final JobScheduler f1582e;

        g(Context context, ComponentName componentName, int i6) {
            super(componentName);
            a(i6);
            this.f1581d = new JobInfo.Builder(i6, this.f1583a).setOverrideDeadline(0L).build();
            this.f1582e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f1583a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1584b;

        /* renamed from: c  reason: collision with root package name */
        int f1585c;

        h(ComponentName componentName) {
            this.f1583a = componentName;
        }

        void a(int i6) {
            if (!this.f1584b) {
                this.f1584b = true;
                this.f1585c = i6;
            } else if (this.f1585c == i6) {
            } else {
                throw new IllegalArgumentException("Given job ID " + i6 + " is different than previous " + this.f1585c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        this.f1566h = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList();
    }

    static h d(Context context, ComponentName componentName, boolean z5, int i6) {
        h cVar;
        HashMap hashMap = f1559j;
        h hVar = (h) hashMap.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else if (!z5) {
                throw new IllegalArgumentException("Can't be here without a job id");
            } else {
                cVar = new g(context, componentName, i6);
            }
            h hVar2 = cVar;
            hashMap.put(componentName, hVar2);
            return hVar2;
        }
        return hVar;
    }

    e a() {
        b bVar = this.f1560b;
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.f1566h) {
            if (this.f1566h.size() > 0) {
                return (e) this.f1566h.remove(0);
            }
            return null;
        }
    }

    boolean b() {
        a aVar = this.f1562d;
        if (aVar != null) {
            aVar.cancel(this.f1563e);
        }
        this.f1564f = true;
        return f();
    }

    void c(boolean z5) {
        if (this.f1562d == null) {
            this.f1562d = new a();
            h hVar = this.f1561c;
            if (hVar != null && z5) {
                hVar.c();
            }
            this.f1562d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(Intent intent);

    public boolean f() {
        return true;
    }

    void g() {
        ArrayList arrayList = this.f1566h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1562d = null;
                ArrayList arrayList2 = this.f1566h;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    c(false);
                } else if (!this.f1565g) {
                    this.f1561c.b();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f1560b;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1560b = new f(this);
            this.f1561c = null;
            return;
        }
        this.f1560b = null;
        this.f1561c = d(this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f1566h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1565g = true;
                this.f1561c.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        if (this.f1566h != null) {
            this.f1561c.d();
            synchronized (this.f1566h) {
                ArrayList arrayList = this.f1566h;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new d(intent, i7));
                c(true);
            }
            return 3;
        }
        return 2;
    }
}
