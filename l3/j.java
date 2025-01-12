package l3;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class j implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.c f11871a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.c f11872b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.internal.d f11873c;

    /* renamed from: d  reason: collision with root package name */
    private final e f11874d;

    /* renamed from: e  reason: collision with root package name */
    private final n3.b f11875e = n3.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Field f11876d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f11877e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ p f11878f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f11879g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ p3.a f11880h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f11881i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z5, boolean z6, Field field, boolean z7, p pVar, com.google.gson.d dVar, p3.a aVar, boolean z8) {
            super(str, z5, z6);
            this.f11876d = field;
            this.f11877e = z7;
            this.f11878f = pVar;
            this.f11879g = dVar;
            this.f11880h = aVar;
            this.f11881i = z8;
        }

        @Override // l3.j.c
        void a(JsonReader jsonReader, Object obj) {
            Object b6 = this.f11878f.b(jsonReader);
            if (b6 == null && this.f11881i) {
                return;
            }
            this.f11876d.set(obj, b6);
        }

        @Override // l3.j.c
        void b(JsonWriter jsonWriter, Object obj) {
            (this.f11877e ? this.f11878f : new k(this.f11879g, this.f11878f, this.f11880h.d())).d(jsonWriter, this.f11876d.get(obj));
        }

        @Override // l3.j.c
        public boolean c(Object obj) {
            return this.f11886b && this.f11876d.get(obj) != obj;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends p {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.gson.internal.i f11883a;

        /* renamed from: b  reason: collision with root package name */
        private final Map f11884b;

        b(com.google.gson.internal.i iVar, Map map) {
            this.f11883a = iVar;
            this.f11884b = map;
        }

        @Override // com.google.gson.p
        public Object b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object a6 = this.f11883a.a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    c cVar = (c) this.f11884b.get(jsonReader.nextName());
                    if (cVar != null && cVar.f11887c) {
                        cVar.a(jsonReader, a6);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return a6;
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (IllegalStateException e7) {
                throw new com.google.gson.l(e7);
            }
        }

        @Override // com.google.gson.p
        public void d(JsonWriter jsonWriter, Object obj) {
            if (obj == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (c cVar : this.f11884b.values()) {
                    if (cVar.c(obj)) {
                        jsonWriter.name(cVar.f11885a);
                        cVar.b(jsonWriter, obj);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f11885a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f11886b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f11887c;

        protected c(String str, boolean z5, boolean z6) {
            this.f11885a = str;
            this.f11886b = z5;
            this.f11887c = z6;
        }

        abstract void a(JsonReader jsonReader, Object obj);

        abstract void b(JsonWriter jsonWriter, Object obj);

        abstract boolean c(Object obj);
    }

    public j(com.google.gson.internal.c cVar, com.google.gson.c cVar2, com.google.gson.internal.d dVar, e eVar) {
        this.f11871a = cVar;
        this.f11872b = cVar2;
        this.f11873c = dVar;
        this.f11874d = eVar;
    }

    private c b(com.google.gson.d dVar, Field field, String str, p3.a aVar, boolean z5, boolean z6) {
        boolean a6 = com.google.gson.internal.k.a(aVar.c());
        k3.b bVar = (k3.b) field.getAnnotation(k3.b.class);
        p b6 = bVar != null ? this.f11874d.b(this.f11871a, dVar, aVar, bVar) : null;
        boolean z7 = b6 != null;
        if (b6 == null) {
            b6 = dVar.l(aVar);
        }
        return new a(str, z5, z6, field, z7, b6, dVar, aVar, a6);
    }

    static boolean d(Field field, boolean z5, com.google.gson.internal.d dVar) {
        return (dVar.c(field.getType(), z5) || dVar.f(field, z5)) ? false : true;
    }

    private Map e(com.google.gson.d dVar, p3.a aVar, Class cls) {
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type d6 = aVar.d();
        p3.a aVar2 = aVar;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z5 = false;
            int i6 = 0;
            while (i6 < length) {
                Field field = declaredFields[i6];
                boolean c6 = c(field, true);
                boolean c7 = c(field, z5);
                if (c6 || c7) {
                    this.f11875e.b(field);
                    Type p5 = com.google.gson.internal.b.p(aVar2.d(), cls2, field.getGenericType());
                    List f6 = f(field);
                    int size = f6.size();
                    c cVar2 = null;
                    int i7 = 0;
                    while (i7 < size) {
                        String str = (String) f6.get(i7);
                        boolean z6 = i7 != 0 ? false : c6;
                        int i8 = i7;
                        c cVar3 = cVar2;
                        int i9 = size;
                        List list = f6;
                        Field field2 = field;
                        cVar2 = cVar3 == null ? (c) linkedHashMap.put(str, b(dVar, field, str, p3.a.b(p5), z6, c7)) : cVar3;
                        i7 = i8 + 1;
                        c6 = z6;
                        f6 = list;
                        size = i9;
                        field = field2;
                    }
                    if (cVar2 != null) {
                        throw new IllegalArgumentException(d6 + " declares multiple JSON fields named " + cVar.f11885a);
                    }
                }
                i6++;
                z5 = false;
            }
            aVar2 = p3.a.b(com.google.gson.internal.b.p(aVar2.d(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.c();
        }
        return linkedHashMap;
    }

    private List f(Field field) {
        k3.c cVar = (k3.c) field.getAnnotation(k3.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f11872b.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.q
    public p a(com.google.gson.d dVar, p3.a aVar) {
        Class c6 = aVar.c();
        if (Object.class.isAssignableFrom(c6)) {
            return new b(this.f11871a.a(aVar), e(dVar, aVar, c6));
        }
        return null;
    }

    public boolean c(Field field, boolean z5) {
        return d(field, z5, this.f11873c);
    }
}
