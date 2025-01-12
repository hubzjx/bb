package o3;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;
/* loaded from: classes.dex */
class c extends p {

    /* renamed from: b  reason: collision with root package name */
    static final q f12485b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final p f12486a;

    /* loaded from: classes.dex */
    class a implements q {
        a() {
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == Timestamp.class) {
                return new c(dVar.k(Date.class), null);
            }
            return null;
        }
    }

    private c(p pVar) {
        this.f12486a = pVar;
    }

    @Override // com.google.gson.p
    /* renamed from: e */
    public Timestamp b(JsonReader jsonReader) {
        Date date = (Date) this.f12486a.b(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.p
    /* renamed from: f */
    public void d(JsonWriter jsonWriter, Timestamp timestamp) {
        this.f12486a.d(jsonWriter, timestamp);
    }

    /* synthetic */ c(p pVar, a aVar) {
        this(pVar);
    }
}
