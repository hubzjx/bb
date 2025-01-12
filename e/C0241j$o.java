package e;

import java.util.NoSuchElementException;
/* renamed from: e.j$o  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0241j$o {

    /* renamed from: c  reason: collision with root package name */
    private static final C0241j$o f9309c = new C0241j$o();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9310a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9311b;

    private C0241j$o() {
        this.f9310a = false;
        this.f9311b = 0;
    }

    private C0241j$o(int i6) {
        this.f9310a = true;
        this.f9311b = i6;
    }

    public static C0241j$o a() {
        return f9309c;
    }

    public static C0241j$o d(int i6) {
        return new C0241j$o(i6);
    }

    public final int b() {
        if (this.f9310a) {
            return this.f9311b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f9310a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0241j$o) {
            C0241j$o c0241j$o = (C0241j$o) obj;
            boolean z5 = this.f9310a;
            if (z5 && c0241j$o.f9310a) {
                if (this.f9311b == c0241j$o.f9311b) {
                    return true;
                }
            } else if (z5 == c0241j$o.f9310a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9310a) {
            return this.f9311b;
        }
        return 0;
    }

    public final String toString() {
        return this.f9310a ? String.format("OptionalInt[%s]", Integer.valueOf(this.f9311b)) : "OptionalInt.empty";
    }
}
