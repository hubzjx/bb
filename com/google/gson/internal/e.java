package com.google.gson.internal;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5803a = a();

    private static int a() {
        return d(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c() {
        return f5803a;
    }

    static int d(String str) {
        int f6 = f(str);
        if (f6 == -1) {
            f6 = b(str);
        }
        if (f6 == -1) {
            return 6;
        }
        return f6;
    }

    public static boolean e() {
        return f5803a >= 9;
    }

    private static int f(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
