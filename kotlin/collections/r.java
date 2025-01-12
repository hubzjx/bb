package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class r extends q {
    public static void q(List list) {
        kotlin.jvm.internal.l.d(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final void r(List list, Comparator comparator) {
        kotlin.jvm.internal.l.d(list, "<this>");
        kotlin.jvm.internal.l.d(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
