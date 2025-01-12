package q2;

import java.io.InputStream;
/* loaded from: classes.dex */
public final class n extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final l f12788a;

    /* renamed from: b  reason: collision with root package name */
    private final o f12789b;

    /* renamed from: f  reason: collision with root package name */
    private long f12793f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12791d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12792e = false;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f12790c = new byte[1];

    public n(l lVar, o oVar) {
        this.f12788a = lVar;
        this.f12789b = oVar;
    }

    private void a() {
        if (this.f12791d) {
            return;
        }
        this.f12788a.b(this.f12789b);
        this.f12791d = true;
    }

    public void b() {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12792e) {
            return;
        }
        this.f12788a.close();
        this.f12792e = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f12790c) == -1) {
            return -1;
        }
        return this.f12790c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) {
        com.google.android.exoplayer2.util.a.g(!this.f12792e);
        a();
        int read = this.f12788a.read(bArr, i6, i7);
        if (read == -1) {
            return -1;
        }
        this.f12793f += read;
        return read;
    }
}
