package com.google.common.collect;
/* loaded from: classes.dex */
abstract class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i6, double d6) {
        int max = Math.max(i6, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d6 * highestOneBit))) {
            int i7 = highestOneBit << 1;
            if (i7 > 0) {
                return i7;
            }
            return 1073741824;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i6) {
        return (int) (Integer.rotateLeft((int) (i6 * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Object obj) {
        return b(obj == null ? 0 : obj.hashCode());
    }
}
