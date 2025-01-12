package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultHeader<T extends Header<T>> extends JwtMap implements Header<T> {
    public DefaultHeader() {
    }

    public DefaultHeader(Map<String, Object> map) {
        super(map);
    }

    @Override // io.jsonwebtoken.Header
    public String getCompressionAlgorithm() {
        String string = getString(Header.COMPRESSION_ALGORITHM);
        return !Strings.hasText(string) ? getString(Header.DEPRECATED_COMPRESSION_ALGORITHM) : string;
    }

    @Override // io.jsonwebtoken.Header
    public String getContentType() {
        return getString(Header.CONTENT_TYPE);
    }

    @Override // io.jsonwebtoken.Header
    public String getType() {
        return getString(Header.TYPE);
    }

    @Override // io.jsonwebtoken.Header
    public T setCompressionAlgorithm(String str) {
        setValue(Header.COMPRESSION_ALGORITHM, str);
        return this;
    }

    @Override // io.jsonwebtoken.Header
    public T setContentType(String str) {
        setValue(Header.CONTENT_TYPE, str);
        return this;
    }

    @Override // io.jsonwebtoken.Header
    public T setType(String str) {
        setValue(Header.TYPE, str);
        return this;
    }
}
