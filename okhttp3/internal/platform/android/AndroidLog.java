package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.e0;
import kotlin.jvm.internal.l;
import kotlin.text.x;
import kotlin.text.z;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
@SuppressSignatureCheck
/* loaded from: classes.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        Map<String, String> k6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = OkHttpClient.class.getPackage();
        String name = r22 == null ? null : r22.getName();
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        l.c(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        l.c(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        l.c(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        k6 = e0.k(linkedHashMap);
        knownLoggers = k6;
    }

    private AndroidLog() {
    }

    private final void enableLogging(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String w02;
        String str2 = knownLoggers.get(str);
        if (str2 == null) {
            w02 = z.w0(str, 23);
            return w02;
        }
        return str2;
    }

    public final void androidLog$okhttp(String str, int i6, String str2, Throwable th) {
        int N;
        int min;
        l.d(str, "loggerName");
        l.d(str2, "message");
        String loggerTag = loggerTag(str);
        if (Log.isLoggable(loggerTag, i6)) {
            if (th != null) {
                str2 = str2 + '\n' + ((Object) Log.getStackTraceString(th));
            }
            int length = str2.length();
            int i7 = 0;
            while (i7 < length) {
                N = x.N(str2, '\n', i7, false, 4, null);
                if (N == -1) {
                    N = length;
                }
                while (true) {
                    min = Math.min(N, i7 + MAX_LOG_LENGTH);
                    String substring = str2.substring(i7, min);
                    l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i6, loggerTag, substring);
                    if (min >= N) {
                        break;
                    }
                    i7 = min;
                }
                i7 = min + 1;
            }
        }
    }

    public final void enable() {
        for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
            enableLogging(entry.getKey(), entry.getValue());
        }
    }
}
