package okhttp3.internal;

import h4.q;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.a0;
import kotlin.collections.e0;
import kotlin.collections.j;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v;
import kotlin.text.d;
import kotlin.text.k;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p4.a;
import r4.c;
import r4.f;
/* loaded from: classes.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final k VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.11.0";

    static {
        String c02;
        String d02;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        l.b(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new k("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        l.c(name, "OkHttpClient::class.java.name");
        c02 = x.c0(name, "okhttp3.");
        d02 = x.d0(c02, "Client");
        okHttpName = d02;
    }

    public static final <E> void addIfAbsent(List<E> list, E e6) {
        l.d(list, "<this>");
        if (list.contains(e6)) {
            return;
        }
        list.add(e6);
    }

    public static final int and(byte b6, int i6) {
        return b6 & i6;
    }

    public static final EventListener.Factory asFactory(final EventListener eventListener) {
        l.d(eventListener, "<this>");
        return new EventListener.Factory() { // from class: j5.b
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                EventListener m159asFactory$lambda8;
                m159asFactory$lambda8 = Util.m159asFactory$lambda8(EventListener.this, call);
                return m159asFactory$lambda8;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: asFactory$lambda-8  reason: not valid java name */
    public static final EventListener m159asFactory$lambda8(EventListener eventListener, Call call) {
        l.d(eventListener, "$this_asFactory");
        l.d(call, "it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        l.d(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        l.d(obj, "<this>");
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(String str) {
        l.d(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        l.d(httpUrl, "<this>");
        l.d(httpUrl2, "other");
        return l.a(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && l.a(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j6, TimeUnit timeUnit) {
        l.d(str, "name");
        boolean z5 = true;
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (i6 >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j6);
                if (millis <= 2147483647L) {
                    if (millis == 0 && i6 > 0) {
                        z5 = false;
                    }
                    if (z5) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException(l.i(str, " too small.").toString());
                }
                throw new IllegalArgumentException(l.i(str, " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException(l.i(str, " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        l.d(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e6) {
            throw e6;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        int r5;
        l.d(strArr, "<this>");
        l.d(str, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        l.c(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        r5 = j.r(strArr2);
        strArr2[r5] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, char c6, int i6, int i7) {
        l.d(str, "<this>");
        while (i6 < i7) {
            int i8 = i6 + 1;
            if (str.charAt(i6) == c6) {
                return i6;
            }
            i6 = i8;
        }
        return i7;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = str.length();
        }
        return delimiterOffset(str, c6, i6, i7);
    }

    public static final boolean discard(Source source, int i6, TimeUnit timeUnit) {
        l.d(source, "<this>");
        l.d(timeUnit, "timeUnit");
        try {
            return skipAll(source, i6, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, p4.l lVar) {
        List<T> f6;
        l.d(iterable, "<this>");
        l.d(lVar, "predicate");
        f6 = n.f();
        for (T t5 : iterable) {
            if (((Boolean) lVar.invoke(t5)).booleanValue()) {
                if (f6.isEmpty()) {
                    f6 = new ArrayList<>();
                }
                v.a(f6).add(t5);
            }
        }
        return f6;
    }

    public static final String format(String str, Object... objArr) {
        l.d(str, "format");
        l.d(objArr, "args");
        u uVar = u.f11325a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        l.c(format, "format(locale, format, *args)");
        return format;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        l.d(strArr, "<this>");
        l.d(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                int length = strArr.length;
                int i6 = 0;
                while (i6 < length) {
                    String str = strArr[i6];
                    i6++;
                    Iterator a6 = b.a(strArr2);
                    while (a6.hasNext()) {
                        if (comparator.compare(str, (String) a6.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        l.d(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return toLongOrDefault(str, -1L);
    }

    public static final void ignoreIoExceptions(a aVar) {
        l.d(aVar, "block");
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        List i6;
        l.d(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        i6 = n.i(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(i6);
        l.c(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        l.d(strArr, "<this>");
        l.d(str, "value");
        l.d(comparator, "comparator");
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (comparator.compare(strArr[i6], str) == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        l.d(str, "<this>");
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            char charAt = str.charAt(i6);
            if (l.e(charAt, 31) <= 0 || l.e(charAt, 127) >= 0) {
                return i6;
            }
            i6 = i7;
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i6, int i7) {
        l.d(str, "<this>");
        while (i6 < i7) {
            int i8 = i6 + 1;
            char charAt = str.charAt(i6);
            if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                return i6;
            }
            i6 = i8;
        }
        return i7;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i6, i7);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i6, int i7) {
        l.d(str, "<this>");
        int i8 = i7 - 1;
        if (i6 <= i8) {
            while (true) {
                int i9 = i8 - 1;
                char charAt = str.charAt(i8);
                if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                    return i8 + 1;
                }
                if (i8 == i6) {
                    break;
                }
                i8 = i9;
            }
        }
        return i6;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i6, i7);
    }

    public static final int indexOfNonWhitespace(String str, int i6) {
        l.d(str, "<this>");
        int length = str.length();
        while (i6 < length) {
            int i7 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt != ' ' && charAt != '\t') {
                return i6;
            }
            i6 = i7;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        return indexOfNonWhitespace(str, i6);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        l.d(strArr, "<this>");
        l.d(strArr2, "other");
        l.d(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i6 = 0;
        while (i6 < length) {
            String str = strArr[i6];
            i6++;
            int length2 = strArr2.length;
            int i7 = 0;
            while (true) {
                if (i7 < length2) {
                    String str2 = strArr2[i7];
                    i7++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file) {
        l.d(fileSystem, "<this>");
        l.d(file, "file");
        Sink sink = fileSystem.sink(file);
        try {
            try {
                fileSystem.delete(file);
                n4.a.a(sink, null);
                return true;
            } catch (IOException unused) {
                q qVar = q.f10774a;
                n4.a.a(sink, null);
                fileSystem.delete(file);
                return false;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                n4.a.a(sink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        l.d(socket, "<this>");
        l.d(bufferedSource, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z5 = !bufferedSource.exhausted();
                socket.setSoTimeout(soTimeout);
                return z5;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        boolean l6;
        boolean l7;
        boolean l8;
        boolean l9;
        l.d(str, "name");
        l6 = w.l(str, "Authorization", true);
        if (l6) {
            return true;
        }
        l7 = w.l(str, "Cookie", true);
        if (l7) {
            return true;
        }
        l8 = w.l(str, "Proxy-Authorization", true);
        if (l8) {
            return true;
        }
        l9 = w.l(str, "Set-Cookie", true);
        return l9;
    }

    public static final void notify(Object obj) {
        l.d(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        l.d(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c6) {
        boolean z5 = true;
        if ('0' <= c6 && c6 < ':') {
            return c6 - '0';
        }
        char c7 = 'a';
        if (!('a' <= c6 && c6 < 'g')) {
            c7 = 'A';
            if (!(('A' > c6 || c6 >= 'G') ? false : false)) {
                return -1;
            }
        }
        return (c6 - c7) + 10;
    }

    public static final String peerName(Socket socket) {
        l.d(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            l.c(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) {
        Charset charset2;
        String str;
        l.d(bufferedSource, "<this>");
        l.d(charset, "default");
        int select = bufferedSource.select(UNICODE_BOMS);
        if (select != -1) {
            if (select == 0) {
                charset2 = StandardCharsets.UTF_8;
                str = "UTF_8";
            } else if (select == 1) {
                charset2 = StandardCharsets.UTF_16BE;
                str = "UTF_16BE";
            } else if (select != 2) {
                if (select != 3) {
                    if (select == 4) {
                        return d.f11326a.b();
                    }
                    throw new AssertionError();
                }
                return d.f11326a.a();
            } else {
                charset2 = StandardCharsets.UTF_16LE;
                str = "UTF_16LE";
            }
            l.c(charset2, str);
            return charset2;
        }
        return charset;
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        T t5;
        Object readFieldOrNull;
        l.d(obj, "instance");
        l.d(cls, "fieldType");
        l.d(str, "fieldName");
        Class<?> cls2 = obj.getClass();
        while (true) {
            t5 = null;
            if (l.a(cls2, Object.class)) {
                if (l.a(str, "delegate") || (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(readFieldOrNull, cls, str);
            }
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                t5 = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
                l.c(cls2, "c.superclass");
            }
        }
        return t5;
    }

    public static final int readMedium(BufferedSource bufferedSource) {
        l.d(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    public static final int skipAll(Buffer buffer, byte b6) {
        l.d(buffer, "<this>");
        int i6 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b6) {
            i6++;
            buffer.readByte();
        }
        return i6;
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z5) {
        l.d(str, "name");
        return new ThreadFactory() { // from class: j5.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m160threadFactory$lambda1;
                m160threadFactory$lambda1 = Util.m160threadFactory$lambda1(str, z5, runnable);
                return m160threadFactory$lambda1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: threadFactory$lambda-1  reason: not valid java name */
    public static final Thread m160threadFactory$lambda1(String str, boolean z5, Runnable runnable) {
        l.d(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z5);
        return thread;
    }

    public static final void threadName(String str, a aVar) {
        l.d(str, "name");
        l.d(aVar, "block");
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            kotlin.jvm.internal.k.b(1);
            currentThread.setName(name);
            kotlin.jvm.internal.k.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        c g6;
        int p5;
        l.d(headers, "<this>");
        g6 = f.g(0, headers.size());
        p5 = o.p(g6, 10);
        ArrayList arrayList = new ArrayList(p5);
        Iterator it = g6.iterator();
        while (it.hasNext()) {
            int a6 = ((a0) it).a();
            arrayList.add(new Header(headers.name(a6), headers.value(a6)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        l.d(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(int i6) {
        String hexString = Integer.toHexString(i6);
        l.c(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z5) {
        boolean D;
        String host;
        l.d(httpUrl, "<this>");
        D = x.D(httpUrl.host(), ":", false, 2, null);
        if (D) {
            host = '[' + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (z5 || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host + ':' + httpUrl.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return toHostHeader(httpUrl, z5);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        List Q;
        l.d(list, "<this>");
        Q = kotlin.collections.v.Q(list);
        List<T> unmodifiableList = Collections.unmodifiableList(Q);
        l.c(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Map<K, V> d6;
        l.d(map, "<this>");
        if (map.isEmpty()) {
            d6 = e0.d();
            return d6;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        l.c(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j6) {
        l.d(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j6;
        }
    }

    public static final int toNonNegativeInt(String str, int i6) {
        Long valueOf;
        if (str == null) {
            valueOf = null;
        } else {
            try {
                valueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i6;
            }
        }
        if (valueOf == null) {
            return i6;
        }
        long longValue = valueOf.longValue();
        if (longValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final String trimSubstring(String str, int i6, int i7) {
        l.d(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i6, i7);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i7));
        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return trimSubstring(str, i6, i7);
    }

    public static final void wait(Object obj) {
        l.d(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        l.d(exc, "<this>");
        l.d(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception exc2 : list) {
            h4.b.a(exc, exc2);
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i6) {
        l.d(bufferedSink, "<this>");
        bufferedSink.writeByte((i6 >>> 16) & 255);
        bufferedSink.writeByte((i6 >>> 8) & 255);
        bufferedSink.writeByte(i6 & 255);
    }

    public static final int and(short s5, int i6) {
        return s5 & i6;
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        l.d(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e6) {
            throw e6;
        } catch (Exception unused) {
        }
    }

    public static final int delimiterOffset(String str, String str2, int i6, int i7) {
        boolean C;
        l.d(str, "<this>");
        l.d(str2, "delimiters");
        while (i6 < i7) {
            int i8 = i6 + 1;
            C = x.C(str2, str.charAt(i6), false, 2, null);
            if (C) {
                return i6;
            }
            i6 = i8;
        }
        return i7;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = str.length();
        }
        return delimiterOffset(str, str2, i6, i7);
    }

    public static final boolean skipAll(Source source, int i6, TimeUnit timeUnit) {
        l.d(source, "<this>");
        l.d(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i6)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            int i7 = (deadlineNanoTime > Long.MAX_VALUE ? 1 : (deadlineNanoTime == Long.MAX_VALUE ? 0 : -1));
            Timeout timeout = source.timeout();
            if (i7 == 0) {
                timeout.clearDeadline();
            } else {
                timeout.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i8 = (deadlineNanoTime > Long.MAX_VALUE ? 1 : (deadlineNanoTime == Long.MAX_VALUE ? 0 : -1));
            Timeout timeout2 = source.timeout();
            if (i8 == 0) {
                timeout2.clearDeadline();
            } else {
                timeout2.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            int i9 = (deadlineNanoTime > Long.MAX_VALUE ? 1 : (deadlineNanoTime == Long.MAX_VALUE ? 0 : -1));
            Timeout timeout3 = source.timeout();
            if (i9 == 0) {
                timeout3.clearDeadline();
            } else {
                timeout3.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final String toHexString(long j6) {
        String hexString = Long.toHexString(j6);
        l.c(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long and(int i6, long j6) {
        return i6 & j6;
    }

    public static final void closeQuietly(Socket socket) {
        l.d(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e6) {
            throw e6;
        } catch (RuntimeException e7) {
            if (!l.a(e7.getMessage(), "bio == null")) {
                throw e7;
            }
        } catch (Exception unused) {
        }
    }
}
