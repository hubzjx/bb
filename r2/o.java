package r2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Map f13005a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final List f13006b = new ArrayList();

    private o a(String str, Object obj) {
        this.f13005a.put((String) com.google.android.exoplayer2.util.a.e(str), com.google.android.exoplayer2.util.a.e(obj));
        this.f13006b.remove(str);
        return this;
    }

    public static o g(o oVar, long j6) {
        return oVar.e("exo_len", j6);
    }

    public static o h(o oVar, Uri uri) {
        return uri == null ? oVar.d("exo_redir") : oVar.f("exo_redir", uri.toString());
    }

    public Map b() {
        HashMap hashMap = new HashMap(this.f13005a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List c() {
        return Collections.unmodifiableList(new ArrayList(this.f13006b));
    }

    public o d(String str) {
        this.f13006b.add(str);
        this.f13005a.remove(str);
        return this;
    }

    public o e(String str, long j6) {
        return a(str, Long.valueOf(j6));
    }

    public o f(String str, String str2) {
        return a(str, str2);
    }
}
