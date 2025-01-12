package a2;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final p1.a[] f78a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f79b;

    /* renamed from: c  reason: collision with root package name */
    public final String f80c;

    /* renamed from: d  reason: collision with root package name */
    public final String f81d;

    /* renamed from: e  reason: collision with root package name */
    public final long f82e;

    public e(String str, String str2, long j6, long[] jArr, p1.a[] aVarArr) {
        this.f80c = str;
        this.f81d = str2;
        this.f82e = j6;
        this.f79b = jArr;
        this.f78a = aVarArr;
    }

    public String a() {
        String str = this.f80c;
        String str2 = this.f81d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return sb.toString();
    }
}
