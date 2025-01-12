package io.jsonwebtoken.impl;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
@Deprecated
/* loaded from: classes.dex */
public class Base64Codec extends AbstractTextCodec {
    @Override // io.jsonwebtoken.impl.TextCodec
    public byte[] decode(String str) {
        return Decoders.BASE64.decode(str);
    }

    @Override // io.jsonwebtoken.impl.TextCodec
    public String encode(byte[] bArr) {
        return Encoders.BASE64.encode(bArr);
    }
}
