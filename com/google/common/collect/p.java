package com.google.common.collect;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends z {
    static final p INSTANCE = new p();
    private static final long serialVersionUID = 0;

    private p() {
        super(a0.of(), 0);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
