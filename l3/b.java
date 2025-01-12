package l3;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes.dex */
public final class b implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.c f11843a;

    /* loaded from: classes.dex */
    private static final class a extends p {

        /* renamed from: a  reason: collision with root package name */
        private final p f11844a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.gson.internal.i f11845b;

        public a(com.google.gson.d dVar, Type type, p pVar, com.google.gson.internal.i iVar) {
            this.f11844a = new k(dVar, pVar, type);
            this.f11845b = iVar;
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Collection b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection collection = (Collection) this.f11845b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f11844a.b(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Collection collection) {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (Object obj : collection) {
                this.f11844a.d(jsonWriter, obj);
            }
            jsonWriter.endArray();
        }
    }

    public b(com.google.gson.internal.c cVar) {
        this.f11843a = cVar;
    }

    @Override // com.google.gson.q
    public p a(com.google.gson.d dVar, p3.a aVar) {
        Type d6 = aVar.d();
        Class c6 = aVar.c();
        if (Collection.class.isAssignableFrom(c6)) {
            Type h6 = com.google.gson.internal.b.h(d6, c6);
            return new a(dVar, h6, dVar.l(p3.a.b(h6)), this.f11843a.a(aVar));
        }
        return null;
    }
}
