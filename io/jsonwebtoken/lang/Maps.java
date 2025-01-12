package io.jsonwebtoken.lang;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class Maps {

    /* loaded from: classes.dex */
    private static class HashMapBuilder<K, V> implements MapBuilder<K, V> {
        private final Map<K, V> data;

        private HashMapBuilder() {
            this.data = new HashMap();
        }

        @Override // io.jsonwebtoken.lang.Maps.MapBuilder
        public MapBuilder<K, V> and(K k6, V v5) {
            this.data.put(k6, v5);
            return this;
        }

        @Override // io.jsonwebtoken.lang.Maps.MapBuilder
        public Map<K, V> build() {
            return java.util.Collections.unmodifiableMap(this.data);
        }
    }

    /* loaded from: classes.dex */
    public interface MapBuilder<K, V> {
        MapBuilder<K, V> and(K k6, V v5);

        Map<K, V> build();
    }

    private Maps() {
    }

    public static <K, V> MapBuilder<K, V> of(K k6, V v5) {
        return new HashMapBuilder().and(k6, v5);
    }
}
