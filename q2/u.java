package q2;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okio.internal._BufferKt;
import q2.a0;
/* loaded from: classes.dex */
public class u extends f implements a0 {

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f12869u = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: v  reason: collision with root package name */
    private static final AtomicReference f12870v = new AtomicReference();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f12871e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12872f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12873g;

    /* renamed from: h  reason: collision with root package name */
    private final String f12874h;

    /* renamed from: i  reason: collision with root package name */
    private final a0.f f12875i;

    /* renamed from: j  reason: collision with root package name */
    private final a0.f f12876j;

    /* renamed from: k  reason: collision with root package name */
    private com.google.common.base.k f12877k;

    /* renamed from: l  reason: collision with root package name */
    private o f12878l;

    /* renamed from: m  reason: collision with root package name */
    private HttpURLConnection f12879m;

    /* renamed from: n  reason: collision with root package name */
    private InputStream f12880n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12881o;

    /* renamed from: p  reason: collision with root package name */
    private int f12882p;

    /* renamed from: q  reason: collision with root package name */
    private long f12883q;

    /* renamed from: r  reason: collision with root package name */
    private long f12884r;

    /* renamed from: s  reason: collision with root package name */
    private long f12885s;

    /* renamed from: t  reason: collision with root package name */
    private long f12886t;

    public u(String str, int i6, int i7, boolean z5, a0.f fVar) {
        super(true);
        this.f12874h = com.google.android.exoplayer2.util.a.d(str);
        this.f12876j = new a0.f();
        this.f12872f = i6;
        this.f12873g = i7;
        this.f12871e = z5;
        this.f12875i = fVar;
    }

    private HttpURLConnection A(o oVar) {
        HttpURLConnection z5;
        o oVar2 = oVar;
        URL url = new URL(oVar2.f12794a.toString());
        int i6 = oVar2.f12796c;
        byte[] bArr = oVar2.f12797d;
        long j6 = oVar2.f12800g;
        long j7 = oVar2.f12801h;
        boolean d6 = oVar2.d(1);
        if (this.f12871e) {
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                if (i7 > 20) {
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Too many redirects: ");
                    sb.append(i8);
                    throw new NoRouteToHostException(sb.toString());
                }
                byte[] bArr2 = bArr;
                long j8 = j7;
                long j9 = j6;
                z5 = z(url, i6, bArr, j6, j7, d6, false, oVar2.f12798e);
                int responseCode = z5.getResponseCode();
                String headerField = z5.getHeaderField("Location");
                if ((i6 == 1 || i6 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    z5.disconnect();
                    url = x(url, headerField);
                } else if (i6 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                } else {
                    z5.disconnect();
                    url = x(url, headerField);
                    bArr2 = null;
                    i6 = 1;
                }
                i7 = i8;
                bArr = bArr2;
                j7 = j8;
                j6 = j9;
                oVar2 = oVar;
            }
            return z5;
        }
        return z(url, i6, bArr, j6, j7, d6, true, oVar2.f12798e);
    }

    private static void B(HttpURLConnection httpURLConnection, long j6) {
        int i6 = s0.f4673a;
        if (i6 == 19 || i6 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j6 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j6 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int D(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f12884r;
        if (j6 != -1) {
            long j7 = j6 - this.f12886t;
            if (j7 == 0) {
                return -1;
            }
            i7 = (int) Math.min(i7, j7);
        }
        int read = this.f12880n.read(bArr, i6, i7);
        if (read == -1) {
            if (this.f12884r == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.f12886t += read;
        q(read);
        return read;
    }

    private void E() {
        if (this.f12885s == this.f12883q) {
            return;
        }
        byte[] bArr = (byte[]) f12870v.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[_BufferKt.SEGMENTING_THRESHOLD];
        }
        while (true) {
            long j6 = this.f12885s;
            long j7 = this.f12883q;
            if (j6 == j7) {
                f12870v.set(bArr);
                return;
            }
            int read = this.f12880n.read(bArr, 0, (int) Math.min(j7 - j6, bArr.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.f12885s += read;
            q(read);
        }
    }

    private void v() {
        HttpURLConnection httpURLConnection = this.f12879m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e6) {
                com.google.android.exoplayer2.util.n.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e6);
            }
            this.f12879m = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long w(HttpURLConnection httpURLConnection) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(headerField2).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField2);
                sb.append("]");
                com.google.android.exoplayer2.util.n.c("DefaultHttpDataSource", sb.toString());
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                Matcher matcher = f12869u.matcher(headerField);
                if (matcher.find()) {
                    try {
                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(headerField2).length() + 26 + String.valueOf(headerField).length());
                            sb2.append("Inconsistent headers [");
                            sb2.append(headerField2);
                            sb2.append("] [");
                            sb2.append(headerField);
                            sb2.append("]");
                            com.google.android.exoplayer2.util.n.h("DefaultHttpDataSource", sb2.toString());
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(headerField).length() + 27);
                        sb3.append("Unexpected Content-Range [");
                        sb3.append(headerField);
                        sb3.append("]");
                        com.google.android.exoplayer2.util.n.c("DefaultHttpDataSource", sb3.toString());
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField)) {
        }
    }

