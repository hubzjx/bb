package g1;

import c1.j;
import com.google.android.exoplayer2.util.y;
import okhttp3.internal.ws.RealWebSocket;
/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private final y f10406a = new y(8);

    /* renamed from: b  reason: collision with root package name */
    private int f10407b;

    private long a(j jVar) {
        int i6 = 0;
        jVar.n(this.f10406a.c(), 0, 1);
        int i7 = this.f10406a.c()[0] & 255;
        if (i7 == 0) {
            return Long.MIN_VALUE;
        }
        int i8 = 128;
        int i9 = 0;
        while ((i7 & i8) == 0) {
            i8 >>= 1;
            i9++;
        }
        int i10 = i7 & (~i8);
        jVar.n(this.f10406a.c(), 1, i9);
        while (i6 < i9) {
            i6++;
            i10 = (this.f10406a.c()[i6] & 255) + (i10 << 8);
        }
        this.f10407b += i9 + 1;
        return i10;
    }

    public boolean b(j jVar) {
        long a6;
        int i6;
        long a7 = jVar.a();
        long j6 = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        int i7 = (a7 > (-1L) ? 1 : (a7 == (-1L) ? 0 : -1));
        if (i7 != 0 && a7 <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j6 = a7;
        }
        int i8 = (int) j6;
        jVar.n(this.f10406a.c(), 0, 4);
        long C = this.f10406a.C();
        this.f10407b = 4;
        while (C != 440786851) {
            int i9 = this.f10407b + 1;
            this.f10407b = i9;
            if (i9 == i8) {
                return false;
            }
            jVar.n(this.f10406a.c(), 0, 1);
            C = ((C << 8) & (-256)) | (this.f10406a.c()[0] & 255);
        }
        long a8 = a(jVar);
        long j7 = this.f10407b;
        if (a8 == Long.MIN_VALUE) {
            return false;
        }
        if (i7 != 0 && j7 + a8 >= a7) {
            return false;
        }
        while (true) {
            int i10 = this.f10407b;
            long j8 = j7 + a8;
            if (i10 >= j8) {
                return ((long) i10) == j8;
            } else if (a(jVar) != Long.MIN_VALUE && (a(jVar)) >= 0 && a6 <= 2147483647L) {
                if (i6 != 0) {
                    int i11 = (int) a6;
                    jVar.o(i11);
                    this.f10407b += i11;
                }
            }
        }
    }
}
