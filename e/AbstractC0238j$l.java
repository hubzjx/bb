package e;

import java.lang.reflect.Field;
import java.util.LongSummaryStatistics;
/* renamed from: e.j$l  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0238j$l {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f9300a;

    /* renamed from: b  reason: collision with root package name */
    private static final Field f9301b;

    /* renamed from: c  reason: collision with root package name */
    private static final Field f9302c;

    /* renamed from: d  reason: collision with root package name */
    private static final Field f9303d;

    static {
        b(C0237j$k.class, "count").setAccessible(true);
        b(C0237j$k.class, "sum").setAccessible(true);
        b(C0237j$k.class, "min").setAccessible(true);
        b(C0237j$k.class, "max").setAccessible(true);
        Field b6 = b(LongSummaryStatistics.class, "count");
        f9300a = b6;
        b6.setAccessible(true);
        Field b7 = b(LongSummaryStatistics.class, "sum");
        f9301b = b7;
        b7.setAccessible(true);
        Field b8 = b(LongSummaryStatistics.class, "min");
        f9302c = b8;
        b8.setAccessible(true);
        Field b9 = b(LongSummaryStatistics.class, "max");
        f9303d = b9;
        b9.setAccessible(true);
    }

    public static LongSummaryStatistics a(C0237j$k c0237j$k) {
        if (c0237j$k == null) {
            return null;
        }
        LongSummaryStatistics longSummaryStatistics = new LongSummaryStatistics();
        try {
            f9300a.set(longSummaryStatistics, Long.valueOf(c0237j$k.c()));
            f9301b.set(longSummaryStatistics, Long.valueOf(c0237j$k.h()));
            f9302c.set(longSummaryStatistics, Long.valueOf(c0237j$k.g()));
            f9303d.set(longSummaryStatistics, Long.valueOf(c0237j$k.d()));
            return longSummaryStatistics;
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
