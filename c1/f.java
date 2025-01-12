package c1;

import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class f implements j {

    /* renamed from: b  reason: collision with root package name */
    private final q2.h f3199b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3200c;

    /* renamed from: d  reason: collision with root package name */
    private long f3201d;

    /* renamed from: f  reason: collision with root package name */
    private int f3203f;

    /* renamed from: g  reason: collision with root package name */
    private int f3204g;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f3202e = new byte[DnsOverHttps.MAX_RESPONSE_SIZE];

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f3198a = new byte[_BufferKt.SEGMENTING_THRESHOLD];

    public f(q2.h hVar, long j6, long j7) {
        this.f3199b = hVar;
        this.f3201d = j6;
        this.f3200c = j7;
    }

    private void q(int i6) {
        if (i6 != -1) {
            this.f3201d += i6;
        }
    }

    private void r(int i6) {
        int i7 = this.f3203f + i6;
        byte[] bArr = this.f3202e;
        if (i7 > bArr.length) {
            this.f3202e = Arrays.copyOf(this.f3202e, s0.r(bArr.length * 2, DnsOverHttps.MAX_RESPONSE_SIZE + i7, i7 + 524288));
        }
    }

    private int s(byte[] bArr, int i6, int i7) {
        int i8 = this.f3204g;
        if (i8 == 0) {
            return 0;
        }
        int min = Math.min(i8, i7);
        System.arraycopy(this.f3202e, 0, bArr, i6, min);
        w(min);
        return min;
    }

    private int t(byte[] bArr, int i6, int i7, int i8, boolean z5) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.f3199b.read(bArr, i6 + i8, i7 - i8);
        if (read == -1) {
            if (i8 == 0 && z5) {
                return -1;
            }
            throw new EOFException();
        }
        return i8 + read;
    }

    private int u(int i6) {
        int min = Math.min(this.f3204g, i6);
        w(min);
        return min;
    }

    private void w(int i6) {
        int i7 = this.f3204g - i6;
        this.f3204g = i7;
        this.f3203f = 0;
        byte[] bArr = this.f3202e;
        byte[] bArr2 = i7 < bArr.length - 524288 ? new byte[DnsOverHttps.MAX_RESPONSE_SIZE + i7] : bArr;
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        this.f3202e = bArr2;
    }

    @Override // c1.j
    public long a() {
        return this.f3200c;
    }

    @Override // c1.j
    public int c(int i6) {
        int u5 = u(i6);
        if (u5 == 0) {
            byte[] bArr = this.f3198a;
            u5 = t(bArr, 0, Math.min(i6, bArr.length), 0, true);
        }
        q(u5);
        return u5;
    }

    @Override // c1.j
    public boolean d(byte[] bArr, int i6, int i7, boolean z5) {
        int s5 = s(bArr, i6, i7);
        while (s5 < i7 && s5 != -1) {
            s5 = t(bArr, i6, i7, s5, z5);
        }
        q(s5);
        return s5 != -1;
    }

    @Override // c1.j
    public int e(byte[] bArr, int i6, int i7) {
        int min;
        r(i7);
        int i8 = this.f3204g;
        int i9 = this.f3203f;
        int i10 = i8 - i9;
        if (i10 == 0) {
            min = t(this.f3202e, i9, i7, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f3204g += min;
        } else {
            min = Math.min(i7, i10);
        }
        System.arraycopy(this.f3202e, this.f3203f, bArr, i6, min);
        this.f3203f += min;
        return min;
    }

    @Override // c1.j
    public void g() {
        this.f3203f = 0;
    }

    @Override // c1.j
    public void h(int i6) {
        v(i6, false);
    }

    @Override // c1.j
    public boolean j(int i6, boolean z5) {
        r(i6);
        int i7 = this.f3204g - this.f3203f;
        while (i7 < i6) {
            i7 = t(this.f3202e, this.f3203f, i6, i7, z5);
            if (i7 == -1) {
                return false;
            }
            this.f3204g = this.f3203f + i7;
        }
        this.f3203f += i6;
        return true;
    }

    @Override // c1.j
    public boolean l(byte[] bArr, int i6, int i7, boolean z5) {
        if (j(i7, z5)) {
            System.arraycopy(this.f3202e, this.f3203f - i7, bArr, i6, i7);
            return true;
        }
        return false;
    }

    @Override // c1.j
    public long m() {
        return this.f3201d + this.f3203f;
    }

    @Override // c1.j
    public void n(byte[] bArr, int i6, int i7) {
        l(bArr, i6, i7, false);
    }

    @Override // c1.j
    public void o(int i6) {
        j(i6, false);
    }

    @Override // c1.j
    public long p() {
        return this.f3201d;
    }

    @Override // c1.j, q2.h
    public int read(byte[] bArr, int i6, int i7) {
        int s5 = s(bArr, i6, i7);
        if (s5 == 0) {
            s5 = t(bArr, i6, i7, 0, true);
        }
        q(s5);
        return s5;
    }

    @Override // c1.j
    public void readFully(byte[] bArr, int i6, int i7) {
        d(bArr, i6, i7, false);
    }

    public boolean v(int i6, boolean z5) {
        int u5 = u(i6);
        while (u5 < i6 && u5 != -1) {
            u5 = t(this.f3198a, -u5, Math.min(i6, this.f3198a.length + u5), u5, z5);
        }
        q(u5);
        return u5 != -1;
    }
}
