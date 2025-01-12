package o2;

import com.google.android.exoplayer2.s0;
import java.util.List;
import w1.x0;
/* loaded from: classes.dex */
public interface j {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final x0 f12456a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f12457b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12458c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f12459d;

        public a(x0 x0Var, int... iArr) {
            this(x0Var, iArr, 0, null);
        }

        public a(x0 x0Var, int[] iArr, int i6, Object obj) {
            this.f12456a = x0Var;
            this.f12457b = iArr;
            this.f12458c = i6;
            this.f12459d = obj;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        j[] a(a[] aVarArr, q2.e eVar);
    }

    boolean a(int i6, long j6);

    void b(long j6, long j7, long j8, List list, y1.n[] nVarArr);

    s0 c(int i6);

    void d();

    void e();

    int f(int i6);

    int g(long j6, List list);

    int h(s0 s0Var);

    boolean i(long j6, y1.e eVar, List list);

    int j();

    x0 k();

    s0 l();

    int length();

    int m();

    int n();

    void o(float f6);

    Object p();

    void q();

    int r(int i6);
}
