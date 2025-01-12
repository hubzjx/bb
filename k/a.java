package k;

import java.util.HashMap;
import java.util.Map;
import k.b;
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: e  reason: collision with root package name */
    private HashMap f11251e = new HashMap();

    @Override // k.b
    protected b.c b(Object obj) {
        return (b.c) this.f11251e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f11251e.containsKey(obj);
    }

    @Override // k.b
    public Object f(Object obj) {
        Object f6 = super.f(obj);
        this.f11251e.remove(obj);
        return f6;
    }

    public Map.Entry g(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f11251e.get(obj)).f11259d;
        }
        return null;
    }

    public Object h(Object obj, Object obj2) {
        b.c b6 = b(obj);
        if (b6 != null) {
            return b6.f11257b;
        }
        this.f11251e.put(obj, e(obj, obj2));
        return null;
    }
}
