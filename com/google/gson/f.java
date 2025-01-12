package com.google.gson;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes.dex */
public abstract class f {
    public e a() {
        if (d()) {
            return (e) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public i b() {
        if (f()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public k c() {
        if (g()) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof e;
    }

    public boolean e() {
        return this instanceof h;
    }

    public boolean f() {
        return this instanceof i;
    }

    public boolean g() {
        return this instanceof k;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            com.google.gson.internal.l.a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }
}
