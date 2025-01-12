package okhttp3.internal.ws;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.v;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.Headers;
import okhttp3.internal.Util;
/* loaded from: classes.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WebSocketExtensions parse(Headers headers) {
            boolean l6;
            boolean l7;
            boolean l8;
            Integer f6;
            boolean l9;
            boolean l10;
            Integer f7;
            boolean l11;
            l.d(headers, "responseHeaders");
            int size = headers.size();
            int i6 = 0;
            boolean z5 = false;
            Integer num = null;
            boolean z6 = false;
            Integer num2 = null;
            boolean z7 = false;
            boolean z8 = false;
            while (i6 < size) {
                int i7 = i6 + 1;
                l6 = w.l(headers.name(i6), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true);
                if (l6) {
                    String value = headers.value(i6);
                    int i8 = 0;
                    while (i8 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i8, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i8, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i8, delimiterOffset);
                        int i9 = delimiterOffset + 1;
                        l7 = w.l(trimSubstring, "permessage-deflate", true);
                        if (l7) {
                            if (z5) {
                                z8 = true;
                            }
                            i8 = i9;
                            while (i8 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i8, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i8, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i8, delimiterOffset3);
                                String e02 = delimiterOffset3 < delimiterOffset2 ? x.e0(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"") : null;
                                i8 = delimiterOffset2 + 1;
                                l8 = w.l(trimSubstring2, "client_max_window_bits", true);
                                if (l8) {
                                    if (num != null) {
                                        z8 = true;
                                    }
                                    if (e02 == null) {
                                        num = null;
                                    } else {
                                        f6 = v.f(e02);
                                        num = f6;
                                    }
                                    if (num == null) {
                                        z8 = true;
                                    }
                                } else {
                                    l9 = w.l(trimSubstring2, "client_no_context_takeover", true);
                                    if (l9) {
                                        if (z6) {
                                            z8 = true;
                                        }
                                        if (e02 != null) {
                                            z8 = true;
                                        }
                                        z6 = true;
                                    } else {
                                        l10 = w.l(trimSubstring2, "server_max_window_bits", true);
                                        if (l10) {
                                            if (num2 != null) {
                                                z8 = true;
                                            }
                                            if (e02 == null) {
                                                num2 = null;
                                            } else {
                                                f7 = v.f(e02);
                                                num2 = f7;
                                            }
                                            if (num2 == null) {
                                                z8 = true;
                                            }
                                        } else {
                                            l11 = w.l(trimSubstring2, "server_no_context_takeover", true);
                                            if (l11) {
                                                if (z7) {
                                                    z8 = true;
                                                }
                                                if (e02 != null) {
                                                    z8 = true;
                                                }
                                                z7 = true;
                                            } else {
                                                z8 = true;
                                            }
                                        }
                                    }
                                }
                            }
                            z5 = true;
                        } else {
                            i8 = i9;
                            z8 = true;
                        }
                    }
                }
                i6 = i7;
            }
            return new WebSocketExtensions(z5, num, z6, num2, z7, z8);
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z5, Integer num, boolean z6, Integer num2, boolean z7, boolean z8, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = webSocketExtensions.perMessageDeflate;
        }
        if ((i6 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i6 & 4) != 0) {
            z6 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z9 = z6;
        if ((i6 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i6 & 16) != 0) {
            z7 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z10 = z7;
        if ((i6 & 32) != 0) {
            z8 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z5, num3, z9, num4, z10, z8);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z5, Integer num, boolean z6, Integer num2, boolean z7, boolean z8) {
        return new WebSocketExtensions(z5, num, z6, num2, z7, z8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebSocketExtensions) {
            WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
            return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && l.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && l.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z5 = this.perMessageDeflate;
        ?? r02 = z5;
        if (z5) {
            r02 = 1;
        }
        int i6 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode = (i6 + (num == null ? 0 : num.hashCode())) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i7 = r22;
        if (r22 != 0) {
            i7 = 1;
        }
        int i8 = (hashCode + i7) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int hashCode2 = (i8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i9 = r23;
        if (r23 != 0) {
            i9 = 1;
        }
        int i10 = (hashCode2 + i9) * 31;
        boolean z6 = this.unknownValues;
        return i10 + (z6 ? 1 : z6 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z5) {
        return z5 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z5, Integer num, boolean z6, Integer num2, boolean z7, boolean z8) {
        this.perMessageDeflate = z5;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z6;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z7;
        this.unknownValues = z8;
    }

    public /* synthetic */ WebSocketExtensions(boolean z5, Integer num, boolean z6, Integer num2, boolean z7, boolean z8, int i6, g gVar) {
        this((i6 & 1) != 0 ? false : z5, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? false : z6, (i6 & 8) == 0 ? num2 : null, (i6 & 16) != 0 ? false : z7, (i6 & 32) != 0 ? false : z8);
    }
}
