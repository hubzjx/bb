package com.google.common.collect;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends i0 {
    static final q INSTANCE = new q();
    private static final long serialVersionUID = 0;

    private q() {
        super(a0.of(), 0, null);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
