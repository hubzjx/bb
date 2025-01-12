package a1;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f41d = new a(0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f42a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43b;

    /* renamed from: c  reason: collision with root package name */
    public final int f44c;

    public a(int i6, int i7, int i8) {
        this.f42a = i6;
        this.f43b = i7;
        this.f44c = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f42a == aVar.f42a && this.f43b == aVar.f43b && this.f44c == aVar.f44c;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f42a) * 31) + this.f43b) * 31) + this.f44c;
    }
}
