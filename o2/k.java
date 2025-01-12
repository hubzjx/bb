package o2;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f12460a;

    /* renamed from: b  reason: collision with root package name */
    private final j[] f12461b;

    /* renamed from: c  reason: collision with root package name */
    private int f12462c;

    public k(j... jVarArr) {
        this.f12461b = jVarArr;
        this.f12460a = jVarArr.length;
    }

    public j a(int i6) {
        return this.f12461b[i6];
    }

    public j[] b() {
        return (j[]) this.f12461b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f12461b, ((k) obj).f12461b);
    }

    public int hashCode() {
        if (this.f12462c == 0) {
            this.f12462c = 527 + Arrays.hashCode(this.f12461b);
        }
        return this.f12462c;
    }
}
