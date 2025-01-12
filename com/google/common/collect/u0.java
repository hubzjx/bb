package com.google.common.collect;
/* loaded from: classes.dex */
public abstract class u0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(t0 t0Var, Object obj) {
        if (obj == t0Var) {
            return true;
        }
        if (obj instanceof t0) {
            return t0Var.asMap().equals(((t0) obj).asMap());
        }
        return false;
    }
}
