package r4;

import kotlin.jvm.internal.g;
/* loaded from: classes.dex */
public final class c extends r4.a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f13061e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final c f13062f = new c(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f13062f;
        }
    }

    public c(int i6, int i7) {
        super(i6, i7, 1);
    }

    @Override // r4.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i6) {
        return a() <= i6 && i6 <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // r4.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // r4.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // r4.a
    public String toString() {
        return a() + ".." + b();
    }
}
