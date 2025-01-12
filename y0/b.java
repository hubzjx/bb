package y0;

import com.google.android.exoplayer2.y1;
import com.google.common.base.h;
import w1.v;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f14244a;

    /* renamed from: b  reason: collision with root package name */
    public final y1 f14245b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14246c;

    /* renamed from: d  reason: collision with root package name */
    public final v.a f14247d;

    /* renamed from: e  reason: collision with root package name */
    public final long f14248e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f14249f;

    /* renamed from: g  reason: collision with root package name */
    public final int f14250g;

    /* renamed from: h  reason: collision with root package name */
    public final v.a f14251h;

    /* renamed from: i  reason: collision with root package name */
    public final long f14252i;

    /* renamed from: j  reason: collision with root package name */
    public final long f14253j;

    public b(long j6, y1 y1Var, int i6, v.a aVar, long j7, y1 y1Var2, int i7, v.a aVar2, long j8, long j9) {
        this.f14244a = j6;
        this.f14245b = y1Var;
        this.f14246c = i6;
        this.f14247d = aVar;
        this.f14248e = j7;
        this.f14249f = y1Var2;
        this.f14250g = i7;
        this.f14251h = aVar2;
        this.f14252i = j8;
        this.f14253j = j9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14244a == bVar.f14244a && this.f14246c == bVar.f14246c && this.f14248e == bVar.f14248e && this.f14250g == bVar.f14250g && this.f14252i == bVar.f14252i && this.f14253j == bVar.f14253j && h.a(this.f14245b, bVar.f14245b) && h.a(this.f14247d, bVar.f14247d) && h.a(this.f14249f, bVar.f14249f) && h.a(this.f14251h, bVar.f14251h);
    }

    public int hashCode() {
        return h.b(Long.valueOf(this.f14244a), this.f14245b, Integer.valueOf(this.f14246c), this.f14247d, Long.valueOf(this.f14248e), this.f14249f, Integer.valueOf(this.f14250g), this.f14251h, Long.valueOf(this.f14252i), Long.valueOf(this.f14253j));
    }
}
