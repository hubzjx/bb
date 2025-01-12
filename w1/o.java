package w1;

import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
final class o implements q2.l {

    /* renamed from: a  reason: collision with root package name */
    private final q2.l f13931a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13932b;

    /* renamed from: c  reason: collision with root package name */
    private final a f13933c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f13934d;

    /* renamed from: e  reason: collision with root package name */
    private int f13935e;

    /* loaded from: classes.dex */
    public interface a {
        void b(com.google.android.exoplayer2.util.y yVar);
    }

    public o(q2.l lVar, int i6, a aVar) {
        com.google.android.exoplayer2.util.a.a(i6 > 0);
        this.f13931a = lVar;
        this.f13932b = i6;
        this.f13933c = aVar;
        this.f13934d = new byte[1];
        this.f13935e = i6;
    }

    private boolean q() {
        if (this.f13931a.read(this.f13934d, 0, 1) == -1) {
            return false;
        }
        int i6 = (this.f13934d[0] & 255) << 4;
        if (i6 == 0) {
            return true;
        }
        byte[] bArr = new byte[i6];
        int i7 = i6;
        int i8 = 0;
        while (i7 > 0) {
            int read = this.f13931a.read(bArr, i8, i7);
            if (read == -1) {
                return false;
            }
            i8 += read;
            i7 -= read;
        }
        while (i6 > 0 && bArr[i6 - 1] == 0) {
            i6--;
        }
        if (i6 > 0) {
            this.f13933c.b(new com.google.android.exoplayer2.util.y(bArr, i6));
        }
        return true;
    }

    @Override // q2.l
    public long b(q2.o oVar) {
        throw new UnsupportedOperationException();
    }

    @Override // q2.l
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // q2.l
    public Map f() {
        return this.f13931a.f();
    }

    @Override // q2.l
    public void i(q2.i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        this.f13931a.i(i0Var);
    }

    @Override // q2.l
    public Uri k() {
        return this.f13931a.k();
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (this.f13935e == 0) {
            if (!q()) {
                return -1;
            }
            this.f13935e = this.f13932b;
        }
        int read = this.f13931a.read(bArr, i6, Math.min(this.f13935e, i7));
        if (read != -1) {
            this.f13935e -= read;
        }
        return read;
    }
}
