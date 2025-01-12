package d5;

import java.io.OutputStream;
/* loaded from: classes.dex */
class j extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f9217b;

    /* renamed from: a  reason: collision with root package name */
    private long f9216a = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9218c = false;

    public j(OutputStream outputStream) {
        this.f9217b = outputStream;
    }

    public void a() {
        this.f9218c = true;
    }

    public long b() {
        return this.f9216a;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
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
        if (this.f9218c) {
            throw new IllegalStateException("ZipEntryOutputStream is closed");
        }
        this.f9217b.write(bArr, i6, i7);
        this.f9216a += i7;
    }
}
