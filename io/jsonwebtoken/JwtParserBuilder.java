package io.jsonwebtoken;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public interface JwtParserBuilder {
    JwtParserBuilder base64UrlDecodeWith(Decoder<String, byte[]> decoder);

    JwtParser build();

    JwtParserBuilder deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    JwtParserBuilder require(String str, Object obj);

    JwtParserBuilder requireAudience(String str);

    JwtParserBuilder requireExpiration(Date date);

    JwtParserBuilder requireId(String str);

    JwtParserBuilder requireIssuedAt(Date date);

    JwtParserBuilder requireIssuer(String str);

    JwtParserBuilder requireNotBefore(Date date);

    JwtParserBuilder requireSubject(String str);

    JwtParserBuilder setAllowedClockSkewSeconds(long j6);

    JwtParserBuilder setClock(Clock clock);

    JwtParserBuilder setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver);

    JwtParserBuilder setSigningKey(String str);

    JwtParserBuilder setSigningKey(Key key);

    JwtParserBuilder setSigningKey(byte[] bArr);

    JwtParserBuilder setSigningKeyResolver(SigningKeyResolver signingKeyResolver);
}
