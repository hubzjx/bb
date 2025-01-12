package c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$e implements j$g {

    /* renamed from: a  reason: collision with root package name */
    private final char f3050a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$e(char c6) {
        this.f3050a = c6;
    }

    @Override // c.j$g
    public final boolean a(j$r j_r, StringBuilder sb) {
        sb.append(this.f3050a);
        return true;
    }

    public final String toString() {
        char c6 = this.f3050a;
        if (c6 == '\'') {
            return "''";
        }
        return "'" + c6 + "'";
    }
}
