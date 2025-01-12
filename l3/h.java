package l3;

import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* loaded from: classes.dex */
public final class h extends p {

    /* renamed from: b  reason: collision with root package name */
    private static final q f11862b = f(n.LAZILY_PARSED_NUMBER);

    /* renamed from: a  reason: collision with root package name */
    private final o f11863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements q {
        a() {
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == Number.class) {
                return h.this;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11865a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f11865a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11865a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11865a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private h(o oVar) {
        this.f11863a = oVar;
    }

    public static q e(o oVar) {
        return oVar == n.LAZILY_PARSED_NUMBER ? f11862b : f(oVar);
    }

    private static q f(o oVar) {
        return new a();
    }

    @Override // com.google.gson.p
    /* renamed from: g */
    public Number b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        int i6 = b.f11865a[peek.ordinal()];
        if (i6 == 1) {
            jsonReader.nextNull();
            return null;
        } else if (i6 == 2 || i6 == 3) {
            return this.f11863a.readNumber(jsonReader);
        } else {
            throw new com.google.gson.l("Expecting number, got: " + peek);
        }
    }

    @Override // com.google.gson.p
    /* renamed from: h */
    public void d(JsonWriter jsonWriter, Number number) {
        jsonWriter.value(number);
    }
}
