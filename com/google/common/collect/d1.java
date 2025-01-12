package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
abstract class d1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] a(Object[] objArr, int i6, int i7, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i6, i7, objArr2.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] b(Object[] objArr, int i6) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set c() {
        return l.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map d() {
        return k.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0 e(q0 q0Var) {
        return q0Var.l();
    }
}
