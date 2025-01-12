package b1;

import android.net.Uri;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.util.s0;
import com.google.common.base.k;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.internal._BufferKt;
import q2.a0;
import q2.f;
import q2.m;
import q2.o;
/* loaded from: classes.dex */
public class a extends f implements a0 {

    /* renamed from: s  reason: collision with root package name */
    private static final byte[] f2890s;

    /* renamed from: e  reason: collision with root package name */
    private final Call.Factory f2891e;

    /* renamed from: f  reason: collision with root package name */
    private final a0.f f2892f;

    /* renamed from: g  reason: collision with root package name */
    private final String f2893g;

    /* renamed from: h  reason: collision with root package name */
    private final CacheControl f2894h;

    /* renamed from: i  reason: collision with root package name */
    private final a0.f f2895i;

    /* renamed from: j  reason: collision with root package name */
    private k f2896j;

    /* renamed from: k  reason: collision with root package name */
    private o f2897k;

    /* renamed from: l  reason: collision with root package name */
    private Response f2898l;

    /* renamed from: m  reason: collision with root package name */
    private InputStream f2899m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2900n;

    /* renamed from: o  reason: collision with root package name */
    private long f2901o;

    /* renamed from: p  reason: collision with root package name */
    private long f2902p;

    /* renamed from: q  reason: collision with root package name */
    private long f2903q;

    /* renamed from: r  reason: collision with root package name */
    private long f2904r;

    static {
        r0.a("goog.exo.okhttp");
        f2890s = new byte[_BufferKt.SEGMENTING_THRESHOLD];
    }

    public a(Call.Factory factory, String str, CacheControl cacheControl, a0.f fVar) {
        super(true);
        this.f2891e = (Call.Factory) com.google.android.exoplayer2.util.a.e(factory);
        this.f2893g = str;
        this.f2894h = cacheControl;
        this.f2895i = fVar;
        this.f2892f = new a0.f();
    }

    private void u() {
        Response response = this.f2898l;
        if (response != null) {
            ((ResponseBody) com.google.android.exoplayer2.util.a.e(response.body())).close();
            this.f2898l = null;
        }
        this.f2899m = null;
    }

    private Request v(o oVar) {
        long j6 = oVar.f12800g;
        long j7 = oVar.f12801h;
        HttpUrl parse = HttpUrl.parse(oVar.f12794a.toString());
        if (parse != null) {
            Request.Builder url = new Request.Builder().url(parse);
            CacheControl cacheControl = this.f2894h;
            if (cacheControl != null) {
                url.cacheControl(cacheControl);
            }
            HashMap hashMap = new HashMap();
            a0.f fVar = this.f2895i;
            if (fVar != null) {
                hashMap.putAll(fVar.a());
            }
            hashMap.putAll(this.f2892f.a());
            hashMap.putAll(oVar.f12798e);
            for (Map.Entry entry : hashMap.entrySet()) {
                url.header((String) entry.getKey(), (String) entry.getValue());
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
                url.addHeader("Range", sb2);
            }
            String str = this.f2893g;
            if (str != null) {
                url.addHeader("User-Agent", str);
            }
            if (!oVar.d(1)) {
                url.addHeader("Accept-Encoding", "identity");
            }
            byte[] bArr = oVar.f12797d;
            RequestBody requestBody = null;
            if (bArr != null) {
                requestBody = RequestBody.create((MediaType) null, bArr);
            } else if (oVar.f12796c == 2) {
                requestBody = RequestBody.create((MediaType) null, s0.f4678f);
            }
            url.method(oVar.b(), requestBody);
            return url.build();
        }
        throw new a0.c("Malformed URL", oVar, 1);
    }

    private int w(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f2902p;
        if (j6 != -1) {
            long j7 = j6 - this.f2904r;
            if (j7 == 0) {
                return -1;
            }
            i7 = (int) Math.min(i7, j7);
        }
        int read = ((InputStream) s0.j(this.f2899m)).read(bArr, i6, i7);
        if (read == -1) {
            if (this.f2902p == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.f2904r += read;
        q(read);
        return read;
    }

    private void x() {
        byte[] bArr;
        if (this.f2903q == this.f2901o) {
            return;
        }
        while (true) {
            long j6 = this.f2903q;
            long j7 = this.f2901o;
            if (j6 == j7) {
                return;
            }
            long j8 = j7 - j6;
            int read = ((InputStream) s0.j(this.f2899m)).read(f2890s, 0, (int) Math.min(j8, bArr.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.f2903q += read;
            q(read);
        }
    }

    @Override // q2.l
    public long b(o oVar) {
        this.f2897k = oVar;
        long j6 = 0;
        this.f2904r = 0L;
        this.f2903q = 0L;
        s(oVar);
        try {
            Response execute = this.f2891e.newCall(v(oVar)).execute();
            this.f2898l = execute;
            ResponseBody responseBody = (ResponseBody) com.google.android.exoplayer2.util.a.e(execute.body());
            this.f2899m = responseBody.byteStream();
            int code = execute.code();
            if (!execute.isSuccessful()) {
                try {
                    byte[] Q0 = s0.Q0((InputStream) com.google.android.exoplayer2.util.a.e(this.f2899m));
                    Map<String, List<String>> multimap = execute.headers().toMultimap();
                    u();
                    a0.e eVar = new a0.e(code, execute.message(), multimap, oVar, Q0);
                    if (code == 416) {
                        eVar.initCause(new m(0));
                    }
                    throw eVar;
                } catch (IOException e6) {
                    throw new a0.c("Error reading non-2xx response body", e6, oVar, 1);
                }
            }
            MediaType contentType = responseBody.contentType();
            String mediaType = contentType != null ? contentType.toString() : HttpUrl.FRAGMENT_ENCODE_SET;
            k kVar = this.f2896j;
            if (kVar != null && !kVar.apply(mediaType)) {
                u();
                throw new a0.d(mediaType, oVar);
            }
            if (code == 200) {
                long j7 = oVar.f12800g;
                if (j7 != 0) {
                    j6 = j7;
                }
            }
            this.f2901o = j6;
            long j8 = oVar.f12801h;
            if (j8 != -1) {
                this.f2902p = j8;
            } else {
                long contentLength = responseBody.contentLength();
                this.f2902p = contentLength != -1 ? contentLength - this.f2901o : -1L;
            }
            this.f2900n = true;
            t(oVar);
            return this.f2902p;
        } catch (IOException e7) {
            throw new a0.c("Unable to connect", e7, oVar, 1);
        }
    }

    @Override // q2.l
    public void close() {
        if (this.f2900n) {
            this.f2900n = false;
            r();
            u();
        }
    }

    @Override // q2.f, q2.l
    public Map f() {
        Response response = this.f2898l;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // q2.l
    public Uri k() {
        Response response = this.f2898l;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().toString());
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        try {
            x();
            return w(bArr, i6, i7);
        } catch (IOException e6) {
            throw new a0.c(e6, (o) com.google.android.exoplayer2.util.a.e(this.f2897k), 2);
        }
    }
}
