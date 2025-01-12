package io.jsonwebtoken;
/* loaded from: classes.dex */
public class JwtHandlerAdapter<T> implements JwtHandler<T> {
    @Override // io.jsonwebtoken.JwtHandler
    public T onClaimsJws(Jws<Claims> jws) {
        throw new UnsupportedJwtException("Signed Claims JWSs are not supported.");
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onClaimsJwt(Jwt<Header, Claims> jwt) {
        throw new UnsupportedJwtException("Unsigned Claims JWTs are not supported.");
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onPlaintextJws(Jws<String> jws) {
        throw new UnsupportedJwtException("Signed plaintext JWSs are not supported.");
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onPlaintextJwt(Jwt<Header, String> jwt) {
        throw new UnsupportedJwtException("Unsigned plaintext JWTs are not supported.");
    }
}
