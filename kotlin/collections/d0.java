package kotlin.collections;

import java.util.Collections;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d0 extends c0 {
    public static int a(int i6) {
        if (i6 < 0) {
            return i6;
        }
        if (i6 < 3) {
            return i6 + 1;
        }
        if (i6 < 1073741824) {
            return (int) ((i6 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map b(h4.j jVar) {
        kotlin.jvm.internal.l.d(jVar, "pair");
        Map singletonMap = Collections.singletonMap(jVar.getFirst(), jVar.getSecond());
        kotlin.jvm.internal.l.c(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final Map c(Map map) {
        kotlin.jvm.internal.l.d(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.l.c(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
