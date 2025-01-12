package w3;

import java.nio.charset.StandardCharsets;
/* loaded from: classes.dex */
final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f14111a;

    /* renamed from: b  reason: collision with root package name */
    private l f14112b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f14113c;

    /* renamed from: d  reason: collision with root package name */
    int f14114d;

    /* renamed from: e  reason: collision with root package name */
    private int f14115e;

    /* renamed from: f  reason: collision with root package name */
    private k f14116f;

    /* renamed from: g  reason: collision with root package name */
    private int f14117g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i6 = 0; i6 < length; i6++) {
            char c6 = (char) (bytes[i6] & 255);
            if (c6 == '?' && str.charAt(i6) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c6);
        }
        this.f14111a = sb.toString();
        this.f14112b = l.FORCE_NONE;
        this.f14113c = new StringBuilder(str.length());
        this.f14115e = -1;
    }

    private int h() {
        return this.f14111a.length() - this.f14117g;
    }

    public int a() {
        return this.f14113c.length();
    }

    public StringBuilder b() {
        return this.f14113c;
    }

    public char c() {
        return this.f14111a.charAt(this.f14114d);
    }

    public String d() {
        return this.f14111a;
    }

    public int e() {
        return this.f14115e;
    }

    public int f() {
        return h() - this.f14114d;
    }

    public k g() {
        return this.f14116f;
    }

    public boolean i() {
        return this.f14114d < h();
    }

    public void j() {
        this.f14115e = -1;
    }

    public void k() {
        this.f14116f = null;
    }

    public void l(com.google.zxing.f fVar, com.google.zxing.f fVar2) {
    }

    public void m(int i6) {
        this.f14117g = i6;
    }

    public void n(l lVar) {
        this.f14112b = lVar;
    }

    public void o(int i6) {
        this.f14115e = i6;
    }

    public void p() {
        q(a());
    }

    public void q(int i6) {
        k kVar = this.f14116f;
        if (kVar == null || i6 > kVar.a()) {
            this.f14116f = k.l(i6, this.f14112b, null, null, true);
        }
    }

    public void r(char c6) {
        this.f14113c.append(c6);
    }

    public void s(String str) {
        this.f14113c.append(str);
    }
}
