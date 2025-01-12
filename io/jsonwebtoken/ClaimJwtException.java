package io.jsonwebtoken;
/* loaded from: classes.dex */
public abstract class ClaimJwtException extends JwtException {
    public static final String INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was: %s.";
    public static final String MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was not present in the JWT claims.";
    private final Claims claims;
    private final Header header;

    /* JADX INFO: Access modifiers changed from: protected */
    public ClaimJwtException(Header header, Claims claims, String str) {
        super(str);
        this.header = header;
        this.claims = claims;
    }

    public Claims getClaims() {
        return this.claims;
    }

    public Header getHeader() {
        return this.header;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClaimJwtException(Header header, Claims claims, String str, Throwable th) {
        super(str, th);
        this.header = header;
        this.claims = claims;
    }
}
