package com.google.common.base;
/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(char c6) {
        return c6 >= 'A' && c6 <= 'Z';
    }

    public static String b(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            if (a(str.charAt(i6))) {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c6 = charArray[i6];
                    if (a(c6)) {
                        charArray[i6] = (char) (c6 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }
}
