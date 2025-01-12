package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class EllipticCurveProvider extends SignatureProvider {
    private static final Map<SignatureAlgorithm, String> EC_CURVE_NAMES = createEcCurveNames();

    /* renamed from: io.jsonwebtoken.impl.crypto.EllipticCurveProvider$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;

        static {
            int[] iArr = new int[SignatureAlgorithm.values().length];
            $SwitchMap$io$jsonwebtoken$SignatureAlgorithm = iArr;
            try {
                iArr[SignatureAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EllipticCurveProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm must be an Elliptic Curve algorithm.");
    }

    private static Map<SignatureAlgorithm, String> createEcCurveNames() {
        HashMap hashMap = new HashMap();
        hashMap.put(SignatureAlgorithm.ES256, "secp256r1");
        hashMap.put(SignatureAlgorithm.ES384, "secp384r1");
        hashMap.put(SignatureAlgorithm.ES512, "secp521r1");
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return generateKeyPair(SignatureAlgorithm.ES512);
    }

    public static int getSignatureByteArrayLength(SignatureAlgorithm signatureAlgorithm) {
        int i6 = AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return 132;
                }
                throw new JwtException("Unsupported Algorithm: " + signatureAlgorithm.name());
            }
            return 96;
        }
        return 64;
    }

    public static byte[] transcodeSignatureToConcat(byte[] bArr, int i6) {
        int i7;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new JwtException("Invalid ECDSA signature format");
        }
        byte b6 = bArr[1];
        if (b6 > 0) {
            i7 = 2;
        } else if (b6 != -127) {
            throw new JwtException("Invalid ECDSA signature format");
        } else {
            i7 = 3;
        }
        int i8 = bArr[i7 + 1];
        int i9 = i8;
        while (i9 > 0 && bArr[((i7 + 2) + i8) - i9] == 0) {
            i9--;
        }
        int i10 = i7 + 2 + i8;
        int i11 = bArr[i10 + 1];
        int i12 = i11;
        while (i12 > 0 && bArr[((i10 + 2) + i11) - i12] == 0) {
            i12--;
        }
        int max = Math.max(Math.max(i9, i12), i6 / 2);
        int i13 = bArr[i7 - 1];
        if ((i13 & 255) == bArr.length - i7 && (i13 & 255) == i8 + 2 + 2 + i11 && bArr[i7] == 2 && bArr[i10] == 2) {
            int i14 = max * 2;
            byte[] bArr2 = new byte[i14];
            System.arraycopy(bArr, i10 - i9, bArr2, max - i9, i9);
            System.arraycopy(bArr, ((i10 + 2) + i11) - i12, bArr2, i14 - i12, i12);
            return bArr2;
        }
        throw new JwtException("Invalid ECDSA signature format");
    }

    public static byte[] transcodeSignatureToDER(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length / 2;
        int i6 = length;
        while (i6 > 0 && bArr[length - i6] == 0) {
            i6--;
        }
        int i7 = length - i6;
        int i8 = bArr[i7] < 0 ? i6 + 1 : i6;
        int i9 = length;
        while (i9 > 0 && bArr[(length * 2) - i9] == 0) {
            i9--;
        }
        int i10 = (length * 2) - i9;
        int i11 = bArr[i10] < 0 ? i9 + 1 : i9;
        int i12 = i8 + 2 + 2 + i11;
        if (i12 <= 255) {
            int i13 = 1;
            if (i12 < 128) {
                bArr2 = new byte[i8 + 4 + 2 + i11];
            } else {
                bArr2 = new byte[i8 + 5 + 2 + i11];
                bArr2[1] = -127;
                i13 = 2;
            }
            bArr2[0] = 48;
            int i14 = i13 + 1;
            bArr2[i13] = (byte) i12;
            int i15 = i14 + 1;
            bArr2[i14] = 2;
            bArr2[i15] = (byte) i8;
            int i16 = i15 + 1 + i8;
            System.arraycopy(bArr, i7, bArr2, i16 - i6, i6);
            int i17 = i16 + 1;
            bArr2[i16] = 2;
            bArr2[i17] = (byte) i11;
            System.arraycopy(bArr, i10, bArr2, ((i17 + 1) + i11) - i9, i9);
            return bArr2;
        }
        throw new JwtException("Invalid ECDSA signature format");
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        return generateKeyPair(signatureAlgorithm, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) {
        return generateKeyPair("EC", null, signatureAlgorithm, secureRandom);
    }

    public static KeyPair generateKeyPair(String str, String str2, SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm argument cannot be null.");
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm argument must represent an Elliptic Curve algorithm.");
        try {
            KeyPairGenerator keyPairGenerator = Strings.hasText(str2) ? KeyPairGenerator.getInstance(str, str2) : KeyPairGenerator.getInstance(str);
            keyPairGenerator.initialize(new ECGenParameterSpec(EC_CURVE_NAMES.get(signatureAlgorithm)), secureRandom);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e6) {
            throw new IllegalStateException("Unable to generate Elliptic Curve KeyPair: " + e6.getMessage(), e6);
        }
    }
}
