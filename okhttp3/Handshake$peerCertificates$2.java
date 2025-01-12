package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.n;
import kotlin.jvm.internal.m;
/* loaded from: classes.dex */
final class Handshake$peerCertificates$2 extends m implements p4.a {
    final /* synthetic */ p4.a $peerCertificatesFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Handshake$peerCertificates$2(p4.a aVar) {
        super(0);
        this.$peerCertificatesFn = aVar;
    }

    @Override // p4.a
    public final List<Certificate> invoke() {
        List<Certificate> f6;
        try {
            return (List) this.$peerCertificatesFn.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            f6 = n.f();
            return f6;
        }
    }
}
