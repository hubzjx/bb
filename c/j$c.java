package c;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes2.dex */
final class j$c {

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator f3047b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f3048c = 0;

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$s f3049a;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
        f3047b = new Comparator() { // from class: c.j$d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((String) ((Map.Entry) obj2).getKey()).length() - ((String) ((Map.Entry) obj).getKey()).length();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$c(j$s j_s) {
        this.f3049a = j_s;
    }
}
