package d;

import j$.time.Duration;
/* loaded from: classes2.dex */
enum j$h implements j$o {
    /* JADX INFO: Fake field, exist only in values array */
    WEEK_BASED_YEARS("WeekBasedYears"),
    /* JADX INFO: Fake field, exist only in values array */
    QUARTER_YEARS("QuarterYears");
    

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f9092c = 0;

    /* renamed from: a  reason: collision with root package name */
    private final String f9093a;

    static {
        Duration.d(31556952L);
        Duration.d(7889238L);
    }

    j$h(String str) {
        this.f9093a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f9093a;
    }
}
