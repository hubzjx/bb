package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
/* loaded from: classes.dex */
public class RsaSignatureValidator extends RsaProvider implements SignatureValidator {
    private final RsaSigner SIGNER;

    public RsaSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        boolean z5 = key instanceof RSAPrivateKey;
        Assert.isTrue(z5 || (key instanceof RSAPublicKey), "RSA Signature validation requires either a RSAPublicKey or RSAPrivateKey instance.");
        this.SIGNER = z5 ? new RsaSigner(signatureAlgorithm, key) : null;
    }

    protected boolean doVerify(Signature signature, PublicKey publicKey, byte[] bArr, byte[] bArr2) {
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureValidator
    public boolean isValid(byte[] bArr, byte[] bArr2) {
        if (!(this.key instanceof PublicKey)) {
            Assert.notNull(this.SIGNER, "RSA Signer instance cannot be null.  This is a bug.  Please report it.");
            return MessageDigest.isEqual(this.SIGNER.sign(bArr), bArr2);
        }
        try {
            return doVerify(createSignatureInstance(), (PublicKey) this.key, bArr, bArr2);
        } catch (Exception e6) {
            throw new SignatureException("Unable to verify RSA signature using configured PublicKey. " + e6.getMessage(), e6);
        }
    }
}
