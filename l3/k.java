package l3;

import com.google.gson.p;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import l3.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends p {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.d f11888a;

    /* renamed from: b  reason: collision with root package name */
    private final p f11889b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f11890c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.google.gson.d dVar, p pVar, Type type) {
        this.f11888a = dVar;
        this.f11889b = pVar;
        this.f11890c = type;
    }

    private Type e(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.p
    public Object b(JsonReader jsonReader) {
        return this.f11889b.b(jsonReader);
    }

    @Override // com.google.gson.p
    public void d(JsonWriter jsonWriter, Object obj) {
        p pVar = this.f11889b;
        Type e6 = e(this.f11890c, obj);
        if (e6 != this.f11890c) {
            pVar = this.f11888a.l(p3.a.b(e6));
            if (pVar instanceof j.b) {
                p pVar2 = this.f11889b;
                if (!(pVar2 instanceof j.b)) {
                    pVar = pVar2;
                }
            }
        }
        pVar.d(jsonWriter, obj);
    }
}
