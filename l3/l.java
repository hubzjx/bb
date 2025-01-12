package l3;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* loaded from: classes.dex */
public abstract class l {
    public static final com.google.gson.p A;
    public static final com.google.gson.q B;
    public static final com.google.gson.p C;
    public static final com.google.gson.q D;
    public static final com.google.gson.p E;
    public static final com.google.gson.q F;
    public static final com.google.gson.p G;
    public static final com.google.gson.q H;
    public static final com.google.gson.p I;
    public static final com.google.gson.q J;
    public static final com.google.gson.p K;
    public static final com.google.gson.q L;
    public static final com.google.gson.p M;
    public static final com.google.gson.q N;
    public static final com.google.gson.p O;
    public static final com.google.gson.q P;
    public static final com.google.gson.p Q;
    public static final com.google.gson.q R;
    public static final com.google.gson.p S;
    public static final com.google.gson.q T;
    public static final com.google.gson.p U;
    public static final com.google.gson.q V;
    public static final com.google.gson.q W;

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.p f11891a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.google.gson.q f11892b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.gson.p f11893c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.gson.q f11894d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.gson.p f11895e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.gson.p f11896f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.gson.q f11897g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.gson.p f11898h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.gson.q f11899i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.gson.p f11900j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.google.gson.q f11901k;

    /* renamed from: l  reason: collision with root package name */
    public static final com.google.gson.p f11902l;

    /* renamed from: m  reason: collision with root package name */
    public static final com.google.gson.q f11903m;

    /* renamed from: n  reason: collision with root package name */
    public static final com.google.gson.p f11904n;

    /* renamed from: o  reason: collision with root package name */
    public static final com.google.gson.q f11905o;

    /* renamed from: p  reason: collision with root package name */
    public static final com.google.gson.p f11906p;

    /* renamed from: q  reason: collision with root package name */
    public static final com.google.gson.q f11907q;

    /* renamed from: r  reason: collision with root package name */
    public static final com.google.gson.p f11908r;

    /* renamed from: s  reason: collision with root package name */
    public static final com.google.gson.q f11909s;

    /* renamed from: t  reason: collision with root package name */
    public static final com.google.gson.p f11910t;

    /* renamed from: u  reason: collision with root package name */
    public static final com.google.gson.p f11911u;

    /* renamed from: v  reason: collision with root package name */
    public static final com.google.gson.p f11912v;

    /* renamed from: w  reason: collision with root package name */
    public static final com.google.gson.p f11913w;

    /* renamed from: x  reason: collision with root package name */
    public static final com.google.gson.q f11914x;

    /* renamed from: y  reason: collision with root package name */
    public static final com.google.gson.p f11915y;

    /* renamed from: z  reason: collision with root package name */
    public static final com.google.gson.p f11916z;

    /* loaded from: classes.dex */
    class a extends com.google.gson.p {
        a() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public AtomicIntegerArray b(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e6) {
                    throw new com.google.gson.l(e6);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i6 = 0; i6 < size; i6++) {
                atomicIntegerArray.set(i6, ((Integer) arrayList.get(i6)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                jsonWriter.value(atomicIntegerArray.get(i6));
            }
            jsonWriter.endArray();
        }
    }

