package com.secret.prettyhezi.Payment;

import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static b[] f6827a;

    public static b a(int i6) {
        if (f6827a == null) {
            return null;
        }
        int i7 = 0;
        while (true) {
            b[] bVarArr = f6827a;
            if (i7 >= bVarArr.length) {
                return null;
            }
            b bVar = bVarArr[i7];
            if (bVar.type == i6) {
                return bVar;
            }
            i7++;
        }
    }

    public static String b(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                return null;
            }
            return "微信";
        }
        return "支付宝";
    }

    public static int c(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                return 0;
            }
            return C0382R.drawable.wx;
        }
        return C0382R.drawable.ali;
    }

    public static int d(int i6) {
        b a6 = a(i6);
        if (a6 == null) {
            return 0;
        }
        return a6.status == 0 ? 1 : 2;
    }
}
