package a2;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final String f128a;

    /* renamed from: b  reason: collision with root package name */
    public final String f129b;

    public m(String str, String str2) {
        this.f128a = str;
        this.f129b = str2;
    }

    public String toString() {
        String str = this.f128a;
        String str2 = this.f129b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        return sb.toString();
    }
}
