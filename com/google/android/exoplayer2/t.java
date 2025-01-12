package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import w1.v;
/* loaded from: classes.dex */
public final class t extends Exception {
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    public final v.a mediaPeriodId;
    public final s0 rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final int timeoutOperation;
    public final long timestampMs;
    public final int type;

    private t(int i6, String str) {
        this(i6, null, str, null, -1, null, 4, 0);
    }

    public static t createForOutOfMemory(OutOfMemoryError outOfMemoryError) {
        return new t(4, outOfMemoryError);
    }

    public static t createForRemote(String str) {
        return new t(3, str);
    }

    public static t createForRenderer(Exception exc, String str, int i6, s0 s0Var, int i7) {
        return new t(1, exc, null, str, i6, s0Var, s0Var == null ? 4 : i7, 0);
    }

    public static t createForSource(IOException iOException) {
        return new t(0, iOException);
    }

    public static t createForTimeout(TimeoutException timeoutException, int i6) {
        return new t(5, timeoutException, null, null, -1, null, 4, i6);
    }

    public static t createForUnexpected(RuntimeException runtimeException) {
        return new t(2, runtimeException);
    }

    private static String deriveMessage(int i6, String str, String str2, int i7, s0 s0Var, int i8) {
        String str3;
        if (i6 == 0) {
            str3 = "Source error";
        } else if (i6 != 1) {
            str3 = i6 != 3 ? i6 != 4 ? i6 != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            String valueOf = String.valueOf(s0Var);
            String e6 = o1.e(i8);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 53 + valueOf.length() + String.valueOf(e6).length());
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i7);
            sb.append(", format=");
            sb.append(valueOf);
            sb.append(", format_supported=");
            sb.append(e6);
            str3 = sb.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String valueOf2 = String.valueOf(str3);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 2 + String.valueOf(str).length());
        sb2.append(valueOf2);
        sb2.append(": ");
        sb2.append(str);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t copyWithMediaPeriodId(v.a aVar) {
        return new t(getMessage(), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, aVar, this.timeoutOperation, this.timestampMs);
    }

    public OutOfMemoryError getOutOfMemoryError() {
        com.google.android.exoplayer2.util.a.g(this.type == 4);
        return (OutOfMemoryError) com.google.android.exoplayer2.util.a.e(this.cause);
    }

    public Exception getRendererException() {
        com.google.android.exoplayer2.util.a.g(this.type == 1);
        return (Exception) com.google.android.exoplayer2.util.a.e(this.cause);
    }

    public IOException getSourceException() {
        com.google.android.exoplayer2.util.a.g(this.type == 0);
        return (IOException) com.google.android.exoplayer2.util.a.e(this.cause);
    }

    public TimeoutException getTimeoutException() {
        com.google.android.exoplayer2.util.a.g(this.type == 5);
        return (TimeoutException) com.google.android.exoplayer2.util.a.e(this.cause);
    }

    public RuntimeException getUnexpectedException() {
        com.google.android.exoplayer2.util.a.g(this.type == 2);
        return (RuntimeException) com.google.android.exoplayer2.util.a.e(this.cause);
    }

    private t(int i6, Throwable th) {
        this(i6, th, null, null, -1, null, 4, 0);
    }

    private t(int i6, Throwable th, String str, String str2, int i7, s0 s0Var, int i8, int i9) {
        this(deriveMessage(i6, str, str2, i7, s0Var, i8), th, i6, str2, i7, s0Var, i8, null, i9, SystemClock.elapsedRealtime());
    }

    private t(String str, Throwable th, int i6, String str2, int i7, s0 s0Var, int i8, v.a aVar, int i9, long j6) {
        super(str, th);
        this.type = i6;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i7;
        this.rendererFormat = s0Var;
        this.rendererFormatSupport = i8;
        this.mediaPeriodId = aVar;
        this.timeoutOperation = i9;
        this.timestampMs = j6;
    }
}
