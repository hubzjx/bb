package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class k0 {
    private static long a(Map map, String str) {
        if (map != null) {
            try {
                String str2 = (String) map.get(str);
                if (str2 != null) {
                    return Long.parseLong(str2);
                }
                return -9223372036854775807L;
            } catch (NumberFormatException unused) {
                return -9223372036854775807L;
            }
        }
        return -9223372036854775807L;
    }

    public static Pair b(m mVar) {
        Map c6 = mVar.c();
        if (c6 == null) {
            return null;
        }
        return new Pair(Long.valueOf(a(c6, "LicenseDurationRemaining")), Long.valueOf(a(c6, "PlaybackDurationRemaining")));
    }
}
