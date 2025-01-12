package com.google.zxing;
/* loaded from: classes.dex */
public final class d extends m {
    private static final d INSTANCE;

    static {
        d dVar = new d();
        INSTANCE = dVar;
        dVar.setStackTrace(m.NO_TRACE);
    }

    private d() {
    }

    private d(Throwable th) {
        super(th);
    }

    public static d getChecksumInstance() {
        return m.isStackTrace ? new d() : INSTANCE;
    }

    public static d getChecksumInstance(Throwable th) {
        return m.isStackTrace ? new d(th) : INSTANCE;
    }
}
