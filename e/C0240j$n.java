package e;

import java.util.NoSuchElementException;
/* renamed from: e.j$n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0240j$n {

    /* renamed from: c  reason: collision with root package name */
    private static final C0240j$n f9306c = new C0240j$n();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9307a;

    /* renamed from: b  reason: collision with root package name */
    private final double f9308b;

    private C0240j$n() {
        this.f9307a = false;
        this.f9308b = Double.NaN;
    }

    private C0240j$n(double d6) {
        this.f9307a = true;
        this.f9308b = d6;
    }

    public static C0240j$n a() {
        return f9306c;
    }

    public static C0240j$n d(double d6) {
        return new C0240j$n(d6);
    }

    public final double b() {
        if (this.f9307a) {
            return this.f9308b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f9307a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0240j$n) {
            C0240j$n c0240j$n = (C0240j$n) obj;
            boolean z5 = this.f9307a;
            if (z5 && c0240j$n.f9307a) {
                if (Double.compare(this.f9308b, c0240j$n.f9308b) == 0) {
                    return true;
                }
            } else if (z5 == c0240j$n.f9307a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9307a) {
            long doubleToLongBits = Double.doubleToLongBits(this.f9308b);
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
        return 0;
    }

    public final String toString() {
        return this.f9307a ? String.format("OptionalDouble[%s]", Double.valueOf(this.f9308b)) : "OptionalDouble.empty";
    }
}
