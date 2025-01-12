package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import c1.a0;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.y;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Segment;
/* loaded from: classes.dex */
public final class u implements c1.i {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f4379g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f4380h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private final String f4381a;

    /* renamed from: b  reason: collision with root package name */
    private final k0 f4382b;

    /* renamed from: d  reason: collision with root package name */
    private c1.k f4384d;

    /* renamed from: f  reason: collision with root package name */
    private int f4386f;

    /* renamed from: c  reason: collision with root package name */
    private final y f4383c = new y();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f4385e = new byte[Segment.SHARE_MINIMUM];

    public u(String str, k0 k0Var) {
        this.f4381a = str;
        this.f4382b = k0Var;
    }

    private a0 b(long j6) {
        a0 e6 = this.f4384d.e(0, 3);
        e6.e(new s0.b().e0("text/vtt").V(this.f4381a).i0(j6).E());
        this.f4384d.g();
        return e6;
    }

    private void e() {
        y yVar = new y(this.f4385e);
        n2.i.e(yVar);
        long j6 = 0;
        long j7 = 0;
        for (String m5 = yVar.m(); !TextUtils.isEmpty(m5); m5 = yVar.m()) {
            if (m5.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f4379g.matcher(m5);
                if (!matcher.find()) {
                    throw new f1(m5.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(m5) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "));
                }
                Matcher matcher2 = f4380h.matcher(m5);
                if (!matcher2.find()) {
                    throw new f1(m5.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(m5) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "));
                }
                j7 = n2.i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
                j6 = k0.f(Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1))));
            }
        }
        Matcher a6 = n2.i.a(yVar);
        if (a6 == null) {
            b(0L);
            return;
        }
        long d6 = n2.i.d((String) com.google.android.exoplayer2.util.a.e(a6.group(1)));
        long b6 = this.f4382b.b(k0.j((j6 + d6) - j7));
        a0 b7 = b(b6 - d6);
        this.f4383c.K(this.f4385e, this.f4386f);
        b7.a(this.f4383c, this.f4386f);
        b7.d(b6, 1, this.f4386f, 0, null);
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f4384d = kVar;
        kVar.r(new x.b(-9223372036854775807L));
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        throw new IllegalStateException();
    }

    @Override // c1.i
    public int g(c1.j jVar, w wVar) {
        com.google.android.exoplayer2.util.a.e(this.f4384d);
        int a6 = (int) jVar.a();
        int i6 = this.f4386f;
        byte[] bArr = this.f4385e;
        if (i6 == bArr.length) {
            this.f4385e = Arrays.copyOf(bArr, ((a6 != -1 ? a6 : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f4385e;
        int i7 = this.f4386f;
        int read = jVar.read(bArr2, i7, bArr2.length - i7);
        if (read != -1) {
            int i8 = this.f4386f + read;
            this.f4386f = i8;
            if (a6 == -1 || i8 != a6) {
                return 0;
            }
        }
        e();
        return -1;
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        jVar.l(this.f4385e, 0, 6, false);
        this.f4383c.K(this.f4385e, 6);
        if (n2.i.b(this.f4383c)) {
            return true;
        }
        jVar.l(this.f4385e, 6, 3, false);
        this.f4383c.K(this.f4385e, 9);
        return n2.i.b(this.f4383c);
    }
}
