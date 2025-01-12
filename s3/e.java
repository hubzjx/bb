package s3;

import java.util.List;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13274a;

    /* renamed from: b  reason: collision with root package name */
    private int f13275b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13276c;

    /* renamed from: d  reason: collision with root package name */
    private final List f13277d;

    /* renamed from: e  reason: collision with root package name */
    private final String f13278e;

    /* renamed from: f  reason: collision with root package name */
    private Object f13279f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13280g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13281h;

    public e(byte[] bArr, String str, List list, String str2, int i6, int i7) {
        this.f13274a = bArr;
        this.f13275b = bArr == null ? 0 : bArr.length * 8;
        this.f13276c = str;
        this.f13277d = list;
        this.f13278e = str2;
        this.f13280g = i7;
        this.f13281h = i6;
    }

    public List a() {
        return this.f13277d;
    }

    public String b() {
        return this.f13278e;
    }

    public Object c() {
        return this.f13279f;
    }

    public byte[] d() {
        return this.f13274a;
    }

    public int e() {
        return this.f13280g;
    }

    public int f() {
        return this.f13281h;
    }

    public String g() {
        return this.f13276c;
    }

    public boolean h() {
        return this.f13280g >= 0 && this.f13281h >= 0;
    }

    public void i(Object obj) {
        this.f13279f = obj;
    }
}
