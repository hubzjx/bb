package com.secret.prettyhezi;

import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class g {
    public static int a(int i6) {
        return i6;
    }

    public static String b(int i6) {
        switch (i6) {
            case 1:
                return "photo";
            case 2:
                return "video";
            case 3:
                return "book";
            case 4:
                return "film";
            case 5:
                return "rrvideo";
            case 6:
                return "gallery";
            case 7:
                return "audio";
            default:
                return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static boolean c(int i6) {
        return i6 == 1 || i6 == 6;
    }

    public static boolean d(int i6) {
        return i6 == 6 || i6 == 7 || i6 == 5;
    }
}
