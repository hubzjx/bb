package com.secret.prettyhezi.Upload;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static a[][] f7509a;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        long enable_at;
        int id;
        String name;
    }

    /* loaded from: classes.dex */
    public static class b extends com.secret.prettyhezi.Server.w {
        a[] data;
    }

    public static int a(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 5) {
                    if (i6 != 6) {
                        return i6 != 7 ? 0 : 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 2;
        }
        return 4;
    }

    public static a[] b(int i6) {
        if (f7509a == null) {
            f7509a = new a[8];
        }
        return f7509a[i6];
    }

    public static void c(int i6, a[] aVarArr) {
        if (f7509a == null) {
            f7509a = new a[8];
        }
        f7509a[i6] = aVarArr;
    }
}
