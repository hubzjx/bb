package io.jsonwebtoken;
/* loaded from: classes.dex */
public interface Jws<B> extends Jwt<JwsHeader, B> {
    String getSignature();
}
