package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultClaims extends JwtMap implements Claims {
    private static final String CONVERSION_ERROR_MSG = "Cannot convert existing claim value of type '%s' to desired type '%s'. JJWT only converts simple String, Date, Long, Integer, Short and Byte types automatically. Anything more complex is expected to be already converted to your desired type by the JSON Deserializer implementation. You may specify a custom Deserializer for a JwtParser with the desired conversion configuration via the JwtParserBuilder.deserializeJsonWith() method. See https://github.com/jwtk/jjwt#custom-json-processor for more information. If using Jackson, you can specify custom claim POJO types as described in https://github.com/jwtk/jjwt#json-jackson-custom-types";

    public DefaultClaims() {
    }

    public DefaultClaims(Map<String, ?> map) {
        super(map);
    }

    private <T> T castClaimValue(Object obj, Class<T> cls) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (cls == Long.class) {
                obj = Long.valueOf(intValue);
            } else if (cls == Short.class && -32768 <= intValue && intValue <= 32767) {
                obj = Short.valueOf((short) intValue);
            } else if (cls == Byte.class && -128 <= intValue && intValue <= 127) {
                obj = Byte.valueOf((byte) intValue);
            }
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RequiredTypeException(String.format(CONVERSION_ERROR_MSG, obj.getClass(), cls));
    }

    private static boolean isSpecDate(String str) {
        return Claims.EXPIRATION.equals(str) || Claims.ISSUED_AT.equals(str) || Claims.NOT_BEFORE.equals(str);
    }

    @Override // io.jsonwebtoken.Claims
    public <T> T get(String str, Class<T> cls) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        if (Date.class.equals(cls)) {
            obj = isSpecDate(str) ? JwtMap.toSpecDate(obj, str) : JwtMap.toDate(obj, str);
        }
        return (T) castClaimValue(obj, cls);
    }

    @Override // io.jsonwebtoken.Claims
    public String getAudience() {
        return getString(Claims.AUDIENCE);
    }

    @Override // io.jsonwebtoken.Claims
    public Date getExpiration() {
        return (Date) get(Claims.EXPIRATION, Date.class);
    }

    @Override // io.jsonwebtoken.Claims
    public String getId() {
        return getString(Claims.ID);
    }

    @Override // io.jsonwebtoken.Claims
    public Date getIssuedAt() {
        return (Date) get(Claims.ISSUED_AT, Date.class);
    }

    @Override // io.jsonwebtoken.Claims
    public String getIssuer() {
        return getString(Claims.ISSUER);
    }

    @Override // io.jsonwebtoken.Claims
    public Date getNotBefore() {
        return (Date) get(Claims.NOT_BEFORE, Date.class);
    }

    @Override // io.jsonwebtoken.Claims
    public String getSubject() {
        return getString(Claims.SUBJECT);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setAudience(String str) {
        setValue(Claims.AUDIENCE, str);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setExpiration(Date date) {
        setDateAsSeconds(Claims.EXPIRATION, date);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setId(String str) {
        setValue(Claims.ID, str);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setIssuedAt(Date date) {
        setDateAsSeconds(Claims.ISSUED_AT, date);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setIssuer(String str) {
        setValue(Claims.ISSUER, str);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setNotBefore(Date date) {
        setDateAsSeconds(Claims.NOT_BEFORE, date);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.Claims, io.jsonwebtoken.ClaimsMutator
    public Claims setSubject(String str) {
        setValue(Claims.SUBJECT, str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap, java.util.Map
    public Object put(String str, Object obj) {
        return ((obj instanceof Date) && isSpecDate(str)) ? setDateAsSeconds(str, (Date) obj) : super.put(str, obj);
    }
}
