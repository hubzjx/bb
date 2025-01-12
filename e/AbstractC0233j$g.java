package e;

import java.lang.reflect.Field;
import java.util.DoubleSummaryStatistics;
/* renamed from: e.j$g  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0233j$g {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f9292a;

    /* renamed from: b  reason: collision with root package name */
    private static final Field f9293b;

    /* renamed from: c  reason: collision with root package name */
    private static final Field f9294c;

    /* renamed from: d  reason: collision with root package name */
    private static final Field f9295d;

    static {
        b(C0232j$f.class, "count").setAccessible(true);
        b(C0232j$f.class, "sum").setAccessible(true);
        b(C0232j$f.class, "min").setAccessible(true);
        b(C0232j$f.class, "max").setAccessible(true);
        Field b6 = b(DoubleSummaryStatistics.class, "count");
        f9292a = b6;
        b6.setAccessible(true);
        Field b7 = b(DoubleSummaryStatistics.class, "sum");
        f9293b = b7;
        b7.setAccessible(true);
        Field b8 = b(DoubleSummaryStatistics.class, "min");
        f9294c = b8;
        b8.setAccessible(true);
        Field b9 = b(DoubleSummaryStatistics.class, "max");
        f9295d = b9;
        b9.setAccessible(true);
    }

    public static DoubleSummaryStatistics a(C0232j$f c0232j$f) {
        if (c0232j$f == null) {
            return null;
        }
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
        try {
            f9292a.set(doubleSummaryStatistics, Long.valueOf(c0232j$f.c()));
            f9293b.set(doubleSummaryStatistics, Double.valueOf(c0232j$f.g()));
            f9294c.set(doubleSummaryStatistics, Double.valueOf(c0232j$f.f()));
            f9295d.set(doubleSummaryStatistics, Double.valueOf(c0232j$f.e()));
            return doubleSummaryStatistics;
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
