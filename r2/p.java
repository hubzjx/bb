package r2;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class p implements n {

    /* renamed from: c  reason: collision with root package name */
    public static final p f13007c = new p(Collections.emptyMap());

    /* renamed from: a  reason: collision with root package name */
    private int f13008a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f13009b;

    public p(Map map) {
        this.f13009b = Collections.unmodifiableMap(map);
    }

    private static void c(HashMap hashMap, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), g(entry.getValue()));
        }
    }

    private static Map d(Map map, o oVar) {
        HashMap hashMap = new HashMap(map);
        i(hashMap, oVar.c());
        c(hashMap, oVar.b());
        return hashMap;
    }

    private static byte[] g(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(com.google.common.base.b.f5585c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean h(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void i(HashMap hashMap, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            hashMap.remove(list.get(i6));
        }
    }

    @Override // r2.n
    public final String a(String str, String str2) {
        byte[] bArr = (byte[]) this.f13009b.get(str);
        return bArr != null ? new String(bArr, com.google.common.base.b.f5585c) : str2;
    }

    @Override // r2.n
    public final long b(String str, long j6) {
        byte[] bArr = (byte[]) this.f13009b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j6;
    }

    public p e(o oVar) {
        Map d6 = d(this.f13009b, oVar);
        return h(this.f13009b, d6) ? this : new p(d6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        return h(this.f13009b, ((p) obj).f13009b);
    }

    public Set f() {
        return this.f13009b.entrySet();
    }

    public int hashCode() {
        if (this.f13008a == 0) {
            int i6 = 0;
            for (Map.Entry entry : this.f13009b.entrySet()) {
                i6 += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f13008a = i6;
        }
        return this.f13008a;
    }
}
