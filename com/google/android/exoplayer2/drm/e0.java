package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.drm.z;
import com.google.android.exoplayer2.util.s0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import q2.a0;
import q2.o;
/* loaded from: classes.dex */
public final class e0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private final a0.b f3631a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3632b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3633c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f3634d = new HashMap();

    public e0(String str, boolean z5, a0.b bVar) {
        this.f3631a = bVar;
        this.f3632b = str;
        this.f3633c = z5;
    }

    private static byte[] c(a0.b bVar, String str, byte[] bArr, Map map) {
        q2.g0 g0Var = new q2.g0(bVar.a());
        q2.o a6 = new o.b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i6 = 0;
        q2.o oVar = a6;
        while (true) {
            try {
                q2.n nVar = new q2.n(g0Var, oVar);
                try {
                    byte[] Q0 = s0.Q0(nVar);
                    s0.n(nVar);
                    return Q0;
                } catch (a0.e e6) {
                    String d6 = d(e6, i6);
                    if (d6 == null) {
                        throw e6;
                    }
                    i6++;
                    oVar = oVar.a().j(d6).a();
                    s0.n(nVar);
                }
            } catch (Exception e7) {
                throw new h0(a6, (Uri) com.google.android.exoplayer2.util.a.e(g0Var.r()), g0Var.f(), g0Var.q(), e7);
            }
        }
    }

    private static String d(a0.e eVar, int i6) {
        Map<String, List<String>> map;
        List<String> list;
        int i7 = eVar.responseCode;
        if (!((i7 == 307 || i7 == 308) && i6 < 5) || (map = eVar.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.g0
    public byte[] a(UUID uuid, z.a aVar) {
        String b6 = aVar.b();
        if (this.f3633c || TextUtils.isEmpty(b6)) {
            b6 = this.f3632b;
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = com.google.android.exoplayer2.p.f3952e;
        hashMap.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : com.google.android.exoplayer2.p.f3950c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f3634d) {
            hashMap.putAll(this.f3634d);
        }
        return c(this.f3631a, b6, aVar.a(), hashMap);
    }

    @Override // com.google.android.exoplayer2.drm.g0
    public byte[] b(UUID uuid, z.d dVar) {
        String b6 = dVar.b();
        String E = s0.E(dVar.a());
        StringBuilder sb = new StringBuilder(String.valueOf(b6).length() + 15 + String.valueOf(E).length());
        sb.append(b6);
        sb.append("&signedRequest=");
        sb.append(E);
        return c(this.f3631a, sb.toString(), null, Collections.emptyMap());
    }

    public void e(String str, String str2) {
        com.google.android.exoplayer2.util.a.e(str);
        com.google.android.exoplayer2.util.a.e(str2);
        synchronized (this.f3634d) {
            this.f3634d.put(str, str2);
        }
    }
}
