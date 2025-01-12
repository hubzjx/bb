package e;

import java.lang.reflect.Field;
import java.util.IntSummaryStatistics;
/* renamed from: e.j$i  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0235j$i {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f9296a;

    /* renamed from: b  reason: collision with root package name */
    private static final Field f9297b;

    /* renamed from: c  reason: collision with root package name */
    private static final Field f9298c;

    /* renamed from: d  reason: collision with root package name */
    private static final Field f9299d;

    static {
        b(C0234j$h.class, "count").setAccessible(true);
        b(C0234j$h.class, "sum").setAccessible(true);
        b(C0234j$h.class, "min").setAccessible(true);
        b(C0234j$h.class, "max").setAccessible(true);
        Field b6 = b(IntSummaryStatistics.class, "count");
        f9296a = b6;
        b6.setAccessible(true);
        Field b7 = b(IntSummaryStatistics.class, "sum");
        f9297b = b7;
        b7.setAccessible(true);
        Field b8 = b(IntSummaryStatistics.class, "min");
        f9298c = b8;
        b8.setAccessible(true);
        Field b9 = b(IntSummaryStatistics.class, "max");
        f9299d = b9;
        b9.setAccessible(true);
    }

    public static IntSummaryStatistics a(C0234j$h c0234j$h) {
        if (c0234j$h == null) {
            return null;
        }
        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
        try {
            f9296a.set(intSummaryStatistics, Long.valueOf(c0234j$h.c()));
            f9297b.set(intSummaryStatistics, Long.valueOf(c0234j$h.g()));
            f9298c.set(intSummaryStatistics, Integer.valueOf(c0234j$h.f()));
            f9299d.set(intSummaryStatistics, Integer.valueOf(c0234j$h.d()));
            return intSummaryStatistics;
        } catch (IllegalAccessException e6) {
            throw new Error("Failed summary statistics conversion.", e6);
        }
    }

    private static Field b(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e6) {
            throw new Error("Failed summary statistics set-up.", e6);
        }
    }
}
