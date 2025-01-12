package q2;

import com.google.android.exoplayer2.f1;
import java.io.FileNotFoundException;
import java.io.IOException;
import q2.a0;
import q2.c0;
import q2.d0;
/* loaded from: classes.dex */
public class w implements c0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f12892a;

    public w() {
        this(-1);
    }

    @Override // q2.c0
    public /* synthetic */ void a(long j6) {
        b0.a(this, j6);
    }

    @Override // q2.c0
    public long b(c0.a aVar) {
        IOException iOException = aVar.f12720c;
        if ((iOException instanceof f1) || (iOException instanceof FileNotFoundException) || (iOException instanceof d0.h)) {
            return -9223372036854775807L;
        }
        return Math.min((aVar.f12721d - 1) * 1000, 5000);
    }

    @Override // q2.c0
    public long c(c0.a aVar) {
        IOException iOException = aVar.f12720c;
        if (iOException instanceof a0.e) {
            int i6 = ((a0.e) iOException).responseCode;
            return (i6 == 403 || i6 == 404 || i6 == 410 || i6 == 416 || i6 == 500 || i6 == 503) ? 60000L : -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // q2.c0
    public int d(int i6) {
        int i7 = this.f12892a;
        return i7 == -1 ? i6 == 7 ? 6 : 3 : i7;
    }

    public w(int i6) {
        this.f12892a = i6;
    }
}
