package b0;

import android.util.Base64;
import d0.i;
import java.util.List;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f2852a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2853b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2854c;

    /* renamed from: d  reason: collision with root package name */
    private final List f2855d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2856e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f2857f;

    public d(String str, String str2, String str3, List list) {
        this.f2852a = (String) i.c(str);
        this.f2853b = (String) i.c(str2);
        this.f2854c = (String) i.c(str3);
        this.f2855d = (List) i.c(list);
        this.f2857f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f2855d;
    }

    public int c() {
        return this.f2856e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f2857f;
    }

    public String e() {
        return this.f2852a;
    }

    public String f() {
        return this.f2853b;
    }

    public String g() {
        return this.f2854c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2852a + ", mProviderPackage: " + this.f2853b + ", mQuery: " + this.f2854c + ", mCertificates:");
        for (int i6 = 0; i6 < this.f2855d.size(); i6++) {
            sb.append(" [");
            List list = (List) this.f2855d.get(i6);
            for (int i7 = 0; i7 < list.size(); i7++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i7), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2856e);
        return sb.toString();
    }
}
