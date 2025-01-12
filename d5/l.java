package d5;

import e5.q;
import i5.i0;
import java.io.OutputStream;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
class l extends b {
    public l(j jVar, q qVar, char[] cArr) {
        super(jVar, qVar, cArr);
    }

    private long f(q qVar) {
        return qVar.u() ? (i0.c(qVar.l()) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16 : qVar.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d5.b
    /* renamed from: g */
    public x4.d d(OutputStream outputStream, q qVar, char[] cArr) {
        x4.d dVar = new x4.d(cArr, f(qVar));
        e(dVar.e());
        return dVar;
    }

    @Override // d5.b, java.io.OutputStream
    public void write(int i6) {
        write(new byte[]{(byte) i6});
    }

    @Override // d5.b, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // d5.b, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        super.write(bArr, i6, i7);
    }
}
