package okhttp3.internal.ws;

import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.ByteString;
/* loaded from: classes.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String str) {
        l.d(str, "key");
        return ByteString.Companion.encodeUtf8(l.i(str, ACCEPT_MAGIC)).sha1().base64();
    }

    public final String closeCodeExceptionMessage(int i6) {
        if (i6 < 1000 || i6 >= 5000) {
            return l.i("Code must be in range [1000,5000): ", Integer.valueOf(i6));
        }
        boolean z5 = true;
        if (!(1004 <= i6 && i6 < 1007)) {
            if (!((1015 > i6 || i6 >= 3000) ? false : false)) {
                return null;
            }
        }
        return "Code " + i6 + " is reserved and may not be used.";
    }

    public final void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        l.d(unsafeCursor, "cursor");
        l.d(bArr, "key");
        int length = bArr.length;
        int i6 = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i7 = unsafeCursor.start;
            int i8 = unsafeCursor.end;
            if (bArr2 != null) {
                while (i7 < i8) {
                    int i9 = i6 % length;
                    bArr2[i7] = (byte) (bArr2[i7] ^ bArr[i9]);
                    i7++;
                    i6 = i9 + 1;
                }
            }
        } while (unsafeCursor.next() != -1);
    }

    public final void validateCloseCode(int i6) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i6);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        l.b(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
