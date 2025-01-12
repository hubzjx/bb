package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;
/* loaded from: classes.dex */
class ExceptionPropagatingDecoder<T, R> implements Decoder<T, R> {
    private final Decoder<T, R> decoder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExceptionPropagatingDecoder(Decoder<T, R> decoder) {
        Assert.notNull(decoder, "Decoder cannot be null.");
        this.decoder = decoder;
    }

    @Override // io.jsonwebtoken.io.Decoder
    public R decode(T t5) {
        Assert.notNull(t5, "Decode argument cannot be null.");
        try {
            return this.decoder.decode(t5);
        } catch (DecodingException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new DecodingException("Unable to decode input: " + e7.getMessage(), e7);
        }
    }
}
