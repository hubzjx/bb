package z0;

import android.database.SQLException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class a extends IOException {
    public a(SQLException sQLException) {
        super(sQLException);
    }

    public a(SQLException sQLException, String str) {
        super(str, sQLException);
    }
}
