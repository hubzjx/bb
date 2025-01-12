package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.ConnectionSpec;
/* loaded from: classes.dex */
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        l.d(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int i6 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (i6 < size) {
            int i7 = i6 + 1;
            if (this.connectionSpecs.get(i6).isCompatible(sSLSocket)) {
                return true;
            }
            i6 = i7;
        }
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) {
        ConnectionSpec connectionSpec;
        l.d(sSLSocket, "sslSocket");
        int i6 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i6 >= size) {
                connectionSpec = null;
                break;
            }
            int i7 = i6 + 1;
            connectionSpec = this.connectionSpecs.get(i6);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i7;
                break;
            }
            i6 = i7;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            connectionSpec.apply$okhttp(sSLSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isFallback);
        sb.append(", modes=");
        sb.append(this.connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        l.b(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        l.c(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean connectionFailed(IOException iOException) {
        l.d(iOException, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }
}
