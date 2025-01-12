package d;

import j$.time.Duration;
/* loaded from: classes2.dex */
public enum j$b implements j$o {
    NANOS("Nanos"),
    /* JADX INFO: Fake field, exist only in values array */
    MICROS("Micros"),
    /* JADX INFO: Fake field, exist only in values array */
    MILLIS("Millis"),
    /* JADX INFO: Fake field, exist only in values array */
    SECONDS("Seconds"),
    /* JADX INFO: Fake field, exist only in values array */
    MINUTES("Minutes"),
    /* JADX INFO: Fake field, exist only in values array */
    HOURS("Hours"),
    /* JADX INFO: Fake field, exist only in values array */
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    /* JADX INFO: Fake field, exist only in values array */
    WEEKS("Weeks"),
    MONTHS("Months"),
    /* JADX INFO: Fake field, exist only in values array */
    YEARS("Years"),
    /* JADX INFO: Fake field, exist only in values array */
    DECADES("Decades"),
    /* JADX INFO: Fake field, exist only in values array */
    ERAS("Centuries"),
    /* JADX INFO: Fake field, exist only in values array */
    MILLENNIA("Millennia"),
    /* JADX INFO: Fake field, exist only in values array */
    ERAS("Eras"),
    /* JADX INFO: Fake field, exist only in values array */
    FOREVER("Forever");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f9085a;

    static {
        Duration.b(1L);
        Duration.b(1000L);
        Duration.b(1000000L);
        Duration.d(1L);
        Duration.d(60L);
        Duration.d(3600L);
        Duration.d(43200L);
        Duration.d(86400L);
        Duration.d(604800L);
        Duration.d(2629746L);
        Duration.d(31556952L);
        Duration.d(315569520L);
        Duration.d(3155695200L);
        Duration.d(31556952000L);
        Duration.d(31556952000000000L);
        Duration.c();
    }

    j$b(String str) {
        this.f9085a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f9085a;
    }
}
