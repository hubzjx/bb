package com.google.zxing;
/* loaded from: classes.dex */
public final class h extends m {
    private static final h INSTANCE;

    static {
        h hVar = new h();
        INSTANCE = hVar;
        hVar.setStackTrace(m.NO_TRACE);
    }

    private h() {
    }

    private h(Throwable th) {
        super(th);
    }

    public static h getFormatInstance() {
        return m.isStackTrace ? new h() : INSTANCE;
    }

    public static h getFormatInstance(Throwable th) {
        return m.isStackTrace ? new h(th) : INSTANCE;
    }
}
