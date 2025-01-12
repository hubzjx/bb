package l3;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class g implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.c f11856a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f11857b;

    /* loaded from: classes.dex */
    private final class a extends p {

        /* renamed from: a  reason: collision with root package name */
        private final p f11858a;

        /* renamed from: b  reason: collision with root package name */
        private final p f11859b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.gson.internal.i f11860c;

        public a(com.google.gson.d dVar, Type type, p pVar, Type type2, p pVar2, com.google.gson.internal.i iVar) {
            this.f11858a = new k(dVar, pVar, type);
            this.f11859b = new k(dVar, pVar2, type2);
            this.f11860c = iVar;
        }

        private String e(com.google.gson.f fVar) {
            if (!fVar.g()) {
                if (fVar.e()) {
                    return "null";
                }
                throw new AssertionError();
            }
            com.google.gson.k c6 = fVar.c();
            if (c6.m()) {
                return String.valueOf(c6.i());
            }
            if (c6.k()) {
                return Boolean.toString(c6.h());
            }
            if (c6.n()) {
                return c6.j();
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public Map b(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map map = (Map) this.f11860c.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    Object b6 = this.f11858a.b(jsonReader);
                    if (map.put(b6, this.f11859b.b(jsonReader)) != null) {
                        throw new com.google.gson.l("duplicate key: " + b6);
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    com.google.gson.internal.f.INSTANCE.promoteNameToValue(jsonReader);
                    Object b7 = this.f11858a.b(jsonReader);
                    if (map.put(b7, this.f11859b.b(jsonReader)) != null) {
                        throw new com.google.gson.l("duplicate key: " + b7);
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        @Override // com.google.gson.p
        /* renamed from: g */
        public void d(JsonWriter jsonWriter, Map map) {
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!g.this.f11857b) {
                jsonWriter.beginObject();
                for (Map.Entry entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f11859b.d(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i6 = 0;
                boolean z5 = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    com.google.gson.f c6 = this.f11858a.c(entry2.getKey());
                    arrayList.add(c6);
                    arrayList2.add(entry2.getValue());
                    z5 |= c6.d() || c6.f();
                }
                if (!z5) {
                    jsonWriter.beginObject();
                    int size = arrayList.size();
                    while (i6 < size) {
                        jsonWriter.name(e((com.google.gson.f) arrayList.get(i6)));
                        this.f11859b.d(jsonWriter, arrayList2.get(i6));
                        i6++;
                    }
                    jsonWriter.endObject();
                    return;
                }
                jsonWriter.beginArray();
                int size2 = arrayList.size();
                while (i6 < size2) {
                    jsonWriter.beginArray();
                    com.google.gson.internal.l.a((com.google.gson.f) arrayList.get(i6), jsonWriter);
                    this.f11859b.d(jsonWriter, arrayList2.get(i6));
                    jsonWriter.endArray();
                    i6++;
                }
                jsonWriter.endArray();
            }
        }
    }

    public g(com.google.gson.internal.c cVar, boolean z5) {
        this.f11856a = cVar;
        this.f11857b = z5;
    }

    private p b(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? l.f11896f : dVar.l(p3.a.b(type));
    }

    @Override // com.google.gson.q
    public p a(com.google.gson.d dVar, p3.a aVar) {
        Type d6 = aVar.d();
        if (Map.class.isAssignableFrom(aVar.c())) {
            Type[] j6 = com.google.gson.internal.b.j(d6, com.google.gson.internal.b.k(d6));
            return new a(dVar, j6[0], b(dVar, j6[0]), j6[1], dVar.l(p3.a.b(j6[1])), this.f11856a.a(aVar));
        }
        return null;
    }
}
