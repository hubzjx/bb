package l3;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a extends p {

    /* renamed from: c  reason: collision with root package name */
    public static final q f11840c = new C0192a();

    /* renamed from: a  reason: collision with root package name */
    private final Class f11841a;

    /* renamed from: b  reason: collision with root package name */
    private final p f11842b;

    /* renamed from: l3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0192a implements q {
        C0192a() {
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            Type d6 = aVar.d();
            if ((d6 instanceof GenericArrayType) || ((d6 instanceof Class) && ((Class) d6).isArray())) {
                Type g6 = com.google.gson.internal.b.g(d6);
                return new a(dVar, dVar.l(p3.a.b(g6)), com.google.gson.internal.b.k(g6));
            }
            return null;
        }
    }

    public a(com.google.gson.d dVar, p pVar, Class cls) {
        this.f11842b = new k(dVar, pVar, cls);
        this.f11841a = cls;
    }

    @Override // com.google.gson.p
    public Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f11842b.b(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Object newInstance = Array.newInstance(this.f11841a, size);
        for (int i6 = 0; i6 < size; i6++) {
            Array.set(newInstance, i6, arrayList.get(i6));
        }
        return newInstance;
    }

    @Override // com.google.gson.p
    public void d(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i6 = 0; i6 < length; i6++) {
            this.f11842b.d(jsonWriter, Array.get(obj, i6));
        }
        jsonWriter.endArray();
    }
}
