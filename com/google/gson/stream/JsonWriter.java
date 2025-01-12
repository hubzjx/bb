package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i6 = 0; i6 <= 31; i6++) {
            REPLACEMENT_CHARS[i6] = String.format("\\u%04x", Integer.valueOf(i6));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    private void beforeName() {
        int peek = peek();
        if (peek == 5) {
            this.out.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() {
        int peek = peek();
        if (peek == 1) {
            replaceTop(2);
        } else if (peek != 2) {
            if (peek == 4) {
                this.out.append((CharSequence) this.separator);
                replaceTop(5);
                return;
            }
            if (peek != 6) {
                if (peek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            replaceTop(7);
            return;
        } else {
            this.out.append(',');
        }
        newline();
    }

    private JsonWriter close(int i6, int i7, char c6) {
        int peek = peek();
        if (peek == i7 || peek == i6) {
            if (this.deferredName != null) {
                throw new IllegalStateException("Dangling name: " + this.deferredName);
            }
            this.stackSize--;
            if (peek == i7) {
                newline();
            }
            this.out.write(c6);
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.out.write(10);
        int i6 = this.stackSize;
        for (int i7 = 1; i7 < i6; i7++) {
            this.out.write(this.indent);
        }
    }

    private JsonWriter open(int i6, char c6) {
        beforeValue();
        push(i6);
        this.out.write(c6);
        return this;
    }

    private int peek() {
        int i6 = this.stackSize;
        if (i6 != 0) {
            return this.stack[i6 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int i6) {
        int i7 = this.stackSize;
        int[] iArr = this.stack;
        if (i7 == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i7 * 2);
        }
        int[] iArr2 = this.stack;
        int i8 = this.stackSize;
        this.stackSize = i8 + 1;
        iArr2[i8] = i6;
    }

    private void replaceTop(int i6) {
        this.stack[this.stackSize - 1] = i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) {
        int i6;
        String str2;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write(34);
        int length = str.length();
        int i7 = 0;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i6 = str2 == null ? i6 + 1 : 0;
                if (i7 < i6) {
                    this.out.write(str, i7, i6 - i7);
                }
                this.out.write(str2);
                i7 = i6 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i7 < i6) {
                }
                this.out.write(str2);
                i7 = i6 + 1;
            }
        }
        if (i7 < length) {
            this.out.write(str, i7, length - i7);
        }
        this.out.write(34);
    }

    private void writeDeferredName() {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() {
        writeDeferredName();
        return open(1, '[');
    }

    public JsonWriter beginObject() {
        writeDeferredName();
        return open(3, '{');
    }

    public JsonWriter endArray() {
        return close(1, 2, ']');
    }

    public JsonWriter endObject() {
        return close(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String str) {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((CharSequence) str);
        return this;
    }

    public JsonWriter name(String str) {
        if (str != null) {
            if (this.deferredName == null) {
                if (this.stackSize != 0) {
                    this.deferredName = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public JsonWriter nullValue() {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean z5) {
        this.htmlSafe = z5;
    }

    public final void setIndent(String str) {
        String str2;
        if (str.length() == 0) {
            this.indent = null;
            str2 = ":";
        } else {
            this.indent = str;
            str2 = ": ";
        }
        this.separator = str2;
    }

    public final void setLenient(boolean z5) {
        this.lenient = z5;
    }

    public final void setSerializeNulls(boolean z5) {
        this.serializeNulls = z5;
    }

    public JsonWriter value(double d6) {
        writeDeferredName();
        if (this.lenient || !(Double.isNaN(d6) || Double.isInfinite(d6))) {
            beforeValue();
            this.out.append((CharSequence) Double.toString(d6));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
        int i6 = this.stackSize;
        if (i6 > 1 || (i6 == 1 && this.stack[i6 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter value(long j6) {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j6));
        return this;
    }

    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number.toString();
        if (this.lenient || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            beforeValue();
            this.out.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter value(boolean z5) {
        writeDeferredName();
        beforeValue();
        this.out.write(z5 ? "true" : "false");
        return this;
    }
}
