package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;
/* loaded from: classes.dex */
class Base64Decoder extends Base64Support implements Decoder<String, byte[]> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Base64Decoder() {
        super(Base64.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Base64Decoder(Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Decoder
    public byte[] decode(String str) {
        Assert.notNull(str, "String argument cannot be null");
        return this.base64.decodeFast(str.toCharArray());
    }
}
