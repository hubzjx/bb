package r3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f13044c;

    /* renamed from: d  reason: collision with root package name */
    private final short f13045d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, int i6, int i7) {
        super(gVar);
        this.f13044c = (short) i6;
        this.f13045d = (short) i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // r3.g
    public void c(s3.a aVar, byte[] bArr) {
        aVar.c(this.f13044c, this.f13045d);
    }

    public String toString() {
        short s5 = this.f13044c;
        short s6 = this.f13045d;
        int i6 = (s5 & ((1 << s6) - 1)) | (1 << s6);
        return "<" + Integer.toBinaryString(i6 | (1 << this.f13045d)).substring(1) + '>';
    }
}
