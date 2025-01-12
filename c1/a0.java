package c1;

import com.google.android.exoplayer2.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public interface a0 {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f3156a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f3157b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3158c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3159d;

        public a(int i6, byte[] bArr, int i7, int i8) {
            this.f3156a = i6;
            this.f3157b = bArr;
            this.f3158c = i7;
            this.f3159d = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3156a == aVar.f3156a && this.f3158c == aVar.f3158c && this.f3159d == aVar.f3159d && Arrays.equals(this.f3157b, aVar.f3157b);
        }

        public int hashCode() {
            return (((((this.f3156a * 31) + Arrays.hashCode(this.f3157b)) * 31) + this.f3158c) * 31) + this.f3159d;
        }
    }

    void a(com.google.android.exoplayer2.util.y yVar, int i6);

    int b(q2.h hVar, int i6, boolean z5);

    int c(q2.h hVar, int i6, boolean z5, int i7);

    void d(long j6, int i6, int i7, int i8, a aVar);

    void e(s0 s0Var);

    void f(com.google.android.exoplayer2.util.y yVar, int i6, int i7);
}
