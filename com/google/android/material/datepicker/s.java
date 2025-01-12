package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
abstract class s {

    /* renamed from: a  reason: collision with root package name */
    static AtomicReference f5217a = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(long j6) {
        Calendar k6 = k();
        k6.setTimeInMillis(j6);
        return d(k6).getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat b(Locale locale) {
        return c("MMMEd", locale);
    }

    private static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton;
        instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(j());
        return instanceForSkeleton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar d(Calendar calendar) {
        Calendar l6 = l(calendar);
        Calendar k6 = k();
        k6.set(l6.get(1), l6.get(2), l6.get(5));
        return k6;
    }

    private static java.text.DateFormat e(int i6, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i6, locale);
        dateInstance.setTimeZone(h());
        return dateInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat f(Locale locale) {
        return e(0, locale);
    }

    static o g() {
        o oVar = (o) f5217a.get();
        return oVar == null ? o.c() : oVar;
    }

    private static TimeZone h() {
        return TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar i() {
        Calendar a6 = g().a();
        a6.set(11, 0);
        a6.set(12, 0);
        a6.set(13, 0);
        a6.set(14, 0);
        a6.setTimeZone(h());
        return a6;
    }

    private static android.icu.util.TimeZone j() {
        android.icu.util.TimeZone timeZone;
        timeZone = android.icu.util.TimeZone.getTimeZone("UTC");
        return timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar k() {
        return l(null);
    }

    static Calendar l(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(h());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat m(Locale locale) {
        return c("yMMMEd", locale);
    }
}
