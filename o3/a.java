package o3;

import com.google.gson.l;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
final class a extends p {

    /* renamed from: b  reason: collision with root package name */
    static final q f12481b = new C0203a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f12482a;

    /* renamed from: o3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0203a implements q {
        C0203a() {
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == Date.class) {
                return new a(null);
            }
            return null;
        }
    }

    private a() {
        this.f12482a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.p
    /* renamed from: e */
    public synchronized Date b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Date(this.f12482a.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e6) {
            throw new l(e6);
        }
    }

    @Override // com.google.gson.p
    /* renamed from: f */
    public synchronized void d(JsonWriter jsonWriter, Date date) {
        jsonWriter.value(date == null ? null : this.f12482a.format((java.util.Date) date));
    }

    /* synthetic */ a(C0203a c0203a) {
        this();
    }
}
