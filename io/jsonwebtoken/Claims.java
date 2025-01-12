package io.jsonwebtoken;

import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public interface Claims extends Map<String, Object>, ClaimsMutator<Claims> {
    public static final String AUDIENCE = "aud";
    public static final String EXPIRATION = "exp";
    public static final String ID = "jti";
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String NOT_BEFORE = "nbf";
    public static final String SUBJECT = "sub";

    <T> T get(String str, Class<T> cls);

    String getAudience();

    Date getExpiration();

    String getId();

    Date getIssuedAt();

    String getIssuer();

    Date getNotBefore();

    String getSubject();

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setAudience(String str);

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setExpiration(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setId(String str);

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setIssuedAt(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setIssuer(String str);

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setNotBefore(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    Claims setSubject(String str);
}
