package d5;

import java.io.OutputStream;
/* loaded from: classes.dex */
public class d extends OutputStream implements g {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f9206a;

    /* renamed from: b  reason: collision with root package name */
    private long f9207b = 0;

    public d(OutputStream outputStream) {
        this.f9206a = outputStream;
    }

    @Override // d5.g
    public int a() {
        if (g()) {
            return ((h) this.f9206a).a();
        }
        return 0;
    }

    @Override // d5.g
    public long b() {
        OutputStream outputStream = this.f9206a;
        return outputStream instanceof h ? ((h) outputStream).b() : this.f9207b;
    }

    public boolean c(int i6) {
        if (g()) {
            return ((h) this.f9206a).c(i6);
        }
        return false;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9206a.close();
    }

    public long d() {
        OutputStream outputStream = this.f9206a;
        return outputStream instanceof h ? ((h) outputStream).b() : this.f9207b;
    }

    public long e() {
        OutputStream outputStream = this.f9206a;
        return outputStream instanceof h ? ((h) outputStream).b() : this.f9207b;
    }

    public long f() {
        if (g()) {
            return ((h) this.f9206a).d();
        }
        return 0L;
    }

    public boolean g() {
        OutputStream outputStream = this.f9206a;
        return (outputStream instanceof h) && ((h) outputStream).g();
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
        this.f9206a.write(bArr, i6, i7);
        this.f9207b += i7;
    }
}
