package l3;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public final class c extends p {

    /* renamed from: b  reason: collision with root package name */
    public static final q f11846b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List f11847a;

    /* loaded from: classes.dex */
    class a implements q {
        a() {
        }

        @Override // com.google.gson.q
        public p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f11847a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.e.e()) {
            arrayList.add(com.google.gson.internal.j.c(2, 2));
        }
    }

    private synchronized Date e(String str) {
        for (DateFormat dateFormat : this.f11847a) {
            try {
                return dateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return m3.a.c(str, new ParsePosition(0));
        } catch (ParseException e6) {
            throw new com.google.gson.l(str, e6);
        }
    }

    @Override // com.google.gson.p
    /* renamed from: f */
    public Date b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return e(jsonReader.nextString());
    }

    @Override // com.google.gson.p
    /* renamed from: g */
    public synchronized void d(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(((DateFormat) this.f11847a.get(0)).format(date));
        }
    }
}
