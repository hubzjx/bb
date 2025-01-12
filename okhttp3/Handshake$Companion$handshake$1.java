package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.internal.m;
/* loaded from: classes.dex */
final class Handshake$Companion$handshake$1 extends m implements p4.a {
    final /* synthetic */ List<Certificate> $peerCertificatesCopy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Handshake$Companion$handshake$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // p4.a
    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
