package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.HttpUrl;
import q2.f;
import q2.o;
/* loaded from: classes.dex */
public final class RawResourceDataSource extends f {

    /* renamed from: e  reason: collision with root package name */
    private final Resources f4577e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4578f;

    /* renamed from: g  reason: collision with root package name */
    private Uri f4579g;

    /* renamed from: h  reason: collision with root package name */
    private AssetFileDescriptor f4580h;

    /* renamed from: i  reason: collision with root package name */
    private InputStream f4581i;

    /* renamed from: j  reason: collision with root package name */
    private long f4582j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4583k;

    /* loaded from: classes.dex */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }

        public a(String str) {
            super(str);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f4577e = context.getResources();
        this.f4578f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i6) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i6);
        return Uri.parse(sb.toString());
    }

    @Override // q2.l
    public long b(o oVar) {
        int parseInt;
        Uri uri = oVar.f12794a;
        this.f4579g = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.");
            }
        } else if (!TextUtils.equals("android.resource", uri.getScheme())) {
            throw new a("URI must either use scheme rawresource or android.resource");
        } else {
            String str = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            String host = uri.getHost();
            String valueOf = String.valueOf(TextUtils.isEmpty(host) ? HttpUrl.FRAGMENT_ENCODE_SET : String.valueOf(host).concat(":"));
            String valueOf2 = String.valueOf(str);
            parseInt = this.f4577e.getIdentifier(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), "raw", this.f4578f);
            if (parseInt == 0) {
                throw new a("Resource not found.");
            }
        }
        s(oVar);
        AssetFileDescriptor openRawResourceFd = this.f4577e.openRawResourceFd(parseInt);
        this.f4580h = openRawResourceFd;
        if (openRawResourceFd == null) {
            String valueOf3 = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf3.length() + 24);
            sb.append("Resource is compressed: ");
            sb.append(valueOf3);
            throw new a(sb.toString());
        }
        FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
        this.f4581i = fileInputStream;
        try {
            fileInputStream.skip(openRawResourceFd.getStartOffset());
            if (fileInputStream.skip(oVar.f12800g) < oVar.f12800g) {
                throw new EOFException();
            }
            long j6 = oVar.f12801h;
            if (j6 != -1) {
                this.f4582j = j6;
            } else {
                long length = openRawResourceFd.getLength();
                this.f4582j = length != -1 ? length - oVar.f12800g : -1L;
            }
            this.f4583k = true;
            t(oVar);
            return this.f4582j;
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // q2.l
    public void close() {
        this.f4579g = null;
        try {
            try {
                InputStream inputStream = this.f4581i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f4581i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f4580h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f4580h = null;
                        if (this.f4583k) {
                            this.f4583k = false;
                            r();
                        }
                    }
                } catch (IOException e6) {
                    throw new a(e6);
                }
            } catch (IOException e7) {
                throw new a(e7);
            }
        } catch (Throwable th) {
            this.f4581i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f4580h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f4580h = null;
                    if (this.f4583k) {
                        this.f4583k = false;
                        r();
                    }
                    throw th;
                } catch (IOException e8) {
                    throw new a(e8);
                }
            } finally {
                this.f4580h = null;
                if (this.f4583k) {
                    this.f4583k = false;
                    r();
                }
            }
        }
    }

    @Override // q2.l
    public Uri k() {
        return this.f4579g;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f4582j;
        if (j6 == 0) {
            return -1;
        }
        if (j6 != -1) {
            try {
                i7 = (int) Math.min(j6, i7);
            } catch (IOException e6) {
                throw new a(e6);
            }
        }
        int read = ((InputStream) s0.j(this.f4581i)).read(bArr, i6, i7);
        if (read == -1) {
            if (this.f4582j == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j7 = this.f4582j;
        if (j7 != -1) {
            this.f4582j = j7 - read;
        }
        q(read);
        return read;
    }
}
