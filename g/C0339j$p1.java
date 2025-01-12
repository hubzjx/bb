package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$p1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0339j$p1 extends AbstractC0343j$q1 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10240c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f10241d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0339j$p1(j$A0 j_a0, Object obj) {
        this(j_a0, obj, 0);
        this.f10240c = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0339j$p1(j$B0 j_b0, Object obj, int i6) {
        super(j_b0);
        this.f10240c = i6;
        this.f10241d = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0339j$p1(j$B0 j_b0, Object[] objArr) {
        this(j_b0, objArr, 1);
        this.f10240c = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0339j$p1(C0339j$p1 c0339j$p1, j$A0 j_a0, int i6) {
        super(c0339j$p1, j_a0, i6);
        this.f10240c = 0;
        this.f10241d = c0339j$p1.f10241d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0339j$p1(C0339j$p1 c0339j$p1, j$B0 j_b0, int i6) {
        super(c0339j$p1, j_b0, i6);
        this.f10240c = 1;
        this.f10241d = (Object[]) c0339j$p1.f10241d;
    }

    @Override // g.AbstractC0343j$q1
    final void a() {
        switch (this.f10240c) {
            case 0:
                ((j$A0) this.f10248a).u(this.f10249b, this.f10241d);
                return;
            default:
                this.f10248a.p((Object[]) this.f10241d, this.f10249b);
                return;
        }
    }

    @Override // g.AbstractC0343j$q1
    final C0339j$p1 b(int i6, int i7) {
        switch (this.f10240c) {
            case 0:
                return new C0339j$p1(this, ((j$A0) this.f10248a).c(i6), i7);
            default:
                return new C0339j$p1(this, this.f10248a.c(i6), i7);
        }
    }
}
