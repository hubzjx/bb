package a0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static long f36a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f37b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f38c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f39d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f40e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f36a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f37b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f38c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f39d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f40e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e6) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e6);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
