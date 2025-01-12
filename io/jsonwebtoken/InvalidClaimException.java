package io.jsonwebtoken;
/* loaded from: classes.dex */
public class InvalidClaimException extends ClaimJwtException {
    private String claimName;
    private Object claimValue;

    /* JADX INFO: Access modifiers changed from: protected */
    public InvalidClaimException(Header header, Claims claims, String str) {
        super(header, claims, str);
    }

    public String getClaimName() {
        return this.claimName;
    }

    public Object getClaimValue() {
        return this.claimValue;
    }

    public void setClaimName(String str) {
        this.claimName = str;
    }

    public void setClaimValue(Object obj) {
        this.claimValue = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InvalidClaimException(Header header, Claims claims, String str, Throwable th) {
        super(header, claims, str, th);
    }
}
