package q2;

import q2.a0;
/* loaded from: classes.dex */
public final class v extends a0.a {

    /* renamed from: b  reason: collision with root package name */
    private final String f12887b;

    /* renamed from: c  reason: collision with root package name */
    private final i0 f12888c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12889d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12890e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12891f;

    public v(String str) {
        this(str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q2.a0.a
    /* renamed from: c */
    public u b(a0.f fVar) {
        u uVar = new u(this.f12887b, this.f12889d, this.f12890e, this.f12891f, fVar);
        i0 i0Var = this.f12888c;
        if (i0Var != null) {
            uVar.i(i0Var);
        }
        return uVar;
    }

    public v(String str, i0 i0Var) {
        this(str, i0Var, 8000, 8000, false);
    }

    public v(String str, i0 i0Var, int i6, int i7, boolean z5) {
        this.f12887b = com.google.android.exoplayer2.util.a.d(str);
        this.f12888c = i0Var;
        this.f12889d = i6;
        this.f12890e = i7;
        this.f12891f = z5;
    }
}
