package d0;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: c  reason: collision with root package name */
    private final Object f9115c;

    public h(int i6) {
        super(i6);
        this.f9115c = new Object();
    }

    @Override // d0.g, d0.f
    public boolean a(Object obj) {
        boolean a6;
        synchronized (this.f9115c) {
            a6 = super.a(obj);
        }
        return a6;
    }

    @Override // d0.g, d0.f
    public Object b() {
        Object b6;
        synchronized (this.f9115c) {
            b6 = super.b();
        }
        return b6;
    }
}
