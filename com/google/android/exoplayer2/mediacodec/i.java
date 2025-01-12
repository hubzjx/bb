package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public class i extends com.google.android.exoplayer2.decoder.i {
    public final j codecInfo;
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i(Throwable th, j jVar) {
        super(r1.length() != 0 ? "Decoder failed: ".concat(r1) : new String("Decoder failed: "), th);
        String valueOf = String.valueOf(jVar == null ? null : jVar.f3861a);
        this.codecInfo = jVar;
        this.diagnosticInfo = s0.f4673a >= 21 ? getDiagnosticInfoV21(th) : null;
    }

    private static String getDiagnosticInfoV21(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
