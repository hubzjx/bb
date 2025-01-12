package io.jsonwebtoken.impl;

import io.jsonwebtoken.JwsHeader;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultJwsHeader extends DefaultHeader implements JwsHeader {
    public DefaultJwsHeader() {
    }

    public DefaultJwsHeader(Map<String, Object> map) {
        super(map);
    }

    @Override // io.jsonwebtoken.JwsHeader
    public String getAlgorithm() {
        return getString(JwsHeader.ALGORITHM);
    }

    @Override // io.jsonwebtoken.JwsHeader
    public String getKeyId() {
        return getString(JwsHeader.KEY_ID);
    }

    @Override // io.jsonwebtoken.JwsHeader
    public JwsHeader setAlgorithm(String str) {
        setValue(JwsHeader.ALGORITHM, str);
        return this;
    }

    @Override // io.jsonwebtoken.JwsHeader
    public JwsHeader setKeyId(String str) {
        setValue(JwsHeader.KEY_ID, str);
        return this;
    }
}
