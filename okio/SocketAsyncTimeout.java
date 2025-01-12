package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        kotlin.jvm.internal.l.d(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okio.AsyncTimeout
    protected void timedOut() {
        Logger logger;
        Level level;
        StringBuilder sb;
        Logger logger2;
        Exception exc;
        Logger logger3;
        try {
            this.socket.close();
        } catch (AssertionError e6) {
            if (!Okio.isAndroidGetsocknameError(e6)) {
                throw e6;
            }
            logger3 = Okio__JvmOkioKt.logger;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e6;
            logger2 = logger3;
            sb.append("Failed to close timed out socket ");
            sb.append(this.socket);
            logger2.log(level, sb.toString(), (Throwable) exc);
        } catch (Exception e7) {
            logger = Okio__JvmOkioKt.logger;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e7;
            logger2 = logger;
            sb.append("Failed to close timed out socket ");
            sb.append(this.socket);
            logger2.log(level, sb.toString(), (Throwable) exc);
        }
    }
}
