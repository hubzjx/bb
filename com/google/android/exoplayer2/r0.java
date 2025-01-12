package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4032a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet f4033b;

    /* renamed from: c  reason: collision with root package name */
    private static String f4034c;

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
        sb.append("ExoPlayerLib/2.12.1 (Linux;Android ");
        sb.append(str);
        sb.append(") ");
        sb.append("ExoPlayerLib/2.12.1");
        f4032a = sb.toString();
        f4033b = new HashSet();
        f4034c = "goog.exo.core";
    }

    public static synchronized void a(String str) {
        synchronized (r0.class) {
            if (f4033b.add(str)) {
                String str2 = f4034c;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
                sb.append(str2);
                sb.append(", ");
                sb.append(str);
                f4034c = sb.toString();
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (r0.class) {
            str = f4034c;
        }
        return str;
    }
}
