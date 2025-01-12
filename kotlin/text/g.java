package kotlin.text;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f11345a;

    /* renamed from: b  reason: collision with root package name */
    private final r4.c f11346b;

    public g(String str, r4.c cVar) {
        kotlin.jvm.internal.l.d(str, "value");
        kotlin.jvm.internal.l.d(cVar, "range");
        this.f11345a = str;
        this.f11346b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return kotlin.jvm.internal.l.a(this.f11345a, gVar.f11345a) && kotlin.jvm.internal.l.a(this.f11346b, gVar.f11346b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f11345a.hashCode() * 31) + this.f11346b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f11345a + ", range=" + this.f11346b + ')';
    }
}
