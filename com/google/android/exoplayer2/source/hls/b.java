package com.google.android.exoplayer2.source.hls;

import c1.w;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.k0;
import l1.h0;
/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: d  reason: collision with root package name */
    private static final w f4256d = new w();

    /* renamed from: a  reason: collision with root package name */
    final c1.i f4257a;

    /* renamed from: b  reason: collision with root package name */
    private final s0 f4258b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f4259c;

    public b(c1.i iVar, s0 s0Var, k0 k0Var) {
        this.f4257a = iVar;
        this.f4258b = s0Var;
        this.f4259c = k0Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean b(c1.j jVar) {
        return this.f4257a.g(jVar, f4256d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public void c(c1.k kVar) {
        this.f4257a.c(kVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean d() {
        c1.i iVar = this.f4257a;
        return (iVar instanceof l1.h) || (iVar instanceof l1.b) || (iVar instanceof l1.e) || (iVar instanceof h1.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean e() {
        c1.i iVar = this.f4257a;
        return (iVar instanceof h0) || (iVar instanceof i1.g);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public k f() {
        c1.i fVar;
        com.google.android.exoplayer2.util.a.g(!e());
        c1.i iVar = this.f4257a;
        if (iVar instanceof u) {
            fVar = new u(this.f4258b.f4047c, this.f4259c);
        } else if (iVar instanceof l1.h) {
            fVar = new l1.h();
        } else if (iVar instanceof l1.b) {
            fVar = new l1.b();
        } else if (iVar instanceof l1.e) {
            fVar = new l1.e();
        } else if (!(iVar instanceof h1.f)) {
            String simpleName = this.f4257a.getClass().getSimpleName();
            throw new IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new String("Unexpected extractor type for recreation: "));
        } else {
            fVar = new h1.f();
        }
        return new b(fVar, this.f4258b, this.f4259c);
    }
}
