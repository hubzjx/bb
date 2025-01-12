package c;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$s {

    /* renamed from: a  reason: collision with root package name */
    private final Map f3090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$s(Map map) {
        Comparator comparator;
        Comparator comparator2;
        this.f3090a = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                int i6 = j$c.f3048c;
                hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            comparator2 = j$c.f3047b;
            Collections.sort(arrayList2, comparator2);
            hashMap.put((j$v) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put(null, arrayList);
        }
        comparator = j$c.f3047b;
        Collections.sort(arrayList, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(long j6) {
        Map map = (Map) this.f3090a.get(j$v.FULL);
        if (map != null) {
            return (String) map.get(Long.valueOf(j6));
        }
        return null;
    }
}
