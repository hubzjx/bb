package okhttp3.internal.http2;

import kotlin.jvm.internal.l;
import kotlin.text.w;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.ByteString;
/* loaded from: classes.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final Http2 INSTANCE = new Http2();
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    static {
        String t5;
        String[] strArr = new String[256];
        int i6 = 0;
        for (int i7 = 0; i7 < 256; i7++) {
            String binaryString = Integer.toBinaryString(i7);
            l.c(binaryString, "toBinaryString(it)");
            t5 = w.t(Util.format("%8s", binaryString), ' ', '0', false, 4, null);
            strArr[i7] = t5;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = HttpUrl.FRAGMENT_ENCODE_SET;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = l.i("END_STREAM", "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i8 = 0;
        while (i8 < 3) {
            int i9 = iArr2[i8];
            i8++;
            int i10 = iArr[0];
            String[] strArr3 = FLAGS;
            int i11 = i10 | i9;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) strArr3[i10]);
            sb.append('|');
            sb.append((Object) strArr3[i9]);
            strArr3[i11] = sb.toString();
            strArr3[i11 | 8] = ((Object) strArr3[i10]) + '|' + ((Object) strArr3[i9]) + "|PADDED";
        }
        int length = FLAGS.length;
        while (i6 < length) {
            int i12 = i6 + 1;
            String[] strArr4 = FLAGS;
            if (strArr4[i6] == null) {
                strArr4[i6] = BINARY[i6];
            }
            i6 = i12;
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i6, int i7) {
        String str;
        String str2;
        String str3;
        String u5;
        if (i7 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (i6 != 2 && i6 != 3) {
            if (i6 == 4 || i6 == 6) {
                return i7 == 1 ? "ACK" : BINARY[i7];
            } else if (i6 != 7 && i6 != 8) {
                String[] strArr = FLAGS;
                if (i7 < strArr.length) {
                    str = strArr[i7];
                    l.b(str);
                } else {
                    str = BINARY[i7];
                }
                String str4 = str;
                if (i6 == 5 && (i7 & 4) != 0) {
                    str2 = "HEADERS";
                    str3 = "PUSH_PROMISE";
                } else if (i6 != 0 || (i7 & 32) == 0) {
                    return str4;
                } else {
                    str2 = "PRIORITY";
                    str3 = "COMPRESSED";
                }
                u5 = w.u(str4, str2, str3, false, 4, null);
                return u5;
            }
        }
        return BINARY[i7];
    }

    public final String formattedType$okhttp(int i6) {
        String[] strArr = FRAME_NAMES;
        return i6 < strArr.length ? strArr[i6] : Util.format("0x%02x", Integer.valueOf(i6));
    }

    public final String frameLog(boolean z5, int i6, int i7, int i8, int i9) {
        return Util.format("%s 0x%08x %5d %-13s %s", z5 ? "<<" : ">>", Integer.valueOf(i6), Integer.valueOf(i7), formattedType$okhttp(i8), formatFlags(i8, i9));
    }
}
