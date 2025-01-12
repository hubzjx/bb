package b1;

import okhttp3.CacheControl;
import okhttp3.Call;
import q2.a0;
import q2.i0;
/* loaded from: classes.dex */
public final class b extends a0.a {

    /* renamed from: b  reason: collision with root package name */
    private final Call.Factory f2905b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2906c;

    /* renamed from: d  reason: collision with root package name */
    private final i0 f2907d;

    /* renamed from: e  reason: collision with root package name */
    private final CacheControl f2908e;

    public b(Call.Factory factory, String str) {
        this(factory, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q2.a0.a
    /* renamed from: c */
    public a b(a0.f fVar) {
        a aVar = new a(this.f2905b, this.f2906c, this.f2908e, fVar);
        i0 i0Var = this.f2907d;
        if (i0Var != null) {
            aVar.i(i0Var);
        }
        return aVar;
    }

    public b(Call.Factory factory, String str, i0 i0Var, CacheControl cacheControl) {
        this.f2905b = factory;
        this.f2906c = str;
        this.f2907d = i0Var;
        this.f2908e = cacheControl;
    }
}
