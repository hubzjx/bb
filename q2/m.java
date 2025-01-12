package q2;

import java.io.IOException;
/* loaded from: classes.dex */
public final class m extends IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public m(int i6) {
        this.reason = i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r1 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        for (IOException iOException2 = iOException; iOException2 != null; iOException2 = iOException2.getCause()) {
            if ((iOException2 instanceof m) && ((m) iOException2).reason == 0) {
                return true;
            }
        }
        return false;
    }
}
