package d5;

import java.io.OutputStream;
/* loaded from: classes.dex */
abstract class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private b f9205a;

    public c(b bVar) {
        this.f9205a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.f9205a.a();
    }

    public long b() {
        return this.f9205a.c();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9205a.close();
    }

    @Override // java.io.OutputStream
    public void write(int i6) {
        write(new byte[]{(byte) i6});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        this.f9205a.write(bArr, i6, i7);
    }
}
