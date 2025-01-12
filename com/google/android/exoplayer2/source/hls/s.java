package com.google.android.exoplayer2.source.hls;

import java.io.IOException;
/* loaded from: classes.dex */
public final class s extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s(String str) {
        super(r1.toString());
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 60);
        sb.append("Unable to bind a sample queue to TrackGroup with mime type ");
        sb.append(str);
        sb.append(".");
    }
}
