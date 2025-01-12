package r3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: b  reason: collision with root package name */
    static final g f13051b = new e(null, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final g f13052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(g gVar) {
        this.f13052a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g a(int i6, int i7) {
        return new e(this, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g b(int i6, int i7) {
        return new b(this, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(s3.a aVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g d() {
        return this.f13052a;
    }
}
