package io.jsonwebtoken.lang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class DateFormats {
    private static final ThreadLocal<DateFormat> ISO_8601 = new ThreadLocal<DateFormat>() { // from class: io.jsonwebtoken.lang.DateFormats.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.ISO_8601_PATTERN);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    private static final ThreadLocal<DateFormat> ISO_8601_MILLIS = new ThreadLocal<DateFormat>() { // from class: io.jsonwebtoken.lang.DateFormats.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.ISO_8601_MILLIS_PATTERN);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    private static final String ISO_8601_MILLIS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String formatIso8601(Date date) {
        return formatIso8601(date, true);
    }

    public static Date parseIso8601Date(String str) {
        Assert.notNull(str, "String argument cannot be null.");
        return (str.lastIndexOf(46) > -1 ? ISO_8601_MILLIS : ISO_8601).get().parse(str);
    }

    public static String formatIso8601(Date date, boolean z5) {
        return (z5 ? ISO_8601_MILLIS : ISO_8601).get().format(date);
    }
}
