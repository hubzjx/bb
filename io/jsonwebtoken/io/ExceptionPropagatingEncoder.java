package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;
/* loaded from: classes.dex */
class ExceptionPropagatingEncoder<T, R> implements Encoder<T, R> {
    private final Encoder<T, R> encoder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExceptionPropagatingEncoder(Encoder<T, R> encoder) {
        Assert.notNull(encoder, "Encoder cannot be null.");
        this.encoder = encoder;
    }

    @Override // io.jsonwebtoken.io.Encoder
    public R encode(T t5) {
        Assert.notNull(t5, "Encode argument cannot be null.");
        try {
            return this.encoder.encode(t5);
        } catch (EncodingException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new EncodingException("Unable to encode input: " + e7.getMessage(), e7);
        }
    }
}
