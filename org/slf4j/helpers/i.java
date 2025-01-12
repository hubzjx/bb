package org.slf4j.helpers;

import java.io.PrintStream;
/* loaded from: classes.dex */
public abstract class i {
    public static final void a(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void b(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static boolean c(String str) {
        String d6 = d(str);
        if (d6 == null) {
            return false;
        }
        return d6.equalsIgnoreCase("true");
    }

    public static String d(String str) {
        if (str != null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("null input");
    }
}
