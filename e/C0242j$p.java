package e;

import java.util.NoSuchElementException;
/* renamed from: e.j$p  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0242j$p {

    /* renamed from: c  reason: collision with root package name */
    private static final C0242j$p f9312c = new C0242j$p();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9313a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9314b;

    private C0242j$p() {
        this.f9313a = false;
        this.f9314b = 0L;
    }

    private C0242j$p(long j6) {
        this.f9313a = true;
        this.f9314b = j6;
    }

    public static C0242j$p a() {
        return f9312c;
    }

    public static C0242j$p d(long j6) {
        return new C0242j$p(j6);
    }

    public final long b() {
        if (this.f9313a) {
            return this.f9314b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f9313a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0242j$p) {
            C0242j$p c0242j$p = (C0242j$p) obj;
            boolean z5 = this.f9313a;
            if (z5 && c0242j$p.f9313a) {
                if (this.f9314b == c0242j$p.f9314b) {
                    return true;
                }
            } else if (z5 == c0242j$p.f9313a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9313a) {
            long j6 = this.f9314b;
            return (int) (j6 ^ (j6 >>> 32));
        }
        return 0;
    }

    public final String toString() {
        return this.f9313a ? String.format("OptionalLong[%s]", Long.valueOf(this.f9314b)) : "OptionalLong.empty";
    }
}
