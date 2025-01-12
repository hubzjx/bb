package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class MacValidator implements SignatureValidator {
    private final MacSigner signer;

    public MacValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        this.signer = new MacSigner(signatureAlgorithm, key);
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureValidator
    public boolean isValid(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(this.signer.sign(bArr), bArr2);
    }
}
