package q2;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: e  reason: collision with root package name */
    private final AssetManager f12713e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f12714f;

    /* renamed from: g  reason: collision with root package name */
    private InputStream f12715g;

    /* renamed from: h  reason: collision with root package name */
    private long f12716h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12717i;

    /* loaded from: classes.dex */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context) {
        super(false);
        this.f12713e = context.getAssets();
    }

    @Override // q2.l
    public long b(o oVar) {
        try {
            Uri uri = oVar.f12794a;
            this.f12714f = uri;
            String str = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            s(oVar);
            InputStream open = this.f12713e.open(str, 1);
            this.f12715g = open;
            if (open.skip(oVar.f12800g) >= oVar.f12800g) {
                long j6 = oVar.f12801h;
                if (j6 != -1) {
                    this.f12716h = j6;
                } else {
                    long available = this.f12715g.available();
                    this.f12716h = available;
                    if (available == 2147483647L) {
                        this.f12716h = -1L;
                    }
                }
                this.f12717i = true;
                t(oVar);
                return this.f12716h;
            }
            throw new EOFException();
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // q2.l
    public void close() {
        this.f12714f = null;
        try {
            try {
                InputStream inputStream = this.f12715g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e6) {
                throw new a(e6);
            }
        } finally {
            this.f12715g = null;
            if (this.f12717i) {
                this.f12717i = false;
                r();
            }
        }
    }

    @Override // q2.l
    public Uri k() {
        return this.f12714f;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f12716h;
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
        int read = ((InputStream) s0.j(this.f12715g)).read(bArr, i6, i7);
        if (read == -1) {
            if (this.f12716h == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j7 = this.f12716h;
        if (j7 != -1) {
            this.f12716h = j7 - read;
        }
        q(read);
        return read;
    }
}
