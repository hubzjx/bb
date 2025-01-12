package w1;

import android.os.Handler;
import com.google.android.exoplayer2.y1;
/* loaded from: classes.dex */
public interface v {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f14051a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14052b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14053c;

        /* renamed from: d  reason: collision with root package name */
        public final long f14054d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14055e;

        public a(Object obj) {
            this(obj, -1L);
        }

        public a a(Object obj) {
            return this.f14051a.equals(obj) ? this : new a(obj, this.f14052b, this.f14053c, this.f14054d, this.f14055e);
        }

        public boolean b() {
            return this.f14052b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f14051a.equals(aVar.f14051a) && this.f14052b == aVar.f14052b && this.f14053c == aVar.f14053c && this.f14054d == aVar.f14054d && this.f14055e == aVar.f14055e;
        }

        public int hashCode() {
            return ((((((((527 + this.f14051a.hashCode()) * 31) + this.f14052b) * 31) + this.f14053c) * 31) + ((int) this.f14054d)) * 31) + this.f14055e;
        }

        public a(Object obj, int i6, int i7, long j6) {
            this(obj, i6, i7, j6, -1);
        }

        private a(Object obj, int i6, int i7, long j6, int i8) {
            this.f14051a = obj;
            this.f14052b = i6;
            this.f14053c = i7;
            this.f14054d = j6;
            this.f14055e = i8;
        }

        public a(Object obj, long j6) {
            this(obj, -1, -1, j6, -1);
        }

        public a(Object obj, long j6, int i6) {
            this(obj, -1, -1, j6, i6);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(v vVar, y1 y1Var);
    }

    com.google.android.exoplayer2.w0 a();

    void b(b bVar);

    void c(b bVar);

    void d(Handler handler, com.google.android.exoplayer2.drm.t tVar);

    void e();

    boolean f();

    y1 g();

    void i(t tVar);

    void j(b bVar);

    void l(b bVar, q2.i0 i0Var);

    void n(Handler handler, e0 e0Var);

    t o(a aVar, q2.b bVar, long j6);

    void r(e0 e0Var);
}
