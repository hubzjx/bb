package g5;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f10517a;

    /* renamed from: b  reason: collision with root package name */
    private long f10518b;

    /* renamed from: c  reason: collision with root package name */
    private long f10519c;

    /* renamed from: d  reason: collision with root package name */
    private int f10520d;

    /* renamed from: e  reason: collision with root package name */
    private c f10521e;

    /* renamed from: f  reason: collision with root package name */
    private String f10522f;

    /* renamed from: g  reason: collision with root package name */
    private EnumC0171a f10523g;

    /* renamed from: h  reason: collision with root package name */
    private Exception f10524h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10525i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10526j;

    /* renamed from: g5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0171a {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    /* loaded from: classes.dex */
    public enum b {
        READY,
        BUSY
    }

    /* loaded from: classes.dex */
    public enum c {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public a() {
        f();
    }

    private void f() {
        this.f10521e = c.NONE;
        this.f10517a = b.READY;
    }

    public void a() {
        this.f10523g = EnumC0171a.SUCCESS;
        this.f10520d = 100;
        f();
    }

    public void b(Exception exc) {
        this.f10523g = EnumC0171a.ERROR;
        this.f10524h = exc;
        f();
    }

    public void c() {
        f();
        this.f10522f = null;
        this.f10518b = 0L;
        this.f10519c = 0L;
        this.f10520d = 0;
    }

    public b d() {
        return this.f10517a;
    }

    public boolean e() {
        return this.f10525i;
    }

    public void g(c cVar) {
        this.f10521e = cVar;
    }

    public void h(String str) {
        this.f10522f = str;
    }

    public void i(EnumC0171a enumC0171a) {
        this.f10523g = enumC0171a;
    }

    public void j(b bVar) {
        this.f10517a = bVar;
    }

    public void k(long j6) {
        this.f10518b = j6;
    }

    public void l(long j6) {
        long j7 = this.f10519c + j6;
        this.f10519c = j7;
        long j8 = this.f10518b;
        if (j8 > 0) {
            int i6 = (int) ((j7 * 100) / j8);
            this.f10520d = i6;
            if (i6 > 100) {
                this.f10520d = 100;
            }
        }
        while (this.f10526j) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
