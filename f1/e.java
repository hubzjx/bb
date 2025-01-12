package f1;

import c1.a0;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected final a0 f9790a;

    /* loaded from: classes.dex */
    public static final class a extends f1 {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(a0 a0Var) {
        this.f9790a = a0Var;
    }

    public final boolean a(y yVar, long j6) {
        return b(yVar) && c(yVar, j6);
    }

    protected abstract boolean b(y yVar);

    protected abstract boolean c(y yVar, long j6);
}
