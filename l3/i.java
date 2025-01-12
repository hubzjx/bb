package l3;

import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i extends p {

    /* renamed from: c  reason: collision with root package name */
    private static final q f11866c = f(n.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.d f11867a;

    /* renamed from: b  reason: collision with root package name */
    private final o f11868b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f11869a;

        a(o oVar) {
            this.f11869a = oVar;
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == Object.class) {
                return new i(dVar, this.f11869a, null);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11870a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f11870a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11870a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11870a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11870a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11870a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11870a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private i(com.google.gson.d dVar, o oVar) {
        this.f11867a = dVar;
        this.f11868b = oVar;
    }

    public static q e(o oVar) {
        return oVar == n.DOUBLE ? f11866c : f(oVar);
    }

    private static q f(o oVar) {
        return new a(oVar);
    }

    @Override // com.google.gson.p
    public Object b(JsonReader jsonReader) {
        switch (b.f11870a[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(b(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                com.google.gson.internal.h hVar = new com.google.gson.internal.h();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    hVar.put(jsonReader.nextName(), b(jsonReader));
                }
                jsonReader.endObject();
                return hVar;
            case 3:
                return jsonReader.nextString();
            case 4:
                return this.f11868b.readNumber(jsonReader);
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.p
    public void d(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        p k6 = this.f11867a.k(obj.getClass());
        if (!(k6 instanceof i)) {
            k6.d(jsonWriter, obj);
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.endObject();
    }

    /* synthetic */ i(com.google.gson.d dVar, o oVar, a aVar) {
        this(dVar, oVar);
    }
}
