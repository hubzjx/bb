package q2;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.s0;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public final class i extends f {

    /* renamed from: e  reason: collision with root package name */
    private o f12774e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f12775f;

    /* renamed from: g  reason: collision with root package name */
    private int f12776g;

    /* renamed from: h  reason: collision with root package name */
    private int f12777h;

    public i() {
        super(false);
    }

    @Override // q2.l
    public long b(o oVar) {
        s(oVar);
        this.f12774e = oVar;
        this.f12777h = (int) oVar.f12800g;
        Uri uri = oVar.f12794a;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            String valueOf = String.valueOf(scheme);
            throw new f1(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
        }
        String[] K0 = s0.K0(uri.getSchemeSpecificPart(), ",");
        if (K0.length != 2) {
            String valueOf2 = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf2.length() + 23);
            sb.append("Unexpected URI format: ");
            sb.append(valueOf2);
            throw new f1(sb.toString());
        }
        String str = K0[1];
        if (K0[0].contains(";base64")) {
            try {
                this.f12775f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e6) {
                String valueOf3 = String.valueOf(str);
                throw new f1(valueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf3) : new String("Error while parsing Base64 encoded string: "), e6);
            }
        } else {
            this.f12775f = s0.h0(URLDecoder.decode(str, com.google.common.base.b.f5583a.name()));
        }
        long j6 = oVar.f12801h;
        int length = j6 != -1 ? ((int) j6) + this.f12777h : this.f12775f.length;
        this.f12776g = length;
        if (length > this.f12775f.length || this.f12777h > length) {
            this.f12775f = null;
            throw new m(0);
        }
        t(oVar);
        return this.f12776g - this.f12777h;
    }

    @Override // q2.l
    public void close() {
        if (this.f12775f != null) {
            this.f12775f = null;
            r();
        }
        this.f12774e = null;
    }

    @Override // q2.l
    public Uri k() {
        o oVar = this.f12774e;
        if (oVar != null) {
            return oVar.f12794a;
        }
        return null;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        int i8 = this.f12776g - this.f12777h;
        if (i8 == 0) {
            return -1;
        }
        int min = Math.min(i7, i8);
        System.arraycopy(s0.j(this.f12775f), this.f12777h, bArr, i6, min);
        this.f12777h += min;
        q(min);
        return min;
    }
}
