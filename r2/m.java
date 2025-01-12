package r2;

import android.net.Uri;
/* loaded from: classes.dex */
public abstract /* synthetic */ class m {
    public static long a(n nVar) {
        return nVar.b("exo_len", -1L);
    }

    public static Uri b(n nVar) {
        String a6 = nVar.a("exo_redir", null);
        if (a6 == null) {
            return null;
        }
        return Uri.parse(a6);
    }
}
