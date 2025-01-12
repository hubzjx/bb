package io.jsonwebtoken.orgjson.io;

import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OrgJsonSerializer<T> implements Serializer<T> {
    private static final Class JSON_STRING_CLASS;
    private static final String JSON_STRING_CLASS_NAME = "org.json.JSONString";
    private static final String JSON_WRITER_CLASS_NAME = "org.json.JSONWriter";
    private static final Class[] VALUE_TO_STRING_ARG_TYPES = {Object.class};

    static {
        JSON_STRING_CLASS = Classes.isAvailable(JSON_STRING_CLASS_NAME) ? Classes.forName(JSON_STRING_CLASS_NAME) : null;
    }

    private static boolean isJSONString(Object obj) {
        Class cls = JSON_STRING_CLASS;
        if (cls != null) {
            return cls.isInstance(obj);
        }
        return false;
    }

    private JSONArray toJSONArray(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : collection) {
            jSONArray.put(toJSONInstance(obj));
        }
        return jSONArray;
    }

    private Object toJSONInstance(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray) || JSONObject.NULL.equals(obj) || isJSONString(obj) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof BigInteger) || (obj instanceof BigDecimal) || (obj instanceof Enum)) {
            return obj;
        }
        if (obj instanceof Calendar) {
            obj = ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return DateFormats.formatIso8601((Date) obj);
        }
        if (obj instanceof byte[]) {
            return Encoders.BASE64.encode((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return new String((char[]) obj);
        }
        if (obj instanceof Map) {
            return toJSONObject((Map) obj);
        }
        if (obj instanceof Collection) {
            return toJSONArray((Collection) obj);
        }
        if (Objects.isArray(obj)) {
            return toJSONArray(Collections.arrayToList(obj));
        }
        throw new SerializationException("Unable to serialize object of type " + obj.getClass().getName() + " to JSON using known heuristics.");
    }

    private JSONObject toJSONObject(Map<?, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            jSONObject.put(String.valueOf(entry.getKey()), toJSONInstance(entry.getValue()));
        }
        return jSONObject;
    }

    @Override // io.jsonwebtoken.io.Serializer
    public byte[] serialize(T t5) {
        try {
            return toBytes(toJSONInstance(t5));
        } catch (SerializationException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new SerializationException("Unable to serialize object of type " + t5.getClass().getName() + " to JSON: " + e7.getMessage(), e7);
        }
    }

    protected byte[] toBytes(Object obj) {
        return (obj instanceof JSONObject ? obj.toString() : (String) Classes.invokeStatic(JSON_WRITER_CLASS_NAME, "valueToString", VALUE_TO_STRING_ARG_TYPES, obj)).getBytes(Strings.UTF_8);
    }
}
