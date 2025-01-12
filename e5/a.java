package e5;
/* loaded from: classes.dex */
public class a extends o {

    /* renamed from: b  reason: collision with root package name */
    private int f9546b;

    /* renamed from: c  reason: collision with root package name */
    private f5.b f9547c;

    /* renamed from: d  reason: collision with root package name */
    private String f9548d;

    /* renamed from: e  reason: collision with root package name */
    private f5.a f9549e;

    /* renamed from: f  reason: collision with root package name */
    private f5.d f9550f;

    public a() {
        b(b5.c.AES_EXTRA_DATA_RECORD);
        this.f9546b = 7;
        this.f9547c = f5.b.TWO;
        this.f9548d = "AE";
        this.f9549e = f5.a.KEY_STRENGTH_256;
        this.f9550f = f5.d.DEFLATE;
    }

    public f5.a c() {
        return this.f9549e;
    }

    public f5.b d() {
        return this.f9547c;
    }

    public f5.d e() {
        return this.f9550f;
    }

    public int f() {
        return this.f9546b;
    }

    public String g() {
        return this.f9548d;
    }

    public void h(f5.a aVar) {
        this.f9549e = aVar;
    }

    public void i(f5.b bVar) {
        this.f9547c = bVar;
    }

    public void j(f5.d dVar) {
        this.f9550f = dVar;
    }

    public void k(int i6) {
        this.f9546b = i6;
    }

    public void l(String str) {
        this.f9548d = str;
    }
}
