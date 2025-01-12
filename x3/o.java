package x3;

import java.util.Map;
/* loaded from: classes.dex */
public final class o implements com.google.zxing.r {

    /* renamed from: a  reason: collision with root package name */
    private final j f14211a = new j();

    @Override // com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar != com.google.zxing.a.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + aVar);
        }
        j jVar = this.f14211a;
        return jVar.a("0" + str, com.google.zxing.a.EAN_13, i6, i7, map);
    }
}
