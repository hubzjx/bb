package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
/* loaded from: classes.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.Companion;
        QUOTED_STRING_DELIMITERS = companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = companion.encodeUtf8("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        l.d(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        boolean l6;
        l.d(headers, "<this>");
        l.d(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            l6 = w.l(str, headers.name(i6), true);
            if (l6) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8(headers.value(i6)), arrayList);
                } catch (EOFException e6) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e6);
                }
            }
            i6 = i7;
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        boolean l6;
        l.d(response, "<this>");
        if (l.a(response.request().method(), "HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1) {
            l6 = w.l("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
            if (!l6) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0079, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0079, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) {
        String readToken;
        Map d6;
        int skipAll;
        String q5;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    skipCommasAndWhitespace(buffer);
                    str = readToken(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                readToken = readToken(buffer);
                if (readToken == null) {
                    if (buffer.exhausted()) {
                        d6 = e0.d();
                        list.add(new Challenge(str, d6));
                        return;
                    }
                    return;
                }
                skipAll = Util.skipAll(buffer, (byte) 61);
                boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int skipAll2 = skipAll + Util.skipAll(buffer, (byte) 61);
                    while (true) {
                        if (readToken == null) {
                            readToken = readToken(buffer);
                            if (skipCommasAndWhitespace(buffer)) {
                                break;
                            }
                            skipAll2 = Util.skipAll(buffer, (byte) 61);
                        }
                        if (skipAll2 == 0) {
                            break;
                        } else if (skipAll2 > 1 || skipCommasAndWhitespace(buffer)) {
                            return;
                        } else {
                            String readQuotedString = startsWith(buffer, (byte) 34) ? readQuotedString(buffer) : readToken(buffer);
                            if (readQuotedString == null || ((String) linkedHashMap.put(readToken, readQuotedString)) != null) {
                                return;
                            }
                            if (!skipCommasAndWhitespace(buffer) && !buffer.exhausted()) {
                                return;
                            }
                            readToken = null;
                        }
                    }
                    list.add(new Challenge(str, linkedHashMap));
                    str = readToken;
                }
            }
            q5 = w.q("=", skipAll);
            Map singletonMap = Collections.singletonMap(null, l.i(readToken, q5));
            l.c(singletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str, singletonMap));
        }
    }

    private static final String readQuotedString(Buffer buffer) {
        if (!(buffer.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (indexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(indexOfElement) == 34) {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            } else if (buffer.size() == indexOfElement + 1) {
                return null;
            } else {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                buffer2.write(buffer, 1L);
            }
        }
    }

    private static final String readToken(Buffer buffer) {
        long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        if (indexOfElement != 0) {
            return buffer.readUtf8(indexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        l.d(cookieJar, "<this>");
        l.d(httpUrl, "url");
        l.d(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.Companion.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z5 = false;
        while (!buffer.exhausted()) {
            byte b6 = buffer.getByte(0L);
            boolean z6 = true;
            if (b6 != 44) {
                if (b6 != 32 && b6 != 9) {
                    z6 = false;
                }
                if (!z6) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z5 = true;
            }
        }
        return z5;
    }

    private static final boolean startsWith(Buffer buffer, byte b6) {
        return !buffer.exhausted() && buffer.getByte(0L) == b6;
    }
}
