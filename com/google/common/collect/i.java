package com.google.common.collect;
/* loaded from: classes.dex */
abstract class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 != null) {
        } else {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i6, String str) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i6, String str) {
        if (i6 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(boolean z5) {
        com.google.common.base.j.o(z5, "no calls to next() since the last call to remove()");
    }
}
