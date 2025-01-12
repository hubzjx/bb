package com.google.android.exoplayer2.mediacodec;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes.dex */
public abstract class y {
    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, s2.b bVar) {
        if (bVar != null) {
            d(mediaFormat, "color-transfer", bVar.f13174c);
            d(mediaFormat, "color-standard", bVar.f13172a);
            d(mediaFormat, "color-range", bVar.f13173b);
            a(mediaFormat, "hdr-static-info", bVar.f13175d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f6) {
        if (f6 != -1.0f) {
            mediaFormat.setFloat(str, f6);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i6) {
        if (i6 != -1) {
            mediaFormat.setInteger(str, i6);
        }
    }

    public static void e(MediaFormat mediaFormat, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i6);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap((byte[]) list.get(i6)));
        }
    }
}
