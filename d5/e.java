package d5;

import java.util.zip.Deflater;
/* loaded from: classes.dex */
class e extends c {

    /* renamed from: b  reason: collision with root package name */
    private byte[] f9208b;

    /* renamed from: c  reason: collision with root package name */
    protected Deflater f9209c;

    public e(b bVar, f5.c cVar, int i6) {
        super(bVar);
        this.f9209c = new Deflater(cVar.getLevel(), true);
        this.f9208b = new byte[i6];
    }

    private void c() {
        Deflater deflater = this.f9209c;
        byte[] bArr = this.f9208b;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            super.write(this.f9208b, 0, deflate);
        }
    }

    @Override // d5.c
    public void a() {
        if (!this.f9209c.finished()) {
            this.f9209c.finish();
            while (!this.f9209c.finished()) {
                c();
            }
        }
        this.f9209c.end();
        super.a();
    }

    @Override // d5.c, java.io.OutputStream
    public void write(int i6) {
        write(new byte[]{(byte) i6}, 0, 1);
    }

    @Override // d5.c, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // d5.c, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        this.f9209c.setInput(bArr, i6, i7);
        while (!this.f9209c.needsInput()) {
            c();
        }
    }
}
