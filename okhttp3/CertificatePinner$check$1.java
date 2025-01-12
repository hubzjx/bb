package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.m;
import okhttp3.internal.tls.CertificateChainCleaner;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CertificatePinner$check$1 extends m implements p4.a {
    final /* synthetic */ String $hostname;
    final /* synthetic */ List<Certificate> $peerCertificates;
    final /* synthetic */ CertificatePinner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CertificatePinner$check$1(CertificatePinner certificatePinner, List<? extends Certificate> list, String str) {
        super(0);
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    @Override // p4.a
    public final List<X509Certificate> invoke() {
        int p5;
        CertificateChainCleaner certificateChainCleaner$okhttp = this.this$0.getCertificateChainCleaner$okhttp();
        List<Certificate> clean = certificateChainCleaner$okhttp == null ? null : certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname);
        if (clean == null) {
            clean = this.$peerCertificates;
        }
        p5 = o.p(clean, 10);
        ArrayList arrayList = new ArrayList(p5);
        for (Certificate certificate : clean) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
