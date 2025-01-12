package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.drm.z;
import com.google.android.exoplayer2.util.s0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class d0 implements z {

    /* renamed from: d  reason: collision with root package name */
    public static final z.c f3626d = new z.c() { // from class: com.google.android.exoplayer2.drm.b0
        @Override // com.google.android.exoplayer2.drm.z.c
        public final z a(UUID uuid) {
            z y5;
            y5 = d0.y(uuid);
            return y5;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final UUID f3627a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaDrm f3628b;

    /* renamed from: c  reason: collision with root package name */
    private int f3629c;

    private d0(UUID uuid) {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.p.f3949b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f3627a = uuid;
        MediaDrm mediaDrm = new MediaDrm(s(uuid));
        this.f3628b = mediaDrm;
        this.f3629c = 1;
        if (com.google.android.exoplayer2.p.f3951d.equals(uuid) && z()) {
            u(mediaDrm);
        }
    }

    public static d0 A(UUID uuid) {
        try {
            return new d0(uuid);
        } catch (UnsupportedSchemeException e6) {
            throw new i0(1, e6);
        } catch (Exception e7) {
            throw new i0(2, e7);
        }
    }

    private static byte[] o(byte[] bArr) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(bArr);
        int n5 = yVar.n();
        short p5 = yVar.p();
        short p6 = yVar.p();
        if (p5 != 1 || p6 != 1) {
            com.google.android.exoplayer2.util.n.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short p7 = yVar.p();
        Charset charset = com.google.common.base.b.f5587e;
        String y5 = yVar.y(p7, charset);
        if (y5.contains("<LA_URL>")) {
            return bArr;
        }
        int indexOf = y5.indexOf("</DATA>");
        if (indexOf == -1) {
            com.google.android.exoplayer2.util.n.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String substring = y5.substring(0, indexOf);
        String substring2 = y5.substring(indexOf);
        StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 26 + String.valueOf(substring2).length());
        sb.append(substring);
        sb.append("<LA_URL>https://x</LA_URL>");
        sb.append(substring2);
        String sb2 = sb.toString();
        int i6 = n5 + 52;
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i6);
        allocate.putShort(p5);
        allocate.putShort(p6);
        allocate.putShort((short) (sb2.length() * 2));
        allocate.put(sb2.getBytes(charset));
        return allocate.array();
    }

    private static byte[] p(UUID uuid, byte[] bArr) {
        return com.google.android.exoplayer2.p.f3950c.equals(uuid) ? a.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        if ("AFTT".equals(r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] q(UUID uuid, byte[] bArr) {
        UUID uuid2 = com.google.android.exoplayer2.p.f3952e;
        if (uuid2.equals(uuid)) {
            byte[] e6 = i1.m.e(bArr, uuid);
            if (e6 != null) {
                bArr = e6;
            }
            bArr = i1.m.a(uuid2, o(bArr));
        }
        if (s0.f4673a >= 23 || !com.google.android.exoplayer2.p.f3951d.equals(uuid)) {
            if (uuid2.equals(uuid) && "Amazon".equals(s0.f4675c)) {
                String str = s0.f4676d;
                if (!"AFTB".equals(str)) {
                    if (!"AFTS".equals(str)) {
                        if (!"AFTM".equals(str)) {
                        }
                    }
                }
            }
        }
        byte[] e7 = i1.m.e(bArr, uuid);
        return e7 != null ? e7 : bArr;
    }

    private static String r(UUID uuid, String str) {
        return (s0.f4673a < 26 && com.google.android.exoplayer2.p.f3950c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    private static UUID s(UUID uuid) {
        return (s0.f4673a >= 27 || !com.google.android.exoplayer2.p.f3950c.equals(uuid)) ? uuid : com.google.android.exoplayer2.p.f3949b;
    }

    private static void u(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static k.b w(UUID uuid, List list) {
        boolean z5;
        if (com.google.android.exoplayer2.p.f3951d.equals(uuid)) {
            if (s0.f4673a >= 28 && list.size() > 1) {
                k.b bVar = (k.b) list.get(0);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    k.b bVar2 = (k.b) list.get(i7);
                    byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(bVar2.f3709e);
                    if (!s0.c(bVar2.f3708d, bVar.f3708d) || !s0.c(bVar2.f3707c, bVar.f3707c) || !i1.m.c(bArr)) {
                        z5 = false;
                        break;
                    }
                    i6 += bArr.length;
                }
                z5 = true;
                if (z5) {
                    byte[] bArr2 = new byte[i6];
                    int i8 = 0;
                    for (int i9 = 0; i9 < list.size(); i9++) {
                        byte[] bArr3 = (byte[]) com.google.android.exoplayer2.util.a.e(((k.b) list.get(i9)).f3709e);
                        int length = bArr3.length;
                        System.arraycopy(bArr3, 0, bArr2, i8, length);
                        i8 += length;
                    }
                    return bVar.f(bArr2);
                }
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                k.b bVar3 = (k.b) list.get(i10);
                int g6 = i1.m.g((byte[]) com.google.android.exoplayer2.util.a.e(bVar3.f3709e));
                int i11 = s0.f4673a;
                if (i11 < 23 && g6 == 0) {
                    return bVar3;
                }
                if (i11 >= 23 && g6 == 1) {
                    return bVar3;
                }
            }
        }
        return (k.b) list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(z.b bVar, MediaDrm mediaDrm, byte[] bArr, int i6, int i7, byte[] bArr2) {
        bVar.a(this, bArr, i6, i7, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ z y(UUID uuid) {
        try {
            return A(uuid);
        } catch (i0 unused) {
            String valueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(valueOf.length() + 53);
            sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            sb.append(valueOf);
            sb.append(".");
            com.google.android.exoplayer2.util.n.c("FrameworkMediaDrm", sb.toString());
            return new w();
        }
    }

    private static boolean z() {
        return "ASUS_Z00AD".equals(s0.f4676d);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public synchronized void a() {
        int i6 = this.f3629c - 1;
        this.f3629c = i6;
        if (i6 == 0) {
            this.f3628b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.z
    public Class b() {
        return a0.class;
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void c(byte[] bArr, byte[] bArr2) {
        this.f3628b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public Map d(byte[] bArr) {
        return this.f3628b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void e(byte[] bArr) {
        this.f3628b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void f(final z.b bVar) {
        this.f3628b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: com.google.android.exoplayer2.drm.c0
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i6, int i7, byte[] bArr2) {
                d0.this.x(bVar, mediaDrm, bArr, i6, i7, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.z
    public byte[] g(byte[] bArr, byte[] bArr2) {
        if (com.google.android.exoplayer2.p.f3950c.equals(this.f3627a)) {
            bArr2 = a.b(bArr2);
        }
        return this.f3628b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public z.d i() {
        MediaDrm.ProvisionRequest provisionRequest = this.f3628b.getProvisionRequest();
        return new z.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void j(byte[] bArr) {
        this.f3628b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public z.a k(byte[] bArr, List list, int i6, HashMap hashMap) {
        k.b bVar;
        byte[] bArr2;
        String str;
        if (list != null) {
            bVar = w(this.f3627a, list);
            bArr2 = q(this.f3627a, (byte[]) com.google.android.exoplayer2.util.a.e(bVar.f3709e));
            str = r(this.f3627a, bVar.f3708d);
        } else {
            bVar = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f3628b.getKeyRequest(bArr, bArr2, str, i6, hashMap);
        byte[] p5 = p(this.f3627a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (TextUtils.isEmpty(defaultUrl) && bVar != null && !TextUtils.isEmpty(bVar.f3707c)) {
            defaultUrl = bVar.f3707c;
        }
        return new z.a(p5, defaultUrl);
    }

    @Override // com.google.android.exoplayer2.drm.z
    public byte[] l() {
        return this.f3628b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.z
    /* renamed from: t */
    public a0 h(byte[] bArr) {
        return new a0(s(this.f3627a), bArr, s0.f4673a < 21 && com.google.android.exoplayer2.p.f3951d.equals(this.f3627a) && "L3".equals(v("securityLevel")));
    }

    public String v(String str) {
        return this.f3628b.getPropertyString(str);
    }
}
