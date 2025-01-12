package com.google.gson;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class m {
    private static final /* synthetic */ m[] $VALUES;
    public static final m DEFAULT;
    public static final m STRING;

    /* loaded from: classes.dex */
    enum a extends m {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // com.google.gson.m
        public f serialize(Long l6) {
            return l6 == null ? h.f5768a : new k(l6);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        m mVar = new m("STRING", 1) { // from class: com.google.gson.m.b
            @Override // com.google.gson.m
            public f serialize(Long l6) {
                return l6 == null ? h.f5768a : new k(l6.toString());
            }
        };
        STRING = mVar;
        $VALUES = new m[]{aVar, mVar};
    }

    private m(String str, int i6) {
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) $VALUES.clone();
    }

    public abstract f serialize(Long l6);

    /* synthetic */ m(String str, int i6, a aVar) {
        this(str, i6);
    }
}
