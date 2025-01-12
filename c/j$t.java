package c;

import j$.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public final class j$t {

    /* renamed from: a  reason: collision with root package name */
    public static final j$t f3091a = new j$t();

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private j$t() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j$t) {
            ((j$t) obj).getClass();
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 182;
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
