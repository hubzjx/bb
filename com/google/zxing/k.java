package com.google.zxing;
/* loaded from: classes.dex */
public final class k extends m {
    private static final k INSTANCE;

    static {
        k kVar = new k();
        INSTANCE = kVar;
        kVar.setStackTrace(m.NO_TRACE);
    }

    private k() {
    }

    public static k getNotFoundInstance() {
        return INSTANCE;
    }
}
