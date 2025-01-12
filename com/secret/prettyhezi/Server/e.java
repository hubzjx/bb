package com.secret.prettyhezi.Server;

import c.abc;
/* loaded from: classes.dex */
public abstract class e {
    public static String a(String str) {
        return abc.da(str);
    }

    public static byte[] b(byte[] bArr, int i6) {
        try {
            return abc.da3(bArr, i6);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] c(String str, int i6) {
        try {
            return e(str.getBytes("UTF-8"), i6);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str) {
        try {
            return abc.ea2(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] e(byte[] bArr, int i6) {
        try {
            return abc.ea3(bArr, i6);
        } catch (Exception unused) {
            return null;
        }
    }
}
