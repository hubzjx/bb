package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static int f4644a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4645b = true;

    private static String a(String str, Throwable th) {
        String e6 = e(th);
        if (TextUtils.isEmpty(e6)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = e6.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(valueOf.length() + 4 + String.valueOf(replace).length());
        sb.append(valueOf);
        sb.append("\n  ");
        sb.append(replace);
        sb.append('\n');
        return sb.toString();
    }

    public static void b(String str, String str2) {
        if (f4644a == 0) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f4644a <= 3) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    public static String e(Throwable th) {
        if (th == null) {
            return null;
        }
        return g(th) ? "UnknownHostException (no network)" : !f4645b ? th.getMessage() : Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    public static void f(String str, String str2) {
        if (f4644a <= 1) {
            Log.i(str, str2);
        }
    }

    private static boolean g(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void h(String str, String str2) {
        if (f4644a <= 2) {
            Log.w(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        h(str, a(str2, th));
    }
}
