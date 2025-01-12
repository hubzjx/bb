package d;
/* loaded from: classes2.dex */
public enum j$a implements j$l {
    NANO_OF_SECOND("NanoOfSecond", j$q.i(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", j$q.i(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", j$q.i(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", j$q.i(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", j$q.i(0, 999)),
    MILLI_OF_DAY("MilliOfDay", j$q.i(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", j$q.i(0, 59), 0),
    /* JADX INFO: Fake field, exist only in values array */
    SECOND_OF_DAY("SecondOfDay", j$q.i(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", j$q.i(0, 59), 0),
    /* JADX INFO: Fake field, exist only in values array */
    ALIGNED_WEEK_OF_MONTH("MinuteOfDay", j$q.i(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", j$q.i(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", j$q.i(1, 12)),
    HOUR_OF_DAY("HourOfDay", j$q.i(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", j$q.i(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", j$q.i(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", j$q.i(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", j$q.i(1, 7)),
    /* JADX INFO: Fake field, exist only in values array */
    ALIGNED_WEEK_OF_MONTH("AlignedDayOfWeekInYear", j$q.i(1, 7)),
    DAY_OF_MONTH("DayOfMonth", j$q.j(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", j$q.j(365, 366)),
    EPOCH_DAY("EpochDay", j$q.i(-365249999634L, 365249999634L)),
    /* JADX INFO: Fake field, exist only in values array */
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", j$q.j(4, 5)),
    /* JADX INFO: Fake field, exist only in values array */
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", j$q.i(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", j$q.i(1, 12), 0),
    PROLEPTIC_MONTH("ProlepticMonth", j$q.i(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", j$q.j(999999999, 1000000000)),
    YEAR("Year", j$q.i(-999999999, 999999999), 0),
    ERA("Era", j$q.i(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", j$q.i(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", j$q.i(-64800, 64800));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f9079a;

    /* renamed from: b  reason: collision with root package name */
    private final j$q f9080b;

    static {
        j$b j_b = j$b.NANOS;
    }

    j$a(String str, j$q j_q) {
        this.f9079a = str;
        this.f9080b = j_q;
    }

    j$a(String str, j$q j_q, int i6) {
        this.f9079a = str;
        this.f9080b = j_q;
    }

    @Override // d.j$l
    public final long a(j$k j_k) {
        return j_k.a(this);
    }

    @Override // d.j$l
    public final j$q b() {
        return this.f9080b;
    }

    @Override // d.j$l
    public final boolean c(j$k j_k) {
        return j_k.d(this);
    }

    @Override // d.j$l
    public final boolean d() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override // d.j$l
    public final boolean e() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    @Override // d.j$l
    public final j$q f(j$k j_k) {
        return j_k.b(this);
    }

    public final int g(long j6) {
        return this.f9080b.a(j6, this);
    }

    public final void h(long j6) {
        this.f9080b.b(j6, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f9079a;
    }
}
