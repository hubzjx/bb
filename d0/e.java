package d0;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9111a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f9112b;

    public e(Object obj, Object obj2) {
        this.f9111a = obj;
        this.f9112b = obj2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return d.a(eVar.f9111a, this.f9111a) && d.a(eVar.f9112b, this.f9112b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f9111a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f9112b;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f9111a + " " + this.f9112b + "}";
    }
}
