package d5;

import e5.q;
import java.io.OutputStream;
/* loaded from: classes.dex */
abstract class b extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private j f9203a;

    /* renamed from: b  reason: collision with root package name */
    private x4.c f9204b;

    public b(j jVar, q qVar, char[] cArr) {
        this.f9203a = jVar;
        this.f9204b = d(jVar, qVar, cArr);
    }

    public void a() {
        this.f9203a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x4.c b() {
        return this.f9204b;
    }

    public long c() {
        return this.f9203a.b();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9203a.close();
    }

    protected abstract x4.c d(OutputStream outputStream, q qVar, char[] cArr);

    public void e(byte[] bArr) {
        this.f9203a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i6) {
        this.f9203a.write(i6);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f9203a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        this.f9204b.a(bArr, i6, i7);
        this.f9203a.write(bArr, i6, i7);
    }
}
