package kotlin.collections;

import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class o extends n {
    public static int p(Iterable iterable, int i6) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i6;
    }
}
