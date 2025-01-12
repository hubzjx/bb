package l;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
/* loaded from: classes.dex */
public class a extends g implements Map, j$.util.Map {

    /* renamed from: h  reason: collision with root package name */
    f f11351h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0188a extends f {
        C0188a() {
        }

        @Override // l.f
        protected void a() {
            a.this.clear();
        }

        @Override // l.f
        protected Object b(int i6, int i7) {
            return a.this.f11400b[(i6 << 1) + i7];
        }

        @Override // l.f
        protected Map c() {
            return a.this;
        }

        @Override // l.f
        protected int d() {
            return a.this.f11401c;
        }

        @Override // l.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // l.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // l.f
        protected void g(Object obj, Object obj2) {
            a.this.put(obj, obj2);
        }

        @Override // l.f
        protected void h(int i6) {
            a.this.k(i6);
        }

        @Override // l.f
        protected Object i(int i6, Object obj) {
            return a.this.l(i6, obj);
        }
    }

    public a() {
    }

    public a(int i6) {
        super(i6);
    }

    private f n() {
        if (this.f11351h == null) {
            this.f11351h = new C0188a();
        }
        return this.f11351h;
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map
    public Set entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.Map
    public Set keySet() {
        return n().m();
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public boolean o(Collection collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f11401c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map
    public Collection values() {
        return n().n();
    }

    public a(g gVar) {
        super(gVar);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, j$.util.function.BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, j$.util.function.Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, j$.util.function.BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(j$.util.function.BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, j$.util.function.BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(j$.util.function.BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }
}
