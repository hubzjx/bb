package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(ErrorCode errorCode) {
        super(l.i("stream was reset: ", errorCode));
        l.d(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
