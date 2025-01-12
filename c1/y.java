package c1;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: c  reason: collision with root package name */
    public static final y f3252c = new y(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f3253a;

    /* renamed from: b  reason: collision with root package name */
    public final long f3254b;

    public y(long j6, long j7) {
        this.f3253a = j6;
        this.f3254b = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.f3253a == yVar.f3253a && this.f3254b == yVar.f3254b;
    }

    public int hashCode() {
        return (((int) this.f3253a) * 31) + ((int) this.f3254b);
    }

    public String toString() {
        long j6 = this.f3253a;
        long j7 = this.f3254b;
        StringBuilder sb = new StringBuilder(60);
        sb.append("[timeUs=");
        sb.append(j6);
        sb.append(", position=");
        sb.append(j7);
        sb.append("]");
        return sb.toString();
    }
}
