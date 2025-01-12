package okio;
/* loaded from: classes.dex */
public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String str) {
        kotlin.jvm.internal.l.d(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.text.d.f11327b);
        kotlin.jvm.internal.l.c(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m184synchronized(Object obj, p4.a aVar) {
        R r5;
        kotlin.jvm.internal.l.d(obj, "lock");
        kotlin.jvm.internal.l.d(aVar, "block");
        synchronized (obj) {
            try {
                r5 = (R) aVar.invoke();
                kotlin.jvm.internal.k.b(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.k.b(1);
                kotlin.jvm.internal.k.a(1);
                throw th;
            }
        }
        kotlin.jvm.internal.k.a(1);
        return r5;
    }

    public static final String toUtf8String(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        return new String(bArr, kotlin.text.d.f11327b);
    }
}
