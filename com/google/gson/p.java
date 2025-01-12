package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends p {
        a() {
        }

        @Override // com.google.gson.p
        public Object b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return p.this.b(jsonReader);
        }

        @Override // com.google.gson.p
        public void d(JsonWriter jsonWriter, Object obj) {
            if (obj == null) {
                jsonWriter.nullValue();
            } else {
                p.this.d(jsonWriter, obj);
            }
        }
    }

    public final p a() {
        return new a();
    }

    public abstract Object b(JsonReader jsonReader);

    public final f c(Object obj) {
        try {
            l3.f fVar = new l3.f();
            d(fVar, obj);
            return fVar.a();
        } catch (IOException e6) {
            throw new g(e6);
        }
    }

    public abstract void d(JsonWriter jsonWriter, Object obj);
}
