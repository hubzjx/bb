package com.google.common.collect;

import java.util.Collection;
/* loaded from: classes.dex */
public abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection a(Iterable iterable) {
        return (Collection) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder b(int i6) {
        i.b(i6, "size");
        return new StringBuilder((int) Math.min(i6 * 8, 1073741824L));
    }
}
