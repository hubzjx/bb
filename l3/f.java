package l3;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class f extends JsonWriter {

    /* renamed from: d  reason: collision with root package name */
    private static final Writer f11851d = new a();

    /* renamed from: e  reason: collision with root package name */
    private static final com.google.gson.k f11852e = new com.google.gson.k("closed");

    /* renamed from: a  reason: collision with root package name */
    private final List f11853a;

    /* renamed from: b  reason: collision with root package name */
    private String f11854b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.gson.f f11855c;

    /* loaded from: classes.dex */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i6, int i7) {
            throw new AssertionError();
        }
    }

    public f() {
        super(f11851d);
        this.f11853a = new ArrayList();
        this.f11855c = com.google.gson.h.f5768a;
    }

    private com.google.gson.f b() {
        List list = this.f11853a;
        return (com.google.gson.f) list.get(list.size() - 1);
    }

    private void c(com.google.gson.f fVar) {
        if (this.f11854b != null) {
            if (!fVar.e() || getSerializeNulls()) {
                ((com.google.gson.i) b()).h(this.f11854b, fVar);
            }
            this.f11854b = null;
        } else if (this.f11853a.isEmpty()) {
            this.f11855c = fVar;
        } else {
            com.google.gson.f b6 = b();
            if (!(b6 instanceof com.google.gson.e)) {
                throw new IllegalStateException();
            }
            ((com.google.gson.e) b6).h(fVar);
        }
    }

    public com.google.gson.f a() {
        if (this.f11853a.isEmpty()) {
            return this.f11855c;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f11853a);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() {
        com.google.gson.e eVar = new com.google.gson.e();
        c(eVar);
        this.f11853a.add(eVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() {
        com.google.gson.i iVar = new com.google.gson.i();
        c(iVar);
        this.f11853a.add(iVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f11853a.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f11853a.add(f11852e);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() {
        if (this.f11853a.isEmpty() || this.f11854b != null) {
            throw new IllegalStateException();
        }
        if (b() instanceof com.google.gson.e) {
            List list = this.f11853a;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() {
        if (this.f11853a.isEmpty() || this.f11854b != null) {
            throw new IllegalStateException();
        }
        if (b() instanceof com.google.gson.i) {
            List list = this.f11853a;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) {
        if (str != null) {
            if (this.f11853a.isEmpty() || this.f11854b != null) {
                throw new IllegalStateException();
            }
            if (b() instanceof com.google.gson.i) {
                this.f11854b = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() {
        c(com.google.gson.h.f5768a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d6) {
        if (isLenient() || !(Double.isNaN(d6) || Double.isInfinite(d6))) {
            c(new com.google.gson.k(Double.valueOf(d6)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d6);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j6) {
        c(new com.google.gson.k(Long.valueOf(j6)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        c(new com.google.gson.k(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new com.google.gson.k(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z5) {
        c(new com.google.gson.k(Boolean.valueOf(z5)));
        return this;
    }
}
