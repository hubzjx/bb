package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes.dex */
class o {

    /* renamed from: c  reason: collision with root package name */
    private static final o f5214c = new o(null, null);

    /* renamed from: a  reason: collision with root package name */
    private final Long f5215a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f5216b;

    private o(Long l6, TimeZone timeZone) {
        this.f5215a = l6;
        this.f5216b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o c() {
        return f5214c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f5216b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l6 = this.f5215a;
        if (l6 != null) {
            calendar.setTimeInMillis(l6.longValue());
        }
        return calendar;
    }
}
