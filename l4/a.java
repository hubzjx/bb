package l4;

import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public class a extends k4.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0194a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0194a f11934a = new C0194a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f11935b;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null) {
                    if (num.intValue() > 0) {
                        num2 = num;
                    }
                }
                f11935b = num2;
            }
            num = null;
            if (num != null) {
            }
            f11935b = num2;
        }

        private C0194a() {
        }
    }

    private final boolean b(int i6) {
        Integer num = C0194a.f11935b;
        return num == null || num.intValue() >= i6;
    }

    @Override // k4.a
    public void a(Throwable th, Throwable th2) {
        l.d(th, "cause");
        l.d(th2, "exception");
        if (b(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
