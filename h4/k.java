package h4;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class k implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            kotlin.jvm.internal.l.d(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.l.a(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    private /* synthetic */ k(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ k m14boximpl(Object obj) {
        return new k(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m15constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m16equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof k) && kotlin.jvm.internal.l.a(obj, ((k) obj2).m24unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m17equalsimpl0(Object obj, Object obj2) {
        return kotlin.jvm.internal.l.a(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m18exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final Object m19getOrNullimpl(Object obj) {
        if (m21isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m20hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m21isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m22isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m23toStringimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m16equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m20hashCodeimpl(this.value);
    }

    public String toString() {
        return m23toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m24unboximpl() {
        return this.value;
    }
}
