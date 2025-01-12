package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class b implements com.google.gson.c {
    private static final /* synthetic */ b[] $VALUES;
    public static final b IDENTITY;
    public static final b LOWER_CASE_WITH_DASHES;
    public static final b LOWER_CASE_WITH_DOTS;
    public static final b LOWER_CASE_WITH_UNDERSCORES;
    public static final b UPPER_CAMEL_CASE;
    public static final b UPPER_CAMEL_CASE_WITH_SPACES;

    /* loaded from: classes.dex */
    enum a extends b {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // com.google.gson.b, com.google.gson.c
        public String translateName(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        IDENTITY = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.b.b
            @Override // com.google.gson.b, com.google.gson.c
            public String translateName(Field field) {
                return b.upperCaseFirstLetter(field.getName());
            }
        };
        UPPER_CAMEL_CASE = bVar;
        b bVar2 = new b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.b.c
            @Override // com.google.gson.b, com.google.gson.c
            public String translateName(Field field) {
                return b.upperCaseFirstLetter(b.separateCamelCase(field.getName(), " "));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = bVar2;
        b bVar3 = new b("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.b.d
            @Override // com.google.gson.b, com.google.gson.c
            public String translateName(Field field) {
                return b.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = bVar3;
        b bVar4 = new b("LOWER_CASE_WITH_DASHES", 4) { // from class: com.google.gson.b.e
            @Override // com.google.gson.b, com.google.gson.c
            public String translateName(Field field) {
                return b.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = bVar4;
        b bVar5 = new b("LOWER_CASE_WITH_DOTS", 5) { // from class: com.google.gson.b.f
            @Override // com.google.gson.b, com.google.gson.c
            public String translateName(Field field) {
                return b.separateCamelCase(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = bVar5;
        $VALUES = new b[]{aVar, bVar, bVar2, bVar3, bVar4, bVar5};
    }

    private b(String str, int i6) {
    }

    static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String upperCaseFirstLetter(String str) {
        int length = str.length() - 1;
        int i6 = 0;
        while (!Character.isLetter(str.charAt(i6)) && i6 < length) {
            i6++;
        }
        char charAt = str.charAt(i6);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i6 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i6) + upperCase + str.substring(i6 + 1);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }

    @Override // com.google.gson.c
    public abstract /* synthetic */ String translateName(Field field);

    /* synthetic */ b(String str, int i6, a aVar) {
        this(str, i6);
    }
}
