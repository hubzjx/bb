package i5;
/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(byte b6, int i6) {
        return ((1 << i6) & ((long) b6)) != 0;
    }

    public static byte b(byte b6, int i6) {
        return (byte) (b6 | (1 << i6));
    }

    public static byte c(byte b6, int i6) {
        return (byte) (b6 & (~(1 << i6)));
    }
}
