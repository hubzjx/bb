package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;
import io.jsonwebtoken.impl.lang.LegacyServices;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class DefaultJwtParser implements JwtParser {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private long allowedClockSkewMillis;
    private Decoder<String, byte[]> base64UrlDecoder;
    private Clock clock;
    private CompressionCodecResolver compressionCodecResolver;
    private Deserializer<Map<String, ?>> deserializer;
    private Claims expectedClaims;
    private Key key;
    private byte[] keyBytes;
    private SigningKeyResolver signingKeyResolver;

    @Deprecated
    public DefaultJwtParser() {
        this.compressionCodecResolver = new DefaultCompressionCodecResolver();
        this.base64UrlDecoder = Decoders.BASE64URL;
        this.expectedClaims = new DefaultClaims();
        this.clock = DefaultClock.INSTANCE;
        this.allowedClockSkewMillis = 0L;
    }

    private static Object normalize(Object obj) {
        return obj instanceof Integer ? Long.valueOf(((Integer) obj).longValue()) : obj;
    }

    private void validateExpectedClaims(Header header, Claims claims) {
        InvalidClaimException invalidClaimException;
        for (String str : this.expectedClaims.keySet()) {
            Object normalize = normalize(this.expectedClaims.get(str));
            Object normalize2 = normalize(claims.get(str));
            if (normalize instanceof Date) {
                try {
                    normalize2 = claims.get(str, Date.class);
                } catch (Exception unused) {
                    throw new IncorrectClaimException(header, claims, "JWT Claim '" + str + "' was expected to be a Date, but its value cannot be converted to a Date using current heuristics.  Value: " + normalize2);
                }
            }
            if (normalize2 == null) {
                invalidClaimException = new MissingClaimException(header, claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, str, normalize));
                continue;
            } else if (normalize.equals(normalize2)) {
                invalidClaimException = null;
                continue;
            } else {
                invalidClaimException = new IncorrectClaimException(header, claims, String.format(ClaimJwtException.INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE, str, normalize, normalize2));
                continue;
            }
            if (invalidClaimException != null) {
                invalidClaimException.setClaimName(str);
                invalidClaimException.setClaimValue(normalize);
                throw invalidClaimException;
            }
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.base64UrlDecoder = decoder;
        return this;
    }

    protected JwtSignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        return new DefaultJwtSignatureValidator(signatureAlgorithm, key, this.base64UrlDecoder);
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        Assert.notNull(deserializer, "deserializer cannot be null.");
        this.deserializer = deserializer;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public boolean isSigned(String str) {
        if (str == null) {
            return false;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char charAt = str.charAt(i7);
            if (i6 == 2) {
                return (Character.isWhitespace(charAt) || charAt == '.') ? false : true;
            }
            if (charAt == '.') {
                i6++;
            }
        }
        return false;
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt parse(String str) {
        CompressionCodec compressionCodec;
        JwsHeader jwsHeader;
        String str2;
        Claims claims;
        long j6;
        long j7;
        SigningKeyResolver signingKeyResolver;
        if (this.deserializer == null) {
            this.deserializer = (Deserializer) LegacyServices.loadFirst(Deserializer.class);
        }
        Assert.hasText(str, "JWT String argument cannot be null or empty.");
        if ("..".equals(str)) {
            throw new MalformedJwtException("JWT string '..' is missing a header.");
        }
        StringBuilder sb = new StringBuilder(128);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        SignatureAlgorithm signatureAlgorithm = null;
        String str3 = null;
        String str4 = null;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char c6 = charArray[i6];
            if (c6 == '.') {
                CharSequence clean = Strings.clean(sb);
                String charSequence = clean != null ? clean.toString() : null;
                if (i7 == 0) {
                    str3 = charSequence;
                } else if (i7 == 1) {
                    str4 = charSequence;
                }
                i7++;
                sb.setLength(0);
            } else {
                sb.append(c6);
            }
            i6++;
        }
        if (i7 != 2) {
            throw new MalformedJwtException("JWT strings must contain exactly 2 period characters. Found: " + i7);
        }
        String sb2 = sb.length() > 0 ? sb.toString() : null;
        if (str3 != null) {
            Map<String, ?> readValue = readValue(new String(this.base64UrlDecoder.decode(str3), Strings.UTF_8));
            jwsHeader = sb2 != null ? new DefaultJwsHeader(readValue) : new DefaultHeader(readValue);
            compressionCodec = this.compressionCodecResolver.resolveCompressionCodec(jwsHeader);
        } else {
            compressionCodec = null;
            jwsHeader = null;
        }
        if (str4 != null) {
            byte[] decode = this.base64UrlDecoder.decode(str4);
            if (compressionCodec != null) {
                decode = compressionCodec.decompress(decode);
            }
            str2 = new String(decode, Strings.UTF_8);
        } else {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        DefaultClaims defaultClaims = (!str2.isEmpty() && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}') ? new DefaultClaims(readValue(str2)) : null;
        if (sb2 != null) {
            JwsHeader jwsHeader2 = jwsHeader;
            if (jwsHeader != null) {
                String algorithm = jwsHeader2.getAlgorithm();
                if (Strings.hasText(algorithm)) {
                    signatureAlgorithm = SignatureAlgorithm.forName(algorithm);
                }
            }
            if (signatureAlgorithm == null || signatureAlgorithm == SignatureAlgorithm.NONE) {
                throw new MalformedJwtException("JWT string has a digest/signature, but the header does not reference a valid signature algorithm.");
            }
            Key key = this.key;
            if (key != null && this.keyBytes != null) {
                throw new IllegalStateException("A key object and key bytes cannot both be specified. Choose either.");
            }
            if ((key != null || this.keyBytes != null) && this.signingKeyResolver != null) {
                throw new IllegalStateException("A signing key resolver and " + (key != null ? "a key object" : "key bytes") + " cannot both be specified. Choose either.");
            }
            if (key == null) {
                byte[] bArr = this.keyBytes;
                if (Objects.isEmpty(bArr) && (signingKeyResolver = this.signingKeyResolver) != null) {
                    key = defaultClaims != null ? signingKeyResolver.resolveSigningKey(jwsHeader2, defaultClaims) : signingKeyResolver.resolveSigningKey(jwsHeader2, str2);
                }
                if (!Objects.isEmpty(bArr)) {
                    Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes can only be specified for HMAC signatures. Please specify a PublicKey or PrivateKey instance.");
                    key = new SecretKeySpec(bArr, signatureAlgorithm.getJcaName());
                }
            }
            Assert.notNull(key, "A signing key must be specified if the specified JWT is digitally signed.");
            String str5 = str3 + JwtParser.SEPARATOR_CHAR;
            if (str4 != null) {
                str5 = str5 + str4;
            }
            try {
                signatureAlgorithm.assertValidVerificationKey(key);
                if (!createSignatureValidator(signatureAlgorithm, key).isValid(str5, sb2)) {
                    throw new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                }
            } catch (WeakKeyException e6) {
                throw e6;
            } catch (InvalidKeyException e7) {
                e = e7;
                String value = signatureAlgorithm.getValue();
                throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the " + value + " signature algorithm, but the specified signing key of type " + key.getClass().getName() + " may not be used to validate " + value + " signatures.  Because the specified signing key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was configured with the incorrect signing key, but this cannot be assumed for security reasons.", e);
            } catch (IllegalArgumentException e8) {
                e = e8;
                String value2 = signatureAlgorithm.getValue();
                throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the " + value2 + " signature algorithm, but the specified signing key of type " + key.getClass().getName() + " may not be used to validate " + value2 + " signatures.  Because the specified signing key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was configured with the incorrect signing key, but this cannot be assumed for security reasons.", e);
            }
        }
        boolean z5 = this.allowedClockSkewMillis > 0;
        if (defaultClaims != null) {
            Date now = this.clock.now();
            long time = now.getTime();
            Date expiration = defaultClaims.getExpiration();
            if (expiration != null) {
                claims = str2;
                if ((z5 ? new Date(time - this.allowedClockSkewMillis) : now).after(expiration)) {
                    throw new ExpiredJwtException(jwsHeader, defaultClaims, "JWT expired at " + DateFormats.formatIso8601(expiration, false) + ". Current time: " + DateFormats.formatIso8601(now, false) + ", a difference of " + (j7 - expiration.getTime()) + " milliseconds.  Allowed clock skew: " + this.allowedClockSkewMillis + " milliseconds.");
                }
            } else {
                claims = str2;
            }
            Date notBefore = defaultClaims.getNotBefore();
            if (notBefore != null) {
                if ((z5 ? new Date(time + this.allowedClockSkewMillis) : now).before(notBefore)) {
                    throw new PrematureJwtException(jwsHeader, defaultClaims, "JWT must not be accepted before " + DateFormats.formatIso8601(notBefore, false) + ". Current time: " + DateFormats.formatIso8601(now, false) + ", a difference of " + (notBefore.getTime() - j6) + " milliseconds.  Allowed clock skew: " + this.allowedClockSkewMillis + " milliseconds.");
                }
            }
            validateExpectedClaims(jwsHeader, defaultClaims);
        } else {
            claims = str2;
        }
        DefaultClaims defaultClaims2 = defaultClaims != null ? defaultClaims : claims;
        return sb2 != null ? new DefaultJws(jwsHeader, defaultClaims2, sb2) : new DefaultJwt(jwsHeader, defaultClaims2);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<Claims> parseClaimsJws(String str) {
        return (Jws) parse(str, new JwtHandlerAdapter<Jws<Claims>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.4
            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public Jws<Claims> onClaimsJws(Jws<Claims> jws) {
                return jws;
            }

            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public /* bridge */ /* synthetic */ Object onClaimsJws(Jws jws) {
                return onClaimsJws((Jws<Claims>) jws);
            }
        });
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, Claims> parseClaimsJwt(String str) {
        try {
            return (Jwt) parse(str, new JwtHandlerAdapter<Jwt<Header, Claims>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.2
                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public Jwt<Header, Claims> onClaimsJwt(Jwt<Header, Claims> jwt) {
                    return jwt;
                }

                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public /* bridge */ /* synthetic */ Object onClaimsJwt(Jwt jwt) {
                    return onClaimsJwt((Jwt<Header, Claims>) jwt);
                }
            });
        } catch (IllegalArgumentException e6) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", e6);
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<String> parsePlaintextJws(String str) {
        try {
            return (Jws) parse(str, new JwtHandlerAdapter<Jws<String>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.3
                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public Jws<String> onPlaintextJws(Jws<String> jws) {
                    return jws;
                }

                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public /* bridge */ /* synthetic */ Object onPlaintextJws(Jws jws) {
                    return onPlaintextJws((Jws<String>) jws);
                }
            });
        } catch (IllegalArgumentException e6) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", e6);
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, String> parsePlaintextJwt(String str) {
        return (Jwt) parse(str, new JwtHandlerAdapter<Jwt<Header, String>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.1
            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public Jwt<Header, String> onPlaintextJwt(Jwt<Header, String> jwt) {
                return jwt;
            }

            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public /* bridge */ /* synthetic */ Object onPlaintextJwt(Jwt jwt) {
                return onPlaintextJwt((Jwt<Header, String>) jwt);
            }
        });
    }

    protected Map<String, ?> readValue(String str) {
        try {
            return this.deserializer.deserialize(str.getBytes(Strings.UTF_8));
        } catch (DeserializationException e6) {
            throw new MalformedJwtException("Unable to read JSON value: " + str, e6);
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser require(String str, Object obj) {
        Assert.hasText(str, "claim name cannot be null or empty.");
        Assert.notNull(obj, "The value cannot be null for claim name: " + str);
        this.expectedClaims.put(str, obj);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireAudience(String str) {
        this.expectedClaims.setAudience(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireId(String str) {
        this.expectedClaims.setId(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuer(String str) {
        this.expectedClaims.setIssuer(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireSubject(String str) {
        this.expectedClaims.setSubject(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setAllowedClockSkewSeconds(long j6) {
        Assert.isTrue(j6 <= 9223372036854775L, "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.");
        this.allowedClockSkewMillis = Math.max(0L, j6 * 1000);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setClock(Clock clock) {
        Assert.notNull(clock, "Clock instance cannot be null.");
        this.clock = clock;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        Assert.notNull(compressionCodecResolver, "compressionCodecResolver cannot be null.");
        this.compressionCodecResolver = compressionCodecResolver;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(String str) {
        Assert.hasText(str, "signing key cannot be null or empty.");
        this.keyBytes = Decoders.BASE64.decode(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        Assert.notNull(signingKeyResolver, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultJwtParser(SigningKeyResolver signingKeyResolver, Key key, byte[] bArr, Clock clock, long j6, Claims claims, Decoder<String, byte[]> decoder, Deserializer<Map<String, ?>> deserializer, CompressionCodecResolver compressionCodecResolver) {
        this.compressionCodecResolver = new DefaultCompressionCodecResolver();
        this.base64UrlDecoder = Decoders.BASE64URL;
        this.expectedClaims = new DefaultClaims();
        Clock clock2 = DefaultClock.INSTANCE;
        this.signingKeyResolver = signingKeyResolver;
        this.key = key;
        this.keyBytes = bArr;
        this.clock = clock;
        this.allowedClockSkewMillis = j6;
        this.expectedClaims = claims;
        this.base64UrlDecoder = decoder;
        this.deserializer = deserializer;
        this.compressionCodecResolver = compressionCodecResolver;
    }

    @Override // io.jsonwebtoken.JwtParser
    public <T> T parse(String str, JwtHandler<T> jwtHandler) {
        Assert.notNull(jwtHandler, "JwtHandler argument cannot be null.");
        Assert.hasText(str, "JWT String argument cannot be null or empty.");
        Jwt<Header, String> parse = parse(str);
        if (!(parse instanceof Jws)) {
            return parse.getBody() instanceof Claims ? jwtHandler.onClaimsJwt(parse) : jwtHandler.onPlaintextJwt(parse);
        }
        Jws<String> jws = (Jws) parse;
        return jws.getBody() instanceof Claims ? jwtHandler.onClaimsJws(jws) : jwtHandler.onPlaintextJws(jws);
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(Key key) {
        Assert.notNull(key, "signing key cannot be null.");
        this.key = key;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signing key cannot be null or empty.");
        this.keyBytes = bArr;
        return this;
    }
}