    private static URL x(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            String valueOf = String.valueOf(protocol);
            throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
        }
        throw new ProtocolException("Null location redirect");
    }

    private static boolean y(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection z(URL url, int i6, byte[] bArr, long j6, long j7, boolean z5, boolean z6, Map map) {
        HttpURLConnection C = C(url);
        C.setConnectTimeout(this.f12872f);
        C.setReadTimeout(this.f12873g);
        HashMap hashMap = new HashMap();
        a0.f fVar = this.f12875i;
        if (fVar != null) {
            hashMap.putAll(fVar.a());
        }
        hashMap.putAll(this.f12876j.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            C.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j6 != 0 || j7 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j6);
            sb.append("-");
            String sb2 = sb.toString();
            if (j7 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                sb3.append(valueOf);
                sb3.append((j6 + j7) - 1);
                sb2 = sb3.toString();
            }
            C.setRequestProperty("Range", sb2);
        }
        C.setRequestProperty("User-Agent", this.f12874h);
        C.setRequestProperty("Accept-Encoding", z5 ? "gzip" : "identity");
        C.setInstanceFollowRedirects(z6);
        C.setDoOutput(bArr != null);
        C.setRequestMethod(o.c(i6));
        if (bArr != null) {
            C.setFixedLengthStreamingMode(bArr.length);
            C.connect();
            OutputStream outputStream = C.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            C.connect();
        }
        return C;
    }

    HttpURLConnection C(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: IOException -> 0x0092, TRY_LEAVE, TryCatch #2 {IOException -> 0x0092, blocks: (B:32:0x0077, B:34:0x0081), top: B:61:0x0077 }] */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    @Override // q2.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(o oVar) {
        this.f12878l = oVar;
        long j6 = 0;
        this.f12886t = 0L;
        this.f12885s = 0L;
        s(oVar);
        try {
            HttpURLConnection A = A(oVar);
            this.f12879m = A;
            try {
                this.f12882p = A.getResponseCode();
                String responseMessage = this.f12879m.getResponseMessage();
                int i6 = this.f12882p;
                if (i6 < 200 || i6 > 299) {
                    Map<String, List<String>> headerFields = this.f12879m.getHeaderFields();
                    InputStream errorStream = this.f12879m.getErrorStream();
                    try {
                        byte[] Q0 = errorStream != null ? s0.Q0(errorStream) : s0.f4678f;
                        v();
                        a0.e eVar = new a0.e(this.f12882p, responseMessage, headerFields, oVar, Q0);
                        oVar = this.f12882p;
                        if (oVar == 416) {
                            eVar.initCause(new m(0));
                        }
                        throw eVar;
                    } catch (IOException e6) {
                        throw new a0.c("Error reading non-2xx response body", e6, oVar, 1);
                    }
                }
                String contentType = this.f12879m.getContentType();
                com.google.common.base.k kVar = this.f12877k;
                if (kVar != null && !kVar.apply(contentType)) {
                    v();
                    throw new a0.d(contentType, oVar);
                }
                if (this.f12882p == 200) {
                    long j7 = oVar.f12800g;
                    if (j7 != 0) {
                        j6 = j7;
                    }
                }
                this.f12883q = j6;
                boolean y5 = y(this.f12879m);
                long j8 = oVar.f12801h;
                try {
                    if (!y5) {
                        if (j8 == -1) {
                            long w5 = w(this.f12879m);
                            this.f12884r = w5 != -1 ? w5 - this.f12883q : -1L;
                            this.f12880n = this.f12879m.getInputStream();
                            if (y5) {
                                this.f12880n = new GZIPInputStream(this.f12880n);
                            }
                            this.f12881o = true;
                            t(oVar);
                            return this.f12884r;
                        }
                    }
                    this.f12880n = this.f12879m.getInputStream();
                    if (y5) {
                    }
                    this.f12881o = true;
                    t(oVar);
                    return this.f12884r;
                } catch (IOException e7) {
                    v();
                    throw new a0.c(e7, oVar, 1);
                }
                this.f12884r = j8;
            } catch (IOException e8) {
                v();
                throw new a0.c("Unable to connect", e8, oVar, 1);
            }
        } catch (IOException e9) {
            throw new a0.c("Unable to connect", e9, oVar, 1);
        }
    }

    @Override // q2.l
    public void close() {
        try {
            if (this.f12880n != null) {
                B(this.f12879m, u());
                try {
                    this.f12880n.close();
                } catch (IOException e6) {
                    throw new a0.c(e6, this.f12878l, 3);
                }
            }
        } finally {
            this.f12880n = null;
            v();
            if (this.f12881o) {
                this.f12881o = false;
                r();
            }
        }
    }

    @Override // q2.f, q2.l
    public Map f() {
        HttpURLConnection httpURLConnection = this.f12879m;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // q2.l
    public Uri k() {
        HttpURLConnection httpURLConnection = this.f12879m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        try {
            E();
            return D(bArr, i6, i7);
        } catch (IOException e6) {
            throw new a0.c(e6, this.f12878l, 2);
        }
    }

    protected final long u() {
        long j6 = this.f12884r;
        return j6 == -1 ? j6 : j6 - this.f12886t;
    }
}
