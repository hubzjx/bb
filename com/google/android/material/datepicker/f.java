package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j6) {
        return b(j6, Locale.getDefault());
    }

    static String b(long j6, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = s.b(locale).format(new Date(j6));
            return format;
        }
        return s.f(locale).format(new Date(j6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context, long j6) {
        return DateUtils.formatDateTime(context, j6 - TimeZone.getDefault().getOffset(j6), 36);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(long j6) {
        return e(j6, Locale.getDefault());
    }

    static String e(long j6, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = s.m(locale).format(new Date(j6));
            return format;
        }
        return s.f(locale).format(new Date(j6));
    }
}
