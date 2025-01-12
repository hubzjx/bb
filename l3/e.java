package l3;

import com.google.gson.p;
import com.google.gson.q;
/* loaded from: classes.dex */
public final class e implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.c f11850a;

    public e(com.google.gson.internal.c cVar) {
        this.f11850a = cVar;
    }

    @Override // com.google.gson.q
    public p a(com.google.gson.d dVar, p3.a aVar) {
        k3.b bVar = (k3.b) aVar.c().getAnnotation(k3.b.class);
        if (bVar == null) {
            return null;
        }
        return b(this.f11850a, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p b(com.google.gson.internal.c cVar, com.google.gson.d dVar, p3.a aVar, k3.b bVar) {
        p a6;
        Object a7 = cVar.a(p3.a.a(bVar.value())).a();
        if (a7 instanceof p) {
            a6 = (p) a7;
        } else if (!(a7 instanceof q)) {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a7.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        } else {
            a6 = ((q) a7).a(dVar, aVar);
        }
        return (a6 == null || !bVar.nullSafe()) ? a6 : a6.a();
    }
}
