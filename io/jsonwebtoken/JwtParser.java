package io.jsonwebtoken;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public interface JwtParser {
    public static final char SEPARATOR_CHAR = '.';

    @Deprecated
    JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder);

    @Deprecated
    JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    boolean isSigned(String str);

    Jwt parse(String str);

    <T> T parse(String str, JwtHandler<T> jwtHandler);

    Jws<Claims> parseClaimsJws(String str);

    Jwt<Header, Claims> parseClaimsJwt(String str);

    Jws<String> parsePlaintextJws(String str);

    Jwt<Header, String> parsePlaintextJwt(String str);

    @Deprecated
    JwtParser require(String str, Object obj);

    @Deprecated
    JwtParser requireAudience(String str);

    @Deprecated
    JwtParser requireExpiration(Date date);

    @Deprecated
    JwtParser requireId(String str);

    @Deprecated
    JwtParser requireIssuedAt(Date date);

    @Deprecated
    JwtParser requireIssuer(String str);

    @Deprecated
    JwtParser requireNotBefore(Date date);

    @Deprecated
    JwtParser requireSubject(String str);

    @Deprecated
    JwtParser setAllowedClockSkewSeconds(long j6);

    @Deprecated
    JwtParser setClock(Clock clock);

    @Deprecated
    JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver);

    @Deprecated
    JwtParser setSigningKey(String str);

    @Deprecated
    JwtParser setSigningKey(Key key);

    @Deprecated
    JwtParser setSigningKey(byte[] bArr);

    @Deprecated
    JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver);
}
