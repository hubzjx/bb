package r0;

import android.text.TextUtils;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class a {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? HttpUrl.FRAGMENT_ENCODE_SET : str.substring(lastIndexOf + 1, str.length());
    }

    public String a(String str) {
        String b6 = b(str);
        String b7 = q0.a.b(str);
        if (TextUtils.isEmpty(b6)) {
            return b7;
        }
        return b7 + "." + b6;
    }
}
