package io.jsonwebtoken;

import io.jsonwebtoken.Header;
/* loaded from: classes.dex */
public interface Jwt<H extends Header, B> {
    B getBody();

    H getHeader();
}
