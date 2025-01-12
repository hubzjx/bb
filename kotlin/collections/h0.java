package kotlin.collections;

import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
abstract class h0 {
    public static final Set a(Object obj) {
        Set singleton = Collections.singleton(obj);
        kotlin.jvm.internal.l.c(singleton, "singleton(element)");
        return singleton;
    }
}
