package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSigner;
import io.jsonwebtoken.impl.crypto.JwtSigner;
import io.jsonwebtoken.impl.lang.LegacyServices;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class DefaultJwtBuilder implements JwtBuilder {
    private SignatureAlgorithm algorithm;
    private Encoder<byte[], String> base64UrlEncoder = Encoders.BASE64URL;
    private Claims claims;
    private CompressionCodec compressionCodec;
    private Header header;
    private Key key;
    private String payload;
    private Serializer<Map<String, ?>> serializer;

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder addClaims(Map<String, Object> map) {
        ensureClaims().putAll(map);
        return this;
    }

    @Deprecated
    protected String base64UrlEncode(Object obj, String str) {
        Assert.isInstanceOf(Map.class, obj, "object argument must be a map.");
        try {
            return this.base64UrlEncoder.encode(toJson((Map) obj));
        } catch (SerializationException e6) {
            throw new IllegalStateException(str, e6);
        }
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder) {
        Assert.notNull(encoder, "base64UrlEncoder cannot be null.");
        this.base64UrlEncoder = encoder;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder claim(String str, Object obj) {
        Assert.hasText(str, "Claim property name cannot be null or empty.");
        Claims claims = this.claims;
        if (claims != null) {
            if (obj == null) {
                claims.remove(str);
            }
            claims.put(str, obj);
        } else if (obj != null) {
            claims = ensureClaims();
            claims.put(str, obj);
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public String compact() {
        if (this.serializer == null) {
            this.serializer = (Serializer) LegacyServices.loadFirst(Serializer.class);
        }
        if (this.payload == null && Collections.isEmpty(this.claims)) {
            this.payload = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (this.payload == null || Collections.isEmpty(this.claims)) {
            Header ensureHeader = ensureHeader();
            JwsHeader defaultJwsHeader = ensureHeader instanceof JwsHeader ? (JwsHeader) ensureHeader : new DefaultJwsHeader(ensureHeader);
            defaultJwsHeader.setAlgorithm((this.key != null ? this.algorithm : SignatureAlgorithm.NONE).getValue());
            CompressionCodec compressionCodec = this.compressionCodec;
            if (compressionCodec != null) {
                defaultJwsHeader.setCompressionAlgorithm(compressionCodec.getAlgorithmName());
            }
            String base64UrlEncode = base64UrlEncode(defaultJwsHeader, "Unable to serialize header to json.");
            try {
                String str = this.payload;
                byte[] bytes = str != null ? str.getBytes(Strings.UTF_8) : toJson(this.claims);
                CompressionCodec compressionCodec2 = this.compressionCodec;
                if (compressionCodec2 != null) {
                    bytes = compressionCodec2.compress(bytes);
                }
                String str2 = base64UrlEncode + JwtParser.SEPARATOR_CHAR + this.base64UrlEncoder.encode(bytes);
                Key key = this.key;
                if (key == null) {
                    return str2 + JwtParser.SEPARATOR_CHAR;
                }
                return str2 + JwtParser.SEPARATOR_CHAR + createSigner(this.algorithm, key).sign(str2);
            } catch (SerializationException e6) {
                throw new IllegalArgumentException("Unable to serialize claims object to json: " + e6.getMessage(), e6);
            }
        }
        throw new IllegalStateException("Both 'payload' and 'claims' cannot both be specified. Choose either one.");
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder compressWith(CompressionCodec compressionCodec) {
        Assert.notNull(compressionCodec, "compressionCodec cannot be null");
        this.compressionCodec = compressionCodec;
        return this;
    }

    protected JwtSigner createSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        return new DefaultJwtSigner(signatureAlgorithm, key, this.base64UrlEncoder);
    }

    protected Claims ensureClaims() {
        if (this.claims == null) {
            this.claims = new DefaultClaims();
        }
        return this.claims;
    }

    protected Header ensureHeader() {
        if (this.header == null) {
            this.header = new DefaultHeader();
        }
        return this.header;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer) {
        Assert.notNull(serializer, "Serializer cannot be null.");
        this.serializer = serializer;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setClaims(Claims claims) {
        this.claims = claims;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeader(Header header) {
        this.header = header;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeaderParam(String str, Object obj) {
        ensureHeader().put(str, obj);
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeaderParams(Map<String, Object> map) {
        if (!Collections.isEmpty(map)) {
            Header ensureHeader = ensureHeader();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                ensureHeader.put(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setPayload(String str) {
        this.payload = str;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str) {
        Assert.hasText(str, "base64-encoded secret key cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Base64-encoded key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(signatureAlgorithm, Decoders.BASE64.decode(str));
    }

    @Deprecated
    protected byte[] toJson(Object obj) {
        Assert.isInstanceOf(Map.class, obj, "object argument must be a map.");
        return this.serializer.serialize((Map) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != null) goto L4;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setAudience(String str) {
        Claims claims = Strings.hasText(str) ? ensureClaims() : this.claims;
        claims.setAudience(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setClaims(Map<String, ?> map) {
        this.claims = new DefaultClaims(map);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r0 != null) goto L3;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setExpiration(Date date) {
        Claims claims = date != null ? ensureClaims() : this.claims;
        claims.setExpiration(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeader(Map<String, Object> map) {
        this.header = new DefaultHeader(map);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != null) goto L4;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setId(String str) {
        Claims claims = Strings.hasText(str) ? ensureClaims() : this.claims;
        claims.setId(str);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r0 != null) goto L3;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setIssuedAt(Date date) {
        Claims claims = date != null ? ensureClaims() : this.claims;
        claims.setIssuedAt(date);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != null) goto L4;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setIssuer(String str) {
        Claims claims = Strings.hasText(str) ? ensureClaims() : this.claims;
        claims.setIssuer(str);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r0 != null) goto L3;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setNotBefore(Date date) {
        Claims claims = date != null ? ensureClaims() : this.claims;
        claims.setNotBefore(date);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != null) goto L4;
     */
    @Override // io.jsonwebtoken.JwtBuilder, io.jsonwebtoken.ClaimsMutator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JwtBuilder setSubject(String str) {
        Claims claims = Strings.hasText(str) ? ensureClaims() : this.claims;
        claims.setSubject(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key) {
        return signWith(key, signatureAlgorithm);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notEmpty(bArr, "secret key byte array cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()), signatureAlgorithm);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(Key key) {
        Assert.notNull(key, "Key argument cannot be null.");
        return signWith(key, SignatureAlgorithm.forSigningKey(key));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(Key key, SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(key, "Key argument cannot be null.");
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        signatureAlgorithm.assertValidSigningKey(key);
        this.algorithm = signatureAlgorithm;
        this.key = key;
        return this;
    }
}
