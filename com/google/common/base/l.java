package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class l {
    public static String a(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i6 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i7 = 0; i7 < objArr.length; i7++) {
                objArr[i7] = b(objArr[i7]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i8 = 0;
        while (i6 < objArr.length && (indexOf = valueOf.indexOf("%s", i8)) != -1) {
            sb.append((CharSequence) valueOf, i8, indexOf);
            sb.append(objArr[i6]);
            i8 = indexOf + 2;
            i6++;
        }
        sb.append((CharSequence) valueOf, i8, valueOf.length());
        if (i6 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i9 = i6 + 1; i9 < objArr.length; i9++) {
                sb.append(", ");
                sb.append(objArr[i9]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String b(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e6) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e6);
            return "<" + str + " threw " + e6.getClass().getName() + ">";
        }
    }
}
