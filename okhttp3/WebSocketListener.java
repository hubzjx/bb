package okhttp3;

import kotlin.jvm.internal.l;
import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i6, String str) {
        l.d(webSocket, "webSocket");
        l.d(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i6, String str) {
        l.d(webSocket, "webSocket");
        l.d(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        l.d(webSocket, "webSocket");
        l.d(th, "t");
    }

    public void onMessage(WebSocket webSocket, String str) {
        l.d(webSocket, "webSocket");
        l.d(str, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        l.d(webSocket, "webSocket");
        l.d(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        l.d(webSocket, "webSocket");
        l.d(byteString, "bytes");
    }
}
