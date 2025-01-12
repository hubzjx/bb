package c;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$f implements j$g {

    /* renamed from: a  reason: collision with root package name */
    private final j$g[] f3051a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3052b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j$f(List list, boolean z5) {
        this((j$g[]) r2.toArray(new j$g[r2.size()]), z5);
        ArrayList arrayList = (ArrayList) list;
    }

    j$f(j$g[] j_gArr, boolean z5) {
        this.f3051a = j_gArr;
        this.f3052b = z5;
    }

    @Override // c.j$g
    public final boolean a(j$r j_r, StringBuilder sb) {
        int length = sb.length();
        boolean z5 = this.f3052b;
        if (z5) {
            j_r.g();
        }
        try {
            for (j$g j_g : this.f3051a) {
                if (!j_g.a(j_r, sb)) {
                    sb.setLength(length);
                    return true;
                }
            }
            if (z5) {
                j_r.a();
            }
            return true;
        } finally {
            if (z5) {
                j_r.a();
            }
        }
    }

    public final j$f b() {
        return !this.f3052b ? this : new j$f(this.f3051a, false);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        j$g[] j_gArr = this.f3051a;
        if (j_gArr != null) {
            boolean z5 = this.f3052b;
            sb.append(z5 ? "[" : "(");
            for (j$g j_g : j_gArr) {
                sb.append(j_g);
            }
            sb.append(z5 ? "]" : ")");
        }
        return sb.toString();
    }
}
