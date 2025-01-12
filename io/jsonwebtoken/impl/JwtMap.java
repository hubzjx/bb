package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class JwtMap implements Map<String, Object> {
    private final Map<String, Object> map;

    public JwtMap() {
        this.map = new LinkedHashMap();
    }

    private static Date parseIso8601Date(String str, String str2) {
        try {
            return DateFormats.parseIso8601Date(str);
        } catch (ParseException e6) {
            throw new IllegalArgumentException("'" + str2 + "' value does not appear to be ISO-8601-formatted: " + str, e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date toDate(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            return parseIso8601Date((String) obj, str);
        }
        throw new IllegalStateException("Cannot create Date from '" + str + "' value '" + obj + "'.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date toSpecDate(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            obj = Long.valueOf(((Number) obj).longValue() * 1000);
        } else if (obj instanceof String) {
            try {
                obj = Long.valueOf(Long.parseLong((String) obj) * 1000);
            } catch (NumberFormatException unused) {
            }
        }
        return toDate(obj, str);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(String str) {
        Object obj = get(str);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            put(str, map.get(str));
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Deprecated
    protected void setDate(String str, Date date) {
        if (date == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, Long.valueOf(date.getTime() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object setDateAsSeconds(String str, Date date) {
        return date == null ? this.map.remove(str) : this.map.put(str, Long.valueOf(date.getTime() / 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setValue(String str, Object obj) {
        if (obj == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, obj);
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.map.toString();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    public JwtMap(Map<String, ?> map) {
        this();
        Assert.notNull(map, "Map argument cannot be null.");
        putAll(map);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return obj == null ? this.map.remove(str) : this.map.put(str, obj);
    }
}
