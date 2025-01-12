package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import okhttp3.Handshake;
import p4.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RealConnection$connectTls$2 extends m implements a {
    final /* synthetic */ RealConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection$connectTls$2(RealConnection realConnection) {
        super(0);
        this.this$0 = realConnection;
    }

    @Override // p4.a
    public final List<X509Certificate> invoke() {
        Handshake handshake;
        int p5;
        handshake = this.this$0.handshake;
        l.b(handshake);
        List<Certificate> peerCertificates = handshake.peerCertificates();
        p5 = o.p(peerCertificates, 10);
        ArrayList arrayList = new ArrayList(p5);
        for (Certificate certificate : peerCertificates) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
