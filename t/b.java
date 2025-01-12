package t;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class f13301a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f13302b;

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f13303c;

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f13304d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f13305e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f13306f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f13307g = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f13308a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f13309b;

        a(d dVar, Object obj) {
            this.f13308a = dVar;
            this.f13309b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13308a.f13314a = this.f13309b;
        }
    }

    /* renamed from: t.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0216b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f13310a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f13311b;

        RunnableC0216b(Application application, d dVar) {
            this.f13310a = application;
            this.f13311b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13310a.unregisterActivityLifecycleCallbacks(this.f13311b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f13312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f13313b;

        c(Object obj, Object obj2) {
            this.f13312a = obj;
            this.f13313b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = b.f13304d;
                if (method != null) {
                    method.invoke(this.f13312a, this.f13313b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    b.f13305e.invoke(this.f13312a, this.f13313b, Boolean.FALSE);
                }
            } catch (RuntimeException e6) {
                if (e6.getClass() == RuntimeException.class && e6.getMessage() != null && e6.getMessage().startsWith("Unable to stop")) {
                    throw e6;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f13314a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f13315b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13316c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13317d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f13318e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13319f = false;

        d(Activity activity) {
            this.f13315b = activity;
            this.f13316c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f13315b == activity) {
                this.f13315b = null;
                this.f13318e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f13318e || this.f13319f || this.f13317d || !b.h(this.f13314a, this.f13316c, activity)) {
                return;
            }
            this.f13319f = true;
            this.f13314a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f13315b == activity) {
                this.f13317d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a6 = a();
        f13301a = a6;
        f13302b = b();
        f13303c = f();
        f13304d = d(a6);
        f13305e = c(a6);
        f13306f = e(a6);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 == 26 || i6 == 27;
    }

    protected static boolean h(Object obj, int i6, Activity activity) {
        try {
            Object obj2 = f13303c.get(activity);
            if (obj2 == obj && activity.hashCode() == i6) {
                f13307g.postAtFrontOfQueue(new c(f13302b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f13306f == null) {
            return false;
        } else {
            if (f13305e == null && f13304d == null) {
                return false;
            }
            try {
                Object obj2 = f13303c.get(activity);
                if (obj2 == null || (obj = f13302b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                d dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f13307g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f13306f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new RunnableC0216b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