    /* loaded from: classes.dex */
    class a0 extends com.google.gson.p {
        a0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Boolean b(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek != JsonToken.NULL) {
                return peek == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString())) : Boolean.valueOf(jsonReader.nextBoolean());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.value(bool);
        }
    }

    /* loaded from: classes.dex */
    class b extends com.google.gson.p {
        b() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* loaded from: classes.dex */
    class b0 extends com.google.gson.p {
        b0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Boolean b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Boolean.valueOf(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    }

    /* loaded from: classes.dex */
    class c extends com.google.gson.p {
        c() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* loaded from: classes.dex */
    class c0 extends com.google.gson.p {
        c0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* loaded from: classes.dex */
    class d extends com.google.gson.p {
        d() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* loaded from: classes.dex */
    class d0 extends com.google.gson.p {
        d0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* loaded from: classes.dex */
    class e extends com.google.gson.p {
        e() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Character b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new com.google.gson.l("Expecting character, got: " + nextString);
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Character ch) {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    /* loaded from: classes.dex */
    class e0 extends com.google.gson.p {
        e0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* loaded from: classes.dex */
    class f extends com.google.gson.p {
        f() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public String b(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek != JsonToken.NULL) {
                return peek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, String str) {
            jsonWriter.value(str);
        }
    }

    /* loaded from: classes.dex */
    class f0 extends com.google.gson.p {
        f0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public AtomicInteger b(JsonReader jsonReader) {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* loaded from: classes.dex */
    class g extends com.google.gson.p {
        g() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public BigDecimal b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            jsonWriter.value(bigDecimal);
        }
    }

    /* loaded from: classes.dex */
    class g0 extends com.google.gson.p {
        g0() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public AtomicBoolean b(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    /* loaded from: classes.dex */
    class h extends com.google.gson.p {
        h() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public BigInteger b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigInteger(jsonReader.nextString());
            } catch (NumberFormatException e6) {
                throw new com.google.gson.l(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BigInteger bigInteger) {
            jsonWriter.value(bigInteger);
        }
    }

    /* loaded from: classes.dex */
    private static final class h0 extends com.google.gson.p {

        /* renamed from: a  reason: collision with root package name */
        private final Map f11917a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map f11918b = new HashMap();

        /* loaded from: classes.dex */
        class a implements PrivilegedAction {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Field f11919a;

            a(Field field) {
                this.f11919a = field;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a */
            public Void run() {
                this.f11919a.setAccessible(true);
                return null;
            }
        }

        public h0(Class cls) {
            Field[] declaredFields;
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isEnumConstant()) {
                        AccessController.doPrivileged(new a(field));
                        Enum r42 = (Enum) field.get(null);
                        String name = r42.name();
                        k3.c cVar = (k3.c) field.getAnnotation(k3.c.class);
                        if (cVar != null) {
                            name = cVar.value();
                            for (String str : cVar.alternate()) {
                                this.f11917a.put(str, r42);
                            }
                        }
                        this.f11917a.put(name, r42);
                        this.f11918b.put(r42, name);
                    }
                }
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Enum b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return (Enum) this.f11917a.get(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Enum r32) {
            jsonWriter.value(r32 == null ? null : (String) this.f11918b.get(r32));
        }
    }

    /* loaded from: classes.dex */
    class i extends com.google.gson.p {
        i() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public StringBuilder b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuilder(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, StringBuilder sb) {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    /* loaded from: classes.dex */
    class j extends com.google.gson.p {
        j() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public StringBuffer b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuffer(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, StringBuffer stringBuffer) {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* loaded from: classes.dex */
    class k extends com.google.gson.p {
        k() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Class b(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* renamed from: l3.l$l  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0193l extends com.google.gson.p {
        C0193l() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public URL b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, URL url) {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* loaded from: classes.dex */
    class m extends com.google.gson.p {
        m() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public URI b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e6) {
                throw new com.google.gson.g(e6);
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, URI uri) {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* loaded from: classes.dex */
    class n extends com.google.gson.p {
        n() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public InetAddress b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return InetAddress.getByName(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, InetAddress inetAddress) {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* loaded from: classes.dex */
    class o extends com.google.gson.p {
        o() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public UUID b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return UUID.fromString(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, UUID uuid) {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* loaded from: classes.dex */
    class p extends com.google.gson.p {
        p() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Currency b(JsonReader jsonReader) {
            return Currency.getInstance(jsonReader.nextString());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Currency currency) {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* loaded from: classes.dex */
    class q extends com.google.gson.p {
        q() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Calendar b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
                    i7 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i8 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i9 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i10 = nextInt;
                } else if ("second".equals(nextName)) {
                    i11 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i6, i7, i8, i9, i10, i11);
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Calendar calendar) {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value(calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value(calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value(calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value(calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* loaded from: classes.dex */
    class r extends com.google.gson.p {
        r() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Locale b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Locale locale) {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* loaded from: classes.dex */
    class s extends com.google.gson.p {
        s() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public com.google.gson.f b(JsonReader jsonReader) {
            switch (z.f11933a[jsonReader.peek().ordinal()]) {
                case 1:
                    return new com.google.gson.k(new com.google.gson.internal.g(jsonReader.nextString()));
                case 2:
                    return new com.google.gson.k(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new com.google.gson.k(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return com.google.gson.h.f5768a;
                case 5:
                    com.google.gson.e eVar = new com.google.gson.e();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        eVar.h(b(jsonReader));
                    }
                    jsonReader.endArray();
                    return eVar;
                case 6:
                    com.google.gson.i iVar = new com.google.gson.i();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        iVar.h(jsonReader.nextName(), b(jsonReader));
                    }
                    jsonReader.endObject();
                    return iVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, com.google.gson.f fVar) {
            if (fVar == null || fVar.e()) {
                jsonWriter.nullValue();
            } else if (fVar.g()) {
                com.google.gson.k c6 = fVar.c();
                if (c6.m()) {
                    jsonWriter.value(c6.i());
                } else if (c6.k()) {
                    jsonWriter.value(c6.h());
                } else {
                    jsonWriter.value(c6.j());
                }
            } else if (fVar.d()) {
                jsonWriter.beginArray();
                Iterator it = fVar.a().iterator();
                while (it.hasNext()) {
                    d(jsonWriter, (com.google.gson.f) it.next());
                }
                jsonWriter.endArray();
            } else if (!fVar.f()) {
                throw new IllegalArgumentException("Couldn't write " + fVar.getClass());
            } else {
                jsonWriter.beginObject();
                for (Map.Entry entry : fVar.b().entrySet()) {
                    jsonWriter.name((String) entry.getKey());
                    d(jsonWriter, (com.google.gson.f) entry.getValue());
                }
                jsonWriter.endObject();
            }
        }
    }

    /* loaded from: classes.dex */
    class t implements com.google.gson.q {
        t() {
        }

        @Override // com.google.gson.q
        public com.google.gson.p a(com.google.gson.d dVar, p3.a aVar) {
            Class c6 = aVar.c();
            if (!Enum.class.isAssignableFrom(c6) || c6 == Enum.class) {
                return null;
            }
            if (!c6.isEnum()) {
                c6 = c6.getSuperclass();
            }
            return new h0(c6);
        }
    }

    /* loaded from: classes.dex */
    class u extends com.google.gson.p {
        u() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
            if (r8.nextInt() != 0) goto L15;
         */
        @Override // com.google.gson.p
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BitSet b(JsonReader jsonReader) {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int i6 = 0;
            while (peek != JsonToken.END_ARRAY) {
                int i7 = z.f11933a[peek.ordinal()];
                boolean z5 = true;
                if (i7 != 1) {
                    if (i7 == 2) {
                        z5 = jsonReader.nextBoolean();
                    } else if (i7 != 3) {
                        throw new com.google.gson.l("Invalid bitset value type: " + peek);
                    } else {
                        String nextString = jsonReader.nextString();
                        try {
                        } catch (NumberFormatException unused) {
                            throw new com.google.gson.l("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                        }
                    }
                    if (z5) {
                        bitSet.set(i6);
                    }
                    i6++;
                    peek = jsonReader.peek();
                }
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BitSet bitSet) {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i6 = 0; i6 < length; i6++) {
                jsonWriter.value(bitSet.get(i6) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v implements com.google.gson.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f11921a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.p f11922b;

        v(Class cls, com.google.gson.p pVar) {
            this.f11921a = cls;
            this.f11922b = pVar;
        }

        @Override // com.google.gson.q
        public com.google.gson.p a(com.google.gson.d dVar, p3.a aVar) {
            if (aVar.c() == this.f11921a) {
                return this.f11922b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f11921a.getName() + ",adapter=" + this.f11922b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w implements com.google.gson.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f11923a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f11924b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.p f11925c;

        w(Class cls, Class cls2, com.google.gson.p pVar) {
            this.f11923a = cls;
            this.f11924b = cls2;
            this.f11925c = pVar;
        }

        @Override // com.google.gson.q
        public com.google.gson.p a(com.google.gson.d dVar, p3.a aVar) {
            Class c6 = aVar.c();
            if (c6 == this.f11923a || c6 == this.f11924b) {
                return this.f11925c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f11924b.getName() + k5.d.ANY_NON_NULL_MARKER + this.f11923a.getName() + ",adapter=" + this.f11925c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class x implements com.google.gson.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f11926a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f11927b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.p f11928c;

        x(Class cls, Class cls2, com.google.gson.p pVar) {
            this.f11926a = cls;
            this.f11927b = cls2;
            this.f11928c = pVar;
        }

        @Override // com.google.gson.q
        public com.google.gson.p a(com.google.gson.d dVar, p3.a aVar) {
            Class c6 = aVar.c();
            if (c6 == this.f11926a || c6 == this.f11927b) {
                return this.f11928c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f11926a.getName() + k5.d.ANY_NON_NULL_MARKER + this.f11927b.getName() + ",adapter=" + this.f11928c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y implements com.google.gson.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f11929a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.p f11930b;

        /* loaded from: classes.dex */
        class a extends com.google.gson.p {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f11931a;

            a(Class cls) {
                this.f11931a = cls;
            }

            @Override // com.google.gson.p
            public Object b(JsonReader jsonReader) {
                Object b6 = y.this.f11930b.b(jsonReader);
                if (b6 == null || this.f11931a.isInstance(b6)) {
                    return b6;
                }
                throw new com.google.gson.l("Expected a " + this.f11931a.getName() + " but was " + b6.getClass().getName());
            }

            @Override // com.google.gson.p
            public void d(JsonWriter jsonWriter, Object obj) {
                y.this.f11930b.d(jsonWriter, obj);
            }
        }

        y(Class cls, com.google.gson.p pVar) {
            this.f11929a = cls;
            this.f11930b = pVar;
        }

        @Override // com.google.gson.q
        public com.google.gson.p a(com.google.gson.d dVar, p3.a aVar) {
            Class<?> c6 = aVar.c();
            if (this.f11929a.isAssignableFrom(c6)) {
                return new a(c6);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f11929a.getName() + ",adapter=" + this.f11930b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class z {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11933a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f11933a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11933a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11933a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11933a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11933a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11933a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11933a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11933a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11933a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11933a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        com.google.gson.p a6 = new k().a();
        f11891a = a6;
        f11892b = a(Class.class, a6);
        com.google.gson.p a7 = new u().a();
        f11893c = a7;
        f11894d = a(BitSet.class, a7);
        a0 a0Var = new a0();
        f11895e = a0Var;
        f11896f = new b0();
        f11897g = b(Boolean.TYPE, Boolean.class, a0Var);
        c0 c0Var = new c0();
        f11898h = c0Var;
        f11899i = b(Byte.TYPE, Byte.class, c0Var);
        d0 d0Var = new d0();
        f11900j = d0Var;
        f11901k = b(Short.TYPE, Short.class, d0Var);
        e0 e0Var = new e0();
        f11902l = e0Var;
        f11903m = b(Integer.TYPE, Integer.class, e0Var);
        com.google.gson.p a8 = new f0().a();
        f11904n = a8;
        f11905o = a(AtomicInteger.class, a8);
        com.google.gson.p a9 = new g0().a();
        f11906p = a9;
        f11907q = a(AtomicBoolean.class, a9);
        com.google.gson.p a10 = new a().a();
        f11908r = a10;
        f11909s = a(AtomicIntegerArray.class, a10);
        f11910t = new b();
        f11911u = new c();
        f11912v = new d();
        e eVar = new e();
        f11913w = eVar;
        f11914x = b(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f11915y = fVar;
        f11916z = new g();
        A = new h();
        B = a(String.class, fVar);
        i iVar = new i();
        C = iVar;
        D = a(StringBuilder.class, iVar);
        j jVar = new j();
        E = jVar;
        F = a(StringBuffer.class, jVar);
        C0193l c0193l = new C0193l();
        G = c0193l;
        H = a(URL.class, c0193l);
        m mVar = new m();
        I = mVar;
        J = a(URI.class, mVar);
        n nVar = new n();
        K = nVar;
        L = d(InetAddress.class, nVar);
        o oVar = new o();
        M = oVar;
        N = a(UUID.class, oVar);
        com.google.gson.p a11 = new p().a();
        O = a11;
        P = a(Currency.class, a11);
        q qVar = new q();
        Q = qVar;
        R = c(Calendar.class, GregorianCalendar.class, qVar);
        r rVar = new r();
        S = rVar;
        T = a(Locale.class, rVar);
        s sVar = new s();
        U = sVar;
        V = d(com.google.gson.f.class, sVar);
        W = new t();
    }

    public static com.google.gson.q a(Class cls, com.google.gson.p pVar) {
        return new v(cls, pVar);
    }

    public static com.google.gson.q b(Class cls, Class cls2, com.google.gson.p pVar) {
        return new w(cls, cls2, pVar);
    }

    public static com.google.gson.q c(Class cls, Class cls2, com.google.gson.p pVar) {
        return new x(cls, cls2, pVar);
    }

    public static com.google.gson.q d(Class cls, com.google.gson.p pVar) {
        return new y(cls, pVar);
    }
}
