package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultCompressionCodecResolver implements CompressionCodecResolver {
    private static final String MISSING_COMPRESSION_MESSAGE = "Unable to find an implementation for compression algorithm [%s] using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.";
    private final Map<String, CompressionCodec> codecs;

    public DefaultCompressionCodecResolver() {
        HashMap hashMap = new HashMap();
        for (CompressionCodec compressionCodec : Services.loadAll(CompressionCodec.class)) {
            hashMap.put(compressionCodec.getAlgorithmName().toUpperCase(), compressionCodec);
        }
        CompressionCodec compressionCodec2 = io.jsonwebtoken.CompressionCodecs.DEFLATE;
        hashMap.put(compressionCodec2.getAlgorithmName().toUpperCase(), compressionCodec2);
        CompressionCodec compressionCodec3 = io.jsonwebtoken.CompressionCodecs.GZIP;
        hashMap.put(compressionCodec3.getAlgorithmName().toUpperCase(), compressionCodec3);
        this.codecs = Collections.unmodifiableMap(hashMap);
    }

    private CompressionCodec byName(String str) {
        Assert.hasText(str, "'name' must not be empty");
        CompressionCodec compressionCodec = this.codecs.get(str.toUpperCase());
        if (compressionCodec != null) {
            return compressionCodec;
        }
        throw new CompressionException(String.format(MISSING_COMPRESSION_MESSAGE, str));
    }

    private String getAlgorithmFromHeader(Header header) {
        Assert.notNull(header, "header cannot be null.");
        return header.getCompressionAlgorithm();
    }

    @Override // io.jsonwebtoken.CompressionCodecResolver
    public CompressionCodec resolveCompressionCodec(Header header) {
        String algorithmFromHeader = getAlgorithmFromHeader(header);
        if (Strings.hasText(algorithmFromHeader)) {
            return byName(algorithmFromHeader);
        }
        return null;
    }
}
