package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i0 extends h0 {
    public static Set b() {
        return z.INSTANCE;
    }

    public static final Set c(Set set) {
        kotlin.jvm.internal.l.d(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : h0.a(set.iterator().next()) : g0.b();
    }
}
