package o3;

import com.google.gson.l;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
final class b extends p {

    /* renamed from: b  reason: collision with root package name */
    static final q f12483b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f12484a;

    /* loaded from: classes.dex */
    class a implements q {
        a() {
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == Time.class) {
                return new b(null);
            }
            return null;
        }
    }

    private b() {
        this.f12484a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.p
    /* renamed from: e */
    public synchronized Time b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Time(this.f12484a.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e6) {
            throw new l(e6);
        }
    }

    @Override // com.google.gson.p
    /* renamed from: f */
    public synchronized void d(JsonWriter jsonWriter, Time time) {
        jsonWriter.value(time == null ? null : this.f12484a.format((Date) time));
    }

    /* synthetic */ b(a aVar) {
        this();
    }
}
