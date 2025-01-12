package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.math.BigDecimal;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class n implements o {
    private static final /* synthetic */ n[] $VALUES;
    public static final n BIG_DECIMAL;
    public static final n DOUBLE;
    public static final n LAZILY_PARSED_NUMBER;
    public static final n LONG_OR_DOUBLE;

    /* loaded from: classes.dex */
    enum a extends n {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // com.google.gson.n, com.google.gson.o
        public Double readNumber(JsonReader jsonReader) {
            return Double.valueOf(jsonReader.nextDouble());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        DOUBLE = aVar;
        n nVar = new n("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.n.b
            @Override // com.google.gson.n, com.google.gson.o
            public Number readNumber(JsonReader jsonReader) {
                return new com.google.gson.internal.g(jsonReader.nextString());
            }
        };
        LAZILY_PARSED_NUMBER = nVar;
        n nVar2 = new n("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.n.c
            @Override // com.google.gson.n, com.google.gson.o
            public Number readNumber(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(nextString));
                    } catch (NumberFormatException e6) {
                        throw new j("Cannot parse " + nextString + "; at path " + jsonReader.getPath(), e6);
                    }
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(nextString);
                    if ((valueOf.isInfinite() || valueOf.isNaN()) && !jsonReader.isLenient()) {
                        throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + jsonReader.getPath());
                    }
                    return valueOf;
                }
            }
        };
        LONG_OR_DOUBLE = nVar2;
        n nVar3 = new n("BIG_DECIMAL", 3) { // from class: com.google.gson.n.d
            @Override // com.google.gson.n, com.google.gson.o
            public BigDecimal readNumber(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    return new BigDecimal(nextString);
                } catch (NumberFormatException e6) {
                    throw new j("Cannot parse " + nextString + "; at path " + jsonReader.getPath(), e6);
                }
            }
        };
        BIG_DECIMAL = nVar3;
        $VALUES = new n[]{aVar, nVar, nVar2, nVar3};
    }

    private n(String str, int i6) {
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) $VALUES.clone();
    }

    @Override // com.google.gson.o
    public abstract /* synthetic */ Number readNumber(JsonReader jsonReader);

    /* synthetic */ n(String str, int i6, a aVar) {
        this(str, i6);
    }
}
