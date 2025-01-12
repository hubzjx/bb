package b4;

import com.google.zxing.qrcode.decoder.h;
import com.google.zxing.qrcode.decoder.j;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private h f3032a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.zxing.qrcode.decoder.f f3033b;

    /* renamed from: c  reason: collision with root package name */
    private j f3034c;

    /* renamed from: d  reason: collision with root package name */
    private int f3035d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f3036e;

    public static boolean b(int i6) {
        return i6 >= 0 && i6 < 8;
    }

    public b a() {
        return this.f3036e;
    }

    public void c(com.google.zxing.qrcode.decoder.f fVar) {
        this.f3033b = fVar;
    }

    public void d(int i6) {
        this.f3035d = i6;
    }

    public void e(b bVar) {
        this.f3036e = bVar;
    }

    public void f(h hVar) {
        this.f3032a = hVar;
    }

    public void g(j jVar) {
        this.f3034c = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f3032a);
        sb.append("\n ecLevel: ");
        sb.append(this.f3033b);
        sb.append("\n version: ");
        sb.append(this.f3034c);
        sb.append("\n maskPattern: ");
        sb.append(this.f3035d);
        if (this.f3036e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f3036e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
