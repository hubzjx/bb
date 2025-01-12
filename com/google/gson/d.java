package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: x  reason: collision with root package name */
    private static final p3.a f5738x = p3.a.a(Object.class);

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal f5739a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f5740b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.internal.c f5741c;

    /* renamed from: d  reason: collision with root package name */
    private final l3.e f5742d;

    /* renamed from: e  reason: collision with root package name */
    final List f5743e;

    /* renamed from: f  reason: collision with root package name */
    final com.google.gson.internal.d f5744f;

    /* renamed from: g  reason: collision with root package name */
    final com.google.gson.c f5745g;

    /* renamed from: h  reason: collision with root package name */
    final Map f5746h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f5747i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f5748j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f5749k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f5750l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f5751m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f5752n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f5753o;

    /* renamed from: p  reason: collision with root package name */
    final String f5754p;

    /* renamed from: q  reason: collision with root package name */
    final int f5755q;

    /* renamed from: r  reason: collision with root package name */
    final int f5756r;

    /* renamed from: s  reason: collision with root package name */
    final m f5757s;

    /* renamed from: t  reason: collision with root package name */
    final List f5758t;

    /* renamed from: u  reason: collision with root package name */
    final List f5759u;

    /* renamed from: v  reason: collision with root package name */
    final o f5760v;

    /* renamed from: w  reason: collision with root package name */
    final o f5761w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends p {
        a() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Double b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            d.d(number.doubleValue());
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends p {
        b() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Float b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            d.d(number.floatValue());
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends p {
        c() {
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Long.valueOf(jsonReader.nextLong());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058d extends p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f5764a;

        C0058d(p pVar) {
            this.f5764a = pVar;
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public AtomicLong b(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.f5764a.b(jsonReader)).longValue());
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.f5764a.d(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f5765a;

        e(p pVar) {
            this.f5765a = pVar;
        }

        @Override // com.google.gson.p
        /* renamed from: e */
        public AtomicLongArray b(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f5765a.b(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i6 = 0; i6 < size; i6++) {
                atomicLongArray.set(i6, ((Long) arrayList.get(i6)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.p
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                this.f5765a.d(jsonWriter, Long.valueOf(atomicLongArray.get(i6)));
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f extends p {

        /* renamed from: a  reason: collision with root package name */
        private p f5766a;

        f() {
        }

        @Override // com.google.gson.p
        public Object b(JsonReader jsonReader) {
            p pVar = this.f5766a;
            if (pVar != null) {
                return pVar.b(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.p
        public void d(JsonWriter jsonWriter, Object obj) {
            p pVar = this.f5766a;
            if (pVar == null) {
                throw new IllegalStateException();
            }
            pVar.d(jsonWriter, obj);
        }

        public void e(p pVar) {
            if (this.f5766a != null) {
                throw new AssertionError();
            }
            this.f5766a = pVar;
        }
    }

    public d() {
        this(com.google.gson.internal.d.f5790g, com.google.gson.b.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, m.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), n.DOUBLE, n.LAZILY_PARSED_NUMBER);
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new g("JSON document was not fully consumed.");
            } catch (MalformedJsonException e6) {
                throw new l(e6);
            } catch (IOException e7) {
                throw new g(e7);
            }
        }
    }

    private static p b(p pVar) {
        return new C0058d(pVar).a();
    }

    private static p c(p pVar) {
        return new e(pVar).a();
    }

    static void d(double d6) {
        if (Double.isNaN(d6) || Double.isInfinite(d6)) {
            throw new IllegalArgumentException(d6 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private p e(boolean z5) {
        return z5 ? l3.l.f11912v : new a();
    }

    private p f(boolean z5) {
        return z5 ? l3.l.f11911u : new b();
    }

    private static p n(m mVar) {
        return mVar == m.DEFAULT ? l3.l.f11910t : new c();
    }

    public Object g(JsonReader jsonReader, Type type) {
        boolean isLenient = jsonReader.isLenient();
        boolean z5 = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z5 = false;
                    return l(p3.a.b(type)).b(jsonReader);
                } catch (AssertionError e6) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e6.getMessage());
                    assertionError.initCause(e6);
                    throw assertionError;
                } catch (IllegalStateException e7) {
                    throw new l(e7);
                }
            } catch (EOFException e8) {
                if (z5) {
                    jsonReader.setLenient(isLenient);
                    return null;
                }
                throw new l(e8);
            } catch (IOException e9) {
                throw new l(e9);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public Object h(Reader reader, Type type) {
        JsonReader o5 = o(reader);
        Object g6 = g(o5, type);
        a(g6, o5);
        return g6;
    }

    public Object i(String str, Class cls) {
        return com.google.gson.internal.k.b(cls).cast(j(str, cls));
    }

    public Object j(String str, Type type) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), type);
    }

    public p k(Class cls) {
        return l(p3.a.a(cls));
    }

    public p l(p3.a aVar) {
        boolean z5;
        p pVar = (p) this.f5740b.get(aVar == null ? f5738x : aVar);
        if (pVar != null) {
            return pVar;
        }
        Map map = (Map) this.f5739a.get();
        if (map == null) {
            map = new HashMap();
            this.f5739a.set(map);
            z5 = true;
        } else {
            z5 = false;
        }
        f fVar = (f) map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f fVar2 = new f();
            map.put(aVar, fVar2);
            for (q qVar : this.f5743e) {
                p a6 = qVar.a(this, aVar);
                if (a6 != null) {
                    fVar2.e(a6);
                    this.f5740b.put(aVar, a6);
                    return a6;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.9) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z5) {
                this.f5739a.remove();
            }
        }
    }

    public p m(q qVar, p3.a aVar) {
        if (!this.f5743e.contains(qVar)) {
            qVar = this.f5742d;
        }
        boolean z5 = false;
        for (q qVar2 : this.f5743e) {
            if (z5) {
                p a6 = qVar2.a(this, aVar);
                if (a6 != null) {
                    return a6;
                }
            } else if (qVar2 == qVar) {
                z5 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public JsonReader o(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.f5752n);
        return jsonReader;
    }

    public JsonWriter p(Writer writer) {
        if (this.f5749k) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f5751m) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.f5747i);
        return jsonWriter;
    }

    public String q(com.google.gson.f fVar) {
        StringWriter stringWriter = new StringWriter();
        u(fVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        return obj == null ? q(h.f5768a) : s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(com.google.gson.f fVar, JsonWriter jsonWriter) {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f5750l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f5747i);
        try {
            try {
                com.google.gson.internal.l.a(fVar, jsonWriter);
            } catch (IOException e6) {
                throw new g(e6);
            } catch (AssertionError e7) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e7.getMessage());
                assertionError.initCause(e7);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f5747i + ",factories:" + this.f5743e + ",instanceCreators:" + this.f5741c + "}";
    }

    public void u(com.google.gson.f fVar, Appendable appendable) {
        try {
            t(fVar, p(com.google.gson.internal.l.b(appendable)));
        } catch (IOException e6) {
            throw new g(e6);
        }
    }

    public void v(Object obj, Type type, JsonWriter jsonWriter) {
        p l6 = l(p3.a.b(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f5750l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f5747i);
        try {
            try {
                l6.d(jsonWriter, obj);
            } catch (IOException e6) {
                throw new g(e6);
            } catch (AssertionError e7) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e7.getMessage());
                assertionError.initCause(e7);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(com.google.gson.internal.l.b(appendable)));
        } catch (IOException e6) {
            throw new g(e6);
        }
    }

    d(com.google.gson.internal.d dVar, com.google.gson.c cVar, Map map, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, m mVar, String str, int i6, int i7, List list, List list2, List list3, o oVar, o oVar2) {
        this.f5739a = new ThreadLocal();
        this.f5740b = new ConcurrentHashMap();
        this.f5744f = dVar;
        this.f5745g = cVar;
        this.f5746h = map;
        com.google.gson.internal.c cVar2 = new com.google.gson.internal.c(map);
        this.f5741c = cVar2;
        this.f5747i = z5;
        this.f5748j = z6;
        this.f5749k = z7;
        this.f5750l = z8;
        this.f5751m = z9;
        this.f5752n = z10;
        this.f5753o = z11;
        this.f5757s = mVar;
        this.f5754p = str;
        this.f5755q = i6;
        this.f5756r = i7;
        this.f5758t = list;
        this.f5759u = list2;
        this.f5760v = oVar;
        this.f5761w = oVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(l3.l.V);
        arrayList.add(l3.i.e(oVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(l3.l.B);
        arrayList.add(l3.l.f11903m);
        arrayList.add(l3.l.f11897g);
        arrayList.add(l3.l.f11899i);
        arrayList.add(l3.l.f11901k);
        p n5 = n(mVar);
        arrayList.add(l3.l.b(Long.TYPE, Long.class, n5));
        arrayList.add(l3.l.b(Double.TYPE, Double.class, e(z11)));
        arrayList.add(l3.l.b(Float.TYPE, Float.class, f(z11)));
        arrayList.add(l3.h.e(oVar2));
        arrayList.add(l3.l.f11905o);
        arrayList.add(l3.l.f11907q);
        arrayList.add(l3.l.a(AtomicLong.class, b(n5)));
        arrayList.add(l3.l.a(AtomicLongArray.class, c(n5)));
        arrayList.add(l3.l.f11909s);
        arrayList.add(l3.l.f11914x);
        arrayList.add(l3.l.D);
        arrayList.add(l3.l.F);
        arrayList.add(l3.l.a(BigDecimal.class, l3.l.f11916z));
        arrayList.add(l3.l.a(BigInteger.class, l3.l.A));
        arrayList.add(l3.l.H);
        arrayList.add(l3.l.J);
        arrayList.add(l3.l.N);
        arrayList.add(l3.l.P);
        arrayList.add(l3.l.T);
        arrayList.add(l3.l.L);
        arrayList.add(l3.l.f11894d);
        arrayList.add(l3.c.f11846b);
        arrayList.add(l3.l.R);
        if (o3.d.f12487a) {
            arrayList.add(o3.d.f12491e);
            arrayList.add(o3.d.f12490d);
            arrayList.add(o3.d.f12492f);
        }
        arrayList.add(l3.a.f11840c);
        arrayList.add(l3.l.f11892b);
        arrayList.add(new l3.b(cVar2));
        arrayList.add(new l3.g(cVar2, z6));
        l3.e eVar = new l3.e(cVar2);
        this.f5742d = eVar;
        arrayList.add(eVar);
        arrayList.add(l3.l.W);
        arrayList.add(new l3.j(cVar2, cVar, dVar, eVar));
        this.f5743e = Collections.unmodifiableList(arrayList);
    }
}
