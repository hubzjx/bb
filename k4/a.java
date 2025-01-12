package k4;

import java.lang.reflect.Method;
import kotlin.collections.j;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0184a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0184a f11279a = new C0184a();

        /* renamed from: b  reason: collision with root package name */
        public static final Method f11280b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f11281c;

        /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[LOOP:0: B:3:0x0015->B:13:0x003f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EDGE_INSN: B:24:0x0043->B:15:0x0043 ?: BREAK  , SYNTHETIC] */
        static {
            Method method;
            Method method2;
            boolean z5;
            Object u5;
            Method[] methods = Throwable.class.getMethods();
            l.c(methods, "throwableMethods");
            int length = methods.length;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                method = null;
                if (i7 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i7];
                if (l.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    l.c(parameterTypes, "it.parameterTypes");
                    u5 = j.u(parameterTypes);
                    if (l.a(u5, Throwable.class)) {
                        z5 = true;
                        if (!z5) {
                            break;
                        }
                        i7++;
                    }
                }
                z5 = false;
                if (!z5) {
                }
            }
            f11280b = method2;
            int length2 = methods.length;
            while (true) {
                if (i6 >= length2) {
                    break;
                }
                Method method3 = methods[i6];
                if (l.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i6++;
            }
            f11281c = method;
        }

        private C0184a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        l.d(th, "cause");
        l.d(th2, "exception");
        Method method = C0184a.f11280b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
